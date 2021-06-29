package com.example.demoperformancevalidator.validator.newer.util;

import com.example.demoperformancevalidator.exception.ValidationException;
import java.math.BigDecimal;

public final class PositiveValueHelper {
	private static final int ZERO = 0;

	public static void validate(Integer value) {
		MandatoryValueHelper.validate(value);
		if (value < ZERO) {
			throw new ValidationException("not.positive", "The value is not positive");
		}
	}

	public static void validate(BigDecimal value) {
		MandatoryValueHelper.validate(value);
		if (BigDecimal.ZERO.compareTo(value) > ZERO) {
			throw new ValidationException("not.positive", "The value is not positive");
		}
	}
}
