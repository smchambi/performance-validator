package com.example.demoperformancevalidator.dto.old;

import java.time.ZonedDateTime;
import lombok.*;

@Getter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class EstimatedDeliveryDateDTO {
	private ZonedDateTime from;
	private ZonedDateTime to;
}


