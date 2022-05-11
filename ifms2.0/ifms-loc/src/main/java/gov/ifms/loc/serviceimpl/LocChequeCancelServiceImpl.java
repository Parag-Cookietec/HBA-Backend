package gov.ifms.loc.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
import gov.ifms.loc.converter.LocChequeCancelDtlSdConverter;
import gov.ifms.loc.converter.LocChequeCancelHdrConverter;
import gov.ifms.loc.dto.LocCheckCancelHdrInfoDto;
import gov.ifms.loc.dto.LocChequeCancelDetailDto;
import gov.ifms.loc.dto.LocChequeCancelDivListingDto;
import gov.ifms.loc.dto.LocChequeCancelDtlSdDto;
import gov.ifms.loc.dto.LocChequeCancelEditViewDtlDto;
import gov.ifms.loc.dto.LocChequeCancelEditViewDto;
import gov.ifms.loc.dto.LocChequeCancelHdrDto;
import gov.ifms.loc.dto.LocChequeCancelListDto;
import gov.ifms.loc.dto.LocChequeCancelListingDto;
import gov.ifms.loc.dto.LocChequeCancelSearchParamDto;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.entity.LocChequeCancelDtlSdEntity;
import gov.ifms.loc.entity.LocChequeCancelHdrEntity;
import gov.ifms.loc.notification.LocNotificationService;
import gov.ifms.loc.repository.LocChequeCancelDtlRepository;
import gov.ifms.loc.repository.LocChequeCancelDtlSdRepository;
import gov.ifms.loc.repository.LocChequeCancelHdrRepository;
import gov.ifms.loc.repository.LocChequeCancelWfRepository;
import gov.ifms.loc.service.LocChequeCancelService;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocDBConstants;
import gov.ifms.loc.util.LocMessageConstant;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;

/**
 * The Class LocChequeCancelHdrController.
 *
 * @version v 1.0
 * @created 2021/03/05 17:12:26
 */
@Service
public class LocChequeCancelServiceImpl implements LocChequeCancelService {

	/**
	 * The Constant logger.
	 */
	private static final Logger logg = LoggerFactory.getLogger(LocChequeCancelServiceImpl.class);

	/**
	 * The LocChequeCancelHdrAsMethodName repository.
	 */
	@Autowired
	private LocChequeCancelHdrRepository repository;

	/**
	 * The hdr converter.
	 */
	@Autowired
	private LocChequeCancelHdrConverter hdrConverter;

	/**
	 * The sd converter.
	 */
	@Autowired
	private LocChequeCancelDtlSdConverter sdConverter;

	/**
	 * The sd repository.
	 */
	@Autowired
	private LocChequeCancelDtlSdRepository sdRepository;

	/**
	 * The wf repo.
	 */
	@Autowired
	private LocChequeCancelWfRepository wfRepo;

	/**
	 * The loc wf action config service.
	 */
	@Autowired
	private LocWfActionConfigService locWfActionConfigService;

	/**
	 * The dtl repository.
	 */
	@Autowired
	private LocChequeCancelDtlRepository dtlRepository;

	/** The notificationService. */
	@Autowired
	private LocNotificationService notificationService;

	/**
	 * The look up info repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Override
	public LocChequeCancelListDto getChequeSearchDetails(LocChequeCancelListDto dto) throws CustomException {
		List<Object[]> chqExist = repository.checkChqCnclInProcess(dto.getChequeNO());
		List<LocChequeCancelListDto> listDto;
		if (chqExist.isEmpty()) {
			List<Object[]> objectSp = repository.searchChequeDetail(dto.getChequeNO(), Constant.ACTIVE_STATUS);
			if (!objectSp.isEmpty()) {
				List<LocChequeCancelDetailDto> listDtoDetail;
				listDto = !objectSp.isEmpty() ? NativeQueryResultsMapper.map(objectSp, LocChequeCancelListDto.class)
						: Collections.emptyList();
				List<Object[]> objectSpDetail = repository.searchChqDetail(listDto.get(0).getHdrId(),
						Constant.ACTIVE_STATUS);
				listDtoDetail = !objectSp.isEmpty()
						? NativeQueryResultsMapper.map(objectSpDetail, LocChequeCancelDetailDto.class)
						: Collections.emptyList();
				listDto.get(0).setChequeDtlList(listDtoDetail);
			} else {
				throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
			}
		} else {
			throw new CustomException(HttpStatus.CONFLICT, LocMessageConstant.LOC_CHQ_CNCL_ALREADY_EXIST);
		}
		return listDto.get(0);
	}

	@Override
	public LocCheckCancelHdrInfoDto getCheckCancelHeaderInfo(IdDto dto) throws CustomException {
		List<Object[]> pramList = repository.getHeaderAdviceList(dto.getId(), Constant.ACTIVE_STATUS);
		List<LocCheckCancelHdrInfoDto> hdrInfoList = !pramList.isEmpty()
				? NativeQueryResultsMapper.map(pramList, LocCheckCancelHdrInfoDto.class)
				: Collections.emptyList();
		return hdrInfoList.get(0);

	}

	@Override
	public LocChequeCancelSearchParamDto getSearchParam() throws CustomException {
		List<Object[]> searchParam = repository.getSearchParam();
		List<LocChequeCancelSearchParamDto> searchParamList = !searchParam.isEmpty()
				? NativeQueryResultsMapper.map(searchParam, LocChequeCancelSearchParamDto.class)
				: Collections.emptyList();
		LocChequeCancelSearchParamDto resultList = new LocChequeCancelSearchParamDto();
		resultList.setWfList(searchParamList.stream().filter(distinctByKeys(LocChequeCancelSearchParamDto::getWfStatus))
				.filter(e -> e.getWfStatus() != null).map(e -> {
					LocChequeCancelSearchParamDto wfStatus = new LocChequeCancelSearchParamDto();
					wfStatus.setWfStatus(e.getWfStatus());
					return wfStatus;
				}).collect(Collectors.toList()));
		resultList.setStatusList(
				searchParamList.stream().filter(distinctByKeys(LocChequeCancelSearchParamDto::getStatusName))
						.filter(e -> e.getStatusId() != null).map(e -> {
							LocChequeCancelSearchParamDto status = new LocChequeCancelSearchParamDto();
							status.setStatusId(e.getStatusId());
							status.setStatusName(e.getStatusName());
							return status;
						}).collect(Collectors.toList()));
		resultList
				.setDivNameList(
						searchParamList.stream()
								.filter(distinctByKeys(LocChequeCancelSearchParamDto::getDivId,
										LocChequeCancelSearchParamDto::getDivName))
								.filter(e -> e.getDivId() != null).map(e -> {
									LocChequeCancelSearchParamDto divName = new LocChequeCancelSearchParamDto();
									divName.setDivId(e.getDivId());
									divName.setDivName(e.getDivName());
									return divName;
								}).collect(Collectors.toList()));

		resultList
				.setDivNameList(
						searchParamList.stream()
								.filter(distinctByKeys(LocChequeCancelSearchParamDto::getDivId,
										LocChequeCancelSearchParamDto::getDivName))
								.filter(e -> e.getDivId() != null).map(e -> {
									LocChequeCancelSearchParamDto divName = new LocChequeCancelSearchParamDto();
									divName.setDivId(e.getDivId());
									divName.setDivName(e.getDivName());
									return divName;
								}).collect(Collectors.toList()));

		resultList
				.setDivCodeList(
						searchParamList.stream()
								.filter(distinctByKeys(LocChequeCancelSearchParamDto::getDivId,
										LocChequeCancelSearchParamDto::getDivCode))
								.filter(e -> e.getDivId() != null).map(e -> {
									LocChequeCancelSearchParamDto divCode = new LocChequeCancelSearchParamDto();
									divCode.setDivId(e.getDivId());
									divCode.setDivCode(e.getDivCode());
									return divCode;
								}).collect(Collectors.toList()));

		return resultList;
	}

	@Transactional
	@Override
	public LocChequeCancelHdrDto saveAsDraft(LocChequeCancelHdrDto dto) throws CustomException {
		LocChequeCancelHdrEntity hdrEntity = hdrConverter.toEntity(dto);

		hdrEntity = repository.save(hdrEntity);
		List<LocChequeCancelDtlSdEntity> sdEntityList = new ArrayList<>();
		for (LocChequeCancelDtlSdDto sdDto : dto.getChequeCancelSdDto()) {
			sdDto.setHdrId(hdrEntity.getHdrId());
			sdEntityList.add(sdConverter.toEntity(sdDto));
			validateChequeCancelAmount(hdrEntity.getChequeAmt(),sdDto.getHeadCancelChqAmt());
		}
		sdRepository.saveAll(sdEntityList);

		if (wfRepo.findByTrnIdHdrIdAndActiveStatus(hdrEntity.getHdrId(), Constant.ACTIVE_STATUS) == null) {
			WfUserReqSDDto wfDto = dto.getWfUserReqDto();
			wfDto.setTrnId(hdrEntity.getHdrId());
			callWorkflow(wfDto);
		}
		dto.setHdrId(hdrEntity.getHdrId());
		dto.setRefNo(hdrEntity.getRefNo());
		return dto;
	}

	private void validateChequeCancelAmount(Double chequeAmt, Double headCancelChqAmt) throws CustomException {
		if(!chequeAmt.equals(headCancelChqAmt)) {
			throw new CustomException(HttpStatus.CONFLICT, LocMessageConstant.LOC_CHQ_CANCL_AMNT);
		}
		
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
	public LocChequeCancelEditViewDto getEditViewData(LocChqBookEditViewDto dto) throws CustomException {

		List<Object[]> objectHdrDetail = repository.getChqCnclHdrData(dto.getHdrId(), Constant.ACTIVE_STATUS);
		List<LocChequeCancelEditViewDto> listHdrDetail = !objectHdrDetail.isEmpty()
				? NativeQueryResultsMapper.map(objectHdrDetail, LocChequeCancelEditViewDto.class)
				: Collections.emptyList();

		if (LocConstant.VIEW_ACTION.equals(dto.getActionStatus())) {
			List<Object[]> objectDtlDetail = dtlRepository.getChqCnclDtlData(dto.getHdrId(), Constant.ACTIVE_STATUS);
			List<LocChequeCancelEditViewDtlDto> listDtlDetail = !objectHdrDetail.isEmpty()
					? NativeQueryResultsMapper.map(objectDtlDetail, LocChequeCancelEditViewDtlDto.class)
					: Collections.emptyList();
			listHdrDetail.get(0).setChequeDtlList(listDtlDetail);
		} else if (LocConstant.EDIT_ACTION.equals(dto.getActionStatus())) {
			List<Object[]> objectSdDetail = sdRepository.getChqCnclSdData(dto.getHdrId(), Constant.ACTIVE_STATUS);
			List<LocChequeCancelEditViewDtlDto> listSdDetail = !objectHdrDetail.isEmpty()
					? NativeQueryResultsMapper.map(objectSdDetail, LocChequeCancelEditViewDtlDto.class)
					: Collections.emptyList();
			listHdrDetail.get(0).setChequeDtlList(listSdDetail);
		}
		return listHdrDetail.get(0);
	}

	@Override
	public void submitData(LocSubmitWfDto submitWfDto) throws CustomException {
		Optional<LocChequeCancelHdrEntity> hdrEntity = repository.findByActiveStatusAndHdrId(Constant.ACTIVE_STATUS,
				submitWfDto.getTrnId());
		if (hdrEntity.isPresent()) {
			submitData(submitWfDto, LocDBConstants.SP_LOC_CHQ_CANCEL_SUBMIT);
		}
	}

	/**
	 * Submit data.
	 *
	 * @param submitWfDto the submit wf dto
	 * @param procName    the proc name
	 * @throws CustomException
	 */
	private void submitData(LocSubmitWfDto submitWfDto, String procName) throws CustomException {
		LocChequeCancelHdrEntity hdrEntity = repository.getOne(submitWfDto.getTrnId());
		logg.info("###### "+hdrEntity.getHdrId());
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(LocDBConstants.IN_CHEQUE_CANCELLATION_ID, submitWfDto.getTrnId());
		setSubmitDataStatus(submitWfDto.getTrnStatus(), argsMap);
		argsMap.put(LocDBConstants.IN_WF_ROLE_ID, submitWfDto.getWfId());
		argsMap.put(LocDBConstants.IN_WORKFLOW_ID, submitWfDto.getAssignByWfRoleId());
		argsMap.put(Constant.IN_UPDATED_BY, OAuthUtility.getCurrentUserUserId());
		argsMap.put(Constant.IN_UPDATED_BY_POST, OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());
		String spName = LocDBConstants.LOC_SCHEMA.concat(LocConstant.DOT).concat(procName);
		this.repository.callStoredProcedureWithNoResult(spName, argsMap);
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
	@ExceptionHandler
	@Transactional(rollbackFor = CustomException.class)
	public IdDto deleteById(IdDto dto) throws CustomException {
		LocChequeCancelHdrEntity hdrEntity = repository.findByHdrIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
		hdrEntity.setActiveStatus(0);
		repository.save(hdrEntity);
		return dto;
	}

	/**
	 * Gets the transaction number.
	 *
	 * @param eventName the event name
	 * @return the transaction number
	 * @throws CustomException the custom exception
	 */
	@SuppressWarnings("unused")
	private String getTransactionNumber(String eventName) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.TRN_SCREEN, eventName);
		String procName = LocConstant.LOC_SCHEMA.concat(Constant.DOT.concat(LocConstant.P_LOC_TRN_NO_GEN));
		List<Object[]> nextSequanceNumber = repository.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequanceNumber)) {
			return (String) nextSequanceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
	}

	@Override
	public PagebleDTO<LocChequeCancelListingDto> getChequeCancelListing(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(LocDBConstants.getLocChequeCancelListing().get(search.getKey()),
					search.getValue()));
		} else {
			LocDBConstants.getLocChequeCancelListing()
					.forEach((k, v) -> map.put(LocDBConstants.getLocChequeCancelListing().get(k), 0));
		}
		String procName = LocConstant.LOC_SCHEMA
				.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_CHQ_CANCEL_TO_LISTING));
		List<LocChequeCancelListingDto> objectSp = this.callStoreProc(procName, map, LocChequeCancelListingDto.class);
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
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
		List<Object[]> objectSp = repository.callStoredProcedure(procName, map);
		return !objectSp.isEmpty() ? NativeQueryResultsMapper.map(objectSp, view) : Collections.emptyList();
	}

	@Override
	public PagebleDTO<LocChequeCancelDivListingDto> getChequeCancelDivListing(PageDetails pageDetail)
			throws CustomException {

		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(LocDBConstants.getChequeCancelDivListing().get(search.getKey()),
					search.getValue()));
		} else {
			LocDBConstants.getChequeCancelDivListing()
					.forEach((k, v) -> map.put(LocDBConstants.getChequeCancelDivListing().get(k), 0));
		}
		String procName = LocConstant.LOC_SCHEMA
				.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_CHQ_CANCEL_DIV_LISTING));
		List<LocChequeCancelDivListingDto> objectSp = this.callStoreProc(procName, map,
				LocChequeCancelDivListingDto.class);
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);

	}

}
