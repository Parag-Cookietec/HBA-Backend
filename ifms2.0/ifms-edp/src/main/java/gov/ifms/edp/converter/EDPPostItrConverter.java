package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPPostItrDto;
import gov.ifms.edp.entity.EDPPostItrEntity;

/**
 * The Class EDPPostItrConverter class.
 * 
 * @version 1.0
 * @created 2019/12/09 12:27:17
 *
 */
@Component
public class EDPPostItrConverter implements BaseConverter<EDPPostItrEntity, EDPPostItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPPostItr entity
	 */
	@Override
	public EDPPostItrEntity toEntity(EDPPostItrDto dto) {
		EDPPostItrEntity entity = new EDPPostItrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPPostItr dto
	 */
	@Override
	public EDPPostItrDto toDTO(EDPPostItrEntity entity) {
		EDPPostItrDto dto = new EDPPostItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
