package gov.ifms.pvu.converter;

import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUSSPRemarkRequest;
import gov.ifms.pvu.dto.PVUSeniorScaleDto;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.dto.response.PVUSSPPrintDto;
import gov.ifms.pvu.entity.*;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class PVUSeniorScaleConverter class.
 */
@Component
@Transactional
public class PVUSeniorScaleConverter extends BasePVUPfConverter<PVUSeniorScaleEntity, PVUSeniorScaleDto> {

    @Override
    PVUSeniorScaleEntity createEntity() {
        return new PVUSeniorScaleEntity();
    }

    @Override
    PVUSeniorScaleDto createDTO() {
        return new PVUSeniorScaleDto();
    }

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the PVUSeniorScaleEntity entity
     */
    @Override
    public PVUSeniorScaleEntity toEntity(PVUSeniorScaleDto dto) {
        PVUSeniorScaleEntity entity = this.toCurrentDetailsEntity(dto);
        BeanUtils.copyProperties(dto, entity);
        if (dto.getOfficeId() != 0) {
            entity.setOffice(new EDPMsOfficeEntity(dto.getOfficeId()));
        }
        if (dto.getPayCommId() != 0) {
            entity.setPayComm(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
        }
        if (dto.getStatusId() != 0) {
            entity.setStatus(new EDPLuLookUpInfoEntity(dto.getStatusId()));
        }
        if (dto.getEmployeeId() != 0) {
            entity.setEmployee(new PVUEmployeEntity(dto.getEmployeeId()));
        }
        if (dto.getPayLevelId() != 0) {
            entity.setPayLevel(new PVUMsPayLevelEntity(dto.getPayLevelId()));
        }
        if (dto.getPayBandId() != 0) {
            entity.setPayBand(new PVUMsPayBandEntity(dto.getPayBandId()));
        }
        if (dto.getGradePayId() != 0) {
            entity.setGradePay(new PVUMsGradePayEntity(dto.getGradePayId()));
        }
        if (dto.getCellId() != 0) {
            entity.setCell(new PVUMsPayCellEntity(dto.getCellId()));
        }
        if (dto.getScaleId() != 0) {
            entity.setScale(new PVUMsPayScaleEntity(dto.getScaleId()));
        }
        if (dto.getEventId() != 0) {
            entity.setEvent(new PVUMsEventEntity(dto.getEventId()));
        }
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the PVUSeniorScaleDto dto
     */
    @Override
    public PVUSeniorScaleDto toDTO(PVUSeniorScaleEntity entity) {
        PVUSeniorScaleDto dto = this.toCurrentDetailsDTO(entity);
        BeanUtils.copyProperties(entity, dto);
        if (entity.getEmployee() != null) {
            dto.setEmployeeId(entity.getEmployee().getEmpId());
            if (entity.getEmployee().getEmployeeCode() != null) {
                dto.setEmployeeNo(entity.getEmployee().getEmployeeCode());
            }
        }
        if (entity.getOffice() != null) {
            dto.setOfficeId(entity.getOffice().getOfficeId());
            if (entity.getOffice().getOfficeName() != null) {
                dto.setOfficeName(entity.getOffice().getOfficeName());
            }
        }
        if (entity.getStatus() != null) {
            dto.setStatusId(entity.getStatus().getLookUpInfoId());
        }
        if (entity.getPayComm() != null) {
            dto.setPayCommId(entity.getPayComm().getLookUpInfoId());
        }

        setSixDTO(entity, dto);
        setSevenDTO(entity, dto);
        if (entity.getScale() != null) {
            dto.setScaleId(entity.getScale().getPayScaleId());
            if (entity.getScale().getPayScaleDispVal() != null) {
                dto.setScaleName(entity.getScale().getPayScaleDispVal());
            }
        }
        if (entity.getEvent() != null) {
            dto.setEventId(entity.getEvent().getId());
            if (entity.getEvent().getEventCode() != null) {
                dto.setEventCode(entity.getEvent().getEventCode());
            } else {
                dto.setEventCode(dto.getEventCode());
            }
        }
        return dto;
    }

    private void setSixDTO(PVUSeniorScaleEntity entity, PVUSeniorScaleDto dto) {
        if (entity.getPayBand() != null) {
            dto.setPayBandId(entity.getPayBand().getId());
            if (entity.getPayBand().getPayBandDispVal() != null) {
                dto.setPayBandName(entity.getPayBand().getPayBandDispVal());
            }
        }
        if (entity.getGradePay() != null) {
            dto.setGradePayId(entity.getGradePay().getId());
            if (entity.getGradePay().getGradePayValue() != null) {
                dto.setGradePayName(entity.getGradePay().getGradePayValue());
            }

        }
    }

    private void setSevenDTO(PVUSeniorScaleEntity entity, PVUSeniorScaleDto dto) {
        if (entity.getPayLevel() != null) {
            dto.setPayLevelId(entity.getPayLevel().getId());
            if (entity.getPayLevel().getPayLevelValue() != null) {
                dto.setPayLevelName(entity.getPayLevel().getPayLevelValue());
            }
        }
        if (entity.getCell() != null) {
            dto.setCellId(entity.getCell().getId());
            if (entity.getCell().getCellValue() != 0) {
                dto.setCellName(String.valueOf(entity.getCell().getCellId()));
            }
        }
    }

    public Map<String, String> getEventDetails(PVUSeniorScaleDto dto) {
        Map<String, String> response = new HashMap<>();
        response.put("trnNo", dto.getTrnNo());
        response.put("officeId", dto.getOfficeName());
        response.put("payCommId", PvuUtils.buildCommissionName(dto.getPayCommId()));
        if (dto.getPayCommId() == PvuConstant.SEVENTH_COMMISSION_ID) {
            response.put("payLevelId", dto.getPayLevelName());
            response.put("cellId", String.valueOf(dto.getCellName()));
            response.put("personalPay", String.valueOf(dto.getPersonalPay()));
        } else if (dto.getPayCommId() == PvuConstant.SIXTH_COMMISSION_ID) {
            response.put("payBandId", dto.getPayBandName());
            response.put("payBandValue", String.valueOf(dto.getPayBandValue()));
            response.put("gradePayId", dto.getGradePayName());
        } else if (dto.getPayCommId() == PvuConstant.FIFTH_COMMISSION_ID) {
            response.put("scaleId", dto.getScaleName());
            response.put("personalPay", String.valueOf(dto.getPersonalPay()));
        }
        response.put("eventOrderNo", dto.getEventOrderNo());
        response.put("eventOrderDate", dto.getEventOrderDate().toString());
        response.put("eventEffectiveDate", dto.getEventEffectiveDate().toString());
        response.put("basicPay", String.valueOf(dto.getBasicPay()));
        response.put("remarks", dto.getRemarks());
        response.put("benefitEffectiveDate", dto.getBenefitEffectiveDate().toString());
        response.put("dateOfNextIncrement", dto.getDateOfNextIncrement().toString());
        response.put("employeeNo", String.valueOf(dto.getEmployeeNo()));
        response.put("eventCode", "Senior Scale - PVU");
        return response;
    }

    public PVUSeniorScaleEntity setRemarks(PVUSeniorScaleEntity entity, PVUSSPRemarkRequest dto) {
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

        return entity;
    }

    public PVUSSPPrintDto print(PVUSeniorScaleEntity entity, PVUSSPPrintDto dto,PVUCommonApiDto common) {
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
		
        dto.setEmployeeNo(entity.getEmployee().getEmployeeCode());
		dto.setEmployeeName(srSaluation + " " + entity.getEmployee().getEmployeeName() + " " + middleName + " " + surName);
        dto.setOfficeName(entity.getOffice().getOfficeName());
        dto.setCurrentPayLevel("");
        dto.setAuthorizerRemark(entity.getAuthorizerRemark());
        dto.setEventType("Senior Scale PVU");
        dto.setEventEffectiveDate(PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getEventEffectiveDate()));
        String gender = entity.getEmployee().getGender().getLookUpInfoName();
        if (gender.equalsIgnoreCase("Male")) {
            dto.setGenderHeShePrefix("He");
            dto.setGenderHisHerPrefix("His");
        } else {
            dto.setGenderHeShePrefix("She");
            dto.setGenderHisHerPrefix("Her");
        }
        dto.setBasicPay(entity.getBasicPay());
        dto.setPersonalPay(entity.getPersonalPay());
        dto.setDni(PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getDateOfNextIncrement()));
        if (common.getPayCommId().equals(PvuConstant.FIFTH_COMMISSION_ID)) {
        	dto.setCurrentScaleName(common.getPayScaleName());
        	dto.setScaleName(entity.getScale().getPayScaleDispVal());
		} else if (common.getPayCommId().equals(PvuConstant.SIXTH_COMMISSION_ID)) {
			dto.setCurrentPayBandValue(common.getPayBandValue());
			dto.setPayBandValue(entity.getPayBandValue());
			dto.setCurrentGradePay(common.getGradePayName());
			dto.setGradePay(entity.getGradePay().getGradePayValue());
			dto.setCurrentPayBand(common.getPayBandName());
			dto.setPayBand(entity.getPayBand().getPayBandDispVal());
		} else if (common.getPayCommId().equals(PvuConstant.SEVENTH_COMMISSION_ID)) {
			dto.setCurrentPayLevel(common.getPayLevelName());
			dto.setPayLevel(entity.getPayLevel().getPayLevelValue());

			dto.setCurrentCellId(common.getCellId().toString());
			dto.setCellId(entity.getCell().getCellId());
			dto.setCellIdValue(entity.getCell().getCellValue());
		}
        return dto;
    }

    public PVUPrintEndorsementDto toPrintEndorsementDto(PVUPrintEndorsementEntity source) {
        PVUPrintEndorsementDto target = new PVUPrintEndorsementDto();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public PVUPrintEndorsementItrEntity toEntity(PVUPrintEndorsementEntity printEntity) {
        PVUPrintEndorsementItrEntity entity = new PVUPrintEndorsementItrEntity();
        BeanUtils.copyProperties(printEntity, entity);
        return entity;
    }

    public VelocityContext populateVContext(PVUSeniorScaleEntity entity) {
		VelocityContext context = new VelocityContext();
		
		context.put("EVENT_NAME", PvuConstant.EVENT_NAME_SENIOR_SCALE);
		context.put("OFFICE_NAME", entity.getOffice().getOfficeName());
		context.put("OFFICE_ADDRESS", entity.getOffice().getAddrLine1());
		context.put("TRANSACION_NO", !Utils.isEmpty(entity.getTrnNo()) ? entity.getTrnNo() : "");
		context.put("TRANSACION_DATE",
				entity.getAuthorizeDate() != null
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getAuthorizeDate().toLocalDate())
						: PvuUtils.getDateToStringDMYFormatValue(new Date()));
		context.put("ORDER_NO", entity.getEventOrderNo());
		context.put("EMPLOYEE_NO", entity.getEmployee().getEmployeeCode());
		context.put("BASIC_PAY", !Utils.isEmpty(entity.getBasicPay()) ? entity.getBasicPay() : "");

		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			context.put("CURRENT_PAY_LEVEL",
					!Utils.isEmpty(entity.getcPayLevel()) ? entity.getcPayLevel().getPayLevelValue() : "");
			context.put("PAY_LEVEL",
					!Utils.isEmpty(entity.getPayLevel()) ? entity.getPayLevel().getPayLevelValue() : "");
			context.put("CURRENT_CELL_ID", !Utils.isEmpty(entity.getcCell()) ? entity.getcCell().getCellId() : "");
			context.put("CELL_ID", !Utils.isEmpty(entity.getCell()) ? entity.getCell().getCellId() : "");

		} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {

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

			context.put("CURRENT_BASIC_PAY", !Utils.isEmpty(entity.getcBasicPay()) ? entity.getcBasicPay() : "");

		} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			context.put("CURRENT_PAYSCALE",
					!Utils.isEmpty(entity.getcPayScale()) ? entity.getcPayScale().getScaleValue() : "");
			context.put("PAYSCALE", !Utils.isEmpty(entity.getScale()) ? entity.getScale().getScaleValue() : "");
			context.put("CURRENT_BASIC_PAY", !Utils.isEmpty(entity.getcBasicPay()) ? entity.getcBasicPay() : "");
			context.put("BASIC_PAY", !Utils.isEmpty(entity.getBasicPay()) ? entity.getBasicPay() : "");
			civilServiceDetailsByDate(entity, context);
		}
		context.put("PERSONAL_PAY", !Utils.isEmpty(entity.getPersonalPay()) ? entity.getPersonalPay() : "");
		context.put("CURRENT_DNI",
				!Utils.isEmpty(entity.getDateOfNextIncrement())
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getDateOfNextIncrement())
						: "");
		context.put("DNI",
				!Utils.isEmpty(entity.getcDateOfNextIncrement())
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getcDateOfNextIncrement())
						: "");
		context.put("EVENT_EFFECTIVE_DATE",
				!Utils.isEmpty(entity.getEventEffectiveDate())
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getEventEffectiveDate())
						: "");
		context.put("hisher",
				entity.getEmployee().getGender().getLookUpInfoName().equalsIgnoreCase("Male") ? "his" : "her");
		context.put("heshe",
				entity.getEmployee().getGender().getLookUpInfoName().equalsIgnoreCase("Male") ? "he" : "she");

		String srSaluation="";
		if(!Utils.isEmpty(entity.getEmployee().getSalutation()) ) {
			srSaluation=entity.getEmployee().getSalutation().getLookUpInfoName();
		}
		context.put("EMPLOYEE_NAME", srSaluation +" "+	StringUtils.defaultString(entity.getEmployee().getEmployeeName())+" "+
														StringUtils.defaultString(entity.getEmployee().getEmployeeMiddleName())+" "+
														StringUtils.defaultString(entity.getEmployee().getEmployeeSurname()));
		return context;
		
	}

	private void civilServiceDetailsByDate(PVUSeniorScaleEntity entity, VelocityContext context) {
		boolean diff = PvuUtils.compareToLocalDate( entity.getEventEffectiveDate(),PvuUtils.getDateFromStringYMD(PvuConstant.EVENT_EFFICTED_DATE_5_PAY));
		if(diff) {
			context.put("CIVIL", PvuConstant.G_CIVIL);
			context.put("CIVIL_SUB", PvuConstant.G_CIVIL_SUB);
			context.put("PRA_CIVIL", PvuConstant.G_PRA_CIVIL);
		}else {
			context.put("CIVIL", PvuConstant.B_CIVIL);
			context.put("CIVIL_SUB", PvuConstant.B_CIVIL_SUB);
			context.put("PRA_CIVIL", PvuConstant.B_PRA_CIVIL);
		}
	}
}
