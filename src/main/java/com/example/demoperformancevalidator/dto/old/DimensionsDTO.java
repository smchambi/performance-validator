package com.example.demoperformancevalidator.dto.old;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DimensionsDTO {
	private Integer width;
	private Integer length;
	private Integer weight;
	private Integer height;
}
