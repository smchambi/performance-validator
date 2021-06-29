package com.example.demoperformancevalidator.exception.flow;

import com.example.demoperformancevalidator.exception.BaseException;

public class GetLabelException extends BaseException {
	private static final String ERROR_CODE = "label.get";

	public GetLabelException(String message, Throwable throwable) {
		super(ERROR_CODE, message, throwable);
	}
}
