package com.example.demoperformancevalidator.dto.newer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IdentificationDataSourceType {
	ON("on"),
	OFF("off");
	private final String value;

	@Override
	public String toString() {
		return value;
	}
}
