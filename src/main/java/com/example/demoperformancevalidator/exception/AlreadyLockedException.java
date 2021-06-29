package com.example.demoperformancevalidator.exception;

public class AlreadyLockedException extends BaseException {

	public AlreadyLockedException(String errorCode, String message) {
		super(errorCode, message);
	}

	@Override
	public boolean isExpected() {
		return true;
	}
}