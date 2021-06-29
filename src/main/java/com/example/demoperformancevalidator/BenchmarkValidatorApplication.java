package com.example.demoperformancevalidator;

import com.example.demoperformancevalidator.dto.newer.Command;
import com.example.demoperformancevalidator.dto.newer.CommandType;
import com.example.demoperformancevalidator.dto.newer.factory.mock.CreateShippingOrderCommandFactory;
import com.example.demoperformancevalidator.dto.old.CommandDTO;
import com.example.demoperformancevalidator.dto.old.ShippingOrderDTO;
import com.example.demoperformancevalidator.dto.old.factory.CreateShippingOrderCommandOldFactory;
import com.example.demoperformancevalidator.dto.old.factory.CreateValidatorFactory;
import com.example.demoperformancevalidator.validator.newer.CancelShippingOrderPayloadValidator;
import com.example.demoperformancevalidator.validator.newer.CommandValidator;
import com.example.demoperformancevalidator.validator.newer.CreateShippingOrderPayloadValidator;
import com.example.demoperformancevalidator.validator.old.ValidatorSelector;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkValidatorApplication {
	public static final CommandValidator commandValidator = new CommandValidator(Map.of(
			CommandType.CREATE_SHIPPING_ORDER, new CreateShippingOrderPayloadValidator(),
			CommandType.CANCEL_SHIPPING_ORDER, new CancelShippingOrderPayloadValidator()
	));

	public static final ValidatorSelector validatorSelector = new ValidatorSelector(CreateValidatorFactory.create());

	@State(Scope.Thread)
	public static class BenchMarkPayload {
		public Command<Command.Payload> commandRequestNewer;
		public CommandDTO<ShippingOrderDTO> commandRequestOlder;

		@Setup
		public void setup() {
			commandRequestNewer = CreateShippingOrderCommandFactory.create();
			commandRequestOlder = CreateShippingOrderCommandOldFactory.create();
		}

		@TearDown
		public void cleanUp() {
			commandRequestNewer = null;
			commandRequestOlder = null;
		}

		@Benchmark
		@BenchmarkMode(Mode.AverageTime)
		@OutputTimeUnit(TimeUnit.NANOSECONDS)
		public void validateNewer(BenchMarkPayload statePayload) {
			commandValidator.validate(statePayload.commandRequestNewer).block();
		}

		@Benchmark
		@BenchmarkMode(Mode.AverageTime)
		@OutputTimeUnit(TimeUnit.NANOSECONDS)
		public void validateOlder(BenchMarkPayload statePayload) {
			validatorSelector.validate(statePayload.commandRequestOlder).block();
		}

	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(BenchmarkValidatorApplication.class.getSimpleName())
				.forks(2)
				.warmupIterations(2)
				.measurementIterations(10)
				.build();
		new Runner(opt).run();
	}

}
