package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMODPSheetT91BILLInvestPostDTO;
import gov.ifms.dmo.entity.DMODPSheetT91BILLInvestEntity;

@Component
public class DMODPSheetT91BILLInvestConverter
		implements BaseConverter<DMODPSheetT91BILLInvestEntity, DMODPSheetT91BILLInvestPostDTO> {

	@Override
	public DMODPSheetT91BILLInvestEntity toEntity(DMODPSheetT91BILLInvestPostDTO dto) {
		DMODPSheetT91BILLInvestEntity entity = new DMODPSheetT91BILLInvestEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMODPSheetT91BILLInvestPostDTO toDTO(DMODPSheetT91BILLInvestEntity entity) {
		DMODPSheetT91BILLInvestPostDTO dto = new DMODPSheetT91BILLInvestPostDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
