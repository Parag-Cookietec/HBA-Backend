package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.dto.PVUEmployeShettyPayDto;
import gov.ifms.pvu.dto.PVUEmployeeCurrentDetailDto;
import gov.ifms.pvu.dto.PVUEmployeePostDetailDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeShettyPayEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeShettyPayConverter class.
 *
 * @version v 1.0
 * @created 2020/01/06 12:53:37
 *
 */
@Component
public class PVUEmployeShettyPayConverter implements BaseConverter<PVUEmployeShettyPayEntity, PVUEmployeShettyPayDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeShettyPay entity
	 */
	@Override
	public PVUEmployeShettyPayEntity toEntity(PVUEmployeShettyPayDto dto) {
		PVUEmployeShettyPayEntity entity = new PVUEmployeShettyPayEntity();
		BeanUtils.copyProperties(dto, entity);
		if (dto.getOfficeId() != 0)
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		if (dto.getEmployeeId() != 0)
			entity.setEmpId(new PVUEmployeEntity(dto.getEmployeeId()));
		if (dto.getStatusId() != 0)
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		if (dto.getPayBandId() != 0)
			entity.setPayBand(new PVUMsPayBandEntity(dto.getPayBandId()));
		if (dto.getGradePayId() != 0)
			entity.setGradePay(new PVUMsGradePayEntity(dto.getGradePayId()));
		if (!Utils.isEmpty(dto.getPayCommId())) {
			entity.setPayCommission(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		}
		if (!Utils.isEmpty(dto.getEmployeeId())) {
			entity.setEmpId(new PVUEmployeEntity(dto.getEmployeeId()));
		}
		if (!Utils.isEmpty(dto.getIsPrintAble())) {
			entity.setIsPrintAble(new EDPLuLookUpInfoEntity(dto.getIsPrintAble()));
		}
		return setPayDetailsEntity(dto, entity);
	}

	/**
	 * Sets the pay details.
	 *
	 * @param dto the dto
	 * @param entity the entity
	 * @return the PVU employe shetty pay entity
	 */
	private PVUEmployeShettyPayEntity setPayDetailsEntity(PVUEmployeShettyPayDto dto, PVUEmployeShettyPayEntity entity) {

		if (!Utils.isEmpty(dto.getPayScale())) {
			entity.setPayScale(new PVUMsPayScaleEntity(dto.getPayScale()));
		}
		if (!Utils.isEmpty(dto.getGradePayId())) {
			entity.setGradePay(new PVUMsGradePayEntity(dto.getGradePayId()));
		}
		if (!Utils.isEmpty(dto.getPayBandValue())) {
			entity.setPayBandValue(dto.getPayBandValue());
		}
		if (!Utils.isEmpty(dto.getcPayBandId())) {
			entity.setcPayBandId(new PVUMsPayBandEntity(dto.getcPayBandId()));
		}
		if (!Utils.isEmpty(dto.getcPayBandValue())) {
			entity.setcPayBandValue(dto.getcPayBandValue());
		}
		if (!Utils.isEmpty(dto.getcPayScale())) {
			entity.setcPayScale(new PVUMsPayScaleEntity(dto.getcPayScale()));
		}
		if (!Utils.isEmpty(dto.getcGradePayId())) {
			entity.setcGradePayId(new PVUMsGradePayEntity(dto.getcGradePayId()));
		}
		if (!Utils.isEmpty(dto.getBasicPay())) {
			entity.setBasicPay(dto.getBasicPay());
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeShettyPay dto
	 */
	@Override
	public PVUEmployeShettyPayDto toDTO(PVUEmployeShettyPayEntity entity) {
		PVUEmployeShettyPayDto dto = new PVUEmployeShettyPayDto();

		BeanUtils.copyProperties(entity, dto);
		if (entity.getOfficeId() != null)
			dto.setOfficeId(entity.getOfficeId().getOfficeId());

		if (entity.getStatusId() != null)
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());

		if (!Utils.isEmpty(entity.getEmpId())) {
			dto.setEmployeeId(entity.getEmpId().getEmpId());
		}

		if (!Utils.isEmpty(entity.getEmpId()) && entity.getEmpId().getEmployeeCode() != null)
			dto.setEmployeeNo(entity.getEmpId().getEmployeeCode());

		if (!Utils.isEmpty(entity.getIsPrintAble())) {
			dto.setIsPrintAble(entity.getIsPrintAble().getLookUpInfoId());
		}
		return setPayDetails(entity, dto);
	}

	/**
	 * Sets the pay details.
	 *
	 * @param entity the entity
	 * @param dto    the dto
	 * @return the PVU employe shetty pay dto
	 */
	private PVUEmployeShettyPayDto setPayDetails(PVUEmployeShettyPayEntity entity, PVUEmployeShettyPayDto dto) {

		if (entity.getPayBand() != null)
			dto.setPayBandId(entity.getPayBand().getId());
		if (entity.getGradePay() != null)
			dto.setGradePayId(entity.getGradePay().getId());

		if (!Utils.isEmpty(entity.getPayBandValue())) {
			dto.setPayBandValue(entity.getPayBandValue());
		}

		if (!Utils.isEmpty(entity.getcBasicPay())) {
			dto.setcBasicPay(entity.getcBasicPay());
		}

		if (!Utils.isEmpty(entity.getcPayBandId()))
			dto.setcPayBandId(entity.getcPayBandId().getId());

		if (!Utils.isEmpty(entity.getcPayBandValue())) {
			dto.setcPayBandValue(entity.getcPayBandValue());
		}

		if (!Utils.isEmpty(entity.getcGradePayId()))
			dto.setcGradePayId(entity.getcGradePayId().getId());

		if (!Utils.isEmpty(entity.getcGradePayId()) && !Utils.isEmpty(entity.getcGradePayId().getGradePayValue()))
			dto.setcGradePayIdValue(entity.getcGradePayId().getGradePayValue());

		return setPayScaleDetails(entity, dto);
	}

	private PVUEmployeShettyPayDto setPayScaleDetails(PVUEmployeShettyPayEntity entity, PVUEmployeShettyPayDto dto) {

		if (!Utils.isEmpty(dto.getPayCommId())) {
			entity.setPayCommission(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		}
		if (!Utils.isEmpty(entity.getPayCommission())) {
			dto.setPayCommId(entity.getPayCommission().getLookUpInfoId());
		}
		if (!Utils.isEmpty(entity.getcPayScale()) && entity.getcPayScale().getPayScaleDispVal() != null)
			dto.setcPayScaleValue(entity.getcPayScale().getPayScaleDispVal());

		if (!Utils.isEmpty(entity.getcPayScale())) {
			dto.setcPayScale(entity.getcPayScale().getPayScaleId());
		}
		if (!Utils.isEmpty(entity.getPayScale())) {
			dto.setcPayScale(entity.getPayScale().getPayScaleId());
		}
		return dto;
	}

	public PVUEmployeeCurrentDetailDto toPVUObjCommon(PVUCommonApiDto dto, PVUEmployeShettyPayEntity entity) {
		PVUEmployeeCurrentDetailDto currentDetails = new PVUEmployeeCurrentDetailDto();
		currentDetails.setEmployeeName(dto.getEmployeeName());
		currentDetails.setEmployeeClass(dto.getEmployeeClass());
		currentDetails.setDesignationName(dto.getDesignationName());
		if (dto.getPayCommId().equals(PvuConstant.SIXTH_COMMISSION_ID)) {
			currentDetails.setPayBandName(String.valueOf(entity.getcPayBandId().getPayBandDispVal()));
			currentDetails.setPayBandValue(String.valueOf(entity.getcPayBandValue()));
			currentDetails.setGradePayName(String.valueOf(entity.getcGradePayId().getGradePayValue()));

		} else if (dto.getPayCommId().equals(PvuConstant.FIFTH_COMMISSION_ID)) {
			currentDetails.setPayScaleName(dto.getPayScaleName());
		}
		currentDetails.setEmpBasicPay(String.valueOf(entity.getcBasicPay()));
		currentDetails.setDateNxtIncr(String.valueOf(entity.getDateOfNextIncrement()));
		currentDetails.setDateJoining(dto.getDateJoining());
		currentDetails.setRetirementDate(dto.getRetirementDate());
		currentDetails.setOfficeName(dto.getOfficeName());
		return currentDetails;
	}

	public PVUEmployeePostDetailDto toPVUObj(PVUEmployeShettyPayEntity entity) {
		PVUEmployeePostDetailDto detailDto = new PVUEmployeePostDetailDto();

		if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.PREM_SIXTH_COMMISSION_ID) {
			detailDto.setPayBandId(String.valueOf(entity.getPayBand().getPayBandDispVal()));
			detailDto.setPayBandValue(String.valueOf(entity.getPayBandValue()));
			detailDto.setGradePayId(entity.getGradePay().getGradePayValue());
			detailDto.setPayCommId(PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME);
		} else if (entity.getPayCommission().getLookUpInfoId() == PvuConstant.PREM_FIFTH_COMMISSION_ID) {
			detailDto.setPayScale(String.valueOf(entity.getPayScale().getPayScaleDispVal()));
			detailDto.setPayCommId(PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME);
		}
		detailDto.setBasicPay(String.valueOf(entity.getBasicPay()));
		detailDto.setDateOfNextIncrement(String.valueOf(entity.getDateOfNextIncrement()));
		detailDto.setOfficeId(entity.getOfficeId().getOfficeName());
		detailDto.setEventOrderNo(entity.getEventOrderNo());
		detailDto.setEventOrderDate(String.valueOf(entity.getEventOrderDate()));
		detailDto.setEventEffectiveDate(entity.getEventEffectiveDate());
		detailDto.setEventCode(PvuConstant.EVENT_NAME_SHETTY_PAY);
		detailDto.setEmployeeNo(String.valueOf(entity.getEmpId().getEmployeeCode()));

		return detailDto;
	}

	public PVUEmployeShettyPayEntity updateSPRemarks(PVUEmployeShettyPayEntity entity, PVUEmployeShettyPayDto dto) {
		if (!Utils.isEmpty(dto.getAuditorRemarks())) {
			entity.setAuditorRemarks(dto.getAuditorRemarks());
		}

		if (PvuUtils.notNull(dto.getClassTwoRemarks())) {
			entity.setClassTwoRemarks(dto.getClassTwoRemarks());
		}

		if (!Utils.isEmpty(dto.getPrintRemarks())) {
			entity.setPrintRemarks(dto.getPrintRemarks());
		}

		if (!Utils.isEmpty(dto.getAuditorReturnReason())) {
			entity.setAuditorReturnReason(dto.getAuditorReturnReason());
		}

		if (PvuUtils.notNull(dto.getClassOneRemarks())) {
			entity.setClassOneRemarks(dto.getClassOneRemarks());
		}

		if (!Utils.isEmpty(dto.getVerifierRemarks())) {
			entity.setVerifierRemarks(dto.getVerifierRemarks());
		}

		if (!Utils.isEmpty(dto.getClassTwoReturnReason())) {
			entity.setClassTwoReturnReason(dto.getClassTwoReturnReason());
		}

		if (!Utils.isEmpty(dto.getPrintReturnReason())) {
			entity.setPrintReturnReason(dto.getPrintReturnReason());
		}

		if (!Utils.isEmpty(dto.getClassOneReturnReason())) {
			entity.setClassOneReturnReason(dto.getClassOneReturnReason());
		}

		if (!Utils.isEmpty(dto.getVerifierReturnReason())) {
			entity.setVerifierReturnReason(dto.getVerifierReturnReason());
		}

		if (!Utils.isEmpty(dto.getPrintCount())) {
			entity.setPrintCount(dto.getPrintCount());
		}
		return entity;
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
}
