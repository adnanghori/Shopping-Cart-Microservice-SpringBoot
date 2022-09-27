package com.microservice.ecommerce.external.decoder;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.ecommerce.exception.OrderServiceException;
import com.microservice.ecommerce.external.response.ErrorResponse;

import feign.Response;
import feign.codec.ErrorDecoder;


public class OrderErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
	
		ObjectMapper objectMapper = new ObjectMapper();
		   
		try {
			ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(),ErrorResponse.class);
			return new OrderServiceException(errorResponse.getErrorMessage(),errorResponse.getErrorCode() ,  response.status());
		}
		 catch (IOException e) {
			 
			
			e.printStackTrace();
			throw new OrderServiceException("Internal Server Error", "INTERNAL_SERVER_ERROR", 500);
		}
	}

}
