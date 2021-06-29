package com.example.demoperformancevalidator.validator.old;

import com.example.demoperformancevalidator.dto.old.IdentificationDataSourceDTO;
import com.example.demoperformancevalidator.dto.old.IdentificationDataSourceType;
import com.example.demoperformancevalidator.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IdentificationDataSourceValidator implements Validator<IdentificationDataSourceDTO> {

	private static final String ID = "id";
	private static final String ID_DATA_SOURCE = "identification data source";
	private static final String ID_DATA_SOURCE_TYPE = "IdentificationDataSourceType";
	private static final String SOURCE = "source";

	@Override
	public void validate(IdentificationDataSourceDTO identificationDataSourceDTO) {
		if (StringUtils.isBlank(identificationDataSourceDTO.getId())) {
			throw new ValidationException(INVALID_DTO, String.format(MANDATORY_FIELD, ID, ID_DATA_SOURCE));
		}

		if (StringUtils.isBlank(identificationDataSourceDTO.getSource())) {
			throw new ValidationException(INVALID_DTO, String.format(MANDATORY_FIELD, SOURCE, ID_DATA_SOURCE));
		}

		if (!this.typeValueIsAllowed(identificationDataSourceDTO)) {
			throw new ValidationException(INVALID_DTO, String.format(INVALID_ENUM, SOURCE, ID_DATA_SOURCE, ID_DATA_SOURCE_TYPE, identificationDataSourceDTO.getSource()));
		}
	}

	private Boolean typeValueIsAllowed(IdentificationDataSourceDTO identificationDataSourceDTO) {
		return Validator.valueBelongsToEnum(identificationDataSourceDTO.getSource(), IdentificationDataSourceType.class);
	}
}
