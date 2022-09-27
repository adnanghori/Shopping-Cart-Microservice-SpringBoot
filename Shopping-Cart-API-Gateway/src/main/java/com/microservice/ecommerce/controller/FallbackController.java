package com.microservice.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@GetMapping("/orderServiceFallBack")
	public String orderServiceFallBackController() {
		 return "order service-down";
	}
	@GetMapping("/productServiceFallBack")
	public String productServiceFallBackController() {
		 return "product service-down";
	}
	@GetMapping("/paymentServiceFallBack")
	public String paymentServiceFallBackController() {
		 return "payment service-down";
	}
}
