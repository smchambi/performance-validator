package com.example.demoperformancevalidator.config;

import com.example.demoperformancevalidator.dto.newer.CancelShippingOrderPayload;
import com.example.demoperformancevalidator.dto.newer.Command;
import com.example.demoperformancevalidator.dto.newer.CommandType;
import com.example.demoperformancevalidator.dto.newer.CreateShippingOrderPayload;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.ZonedDateTime;

public class CommandDeserializer extends StdDeserializer<Command<? extends Command.Payload>> {



	private static final String COMMAND_NAME_FIELD = "command_name";
	private static final String TIMESTAMP_FIELD = "command_name";
	private static final String PAYLOAD_FIELD = "payload";

	public CommandDeserializer(){
		super(Command.class);
	}

	public CommandDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Command<? extends Command.Payload> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = p.getCodec().readTree(p);
		var commandName = CommandType.parse(node.get(COMMAND_NAME_FIELD).asText());
		var commandBuilder = Command.builder();
		if (commandName.isPresent()) {
			var payload = getPayload(commandName.get(), p, node.get(PAYLOAD_FIELD).traverse());
			commandBuilder
					.payload(payload)
					.commandName(commandName.get())
					.timestamp(ZonedDateTime.now());
		}
		return commandBuilder.build();
	}

	private static Command.Payload getPayload(CommandType commandType, JsonParser root, JsonParser payloadParser) throws IOException {
		if (CommandType.CREATE_SHIPPING_ORDER.equals(commandType)) {
			return root.getCodec().readValue(payloadParser, CreateShippingOrderPayload.class);
		}
		if (CommandType.CHANGE_SHIPPING_ORDER_ADDRESS.equals(commandType)) {
			return root.getCodec().readValue(payloadParser, CancelShippingOrderPayload.class);
		}
		return null;
	}

}
