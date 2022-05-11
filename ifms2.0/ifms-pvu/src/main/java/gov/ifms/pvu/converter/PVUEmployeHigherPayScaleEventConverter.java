package gov.ifms.pvu.converter;

import gov.ifms.common.util.Utils;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUSSPRemarkRequest;
import gov.ifms.pvu.entity.*;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.dto.PVUEmployeHigherPayScaleEventDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The Class PVUEmployeHigherPayScaleEventConverter class.
 *
 * @version v 1.0
 * @created 2020/01/07 16:13:21
 *
 */
@Component
public class PVUEmployeHigherPayScaleEventConverter
		implements BaseConverter<PVUEmployeHigherPayScaleEventEntity, PVUEmployeHigherPayScaleEventDto> {

	@Autowired
	private PVUMsPayScaleRepository payscaleRepository;

	@Autowired
	private EDPLuLookUpInfoRepository eDPLuLookUpInfoRepository;

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeHigherPayScaleEvent entity
	 */
	@Override
	public PVUEmployeHigherPayScaleEventEntity toEntity(PVUEmployeHigherPayScaleEventDto dto) {
		PVUEmployeHigherPayScaleEventEntity entity = new PVUEmployeHigherPayScaleEventEntity();
		BeanUtils.copyProperties(dto, entity);
		if (dto.getEmployeeId() != 0) {
			entity.setEmployee(new PVUEmployeEntity(dto.getEmployeeId()));
		}
		if (dto.getPayLevelId() != 0) {
			entity.setPayLevel(new PVUMsPayLevelEntity(dto.getPayLevelId()));
		}
		if (dto.getHpScaleFor() != 0) {
			entity.setHpScaleFor(new EDPLuLookUpInfoEntity(dto.getHpScaleFor()));
		}
		if (dto.getHpScaleType() != 0) {
			entity.setHpScaleType((new EDPLuLookUpInfoEntity(dto.getHpScaleType())));
		}
		if (dto.getGradePayId() != 0) {
			entity.setGradePay(new PVUMsGradePayEntity(dto.getGradePayId()));
		}
		if (dto.getCellId() != 0) {
			entity.setCell(new PVUMsPayCellEntity(dto.getCellId()));
		}
		if (dto.getHpType() != 0) {
			entity.setHpType(new EDPLuLookUpInfoEntity(dto.getHpType()));
		}
		if (dto.getPayCommId() != 0) {
			entity.setPayComm(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		}
		if (dto.getOptionAvailableId() != 0) {
			entity.setOptionAvailable(new EDPLuLookUpInfoEntity(dto.getOptionAvailableId()));
		}
		if (dto.getOfficeId() != 0) {
			entity.setOffice(new EDPMsOfficeEntity(dto.getOfficeId()));
		}
		if (dto.getStatusId() != 0) {
			entity.setStatus(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (dto.getPayBandId() != 0) {
			entity.setPayband(new PVUMsPayBandEntity(dto.getPayBandId()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeHigherPayScaleEvent dto
	 */
	@Override
	public PVUEmployeHigherPayScaleEventDto toDTO(PVUEmployeHigherPayScaleEventEntity entity) {
		PVUEmployeHigherPayScaleEventDto dto = new PVUEmployeHigherPayScaleEventDto();
		BeanUtils.copyProperties(entity, dto);
		dataConverter(entity, dto);
		if (entity.getPayComm() != null) {
			dto.setPayCommId(entity.getPayComm().getLookUpInfoId());
		}
		if (entity.getOptionAvailable() != null) {
			dto.setOptionAvailableId(entity.getOptionAvailable().getLookUpInfoId());
			if (entity.getOptionAvailable().getLookUpInfoId() != 0) {
				dto.setOptionAvailableName(entity.getOptionAvailable().getLookUpInfoName());
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

		if (!Utils.isEmpty(entity.getHpEmpType()) && entity.getHpEmpType() > 0) {
			dto.setHpEmpTypeName(getEmpTypeName(entity.getHpEmpType()));
		}
		setPayDetails(entity, dto);
		return dto;
	}

	private void setPayDetails(PVUEmployeHigherPayScaleEventEntity entity, PVUEmployeHigherPayScaleEventDto dto) {
		if (entity.getPayband() != null) {
			dto.setPayBandId(entity.getPayband().getId());
			if (entity.getPayband().getPayBandDispVal() != null) {
				dto.setPayBandName(entity.getPayband().getPayBandDispVal());
			}
		}
		if (entity.getPayLevel() != null) {
			dto.setPayLevelId(entity.getPayLevel().getId());
			if (entity.getPayLevel().getPayLevelValue() != null) {
				dto.setPayLevelName(entity.getPayLevel().getPayLevelValue());
			}
		}
		if (!Utils.isEmpty(entity.getPayScale())) {
			dto.setPayScale(entity.getPayScale());
			dto.setScaleName(getPayScaleValue(entity.getPayScale()));
		}

	}

	public String getEmpTypeName(Long empType) {
		EDPLuLookUpInfoEntity lookupInfo = eDPLuLookUpInfoRepository.findBylookUpInfoId(empType);

		return lookupInfo.getLookUpInfoName();
	}

	public String getPayScaleValue(Long payScale) {
		Optional<PVUMsPayScaleEntity> payscale = payscaleRepository.findById(payScale);
		return payscale.isPresent() ? payscale.get().getScaleValue() : "";
	}

	/**
	 * @param entity
	 * @param dto
	 */
	private void dataConverter(PVUEmployeHigherPayScaleEventEntity entity, PVUEmployeHigherPayScaleEventDto dto) {
		if (entity.getEmployee() != null) {
			dto.setEmployeeId(entity.getEmployee().getEmpId());
			if (entity.getEmployee().getEmployeeCode() != null) {
				dto.setEmployeeNo(entity.getEmployee().getEmployeeCode());
			}
		}
		if (entity.getHpScaleFor() != null) {
			dto.setHpScaleFor(entity.getHpScaleFor().getLookUpInfoId());
			if (entity.getHpScaleFor().getLookUpInfoId() != 0) {
				dto.setHpScaleForName(entity.getHpScaleFor().getLookUpInfoName());
			}
		}
		if (entity.getHpScaleType() != null) {
			dto.setHpScaleType(entity.getHpScaleType().getLookUpInfoId());
			if (entity.getHpScaleType().getLookUpInfoId() != 0) {
				dto.setHpScaleTypeName(entity.getHpScaleType().getLookUpInfoName());
			}
		}

		newDataConverter(entity, dto);
	}

	/**
	 * @param entity
	 * @param dto    getHpEmpTypeName
	 */
	private void newDataConverter(PVUEmployeHigherPayScaleEventEntity entity, PVUEmployeHigherPayScaleEventDto dto) {
		if (entity.getGradePay() != null) {
			dto.setGradePayId(entity.getGradePay().getId());
			if (entity.getGradePay().getGradePayValue() != null) {
				dto.setGradePayName(entity.getGradePay().getGradePayValue());
			}
		}
		if (entity.getCell() != null) {
			dto.setCellId(entity.getCell().getId());
			if (entity.getCell().getCellValue() != 0) {
				dto.setCellName(String.valueOf(entity.getCell().getCellId()));
			}
		}
		if (entity.getHpType() != null) {
			dto.setHpType(entity.getHpType().getLookUpInfoId());
			if (entity.getHpType().getLookUpInfoId() != 0) {
				dto.setHpTypeName(entity.getHpType().getLookUpInfoName());
			}
		}
	}

	public PVUEmployeHigherPayScaleEventEntity setRemarks(PVUEmployeHigherPayScaleEventEntity entity,
			PVUSSPRemarkRequest dto) {
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
			entity.setPrintCount(Long.valueOf(dto.getPrintCount()));
		}
		return entity;
	}

	public Map<String, String> getEventDetails(PVUEmployeHigherPayScaleEventDto dto) {
		Map<String, String> response = new HashMap<>();
		response.put("trnNo", dto.getTrnNo());
		response.put("officeId", dto.getOfficeName());
		response.put("payCommId", PvuUtils.buildCommissionName(dto.getPayCommId()));//
		if (dto.getPayCommId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			response.put("payLevelId", dto.getPayLevelName());
			response.put("cellId", dto.getCellName());
		} else if (dto.getPayCommId() == PvuConstant.SIXTH_COMMISSION_ID) {
			response.put("payBandId", dto.getPayBandName());
			response.put("payBandValue", String.valueOf(dto.getPayBandValue()));
			response.put("gradePayId", dto.getGradePayName());
		} else if (dto.getPayCommId() == PvuConstant.FIFTH_COMMISSION_ID) {
			response.put("payScale", String.valueOf(dto.getScaleName()));
		}
		response.put("eventOrderNo", dto.getEventOrderNo());
		response.put("eventOrderDate", dto.getEventOrderDate().toString());
		response.put("eventEffectiveDate", dto.getEventEffectiveDate().toString());
		response.put("basicPay", String.valueOf(dto.getBasicPay()));
		response.put("remarks", dto.getRemarks());

		response.put("dateOfNextIncrement", dto.getDateOfNextIncrement().toString());
		response.put("employeeNo", String.valueOf(dto.getEmployeeNo()));
		response.put("eventCode", "Higher pay Scale");
		response.put("hpScaleFor", dto.getHpScaleForName());
		response.put("hpScaleType", dto.getHpScaleTypeName());
		response.put("hpType", dto.getHpTypeName());
		response.put("hpEmpType", dto.getHpEmpTypeName());
		response.put("optionAvailableId", dto.getOptionAvailableName());
		response.put("hgEffDate", dto.getHgEffDate().toString());
		response.put("optionAvailableDate",
				dto.getOptionAvailableDate() != null ? dto.getOptionAvailableDate().toString() : null);
		return response;
	}

	public PVUPrintEndorsementEntity toPrintEntity(PVUPrintEndorsementDto dto) {
		PVUPrintEndorsementEntity entity = new PVUPrintEndorsementEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public PVUPrintEndorsementDto toPrintDTO(PVUPrintEndorsementEntity entity) {
		PVUPrintEndorsementDto dto = new PVUPrintEndorsementDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public PVUPrintEndorsementDto toPrintEndorsementDto(PVUPrintEndorsementEntity source) {
		PVUPrintEndorsementDto target = new PVUPrintEndorsementDto();
		BeanUtils.copyProperties(source, target);
		return target;
	}
}
