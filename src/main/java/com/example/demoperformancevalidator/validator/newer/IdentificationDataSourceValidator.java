package com.example.demoperformancevalidator.validator.newer;

import com.example.demoperformancevalidator.dto.newer.CreateShippingOrderPayload;
import com.example.demoperformancevalidator.validator.newer.util.MandatoryValueHelper;

public final class IdentificationDataSourceValidator {

	public static void validate(CreateShippingOrderPayload.IdentificationDataSource identificationDataSource) {
		MandatoryValueHelper.validate(identificationDataSource);
		MandatoryValueHelper.validate(identificationDataSource.getId());
		MandatoryValueHelper.validate(identificationDataSource.getSource());
	}
}
