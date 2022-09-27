 package com.microservice.ecommerce.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice.ecommerce.exception.OrderServiceException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "Product-Service/product")
@CircuitBreaker(name = "external",fallbackMethod = "fallback")
public interface ProductService {

	@PutMapping("/reduce-quantity/{id}")
	public ResponseEntity<String> reduceQuantity(@PathVariable Long id , @RequestParam Long quantity);
	default void fallback(Exception e) {
		  throw new  OrderServiceException("Product  Service is not avalaible", "Uavailable", 500);  
	} 
}

