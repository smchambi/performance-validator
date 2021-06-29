package com.example.demoperformancevalidator.dto.old;

import java.util.List;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ParcelsAffinityGroupDTO {
	//This id is used when a GET is made to shipping orders.
	//It is not read when creating the shipping order because
	//the responsibility to generate it is internal and not external
	private String id;
	private String externalReferenceId;
	private List<ParcelDTO> parcels;

}
