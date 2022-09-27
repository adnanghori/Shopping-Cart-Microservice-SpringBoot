package com.microservice.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

@SpringBootApplication
public class ShoppingCartApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApiGatewayApplication.class, args);
	}
	
	// Because what ever configuration we've done yaml file that should be added in context by spring in other words to tell spring about the configuration of circuit breaker 
	@Bean  
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer(){
		return factory->factory.configureDefault(
				id -> new Resilience4JConfigBuilder(id)
				.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults()).build() 
				);
	}
}
