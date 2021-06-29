package com.example.demoperformancevalidator.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterWeb {

	@Bean
	public RouterFunction<ServerResponse> routeWeb(ShippingOrderHandler orderHandler, ValidationOldHandler validationOldHandler) {
		return RouterFunctions.route()
				.POST("/new-validation-router", RequestPredicates.accept(MediaType.APPLICATION_JSON), orderHandler::executeCommand)
				.POST("/old-validation", RequestPredicates.accept(MediaType.APPLICATION_JSON), validationOldHandler::validate)
				.build();
	}
}
