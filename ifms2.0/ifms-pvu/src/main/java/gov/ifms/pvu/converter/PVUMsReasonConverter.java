package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.entity.PVUMsReasonEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class PVUMsReasonConverter class.
 * 
 * @version v 1.0
 * @created 2020/04/14 02:50:39
 *
 */
@Component
public class PVUMsReasonConverter implements BaseConverter<PVUMsReasonEntity, PVUMsReasonDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUMsReason entity
	 */
	@Override
	public PVUMsReasonEntity toEntity(PVUMsReasonDto dto) {
		PVUMsReasonEntity entity = new PVUMsReasonEntity();
		entity.setId(dto.getReasonId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUMsReason dto
	 */
	@Override
	public PVUMsReasonDto toDTO(PVUMsReasonEntity entity) {
		PVUMsReasonDto dto = new PVUMsReasonDto();
		dto.setReasonId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
