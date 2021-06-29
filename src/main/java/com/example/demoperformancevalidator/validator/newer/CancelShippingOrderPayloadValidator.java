package com.example.demoperformancevalidator.validator.newer;

import com.example.demoperformancevalidator.dto.newer.CancelShippingOrderPayload;
import com.example.demoperformancevalidator.dto.newer.PayloadValidator;
import com.example.demoperformancevalidator.validator.newer.util.MandatoryValueHelper;
import org.springframework.stereotype.Component;

@Component
public class CancelShippingOrderPayloadValidator implements PayloadValidator<CancelShippingOrderPayload> {
	@Override
	public void validate(CancelShippingOrderPayload payload) {
		MandatoryValueHelper.validate(payload.getId());
	}
}
