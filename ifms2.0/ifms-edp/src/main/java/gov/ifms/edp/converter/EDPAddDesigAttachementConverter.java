package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPAddDesAttachmentDto;
import gov.ifms.edp.entity.EDPAddDesAttachmentEntity;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;

/**
 * The Class EDPAddDesigAttachementConverter.
 */
@Component
public class EDPAddDesigAttachementConverter
		implements BaseConverter<EDPAddDesAttachmentEntity, EDPAddDesAttachmentDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP office attachment entity
	 */
	@Override
	public EDPAddDesAttachmentEntity toEntity(EDPAddDesAttachmentDto dto) {
		EDPAddDesAttachmentEntity entity = new EDPAddDesAttachmentEntity();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setAttachmentId(new EDPMsAttachmentEntity(dto.getAttachmentId()));
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP office attachment dto
	 */
	@Override
	public EDPAddDesAttachmentDto toDTO(EDPAddDesAttachmentEntity entity) {
		EDPAddDesAttachmentDto dto = new EDPAddDesAttachmentDto();
		dto.setAttachmentId(entity.getAttachmentId().getAttachmentId());
		BeanUtils.copyProperties(entity, dto);
		dto.setAttachmentName(entity.getAttachmentId().getAttachmentName());
		dto.setUploadedById(entity.getUploadedBy().getUserId());
		dto.setUploadedByName(entity.getUploadedBy().getUserName());
		return dto;
	}

}
