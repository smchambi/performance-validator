package com.example.demoperformancevalidator.dto.old.factory;

import com.example.demoperformancevalidator.validator.old.*;

public class CreateValidatorFactory {
	public static CreateValidator create() {
		return new CreateValidator(new LocationSourceValidator(),
				new IdentificationDataSourceValidator(),
				new MonetaryAmountValidator(),
				new ParcelsAffinityGroupValidator(
						new ParcelValidator(
								new DimensionsValidator(),
								new ContentValidator(new MonetaryAmountValidator()))),
				new ShippingMethodValidator()
				);
	}
}
