package com.example.demoperformancevalidator.dto.newer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LocationSourceType {
	ADDRESS("address"),
	AGENCY("agency"),
	LOGISTIC_CENTER("logistic_center");
	private final String value;

	@Override
	public String toString() {
		return value;
	}
}
