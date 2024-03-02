package com.restfulapicrud.exception;

public class CustomMethodArgumentNotValidException extends RuntimeException {
	public CustomMethodArgumentNotValidException(String message) {
		super(message);
	}

}
