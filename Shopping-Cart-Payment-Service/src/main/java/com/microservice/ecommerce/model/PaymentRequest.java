package com.microservice.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class PaymentRequest {
 
	private Long orderID;
	private Long amount;
	private  PaymentMode paymentMode;
}
 