package com.example.demoperformancevalidator.exception;

public class RepositoryException extends BaseException {
	public RepositoryException(String errorCode, String message, Throwable throwable) {
		super(errorCode, message, throwable);
	}

	public RepositoryException(String errorCode, String message) {
		super(errorCode, message);
	}
}
