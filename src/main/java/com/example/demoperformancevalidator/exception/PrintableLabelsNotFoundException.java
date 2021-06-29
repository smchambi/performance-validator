package com.example.demoperformancevalidator.exception;

public class PrintableLabelsNotFoundException extends BaseException {
	private static final String ERROR_CODE = "printable.not.found";

	public PrintableLabelsNotFoundException(String message) {
		super(ERROR_CODE, message);
	}

	@Override
	public boolean isExpected() {
		return true;
	}
}
