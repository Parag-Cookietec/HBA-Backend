package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.loc.dto.LocAdviceDeductionDetailsDto;
import gov.ifms.loc.entity.LocAdviceDeductionDetailsEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class LocAdviceDeductionDetailsEntity class.
 * 
 * @version v 1.0
 * @created 2021/02/23 11:48:46
 *
 */
@Component
public class LocAdviceDeductionDetailsConverter implements BaseConverter<LocAdviceDeductionDetailsEntity,LocAdviceDeductionDetailsDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocAdvicedeductionDetails entity
	 */
	@Override
	public LocAdviceDeductionDetailsEntity toEntity(LocAdviceDeductionDetailsDto dto) {
		LocAdviceDeductionDetailsEntity entity = new LocAdviceDeductionDetailsEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocAdvicedeductionDetails  dto
	 */
	@Override
	public LocAdviceDeductionDetailsDto toDTO(LocAdviceDeductionDetailsEntity entity) {
		LocAdviceDeductionDetailsDto dto = new LocAdviceDeductionDetailsDto();
		dto.setLcAdviceId(entity.getLcAdvice().getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
