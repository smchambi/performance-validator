package com.example.demoperformancevalidator.validator.old;

import com.example.demoperformancevalidator.dto.old.CurrencyType;
import com.example.demoperformancevalidator.dto.old.MonetaryAmountDTO;
import com.example.demoperformancevalidator.exception.ValidationException;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 * A {@link Validator} which check if a Monetary Amount is valid.
 *
 * <ul>
 *     <li>Validation will <b>fail</b> if currency is <code>null</code> or not alphanumeric</li>
 *     <li>Validation will <b>fail</b> if currency not belongs to {@link CurrencyType}</li>
 *     <li>Validation will <b>fail</b> if amount is not positive</li>
 *     <li>Validation will <b>succeed</b> otherwise</li>
 * </ul>
 */
@Component
public class MonetaryAmountValidator implements Validator<MonetaryAmountDTO> {

	public static final String CURRENCY = "currency";
	public static final String CURRENCY_TYPE = "CurrencyType";
	public static final String AMOUNT = "amount";
	public static final String PRICE = "price";
	public static final Integer ONE = 1;

	@Override
	public void validate(MonetaryAmountDTO monetaryAmountDTO) {
		if (monetaryAmountDTO != null) {
			if (!hasValidAmount(monetaryAmountDTO)) {
				throw new ValidationException(INVALID_DTO, String.format(INVALID_VALUE, AMOUNT, PRICE));
			}
			if (!hasValidCurrency(monetaryAmountDTO)) {
				throw new ValidationException(INVALID_DTO, String.format(INVALID_VALUE, CURRENCY, PRICE, CURRENCY_TYPE, monetaryAmountDTO.getCurrency()));
			}
		}
	}

	private boolean hasValidCurrency(MonetaryAmountDTO monetaryAmountDTO) {
		return monetaryAmountDTO.getCurrency() != null && this.typeCurrencyIsAllowed(monetaryAmountDTO);
	}

	private Boolean hasValidAmount(MonetaryAmountDTO monetaryAmountDTO) {
		return Optional.ofNullable(monetaryAmountDTO.getAmount())
				.map(amount -> amount.compareTo(BigDecimal.ZERO) >= ONE)
				.orElse(false);
	}

	private Boolean typeCurrencyIsAllowed(MonetaryAmountDTO priceDTO) {
		return Validator.valueBelongsToEnum(priceDTO.getCurrency(), CurrencyType.class);
	}
}
