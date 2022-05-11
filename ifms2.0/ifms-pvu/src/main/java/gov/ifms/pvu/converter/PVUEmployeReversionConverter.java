package gov.ifms.pvu.converter;

import java.util.Date;

import org.apache.velocity.VelocityContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.attachment.dto.FileUploadResponseDto;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;
import gov.ifms.pvu.dto.PVUCommonAttachmentsDto;
import gov.ifms.pvu.dto.PVUEmployeReversionDto;
import gov.ifms.pvu.entity.PVUCareerAdvanceAttachmentsEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeReversionEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.entity.PVUReversionAttachmentEntity;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;


/**
 * The Class PVUEmployeReversionEventConverter class.
 */
@Component
public class PVUEmployeReversionConverter extends BasePVUPfConverter<PVUEmployeReversionEntity, PVUEmployeReversionDto>
{

	@Override
	PVUEmployeReversionEntity createEntity() {
		return new PVUEmployeReversionEntity();
	}

	@Override
	PVUEmployeReversionDto createDTO() {
		return new PVUEmployeReversionDto();
	}
	
	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeReversionEvent entity
	 */
	@Override
	public PVUEmployeReversionEntity toEntity(PVUEmployeReversionDto dto) {
		PVUEmployeReversionEntity entity = this.toCurrentDetailsEntity(dto);
		BeanUtils.copyProperties(dto, entity);
		if (dto.getOfficeId() != 0)
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		if (dto.getStatusId() != 0)
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		if (dto.getPayCommId() != 0)
			entity.setPayComm(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		if (dto.getDesignationId() != 0)
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		if (dto.getEmployeeId() != 0)
			entity.setEmployee(new PVUEmployeEntity(dto.getEmployeeId()));
		if (dto.getEmployeeClassId() != 0)
			entity.setEmpClass(new EDPLuLookUpInfoEntity(dto.getEmployeeClassId()));
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
	 * @return the PVUEmployeReversionEvent dto
	 */
	@Override
	public PVUEmployeReversionDto toDTO(PVUEmployeReversionEntity entity) {
		PVUEmployeReversionDto dto = this.toCurrentDTO(entity);
		BeanUtils.copyProperties(entity, dto);
		if (entity.getOfficeId() != null)
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
		if (entity.getPayComm() != null)
			dto.setPayCommId(entity.getPayComm().getLookUpInfoId());
		if (entity.getStatusId() != null)
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		if (entity.getDesignationId() != null)
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
		if (entity.getEmployee() != null) {
			dto.setEmployeeId(entity.getEmployee().getEmpId());
		}
		if (entity.getEmployee() != null && entity.getEmployee().getEmployeeCode() != null) {
			dto.setEmployeeNo(entity.getEmployee().getEmployeeCode());
		}
		if (entity.getEmpClass() != null)
			dto.setEmployeeClassId(entity.getEmpClass().getLookUpInfoId());
		if (entity.getPayLevel() != null)
			dto.setPayLevelId(entity.getPayLevel().getId());
		if (entity.getCellId() != null)
			dto.setCellId(entity.getCellId().getId());
		if (entity.getPayBand() != null)
			dto.setPayBandId(entity.getPayBand().getId());
		if (entity.getGradePay() != null)
			dto.setGradePayId(entity.getGradePay().getId());
		dto.setCreatedDate(new Date());

		return dto;
	}

	/**
	 * Prepare attachment entity.
	 *
	 * @param dto          the event dto
	 * @param fileResponse the file response
	 * @return the PVU cs attachments entity
	 */
	public PVUReversionAttachmentEntity prepareAttachmentEntity(PVUCommonAttachmentsDto dto,
			FileUploadResponseDto fileResponse) {
		PVUReversionAttachmentEntity attachmentEntity = new PVUReversionAttachmentEntity();
		if (!Utils.isEmpty(fileResponse)) {
			
			if (!Utils.isEmpty(fileResponse.getFilename())) {
				attachmentEntity.setFileName(fileResponse.getFilename());
			}

			attachmentEntity.setActiveStatus(1);
			EDPMsRolePermissionsEntity roleid = new EDPMsRolePermissionsEntity();
			roleid.setRoleActivityId(1L);
			attachmentEntity.setCreatedBy(dto.getCreatedBy());
			attachmentEntity.setCreatedByPost(dto.getCreatedByPost());
			attachmentEntity.setCreatedDate(dto.getCreatedDate());
			attachmentEntity.setUpdatedBy(dto.getUpdatedBy());
			attachmentEntity.setUpdatedByPost(dto.getUpdatedByPost());
			attachmentEntity.setUpdatedDate(dto.getUpdatedDate());
		}
		return attachmentEntity;
	}
	public PVUCommonAttachmentsDto toAttachmentDTO(PVUCareerAdvanceAttachmentsEntity entity) {
		PVUCommonAttachmentsDto dto = new PVUCommonAttachmentsDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public PVUEmployeReversionEntity toEntityWithDto(PVUEmployeReversionEntity entity, PVUEmployeReversionDto dto) {
		BeanUtils.copyProperties(dto, entity);
		if (dto.getOfficeId() != 0)
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		if (dto.getStatusId() != 0)
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		if (dto.getPayCommId() != 0)
			entity.setPayComm(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		if (dto.getDesignationId() != 0)
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		if (dto.getEmployeeId() != 0)
			entity.setEmployee(new PVUEmployeEntity(dto.getEmployeeId()));
		if (dto.getEmployeeClassId() != 0)
			entity.setEmpClass(new EDPLuLookUpInfoEntity(dto.getEmployeeClassId()));
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

	 public VelocityContext populateVContext(PVUEmployeReversionEntity entity) {
			VelocityContext context = new VelocityContext();
			
			context.put("EVENT_NAME",PvuConstant.EVENT_NAME_REVERSION );
			context.put("OFFICE_NAME", entity.getOfficeId().getOfficeName());
			context.put("OFFICE_ADDRESS", entity.getOfficeId().getAddrLine1());
			context.put("TRANSACION_NO", entity.getTrnNo());
			context.put("TRANSACION_DATE", Utils.getDateString(entity.getUpdatedDate()));
			context.put("ORDER_NO", entity.getEventOrderNo());
			context.put("DESIGNATION", entity.getDesignationId().getDesignationName());
			context.put("EMPLOYEE_NO", entity.getEmployee().getEmployeeCode());
			context.put("BASIC_PAY", entity.getBasicPay());

			if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
				context.put("CURRENT_PAY_LEVEL", entity.getcPayLevel().getPayLevelValue());
				context.put("PAY_LEVEL", entity.getPayLevel().getPayLevelValue());
				context.put("CURRENT_CELL_ID", entity.getcCell().getCellId());
				context.put("CELL_ID", entity.getCellId().getCellId());

				context.put("CURRENT_PAY_RANGE", entity.getcPayLevel().getPayLevelValue());// need to change
				context.put("PAY_RANGE", entity.getEmployee().getEmployeeCode());// need to change
				
				context.put("CURRENT_PAY_IN_LEVEL", entity.getcPayLevel().getPayLevelValue());// need to change
				context.put("PAY_IN_LEVEL", entity.getcPayLevel().getPayLevelValue());// need to change

			}else if(entity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
				
				context.put("CURRENT_PAY_BAND", entity.getcPayBand().getPayBandDispVal());
				context.put("PAY_BAND", entity.getPayBand().getPayBandDispVal());

				context.put("CURRENT_PAY_BAND_VALUE", entity.getcPayBandValue());
				context.put("PAY_BAND_VALUE", entity.getPayBandValue());

				context.put("CURRENT_GRADE_PAY", entity.getcGradePay().getGradePayValue());
				context.put("GRADE_PAY", entity.getGradePay().getGradePayValue());

				context.put("CURRENT_BASIC_PAY", entity.getcBasicPay());

			}else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
				context.put("CURRENT_PAYSCALE", entity.getcPayScale().getScaleValue());
				context.put("CURRENT_BASIC_PAY", entity.getcBasicPay());
			}
			context.put("CURRENT_DNI",PvuUtils.getStrOfLocalDateInDDMMYYYY( entity.getDateOfNextIncrement()));
			context.put("DNI",PvuUtils.getStrOfLocalDateInDDMMYYYY( entity.getcDateOfNextIncrement()));
			context.put("EVENT_EFFECTIVE_DATE", PvuUtils.getStrOfLocalDateInDDMMYYYY( entity.getEventEffectiveDate()));

			String srSaluation="";
			if(!Utils.isEmpty(entity.getEmployee().getSalutation()) ) {
				srSaluation=entity.getEmployee().getSalutation().getLookUpInfoName();
			}

			context.put("EMPLOYEE_NAME", srSaluation +" "+entity.getEmployee().getEmployeeName()+" "+
					entity.getEmployee().getEmployeeMiddleName()+" "+entity.getEmployee().getEmployeeSurname());


			return context;
			
		}
	 
	private PVUEmployeReversionDto toCurrentDTO(PVUEmployeReversionEntity entity) {
		PVUEmployeReversionDto dto = new PVUEmployeReversionDto();
		dto.setcBasicPay(entity.getcBasicPay());
		dto.setcDateOfNextIncrement(entity.getcDateOfNextIncrement());
		dto.setcDateOfJoining(entity.getcDateOfJoining());
		dto.setcDateOfRetirement(entity.getcDateOfRetirement());
		dto.setcPayBandValue(entity.getcPayBandValue());
		dto.setCurrentDetailsEventId(entity.getCurrentDetailsEventId());
		extractedEmployee(entity, dto);
		clsDegoffMix(entity, dto);
		currentSix(entity, dto);
		currentSeven(entity, dto);
		if (Utils.isNonEmpty(entity.getcPayScale())) {
			dto.setcPayScaleId(entity.getcPayScale().getPayScaleId());
			if (Utils.isNonEmpty(entity.getcPayScale().getPayScaleDispVal())) {
				dto.setcPayScaleName(entity.getcPayScale().getPayScaleDispVal());
			}
		}
		return dto;
	}

	private void clsDegoffMix(PVUEmployeReversionEntity entity, PVUEmployeReversionDto dto) {
		if (Utils.isNonEmpty(entity.getcClass())) {
			dto.setcClassId(entity.getcClass().getLookUpInfoId());
			if (Utils.isNonEmpty(entity.getcClass().getLookUpInfoName())) {
				dto.setcClassName(entity.getcClass().getLookUpInfoName());
			}
		}

		if (Utils.isNonEmpty(entity.getcDesignation())) {
			dto.setcDesignationId(entity.getcDesignation().getDesignationId());
			if (Utils.isNonEmpty(entity.getcDesignation().getDesignationName())) {
				dto.setcDesignationName(entity.getcDesignation().getDesignationName());
			}
		}

		if (Utils.isNonEmpty(entity.getcOfficeId())) {
			dto.setcOfficeId(entity.getcOfficeId().getOfficeId());
			if (Utils.isNonEmpty(entity.getcOfficeId().getOfficeId())) {
				dto.setcOfficeName(entity.getcOfficeId().getOfficeName());
			}
		}
	}

	private void currentSix(PVUEmployeReversionEntity entity, PVUEmployeReversionDto dto) {
		if (Utils.isNonEmpty(entity.getcGradePay())) {
			dto.setcGradePayId(entity.getcGradePay().getId());
			if (Utils.isNonEmpty(entity.getcGradePay().getGradePayValue())) {
				dto.setcGradePayName(entity.getcGradePay().getGradePayValue());
			}
		}
		if (Utils.isNonEmpty(entity.getcPayBand())) {
			dto.setcPayBandId(entity.getcPayBand().getId());
			if (Utils.isNonEmpty(entity.getcPayBand().getPayBandDispVal())) {
				dto.setcPayBandName(entity.getcPayBand().getPayBandDispVal());
			}
		}
	}

	private void currentSeven(PVUEmployeReversionEntity entity, PVUEmployeReversionDto dto) {
		if (Utils.isNonEmpty(entity.getcPayLevel())) {
			dto.setcPayLevelId(entity.getcPayLevel().getId());
			if (Utils.isNonEmpty(entity.getcPayLevel().getId())) {
				dto.setcPayLevelName(entity.getcPayLevel().getPayLevelValue());
			}
		}

		if (Utils.isNonEmpty(entity.getcCell())) {
			dto.setcCellId(entity.getcCell().getId());
			if (Utils.isNonEmpty(entity.getcCell().getCellId())) {
				dto.setcCellName(entity.getcCell().getCellId());
			}
		}
	}

	private void extractedEmployee(PVUEmployeReversionEntity entity, PVUEmployeReversionDto dto) {
		StringBuilder sb = new StringBuilder();
		String srSaluation = "";
		if (Utils.isNonEmpty(entity.getEmployee())) {
			if (!Utils.isEmpty(entity.getEmployee().getSalutation())) {
				srSaluation = entity.getEmployee().getSalutation().getLookUpInfoName();
				sb.append(srSaluation);
			}
			if (Utils.isNonEmpty(entity.getEmployee().getEmployeeName())) {
				sb.append(" ");
				sb.append(entity.getEmployee().getEmployeeName());
			}
			if (Utils.isNonEmpty(entity.getEmployee().getEmployeeMiddleName())) {
				sb.append(" ");
				sb.append(entity.getEmployee().getEmployeeMiddleName());
			}
			if (Utils.isNonEmpty(entity.getEmployee().getEmployeeSurname())) {
				sb.append(" ");
				sb.append(entity.getEmployee().getEmployeeSurname());
			}
			dto.setcEmployeeName(PvuUtils.concatName(sb.toString()));
		}
	}
	 
	 
}
