package gov.ifms.pvu.converter;

import gov.ifms.common.util.Constant;
import gov.ifms.common.util.Utils;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.dto.PVUPromotionDto;
import gov.ifms.pvu.entity.*;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

import org.apache.velocity.VelocityContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class PVUPromotionConverter class.
 */
@Component
public class PVUPromotionConverter extends BasePVUPfConverter<PVUPromotionEntity, PVUPromotionDto> {

	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;
	
	@Autowired
	private PVUMsPayScaleRepository payscaleRepository;

	@Override
	PVUPromotionEntity createEntity() {
		return new PVUPromotionEntity();
	}

	@Override
	PVUPromotionDto createDTO() {
		return new PVUPromotionDto();
	}

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUPromotionEntity entity
	 */
	@Override
	public PVUPromotionEntity toEntity(PVUPromotionDto dto) {
		PVUPromotionEntity entity = this.toCurrentDetailsEntity(dto);
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
		if (dto.getDesignationId() != 0) {
			entity.setDesignation(new EDPMsDesignationEntity(dto.getDesignationId()));
		}
		if (dto.getEmployeeId() != 0) {
			entity.setEmployee(new PVUEmployeEntity(dto.getEmployeeId()));
		}
		if (dto.getNoonTypeId() != 0) {
			entity.setNoonType(new EDPLuLookUpInfoEntity(dto.getNoonTypeId()));
		}
		if (dto.getOptionAvailableId() != 0) {
			entity.setOptionAvailable(new EDPLuLookUpInfoEntity(dto.getOptionAvailableId()));
		}
		if (dto.getEmployeeClassId() != 0) {
			entity.setEmployeeClass(new EDPLuLookUpInfoEntity(dto.getEmployeeClassId()));
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
		if (dto.getPromotionTypeId() != 0) {
			entity.setPromotionType(new EDPLuLookUpInfoEntity(dto.getPromotionTypeId()));
			if (dto.getPromotionTypeId() == getSameScalePromotion()) {
				entity.setOptionAvailable(lookUpInfoRepository.findBylookUpInfoId(Constant.NO_LOOKUP_INFO_ID));
			}
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUPromotionDto dto
	 */
	@Override
	public PVUPromotionDto toDTO(PVUPromotionEntity entity) {
		PVUPromotionDto dto = this.toCurrentDetailsDTO(entity);
		BeanUtils.copyProperties(entity, dto);
		if (entity.getEmployee() != null) {
			dto.setEmployeeId(entity.getEmployee().getEmpId());
			if (entity.getEmployee().getEmployeeCode() != null) {
				dto.setEmployeeNo(entity.getEmployee().getEmployeeCode());
			}
		}
		if (!Utils.isEmpty(entity.getPayScale())) {
			dto.setPayScale(entity.getPayScale());
			dto.setScaleName(getPayScaleValue(entity.getPayScale()));
		}
		setDTO(entity, dto);
		setSixDTO(entity, dto);
		setSevenDTO(entity, dto);
		
		return dto;
	}
	
	public String getPayScaleValue(Long payScale) {
		Optional<PVUMsPayScaleEntity> payscale = payscaleRepository.findById(payScale);
		return payscale.isPresent() ? payscale.get().getScaleValue() : "";
	}

	private void setDTO(PVUPromotionEntity entity, PVUPromotionDto dto) {
		if (entity.getOffice() != null) {
			dto.setOfficeId(entity.getOffice().getOfficeId());
		}
		if (entity.getStatus() != null) {
			dto.setStatusId(entity.getStatus().getLookUpInfoId());
		}
		if (entity.getPayComm() != null) {
			dto.setPayCommId(entity.getPayComm().getLookUpInfoId());
		}
		if (entity.getDesignation() != null) {
			dto.setDesignationId(entity.getDesignation().getDesignationId());
		}
		if (entity.getNoonType() != null) {
			dto.setNoonTypeId(entity.getNoonType().getLookUpInfoId());
		}
		if (entity.getOptionAvailable() != null) {
			dto.setOptionAvailableId(entity.getOptionAvailable().getLookUpInfoId());
		}
		if (entity.getStatus() != null) {
			dto.setStatusId(entity.getStatus().getLookUpInfoId());
		}
		if (entity.getEmployeeClass() != null) {
			dto.setEmployeeClassId(entity.getEmployeeClass().getLookUpInfoId());
		}
		if (entity.getPromotionType() != null) {
			dto.setPromotionTypeId(entity.getPromotionType().getLookUpInfoId());
		}
	}

	private long getSameScalePromotion() {
		return lookUpInfoRepository.findByLookUpInfoName(Constant.SAME_PSCALE_PROMOTION_NAME).getLookUpInfoId();
	}

	private void setSixDTO(PVUPromotionEntity entity, PVUPromotionDto dto) {
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

	private void setSevenDTO(PVUPromotionEntity entity, PVUPromotionDto dto) {
		if (entity.getPayLevel() != null) {
			dto.setPayLevelId(entity.getPayLevel().getId());
			
			if (entity.getPayLevel().getPayLevelValue() != null) {
				dto.setPayLevelName(entity.getPayLevel().getPayLevelValue());
			}
		}
		if (entity.getCell() != null) {
			dto.setCellId(entity.getCell().getId());
		}
	}

	public VelocityContext populateVContext(PVUPromotionEntity entity) {
		VelocityContext context = new VelocityContext();

		context.put("EVENT_NAME", PvuConstant.EVENT_CODE_PROMOTION);
		context.put("OFFICE_NAME", entity.getOffice().getOfficeName());
		context.put("OFFICE_ADDRESS", entity.getOffice().getAddrLine1());
		context.put("TRANSACION_NO", entity.getTrnNo());
		context.put("TRANSACION_DATE", Utils.getDateString(entity.getUpdatedDate()));
		context.put("ORDER_NO", entity.getEventOrderNo());
		context.put("DESIGNATION", entity.getDesignation().getDesignationName());
		context.put("EMPLOYEE_NO", entity.getEmployee().getEmployeeCode());
		context.put("BASIC_PAY", entity.getBasicPay());

		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			context.put("CURRENT_PAY_LEVEL", entity.getcPayLevel().getPayLevelValue());
			context.put("PAY_LEVEL", entity.getPayLevel().getPayLevelValue());
			context.put("CURRENT_CELL_ID", entity.getcCell().getCellId());
			context.put("CELL_ID", entity.getCell().getCellId());
		} else if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {

			context.put("CURRENT_PAY_BAND", entity.getcPayBand().getPayBandDispVal());
			context.put("PAY_BAND", entity.getPayBand().getPayBandDispVal());

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
		String srSaluation = "";
		if (!Utils.isEmpty(entity.getEmployee().getSalutation())) {
			srSaluation = entity.getEmployee().getSalutation().getLookUpInfoName();
		}
		context.put("EMPLOYEE_NAME",
				srSaluation + " " + StringUtils.defaultString(entity.getEmployee().getEmployeeName()) + " "
						+ StringUtils.defaultString(entity.getEmployee().getEmployeeMiddleName()) + " "
						+ StringUtils.defaultString(entity.getEmployee().getEmployeeSurname()));

		return context;

	}
}
