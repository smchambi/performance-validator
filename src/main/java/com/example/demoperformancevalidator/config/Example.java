package com.example.demoperformancevalidator.config;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonDeserialize(builder = Example.ExampleBuilder.class)
public class Example {
	private final String commandName;
}
