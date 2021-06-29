package com.example.demoperformancevalidator.dto.old;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
	private String id;
	private String version;
	private AddressSourceDTO source;
	private String type;
	private String zipCode;
	private LocationDTO country;
	private LocationDTO state;
	private LocationDTO city;
	private LocationDTO municipality;
	private LocationDTO neighborhood;
	private GeolocationDTO geolocation;
}
