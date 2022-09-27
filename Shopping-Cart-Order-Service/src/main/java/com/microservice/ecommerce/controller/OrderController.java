package com.microservice.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ecommerce.model.OrderRequest;
import com.microservice.ecommerce.model.OrderResponse;
import com.microservice.ecommerce.service.OrderService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

	private final OrderService orderService ;
	
	@PostMapping("/place-order")
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest)
	
	{
		return new ResponseEntity<OrderResponse>(this.orderService.placeOrder(orderRequest),HttpStatus.CREATED);
	}
	@GetMapping("/{orderID}")
	public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable Long orderID){

		 return ResponseEntity.status(HttpStatus.OK).body(this.orderService.getOrderDetails(orderID));
	}
}
