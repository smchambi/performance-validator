package com.example.demoperformancevalidator.dto.newer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SiteType {
	MEXICO("MLM"),
	ARGENTINA("MLA"),
	COLOMBIA("MCO"),
	PARAGUAY("MPY"),
	NICARAGUA("MNI"),
	HONDURAS("MHN"),
	URUGUAY("MLU"),
	CUBA("MCU"),
	BRAZIL("MLB"),
	COSTA_RICA("MCR"),
	GUATEMALA("MGT"),
	PERU("MPE"),
	ECUADOR("MEC"),
	BOLIVIA("MBO"),
	SALVADOR("MSV"),
	DOMINICANA("MRD"),
	CHILE("MLC"),
	PANAMA("MPA"),
	VENEZUELA("MLV");
	private final String value;

	@Override
	public String toString() {
		return value;
	}
}
