package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMODPSheetWMAPostDTO;
import gov.ifms.dmo.entity.DMODPSheetWMAPrincipalEntity;

@Component
public class DMODPSheetWMAPrincipalConverter
		implements BaseConverter<DMODPSheetWMAPrincipalEntity, DMODPSheetWMAPostDTO> {

	@Override
	public DMODPSheetWMAPrincipalEntity toEntity(DMODPSheetWMAPostDTO dto) {
		DMODPSheetWMAPrincipalEntity entity = new DMODPSheetWMAPrincipalEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMODPSheetWMAPostDTO toDTO(DMODPSheetWMAPrincipalEntity entity) {
		DMODPSheetWMAPostDTO dto = new DMODPSheetWMAPostDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
