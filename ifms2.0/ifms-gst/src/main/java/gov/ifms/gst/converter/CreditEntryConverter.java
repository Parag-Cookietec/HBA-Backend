package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.CreditEntryDto;
import gov.ifms.gst.entity.AccManualEntryCr;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class CreditEntryDtoConverter.
 *
 * @version v 1.0.
 * @created
 *
 */
@Component
public class CreditEntryConverter implements BaseConverter<AccManualEntryCr, CreditEntryDto> {


	@Override
	public AccManualEntryCr toEntity(CreditEntryDto dto) {
		AccManualEntryCr entity = new AccManualEntryCr();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<AccManualEntryCr> toEntity(List<CreditEntryDto> dpSheetDtos) {
		return dpSheetDtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

	@Override
	public CreditEntryDto toDTO(AccManualEntryCr entity) {
		CreditEntryDto dto = new CreditEntryDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<CreditEntryDto> toDTO(List<AccManualEntryCr> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}

}
