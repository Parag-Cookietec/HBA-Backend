package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPTrnUpdDsgnAttachmentDto;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnAttachmentEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnEntity;

/**
 * The Class EDPTrnUpdDsgnAttachmentConverter.
 */
@Component
public class EDPTrnUpdDsgnAttachmentConverter implements BaseConverter<EDPTrnUpdDsgnAttachmentEntity,EDPTrnUpdDsgnAttachmentDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP trn upd dsgn attachment entity
	 */
	@Override
	public EDPTrnUpdDsgnAttachmentEntity toEntity(EDPTrnUpdDsgnAttachmentDto dto) {
		EDPTrnUpdDsgnAttachmentEntity entity = new EDPTrnUpdDsgnAttachmentEntity();
		entity.setTrnUpdDsgnEntity(new EDPTrnUpdDsgnEntity(dto.getTrnUpdDsgnEntity()));
		entity.setAttachmentId(new EDPMsAttachmentEntity(dto.getAttachmentId()));
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP trn upd dsgn attachment dto
	 */
	@Override
	public EDPTrnUpdDsgnAttachmentDto toDTO(EDPTrnUpdDsgnAttachmentEntity entity) {
		EDPTrnUpdDsgnAttachmentDto dto = new EDPTrnUpdDsgnAttachmentDto();
		dto.setUploadedBy(entity.getUploadedBy().getUserId());
		dto.setUploadedByName(entity.getUploadedBy().getUserName());
		dto.setAttachmentName(entity.getAttachmentId().getAttachmentName());
		dto.setAttachmentId(entity.getAttachmentId().getAttachmentId());
		BeanUtils.copyProperties(entity,dto);
		dto.setFile(null);
		dto.setTrnUpdDsgnEntity(entity.getTrnUpdDsgnEntity().getTedpUpdDsgnId());
		return dto;
	}

}
