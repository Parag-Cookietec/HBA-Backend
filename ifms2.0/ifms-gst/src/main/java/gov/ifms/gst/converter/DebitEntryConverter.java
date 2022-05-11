package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.DebitEntryDto;
import gov.ifms.gst.entity.AccManualEntryDr;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class DebitEntryDtoConverter.
 *
 * @version v 1.0.
 * @created
 *
 */
@Component
public class DebitEntryConverter implements BaseConverter<AccManualEntryDr, DebitEntryDto> {


	@Override
	public AccManualEntryDr toEntity(DebitEntryDto dto) {
		AccManualEntryDr entity = new AccManualEntryDr();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<AccManualEntryDr> toEntity(List<DebitEntryDto> dpSheetDtos) {
		return dpSheetDtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

	@Override
	public DebitEntryDto toDTO(AccManualEntryDr entity) {
		DebitEntryDto dto = new DebitEntryDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<DebitEntryDto> toDTO(List<AccManualEntryDr> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}

}
