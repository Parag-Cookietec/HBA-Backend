package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMOGRFCRFSecuritySalePostDto;
import gov.ifms.dmo.entity.DMOGRFCRFSecurityDtlEntity;

@Component
public class DMOGRFCRFSecurityDtlConverter
		implements BaseConverter<DMOGRFCRFSecurityDtlEntity, DMOGRFCRFSecuritySalePostDto> {

	@Override
	public DMOGRFCRFSecurityDtlEntity toEntity(DMOGRFCRFSecuritySalePostDto dto) {
		DMOGRFCRFSecurityDtlEntity entity = new DMOGRFCRFSecurityDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		return entity;
	}

	@Override
	public DMOGRFCRFSecuritySalePostDto toDTO(DMOGRFCRFSecurityDtlEntity entity) {
		DMOGRFCRFSecuritySalePostDto dto = new DMOGRFCRFSecuritySalePostDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
