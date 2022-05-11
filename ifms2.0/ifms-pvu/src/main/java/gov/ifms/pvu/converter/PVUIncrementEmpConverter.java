package gov.ifms.pvu.converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.dto.PVUIncrementEmpDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUIncrementEmpEntity;
import gov.ifms.pvu.entity.PVUIncrementEventEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUIncrementEmpConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/12 19:19:14
 *
 */
@Component
public class PVUIncrementEmpConverter implements BaseConverter<PVUIncrementEmpEntity, PVUIncrementEmpDto> {

	private final String CURRENT_PAY_DRAWN_DATE = "CURRENT_PAY_DRAWN_DATE";

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUIncrementEmp entity
	 */
	@Override
	public PVUIncrementEmpEntity toEntity(PVUIncrementEmpDto dto) {
		PVUIncrementEmpEntity entity = new PVUIncrementEmpEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setInEventId(new PVUIncrementEventEntity(dto.getInEventId()));
		if (!Utils.isEmpty(dto.getEmpId())) {
			entity.setEmpId(new PVUEmployeEntity(dto.getEmpId()));
		}

		copyCurrentDetailDtoToEntity(dto, entity);

		if (!Utils.isEmpty(dto.getRevPayLevel())) {
			entity.setRevPayLevel(new PVUMsPayLevelEntity(dto.getRevPayLevel()));
		}

		if (!Utils.isEmpty(dto.getRevCellId())) {
			entity.setRevCellId(new PVUMsPayCellEntity(dto.getRevCellId()));
		}

		entity.setRevGrade(dto.getRevGrade());

		if (!Utils.isEmpty(dto.getRevPayBand())) {
			entity.setRevPayBand(new PVUMsPayBandEntity(dto.getRevPayBand()));
		}

		if (!Utils.isEmpty(dto.getRevGradePay())) {
			entity.setRevGradePay(new PVUMsGradePayEntity(dto.getRevGradePay()));
		}
		if (!Utils.isEmpty(dto.getRevGradePay())) {
			entity.setRevBasicPay(dto.getRevBasicPay());
		}

		entity.setRevEffDate(dto.getRevEffDate());
		entity.setRevDateNexInc(dto.getRevDateNexInc());
		entity.setDiffAmt(dto.getDiffAmt());

		if (!Utils.isEmpty(dto.getReasonForExclude())) {
			entity.setReasonForExclude(new EDPLuLookUpInfoEntity(dto.getReasonForExclude()));
		}
		entity.setRemarks(dto.getRemarks());

		if (!Utils.isEmpty(dto.getStatusId())) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}

		if (!Utils.isEmpty(dto.getStopIncrementType())) {
			entity.setStopIncrementType(new EDPLuLookUpInfoEntity(dto.getStopIncrementType()));
		}

		entity.setStopIncFromDate(dto.getStopIncFromDate());
		entity.setStopIncToDate(dto.getStopIncToDate());
		entity.setDateNxtInc(dto.getDateNxtInc());

		if (!Utils.isEmpty(dto.getClassId())) {
			entity.setClassId(new EDPLuLookUpInfoEntity(dto.getClassId()));
		}

		if (!Utils.isEmpty(dto.getEmpType())) {
			entity.setEmpType(new EDPLuLookUpInfoEntity(dto.getEmpType()));
		}

		if (!Utils.isEmpty(dto.getDesignationId())) {
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		}

		entity.setGpf(dto.getGpf());

		entity.setCreatedDate(new Date());
		entity.setUpdatedDate(new Date());
		entity.setCreatedByPost(OAuthUtility.getCurrentUserUserId());
		entity.setUpdatedBy(OAuthUtility.getCurrentUserUserId());
		entity.setUpdatedByPost(OAuthUtility.getCurrentUserUserId());
		entity.setCreatedBy(OAuthUtility.getCurrentUserUserId());
		entity.setActiveStatus(Constant.ACTIVE_STATUS);

		if (!Utils.isEmpty(dto.getRevScale())) {
			entity.setRevScale(new PVUMsPayScaleEntity(dto.getRevScale()));
		}

		entity.setSystemExcluded(dto.getSystemExcluded());
		return entity;
	}

	private void copyCurrentDetailDtoToEntity(PVUIncrementEmpDto dto, PVUIncrementEmpEntity entity) {
		if (!Utils.isEmpty(dto.getCurPayLevel())) {
			entity.setCurPayLevel(new PVUMsPayLevelEntity(dto.getCurPayLevel()));
		}

		if (!Utils.isEmpty(dto.getCurCellId())) {
			entity.setCurCellId(new PVUMsPayCellEntity(dto.getCurCellId()));
		}

		entity.setCurGrade(dto.getCurGrade());
		entity.setCurPayBandValue(dto.getCurPayBandValue());

		if (!Utils.isEmpty(dto.getCurGradePay())) {
			entity.setCurGradePay(new PVUMsGradePayEntity(dto.getCurGradePay()));
		}

		if (!Utils.isEmpty(dto.getCurPayBand())) {
			entity.setCurPayBand(new PVUMsPayBandEntity(dto.getCurPayBand()));
		}
		if (!Utils.isEmpty(dto.getCurScale())) {
			entity.setCurScale(new PVUMsPayScaleEntity(dto.getCurScale()));
		}

		entity.setCurBasicPay(dto.getCurBasicPay());
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUIncrementEmp dto
	 */
	@Override
	public PVUIncrementEmpDto toDTO(PVUIncrementEmpEntity entity) {
		PVUIncrementEmpDto dto = new PVUIncrementEmpDto();
		if (!Utils.isEmpty(entity.getInEventId())) {
			dto.setInEventId(entity.getInEventId().getInEventId());
		}

		if (!Utils.isEmpty(entity.getEmpId())) {
			dto.setEmpId(entity.getEmpId().getEmpId());
		}

		copyCurrentDetailEntityToDto(entity, dto);
		copyRevisedDetailEntityToDto(entity, dto);

		if (!Utils.isEmpty(entity.getDiffAmt())) {
			dto.setDiffAmt(entity.getDiffAmt());
		}

		if (!Utils.isEmpty(entity.getReasonForExclude())) {
			dto.setReasonForExclude(entity.getReasonForExclude().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getRemarks())) {
			dto.setRemarks(entity.getRemarks());
		}

		if (!Utils.isEmpty(entity.getStatusId())) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getStopIncrementType())) {
			dto.setStopIncrementType(entity.getStopIncrementType().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getStopIncFromDate())) {
			dto.setStopIncFromDate(entity.getStopIncFromDate());
		}

		if (!Utils.isEmpty(entity.getStopIncToDate())) {
			dto.setStopIncToDate(entity.getStopIncToDate());
		}

		if (!Utils.isEmpty(entity.getDateNxtInc())) {
			dto.setDateNxtInc(entity.getDateNxtInc());
		}

		if (!Utils.isEmpty(entity.getClassId())) {
			dto.setClassId(entity.getClassId().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getEmpType())) {
			dto.setEmpType(entity.getEmpType().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getDesignationId())) {
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
		}

		dto.setSystemExcluded(entity.getSystemExcluded());
		dto.setIncrementType(entity.getIncrementType());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	private void copyRevisedDetailEntityToDto(PVUIncrementEmpEntity entity, PVUIncrementEmpDto dto) {
		if (!Utils.isEmpty(entity.getRevPayLevel())) {
			dto.setRevPayLevel(entity.getRevPayLevel().getId());
		}

		if (!Utils.isEmpty(entity.getRevCellId())) {
			dto.setRevCellId(entity.getRevCellId().getId());
		}

		dto.setRevGrade(entity.getRevGrade());

		if (!Utils.isEmpty(entity.getRevScale())) {
			dto.setRevScale(entity.getRevScale().getPayScaleId());
		}

		if (!Utils.isEmpty(entity.getRevPayBand())) {
			dto.setRevPayBand(entity.getRevPayBand().getId());
		}

		if (!Utils.isEmpty(entity.getRevPayBandValue())) {
			dto.setRevPayBandValue(entity.getRevPayBandValue());
		}

		if (!Utils.isEmpty(entity.getRevGradePay())) {
			dto.setRevGradePay(entity.getRevGradePay().getId());
		}

		if (!Utils.isEmpty(entity.getRevBasicPay())) {
			dto.setRevBasicPay(entity.getRevBasicPay());
		}

		if (!Utils.isEmpty(entity.getRevEffDate())) {
			dto.setRevEffDate(entity.getRevEffDate());
		}

		if (!Utils.isEmpty(entity.getRevDateNexInc())) {
			dto.setRevDateNexInc(entity.getRevDateNexInc());
		}
	}

	private void copyCurrentDetailEntityToDto(PVUIncrementEmpEntity entity, PVUIncrementEmpDto dto) {
		if (!Utils.isEmpty(entity.getCurPayLevel())) {
			dto.setCurPayLevel(entity.getCurPayLevel().getId());
		}

		if (!Utils.isEmpty(entity.getCurCellId())) {
			dto.setCurCellId(entity.getCurCellId().getId());
		}

		if (!Utils.isEmpty(entity.getCurGrade())) {
			dto.setCurGrade(entity.getCurGrade());
		}

		if (!Utils.isEmpty(entity.getCurScale())) {
			dto.setCurScale(entity.getCurScale().getPayScaleId());
		}

		if (!Utils.isEmpty(entity.getCurPayBand())) {
			dto.setCurPayBand(entity.getCurPayBand().getId());
		}

		if (!Utils.isEmpty(entity.getCurPayBandValue())) {
			dto.setCurPayBandValue(entity.getCurPayBandValue());
		}

		if (!Utils.isEmpty(entity.getCurGradePay())) {
			dto.setCurGradePay(entity.getCurGradePay().getId());
		}

		if (!Utils.isEmpty(entity.getCurBasicPay())) {
			dto.setCurBasicPay(entity.getCurBasicPay());
		}
	}

	public VelocityContext populateVContext(List<PVUIncrementEmpEntity> entity) {
		ArrayList<LinkedHashMap<String, Object>> arrayList = new ArrayList<>();
		VelocityContext context = new VelocityContext();
		context.put("MonthYear", entity.get(0).getInEventId().getFinancialYear().getFy());
		for (PVUIncrementEmpEntity lsEntity : entity) {
			LinkedHashMap<String, Object> hashMap = new LinkedHashMap<>();
			hashMap.put("EVENT_NAME", PvuConstant.EVENT_CODE_INCREMENT);
			hashMap.put("OFFICE_NAME", lsEntity.getInEventId().getOfficeId().getOfficeName());
			hashMap.put("OFFICE_ADDRESS", lsEntity.getInEventId().getOfficeId().getAddrLine1());
			hashMap.put("TRANSACION_NO", lsEntity.getInEventId().getTrnNo());
			hashMap.put("TRANSACION_DATE", Utils.getDateString(lsEntity.getUpdatedDate()));
			hashMap.put("DESIGNATION", lsEntity.getDesignationId().getDesignationName());
			hashMap.put("EMPLOYEE_NO", lsEntity.getEmpId().getEmployeeCode());
			hashMap.put("GPF_NO", StringUtils.defaultString(lsEntity.getGpf()));
			hashMap.put("BUCKLE_NO", "");
			hashMap.put("SUBSTANTIVE_OFFICIATING", "");
			hashMap.put("SUSPENTION_FROM_DATE",
					!Utils.isEmpty(lsEntity.getSusStartDate()) ? Utils.getDateString(lsEntity.getSusStartDate()) : "");
			hashMap.put("SUSPENTION_TO_DATE",
					!Utils.isEmpty(lsEntity.getSusEndDate()) ? Utils.getDateString(lsEntity.getSusEndDate()) : "");
			hashMap.put("EOL_FROM_DATE",
					!Utils.isEmpty(lsEntity.getEolStartDate()) ? Utils.getDateString(lsEntity.getEolStartDate()) : "");
			hashMap.put("EOL_TO_DATE",
					!Utils.isEmpty(lsEntity.getEolEndDate()) ? Utils.getDateString(lsEntity.getEolEndDate()) : "");
			hashMap.put("DATE_OF_INCREMENT",
					!Utils.isEmpty(lsEntity.getRevDateNexInc()) ? Utils.getDateString(lsEntity.getRevDateNexInc())
							: "");
			seventhPay(lsEntity, hashMap);
			sixthPay(lsEntity, hashMap);
			fifththPay(lsEntity, hashMap);
			arrayList.add(hashMap);
		}
		context.put("INCREMENT", arrayList);
		return context;

	}

	private LinkedHashMap<String, Object> seventhPay(PVUIncrementEmpEntity lsEntity,
			LinkedHashMap<String, Object> hashMap) {
		if (lsEntity.getInEventId().getIncrementFor().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			hashMap.put("CURRENT_LEVEL_ID",
					!Utils.isEmpty(lsEntity.getCurPayLevel()) ? lsEntity.getCurPayLevel().getPayLevelValue() : "");
			hashMap.put("CURRENT_CELL_ID",
					!Utils.isEmpty(lsEntity.getCurCellId()) ? lsEntity.getCurCellId().getCellId() : "");
			hashMap.put("CURRENT_PAY_IN_PAY_LEVEL",
					!Utils.isEmpty(lsEntity.getCurBasicPay()) ? lsEntity.getCurBasicPay() : "");
			hashMap.put(CURRENT_PAY_DRAWN_DATE, "");
			hashMap.put("CURRENT_AMOUNT", !Utils.isEmpty(lsEntity.getDiffAmt()) ? lsEntity.getDiffAmt() : "");
			hashMap.put("REVISE_LEVEL_ID",
					!Utils.isEmpty(lsEntity.getRevPayLevel()) ? lsEntity.getRevPayLevel().getPayLevelValue() : "");
			hashMap.put("REVISE_CELL_ID",
					!Utils.isEmpty(lsEntity.getRevCellId()) ? lsEntity.getRevCellId().getCellId() : "");
			hashMap.put("REVISE_PAY_IN_PAY_LEVEL",
					!Utils.isEmpty(lsEntity.getRevBasicPay()) ? lsEntity.getRevBasicPay() : "");
		}
		return hashMap;
	}

	private LinkedHashMap<String, Object> sixthPay(PVUIncrementEmpEntity lsEntity,
			LinkedHashMap<String, Object> hashMap) {
		if (lsEntity.getInEventId().getIncrementFor().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {

			hashMap.put("CURRENT_PAY_BAND",
					!Utils.isEmpty(lsEntity.getCurPayBand()) ? lsEntity.getCurPayBand().getPayBandDispVal() : "");
			hashMap.put("CURRENT_GRADE_PAY",
					!Utils.isEmpty(lsEntity.getCurGradePay()) ? lsEntity.getCurGradePay().getGradePayValue() : "");
			hashMap.put("CURRENT_BASIC_PAY",
					!Utils.isEmpty(lsEntity.getCurBasicPay()) ? lsEntity.getCurBasicPay() : "");
			hashMap.put(CURRENT_PAY_DRAWN_DATE, "");
			hashMap.put("CURRENT_AMOUNT", !Utils.isEmpty(lsEntity.getDiffAmt()) ? lsEntity.getDiffAmt() : "");
			hashMap.put("REVISE_PAY_BAND",
					!Utils.isEmpty(lsEntity.getRevPayBand()) ? lsEntity.getRevPayBand().getPayBandDispVal() : "");
			hashMap.put("REVISE_GRADE_PAY",
					!Utils.isEmpty(lsEntity.getRevGradePay()) ? lsEntity.getRevGradePay().getGradePayValue() : "");
			hashMap.put("REVISE_BASIC_PAY", !Utils.isEmpty(lsEntity.getRevBasicPay()) ? lsEntity.getRevBasicPay() : "");

		}
		return hashMap;
	}

	private LinkedHashMap<String, Object> fifththPay(PVUIncrementEmpEntity lsEntity,
			LinkedHashMap<String, Object> hashMap) {
		if (lsEntity.getInEventId().getIncrementFor().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			hashMap.put("CURRENT_PAY_SCALE",
					!Utils.isEmpty(lsEntity.getCurScale()) ? lsEntity.getCurScale().getScaleValue() : "");
			hashMap.put("CURRENT_BASIC_PAY",
					!Utils.isEmpty(lsEntity.getCurBasicPay()) ? lsEntity.getCurBasicPay() : "");
			hashMap.put(CURRENT_PAY_DRAWN_DATE, "");
			hashMap.put("CURRENT_AMOUNT", !Utils.isEmpty(lsEntity.getDiffAmt()) ? lsEntity.getDiffAmt() : "");
			hashMap.put("REVISE_BASIC_PAY", !Utils.isEmpty(lsEntity.getRevBasicPay()) ? lsEntity.getRevBasicPay() : "");
			hashMap.put("REVISE_PAY_SCALE",
					!Utils.isEmpty(lsEntity.getRevScale()) ? lsEntity.getRevScale().getPayScaleDispVal() : "");
		}

		String srSaluation = "";
		if (!Utils.isEmpty(lsEntity.getEmpId().getSalutation())) {
			srSaluation = lsEntity.getEmpId().getSalutation().getLookUpInfoName();
		}
		hashMap.put("EMPLOYEE_NAME",
				srSaluation + " " + StringUtils.defaultString(lsEntity.getEmpId().getEmployeeName()) + " "
						+ StringUtils.defaultString(lsEntity.getEmpId().getEmployeeMiddleName()) + " "
						+ StringUtils.defaultString(lsEntity.getEmpId().getEmployeeSurname()));
		return hashMap;
	}
}
