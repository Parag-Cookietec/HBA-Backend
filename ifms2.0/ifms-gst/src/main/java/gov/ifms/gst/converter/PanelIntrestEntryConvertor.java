package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.PenalIntrestDTLDto;
import gov.ifms.gst.dto.PenalIntrestEntryDto;
import gov.ifms.gst.entity.PenalIntrestDTL;
import gov.ifms.gst.entity.PenalIntrestEntry;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PanelIntrestEntryConvertor implements BaseConverter<PenalIntrestEntry, PenalIntrestEntryDto> {
	@Override
	public PenalIntrestEntry toEntity(PenalIntrestEntryDto dto) {
		PenalIntrestEntry entity = new PenalIntrestEntry();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public PenalIntrestEntryDto toDTO(PenalIntrestEntry entity) {
		PenalIntrestEntryDto dto = new PenalIntrestEntryDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
