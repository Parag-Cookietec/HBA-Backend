package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPLuLookUpDto;
import gov.ifms.edp.entity.EDPLuLookUpEntity;

/**
 * The Class EDPLuLookUpConverter class.
 * 
 * @version 1.0
 * @created 2019/08/29 18:10:47
 *
 */
@Component
public class EDPLuLookUpConverter implements BaseConverter<EDPLuLookUpEntity, EDPLuLookUpDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPLuLookUp entity
	 */
	@Override
	public EDPLuLookUpEntity toEntity(EDPLuLookUpDto dto) {
		EDPLuLookUpEntity entity = new EDPLuLookUpEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPLuLookUp dto
	 */
	@Override
	public EDPLuLookUpDto toDTO(EDPLuLookUpEntity entity) {
		EDPLuLookUpDto dto = new EDPLuLookUpDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
