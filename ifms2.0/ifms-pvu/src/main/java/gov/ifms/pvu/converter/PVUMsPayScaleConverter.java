package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.pvu.dto.PVUMsPayScaleDto;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class PVUMsPayScaleConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/12 16:58:17
 *
 */
@Component
public class PVUMsPayScaleConverter implements BaseConverter<PVUMsPayScaleEntity,PVUMsPayScaleDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUMsPayScale entity
	 */
	@Override
	public PVUMsPayScaleEntity toEntity(PVUMsPayScaleDto dto) {
		PVUMsPayScaleEntity entity = new PVUMsPayScaleEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUMsPayScale  dto
	 */
	@Override
	public PVUMsPayScaleDto toDTO(PVUMsPayScaleEntity entity) {
		PVUMsPayScaleDto dto = new PVUMsPayScaleDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
