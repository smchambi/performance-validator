package com.example.demoperformancevalidator.validator.newer.util;

import com.example.demoperformancevalidator.exception.ValidationException;
import java.util.regex.Pattern;

public class MandatoryValueHelper {
	private MandatoryValueHelper() {
	}

	public static <T> void validate(T value) {
		get(value);
	}

	public static <T> void validate(String value, Pattern pattern) {
		get(value);
		if (!pattern.matcher(value).matches()) {
			throw new ValidationException("mandatory.value.regex", "Not matches");
		}
	}

	public static <T> T get(T value) {
		if (value == null)
			throw new ValidationException("mandatory.value", "Mandatory value is not present");
		return value;
	}
}
