package com.shivamstack.userservice.controllers.exceptions;

public class DataNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataNotAvailableException(String msg) {
		super(msg);
	}

}
