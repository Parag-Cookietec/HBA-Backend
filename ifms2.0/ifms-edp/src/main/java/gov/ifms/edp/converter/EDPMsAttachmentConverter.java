package gov.ifms.edp.converter;

import org.apache.commons.lang.BooleanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPMsAttachmentDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;

/**
 * The Class EDPMsAttachmentConverter.
 */
@Component
public class EDPMsAttachmentConverter implements BaseConverter<EDPMsAttachmentEntity, EDPMsAttachmentDto>{

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP ms attachment entity
	 */
	@Override
	public EDPMsAttachmentEntity toEntity(EDPMsAttachmentDto dto) {
		EDPMsAttachmentEntity entity = new EDPMsAttachmentEntity();
		if(null!=dto.getIsMandatory()) {
			entity.setIsMandatory(new EDPLuLookUpInfoEntity(dto.getIsMandatory()));
		}
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP ms attachment dto
	 */
	@Override
	public EDPMsAttachmentDto toDTO(EDPMsAttachmentEntity entity) {
		EDPMsAttachmentDto dto = new EDPMsAttachmentDto();
		if(null!=entity.getIsMandatory()) {
			dto.setIsMandatory(entity.getIsMandatory().getLookUpInfoId());
			dto.setMandatoryFlag(BooleanUtils.toBoolean(entity.getIsMandatory().getLookUpInfoValue()));
		}
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
