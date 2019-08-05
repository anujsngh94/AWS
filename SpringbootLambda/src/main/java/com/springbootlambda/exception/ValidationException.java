package com.springbootlambda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ValidationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2449303520689568404L;
	
	public ValidationException(String message) {
        super(message);
    }
}
