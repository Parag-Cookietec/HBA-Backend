package gov.ifms.dmo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMODPSheetT91BILLInvestPostDTO;
import gov.ifms.dmo.entity.DMODPSheetT91BILLRediscEntity;

@Component
public class DMODPSheetT91BILLRediscConverter
		implements BaseConverter<DMODPSheetT91BILLRediscEntity, DMODPSheetT91BILLInvestPostDTO> {

	@Override
	public DMODPSheetT91BILLRediscEntity toEntity(DMODPSheetT91BILLInvestPostDTO dto) {
		DMODPSheetT91BILLRediscEntity entity = new DMODPSheetT91BILLRediscEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMODPSheetT91BILLInvestPostDTO toDTO(DMODPSheetT91BILLRediscEntity entity) {
		DMODPSheetT91BILLInvestPostDTO dto = new DMODPSheetT91BILLInvestPostDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<DMODPSheetT91BILLInvestPostDTO> toDTO(List<DMODPSheetT91BILLRediscEntity> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}

	@Override
	public List<DMODPSheetT91BILLRediscEntity> toEntity(List<DMODPSheetT91BILLInvestPostDTO> dtos) {
		return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

}
