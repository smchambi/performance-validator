package com.example.demoperformancevalidator.validator.newer;

import com.example.demoperformancevalidator.dto.newer.Command;
import com.example.demoperformancevalidator.dto.newer.CommandType;
import com.example.demoperformancevalidator.dto.newer.PayloadValidator;
import com.example.demoperformancevalidator.validator.newer.util.MandatoryValueHelper;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CommandValidator {
	private final Map<CommandType, PayloadValidator> newerValidatorSelector;

	/**
	 * private final Map<CommandType, PayloadValidator> newerValidatorSelector = Map.of(
	 * 		CommandType.CREATE_SHIPPING_ORDER, new CreateShippingOrderPayloadValidator(),
	 * 		CommandType.CANCEL_SHIPPING_ORDER, new CancelShippingOrderPayloadValidator()
	 * 	);
	 * @param command
	 */

	public Mono<Void> validate(Command<Command.Payload> command) {
		return Mono.fromRunnable(() -> {
			MandatoryValueHelper.validate(command.getCommandName());
			MandatoryValueHelper.validate(command.getTimestamp());
			MandatoryValueHelper.validate(command.getPayload());
			newerValidatorSelector.get(command.getCommandName()).validate(command.getPayload());
		});
	}
}
