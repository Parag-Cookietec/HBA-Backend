package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMOSecuirtyMasterDto;
import gov.ifms.dmo.entity.DMOSecuirtyMasterEntity;
@Component
public class DMOSecuirtyMasterConverter implements BaseConverter<DMOSecuirtyMasterEntity, DMOSecuirtyMasterDto> {
	
	@Override
	public DMOSecuirtyMasterEntity toEntity(DMOSecuirtyMasterDto dto) {
	DMOSecuirtyMasterEntity entity=new DMOSecuirtyMasterEntity();
	BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMOSecuirtyMasterDto toDTO(DMOSecuirtyMasterEntity entity) {
	DMOSecuirtyMasterDto dto=new DMOSecuirtyMasterDto();
	BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
