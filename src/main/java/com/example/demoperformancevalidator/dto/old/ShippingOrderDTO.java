package com.example.demoperformancevalidator.dto.old;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShippingOrderDTO {
	private static final String VALIDATE_SLA_TAG = "validate-sla";
	private static final List<String> VALID_TAGS = List.of("test", VALIDATE_SLA_TAG);
	private static final String PARTNER = "partner";
	private static final String REFERENCE_ID = "reference_id";
	private static final String ORDER_ID = "id";

	private String id;
	private String externalReferenceId;
	private LocationSourceDTO origin;
	private LocationSourceDTO destination;
	private IdentificationDataSourceDTO sender;
	private IdentificationDataSourceDTO receiver;
	private String site;
	private String partner;
	private MonetaryAmountDTO price;
	private ShippingMethodDTO shippingMethod;
	private List<ParcelsAffinityGroupDTO> parcelsAffinityGroups;
	private ZonedDateTime scheduleStart;
	@Builder.Default
	private List<String> tags = List.of();

	private List<String> getValidTags() {
		return tags.stream().filter(VALID_TAGS::contains).collect(Collectors.toList());
	}

}
