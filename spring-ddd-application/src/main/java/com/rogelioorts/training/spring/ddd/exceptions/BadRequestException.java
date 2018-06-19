package com.rogelioorts.training.spring.ddd.exceptions;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public BadRequestException(String msg) {
		super(msg);
	}

}
