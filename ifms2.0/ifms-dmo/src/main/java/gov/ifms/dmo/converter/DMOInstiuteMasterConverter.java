package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMOInstiuteMasterDto;
import gov.ifms.dmo.entity.DMOInstiuteMasterEntity;
@Component
public class DMOInstiuteMasterConverter implements BaseConverter<DMOInstiuteMasterEntity, DMOInstiuteMasterDto> {

	@Override
	public DMOInstiuteMasterEntity toEntity(DMOInstiuteMasterDto dto) {
	 DMOInstiuteMasterEntity entity=new DMOInstiuteMasterEntity();
	 BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMOInstiuteMasterDto toDTO(DMOInstiuteMasterEntity entity) {
     DMOInstiuteMasterDto dto=new DMOInstiuteMasterDto();
    		 BeanUtils.copyProperties(entity, dto);

		return dto;
	}

}
