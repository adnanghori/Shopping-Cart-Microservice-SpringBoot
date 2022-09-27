package com.microservice.ecommerce.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class PaymentResponse {

	private Long orderID;
	private PaymentMode paymentMode;
	private String referenceNumber;
	private Instant paymentDate;
	private Long amount;
}
