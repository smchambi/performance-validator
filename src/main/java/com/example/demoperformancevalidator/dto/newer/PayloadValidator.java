package com.example.demoperformancevalidator.dto.newer;

public interface PayloadValidator<T extends Command.Payload> {
	void validate(T payload);
}
