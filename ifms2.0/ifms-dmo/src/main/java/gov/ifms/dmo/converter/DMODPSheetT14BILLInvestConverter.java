package gov.ifms.dmo.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMODPSheetT14BILLInvestPostDTO;
import gov.ifms.dmo.entity.DMODPSheetT14BILLInvestEntity;

@Component
public class DMODPSheetT14BILLInvestConverter
		implements BaseConverter<DMODPSheetT14BILLInvestEntity, DMODPSheetT14BILLInvestPostDTO> {

	@Override
	public DMODPSheetT14BILLInvestEntity toEntity(DMODPSheetT14BILLInvestPostDTO dto) {
		DMODPSheetT14BILLInvestEntity entity = new DMODPSheetT14BILLInvestEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMODPSheetT14BILLInvestPostDTO toDTO(DMODPSheetT14BILLInvestEntity entity) {
		DMODPSheetT14BILLInvestPostDTO dto = new DMODPSheetT14BILLInvestPostDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
