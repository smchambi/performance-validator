package com.example.demoperformancevalidator.dto.newer.factory.mock;

import com.example.demoperformancevalidator.dto.newer.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

public class CreateShippingOrderCommandFactory {
	public static Command<Command.Payload> create() {
		var payload = CreateShippingOrderPayload.builder()
				.externalReferenceId("externalReferenceId")
				.origin(createOrigin())
				.destination(createDestination())
				.sender(createIdentificationDataSource("sender", "1242342"))
				.receiver(createIdentificationDataSource("receiver", "234234"))
				.site(SiteType.ARGENTINA)
				.partner("partnerId")
				.price(createMonetaryAmount())
				.shippingMethod(createShippingMethod())
				.parcelsAffinityGroups(List.of(createParcelAffinityGroup()))
				.build();
		return Command.builder()
				.commandName(CommandType.CREATE_SHIPPING_ORDER)
				.timestamp(ZonedDateTime.now())
				.payload(payload)
				.build();
	}

	private static CreateShippingOrderPayload.LocationSource createOrigin() {
		return CreateShippingOrderPayload.LocationSource.builder()
				.id("originLocation")
				.type(LocationSourceType.LOGISTIC_CENTER)
				.address(CreateShippingOrderPayload.AddressReference.builder()
						.id("addressReferenceId")
						.version("2334234")
						.build())
				.build();
	}

	private static CreateShippingOrderPayload.LocationSource createDestination() {
		return CreateShippingOrderPayload.LocationSource.builder()
				.id("destinationLocation")
				.type(LocationSourceType.ADDRESS)
				.address(CreateShippingOrderPayload.AddressReference.builder()
						.id("addressReferenceId")
						.version("3453453")
						.build())
				.build();
	}

	private static CreateShippingOrderPayload.IdentificationDataSource createIdentificationDataSource(String id, String version) {
		return CreateShippingOrderPayload.IdentificationDataSource.builder()
				.id(id)
				.version(version)
				.source(IdentificationDataSourceType.OFF)
				.build();
	}

	private static CreateShippingOrderPayload.ShippingMethod createShippingMethod() {
		return CreateShippingOrderPayload.ShippingMethod.builder()
				.id("methodId")
				.type("methodType")
				.build();
	}

	private static CreateShippingOrderPayload.ParcelsAffinityGroup createParcelAffinityGroup() {
		return CreateShippingOrderPayload.ParcelsAffinityGroup.builder()
				.externalReferenceId("externalReferenceIdGroup")
				.parcels(List.of(CreateShippingOrderPayload.ParcelsAffinityGroup.Parcel.builder()
						.externalReferenceId("parcelExternalReferenceId")
						.content(CreateShippingOrderPayload.ParcelsAffinityGroup.Parcel.Content.builder()
								.attributes(List.of("pesado", "peligroso"))
								.description(List.of("iphone", "mac"))
								.declaredValue(createMonetaryAmount())
								.build())
						.dimensions(CreateShippingOrderPayload.ParcelsAffinityGroup.Parcel.Dimensions.builder()
								.weight(1)
								.height(1)
								.length(1)
								.width(1)
								.build())
						.build()))
				.build();
	}

	private static CreateShippingOrderPayload.MonetaryAmount createMonetaryAmount() {
		return CreateShippingOrderPayload.MonetaryAmount.builder()
				.amount(BigDecimal.ONE)
				.currency(CurrencyType.PESO_ARGENTINO)
				.build();
	}
}
