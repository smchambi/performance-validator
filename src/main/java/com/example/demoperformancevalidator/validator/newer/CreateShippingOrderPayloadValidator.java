package com.example.demoperformancevalidator.validator.newer;

import com.example.demoperformancevalidator.dto.newer.CreateShippingOrderPayload;
import com.example.demoperformancevalidator.dto.newer.PayloadValidator;
import com.example.demoperformancevalidator.validator.newer.util.MandatoryValueHelper;
import java.util.regex.Pattern;

public class CreateShippingOrderPayloadValidator implements PayloadValidator<CreateShippingOrderPayload> {
	private static final Pattern PARTNER_ALPHANUMERIC_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
	private static final Pattern EXTERNAL_REF_ALPHANUMERIC_WITH_DASH = Pattern.compile("^[a-zA-Z0-9-]+$");

	@Override
	public void validate(CreateShippingOrderPayload payload) {
		MandatoryValueHelper.validate(payload.getExternalReferenceId(), EXTERNAL_REF_ALPHANUMERIC_WITH_DASH);
		MandatoryValueHelper.validate(payload.getSite());
		MandatoryValueHelper.validate(payload.getPartner(), PARTNER_ALPHANUMERIC_PATTERN);
		LocationSourceValidator.validate(payload.getDestination());
		LocationSourceValidator.validate(payload.getOrigin());
		IdentificationDataSourceValidator.validate(payload.getSender());
		IdentificationDataSourceValidator.validate(payload.getReceiver());
		MonetaryAmountValidator.validate(payload.getPrice());
		ShippingMethodValidator.validate(payload.getShippingMethod());
	}
}
