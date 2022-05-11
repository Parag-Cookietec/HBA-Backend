package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPLkPuoDsgnLocDto;
import gov.ifms.edp.entity.EDPLkPuoDsgnLocEntity;

/**
 * The Class EDPLkPuoDsgnLocConverter class.
 * 
 * @version 1.0
 * @created 2019/12/11 16:14:51
 *
 */
@Component
public class EDPLkPuoDsgnLocConverter implements BaseConverter<EDPLkPuoDsgnLocEntity,EDPLkPuoDsgnLocDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPLkPuoDsgnLoc entity
	 */
	@Override
	public EDPLkPuoDsgnLocEntity toEntity(EDPLkPuoDsgnLocDto dto) {
		EDPLkPuoDsgnLocEntity entity = new EDPLkPuoDsgnLocEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPLkPuoDsgnLoc  dto
	 */
	@Override
	public EDPLkPuoDsgnLocDto toDTO(EDPLkPuoDsgnLocEntity entity) {
		EDPLkPuoDsgnLocDto dto = new EDPLkPuoDsgnLocDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
