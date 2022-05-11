package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMOGRFCRFAccruedInterestPostDto;
import gov.ifms.dmo.entity.DMOGRFCRFAccruedInterestEntity;

@Component
public class DMOGRFCRFAccruedInterestConverter
		implements BaseConverter<DMOGRFCRFAccruedInterestEntity, DMOGRFCRFAccruedInterestPostDto> {

	@Override
	public DMOGRFCRFAccruedInterestEntity toEntity(DMOGRFCRFAccruedInterestPostDto dto) {
		DMOGRFCRFAccruedInterestEntity entity = new DMOGRFCRFAccruedInterestEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		return entity;
	}

	@Override
	public DMOGRFCRFAccruedInterestPostDto toDTO(DMOGRFCRFAccruedInterestEntity entity) {
		DMOGRFCRFAccruedInterestPostDto dto = new DMOGRFCRFAccruedInterestPostDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}