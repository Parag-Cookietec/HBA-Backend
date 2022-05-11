package gov.ifms.loc.serviceimpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.loc.converter.LocAccountCloseReqHdrConverter;
import gov.ifms.loc.converter.LocAccountCloseReqSdConverter;
import gov.ifms.loc.dto.LocAccCloseReqHdrDto;
import gov.ifms.loc.dto.LocAccountCloseReqHdrDto;
import gov.ifms.loc.dto.LocAccountCloseReqSdDto;
import gov.ifms.loc.dto.LocAccountCloseViewDto;
import gov.ifms.loc.dto.LocAcctClsSrchPrmDto;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocCloseReqListDto;
import gov.ifms.loc.dto.LocCloseRequestEditViewDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.entity.LocAccountCloseReqHdrEntity;
import gov.ifms.loc.entity.LocAccountCloseReqSdEntity;
import gov.ifms.loc.notification.LocNotificationService;
import gov.ifms.loc.repository.LocAccountCloseReqHdrRepository;
import gov.ifms.loc.repository.LocAccountCloseReqSdRepository;
import gov.ifms.loc.repository.LocAccountCloseWfRepository;
import gov.ifms.loc.repository.LocAccountOpeningReqHdrRepository;
import gov.ifms.loc.service.LocAccountCloseReqService;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocDBConstants;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;

@Service

public class LocAccountCloseReqServiceImpl implements LocAccountCloseReqService {

	/**
	 * The LocAccountOpenReqSdAsMethodName repository.
	 */
	@Autowired
	private LocAccountOpeningReqHdrRepository openingHdrRepo;

	/**
	 * The look up info repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/**
	 * The hdr repo.
	 */
	@Autowired
	private LocAccountCloseReqHdrRepository hdrRepo;

	/**
	 * The LocAccountOpenReqHdrAsMethodName helper.
	 */
	@Autowired
	private LocAccountCloseReqHdrConverter hdrConverter;

	/**
	 * The LocAccountOpenReqSdAsMethodName repository.
	 */
	@Autowired
	private LocAccountCloseReqSdRepository sdRepo;

	/**
	 * The LocAccountOpenReqSdAsMethodName helper.
	 */
	@Autowired
	private LocAccountCloseReqSdConverter sdConverter;

	/**
	 * The loc account open req wf repository.
	 */
	@Autowired
	private LocAccountCloseWfRepository locAccountOpenReqWfRepository;

	/**
	 * The loc wf action config service.
	 */
	@Autowired
	private LocWfActionConfigService locWfActionConfigService;

	/** The notificationService. */
	@Autowired
	private LocNotificationService notificationService;

	@Override
	public LocAccCloseReqHdrDto getAccountCloseReqDtl(Long officeId, Long departmentId, Long cardexNo, Long ddoNo,
			Long districtId) throws CustomException {
		List<Object[]> closereqDtl = openingHdrRepo.getAccountCloseRequestData(officeId, departmentId, cardexNo, ddoNo,
				districtId);
		List<LocAccCloseReqHdrDto> hdrInfoList = !closereqDtl.isEmpty()
				? NativeQueryResultsMapper.map(closereqDtl, LocAccCloseReqHdrDto.class)
				: Collections.emptyList();
		return hdrInfoList.isEmpty() ? new LocAccCloseReqHdrDto() : hdrInfoList.get(0);
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public LocAccountCloseReqHdrDto createLocAccCloseReqHdr(LocAccountCloseReqHdrDto dto) throws CustomException {
		LocAccountCloseReqHdrDto resultDto = new LocAccountCloseReqHdrDto();
		try {
			LocAccountCloseReqHdrEntity locAccountCloseReqHdrEntity = null;
			if(null==dto.getLcCloseReqHdrId()) {
				locAccountCloseReqHdrEntity = hdrRepo.save(hdrConverter.toEntity(dto));
			}
				resultDto = null!=locAccountCloseReqHdrEntity? hdrConverter.toDTO(locAccountCloseReqHdrEntity):dto;
				LocAccountCloseReqSdDto locAccountCloseReqSdDto = dto.getLocAccountCloseReqSdDto();
				locAccountCloseReqSdDto.setLcCloseReqHdrId(resultDto.getLcCloseReqHdrId());
				locAccountCloseReqSdDto.setLcOpenRequestId(dto.getLcOpenRequestId());

				LocAccountCloseReqSdEntity locAccountCloseReqSdEntity = sdRepo
						.save(sdConverter.toEntity(locAccountCloseReqSdDto));
				resultDto.setLocAccountCloseReqSdDto(sdConverter.toDTO(locAccountCloseReqSdEntity));
				if (locAccountOpenReqWfRepository.findByTrnIdIdAndActiveStatus(
						resultDto.getLcCloseReqHdrId(), Constant.ACTIVE_STATUS) == null) {
					WfUserReqSDDto wfUserReqSDDto = dto.getWfUserReqSDDto();
					wfUserReqSDDto.setTrnId(resultDto.getLcCloseReqHdrId());
					callWorkflow(wfUserReqSDDto);
				}

		} catch (CustomException e) {
			e.printStackTrace();
		}
		return resultDto;
	}

	/**
	 * Call workflow. 
	 *
	 * @param wfSaveDto the wf save dto
	 * @throws CustomException the custom exception
	 */
	private void callWorkflow(WfUserReqSDDto wfSaveDto) throws CustomException {
		locWfActionConfigService.saveWfActConfigTrn(wfSaveDto);
	}

	@Override
	public LocCloseRequestEditViewDto getAccountCloseEditDtl(LocChqBookEditViewDto dto) throws CustomException {
		try {
			Map<String, Object> argsMap = new LinkedHashMap<>();
			argsMap.put(LocConstant.IN_LC_HDR_ID, dto.getHdrId());
			argsMap.put(LocConstant.IN_IS_EDITABLE, dto.getActionStatus());
			String procName = LocConstant.LOC_SCHEMA.concat(LocConstant.DOT)
					.concat(LocDBConstants.SP_LOC_CLOSE_REQ_EDIT_DATA);
			List<Object[]> spObjects = hdrRepo.callStoredProcedure(procName, argsMap);
			List<LocCloseRequestEditViewDto> viewDtoList = !spObjects.isEmpty()
					? NativeQueryResultsMapper.map(spObjects, LocCloseRequestEditViewDto.class)
					: Collections.emptyList();
			if (!viewDtoList.isEmpty()) {
				return viewDtoList.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<LocCloseReqListDto> getClosingListingData(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(
					search -> map.put(LocDBConstants.getLocCloseReqListing().get(search.getKey()), search.getValue()));
		} else {
			LocDBConstants.getLocCloseReqListing()
					.forEach((k, v) -> map.put(LocDBConstants.getLocCloseReqListing().get(k), 0));
		}
		String procName = LocDBConstants.LOC_SCHEMA
				.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_CLOSING_REQUEST_LISTING));
		List<LocCloseReqListDto> objectSp = this.callStoreProc(procName, map, LocCloseReqListDto.class);
		Long totalPages = !objectSp.isEmpty() ? Long.valueOf(objectSp.size()) : objectSp.size();
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	/**
	 * Call store proc.
	 *
	 * @param <T>      the generic type
	 * @param procName the proc name
	 * @param map      the map
	 * @param view     the view
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private <T> List<T> callStoreProc(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectSp = hdrRepo.callStoredProcedure(procName, map);
		return !objectSp.isEmpty() ? NativeQueryResultsMapper.map(objectSp, view) : Collections.emptyList();
	}

	@Override
	public void submitData(LocSubmitWfDto submitWfDto) throws CustomException {
		Optional<LocAccountCloseReqHdrEntity> hdrEntity = hdrRepo
				.findByLcCloseReqHdrIdAndActiveStatus(submitWfDto.getTrnId(), Constant.ACTIVE_STATUS);
		if (hdrEntity.isPresent()) {
			submitData(submitWfDto, LocDBConstants.LOC_CLOSING_REQUEST_SUBMIT_DATA);
		}
	}

	/**
	 * Submit data.
	 *
	 * @param submitWfDto the submit wf dto
	 * @param procName    the proc name
	 */
	private void submitData(LocSubmitWfDto submitWfDto, String procName) throws CustomException {
		updateRefNo(submitWfDto);
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(LocConstant.IN_LC_HDR_ID, submitWfDto.getTrnId());
		setSubmitDataStatus(submitWfDto.getTrnStatus(), argsMap);
		argsMap.put(Constant.IN_WORKFLOW_ID, submitWfDto.getWfId());
		argsMap.put(Constant.IN_WF_ROLE_ID, submitWfDto.getAssignByWfRoleId());
		argsMap.put(Constant.IN_UPDATED_BY, OAuthUtility.getCurrentUserUserId());
		argsMap.put(Constant.IN_UPDATED_BY_POST,
				OAuthUtility.getCurrentUserLoginPostFromOauthToken().getLkPoOffUserId());
		String spName = LocDBConstants.LOC_SCHEMA.concat(LocConstant.DOT).concat(procName);

		this.hdrRepo.callStoredProcedureWithNoResult(spName, argsMap);
		if (submitWfDto.getTrnStatus().equals(LocConstant.AUTHORIZED)) {
			List<Object[]> officeData = hdrRepo.getClosingReqOfficeData(submitWfDto.getTrnId());
			this.closeAccountUpdate(Long.parseLong(officeData.get(0)[0].toString()),
					Long.parseLong(officeData.get(0)[2].toString()), Long.parseLong(officeData.get(0)[1].toString()));
		}
		if (submitWfDto.getWfActionId().equals(LocConstant.APPROVED_ACTION)) {
			notificationService.sendNotification(submitWfDto);

		}
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
	 * @return the status look up
	 */
	private EDPLuLookUpInfoEntity getStatusLookUp(String statusName) {
		return lookUpInfoRepository.findByLookUpInfoNameAndActiveStatusAndEdpLuLookUpEntityLookUpId(statusName,
				Constant.ACTIVE_STATUS, Constant.STATUS_LOOKUP_ID);
	}

	@Override
	public LocAcctClsSrchPrmDto getSrchParam() throws CustomException {
		List<Object[]> paramList = hdrRepo.getSrchParam();
		List<LocAcctClsSrchPrmDto> resultList = !paramList.isEmpty()
				? NativeQueryResultsMapper.map(paramList, LocAcctClsSrchPrmDto.class)
				: Collections.emptyList();
		LocAcctClsSrchPrmDto srchPram = new LocAcctClsSrchPrmDto();

		srchPram.setWfStatusList(resultList.stream().filter(distinctByKeys(LocAcctClsSrchPrmDto::getWfStatus))
				.filter(e -> e.getWfStatus() != null).map(e -> {
					LocAcctClsSrchPrmDto wf = new LocAcctClsSrchPrmDto();
					wf.setWfStatus(e.getWfStatus());
					return wf;
				}).collect(Collectors.toList()));

		srchPram.setStatusList(resultList.stream()
				.filter(distinctByKeys(LocAcctClsSrchPrmDto::getStatusName))
				.filter(f -> f.getStatusId() != null).map(e -> {
					LocAcctClsSrchPrmDto status = new LocAcctClsSrchPrmDto();
					status.setStatusId(e.getStatusId());
					status.setStatusName(e.getStatusName());
					return status;
				}).collect(Collectors.toList()));

		srchPram.setDivCodeList(resultList.stream().filter(distinctByKeys(LocAcctClsSrchPrmDto::getDivCode))
				.filter(e -> e.getDivCode() != null).map(e -> {
					LocAcctClsSrchPrmDto divCode = new LocAcctClsSrchPrmDto();
					divCode.setDivId(e.getDivId());
					divCode.setDivCode(e.getDivCode());
					return divCode;
				}).collect(Collectors.toList()));

		srchPram.setDivNameList(resultList.stream().filter(distinctByKeys(LocAcctClsSrchPrmDto::getDivName))
				.filter(e -> e.getDivName() != null).map(e -> {
					LocAcctClsSrchPrmDto divName = new LocAcctClsSrchPrmDto();
					divName.setDivNameId(e.getDivId());
					divName.setDivName(e.getDivName());
					return divName;
				}).collect(Collectors.toList()));

		srchPram.setCircleCodeList(resultList.stream().filter(distinctByKeys(LocAcctClsSrchPrmDto::getCircleCode))
				.filter(e -> e.getCircleCode() != null).map(e -> {
					LocAcctClsSrchPrmDto circleCode = new LocAcctClsSrchPrmDto();
					circleCode.setCircleId(e.getCircleId());
					circleCode.setCircleCode(e.getCircleCode());
					return circleCode;
				}).collect(Collectors.toList()));

		srchPram.setCircleNameList(resultList.stream().filter(distinctByKeys(LocAcctClsSrchPrmDto::getCircleName))
				.filter(e -> e.getCircleCode() != null).map(e -> {
					LocAcctClsSrchPrmDto circleName = new LocAcctClsSrchPrmDto();
					circleName.setCircleNameId(e.getCircleId());
					circleName.setCircleName(e.getCircleName());
					return circleName;
				}).collect(Collectors.toList()));

		srchPram.setDistList(resultList.stream().filter(distinctByKeys(LocAcctClsSrchPrmDto::getDistrictName))
				.filter(e -> e.getDistrictId() != null).map(e -> {
					LocAcctClsSrchPrmDto distName = new LocAcctClsSrchPrmDto();
					distName.setDistrictId(e.getDistrictId());
					distName.setDistrictName(e.getDistrictName());
					return distName;
				}).collect(Collectors.toList()));

		srchPram.setDeptList(resultList.stream().filter(distinctByKeys(LocAcctClsSrchPrmDto::getDeptName))
				.filter(e -> e.getDeptId() != null).map(e -> {
					LocAcctClsSrchPrmDto deptName = new LocAcctClsSrchPrmDto();
					deptName.setDeptId(e.getDeptId());
					deptName.setDeptName(e.getDeptName());
					return deptName;
				}).collect(Collectors.toList()));

		return srchPram;
	}

	/**
	 * Distinct by keys.
	 *
	 * @param <T>           the generic type
	 * @param keyExtractors the key extractors
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
	@Transactional(rollbackOn = Exception.class)
	public IdDto deleteById(IdDto dto) throws CustomException {
		hdrRepo.softDelete(dto.getId());
		return dto;
	}

	@Override
	public PagebleDTO<LocAccountCloseViewDto> getclosingRequestView(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = new LinkedHashMap<>();
			map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
			map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
			List<SearchParam> searchParams = pageDetail.getJsonArr();
			if (searchParams != null && !searchParams.isEmpty()) {
				searchParams.forEach(
						search -> map.put(LocDBConstants.getLocCloseReqView().get(search.getKey()), search.getValue()));
			} else {
				LocDBConstants.getLocChequeBookReqListing()
						.forEach((k, v) -> map.put(LocDBConstants.getLocCloseReqView().get(k), 0));
			}
			String procName = LocConstant.LOC_SCHEMA
					.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_CLOSING_REQUEST_VIEW_DATA));
			List<LocAccountCloseViewDto> objectSp = this.callStoreProc(procName, map, LocAccountCloseViewDto.class);
			long totalPages = !objectSp.isEmpty() ? (objectSp.get(0).getTotalRec()) : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Update ref no.
	 *
	 * @param submitWfDto the submit wf dto
	 * @throws CustomException the custom exception
	 */
	private void updateRefNo(LocSubmitWfDto submitWfDto) throws CustomException {
		LocAccountCloseReqSdEntity sdEntity = sdRepo
				.findByLcCloseReqHdrIdLcCloseReqHdrIdAndActiveStatus(submitWfDto.getTrnId(), Constant.ACTIVE_STATUS);
		if ((submitWfDto.getTrnStatus().equals(LocConstant.PENDING)|| submitWfDto.getTrnStatus().equals(LocConstant.CANCELLED_STATUS)) && sdEntity.getReferenceNo().isEmpty()) {
			sdEntity.setReferenceNo(getTransactionNumber());
			sdEntity.setReferenceDt(new Date());
		}
		sdRepo.save(sdEntity);
	}

	/**
	 * Gets the transaction number.
	 *
	 * @return the transaction number
	 * @throws CustomException the custom exception
	 */
	private String getTransactionNumber() throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.TRN_SCREEN, LocConstant.TRN_SCREEN_CLR);
		String procName = LocConstant.LOC_SCHEMA.concat(Constant.DOT.concat(LocDBConstants.P_LOC_TRN_NO_GEN));
		List<Object[]> nextSequenceNumber = hdrRepo.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequenceNumber)) {
			return (String) nextSequenceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
	}

	/**
	 * Close account update.
	 *
	 * @param districtId the district id
	 * @param cardexNo   the cardex no
	 * @param ddoNo      the ddo no
	 */
	@Async
	@Transactional
	private void closeAccountUpdate(Long districtId, Long cardexNo, Long ddoNo) {
		this.updateOpenReqHdr(districtId, cardexNo, ddoNo);
		this.updateOpenRequestHdr(districtId, cardexNo, ddoNo);
		this.updateMsOffice(districtId, cardexNo, ddoNo.toString());
	}

	/**
	 * Update open req hdr.
	 *
	 * @param districtId the district id
	 * @param cardexNo   the cardex no
	 * @param ddoNo      the ddo no
	 */
	private void updateOpenReqHdr(Long districtId, Long cardexNo, Long ddoNo) {
		hdrRepo.updateOpenReqHdr(districtId, cardexNo, ddoNo, LocConstant.CLOSE_ID);
	}

	/**
	 * Update open request hdr.
	 *
	 * @param districtId the district id
	 * @param cardexNo   the cardex no
	 * @param ddoNo      the ddo no
	 */
	private void updateOpenRequestHdr(Long districtId, Long cardexNo, Long ddoNo) {
		hdrRepo.updateOpenRequestHdr(districtId, cardexNo, ddoNo, LocConstant.CLOSE_ID);
	}

	/**
	 * Update ms office.
	 *
	 * @param districtId the district id
	 * @param cardexNo   the cardex no
	 * @param ddoNo      the ddo no
	 */
	private void updateMsOffice(Long districtId, Long cardexNo, String ddoNo) {
		hdrRepo.updateMsOffice(districtId, cardexNo, ddoNo);
	}

}
