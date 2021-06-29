package com.example.demoperformancevalidator.dto.old;

import com.example.demoperformancevalidator.validator.old.ShippingOrderEnumerable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LocationSourceType implements ShippingOrderEnumerable {
	ADDRESS("address"),
	AGENCY("agency"),
	LOGISTIC_CENTER("logistic_center");
	private final String value;
}
