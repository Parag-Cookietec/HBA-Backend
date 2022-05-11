package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPOfficeAttachmentDto;
import gov.ifms.edp.entity.EDPOfficeAttachmentEntity;
import gov.ifms.edp.entity.EDPOfficeAttachmentItrEntity;

/**
 * The Class EDPOfficeAttachementItrConverter.
 */
@Component
public class EDPOfficeAttachementItrConverter
		implements BaseConverter<EDPOfficeAttachmentItrEntity, EDPOfficeAttachmentDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP office attachment entity
	 */
	public EDPOfficeAttachmentItrEntity toEntity(EDPOfficeAttachmentEntity dto) {
		EDPOfficeAttachmentItrEntity entity = new EDPOfficeAttachmentItrEntity();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To list view.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPOfficeAttachmentItrEntity> toListEntity(List<EDPOfficeAttachmentEntity> list) {

		return list.stream().map(this::toEntity).collect(Collectors.toList());

	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP office attachment dto
	 */
	@Override
	public EDPOfficeAttachmentDto toDTO(EDPOfficeAttachmentItrEntity entity) {
		EDPOfficeAttachmentDto dto = new EDPOfficeAttachmentDto();
		dto.setAttachmentId(entity.getAttachmentId().getAttachmentId());
		dto.setAttachmentName(entity.getAttachmentId().getAttachmentName());
		dto.setUploadedBy(entity.getUploadedBy().getUserId());
		dto.setUploadedByName(entity.getUploadedBy().getUserName());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP office attachment itr entity
	 */
	@Override
	public EDPOfficeAttachmentItrEntity toEntity(EDPOfficeAttachmentDto dto) {
		EDPOfficeAttachmentItrEntity entity = new EDPOfficeAttachmentItrEntity();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
