package com.microservice.ecommerce.service.adapter;

import java.time.Instant;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.ecommerce.entity.Order;
import com.microservice.ecommerce.exception.OrderServiceException;
import com.microservice.ecommerce.external.client.PaymentService;
import com.microservice.ecommerce.external.client.ProductService;
import com.microservice.ecommerce.external.request.PaymentRequest;
import com.microservice.ecommerce.external.response.PaymentResponse;
import com.microservice.ecommerce.model.OrderRequest;
import com.microservice.ecommerce.model.OrderResponse;
import com.microservice.ecommerce.model.OrderResponse.PaymentDetails;
import com.microservice.ecommerce.model.OrderResponse.ProductDetails;
import com.microservice.ecommerce.repository.OrderRepository;
import com.microservice.ecommerce.service.OrderService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@AllArgsConstructor
public class OrderServiceAdapter implements OrderService {

	private final OrderRepository orderRepository;
	private final ModelMapper modelMapper;
	private final ProductService productService;
	private final PaymentService paymentService;
	private final RestTemplate restTemplate;
	@Override
	public OrderResponse placeOrder(OrderRequest orderRequest) {
		log.info("Placing Order",orderRequest);
		Order order = this.modelMapper.map(orderRequest, Order.class);
		order.setOrderDate(Instant.now());
		this.productService.reduceQuantity(orderRequest.getProductID(), orderRequest.getOrderQuantity());
		order.setOrderStatus("CREATED");
	
		  
		 log.info("Calling payment service to complete the payment");
		 
			PaymentRequest paymentRequest = new PaymentRequest();
			paymentRequest.setOrderID(order.getOrderID());
			paymentRequest.setAmount(order.getOrderAmount());
			paymentRequest.setPaymentMode(orderRequest.getPaymentMode());
			this.paymentService.doPayment(paymentRequest);
			order.setOrderStatus("PLACED");
			log.info("Payment Done"); 
		return	this.modelMapper.map(this.orderRepository.save(order), OrderResponse.class);
	}
	@Override
	public OrderResponse getOrderDetails(Long orderID) {

		 log.info("Getting order details ");
		 Order order = this.orderRepository.findById(orderID).orElseThrow(() -> new OrderServiceException("Order Not Found", "Not Found", 404));
		 log.info("Fetching product from product service");
		 ProductDetails productDetails = this.restTemplate.getForObject("http://Product-Service/product/"+order.getProductID(), ProductDetails.class);
		 OrderResponse orderResponse = this.modelMapper.map(order, OrderResponse.class);
		 orderResponse.setProductDetails(productDetails);
		 log.info("Getting Payment Details");
		 PaymentDetails paymentDetails =  this.restTemplate.getForObject("http://Payment-Service/payment/order/"+order.getOrderID(), PaymentDetails.class); 
		 orderResponse.setPaymentDetails(paymentDetails); 
		 return orderResponse;  
	}
 
}
