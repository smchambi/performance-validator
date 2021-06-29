package com.example.demoperformancevalidator.validator.newer;

import com.example.demoperformancevalidator.dto.newer.CreateShippingOrderPayload;
import com.example.demoperformancevalidator.validator.newer.util.MandatoryValueHelper;

public final class LocationSourceValidator {

	public static void validate(CreateShippingOrderPayload.LocationSource locationSource) {
		MandatoryValueHelper.validate(locationSource.getId());
		MandatoryValueHelper.validate(locationSource.getType());
	}
}
