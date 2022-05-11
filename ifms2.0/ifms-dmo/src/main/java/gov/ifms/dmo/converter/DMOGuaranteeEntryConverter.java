package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMOGuaranteeEntryPostDto;
import gov.ifms.dmo.entity.DMOGuaranteeEntryEntity;

@Component
public class DMOGuaranteeEntryConverter implements BaseConverter<DMOGuaranteeEntryEntity, DMOGuaranteeEntryPostDto> {

	@Override
	public DMOGuaranteeEntryEntity toEntity(DMOGuaranteeEntryPostDto dto) {
		DMOGuaranteeEntryEntity entity = new DMOGuaranteeEntryEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		return entity;
	}

	@Override
	public DMOGuaranteeEntryPostDto toDTO(DMOGuaranteeEntryEntity entity) {
		DMOGuaranteeEntryPostDto dto = new DMOGuaranteeEntryPostDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
