package com.example.demoperformancevalidator.validator.old;

import com.example.demoperformancevalidator.dto.old.ParcelsAffinityGroupDTO;
import com.example.demoperformancevalidator.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
@RequiredArgsConstructor
public class ParcelsAffinityGroupValidator implements Validator<ParcelsAffinityGroupDTO> {

	private static final String PARCELS_AFFINITY_GROUP = "parcels affinity group";
	private static final String PARCELS = "parcels";

	private final ParcelValidator parcelValidator;

	@Override
	public void validate(ParcelsAffinityGroupDTO parcelsAffinityGroupDTO) {
		if (parcelsAffinityGroupDTO.getParcels() == null) {
			throw new ValidationException(INVALID_DTO, String.format(MANDATORY_FIELD, PARCELS, PARCELS_AFFINITY_GROUP));
		}
		if (CollectionUtils.isEmpty(parcelsAffinityGroupDTO.getParcels())) {
			throw new ValidationException(INVALID_DTO, String.format(EMPTY_FIELD, PARCELS, PARCELS_AFFINITY_GROUP));
		}
		parcelsAffinityGroupDTO.getParcels().forEach(parcelValidator::validate);
	}
}
