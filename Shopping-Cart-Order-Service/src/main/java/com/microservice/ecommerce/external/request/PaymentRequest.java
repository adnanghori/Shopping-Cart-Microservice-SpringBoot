package com.microservice.ecommerce.external.request;

import com.microservice.ecommerce.model.PaymentMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class PaymentRequest {

	private Long orderID;
	private Long amount;
	private  PaymentMode paymentMode;
}
