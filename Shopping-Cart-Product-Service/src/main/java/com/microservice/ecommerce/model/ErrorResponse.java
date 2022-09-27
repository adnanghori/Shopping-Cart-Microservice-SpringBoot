package com.microservice.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ErrorResponse {

	private String errorMessage;
	private String errorCode;
}
