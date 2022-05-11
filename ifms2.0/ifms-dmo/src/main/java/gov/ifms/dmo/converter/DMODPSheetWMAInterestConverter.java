package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMODPSheetWMAPostDTO;
import gov.ifms.dmo.entity.DMODPSheetWMAInterestEntity;

@Component
public class DMODPSheetWMAInterestConverter
		implements BaseConverter<DMODPSheetWMAInterestEntity, DMODPSheetWMAPostDTO> {

	@Override
	public DMODPSheetWMAInterestEntity toEntity(DMODPSheetWMAPostDTO dto) {
		DMODPSheetWMAInterestEntity entity = new DMODPSheetWMAInterestEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMODPSheetWMAPostDTO toDTO(DMODPSheetWMAInterestEntity entity) {
		DMODPSheetWMAPostDTO dto = new DMODPSheetWMAPostDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
