package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPTrnUserMpAttItrDto;
import gov.ifms.edp.entity.EDPTrnUserMpAttItrEntity;

/**
 * The Class EDPTrnUserMpAttItrConverter.
 */
@Component
public class EDPTrnUserMpAttItrConverter implements BaseConverter<EDPTrnUserMpAttItrEntity, EDPTrnUserMpAttItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPPostAttachmentItr entity
	 */
	@Override
	public EDPTrnUserMpAttItrEntity toEntity(EDPTrnUserMpAttItrDto dto) {
		EDPTrnUserMpAttItrEntity entity = new EDPTrnUserMpAttItrEntity();
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
	public EDPTrnUserMpAttItrDto toDTO(EDPTrnUserMpAttItrEntity entity) {
		EDPTrnUserMpAttItrDto dto = new EDPTrnUserMpAttItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}