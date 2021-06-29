package com.example.demoperformancevalidator.validator.newer;

import com.example.demoperformancevalidator.dto.newer.CreateShippingOrderPayload;
import com.example.demoperformancevalidator.validator.newer.util.MandatoryValueHelper;

public class ShippingMethodValidator  {
	public static void validate(CreateShippingOrderPayload.ShippingMethod shippingMethod) {
		MandatoryValueHelper.validate(shippingMethod);
		MandatoryValueHelper.validate(shippingMethod.getId());
		MandatoryValueHelper.validate(shippingMethod.getType());
	}
}
