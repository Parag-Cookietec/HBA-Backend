package gov.ifms.pvu.converter;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUSteppingUpEventDto;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUDeemedDateEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUSteppingUpEventEntity;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUStEventConverter class.
 *
 * @version v 1.0
 * @created 2019/12/17 18:44:21
 *
 */
@Component
public class PVUSteppingUpEventConverter implements BaseConverter<PVUSteppingUpEventEntity, PVUSteppingUpEventDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUStEvent entity
	 */
	@Override
	public PVUSteppingUpEventEntity toEntity(PVUSteppingUpEventDto dto) {
		PVUSteppingUpEventEntity entity = new PVUSteppingUpEventEntity();
		entity.setStEventId(dto.getId());
		
		if (!Utils.isEmpty(dto.getOfficeId())) {
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		}
		
		BeanUtils.copyProperties(dto, entity);
		
		entity.setEventOrderNo(dto.getEventOrderNo());
		entity.setEventOrderDate(dto.getEventOrderDate());
		entity.setEventEffectiveDate(dto.getEventEffectiveDate());

		if (!Utils.isEmpty(dto.getStatusId())) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}

		if (!Utils.isEmpty(dto.getIsStpAvail())) {
			entity.setIsStpAvail(new EDPLuLookUpInfoEntity(dto.getIsStpAvail()));
		}
		
		if (!Utils.isEmpty(dto.getPayCommId())) {
			entity.setPayComm(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		}

		/*** Junior employee set details  **/

		if (!Utils.isEmpty(dto.getJrEmpId())) {
			entity.setJrEmpId(new PVUEmployeEntity(dto.getJrEmpId()));
			entity.setJrEmpNo(dto.getJrEmpNo());
		}


		/************** Senior employee set details start *************/
		if (!Utils.isEmpty(dto.getEmployeeId())) {
			entity.setCurEmpId(new PVUEmployeEntity(dto.getEmployeeId()));
		}

		if (!Utils.isEmpty(dto.getEmployeeNo())) {
			entity.setCurEmpNo(dto.getEmployeeNo());
		}

		if (!Utils.isEmpty(dto.getcClassId())) {
			entity.setCurEmpClass(new EDPLuLookUpInfoEntity(dto.getcClassId()));
		}

		if (!Utils.isEmpty(dto.getcDesignationId())) {
			entity.setCurEmpDsgn(new EDPMsDesignationEntity(dto.getcDesignationId()));
		}


		if (!Utils.isEmpty(dto.getcBasicPay())) {
			entity.setCurBasicPay(dto.getcBasicPay());
		}

		
		/*** 5th pay Changes for Senior employee set details  **/
		if (!Utils.isEmpty(dto.getcPayScale())) {
			entity.setCurScale(new PVUMsPayScaleEntity(dto.getcPayScale()));
		}
		/*** 5th pay Changes for Senior employee set details  **/

		/*** 6th pay Changes for Senior employee set details  **/
		if (!Utils.isEmpty(dto.getcGradePayId())) {
			entity.setCurGradePay(new PVUMsGradePayEntity(dto.getcGradePayId()));
		}
		if (!Utils.isEmpty(dto.getcPayBandId())) {
			entity.setCurPayBand(new PVUMsPayBandEntity(dto.getcPayBandId()));
		}
		if (!Utils.isEmpty(dto.getcPayBandValue())) {
			entity.setCurPayBandValue( dto.getcPayBandValue() );
		}
		/*** 6th pay Changes for Senior employee set details  **/

		
		/*** 7th pay Changes for Senior employee set details  **/

		if (!Utils.isEmpty(dto.getcPayLevelId())) {
			entity.setCurPayLevel(new PVUMsPayLevelEntity(dto.getcPayLevelId()));
		}

		if (!Utils.isEmpty(dto.getcCellId())) {
			entity.setCurCellId(new PVUMsPayCellEntity(dto.getcCellId()));
		}
		/*** 7th pay Changes for Senior employee set details  **/
		
		/*** Senior employee set details End **/

		return toEntityPostDetails(entity, dto);
	}

	
	public PVUSteppingUpEventEntity toEntityPostDetails(PVUSteppingUpEventEntity entity,PVUSteppingUpEventDto dto) {
		
		/************** Post Changes details Start  *************/

		if (!Utils.isEmpty(dto.getcClassId())) {
			entity.setChEmpClass(new EDPLuLookUpInfoEntity(dto.getcClassId()));
		}

		if (!Utils.isEmpty(dto.getcDesignationId())) {
			entity.setChEmpDsgn(new EDPMsDesignationEntity(dto.getcDesignationId()));
		}
		if (!Utils.isEmpty(dto.getBasicPay())) {
			entity.setChBasicPay(dto.getBasicPay());
		}

		/*** 5th pay  details  **/
		entity.setChGrade(dto.getChGrade());
		if (!Utils.isEmpty(dto.getPayScale())) {
			entity.setChScale(new PVUMsPayScaleEntity(dto.getPayScale()));
		}

		/*** 5th pay  details  **/

		/*** 6th pay  details  **/
		if (!Utils.isEmpty(dto.getPayBandId())) {
			entity.setChPayBand(new PVUMsPayBandEntity(dto.getPayBandId()));
		}
		if (!Utils.isEmpty(dto.getPayBandValue())) {
			entity.setChPayBandValue(dto.getPayBandValue());
		}
		if (!Utils.isEmpty(dto.getGradePayId())) {
			entity.setChGradePay(new PVUMsGradePayEntity(dto.getGradePayId()));
		}
		/*** 6th pay  details  **/


		/*** 7th pay  details  **/
		if (!Utils.isEmpty(dto.getPayLevelId())) {
			entity.setChPayLevel(new PVUMsPayLevelEntity(dto.getPayLevelId()));
		}
		if (!Utils.isEmpty(dto.getCellId())) {
			entity.setChCellId(new PVUMsPayCellEntity(dto.getCellId()));
		}

		/*** 7th pay  details  **/

		entity.setChDateNexInc(dto.getDateOfNextIncrSrJnr());
		entity.setChBeneEffDate(dto.getChBeneEffDate());
		if (!Utils.isEmpty(dto.getSteppingUpTypeId())) {
			entity.setSteppingUpTypeId(new EDPLuLookUpInfoEntity(dto.getSteppingUpTypeId()));
		}

		return entity;
	}

	
	
	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUStEvent dto
	 */
	@Override
	public PVUSteppingUpEventDto toDTO(PVUSteppingUpEventEntity entity) {
		PVUSteppingUpEventDto dto = new PVUSteppingUpEventDto();
		
		BeanUtils.copyProperties(entity, dto);

		dto.setId(entity.getStEventId());
		dto.setEventOrderNo(entity.getEventOrderNo());

		if (!Utils.isEmpty(entity.getOfficeId())) {
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
		}

		dto.setEventOrderDate(entity.getEventOrderDate());
		dto.setEventEffectiveDate(entity.getEventEffectiveDate());

		if (!Utils.isEmpty(entity.getStatusId())) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getPayComm())) {
			dto.setPayCommId(entity.getPayComm().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getCurEmpId())) {
			dto.setCurEmpId(entity.getCurEmpId().getEmpId());
			dto.setCurEmpNo(entity.getCurEmpNo());
			dto.setEmployeeId(entity.getCurEmpId().getEmpId());
			dto.setEmployeeNo(entity.getCurEmpNo());
		}

		if (!Utils.isEmpty(entity.getCurEmpClass())) {
			dto.setCurEmpClass(entity.getCurEmpClass().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getCurEmpDsgn())) {
			dto.setCurEmpDsgn(entity.getCurEmpDsgn().getDesignationId());
		}

		if (!Utils.isEmpty(entity.getCurOffice())) {
			dto.setCurOffice(entity.getCurOffice().getOfficeId());
		}

		dto.setCurDateNextInc(entity.getCurDateNextInc());
		dto.setCurGrade(entity.getCurGrade());
		
		
		if (!Utils.isEmpty(entity.getCurScale())) {
			dto.setCurScale(entity.getCurScale().getPayScaleId());
		}


		if (!Utils.isEmpty(entity.getCurPayLevel())) {
			dto.setCurPayLevel(entity.getCurPayLevel().getId());
		}

		if (!Utils.isEmpty(entity.getCurPayBand())) {
			dto.setCurPayBand(entity.getCurPayBand().getId());
		}
		dto.setCurPayBandValue(entity.getCurPayBandValue());

		if (!Utils.isEmpty(entity.getCurGradePay())) {
			dto.setCurGradePay(entity.getCurGradePay().getId());
		}

		if (!Utils.isEmpty(entity.getCurCellId())) {
			dto.setCurCellId(entity.getCurCellId().getId());
		}
		dto.setCurBasicPay(entity.getCurBasicPay());

		if (!Utils.isEmpty(entity.getJrEmpId())) {
			dto.setJrEmpId(entity.getJrEmpId().getEmpId());
			dto.setJrEmpNo(entity.getJrEmpNo());
		}
		

		return toDtoSeniorDetails( entity, dto);
	}
	
	public PVUSteppingUpEventDto toDtoSeniorDetails(PVUSteppingUpEventEntity entity,PVUSteppingUpEventDto dto) {
		
		

		/************** Senior employee set details Start *************/

		
		/*** 5th pay Changes for sr employee set details  **/
		if (!Utils.isEmpty(entity.getCurScale())) {
			dto.setcPayScale(entity.getCurScale().getPayScaleId());
		}

		/*** 5th pay Changes for sr employee set details  **/

		/*** 6th pay Changes for sr employee set details  **/
		if (!Utils.isEmpty(entity.getCurPayBand())) {
			dto.setcPayBandId(entity.getCurPayBand().getId());
		}
		if (!Utils.isEmpty(entity.getCurPayBandValue())) {
			dto.setcPayBandValue(entity.getCurPayBandValue());
		}

		if (!Utils.isEmpty(entity.getCurGradePay())) {
			dto.setcGradePayId(entity.getCurGradePay().getId());
		}
		/*** 6th pay Changes for sr employee set details  **/

		/*** 7th pay Changes for sr employee set details  **/

		if (!Utils.isEmpty(dto.getcPayLevelId())) {
			entity.setCurPayLevel(new PVUMsPayLevelEntity(dto.getcPayLevelId()));
		}

		if (!Utils.isEmpty(dto.getcCellId())) {
			entity.setCurCellId(new PVUMsPayCellEntity(dto.getcCellId()));
		}
		if (!Utils.isEmpty(entity.getCurCellId())) {
			dto.setcCellId(entity.getCurCellId().getId());
		}
		if (!Utils.isEmpty(entity.getCurPayLevel())) {
			dto.setcPayLevelId(entity.getCurPayLevel().getId());
		}

		/************** Senior employee set details End *************/
		
		return toDtoPostDetails( entity, dto);

	}

	
	public PVUSteppingUpEventDto toDtoPostDetails(PVUSteppingUpEventEntity entity,PVUSteppingUpEventDto dto) {
		
		
	/************** POST detail Changes  Start  *************/

		
		if (!Utils.isEmpty(entity.getChEmpClass())) {
			dto.setChEmpClass(entity.getChEmpClass().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getChEmpDsgn())) {
			dto.setChEmpDsgn(entity.getChEmpDsgn().getDesignationId());
		}

		if (!Utils.isEmpty(entity.getChGrade())) {
			dto.setChGrade(entity.getChGrade());
		}

		/*** 5th pay **/
		if (!Utils.isEmpty(entity.getChScale()) ) {
			dto.setPayScale(entity.getChScale().getPayScaleId());										
		}
		/*** 5th pay **/

		/*** 6th pay **/

		if (!Utils.isEmpty(entity.getChPayBand())) {
			dto.setPayBandId(entity.getChPayBand().getId());
		}
		dto.setPayBandValue(entity.getChPayBandValue());

		if (!Utils.isEmpty(entity.getChGradePay())) {
			dto.setGradePayId(entity.getChGradePay().getId());
		}
		/*** 6th pay  **/
		
		
		/*** 7th pay **/
		if (!Utils.isEmpty(entity.getChPayLevel())) {
			dto.setPayLevelId(entity.getChPayLevel().getId());
		}

		if (!Utils.isEmpty(entity.getChCellId())) {
			dto.setCellId(entity.getChCellId().getId());
		}
		/*** 7th pay **/



		if (!Utils.isEmpty(entity.getChBasicPay())) {
			dto.setBasicPay(entity.getChBasicPay());
		}

		if (!Utils.isEmpty(entity.getStatusId())) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		
		if (!Utils.isEmpty(entity.getIsStpAvail())) {
			dto.setIsStpAvail(entity.getIsStpAvail().getLookUpInfoId());
		}
		
		if (!Utils.isEmpty(entity.getSteppingUpTypeId())) {
			dto.setSteppingUpTypeId(entity.getSteppingUpTypeId().getLookUpInfoId());
		}

		dto.setDateOfNextIncrSrJnr(entity.getChDateNexInc());
		dto.setChBeneEffDate(entity.getChBeneEffDate());
		
		return dto;
	}

	
	
	
	
	
	public PVUSteppingUpEventEntity updateSteppingUpRemarks(PVUSteppingUpEventEntity entity, PVUSteppingUpEventDto dto) {
		
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
	 * To entity.
	 *
	 * @param PVUPrintEndorsementDto dto
	 * @return PVUPrintEndorsementEntity entity
	 */
	public PVUPrintEndorsementEntity toEntity(PVUPrintEndorsementDto dto) {
		PVUPrintEndorsementEntity entity = new PVUPrintEndorsementEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	
	/**
	 * To toDTO.
	 *
	 * @param PVUPrintEndorsementEntity entity
	 * @return PVUPrintEndorsementDto dto
	 */
	public PVUPrintEndorsementDto toDTO(PVUPrintEndorsementEntity entity) {
		PVUPrintEndorsementDto dto = new PVUPrintEndorsementDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}



	public VelocityContext comparisionReport(PVUSteppingUpEventEntity entity, PVUCommonApiDto pvuCommonApiDto) {
		VelocityContext context = new VelocityContext();
		context.put("EVENT_NAME", PvuConstant.EVENT_NAME_STEPPINGUP);
		context.put("OFFICE_NAME", entity.getOfficeId().getOfficeName());
		context.put("OFFICE_ADDRESS", entity.getOfficeId().getAddrLine1());

		context.put("sr_revised_pay_fixation_date",
				!Utils.isEmpty(entity.getEventEffectiveDate())
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getEventEffectiveDate())
						: "");
		context.put("sr_event_effective_date",
				!Utils.isEmpty(entity.getEventEffectiveDate())
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getEventEffectiveDate())
						: "");

		context.put("sr_next_increment_date",
				!Utils.isEmpty(entity.getChDateNexInc())
						? PvuUtils.getStrOfLocalDateInDDMMYYYY(entity.getChDateNexInc())
						: "");

		context.put("sr_seniority_no", !Utils.isEmpty(entity.getSrSeniorNo()) ? entity.getSrSeniorNo() : "");

		context.put("jn_seniority_no", !Utils.isEmpty(entity.getJrSeniorNo()) ? entity.getJrSeniorNo() : "");

		

		context.put("jn_emp_doj",
				!Utils.isEmpty(pvuCommonApiDto.getDateJoining())
						? PvuUtils.getDateToStringDMYFormatValue(pvuCommonApiDto.getDateJoining())
						: "");

		context.put("sr_emp_designation",
				!Utils.isEmpty(entity.getCurEmpDsgn()) ? entity.getCurEmpDsgn().getDesignationName() : "");

		context.put("sr_current_basic_pay", !Utils.isEmpty(entity.getCurBasicPay()) ? entity.getCurBasicPay() : "");

		context.put("sr_revised_basic_pay", !Utils.isEmpty(entity.getChBasicPay()) ? entity.getChBasicPay() : "");

		context.put("jn_current_basic_pay",
				!Utils.isEmpty(pvuCommonApiDto.getEmpBasicPay()) ? pvuCommonApiDto.getEmpBasicPay() : "");

		if (!Utils.isEmpty(pvuCommonApiDto.getEmpBasicPay())) {
			String jrSaluation = "";
			if (!Utils.isEmpty(entity.getJrEmpId().getSalutation())) {
				jrSaluation = entity.getJrEmpId().getSalutation().getLookUpInfoName();
			}

			context.put("jn_emp_name",
					jrSaluation + " " + StringUtils.defaultString(entity.getJrEmpId().getEmployeeName()) + " "
							+ StringUtils.defaultString(entity.getJrEmpId().getEmployeeMiddleName()) + " "
							+ StringUtils.defaultString(entity.getJrEmpId().getEmployeeSurname()));
		} else {
			context.put("jn_emp_name", "");
		}

		
		return comparisionSubReport(entity, pvuCommonApiDto, context);

	}

	public VelocityContext comparisionSubReport(PVUSteppingUpEventEntity entity, PVUCommonApiDto pvuCommonApiDto,
			VelocityContext context) {

		context.put("reason_availed",
				!Utils.isEmpty(entity.getPrvStpAvailDtls()) ? entity.getPrvStpAvailDtls() : "");
		
		String srSaluation = "";
		if (!Utils.isEmpty(entity.getCurEmpId().getSalutation())) {
			srSaluation = entity.getCurEmpId().getSalutation().getLookUpInfoName();
		}

		context.put("sr_emp_name",
				srSaluation + " " + StringUtils.defaultString(entity.getCurEmpId().getEmployeeName()) + " "
						+ StringUtils.defaultString(entity.getCurEmpId().getEmployeeMiddleName()) + " "
						+ StringUtils.defaultString(entity.getCurEmpId().getEmployeeSurname()));
		
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {

			context.put("sr_current_pay_level",
					!Utils.isEmpty(entity.getCurPayLevel()) ? entity.getCurPayLevel().getPayLevelValue() : "");

			context.put("sr_revised_pay_level",
					!Utils.isEmpty(entity.getChPayLevel()) ? entity.getChPayLevel().getPayLevelValue() : "");

			context.put("sr_current_cell_id", !Utils.isEmpty(entity.getCurCellId()) ? entity.getCurCellId().getCellId() : "");

			context.put("sr_revised_cell_id", !Utils.isEmpty(entity.getChCellId()) ? entity.getChCellId().getCellId() : "");

			context.put("jn_current_pay_level",
					!Utils.isEmpty(pvuCommonApiDto.getPayLevelName()) ? pvuCommonApiDto.getPayLevelName() : "");

			context.put("jn_current_cell_id",
					!Utils.isEmpty(pvuCommonApiDto.getCellName()) ? pvuCommonApiDto.getCellName() : "");

			context.put("seventhPay", PvuConstant.SEVENTH_COMMISSION_ID);

		}
		return comparisionSubReports(entity, pvuCommonApiDto, context);
	}

	public VelocityContext comparisionSubReports(PVUSteppingUpEventEntity entity, PVUCommonApiDto pvuCommonApiDto,
			VelocityContext context) {
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {

			context.put("sr_current_pay_band",
					!Utils.isEmpty(entity.getCurPayBand()) ? entity.getCurPayBand().getPayBandDispVal() : "");

			context.put("sr_revised_pay_band",
					!Utils.isEmpty(entity.getChPayBand()) ? entity.getChPayBand().getPayBandDispVal() : "");

			context.put("sr_current_grade_pay",
					!Utils.isEmpty(entity.getCurGradePay()) ? entity.getCurGradePay().getGradePayValue() : "");

			context.put("sr_revised_grade_pay",
					!Utils.isEmpty(entity.getChGradePay()) ? entity.getChGradePay().getGradePayValue() : "");

			context.put("jn_current_pay_band",
					!Utils.isEmpty(pvuCommonApiDto.getPayBandName()) ? pvuCommonApiDto.getPayBandName() : "");

			context.put("jn_current_grade_pay",
					!Utils.isEmpty(pvuCommonApiDto.getGradePayName()) ? pvuCommonApiDto.getGradePayName() : "");

			context.put("sixthPay", PvuConstant.SIXTH_COMMISSION_ID);

		}
		return comparisionsSubReports(entity, pvuCommonApiDto, context);
	}

	public VelocityContext comparisionsSubReports(PVUSteppingUpEventEntity entity, PVUCommonApiDto pvuCommonApiDto,
			VelocityContext context) {
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {

			context.put("sr_current_pay_scale",
					!Utils.isEmpty(entity.getChScale()) ? entity.getChScale().getScaleValue() : "");

			context.put("sr_revised_pay_scale", !Utils.isEmpty(entity.getChScale()) ? entity.getChScale().getScaleValue() : "");
			
			context.put("jn_current_pay_scale",
					!Utils.isEmpty(pvuCommonApiDto.getPayScaleName()) ? pvuCommonApiDto.getPayScaleName() : "");
			
			context.put("fifthPay", PvuConstant.FIFTH_COMMISSION_ID);
		}
		return context;
	}
	
	
}
