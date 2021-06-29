package com.example.demoperformancevalidator.controller;

import com.example.demoperformancevalidator.dto.newer.Command;
import com.example.demoperformancevalidator.validator.newer.CommandValidator;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ValidationNewController {
	private final CommandValidator commandValidator;

	public Mono<Void> validate(Command<Command.Payload> command) {
		return Mono.fromRunnable(() -> commandValidator.validate(command));
	}
}
