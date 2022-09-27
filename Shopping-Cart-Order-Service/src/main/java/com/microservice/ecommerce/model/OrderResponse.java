package com.microservice.ecommerce.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class OrderResponse {

	private Long productID;
	private Long orderQuantity;
	private Instant orderDate;
	private String orderStatus;
	private Long orderAmount;
	private ProductDetails productDetails;  
	private PaymentDetails paymentDetails;
	
	@Data @NoArgsConstructor @AllArgsConstructor
	public static   class ProductDetails {

		private Long productID;
		private String productName;
		private Long productPrice;
		private Long productQuantity;
	}
	@Data @NoArgsConstructor @AllArgsConstructor
	public static class PaymentDetails {

		private Long orderID;
		private PaymentMode paymentMode;
		private String referenceNumber;
		private Instant paymentDate;
		private Long amount;
	}
}
