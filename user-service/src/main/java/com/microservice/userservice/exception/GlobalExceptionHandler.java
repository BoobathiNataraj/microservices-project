package com.microservice.userservice.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> handleValidationException(
	        MethodArgumentNotValidException ex) {

	    List<String> errors = ex.getBindingResult().getFieldErrors().stream()
	            .map(e -> e.getDefaultMessage())
	            .toList();

	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
}
