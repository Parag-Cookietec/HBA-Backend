package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPMsColumnsDto;
import gov.ifms.edp.entity.EDPMsColumnsEntity;

/**
 * The Class EDPMsColumnsConverter class.
 * 
 * @version 1.0
 * @created 2019/08/29 18:39:10
 *
 */
@Component
public class EDPMsColumnsConverter implements BaseConverter<EDPMsColumnsEntity, EDPMsColumnsDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsColumns entity
	 */
	@Override
	public EDPMsColumnsEntity toEntity(EDPMsColumnsDto dto) {
		EDPMsColumnsEntity entity = new EDPMsColumnsEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsColumns dto
	 */
	@Override
	public EDPMsColumnsDto toDTO(EDPMsColumnsEntity entity) {
		EDPMsColumnsDto dto = new EDPMsColumnsDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
