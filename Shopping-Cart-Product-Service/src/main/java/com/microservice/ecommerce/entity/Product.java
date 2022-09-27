package com.microservice.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private Long productID;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "PRODUCT_PRICE")
	private Long productPrice;
	@Column(name = "PRODUCT_QUANTITY")
	private Long productQuantity;
}
