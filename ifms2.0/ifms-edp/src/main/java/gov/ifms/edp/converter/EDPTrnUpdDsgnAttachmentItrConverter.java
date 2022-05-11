package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPTrnUpdDsgnAttachmentItrDto;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnAttachmentEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnAttachmentItrEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnEntity;

/**
 * The Class EDPTrnUpdDsgnAttachmentItrConverter.
 */
@Component
public class EDPTrnUpdDsgnAttachmentItrConverter implements BaseConverter<EDPTrnUpdDsgnAttachmentItrEntity,EDPTrnUpdDsgnAttachmentItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP trn upd dsgn attachment entity
	 */
	@Override
	public EDPTrnUpdDsgnAttachmentItrEntity toEntity(EDPTrnUpdDsgnAttachmentItrDto dto) {
		EDPTrnUpdDsgnAttachmentItrEntity entity = new EDPTrnUpdDsgnAttachmentItrEntity();
		entity.setTedpUpdDsgnAttId(new EDPTrnUpdDsgnAttachmentEntity(dto.getTrnUpdDsgnEntity()));
		entity.setTedpUpdDsgnId(new EDPTrnUpdDsgnEntity(dto.getTrnUpdDsgnEntity()));
		entity.setAttachmentId(new EDPMsAttachmentEntity(dto.getAttachmentId()));
		entity.setUploadedBy(new EDPMsUserEntity(dto.getUploadedBy()));
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
	public EDPTrnUpdDsgnAttachmentItrDto toDTO(EDPTrnUpdDsgnAttachmentItrEntity entity) {
		EDPTrnUpdDsgnAttachmentItrDto dto = new EDPTrnUpdDsgnAttachmentItrDto();
		dto.setUploadedBy(entity.getUploadedBy().getUserId());
		dto.setAttachmentId(entity.getAttachmentId().getAttachmentId());
		BeanUtils.copyProperties(entity,dto);
		return dto;
	}
	
	/**
	 * Upd dsgn attachment to itr.
	 *
	 * @param entity the entity
	 * @return the EDP trn upd dsgn attachment itr entity
	 */
	public EDPTrnUpdDsgnAttachmentItrEntity updDsgnAttachmentToItr(
			EDPTrnUpdDsgnAttachmentEntity entity){
		EDPTrnUpdDsgnAttachmentItrEntity itrEntity = new EDPTrnUpdDsgnAttachmentItrEntity();
		BeanUtils.copyProperties(entity,itrEntity);
		itrEntity.setTedpUpdDsgnAttId(entity);
		itrEntity.setTedpUpdDsgnId(entity.getTrnUpdDsgnEntity());
		return itrEntity;
		
	}
	
	/**
	 * Upd dsgn attachment to itr.
	 *
	 * @param entityList the entity list
	 * @return the list
	 */
	public List<EDPTrnUpdDsgnAttachmentItrEntity> updDsgnAttachmentToItr(
			List<EDPTrnUpdDsgnAttachmentEntity> entityList) {
		return entityList.stream().map(this::updDsgnAttachmentToItr).collect(Collectors.toList());
	}

}
