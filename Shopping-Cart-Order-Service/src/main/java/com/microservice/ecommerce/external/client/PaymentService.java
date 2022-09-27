package com.microservice.ecommerce.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.ecommerce.exception.OrderServiceException;
import com.microservice.ecommerce.external.request.PaymentRequest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "Payment-Service/payment")
@CircuitBreaker(name = "external",fallbackMethod = "fallback")
public interface PaymentService {
 
	@PostMapping("/do-payment")
	public ResponseEntity<String> doPayment(@RequestBody PaymentRequest paymentRequest);
	default void fallback(Exception e) {
		  throw new  OrderServiceException("Payment Service is not avalaible", "Uavailable", 500);  
	}
} 
 