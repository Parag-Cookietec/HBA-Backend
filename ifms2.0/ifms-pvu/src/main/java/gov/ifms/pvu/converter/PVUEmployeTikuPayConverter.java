package gov.ifms.pvu.converter;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

import org.apache.velocity.VelocityContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.pvu.dto.PVUEmployeTikuPayCurrentDto;
import gov.ifms.pvu.dto.PVUEmployeTikuPayDto;
import gov.ifms.pvu.dto.PVUEmployeTikuPayPostDetailsDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementDto;
import gov.ifms.pvu.dto.PVUStickerDTO;
import gov.ifms.pvu.dto.response.PVUTikuPayApiDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeTikuPayEntity;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.entity.PVUPrintEndorsementEntity;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;



@Component
public class PVUEmployeTikuPayConverter implements BaseConverter<PVUEmployeTikuPayEntity, PVUEmployeTikuPayDto> {

	@Autowired
	private OAuthService authService;

	@Override
	public PVUEmployeTikuPayEntity toEntity(PVUEmployeTikuPayDto pvuEmployeTikuPayDto)  {

		PVUEmployeTikuPayEntity pvuEmployeTikuPayEntity = new PVUEmployeTikuPayEntity();
		BeanUtils.copyProperties(pvuEmployeTikuPayDto, pvuEmployeTikuPayEntity);

		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getTrnNo())) {
			pvuEmployeTikuPayEntity.setTrnNo(pvuEmployeTikuPayDto.getTrnNo());
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getEventOrderNo())) {
			pvuEmployeTikuPayEntity.setEventOrderNo(pvuEmployeTikuPayDto.getEventOrderNo());
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getEventOrderDate())) {
			pvuEmployeTikuPayEntity.setEventOrderDate(pvuEmployeTikuPayDto.getEventOrderDate());
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getEventEffectiveDate())) {
			pvuEmployeTikuPayEntity.setEventEffectiveDate(pvuEmployeTikuPayDto.getEventEffectiveDate());
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getRefDate())) {
			pvuEmployeTikuPayEntity.setRefDate(pvuEmployeTikuPayDto.getRefDate());
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getTikuPay1())) {
			pvuEmployeTikuPayEntity.setTikuPayDateOne(pvuEmployeTikuPayDto.getTikuPay1());
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getTikuPay2())) {
			pvuEmployeTikuPayEntity.setTikuPayDateTwo(pvuEmployeTikuPayDto.getTikuPay2());
		}
		
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getCurrentDetailsEventId())) {
			pvuEmployeTikuPayEntity.setCurrentDetailsEventId(pvuEmployeTikuPayDto.getCurrentDetailsEventId());
		}

		if (PvuUtils.hasLength(pvuEmployeTikuPayDto.getOfficeId())) {
			pvuEmployeTikuPayEntity.setOfficeId(new EDPMsOfficeEntity(pvuEmployeTikuPayDto.getOfficeId()));
			pvuEmployeTikuPayEntity.setcOfficeId(new EDPMsOfficeEntity(pvuEmployeTikuPayDto.getOfficeId())); //
		}
		if (PvuUtils.hasLength(pvuEmployeTikuPayDto.getStatusId()))
			pvuEmployeTikuPayEntity.setStatus(new EDPLuLookUpInfoEntity(pvuEmployeTikuPayDto.getStatusId()));

		if (PvuUtils.hasLength(pvuEmployeTikuPayDto.getTikuType()))
			pvuEmployeTikuPayEntity.setPayType(new EDPLuLookUpInfoEntity(pvuEmployeTikuPayDto.getTikuType()));

		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getEmployeeId())) {
			pvuEmployeTikuPayEntity.setEmployeeId(new PVUEmployeEntity(pvuEmployeTikuPayDto.getEmployeeId()));
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getPayCommId())) {
			pvuEmployeTikuPayEntity.setPayCommId(new EDPLuLookUpInfoEntity(pvuEmployeTikuPayDto.getPayCommId()));
		}


		setEntityPostDetails(pvuEmployeTikuPayDto, pvuEmployeTikuPayEntity);
		setEntityPayPostDetails(pvuEmployeTikuPayDto, pvuEmployeTikuPayEntity);
		// Set Current Details
		setEntityPayCurrentDetails(pvuEmployeTikuPayDto, pvuEmployeTikuPayEntity);

		return pvuEmployeTikuPayEntity;
	}


	private void setEntityPostDetails(PVUEmployeTikuPayDto pvuEmployeTikuPayDto,
									  PVUEmployeTikuPayEntity pvuEmployeTikuPayEntity) {
		if (PvuUtils.hasLength(pvuEmployeTikuPayDto.getAdhocId()))
			pvuEmployeTikuPayEntity.setAdhocId(new EDPLuLookUpInfoEntity(pvuEmployeTikuPayDto.getAdhocId()));

		if (!PvuUtils.isEmpty(pvuEmployeTikuPayDto.getAdhocFromDate()))
			pvuEmployeTikuPayEntity.setAdhocStartDate(pvuEmployeTikuPayDto.getAdhocFromDate());
		if (!PvuUtils.isEmpty(pvuEmployeTikuPayDto.getAdhocToDate()))
			pvuEmployeTikuPayEntity.setAdhocEndDate(pvuEmployeTikuPayDto.getAdhocToDate());

		if (PvuUtils.hasLength(pvuEmployeTikuPayDto.getServiceRegularisedId()))
			pvuEmployeTikuPayEntity.setIsSerRegularised(new EDPLuLookUpInfoEntity(pvuEmployeTikuPayDto.getServiceRegularisedId()));

		if (PvuUtils.hasLength(pvuEmployeTikuPayDto.getGpscExamPassedId()))
			pvuEmployeTikuPayEntity.setIsGpscExamPassed(new EDPLuLookUpInfoEntity(pvuEmployeTikuPayDto.getGpscExamPassedId()));
		if (!PvuUtils.isEmpty(pvuEmployeTikuPayDto.getGpscExamPassedDate()))
			pvuEmployeTikuPayEntity.setGpscExamPassedDate(pvuEmployeTikuPayDto.getGpscExamPassedDate());

		if (!PvuUtils.isEmpty(pvuEmployeTikuPayDto.getDojRegularServiceDate()))
			pvuEmployeTikuPayEntity.setDateOfJoining(pvuEmployeTikuPayDto.getDojRegularServiceDate());

		if (PvuUtils.hasLength(pvuEmployeTikuPayDto.getOptionAvailableId()))
			pvuEmployeTikuPayEntity.setOptAvailed(new EDPLuLookUpInfoEntity(pvuEmployeTikuPayDto.getOptionAvailableId()));
		if (!PvuUtils.isEmpty(pvuEmployeTikuPayDto.getOptionAvailableDate()))
			pvuEmployeTikuPayEntity.setOptAvailedDate(pvuEmployeTikuPayDto.getOptionAvailableDate());

		if (!PvuUtils.isEmpty(pvuEmployeTikuPayDto.getBenEffDate()))
			pvuEmployeTikuPayEntity.setEffDate(pvuEmployeTikuPayDto.getBenEffDate());

		if (!PvuUtils.isEmpty(pvuEmployeTikuPayDto.getDateOfNextIncrement())) {
			pvuEmployeTikuPayEntity.setDateOfNextIncrement(pvuEmployeTikuPayDto.getDateOfNextIncrement());
			pvuEmployeTikuPayEntity.setcNextIncrementDate(pvuEmployeTikuPayDto.getcDateOfNextIncrement());
		}
	}


	private void setEntityPayPostDetails(PVUEmployeTikuPayDto pvuEmployeTikuPayDto,
										 PVUEmployeTikuPayEntity pvuEmployeTikuPayEntity) {
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getEmployeeClassId())) {
			pvuEmployeTikuPayEntity.setClassId(new EDPLuLookUpInfoEntity(pvuEmployeTikuPayDto.getEmployeeClassId()));
		}
		if (PvuUtils.hasLength(pvuEmployeTikuPayDto.getDesignationId())) {
			pvuEmployeTikuPayEntity.setDesignationId(new EDPMsDesignationEntity(pvuEmployeTikuPayDto.getDesignationId()));
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getPayScale())) {
			pvuEmployeTikuPayEntity.setPayScale(new PVUMsPayScaleEntity(pvuEmployeTikuPayDto.getPayScale()));
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getPayLevelId())) {
			pvuEmployeTikuPayEntity.setPayLevelId(new PVUMsPayLevelEntity(pvuEmployeTikuPayDto.getPayLevelId()));
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getCellId())) {
			pvuEmployeTikuPayEntity.setCellId(new PVUMsPayCellEntity(pvuEmployeTikuPayDto.getCellId()));
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getPayBandId())) {
			pvuEmployeTikuPayEntity.setPayBandId(new PVUMsPayBandEntity(pvuEmployeTikuPayDto.getPayBandId()));
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getPayBandValue())) {
			pvuEmployeTikuPayEntity.setPayBandValue(pvuEmployeTikuPayDto.getPayBandValue());
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getGradePayId())) {
			pvuEmployeTikuPayEntity.setGradePayId(new PVUMsGradePayEntity(pvuEmployeTikuPayDto.getGradePayId()));
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getBasicPay())) {
			pvuEmployeTikuPayEntity.setBasicPay(pvuEmployeTikuPayDto.getBasicPay());
		}
	}


	private void setEntityPayCurrentDetails(PVUEmployeTikuPayDto pvuEmployeTikuPayDto,
											PVUEmployeTikuPayEntity pvuEmployeTikuPayEntity) {
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getcBasicPay())) {
			pvuEmployeTikuPayEntity.setcBasicPay(pvuEmployeTikuPayDto.getcBasicPay());
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getcPayBandId())) {
			pvuEmployeTikuPayEntity.setcPayBandId(new PVUMsPayBandEntity(pvuEmployeTikuPayDto.getcPayBandId()));
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getcPayBandValue())) {
			pvuEmployeTikuPayEntity.setcPayBandValue(pvuEmployeTikuPayDto.getcPayBandValue());
		}

		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getcPayLevelId())) {
			pvuEmployeTikuPayEntity.setcPayLevel(new PVUMsPayLevelEntity(pvuEmployeTikuPayDto.getcPayLevelId()));
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getcPayScaleId())) {
			pvuEmployeTikuPayEntity.setcPayScale(new PVUMsPayScaleEntity(pvuEmployeTikuPayDto.getcPayScaleId()));
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getcGradePayId())) {
			pvuEmployeTikuPayEntity.setcGradePay(new PVUMsGradePayEntity(pvuEmployeTikuPayDto.getcGradePayId()));
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getcCellId())) {
			pvuEmployeTikuPayEntity.setcCellId(new PVUMsPayCellEntity(pvuEmployeTikuPayDto.getcCellId()));
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getcDesignationId())) {
			pvuEmployeTikuPayEntity.setcDesignationId(new EDPMsDesignationEntity(pvuEmployeTikuPayDto.getcDesignationId()));
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayDto.getcClassId())) {
			pvuEmployeTikuPayEntity.setcClassId(new EDPLuLookUpInfoEntity(pvuEmployeTikuPayDto.getcClassId()));
		}
	}


	@Override
	public PVUEmployeTikuPayDto toDTO(PVUEmployeTikuPayEntity pvuEmployeTikuPayEntity) {
		PVUEmployeTikuPayDto pvuEmployeTikuPayDto = new PVUEmployeTikuPayDto();
		BeanUtils.copyProperties(pvuEmployeTikuPayEntity, pvuEmployeTikuPayDto);

		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getTrnNo())) {
			pvuEmployeTikuPayDto.setTrnNo(pvuEmployeTikuPayEntity.getTrnNo());
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayEntity.getEventOrderNo())) {
			pvuEmployeTikuPayDto.setEventOrderNo(pvuEmployeTikuPayEntity.getEventOrderNo());
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayEntity.getEventOrderDate())) {
			pvuEmployeTikuPayDto.setEventOrderDate(pvuEmployeTikuPayEntity.getEventOrderDate());
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayEntity.getRefDate())) {
			pvuEmployeTikuPayDto.setRefDate(pvuEmployeTikuPayEntity.getRefDate());
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayEntity.getTikuPayDateOne())) {
			pvuEmployeTikuPayDto.setTikuPay1(pvuEmployeTikuPayEntity.getTikuPayDateOne());
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayEntity.getTikuPayDateTwo())) {
			pvuEmployeTikuPayDto.setTikuPay2(pvuEmployeTikuPayEntity.getTikuPayDateTwo());
		}

		if (!Utils.isEmpty(pvuEmployeTikuPayEntity.getCurrentDetailsEventId())) {
			pvuEmployeTikuPayDto.setCurrentDetailsEventId(pvuEmployeTikuPayEntity.getCurrentDetailsEventId());
		}
		
		if (!Utils.isEmpty(pvuEmployeTikuPayEntity.getEventEffectiveDate())) {
			pvuEmployeTikuPayDto.setEventEffectiveDate(pvuEmployeTikuPayEntity.getEventEffectiveDate());
		}
		if (pvuEmployeTikuPayEntity.getStatus() != null)
			pvuEmployeTikuPayDto.setStatusId(pvuEmployeTikuPayEntity.getStatus().getLookUpInfoId());

		if (pvuEmployeTikuPayEntity.getPayType() !=null)
			pvuEmployeTikuPayDto.setTikuType(pvuEmployeTikuPayEntity.getPayType().getLookUpInfoId());

		if (pvuEmployeTikuPayEntity.getEmployeeId() != null)
			pvuEmployeTikuPayDto.setEmployeeId(pvuEmployeTikuPayEntity.getEmployeeId().getEmpId());

		if (pvuEmployeTikuPayEntity.getEmployeeId() != null && pvuEmployeTikuPayEntity.getEmployeeId().getEmployeeCode() != null)
			pvuEmployeTikuPayDto.setEmployeeNo(pvuEmployeTikuPayEntity.getEmployeeId().getEmployeeCode());


		// Post Details
		setPostDetails(pvuEmployeTikuPayEntity, pvuEmployeTikuPayDto);

		if (pvuEmployeTikuPayEntity.getPayCommId() != null)
			pvuEmployeTikuPayDto.setPayCommId(pvuEmployeTikuPayEntity.getPayCommId().getLookUpInfoId());

		setPostPayDetailsToDTO(pvuEmployeTikuPayEntity, pvuEmployeTikuPayDto);

		setCurrentPayDetailsToDTO(pvuEmployeTikuPayEntity, pvuEmployeTikuPayDto);

		return pvuEmployeTikuPayDto;
	}


	private void setPostDetails(PVUEmployeTikuPayEntity pvuEmployeTikuPayEntity,
								PVUEmployeTikuPayDto pvuEmployeTikuPayDto) {
		if (pvuEmployeTikuPayEntity.getAdhocId() != null)
			pvuEmployeTikuPayDto.setAdhocId(pvuEmployeTikuPayEntity.getAdhocId().getLookUpInfoId());

		if (!PvuUtils.isEmpty(pvuEmployeTikuPayEntity.getAdhocStartDate()))
			pvuEmployeTikuPayDto.setAdhocFromDate(pvuEmployeTikuPayEntity.getAdhocStartDate());
		if (!PvuUtils.isEmpty(pvuEmployeTikuPayEntity.getAdhocEndDate()))
			pvuEmployeTikuPayDto.setAdhocToDate(pvuEmployeTikuPayEntity.getAdhocEndDate());
		if (pvuEmployeTikuPayEntity.getIsSerRegularised() != null)
			pvuEmployeTikuPayDto.setServiceRegularisedId(pvuEmployeTikuPayEntity.getIsSerRegularised().getLookUpInfoId());

		if (pvuEmployeTikuPayEntity.getIsGpscExamPassed() != null)
			pvuEmployeTikuPayDto.setGpscExamPassedId(pvuEmployeTikuPayEntity.getIsGpscExamPassed().getLookUpInfoId());

		if (pvuEmployeTikuPayEntity.getGpscExamPassedDate()!=null)
			pvuEmployeTikuPayDto.setGpscExamPassedDate(pvuEmployeTikuPayEntity.getGpscExamPassedDate());

		if (!PvuUtils.isEmpty(pvuEmployeTikuPayEntity.getDateOfJoining()))
			pvuEmployeTikuPayDto.setDojRegularServiceDate(pvuEmployeTikuPayEntity.getDateOfJoining());

		if (pvuEmployeTikuPayEntity.getOptAvailed() != null)
			pvuEmployeTikuPayDto.setOptionAvailableId(pvuEmployeTikuPayEntity.getOptAvailed().getLookUpInfoId());
		if (pvuEmployeTikuPayEntity.getOptAvailedDate() != null)
			pvuEmployeTikuPayDto.setOptionAvailableDate(pvuEmployeTikuPayEntity.getOptAvailedDate());

		if (!PvuUtils.isEmpty(pvuEmployeTikuPayEntity.getEffDate()))
			pvuEmployeTikuPayDto.setBenEffDate(pvuEmployeTikuPayEntity.getEffDate());
		if (!PvuUtils.isEmpty(pvuEmployeTikuPayEntity.getDateOfNextIncrement()))
			pvuEmployeTikuPayDto.setDateOfNextIncrement(pvuEmployeTikuPayEntity.getDateOfNextIncrement());
		if (pvuEmployeTikuPayEntity.getOfficeId() != null) {
			pvuEmployeTikuPayDto.setOfficeId(pvuEmployeTikuPayEntity.getOfficeId().getOfficeId());
		}
	}


	private void setCurrentPayDetailsToDTO(PVUEmployeTikuPayEntity pvuEmployeTikuPayEntity,
										   PVUEmployeTikuPayDto pvuEmployeTikuPayDto) {
		if (!Utils.isEmpty(pvuEmployeTikuPayEntity.getcClassId())) {
			pvuEmployeTikuPayDto.setcClassId(pvuEmployeTikuPayEntity.getcClassId().getLookUpInfoId());
		}

		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getcDesignationId())) {
			pvuEmployeTikuPayDto.setcDesignationId(pvuEmployeTikuPayEntity.getcDesignationId().getDesignationId());
		}
		if (!Utils.isEmpty(pvuEmployeTikuPayEntity.getcPayScale())) {
			pvuEmployeTikuPayDto.setcPayScaleId(pvuEmployeTikuPayEntity.getcPayScale().getPayScaleId());
		}
		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getcPayLevel())) {
			pvuEmployeTikuPayDto.setcPayLevelId(pvuEmployeTikuPayEntity.getcPayLevel().getId());
		}

		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getcCellId())) {
			pvuEmployeTikuPayDto.setcCellId(pvuEmployeTikuPayEntity.getcCellId().getId());
		}
		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getcPayBandId())) {
			pvuEmployeTikuPayDto.setcPayBandId(pvuEmployeTikuPayEntity.getcPayBandId().getId());
		}
		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getcPayBandValue())) {
			pvuEmployeTikuPayDto.setcPayBandValue(pvuEmployeTikuPayEntity.getcPayBandValue());
		}
		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getcGradePay())) {
			pvuEmployeTikuPayDto.setcGradePayId(pvuEmployeTikuPayEntity.getcGradePay().getId());
		}
		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getcBasicPay())) {
			pvuEmployeTikuPayDto.setcBasicPay(pvuEmployeTikuPayEntity.getcBasicPay());
		}
		if (!PvuUtils.isEmpty(pvuEmployeTikuPayEntity.getcNextIncrementDate())) {

			pvuEmployeTikuPayDto.setcDateOfNextIncrement(pvuEmployeTikuPayEntity.getcNextIncrementDate());
		}
	}
	private void setPostPayDetailsToDTO(PVUEmployeTikuPayEntity pvuEmployeTikuPayEntity,
										PVUEmployeTikuPayDto pvuEmployeTikuPayDto) {
		if (!Utils.isEmpty(pvuEmployeTikuPayEntity.getClassId())) {
			pvuEmployeTikuPayDto.setEmployeeClassId(pvuEmployeTikuPayEntity.getClassId().getLookUpInfoId());
		}

		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getDesignationId())) {
			pvuEmployeTikuPayDto.setDesignationId(pvuEmployeTikuPayEntity.getDesignationId().getDesignationId());
		}

		if (!Utils.isEmpty(pvuEmployeTikuPayEntity.getPayScale())) {
			pvuEmployeTikuPayDto.setPayScale(pvuEmployeTikuPayEntity.getPayScale().getPayScaleId());
			pvuEmployeTikuPayDto.setScaleName(pvuEmployeTikuPayEntity.getPayScale().getPayScaleDispVal());
		}

		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getPayLevelId())) {
			pvuEmployeTikuPayDto.setPayLevelId(pvuEmployeTikuPayEntity.getPayLevelId().getId());
			pvuEmployeTikuPayDto.setPayLevelName(pvuEmployeTikuPayEntity.getPayLevelId().getPayLevelValue());
		}
		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getCellId())) {
			pvuEmployeTikuPayDto.setCellId(pvuEmployeTikuPayEntity.getCellId().getId());
		}
		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getPayBandId())) {
			pvuEmployeTikuPayDto.setPayBandId(pvuEmployeTikuPayEntity.getPayBandId().getId());
			pvuEmployeTikuPayDto.setPayBandName(pvuEmployeTikuPayEntity.getPayBandId().getPayBandDispVal());
		}
		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getPayBandValue())) {
			pvuEmployeTikuPayDto.setPayBandValue(pvuEmployeTikuPayEntity.getPayBandValue());
		}

		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getGradePayId())) {
			pvuEmployeTikuPayDto.setGradePayId(pvuEmployeTikuPayEntity.getGradePayId().getId());
			pvuEmployeTikuPayDto.setGradePayName(pvuEmployeTikuPayEntity.getGradePayId().getGradePayValue());
		}
		if(!Utils.isEmpty(pvuEmployeTikuPayEntity.getBasicPay())) {
			pvuEmployeTikuPayDto.setBasicPay(pvuEmployeTikuPayEntity.getBasicPay());
		}
	}


	public PVUEmployeTikuPayCurrentDto auditorCurrentDetails(PVUTikuPayApiDto pvuTikuPayApiDto,PVUEmployeTikuPayEntity tikuPayEntity) {
		PVUEmployeTikuPayCurrentDto tikuPayCurrentDto = new PVUEmployeTikuPayCurrentDto();

		if(!Utils.isEmpty(pvuTikuPayApiDto.getEmployeeName())) {
			tikuPayCurrentDto.setEmployeeName(pvuTikuPayApiDto.getEmployeeName());
		}
		if(!Utils.isEmpty(pvuTikuPayApiDto.getDateNxtIncr())) {
			tikuPayCurrentDto.setDateNxtIncr(pvuTikuPayApiDto.getDateNxtIncr());
		}

		if(!Utils.isEmpty(pvuTikuPayApiDto.getDesignationName())) {
			tikuPayCurrentDto.setDesignationName(pvuTikuPayApiDto.getDesignationName());
		}
		if(!Utils.isEmpty(pvuTikuPayApiDto.getRetirementDate())) {
			tikuPayCurrentDto.setRetirementDate(pvuTikuPayApiDto.getRetirementDate());
		}
		if(!Utils.isEmpty(pvuTikuPayApiDto.getOfficeName())) {
			tikuPayCurrentDto.setOfficeName(pvuTikuPayApiDto.getOfficeName());
		}
		if(!Utils.isEmpty(pvuTikuPayApiDto.getDateJoining())) {
			tikuPayCurrentDto.setDateJoining(pvuTikuPayApiDto.getDateJoining());
		}
		if(!Utils.isEmpty(pvuTikuPayApiDto.getEmployeeClass())) {
			tikuPayCurrentDto.setEmployeeClass(pvuTikuPayApiDto.getEmployeeClass());
		}
		
		setAuditorPayCommisionCurrentDetails(pvuTikuPayApiDto, tikuPayCurrentDto,tikuPayEntity);
		if(!Utils.isEmpty(tikuPayEntity.getcNextIncrementDate())) {
			tikuPayCurrentDto.setDateNxtIncr(String.valueOf(tikuPayEntity.getcNextIncrementDate()));
		}
		if(!Utils.isEmpty(tikuPayEntity.getcBasicPay())) {
			tikuPayCurrentDto.setEmpBasicPay(String.valueOf(tikuPayEntity.getcBasicPay()));
		}
		if(!Utils.isEmpty(pvuTikuPayApiDto.getTikuPay1())) {
			tikuPayCurrentDto.setTikuPay1(pvuTikuPayApiDto.getTikuPay1());
		}
		if(!Utils.isEmpty(pvuTikuPayApiDto.getTikuPay2())) {
			tikuPayCurrentDto.setTikuPay2(pvuTikuPayApiDto.getTikuPay2());
		}

		return tikuPayCurrentDto;
	}


	private void setAuditorPayCommisionCurrentDetails(PVUTikuPayApiDto pvuTikuPayApiDto,PVUEmployeTikuPayCurrentDto tikuPayCurrentDto,PVUEmployeTikuPayEntity tikuPayEntity) {
		
		if (Objects.equals(pvuTikuPayApiDto.getPayCommId(), PvuConstant.FIFTH_COMMISSION_ID)) {

			if(!Utils.isEmpty(tikuPayEntity.getcPayScale())) {
				tikuPayCurrentDto.setPayScale(String.valueOf(tikuPayEntity.getcPayScale().getScaleValue()));
				tikuPayCurrentDto.setPayScaleName(tikuPayEntity.getcPayScale().getScaleValue());
				tikuPayCurrentDto.setPayCommName(PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME);
			}
		}else if (Objects.equals(pvuTikuPayApiDto.getPayCommId(), PvuConstant.SIXTH_COMMISSION_ID)) {

			tikuPayCurrentDto.setPayCommName(PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME);
			if(!Utils.isEmpty(tikuPayEntity.getcPayBandValue())) {
				tikuPayCurrentDto.setPayBandValue(String.valueOf(tikuPayEntity.getcPayBandValue()));
			}
			if(!Utils.isEmpty(tikuPayEntity.getcGradePay())) {
				tikuPayCurrentDto.setGradePayName(tikuPayEntity.getcGradePay().getGradePayValue());
			}
			if(!Utils.isEmpty(tikuPayEntity.getcPayBandId())) {
				tikuPayCurrentDto.setPayBandName(tikuPayEntity.getcPayBandId().getPayBandDispVal());
			}
		}else if (Objects.equals(pvuTikuPayApiDto.getPayCommId(), PvuConstant.SEVENTH_COMMISSION_ID)) {

			tikuPayCurrentDto.setPayCommName(PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME);

			if(!Utils.isEmpty(tikuPayEntity.getcPayLevel())) {
				tikuPayCurrentDto.setPayLevelName(String.valueOf(tikuPayEntity.getcPayLevel().getPayLevelValue()));
			}

			if(!Utils.isEmpty(tikuPayEntity.getcCellId())) {
				tikuPayCurrentDto.setCellName(String.valueOf(tikuPayEntity.getcCellId().getCellId()));
			}
		}
	}

	public PVUEmployeTikuPayPostDetailsDto setAuditorPostDetails(PVUEmployeTikuPayEntity tikuPayEntity) {
		PVUEmployeTikuPayPostDetailsDto tikuPayPostDetailsDto = new PVUEmployeTikuPayPostDetailsDto();
		tikuPayPostDetailsDto.setOfficeId(tikuPayEntity.getOfficeId().getOfficeName());
		tikuPayPostDetailsDto.setEventOrderNo(tikuPayEntity.getEventOrderNo());
		tikuPayPostDetailsDto.setEventOrderDate(tikuPayEntity.getEventOrderDate().toString());
		tikuPayPostDetailsDto.setEventEffectiveDate(tikuPayEntity.getEventEffectiveDate().toString());

		tikuPayPostDetailsDto.setEventCode(PvuConstant.PVU_TIKU_PAY_EVENT);

		tikuPayPostDetailsDto.setTikuType(tikuPayEntity.getPayType().getLookUpInfoName());
		tikuPayPostDetailsDto.setEmployeeNo(tikuPayEntity.getEmployeeId().getEmployeeCode().toString());

		setAuditorPayCommissionPostDetail(tikuPayEntity, tikuPayPostDetailsDto);

		if(!Utils.isEmpty(tikuPayEntity.getBasicPay())) {
			tikuPayPostDetailsDto.setBasicPay(String.valueOf(tikuPayEntity.getBasicPay()));
		}
		if(!Utils.isEmpty(tikuPayEntity.getAdhocId())) {
			tikuPayPostDetailsDto.setAdhocId(tikuPayEntity.getAdhocId().getLookUpInfoName());
		}
		if(!Utils.isEmpty(tikuPayEntity.getAdhocStartDate())) {
			tikuPayPostDetailsDto.setAdhocFromDate(String.valueOf(tikuPayEntity.getAdhocStartDate()));
		}
		if(!Utils.isEmpty(tikuPayEntity.getAdhocEndDate())) {
			tikuPayPostDetailsDto.setAdhocToDate(String.valueOf(tikuPayEntity.getAdhocEndDate()));
		}
		if(!Utils.isEmpty(tikuPayEntity.getIsSerRegularised())) {
			tikuPayPostDetailsDto.setServiceRegularisedId(tikuPayEntity.getIsSerRegularised().getLookUpInfoDescription());
		}
		if(!Utils.isEmpty(tikuPayEntity.getIsGpscExamPassed())) {
			tikuPayPostDetailsDto.setGpscExamPassedId(tikuPayEntity.getIsGpscExamPassed().getLookUpInfoDescription());
		}
		if(!Utils.isEmpty(tikuPayEntity.getGpscExamPassedDate())) {
			tikuPayPostDetailsDto.setGpscExamPassedDate(String.valueOf(tikuPayEntity.getGpscExamPassedDate()));
		}
		if(!Utils.isEmpty(tikuPayEntity.getDateOfJoining())) {
			tikuPayPostDetailsDto.setDojRegularServiceDate(String.valueOf(tikuPayEntity.getDateOfJoining()));
		}
		if(!Utils.isEmpty(tikuPayEntity.getOptAvailed())) {
			tikuPayPostDetailsDto.setOptionAvailableId(tikuPayEntity.getOptAvailed().getLookUpInfoDescription());
		}
		if(!Utils.isEmpty(tikuPayEntity.getOptAvailedDate())) {
			tikuPayPostDetailsDto.setOptionAvailableDate(tikuPayEntity.getOptAvailedDate().toString());
		}
		if(!Utils.isEmpty(tikuPayEntity.getEffDate())) {
			tikuPayPostDetailsDto.setBenefitEffectiveDate(tikuPayEntity.getEffDate().toString());
		}
		if(!Utils.isEmpty(tikuPayEntity.getDateOfNextIncrement())) {
			tikuPayPostDetailsDto.setDateOfNextIncrement(tikuPayEntity.getDateOfNextIncrement().toString());
		}
		if(!Utils.isEmpty(tikuPayEntity.getDesignationId())) {
			tikuPayPostDetailsDto.setDesignationId(tikuPayEntity.getDesignationId().getDesignationDescription());
		}
		return tikuPayPostDetailsDto;
	}
	private void setAuditorPayCommissionPostDetail(PVUEmployeTikuPayEntity tikuPayEntity,
												   PVUEmployeTikuPayPostDetailsDto tikuPayPostDetailsDto) {
		if (tikuPayEntity.getPayCommId().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
			tikuPayPostDetailsDto.setPayCommId(PvuConstant.SEVENTH_COMMISSION_LOOKUP_NAME);
			tikuPayPostDetailsDto.setPayLevelId(tikuPayEntity.getPayLevelId().getPayLevelValue());
			tikuPayPostDetailsDto.setCellId(String.valueOf(tikuPayEntity.getCellId().getCellId()));
		}
		else if (tikuPayEntity.getPayCommId().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {
			tikuPayPostDetailsDto.setPayCommId(PvuConstant.SIXTH_COMMISSION_LOOKUP_NAME);
			tikuPayPostDetailsDto.setPayBandId(String.valueOf(tikuPayEntity.getPayBandId().getPayBandDispVal()));
			tikuPayPostDetailsDto.setPayBandValue(String.valueOf(tikuPayEntity.getPayBandValue()));
			tikuPayPostDetailsDto.setGradePayId(tikuPayEntity.getGradePayId().getGradePayValue());
		}
		else if (tikuPayEntity.getPayCommId().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
			tikuPayPostDetailsDto.setPayCommId(PvuConstant.FIFTH_COMMISSION_LOOKUP_NAME);
			tikuPayPostDetailsDto.setPayScale(String.valueOf(tikuPayEntity.getPayScale().getScaleValue()));
		}
	}

	public PVUEmployeTikuPayEntity updateTikyPayRemarks(PVUEmployeTikuPayEntity entity, PVUEmployeTikuPayDto dto) {

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
	public VelocityContext populateVContext(PVUStickerDTO stickerDTO,PVUEmployeTikuPayEntity tikuPayEntity,PVUEmployeTikuPayDto tikuPayDto) {
		VelocityContext context = new VelocityContext();

		setTikuPayType(tikuPayDto, context);

		context.put("heshe", tikuPayEntity.getEmployeeId().getGender().getLookUpInfoName().equalsIgnoreCase(PvuConstant.MALE)?"He":"She" );
		context.put("gender", tikuPayEntity.getEmployeeId().getGender().getLookUpInfoName().equalsIgnoreCase(PvuConstant.MALE)?"his":"her" );

		String srSaluation="";
		if(!Utils.isEmpty(tikuPayEntity.getEmployeeId().getSalutation()) ) {
			srSaluation=tikuPayEntity.getEmployeeId().getSalutation().getLookUpInfoName();
		}
		String middleName="";
		if(!"0".equals(tikuPayEntity.getEmployeeId().getEmployeeMiddleName())) {
			middleName=tikuPayEntity.getEmployeeId().getEmployeeMiddleName();
		}
		String surName="";
		if(!"0".equalsIgnoreCase(tikuPayEntity.getEmployeeId().getEmployeeSurname()) ) {
			surName=tikuPayEntity.getEmployeeId().getEmployeeSurname();
		}
		
		context.put("employeeName", srSaluation +" "+tikuPayEntity.getEmployeeId().getEmployeeName()+" "+ middleName +" "+surName);


		if(!Utils.isEmpty(tikuPayEntity.getEmployeeId())) {
			context.put("employeeNo", stickerDTO.getEmployeeNo());
		}
		if(!Utils.isEmpty(stickerDTO.getDesignation())) {
			context.put("designation", stickerDTO.getDesignation());
		}

		if(!Utils.isEmpty(stickerDTO.getOfficeName())) {
			context.put("officeName", stickerDTO.getOfficeName());
		}

		if(!Utils.isEmpty(tikuPayDto.getBenEffDate())) {
			context.put("effectiveDate", tikuPayDto.getBenEffDate().format(DateTimeFormatter.ofPattern(PvuConstant.TIKUPAY_DD_MM_YYY)));
		}
		if(!Utils.isEmpty(stickerDTO.getNextIncDate())) {
			context.put("nextIncDate", stickerDTO.getNextIncDate());
		}
		if(!Utils.isEmpty(tikuPayDto.getOptionAvailableDate())) {
			context.put("optionDate",tikuPayDto.getOptionAvailableDate().format(DateTimeFormatter.ofPattern(PvuConstant.TIKUPAY_DD_MM_YYY)));
		}else {
			context.put("optionDate","");
		}

		if(!Utils.isEmpty(tikuPayDto.getDateOfNextIncrement())) {
			context.put("nextIncrDate",tikuPayDto.getDateOfNextIncrement().format(DateTimeFormatter.ofPattern(PvuConstant.TIKUPAY_DD_MM_YYY)));
		}

		setPrintDetails(stickerDTO, context,tikuPayEntity);

		setPayCommision(tikuPayEntity, tikuPayDto, context);

		return context;
	}


	private void setTikuPayType(PVUEmployeTikuPayDto tikuPayDto, VelocityContext context) {
		if(tikuPayDto.getTikuType() == PvuConstant.TIKU_PAY_ONE) {
			context.put(PvuConstant.TIKU_PAYTYPE ,PvuConstant.TIKU_PAY_I );
			context.put(PvuConstant.TIKU_PAYYEAR,PvuConstant.TIKU_PAY_SIX);
			context.put(PvuConstant.TIKU_PAYSCALE,PvuConstant.TIKU_PAY_FIRST);
		}
		if(tikuPayDto.getTikuType() == PvuConstant.TIKU_PAY_TWO) {
			context.put(PvuConstant.TIKU_PAYTYPE,PvuConstant.TIKU_PAY_II );
			context.put(PvuConstant.TIKU_PAYYEAR ,PvuConstant.TIKU_PAY_THIRTEEN);
			context.put(PvuConstant.TIKU_PAYSCALE,PvuConstant.TIKU_PAY_SECOND);
		}
		if(tikuPayDto.getTikuType() == PvuConstant.TIKU_PAY_THREE) {
			context.put(PvuConstant.TIKU_PAYTYPE,PvuConstant.TIKU_PAY_III );
			context.put(PvuConstant.TIKU_PAYYEAR,PvuConstant.TIKU_PAY_NINETEEN);
			context.put(PvuConstant.TIKU_PAYSCALE,PvuConstant.TIKU_PAY_THIRD);
		}
	}


	private void setPrintDetails(PVUStickerDTO stickerDTO, VelocityContext context,PVUEmployeTikuPayEntity tikuPayEntity) {
		if (!Utils.isEmpty(stickerDTO.getEndorsementPrintDate())) {
			context.put("endorsementPrintDate", Utils.getDateString(stickerDTO.getEndorsementPrintDate()));
		}
		if (!Utils.isEmpty(stickerDTO.getEndorsementReprintDate())) {
			context.put("endorsementReprintDate", Utils.getDateString(stickerDTO.getEndorsementReprintDate()));
		} else {
			context.put("endorsementReprintDate", "");
		}
		if (!Utils.isEmpty(stickerDTO.getRePrintCount())) {
			context.put("rePrintCount",
					(stickerDTO.getRePrintCount() != null && stickerDTO.getRePrintCount() > 1)
							? stickerDTO.getRePrintCount() - 1
							: stickerDTO.getRePrintCount());
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

		context.put("authorizerRemarks",!Utils.isEmpty(tikuPayEntity.getAuthorizerRemark()) ? tikuPayEntity.getAuthorizerRemark() : "" );
		if(tikuPayEntity.getAuthorizeBy()!=null) {
			context.put("authorizeBy",String.valueOf(authService.getOnlyIdAndName(tikuPayEntity.getAuthorizeBy()).getName()));
		}else {
			context.put("authorizeBy","");
		}
	}


	private void setPayCommision(PVUEmployeTikuPayEntity tikuPayEntity, PVUEmployeTikuPayDto tikuPayDto,	VelocityContext context) {
		if(!Utils.isEmpty(tikuPayEntity.getPayCommId())) {
			context.put("basicPay",tikuPayEntity.getBasicPay());
			if (tikuPayEntity.getPayCommId().getLookUpInfoId() == PvuConstant.SEVENTH_COMMISSION_ID) {
				context.put("cPayLevel",tikuPayEntity.getcPayLevel().getPayLevelValue()); // Current
				context.put("newPayLevel",tikuPayEntity.getPayLevelId().getPayLevelValue()); // NewPayLevel
				context.put("cCellIdValue", tikuPayEntity.getcCellId().getCellId());
				context.put("newCellIdValue", tikuPayEntity.getCellId().getCellValue());
				context.put("newCellId", tikuPayEntity.getCellId().getCellId());
			}
			else if (tikuPayEntity.getPayCommId().getLookUpInfoId() == PvuConstant.SIXTH_COMMISSION_ID) {

				context.put("cPayBandId", tikuPayEntity.getcPayBandId().getPayBandDispVal());   // PayBand
				context.put("cPayBandValue", tikuPayDto.getcPayBandValue());
				context.put("newPayBandIdValue", tikuPayEntity.getPayBandId().getPayBandDispVal());
				context.put("newPayBandValue", tikuPayDto.getPayBandValue());
				context.put("newGradeValue",tikuPayEntity.getGradePayId().getGradePayValue());
			}
			else if (tikuPayEntity.getPayCommId().getLookUpInfoId() == PvuConstant.FIFTH_COMMISSION_ID) {
				if (!Utils.isEmpty(tikuPayEntity.getcPayScale())) {
					context.put("cPayScale", tikuPayEntity.getcPayScale().getScaleValue());
				}else {		context.put("cPayScale", "");	}
				if (!Utils.isEmpty(tikuPayEntity.getPayScale())) {
					context.put("newPayScale", tikuPayEntity.getPayScale().getScaleValue());
				}else {					context.put("newPayScale", ""); 				}
			}
		}
	}



}
