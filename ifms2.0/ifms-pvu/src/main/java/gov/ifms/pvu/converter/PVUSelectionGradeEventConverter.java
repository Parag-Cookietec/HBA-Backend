package gov.ifms.pvu.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.velocity.VelocityContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUSelectionGradeEventDto;
import gov.ifms.pvu.dto.PVUSelectiongGradePostDetailDto;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.response.PVUCommonApiDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementItrEntity;
import gov.ifms.pvu.entity.PVUSelectionGradeEventEntity;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUSelectionGradeEventConverter class.
 * 
 * @version v 1.0
 * @created 2019/12/18 11:56:47
 *
 */
@Component
public class PVUSelectionGradeEventConverter
		implements BaseConverter<PVUSelectionGradeEventEntity, PVUSelectionGradeEventDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUSelectionGradeEvent entity
	 */
	@Autowired
	PVUMsPayScaleRepository pvuMsPayScaleRepository;
	
	@Autowired
	private EDPLuLookUpInfoRepository lookupinforepository;

	@Override
	public PVUSelectionGradeEventEntity toEntity(PVUSelectionGradeEventDto dto) {
		PVUSelectionGradeEventEntity entity = new PVUSelectionGradeEventEntity();

		if (PvuUtils.hasLength(dto.getStatusId())) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (PvuUtils.hasLength(dto.getOfficeId())) {
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		}
		if (PvuUtils.hasLength(dto.getPayCommId())) {
			entity.setPayComm(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		}
		if (PvuUtils.hasLength(dto.getEmployeeId())) {
			entity.setEmpId(new PVUEmployeEntity(dto.getEmployeeId()));
		}
		if (PvuUtils.hasLength(dto.getDesignationId())) {
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		}
		if (PvuUtils.hasLength(dto.getPayBandId())) {
			entity.setPayBand(new PVUMsPayBandEntity(dto.getPayBandId()));
		}
		if (PvuUtils.hasLength(dto.getGradePayId())) {
			entity.setGradePay(new PVUMsGradePayEntity(dto.getGradePayId()));
		}
		if (PvuUtils.hasLength(dto.getPayLevelId())) {
			entity.setPayLevel(new PVUMsPayLevelEntity(dto.getPayLevelId()));
		}
		if (PvuUtils.hasLength(dto.getCellId())) {
			entity.setCellId(new PVUMsPayCellEntity(dto.getCellId()));
		}
		if (PvuUtils.hasLength(dto.getBasicPay())) {
			entity.setBasicPay(dto.getBasicPay());
		}
		if (PvuUtils.hasLength(dto.getPayBandValue())) {
			entity.setPayBandValue(dto.getPayBandValue());
		}
		if (PvuUtils.hasLength(dto.getPayScale())) {
			entity.setPayScale(dto.getPayScale());
		}
		toCurrentDetailsForPayDetails(entity, dto);
		entity.setEventEffectiveDate(dto.getEventEffectiveDate());
		entity.setTrnNo(LocalDateTime.now().toString());
		entity.setCreatedDate(new Date());
		entity.setUpdatedDate(new Date());
		entity.setUpdatedBy(OAuthUtility.getCurrentUserUserId());
		entity.setUpdatedByPost(OAuthUtility.getCurrentUserUserId());
		entity.setCreatedBy(OAuthUtility.getCurrentUserUserId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUSelectionGradeEvent dto
	 */
	@Override
	public PVUSelectionGradeEventDto toDTO(PVUSelectionGradeEventEntity entity) {
		PVUSelectionGradeEventDto dto = new PVUSelectionGradeEventDto();
		entityToDtoEventSgDetails(entity, dto);
		PVUMsPayBandEntity bandEntity = entity.getPayBand();
		if (!Utils.isEmpty(bandEntity)) {
			dto.setPayBandId(bandEntity.getId());
		}

		if (!Utils.isEmpty(entity.getPayBandValue())) {
			dto.setPayBandValue(entity.getPayBandValue());
		}

		PVUMsGradePayEntity gradePayEntity = entity.getGradePay();
		if (!Utils.isEmpty(gradePayEntity)) {
			dto.setGradePayId(gradePayEntity.getId());
		}

		if (!Utils.isEmpty(dto.getPayCommId())) {
			entity.setPayComm(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		}
		if (!Utils.isEmpty(entity.getIsPrintAble())) {
			dto.setIsPrintAble(entity.getIsPrintAble().getLookUpInfoId());
		}
		if (!Utils.isEmpty(entity.getRefDate())) {
			dto.setRefDate(entity.getRefDate());
		}
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	private void entityToDtoEventSgDetails(PVUSelectionGradeEventEntity entity, PVUSelectionGradeEventDto dto) {
		if (!PvuUtils.isEmpty(entity.getDesignationId())) {
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
		}
		if (!PvuUtils.isEmpty(entity.getStatusId())) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		if (!PvuUtils.isEmpty(entity.getOfficeId())) {
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
		}
		if (!PvuUtils.isEmpty(entity.getPayComm())) {
			dto.setPayCommId(entity.getPayComm().getLookUpInfoId());
		}
		if (!PvuUtils.isEmpty(entity.getEmpId())) {
			dto.setEmployeeId(entity.getEmpId().getEmpId());
		}
		if (!PvuUtils.isEmpty(entity.getDesignationId())) {
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
		}
		if (!PvuUtils.isEmpty(entity.getPayBand())) {
			dto.setPayBandId(entity.getPayBand().getId());
		}
		if (!PvuUtils.isEmpty(entity.getGradePay())) {
			dto.setGradePayId(entity.getGradePay().getId());
		}
		if (!PvuUtils.isEmpty(entity.getPayLevel())) {
			dto.setPayLevelId(entity.getPayLevel().getId());
		}
		if (!PvuUtils.isEmpty(entity.getCellId())) {
			dto.setCellId(entity.getCellId().getId());
		}
	}

	public PVUSelectionGradeEventEntity toEntityWithDto(PVUSelectionGradeEventEntity entity,
			PVUSelectionGradeEventDto dto) {

		if (PvuUtils.hasLength(dto.getStatusId())) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (PvuUtils.hasLength(dto.getOfficeId())) {
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		}
		if (PvuUtils.hasLength(dto.getPayCommId())) {
			entity.setPayComm(new EDPLuLookUpInfoEntity(dto.getPayCommId()));
		}
		if (PvuUtils.hasLength(dto.getEmployeeId())) {
			entity.setEmpId(new PVUEmployeEntity(dto.getEmployeeId()));
		}
		if (PvuUtils.hasLength(dto.getDesignationId())) {
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		}
		if (PvuUtils.hasLength(dto.getPayBandId())) {
			entity.setPayBand(new PVUMsPayBandEntity(dto.getPayBandId()));
		}
		if (PvuUtils.hasLength(dto.getGradePayId())) {
			entity.setGradePay(new PVUMsGradePayEntity(dto.getGradePayId()));
		}
		if (PvuUtils.hasLength(dto.getPayLevelId())) {
			entity.setPayLevel(new PVUMsPayLevelEntity(dto.getPayLevelId()));
		}
		if (PvuUtils.hasLength(dto.getCellId())) {
			entity.setCellId(new PVUMsPayCellEntity(dto.getCellId()));
		}
		if (PvuUtils.hasLength(dto.getBasicPay())) {
			entity.setBasicPay(dto.getBasicPay());
		}
		if (PvuUtils.hasLength(dto.getPayBandValue())) {
			entity.setPayBandValue(dto.getPayBandValue());
		}
		if (PvuUtils.hasLength(dto.getPayScale())) {
			entity.setPayScale(dto.getPayScale());
		}
		toCurrentDetailsForPayDetails(entity, dto);
		entity.setTrnNo(LocalDateTime.now().toString());
		entity.setCreatedDate(new Date());
		entity.setUpdatedDate(new Date());
		entity.setUpdatedBy(OAuthUtility.getCurrentUserUserId());
		entity.setUpdatedByPost(OAuthUtility.getCurrentUserUserId());
		entity.setCreatedBy(OAuthUtility.getCurrentUserUserId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	private void toCurrentDetailsForPayDetails(PVUSelectionGradeEventEntity entity, PVUSelectionGradeEventDto dto) {
		if (dto.getcPayBandId() != null && PvuUtils.hasLength(dto.getcPayBandId())) {
			entity.setcPayBandId(new PVUMsPayBandEntity(dto.getcPayBandId()));
		}
		if (PvuUtils.hasLength(dto.getcGradePayId())) {
			entity.setcGradePayId(new PVUMsGradePayEntity(dto.getcGradePayId()));
		}
		if (PvuUtils.hasLength(dto.getcPayLevelId())) {
			entity.setcPayLevelId(new PVUMsPayLevelEntity(dto.getcPayLevelId()));
		}
		if (PvuUtils.hasLength(dto.getcCellId())) {
			entity.setcCellId(new PVUMsPayCellEntity(dto.getcCellId()));
		}
		if (PvuUtils.hasLength(dto.getcPayBandValue())) {
			entity.setPayBandValue(dto.getcPayBandValue());
		}
		if (PvuUtils.hasLength(dto.getcPayScaleId())) {
			entity.setcPayScale(new PVUMsPayScaleEntity(dto.getcPayScaleId()));
		}
		if (PvuUtils.hasLength(dto.getcClassId())) {
			entity.setcClass(new EDPLuLookUpInfoEntity(dto.getcClassId()));
		}
		if (dto.getcDateOfNextIncrement() != null) {
			entity.setcDateOfNextIncrement(dto.getcDateOfNextIncrement());
		}
		if (PvuUtils.hasLength(dto.getcOfficeId())) {
			entity.setcOfficeId(new EDPMsOfficeEntity(dto.getcOfficeId()));
		}
		if (PvuUtils.hasLength(dto.getcDesignationId())) {
			entity.setcDesignation(new EDPMsDesignationEntity(dto.getcDesignationId()));
		}
	}

	public PVUSelectiongGradePostDetailDto toPVUObj(PVUSelectionGradeEventEntity selectionEntity) {
		PVUSelectiongGradePostDetailDto postDetails = new PVUSelectiongGradePostDetailDto();
		if (!Utils.isEmpty(selectionEntity.getPayComm())) {
			sevenPayCommForPVURes(selectionEntity, postDetails);
			sixPayCommoForPvuRes(selectionEntity, postDetails);
			fivthPayCommForPvuRes(selectionEntity, postDetails);
		}
		if (!Utils.isEmpty(selectionEntity.getEventOrderDate())) {
			postDetails.setEventOrderDate(selectionEntity.getEventOrderDate().toString());
		}
		pvuResponceCommonDetails(selectionEntity, postDetails);
		postDetails.setEventCode(PvuConstant.EVENT_CODE_SELECTION_NAME);
		return postDetails;
	}

	private void fivthPayCommForPvuRes(PVUSelectionGradeEventEntity selectionEntity,
			PVUSelectiongGradePostDetailDto postDetails) {
		if (selectionEntity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			postDetails.setPayCommId(PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME);
			if (!Utils.isEmpty(selectionEntity.getPayScale())) {
				postDetails
						.setPayScale(pvuMsPayScaleRepository.getOnlyIdAndName(selectionEntity.getPayScale()).getName());
			}
		}
	}

	private void sixPayCommoForPvuRes(PVUSelectionGradeEventEntity selectionEntity,
			PVUSelectiongGradePostDetailDto postDetails) {
		if (selectionEntity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			postDetails.setPayCommId(PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME);

			if (!Utils.isEmpty(selectionEntity.getPayBand())
					&& !Utils.isEmpty(selectionEntity.getPayBand().getPayBandDispVal())) {
				postDetails.setPayBandId(String.valueOf(selectionEntity.getPayBand().getPayBandDispVal()));
			}
			if (!Utils.isEmpty(selectionEntity.getPayBandValue())) {
				postDetails.setPayBandValue(String.valueOf(selectionEntity.getPayBandValue()));
			}
			if (!Utils.isEmpty(selectionEntity.getGradePay())
					&& !Utils.isEmpty(selectionEntity.getGradePay().getGradePayValue())) {
				postDetails.setGradePayId(String.valueOf(selectionEntity.getGradePay().getGradePayValue()));
			}
		}
	}

	private void sevenPayCommForPVURes(PVUSelectionGradeEventEntity selectionEntity,
			PVUSelectiongGradePostDetailDto postDetails) {
		if (selectionEntity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			if (!Utils.isEmpty(selectionEntity.getPayLevel())
					&& !Utils.isEmpty(selectionEntity.getPayLevel().getPayLevelValue())) {
				postDetails.setPayLevelId(selectionEntity.getPayLevel().getPayLevelValue());
			}
			if (!Utils.isEmpty(selectionEntity.getCellId())
					&& !Utils.isEmpty(selectionEntity.getCellId().getCellId())) {
				postDetails.setCellId(String.valueOf(selectionEntity.getCellId().getCellId()));
			}
			postDetails.setPayCommId(PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME);
		}
	}

	private void pvuResponceCommonDetails(PVUSelectionGradeEventEntity selectionEntity,
			PVUSelectiongGradePostDetailDto postDetails) {
		if (!Utils.isEmpty(selectionEntity.getBasicPay())) {
			postDetails.setBasicPay(String.valueOf(selectionEntity.getBasicPay()));
		}

		if (!Utils.isEmpty(selectionEntity.getEventEffectiveDate())) {
			postDetails.setBenefitEffectiveDate(selectionEntity.getEventEffectiveDate().toString());
		}
		if (!Utils.isEmpty(selectionEntity.getDateOfNextIncrement())) {
			postDetails.setDateOfNextIncrement(selectionEntity.getDateOfNextIncrement().toString());
		}
		if (!Utils.isEmpty(selectionEntity.getDesignationId())) {
			postDetails.setDesignationId(selectionEntity.getDesignationId().getDesignationDescription());
		}
		if (!Utils.isEmpty(selectionEntity.getRefDate())) {
			postDetails.setRefDate(selectionEntity.getRefDate());
		}
		if (!Utils.isEmpty(selectionEntity.getOfficeId())
				&& !Utils.isEmpty(selectionEntity.getOfficeId().getOfficeName())) {
			postDetails.setOfficeId(selectionEntity.getOfficeId().getOfficeName());
		}
		if (!Utils.isEmpty(selectionEntity.getTrnNo())) {
			postDetails.setTrnNo(selectionEntity.getTrnNo());
		}
		if (!Utils.isEmpty(selectionEntity.getEmpId())
				&& !Utils.isEmpty(selectionEntity.getEmpId().getEmployeeCode())) {
			postDetails.setEmployeeNo(String.valueOf(selectionEntity.getEmpId().getEmployeeCode()));
		}
		if (!Utils.isEmpty(selectionEntity.getEventOrderNo())) {
			postDetails.setEventOrderNo(selectionEntity.getEventOrderNo());
		}
	}

	public PVUSelectionGradeEventEntity updateSGRemarks(PVUSelectionGradeEventEntity entity,
			PVUSelectionGradeEventDto dto) {
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

		if (!Utils.isEmpty(dto.getVerifierReturnReason())) {
			entity.setVerifierReturnReason(dto.getVerifierReturnReason());
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

	public PVUSelectionGradeEventDto toDTOView(PVUSelectionGradeEventEntity entity) {
		PVUSelectionGradeEventDto dto = new PVUSelectionGradeEventDto();

		dto.setEventCode(PvuConstant.SELECTION_GRADE_EVENT_ID.toString());
		if (!PvuUtils.isEmpty(entity.getDesignationId())) {
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
		}
		if (!PvuUtils.isEmpty(entity.getStatusId())) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		if (!PvuUtils.isEmpty(entity.getOfficeId())) {
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
		}

		if (!PvuUtils.isEmpty(entity.getPayComm())) {
			dto.setPayCommId(entity.getPayComm().getLookUpInfoId());
		}
		if (!PvuUtils.isEmpty(entity.getEmpId())) {
			dto.setEmployeeId(entity.getEmpId().getEmpId());
			if (entity.getEmpId() != null && entity.getEmpId().getEmployeeCode() != null) {
				dto.setEmployeeNo(entity.getEmpId().getEmployeeCode());
			}
		}
		if (!PvuUtils.isEmpty(entity.getDesignationId())) {
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
		}

		payCommisionToDto(entity, dto);
		remarksToDto(entity, dto);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	private void payCommisionToDto(PVUSelectionGradeEventEntity entity, PVUSelectionGradeEventDto dto) {
		if (!PvuUtils.isEmpty(entity.getPayBand())) {
			dto.setPayBandId(entity.getPayBand().getId());
		}
		if (!PvuUtils.isEmpty(entity.getGradePay())) {
			dto.setGradePayId(entity.getGradePay().getId());
		}
		if (!PvuUtils.isEmpty(entity.getPayLevel())) {
			dto.setPayLevelId(entity.getPayLevel().getId());
		}
		if (!PvuUtils.isEmpty(entity.getCellId())) {
			dto.setCellId(entity.getCellId().getId());
		}

		if (!Utils.isEmpty(entity.getGradePay())) {
			dto.setGradePayId(entity.getGradePay().getId());
		}

		if (!Utils.isEmpty(entity.getPayBand())) {
			dto.setPayBandId(entity.getPayBand().getId());
		}

		if (!Utils.isEmpty(entity.getPayBandValue())) {
			dto.setPayBandValue(entity.getPayBandValue());
		}

		if (!Utils.isEmpty(entity.getPayLevel())) {
			dto.setPayLevelId(entity.getPayLevel().getId());
		}

		if (!Utils.isEmpty(entity.getCellId())) {
			dto.setCellId(entity.getCellId().getId());
		}

		if (!Utils.isEmpty(entity.getPayScale())) {
			dto.setPayScale(entity.getPayScale());
		}

		if (!Utils.isEmpty(entity.getCurrentDetailsEventId())) {
			dto.setCurrentDetailsEventId(entity.getCurrentDetailsEventId());
		}
	}

	private void remarksToDto(PVUSelectionGradeEventEntity entity, PVUSelectionGradeEventDto dto) {
		if (!Utils.isEmpty(entity.getAuditorRemarks())) {
			dto.setAuditorRemarks(dto.getAuditorRemarks());
		}

		if (!Utils.isEmpty(entity.getVerifierRemarks())) {
			dto.setVerifierRemarks(dto.getVerifierRemarks());
		}

		if (!Utils.isEmpty(entity.getClassTwoRemarks())) {
			dto.setClassTwoRemarks(dto.getClassTwoRemarks());
		}

		if (!Utils.isEmpty(entity.getClassOneRemarks())) {
			dto.setClassOneRemarks(dto.getClassOneRemarks());
		}

		if (!Utils.isEmpty(entity.getPrintRemarks())) {
			dto.setPrintRemarks(dto.getPrintRemarks());
		}

		if (!Utils.isEmpty(entity.getAuditorReturnReason())) {
			dto.setAuditorReturnReason(dto.getAuditorReturnReason());
		}

		if (!Utils.isEmpty(entity.getVerifierReturnReason())) {
			dto.setVerifierReturnReason(dto.getVerifierReturnReason());
		}

		if (!Utils.isEmpty(entity.getClassTwoReturnReason())) {
			dto.setClassTwoReturnReason(dto.getClassTwoReturnReason());
		}

		if (!Utils.isEmpty(entity.getClassOneReturnReason())) {
			dto.setClassOneReturnReason(dto.getClassOneReturnReason());
		}
	}

	public PVUPrintEndorsementEntity toEntityPrint(PVUPrintEndorsementDto dto) {
		PVUPrintEndorsementEntity entity = new PVUPrintEndorsementEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public PVUPrintEndorsementDto toDTOPrint(PVUPrintEndorsementEntity entity) {
		PVUPrintEndorsementDto dto = new PVUPrintEndorsementDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public PVUPrintEndorsementItrEntity toEntityPrint(PVUPrintEndorsementEntity printEntity) {
		PVUPrintEndorsementItrEntity entity = new PVUPrintEndorsementItrEntity();
		BeanUtils.copyProperties(printEntity, entity);
		return entity;
	}

	public VelocityContext setPopulateVContext(PVUStickerDTO stickerDTO, PVUSelectionGradeEventEntity entity,
			PVUCommonApiDto apiDto, PVUSelectiongGradePostDetailDto postDetails, String authorize) {
		VelocityContext context = new VelocityContext();
		if (!Utils.isEmpty(stickerDTO.getEmployeeNo())) {
			context.put("employeeNo", stickerDTO.getEmployeeNo());
		}
		if (!Utils.isEmpty(stickerDTO.getEmployeeName())) {
			context.put("employeeName", entity.getEmpId().getEmployeeName());
			populateName(context, entity);
		}
		if (!Utils.isEmpty(stickerDTO.getEmployeeName())) {
			context.put("designation", stickerDTO.getDesignation());
		}
		if (!Utils.isEmpty(stickerDTO.getOfficeName())) {
			context.put("officeName", stickerDTO.getOfficeName());
		}
		if (!Utils.isEmpty(entity.getEventEffectiveDate())) {
			context.put("effectiveDate", PvuUtils.getStrOfLocalDateInDMY(entity.getEventEffectiveDate()));
		}
		if (!Utils.isEmpty(apiDto.getDateNxtIncr())) {
			context.put("oldIncrement", PvuUtils.getDateToStringDMYFormatValue(apiDto.getDateNxtIncr()));
		}

		if (!Utils.isEmpty(postDetails.getDateOfNextIncrement())) {
			context.put("newIncrement", PvuUtils.getDateToStringDMYFormatValue(postDetails.getDateOfNextIncrement()));
		}

		printEndosmentDate(stickerDTO, entity, context);
		context.put("printCurrentDate", PvuUtils.getStrOfLocalDateInDMY(LocalDate.now()));
		if (!Utils.isEmpty(entity.getBasicPay())) {
			context.put("newBasic", postDetails.getBasicPay());
			context.put("oldBasic", apiDto.getEmpBasicPay());
		}

		if (!Utils.isEmpty(entity.getPersonalPay())) {
			context.put("personalPay", entity.getPersonalPay());
		}
		context.put("eventType", "Selection Grade");
		context.put("authBy", authorize);

		return setPopulateVContextPayComm(context, entity, postDetails, apiDto);
	}
	
	private void populateName(VelocityContext context, PVUSelectionGradeEventEntity spentity) {
		context.put("salutation", spentity.getEmpId().getSalutation() == null ? ""
				: getSalutationName(spentity.getEmpId().getSalutation().getLookUpInfoId()));
		context.put("middleName", getName(spentity.getEmpId().getEmployeeMiddleName()));
		context.put("surname", getName(spentity.getEmpId().getEmployeeSurname()));
		
	}
	private String getSalutationName(Long lkInfoId) {
		EDPLuLookUpInfoEntity saluationLKEntity = lookupinforepository.findBylookUpInfoId(lkInfoId);
		return saluationLKEntity != null ? saluationLKEntity.getLookUpInfoName() : "";
	}
	
	private String getName(String name) {
		if (name == null || name.equals("0"))
			return "";
		else
			return name;
	}

	private void printEndosmentDate(PVUStickerDTO stickerDTO, PVUSelectionGradeEventEntity entity,
			VelocityContext context) {
		if (entity.getEmpId().getGender().getLookUpInfoId() == PvuConstant.EMP_GENDER_FEMALE_ID) {
			context.put("genderHisHerPrefix", "Her");
		} else {
			context.put("genderHisHerPrefix", "His");
		}
		if (!Utils.isEmpty(stickerDTO.getEndorsementPrintDate())) {
			context.put("endorsementPrintDate",
					PvuUtils.getDateToStringDMYFormatValue(stickerDTO.getEndorsementPrintDate()));
		}
		if (!Utils.isEmpty(stickerDTO.getEndorsementReprintDate())) {
			context.put("endorsementReprintDate",
					PvuUtils.getDateToStringDMYFormatValue(stickerDTO.getEndorsementReprintDate()));
		} else {
			context.put("endorsementReprintDate", "");
		}
		if (!Utils.isEmpty(stickerDTO.getRePrintCount())) {
			context.put("rePrintCount",getCount(stickerDTO));
			context.put("rePrintCounter",stickerDTO.getRePrintCount());
		} else {
			context.put("rePrintCount", "");
			context.put("rePrintCounter","");
		}
		if (!Utils.isEmpty(stickerDTO.getRePrintRemark())) {
			context.put("remarks", stickerDTO.getRePrintRemark());
		} else {
			context.put("remarks", "");			
		}

		if (!Utils.isEmpty(entity.getEventOrderDate())) {
			context.put("eventOrderDate", PvuUtils.getStrOfLocalDateInDMY(entity.getEventOrderDate()));
		}
		if (!Utils.isEmpty(entity.getAuthorizerRemark())) {
			context.put("authorizerRemarks", entity.getAuthorizerRemark() != null ? entity.getAuthorizerRemark() : "");
		} else {
			context.put("authorizerRemarks", "");
		}
	}
	
	private Long getCount(PVUStickerDTO stickerDTO) {
		return (stickerDTO.getRePrintCount() != null && stickerDTO.getRePrintCount() > 1)
		? stickerDTO.getRePrintCount() - 1
		: stickerDTO.getRePrintCount();
	}

	private VelocityContext setPopulateVContextPayComm(VelocityContext context, PVUSelectionGradeEventEntity entity,
			PVUSelectiongGradePostDetailDto postDetails, PVUCommonApiDto apiDto) {
		if (!Utils.isEmpty(entity.getPayComm())) {
			payCommisionOfSavenPay(context, entity, postDetails, apiDto);
			payCommisionOfSixPay(context, entity, postDetails, apiDto);
			if ((entity.getPayComm().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID)
					&& (!Utils.isEmpty(entity.getPayScale()))) {
				context.put("oldPayScale", apiDto.getPayScaleName());
				context.put("newPayScale", postDetails.getPayScale());
			}
		}
		return context;
	}

	private void payCommisionOfSavenPay(VelocityContext context, PVUSelectionGradeEventEntity entity,
			PVUSelectiongGradePostDetailDto postDetails, PVUCommonApiDto apiDto) {
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			if (!Utils.isEmpty(entity.getPayLevel())) {
				context.put("oldPayLevel", apiDto.getPayLevelName());
				context.put("newPayLevel", postDetails.getPayLevelId());
			}
			if (!Utils.isEmpty(entity.getCellId().getCellValue())) {
				context.put("cellIdValue", entity.getCellId().getCellValue());
			}
		}
	}

	private void payCommisionOfSixPay(VelocityContext context, PVUSelectionGradeEventEntity entity,
			PVUSelectiongGradePostDetailDto postDetails, PVUCommonApiDto apiDto) {
		if (entity.getPayComm().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			if (!Utils.isEmpty(entity.getPayBand())) {
				context.put("newPayBand", postDetails.getPayBandId());
				context.put("oldPayBand", apiDto.getPayBandName());
			}
			if (!Utils.isEmpty(entity.getPayBandValue())) {
				context.put("newPayBandValue", postDetails.getPayBandValue());
				context.put("oldPayBandValue", apiDto.getPayBandValue());
			}
			if (!Utils.isEmpty(entity.getGradePay())) {
				context.put("newGradePay", postDetails.getGradePayId());
				context.put("oldGradPay", apiDto.getGradePayName());
			}

		}
	}

}
