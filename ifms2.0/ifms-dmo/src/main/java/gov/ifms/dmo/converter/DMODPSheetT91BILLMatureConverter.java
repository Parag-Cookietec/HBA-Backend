package gov.ifms.dmo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMODPSheetT91BILLInvestPostDTO;
import gov.ifms.dmo.entity.DMODPSheetT91BILLMatureEntity;
import gov.ifms.dmo.entity.DMODPSheetT91BILLRediscEntity;

@Component
public class DMODPSheetT91BILLMatureConverter
		implements BaseConverter<DMODPSheetT91BILLMatureEntity, DMODPSheetT91BILLInvestPostDTO> {

	@Override
	public DMODPSheetT91BILLMatureEntity toEntity(DMODPSheetT91BILLInvestPostDTO dto) {
		DMODPSheetT91BILLMatureEntity entity = new DMODPSheetT91BILLMatureEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMODPSheetT91BILLInvestPostDTO toDTO(DMODPSheetT91BILLMatureEntity entity) {
		DMODPSheetT91BILLInvestPostDTO dto = new DMODPSheetT91BILLInvestPostDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<DMODPSheetT91BILLInvestPostDTO> toDTO(List<DMODPSheetT91BILLMatureEntity> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}

	@Override
	public List<DMODPSheetT91BILLMatureEntity> toEntity(List<DMODPSheetT91BILLInvestPostDTO> dtos) {
		return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

}
