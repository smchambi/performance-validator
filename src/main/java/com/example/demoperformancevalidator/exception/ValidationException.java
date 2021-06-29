package com.example.demoperformancevalidator.exception;

public class ValidationException extends BaseException {

	public ValidationException(String errorCode, String message) {
		super(errorCode, message);
	}

	@Override
	public boolean isExpected() {
		return true;
	}
}
