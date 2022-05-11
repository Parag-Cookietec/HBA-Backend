package gov.ifms.loc.serviceimpl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.loc.converter.LocChequeBookHdrConverter;
import gov.ifms.loc.converter.LocChequeBookSdConverter;
import gov.ifms.loc.dto.LocAdviceRegChqDtlDto;
import gov.ifms.loc.dto.LocChequeBookHdrDto;
import gov.ifms.loc.dto.LocChequeBookHdrInfoDto;
import gov.ifms.loc.dto.LocChequeBookSdDto;
import gov.ifms.loc.dto.LocChequebookeditVeiwDto;
import gov.ifms.loc.dto.LocChqBookActInActDto;
import gov.ifms.loc.dto.LocChqBookData;
import gov.ifms.loc.dto.LocChqBookEditViewDto;
import gov.ifms.loc.dto.LocChqBookList;
import gov.ifms.loc.dto.LocChqBookListingDto;
import gov.ifms.loc.dto.LocChqBookSrchPrmDto;
import gov.ifms.loc.dto.LocChqDtlDto;
import gov.ifms.loc.dto.LocIdNameDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.entity.LocChequeBookDtlEntity;
import gov.ifms.loc.entity.LocChequeBookHdrEntity;
import gov.ifms.loc.entity.LocChequeBookSdEntity;
import gov.ifms.loc.notification.LocNotificationService;
import gov.ifms.loc.repository.LocChequeBookDtlRepository;
import gov.ifms.loc.repository.LocChequeBookHdrRepository;
import gov.ifms.loc.repository.LocChequeBookSdRepository;
import gov.ifms.loc.repository.LocChequeBookWfRepository;
import gov.ifms.loc.service.LocChequeBookService;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocDBConstants;
import gov.ifms.loc.util.LocMessageConstant;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;

/**
 * The Class LocChqDtlServiceImpl.
 */
@Service
public class LocChequeBookServiceImpl implements LocChequeBookService {

	/**
	 * The hdr repo.
	 */
	@Autowired
	private LocChequeBookHdrRepository hdrRepo;

	/**
	 * The sd repo.
	 */
	@Autowired
	private LocChequeBookSdRepository sdRepo;

	/**
	 * The dtl repo.
	 */
	@Autowired
	private LocChequeBookDtlRepository dtlRepo;

	/**
	 * The hdr converter.
	 */
	@Autowired
	private LocChequeBookHdrConverter hdrConverter;

	/**
	 * The look up info repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;
	/**
	 * The sd converter.
	 */
	@Autowired
	private LocChequeBookSdConverter sdConverter;

	/** The wf repo. */
	@Autowired
	private LocChequeBookWfRepository wfRepo;

	/**
	 * The look up repo.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepo;

	/**
	 * The loc wf action config service.
	 */
	@Autowired
	private LocWfActionConfigService locWfActionConfigService;

	/** The notificationService. */
	@Autowired
	private LocNotificationService notificationService;

	@Override
	@ExceptionHandler
	@Transactional(rollbackFor = CustomException.class)
	public LocChequeBookHdrDto saveDraft(LocChequeBookHdrDto dto) throws CustomException {

		int flag = 0;

		LocChequeBookHdrEntity hdrEntity = hdrRepo.save(hdrConverter.toEntity(dto));
		dto.setId(hdrEntity.getId());

		List<LocChequeBookSdEntity> sdData = sdRepo.findByHdrIdId(dto.getId());
		sdData.stream().forEach(s -> s.setActiveStatus(0));
		for (LocChequeBookSdDto dtoData : dto.getChequeBookSdDto()) {
			if (dtoData.getIsActive().equals(LocConstant.CHQ_IS_INACTIVE)
					&& this.usedChequeTest(dtoData.getStartSeries())) {
				throw new CustomException(HttpStatus.CONFLICT, MessageFormat
						.format(LocMessageConstant.LOC_CHEQUEBOOK_UNDER_TRANSACTION, dtoData.getStartSeries()));

			}
			flag = 0;
			for (LocChequeBookSdEntity mapData : sdData) {

				if ((null != dtoData.getId() && dtoData.getId().equals(mapData.getId()))
						|| (dtoData.getStartSeries().equals(mapData.getStartSeries()))) {
					mapData.setActiveStatus(1);
					flag++;
				}
			}
			if (flag == 0) {
				LocChequeBookSdEntity entity = sdConverter.toEntity(dtoData);
				entity.setHdrId(hdrEntity);
				sdData.add(entity);
			}
		}
		sdData = sdRepo.saveAll(sdData);

		if (wfRepo.findByTrnIdAndActiveStatus(hdrEntity.getId(), Constant.ACTIVE_STATUS) == null) {
			WfUserReqSDDto wfDto = dto.getWfUserReqDto().get(0);
			wfDto.setTrnId(hdrEntity.getId());
			callWorkflow(wfDto);
		}
		LocChqBookEditViewDto editViewDto = new LocChqBookEditViewDto();
		editViewDto.setActionStatus(LocConstant.EDIT_ACTION);
		editViewDto.setHdrId(hdrEntity.getId());
		dto = this.getEditView(editViewDto);
		dto.setChequeBookSdDto(
				sdConverter.toDTO(sdData.stream().filter(e -> e.getActiveStatus() == 1).collect(Collectors.toList())));

		return dto;

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
	public LocChqBookSrchPrmDto getSearchParam() throws CustomException {
		List<Object[]> paramList = hdrRepo.getSearchParam();
		List<LocChqBookSrchPrmDto> resultList = !paramList.isEmpty()
				? NativeQueryResultsMapper.map(paramList, LocChqBookSrchPrmDto.class)
				: Collections.emptyList();
		LocChqBookSrchPrmDto srchPram = new LocChqBookSrchPrmDto();

		srchPram.setChequeTypeList(resultList.stream()
				.filter(distinctByKeys(LocChqBookSrchPrmDto::getChequeTypeId, LocChqBookSrchPrmDto::getChequeTypeName))
				.filter(e -> e.getChequeTypeId() != null).map(e -> {
					LocChqBookSrchPrmDto chqType = new LocChqBookSrchPrmDto();
					chqType.setChequeTypeId(e.getChequeTypeId());
					chqType.setChequeTypeName(e.getChequeTypeName());
					return chqType;
				}).collect(Collectors.toList()));

		srchPram.setReqTypeList(resultList.stream()
				.filter(distinctByKeys(LocChqBookSrchPrmDto::getReqTypeId, LocChqBookSrchPrmDto::getReqTypeName))
				.filter(e -> e.getChequeTypeId() != null).map(e -> {
					LocChqBookSrchPrmDto reqType = new LocChqBookSrchPrmDto();
					reqType.setReqTypeId(e.getReqTypeId());
					reqType.setReqTypeName(e.getReqTypeName());
					return reqType;
				}).collect(Collectors.toList()));

		srchPram.setStatusList(resultList.stream().filter(distinctByKeys(LocChqBookSrchPrmDto::getStatusName))
				.filter(e -> e.getChequeTypeId() != null).map(e -> {
					LocChqBookSrchPrmDto statusType = new LocChqBookSrchPrmDto();
					statusType.setStatusId(e.getStatusId());
					statusType.setStatusName(e.getStatusName());
					return statusType;
				}).collect(Collectors.toList()));

		srchPram.setWfList(resultList.stream().filter(distinctByKeys(LocChqBookSrchPrmDto::getWfName))
				.filter(e -> e.getChequeTypeId() != null).map(e -> {
					LocChqBookSrchPrmDto wfType = new LocChqBookSrchPrmDto();
					wfType.setWfId(e.getWfId());
					wfType.setWfName(e.getWfName());
					return wfType;
				}).collect(Collectors.toList()));

		srchPram.setDivCodeList(resultList.stream().filter(distinctByKeys(LocChqBookSrchPrmDto::getDivCode))
				.filter(e -> e.getDivCode() != null).map(e -> {
					LocChqBookSrchPrmDto divCode = new LocChqBookSrchPrmDto();
					divCode.setDivId(e.getDivId());
					divCode.setDivCode(e.getDivCode());
					return divCode;
				}).collect(Collectors.toList()));

		srchPram.setDivNameList(resultList.stream().filter(distinctByKeys(LocChqBookSrchPrmDto::getDivName))
				.filter(e -> e.getDivName() != null).map(e -> {
					LocChqBookSrchPrmDto divName = new LocChqBookSrchPrmDto();
					divName.setDivId(e.getDivId());
					divName.setDivName(e.getDivName());
					return divName;
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
	public void submitData(LocSubmitWfDto submitWfDto) throws CustomException {
		Optional<LocChequeBookHdrEntity> hdrEntity = hdrRepo.findByIdAndActiveStatus(submitWfDto.getTrnId(),
				Constant.ACTIVE_STATUS);
		if (hdrEntity.isPresent()) {

			submitData(submitWfDto, LocDBConstants.SP_LOC_CHEQUEBOOK_SUBMIT);
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
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(LocDBConstants.IN_LC_CHEQUEBOOK_ID, submitWfDto.getTrnId());
		setSubmitDataStatus(submitWfDto.getTrnStatus(), argsMap);
		argsMap.put(LocDBConstants.IN_WF_ROLE_ID, submitWfDto.getWfId());
		argsMap.put(LocDBConstants.IN_WORKFLOW_ID, submitWfDto.getAssignByWfRoleId());
		argsMap.put(Constant.IN_UPDATED_BY, OAuthUtility.getCurrentUserUserId());
		argsMap.put(Constant.IN_UPDATED_BY_POST, OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());
		String spName = LocDBConstants.LOC_SCHEMA.concat(LocConstant.DOT).concat(procName);
		this.hdrRepo.callStoredProcedureWithNoResult(spName, argsMap);
		if (submitWfDto.getTrnStatus().equals(LocConstant.AUTHORIZED)) {
			this.updatedIsActive(submitWfDto);
			this.flagChange(submitWfDto);
		}
		if (submitWfDto.getTrnStatus().equals(LocConstant.AUTHORIZED)
				|| submitWfDto.getWfActionId().equals(LocConstant.APPROVED_ACTION)) {
			notificationService.sendNotification(submitWfDto);

		}
	}

	@Override
	public LocChqBookData getChequeBookData(LocChqDtlDto dto) throws CustomException {
		LocChqBookData chqBookData = new LocChqBookData();
		List<Object[]> paramList = hdrRepo.getChequeBookData(dto.getDeptId(), dto.getCardexNo(), dto.getDdoNo(),
				dto.getOfficeNameId(), Constant.ACTIVE_STATUS);
		List<LocChqBookData> resultList = !paramList.isEmpty()
				? NativeQueryResultsMapper.map(paramList, LocChqBookData.class)
				: Collections.emptyList();
		if (!resultList.isEmpty()) {
			chqBookData = resultList.get(0);
		}
		chqBookData.setChequeTypeList(this.getLookupIdName(LocConstant.CHEQUE_TYPE_ID));
		chqBookData.setReqTypeList(this.getLookupIdName(LocConstant.REQUEST_TYPE_ID));

		return chqBookData;
	}

	/**
	 * Gets the lookup id name.
	 *
	 * @param parentLookupId the parent lookup id
	 * @return the lookup id name
	 * @throws CustomException the custom exception
	 */
	private List<LocIdNameDto> getLookupIdName(Long parentLookupId) throws CustomException {
		List<Object[]> paramList = hdrRepo.getLookupIdandName(parentLookupId, Constant.ACTIVE_STATUS);
		return !paramList.isEmpty() ? NativeQueryResultsMapper.map(paramList, LocIdNameDto.class)
				: Collections.emptyList();
	}

	@Override
	public LocChqBookList getChequeBookList(LocChqDtlDto dto) throws CustomException {
		LocChqBookList srchPram = new LocChqBookList();
		Map<String, Object> argsMap = new HashMap<>();
		if (dto.getReqTypeId().equals(LocConstant.REQUEST_TYPE_ACTIVATE)) {
			argsMap.put(LocConstant.CHQ_TYPE_LABLE, dto.getChequeTypeId());
			argsMap.put(LocConstant.BANK_ACC_LABLE, dto.getBankAccNo());
			argsMap.put(LocConstant.DIV_ID_LABLE, dto.getDivId());
			String spName = LocDBConstants.LOC_SCHEMA.concat(LocConstant.DOT)
					.concat(LocConstant.SP_LOC_CHQINV_ISSUED_CHQ_SERIES);
			List<LocChqBookList> chqInvResultList = this.callStoreProc(spName, argsMap, LocChqBookList.class);

			List<LocChqBookActInActDto> chqInvFltrList = chqInvResultList.stream().map(e -> {
				LocChqBookActInActDto activeList = new LocChqBookActInActDto();
				activeList.setIssueDate(e.getIssueDate());
				activeList.setStartSeries(e.getDivCode() + "-" + e.getStartSeries());
				activeList.setEndSeries(e.getDivCode() + "-" + e.getEndSeries());
				return activeList;
			}).collect(Collectors.toList());

			List<Object[]> sdList = hdrRepo.getChqBookActInactSdList(Constant.ACTIVE_STATUS, LocConstant.CHQ_IS_ACTIVE,
					LocConstant.CHQ_IS_INACTIVE, Constant.CANCELLED_LOOKUP_NAME, Constant.REJECTED);
			List<LocChqBookActInActDto> sdChqList = !sdList.isEmpty()
					? NativeQueryResultsMapper.map(sdList, LocChqBookActInActDto.class)
					: Collections.emptyList();
			Set<String> startSeries = sdChqList.stream().map(LocChqBookActInActDto::getStartSeries)
					.collect(Collectors.toSet());

			srchPram.setChqInvInActiveList(chqInvFltrList.stream()
					.filter(e -> !startSeries.contains(e.getStartSeries())).collect(Collectors.toList()));

			List<Object[]> inactiveList = hdrRepo.getChqBookActInactList(dto.getBankAccNo(), dto.getDivId(),
					dto.getChequeTypeId(), dto.getBankId(), Constant.ACTIVE_STATUS, LocConstant.CHQ_IS_ACTIVE,
					LocConstant.AUTHORIZED);
			List<LocChqBookActInActDto> locInActiveChqList = !inactiveList.isEmpty()
					? NativeQueryResultsMapper.map(inactiveList, LocChqBookActInActDto.class)
					: Collections.emptyList();
			List<LocChqBookActInActDto> inactList = locInActiveChqList.stream().map(e -> {
				LocChqBookActInActDto inActiveList = new LocChqBookActInActDto();
				inActiveList.setStartSeries(e.getStartSeries());
				inActiveList.setEndSeries(e.getEndSeries());
				inActiveList.setIssueDate(e.getIssueDate());
				inActiveList.setInActiveDate(e.getInActiveDate());
				inActiveList.setActiveDate(e.getActiveDate());
				return inActiveList;
			}).collect(Collectors.toList());

			sdList = hdrRepo.getChqBookInactSdList(Constant.ACTIVE_STATUS, LocConstant.CHQ_IS_ACTIVE,
					Constant.CANCELLED_LOOKUP_NAME, Constant.REJECTED, LocConstant.AUTHORIZED);
			sdChqList = !sdList.isEmpty() ? NativeQueryResultsMapper.map(sdList, LocChqBookActInActDto.class)
					: Collections.emptyList();
			Set<String> startSeriesInactive = sdChqList.stream().map(LocChqBookActInActDto::getStartSeries)
					.collect(Collectors.toSet());

			srchPram.setLocInActiveList(inactList.stream()
					.filter(e -> !startSeriesInactive.contains(e.getStartSeries())).collect(Collectors.toList()));

		} else if (dto.getReqTypeId().equals(LocConstant.REQUEST_TYPE_INACTIVATE)) {
			List<Object[]> activeList = hdrRepo.getChqBookActInactList(dto.getBankAccNo(), dto.getDivId(),
					dto.getChequeTypeId(), dto.getBankId(), Constant.ACTIVE_STATUS, LocConstant.CHQ_IS_INACTIVE,
					LocConstant.AUTHORIZED);

			List<LocChqBookActInActDto> locActiveChqList = !activeList.isEmpty()
					? NativeQueryResultsMapper.map(activeList, LocChqBookActInActDto.class)
					: Collections.emptyList();
			locActiveChqList = this.getchequeDataAdvice(locActiveChqList, dto.getDivId());
			List<Object[]> sdList = hdrRepo.getSdInactiveList(Constant.ACTIVE_STATUS, LocConstant.AUTHORIZED,
					LocConstant.CHQ_IS_INACTIVE, Constant.CANCELLED_LOOKUP_NAME, Constant.REJECTED);
			List<Object[]> sdActiveList = hdrRepo.getSdactiveList(Constant.ACTIVE_STATUS, LocConstant.CHQ_IS_ACTIVE,
					Constant.CANCELLED_LOOKUP_NAME, Constant.REJECTED);
			List<LocChqBookActInActDto> sdChqList = !sdList.isEmpty()
					? NativeQueryResultsMapper.map(sdList, LocChqBookActInActDto.class)
					: Collections.emptyList();
			List<LocChqBookActInActDto> sdActiveChqList = !sdActiveList.isEmpty()
					? NativeQueryResultsMapper.map(sdActiveList, LocChqBookActInActDto.class)
					: Collections.emptyList();
			Set<String> startSeries = sdChqList.stream().map(LocChqBookActInActDto::getStartSeries)
					.collect(Collectors.toSet());
			Set<String> startSeries1 = sdActiveChqList.stream().map(LocChqBookActInActDto::getStartSeries)
					.collect(Collectors.toSet());

			List<LocChqBookActInActDto> actList = locActiveChqList.stream().map(e -> {
				LocChqBookActInActDto inActiveList = new LocChqBookActInActDto();
				inActiveList.setStartSeries(e.getStartSeries());
				inActiveList.setEndSeries(e.getEndSeries());
				inActiveList.setActiveDate(e.getActiveDate());
				inActiveList.setIssueDate(e.getIssueDate());
				return inActiveList;
			}).collect(Collectors.toList());
			srchPram.setLocActiveList(actList.stream().filter(e -> !startSeries.contains(e.getStartSeries()))
					.filter(e -> !startSeries1.contains(e.getStartSeries())).collect(Collectors.toList()));

		}

		return srchPram;
	}

	@Override
	public LocChequeBookHdrDto getEditView(LocChqBookEditViewDto dto) throws CustomException {

		LocChequeBookHdrEntity hdrEntity = hdrRepo.findByActiveStatusAndId(Constant.ACTIVE_STATUS, dto.getHdrId());
		LocChequeBookHdrDto resultDto = hdrConverter.toDTO(hdrEntity);

		resultDto.setDivCode(hdrEntity.getDivId().getDivCode());
		resultDto.setDivName(hdrEntity.getDivId().getDivisionName());
		resultDto.setBankName(hdrEntity.getBankBranchId().getBankName());
		resultDto.setReqTypeName(getName(resultDto.getReqTypeId()));
		resultDto.setChequeTypeName(getName(resultDto.getChequeTypeId()));
		LocChequeBookSdDto resultSdDto = new LocChequeBookSdDto();
		List<LocChequeBookSdDto> sdDtoList = new ArrayList<>();
		if (LocConstant.VIEW_ACTION.equals(dto.getActionStatus())) {
			List<Object[]> dtlList = hdrRepo.getDtlData(dto.getHdrId(), Constant.ACTIVE_STATUS);

			List<LocChequebookeditVeiwDto> dtlResultList = !dtlList.isEmpty()
					? NativeQueryResultsMapper.map(dtlList, LocChequebookeditVeiwDto.class)
					: Collections.emptyList();
			sdDtoList = dtlResultList.stream().map(e -> {
				LocChequeBookSdDto dtlDto = new LocChequeBookSdDto();
				dtlDto.setEndSeries(e.getEndSeries());
				dtlDto.setHdrId(e.getHdrId());
				dtlDto.setId(e.getId());
				dtlDto.setIsActive(e.getIsActive());
				dtlDto.setStartSeries(e.getStartSeries());
				dtlDto.setCreatedBy(e.getCreatedBy());
				dtlDto.setCreatedByPost(e.getCreatedByPost());
				dtlDto.setCreatedDate(e.getCreatedDate());
				dtlDto.setActiveDate(e.getActiveDate());
				dtlDto.setIssueDate(e.getIssueDate());
				dtlDto.setStatusId(e.getStatusId());
				dtlDto.setInActiveDate(e.getInActiveDate());
				return dtlDto;
			}).collect(Collectors.toList());
			resultSdDto.setChqInvInActiveList(sdDtoList.stream()
					.filter(e -> (e.getIsActive().equals(LocConstant.CHQ_IS_ACTIVE) && null == e.getActiveDate()
							&& !e.getStatusId().equals(LocConstant.LOC_AUTHORIZED_ID))
							|| (e.getIsActive().equals(LocConstant.CHQ_IS_INACTIVE) && null == e.getActiveDate()
									&& e.getStatusId().equals(LocConstant.LOC_AUTHORIZED_ID)))
					.collect(Collectors.toList()));
			resultSdDto.setLocInActiveList(sdDtoList.stream()
					.filter(e -> (e.getIsActive().equals(LocConstant.CHQ_IS_ACTIVE) && null != e.getActiveDate()
							&& !e.getStatusId().equals(LocConstant.LOC_AUTHORIZED_ID))
							|| (e.getIsActive().equals(LocConstant.CHQ_IS_INACTIVE) && null != e.getActiveDate()
									&& e.getStatusId().equals(LocConstant.LOC_AUTHORIZED_ID)))
					.collect(Collectors.toList()));
			resultSdDto.setLocActiveList(sdDtoList.stream()
					.filter(e -> (e.getIsActive().equals(LocConstant.CHQ_IS_INACTIVE)
							&& !e.getStatusId().equals(LocConstant.LOC_AUTHORIZED_ID))
							|| (e.getIsActive().equals(LocConstant.CHQ_IS_ACTIVE)
									&& e.getStatusId().equals(LocConstant.LOC_AUTHORIZED_ID)))
					.collect(Collectors.toList()));
		} else if (LocConstant.EDIT_ACTION.equals(dto.getActionStatus())) {

			sdDtoList = sdConverter.toDTO(sdRepo.findByHdrIdIdAndActiveStatus(dto.getHdrId(), Constant.ACTIVE_STATUS));

			resultSdDto.setChqInvInActiveList(sdDtoList.stream()
					.filter(e -> e.getIsActive().equals(LocConstant.CHQ_IS_ACTIVE) && null == e.getActiveDate())
					.collect(Collectors.toList()));
			resultSdDto.setLocInActiveList(sdDtoList.stream()
					.filter(e -> e.getIsActive().equals(LocConstant.CHQ_IS_ACTIVE) && null != e.getActiveDate())
					.collect(Collectors.toList()));
			resultSdDto.setLocActiveList(sdDtoList.stream()
					.filter(e -> e.getIsActive().equals(LocConstant.CHQ_IS_INACTIVE)).collect(Collectors.toList()));

		}
		resultDto.setChequeViewEditSdDto(resultSdDto);
		return resultDto;

	}

	/**
	 * Gets the name.
	 *
	 * @param id the id
	 * @return the name
	 */
	private String getName(Long id) {
		EDPLuLookUpInfoEntity lookUpInfoEntity = lookUpInfoRepo.findBylookUpInfoId(id);
		return lookUpInfoEntity.getLookUpInfoName();
	}

	@Override
	public PagebleDTO<LocChqBookListingDto> getListingData(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(LocDBConstants.getLocChequeBookReqListing().get(search.getKey()),
					search.getValue()));
		} else {
			LocDBConstants.getLocChequeBookReqListing()
					.forEach((k, v) -> map.put(LocDBConstants.getLocChequeBookReqListing().get(k), 0));
		}
		String procName = LocConstant.LOC_SCHEMA.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_CHEQUEBOOK_LISTING));
		List<LocChqBookListingDto> objectSp = this.callStoreProc(procName, map, LocChqBookListingDto.class);
		Long totalPages = !objectSp.isEmpty() ? (objectSp.get(0).getTotalRecords()) : objectSp.size();
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
	public LocChequeBookHdrInfoDto getHeaderInfo(IdDto dto) throws CustomException {

		List<Object[]> paramList = hdrRepo.getHeaderInfo(dto.getId(), Constant.ACTIVE_STATUS);
		List<LocChequeBookHdrInfoDto> hdrInfolist = !paramList.isEmpty()
				? NativeQueryResultsMapper.map(paramList, LocChequeBookHdrInfoDto.class)
				: Collections.emptyList();
		return hdrInfolist.get(0);
	}

	@Override
	@ExceptionHandler
	@Transactional(rollbackFor = CustomException.class)
	public IdDto deleteById(IdDto dto) throws CustomException {
		LocChequeBookHdrEntity hdrEntity = hdrRepo.findByActiveStatusAndId(Constant.ACTIVE_STATUS, dto.getId());
		hdrEntity.setActiveStatus(0);
		hdrRepo.save(hdrEntity);
		List<LocChequeBookSdEntity> sdData = sdRepo.findByHdrIdId(dto.getId());
		sdData.stream().forEach(s -> s.setActiveStatus(0));
		return dto;
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

	/**
	 * Updated is active.
	 *
	 * @param dto the dto
	 */
	private void updatedIsActive(LocSubmitWfDto dto) {
		List<LocChequeBookDtlEntity> dtlEntityList = dtlRepo.findByHdrIdIdAndActiveStatus(dto.getTrnId(),
				Constant.ACTIVE_STATUS);
		List<LocChequeBookSdEntity> sdEntityList = sdRepo.findByHdrIdIdAndActiveStatus(dto.getTrnId(),
				Constant.ACTIVE_STATUS);
		for (LocChequeBookDtlEntity entity : dtlEntityList) {
			if (entity.getIsActive().equals(LocConstant.CHQ_IS_ACTIVE)) {
				entity.setActiveDate(new Date());
				entity.setIsActive(LocConstant.CHQ_IS_INACTIVE);
			} else if (entity.getIsActive().equals(LocConstant.CHQ_IS_INACTIVE)) {
				entity.setInactiveDate(new Date());
				entity.setIsActive(LocConstant.CHQ_IS_ACTIVE);
			}
		}
		dtlRepo.saveAll(dtlEntityList);
		for (LocChequeBookSdEntity sdEntity : sdEntityList) {
			if (sdEntity.getIsActive().equals(LocConstant.CHQ_IS_ACTIVE)) {
				sdEntity.setActiveDate(new Date());
				sdEntity.setIsActive(LocConstant.CHQ_IS_INACTIVE);
			} else if (sdEntity.getIsActive().equals(LocConstant.CHQ_IS_INACTIVE)) {
				sdEntity.setInActiveDate(new Date());
				sdEntity.setIsActive(LocConstant.CHQ_IS_ACTIVE);
			}
			sdRepo.saveAll(sdEntityList);
		}

	}

	/**
	 * Flag change.
	 *
	 * @param dto the dto
	 */
	private void flagChange(LocSubmitWfDto dto) {
		List<Long> dtlIdList = hdrRepo.getOldHdrId(dto.getTrnId(), Constant.ACTIVE_STATUS, LocConstant.AUTHORIZED);
		List<LocChequeBookDtlEntity> dtlEntityList = new ArrayList<>();
		for (Long i : dtlIdList) {
			LocChequeBookDtlEntity entity = dtlRepo.findByIdAndActiveStatus(i, Constant.ACTIVE_STATUS);
			if (entity.getFlag().equals(LocConstant.LONG_ONE)) {
				entity.setFlag(LocConstant.LONG_ZERO);
			} else if (entity.getFlag().equals(LocConstant.LONG_ZERO)) {
				entity.setFlag(LocConstant.LONG_ONE);
			}
			dtlEntityList.add(entity);
		}
		dtlRepo.saveAll(dtlEntityList);
	}

	/**
	 * Used cheque test.
	 *
	 * @param chqNo the chq no
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	private Boolean usedChequeTest(String chqNo) throws CustomException {
		return hdrRepo.uesdChequeAdvicePrepTest(chqNo).isEmpty()
				? (hdrRepo.uesdChequeChqToChqTest(chqNo).isEmpty() ? false : true)
				: true;
	}

	/**
	 * Gets the cheque data advice.
	 *
	 * @param locActiveChqList the loc active chq list
	 * @param divId            the div id
	 * @return the cheque data advice
	 * @throws CustomException the custom exception
	 */
	private List<LocChqBookActInActDto> getchequeDataAdvice(List<LocChqBookActInActDto> locActiveChqList, Long divId)
			throws CustomException {

		List<Object[]> locChqList = hdrRepo.getLocAdviceChqList(divId, Constant.ACTIVE_STATUS);
		List<LocAdviceRegChqDtlDto> locChequeData = !locChqList.isEmpty()
				? NativeQueryResultsMapper.map(locChqList, LocAdviceRegChqDtlDto.class)
				: Collections.emptyList();
		TreeSet<String> chqList = locChequeData.stream().filter(e -> null != e.getChqSerStart())
				.map(s -> s.getChqSerStart()).collect(Collectors.toCollection(TreeSet::new));
		TreeSet<String> chqList2 = locChequeData.stream().filter(e -> null != e.getChqTochqData())
				.map(s -> s.getChqTochqData()).collect(Collectors.toCollection(TreeSet::new));

		TreeSet<String> finalChqList = Stream.concat(chqList.stream(), chqList2.stream())
				.collect(Collectors.toCollection(TreeSet::new));
		String divName = "";
		List<Long> finalChqList2 = new ArrayList<>();
		for (String chqNo : finalChqList) {
			divName = chqNo.split("-")[0];
			finalChqList2.add(new Long(chqNo.split("-")[1]));
		}
		Collections.sort(finalChqList2);

		for (LocChqBookActInActDto activeChequeList : locActiveChqList) {
			int counter = -1;
			for (int i = 0; i < finalChqList.size(); i++) {
				if (counter > -1
						|| new Long(activeChequeList.getStartSeries().split("-")[1]).equals(finalChqList2.get(i))) {
					if ((activeChequeList.getEndSeries().split("-")[1]).equals(finalChqList2.get(i))) {
						locActiveChqList.remove(activeChequeList);
						counter = 0;
					} else if (new Long(activeChequeList.getEndSeries().split("-")[1]) > finalChqList2.get(i)) {
						counter = i;
					}
				}
			}
			if (counter > 0) {
				Long chqNo = finalChqList2.get(counter) + 1;
				activeChequeList.setStartSeries(divName + "-" + chqNo);
			}
		}
		return locActiveChqList;
	}
}
