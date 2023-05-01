//package com.carranzac.security.custom;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@Configuration
//public class SpringSecurityConfiguration {
//	
//	@Autowired
//	private SpringAuthenticationFilter authenticationFilter;
//	
//	@Bean
//	public SecurityWebFilterChain configure(ServerHttpSecurity http) {
//		return http.authorizeExchange()
//				.pathMatchers("/actuator/**", "/api/security/**").permitAll()
//				.pathMatchers(HttpMethod.GET, "/api/cart/**", "/api/product/**").hasAnyRole("USER")
//				.pathMatchers("/api/cart/**", "/api/product/**").hasRole("ADMIN")
//				.anyExchange().authenticated()
//				.and()
//				.addFilterAt(authenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION)
//		.build();
//	}
//	
//}
