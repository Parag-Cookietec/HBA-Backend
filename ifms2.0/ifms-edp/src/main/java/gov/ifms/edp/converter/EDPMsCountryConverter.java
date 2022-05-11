package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPMsCountryDto;
import gov.ifms.edp.entity.EDPMsCountryEntity;

/**
 * The Class EDPMsCountryConverter.
 */
@Component
public class EDPMsCountryConverter implements BaseConverter<EDPMsCountryEntity,EDPMsCountryDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsCountryEntity entity
	 */
	@Override
	public EDPMsCountryEntity toEntity(EDPMsCountryDto dto) {
		EDPMsCountryEntity entity = new EDPMsCountryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsCountryEntity  dto
	 */
	@Override
	public EDPMsCountryDto toDTO(EDPMsCountryEntity entity) {
		EDPMsCountryDto dto = new EDPMsCountryDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
