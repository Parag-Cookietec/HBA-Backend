package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.PVUEmployeTypeChangeDto;
import gov.ifms.pvu.entity.PVUEmployeTypeChangeSDEntity;

/**
 * The Class PVUEmployeTypeChangeConverter class.
 *
 * @version v 2.0
 * @created 2021/04/20 12:05:07
 *
 */
@Component
public class PVUEmployeTypeChangeSDConverter implements BaseConverter<PVUEmployeTypeChangeSDEntity, PVUEmployeTypeChangeDto> {

	@Override
	public PVUEmployeTypeChangeSDEntity toEntity(PVUEmployeTypeChangeDto dto) {
		PVUEmployeTypeChangeSDEntity entity = new PVUEmployeTypeChangeSDEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public PVUEmployeTypeChangeDto toDTO(PVUEmployeTypeChangeSDEntity entity) {
		PVUEmployeTypeChangeDto dto = new PVUEmployeTypeChangeDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	
}
