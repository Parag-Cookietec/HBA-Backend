package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;

import gov.ifms.dmo.dto.DMOLoanPurposeDto;

import gov.ifms.dmo.entity.DMOLoanPurposeEntity;
@Component
public class DMOLoanPurposeConverter implements BaseConverter<DMOLoanPurposeEntity, DMOLoanPurposeDto>{

	@Override
	public DMOLoanPurposeEntity toEntity(DMOLoanPurposeDto dto) {
		 DMOLoanPurposeEntity  entity = new  DMOLoanPurposeEntity ();
		BeanUtils.copyProperties(dto, entity);
		
		return entity;
	}

	@Override
	public DMOLoanPurposeDto toDTO(DMOLoanPurposeEntity entity) {
		DMOLoanPurposeDto dto = new  DMOLoanPurposeDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
