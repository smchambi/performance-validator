package com.example.demoperformancevalidator.validator.old;

import com.example.demoperformancevalidator.dto.old.DimensionsDTO;
import com.example.demoperformancevalidator.exception.ValidationException;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class DimensionsValidator implements Validator<DimensionsDTO> {

	private static final String DIMENSIONS = "dimensions";
	private static final String HEIGHT = "height";
	private static final String WIDTH = "width";
	private static final String WEIGHT = "weight";
	private static final String LENGTH = "length";

	@Override
	public void validate(DimensionsDTO dimensionsDTO) {
		if (!isPositive(dimensionsDTO.getHeight())) {
			throw new ValidationException(INVALID_DTO, String.format(POSITIVE_FIELD, HEIGHT, DIMENSIONS));
		}
		if (!isPositive(dimensionsDTO.getWidth())) {
			throw new ValidationException(INVALID_DTO, String.format(POSITIVE_FIELD, WIDTH, DIMENSIONS));
		}
		if (!isPositive(dimensionsDTO.getWeight())) {
			throw new ValidationException(INVALID_DTO, String.format(POSITIVE_FIELD, WEIGHT, DIMENSIONS));
		}
		if (!isPositive(dimensionsDTO.getLength())) {
			throw new ValidationException(INVALID_DTO, String.format(POSITIVE_FIELD, LENGTH, DIMENSIONS));
		}
	}

	private boolean isPositive(Integer number) {
		return Optional.ofNullable(number).filter(value -> value > 0).isPresent();
	}
}
