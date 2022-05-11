package gov.ifms.pvu.converter;

import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.dto.PVUCsEventDView;
import gov.ifms.pvu.dto.PVUCsEventDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.entity.PVUCsEventEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUMsEventEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUCsEventConverter class.
 */
@Component
public class PVUCsEventConverter extends BasePVUPfConverter<PVUCsEventEntity, PVUCsEventDto> {

	@Override
	PVUCsEventEntity createEntity() {
		return new PVUCsEventEntity();
	}

	@Override
	PVUCsEventDto createDTO() {
		return new PVUCsEventDto();
	}

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUCsEvent entity
	 */
	@Override
	public PVUCsEventEntity toEntity(PVUCsEventDto dto) {
		PVUCsEventEntity entity = this.toCurrentDetailsEntity(dto);
		BeanUtils.copyProperties(dto, entity);
		if (!Utils.isEmpty(dto.getOfficeId())) {
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		}

		if (!Utils.isEmpty(dto.getEventOrderNo())) {
			entity.setEventOrderNo(dto.getEventOrderNo());
		}

		if (!Utils.isEmpty(dto.getTrnNo())) {
			entity.setTrnNo(dto.getTrnNo());
		}

		if (!Utils.isEmpty(dto.getStatusId())) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}

		if (!Utils.isEmpty(dto.getBasicPay())) {
			entity.setBasicPay(dto.getBasicPay());
		}

		if (!Utils.isEmpty(dto.getEmployeeId())) {
			entity.setEmployee(new PVUEmployeEntity(dto.getEmployeeId()));
		}

		if (!Utils.isEmpty(dto.getGradePayId())) {
			entity.setGradePay(new PVUMsGradePayEntity(dto.getGradePayId()));
		}

		if (!Utils.isEmpty(dto.getPayBandId())) {
			entity.setPayBand(new PVUMsPayBandEntity(dto.getPayBandId()));
		}

		if (!Utils.isEmpty(dto.getPayBandValue())) {
			entity.setPayBandValue(dto.getPayBandValue());
		}

		if (!Utils.isEmpty(dto.getCellId())) {
			entity.setCellId(new PVUMsPayCellEntity(dto.getCellId()));
		}

		if (!Utils.isEmpty(dto.getPayLevelId())) {
			entity.setPayLevel(new PVUMsPayLevelEntity(dto.getPayLevelId()));
		}

		if (!Utils.isEmpty(dto.getPayScale())) {
			entity.setScale(new PVUMsPayScaleEntity(dto.getPayScale()));
		}

		if (!Utils.isEmpty(dto.getPayCommId())) {
			entity.setPayCommission(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		}

		if (!Utils.isEmpty(dto.getEventId())) {
			entity.setEventId(new PVUMsEventEntity(dto.getEventId()));
		}

		return toEntityCurrentDetails(dto, entity);
	}

	public PVUCsEventEntity toEntityCurrentDetails(PVUCsEventDto dto, PVUCsEventEntity entity) {

		if (dto.getDuration() != null && dto.getDuration() != 0) {
			entity.setNotionalDuration(dto.getDuration());
		}

		if (!Utils.isEmpty(dto.getcPayScale())) {
			entity.setcPayScale(new PVUMsPayScaleEntity(dto.getcPayScale()));
		}

		if (!Utils.isEmpty(dto.getAuditorRemarks())) {
			entity.setAuditorRemarks(dto.getAuditorRemarks());
		}

		if (!Utils.isEmpty(dto.getVerifierRemarks())) {
			entity.setVerifierRemarks(dto.getVerifierRemarks());
		}

		if (!Utils.isEmpty(dto.getcDateOfRetiremnet())) {
			entity.setcDateOfRetirement(dto.getcDateOfRetiremnet());
		}

		return toEntityCurrentDetail(dto, entity);
	}

	public PVUCsEventEntity toEntityCurrentDetail(PVUCsEventDto dto, PVUCsEventEntity entity) {
		if (!Utils.isEmpty(dto.getClassTwoRemarks())) {
			entity.setClassTwoRemarks(dto.getClassTwoRemarks());
		}

		if (!Utils.isEmpty(dto.getClassOneRemarks())) {
			entity.setClassOneRemarks(dto.getClassOneRemarks());
		}

		if (!Utils.isEmpty(dto.getPrintRemarks())) {
			entity.setPrintRemarks(dto.getPrintRemarks());
		}

		if (!Utils.isEmpty(dto.getAuditorReturnReason())) {
			entity.setAuditorReturnReason(dto.getAuditorReturnReason());
		}

		if (!Utils.isEmpty(dto.getVerifierReturnReason())) {
			entity.setVerifierReturnReason(dto.getVerifierReturnReason());
		}

		if (!Utils.isEmpty(dto.getClassTwoReturnReason())) {
			entity.setClassTwoReturnReason(dto.getClassTwoReturnReason());
		}

		if (!Utils.isEmpty(dto.getClassOneReturnReason())) {
			entity.setClassOneReturnReason(dto.getClassOneReturnReason());
		}

		if (!Utils.isEmpty(dto.getPrintReturnReason())) {
			entity.setPrintReturnReason(dto.getPrintReturnReason());
		}

		if (!Utils.isEmpty(dto.getPrintCount())) {
			entity.setPrintCount(dto.getPrintCount());
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUCsEvent dto
	 */
	@Override
	public PVUCsEventDto toDTO(PVUCsEventEntity entity) {
		PVUCsEventDto dto = this.toCurrentDetailsDTO(entity);
		BeanUtils.copyProperties(entity, dto);
		if (!Utils.isEmpty(entity.getOfficeId())) {
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
		}

		if (!Utils.isEmpty(entity.getEventOrderNo())) {
			dto.setEventOrderNo(entity.getEventOrderNo());
		}

		if (!Utils.isEmpty(entity.getTrnNo())) {
			dto.setTrnNo(entity.getTrnNo());
		}

		if (!Utils.isEmpty(entity.getStatusId())) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getBasicPay())) {
			dto.setBasicPay(entity.getBasicPay());
		}

		if (entity.getEmployee() != null) {
			dto.setEmployeeId(entity.getEmployee().getEmpId());
			if (entity.getEmployee() != null && entity.getEmployee().getEmployeeCode() != null) {
				dto.setEmployeeNo(entity.getEmployee().getEmployeeCode());
			}
		}

		if (!Utils.isEmpty(entity.getGradePay())) {
			dto.setGradePayId(entity.getGradePay().getId());
		}

		if (!Utils.isEmpty(entity.getPayBand())) {
			dto.setPayBandId(entity.getPayBand().getId());
		}

		if (!Utils.isEmpty(entity.getPayBandValue())) {
			dto.setPayBandValue(entity.getPayBandValue());
		}

		if (!Utils.isEmpty(entity.getPayLevel())) {
			dto.setPayLevelId(entity.getPayLevel().getId());
		}

		if (!Utils.isEmpty(entity.getCellId())) {
			dto.setCellId(entity.getCellId().getId());
		}

		if (!Utils.isEmpty(entity.getScale())) {
			dto.setPayScale(entity.getScale().getPayScaleId());
		}

		return toSubDTO(entity, dto);
	}

	public PVUCsEventDto toSubDTO(PVUCsEventEntity entity, PVUCsEventDto dto) {

		if (!Utils.isEmpty(entity.getEventId())) {
			dto.setEventId(entity.getEventId().getId());
		}
		if (!Utils.isEmpty(entity.getEventId())
				&& entity.getEventId().getId() == PvuConstant.CHANGE_OF_SCALE_EVENT_ID) {
			dto.setEventCode(PvuConstant.EVENT_CODE_CHANGE_OF_SCALE);
		}
		if (!Utils.isEmpty(entity.getEventId())
				&& entity.getEventId().getId() == PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID) {
			dto.setEventCode(PvuConstant.EVENT_CODE_CHANGE_OF_SCALE_PVU);
		}

		if (!Utils.isEmpty(entity.getPayCommission())) {
			dto.setPayCommId(entity.getPayCommission().getLookUpInfoId());
		}

		dto.setDuration(entity.getNotionalDuration());

		if (!Utils.isEmpty(entity.getcPayScale())) {
			dto.setcPayScale(entity.getcPayScale().getPayScaleId());
		}

		return toSubDTOs(entity, dto);

	}

	public PVUCsEventDto toSubDTOs(PVUCsEventEntity entity, PVUCsEventDto dto) {

		if (!Utils.isEmpty(entity.getOfficeId())) {
			dto.setcOfficeName(entity.getOfficeId().getOfficeName());
		}

		if (!Utils.isEmpty(entity.getAuditorRemarks())) {
			dto.setAuditorRemarks(dto.getAuditorRemarks());
		}

		if (!Utils.isEmpty(entity.getVerifierRemarks())) {
			dto.setVerifierRemarks(dto.getVerifierRemarks());
		}

		if (!Utils.isEmpty(entity.getClassTwoRemarks())) {
			dto.setClassTwoRemarks(dto.getClassTwoRemarks());
		}

		return toPVUSubDTO(entity, dto);

	}

	public PVUCsEventDto toPVUSubDTO(PVUCsEventEntity entity, PVUCsEventDto dto) {

		if (!Utils.isEmpty(entity.getClassOneRemarks())) {
			dto.setClassOneRemarks(dto.getClassOneRemarks());
		}

		if (!Utils.isEmpty(entity.getPrintRemarks())) {
			dto.setPrintRemarks(dto.getPrintRemarks());
		}

		if (!Utils.isEmpty(entity.getAuditorReturnReason())) {
			dto.setAuditorReturnReason(dto.getAuditorReturnReason());
		}

		if (!Utils.isEmpty(entity.getVerifierReturnReason())) {
			dto.setVerifierReturnReason(dto.getVerifierReturnReason());
		}

		if (!Utils.isEmpty(entity.getClassTwoReturnReason())) {
			dto.setClassTwoReturnReason(dto.getClassTwoReturnReason());
		}

		if (!Utils.isEmpty(entity.getClassOneReturnReason())) {
			dto.setClassOneReturnReason(dto.getClassOneReturnReason());
		}

		if (!Utils.isEmpty(entity.getPrintReturnReason())) {
			dto.setPrintReturnReason(dto.getPrintReturnReason());
		}

		if (!Utils.isEmpty(entity.getPrintCount())) {
			dto.setPrintCount(dto.getPrintCount());
		}
		return dto;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUCsEvent dto
	 */
	public PVUCsEventDView toPVUDTO(PVUCsEventEntity entity) {
		PVUCsEventDView dto = new PVUCsEventDView();
		BeanUtils.copyProperties(entity, dto);
		if (!Utils.isEmpty(entity.getOfficeId())) {
			dto.setOfficeId(entity.getOfficeId().getOfficeName());
		}

		if (!Utils.isEmpty(entity.getEventOrderNo())) {
			dto.setEventOrderNo(entity.getEventOrderNo());
		}

		if (!Utils.isEmpty(entity.getEventEffectiveDate())) {
			dto.setBenefitEffectiveDate(entity.getEventEffectiveDate());
		}

		if (entity.getEmployee() != null) {
			dto.setEmployeeId(Long.toString(entity.getEmployee().getEmpId()));
			if (entity.getEmployee() != null && entity.getEmployee().getEmployeeCode() != null) {
				dto.setEmployeeNo(Long.toString(entity.getEmployee().getEmployeeCode()));
			}
		}

		if (!Utils.isEmpty(entity.getTrnNo())) {
			dto.setTrnNo(entity.getTrnNo());
		}

		if (!Utils.isEmpty(entity.getBasicPay())) {
			dto.setBasicPay(entity.getBasicPay());
		}

		if (!Utils.isEmpty(entity.getGradePay()) && entity.getGradePay().getGradePayValue() != null) {
			dto.setGradePayId(entity.getGradePay().getGradePayValue());
		}

		if (!Utils.isEmpty(entity.getPayBand()) && entity.getPayBand().getPayBandDispVal() != null) {
			dto.setPayBandId(entity.getPayBand().getPayBandDispVal());
		}

		if (!Utils.isEmpty(entity.getPayBandValue())) {
			dto.setPayBandValue(entity.getPayBandValue());
		}
		return toPVUDTOOne(entity, dto);
	}

	public PVUCsEventDView toPVUDTOOne(PVUCsEventEntity entity, PVUCsEventDView dto) {

		if (!Utils.isEmpty(entity.getPayLevel()) && entity.getPayLevel().getPayLevelValue() != null) {
			dto.setPayLevelId(entity.getPayLevel().getPayLevelValue());
		}

		if (!Utils.isEmpty(entity.getCellId()) && entity.getCellId().getCellValue() != 0) {
			dto.setCellId(String.valueOf(entity.getCellId().getCellId()));
		}

		if (!Utils.isEmpty(entity.getScale()) && entity.getScale().getPayScaleDispVal() != null) {
			dto.setPayScale(String.valueOf(entity.getScale().getPayScaleDispVal()));
		}

		if (!Utils.isEmpty(entity.getEventId())) {
			dto.setEventId(entity.getEventId().getId());
		}

		if (!Utils.isEmpty(entity.getEventId())
				&& entity.getEventId().getId() == PvuConstant.CHANGE_OF_SCALE_PVU_EVENT_ID) {
			dto.setEventCode(PvuConstant.EVENT_CODE_PVU_CHANGE_OF_SCALE);
		}

		if (!Utils.isEmpty(entity.getPayCommission())) {
			if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
				dto.setPayCommId(PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME);
			} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
				dto.setPayCommId(PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME);
			} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
				dto.setPayCommId(PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME);
			}
		}

		dto.setDuration(entity.getNotionalDuration());

		return toPVUDTOTwo(entity, dto);

	}

	public PVUCsEventDView toPVUDTOTwo(PVUCsEventEntity entity, PVUCsEventDView dto) {
		if (!Utils.isEmpty(entity.getAuditorRemarks())) {
			dto.setAuditorRemarks(dto.getAuditorRemarks());
		}

		if (!Utils.isEmpty(entity.getVerifierRemarks())) {
			dto.setVerifierRemarks(dto.getVerifierRemarks());
		}

		if (!Utils.isEmpty(entity.getClassTwoRemarks())) {
			dto.setClassTwoRemarks(dto.getClassTwoRemarks());
		}

		if (!Utils.isEmpty(entity.getClassOneRemarks())) {
			dto.setClassOneRemarks(dto.getClassOneRemarks());
		}

		if (!Utils.isEmpty(entity.getPrintRemarks())) {
			dto.setPrintRemarks(dto.getPrintRemarks());
		}

		if (!Utils.isEmpty(entity.getAuditorReturnReason())) {
			dto.setAuditorReturnReason(dto.getAuditorReturnReason());
		}

		if (!Utils.isEmpty(entity.getVerifierReturnReason())) {
			dto.setVerifierReturnReason(dto.getVerifierReturnReason());
		}

		if (!Utils.isEmpty(entity.getClassTwoReturnReason())) {
			dto.setClassTwoReturnReason(dto.getClassTwoReturnReason());
		}

		if (!Utils.isEmpty(entity.getClassOneReturnReason())) {
			dto.setClassOneReturnReason(dto.getClassOneReturnReason());
		}

		if (!Utils.isEmpty(entity.getPrintReturnReason())) {
			dto.setPrintReturnReason(dto.getPrintReturnReason());
		}

		if (!Utils.isEmpty(entity.getPrintCount())) {
			dto.setPrintCount(dto.getPrintCount());
		}
		return dto;
	}

	public PVUCsEventEntity updateCsRemarks(PVUCsEventEntity entity, PVUCsEventDto dto) {
		if (!Utils.isEmpty(dto.getAuditorRemarks())) {
			entity.setAuditorRemarks(dto.getAuditorRemarks());
		}

		if (!Utils.isEmpty(dto.getVerifierRemarks())) {
			entity.setVerifierRemarks(dto.getVerifierRemarks());
		}

		if (PvuUtils.notNull(dto.getClassTwoRemarks())) {
			entity.setClassTwoRemarks(dto.getClassTwoRemarks());
		}

		if (PvuUtils.notNull(dto.getClassOneRemarks())) {
			entity.setClassOneRemarks(dto.getClassOneRemarks());
		}

		if (!Utils.isEmpty(dto.getPrintRemarks())) {
			entity.setPrintRemarks(dto.getPrintRemarks());
		}

		if (!Utils.isEmpty(dto.getAuditorReturnReason())) {
			entity.setAuditorReturnReason(dto.getAuditorReturnReason());
		}

		if (!Utils.isEmpty(dto.getVerifierReturnReason())) {
			entity.setVerifierReturnReason(dto.getVerifierReturnReason());
		}

		if (!Utils.isEmpty(dto.getClassTwoReturnReason())) {
			entity.setClassTwoReturnReason(dto.getClassTwoReturnReason());
		}

		if (!Utils.isEmpty(dto.getClassOneReturnReason())) {
			entity.setClassOneReturnReason(dto.getClassOneReturnReason());
		}

		if (!Utils.isEmpty(dto.getPrintReturnReason())) {
			entity.setPrintReturnReason(dto.getPrintReturnReason());
		}

		if (!Utils.isEmpty(dto.getPrintCount())) {
			entity.setPrintCount(dto.getPrintCount());
		}
		return entity;
	}

	public VelocityContext populateVContext(PVUStickerDTO stickerDTO, PVUCsEventEntity entity) {
		VelocityContext context = new VelocityContext();
		String gender = entity.getEmployee().getGender().getLookUpInfoName();
		if (gender.equalsIgnoreCase("Male")) {
			context.put("gender", "His");
		} else {
			context.put("gender", "Her");
		}
		if (!Utils.isEmpty(stickerDTO.getEmployeeNo())) {
			context.put("employeeNo", stickerDTO.getEmployeeNo());
		}
		String srSaluation = "";
		if (!Utils.isEmpty(entity.getEmployee().getSalutation())) {
			srSaluation = entity.getEmployee().getSalutation().getLookUpInfoName();
		}
		String middleName = "";
		if (!entity.getEmployee().getEmployeeMiddleName().equalsIgnoreCase("0")) {
			middleName = entity.getEmployee().getEmployeeMiddleName();
		}
		String surName = "";
		if (!entity.getEmployee().getEmployeeSurname().equalsIgnoreCase("0")) {
			surName = entity.getEmployee().getEmployeeSurname();
		}
		context.put("employeeName",
				srSaluation + " " + entity.getEmployee().getEmployeeName() + " " + middleName + " " + surName);

		if (!Utils.isEmpty(stickerDTO.getEmployeeName())) {
			context.put("designation", stickerDTO.getDesignation());
		}
		if (!Utils.isEmpty(stickerDTO.getOfficeName())) {
			context.put("officeName", stickerDTO.getOfficeName());
		}
		if (!Utils.isEmpty(entity.getcClass())) {
			context.put("className", entity.getcClass().getLookUpInfoName());
		}
		if (!Utils.isEmpty(entity.getEventEffectiveDate())) {
			context.put("effectiveDate", entity.getEventEffectiveDate()
					.format(DateTimeFormatter.ofPattern(PvuConstant.DATE_FORMATE_DDMMYYYY)));
		}
		if (!Utils.isEmpty(entity.getDateOfNextIncrement())) {
			context.put("nextIncDate", entity.getDateOfNextIncrement()
					.format(DateTimeFormatter.ofPattern(PvuConstant.DATE_FORMATE_DDMMYYYY)));
		}
		if (!Utils.isEmpty(entity.getcDateOfNextIncrement())) {
			context.put("cNextIncDate", entity.getcDateOfNextIncrement()
					.format(DateTimeFormatter.ofPattern(PvuConstant.DATE_FORMATE_DDMMYYYY)));
		}
		if (!Utils.isEmpty(stickerDTO.getEndorsementPrintDate())) {
			context.put("endorsementPrintDate", Utils.getDateString(stickerDTO.getEndorsementPrintDate()));
		}

		if (!Utils.isEmpty(stickerDTO.getRePrintCount())) {
			context.put("rePrintCount", stickerDTO.getRePrintCount());
			context.put("showRePrintCount", stickerDTO.getRePrintCount() - 1);
		} else {
			context.put("rePrintCount", "");
		}

		return pdfpopulateVContextSeven(stickerDTO, entity, context);
	}

	public VelocityContext pdfpopulateVContextSeven(PVUStickerDTO stickerDTO, PVUCsEventEntity entity,
			VelocityContext context) {

		if (!Utils.isEmpty(stickerDTO.getEndorsementReprintDate())) {
			context.put("endorsementReprintDate", Utils.getDateString(stickerDTO.getEndorsementReprintDate()));
		} else {
			context.put("endorsementReprintDate", "");
		}

		if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			if (!Utils.isEmpty(entity.getPayLevel())) {
				context.put("levelValue", entity.getPayLevel().getPayLevelValue());
			}
			if (!Utils.isEmpty(entity.getcPayLevel())) {
				context.put("clevelValue", entity.getcPayLevel().getPayLevelValue());
			}
		}

		return pdfpopulatesVContextSix(stickerDTO, entity, context);
	}

	public VelocityContext pdfpopulatesVContextSix(PVUStickerDTO stickerDTO, PVUCsEventEntity entity,
			VelocityContext context) {

		if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			if (!Utils.isEmpty(entity.getcPayBand())) {
				context.put("cPayBandName", entity.getcPayBand().getPayBandDispVal());
			}
			if (!Utils.isEmpty(entity.getcPayBandValue())) {
				context.put("cPayBandValue", entity.getcPayBandValue());
			}
			if (!Utils.isEmpty(entity.getcGradePay())) {
				context.put("cGradePayValue", entity.getcGradePay().getGradePayValue());
			}
			if (!Utils.isEmpty(entity.getPayBand())) {
				context.put("payBandName", entity.getPayBand().getPayBandDispVal());
			}
			if (!Utils.isEmpty(entity.getPayBandValue())) {
				context.put("payBandValue", entity.getPayBandValue());
			}
			if (!Utils.isEmpty(entity.getGradePay())) {
				context.put("gradePayName", entity.getGradePay().getGradePayValue());
			}
		}
		return pdfpopulatesContextFifth(stickerDTO, entity, context);
	}

	public VelocityContext pdfpopulatesContextFifth(PVUStickerDTO stickerDTO, PVUCsEventEntity entity,
			VelocityContext context) {
		if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			if (!Utils.isEmpty(entity.getcPayScale())) {
				context.put("cPayScale", entity.getcPayScale().getPayScaleDispVal());
			}
			if (!Utils.isEmpty(entity.getScale())) {
				context.put("payscaleName", entity.getScale().getPayScaleDispVal());
			}
		}
		if (!Utils.isEmpty(stickerDTO.getRePrintRemark())) {
			context.put("remarks", stickerDTO.getRePrintRemark());
		} else {
			context.put("remarks", "");
		}
		if (!Utils.isEmpty(entity.getBasicPay())) {
			context.put("basicPay", entity.getBasicPay());
		}
		if (!Utils.isEmpty(entity.getcBasicPay())) {
			context.put("cBasicPay", entity.getcBasicPay());
		}
		if (!Utils.isEmpty(entity.getAuthorizerRemark())) {
			context.put("authorizerRemarks", entity.getAuthorizerRemark());
		} else {
			context.put("authorizerRemarks", "");
		}
		return context;
	}

	public PVUPrintEndorsementEntity toEntity(PVUPrintEndorsementDto dto) {
		PVUPrintEndorsementEntity entity = new PVUPrintEndorsementEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public PVUPrintEndorsementDto toDTO(PVUPrintEndorsementEntity entity) {
		PVUPrintEndorsementDto dto = new PVUPrintEndorsementDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	// 8 No. Screen

	public VelocityContext populateVContext(PVUCsEventEntity entity) {
		VelocityContext context = new VelocityContext();

		context.put("EVENT_NAME", PvuConstant.EVENT_NAME_CHANGE_OF_SCALE);
		context.put("OFFICE_NAME", !Utils.isEmpty(entity.getOfficeId()) ? entity.getOfficeId().getOfficeName() : "");
		context.put("OFFICE_ADDRESS", !Utils.isEmpty(entity.getOfficeId()) ? entity.getOfficeId().getAddrLine1() : "");
		context.put("TRANSACION_NO", !Utils.isEmpty(entity.getTrnNo()) ? entity.getTrnNo() : "");
		context.put("TRANSACION_DATE",
				!Utils.isEmpty(entity.getAuthorizeDate())
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getAuthorizeDate().toLocalDate())
						: "");
		context.put("ORDER_NO", !Utils.isEmpty(entity.getEventOrderNo()) ? entity.getEventOrderNo() : "");
		context.put("EMPLOYEE_NO", !Utils.isEmpty(entity.getEmployee()) ? entity.getEmployee().getEmployeeCode() : "");
		context.put("DESIGNATION",
				!Utils.isEmpty(entity.getcDesignation()) ? entity.getcDesignation().getDesignationName() : "");
//		DESIGNATION
		context.put("CURRENT_BASIC_PAY", !Utils.isEmpty(entity.getcBasicPay()) ? entity.getcBasicPay() : "");
		context.put("BASIC_PAY", !Utils.isEmpty(entity.getBasicPay()) ? entity.getBasicPay() : "");
		if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			context.put("CURRENT_PAY_LEVEL",
					!Utils.isEmpty(entity.getcPayLevel()) ? entity.getcPayLevel().getPayLevelValue() : "");
			context.put("PAY_LEVEL",
					!Utils.isEmpty(entity.getPayLevel()) ? entity.getPayLevel().getPayLevelValue() : "");
			context.put("CURRENT_CELL_ID", !Utils.isEmpty(entity.getcCell()) ? entity.getcCell().getCellId() : "");
			context.put("CELL_ID", !Utils.isEmpty(entity.getCellId()) ? entity.getCellId().getCellId() : "");
		} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			context.put("CURRENT_PAY_BAND",
					!Utils.isEmpty(entity.getcPayBand()) ? entity.getcPayBand().getPayBandDispVal() : "");
			context.put("PAY_BAND", !Utils.isEmpty(entity.getPayBand()) ? entity.getPayBand().getPayBandDispVal() : "");

			context.put("CURRENT_PAY_BAND_VALUE",
					!Utils.isEmpty(entity.getcPayBandValue()) ? entity.getcPayBandValue() : "");
			context.put("PAY_BAND_VALUE", !Utils.isEmpty(entity.getPayBandValue()) ? entity.getPayBandValue() : "");

			context.put("CURRENT_GRADE_PAY",
					!Utils.isEmpty(entity.getcGradePay()) ? entity.getcGradePay().getGradePayValue() : "");
			context.put("GRADE_PAY",
					!Utils.isEmpty(entity.getGradePay()) ? entity.getGradePay().getGradePayValue() : "");
		} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			context.put("CURRENT_PAYSCALE",
					!Utils.isEmpty(entity.getcPayScale()) ? entity.getcPayScale().getScaleValue() : "");
			context.put("CURRENT_BASIC_PAY", !Utils.isEmpty(entity.getcBasicPay()) ? entity.getcBasicPay() : "");
			context.put("PAYSCALE", !Utils.isEmpty(entity.getScale()) ? entity.getScale().getScaleValue() : "");
		}
		context.put("PERSONAL_PAY", !Utils.isEmpty(entity.getPersonalPay()) ? entity.getPersonalPay() : "");
		context.put("CURRENT_DNI",
				!Utils.isEmpty(entity.getcDateOfNextIncrement())
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getcDateOfNextIncrement())
						: "");
		context.put("DNI",
				!Utils.isEmpty(entity.getDateOfNextIncrement())
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getDateOfNextIncrement())
						: "");
		context.put("EVENT_EFFECTIVE_DATE",
				!Utils.isEmpty(entity.getEventEffectiveDate())
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getEventEffectiveDate())
						: "");
		context.put("hisher",
				entity.getEmployee().getGender().getLookUpInfoName().equalsIgnoreCase("Male") ? "his" : "her");
		context.put("heshe",
				entity.getEmployee().getGender().getLookUpInfoName().equalsIgnoreCase("Male") ? "he" : "she");
//		YesNo

		String srSaluation = "";
		if (!Utils.isEmpty(entity.getEmployee().getSalutation())) {
			srSaluation = entity.getEmployee().getSalutation().getLookUpInfoName();
		}
		context.put("EMPLOYEE_NAME",
				srSaluation + " " + StringUtils.defaultString(entity.getEmployee().getEmployeeName()) + " "
						+ StringUtils.defaultString(entity.getEmployee().getEmployeeMiddleName()) + " "
						+ StringUtils.defaultString(entity.getEmployee().getEmployeeSurname()));

		return context;

	}

}
