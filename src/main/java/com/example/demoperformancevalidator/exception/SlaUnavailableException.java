package com.example.demoperformancevalidator.exception;

/**
 * Exception that represent a shipping order without SLA coverage.
 */
public class SlaUnavailableException extends BaseException {
	public static final String UNAVAILABLE_SLA = "There is not available SLA to the order";
	public static final String ERROR_CODE = "sla.unavailable";

	public SlaUnavailableException() {
		super(ERROR_CODE, UNAVAILABLE_SLA);
	}
}
