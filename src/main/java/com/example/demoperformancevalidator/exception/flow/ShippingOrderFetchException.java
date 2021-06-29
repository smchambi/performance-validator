package com.example.demoperformancevalidator.exception.flow;

import com.example.demoperformancevalidator.exception.BaseException;

public class ShippingOrderFetchException extends BaseException {
	private static final String ERROR_CODE = "shipping.order.fetch.error";

	public ShippingOrderFetchException(String message, Throwable throwable) {
		super(ERROR_CODE, message, throwable);
	}
}
