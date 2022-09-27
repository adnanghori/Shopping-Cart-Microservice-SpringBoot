package com.microservice.ecommerce.exception;

import lombok.Data;

@Data

public class ProductServiceException extends RuntimeException{

	private String errorCode;
	public ProductServiceException(String exception,String errorCode) {
		super(exception);
		this.errorCode = errorCode;
	}
}
