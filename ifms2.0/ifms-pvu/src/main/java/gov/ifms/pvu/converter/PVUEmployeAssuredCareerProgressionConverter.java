package gov.ifms.pvu.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.dto.AcpEmployeeDetailDto;
import gov.ifms.pvu.dto.PVUEmployeAcpCurrentDto;
import gov.ifms.pvu.dto.PVUEmployeAcpPostDetailsDto;
import gov.ifms.pvu.dto.PVUEmployeAssuredCareerProgressionDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.entity.PVUEmployeAssuredCareerProgressionEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeAssuredCareerProgressionConverter class.
 */
@Component
public class PVUEmployeAssuredCareerProgressionConverter
		implements BaseConverter<PVUEmployeAssuredCareerProgressionEntity, PVUEmployeAssuredCareerProgressionDto> {

	private final Logger logger = LoggerFactory.getLogger(PVUEmployeAssuredCareerProgressionConverter.class.getName());

	@Override
	public PVUEmployeAssuredCareerProgressionEntity toEntity(PVUEmployeAssuredCareerProgressionDto dto) {
		PVUEmployeAssuredCareerProgressionEntity entity = new PVUEmployeAssuredCareerProgressionEntity();
		BeanUtils.copyProperties(dto, entity);
		if (dto.getPayLevelId() != 0) {
			entity.setPayLevel(new PVUMsPayLevelEntity(dto.getPayLevelId()));
		}
		if (dto.getCellId() != 0) {
			entity.setCellId(new PVUMsPayCellEntity(dto.getCellId()));
		}
		if (dto.getOfficeId() != 0) {
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		}
		if (dto.getEmployeeId() != 0) {
			entity.setEmployeeNo(new PVUEmployeEntity(dto.getEmployeeId()));
		}
		if (dto.getStatusId() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (dto.getDecRegPrm() != 0) {
			entity.setDecRegPrm(new EDPLuLookUpInfoEntity(dto.getDecRegPrm()));
		}

		if (!Utils.isEmpty(dto.getcPayBandId())) {
			entity.setcPayBandId(new PVUMsPayBandEntity(dto.getcPayBandId()));
		}
		if (!Utils.isEmpty(dto.getcPayBandValue())) {
			entity.setcPayBandValue(dto.getcPayBandValue());
		}
		if (!Utils.isEmpty(dto.getcPayScaleId())) {
			entity.setcPayScale(new PVUMsPayScaleEntity(dto.getcPayScaleId()));
		}
		if (!Utils.isEmpty(dto.getPayScale())) {
			entity.setPayScale(new PVUMsPayScaleEntity(dto.getPayScale()));
		}
		if (!Utils.isEmpty(dto.getcGradePayId())) {
			entity.setcGradePayId(new PVUMsGradePayEntity(dto.getcGradePayId()));
		}
		if (!Utils.isEmpty(dto.getPayBandId())) {
			entity.setPayBand(new PVUMsPayBandEntity(dto.getPayBandId()));
		}
		if (dto.getGradePayId() != 0)
			entity.setGradePay(new PVUMsGradePayEntity(dto.getGradePayId()));
		if (!Utils.isEmpty(dto.getPayCommId())) {
			entity.setPayCommission(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		}
		if (PvuUtils.hasLength(dto.getAcpType())) {
			entity.setAcpType(new EDPLuLookUpInfoEntity(dto.getAcpType()));
		}


		if (dto.getCurrentDetailsEventId() != null) {
			entity.setCurrentDetailsEventId(dto.getCurrentDetailsEventId());
		}
		formatDateToEntity(dto, entity);
		return entity;
	}

	private void formatDateToEntity(PVUEmployeAssuredCareerProgressionDto dto,
			PVUEmployeAssuredCareerProgressionEntity entity) {
		SimpleDateFormat formatter = new SimpleDateFormat(PvuConstant.ACP_DATE_FORMAT);
		try {
			entity.setEventEffectiveDate(formatter.parse(dto.getEventEffectiveDate()));
			entity.setBenEffDate(formatter.parse(dto.getBenEffDate()));
			entity.setEventOrderDate(formatter.parse(dto.getEventOrderDate()));
			entity.setDateOfNextIncrement(dto.getcDateOfNextIncrement());
			entity.setcDateOfNextIncrement(dto.getcDateOfNextIncrement());
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeAssuredCareerProgression dto
	 */
	@Override
	public PVUEmployeAssuredCareerProgressionDto toDTO(PVUEmployeAssuredCareerProgressionEntity entity) {

		PVUEmployeAssuredCareerProgressionDto dto = new PVUEmployeAssuredCareerProgressionDto();
		BeanUtils.copyProperties(entity, dto);
		employeeDetailsDTO(entity, dto);
		currentEventDetailstoDTO(entity, dto);
		if (entity.getAcpType() != null) {
			dto.setAcpType(entity.getAcpType().getLookUpInfoId());
		}
		if (entity.getPayLevel() != null) {
			dto.setPayLevelId(entity.getPayLevel().getId());
		}
		if (entity.getPayCommission() != null) {
			dto.setPayCommId(entity.getPayCommission().getLookUpInfoId());
		}
		if (entity.getCellId() != null) {
			dto.setCellId(entity.getCellId().getId());
		}
		if (entity.getDecRegPrm() != null) {
			dto.setDecRegPrm(entity.getDecRegPrm().getLookUpInfoId());
		}
		if (!Utils.isEmpty(entity.getGradePay()))
			dto.setGradePayId(entity.getGradePay().getId());

		if (!Utils.isEmpty(entity.getPayBandValue())) {
			dto.setPayBandValue(entity.getPayBandValue());
		}
		if (!Utils.isEmpty(dto.getPayCommId())) {
			entity.setPayCommission(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		}
		if (entity.getPayBand() != null) {
			dto.setPayBandId(entity.getPayBand().getId());
		}
		if (!PvuUtils.isEmpty(entity.getDateOfNextIncrement())) {
			dto.setDateOfNextIncrement(entity.getDateOfNextIncrement());
			dto.setcDateOfNextIncrement(entity.getcDateOfNextIncrement());
		}

		if (entity.getcPayScale() != null) {
			dto.setcPayScaleId(entity.getcPayScale().getPayScaleId());
		}

		if (entity.getPayScale() != null) {
			dto.setPayScale(entity.getPayScale().getPayScaleId());
		}

		if (!Utils.isEmpty(entity.getcPayBandId()))
			dto.setcPayBandId(entity.getcPayBandId().getId());

		return dateTODTO(entity, dto);
	}

	private void currentEventDetailstoDTO(PVUEmployeAssuredCareerProgressionEntity entity,
			PVUEmployeAssuredCareerProgressionDto dto) {

		if (!Utils.isEmpty(entity.getcPayScale())) {
			dto.setcPayScaleId(entity.getcPayScale().getPayScaleId());
		}
		if (!Utils.isEmpty(entity.getcPayBandId()))
			dto.setcPayBandId(entity.getcPayBandId().getId());

		if (!Utils.isEmpty(entity.getcPayBandValue())) {
			dto.setcPayBandValue(entity.getcPayBandValue());
		}
		if (!Utils.isEmpty(entity.getcBasicPay())) {
			dto.setcBasicPay(entity.getcBasicPay());
		}
		if (!Utils.isEmpty(entity.getcGradePayId())) {
			dto.setcGradePayId(entity.getcGradePayId().getId());
		}
	}

	private PVUEmployeAssuredCareerProgressionDto employeeDetailsDTO(PVUEmployeAssuredCareerProgressionEntity entity,
			PVUEmployeAssuredCareerProgressionDto dto) {
		if (entity.getEmployeeNo() != null && entity.getEmployeeNo().getEmployeeCode() != null) {
			dto.setEmployeeNo(entity.getEmployeeNo().getEmployeeCode());
		}
		if (entity.getEmployeeNo() != null && entity.getEmployeeNo().getEmpId() != 0) {
			dto.setEmployeeId(entity.getEmployeeNo().getEmpId());
		}
		if (entity.getStatusId() != null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		if (entity.getOfficeId() != null) {
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
		}
		return dto;
	}

	private PVUEmployeAssuredCareerProgressionDto dateTODTO(PVUEmployeAssuredCareerProgressionEntity entity,
			PVUEmployeAssuredCareerProgressionDto dto) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (entity.getEventEffectiveDate() != null) {
			String effectiveDate = formatter.format(entity.getEventEffectiveDate());
			dto.setEventEffectiveDate(effectiveDate);
		}
		if (entity.getEventOrderDate() != null) {
			String orderDate = formatter.format(entity.getEventOrderDate());
			dto.setEventOrderDate(orderDate);
		}
		if (entity.getBenEffDate() != null) {
			String benEffectiveDate = formatter.format(entity.getBenEffDate());
			dto.setBenEffDate(benEffectiveDate);
		}

		if (entity.getCurrentDetailsEventId() != null) {
			dto.setCurrentDetailsEventId(entity.getCurrentDetailsEventId());
		}
		dto.setEventOrderNo(entity.getEventOrderNo());

		return dto;
	}

	public PVUEmployeAcpPostDetailsDto toPVUObj(PVUEmployeAssuredCareerProgressionEntity entity) {
		PVUEmployeAcpPostDetailsDto detailDto = new PVUEmployeAcpPostDetailsDto();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.PREM_SIXTH_COMMISSION_ID) {
			detailDto.setPayBandId(entity.getPayBand().getPayBandDispVal());
			detailDto.setPayBandValue(String.valueOf(entity.getPayBandValue()));
			detailDto.setGradePayId(String.valueOf(entity.getGradePay().getGradePayValue()));
			detailDto.setPayCommId(PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME);
		} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.PREM_FIFTH_COMMISSION_ID) {
			if (entity.getPayScale() != null) {
				detailDto.setPayScale(String.valueOf(entity.getPayScale().getPayScaleDispVal()));
			}
			else {	detailDto.setPayScale("");}
			detailDto.setPayCommId(PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME);
		}
		detailDto.setBasicPay(String.valueOf(entity.getBasicPay()));
		detailDto.setOfficeId(entity.getOfficeId().getOfficeName());
		detailDto.setEventOrderNo(entity.getEventOrderNo());
		detailDto.setEventOrderDate(String.valueOf(entity.getEventOrderDate()));
		detailDto.setEventEffectiveDate(formatter.format(entity.getEventEffectiveDate()));
		detailDto.setEventCode(PvuConstant.EVENT_ACP_NAME);
		detailDto.setEmployeeNo(String.valueOf(entity.getEmployeeNo().getEmployeeCode()));
		detailDto.setAcpType(String.valueOf(entity.getAcpType().getLookUpInfoName()));

		return detailDto;
	}

	public PVUEmployeAcpCurrentDto toPVUObjCommon(AcpEmployeeDetailDto dto) {
		PVUEmployeAcpCurrentDto currentDetails = new PVUEmployeAcpCurrentDto();
		currentDetails.setEmployeeName(dto.getEmployeeName());
		currentDetails.setEmployeeClass(dto.getEmployeeClass());
		currentDetails.setDesignationName(dto.getDesignationName());
		if (dto.getPayCommId().equals(PvuConstant.SIXTH_COMMISSION_ID)) {
			currentDetails.setPayBandName(String.valueOf(dto.getPayBandName()));
			currentDetails.setPayBandValue(String.valueOf(dto.getPayBandValue()));
			currentDetails.setGradePayName(String.valueOf(dto.getGradePayName()));

		} else if (dto.getPayCommId().equals(PvuConstant.FIFTH_COMMISSION_ID)) {
			currentDetails.setPayScaleName(String.valueOf(dto.getPayScaleName()));
		}
		currentDetails.setEmpBasicPay(String.valueOf(dto.getEmpBasicPay()));
		currentDetails.setDateNxtIncr(dto.getDateNxtIncr());
		currentDetails.setDateJoining(dto.getDateJoining());
		currentDetails.setRetirementDate(dto.getRetirementDate());
		currentDetails.setOfficeName(dto.getOfficeName());
		return currentDetails;
	}

	public PVUEmployeAssuredCareerProgressionDto updateACPRemarks(PVUEmployeAssuredCareerProgressionDto getRecordDto,
			PVUEmployeAssuredCareerProgressionDto dto) {

		if (!Utils.isEmpty(dto.getAuditorRemarks())) {
			getRecordDto.setAuditorRemarks(dto.getAuditorRemarks());
		}

		if (PvuUtils.notNull(dto.getClassTwoRemarks())) {
			getRecordDto.setClassTwoRemarks(dto.getClassTwoRemarks());
		}

		if (!Utils.isEmpty(dto.getPrintRemarks())) {
			getRecordDto.setPrintRemarks(dto.getPrintRemarks());
		}

		if (!Utils.isEmpty(dto.getAuditorReturnReason())) {
			getRecordDto.setAuditorReturnReason(dto.getAuditorReturnReason());
		}

		if (PvuUtils.notNull(dto.getClassOneRemarks())) {
			getRecordDto.setClassOneRemarks(dto.getClassOneRemarks());
		}

		if (!Utils.isEmpty(dto.getVerifierRemarks())) {
			getRecordDto.setVerifierRemarks(dto.getVerifierRemarks());
		}

		if (!Utils.isEmpty(dto.getClassTwoReturnReason())) {
			getRecordDto.setClassTwoReturnReason(dto.getClassTwoReturnReason());
		}

		if (!Utils.isEmpty(dto.getPrintReturnReason())) {
			getRecordDto.setPrintReturnReason(dto.getPrintReturnReason());
		}

		if (!Utils.isEmpty(dto.getClassOneReturnReason())) {
			getRecordDto.setClassOneReturnReason(dto.getClassOneReturnReason());
		}

		if (!Utils.isEmpty(dto.getVerifierReturnReason())) {
			getRecordDto.setVerifierReturnReason(dto.getVerifierReturnReason());
		}

		if (!Utils.isEmpty(dto.getPrintCount())) {
			getRecordDto.setPrintCount(dto.getPrintCount());
		}
		return getRecordDto;
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

	public VelocityContext populateVContext(PVUStickerDTO stickerDTO, PVUEmployeAssuredCareerProgressionEntity entity) {
		VelocityContext context = new VelocityContext();
		String gender = entity.getEmployeeNo().getGender().getLookUpInfoName();
		empContextCurrDetailsToDTO(stickerDTO, context, gender);
		if (!Utils.isEmpty(entity.getEventEffectiveDate())) {
			context.put("effectiveDate", Utils.getDateString(entity.getEventEffectiveDate()));
		}
		if (!PvuUtils.isEmpty(entity.getDateOfNextIncrement())) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PvuConstant.TIKUPAY_DD_MM_YYY);
			context.put("nextIncDate", simpleDateFormat.format(entity.getDateOfNextIncrement()));
		} else {
			context.put("nextIncDate", "");
		}
		if (!Utils.isEmpty(stickerDTO.getEndorsementPrintDate())) {
			context.put("endorsementPrintDate", Utils.getDateString(stickerDTO.getEndorsementPrintDate()));
		}
		if (!Utils.isEmpty(stickerDTO.getEndorsementReprintDate())) {
			context.put("endorsementReprintDate", Utils.getDateString(stickerDTO.getEndorsementReprintDate()));
		} else {
			context.put("endorsementReprintDate", StringUtils.EMPTY);
		}
		populateReprintContent(stickerDTO, context);
		if (!Utils.isEmpty(entity.getAuthorizerRemark())) {
			context.put("remarks", entity.getAuthorizerRemark());
		} else {
			context.put("remarks", StringUtils.EMPTY);
		}
		if (!Utils.isEmpty(entity.getBasicPay())) {
			context.put("basicPay", entity.getBasicPay());
		}
		if (!Utils.isEmpty(entity.getAcpType()) && entity.getAcpType().equals(PvuConstant.ACP_TYPE_ONE)) {
			context.put("acpYears", PvuConstant.FIVE_YEARS);
			context.put("number", "1st");
		} else {
			context.put("acpYears", PvuConstant.TEN_YEARS);
			context.put("number", "2nd");
		}
		if (!Utils.isEmpty(entity.getcBasicPay())) {
			context.put("cBasicPay", entity.getcBasicPay());
		}
		if (!Utils.isEmpty(entity.getPayCommission())) {
			populateSixPayContext(entity, context);
			if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID
					&& !Utils.isEmpty(entity.getcPayScale())) {
				context.put("cPayScale", entity.getcPayScale().getPayScaleDispVal());
			}
		}
		setPayDetails(entity, context);
		return context;
	}

	void setPayDetails(PVUEmployeAssuredCareerProgressionEntity entity, VelocityContext context) {
		if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			if (!Utils.isEmpty(entity.getcPayBandId()) && !Utils.isEmpty(entity.getcPayBandId().getPayBandDispVal())) {
				context.put("payScaleVal", entity.getcPayBandId().getPayBandDispVal());
			} else {
				context.put("payScaleVal", StringUtils.EMPTY);
			}
			if (!Utils.isEmpty(entity.getPayBand()) && !Utils.isEmpty(entity.getPayBand().getPayBandDispVal())) {
				context.put("scaleVal", entity.getPayBand().getPayBandDispVal());
			} else {
				context.put("scaleVal", StringUtils.EMPTY);
			}
		} else {
			if (!Utils.isEmpty(entity.getcPayScale()) && !Utils.isEmpty(entity.getcPayScale().getPayScaleDispVal())) {
				context.put("payScaleVal", entity.getcPayScale().getPayScaleDispVal());
			}
			if (!Utils.isEmpty(entity.getPayScale()) && !Utils.isEmpty(entity.getPayScale().getPayScaleDispVal())) {
				context.put("scaleVal", entity.getPayScale().getPayScaleDispVal());
			}
		}
	}

	private void populateReprintContent(PVUStickerDTO stickerDTO, VelocityContext context) {
		if (!Utils.isEmpty(stickerDTO.getRePrintCount())) {
			context.put("rePrintCount", stickerDTO.getRePrintCount() - 1);
			context.put("rePrintRemarks", stickerDTO.getRePrintRemark());
			context.put("rePrintCounter", stickerDTO.getRePrintCount());
		} else {
			context.put("rePrintCount", StringUtils.EMPTY);
			context.put("rePrintRemarks", StringUtils.EMPTY);
			context.put("rePrintCounter", StringUtils.EMPTY);
		}
	}

	private void empContextCurrDetailsToDTO(PVUStickerDTO stickerDTO, VelocityContext context, String gender) {

		if (!Utils.isEmpty(gender)) {

			if (gender.equalsIgnoreCase(PvuConstant.MALE)) {
				context.put(PvuConstant.SALUTATION, "MR");
				context.put("heshe", "He");
				context.put("gender", "his");
			} else {
				if (gender.equalsIgnoreCase("Female")) {
					context.put("heshe", "She");
					context.put("gender", "her");
					context.put(PvuConstant.SALUTATION, "Mrs");
				} else if (gender.equalsIgnoreCase(PvuConstant.FMALE_TYPE_MISS)) {
					context.put(PvuConstant.SALUTATION, "Miss");
				} else if (gender.equalsIgnoreCase(PvuConstant.FMALE_TYPE_MS)) {
					context.put(PvuConstant.SALUTATION, "Ms.");
				}
			}

		}
		if (!Utils.isEmpty(stickerDTO.getEmployeeNo())) {
			context.put("employeeNo", stickerDTO.getEmployeeNo());
		}
		if (!Utils.isEmpty(stickerDTO.getEmployeeName())) {
			context.put("employeeName", stickerDTO.getEmployeeName());
		}

		if (!Utils.isEmpty(stickerDTO.getEmployeeName())) {
			context.put("designation", stickerDTO.getDesignation());
		}
		if (!Utils.isEmpty(stickerDTO.getOfficeName())) {
			context.put("officeName", stickerDTO.getOfficeName());
		}
	}

	private VelocityContext populateSixPayContext(PVUEmployeAssuredCareerProgressionEntity entity,
			VelocityContext context) {
		if (!Utils.isEmpty(entity.getcPayBandId())) {
			context.put("cPayBandName", entity.getcPayBandId().getPayBandDispVal());
		} else {
			context.put("cPayBandName", StringUtils.EMPTY);
		}
		if (!Utils.isEmpty(entity.getcPayBandValue())) {
			context.put("cPayBandValue", entity.getcPayBandValue());
		}
		if (!Utils.isEmpty(entity.getcGradePayId())) {
			context.put("cGradePayValue", entity.getcGradePayId().getGradePayValue());
		}
		if (!Utils.isEmpty(entity.getPayBand())) {
			context.put("payBandName", entity.getPayBand().getPayBandDispVal());
		}
		if (!Utils.isEmpty(entity.getGradePay())) {
			context.put("gradePayName", entity.getGradePay().getGradePayValue());
		}
		populatePayScaleVal(entity, context);
		populateEmpDetailsContext(entity, context);
		return context;
	}

	private void populatePayScaleVal(PVUEmployeAssuredCareerProgressionEntity entity, VelocityContext context) {
		if (!Utils.isEmpty(entity.getPayScale())) {
			context.put("payScale", entity.getPayScale());
		}
		if (!Utils.isEmpty(entity.getPayBandValue())) {
			context.put("payBandValue", entity.getPayBandValue());
		}
	}

	private void populateEmpDetailsContext(PVUEmployeAssuredCareerProgressionEntity entity, VelocityContext context) {
		if (!Utils.isEmpty(entity.getEmployeeNo().getEmployeeMiddleName())) {

			if (entity.getEmployeeNo().getEmployeeMiddleName().equals("0")) {
				context.put("middleName", StringUtils.EMPTY);
			} else {
				context.put("middleName", entity.getEmployeeNo().getEmployeeMiddleName());
			}
		} else {
			context.put("middleName", StringUtils.EMPTY);
		}

		if (!Utils.isEmpty(entity.getEmployeeNo().getEmployeeSurname())) {
			if (entity.getEmployeeNo().getEmployeeSurname().equals("0")) {
				context.put("surname", StringUtils.EMPTY);
			} else {
				context.put("surname", entity.getEmployeeNo().getEmployeeSurname());
			}
		} else {
			context.put("surname", StringUtils.EMPTY);
		}
	}

}
