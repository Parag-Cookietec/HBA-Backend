package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAdviceHeadwiseDetailDto;
import gov.ifms.loc.entity.LocAdviceHeadwiseDetailEntity;


/**
 * The Class locLocAdviceHeadwiseDetailConverter class.
 * 
 * @version v 1.0
 * @created 2021/02/23 12:29:53
 *
 */
@Component
public class LocAdviceHeadwiseDetailConverter implements BaseConverter<LocAdviceHeadwiseDetailEntity,LocAdviceHeadwiseDetailDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the locLocAdviceHeadwiseDetail entity
	 */
	@Override
	public LocAdviceHeadwiseDetailEntity toEntity(LocAdviceHeadwiseDetailDto dto) {
		LocAdviceHeadwiseDetailEntity entity = new LocAdviceHeadwiseDetailEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the locLocAdviceHeadwiseDetail  dto
	 */
	@Override
	public LocAdviceHeadwiseDetailDto toDTO(LocAdviceHeadwiseDetailEntity entity) {
		LocAdviceHeadwiseDetailDto dto = new LocAdviceHeadwiseDetailDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	/**
	 * To lst DTO.
	 *
	 * @param entity the entity
	 * @return the loc advice headwise detail dto
	 */
	public LocAdviceHeadwiseDetailDto toLstDTO(LocAdviceHeadwiseDetailEntity entity) {
		LocAdviceHeadwiseDetailDto dto = new LocAdviceHeadwiseDetailDto();
		dto.setMajoreheadId(entity.getMajoreheadId().getMajorHeadId());
		dto.setMinorheadId(entity.getMinorheadId().getMinorHeadId());
		dto.setSubheadId(entity.getSubheadId().getSubHeadId());
		dto.setSubmajorheadId(entity.getSubmajorheadId().getSubMajorHeadId());
		dto.setDemandId(entity.getDemandId().getDemandId());
		dto.setDetailheadId(entity.getDetailheadId().getDetailHeadId());
		dto.setItemId(entity.getItemId().getItemId());
		dto.setObjectclassId(entity.getObjectclassId().getObjectClassId());
		dto.setLcAdviceId(entity.getLcAdvice());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	
	
}
