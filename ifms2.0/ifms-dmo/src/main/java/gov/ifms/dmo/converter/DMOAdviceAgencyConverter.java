package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMOAdviceAgencyDto;

import gov.ifms.dmo.entity.DMOAdviceAgencyEntity;

@Component
public class DMOAdviceAgencyConverter implements BaseConverter<DMOAdviceAgencyEntity, DMOAdviceAgencyDto> {

	@Override
	public DMOAdviceAgencyEntity toEntity(DMOAdviceAgencyDto dto) {
		DMOAdviceAgencyEntity entity = new DMOAdviceAgencyEntity();
		BeanUtils.copyProperties(dto, entity);
		
		return entity;
	}

	@Override
	public DMOAdviceAgencyDto toDTO(DMOAdviceAgencyEntity entity) {
		 DMOAdviceAgencyDto dto = new  DMOAdviceAgencyDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
		
	}

}
