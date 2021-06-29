package com.example.demoperformancevalidator.dto.old;

import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeolocationDTO {
	private Double longitude;
	private Double latitude;
	private String type;
	private String source;
	private ZonedDateTime lastUpdated;
}
