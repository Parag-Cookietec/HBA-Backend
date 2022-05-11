package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMOGRFCRFSecuritySalePostDto;
import gov.ifms.dmo.entity.DMOGRFCRFSecuritySaleEntity;

@Component
public class DMOGRFCRFSecuritySaleConverter
		implements BaseConverter<DMOGRFCRFSecuritySaleEntity, DMOGRFCRFSecuritySalePostDto> {

	@Override
	public DMOGRFCRFSecuritySaleEntity toEntity(DMOGRFCRFSecuritySalePostDto dto) {
		DMOGRFCRFSecuritySaleEntity entity = new DMOGRFCRFSecuritySaleEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		return entity;
	}

	@Override
	public DMOGRFCRFSecuritySalePostDto toDTO(DMOGRFCRFSecuritySaleEntity entity) {
		DMOGRFCRFSecuritySalePostDto dto = new DMOGRFCRFSecuritySalePostDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
