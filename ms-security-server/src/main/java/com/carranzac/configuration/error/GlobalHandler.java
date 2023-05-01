package com.carranzac.configuration.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.carranzac.model.dto.ErrorResponseDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {
	
	private ObjectMapper mapper = new ObjectMapper();

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponseDto> handleConflict(Exception ex, WebRequest request) {
		log.error("Exception " + ex.getMessage());
		var error = new ErrorResponseDto(ex.getMessage(), "" + HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	protected ResponseEntity<ErrorResponseDto> handleConflict(HttpClientErrorException ex, WebRequest request) throws JsonProcessingException {
		log.error("HttpClientErrorException " + ex.getMessage());
		var json = convertToJson(ex.getMessage());
		var error = new ErrorResponseDto(json.get("message").asText(), "" + ex.getRawStatusCode(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.valueOf(ex.getRawStatusCode()));
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	protected ResponseEntity<Object> handleConflict(UsernameNotFoundException ex, WebRequest request) {
		log.error("UsernameNotFoundException " + ex.getMessage());
		var error = new ErrorResponseDto(ex.getMessage(), "" + HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	protected ResponseEntity<Object> handleConflict(InvalidCredentialsException ex, WebRequest request) {
		log.error("InvalidCredentialsException " + ex.getMessage());
		var error = new ErrorResponseDto(ex.getMessage(), "" + ex.getHttpStatus().value(), LocalDateTime.now());
		return new ResponseEntity<>(error, ex.getHttpStatus());
	}
	
	private JsonNode convertToJson(String message) throws JsonProcessingException {
		var messageTmp = message.split(": \"")[1];
		messageTmp = messageTmp.substring(0, messageTmp.length()-1);
		return mapper.readTree(messageTmp);
	}

}