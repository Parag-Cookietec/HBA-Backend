package gov.ifms.dmo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMOGOILoanDto;
import gov.ifms.dmo.dto.DMOGOILoanRePaymentDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMOGOILoanEntity;
import gov.ifms.dmo.entity.DMOGOILoanRePaymentEntity;

@Component
public class DMOGOILoanRePaymentConverter implements BaseConverter<DMOGOILoanRePaymentEntity, DMOGOILoanDto>{

	@Override
	public DMOGOILoanRePaymentEntity toEntity(DMOGOILoanDto dto) {
		DMOGOILoanRePaymentEntity entity = new DMOGOILoanRePaymentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMOGOILoanDto toDTO(DMOGOILoanRePaymentEntity entity) {
		DMOGOILoanDto dto = new DMOGOILoanDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public DMOGOILoanDto toRePaymentDTO(DMOGOILoanEntity entity) {
		DMOGOILoanDto dto = new DMOGOILoanDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public DMOGOILoanRePaymentDto toRePaymentDTO(DMOGOILoanRePaymentEntity entity) {
		DMOGOILoanRePaymentDto dto = new DMOGOILoanRePaymentDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public DMOGOILoanRePaymentEntity toEntity(DMOGOILoanRePaymentDto dto) {
		DMOGOILoanRePaymentEntity entity = new DMOGOILoanRePaymentEntity();
		BeanUtils.copyProperties(dto, entity);
		if(null != dto.getDpSheetEntity()) {
			entity.setDpSheetEntity(new DMODPSheetEntryEntity(dto.getDpSheetEntity()));
		}
	    if(null !=  dto.getGoiLoanId()) {
	    	entity.setGoiLoanId(new DMOGOILoanEntity(dto.getGoiLoanId()));
		}
		return entity;
	}
	
	
	@Override
	public List<DMOGOILoanDto> toDTO(List<DMOGOILoanRePaymentEntity> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	public List<DMOGOILoanRePaymentDto> toRePaymentDTO(List<DMOGOILoanRePaymentEntity> entities) {
		return entities.stream().map(this::toRePaymentDTO).collect(Collectors.toList());
	}
	public List<DMOGOILoanRePaymentEntity> toRePaymentEntity(List<DMOGOILoanRePaymentDto> entities) {
		return entities.stream().map(this::toEntity).collect(Collectors.toList());
	}
	
}
