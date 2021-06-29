package com.example.demoperformancevalidator.validator.old;

import com.example.demoperformancevalidator.dto.old.CommandDTO;
import com.example.demoperformancevalidator.dto.old.ShippingOrderDTO;
import com.example.demoperformancevalidator.exception.ValidationException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ValidatorSelector {

	public static final String CREATE_SHIPPING_ORDER = "create_shipping_order";
	public static final String INVALID_DTO = "invalid.dto";
	public static final String UNKNOWN_COMMAND = "The command [%s] is unknown";
	public static final String MANDATORY_TIMESTAMP = "The [timestamp] field is mandatory";

	private final CreateValidator createValidator;

	private final Map<String, Validator<ShippingOrderDTO>> validators = new HashMap<>();

	public ValidatorSelector(CreateValidator createValidator) {
		this.createValidator = createValidator;
		init();
	}

	@PostConstruct
	public void init() {
		validators.put(CREATE_SHIPPING_ORDER, createValidator);
	}

	public Mono<CommandDTO<ShippingOrderDTO>> validate(CommandDTO<ShippingOrderDTO> commandDTO) {
		return Mono.fromCallable(() -> {
			if (commandDTO.getTimestamp() == null) {
				throw new ValidationException(INVALID_DTO, MANDATORY_TIMESTAMP);
			}
			String commandName = commandDTO.getCommandName();
			if (commandName == null || !validators.containsKey(commandName)) {
				throw new ValidationException(INVALID_DTO, String.format(UNKNOWN_COMMAND, commandName));
			}
			this.validators.get(commandDTO.getCommandName()).validate(commandDTO.getPayload());
			return commandDTO;
		});
	}
}
