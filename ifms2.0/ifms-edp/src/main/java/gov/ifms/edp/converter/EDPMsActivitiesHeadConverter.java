package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPMsActivitiesHeadDto;
import gov.ifms.edp.entity.EDPMsActivitiesHeadEntity;


/**
 * The Class EDPMsActivitiesHeadConverter class.
 * 
 * @version 1.0
 * @created 2019/08/31 12:56:51
 *
 */
@Component
public class EDPMsActivitiesHeadConverter implements BaseConverter<EDPMsActivitiesHeadEntity,EDPMsActivitiesHeadDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsActivitiesHead entity
	 */
	@Override
	public EDPMsActivitiesHeadEntity toEntity(EDPMsActivitiesHeadDto dto) {
		EDPMsActivitiesHeadEntity entity = new EDPMsActivitiesHeadEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsActivitiesHead  dto
	 */
	@Override
	public EDPMsActivitiesHeadDto toDTO(EDPMsActivitiesHeadEntity entity) {
		EDPMsActivitiesHeadDto dto = new EDPMsActivitiesHeadDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
