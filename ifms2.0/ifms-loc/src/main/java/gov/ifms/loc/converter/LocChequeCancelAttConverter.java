package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.loc.dto.LocChequeCancelAttDto;
import gov.ifms.loc.entity.LocChequeCancelAttEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class LOCLocChequeCancelAttConverter class.
 * 
 * @version v 1.0
 * @created 2021/03/05 17:59:59
 *
 */
@Component
public class LocChequeCancelAttConverter implements BaseConverter<LocChequeCancelAttEntity,LocChequeCancelAttDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LOCLocChequeCancelAtt entity
	 */
	@Override
	public LocChequeCancelAttEntity toEntity(LocChequeCancelAttDto dto) {
		LocChequeCancelAttEntity entity = new LocChequeCancelAttEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocChequeCancelAtt  dto
	 */
	@Override
	public LocChequeCancelAttDto toDTO(LocChequeCancelAttEntity entity) {
		LocChequeCancelAttDto dto = new LocChequeCancelAttDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
