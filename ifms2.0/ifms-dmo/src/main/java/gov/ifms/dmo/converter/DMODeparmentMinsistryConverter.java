package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMODeparmentMinsistryDto;
import gov.ifms.dmo.entity.DMODEPTMinistry;

@Component
public class DMODeparmentMinsistryConverter implements BaseConverter<DMODEPTMinistry, DMODeparmentMinsistryDto>{

	@Override
	public DMODEPTMinistry toEntity(DMODeparmentMinsistryDto dto) {
		
		DMODEPTMinistry entity= new DMODEPTMinistry();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMODeparmentMinsistryDto toDTO(DMODEPTMinistry entity) {
		DMODeparmentMinsistryDto dto= new DMODeparmentMinsistryDto();
		BeanUtils.copyProperties(entity, dto);
		
		
		return dto;
	}

}
