package com.fdmgroup.Controller;

import java.time.Instant;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.DTO.Auth.AuthResponseDTO;


@RestController
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final JwtEncoder encoder;
    private final JwtDecoder decoder;

	public AuthController(JwtEncoder encoder, JwtDecoder decoder) {
		super();
		this.encoder = encoder;
		this.decoder = decoder;
	}

	@PostMapping("authenticate")
	public AuthResponseDTO authenticateAndGenerateJWT(Authentication authentication) {
		Instant now = Instant.now();
		long expiry = 3600L; //1hour

		String scope = authentication.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(" "));
		
		JwtClaimsSet accessTokenClaims = JwtClaimsSet.builder()
				.issuer("self")
				.issuedAt(now)
				.expiresAt(now.plusSeconds(expiry))
				.subject(authentication.getName())
				.claim("scope", scope)
				.build();
		
		AuthResponseDTO authResponse = new AuthResponseDTO();
		authResponse.setAccess_token(this.encoder.encode(JwtEncoderParameters.from(accessTokenClaims)).getTokenValue());
		authResponse.setExpires_in(accessTokenClaims.getExpiresAt().toEpochMilli());
		authResponse.setAuthentication(authentication);
		
		return authResponse;
	}

}
