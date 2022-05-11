package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPAddDesAttachmentDto;
import gov.ifms.edp.entity.EDPAddDesAttachmentEntity;
import gov.ifms.edp.entity.EDPAddDesAttachmentItrEntity;

/**
 * The Class EDPAddDesigAttachementItrConverter.
 */
@Component
public class EDPAddDesigAttachementItrConverter
		implements BaseConverter<EDPAddDesAttachmentItrEntity, EDPAddDesAttachmentDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP office attachment entity
	 */
	@Override
	public EDPAddDesAttachmentItrEntity toEntity(EDPAddDesAttachmentDto dto) {
		EDPAddDesAttachmentItrEntity entity = new EDPAddDesAttachmentItrEntity();
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
	public EDPAddDesAttachmentDto toDTO(EDPAddDesAttachmentItrEntity entity) {
		EDPAddDesAttachmentDto dto = new EDPAddDesAttachmentDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP add des attachment itr entity
	 */
	public EDPAddDesAttachmentItrEntity toEntity(EDPAddDesAttachmentEntity dto) {
		EDPAddDesAttachmentItrEntity entity = new EDPAddDesAttachmentItrEntity();

		BeanUtils.copyProperties(dto, entity);
		entity.setDesignationAttachId(dto.getDesignationAttachId());
		return entity;
	}
}
