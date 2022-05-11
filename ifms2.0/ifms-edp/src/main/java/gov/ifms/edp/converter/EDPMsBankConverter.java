package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPMsBankDto;
import gov.ifms.edp.entity.EDPMsBankEntity;

/**
 * The Class EDPMsBankConverter.
 */
@Component
public class EDPMsBankConverter implements BaseConverter<EDPMsBankEntity, EDPMsBankDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP ms bank entity
	 */
	@Override
	public EDPMsBankEntity toEntity(EDPMsBankDto dto) {
		EDPMsBankEntity entity = new EDPMsBankEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP ms bank dto
	 */
	@Override
	public EDPMsBankDto toDTO(EDPMsBankEntity entity) {
		EDPMsBankDto dto = new EDPMsBankDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
