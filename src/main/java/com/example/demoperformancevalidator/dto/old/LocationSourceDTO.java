package com.example.demoperformancevalidator.dto.old;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationSourceDTO {
	private String id;
	private String type;
	private AddressReferenceDTO address;
}