package com.microservice.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer 
public class ShoppingCartConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartConfigServerApplication.class, args);
	}

}
