package com.shivamstack.userservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shivamstack.userservice.controllers.exceptions.DataNotAvailableException;
import com.shivamstack.userservice.controllers.exceptions.OperationFailedException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataNotAvailableException.class)
	public ResponseEntity<Object> handleDataNotAvailableException(DataNotAvailableException ex) {
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(OperationFailedException.class)
	public ResponseEntity<Object> handleOperationFailed(OperationFailedException ex){
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
