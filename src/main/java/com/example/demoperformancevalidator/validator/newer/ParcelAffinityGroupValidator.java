package com.example.demoperformancevalidator.validator.newer;

import com.example.demoperformancevalidator.dto.newer.CreateShippingOrderPayload;
import com.example.demoperformancevalidator.validator.newer.util.MandatoryValueHelper;
import com.example.demoperformancevalidator.validator.newer.util.PositiveValueHelper;

public class ParcelAffinityGroupValidator {

	public static void validate(CreateShippingOrderPayload.ParcelsAffinityGroup parcelsAffinityGroup) {
		MandatoryValueHelper.validate(parcelsAffinityGroup.getExternalReferenceId());
		parcelsAffinityGroup.getParcels().forEach(ParcelAffinityGroupValidator::validate);
	}

	private static void validate(CreateShippingOrderPayload.ParcelsAffinityGroup.Parcel parcel) {
		MandatoryValueHelper.validate(parcel.getExternalReferenceId());
		validate(parcel.getContent());
		validate(parcel.getDimensions());
	}

	private static void validate(CreateShippingOrderPayload.ParcelsAffinityGroup.Parcel.Content content) {
		MandatoryValueHelper.validate(content);

	}

	private static void validate(CreateShippingOrderPayload.ParcelsAffinityGroup.Parcel.Dimensions dimensions) {
		MandatoryValueHelper.validate(dimensions);
		PositiveValueHelper.validate(dimensions.getHeight());
		PositiveValueHelper.validate(dimensions.getLength());
		PositiveValueHelper.validate(dimensions.getWeight());
		PositiveValueHelper.validate(dimensions.getWidth());
	}
}
