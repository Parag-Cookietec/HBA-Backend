package gov.ifms.dmo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMODPSheetT14BILLInvestPostDTO;
import gov.ifms.dmo.entity.DMODPSheetT14BILLMatureEntity;

@Component
public class DMODPSheetT14BILLMatureConverter
		implements BaseConverter<DMODPSheetT14BILLMatureEntity, DMODPSheetT14BILLInvestPostDTO> {

	@Override
	public DMODPSheetT14BILLMatureEntity toEntity(DMODPSheetT14BILLInvestPostDTO dto) {
		DMODPSheetT14BILLMatureEntity entity = new DMODPSheetT14BILLMatureEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMODPSheetT14BILLInvestPostDTO toDTO(DMODPSheetT14BILLMatureEntity entity) {
		DMODPSheetT14BILLInvestPostDTO dto = new DMODPSheetT14BILLInvestPostDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<DMODPSheetT14BILLInvestPostDTO> toDTO(List<DMODPSheetT14BILLMatureEntity> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}

	@Override
	public List<DMODPSheetT14BILLMatureEntity> toEntity(List<DMODPSheetT14BILLInvestPostDTO> dtos) {
		return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

}
