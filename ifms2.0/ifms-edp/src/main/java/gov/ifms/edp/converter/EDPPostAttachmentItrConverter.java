package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.edp.dto.EDPPostAttachmentItrDto;
import gov.ifms.edp.entity.EDPPostAttachmentItrEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class EDPPostAttachmentItrConverter class.
 * 
 * @version 1.0
 * @created 2019/12/20 17:42:52
 *
 */
@Component
public class EDPPostAttachmentItrConverter implements BaseConverter<EDPPostAttachmentItrEntity,EDPPostAttachmentItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPPostAttachmentItr entity
	 */
	@Override
	public EDPPostAttachmentItrEntity toEntity(EDPPostAttachmentItrDto dto) {
		EDPPostAttachmentItrEntity entity = new EDPPostAttachmentItrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPPostAttachmentItr  dto
	 */
	@Override
	public EDPPostAttachmentItrDto toDTO(EDPPostAttachmentItrEntity entity) {
		EDPPostAttachmentItrDto dto = new EDPPostAttachmentItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
