package gov.ifms.pvu.converter;

import java.time.LocalDate;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.dto.PVUDeemedDateDto;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUDeemedDateEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUDeemedDateConverter class.
 */
@Component
public class PVUDeemedDateConverter extends BasePVUPfConverter<PVUDeemedDateEntity, PVUDeemedDateDto> {

	@Override
	PVUDeemedDateEntity createEntity() {
		return new PVUDeemedDateEntity();
	}

	@Override
	PVUDeemedDateDto createDTO() {
		return new PVUDeemedDateDto();
	}

	@Autowired
	private PVUMsPayScaleRepository payscaleRepository;
	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUDeemedDateEntity entity
	 */
	@Override
	public PVUDeemedDateEntity toEntity(PVUDeemedDateDto dto) {
		PVUDeemedDateEntity entity = this.toCurrentDetailsEntity(dto);
		BeanUtils.copyProperties(dto, entity);
		if (dto.getDesignationId() != 0) {
			entity.setDesignation(new EDPMsDesignationEntity(dto.getDesignationId()));
		}
		if (dto.getEmployeeId() != 0) {
			entity.setEmployee(new PVUEmployeEntity(dto.getEmployeeId()));

		}
		if (dto.getStatusId() != 0) {
			entity.setStatus(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (dto.getEmployeeClassId() != 0) {
			entity.setEmployeeClass(new EDPLuLookUpInfoEntity(dto.getEmployeeClassId()));
		}

		if (dto.getPayLevelId() != 0) {
			entity.setPayLevelId(new PVUMsPayLevelEntity(dto.getPayLevelId()));
		}
		if (dto.getGradePayId() != 0) {
			entity.setGradePay(new PVUMsGradePayEntity(dto.getGradePayId()));
		}
		if (dto.getOfficeId() != 0) {
			entity.setOffice(new EDPMsOfficeEntity(dto.getOfficeId()));
		}
		if (dto.getOptionAvailableId() != 0) {
			entity.setOptionAvailable(new EDPLuLookUpInfoEntity(dto.getOptionAvailableId()));
		}
		if (dto.getPayBandId() != 0) {
			entity.setPayBand(new PVUMsPayBandEntity(dto.getPayBandId()));
		}
		if (dto.getPayCommId() != 0) {
			entity.setPayComm(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		}
		if (dto.getAgainstEmployeeId() != 0) {
			entity.setAgainstEmployee(new PVUEmployeEntity(dto.getAgainstEmployeeId()));
		}

		if (dto.getCellId() != 0) {
			entity.setCellId(new PVUMsPayCellEntity(dto.getCellId()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUDeemedDateDto dto
	 */
	@Override
	public PVUDeemedDateDto toDTO(PVUDeemedDateEntity entity) {
		return converterDto(entity);
	}

	/**
	 * @param entity
	 * @return
	 */
	private PVUDeemedDateDto converterDto(PVUDeemedDateEntity entity) {
		PVUDeemedDateDto dto = this.toCurrentDetailsDTO(entity);
		BeanUtils.copyProperties(entity, dto);
		conDto(entity, dto);
		if (entity.getEmployeeClass() != null) {
			dto.setEmployeeClassId(entity.getEmployeeClass().getLookUpInfoId());
		}
		if (entity.getGradePay() != null) {
			dto.setGradePayId(entity.getGradePay().getId());
			if (entity.getGradePay().getGradePayValue() != null) {
				dto.setGradePayName(entity.getGradePay().getGradePayValue());
			}
		}
		if (entity.getOffice() != null) {
			dto.setOfficeId(entity.getOffice().getOfficeId());
		}
		if (entity.getOptionAvailable() != null) {
			dto.setOptionAvailableId(entity.getOptionAvailable().getLookUpInfoId());
		}
		if (entity.getPayBand() != null) {
			dto.setPayBandId(entity.getPayBand().getId());
			if (entity.getPayBand().getPayBandDispVal() != null) {
				dto.setPayBandName(entity.getPayBand().getPayBandDispVal());
			}
		}
		if (entity.getPayComm() != null) {
			dto.setPayCommId(entity.getPayComm().getLookUpInfoId());
		}
		if (entity.getAgainstEmployee() != null) {
			dto.setAgainstEmployeeId(entity.getAgainstEmployee().getEmpId());
		}
		if (entity.getAgainstEmployee() != null && entity.getAgainstEmployee().getEmployeeCode() != null) {
			dto.setAgainstEmployeeNo(entity.getAgainstEmployee().getEmployeeCode());
		}

		if (entity.getCellId() != null) {
			dto.setCellId(entity.getCellId().getId());
		}

		if (entity.getPayLevelId() != null) {
			dto.setPayLevelId(entity.getPayLevelId().getId());
			if (entity.getPayLevelId().getPayLevelValue() != null) {
				dto.setPayLevelName(entity.getPayLevelId().getPayLevelValue());
			}
		}
		return dto;
	}
	
	/**
	 * Gets the pay scale value.
	 *
	 * @param payScale the pay scale
	 * @return the pay scale value
	 */
	private String getPayScaleValue(Long payScale) {
		Optional<PVUMsPayScaleEntity> payscale = payscaleRepository.findById(payScale);
		return payscale.isPresent() ? payscale.get().getScaleValue() : "";
	}

	/**
	 * @param entity
	 * @param dto
	 */
	private void conDto(PVUDeemedDateEntity entity, PVUDeemedDateDto dto) {
		if (entity.getDesignation() != null) {
			dto.setDesignationId(entity.getDesignation().getDesignationId());
		}
		if (entity.getEmployee() != null) {
			dto.setEmployeeId(entity.getEmployee().getEmpId());

		}
		if (entity.getEmployee() != null && entity.getEmployee().getEmployeeCode() != null) {
			dto.setEmployeeNo(entity.getEmployee().getEmployeeCode());
		}

		if (entity.getStatus() != null) {
			dto.setStatusId(entity.getStatus().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getPayScale())) {
			dto.setPayScale(entity.getPayScale());
			dto.setScaleName(getPayScaleValue(entity.getPayScale()));
		}
	}

	public VelocityContext populateVContext(PVUDeemedDateEntity entity) {
		VelocityContext context = new VelocityContext();

		context.put("EVENT_NAME", PvuConstant.EVENT_NAME_DEEMED_DATE);
		context.put("OFFICE_NAME", entity.getOffice().getOfficeName());
		context.put("OFFICE_ADDRESS", entity.getOffice().getAddrLine1());
		context.put("TRANSACION_NO", entity.getTrnNo());
		context.put("TRANSACION_DATE", PvuUtils.getStrOfLocalDateInDDMMYYYY(LocalDate.now()));
		context.put("ORDER_NO", entity.getEventOrderNo());
		context.put("DESIGNATION", entity.getDesignation().getDesignationName());
		context.put("EMPLOYEE_NO", entity.getEmployee().getEmployeeCode());
		context.put("BASIC_PAY", entity.getBasicPay());

		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			context.put("CURRENT_PAY_LEVEL", entity.getcPayLevel().getPayLevelValue());
			context.put("PAY_LEVEL", entity.getPayLevelId().getPayLevelValue());
			context.put("CURRENT_CELL_ID", entity.getcCell().getCellId());
			context.put("CELL_ID", entity.getCellId().getCellId());

			context.put("CURRENT_PAY_RANGE", entity.getcPayLevel().getPayLevelValue());// need to change
			context.put("PAY_RANGE", entity.getPayLevelId().getPayLevelValue());// need to change

			context.put("CURRENT_PAY_IN_LEVEL", entity.getcPayLevel().getPayLevelValue());// need to change
			context.put("PAY_IN_LEVEL", entity.getPayLevelId().getPayLevelValue());// need to change
		} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {

			context.put("CURRENT_PAY_BAND", entity.getcGradePay().getGradePayValue());
			context.put("PAY_BAND", entity.getGradePay().getGradePayValue());

			context.put("CURRENT_PAY_BAND_VALUE", entity.getcPayBandValue());
			context.put("PAY_BAND_VALUE", entity.getPayBandValue());

			context.put("CURRENT_GRADE_PAY", entity.getcGradePay().getGradePayValue());
			context.put("GRADE_PAY", entity.getGradePay().getGradePayValue());

			context.put("CURRENT_BASIC_PAY", entity.getcBasicPay());

		} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			context.put("CURRENT_PAYSCALE", entity.getcPayScale().getScaleValue());
			context.put("CURRENT_BASIC_PAY", entity.getcBasicPay());
		}

		context.put("CURRENT_DNI", PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getDateOfNextIncrement()));
		context.put("DNI", PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getcDateOfNextIncrement()));
		context.put("EVENT_EFFECTIVE_DATE", PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getEventEffectiveDate()));
		context.put("YesNo", entity.getOptionAvailable().getLookUpInfoName());
		context.put("hisher",
				entity.getEmployee().getGender().getLookUpInfoName().equalsIgnoreCase("Male") ? "his" : "her");
		context.put("heshe",
				entity.getEmployee().getGender().getLookUpInfoName().equalsIgnoreCase("Male") ? "he" : "she");

		context.put("J_EMPLOYEE_NO", entity.getAgainstEmployee().getEmployeeCode());
		String jrSaluation = "";
		if (!Utils.isEmpty(entity.getAgainstEmployee().getSalutation())) {
			jrSaluation = entity.getAgainstEmployee().getSalutation().getLookUpInfoName();
		}
		context.put("J_EMPLOYEE_NAME",
				jrSaluation + " " + entity.getAgainstEmployee().getEmployeeName() + " "
						+ entity.getAgainstEmployee().getEmployeeMiddleName() + " "
						+ entity.getAgainstEmployee().getEmployeeSurname());

		String srSaluation = "";
		if (!Utils.isEmpty(entity.getEmployee().getSalutation())) {
			srSaluation = entity.getEmployee().getSalutation().getLookUpInfoName();
		}

		context.put("EMPLOYEE_NAME", srSaluation + " " + entity.getEmployee().getEmployeeName() + " "
				+ entity.getEmployee().getEmployeeMiddleName() + " " + entity.getEmployee().getEmployeeSurname());

		return context;

	}

	public VelocityContext comparisionReport(PVUDeemedDateEntity entity, PVUCommonApiDto pvuCommonApiDto) {
		VelocityContext context = new VelocityContext();
		context.put("EVENT_NAME", PvuConstant.EVENT_NAME_DEEMED);
		context.put("OFFICE_NAME", entity.getOffice().getOfficeName());
		context.put("OFFICE_ADDRESS", entity.getOffice().getAddrLine1());

		context.put("sr_revised_pay_fixation_date",
				!Utils.isEmpty(entity.getEventEffectiveDate())
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getEventEffectiveDate())
						: "");
		context.put("sr_event_effective_date",
				!Utils.isEmpty(entity.getEventEffectiveDate())
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getEventEffectiveDate())
						: "");

		context.put("sr_next_increment_date",
				!Utils.isEmpty(entity.getDateOfNextIncrement())
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getDateOfNextIncrement())
						: "");

		context.put("sr_seniority_no", !Utils.isEmpty(entity.getSrSeniorNo()) ? entity.getSrSeniorNo() : "");

		context.put("jn_seniority_no", !Utils.isEmpty(entity.getJrSeniorNo()) ? entity.getJrSeniorNo() : "");

		context.put("sr_emp_doj",
				!Utils.isEmpty(entity.getcDateOfJoining())
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getcDateOfJoining())
						: "");

		context.put("jn_emp_doj",
				!Utils.isEmpty(pvuCommonApiDto.getDateJoining())
						? PvuUtils.getDateToStringDMYFormatValue(pvuCommonApiDto.getDateJoining())
						: "");

		context.put("sr_emp_designation",
				!Utils.isEmpty(entity.getDesignation()) ? entity.getDesignation().getDesignationName() : "");

		context.put("sr_current_basic_pay", !Utils.isEmpty(entity.getcBasicPay()) ? entity.getcBasicPay() : "");

		context.put("sr_revised_basic_pay", !Utils.isEmpty(entity.getBasicPay()) ? entity.getBasicPay() : "");

		context.put("jn_current_basic_pay",
				!Utils.isEmpty(pvuCommonApiDto.getEmpBasicPay()) ? pvuCommonApiDto.getEmpBasicPay() : "");

		if (!Utils.isEmpty(pvuCommonApiDto.getEmpBasicPay())) {
			String jrSaluation = "";
			if (!Utils.isEmpty(entity.getAgainstEmployee().getSalutation())) {
				jrSaluation = entity.getAgainstEmployee().getSalutation().getLookUpInfoName();
			}

			context.put("jn_emp_name",
					jrSaluation + " " + StringUtils.defaultString(entity.getAgainstEmployee().getEmployeeName()) + " "
							+ StringUtils.defaultString(entity.getAgainstEmployee().getEmployeeMiddleName()) + " "
							+ StringUtils.defaultString(entity.getAgainstEmployee().getEmployeeSurname()));
		} else {
			context.put("jn_emp_name", "");
		}

		
		return comparisionSubReport(entity, pvuCommonApiDto, context);

	}

	public VelocityContext comparisionSubReport(PVUDeemedDateEntity entity, PVUCommonApiDto pvuCommonApiDto,
			VelocityContext context) {

		String srSaluation = "";
		if (!Utils.isEmpty(entity.getEmployee().getSalutation())) {
			srSaluation = entity.getEmployee().getSalutation().getLookUpInfoName();
		}

		context.put("sr_emp_name",
				srSaluation + " " + StringUtils.defaultString(entity.getEmployee().getEmployeeName()) + " "
						+ StringUtils.defaultString(entity.getEmployee().getEmployeeMiddleName()) + " "
						+ StringUtils.defaultString(entity.getEmployee().getEmployeeSurname()));
		
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {

			context.put("sr_current_pay_level",
					!Utils.isEmpty(entity.getcPayLevel()) ? entity.getcPayLevel().getPayLevelValue() : "");

			context.put("sr_revised_pay_level",
					!Utils.isEmpty(entity.getPayLevelId()) ? entity.getPayLevelId().getPayLevelValue() : "");

			context.put("sr_current_cell_id", !Utils.isEmpty(entity.getcCell()) ? entity.getcCell().getCellId() : "");

			context.put("sr_revised_cell_id", !Utils.isEmpty(entity.getCellId()) ? entity.getCellId().getCellId() : "");

			context.put("jn_current_pay_level",
					!Utils.isEmpty(pvuCommonApiDto.getPayLevelName()) ? pvuCommonApiDto.getPayLevelName() : "");

			context.put("jn_current_cell_id",
					!Utils.isEmpty(pvuCommonApiDto.getCellName()) ? pvuCommonApiDto.getCellName() : "");

			context.put("seventhPay", PvuConstant.SEVENTH_COMMISSION_ID);

		}
		return comparisionSubReports(entity, pvuCommonApiDto, context);
	}

	public VelocityContext comparisionSubReports(PVUDeemedDateEntity entity, PVUCommonApiDto pvuCommonApiDto,
			VelocityContext context) {
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {

			context.put("sr_current_pay_band",
					!Utils.isEmpty(entity.getcPayBand()) ? entity.getcPayBand().getPayBandDispVal() : "");

			context.put("sr_revised_pay_band",
					!Utils.isEmpty(entity.getPayBand()) ? entity.getPayBand().getPayBandDispVal() : "");

			context.put("sr_current_grade_pay",
					!Utils.isEmpty(entity.getcGradePay()) ? entity.getcGradePay().getGradePayValue() : "");

			context.put("sr_revised_grade_pay",
					!Utils.isEmpty(entity.getGradePay()) ? entity.getGradePay().getGradePayValue() : "");

			context.put("jn_current_pay_band",
					!Utils.isEmpty(pvuCommonApiDto.getPayBandName()) ? pvuCommonApiDto.getPayBandName() : "");

			context.put("jn_current_grade_pay",
					!Utils.isEmpty(pvuCommonApiDto.getGradePayName()) ? pvuCommonApiDto.getGradePayName() : "");

			context.put("sixthPay", PvuConstant.SIXTH_COMMISSION_ID);

		}
		return comparisionsSubReports(entity, pvuCommonApiDto, context);
	}

	public VelocityContext comparisionsSubReports(PVUDeemedDateEntity entity, PVUCommonApiDto pvuCommonApiDto,
			VelocityContext context) {
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {

			context.put("sr_current_pay_scale",
					!Utils.isEmpty(entity.getcPayScale()) ? entity.getcPayScale().getScaleValue() : "");

			context.put("jn_current_pay_scale",
					!Utils.isEmpty(pvuCommonApiDto.getPayScaleName()) ? pvuCommonApiDto.getPayScaleName() : "");

			context.put("fifthPay", PvuConstant.FIFTH_COMMISSION_ID);
		}
		return context;
	}
}
