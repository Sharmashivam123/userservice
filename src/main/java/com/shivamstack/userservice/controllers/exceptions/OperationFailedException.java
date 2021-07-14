package com.shivamstack.userservice.controllers.exceptions;

public class OperationFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OperationFailedException(String msg) {
		super(msg);
	}

}
