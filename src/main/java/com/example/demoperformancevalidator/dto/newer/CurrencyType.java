package com.example.demoperformancevalidator.dto.newer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CurrencyType {
	PESO_ARGENTINO("ARS"),
	BOLIVIANO("BOB"),
	REAL("BRL"),
	UNIDAD_DE_FOMENTO("CLF"),
	PESO_CHILENO("CLP"),
	PESO_COLOMBIANO("COP"),
	COLON("CRC"),
	PESO_CUBANO_CONVERTIBLE("CUC"),
	PESO_CUBANO("CUP"),
	PESO_DOMINICANO("DOP"),
	EURO("EUR"),
	QUETZAL_GUATEMALTECO("GTQ"),
	LEMPIRA("HNL"),
	PESO_MEXICANO("MXN"),
	CORDOBA("NIO"),
	BALBOA("PAB"),
	SOLES("PEN"),
	GUARANI("PYG"),
	DOLAR("USD"),
	PESO_URUGUAYO("UYU"),
	BOLIVAR_FUERTE("VEF"),
	BOLIVAR_SOBERANO("VES");
	private final String value;

	@Override
	public String toString() {
		return value;
	}
}

