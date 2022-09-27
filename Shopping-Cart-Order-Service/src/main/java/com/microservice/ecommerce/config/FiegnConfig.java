package com.microservice.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservice.ecommerce.external.decoder.OrderErrorDecoder;

import feign.codec.ErrorDecoder;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Configuration
 
public class FiegnConfig {

	@Bean
	ErrorDecoder errorDecoder() {
		return new OrderErrorDecoder();
	}
	
}
