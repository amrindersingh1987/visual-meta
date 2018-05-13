package com.visualmeta.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * This is custom exception class  
 * @author asi
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomException() {
		super();
	}

	public CustomException(String message) {
		super(message);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}
}
