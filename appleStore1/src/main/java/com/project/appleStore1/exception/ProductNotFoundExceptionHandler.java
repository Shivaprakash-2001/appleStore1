package com.project.appleStore1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductNotFoundExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> ProductNotFoundException(ProductNotFoundException productNotFoundException) {

		return new ResponseEntity<>(productNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}

}
