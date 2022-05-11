package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.edp.dto.EDPMsAccountHeadDto;
import gov.ifms.edp.entity.EDPMsAccountHeadEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class EDPMsAccountHeadConverter class.
 * 
 * @version 1.0
 * @created 2019/08/31 12:54:53
 *
 */
@Component
public class EDPMsAccountHeadConverter implements BaseConverter<EDPMsAccountHeadEntity, EDPMsAccountHeadDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsAccountHead entity
	 */
	@Override
	public EDPMsAccountHeadEntity toEntity(EDPMsAccountHeadDto dto) {
		EDPMsAccountHeadEntity entity = new EDPMsAccountHeadEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsAccountHead dto
	 */
	@Override
	public EDPMsAccountHeadDto toDTO(EDPMsAccountHeadEntity entity) {
		EDPMsAccountHeadDto dto = new EDPMsAccountHeadDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
