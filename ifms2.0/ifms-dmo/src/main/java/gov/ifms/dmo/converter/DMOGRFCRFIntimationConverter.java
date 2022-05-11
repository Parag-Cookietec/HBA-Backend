package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMOGRFCRFIntimationPostDto;
import gov.ifms.dmo.entity.DMOGRFCRFIntimationEntity;

@Component
public class DMOGRFCRFIntimationConverter
		implements BaseConverter<DMOGRFCRFIntimationEntity, DMOGRFCRFIntimationPostDto> {

	@Override
	public DMOGRFCRFIntimationEntity toEntity(DMOGRFCRFIntimationPostDto dto) {
		DMOGRFCRFIntimationEntity entity = new DMOGRFCRFIntimationEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		return entity;
	}

	public DMOGRFCRFIntimationEntity toEntity(DMOGRFCRFIntimationEntity entity, DMOGRFCRFIntimationPostDto dto) {
		BeanUtils.copyProperties(dto, entity);
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		return entity;
	}

	@Override
	public DMOGRFCRFIntimationPostDto toDTO(DMOGRFCRFIntimationEntity entity) {
		DMOGRFCRFIntimationPostDto dto = new DMOGRFCRFIntimationPostDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
