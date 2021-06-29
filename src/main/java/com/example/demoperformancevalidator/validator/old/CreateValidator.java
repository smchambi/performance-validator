package com.example.demoperformancevalidator.validator.old;

import com.example.demoperformancevalidator.dto.old.ParcelsAffinityGroupDTO;
import com.example.demoperformancevalidator.dto.old.ShippingOrderDTO;

import com.example.demoperformancevalidator.dto.old.SiteType;
import com.example.demoperformancevalidator.exception.ValidationException;
import java.util.List;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
@RequiredArgsConstructor
public class CreateValidator implements Validator<ShippingOrderDTO> {

	private static final String PARTNER = "partner";
	private static final String EXTERNAL_REFERENCE_ID = "externalReferenceId";
	private static final String ORIGIN = "origin";
	private static final String DESTINATION = "destination";
	private static final String SENDER = "sender";
	private static final String RECEIVER = "receiver";
	private static final String SITE = "site";
	private static final String SHIPPING_METHOD = "shippingMethod";
	private static final String PARCELS_AFFINITY_GROUPS = "parcelsAffinityGroups";
	private static final String SHIPPING_ORDER = "shipping order";
	private static final String SITE_TYPE = "SiteType";

	private static final Pattern ALPHANUMERIC_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");
	private static final Pattern ALPHANUMERIC_WITH_DASH = Pattern.compile("^[a-zA-Z0-9-]+$");

	private final LocationSourceValidator locationSourceValidator;
	private final IdentificationDataSourceValidator idDataSourceValidator;
	private final MonetaryAmountValidator monetaryAmountValidator;
	private final ParcelsAffinityGroupValidator parcelsAffinityGroupValidator;
	private final ShippingMethodValidator shippingMethodValidator;

	@Override
	public void validate(ShippingOrderDTO shippingOrderDTO) {
		this.validMandatoryFields(shippingOrderDTO);
		this.validateAlphanumericFields(shippingOrderDTO);
		this.validateEnumerableFields(shippingOrderDTO);
		this.validateLocationSourceFields(shippingOrderDTO);
		this.validateIdentificationDataSourceFields(shippingOrderDTO);
		this.monetaryAmountValidator.validate(shippingOrderDTO.getPrice());
		this.shippingMethodValidator.validate(shippingOrderDTO.getShippingMethod());
		this.validateParcelsAffinityGroups(shippingOrderDTO.getParcelsAffinityGroups());
	}

	private void validMandatoryFields(ShippingOrderDTO shippingOrderDTO) {
		validateMandatoryField(shippingOrderDTO.getPartner(), PARTNER);
		validateMandatoryField(shippingOrderDTO.getExternalReferenceId(), EXTERNAL_REFERENCE_ID);
		validateMandatoryField(shippingOrderDTO.getOrigin(), ORIGIN);
		validateMandatoryField(shippingOrderDTO.getDestination(), DESTINATION);
		validateMandatoryField(shippingOrderDTO.getSender(), SENDER);
		validateMandatoryField(shippingOrderDTO.getReceiver(), RECEIVER);
		validateMandatoryField(shippingOrderDTO.getSite(), SITE);
		validateMandatoryField(shippingOrderDTO.getShippingMethod(), SHIPPING_METHOD);
		validateMandatoryField(shippingOrderDTO.getParcelsAffinityGroups(), PARCELS_AFFINITY_GROUPS);
	}

	private void validateMandatoryField(Object value, String name) {
		if (value == null) {
			throw new ValidationException(INVALID_DTO, String.format(MANDATORY_FIELD, name, SHIPPING_ORDER));
		}
	}

	private void validateAlphanumericFields(ShippingOrderDTO shippingOrderDTO) {
		validateAlphanumericField(shippingOrderDTO.getPartner(), PARTNER, ALPHANUMERIC_PATTERN);
		validateAlphanumericField(shippingOrderDTO.getExternalReferenceId(), EXTERNAL_REFERENCE_ID, ALPHANUMERIC_WITH_DASH);
	}

	private void validateAlphanumericField(String value, String name, Pattern pattern) {
		// PATTERN matcher needs a not null property
		if (value != null && !pattern.matcher(value).matches()) {
			throw new ValidationException(INVALID_DTO, String.format(ALPHANUMERIC_FIELD, name, SHIPPING_ORDER));
		}
	}

	private void validateEnumerableFields(ShippingOrderDTO shippingOrderDTO) {
		if (!siteValueIsAllowed(shippingOrderDTO)) {
			throw new ValidationException(INVALID_DTO, String.format(INVALID_ENUM, SITE, SHIPPING_ORDER, SITE_TYPE, shippingOrderDTO.getSite()));
		}
	}

	private Boolean siteValueIsAllowed(ShippingOrderDTO shippingOrderDTO) {
		return Validator.valueBelongsToEnum(shippingOrderDTO.getSite(), SiteType.class);
	}

	private void validateLocationSourceFields(ShippingOrderDTO shippingOrderDTO) {
		locationSourceValidator.validate(shippingOrderDTO.getOrigin());
		locationSourceValidator.validate(shippingOrderDTO.getDestination());
	}

	private void validateIdentificationDataSourceFields(ShippingOrderDTO shippingOrderDTO) {
		idDataSourceValidator.validate(shippingOrderDTO.getSender());
		idDataSourceValidator.validate(shippingOrderDTO.getReceiver());
	}

	private void validateParcelsAffinityGroups(List<ParcelsAffinityGroupDTO> parcelsAffinityGroupsDTO) {
		if (CollectionUtils.isEmpty(parcelsAffinityGroupsDTO)) {
			throw new ValidationException(INVALID_DTO, String.format(EMPTY_FIELD, PARCELS_AFFINITY_GROUPS, SHIPPING_ORDER));
		}
		parcelsAffinityGroupsDTO.forEach(parcelsAffinityGroupValidator::validate);
	}
}
