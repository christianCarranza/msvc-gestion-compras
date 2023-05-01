package com.carranzac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class MsSecurityServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSecurityServerApplication.class, args);
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		for (int i = 0; i < 0; i++) {
			String passwordBCrypt = bCryptPasswordEncoder.encode("123456");
			System.out.println(passwordBCrypt);
		}
	}
	
	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
