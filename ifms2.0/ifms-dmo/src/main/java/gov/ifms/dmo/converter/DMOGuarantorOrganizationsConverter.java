package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMOGuarantorOrganizationsDto;
import gov.ifms.dmo.entity.DMOLoanGuarantorEntity;
@Component
public class DMOGuarantorOrganizationsConverter implements BaseConverter<DMOLoanGuarantorEntity, DMOGuarantorOrganizationsDto>{

	@Override
	public DMOLoanGuarantorEntity toEntity(DMOGuarantorOrganizationsDto dto) {
		DMOLoanGuarantorEntity entity=new DMOLoanGuarantorEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMOGuarantorOrganizationsDto toDTO(DMOLoanGuarantorEntity entity) {
		DMOGuarantorOrganizationsDto dto=new DMOGuarantorOrganizationsDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
