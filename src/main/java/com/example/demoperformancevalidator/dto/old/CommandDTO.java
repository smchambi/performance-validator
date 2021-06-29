package com.example.demoperformancevalidator.dto.old;

import java.time.ZonedDateTime;
import lombok.*;

/**
 * Defines the action to be performed in the system.
 * Example: create_shipping_order with a ShippingOrderDTO when called from outside the system
 * or create_shipment with a ShipmentDTO when posting to the Orchestrator
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CommandDTO<T> {
	private static final String COMMAND_NAME = "command_name";

	private String commandName;
	private ZonedDateTime timestamp;
	private T payload;

}
