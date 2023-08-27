package com.fdmgroup.DTO.Auth;

import org.springframework.security.core.Authentication;

import lombok.Data;

@Data
public class AuthResponseDTO {
	private String access_token;
	private String refresh_token;
	private long expires_in;
	private Authentication authentication;
}
