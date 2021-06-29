package com.example.demoperformancevalidator.validator.old;

import java.util.stream.Stream;

public interface Validator<T> {

	String INVALID_DTO = "invalid.dto";
	String MANDATORY_FIELD = "The [%s] field in [%s] is mandatory";
	String MANDATORY_UNSET_FIELD = "The [%s] field in [%s] should not be set";
	String POSITIVE_FIELD = "The [%s] field in [%s] must be positive";
	String INVALID_ENUM = "The [%s] field in [%s] value must be any value of enum [%s]. Actual value [%s]";
	String INVALID_VALUE = "The [%s] field in [%s] is invalid";
	String EMPTY_FIELD = "The [%s] field in [%s] is empty";
	String ALPHANUMERIC_FIELD = "The [%s] field in [%s] must be alphanumeric";

	void validate(T object);

	static boolean valueBelongsToEnum(String value, Class<? extends ShippingOrderEnumerable> enumerable) {
		return Stream.of(enumerable.getEnumConstants())
				.map(ShippingOrderEnumerable::getValue)
				.anyMatch((enumValue) -> enumValue.equals(value));
	}
}
