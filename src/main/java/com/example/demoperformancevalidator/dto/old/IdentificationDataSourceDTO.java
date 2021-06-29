package com.example.demoperformancevalidator.dto.old;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationDataSourceDTO {
	private static final String IDENTIFICATION_DATA_MELI_ID = "MELI";
	private String id;
	private String version;
	private String source;
}
