package com.rogelioorts.training.spring.ddd.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

	private boolean error;
	
	private String errorCode;
	
	private String message;
	
	public ErrorResponse(String errorCode, String message) {
		this.error = true;
		this.errorCode = errorCode;
		this.message = message;
	}
	
}
