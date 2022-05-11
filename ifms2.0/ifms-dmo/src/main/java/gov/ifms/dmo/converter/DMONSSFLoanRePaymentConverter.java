package gov.ifms.dmo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMONSSFLoanDto;
import gov.ifms.dmo.dto.DMONSSFLoanRePaymentDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMONSSFLoanEntity;
import gov.ifms.dmo.entity.DMONSSFLoanRePaymentEntity;

@Component
public class DMONSSFLoanRePaymentConverter implements BaseConverter<DMONSSFLoanRePaymentEntity, DMONSSFLoanDto>{

	@Override
	public DMONSSFLoanRePaymentEntity toEntity(DMONSSFLoanDto dto) {
		DMONSSFLoanRePaymentEntity entity = new DMONSSFLoanRePaymentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMONSSFLoanDto toDTO(DMONSSFLoanRePaymentEntity entity) {
		DMONSSFLoanDto dto = new DMONSSFLoanDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public DMONSSFLoanDto toRePaymentDTO(DMONSSFLoanEntity entity) {
		DMONSSFLoanDto dto = new DMONSSFLoanDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public DMONSSFLoanRePaymentDto toRePaymentDTO(DMONSSFLoanRePaymentEntity entity) {
		DMONSSFLoanRePaymentDto dto = new DMONSSFLoanRePaymentDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public DMONSSFLoanRePaymentEntity toEntity(DMONSSFLoanRePaymentDto dto) {
		DMONSSFLoanRePaymentEntity entity = new DMONSSFLoanRePaymentEntity();
		BeanUtils.copyProperties(dto, entity);
		if(null != dto.getDpSheetEntity()) {
			entity.setDpSheetEntity(new DMODPSheetEntryEntity(dto.getDpSheetEntity()));
		}
	    if(null !=  dto.getNssfLoanId()) {
	    	entity.setNssfLoanId(new DMONSSFLoanEntity(dto.getNssfLoanId()));
		}
		return entity;
	}
	
	
	@Override
	public List<DMONSSFLoanDto> toDTO(List<DMONSSFLoanRePaymentEntity> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	public List<DMONSSFLoanRePaymentDto> toRePaymentDTO(List<DMONSSFLoanRePaymentEntity> entities) {
		return entities.stream().map(this::toRePaymentDTO).collect(Collectors.toList());
	}
	public List<DMONSSFLoanRePaymentEntity> toRePaymentEntity(List<DMONSSFLoanRePaymentDto> entities) {
		return entities.stream().map(this::toEntity).collect(Collectors.toList());
	}
	
}
