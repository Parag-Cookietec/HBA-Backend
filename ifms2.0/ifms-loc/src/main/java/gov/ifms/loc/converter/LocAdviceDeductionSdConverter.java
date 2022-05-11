package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAdviceDeductionSdDto;
import gov.ifms.loc.entity.LocAdviceDeductionDetailsEntity;
import gov.ifms.loc.entity.LocAdviceDeductionSdEntity;
import gov.ifms.loc.entity.LocAdvicePrepHdrEntity;


/**
 * The Class locLocAdvicedeductionSdConverter class.
 * 
 * @version v 1.0
 * @created 2021/02/23 16:58:33
 *
 */
@Component
public class LocAdviceDeductionSdConverter implements BaseConverter<LocAdviceDeductionSdEntity,LocAdviceDeductionSdDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the locLocAdvicedeductionSd entity
	 */
	@Override
	public LocAdviceDeductionSdEntity toEntity(LocAdviceDeductionSdDto dto) {
		LocAdviceDeductionSdEntity entity = new LocAdviceDeductionSdEntity();
		if(null!= dto.getLocAdviceHrdId()) {
			entity.setLcAdvice(new LocAdvicePrepHdrEntity(dto.getLocAdviceHrdId()));
		}
		if(null!=dto.getId()) {
			entity.setId(dto.getId());
		}
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the locLocAdvicedeductionSd  dto
	 */
	@Override
	public LocAdviceDeductionSdDto toDTO(LocAdviceDeductionSdEntity entity) {
		LocAdviceDeductionSdDto dto = new LocAdviceDeductionSdDto();
		dto.setLocAdviceHrdId(entity.getLcAdvice().getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	
	/**
	 * Dtl sd dto.
	 *
	 * @param entity the entity
	 * @return the loc advice deduction sd dto
	 */
	public LocAdviceDeductionSdDto dtlSdDto(LocAdviceDeductionDetailsEntity entity){
		LocAdviceDeductionSdDto dto = new LocAdviceDeductionSdDto();
		dto.setLocAdviceHrdId(entity.getLcAdvice().getId());
			BeanUtils.copyProperties(entity, dto);
		return dto;
		
	}
	
	
}
