package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	//customer not found exception
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException e)
	{
		CustomerErrorResponse errorResponse = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
																		e.getMessage(),
																		System.currentTimeMillis());
		
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
		
		
		
		
	}
	
	public ResponseEntity<CustomerErrorResponse> handleanyException(Exception e)
	{
		CustomerErrorResponse errorResponse = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),
																		e.getMessage(),
																		System.currentTimeMillis());
		
		
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
		
		
		
		
		
	}
	
	
	
	
}
