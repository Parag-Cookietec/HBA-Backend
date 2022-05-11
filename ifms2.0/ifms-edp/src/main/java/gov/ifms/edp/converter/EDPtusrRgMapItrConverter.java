package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPtusrRgMapItrDto;
import gov.ifms.edp.entity.EDPtusrRgMapItrEntity;

/**
 * The Class EDPtusrRgMapItrConverter class.
 * 
 * @version 1.0
 * @created 2020/07/16 09:28:25
 *
 */
@Component
public class EDPtusrRgMapItrConverter implements BaseConverter<EDPtusrRgMapItrEntity,EDPtusrRgMapItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPtusrRgMapItr entity
	 */
	@Override
	public EDPtusrRgMapItrEntity toEntity(EDPtusrRgMapItrDto dto) {
		EDPtusrRgMapItrEntity entity = new EDPtusrRgMapItrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPtusrRgMapItr  dto
	 */
	@Override
	public EDPtusrRgMapItrDto toDTO(EDPtusrRgMapItrEntity entity) {
		EDPtusrRgMapItrDto dto = new EDPtusrRgMapItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
