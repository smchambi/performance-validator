package com.example.demoperformancevalidator.exception;

public class ShippingOrderNotFoundException extends BaseException {
	private static final String ERROR_CODE = "not.found";

	public ShippingOrderNotFoundException(String message) {
		super(ERROR_CODE, message);
	}

	@Override
	public boolean isExpected() {
		return true;
	}
}
