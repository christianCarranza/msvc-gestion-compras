//package com.carranzac.security.custom;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.authentication.ReactiveAuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Component;
//
//import lombok.extern.slf4j.Slf4j;
//import reactor.core.publisher.Mono;
//
//@Slf4j
//@Component
//public class SpringAuthenticationManager implements ReactiveAuthenticationManager{
//
//	@Value("${jwt.key}")
//	private String jwtKey;
//	
//	@Override
//	public Mono<Authentication> authenticate(Authentication authentication) {
//		log.info("authenticate");
//		return Mono.just(authentication.getCredentials().toString())
//				.map(token -> {
//					Algorithm algorithm = Algorithm.HMAC256(jwtKey.getBytes());
//					JWTVerifier verifier = JWT.require(algorithm).build();
//				    DecodedJWT jwt = verifier.verify(token);
//				    return jwt.getClaims();
//				})
//				.map(claims -> {
//					String username = claims.get("user").asString();
//					List<String> roles = claims.get("roles").asList(String.class);
//					roles = roles.stream().map(p -> "ROLE_"+ p).collect(Collectors.toList());
//					Collection<GrantedAuthority> authorities = roles.stream().map(SimpleGrantedAuthority::new)
//							.collect(Collectors.toList());
//					return new UsernamePasswordAuthenticationToken(username, null, authorities);
//				});
//	}
//
//}
