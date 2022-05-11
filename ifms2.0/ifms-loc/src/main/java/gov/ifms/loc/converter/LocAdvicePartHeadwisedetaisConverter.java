package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAdvicePartHeadwisedetaisSdDto;
import gov.ifms.loc.entity.LocAdvicePartHeadwisedetaisEntity;

/**
 * The Class LocAdvicePartHeadwisedetaisConverter class.
 * 
 * @version v 1.0
 * @created 2021/02/23 12:51:19
 *
 */
@Component
public class LocAdvicePartHeadwisedetaisConverter implements BaseConverter<LocAdvicePartHeadwisedetaisEntity,LocAdvicePartHeadwisedetaisSdDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocAdvicePartHeadwisedetais entity
	 */
	@Override
	public LocAdvicePartHeadwisedetaisEntity toEntity(LocAdvicePartHeadwisedetaisSdDto dto) {
		LocAdvicePartHeadwisedetaisEntity entity = new LocAdvicePartHeadwisedetaisEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocAdvicePartHeadwisedetais  dto
	 */
	@Override
	public LocAdvicePartHeadwisedetaisSdDto toDTO(LocAdvicePartHeadwisedetaisEntity entity) {
		LocAdvicePartHeadwisedetaisSdDto dto = new LocAdvicePartHeadwisedetaisSdDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
