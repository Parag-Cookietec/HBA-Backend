package gov.ifms.pvu.converter;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.dto.PVUEmployeSuspensionDto;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeSuspensionEntity;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeSuspensionConverter class.
 *
 * @version 1.0
 * @created 2019/12/12 15:52:48
 */
@Component
public class PVUEmployeSuspensionConverter
		implements BaseConverter<PVUEmployeSuspensionEntity, PVUEmployeSuspensionDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeSuspension entity
	 */
	@Autowired
	PVUSuspensionPayDetailsConverter payDetailsConverter;

	@Override
	public PVUEmployeSuspensionEntity toEntity(PVUEmployeSuspensionDto dto) {
		PVUEmployeSuspensionEntity entity = new PVUEmployeSuspensionEntity();
		BeanUtils.copyProperties(dto, entity);
		if (dto.getEmpId() != 0) {
			entity.setEmployee(new PVUEmployeEntity(dto.getEmpId()));
			if (dto.getEmployeeNumber() != null && dto.getEmployeeNumber() != 0) {
				entity.getEmployee().setEmployeeCode(dto.getEmployeeNumber());
			}
		}
		if (dto.getOfficeId() != 0) {
			entity.setOffice(new EDPMsOfficeEntity(dto.getOfficeId()));
		}
		if (dto.getPayCommission() != 0) {
			entity.setPayCommission(new EDPLuLookUpInfoEntity(dto.getPayCommission()));
		}
		if (dto.getStatusId() != 0) {
			entity.setStatus(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (dto.getReasonForSus() != 0) {
			entity.setReasonForSus(new EDPLuLookUpInfoEntity(dto.getReasonForSus()));
		}
		if (dto.getPayDetailsDtos() != null) {
			entity.addSuspension(payDetailsConverter.toEntity(dto.getPayDetailsDtos()));
		}
		if (dto.isSuspensionClosure()) {
			if (dto.getClosureId() != 0) {
				entity.setClosure(new EDPLuLookUpInfoEntity(dto.getClosureId()));
			}
			if (dto.getReinstateFlagId() != 0) {
				entity.setReinstateFlag(new EDPLuLookUpInfoEntity(dto.getReinstateFlagId()));
			}
		}

		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeSuspension dto
	 */
	@Override
	public PVUEmployeSuspensionDto toDTO(PVUEmployeSuspensionEntity entity) {
		PVUEmployeSuspensionDto dto = new PVUEmployeSuspensionDto();
		BeanUtils.copyProperties(entity, dto);
		if (entity.getEmployee() != null) {
			dto.setEmpId(entity.getEmployee().getEmpId());
			if (entity.getEmployee().getEmployeeCode() != null) {
				dto.setEmployeeNumber(entity.getEmployee().getEmployeeCode());
			}
		}
		if (entity.getOffice() != null) {
			dto.setOfficeId(entity.getOffice().getOfficeId());
		}
		if (entity.getPayCommission() != null) {
			dto.setPayCommission(entity.getPayCommission().getLookUpInfoId());
		}
		if (entity.getStatus() != null) {
			dto.setStatusId(entity.getStatus().getLookUpInfoId());
		}
		if (entity.getReasonForSus() != null) {
			dto.setReasonForSus(entity.getReasonForSus().getLookUpInfoId());
		}
		if (entity.getPayDetailsEntity() != null) {
			dto.setPayDetailsDtos(payDetailsConverter.toDTO(entity.getPayDetailsEntity()));
		}
		if (dto.isSuspensionClosure()) {
			if (entity.getClosure() != null) {
				dto.setClosureId(entity.getClosure().getLookUpInfoId());
			}
			if (entity.getReinstateFlag() != null) {
				dto.setReinstateFlagId(entity.getReinstateFlag().getLookUpInfoId());
			}
		}

		return dto;
	}

	public VelocityContext populateVContext(PVUEmployeSuspensionEntity entity, PVUCommonApiDto pvuCommonApiDto) {
		VelocityContext context = new VelocityContext();

		if (!Utils.isEmpty(entity.getOffice())) {
			context.put("officeName", entity.getOffice().getOfficeName());
			context.put("officeAddress", entity.getOffice().getAddrLine1());
		}
		context.put("eventName", PvuConstant.EVENT_CODE_SUSPENSION);
		if (!Utils.isEmpty(entity.getTrnNo())) {
			context.put("trnNo", entity.getTrnNo());
		}
		if (!Utils.isEmpty(entity.getUpdatedDate())) {
			context.put("trnDate", Utils.getDateString(entity.getUpdatedDate()));
		}
		if (!Utils.isEmpty(entity.getTrnNo())) {
			context.put("designation", pvuCommonApiDto.getDesignationName());
		}
		if (!Utils.isEmpty(pvuCommonApiDto.getEmployeeClass())) {
			context.put("employeeClass", pvuCommonApiDto.getEmployeeClass());
		}
		if (!Utils.isEmpty(entity.getReasonForSus())) {
			context.put("suspensionReason", entity.getReasonForSus().getLookUpInfoName());
		}
		if (!Utils.isEmpty(entity.getSusEventDate())) {
			context.put("suspensionEffectiveDate", PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getSusEventDate()));
		}

		if (!Utils.isEmpty(entity.getSusEndDate())) {
			context.put("suspensionEndDate", PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getSusEndDate()));
		}

		String srSaluation = "";
		if (!Utils.isEmpty(entity.getEmployee().getSalutation())) {
			srSaluation = entity.getEmployee().getSalutation().getLookUpInfoName();
		}
		context.put("hisher",
				entity.getEmployee().getGender().getLookUpInfoName().equalsIgnoreCase("Male") ? "His" : "Her");
		context.put("heshe",
				entity.getEmployee().getGender().getLookUpInfoName().equalsIgnoreCase("Male") ? "he" : "she");

		context.put("employeeName",
				srSaluation + " " + StringUtils.defaultString(entity.getEmployee().getEmployeeName()) + " "
						+ StringUtils.defaultString(entity.getEmployee().getEmployeeMiddleName()) + " "
						+ StringUtils.defaultString(entity.getEmployee().getEmployeeSurname()));

		return suspension(entity, pvuCommonApiDto, context);

	}

	private VelocityContext suspension(PVUEmployeSuspensionEntity entity, PVUCommonApiDto pvuCommonApiDto,
			VelocityContext context) {
		final String BASIC_PAY = "basicPay";
		if (!Utils.isEmpty(entity.getReinstateFlag())) {
			context.put("reinstateFlage", entity.getReinstateFlag());
			context.put("hisher",
					entity.getEmployee().getGender().getLookUpInfoName().equalsIgnoreCase("Male") ? "his" : "her");
			context.put(BASIC_PAY, pvuCommonApiDto.getEmpBasicPay());
			if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
				context.put("payLevel", pvuCommonApiDto.getPayLevelName());
				context.put("seventhPay", PvuConstant.SEVENTH_COMMISSION_ID);
			} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
				context.put("payBand", pvuCommonApiDto.getPayBandName());

				context.put("payBandValue", pvuCommonApiDto.getPayBandValue());

				context.put("gradePay", pvuCommonApiDto.getGradePayName());
				context.put("sixthPay", PvuConstant.SEVENTH_COMMISSION_ID);

			} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
				context.put("payScale", pvuCommonApiDto.getPayScaleName());
				context.put("fifthPay", PvuConstant.SEVENTH_COMMISSION_ID);
			} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.FIX_PAY_COMMISSION_ID) {
				context.put("fixPay", PvuConstant.FIX_PAY_COMMISSION_ID);
			}
		} else {
			context.put(BASIC_PAY, entity.getPayDetailsEntity().get(0).getPayableBasicPayAmt());
			if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
				context.put("payLevel", pvuCommonApiDto.getPayLevelName());
				context.put("seventhPay", PvuConstant.SEVENTH_COMMISSION_ID);
			} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
				context.put("payBand", pvuCommonApiDto.getPayBandName());

				context.put("payBandValue", entity.getPayDetailsEntity().get(0).getPayablePayBandAmt());

				context.put("gradePay", entity.getPayDetailsEntity().get(0).getPayableGradePayAmt());

				context.put(BASIC_PAY, entity.getPayDetailsEntity().get(0).getPayableGradePayAmt()
						+ entity.getPayDetailsEntity().get(0).getPayablePayBandAmt());
				context.put("sixthPay", PvuConstant.SEVENTH_COMMISSION_ID);
			} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
				context.put("payScale", pvuCommonApiDto.getPayScaleName());
				context.put("fifthPay", PvuConstant.SEVENTH_COMMISSION_ID);
			} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.FIX_PAY_COMMISSION_ID) {
				context.put("fixPay", PvuConstant.FIX_PAY_COMMISSION_ID);
			}
		}
		return context;
	}

}
