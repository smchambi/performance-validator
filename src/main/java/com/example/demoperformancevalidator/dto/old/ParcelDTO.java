package com.example.demoperformancevalidator.dto.old;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParcelDTO {
	//This id is used when a GET is made to shipping orders.
	//It is not read when creating the shipping order because
	//the responsibility to generate it is internal and not external
	private String id;
	private String externalReferenceId;
	private DimensionsDTO dimensions;
	private ContentDTO content;
	private EstimatedDeliveryDateDTO estimatedDeliveryDate;
}
