/*
 * 
 */
package gov.ifms.pvu.converter;

import gov.ifms.pvu.dto.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.dto.response.PVUCASPrintDto;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUCareerAdvancementEntity;
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
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class PVUCarearAdvancementConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/09 11:46:59
 *
 */
@Component
@Transactional
public class PVUCareerAdvancementConverter
		extends BasePVUPfConverter<PVUCareerAdvancementEntity, PVUCareerAdvancementDto> {


	@Override
	PVUCareerAdvancementEntity createEntity() {
		return new PVUCareerAdvancementEntity();
	}

	@Override
	PVUCareerAdvancementDto createDTO() {
		return new PVUCareerAdvancementDto();
	}
	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUCarrearAdvancement entity
	 */
	@Override
	public PVUCareerAdvancementEntity toEntity(PVUCareerAdvancementDto dto) {
		PVUCareerAdvancementEntity entity = this.toCurrentDetailsEntity(dto);

		BeanUtils.copyProperties(dto, entity);
		if (PvuUtils.hasLength(dto.getEmployeeId())) {
			entity.setEmployee(new PVUEmployeEntity(dto.getEmployeeId()));
		}
		if (PvuUtils.hasLength(dto.getDesignationId())) {
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		}
		if (PvuUtils.hasLength(dto.getOfficeId())) {
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		}

		if (PvuUtils.hasLength(dto.getOptionAvailableId())) {
			entity.setOptionAvailableId(new EDPLuLookUpInfoEntity(dto.getOptionAvailableId()));
		}
		if (dto.getOptionAvailableId()==0L) {
			entity.setOptionAvailableId(new EDPLuLookUpInfoEntity(1L));
		}
		if (PvuUtils.hasLength(dto.getOriCourAtte())) {
			entity.setOriCourAtte(new EDPLuLookUpInfoEntity(dto.getOriCourAtte()));
		}
		if (PvuUtils.hasLength(dto.getRefCourAtte())) {
			entity.setRefCourAtte(new EDPLuLookUpInfoEntity(dto.getRefCourAtte()));
		}
		if (PvuUtils.hasLength(dto.getUniAppLectType())) {
			entity.setUniAppLectType(new EDPLuLookUpInfoEntity(dto.getUniAppLectType()));
		}
		if (PvuUtils.hasLength(dto.getStatusId())) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}

		if (PvuUtils.hasLength(dto.getCellId())) {
			entity.setCellId(new PVUMsPayCellEntity(dto.getCellId()));
		}
		if (dto.getEventId() != 0) {
			entity.setEvent(new PVUMsEventEntity(dto.getEventId()));
		}

		return setPayDetails(dto, entity);
	}

	/**
	 * Sets the pay details.
	 *
	 * @param dto    the dto
	 * @param entity the entity
	 * @return the PVU career advancement entity
	 */
	private PVUCareerAdvancementEntity setPayDetails(PVUCareerAdvancementDto dto, PVUCareerAdvancementEntity entity) {
		if (PvuUtils.hasLength(dto.getPayCommId())) {
			entity.setPayCommId(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		}
		if (PvuUtils.hasLength(dto.getCasType())) {
			entity.setAdvSchType(new EDPLuLookUpInfoEntity(dto.getCasType()));
		}

		if (PvuUtils.hasLength(dto.getPayBandId())) {
			entity.setPayBandId(new PVUMsPayBandEntity(dto.getPayBandId()));
		}
		if (PvuUtils.hasLength(dto.getGradePayId())) {
			entity.setGradePayId(new PVUMsGradePayEntity(dto.getGradePayId()));
		}
		if (PvuUtils.hasLength(dto.getPayLevelId())) {
			entity.setPayLevelId(new PVUMsPayLevelEntity(dto.getPayLevelId()));
		}
		if (dto.getPayScale() != 0) {
			entity.setPayScale(new PVUMsPayScaleEntity(dto.getPayScale()));
		}

		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUCarrearAdvancement dto
	 */
	@Override
	public PVUCareerAdvancementDto toDTO(PVUCareerAdvancementEntity entity) {
		PVUCareerAdvancementDto dto = this.toCurrentDetailsDTO(entity);
		BeanUtils.copyProperties(entity, dto);
		if (entity.getEmployee() != null) {
			dto.setEmployeeId(entity.getEmployee().getEmpId());
			if (entity.getEmployee().getEmployeeCode() != null) {
				dto.setEmployeeNo(entity.getEmployee().getEmployeeCode());
			}
		}
		if (entity.getStatusId() != null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		if (entity.getOfficeId() != null) {
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
			if (entity.getOfficeId().getOfficeName() != null) {
				dto.setOfficeName(entity.getOfficeId().getOfficeName());
			}
		}

		if (entity.getOriCourAtte() != null) {
			dto.setOriCourAtte(entity.getOriCourAtte().getLookUpInfoId());
		}
		if (entity.getRefCourAtte() != null) {
			dto.setRefCourAtte(entity.getRefCourAtte().getLookUpInfoId());
		}
		if (entity.getUniAppLectType() != null) {
			dto.setUniAppLectType(entity.getUniAppLectType().getLookUpInfoId());
		}
		setPayDetails(entity, dto);
		return setPayEventdetails(entity, dto);
	}

	/**
	 * Sets the pay eventdetails.
	 *
	 * @param entity the entity
	 * @param dto    the dto
	 * @return the PVU career advancement dto
	 */
	private PVUCareerAdvancementDto setPayEventdetails(PVUCareerAdvancementEntity entity, PVUCareerAdvancementDto dto) {
		if (entity.getEvent() != null) {
			dto.setEventId(entity.getEvent().getId());
			if (entity.getEvent().getEventCode() != null) {
				dto.setEventCode(entity.getEvent().getEventCode());
			} else {
				dto.setEventCode(dto.getEventCode());
			}
		}
		if (entity.getPayLevelId() != null) {
			dto.setPayLevelId(entity.getPayLevelId().getId());
			if (entity.getPayLevelId().getPayLevelValue() != null) {
				dto.setPayLevelName(entity.getPayLevelId().getPayLevelValue());
			}
		}

		if (entity.getCellId() != null) {
			dto.setCellId(entity.getCellId().getId());
			if (entity.getCellId().getCellValue() != 0) {
				dto.setCellName(String.valueOf(entity.getCellId().getCellId()));
			}
		}

		return setPayBandEventdetails(entity, dto);
	}

	/**
	 * Sets the pay band eventdetails.
	 *
	 * @param entity the entity
	 * @param dto    the dto
	 * @return the PVU career advancement dto
	 */
	private PVUCareerAdvancementDto setPayBandEventdetails(PVUCareerAdvancementEntity entity,
			PVUCareerAdvancementDto dto) {
		if (entity.getPayScale() != null) {
			dto.setPayScale(entity.getPayScale().getPayScaleId());
			if (entity.getPayScale().getPayScaleDispVal() != null) {
				dto.setScaleName(entity.getPayScale().getPayScaleDispVal());
			}
		}
		if (entity.getPayBandId() != null) {
			dto.setPayBandId(entity.getPayBandId().getId());
			if (entity.getPayBandId().getPayBandDispVal() != null) {
				dto.setPayBandName(entity.getPayBandId().getPayBandDispVal());
			}
		}
		if (entity.getGradePayId() != null) {
			dto.setGradePayId(entity.getGradePayId().getId());
			if (entity.getGradePayId().getGradePayValue() != null) {
				dto.setGradePayName(entity.getGradePayId().getGradePayValue());
			}

		}
		return dto;
	}

	/**
	 * Sets the pay details.
	 *
	 * @param entity the entity
	 * @param dto    the dto
	 */
	private void setPayDetails(PVUCareerAdvancementEntity entity, PVUCareerAdvancementDto dto) {
		if (entity.getPayCommId() != null) {
			dto.setPayCommId(entity.getPayCommId().getLookUpInfoId());
		}
		if (entity.getDesignationId() != null) {
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
		}
		if (entity.getOptionAvailableId() != null) {
			dto.setOptionAvailableId(entity.getOptionAvailableId().getLookUpInfoId());
		}
		if (entity.getAdvSchType() != null) {
			dto.setCasType(entity.getAdvSchType().getLookUpInfoId());
		}
		if (entity.getPayLevelId() != null) {
			dto.setPayLevelId(entity.getPayLevelId().getId());
		}
		if (entity.getPayBandId() != null) {
			dto.setPayBandId(entity.getPayBandId().getId());
		}
		if (entity.getGradePayId() != null) {
			dto.setGradePayId(entity.getGradePayId().getId());
		}
		if (entity.getCellId() != null) {
			dto.setCellId(entity.getCellId().getId());
		}
		if (entity.getPayScale() != null) {
			dto.setPayScale(entity.getPayScale().getPayScaleId());
		}
	}

	/**
	 * To current obj.
	 *
	 * @param dto    the dto
	 * @param entity the entity
	 * @return the PVU carrier advance current dto
	 */
	public PVUCarrierAdvanceCurrentDto toCurrentObj(PVUCommonApiDto dto, PVUCareerAdvancementEntity entity) {
		PVUCarrierAdvanceCurrentDto currentDetails = new PVUCarrierAdvanceCurrentDto();
		currentDetails.setEmployeeName(dto.getEmployeeName());
		currentDetails.setEmployeeClass(dto.getEmployeeClass());
		currentDetails.setDesignationName(dto.getDesignationName());

		if (dto.getPayCommId().equals(PvuConstant.SIXTH_COMMISSION_ID)) {
			currentDetails.setPayBandName(String.valueOf(dto.getPayBandName()));
			currentDetails.setPayBandValue(String.valueOf(dto.getPayBandValue()));
			currentDetails.setGradePayName(String.valueOf(dto.getGradePayName()));

		} else if (dto.getPayCommId().equals(PvuConstant.FIFTH_COMMISSION_ID)) {
			currentDetails.setPayScaleName(String.valueOf(dto.getPayScaleName()));
		} else if (dto.getPayCommId().equals(PvuConstant.SEVENTH_COMMISSION_ID)) {
			currentDetails.setPayLevelName(String.valueOf(dto.getPayLevelName()));
			currentDetails.setCellName(String.valueOf(dto.getCellName()));
		}
		currentDetails.setEmpBasicPay(String.valueOf(dto.getEmpBasicPay()));
		currentDetails.setDateNxtIncr(dto.getDateNxtIncr());
		currentDetails.setDateJoining(dto.getDateJoining());
		currentDetails.setRetirementDate(dto.getRetirementDate());
		currentDetails.setOfficeName(dto.getOfficeName());
		return currentDetails;

	}

	/**
	 * To payment details.
	 *
	 * @param entity the entity
	 * @return the PVU career advancement post dto
	 */
	public PVUCareerAdvancementPostDto toPaymentDetails(PVUCareerAdvancementEntity entity,PVUCareerAdvancementPostDto detailDto) {
		if (entity.getPayCommId().getLookUpInfoId() == PvuConstant.PREM_SIXTH_COMMISSION_ID) {
			if (entity.getPayBandId() != null) {
				detailDto.setPayBandId(String.valueOf(entity.getPayBandId().getPayBandDispVal()));
				detailDto.setPayBandValue(String.valueOf(entity.getPayBandValue()));
				detailDto.setGradePayId(String.valueOf(entity.getGradePayId().getGradePayValue()));
			}
			detailDto.setPayCommId(PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME);
		} else if (entity.getPayCommId().getLookUpInfoId() == PvuConstant.PREM_FIFTH_COMMISSION_ID) {
			detailDto.setPayCommId(PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME);
			if (entity.getPayScale() != null) {
				detailDto.setScaleId(String.valueOf(entity.getPayScale().getScaleValue()));
			}
		} else if (entity.getPayCommId().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			detailDto.setPayCommId(PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME);
			if (entity.getCellId() != null) {
				detailDto.setCellId(String.valueOf(entity.getCellId().getCellId()));
				detailDto.setPayLevelId(String.valueOf(entity.getPayLevelId().getPayLevelValue()));
			}
		}
		return detailDto;
	}

	/**
	 * To post obj.
	 *
	 * @param entity the entity
	 * @return the PVU career advancement post dto
	 */
	public PVUCareerAdvancementPostDto toPostObj(PVUCareerAdvancementEntity entity) {
		PVUCareerAdvancementPostDto detailDto = new PVUCareerAdvancementPostDto();
		detailDto.setBasicPay(String.valueOf(entity.getBasicPay()));
		detailDto.setDateOfNextIncrement(entity.getDateOfNextIncrement().toString());
		detailDto.setEventOrderDate(entity.getEventOrderDate().toString());
		detailDto.setEventCode(PvuConstant.EVENT_NAME_CAREER_ADVANCE);
		detailDto.setEmployeeNo(String.valueOf(entity.getEmployee().getEmployeeCode()));
		detailDto.setCasType(String.valueOf(entity.getAdvSchType().getLookUpInfoName()));
		if(entity.getOfficeId()!=null) {
			detailDto.setOfficeId(String.valueOf(entity.getOfficeId().getOfficeName()));
		}
		if (entity.getEventOrderNo() != null) {
			detailDto.setEventOrderNo(entity.getEventOrderNo());
		}
		if (entity.getDesignationId() != null) {
			detailDto.setDesignationId(String.valueOf(entity.getDesignationId().getDesignationName()));
		}
		if (entity.getUniAppLectType() != null) {
			detailDto.setUniAppLectType(entity.getUniAppLectType().getLookUpInfoDescription());
		}
		if (entity.getOriCertDate() != null) {
			detailDto.setOriCertDate(entity.getOriCertDate().toString());
		}
		if (entity.getRefCourAtte() != null) {
			detailDto.setOriCourAtte(entity.getRefCourAtte().getLookUpInfoName());
		}
		if (entity.getRefCertDate() != null) {
			detailDto.setRefCertDate(entity.getRefCertDate().toString());
		}
		if (entity.getRefCourAtte() != null) {
			detailDto.setRefCourAtte(entity.getRefCourAtte().getLookUpInfoName());
		}
		if (entity.getEventOrderDate() != null) {
			detailDto.setEventOrderDate(entity.getEventOrderDate().toString());
		}
		if (entity.getEventEffectiveDate() != null) {
			detailDto.setEventEffectiveDate(entity.getEventEffectiveDate().toString());
		}
		if (entity.getBeneEffictDate() != null) {
			detailDto.setBenefitEffectiveDate(entity.getBeneEffictDate().toString());
		}
		if (entity.getOptionAvailableId() != null) {
			detailDto.setOptionAvailableId(entity.getOptionAvailableId().getLookUpInfoName());
		}

		if (entity.getOptionAvailableDate() != null)
			detailDto.setOptionAvailableDate(entity.getOptionAvailableDate().toString());

		return toPaymentDetails(entity,detailDto);
	}

	/**
	 * Sets the remarks.
	 *
	 * @param entity the entity
	 * @param dto    the dto
	 * @return the PVU career advancement entity
	 */
	public PVUCareerAdvancementEntity setRemarks(PVUCareerAdvancementEntity entity, PVUSSPRemarkRequest dto) {
		if (Utils.isNonEmpty(dto.getAuditorRemarks())) {
			entity.setAuditorRemarks(dto.getAuditorRemarks());
		}

		if (Utils.isNonEmpty(dto.getVerifierRemarks())) {
			entity.setVerifierRemarks(dto.getVerifierRemarks());
		}

		if (PvuUtils.notNull(dto.getClassTwoRemarks())) {
			entity.setClassTwoRemarks(dto.getClassTwoRemarks());
		}

		if (PvuUtils.notNull(dto.getClassOneRemarks())) {
			entity.setClassOneRemarks(dto.getClassOneRemarks());
		}

		if (Utils.isNonEmpty(dto.getPrintRemarks())) {
			entity.setPrintRemarks(dto.getPrintRemarks());
		}

		if (Utils.isNonEmpty(dto.getAuditorReturnReason())) {
			entity.setAuditorReturnReason(dto.getAuditorReturnReason());
		}

		if (Utils.isNonEmpty(dto.getVerifierReturnReason())) {
			entity.setVerifierReturnReason(dto.getVerifierReturnReason());
		}

		if (Utils.isNonEmpty(dto.getClassTwoReturnReason())) {
			entity.setClassTwoReturnReason(dto.getClassTwoReturnReason());
		}

		if (Utils.isNonEmpty(dto.getClassOneReturnReason())) {
			entity.setClassOneReturnReason(dto.getClassOneReturnReason());
		}

		if (Utils.isNonEmpty(dto.getPrintReturnReason())) {
			entity.setPrintReturnReason(dto.getPrintReturnReason());
		}

		if (Utils.isNonEmpty(dto.getPrintCount())) {
			entity.setPrintCount(dto.getPrintCount());
		}
		return entity;
	}

	/**
	 * To DTO view.
	 *
	 * @param entity the entity
	 * @return the PVU career advancement dto
	 */
	public PVUCareerAdvancementDto toDTOView(PVUCareerAdvancementEntity entity) {
		PVUCareerAdvancementDto dto = new PVUCareerAdvancementDto();
		if (!PvuUtils.isEmpty(entity.getDesignationId())) {
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
		}
		if (!PvuUtils.isEmpty(entity.getStatusId())) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		if (!PvuUtils.isEmpty(entity.getOfficeId())) {
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
		}
		if (!PvuUtils.isEmpty(entity.getPayCommId())) {
			dto.setPayCommId(entity.getPayCommId().getLookUpInfoId());
		}
		if (!PvuUtils.isEmpty(entity.getEmployee())) {
			dto.setEmployeeId(entity.getEmployee().getEmpId());
			if (entity.getEmployee() != null && entity.getEmployee().getEmployeeCode() != null) {
				dto.setEmployeeNo(entity.getEmployee().getEmployeeCode());
			}
		}
		if (!PvuUtils.isEmpty(entity.getPayBandId())) {
			dto.setPayBandId(entity.getPayBandId().getId());
		}
		if (!PvuUtils.isEmpty(entity.getGradePayId())) {
			dto.setGradePayId(entity.getGradePayId().getId());
		}
		if (!PvuUtils.isEmpty(entity.getPayLevelId())) {
			dto.setPayLevelId(entity.getPayLevelId().getId());
		}
		if (!PvuUtils.isEmpty(entity.getCellId())) {
			dto.setCellId(entity.getCellId().getId());
		}
		dto.setEventCode(PvuConstant.EVENT_CODE_CAREER_ADVANCE);
		if (!Utils.isEmpty(entity.getPayBandValue())) {
			dto.setPayBandValue(entity.getPayBandValue());
		}
		if (!Utils.isEmpty(entity.getPayScale())) {
			dto.setPayScale(entity.getPayScale().getPayScaleId());
		}
		if (!Utils.isEmpty(entity.getCurrentDetailsEventId())) {
			dto.setCurrentDetailsEventId(entity.getCurrentDetailsEventId());
		}
		setRemarkAndReason(entity, dto);
		BeanUtils.copyProperties(entity, dto);
		return dto;

	}

	/**
	 * Sets the remark and reason.
	 *
	 * @param entity the entity
	 * @param dto    the dto
	 */
	private void setRemarkAndReason(PVUCareerAdvancementEntity entity, PVUCareerAdvancementDto dto) {
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
	}

	/**
	 * To entity print.
	 *
	 * @param dto the dto
	 * @return the PVU print endorsement entity
	 */
	public PVUPrintEndorsementEntity toEntityPrint(PVUPrintEndorsementDto dto) {
		PVUPrintEndorsementEntity entity = new PVUPrintEndorsementEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO print.
	 *
	 * @param entity the entity
	 * @return the PVU print endorsement dto
	 */
	public PVUPrintEndorsementDto toDTOPrint(PVUPrintEndorsementEntity entity) {
		PVUPrintEndorsementDto dto = new PVUPrintEndorsementDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * Prints the.
	 *
	 * @param entity the entity
	 * @param dto    the dto
	 * @return the PVUCAS print dto
	 */
	public PVUCASPrintDto print(PVUCareerAdvancementEntity entity, PVUCASPrintDto dto,PVUCommonApiDto common) {
		if (entity.getEmployee() != null) {
			dto.setEmployeeNo(entity.getEmployee().getEmployeeCode());
			dto.setFirstName(entity.getEmployee().getEmployeeName());
			dto.setMiddleName(entity.getEmployee().getEmployeeMiddleName());
			dto.setSurname(entity.getEmployee().getEmployeeSurname());
			if (entity.getEmployee().getSalutation() != null) {
				dto.setSalutation(entity.getEmployee().getSalutation().getLookUpInfoName());
			}
			dto.setDesignation(entity.getDesignationId().getDesignationName());
			dto.setOfficeName(entity.getOfficeId().getOfficeName());
			dto.setAuthorizerRemark(entity.getAuthorizerRemark());
			// years
			if (entity.getEmployee().getGender() != null) {
				dto.setGender(entity.getEmployee().getGender().getLookUpInfoName());
				if (dto.getGender().equalsIgnoreCase("Male")) {
					dto.setGenderHeShePrefix("He");
					dto.setGenderHisHerPrefix("His");
				} else {
					dto.setGenderHeShePrefix("She");
					dto.setGenderHisHerPrefix("Her");
				}
			}

			dto.setEventName(PvuConstant.EVENT_NAME_CAREER_ADVANCE);

			dto.setEventEffectiveDate(PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getEventEffectiveDate()));
			String gender = entity.getEmployee().getGender().getLookUpInfoName();
			if (gender.equalsIgnoreCase("Male")) {
				dto.setGenderHeShePrefix("He");
				dto.setGenderHisHerPrefix("His");
			} else {
				dto.setGenderHeShePrefix("Female");
				dto.setGenderHisHerPrefix("Her");
			}
		}
		dto.setBasicPay(entity.getBasicPay());
		if(entity.getDateOfNextIncrement()!=null) {
			dto.setDateOfNextIncrement(PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getDateOfNextIncrement()));
		}
		
		if(entity.getOptionAvailableDate()!=null) {
			dto.setOptionDate(PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getOptionAvailableDate()));
		}else {
			dto.setOptionDate(null);
		}
		if (common.getPayCommId().equals(PvuConstant.FIFTH_COMMISSION_ID)) {
			dto.setCurrentScaleName(common.getPayScaleName());
			dto.setScaleName(entity.getPayScale().getPayScaleDispVal());
		} else if (common.getPayCommId().equals(PvuConstant.SIXTH_COMMISSION_ID)) {
			dto.setCurrentPayBandValue(common.getPayBandValue());
			dto.setPayBandValue(entity.getPayBandValue());
			dto.setCurrentGradePay(common.getGradePayName());
			dto.setGradePay(entity.getGradePayId().getGradePayValue());
			dto.setCurrentPayBand(common.getPayBandName());
			dto.setPayBand(entity.getPayBandId().getPayBandDispVal());
		} else if (common.getPayCommId().equals(PvuConstant.SEVENTH_COMMISSION_ID)) {
			dto.setCurrentPayLevel(common.getPayLevelName());
			dto.setPayLevel(entity.getPayLevelId().getPayLevelValue());
			dto.setCellIdValue(entity.getCellId().getCellId());
			dto.setCellName(entity.getCellId().getCellValue());
		}
		return dto;
	}

	/**
	 * To print endorsement dto.
	 *
	 * @param source the source
	 * @return the PVU print endorsement dto
	 */
	public PVUPrintEndorsementDto toPrintEndorsementDto(PVUPrintEndorsementEntity source) {
		PVUPrintEndorsementDto target = new PVUPrintEndorsementDto();
		BeanUtils.copyProperties(source, target);
		return target;
	}

}
