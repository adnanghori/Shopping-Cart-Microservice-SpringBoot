package com.microservice.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservice.ecommerce.external.response.ErrorResponse;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(OrderServiceException.class)
	public ResponseEntity<ErrorResponse> handleOrderServiceException(OrderServiceException  exception){
		
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(exception.getMessage(), exception.getErrorCode()),HttpStatus.valueOf(exception.getStatus()));
	} 
}
 