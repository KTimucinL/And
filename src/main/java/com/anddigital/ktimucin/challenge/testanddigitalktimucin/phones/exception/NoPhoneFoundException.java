package com.anddigital.ktimucin.challenge.testanddigitalktimucin.phones.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoPhoneFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public NoPhoneFoundException(String errorMessage) {
		super(errorMessage);
	}

}
