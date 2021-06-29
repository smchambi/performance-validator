package com.example.demoperformancevalidator.config;

import com.example.demoperformancevalidator.dto.newer.CommandType;
import com.example.demoperformancevalidator.dto.newer.PayloadValidator;
import com.example.demoperformancevalidator.validator.newer.CancelShippingOrderPayloadValidator;
import com.example.demoperformancevalidator.validator.newer.CreateShippingOrderPayloadValidator;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PayloadValidatorSelectorConfig {

	@Bean
	public Map<CommandType, PayloadValidator> newerValidatorSelector() {
		return Map.of(
				CommandType.CREATE_SHIPPING_ORDER, new CreateShippingOrderPayloadValidator(),
				CommandType.CANCEL_SHIPPING_ORDER, new CancelShippingOrderPayloadValidator()
		);
	}
}
