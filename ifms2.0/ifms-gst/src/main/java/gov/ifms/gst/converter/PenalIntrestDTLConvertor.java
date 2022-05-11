package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.PenalIntrestDTLDto;
import gov.ifms.gst.entity.PenalIntrestDTL;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PenalIntrestDTLConvertor implements BaseConverter<PenalIntrestDTL, PenalIntrestDTLDto> {
	@Override
	public PenalIntrestDTL toEntity(PenalIntrestDTLDto dto) {
		PenalIntrestDTL entity = new PenalIntrestDTL();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<PenalIntrestDTL> toEntity(List<PenalIntrestDTLDto> dpSheetDtos) {
		return dpSheetDtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

	@Override
	public PenalIntrestDTLDto toDTO(PenalIntrestDTL entity) {
		PenalIntrestDTLDto dto = new PenalIntrestDTLDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<PenalIntrestDTLDto> toDTO(List<PenalIntrestDTL> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}
}
