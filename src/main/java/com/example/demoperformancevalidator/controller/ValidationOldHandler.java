package com.example.demoperformancevalidator.controller;

import com.example.demoperformancevalidator.dto.old.CommandDTO;
import com.example.demoperformancevalidator.dto.old.ShippingOrderDTO;
import com.example.demoperformancevalidator.validator.old.ValidatorSelector;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ValidationOldHandler {
	private static final ParameterizedTypeReference<CommandDTO<ShippingOrderDTO>> reference = new ParameterizedTypeReference<>() {
	};
	private final ValidatorSelector validatorSelector;

	public Mono<ServerResponse> validate(ServerRequest serverRequest) {
		return serverRequest.bodyToMono(reference)
				.map(validatorSelector::validate)
				.then(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build());
	}
}
