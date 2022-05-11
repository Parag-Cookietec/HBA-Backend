package gov.ifms.dmo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMOMarketLoanDto;
import gov.ifms.dmo.dto.DMOMarketLoanRePaymentDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMOMarketLoanEntity;
import gov.ifms.dmo.entity.DMOMarketLoanRePaymentEntity;

@Component
public class DMOMarketLoanRePaymentConverter implements BaseConverter<DMOMarketLoanRePaymentEntity, DMOMarketLoanDto>{

	@Override
	public DMOMarketLoanRePaymentEntity toEntity(DMOMarketLoanDto dto) {
		DMOMarketLoanRePaymentEntity entity = new DMOMarketLoanRePaymentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMOMarketLoanDto toDTO(DMOMarketLoanRePaymentEntity entity) {
		DMOMarketLoanDto dto = new DMOMarketLoanDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public DMOMarketLoanDto toRePaymentDTO(DMOMarketLoanEntity entity) {
		DMOMarketLoanDto dto = new DMOMarketLoanDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public DMOMarketLoanRePaymentDto toRePaymentDTO(DMOMarketLoanRePaymentEntity entity) {
		DMOMarketLoanRePaymentDto dto = new DMOMarketLoanRePaymentDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	public DMOMarketLoanRePaymentEntity toEntity(DMOMarketLoanRePaymentDto dto) {
		DMOMarketLoanRePaymentEntity entity = new DMOMarketLoanRePaymentEntity();
		BeanUtils.copyProperties(dto, entity);
		if(null != dto.getDpSheetId()) {
			entity.setDpSheetId(new DMODPSheetEntryEntity(dto.getDpSheetId()));
		}
	    if(null !=  dto.getMarketLoanHdrId()) {
	    	entity.setMarketLoanHdrId(new DMOMarketLoanEntity(dto.getMarketLoanHdrId()));
		}
		return entity;
	}
	
	
	@Override
	public List<DMOMarketLoanDto> toDTO(List<DMOMarketLoanRePaymentEntity> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	public List<DMOMarketLoanRePaymentDto> toRePaymentDTO(List<DMOMarketLoanRePaymentEntity> entities) {
		return entities.stream().map(this::toRePaymentDTO).collect(Collectors.toList());
	}
	public List<DMOMarketLoanRePaymentEntity> toRePaymentEntity(List<DMOMarketLoanRePaymentDto> entities) {
		return entities.stream().map(this::toEntity).collect(Collectors.toList());
	}
	
}
