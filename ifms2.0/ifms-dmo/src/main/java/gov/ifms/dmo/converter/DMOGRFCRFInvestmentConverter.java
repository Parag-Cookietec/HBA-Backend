package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMOGRFCRFInvestmentPostDto;
import gov.ifms.dmo.entity.DMOGRFCRFInvestmentEntity;

@Component
public class DMOGRFCRFInvestmentConverter
		implements BaseConverter<DMOGRFCRFInvestmentEntity, DMOGRFCRFInvestmentPostDto> {

	@Override
	public DMOGRFCRFInvestmentEntity toEntity(DMOGRFCRFInvestmentPostDto dto) {
		DMOGRFCRFInvestmentEntity entity = new DMOGRFCRFInvestmentEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		return entity;
	}

	@Override
	public DMOGRFCRFInvestmentPostDto toDTO(DMOGRFCRFInvestmentEntity entity) {
		DMOGRFCRFInvestmentPostDto dto = new DMOGRFCRFInvestmentPostDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
