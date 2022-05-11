package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.loc.dto.LocAdvicePartyDetaisDto;
import gov.ifms.loc.entity.LocAdvicePartyDetailsEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class locLocAdvicePartyDetaisConverter class.
 * 
 * @version v 1.0
 * @created 2021/02/23 14:53:51
 *
 */
@Component
public class LocAdvicePartyDetaisConverter implements BaseConverter<LocAdvicePartyDetailsEntity,LocAdvicePartyDetaisDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the locLocAdvicePartyDetais entity
	 */
	@Override
	public LocAdvicePartyDetailsEntity toEntity(LocAdvicePartyDetaisDto dto) {
		LocAdvicePartyDetailsEntity entity = new LocAdvicePartyDetailsEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the locLocAdvicePartyDetais  dto
	 */
	@Override
	public LocAdvicePartyDetaisDto toDTO(LocAdvicePartyDetailsEntity entity) {
		LocAdvicePartyDetaisDto dto = new LocAdvicePartyDetaisDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
