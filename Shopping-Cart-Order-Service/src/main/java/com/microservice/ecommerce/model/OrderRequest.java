package com.microservice.ecommerce.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class OrderRequest {

	private Long productID;
	private Long orderQuantity;
	private Instant orderDate;
	private String orderStatus;
	private Long orderAmount;
	private PaymentMode paymentMode;
}
