package com.example.demoperformancevalidator.validator.old;

import com.example.demoperformancevalidator.dto.old.LocationSourceDTO;
import com.example.demoperformancevalidator.dto.old.LocationSourceType;
import com.example.demoperformancevalidator.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationSourceValidator implements Validator<LocationSourceDTO> {

	private static final String ID = "id";
	private static final String LOCATION_SOURCE = "location source";
	private static final String LOCATION_SOURCE_TYPE = "LocationSourceType";
	private static final String TYPE = "type";

	@Override
	public void validate(LocationSourceDTO locationSourceDTO) {
		if (StringUtils.isBlank(locationSourceDTO.getId())) {
			throw new ValidationException(INVALID_DTO, String.format(MANDATORY_FIELD, ID, LOCATION_SOURCE));
		}

		if (StringUtils.isBlank(locationSourceDTO.getType())) {
			throw new ValidationException(INVALID_DTO, String.format(MANDATORY_FIELD, TYPE, LOCATION_SOURCE));
		}

		if (!this.typeValueIsAllowed(locationSourceDTO)) {
			throw new ValidationException(INVALID_DTO, String.format(INVALID_ENUM, TYPE, LOCATION_SOURCE, LOCATION_SOURCE_TYPE, locationSourceDTO.getType()));
		}
	}

	private Boolean typeValueIsAllowed(LocationSourceDTO locationSourceDTO) {
		return Validator.valueBelongsToEnum(locationSourceDTO.getType(), LocationSourceType.class);
	}
}
