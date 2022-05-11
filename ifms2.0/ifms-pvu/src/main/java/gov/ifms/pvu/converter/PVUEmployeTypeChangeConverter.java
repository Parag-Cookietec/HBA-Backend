package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.PVUEmployeTypeChangeDto;
import gov.ifms.pvu.entity.PVUEmployeTypeChangeEntity;

/**
 * The Class PVUEmployeTypeChangeConverter class.
 *
 * @version v 2.0
 * @created 2021/04/20 12:05:07
 *
 */
@Component
public class PVUEmployeTypeChangeConverter implements BaseConverter<PVUEmployeTypeChangeEntity, PVUEmployeTypeChangeDto> {

	@Override
	public PVUEmployeTypeChangeEntity toEntity(PVUEmployeTypeChangeDto dto) {
		PVUEmployeTypeChangeEntity entity = new PVUEmployeTypeChangeEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public PVUEmployeTypeChangeDto toDTO(PVUEmployeTypeChangeEntity entity) {
		PVUEmployeTypeChangeDto dto = new PVUEmployeTypeChangeDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	
}
