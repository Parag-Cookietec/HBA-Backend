package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMOGRFCRFIntimationPostDto;
import gov.ifms.dmo.entity.DMOGRFCRFAccountEntity;

@Component
public class DMOGRFCRFAccountConverter implements BaseConverter<DMOGRFCRFAccountEntity, DMOGRFCRFIntimationPostDto> {

	@Override
	public DMOGRFCRFAccountEntity toEntity(DMOGRFCRFIntimationPostDto dto) {
		DMOGRFCRFAccountEntity entity = new DMOGRFCRFAccountEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		return entity;
	}

	@Override
	public DMOGRFCRFIntimationPostDto toDTO(DMOGRFCRFAccountEntity entity) {
		DMOGRFCRFIntimationPostDto dto = new DMOGRFCRFIntimationPostDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
