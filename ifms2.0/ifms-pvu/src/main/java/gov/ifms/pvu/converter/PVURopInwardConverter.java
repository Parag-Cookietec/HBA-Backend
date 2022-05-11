package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.pvu.dto.PVURopInwardDto;
import gov.ifms.pvu.entity.PVURopInwardEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class PVURopInwardConverter class.
 * 
 * @version v 1.0
 * @created 2020/03/12 14:42:25
 *
 */
@Component
public class PVURopInwardConverter implements BaseConverter<PVURopInwardEntity,PVURopInwardDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVURopInward entity
	 */
	@Override
	public PVURopInwardEntity toEntity(PVURopInwardDto dto) {
		PVURopInwardEntity entity = new PVURopInwardEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVURopInward  dto
	 */
	@Override
	public PVURopInwardDto toDTO(PVURopInwardEntity entity) {
		PVURopInwardDto dto = new PVURopInwardDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
