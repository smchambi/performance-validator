package com.example.demoperformancevalidator.dto.newer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonDeserialize(builder = CreateShippingOrderPayload.CreateShippingOrderPayloadBuilder.class)
public class CreateShippingOrderPayload implements Command.Payload {
	private final String externalReferenceId;
	private final LocationSource origin;
	private final LocationSource destination;
	private final IdentificationDataSource sender;
	private final IdentificationDataSource receiver;
	private final SiteType site;
	private final String partner;
	private final MonetaryAmount price;
	private final ShippingMethod shippingMethod;
	private final List<ParcelsAffinityGroup> parcelsAffinityGroups;

	@Getter
	@Builder
	@JsonDeserialize(builder = LocationSource.LocationSourceBuilder.class)
	public static class LocationSource {
		private final String id;
		private final LocationSourceType type;
		private final AddressReference address;
	}

	@Getter
	@Builder
	@JsonDeserialize(builder = AddressReference.AddressReferenceBuilder.class)
	public static class AddressReference {
		private final String id;
		private final String version;
	}

	@Getter
	@Builder
	@JsonDeserialize(builder = IdentificationDataSource.IdentificationDataSourceBuilder.class)
	public static class IdentificationDataSource {
		private final String id;
		private final String version;
		private final IdentificationDataSourceType source;
	}

	@Getter
	@Builder
	@JsonDeserialize(builder = MonetaryAmount.MonetaryAmountBuilder.class)
	public static class MonetaryAmount {
		private final CurrencyType currency;
		private final BigDecimal amount;
	}

	@Getter
	@Builder
	@JsonDeserialize(builder = ShippingMethod.ShippingMethodBuilder.class)
	public static class ShippingMethod {
		private final String id;
		private final String type;
	}

	@Getter
	@Builder
	@JsonDeserialize(builder = ParcelsAffinityGroup.ParcelsAffinityGroupBuilder.class)
	public static class ParcelsAffinityGroup {
		private final String externalReferenceId;
		private final List<Parcel> parcels;

		@Getter
		@Builder
		@JsonDeserialize(builder = Parcel.ParcelBuilder.class)
		public static class Parcel {
			private final String externalReferenceId;
			private final Dimensions dimensions;
			private final Content content;

			@Getter
			@Builder
			@JsonDeserialize(builder = Dimensions.DimensionsBuilder.class)
			public static class Dimensions {
				private final Integer width;
				private final Integer length;
				private final Integer weight;
				private final Integer height;
			}

			@Getter
			@Builder
			@JsonDeserialize(builder = Content.ContentBuilder.class)
			public static class Content {
				private final MonetaryAmount declaredValue;
				private final List<String> attributes;
				private final List<String> description;
			}
		}
	}
}
