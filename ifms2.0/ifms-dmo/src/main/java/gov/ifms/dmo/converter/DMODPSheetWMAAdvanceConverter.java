package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMODPSheetWMAPostDTO;
import gov.ifms.dmo.entity.DMODPSheetWMAAdvanceEntity;

@Component
public class DMODPSheetWMAAdvanceConverter implements BaseConverter<DMODPSheetWMAAdvanceEntity, DMODPSheetWMAPostDTO> {

	@Override
	public DMODPSheetWMAAdvanceEntity toEntity(DMODPSheetWMAPostDTO dto) {
		DMODPSheetWMAAdvanceEntity entity = new DMODPSheetWMAAdvanceEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMODPSheetWMAPostDTO toDTO(DMODPSheetWMAAdvanceEntity entity) {
		DMODPSheetWMAPostDTO dto = new DMODPSheetWMAPostDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
