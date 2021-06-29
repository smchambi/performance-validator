package com.example.demoperformancevalidator.dto.old.factory;

import com.example.demoperformancevalidator.dto.newer.CommandType;
import com.example.demoperformancevalidator.dto.old.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

public class CreateShippingOrderCommandOldFactory {
	public static CommandDTO<ShippingOrderDTO> create() {
		var payload = ShippingOrderDTO.builder()
				.externalReferenceId("externalReferenceId")
				.origin(createOrigin())
				.destination(createDestination())
				.sender(createIdentificationDataSource("senderOld", "1242342"))
				.receiver(createIdentificationDataSource("receiverOld", "234234"))
				.site(SiteType.ARGENTINA.getValue())
				.partner("partnerIdOld")
				.price(createMonetaryAmount())
				.shippingMethod(createShippingMethod())
				.parcelsAffinityGroups(List.of(createParcelAffinityGroup()))
				.build();

		return new CommandDTO<>(CommandType.CREATE_SHIPPING_ORDER.getValue(),
				ZonedDateTime.now(), payload);
	}
	private static LocationSourceDTO createOrigin() {
		return LocationSourceDTO.builder()
				.id("originLocation")
				.type(LocationSourceType.LOGISTIC_CENTER.getValue())
				.address(AddressReferenceDTO.builder()
						.id("addressReferenceId")
						.version("2334234")
						.build())
				.build();
	}

	private static LocationSourceDTO createDestination() {
		return LocationSourceDTO.builder()
				.id("destinationLocation")
				.type(LocationSourceType.ADDRESS.getValue())
				.address(AddressReferenceDTO.builder()
						.id("addressReferenceId")
						.version("3453453")
						.build())
				.build();
	}

	private static IdentificationDataSourceDTO createIdentificationDataSource(String id, String version) {
		return IdentificationDataSourceDTO.builder()
				.id(id)
				.version(version)
				.source(IdentificationDataSourceType.OFF.getValue())
				.build();
	}

	private static ShippingMethodDTO createShippingMethod() {
		return new ShippingMethodDTO("methodId", "methodType");
	}

	private static ParcelsAffinityGroupDTO createParcelAffinityGroup() {
		return new ParcelsAffinityGroupDTO(null,
				"externalReferenceIdGroup",
				List.of(ParcelDTO.builder()
						.externalReferenceId("parcelExternalReferenceId")
						.content(new ContentDTO(createMonetaryAmount(), List.of("pesado", "peligroso"),
								List.of("iphone", "mac")))
						.dimensions(DimensionsDTO.builder()
								.weight(1)
								.height(1)
								.length(1)
								.width(1)
								.build())
						.build())
		);
	}

	private static MonetaryAmountDTO createMonetaryAmount() {
		return new MonetaryAmountDTO(CurrencyType.PESO_ARGENTINO.getValue(), BigDecimal.ONE);
	}
}
