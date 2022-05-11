package gov.ifms.loc.serviceimpl;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.loc.converter.LocAdvcPrepCheqPaySdConverter;
import gov.ifms.loc.converter.LocAdviceDeductionSdConverter;
import gov.ifms.loc.converter.LocAdvicePrepHdrConverter;
import gov.ifms.loc.converter.LocMsAdviceDtlConvertor;
import gov.ifms.loc.dto.LocActiveDeductionEditViewDto;
import gov.ifms.loc.dto.LocAdvcPrepCheqPaySdDto;
import gov.ifms.loc.dto.LocAdviceAmountDto;
import gov.ifms.loc.dto.LocAdviceAuthorizationListingDto;
import gov.ifms.loc.dto.LocAdviceCardexVerificationListingDto;
import gov.ifms.loc.dto.LocAdviceChqEpayList;
import gov.ifms.loc.dto.LocAdviceChqTypeEmpList;
import gov.ifms.loc.dto.LocAdviceChqTypeList;
import gov.ifms.loc.dto.LocAdviceChqTypeListDto;
import gov.ifms.loc.dto.LocAdviceChqTypeSrchList;
import gov.ifms.loc.dto.LocAdviceDeductionDto;
import gov.ifms.loc.dto.LocAdviceDeductionSdDto;
import gov.ifms.loc.dto.LocAdviceDtlDataDto;
import gov.ifms.loc.dto.LocAdviceDtlEditViewDto;
import gov.ifms.loc.dto.LocAdviceEpayChqDtlDto;
import gov.ifms.loc.dto.LocAdviceHdrInfoDto;
import gov.ifms.loc.dto.LocAdviceInwardListingDto;
import gov.ifms.loc.dto.LocAdviceMapEpymntEditViewDto;
import gov.ifms.loc.dto.LocAdvicePartHeadwisedetaisSdDto;
import gov.ifms.loc.dto.LocAdvicePaymntLCSearchDto;
import gov.ifms.loc.dto.LocAdvicePostingDtlsEditViewDto;
import gov.ifms.loc.dto.LocAdvicePostingHeadwisedetaisDto;
import gov.ifms.loc.dto.LocAdvicePrepDtlDto;
import gov.ifms.loc.dto.LocAdvicePrepHdrDto;
import gov.ifms.loc.dto.LocAdvicePrepListingDto;
import gov.ifms.loc.dto.LocAdvicePrepMultipleDto;
import gov.ifms.loc.dto.LocAdvicePreparationPaymentDtlsDto;
import gov.ifms.loc.dto.LocAdviceRegChqDtlDto;
import gov.ifms.loc.dto.LocAdviceReqDtlDto;
import gov.ifms.loc.dto.LocAdviceReqParamDto;
import gov.ifms.loc.dto.LocAdviceSrchParamDto;
import gov.ifms.loc.dto.LocAdviceVerificationListingDto;
import gov.ifms.loc.dto.LocAdviceVerifyAuthSearchParam;
import gov.ifms.loc.dto.LocCheckPayEditViewDto;
import gov.ifms.loc.dto.LocCheckPayPaymentDto;
import gov.ifms.loc.dto.LocChqBookActInActDto;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocChqSortDto;
import gov.ifms.loc.dto.LocIdNameDto;
import gov.ifms.loc.dto.LocInwardCardexSrchParamDto;
import gov.ifms.loc.dto.LocMsAdviceDtlDto;
import gov.ifms.loc.dto.LocOpeningBalanceDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.entity.LocAdvcPrepCheqPaySdEntity;
import gov.ifms.loc.entity.LocAdviceDeductionDetailsEntity;
import gov.ifms.loc.entity.LocAdviceDeductionSdEntity;
import gov.ifms.loc.entity.LocAdvicePartHeadwiseSdEntity;
import gov.ifms.loc.entity.LocAdvicePrepHdrEntity;
import gov.ifms.loc.entity.LocMsAdviceDtlEntity;
import gov.ifms.loc.notification.LocNotificationService;
import gov.ifms.loc.repository.LocAdvcPrepCheqPayDtlRepository;
import gov.ifms.loc.repository.LocAdvcPrepCheqPaySdRepository;
import gov.ifms.loc.repository.LocAdviceDeductionSdRepository;
import gov.ifms.loc.repository.LocAdvicePartHeadwiseSdRepository;
import gov.ifms.loc.repository.LocAdvicePartyDetaisRepository;
import gov.ifms.loc.repository.LocAdvicePrepHdrRepository;
import gov.ifms.loc.repository.LocAdvicePrepWfRepository;
import gov.ifms.loc.repository.LocAdvicedeductionDetailsRepository;
import gov.ifms.loc.repository.LocChequeBookHdrRepository;
import gov.ifms.loc.repository.LocDistributionHeadDtlRepository;
import gov.ifms.loc.repository.LocMsAdviceEntityRepostory;
import gov.ifms.loc.service.LocAdvicePrepService;
import gov.ifms.loc.service.LocPDFService;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocDBConstants;
import gov.ifms.loc.util.LocMessageConstant;
import gov.ifms.loc.util.LocNumberToWordsConverter;
import gov.ifms.loc.util.LocNumberToWordsConverterData;
import gov.ifms.loc.util.LocURLConstant;
import gov.ifms.loc.util.LocUtility;
import gov.ifms.loc.workflow.dto.LocPaymentDtlsDto;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;

/**
 * The Class LocAdvicePrepServiceImpl.
 */
@Service
public class LocAdvicePrepServiceImpl implements LocAdvicePrepService {

	/**
	 * The Constant logger.
	 */
	private static final Logger logg = LoggerFactory.getLogger(LocAdvicePrepServiceImpl.class);

	/**
	 * The advice repo.
	 */
	@Autowired
	private LocMsAdviceEntityRepostory adviceRepo;

	/**
	 * The advice type convertor.
	 */
	@Autowired
	private LocMsAdviceDtlConvertor adviceTypeConvertor;

	/**
	 * The hdr repo.
	 */
	@Autowired
	private LocAdvicePrepHdrRepository hdrRepo;

	/**
	 * The hdr converter.
	 */
	@Autowired
	private LocAdvicePrepHdrConverter hdrConverter;

	/**
	 * The sd converter.
	 */
	@Autowired
	private LocAdvcPrepCheqPaySdConverter sdConverter;

	/**
	 * The sd repository.
	 */
	@Autowired
	private LocAdvcPrepCheqPaySdRepository sdRepository;

	/**
	 * The wf repo.
	 */
	@Autowired
	private LocAdvicePrepWfRepository wfRepo;

	/**
	 * The loc wf action config service.
	 */
	@Autowired
	private LocWfActionConfigService locWfActionConfigService;

	/**
	 * The hrd sd repository.
	 */
	@Autowired
	private LocAdviceDeductionSdRepository hrdSdRepository;

	/**
	 * The hdr sd converter.
	 */
	@Autowired
	private LocAdviceDeductionSdConverter hdrSdConverter;

	/**
	 * The dtl repo.
	 */
	@Autowired
	private LocAdvicedeductionDetailsRepository dtlRepo;

	/**
	 * The look up info repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/**
	 * The party head wise repository.
	 */
	@Autowired
	private LocAdvicePartHeadwiseSdRepository partyHeadWiseRepository;

	/**
	 * The distribution dtl repo.
	 */
	@Autowired
	private LocDistributionHeadDtlRepository distributionDtlRepo;

	/**
	 * The check pay dtl repo.
	 */
	@Autowired
	private LocAdvcPrepCheqPayDtlRepository checkPayDtlRepo;

	/**
	 * The pdf service.
	 */
	@Autowired
	private LocPDFService pdfService;

	/**
	 * The Advice Party Detail repo.
	 */
	@Autowired
	private LocAdvicePartyDetaisRepository partyDRepo;

	/**
	 * The notificationService.
	 */
	@Autowired
	private LocNotificationService notificationService;

	@Autowired
	private LocChequeBookHdrRepository chqbookHdrRepo;

	@Override
	public LocAdviceDeductionSdDto deductionDetailandUpdate(LocAdviceDeductionDto dto) throws CustomException {
		LocAdviceDeductionSdDto resultDto = new LocAdviceDeductionSdDto();
		try {
			if (dto.getLocAdviceHrdId() != null) {
				LocAdvicePrepHdrEntity entity = hdrRepo.getOne(dto.getLocAdviceHrdId());
				entity.setNetAmt(dto.getNetTotal());
				entity.setGrossAmt(dto.getGrossAmount());
				entity.setClosingBalance(dto.getClosingBalance());
				entity.setOpeningBalance(dto.getOpeningBalance());
				entity.setNewBalanceAmnt(dto.getNewBalance());
				entity.setDeductionAmount(dto.getDeductionTotal());
				hdrRepo.save(entity);
				LocAdviceDeductionSdDto sdDto = new LocAdviceDeductionSdDto();
				BeanUtils.copyProperties(dto, sdDto);
				LocAdviceDeductionSdEntity hdrEntity = hrdSdRepository.save(hdrSdConverter.toEntity(sdDto));
				resultDto = hdrSdConverter.toDTO(hdrEntity);

			}

		} catch (Exception e) {
			logg.error(e.getMessage(), e);
			throw new CustomException(HttpStatus.CONFLICT, LocMessageConstant.LOC_ADVICE_AMOUNT);
		}
		return resultDto;
	}

	@Override
	public LocAdviceDeductionSdDto getDeductionDtleditview(LocActiveDeductionEditViewDto dto) throws CustomException {
		LocAdviceDeductionSdDto resultDto = null;
		if (LocConstant.VIEW_ACTION.equals(dto.getActionStatus())) {
			LocAdviceDeductionDetailsEntity entity = dtlRepo.findByLcAdviceIdAndActiveStatus(dto.getHdrId(),
					Constant.ACTIVE_STATUS);
			resultDto = hdrSdConverter.dtlSdDto(entity);
		} else if (LocConstant.EDIT_ACTION.equals(dto.getActionStatus())) {
			resultDto = hdrSdConverter
					.toDTO(hrdSdRepository.findByLcAdviceIdAndActiveStatus(dto.getHdrId(), Constant.ACTIVE_STATUS));
		}
		return resultDto;
	}

	@Override
	public LocAdviceDtlDataDto getAdviceDtl(LocAdviceReqParamDto dto) throws CustomException {
		List<Object[]> bankList = hdrRepo.getAdviceDtlBank(dto.getCardexNo(), dto.getDdoNo(), dto.getDistrictId(),
				Constant.ACTIVE_STATUS);
		List<LocAdviceDtlDataDto> bankData = !bankList.isEmpty()
				? NativeQueryResultsMapper.map(bankList, LocAdviceDtlDataDto.class)
				: Collections.emptyList();
		List<Object[]> treasuryList = hdrRepo.getAdviceDtlSubTreasuryTreas(dto.getOfficeId());
		List<LocIdNameDto> treasuryData = !treasuryList.isEmpty()
				? NativeQueryResultsMapper.map(treasuryList, LocIdNameDto.class)
				: Collections.emptyList();
		LocAdviceDtlDataDto result = bankData.get(0);
		result.setTresSubTresId(treasuryData.get(0).getId());
		result.setTresSubTresName(treasuryData.get(0).getName());
		result.setLcValidfrom(
				hdrRepo.getLcValidFrom(dto.getCardexNo(), dto.getDdoNo(), dto.getOfficeId(), Constant.ACTIVE_STATUS));
		result.setPaymentType(this.getLookupIdName(LocConstant.ENTRY_TYPE_LOOKUP));
		result.setAdviceNo("");
		result.setAdviceDate("");
		return result;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public LocAdvicePrepHdrDto adviceDtlSave(LocAdvicePrepHdrDto dto) throws CustomException {
		LocAdvicePrepHdrEntity hdrEntity = new LocAdvicePrepHdrEntity();
		List<Object[]> advcList = new ArrayList<>();
		if (dto.getWfUserReqSdDto().getMenuId() == Long.valueOf(LocConstant.MENUID_ADVICE_PRE)) {
			advcList = validation(dto);
		}
		if (CollectionUtils.isEmpty(advcList)) {
			if (Objects.nonNull(dto)) {
				if (Objects.isNull(dto.getId())) {
					hdrEntity = hdrRepo.save(hdrConverter.toEntity(dto));
				} else if (Objects.nonNull(dto.getId())) {
					hdrEntity = hdrRepo.getOne(dto.getId());
					hdrEntity.setRaiseObjectionFlag(dto.getRaiseObjectionFlag());
					hdrEntity.setRaiseObjectionRemarks(dto.getRaiseObjectionRemarks());
					hdrEntity = hdrRepo.save(hdrEntity);
				}

				if (wfRepo.findByTrnIdIdAndActiveStatus(hdrEntity.getId(), Constant.ACTIVE_STATUS) == null) {
					WfUserReqSDDto wfsdDto = dto.getWfUserReqSdDto();
					wfsdDto.setTrnId(hdrEntity.getId());
					callWorkflow(wfsdDto);
				}
			}

		} else {
			throw new CustomException(HttpStatus.CONFLICT, LocMessageConstant.LOC_ADVICE_REQUEST_BEING_PROCESSED);
		}

		return hdrConverter.toDTO(hdrEntity);
	}

	private List<Object[]> validation(LocAdvicePrepHdrDto dto) {
		List<Object[]> obj = hdrRepo.checkAdviceVal(dto.getDivId(), dto.getDdoNo(), dto.getCardexNo(), dto.getDeptId(),
				dto.getDistrictId());
		return obj;
	}

	/**
	 * Call workflow.
	 *
	 * @param wfSaveDto the wf save dto
	 *
	 * @throws CustomException the custom exception
	 */
	private void callWorkflow(WfUserReqSDDto wfSaveDto) throws CustomException {
		locWfActionConfigService.saveWfActConfigTrn(wfSaveDto);
	}

	@Override
	public LocAdviceDtlEditViewDto getAdviceDtlEditView(LocChqBookEditViewDto dto) throws CustomException {
		LocAdviceDtlEditViewDto resultDto = null;
		if (LocConstant.VIEW_ACTION.equals(dto.getActionStatus())) {
			List<Object[]> viewList = hdrRepo.getAdviceDtlViewData(dto.getHdrId(), Constant.ACTIVE_STATUS);
			List<LocAdviceDtlEditViewDto> viewData = !viewList.isEmpty()
					? NativeQueryResultsMapper.map(viewList, LocAdviceDtlEditViewDto.class)
					: Collections.emptyList();
			resultDto = viewData.get(0);
		} else if (LocConstant.EDIT_ACTION.equals(dto.getActionStatus())) {
			List<Object[]> dtlList = hdrRepo.getAdviceDtlEditData(dto.getHdrId(), Constant.ACTIVE_STATUS);
			List<LocAdviceDtlEditViewDto> dtlData = !dtlList.isEmpty()
					? NativeQueryResultsMapper.map(dtlList, LocAdviceDtlEditViewDto.class)
					: Collections.emptyList();
			resultDto = dtlData.get(0);
		}
		return resultDto;
	}

	@Override
	public IdDto delete(IdDto dto) throws CustomException {
		hdrRepo.softDeleteById(dto.getId());
		return dto;
	}

	/**
	 * Gets the lookup id name.
	 *
	 * @param parentLookupId the parent lookup id
	 *
	 * @return the lookup id name
	 * @throws CustomException the custom exception
	 */
	private List<LocIdNameDto> getLookupIdName(Long parentLookupId) throws CustomException {
		List<Object[]> paramList = hdrRepo.getLookupIdandName(parentLookupId, Constant.ACTIVE_STATUS);
		return !paramList.isEmpty() ? NativeQueryResultsMapper.map(paramList, LocIdNameDto.class)
				: Collections.emptyList();
	}

	@Override
	public List<LocIdNameDto> getAdviceChequeListType() throws CustomException {
		List<Object[]> chequeTypeList = hdrRepo.getLookupIdandName(LocConstant.LOC_PARENT_CHEQUE_TYPE,
				Constant.ACTIVE_STATUS);
		return !chequeTypeList.isEmpty() ? NativeQueryResultsMapper.map(chequeTypeList, LocIdNameDto.class)
				: Collections.emptyList();

	}

	@Override
	public List<LocMsAdviceDtlDto> getPostingDtlAdviceType() throws CustomException {
		List<LocMsAdviceDtlEntity> adviceTypeList = adviceRepo.findAll();
		return !adviceTypeList.isEmpty() ? adviceTypeConvertor.toDTO(adviceTypeList) : Collections.emptyList();
	}

	@Override
	public List<LocAdvicePreparationPaymentDtlsDto> getPostingDtls(LocAdviceReqParamDto dto) throws CustomException {
		List<Object[]> advicePaymentDtls = hdrRepo.getAdvicePaymentDetails(String.valueOf(dto.getDdoNo()),
				LocConstant.LOC_AUTHORIZED_ID);

		return !advicePaymentDtls.isEmpty()
				? NativeQueryResultsMapper.map(advicePaymentDtls, LocAdvicePreparationPaymentDtlsDto.class)
				: Collections.emptyList();
	}

	@Override
	public List<LocAdvicePaymntLCSearchDto> getPostingDtlsSearchLc(LocAdvicePostingHeadwisedetaisDto dto)
			throws CustomException {
		List<Object[]> advicePaymentDtls = null;

		if (StringUtils.equals(dto.getFundType(), LocConstant.PUBLIC_ACCOUNT)) {

			advicePaymentDtls = hdrRepo.getAdvicePaymentDetailsLCSearchPA(String.valueOf(dto.getDdoNo()),
					LocConstant.LOC_AUTHORIZED_ID, dto.getMajorheadId(), dto.getSubmajorheadId(), dto.getMinorheadId(),
					dto.getSubheadId(), dto.getDetailHeadId(), dto.getFundType());
		} else {
			if (dto.getEstimateType().contains("Standing")) {
				advicePaymentDtls = hdrRepo.getAdvicePaymentDetailsLCSearchSC(String.valueOf(dto.getDdoNo()),
						LocConstant.LOC_AUTHORIZED_ID, dto.getDemandId(), dto.getMajorheadId(), dto.getSubmajorheadId(),
						dto.getMinorheadId(), dto.getSubheadId(), dto.getDetailHeadId(), dto.getObjectClassId(),
						dto.getFundType(), dto.getBudgetType(), dto.getChargedVoted(), dto.getEstimateType());
			} else {
				advicePaymentDtls = hdrRepo.getAdvicePaymentDetailsLCSearch(String.valueOf(dto.getDdoNo()),
						LocConstant.LOC_AUTHORIZED_ID, dto.getDemandId(), dto.getMajorheadId(), dto.getSubmajorheadId(),
						dto.getMinorheadId(), dto.getSubheadId(), dto.getDetailHeadId(), dto.getItemId(),
						dto.getObjectClassId(), dto.getFundType(), dto.getBudgetType(), dto.getChargedVoted(),
						dto.getEstimateType());
			}
		}
		return !advicePaymentDtls.isEmpty()
				? NativeQueryResultsMapper.map(advicePaymentDtls, LocAdvicePaymntLCSearchDto.class)
				: Collections.emptyList();

	}

	@Override
	public List<LocAdvicePostingDtlsEditViewDto> postingDtlsSave(List<LocAdvicePartHeadwisedetaisSdDto> postingDtlsList)
			throws CustomException {
		if (!CollectionUtils.isEmpty(postingDtlsList)) {

			LocChqBookEditViewDto dto = null;
			for (LocAdvicePartHeadwisedetaisSdDto locAdvicePartHeadwisedetaisDto : postingDtlsList) {
				LocAdvicePartHeadwiseSdEntity sdEntity = null;

				if (Objects.nonNull(locAdvicePartHeadwisedetaisDto.getId())) {
					sdEntity = partyHeadWiseRepository.getOne(locAdvicePartHeadwisedetaisDto.getId());
					sdEntity.setExpenditureAmt(locAdvicePartHeadwisedetaisDto.getExpenditureAmt());
					sdEntity.setHeadwiseAvailableAmt(locAdvicePartHeadwisedetaisDto.getHeadwiseAvailableAmt());
					sdEntity.setLcNo(locAdvicePartHeadwisedetaisDto.getLcNo());
				}

				if (Objects.nonNull(sdEntity)) {
					partyHeadWiseRepository.save(sdEntity);
					dto = new LocChqBookEditViewDto();
					dto.setHdrId(sdEntity.getLcAdviceHdrId());
					dto.setActionStatus(Constant.ACTIVE_STATUS);
				}
			}
			if (Objects.nonNull(dto)) {
				return getPostingDtlEditView(dto);
			}
		}

		return new ArrayList<>();
	}

	@Override
	public List<LocAdvicePostingDtlsEditViewDto> getPostingDtlEditView(LocChqBookEditViewDto dto)
			throws CustomException {
		if (LocConstant.VIEW_ACTION.equals(dto.getActionStatus())) {
			List<Object[]> dtlList = hdrRepo.getPostingDtlViewData(dto.getHdrId(), Constant.ACTIVE_STATUS);
			return !dtlList.isEmpty() ? NativeQueryResultsMapper.map(dtlList, LocAdvicePostingDtlsEditViewDto.class)
					: Collections.emptyList();
		} else if (LocConstant.EDIT_ACTION.equals(dto.getActionStatus())) {
			List<Object[]> dtlList = hdrRepo.getPostingDtlEditData(dto.getHdrId(), Constant.ACTIVE_STATUS);
			return !dtlList.isEmpty() ? NativeQueryResultsMapper.map(dtlList, LocAdvicePostingDtlsEditViewDto.class)
					: Collections.emptyList();
		}
		return new ArrayList<>();
	}

	@Override
	public LocAdviceVerifyAuthSearchParam getAdviceVerifyAuthSearchParam() throws CustomException {
		List<Object[]> searchParam = hdrRepo.getAdviceVerifyAuthSearchParam();
		List<LocAdviceVerifyAuthSearchParam> searchParamList = !searchParam.isEmpty()
				? NativeQueryResultsMapper.map(searchParam, LocAdviceVerifyAuthSearchParam.class)
				: Collections.emptyList();
		LocAdviceVerifyAuthSearchParam resultList = new LocAdviceVerifyAuthSearchParam();
		resultList
				.setWfList(searchParamList.stream().filter(distinctByKeys(LocAdviceVerifyAuthSearchParam::getWfStatus))
						.filter(e -> e.getWfStatus() != null).map(e -> {

							LocAdviceVerifyAuthSearchParam wfStatus = new LocAdviceVerifyAuthSearchParam();
							wfStatus.setWfStatus(e.getWfStatus());
							return wfStatus;
						}).collect(Collectors.toList()));
		resultList
				.setStatusList(searchParamList.stream()
						.filter(distinctByKeys(LocAdviceVerifyAuthSearchParam::getStatusId,
								LocAdviceVerifyAuthSearchParam::getStatusName))
						.filter(e -> e.getStatusId() != null).map(e -> {
							LocAdviceVerifyAuthSearchParam status = new LocAdviceVerifyAuthSearchParam();
							status.setStatusId(e.getStatusId());
							status.setStatusName(e.getStatusName());
							return status;
						}).collect(Collectors.toList()));

		resultList
				.setCircleNameList(searchParamList.stream()
						.filter(distinctByKeys(LocAdviceVerifyAuthSearchParam::getCircleId,
								LocAdviceVerifyAuthSearchParam::getCircleName))
						.filter(e -> e.getCircleId() != null).map(e -> {
							LocAdviceVerifyAuthSearchParam circleName = new LocAdviceVerifyAuthSearchParam();
							circleName.setCircleId(e.getCircleId());
							circleName.setCircleName(e.getCircleName());
							return circleName;
						}).collect(Collectors.toList()));

		resultList
				.setCircleCodeList(searchParamList.stream()
						.filter(distinctByKeys(LocAdviceVerifyAuthSearchParam::getCircleId,
								LocAdviceVerifyAuthSearchParam::getCircleCode))
						.filter(e -> e.getCircleId() != null).map(e -> {
							LocAdviceVerifyAuthSearchParam circleCode = new LocAdviceVerifyAuthSearchParam();
							circleCode.setCircleId(e.getCircleId());
							circleCode.setCircleCode(e.getCircleCode());
							return circleCode;
						}).collect(Collectors.toList()));

		resultList
				.setDivCodeList(searchParamList.stream()
						.filter(distinctByKeys(LocAdviceVerifyAuthSearchParam::getDivId,
								LocAdviceVerifyAuthSearchParam::getDivCode))
						.filter(e -> e.getDivId() != null).map(e -> {
							LocAdviceVerifyAuthSearchParam divCode = new LocAdviceVerifyAuthSearchParam();
							divCode.setDivId(e.getDivId());
							divCode.setDivCode(e.getDivCode());
							return divCode;
						}).collect(Collectors.toList()));

		resultList
				.setDivNameList(searchParamList.stream()
						.filter(distinctByKeys(LocAdviceVerifyAuthSearchParam::getDivId,
								LocAdviceVerifyAuthSearchParam::getDivName))
						.filter(e -> e.getDivId() != null).map(e -> {
							LocAdviceVerifyAuthSearchParam divName = new LocAdviceVerifyAuthSearchParam();
							divName.setDivId(e.getDivId());
							divName.setDivName(e.getDivName());
							return divName;
						}).collect(Collectors.toList()));

		resultList
				.setDeptList(searchParamList.stream()
						.filter(distinctByKeys(LocAdviceVerifyAuthSearchParam::getDeptId,
								LocAdviceVerifyAuthSearchParam::getDeptName))
						.filter(e -> e.getDeptId() != null).map(e -> {
							LocAdviceVerifyAuthSearchParam deptName = new LocAdviceVerifyAuthSearchParam();
							deptName.setDeptId(e.getDeptId());
							deptName.setDeptName(e.getDeptName());
							return deptName;
						}).collect(Collectors.toList()));

		resultList.setPaymentTypeList(searchParamList.stream()
				.filter(distinctByKeys(LocAdviceVerifyAuthSearchParam::getPaymentId,
						LocAdviceVerifyAuthSearchParam::getPaymentName))
				.filter(e -> e.getPaymentId() != null).map(e -> {
					LocAdviceVerifyAuthSearchParam paymentName = new LocAdviceVerifyAuthSearchParam();
					paymentName.setPaymentId(e.getPaymentId());
					paymentName.setPaymentName(e.getPaymentName());
					return paymentName;
				}).collect(Collectors.toList()));

		return resultList;
	}

	@Override
	public void submit(LocSubmitWfDto submitWfDto) throws CustomException {

		LocAdvicePrepHdrEntity hdrEntity = hdrRepo.findByIdAndActiveStatus(submitWfDto.getTrnId(),
				Constant.ACTIVE_STATUS);
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(LocConstant.IN_LC_HDR_ID, submitWfDto.getTrnId());
		setSubmitDataStatus(submitWfDto.getTrnStatus(), argsMap);
		argsMap.put(Constant.IN_UPDATED_BY, OAuthUtility.getCurrentUserUserId());
		argsMap.put(Constant.IN_UPDATED_BY_POST, OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());
		argsMap.put(Constant.IN_DISTRICT_ID, hdrEntity.getDistrictId().getDistrictId());
		argsMap.put(LocDBConstants.IN_DIVISION_ID, hdrEntity.getDivId().getDivisonId());
		argsMap.put(LocDBConstants.IN_WF_ROLE_ID, submitWfDto.getWfId());
		argsMap.put(LocDBConstants.IN_WORKFLOW_ID, submitWfDto.getAssignByWfRoleId());
		String procName = LocConstant.LOC_SCHEMA.concat(LocConstant.DOT)
				.concat(LocDBConstants.SP_LOC_ADVICE_PAYMENT_SUBMIT);
		this.hdrRepo.callStoredProcedureWithNoResult(procName, argsMap);

		submitProc(submitWfDto);
		updateFlaginAdvice(submitWfDto, hdrEntity);

	}

	/**
	 * Submit proc.
	 *
	 * @param submitWfDto the submit wf dto
	 *
	 * @throws CustomException the custom exception
	 */
	@Async
	private void submitProc(LocSubmitWfDto submitWfDto) {
		submitDeduction(submitWfDto);
		submitPosting(submitWfDto);

	}

	private void updateFlaginAdvice(LocSubmitWfDto submitWfDto, LocAdvicePrepHdrEntity hdrEntity) {
		if (submitWfDto.getWfActionId() == LocConstant.APPROVED_ACTION) {
			hdrRepo.updateFlaginAdvice(hdrEntity.getDdoNo(), hdrEntity.getCardexNo(), hdrEntity.getOfficeId());
		}

	}

	/**
	 * Submit posting.
	 *
	 * @param submitWfDto the submit wf dto
	 *
	 * @throws CustomException the custom exception
	 */
	private void submitPosting(LocSubmitWfDto submitWfDto) {

		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(LocConstant.IN_LC_HDR_ID, submitWfDto.getTrnId());
		setSubmitDataStatus(submitWfDto.getTrnStatus(), argsMap);
		argsMap.put(Constant.IN_UPDATED_BY, OAuthUtility.getCurrentUserUserId());
		argsMap.put(Constant.IN_UPDATED_BY_POST, OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());
		String procName = LocConstant.LOC_SCHEMA.concat(LocConstant.DOT)
				.concat(LocDBConstants.SP_LOC_ADVICE_POSTING_SUBMIT);
		this.hdrRepo.callStoredProcedureWithNoResult(procName, argsMap);

	}

	/**
	 * Submit deduction.
	 *
	 * @param submitWfDto the submit wf dto
	 *
	 * @throws CustomException the custom exception
	 */
	private void submitDeduction(LocSubmitWfDto submitWfDto) {

		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(LocConstant.IN_LC_HDR_ID, submitWfDto.getTrnId());
		setSubmitDataStatus(submitWfDto.getTrnStatus(), argsMap);
		argsMap.put(Constant.IN_UPDATED_BY, OAuthUtility.getCurrentUserUserId());
		argsMap.put(Constant.IN_UPDATED_BY_POST, OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());
		String procName = LocConstant.LOC_SCHEMA.concat(LocConstant.DOT)
				.concat(LocDBConstants.SP_LOC_ADVICE_DEDUCTION_SUBMIT);
		this.hdrRepo.callStoredProcedureWithNoResult(procName, argsMap);

	}

	/**
	 * Sets the submit data status.
	 *
	 * @param trnStatus the trn status
	 * @param argsMap   the args map
	 */
	private void setSubmitDataStatus(String trnStatus, Map<String, Object> argsMap) {
		argsMap.put(Constant.IN_STATUS_ID, getStatusLookUp(trnStatus).getLookUpInfoId());
	}

	/**
	 * Gets the status look up.
	 *
	 * @param statusName the status name
	 *
	 * @return the status look up
	 */
	private EDPLuLookUpInfoEntity getStatusLookUp(String statusName) {
		return lookUpInfoRepository.findByLookUpInfoNameAndActiveStatusAndEdpLuLookUpEntityLookUpId(statusName,
				Constant.ACTIVE_STATUS, Constant.STATUS_LOOKUP_ID);

	}

	/**
	 * Distinct by keys.
	 *
	 * @param <T>           the generic type
	 * @param keyExtractors the key extractors
	 *
	 * @return the predicate
	 */
	@SafeVarargs
	private static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) {
		final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();

		return t -> {
			final List<?> keys = Arrays.stream(keyExtractors).map(ke -> ke.apply(t)).collect(Collectors.toList());

			return seen.putIfAbsent(keys, Boolean.TRUE) == null;
		};
	}

	@Override
	public List<LocAdviceMapEpymntEditViewDto> getPostingDtlMapEpymt(LocChqBookEditViewDto dto) throws CustomException {
		List<LocAdviceMapEpymntEditViewDto> resultDto = null;
		if (LocConstant.VIEW_ACTION.equals(dto.getActionStatus())) {
			List<Object[]> viewList = hdrRepo.getPostingDtlMapEpymntView(dto.getHdrId(), Constant.ACTIVE_STATUS);
			List<LocAdviceMapEpymntEditViewDto> viewData = !viewList.isEmpty()
					? NativeQueryResultsMapper.map(viewList, LocAdviceMapEpymntEditViewDto.class)
					: Collections.emptyList();
			resultDto = viewData;
		} else if (LocConstant.EDIT_ACTION.equals(dto.getActionStatus())) {
			List<Object[]> dtlList = hdrRepo.getPostingDtlMapEpymntEdit(dto.getHdrId(), Constant.ACTIVE_STATUS);
			List<LocAdviceMapEpymntEditViewDto> dtlData = !dtlList.isEmpty()
					? NativeQueryResultsMapper.map(dtlList, LocAdviceMapEpymntEditViewDto.class)
					: Collections.emptyList();
			resultDto = dtlData;
		}
		return resultDto;
	}

	@Override
	public List<LocAdvcPrepCheqPaySdDto> getPostingDtlUpdtEpymntAmnt(List<LocAdvcPrepCheqPaySdDto> dtoList)
			throws CustomException {
		LocAdvcPrepCheqPaySdEntity sdEntity = null;
		List<LocAdvcPrepCheqPaySdDto> sdList = new ArrayList<>();
		for (LocAdvcPrepCheqPaySdDto locAdvcPrepCheqPaySdDto : dtoList) {
			if (Objects.nonNull(locAdvcPrepCheqPaySdDto.getSdId()) && locAdvcPrepCheqPaySdDto.getSdId() > 0) {
				sdEntity = sdRepository.getOne(locAdvcPrepCheqPaySdDto.getSdId());
			}
			if (Objects.nonNull(sdEntity)) {
				sdEntity.setEpayAmnt(locAdvcPrepCheqPaySdDto.getEpayAmnt());
				sdEntity.setUpdatedBy(OAuthUtility.getCurrentUserUserId());
				sdEntity.setUpdatedByPost(OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());
				sdEntity.setUpdatedDate(new Date());
				sdRepository.save(sdEntity);
			}

			sdList.add(sdConverter.toDTO(sdEntity));
		}
		return sdList;
	}

	@Override
	public PagebleDTO<LocAdvicePrepListingDto> getAdvicePrepListing(PageDetails pageDetail)
			throws CustomException, ParseException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(LocDBConstants.getLocAdvicePrepListing().get(search.getKey()),
					search.getValue()));
		} else {
			LocDBConstants.getLocAdvicePrepListing()
					.forEach((k, v) -> map.put(LocDBConstants.getLocAdvicePrepListing().get(k), 0));
		}
		String procName = LocConstant.LOC_SCHEMA.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_ADVICE_LISTING));
		List<LocAdvicePrepListingDto> objectSp = this.callStoreProc(procName, map, LocAdvicePrepListingDto.class);
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	@Override
	public LocAdviceChqEpayList getChequeTypeLisiting(LocAdviceChqTypeListDto dto) throws CustomException {
		LocAdviceChqEpayList resultList = new LocAdviceChqEpayList();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(LocDBConstants.IN_VENDOR_PARTY_NAME, dto.getVendorName());
		map.put(LocDBConstants.IN_CHQ_LIST_TYPE, dto.getChqListTypeId());
		map.put(LocDBConstants.IN_BNK_ACNT_NO, dto.getBankAccNo());
		map.put(LocDBConstants.IN_IFSC_CD, dto.getIfscCode());
		map.put(LocDBConstants.IN_BNK_BRNCH_NM, dto.getBankBranchName());
		map.put(LocDBConstants.IN_PAN_NO, dto.getPanNo());
		map.put(LocDBConstants.IN_INCOME_TAX, dto.getIncomeTaxRate());
		map.put(LocDBConstants.IN_MOBILE_NO, dto.getMobileNo());
		map.put(LocDBConstants.IN_EMP_NO, dto.getEmpNo());
		map.put(LocDBConstants.IN_GPF_NO, dto.getGpfNo());
		map.put(LocDBConstants.IN_EMP_NAME, dto.getEmpName());
		map.put(LocDBConstants.IN_DESIG_NAME, dto.getDesignationId());
		map.put(LocDBConstants.IN_EMP_TYPE, dto.getEmpType());
		map.put(LocDBConstants.IN_OFFICE_ID, dto.getOfficeId());
		String procName = LocConstant.LOC_SCHEMA
				.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_PAYMENT_TYPE_LISTING));
		if (dto.getChqListTypeId().equals(LocConstant.LOC_CHQ_TYPE_EMPLOYEE)) {
			resultList.setEmpDtlList(this.callStoreProc(procName, map, LocAdviceChqTypeEmpList.class));
		} else {
			resultList.setDtlList(this.callStoreProc(procName, map, LocAdviceChqTypeList.class));
		}
		return resultList;
	}

	@Override
	public LocAdviceChqTypeSrchList getChequeTypeSearchData(LocAdviceChqTypeListDto dto) throws CustomException {
		LocAdviceChqTypeSrchList resultData = new LocAdviceChqTypeSrchList();
		if (dto.getChqListTypeId().equals(LocConstant.LOC_CHQ_TYPE_EMPLOYEE)) {
			resultData.setEmpTypeList(this.getLookupIdName(LocConstant.LOC_DESIGNATION_ID));
			List<Object[]> designationList = hdrRepo.getDesignationList(dto.getOfficeId(), Constant.ACTIVE_STATUS);
			resultData.setDesignationList(
					!designationList.isEmpty() ? NativeQueryResultsMapper.map(designationList, LocIdNameDto.class)
							: Collections.emptyList());
		} else {
			List<LocIdNameDto> chqList = this.getAdviceChequeListType();
			chqList.removeIf(e -> e.getId().equals(LocConstant.LOC_CHQ_TYPE_EMPLOYEE));
			resultData.setChqTypeList(chqList);
		}
		return resultData;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public List<LocAdvcPrepCheqPaySdDto> chequeEpaySave(List<LocAdvcPrepCheqPaySdDto> dtoList) throws CustomException {
		List<LocAdvcPrepCheqPaySdEntity> sdEntityList = new ArrayList<>();
		for (LocAdvcPrepCheqPaySdDto dto : dtoList) {
			validationChequeDtAmount(dto.getChequeDt(), dto.getChequeAmnt());
			this.checkInActiveValidation(dto.getChequeNo());
			sdEntityList.add(sdConverter.toEntity(dto));
		}
		sdEntityList = sdRepository.saveAll(sdEntityList);
		List<LocAdvcPrepCheqPaySdDto> resultDto = new ArrayList<>();
		for (LocAdvcPrepCheqPaySdEntity entity : sdEntityList) {
			resultDto.add(sdConverter.toDTO(entity));
		}
		return resultDto;
	}

	private void validationChequeDtAmount(Date chequeDt, Double chequeAmnt) throws CustomException {
		if (Objects.nonNull(chequeDt) && !LocUtility.validateFromDate(chequeDt)) {
			throw new CustomException(HttpStatus.CONFLICT, LocMessageConstant.LOC_CURRENT_DT_VALIDATION);
		}
		if (!(Objects.nonNull(chequeAmnt) && chequeAmnt > 0)) {
			throw new CustomException(HttpStatus.CONFLICT, LocMessageConstant.LOC_ADVICE_AMOUNT);
		}

	}

	/**
	 * Call store proc.
	 *
	 * @param <T>      the generic type
	 * @param procName the proc name
	 * @param map      the map
	 * @param view     the view
	 *
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private <T> List<T> callStoreProc(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectSp = hdrRepo.callStoredProcedure(procName, map);
		return !objectSp.isEmpty() ? NativeQueryResultsMapper.map(objectSp, view) : Collections.emptyList();
	}

	@Override
	public IdDto checkPayDelete(IdDto dto) throws CustomException {
		sdRepository.softDeleteById(dto.getId());
		return dto;
	}

	@Override
	public List<LocCheckPayPaymentDto> getCheckPayEditView(LocCheckPayEditViewDto dto) throws CustomException {
		List<LocCheckPayPaymentDto> checkPayEntity = null;
		if (LocConstant.VIEW_ACTION.equals(dto.getActionStatus())) {
			List<Object[]> viewList = checkPayDtlRepo.getPostingDtlEditData(dto.getId(), Constant.ACTIVE_STATUS);
			checkPayEntity = !viewList.isEmpty() ? NativeQueryResultsMapper.map(viewList, LocCheckPayPaymentDto.class)
					: Collections.emptyList();
		} else if (LocConstant.EDIT_ACTION.equals(dto.getActionStatus())) {
			List<Object[]> dtlList = sdRepository.getPostingDtlViewData(dto.getId(), Constant.ACTIVE_STATUS);
			checkPayEntity = !dtlList.isEmpty() ? NativeQueryResultsMapper.map(dtlList, LocCheckPayPaymentDto.class)
					: Collections.emptyList();
		}
		return checkPayEntity;
	}

	@Override
	public LocAdviceEpayChqDtlDto getChequeBookData(LocAdviceReqParamDto dto) throws CustomException {
		int flag = 0;
		List<LocAdviceEpayChqDtlDto> finalChqList = new ArrayList<>();
		LocAdviceEpayChqDtlDto resultDto = new LocAdviceEpayChqDtlDto();
		List<Object[]> chqSeriesList = hdrRepo.getChqSeriesFromChqActInactive(dto.getDistrictId(), dto.getCardexNo(),
				dto.getDdoNo(), Constant.ACTIVE_STATUS);
		List<LocAdviceEpayChqDtlDto> chqBookList1 = !chqSeriesList.isEmpty()
				? NativeQueryResultsMapper.map(chqSeriesList, LocAdviceEpayChqDtlDto.class)
				: Collections.emptyList();
		chqBookList1.removeIf(e -> null == e.getChqSerStart() || e.getChqSerStart().isEmpty());
		List<Object[]> sdActiveList = chqbookHdrRepo.getSdactiveList(Constant.ACTIVE_STATUS, LocConstant.CHQ_IS_ACTIVE,
				Constant.CANCELLED_LOOKUP_NAME, Constant.REJECTED);
		List<LocChqBookActInActDto> sdActiveChqList = !sdActiveList.isEmpty()
				? NativeQueryResultsMapper.map(sdActiveList, LocChqBookActInActDto.class)
				: Collections.emptyList();
		Set<String> startSeries1 = sdActiveChqList.stream().map(LocChqBookActInActDto::getStartSeries)
				.collect(Collectors.toSet());
		Set<String> endseries = sdActiveChqList.stream().map(LocChqBookActInActDto::getEndSeries)
				.collect(Collectors.toSet());
		List<LocAdviceEpayChqDtlDto> chqBookList = chqBookList1.stream()
				.filter(e -> !startSeries1.contains(e.getChqSerStart()))
				.filter(f -> !endseries.contains(f.getChqSeriesEnd())).collect(Collectors.toList());
		List<Object[]> locChqList = hdrRepo.getLocAdviceChqList(dto.getDistrictId(), dto.getCardexNo(), dto.getDdoNo(),
				Constant.ACTIVE_STATUS);
		List<LocAdviceRegChqDtlDto> locChequeData = !locChqList.isEmpty()
				? NativeQueryResultsMapper.map(locChqList, LocAdviceRegChqDtlDto.class)
				: Collections.emptyList();
		locChequeData.removeIf(e -> (null == e.getChqSerStart() || e.getChqSerStart().isEmpty())
				&& (null == e.getChqTochqData() || e.getChqTochqData().isEmpty()));

		resultDto.setLastChqNo(this.getLastChqNo(dto));
		for (LocAdviceEpayChqDtlDto chqBook : chqBookList) {
			if (locChequeData.stream().anyMatch(t -> t.getChqSerStart().equals(chqBook.getChqSerStart()))) {
				if (locChequeData.stream().anyMatch(t -> t.getChqSeriesEnd().equals(chqBook.getChqSeriesEnd()))) {
					finalChqList.add(chqBook);

				} else {
					flag++;
					String[] splitString = resultDto.getLastChqNo().split("-");
					finalChqList.add(chqBook);
					resultDto.setChqSerStart(chqBook.getChqSerStart());
					resultDto.setChqSeriesEnd(chqBook.getChqSeriesEnd());
					Integer chqNo = Integer.valueOf(splitString[1]);
					chqNo++;
					resultDto.setNewChqNo(splitString[0] + "-" + chqNo);
				}
			}
		}
		if (flag == 0 && chqBookList.size() > 1) {
			resultDto.setChqSerStart(chqBookList.get(0).getChqSerStart());
			resultDto.setChqSeriesEnd(chqBookList.get(0).getChqSeriesEnd());
			resultDto.setNewChqNo(chqBookList.get(0).getChqSerStart());
		}
		finalChqList.forEach(f -> chqBookList.removeIf(e -> e.getChqSerStart().equals(f.getChqSerStart())));
		resultDto.setNextChqSeries(chqBookList);
		return resultDto;
	}

	/**
	 * Gets the last chq no.
	 *
	 * @param dto the dto
	 *
	 * @return the last chq no
	 * @throws CustomException the custom exception
	 */
	private String getLastChqNo(LocAdviceReqParamDto dto) throws CustomException {
		List<Object[]> lastChqList = hdrRepo.getLatestChq(dto.getDistrictId(), dto.getCardexNo(), dto.getDdoNo(),
				Constant.ACTIVE_STATUS);
		List<LocChqSortDto> locChequeData = !lastChqList.isEmpty()
				? NativeQueryResultsMapper.map(lastChqList, LocChqSortDto.class)
				: Collections.emptyList();

		List<LocChqSortDto> sortingList = new ArrayList<>();
		locChequeData.stream().filter(f -> null != f.getChqNo())
				.forEach(e -> sortingList.add(new LocChqSortDto(e.getChqNo(), e.getChqDate())));
		locChequeData.stream().filter(f -> null != f.getChqToChqNo())
				.forEach(e -> sortingList.add(new LocChqSortDto(e.getChqToChqNo(), e.getChqToChqDate())));
		sortingList.sort(Comparator.comparing(LocChqSortDto::getChqDate).reversed());
		return sortingList.isEmpty() ? null : sortingList.get(0).getChqNo();
	}

	@Override
	public LocAdviceHdrInfoDto getHeaderInfo(IdDto dto) throws CustomException {

		List<Object[]> pramList = hdrRepo.getHeaderAdviceList(dto.getId(), Constant.ACTIVE_STATUS);
		List<LocAdviceHdrInfoDto> hdrInfolist = !pramList.isEmpty()
				? NativeQueryResultsMapper.map(pramList, LocAdviceHdrInfoDto.class)
				: Collections.emptyList();
		return hdrInfolist.get(0);
	}

	@Override
	public List<LocPaymentDtlsDto> getAllDemandList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException {
		List<Object[]> demandList = distributionDtlRepo.getDemandList(dto.getChargedVoted(), dto.getFundType(),
				dto.getBudgetType(), dto.getDdoNo(), LocConstant.LOC_AUTHORIZED_ID);
		return !demandList.isEmpty() ? NativeQueryResultsMapper.map(demandList, LocPaymentDtlsDto.class)
				: Collections.emptyList();
	}

	@Override
	public List<LocPaymentDtlsDto> getMajorHeadList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException {
		List<Object[]> majorHeadList;
		if (dto.getFundType().equals(LocConstant.PUBLIC_ACCOUNT)) {
			majorHeadList = distributionDtlRepo.getMajorHeadListPA(dto.getFundType(), dto.getDdoNo(),
					LocConstant.LOC_AUTHORIZED_ID);
		} else {

			majorHeadList = distributionDtlRepo.getMajorHeadList(dto.getChargedVoted(), dto.getFundType(),
					dto.getBudgetType(), dto.getDdoNo(), dto.getDemandId(), LocConstant.LOC_AUTHORIZED_ID);
		}
		return !majorHeadList.isEmpty() ? NativeQueryResultsMapper.map(majorHeadList, LocPaymentDtlsDto.class)
				: Collections.emptyList();
	}

	@Override
	public List<LocPaymentDtlsDto> getSubMajorHeadList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException {
		List<Object[]> subMajorHeadList;
		if (dto.getFundType().equals(LocConstant.PUBLIC_ACCOUNT)) {
			subMajorHeadList = distributionDtlRepo.getSubMajorHeadListPA(dto.getFundType(), dto.getDdoNo(),
					dto.getMajorheadId(), LocConstant.LOC_AUTHORIZED_ID);
		} else {

			subMajorHeadList = distributionDtlRepo.getSubMajorHeadList(dto.getChargedVoted(), dto.getFundType(),
					dto.getBudgetType(), dto.getDdoNo(), dto.getDemandId(), dto.getMajorheadId(),
					LocConstant.LOC_AUTHORIZED_ID);

		}
		return !subMajorHeadList.isEmpty() ? NativeQueryResultsMapper.map(subMajorHeadList, LocPaymentDtlsDto.class)
				: Collections.emptyList();
	}

	@Override
	public List<LocIdNameDto> getFundType() throws CustomException {
		List<Object[]> fundTypeList = hdrRepo.getLookupIdandName(LocConstant.FUND_TYPE_PARENT_LOOK_UP_ID,
				Constant.ACTIVE_STATUS);
		return !fundTypeList.isEmpty() ? NativeQueryResultsMapper.map(fundTypeList, LocIdNameDto.class)
				: Collections.emptyList();
	}

	@Override
	public List<LocIdNameDto> getChargedVoted() throws CustomException {
		List<Object[]> chargedVotedList = hdrRepo.getLookupIdandName(LocConstant.CHARGED_VOTED_PARENT_LOOK_UP_ID,
				Constant.ACTIVE_STATUS);
		return !chargedVotedList.isEmpty() ? NativeQueryResultsMapper.map(chargedVotedList, LocIdNameDto.class)
				: Collections.emptyList();
	}

	@Override
	public List<LocIdNameDto> getBudgetType() throws CustomException {
		List<Object[]> budgetTypeList = hdrRepo.getLookupIdandNameBudgetType(LocConstant.BUDGET_TYPE_PARENT_LOOK_UP_ID,
				Constant.ACTIVE_STATUS);
		return !budgetTypeList.isEmpty() ? NativeQueryResultsMapper.map(budgetTypeList, LocIdNameDto.class)
				: Collections.emptyList();
	}

	@Override
	public List<LocPaymentDtlsDto> getMinorHeadList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException {
		List<Object[]> minorHeadList;
		if (dto.getFundType().equals(LocConstant.PUBLIC_ACCOUNT)) {
			minorHeadList = distributionDtlRepo.getMinorHeadListPA(dto.getFundType(), dto.getDdoNo(),
					dto.getMajorheadId(), dto.getSubmajorheadId(), LocConstant.LOC_AUTHORIZED_ID);
		} else {
			minorHeadList = distributionDtlRepo.getMinorHeadList(dto.getChargedVoted(), dto.getFundType(),
					dto.getBudgetType(), dto.getDdoNo(), dto.getDemandId(), dto.getMajorheadId(),
					dto.getSubmajorheadId(), LocConstant.LOC_AUTHORIZED_ID);
		}
		return !minorHeadList.isEmpty() ? NativeQueryResultsMapper.map(minorHeadList, LocPaymentDtlsDto.class)
				: Collections.emptyList();
	}

	@Override
	public List<LocPaymentDtlsDto> getSubHeadList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException {
		List<Object[]> subHeadList;
		if (dto.getFundType().equals(LocConstant.PUBLIC_ACCOUNT)) {
			subHeadList = distributionDtlRepo.getSubHeadListPA(dto.getFundType(), dto.getDdoNo(), dto.getMajorheadId(),
					dto.getSubmajorheadId(), dto.getMinorheadId(), LocConstant.LOC_AUTHORIZED_ID);
		} else {
			subHeadList = distributionDtlRepo.getSubHeadList(dto.getChargedVoted(), dto.getFundType(),
					dto.getBudgetType(), dto.getDdoNo(), dto.getDemandId(), dto.getMajorheadId(),
					dto.getSubmajorheadId(), dto.getMinorheadId(), LocConstant.LOC_AUTHORIZED_ID);

		}
		return !subHeadList.isEmpty() ? NativeQueryResultsMapper.map(subHeadList, LocPaymentDtlsDto.class)
				: Collections.emptyList();
	}

	@Override
	public List<LocPaymentDtlsDto> getDetailHeadList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException {
		List<Object[]> detailHeadList;
		if (dto.getFundType().equals(LocConstant.PUBLIC_ACCOUNT)) {
			detailHeadList = distributionDtlRepo.getDetailHeadListPA(dto.getFundType(), dto.getDdoNo(),
					dto.getMajorheadId(), dto.getSubmajorheadId(), dto.getMinorheadId(), dto.getSubheadId(),
					LocConstant.LOC_AUTHORIZED_ID);
		} else {
			detailHeadList = distributionDtlRepo.getDetailHeadList(dto.getChargedVoted(), dto.getFundType(),
					dto.getBudgetType(), dto.getDdoNo(), dto.getDemandId(), dto.getMajorheadId(),
					dto.getSubmajorheadId(), dto.getMinorheadId(), dto.getSubheadId(), LocConstant.LOC_AUTHORIZED_ID);
		}
		return !detailHeadList.isEmpty() ? NativeQueryResultsMapper.map(detailHeadList, LocPaymentDtlsDto.class)
				: Collections.emptyList();

	}

	@Override
	public List<LocPaymentDtlsDto> getItemNameList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException {
		List<Object[]> itemList;
		itemList = distributionDtlRepo.getItemNameList(dto.getChargedVoted(), dto.getFundType(), dto.getBudgetType(),
				dto.getDdoNo(), dto.getDemandId(), dto.getMajorheadId(), dto.getSubmajorheadId(), dto.getMinorheadId(),
				dto.getSubheadId(), dto.getDetailHeadId(), LocConstant.LOC_AUTHORIZED_ID);

		return !itemList.isEmpty() ? NativeQueryResultsMapper.map(itemList, LocPaymentDtlsDto.class)
				: Collections.emptyList();
	}

	@Override
	public List<LocIdNameDto> getBudgetEstimateTypeList(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException {
		List<Object[]> estimateType = null;
		if (dto.getFundType().equals(LocConstant.PUBLIC_ACCOUNT)) {
			estimateType = distributionDtlRepo.getBudgetEstimateTypeList(dto.getChargedVoted(), dto.getFundType(),
					dto.getBudgetType(), dto.getDdoNo(), dto.getDemandId(), dto.getMajorheadId(),
					dto.getSubmajorheadId(), dto.getMinorheadId(), dto.getSubheadId(), dto.getDetailHeadId(),
					LocConstant.LOC_AUTHORIZED_ID);
		} else {
			estimateType = distributionDtlRepo.getBudgetEstimateTypeListPA(dto.getDdoNo(), dto.getMajorheadId(),
					dto.getSubmajorheadId(), dto.getMinorheadId(), dto.getSubheadId(), dto.getDetailHeadId(),
					LocConstant.LOC_AUTHORIZED_ID);
		}
		return !estimateType.isEmpty() ? NativeQueryResultsMapper.map(estimateType, LocIdNameDto.class)
				: Collections.emptyList();

	}

	@Override
	public List<LocPaymentDtlsDto> getObjectClass(LocAdvicePostingHeadwisedetaisDto dto) throws CustomException {
		List<Object[]> objectClassList = new ArrayList<>();
		if (Objects.nonNull(dto.getItemId()) && !dto.getItemId().equals(LocConstant.LONG_ZERO)) {
			objectClassList = distributionDtlRepo.getObjectClassList(dto.getChargedVoted(), dto.getFundType(),
					dto.getBudgetType(), dto.getDdoNo(), dto.getDemandId(), dto.getMajorheadId(),
					dto.getSubmajorheadId(), dto.getMinorheadId(), dto.getSubheadId(), dto.getDetailHeadId(),
					dto.getItemId(), LocConstant.LOC_AUTHORIZED_ID);
		} else {
			objectClassList = distributionDtlRepo.getObjectClassListSC(dto.getChargedVoted(), dto.getFundType(),
					dto.getBudgetType(), dto.getDdoNo(), dto.getDemandId(), dto.getMajorheadId(),
					dto.getSubmajorheadId(), dto.getMinorheadId(), dto.getSubheadId(), dto.getDetailHeadId(),
					LocConstant.LOC_AUTHORIZED_ID);

		}

		return !objectClassList.isEmpty() ? NativeQueryResultsMapper.map(objectClassList, LocPaymentDtlsDto.class)
				: Collections.emptyList();
	}

	@Override
	public PagebleDTO<LocAdvicePostingDtlsEditViewDto> postingDtlsAdd(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map
					.put(LocDBConstants.getLocAdvicePrepPostingDtlsListing().get(search.getKey()), search.getValue()));
		} else {
			LocDBConstants.getLocAdvicePrepListing()
					.forEach((k, v) -> map.put(LocDBConstants.getLocAdvicePrepPostingDtlsListing().get(k), 0));
		}
		String procName = LocConstant.LOC_SCHEMA
				.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_ADVICE_POSTING_DTLS_LISTING));
		List<LocAdvicePostingDtlsEditViewDto> objectSp = this.callStoreProc(procName, map,
				LocAdvicePostingDtlsEditViewDto.class);
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	@Override
	public IdDto postingDtlsDelete(IdDto dto) throws CustomException {
		LocAdvicePartHeadwiseSdEntity sdEntity = null;
		if (Objects.nonNull(dto) && Objects.nonNull(dto.getId())) {
			sdEntity = partyHeadWiseRepository.getOne(dto.getId());
			sdEntity.setActiveStatus(Constant.IN_ACTIVE_STATUS);
			partyHeadWiseRepository.save(sdEntity);
		}
		return dto;
	}

	@Override
	public Object getOpeningNewBalance(LocAdviceReqParamDto dto) throws CustomException {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(LocConstant.IN_CARDEX_NO, dto.getCardexNo());
		argsMap.put(Constant.IN_DDO_NO, dto.getDdoNo());
		argsMap.put(Constant.IN_OFFICE_ID, dto.getOfficeId());

		String procName = LocConstant.LOC_SCHEMA.concat(LocConstant.DOT).concat(LocDBConstants.SP_LOC_ADVICE_AMOUNT);
		List<Object[]> openingBl = this.hdrRepo.callStoredProcedure(procName, argsMap);
		return !openingBl.isEmpty() ? NativeQueryResultsMapper.map(openingBl, LocOpeningBalanceDto.class)
				: Collections.emptyList();
	}

	@Override
	public List<LocAdviceReqParamDto> generateTokenNo(List<LocAdviceReqParamDto> dtoList) {
		List<LocAdviceReqParamDto> paramDtoList = new ArrayList<>();
		Long cardexNo;
		String ddoNo;
		Long districtId;
		Map<Long, Map<String, Map<Long, List<LocAdviceReqParamDto>>>> groupedMap = dtoList.stream()
				.collect(Collectors.groupingBy(LocAdviceReqParamDto::getCardexNo, Collectors.groupingBy(
						LocAdviceReqParamDto::getDdoNo, Collectors.groupingBy(LocAdviceReqParamDto::getDistrictId))));
		for (Entry<Long, Map<String, Map<Long, List<LocAdviceReqParamDto>>>> locAdviceReqParamDto : groupedMap
				.entrySet()) {
			cardexNo = locAdviceReqParamDto.getKey();
			for (Entry<String, Map<Long, List<LocAdviceReqParamDto>>> locAdviceReqParamDto2 : locAdviceReqParamDto
					.getValue().entrySet()) {
				ddoNo = locAdviceReqParamDto2.getKey();
				for (Entry<Long, List<LocAdviceReqParamDto>> locAdviceReqParamDto3 : locAdviceReqParamDto2.getValue()
						.entrySet()) {
					districtId = locAdviceReqParamDto3.getKey();
					Integer maxTokenNo = hdrRepo.findMaxTokenNoByCardexNoAndDdoNoAndDistrictIdAndActiveStatus(cardexNo,
							ddoNo, districtId, Constant.ACTIVE_STATUS);
					if (Objects.isNull(maxTokenNo)) {
						maxTokenNo = 0;
					}
					Integer tokenNo;
					for (LocAdviceReqParamDto locAdviceReqParamDto4 : locAdviceReqParamDto3.getValue()) {
						tokenNo = maxTokenNo + 1;
						locAdviceReqParamDto4.setTokenNo(tokenNo);
						paramDtoList.add(locAdviceReqParamDto4);
						maxTokenNo = tokenNo;
					}

				}
			}
		}
		return paramDtoList;
	}

	@Override
	public List<LocAdviceReqParamDto> onReceive(List<LocAdviceReqParamDto> dtoList) {
		if (!CollectionUtils.isEmpty(dtoList)) {
			for (LocAdviceReqParamDto locAdviceReqParamDto : dtoList) {
				LocAdvicePrepHdrEntity hdr = hdrRepo.getOne(locAdviceReqParamDto.getHdrId());
				hdr.setVirtualTokenNo(locAdviceReqParamDto.getTokenNo());
				hdr.setVirtualTokenDate(new Date());
				hdr.setUpdatedBy(OAuthUtility.getCurrentUserLkPOUId());
				hdr.setUpdatedByPost(OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());
				hdr.setUpdatedDate(new Date());
				hdrRepo.save(hdr);
				locAdviceReqParamDto.setTokenDt(new Date());
			}
		}
		return dtoList;
	}

	@Override
	public Map<String, Object> lcAdviceStatementPdf(IdDto dto) throws CustomException {
		List<Object[]> hdrList = hdrRepo.getAdviceDtlViewData(dto.getId(), Constant.ACTIVE_STATUS);
		List<LocAdviceDtlEditViewDto> adviceHdrDetails = !hdrList.isEmpty()
				? NativeQueryResultsMapper.map(hdrList, LocAdviceDtlEditViewDto.class)
				: Collections.emptyList();

		List<Object[]> viewList = checkPayDtlRepo.getPostingDtlEditData(dto.getId(), Constant.ACTIVE_STATUS);
		List<LocCheckPayPaymentDto> chqDetails = !viewList.isEmpty()
				? NativeQueryResultsMapper.map(viewList, LocCheckPayPaymentDto.class)
				: Collections.emptyList();

		List<Object[]> dtlList = hdrRepo.getPostingDtlViewData(dto.getId(), Constant.ACTIVE_STATUS);
		List<LocAdvicePostingDtlsEditViewDto> postingDetails = !dtlList.isEmpty()
				? NativeQueryResultsMapper.map(dtlList, LocAdvicePostingDtlsEditViewDto.class)
				: Collections.emptyList();

		LocAdviceDeductionDetailsEntity deductionDetails = dtlRepo.findByLcAdviceIdAndActiveStatus(dto.getId(),
				Constant.ACTIVE_STATUS);

		return generateAdvicePDF(adviceHdrDetails.get(0), chqDetails, postingDetails, deductionDetails);
	}

	/**
	 * Generate advice PDF.
	 *
	 * @param adviceHdrDetails the advice hdr details
	 * @param chqDetails       the chq details
	 * @param postingDetails   the posting details
	 * @param deductionDetails the deduction details
	 *
	 * @return the map
	 */
	private Map<String, Object> generateAdvicePDF(LocAdviceDtlEditViewDto adviceHdrDetails,
			List<LocCheckPayPaymentDto> chqDetails, List<LocAdvicePostingDtlsEditViewDto> postingDetails,
			LocAdviceDeductionDetailsEntity deductionDetails) {
		boolean payTypeEpay = false;
		boolean payTypeChq = false;
		Double chqtotalAmount;
		Map<String, Object> inputMap = null;
		Map<String, Object> resultMap = null;
		inputMap = new HashMap<>();
		inputMap.put("header", adviceHdrDetails);
		inputMap.put("chqDtl", chqDetails);
		inputMap.put("pstDtl", postingDetails);
		inputMap.put("dedDtl", deductionDetails);
		inputMap.put("payTypeChq",
				adviceHdrDetails.getPaymentTypeId().equals(LocConstant.CHQ_TYPE) ? Boolean.TRUE : payTypeEpay);
		inputMap.put("payTypeEpay",
				adviceHdrDetails.getPaymentTypeId().equals(LocConstant.EPAY_TYPE) ? Boolean.TRUE : payTypeChq);
		inputMap.put("qrCode", LocUtility.generateBase64QRCodeImage(getQRDetail(adviceHdrDetails)));
		if (adviceHdrDetails.getPaymentTypeId().equals(LocConstant.CHQ_TYPE)) {
			chqtotalAmount = chqDetails.stream().map(LocCheckPayPaymentDto::getChequeAmount)
					.mapToDouble(Double::doubleValue).sum();
		} else {
			chqtotalAmount = chqDetails.stream().map(LocCheckPayPaymentDto::getEpayAmnt).filter(Objects::nonNull)
					.mapToDouble(Double::doubleValue).sum();
		}
		inputMap.put("chqtotalAmount", chqtotalAmount);
		resultMap = new HashMap<>();
		resultMap.put("base64String", pdfService.generatePDF(LocURLConstant.ADVICE_STATEMENT_FTL_FILE, inputMap,
				LocConstant.ADVICE_PDF_FILE_NAME + adviceHdrDetails.getAdviceNo()));
		resultMap.put("fileName", LocConstant.ADVICE_PDF_FILE_NAME + "  " + adviceHdrDetails.getAdviceNo());
		return resultMap;
	}

	@Override
	public LocAdvicePrepMultipleDto getMultiple(IdDto dto) throws CustomException {
		List<Object[]> multipleData = hdrRepo.getMultipleList(dto.getId(), Constant.ACTIVE_STATUS);
		List<LocAdvicePrepMultipleDto> multipleDtoList = !multipleData.isEmpty()
				? NativeQueryResultsMapper.map(multipleData, LocAdvicePrepMultipleDto.class)
				: Collections.emptyList();
		LocAdvicePrepMultipleDto multipleDto = new LocAdvicePrepMultipleDto();
		multipleDto.setMultipleList(multipleDtoList.stream().filter(e -> null != e.getPartyName()).map(e -> {
			LocAdvicePrepMultipleDto chqPay = new LocAdvicePrepMultipleDto();
			chqPay.setPartyName(e.getPartyName());
			chqPay.setChqAmnt((null != e.getChqAmnt() && !e.getChqAmnt().equals(LocConstant.LONG_ZERO)) ? e.getChqAmnt()
					: e.getEpayAmnt());
			return chqPay;
		}).collect(Collectors.toList()));

		return multipleDto;

	}

	@Override
	public PagebleDTO<LocAdviceInwardListingDto> getAdviceInwardListing(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(LocDBConstants.getLocAdviceInwardListing().get(search.getKey()),
					search.getValue()));
		} else {
			LocDBConstants.getLocAdviceInwardListing()
					.forEach((k, v) -> map.put(LocDBConstants.getLocAdviceInwardListing().get(k), 0));
		}
		String procName = LocConstant.LOC_SCHEMA
				.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_ADVICE_INWARD_LISTING));
		List<LocAdviceInwardListingDto> objectSp = this.callStoreProc(procName, map, LocAdviceInwardListingDto.class);
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	@Override
	public PagebleDTO<LocAdviceCardexVerificationListingDto> getAdviceCardexVerificationListing(PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(
					LocDBConstants.getLocAdviceCardexVerifcationListing().get(search.getKey()), search.getValue()));
		} else {
			LocDBConstants.getLocAdviceCardexVerifcationListing()
					.forEach((k, v) -> map.put(LocDBConstants.getLocAdviceCardexVerifcationListing().get(k), 0));
		}
		String procName = LocConstant.LOC_SCHEMA
				.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_ADVICE_CARDEX_LISTING));
		List<LocAdviceCardexVerificationListingDto> objectSp = this.callStoreProc(procName, map,
				LocAdviceCardexVerificationListingDto.class);
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	@Override
	public PagebleDTO<LocAdviceVerificationListingDto> getAdviceVerficationListing(PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(LocDBConstants.getLocAdviceVerifcationListing().get(search.getKey()),
					search.getValue()));
		} else {
			LocDBConstants.getLocAdviceVerifcationListing()
					.forEach((k, v) -> map.put(LocDBConstants.getLocAdviceVerifcationListing().get(k), 0));
		}
		String procName = LocConstant.LOC_SCHEMA.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_ADVICE_VERIFICATION));
		List<LocAdviceVerificationListingDto> objectSp = this.callStoreProc(procName, map,
				LocAdviceVerificationListingDto.class);
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	@Override
	public PagebleDTO<LocAdviceAuthorizationListingDto> getAdviceAuthorizationListing(PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map
					.put(LocDBConstants.getLocAdviceAuthorizationListing().get(search.getKey()), search.getValue()));
		} else {
			LocDBConstants.getLocAdviceAuthorizationListing()
					.forEach((k, v) -> map.put(LocDBConstants.getLocAdviceAuthorizationListing().get(k), 0));
		}

		String procName = LocConstant.LOC_SCHEMA
				.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_ADVICE_AUTHRZ_LISTING));

		List<LocAdviceAuthorizationListingDto> objectSp = this.callStoreProc(procName, map,
				LocAdviceAuthorizationListingDto.class);
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	@Override
	public LocInwardCardexSrchParamDto getInwardCardexSearchParam() throws CustomException {
		List<Object[]> searchParam = hdrRepo.getInwardCardexSearchParam();
		List<LocInwardCardexSrchParamDto> searchParamList = !searchParam.isEmpty()
				? NativeQueryResultsMapper.map(searchParam, LocInwardCardexSrchParamDto.class)
				: Collections.emptyList();
		LocInwardCardexSrchParamDto resultList = new LocInwardCardexSrchParamDto();

		resultList
				.setCircleNameList(searchParamList.stream()
						.filter(distinctByKeys(LocInwardCardexSrchParamDto::getCircleId,
								LocInwardCardexSrchParamDto::getCircleName))
						.filter(e -> e.getCircleId() != null).map(e -> {
							LocInwardCardexSrchParamDto circleName = new LocInwardCardexSrchParamDto();
							circleName.setCircleId(e.getCircleId());
							circleName.setCircleName(e.getCircleName());
							return circleName;
						}).collect(Collectors.toList()));

		resultList
				.setCircleCodeList(searchParamList.stream()
						.filter(distinctByKeys(LocInwardCardexSrchParamDto::getCircleId,
								LocInwardCardexSrchParamDto::getCircleCode))
						.filter(e -> e.getCircleId() != null).map(e -> {
							LocInwardCardexSrchParamDto circleCode = new LocInwardCardexSrchParamDto();
							circleCode.setCircleId(e.getCircleId());
							circleCode.setCircleCode(e.getCircleCode());
							return circleCode;
						}).collect(Collectors.toList()));

		resultList.setDivCodeList(searchParamList.stream()
				.filter(distinctByKeys(LocInwardCardexSrchParamDto::getDivId, LocInwardCardexSrchParamDto::getDivCode))
				.filter(e -> e.getDivId() != null).map(e -> {
					LocInwardCardexSrchParamDto divCode = new LocInwardCardexSrchParamDto();
					divCode.setDivId(e.getDivId());
					divCode.setDivCode(e.getDivCode());
					return divCode;
				}).collect(Collectors.toList()));

		resultList.setDivNameList(searchParamList.stream()
				.filter(distinctByKeys(LocInwardCardexSrchParamDto::getDivId, LocInwardCardexSrchParamDto::getDivName))
				.filter(e -> e.getDivId() != null).map(e -> {
					LocInwardCardexSrchParamDto divName = new LocInwardCardexSrchParamDto();
					divName.setDivId(e.getDivId());
					divName.setDivName(e.getDivName());
					return divName;
				}).collect(Collectors.toList()));

		return resultList;
	}

	@Override
	public LocAdviceSrchParamDto getSearchParam() throws CustomException {
		List<Object[]> searchParam = hdrRepo.getSearchParam();
		List<LocAdviceSrchParamDto> searchParamList = !searchParam.isEmpty()
				? NativeQueryResultsMapper.map(searchParam, LocAdviceSrchParamDto.class)
				: Collections.emptyList();
		LocAdviceSrchParamDto resultList = new LocAdviceSrchParamDto();
		resultList.setWfList(searchParamList.stream().filter(distinctByKeys(LocAdviceSrchParamDto::getWfStatus))
				.filter(e -> e.getWfStatus() != null).map(e -> {
					LocAdviceSrchParamDto wfStatus = new LocAdviceSrchParamDto();
					wfStatus.setWfStatus(e.getWfStatus());
					return wfStatus;
				}).collect(Collectors.toList()));

		resultList.setStatusList(searchParamList.stream().filter(distinctByKeys(LocAdviceSrchParamDto::getStatusName))
				.filter(e -> e.getStatusId() != null).map(e -> {
					LocAdviceSrchParamDto status = new LocAdviceSrchParamDto();
					status.setStatusId(e.getStatusId());
					status.setStatusName(e.getStatusName());
					return status;
				}).collect(Collectors.toList()));

		return resultList;
	}

	@Override
	public Map<String, Object> genAuthLetter(IdDto dto) throws CustomException {
		LocAdvicePrepDtlDto entity = partyDRepo.getAdvicePrepHdrDtoByHdrIdAndActiveStatus(dto.getId(),
				Constant.ACTIVE_STATUS);
		List<Object[]> chqInvList1 = dtlRepo.getEditViewData(dto.getId(), Constant.ACTIVE_STATUS);
		List<LocAdviceReqDtlDto> list = !chqInvList1.isEmpty()
				? NativeQueryResultsMapper.map(chqInvList1, LocAdviceReqDtlDto.class)
				: Collections.emptyList();
		return genAuthLetterPDF(entity, list.get(0));
	}

	/**
	 * Gen auth letter PDF.
	 *
	 * @param hdrDtlDto the hdr dtl dto
	 * @param agDtlDto  the ag dtl dto
	 *
	 * @return the map
	 */
	private Map<String, Object> genAuthLetterPDF(LocAdvicePrepDtlDto hdrDtlDto, LocAdviceReqDtlDto agDtlDto) {
		Map<String, Object> inputMap = null;
		Map<String, Object> resultMap = null;
		inputMap = new HashMap<>();
		inputMap.put("header", hdrDtlDto);
		inputMap.put("agOffcDtl", agDtlDto);
		inputMap.put("currDate", new Date());
		inputMap.put("lcTotalInWord",
				null != hdrDtlDto.getChequeAmount() ? LocNumberToWordsConverterData.convert(hdrDtlDto.getChequeAmount())
						: null);
		resultMap = new HashMap<>();
		resultMap.put("base64String", pdfService.generatePDF(LocURLConstant.ADVICE_LETTER_FTL_FILE, inputMap,
				LocConstant.ADVICE_LETTER_PDF_FILE_NAME + hdrDtlDto.getChequeDate()));
		resultMap.put("fileName", LocConstant.ADVICE_LETTER_PDF_FILE_NAME + "" + hdrDtlDto.getChequeDate());
		return resultMap;
	}

	@Override
	public Boolean sendNotification(LocSubmitWfDto dto) throws CustomException {
		notificationService.sendNotification(dto);
		return true;
	}

	/**
	 * Gets the QR detail.
	 *
	 * @param hdrDtlDto the hdr dtl dto
	 *
	 * @return the QR detail
	 */
	private String getQRDetail(LocAdviceDtlEditViewDto hdrDtlDto) {
		StringBuilder grnBuilder = new StringBuilder();
		grnBuilder.append(hdrDtlDto.getAdviceNo() + "\n");
		grnBuilder.append(LocConstant.ADVICE_NO
				+ (!hdrDtlDto.getAdviceNo().isEmpty() ? hdrDtlDto.getAdviceNo().substring(11) : null) + "\n");
		grnBuilder.append(LocConstant.ADVICE_DATE + LocUtility.getFormattedDate(hdrDtlDto.getAdviceDate()) + "\n");
		grnBuilder.append(LocConstant.ADVICE_AMOUNT
				+ (LocNumberToWordsConverter.roundBy2Decimal(hdrDtlDto.getGrossAmt())) + "\n");
		grnBuilder.append(LocConstant.PAYMENT_TYPE + (hdrDtlDto.getPaymentTypeName()) + "\n");
		grnBuilder.append(LocConstant.DIVISION_CODE + (hdrDtlDto.getDivCode() + " - " + hdrDtlDto.getDivName()) + "\n");
		grnBuilder.append(LocConstant.CIRCLE_CODE_LABLE + (hdrRepo.getCircle(hdrDtlDto.getDivId())) + "\n");
		grnBuilder.append(LocConstant.DISTRICT_LABLE
				+ (hdrDtlDto.getDistrictCode() + " - " + hdrDtlDto.getDistrictName()) + "\n");
		grnBuilder.append(LocConstant.TO_OFFICE + (hdrDtlDto.getDrawingOfficeName()) + "\n");
		return grnBuilder.toString();
	}

	@Override
	public List<LocAdviceAmountDto> getPostingDtlsSearchLCAdvAmnts(LocAdvicePostingHeadwisedetaisDto dto)
			throws CustomException {
		List<Object[]> advicePaymentDtls = null;

		if (StringUtils.equals(dto.getFundType(), LocConstant.PUBLIC_ACCOUNT)) {

			advicePaymentDtls = hdrRepo.getAdvicePaymentDetailsLCSearchAdvcAmountsPA(String.valueOf(dto.getDdoNo()),
					dto.getMajorheadId(), dto.getSubmajorheadId(), dto.getMinorheadId(), dto.getSubheadId(),
					dto.getDetailHeadId(), dto.getFundTypeId());
		} else {
			if (dto.getEstimateType().contains("Standing")) {
				advicePaymentDtls = hdrRepo.getAdvicePaymentDetailsLCSearchSCAdvcAmounts(String.valueOf(dto.getDdoNo()),
						dto.getDemandId(), dto.getMajorheadId(), dto.getSubmajorheadId(), dto.getMinorheadId(),
						dto.getSubheadId(), dto.getDetailHeadId(), dto.getObjectClassId(), dto.getFundTypeId(),
						dto.getBudgetType(), dto.getChargedVotedId(), dto.getEstimateTypeId());
			} else {
				advicePaymentDtls = hdrRepo.getAdvicePaymentDetailsLCSearchAdvcAmounts(String.valueOf(dto.getDdoNo()),
						dto.getDemandId(), dto.getMajorheadId(), dto.getSubmajorheadId(), dto.getMinorheadId(),
						dto.getSubheadId(), dto.getDetailHeadId(), dto.getItemId(), dto.getObjectClassId(),
						dto.getFundTypeId(), dto.getBudgetType(), dto.getChargedVotedId(), dto.getEstimateTypeId());
			}
		}
		return !advicePaymentDtls.isEmpty() ? NativeQueryResultsMapper.map(advicePaymentDtls, LocAdviceAmountDto.class)
				: Collections.emptyList();

	}

	/**
	 * Check in active validation.
	 *
	 * @param chqNo the chq no
	 * @throws CustomException the custom exception
	 */
	private void checkInActiveValidation(String chqNo) throws CustomException {

		List<Object[]> chqData = hdrRepo.getInactiveCheque(chqNo, Constant.ACTIVE_STATUS);
		if (!chqData.isEmpty()) {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(LocMessageConstant.LOC_CHEQUE_INACTIVATION_IN_PROGRESS,
							chqData.get(0)[0].toString(), chqData.get(0)[1].toString()));

		}

	}
}
