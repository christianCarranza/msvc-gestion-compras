package com.carranzac.configuration.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtUtil {
    
    @Value("${jwt.key}")
    private String jwtKey;
    
    @Value("${jwt.expirationTimeMinutes}")
    private Long jwtExpirationTimeMinutes;

    public String generateToken(String username, List<String> roles) {
    	String accessToken = JWT.create()
		.withSubject(username)
		.withIssuedAt(Date.from(Instant.now()))
		.withExpiresAt(toDate(LocalDateTime.now().plusMinutes(jwtExpirationTimeMinutes)))
		.withClaim("user", username)
		.withClaim("roles", roles)
		.sign(Algorithm.HMAC256(jwtKey.getBytes()));
        return accessToken;
    }
    
    public static Date toDate(LocalDateTime localDateTime) {
    	return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

}
