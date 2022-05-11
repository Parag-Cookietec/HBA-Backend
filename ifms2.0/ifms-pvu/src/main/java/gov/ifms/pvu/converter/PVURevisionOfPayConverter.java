package gov.ifms.pvu.converter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.converter.EDPMsOfficeConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.dto.PVURevisionOfPayDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.entity.PVURevisionOfPayEntity;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVURevisionOfPayConverter class.
 *
 * @version v 1.0
 * @created 2020/01/09 12:59:56
 */
@Component
public class PVURevisionOfPayConverter implements BaseConverter<PVURevisionOfPayEntity, PVURevisionOfPayDto> {

	@Autowired
	EDPMsOfficeConverter edpMsOfficeConverter;

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVURevisionOfPay entity
	 */
	@Override
	public PVURevisionOfPayEntity toEntity(PVURevisionOfPayDto dto) {
		PVURevisionOfPayEntity entity = new PVURevisionOfPayEntity();
		BeanUtils.copyProperties(dto, entity);

		if (!Utils.isEmpty(dto.getRevNextIncrementDate())) {
			entity.setRevNextIncrementDate(dto.getRevNextIncrementDate());
		}

		if (!Utils.isEmpty(dto.getCurNextIncrementDate())) {
			entity.setCurNextIncrementDate(dto.getCurNextIncrementDate());
		}

		if (!Utils.isEmpty(dto.getEmpId())) {
			entity.setEmpId(new PVUEmployeEntity(dto.getEmpId()));
		}

		if (!Utils.isEmpty(dto.getRopType())) {
			entity.setRopType(new EDPLuLookUpInfoEntity(dto.getRopType()));
		}

		if (!Utils.isEmpty(dto.getRevPayLevel())) {
			entity.setRevPayLevel(new PVUMsPayLevelEntity(dto.getRevPayLevel()));
		}

		if (!Utils.isEmpty(dto.getRevCellId())) {
			entity.setRevCellId(new PVUMsPayCellEntity(dto.getRevCellId()));
		}

		if (!Utils.isEmpty(dto.getRevPayBand())) {
			entity.setRevPayBand(new PVUMsPayBandEntity(dto.getRevPayBand()));
		}

		if (!Utils.isEmpty(dto.getRevPayBandValue())) {
			entity.setRevPayBandValue(dto.getRevPayBandValue());
		}

		if (!Utils.isEmpty(dto.getRevGradePay())) {
			entity.setRevGradePay(new PVUMsGradePayEntity(dto.getRevGradePay()));
		}

		if (!Utils.isEmpty(dto.getRevBasicPay())) {
			entity.setRevBasicPay(dto.getRevBasicPay());
		}

		if (!Utils.isEmpty(dto.getEffectiveDate())) {
			entity.setEffectiveDate(dto.getEffectiveDate());
		}

		if (!Utils.isEmpty(dto.getOrderNo())) {
			entity.setOrderNo(dto.getOrderNo());
		}

		if (!Utils.isEmpty(dto.getOrderDate())) {
			entity.setOrderDate(dto.getOrderDate());
		}

		if (!Utils.isEmpty(dto.getRemarks())) {
			entity.setRemarks(dto.getRemarks());
		}

		if (!Utils.isEmpty(dto.getAuditorRemarks())) {
			entity.setAuditorRemarks(dto.getAuditorRemarks());
		}

		if (!Utils.isEmpty(dto.getClassTwoRemarks())) {
			entity.setClassTwoRemarks(dto.getRemarks());
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

		if (!Utils.isEmpty(dto.getPrintReturnReason())) {
			entity.setPrintReturnReason(dto.getPrintReturnReason());
		}

		if (!Utils.isEmpty(dto.getPrintCount())) {
			entity.setPrintCount(dto.getPrintCount());
		}

		if (!Utils.isEmpty(dto.getCurScale())) {
			entity.setCurScale(new PVUMsPayScaleEntity(dto.getCurScale()));
		}

		if (!Utils.isEmpty(dto.getCurGradePay())) {
			entity.setCurGradePay(new PVUMsGradePayEntity(dto.getCurGradePay()));
		}

		if (!Utils.isEmpty(dto.getCurPayBand())) {
			entity.setCurPayBand(new PVUMsPayBandEntity(dto.getCurPayBand()));
		}

		if (!Utils.isEmpty(dto.getCurBasicPay())) {
			entity.setCurBasicPay(dto.getCurBasicPay());
		}

		if (!Utils.isEmpty(dto.getCurPayBandValue())) {
			entity.setCurPayBandValue(dto.getCurPayBandValue());
		}

		if (!Utils.isEmpty(dto.getClassId())) {
			entity.setClassId(new EDPLuLookUpInfoEntity(dto.getClassId()));
		}

		if (!Utils.isEmpty(dto.getDesignationId())) {
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		}

		if (!Utils.isEmpty(dto.getNpa())) {
			entity.setNpa(dto.getNpa());
		}

		entity.setAutoSixValidBasic(dto.getAutoSixValidBasic());
		entity.setAutoSixValidPayValue(dto.getAutoSixValidPayValue());
		entity.setAutoSixValidFlag(dto.getAutoSixValidFlag());
		entity.setOfficeId(edpMsOfficeConverter.toEntity(OAuthUtility.getCurrentUserOfficeOauthToken()));
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVURevisionOfPay dto
	 */
	@Override
	public PVURevisionOfPayDto toDTO(PVURevisionOfPayEntity entity) {
		PVURevisionOfPayDto dto = new PVURevisionOfPayDto();
		if (!Utils.isEmpty(dto.getRevNextIncrementDate())) {
			entity.setRevNextIncrementDate(dto.getRevNextIncrementDate());
		}

		if (!Utils.isEmpty(dto.getCurNextIncrementDate())) {
			entity.setCurNextIncrementDate(dto.getCurNextIncrementDate());
		}

		if (!Utils.isEmpty(entity.getEmpId())) {
			dto.setEmpId(entity.getEmpId().getEmpId());
		}

		if (!Utils.isEmpty(entity.getRopType())) {
			dto.setRopType(entity.getRopType().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getRevPayLevel())) {
			dto.setRevPayLevel(entity.getRevPayLevel().getId());
		}

		if (!Utils.isEmpty(entity.getRevCellId())) {
			dto.setRevCellId(entity.getRevCellId().getId());
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

		if (!Utils.isEmpty(entity.getEffectiveDate())) {
			dto.setEffectiveDate(entity.getEffectiveDate());
		}

		if (!Utils.isEmpty(entity.getOrderNo())) {
			dto.setOrderNo(entity.getOrderNo());
		}

		if (!Utils.isEmpty(entity.getOrderDate())) {
			dto.setOrderDate(entity.getOrderDate());
		}

		if (!Utils.isEmpty(entity.getRemarks())) {
			dto.setRemarks(entity.getRemarks());
		}

		if (!Utils.isEmpty(entity.getAuditorRemarks())) {
			dto.setAuditorRemarks(entity.getAuditorRemarks());
		}

		if (!Utils.isEmpty(entity.getClassTwoRemarks())) {
			dto.setClassTwoRemarks(entity.getRemarks());
		}

		if (!Utils.isEmpty(entity.getPrintRemarks())) {
			dto.setPrintRemarks(entity.getPrintRemarks());
		}

		if (!Utils.isEmpty(entity.getAuditorReturnReason())) {
			dto.setAuditorReturnReason(entity.getAuditorReturnReason());
		}

		if (!Utils.isEmpty(entity.getClassTwoReturnReason())) {
			dto.setClassTwoReturnReason(entity.getClassTwoReturnReason());
		}

		if (!Utils.isEmpty(entity.getPrintReturnReason())) {
			dto.setPrintReturnReason(entity.getPrintReturnReason());
		}

		if (!Utils.isEmpty(entity.getPrintCount())) {
			dto.setPrintCount(entity.getPrintCount());
		}

		if (!Utils.isEmpty(entity.getStatusId())) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getCurScale())) {
			dto.setCurScale(entity.getCurScale().getPayScaleId());
		}

		if (!Utils.isEmpty(entity.getCurGradePay())) {
			dto.setCurGradePay(entity.getCurGradePay().getId());
		}

		if (!Utils.isEmpty(entity.getCurPayBand())) {
			dto.setCurPayBand(entity.getCurPayBand().getId());
		}

		if (!Utils.isEmpty(entity.getCurBasicPay())) {
			dto.setCurBasicPay(entity.getCurBasicPay());
		}

		if (!Utils.isEmpty(entity.getCurPayBandValue())) {
			dto.setCurPayBandValue(entity.getCurPayBandValue());
		}

		if (!Utils.isEmpty(entity.getClassId())) {
			dto.setClassId(entity.getClassId().getLookUpInfoId());
		}

		if (!Utils.isEmpty(entity.getDesignationId())) {
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
		}

		if (!Utils.isEmpty(entity.getNpa())) {
			dto.setNpa(entity.getNpa());
		}
		
		dto.setAutoSixValidBasic(entity.getAutoSixValidBasic());
		dto.setAutoSixValidPayValue(entity.getAutoSixValidPayValue());
		dto.setAutoSixValidFlag(entity.getAutoSixValidFlag());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * Update rop entity.
	 *
	 * @param entity the entity
	 * @param dto    the dto
	 * @return the PVU revision of pay entity
	 */
	public PVURevisionOfPayEntity updateRopEntity(PVURevisionOfPayEntity entity, PVURevisionOfPayDto dto) {
		if (!Utils.isEmpty(dto.getRevNextIncrementDate())) {
			entity.setRevNextIncrementDate(dto.getRevNextIncrementDate());
		}

		if (!Utils.isEmpty(dto.getCurNextIncrementDate())) {
			entity.setCurNextIncrementDate(dto.getCurNextIncrementDate());
		}

		if (!Utils.isEmpty(dto.getEmpId())) {
			entity.setEmpId(new PVUEmployeEntity(dto.getEmpId()));
		}

		if (!Utils.isEmpty(dto.getRopType())) {
			entity.setRopType(new EDPLuLookUpInfoEntity(dto.getRopType()));
		}

		if (!Utils.isEmpty(dto.getRevPayLevel())) {
			entity.setRevPayLevel(new PVUMsPayLevelEntity(dto.getRevPayLevel()));
		}

		if (!Utils.isEmpty(dto.getRevCellId())) {
			entity.setRevCellId(new PVUMsPayCellEntity(dto.getRevCellId()));
		}

		if (!Utils.isEmpty(dto.getRevPayBand())) {
			entity.setRevPayBand(new PVUMsPayBandEntity(dto.getRevPayBand()));
		}

		if (!Utils.isEmpty(dto.getRevPayBandValue())) {
			entity.setRevPayBandValue(dto.getRevPayBandValue());
		}

		if (!Utils.isEmpty(dto.getRevGradePay())) {
			entity.setRevGradePay(new PVUMsGradePayEntity(dto.getRevGradePay()));
		}

		if (!Utils.isEmpty(dto.getRevBasicPay())) {
			entity.setRevBasicPay(dto.getRevBasicPay());
		}

		if (!Utils.isEmpty(dto.getEffectiveDate())) {
			entity.setEffectiveDate(dto.getEffectiveDate());
		}

		if (!Utils.isEmpty(dto.getOrderNo())) {
			entity.setOrderNo(dto.getOrderNo());
		}

		if (!Utils.isEmpty(dto.getOrderDate())) {
			entity.setOrderDate(dto.getOrderDate());
		}

		if (!Utils.isEmpty(dto.getRemarks())) {
			entity.setRemarks(dto.getRemarks());
		}

		if (!Utils.isEmpty(dto.getAuditorRemarks())) {
			entity.setAuditorRemarks(dto.getAuditorRemarks());
		}

		if (!Utils.isEmpty(dto.getClassTwoRemarks())) {
			entity.setClassTwoRemarks(dto.getRemarks());
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

		if (!Utils.isEmpty(dto.getPrintReturnReason())) {
			entity.setPrintReturnReason(dto.getPrintReturnReason());
		}

		if (!Utils.isEmpty(dto.getPrintCount())) {
			entity.setPrintCount(dto.getPrintCount());
		}

		if (!Utils.isEmpty(dto.getCurScale())) {
			entity.setCurScale(new PVUMsPayScaleEntity(dto.getCurScale()));
		}

		if (!Utils.isEmpty(dto.getCurGradePay())) {
			entity.setCurGradePay(new PVUMsGradePayEntity(dto.getCurGradePay()));
		}

		if (!Utils.isEmpty(dto.getCurPayBand())) {
			entity.setCurPayBand(new PVUMsPayBandEntity(dto.getCurPayBand()));
		}

		if (!Utils.isEmpty(dto.getCurBasicPay())) {
			entity.setCurBasicPay(dto.getCurBasicPay());
		}

		if (!Utils.isEmpty(dto.getCurPayBandValue())) {
			entity.setCurPayBandValue(dto.getCurPayBandValue());
		}

		if (!Utils.isEmpty(dto.getClassId())) {
			entity.setClassId(new EDPLuLookUpInfoEntity(dto.getClassId()));
		}

		if (!Utils.isEmpty(dto.getDesignationId())) {
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		}

		if (!Utils.isEmpty(dto.getNpa())) {
			entity.setNpa(dto.getNpa());
		}
		if(!Utils.isEmpty(dto.getRopChangeEffDate())) {
			entity.setRopChangeEffDate(new EDPLuLookUpInfoEntity(dto.getRopChangeEffDate()));
		}
		entity.setAutoSixValidBasic(dto.getAutoSixValidBasic());
		entity.setAutoSixValidPayValue(dto.getAutoSixValidPayValue());
		entity.setAutoSixValidFlag(dto.getAutoSixValidFlag());
		entity.setOfficeId(edpMsOfficeConverter.toEntity(OAuthUtility.getCurrentUserOfficeOauthToken()));
		return entity;
	}

	public PVURevisionOfPayEntity updateRopRemarks(PVURevisionOfPayEntity entity, PVURevisionOfPayDto dto) {
		if (!Utils.isEmpty(dto.getAuditorRemarks())) {
			entity.setAuditorRemarks(dto.getAuditorRemarks());
		}

		if (!Utils.isEmpty(dto.getClassTwoRemarks())) {
			entity.setClassTwoRemarks(dto.getClassTwoRemarks());
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

		if (!Utils.isEmpty(dto.getPrintReturnReason())) {
			entity.setPrintReturnReason(dto.getPrintReturnReason());
		}

		if (!Utils.isEmpty(dto.getPrintCount())) {
			entity.setPrintCount(dto.getPrintCount());
		}
		return entity;
	}
	
	public VelocityContext ddoApprovalCertificate(PVURevisionOfPayEntity entity) {
		VelocityContext context = new VelocityContext();
		context.put("EVENT_NAME", entity.getRopType().getLookUpInfoName());
		context.put("OFFICE_NAME", entity.getOfficeId().getOfficeName());
		context.put("CLASS_NAME", entity.getClassId().getLookUpInfoName());
		context.put("DESIGNATION_NAME", entity.getDesignationId().getDesignationName());
		context.put("EMP_NO", entity.getEmpId().getEmployeeCode());
		
		String jrSaluation = "";
		if (!Utils.isEmpty(entity.getEmpId().getSalutation())) {
			jrSaluation = entity.getEmpId().getSalutation().getLookUpInfoName();
		}

		context.put("EMP_NAME",
				jrSaluation + " " + StringUtils.defaultString(entity.getEmpId().getEmployeeName()) + " "
						+ StringUtils.defaultString(entity.getEmpId().getEmployeeMiddleName()) + " "
						+ StringUtils.defaultString(entity.getEmpId().getEmployeeSurname()));

		return context;

	}

	public VelocityContext ddoApprovalCertificateObject(List<Object[]> objects, List<Object[]> object,
			VelocityContext context) {
		context.put("DDO_DESIGNATION", String.valueOf(objects.get(0)[4]));
		context.put("DDO_NAME", String.valueOf(objects.get(0)[0]));
		context.put("OFFICE_NAME", String.valueOf(objects.get(0)[1]));
		context.put("PLACE", String.valueOf(objects.get(0)[2]));
		context.put("PLACE1", String.valueOf(objects.get(0)[3]));
		context.put("DATE", PvuUtils.getDateToStringDMYFormatValue(String.valueOf(object.get(0)[0])));
		return context;
	}
}
