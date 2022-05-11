package gov.ifms.edp.converter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPTrnUserMpAttDto;
import gov.ifms.edp.employe.EDPEmployeRepository;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPTrnUserMpAttEntity;
import gov.ifms.edp.entity.EDPTrnUserMpAttItrEntity;
import gov.ifms.edp.entity.EDPtusrRgMapEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPTrnUserMpAttConverter.
 */
@Component
public class EDPTrnUserMpAttConverter implements BaseConverter<EDPTrnUserMpAttEntity, EDPTrnUserMpAttDto> {
	
	/** The employe repository. */
	@Autowired
	private EDPEmployeRepository employeRepository;
	
	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP trn user mp att entity
	 */
	@Override
	public EDPTrnUserMpAttEntity toEntity(EDPTrnUserMpAttDto dto) {
		EDPTrnUserMpAttEntity edpTrnUserMpAttEntity = new EDPTrnUserMpAttEntity();
		BeanUtils.copyProperties(dto, edpTrnUserMpAttEntity);
		edpTrnUserMpAttEntity.setUserRgMapId(new EDPtusrRgMapEntity(dto.getUserRgMapId()));
		edpTrnUserMpAttEntity.setRolePrmID(new EDPMsRolePermissionsEntity(1L));
		edpTrnUserMpAttEntity.setAttachmentId(new EDPMsAttachmentEntity(dto.getAttachmentId()));
		edpTrnUserMpAttEntity.setUploadFileName(dto.getFileName());
		edpTrnUserMpAttEntity.setUploadedBy(new EDPMsUserEntity(OAuthUtility.getCurrentUserUserId()));
		edpTrnUserMpAttEntity.setVersionId(0);
		edpTrnUserMpAttEntity.setWfId(1L);
		return edpTrnUserMpAttEntity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP trn user mp att dto
	 */
	@Override
	public EDPTrnUserMpAttDto toDTO(EDPTrnUserMpAttEntity entity) {
		EDPTrnUserMpAttDto dto = new EDPTrnUserMpAttDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setUserRgMapId(entity.getUserRgMapId().getTusrRgMapId());
		dto.setUploadedBy(entity.getUploadedBy().getUserId());
		dto.setUploadedByName(entity.getUploadedBy().getUserName());
		dto.setAttachmentId(entity.getAttachmentId().getAttachmentId());
		dto.setAttachmentName(entity.getAttachmentId().getAttachmentName());
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
	public List<EDPTrnUserMpAttDto> toDTO(List<EDPTrnUserMpAttEntity> entity) {
	return	entity.stream().map(edpUserMpEntity->{
		List<Object[]> employeeInfo = employeRepository.getEmployeeInfoForLogin(edpUserMpEntity.getUploadedBy().getUserCode());
		EDPTrnUserMpAttDto dto = new EDPTrnUserMpAttDto();
		BeanUtils.copyProperties(edpUserMpEntity, dto);
		dto.setUserRgMapId(edpUserMpEntity.getUserRgMapId().getTusrRgMapId());
		dto.setRolePrmID(edpUserMpEntity.getRolePrmID().getRoleActivityId());
		dto.setUserRgMpAttrId(edpUserMpEntity.getUserRgMpAttrId());
		dto.setUploadedBy(edpUserMpEntity.getUploadedBy().getUserId());
		dto.setUploadedByName(EDPUtility.getEmployeeNameFromEmployeeInfo(employeeInfo));
		dto.setAttachmentId(edpUserMpEntity.getAttachmentId().getAttachmentId());
		dto.setAttachmentName(edpUserMpEntity.getAttachmentId().getAttachmentName());
		dto.setUploadFileSize(edpUserMpEntity.getUploadFileSize());
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
	public List<EDPTrnUserMpAttDto> objectToDtoList(List<Object[]> list) {

		return list.stream().map(this::objectToDto).collect(Collectors.toList());

	}


	/**
	 * Object to dto.
	 *
	 * @param object the object
	 * @return the EDP post attachment dto
	 */
	public EDPTrnUserMpAttDto objectToDto(Object[] object) {
		EDPTrnUserMpAttDto attachmentDto = new EDPTrnUserMpAttDto();
		attachmentDto.setFileName(String.valueOf(object[1]));
		attachmentDto.setUploadFileName(String.valueOf(object[2]));
		attachmentDto.setUploadedBy(object[3] != null ? Long.parseLong(object[3].toString()) : 0);
		attachmentDto.setUserRgMpAttrId(object[4] != null ? Long.parseLong(object[4].toString()) : 0);
		attachmentDto.setUserRgMapId(object[5] != null ? Long.parseLong(object[5].toString()) : 0);
		attachmentDto.setCreatedBy(object[6] != null ? Long.parseLong(object[6].toString()) : 0);
		attachmentDto.setCreatedByPost(object[7] != null ? Long.parseLong(object[7].toString()) : 0);
		attachmentDto.setCreatedDate(object[8] != null ? (Date) object[8] : null);
		attachmentDto.setUpdatedBy(object[9] != null ? Long.parseLong(object[9].toString()) : 0);
		attachmentDto.setUpdatedByPost(object[10] != null ? Long.parseLong(object[10].toString()) : 0);
		attachmentDto.setUpdatedDate(object[11] != null ? (Date) object[11] : null);
		attachmentDto.setVersionId(object[12] != null ? Integer.parseInt(object[13].toString()) : 0);
		attachmentDto.setUploadFilePath(String.valueOf(object[13]));
		attachmentDto.setAttachmentId(object[14] != null ? Long.parseLong(object[14].toString()) : 0);
		return attachmentDto;
	}
	
	
	/**
	 * To entity.
	 *
	 * @param edpPostAttachmentEntity the edp post attachment entity
	 * @return the EDP trn user mp att itr entity
	 */
	public EDPTrnUserMpAttItrEntity toEntity(EDPTrnUserMpAttEntity edpPostAttachmentEntity) {
		EDPTrnUserMpAttItrEntity entity=new EDPTrnUserMpAttItrEntity();
		BeanUtils.copyProperties(edpPostAttachmentEntity, entity);
		entity.setUsrRgMpattrId(new EDPTrnUserMpAttEntity(edpPostAttachmentEntity.getUserRgMpAttrId()));
		entity.setAttachmentId(edpPostAttachmentEntity.getAttachmentId().getAttachmentId());
		entity.setUploadFileName(edpPostAttachmentEntity.getUploadFileName());
		return entity;
	}
}