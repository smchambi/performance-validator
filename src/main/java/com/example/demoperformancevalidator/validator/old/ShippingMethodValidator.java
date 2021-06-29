package com.example.demoperformancevalidator.validator.old;

import com.example.demoperformancevalidator.dto.old.ShippingMethodDTO;
import com.example.demoperformancevalidator.exception.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ShippingMethodValidator implements Validator<ShippingMethodDTO> {

	public static final String SHIPPING_METHOD = "shipping method";
	public static final String ID = "id";
	public static final String TYPE = "type";

	@Override
	public void validate(ShippingMethodDTO shippingMethodDTO) {
		if (!StringUtils.isNotBlank(shippingMethodDTO.getId())) {
			throw new ValidationException(INVALID_DTO, String.format(MANDATORY_FIELD, ID, SHIPPING_METHOD));
		}
		if (!StringUtils.isNotBlank(shippingMethodDTO.getType())) {
			throw new ValidationException(INVALID_DTO, String.format(MANDATORY_FIELD, TYPE, SHIPPING_METHOD));
		}
	}
}
