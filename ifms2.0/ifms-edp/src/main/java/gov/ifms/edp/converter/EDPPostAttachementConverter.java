package gov.ifms.edp.converter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPPostAttachmentDto;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPPostAttachmentEntity;
import gov.ifms.edp.entity.EDPPostAttachmentItrEntity;


/**
 * The Class EDPPostAttachementConverter.
 */
@Component
public class EDPPostAttachementConverter implements BaseConverter<EDPPostAttachmentEntity, EDPPostAttachmentDto> {


	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP post attachment entity
	 */
	@Override
	public EDPPostAttachmentEntity toEntity(EDPPostAttachmentDto dto) {
		EDPPostAttachmentEntity entity = new EDPPostAttachmentEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setAttachmentId(new EDPMsAttachmentEntity(dto.getAttachmentId()));
		if(0 !=dto.getPostId())
			entity.setPostId(new EDPMsPostEntity(dto.getPostId()));
		entity.setUploadedBy(new EDPMsUserEntity(dto.getUploadedBy()));
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP post attachment dto
	 */
	@Override
	public EDPPostAttachmentDto toDTO(EDPPostAttachmentEntity entity) {
		EDPPostAttachmentDto dto = new EDPPostAttachmentDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setPostId(entity.getPostId().getPostId());
		dto.setPostAttachmentId(entity.getPostAttactmentId());
		dto.setUploadedBy(entity.getUploadedBy().getUserId());
		dto.setUploadedByName(entity.getUploadedBy().getUserName());
		dto.setAttachmentId(entity.getAttachmentId().getAttachmentId());
		dto.setAttachmentName(entity.getAttachmentId().getAttachmentName());
		dto.setTransactionnumber(entity.getPostId().getTransactionNo());
		dto.setFile(null);
		return dto;
	}
	
	
	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the list
	 */
	@Override
	public List<EDPPostAttachmentDto> toDTO(List<EDPPostAttachmentEntity> entity) {
	return	entity.stream().map(postattchmententity->{
		EDPPostAttachmentDto dto = new EDPPostAttachmentDto();
		BeanUtils.copyProperties(postattchmententity, dto);
		dto.setPostId(postattchmententity.getPostId().getPostId());
		dto.setPostAttachmentId(postattchmententity.getPostAttactmentId());
		dto.setUploadedBy(postattchmententity.getUploadedBy().getUserId());
		dto.setUploadedByName(postattchmententity.getUploadedBy().getUserName());
		dto.setAttachmentId(postattchmententity.getAttachmentId().getAttachmentId());
		dto.setTransactionnumber(postattchmententity.getPostId().getTransactionNo());
		dto.setAttachmentName(postattchmententity.getAttachmentId().getAttachmentName());
		dto.setFile(null);
		return dto;
		}).collect(Collectors.toList());
	}

	/**
	 * Object to dto list.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPPostAttachmentDto> objectToDtoList(List<Object[]> list) {

		return list.stream().map(this::objectToDto).collect(Collectors.toList());

	}


	/**
	 * Object to dto.
	 *
	 * @param object the object
	 * @return the EDP post attachment dto
	 */
	public EDPPostAttachmentDto objectToDto(Object[] object) {
		EDPPostAttachmentDto attachmentDto = new EDPPostAttachmentDto();
		attachmentDto.setAttachmentName(object[0].toString());
		attachmentDto.setFileName(String.valueOf(object[1]));
		attachmentDto.setUploadedFileName(String.valueOf(object[2]));
		attachmentDto.setUploadedBy(object[3] != null ? Long.parseLong(object[3].toString()) : 0);
		attachmentDto.setPostAttachmentId(object[4] != null ? Long.parseLong(object[4].toString()) : 0);
		attachmentDto.setPostId(object[5] != null ? Long.parseLong(object[5].toString()) : 0);
		attachmentDto.setCreatedBy(object[6] != null ? Long.parseLong(object[6].toString()) : 0);
		attachmentDto.setCreatedByPost(object[7] != null ? Long.parseLong(object[7].toString()) : 0);
		attachmentDto.setCreatedDate(object[8] != null ? (Date) object[8] : null);
		attachmentDto.setUpdatedBy(object[9] != null ? Long.parseLong(object[9].toString()) : 0);
		attachmentDto.setUpdatedByPost(object[10] != null ? Long.parseLong(object[10].toString()) : 0);
		attachmentDto.setUpdatedDate(object[11] != null ? (Date) object[11] : null);
		attachmentDto.setVersionId(object[12] != null ? Integer.parseInt(object[13].toString()) : 0);
		attachmentDto.setUploadedFilePath(String.valueOf(object[13]));
		attachmentDto.setAttachmentId(object[14] != null ? Long.parseLong(object[14].toString()) : 0);
		return attachmentDto;
	}
	
	
	/**
	 * To entity.
	 *
	 * @param edpPostAttachmentEntity the edp post attachment entity
	 * @return the EDP post attachment itr entity
	 */
	public EDPPostAttachmentItrEntity toEntity(EDPPostAttachmentEntity edpPostAttachmentEntity) {
		EDPPostAttachmentItrEntity entity=new EDPPostAttachmentItrEntity();
		BeanUtils.copyProperties(edpPostAttachmentEntity, entity);
		entity.setPostAttactmentId(edpPostAttachmentEntity);
		entity.setPostId(edpPostAttachmentEntity.getPostId());
		entity.setAttachmentId(edpPostAttachmentEntity.getAttachmentId().getAttachmentId());
		return entity;
	}

}
