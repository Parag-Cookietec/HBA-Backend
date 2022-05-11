package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.AccDebitEntryDto;
import gov.ifms.gst.entity.AccDebitEntry;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccDebitEntryConvertor implements BaseConverter<AccDebitEntry, AccDebitEntryDto> {
	@Override
	public AccDebitEntry toEntity(AccDebitEntryDto dto) {
		AccDebitEntry entity = new AccDebitEntry();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<AccDebitEntry> toEntity(List<AccDebitEntryDto> dpSheetDtos) {
		return dpSheetDtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

	@Override
	public AccDebitEntryDto toDTO(AccDebitEntry entity) {
		AccDebitEntryDto dto = new AccDebitEntryDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<AccDebitEntryDto> toDTO(List<AccDebitEntry> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}
}
