 package com.microservice.ecommerce.service;

import com.microservice.ecommerce.model.OrderRequest;
import com.microservice.ecommerce.model.OrderResponse;

public interface OrderService {

	public OrderResponse placeOrder(OrderRequest orderRequest);

	 public OrderResponse getOrderDetails(Long orderID);

}
