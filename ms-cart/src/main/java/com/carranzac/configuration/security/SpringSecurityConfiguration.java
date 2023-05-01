package com.carranzac.configuration.security;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SpringSecurityConfiguration {
//	
//	@Bean
//	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
////		http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
////		.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(grantedAuthoritiesConverter())));
////		return http.build();
//		
//		http.authorizeHttpRequests()
//		.antMatchers("/actuator/**").permitAll()
//		.antMatchers(HttpMethod.GET, "/**").hasAnyRole("USER")
//		.antMatchers("/**").hasRole("ADMIN")
//		.anyRequest().authenticated()
//		.and()
//		.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(grantedAuthoritiesConverter())));
//		return http.build();
//	}
//	
//	private Converter<Jwt, ? extends AbstractAuthenticationToken> grantedAuthoritiesConverter() {
//		JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
//		jwtConverter.setJwtGrantedAuthoritiesConverter(new JwtGrantedAuthoritiesConverter());
//		return jwtConverter;
//	}
//	
//}
