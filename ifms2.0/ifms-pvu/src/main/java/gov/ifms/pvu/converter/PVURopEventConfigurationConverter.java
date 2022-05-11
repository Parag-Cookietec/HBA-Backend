package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.response.RopConfigurationDto;
import gov.ifms.pvu.entity.PVURopEventConfigurationEntity;

@Component
public class PVURopEventConfigurationConverter implements BaseConverter<PVURopEventConfigurationEntity, RopConfigurationDto> {

	@Override
	public PVURopEventConfigurationEntity toEntity(RopConfigurationDto dto) {
		return null;
	}

	@Override
	public RopConfigurationDto toDTO(PVURopEventConfigurationEntity entity) {
		RopConfigurationDto dto = new RopConfigurationDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
    
}
