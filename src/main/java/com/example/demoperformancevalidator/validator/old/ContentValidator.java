package com.example.demoperformancevalidator.validator.old;

import com.example.demoperformancevalidator.dto.old.ContentDTO;
import com.example.demoperformancevalidator.dto.old.MonetaryAmountDTO;
import com.example.demoperformancevalidator.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * A {@link Validator} which check if the content of a shipment is valid.
 *
 * <ul>
 *     <li>Validation will <b>fail</b> if declared value is <code>null</code></li>
 *     <li>Validation will <b>fail</b> if declared value is invalid {@link MonetaryAmountValidator}</li>
 *     <li>Validation will <b>succeed</b> if content is <code>null</code></li>
 *     <li>Validation will <b>succeed</b> otherwise</li>
 * </ul>
 */
@Component
@RequiredArgsConstructor
public class ContentValidator implements Validator<ContentDTO> {
	private static final String DECLARED_VALUE = "declaredValue";
	private static final String CONTENT = "content";
	private final Validator<MonetaryAmountDTO> orderMonetaryAmountValidator;

	/**
	 * Validates than a shipping order content is valid.
	 *
	 * @param contentDTO The content of a parcel to validate
	 * @see MonetaryAmountValidator
	 * @see Validator
	 */
	@Override
	public void validate(ContentDTO contentDTO) {
		if (contentDTO != null) {
			if (contentDTO.getDeclaredValue() == null) {
				throw new ValidationException(Validator.INVALID_DTO, String.format(MANDATORY_FIELD,DECLARED_VALUE,CONTENT));
			}
			orderMonetaryAmountValidator.validate(contentDTO.getDeclaredValue());
		}
	}

}
