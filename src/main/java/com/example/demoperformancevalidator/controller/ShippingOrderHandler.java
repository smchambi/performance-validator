package com.example.demoperformancevalidator.controller;

import com.example.demoperformancevalidator.dto.newer.Command;
import com.example.demoperformancevalidator.validator.newer.CommandValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ShippingOrderHandler {
	private final CommandValidator commandValidator;
	private static final ParameterizedTypeReference<Command<Command.Payload>> reference = new ParameterizedTypeReference<>() {};

	public Mono<ServerResponse> executeCommand(ServerRequest request) {
		return request.bodyToMono(reference)
				.map(commandValidator::validate)
				.then(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).build());
	}
}
