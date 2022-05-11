package gov.ifms.pvu.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.dto.PVUIncrementEmpDto;
import gov.ifms.pvu.dto.PVUIncrementEmpSDDto;
import gov.ifms.pvu.entity.*;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeEventsRepository;
import gov.ifms.pvu.repository.PVUIncrementEmpSDRepository;
import gov.ifms.pvu.util.PvuConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

/**
 * The Class PVUIncrementEmpConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/12 19:19:14
 *
 */
@Component
public class PVUIncrementEmpSDConverter implements BaseConverter<PVUIncrementEmpSDEntity, PVUIncrementEmpSDDto> {

	private final String CURRENT_PAY_DRAWN_DATE = "CURRENT_PAY_DRAWN_DATE";

	@Autowired
	private PVUIncrementSTPSDConverter stopConverter;

	@Autowired
	private PVUIncrementEmpSDRepository pvuIncrementEmpSDRepository;

	@Autowired
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	@Autowired
	private PVUEmployeEventsRepository pvuEmployeEventsRepository;

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUIncrementEmp entity
	 */
	@Override
	public PVUIncrementEmpSDEntity toEntity(PVUIncrementEmpSDDto dto) {
		PVUIncrementEmpSDEntity entity = new PVUIncrementEmpSDEntity();
		Optional<PVUIncrementEmpSDEntity> sdEntity = pvuIncrementEmpSDRepository.findById(dto.getIdEmpSDId());
		if(sdEntity.isPresent()) {
			 entity = sdEntity.get();
		}
        entity.setInEventId(new PVUIncrementEventEntity(dto.getInEventId()));
		BeanUtils.copyProperties(dto, entity);
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
		if (!Utils.isEmpty(dto.getRevGrade())) {
			entity.setRevGrade(dto.getRevGrade());
		}
		if (!Utils.isEmpty(dto.getRevPayBand())) {
			entity.setRevPayBand(new PVUMsPayBandEntity(dto.getRevPayBand()));
		}

		if (!Utils.isEmpty(dto.getRevGradePay())) {
			entity.setRevGradePay(new PVUMsGradePayEntity(dto.getRevGradePay()));
		}
		if (!Utils.isEmpty(dto.getRevBasicPay())) {
			entity.setRevBasicPay(dto.getRevBasicPay());
		}
		if (!Utils.isEmpty(dto.getRevEffDate())) {
			entity.setRevEffDate(dto.getRevEffDate());
		}
		if (!Utils.isEmpty(dto.getRevDateNexInc())) {
			entity.setRevDateNexInc(dto.getRevDateNexInc());
		}
		if (!Utils.isEmpty(dto.getDiffAmt())) {
			entity.setDiffAmt(dto.getDiffAmt());
		}
		if (!Utils.isEmpty(dto.getReasonForExclude())) {
			entity.setReasonForExclude(new EDPLuLookUpInfoEntity(dto.getReasonForExclude()));

		}
		else
        {
            entity.setReasonForExclude(null);
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
		entity.setDateOfJoining(dto.getDateOfJoining());

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
		if (dto.getReasonForExclusion() != null) {
			entity.setPvuIncrementSTPSDPEntity(stopConverter.toEntity(dto.getReasonForExclusion()));
		}
		if (dto.getUserRemarks() != null) {
			entity.setUserRemarks(dto.getUserRemarks());
		}

		return entity;
	}

	private void copyCurrentDetailDtoToEntity(PVUIncrementEmpSDDto dto, PVUIncrementEmpSDEntity entity) {
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
	/*	if (entity.getPvuIncrementSTPSDPEntity() != null) {
			dto.setReasonForExclusion(stopConverter.toDTO(entity.getPvuIncrementSTPSDPEntity()));
		}*/
		entity.setCurBasicPay(dto.getCurBasicPay());
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUIncrementEmp dto
	 */
	@Override
	public PVUIncrementEmpSDDto toDTO(PVUIncrementEmpSDEntity entity) {
		PVUIncrementEmpSDDto dto = new PVUIncrementEmpSDDto();
		BeanUtils.copyProperties(entity, dto);
		if (!Utils.isEmpty(entity.getInEventId())) {
			dto.setInEventId(entity.getInEventId().getInEventId());
		}

		if (!Utils.isEmpty(entity.getEmpId())) {
			dto.setEmpId(entity.getEmpId().getEmpId());
			if((entity.getEmpId().getEmployeeCode() != null)) {
				String empName="";
				if(entity.getEmpId().getSalutation()!=null)
				{
					empName=entity.getEmpId().getSalutation().getLookUpInfoName();
				}
				if(entity.getEmpId().getEmployeeName()!=null)
				{
					empName=empName+" "+entity.getEmpId().getEmployeeName();
				}

				if(entity.getEmpId().getEmployeeMiddleName()!=null)
				{
					empName=empName+" "+entity.getEmpId().getEmployeeMiddleName();
				}

				if(entity.getEmpId().getEmployeeSurname()!=null)
				{
					empName=empName+" "+entity.getEmpId().getEmployeeSurname();
				}
				dto.setEmpName(empName);
				dto.setEmpNo(entity.getEmpId().getEmployeeCode());
			}
		}

		copyCurrentDetailEntityToDto(entity, dto);
		copyRevisedDetailEntityToDto(entity, dto);

		if (!Utils.isEmpty(entity.getDiffAmt())) {
			dto.setDiffAmt(entity.getDiffAmt());
		}

		if (!Utils.isEmpty(entity.getReasonForExclude())) {
			dto.setReasonForExclude(entity.getReasonForExclude().getLookUpInfoId());
			dto.setReasonForExcludeValue(entity.getReasonForExclude().getLookUpInfoName());
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
		if (!Utils.isEmpty(entity.getDateOfJoining())) {
			dto.setDateOfJoining(entity.getDateOfJoining());
		}

		if (!Utils.isEmpty(entity.getClassId())) {
			dto.setClassId(entity.getClassId().getLookUpInfoId());
			dto.setClassName(entity.getClassId().getLookUpInfoName());
		}

		if (!Utils.isEmpty(entity.getEmpType())) {
			dto.setEmpType(entity.getEmpType().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getDesignationId())) {
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
			dto.setDesignationName(entity.getDesignationId().getDesignationName());
		}

		dto.setSystemExcluded(entity.getSystemExcluded());
		dto.setIncrementType(entity.getIncrementType());


		if (entity.getPvuIncrementSTPSDPEntity() != null) {
			dto.setReasonForExclusion(stopConverter.toDTO(entity.getPvuIncrementSTPSDPEntity()));
		}
		return dto;
	}



	private void copyRevisedDetailEntityToDto(PVUIncrementEmpSDEntity entity, PVUIncrementEmpSDDto dto) {
		if (!Utils.isEmpty(entity.getRevPayLevel())) {
			dto.setRevPayLevel(entity.getRevPayLevel().getId());
		}

		if (!Utils.isEmpty(entity.getRevCellId())) {
			dto.setRevCellId(entity.getRevCellId().getId());
		}
		if (!Utils.isEmpty(entity.getRevGrade())) {
			dto.setRevGrade(entity.getRevGrade());
		}
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

	private void copyCurrentDetailEntityToDto(PVUIncrementEmpSDEntity entity, PVUIncrementEmpSDDto dto) {
		if (!Utils.isEmpty(entity.getCurPayLevel())) {
			dto.setCurPayLevel(entity.getCurPayLevel().getId());
			dto.setCurPayLevelValue(entity.getCurPayLevel().getPayLevelValue());
		}

		if (!Utils.isEmpty(entity.getCurCellId())) {
			dto.setCurCellId(entity.getCurCellId().getId());
			dto.setCurCellIdValue(entity.getCurCellId().getCellId());
		}

		if (!Utils.isEmpty(entity.getCurGrade())) {
			dto.setCurGrade(entity.getCurGrade());
		}

		if (!Utils.isEmpty(entity.getCurScale())) {
			dto.setCurScale(entity.getCurScale().getPayScaleId());
			dto.setCurScaleValue(entity.getCurScale().getScaleValue());
		}

		if (!Utils.isEmpty(entity.getCurPayBand())) {
			dto.setCurPayBand(entity.getCurPayBand().getId());
			dto.setCurPayBandRange(entity.getCurPayBand().getPayBandDispVal());
		}

		if (!Utils.isEmpty(entity.getCurPayBandValue())) {
			dto.setCurPayBandValue(entity.getCurPayBandValue());
		}

		if (!Utils.isEmpty(entity.getCurGradePay())) {
			dto.setCurGradePay(entity.getCurGradePay().getId());
			dto.setCurGradePayValue(entity.getCurGradePay().getGradePayValue());
		}


		if (!Utils.isEmpty(entity.getCurBasicPay())) {
			dto.setCurBasicPay(entity.getCurBasicPay());
		}
	}

	public VelocityContext populateVContext(List<PVUIncrementEmpSDEntity> entity) {
		ArrayList<LinkedHashMap<String, Object>> arrayList = new ArrayList<>();
		VelocityContext context = new VelocityContext();
		context.put("MonthYear", entity.get(0).getInEventId().getFinancialYear().getFy());
		for (PVUIncrementEmpSDEntity lsEntity : entity) {
			LinkedHashMap<String, Object> hashMap = new LinkedHashMap<>();

			PVUEmployeDepartmentEntity pvuEmployeDepartmentEntity = pvuEmployeDepartmentRepository.findFirstByPvuEmployeEntityEmpId(lsEntity.getEmpId().getEmpId());
			if(pvuEmployeDepartmentEntity != null && pvuEmployeDepartmentEntity.getEmpType() != null){
				hashMap.put("SUBSTANTIVE_OFFICIATING", pvuEmployeDepartmentEntity.getEmpStatus().getLookUpInfoName());
			}else {
				hashMap.put("SUBSTANTIVE_OFFICIATING", "");
			}
			hashMap.put("EVENT_NAME", PvuConstant.EVENT_CODE_INCREMENT);
			hashMap.put("OFFICE_NAME", lsEntity.getInEventId().getOfficeId().getOfficeName());
			hashMap.put("OFFICE_ADDRESS", lsEntity.getInEventId().getOfficeId().getAddrLine1());
			hashMap.put("TRANSACION_NO", lsEntity.getInEventId().getTrnNo());
			hashMap.put("TRANSACION_DATE", Utils.getDateString(lsEntity.getUpdatedDate()));
			hashMap.put("DESIGNATION", lsEntity.getDesignationId().getDesignationName());
			hashMap.put("EMPLOYEE_NO", lsEntity.getEmpId().getEmployeeCode());
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

	private LinkedHashMap<String, Object> seventhPay(PVUIncrementEmpSDEntity lsEntity,
			LinkedHashMap<String, Object> hashMap) {
		if (lsEntity.getInEventId().getIncrementFor().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {

			hashMap.put("CURRENT_LEVEL_ID",
					!Utils.isEmpty(lsEntity.getCurPayLevel()) ? lsEntity.getCurPayLevel().getPayLevelValue() : "");
			hashMap.put("CURRENT_CELL_ID",
					!Utils.isEmpty(lsEntity.getCurCellId()) ? lsEntity.getCurCellId().getCellId() : "");
			hashMap.put("CURRENT_PAY_IN_PAY_LEVEL",
					!Utils.isEmpty(lsEntity.getCurBasicPay()) ? lsEntity.getCurBasicPay() : "");
			hashMap.put(CURRENT_PAY_DRAWN_DATE,
					!Utils.isEmpty(getlastEventDate(lsEntity)) ? Utils.inFormatedDateString(getlastEventDate(lsEntity))
							: "");
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

	private LocalDateTime getlastEventDate(PVUIncrementEmpSDEntity lsEntity) {
		List<PVUEmployeEventsEntity>  list = pvuEmployeEventsRepository.findAllByEmpIdAndPayCommissionAndActiveStatus(lsEntity.getEmpId().getEmpId(),
				PvuConstant.SEVENTH_COMMISSION_ID,1);
		Comparator<PVUEmployeEventsEntity> empNameComparator = (PVUEmployeEventsEntity emp1, PVUEmployeEventsEntity emp2) -> {
			return (emp2.getEventDate().compareTo(emp1.getEventDate()));
		};
		Collections.sort(list, empNameComparator);
		LocalDateTime localDate = null;
		if(list != null && !list.isEmpty()){
			localDate = list.get(0).getEventDate();
		}
		return localDate;
	}

	private LinkedHashMap<String, Object> sixthPay(PVUIncrementEmpSDEntity lsEntity,
			LinkedHashMap<String, Object> hashMap) {
		if (lsEntity.getInEventId().getIncrementFor().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {

			hashMap.put("CURRENT_PAY_BAND",
					!Utils.isEmpty(lsEntity.getCurPayBand()) ? lsEntity.getCurPayBand().getPayBandDispVal() : "");
			hashMap.put("CURRENT_PAY_BAND_VALUE",
					!Utils.isEmpty(lsEntity.getCurPayBandValue()) ? lsEntity.getCurPayBandValue() : "");
			hashMap.put("CURRENT_GRADE_PAY",
					!Utils.isEmpty(lsEntity.getCurGradePay()) ? lsEntity.getCurGradePay().getGradePayValue() : "");
			hashMap.put("CURRENT_BASIC_PAY",
					!Utils.isEmpty(lsEntity.getCurBasicPay()) ? lsEntity.getCurBasicPay() : "");
			hashMap.put(CURRENT_PAY_DRAWN_DATE,
					!Utils.isEmpty(getlastEventDate(lsEntity)) ? Utils.inFormatedDateString(getlastEventDate(lsEntity))
							: "");
			hashMap.put("CURRENT_AMOUNT", !Utils.isEmpty(lsEntity.getDiffAmt()) ? lsEntity.getDiffAmt() : "");
			hashMap.put("REVISE_PAY_BAND",
					!Utils.isEmpty(lsEntity.getRevPayBand()) ? lsEntity.getRevPayBand().getPayBandDispVal() : "");
			hashMap.put("REVISE_PAY_BAND_VALUE",
					!Utils.isEmpty(lsEntity.getRevPayBandValue()) ? lsEntity.getRevPayBandValue() : "");
			hashMap.put("REVISE_GRADE_PAY",
					!Utils.isEmpty(lsEntity.getRevGradePay()) ? lsEntity.getRevGradePay().getGradePayValue() : "");
			hashMap.put("REVISE_BASIC_PAY", !Utils.isEmpty(lsEntity.getRevBasicPay()) ? lsEntity.getRevBasicPay() : "");

		}
		return hashMap;
	}

	private LinkedHashMap<String, Object> fifththPay(PVUIncrementEmpSDEntity lsEntity,
			LinkedHashMap<String, Object> hashMap) {
		if (lsEntity.getInEventId().getIncrementFor().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {

			hashMap.put("CURRENT_PAY_SCALE",
					!Utils.isEmpty(lsEntity.getCurScale()) ? lsEntity.getCurScale().getScaleValue() : "");
			hashMap.put("CURRENT_BASIC_PAY",
					!Utils.isEmpty(lsEntity.getCurBasicPay()) ? lsEntity.getCurBasicPay() : "");
			hashMap.put(CURRENT_PAY_DRAWN_DATE,
					!Utils.isEmpty(getlastEventDate(lsEntity)) ? Utils.inFormatedDateString(getlastEventDate(lsEntity))
							: "");
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
