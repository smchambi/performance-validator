package com.example.demoperformancevalidator.validator.old;

import com.example.demoperformancevalidator.dto.old.LocationDTO;
import com.example.demoperformancevalidator.exception.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class LocationValidator implements Validator<LocationDTO> {

	private static final String LOCATION = "location";
	private static final String ID = "id";
	private static final String TYPE = "name";

	@Override
	public void validate(LocationDTO locationDTO) {
		if (!StringUtils.isNotBlank(locationDTO.getId())) {
			throw new ValidationException(INVALID_DTO, String.format(MANDATORY_FIELD, ID, LOCATION));
		}
		if (!StringUtils.isNotBlank(locationDTO.getName())) {
			throw new ValidationException(INVALID_DTO, String.format(MANDATORY_FIELD, TYPE, LOCATION));
		}
	}
}
