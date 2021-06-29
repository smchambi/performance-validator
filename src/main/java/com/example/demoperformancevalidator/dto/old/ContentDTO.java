package com.example.demoperformancevalidator.dto.old;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ContentDTO {
	private MonetaryAmountDTO declaredValue;
	private List<String> attributes;
	private List<String> description;
}
