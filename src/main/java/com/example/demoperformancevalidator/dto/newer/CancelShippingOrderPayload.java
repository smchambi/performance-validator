package com.example.demoperformancevalidator.dto.newer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonDeserialize(builder = CancelShippingOrderPayload.CancelShippingOrderPayloadBuilder.class)
public class CancelShippingOrderPayload implements Command.Payload {
	private final String id;
}
