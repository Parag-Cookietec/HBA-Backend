package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.pvu.dto.PVUForgoAttachmentDto;
import gov.ifms.pvu.entity.PVUForgoAttachmentEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class PVUForgoAttachmentConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/13 11:47:13
 *
 */
@Component
public class PVUForgoAttachmentConverter implements BaseConverter<PVUForgoAttachmentEntity,PVUForgoAttachmentDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUForgoAttachment entity
	 */
	@Override
	public PVUForgoAttachmentEntity toEntity(PVUForgoAttachmentDto dto) {
		PVUForgoAttachmentEntity entity = new PVUForgoAttachmentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUForgoAttachment  dto
	 */
	@Override
	public PVUForgoAttachmentDto toDTO(PVUForgoAttachmentEntity entity) {
		PVUForgoAttachmentDto dto = new PVUForgoAttachmentDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
