package com.example.demoperformancevalidator.exception;

public class DependencyException extends BaseException {

	public DependencyException(String errorCode, String message, Throwable throwable) {
		super(errorCode, message, throwable);
	}

	public DependencyException(String errorCode, String message) {
		super(errorCode, message);
	}
}
