package com.example.demoperformancevalidator.exception;

public class BaseException extends RuntimeException {
	private final String errorCode;

	public BaseException(String errorCode, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = errorCode;
	}

	public BaseException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public boolean isExpected() {
		return false;
	}
}
