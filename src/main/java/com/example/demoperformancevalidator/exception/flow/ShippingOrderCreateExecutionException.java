package com.example.demoperformancevalidator.exception.flow;


import com.example.demoperformancevalidator.exception.BaseException;

public class ShippingOrderCreateExecutionException extends BaseException {
	private static final String ERROR_CODE = "shipping.order.create.error";

	public ShippingOrderCreateExecutionException(String message, Throwable throwable) {
		super(ERROR_CODE, message, throwable);
	}

	public ShippingOrderCreateExecutionException(String message) {
		super(ERROR_CODE, message);
	}

}
