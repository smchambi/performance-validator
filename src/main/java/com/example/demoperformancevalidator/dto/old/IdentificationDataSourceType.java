package com.example.demoperformancevalidator.dto.old;

import com.example.demoperformancevalidator.validator.old.ShippingOrderEnumerable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IdentificationDataSourceType implements ShippingOrderEnumerable {
	ON("on"),
	OFF("off");
	private final String value;
}
