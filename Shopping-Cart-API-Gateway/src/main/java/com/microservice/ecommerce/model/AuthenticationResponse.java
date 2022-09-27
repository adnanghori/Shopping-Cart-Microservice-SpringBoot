package com.microservice.ecommerce.model;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AuthenticationResponse {
	
	private String userID;
	private String accessToken;
	private String refreshToken;
	private Long expiresAt;
	private Collection<String> authorityList;
}
