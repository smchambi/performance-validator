package com.example.demoperformancevalidator.dto.newer;

import java.util.Arrays;
import java.util.Optional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommandType {
	CREATE_SHIPPING_ORDER("create_shipping_order"),
	CHANGE_SHIPPING_ORDER_ADDRESS("change_shipping_order_address"),
	CANCEL_SHIPPING_ORDER("cancel_shipping_order"),
	NONE("none");
	private final String value;

	@Override
	public String toString() {
		return value;
	}

	public static Optional<CommandType> parse(String value) {
		return Arrays.stream(values()).filter(v -> value.equalsIgnoreCase(v.getValue())).findFirst();
	}
}