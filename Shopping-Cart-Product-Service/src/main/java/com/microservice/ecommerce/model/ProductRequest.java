package com.microservice.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ProductRequest {

	private String productName;
	private Long productPrice;
	private Long productQuantity;
}
