package gov.ifms.dmo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMODPSheetEntryPostDto;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMODPSheetHDREntity;

/**
 * The Class DMODPSheetEntryConverter.
 * 
 * @version 2.0
 * @created 2021/07/21 15:19:32
 *
 */
@Component
public class DMODPSheetEntryConverter implements BaseConverter<DMODPSheetEntryEntity, DMODPSheetEntryPostDto> {

	@Override
	public DMODPSheetEntryEntity toEntity(DMODPSheetEntryPostDto dto) {
		DMODPSheetEntryEntity entity = new DMODPSheetEntryEntity();
		BeanUtils.copyProperties(dto, entity);
	    if(null != dto.getParentDpSheetId()) {
			entity.setEntity(new DMODPSheetHDREntity(dto.getParentDpSheetId()));
		}
		return entity;
	}

	@Override
	public List<DMODPSheetEntryPostDto> toDTO(List<DMODPSheetEntryEntity> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}

	@Override
	public DMODPSheetEntryPostDto toDTO(DMODPSheetEntryEntity entity) {
		DMODPSheetEntryPostDto dto = new DMODPSheetEntryPostDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setMemoNo(entity.getMemoNo());
		dto.setDpSheetReciveDate(entity.getEntity().getDpSheetReciveDate());
		dto.setParentDpSheetId(entity.getEntity().getDpSheetId());
		dto.setTransactionDesc(entity.getTransactionDesc());
		return dto;
	}
	
	public List<DMODPSheetEntryEntity> toEntity(List<DMODPSheetEntryPostDto> dpSheetDtos) {
		return dpSheetDtos.stream().map(this::toEntity).collect(Collectors.toList());
	}
	
	public DMODPSheetEntryPostDto mapToDTO(List<DMODPSheetEntryEntity> entities) {
		DMODPSheetEntryPostDto dto = new DMODPSheetEntryPostDto();
		for(DMODPSheetEntryEntity entity : entities) {
			BeanUtils.copyProperties(entity, dto);
		}
		return dto;
	}
}
