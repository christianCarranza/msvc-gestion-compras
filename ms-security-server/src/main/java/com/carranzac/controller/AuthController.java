package com.carranzac.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carranzac.model.dto.AuthRequestDto;
import com.carranzac.service.SecurityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "v1")
@RequiredArgsConstructor
public class AuthController {
    
    private final SecurityService securityService;
    
    @PostMapping()
    public ResponseEntity<?> post(@RequestBody AuthRequestDto request) throws Exception {
    	return ResponseEntity.ok(securityService.login(request));
    }
  
}
