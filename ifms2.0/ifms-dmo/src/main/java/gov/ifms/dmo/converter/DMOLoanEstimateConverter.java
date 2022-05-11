package gov.ifms.dmo.converter;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMOLoanEstimateDto;
import gov.ifms.dmo.entity.DMOLoanEstimateEntity;
@Component
public class DMOLoanEstimateConverter implements BaseConverter<DMOLoanEstimateEntity, DMOLoanEstimateDto>{

	@Override
	public DMOLoanEstimateEntity toEntity(DMOLoanEstimateDto dto) {
	
		DMOLoanEstimateEntity entity=new DMOLoanEstimateEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMOLoanEstimateDto toDTO(DMOLoanEstimateEntity entity) {
		DMOLoanEstimateDto dto=new DMOLoanEstimateDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
