package com.example.demoperformancevalidator.validator.newer;

import com.example.demoperformancevalidator.dto.newer.CreateShippingOrderPayload;
import com.example.demoperformancevalidator.validator.newer.util.MandatoryValueHelper;
import com.example.demoperformancevalidator.validator.newer.util.PositiveValueHelper;

public class MonetaryAmountValidator {

	public static void validate(CreateShippingOrderPayload.MonetaryAmount monetaryAmount) {
		if (monetaryAmount == null) return;
		PositiveValueHelper.validate(monetaryAmount.getAmount());
		MandatoryValueHelper.validate(monetaryAmount.getCurrency());
	}
}
