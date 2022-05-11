package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.loc.dto.LocChequeCancelWfDto;
import gov.ifms.loc.entity.LocChequeCancelWfEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class LOCLocChequeCancelWfConverter class.
 * 
 * @version v 1.0
 * @created 2021/03/05 18:24:32
 *
 */
@Component
public class LocChequeCancelWfConverter implements BaseConverter<LocChequeCancelWfEntity,LocChequeCancelWfDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocChequeCancelWf entity
	 */
	@Override
	public LocChequeCancelWfEntity toEntity(LocChequeCancelWfDto dto) {
		LocChequeCancelWfEntity entity = new LocChequeCancelWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocChequeCancelWf  dto
	 */
	@Override
	public LocChequeCancelWfDto toDTO(LocChequeCancelWfEntity entity) {
		LocChequeCancelWfDto dto = new LocChequeCancelWfDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
