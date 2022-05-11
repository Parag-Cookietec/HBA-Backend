package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.entity.PVUEventRemarksEntity;

/**
 * The Class PVUEventRemarksEntityConverter class.
 * 
 * @version v 1.0
 * @created 2020/04/14 15:45:41
 *
 */
@Component
public class PVUEventRemarksConverter implements BaseConverter<PVUEventRemarksEntity, PVUEventRemarksDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEventRemarksEntity entity
	 */
	@Override
	public PVUEventRemarksEntity toEntity(PVUEventRemarksDto dto) {
		PVUEventRemarksEntity entity = new PVUEventRemarksEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEventRemarksEntity dto
	 */
	@Override
	public PVUEventRemarksDto toDTO(PVUEventRemarksEntity entity) {
		PVUEventRemarksDto dto = new PVUEventRemarksDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
