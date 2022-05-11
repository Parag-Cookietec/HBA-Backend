package gov.ifms.dmo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.dmo.dto.DMODPSheetT14BILLInvestPostDTO;
import gov.ifms.dmo.entity.DMODPSheetT14BILLRediscEntity;

@Component
public class DMODPSheetT14BILLReDiscConverter
		implements BaseConverter<DMODPSheetT14BILLRediscEntity, DMODPSheetT14BILLInvestPostDTO> {

	@Override
	public DMODPSheetT14BILLRediscEntity toEntity(DMODPSheetT14BILLInvestPostDTO dto) {
		DMODPSheetT14BILLRediscEntity entity = new DMODPSheetT14BILLRediscEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DMODPSheetT14BILLInvestPostDTO toDTO(DMODPSheetT14BILLRediscEntity entity) {
		DMODPSheetT14BILLInvestPostDTO dto = new DMODPSheetT14BILLInvestPostDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<DMODPSheetT14BILLInvestPostDTO> toDTO(List<DMODPSheetT14BILLRediscEntity> entities) {
		return entities.stream().map(this::toDTO).collect(Collectors.toList());
	}

	@Override
	public List<DMODPSheetT14BILLRediscEntity> toEntity(List<DMODPSheetT14BILLInvestPostDTO> dtos) {
		return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	}

}
