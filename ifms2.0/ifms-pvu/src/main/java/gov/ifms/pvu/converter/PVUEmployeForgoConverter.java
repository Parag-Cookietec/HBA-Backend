package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.attachment.dto.FileUploadResponseDto;
import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsAttachmentEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;
import gov.ifms.pvu.dto.PVUCommonAttachmentsDto;
import gov.ifms.pvu.dto.PVUEmployeForgoDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeForgoEntity;
import gov.ifms.pvu.entity.PVUForgoAttachmentEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;

/**
 * The Class PVUForgoEventConverter class.
 */
@Component
public class PVUEmployeForgoConverter implements BaseConverter<PVUEmployeForgoEntity, PVUEmployeForgoDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUForgoEvent entity
	 */
	@Override
	public PVUEmployeForgoEntity toEntity(PVUEmployeForgoDto dto) {
		PVUEmployeForgoEntity entity = new PVUEmployeForgoEntity();

		BeanUtils.copyProperties(dto, entity);
		if (dto.getOfficeId() != 0)
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		if (dto.getPayCommId() != 0)
			entity.setPayComm(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		if (dto.getStatus() != 0)
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatus()));
		if (dto.getEmployeeId() != 0)
			entity.setEmpId(new PVUEmployeEntity(dto.getEmployeeId()));
		if (dto.getDesignationId() != 0)
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		if (dto.getEmployeeClassId() != 0)
			entity.setEmpClass(new EDPLuLookUpInfoEntity(dto.getEmployeeClassId()));
		if (dto.getEmpEvent() != 0)
			entity.setEmpEvent(new EDPLuLookUpInfoEntity(dto.getEmpEvent()));
		if (dto.getPayLevelId() != 0)
			entity.setPayLevel(new PVUMsPayLevelEntity(dto.getPayLevelId()));
		if (dto.getCellId() != 0)
			entity.setCellId(new PVUMsPayCellEntity(dto.getCellId()));
		if (dto.getPayBandId() != 0)
			entity.setPayBand(new PVUMsPayBandEntity(dto.getPayBandId()));
		if (dto.getGradePayId() != 0)
			entity.setGradePay(new PVUMsGradePayEntity(dto.getGradePayId()));
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUForgoEvent dto
	 */
	@Override
	public PVUEmployeForgoDto toDTO(PVUEmployeForgoEntity entity) {
		PVUEmployeForgoDto dto = new PVUEmployeForgoDto();
		BeanUtils.copyProperties(entity, dto);
		if (entity.getOfficeId() != null)
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
		if (entity.getPayComm() != null)
			dto.setPayCommId(entity.getPayComm().getLookUpInfoId());
		if (entity.getStatusId() != null)
			dto.setStatus(entity.getStatusId().getLookUpInfoId());
		if (entity.getDesignationId() != null)
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
		if (entity.getEmpId() != null)
			dto.setEmployeeId(entity.getEmpId().getEmpId());

		if (entity.getEmpId() != null && entity.getEmpId().getEmployeeCode() != null)
			dto.setEmployeeNo(entity.getEmpId().getEmployeeCode());

		if (entity.getEmpClass() != null)
			dto.setEmployeeClassId(entity.getEmpClass().getLookUpInfoId());
		if (entity.getEmpEvent() != null)
			dto.setEmpEvent(entity.getEmpEvent().getLookUpInfoId());
		if (entity.getPayLevel() != null)
			dto.setPayLevelId(entity.getPayLevel().getId());
		if (entity.getCellId() != null)
			dto.setCellId(entity.getCellId().getId());
		if (entity.getPayBand() != null)
			dto.setPayBandId(entity.getPayBand().getId());
		if (entity.getGradePay() != null)
			dto.setGradePayId(entity.getGradePay().getId());
		return dto;
	}

	/**
	 * Prepare attachment entity.
	 *
	 * @param dto          the event dto
	 * @param fileResponse the file response
	 * @return the PVU cs attachments entity
	 */
	public PVUForgoAttachmentEntity prepareAttachmentEntity(PVUCommonAttachmentsDto dto,
			FileUploadResponseDto fileResponse) {
		PVUForgoAttachmentEntity attachmentEntity = new PVUForgoAttachmentEntity();
		if (!Utils.isEmpty(fileResponse)) {
			if (!Utils.isEmpty(fileResponse.getDocumentId())) {
				attachmentEntity.setUploadedFilePath(fileResponse.getDocumentId());
			}
			if (!Utils.isEmpty(fileResponse.getFilename())) {
				attachmentEntity.setUploadedFileName(fileResponse.getFilename());
				attachmentEntity.setFileName(fileResponse.getFilename());
			}

			attachmentEntity.setActiveStatus(1);
			EDPMsRolePermissionsEntity roleid = new EDPMsRolePermissionsEntity();
			roleid.setRoleActivityId(1L);
			attachmentEntity.setRoleId(roleid);
			attachmentEntity.setAttachId(new EDPMsAttachmentEntity(dto.getFileAttachment().get(0).getAttTypeId().getId()));
			attachmentEntity.setEventId(new PVUEmployeForgoEntity(dto.getId()));
			attachmentEntity.setCreatedBy(dto.getCreatedBy());
			attachmentEntity.setCreatedByPost(dto.getCreatedByPost());
			attachmentEntity.setCreatedDate(dto.getCreatedDate());
			attachmentEntity.setUpdatedBy(dto.getUpdatedBy());
			attachmentEntity.setUpdatedByPost(dto.getUpdatedByPost());
			attachmentEntity.setUpdatedDate(dto.getUpdatedDate());
		}
		return attachmentEntity;
	}
}