package com.example.demoperformancevalidator.validator.old;

import com.example.demoperformancevalidator.dto.old.ContentDTO;
import com.example.demoperformancevalidator.dto.old.DimensionsDTO;
import com.example.demoperformancevalidator.dto.old.ParcelDTO;
import com.example.demoperformancevalidator.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/* TODO Maybe make this class abstract and extend a CreationParcelValidator and UpdateParcelValidator
 *  (Consider override of hasValidId e.g) */
@Component
@RequiredArgsConstructor
public class ParcelValidator implements Validator<ParcelDTO> {

	private static final String PARCEL = "parcel";
	private static final String PARCEL_ID = "id";
	private static final String DIMENSIONS = "dimensions";
	private static final String CONTENT = "content";

	private final Validator<DimensionsDTO> dimensionsValidator;
	private final Validator<ContentDTO> contentValidator;

	@Override
	public void validate(ParcelDTO parcelDTO) {
		if (!hasValidId(parcelDTO)) {
			throw new ValidationException(INVALID_DTO, String.format(MANDATORY_UNSET_FIELD, PARCEL_ID, PARCEL));
		}
		if (parcelDTO.getDimensions() == null) {
			throw new ValidationException(INVALID_DTO, String.format(MANDATORY_FIELD, DIMENSIONS, PARCEL));
		}
		if (parcelDTO.getContent() == null) {
			throw new ValidationException(INVALID_DTO, String.format(MANDATORY_FIELD, CONTENT, PARCEL));
		}
		dimensionsValidator.validate(parcelDTO.getDimensions());
		contentValidator.validate(parcelDTO.getContent());
	}

	// Should be an abstract method when the Update logic begin
	private boolean hasValidId(ParcelDTO parcelDTO) {
		return parcelDTO.getId() == null;
	}
}
