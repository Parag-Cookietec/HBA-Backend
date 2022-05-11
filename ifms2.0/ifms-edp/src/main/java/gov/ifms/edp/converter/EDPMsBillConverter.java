package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPMsBillDto;
import gov.ifms.edp.entity.EDPMsBillEntity;

/**
 * The Class EDPMsBillConverter class.
 * 
 * @version 1.0
 * @created 2020/01/29 17:03:45
 *
 */
@Component
public class EDPMsBillConverter implements BaseConverter<EDPMsBillEntity, EDPMsBillDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsBill entity
	 */
	@Override
	public EDPMsBillEntity toEntity(EDPMsBillDto dto) {
		EDPMsBillEntity entity = new EDPMsBillEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsBill dto
	 */
	@Override
	public EDPMsBillDto toDTO(EDPMsBillEntity entity) {
		EDPMsBillDto dto = new EDPMsBillDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
