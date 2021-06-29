package com.example.demoperformancevalidator.dto.old;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class MonetaryAmountDTO {
	private String currency;
	private BigDecimal amount;
}
