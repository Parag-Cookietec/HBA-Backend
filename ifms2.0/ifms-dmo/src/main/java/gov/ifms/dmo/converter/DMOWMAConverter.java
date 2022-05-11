package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMOWMATypesDto;

import gov.ifms.dmo.entity.DMOWMATypesEntity;
@Component
public class DMOWMAConverter implements BaseConverter<DMOWMATypesEntity, DMOWMATypesDto> {

	@Override
	public DMOWMATypesEntity toEntity(DMOWMATypesDto dto) {
		DMOWMATypesEntity entity = new DMOWMATypesEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMOWMATypesDto toDTO(DMOWMATypesEntity entity) {
		DMOWMATypesDto dto=new DMOWMATypesDto();
		BeanUtils.copyProperties(entity, dto);		
		return dto;
	}

}
