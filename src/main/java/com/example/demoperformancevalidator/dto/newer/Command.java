package com.example.demoperformancevalidator.dto.newer;

import com.example.demoperformancevalidator.config.CommandDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonDeserialize(builder = Command.CommandBuilder.class, using = CommandDeserializer.class)
public class Command<T extends Command.Payload> {
	public interface Payload {
	}
	private final CommandType commandName;
	private final ZonedDateTime timestamp;
	private final T payload;
}
