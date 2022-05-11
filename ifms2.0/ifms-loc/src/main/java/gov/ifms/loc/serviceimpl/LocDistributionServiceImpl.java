package gov.ifms.loc.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
import gov.ifms.loc.converter.LocDistributionHdrConverter;
import gov.ifms.loc.converter.LocDistributionHeadDtlConverter;
import gov.ifms.loc.dto.LocDistGrantDto;
import gov.ifms.loc.dto.LocDistributionDtlViewDto;
import gov.ifms.loc.dto.LocDistributionHdrViewDto;
import gov.ifms.loc.dto.LocDistributionListingDto;
import gov.ifms.loc.dto.LocDistributionSrchParamDto;
import gov.ifms.loc.dto.LocDistributionSubmitDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.entity.LocDistributionHdrEntity;
import gov.ifms.loc.entity.LocDistributionHeadDtlEntity;
import gov.ifms.loc.notification.LocNotificationService;
import gov.ifms.loc.repository.LocDistributionHdrRepository;
import gov.ifms.loc.repository.LocDistributionHeadDtlRepository;
import gov.ifms.loc.repository.LocDistributionWfRepository;
import gov.ifms.loc.repository.LocMsOfficeRepository;
import gov.ifms.loc.service.LocDistributionService;
import gov.ifms.loc.service.LocPDFService;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocDBConstants;
import gov.ifms.loc.util.LocNumberToWordsConverter;
import gov.ifms.loc.util.LocURLConstant;
import gov.ifms.loc.util.LocUtility;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;


/**
 * The Class LocDistributionServiceImpl.
 */
@Service
public class LocDistributionServiceImpl implements LocDistributionService {

	/**
	 * The hdr repo.
	 */
	@Autowired
	LocDistributionHdrRepository hdrRepo;

	/**
	 * The office repo.
	 */
	@Autowired
	LocMsOfficeRepository officeRepo;

	/**
	 * The hdr convertor.
	 */
	@Autowired
	LocDistributionHdrConverter hdrConvertor;

	/**
	 * The dtl repo.
	 */
	@Autowired
	LocDistributionHeadDtlRepository dtlRepo;

	/**
	 * The dtl convertor.
	 */
	@Autowired
	LocDistributionHeadDtlConverter dtlConvertor;

	/**
	 * The wf repo.
	 */
	@Autowired
	LocDistributionWfRepository wfRepo;
	
	/** The pdf service. */
	@Autowired
	private LocPDFService pdfService;

	/**
	 * The loc wf action config service.
	 */
	@Autowired
	private LocWfActionConfigService locWfActionConfigService;

	/** The notificationService. */
	@Autowired
	private LocNotificationService notificationService;
	
	/**
	 * The look up info repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Override
	public LocDistributionSrchParamDto getSearchParam() throws CustomException {
		List<Object[]> searchPrmList = hdrRepo.getSrchParam();
		List<LocDistributionSrchParamDto> resultList = !searchPrmList.isEmpty()
				? NativeQueryResultsMapper.map(searchPrmList, LocDistributionSrchParamDto.class)
				: Collections.emptyList();
		LocDistributionSrchParamDto searchPram = new LocDistributionSrchParamDto();

		searchPram
				.setEntryTypeList(resultList.stream().filter(distinctByKeys(LocDistributionSrchParamDto::getEntryType))
						.filter(e -> e.getEntryType() != null).map(e -> {
							LocDistributionSrchParamDto entryType = new LocDistributionSrchParamDto();
							entryType.setEntryType(e.getEntryType());
							return entryType;
						}).collect(Collectors.toList()));

		searchPram.setWfList(resultList.stream().filter(distinctByKeys(LocDistributionSrchParamDto::getWfStatus))
				.filter(e -> e.getWfStatus() != null).map(e -> {
					LocDistributionSrchParamDto wfStatus = new LocDistributionSrchParamDto();
					wfStatus.setWfStatus(e.getWfStatus());
					return wfStatus;
				}).collect(Collectors.toList()));

		searchPram
				.setStatusList(resultList.stream()
						.filter(distinctByKeys(LocDistributionSrchParamDto::getStatusName))
						.filter(e -> e.getStatusId() != null).map(e -> {
							LocDistributionSrchParamDto statusData = new LocDistributionSrchParamDto();
							statusData.setStatusId(e.getStatusId());
							statusData.setStatusName(e.getStatusName());
							return statusData;
						}).collect(Collectors.toList()));

		searchPram
				.setCircleCodeList(resultList.stream()
						.filter(distinctByKeys(LocDistributionSrchParamDto::getCircleId,
								LocDistributionSrchParamDto::getCircleCode))
						.filter(e -> e.getCircleId() != null).map(e -> {
							LocDistributionSrchParamDto circleCodeData = new LocDistributionSrchParamDto();
							circleCodeData.setCircleId(e.getCircleId());
							circleCodeData.setCircleCode(e.getCircleCode());
							return circleCodeData;
						}).collect(Collectors.toList()));

		searchPram
				.setCircleNameList(resultList.stream()
						.filter(distinctByKeys(LocDistributionSrchParamDto::getCircleId,
								LocDistributionSrchParamDto::getCircleName))
						.filter(e -> e.getCircleId() != null).map(e -> {
							LocDistributionSrchParamDto circleNameData = new LocDistributionSrchParamDto();
							circleNameData.setCircleNameId(e.getCircleId());
							circleNameData.setCircleName(e.getCircleName());
							return circleNameData;
						}).collect(Collectors.toList()));
		searchPram.setDivCodeList(resultList.stream()
				.filter(distinctByKeys(LocDistributionSrchParamDto::getDivId, LocDistributionSrchParamDto::getDivCode))
				.filter(e -> e.getDivId() != null).map(e -> {
					LocDistributionSrchParamDto divCodeData = new LocDistributionSrchParamDto();
					divCodeData.setDivId(e.getDivId());
					divCodeData.setDivCode(e.getDivCode());
					return divCodeData;
				}).collect(Collectors.toList()));

		searchPram.setDivNameList(resultList.stream()
				.filter(distinctByKeys(LocDistributionSrchParamDto::getDivId, LocDistributionSrchParamDto::getDivCode))
				.filter(e -> e.getDivId() != null).map(e -> {
					LocDistributionSrchParamDto divNameData = new LocDistributionSrchParamDto();
					divNameData.setDivNameId(e.getDivId());
					divNameData.setDivName(e.getDivName());
					return divNameData;
				}).collect(Collectors.toList()));

		searchPram
				.setFinYearList(resultList.stream()
						.filter(distinctByKeys(LocDistributionSrchParamDto::getFinYearId,
								LocDistributionSrchParamDto::getFinYear))
						.filter(e -> e.getFinYearId() != null).map(e -> {
							LocDistributionSrchParamDto finYear = new LocDistributionSrchParamDto();
							finYear.setFinYearId(e.getFinYearId());
							finYear.setFinYear(e.getFinYear());
							finYear.setIsCurFinYear(
									e.getIsCurFinYear() == 2 ? LocConstant.LONG_ONE : LocConstant.LONG_ZERO);
							return finYear;
						}).collect(Collectors.toList()));
		return searchPram;
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
	public LocDistributionSubmitDto submit(LocDistributionSubmitDto dto) throws CustomException {
		LocDistributionHdrEntity hdrEntity = hdrRepo.findByIdAndActiveStatus(dto.getHdrId(), Constant.ACTIVE_STATUS);
		EDPLuLookUpInfoEntity statusLookUp =  getStatusLookUp(dto.getTrnStatus());
		Long statusId = 0l;
		if(Objects.nonNull(statusLookUp)) {
			statusId = statusLookUp.getLookUpInfoId();
		}
		if (null == hdrEntity.getRefNo()) {
			dto.setRefNo(getTransactionNumber());
			dto.setRefDate(new Date());
			hdrRepo.updateLocDistribution(dto.getHdrId(), dto.getInwardNo(), dto.getInwardDate(), dto.getPartyRefNo(),
					dto.getPartyRefDate(), dto.getRaiseObjFlag(), dto.getObjRemarks(), dto.getRefNo(),
					dto.getRefDate(), OAuthUtility.getCurrentUserUserId(), OAuthUtility.getCurrentUserLkPOUId(), new Date(),statusId);
		} else {
			hdrRepo.updateLocDistribution(dto.getHdrId(), dto.getInwardNo(), dto.getInwardDate(), dto.getPartyRefNo(),
					dto.getPartyRefDate(), dto.getRaiseObjFlag(), dto.getObjRemarks(), hdrEntity.getRefNo(),
					hdrEntity.getRefDate(), OAuthUtility.getCurrentUserUserId(), OAuthUtility.getCurrentUserLkPOUId(),
					new Date(),statusId);
			if (dto.getTrnStatus().equals("Authorized")) {
			
				hdrEntity.setStatusId(LocConstant.LOC_AUTHORIZED_ID);
				hdrRepo.save(hdrEntity);
				List<LocDistributionHeadDtlEntity> dtlList = dtlRepo.findByHdrIdIdAndActiveStatus(dto.getHdrId(),
						Constant.ACTIVE_STATUS);

				if (!CollectionUtils.isEmpty(dtlList)) {
					updatePendingRecordsAmounts(dtlList.get(0), dto, hdrEntity);
				}
				updateFlagInHdr(hdrEntity.getDdoNo(),hdrEntity.getCardexNo(),hdrEntity.getOfficeId());
			}
			LocSubmitWfDto submitWfDto = new LocSubmitWfDto();
			submitWfDto.setTrnId(dto.getHdrId());
			submitWfDto.setMenuId(dto.getMenuId());
			submitWfDto.setAssignByBranchId(dto.getAssignByBranchId());
			submitWfDto.setAssignByOfficeId(dto.getAssignByOfficeId());
			submitWfDto.setAssignByWfRoleId(dto.getAssignByWfRoleId());
			submitWfDto.setAssignToOfficeId(dto.getAssignToOfficeId());
			submitWfDto.setAssignToPouId(dto.getAssignToPouId());
			submitWfDto.setAssignToWfRoleId(dto.getAssignToWfRoleId());
			submitWfDto.setWfActionId(dto.getWfActionId());
			submitWfDto.setTrnStatus(dto.getTrnStatus());
			notificationService.sendNotification(submitWfDto);
			}
			
		if(dto.getTrnStatus().equals(LocConstant.AUTHORIZED) || dto.getTrnStatus().equals(Constant.REJECTED) ) {
			amountCalculationAfterSubmit(hdrEntity.getGrantId(),dto.getTrnStatus());
		}
		
		if (wfRepo.findByTrnIdAndActiveStatus(hdrEntity.getId(), Constant.ACTIVE_STATUS) == null) {
			WfUserReqSDDto wfDto = dto.getWfuserReqDto();
			wfDto.setTrnId(hdrEntity.getId());
			callWorkflow(wfDto);
		}
		return dto;
	}
	
	
	private void updateFlagInHdr(String ddoNo, String cardexNo, Long officeId) {
		hdrRepo.updateFlagInAdviceHdr(ddoNo, cardexNo, officeId);
	}

	private void amountCalculationAfterSubmit(Long trnId,String status) throws CustomException {
		try {
			Map<String, Object> map = new LinkedHashMap<>();
			map.put(Constant.IN_HDR_ID, trnId);
			map.put(Constant.IN_WF_STATUS, status);
			String procName = LocConstant.LOC_SCHEMA.concat(Constant.DOT.concat("SP_GRANT_AMOUNT_CO_DDO_WF"));
			hdrRepo.callStoredProcedureWithNoResult(procName, map);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CALL_SP);
		}
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
	 * Call workflow.
	 *
	 * @param wfSaveDto the wf save dto
	 * @throws CustomException the custom exception
	 */
	private void callWorkflow(WfUserReqSDDto wfSaveDto) throws CustomException {
		locWfActionConfigService.saveWfActConfigTrn(wfSaveDto);
	}


	@Override
	public PagebleDTO<LocDistributionListingDto> getListingData(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(LocDBConstants.getLocDistributionListing().get(search.getKey()),
					search.getValue()));
		} else {
			LocDBConstants.getLocDistributionListing()
					.forEach((k, v) -> map.put(LocDBConstants.getLocDistributionListing().get(k), 0));
		}
		String procName;
		Integer isTo = Integer.valueOf(String.valueOf(map.get(LocDBConstants.IS_TO)));
		if(isTo == (Constant.INACTIVE_STATUS)){
		 procName = LocConstant.LOC_SCHEMA
				.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_DISTRIBUTION_DIV_LISTNG));
		}else {
			 procName = LocConstant.LOC_SCHEMA
					.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_DISTRIBUTION_LISTING));					
		}
		List<LocDistGrantDto> grantList = this.getDistributionGrantList(map);
		map.remove(LocDBConstants.IN_OFFICE_ID);
		map.remove(LocDBConstants.IS_TO);
		if(isTo != (Constant.INACTIVE_STATUS)){
		map.remove(LocDBConstants.IN_CARDEX_NO);
		map.remove(LocDBConstants.IN_DDO_NO);
		}
		List<LocDistributionListingDto> objectSp = this.callStoreProc(procName, map, LocDistributionListingDto.class);
		List<LocDistributionListingDto> finalObjectSp = this.grantDataMapper(objectSp, grantList);
		long totalPages = !finalObjectSp.isEmpty() ? (finalObjectSp.size()) : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, finalObjectSp);
	}


	@Override
	public LocDistributionHdrViewDto getEditView(IdDto dto) throws CustomException {
		List<Object[]> hdrData = hdrRepo.getHdrEditView(dto.getId(), Constant.ACTIVE_STATUS);
		List<LocDistributionHdrViewDto> resultList = !hdrData.isEmpty()
				? NativeQueryResultsMapper.map(hdrData, LocDistributionHdrViewDto.class)
				: Collections.emptyList();
		LocDistributionHdrViewDto hdrDto = resultList.get(0);

		List<Object[]> dtlData = hdrRepo.getDtlEditView(dto.getId(), Constant.ACTIVE_STATUS);
		List<LocDistributionDtlViewDto> dtlDataList = !dtlData.isEmpty()
				? NativeQueryResultsMapper.map(dtlData, LocDistributionDtlViewDto.class)
				: Collections.emptyList();
		hdrDto.setDistributionDtlDto(dtlDataList);
		return hdrDto;
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

	/**
	 * Gets the transaction number.
	 *
	 * @return the transaction number
	 * @throws CustomException the custom exception
	 */
	private String getTransactionNumber() throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.TRN_SCREEN, LocConstant.TRN_SCREEN);
		String procName = LocConstant.LOC_SCHEMA.concat(Constant.DOT.concat(LocDBConstants.P_LOC_TRN_NO_GEN));
		List<Object[]> nextSequenceNumber = hdrRepo.callStoredProcedure(procName, map);
		if (!Utils.isEmpty(nextSequenceNumber)) {
			return (String) nextSequenceNumber.get(0)[0];
		} else {
			throw new CustomException(ErrorResponse.REF_GENERATION_FAILED);
		}
	}

	/**
	 * Gets the distribution grant list.
	 *
	 * @param map the map
	 * @return the distribution grant list
	 * @throws CustomException the custom exception
	 */
	private List<LocDistGrantDto> getDistributionGrantList(Map<String, Object> map) throws CustomException {
		List<Object[]> grantData = hdrRepo.getGrantDistributionList(
				Long.valueOf(String.valueOf(map.get(LocDBConstants.IN_CARDEX_NO))),
				Long.valueOf(String.valueOf(map.get(LocDBConstants.IN_DDO_NO))),
				Long.valueOf(String.valueOf(map.get(LocDBConstants.IN_OFFICE_ID))),
				Long.valueOf(String.valueOf(map.get(LocDBConstants.IN_FIN_YR))));
		return !grantData.isEmpty() ? NativeQueryResultsMapper.map(grantData, LocDistGrantDto.class)
				: Collections.emptyList();
	}

	/**
	 * Grant data mapper.
	 *
	 * @param distObjectSp the dist object sp
	 * @param grantList    the grant list
	 * @return the list
	 */
	private List<LocDistributionListingDto> grantDataMapper(List<LocDistributionListingDto> distObjectSp,
			List<LocDistGrantDto> grantList) {
		List<LocDistributionListingDto> objectSp = new ArrayList<>();
		if (!distObjectSp.isEmpty()) {
			objectSp = distObjectSp;
		}
		return objectSp;
	}

	/**
	 * Update pending records amounts.
	 *
	 * @param locDistributionHeadDtlEntity the loc distribution head dtl entity
	 * @param dto the dto
	 * @param hdrEntity 
	 */
	private void updatePendingRecordsAmounts(LocDistributionHeadDtlEntity locDistributionHeadDtlEntity, LocDistributionSubmitDto dto, LocDistributionHdrEntity hdrEntity) {

		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(LocDBConstants.IN_TYPE_OF_ESTIMATE, locDistributionHeadDtlEntity.getTypeOfEstimate());
		argsMap.put(LocDBConstants.IN_FUND_TYPE, locDistributionHeadDtlEntity.getFundType());
		argsMap.put(LocDBConstants.IN_CLASS_EXPENDITURE,locDistributionHeadDtlEntity.getClassExpend());
		if(Objects.nonNull(locDistributionHeadDtlEntity.getBudgetType())) {
		argsMap.put(LocDBConstants.IN_BUDGET_TYPE, locDistributionHeadDtlEntity.getBudgetType());
		}else {
			argsMap.put(LocDBConstants.IN_BUDGET_TYPE, 0);
		}
		if(Objects.nonNull(locDistributionHeadDtlEntity.getObjectClass())) {
			argsMap.put(LocDBConstants.IN_OBJECT_CLASS, locDistributionHeadDtlEntity.getObjectClass().getObjectClassId());
		}else {
			argsMap.put(LocDBConstants.IN_OBJECT_CLASS, 0);
		}
		if(Objects.nonNull(locDistributionHeadDtlEntity.getItemWorkName())) {
			argsMap.put(LocDBConstants.IN_ITEM_WORK_NAME,locDistributionHeadDtlEntity.getItemWorkName().getItemId());
		}else {
			argsMap.put(LocDBConstants.IN_ITEM_WORK_NAME,0);
		}

		argsMap.put(LocDBConstants.IN_DETAILED_HEAD_ID, locDistributionHeadDtlEntity.getDetailedHeadId().getDetailHeadId());
		argsMap.put(LocDBConstants.IN_SUBHEAD_ID, locDistributionHeadDtlEntity.getSubHeadId().getSubHeadId());
		argsMap.put(LocDBConstants.IN_MINOR_HEAD_ID, locDistributionHeadDtlEntity.getMinorHeadId().getMinorHeadId());
		argsMap.put(LocDBConstants.IN_SUBMAJOR_HEAD_ID,locDistributionHeadDtlEntity.getSubMajorHeadId().getSubMajorHeadId());
		argsMap.put(LocDBConstants.IN_MAJOR_HEAD_ID, locDistributionHeadDtlEntity.getMajorHeadId().getMajorHeadId());
		argsMap.put(LocDBConstants.IN_DEMAND_ID, locDistributionHeadDtlEntity.getDemandId().getDemandId());
		argsMap.put(LocDBConstants.IN_NEW_BALANCE_LC_AMT, dto.getNewBalAmt());
		argsMap.put(LocDBConstants.IN_BALANCE_LC_AMT, dto.getNewBalAmt());
		argsMap.put(LocDBConstants.IN_DDO_NO, (hdrEntity.getDdoNo()));
		argsMap.put(LocDBConstants.IN_HDR_ID, dto.getHdrId());
		String procName = LocConstant.LOC_SCHEMA.concat(LocConstant.DOT)
				.concat(LocDBConstants.SP_LOC_DISTRIBUTION_UPDATE);
		this.hdrRepo.callStoredProcedureWithNoResult(procName, argsMap);
	}
	

	@Override
	public Map<String,Object> printFormB(IdDto dto) throws CustomException{
		List<Object[]> hdrData = hdrRepo.getHdrEditView(dto.getId(), Constant.ACTIVE_STATUS);
		List<LocDistributionHdrViewDto> locDistributionHdrView = !hdrData.isEmpty()
				? NativeQueryResultsMapper.map(hdrData, LocDistributionHdrViewDto.class)
				: Collections.emptyList();
				if(!CollectionUtils.isEmpty(locDistributionHdrView)) {
				return generateFormBPDF(locDistributionHdrView.get(0));
				}
				return null;

	}

	/**
	 * Generate form BPDF.
	 *
	 * @param hdrViewDto the hdr view dto
	 * @return the map
	 */
	private Map<String, Object> generateFormBPDF(LocDistributionHdrViewDto hdrViewDto) {
		
		Map<String, Object> inputMap = null;
		Map<String, Object> resultMap = null;
		Double progAmt=hdrViewDto.getNewBalanceLcAmt()+hdrViewDto.getBalanceLcAmt();
		inputMap = new HashMap<>();
		inputMap.put("header", hdrViewDto);
		inputMap.put("progAmt", progAmt);
		inputMap.put("progTotalInWord", LocNumberToWordsConverter.convert(progAmt) );
		inputMap.put("lcTotalInWord", null != hdrViewDto.getBalanceLcAmt() ? LocNumberToWordsConverter.convert(hdrViewDto.getBalanceLcAmt()) : null);

		resultMap = new HashMap<>();
		resultMap.put("base64String", pdfService.generatePDF(LocURLConstant.FORMB_FTL_FILE, inputMap,
				LocConstant.FORMB_PDF_FILE_NAME + hdrViewDto.getLcNo()));
		resultMap.put("fileName", LocConstant.FORMB_PDF_FILE_NAME  + hdrViewDto.getLcNo());
		return resultMap;
	}
	
	@Override
	public Map<String,Object> printFormA(IdDto dto) throws CustomException{
		List<Object[]> hdrData = hdrRepo.getHdrEditView(dto.getId(), Constant.ACTIVE_STATUS);
		List<LocDistributionHdrViewDto> locDistributionHdrView = !hdrData.isEmpty()
				? NativeQueryResultsMapper.map(hdrData, LocDistributionHdrViewDto.class)
				: Collections.emptyList();
				List<Object[]> dtlData = hdrRepo.getDtlViewData(dto.getId(), Constant.ACTIVE_STATUS);
				List<LocDistributionDtlViewDto> dtlDataList = !dtlData.isEmpty()
						? NativeQueryResultsMapper.map(dtlData, LocDistributionDtlViewDto.class)
						: Collections.emptyList();		
				return generateFormAPDF(locDistributionHdrView.get(0), dtlDataList);

	}
	
	/**
	 * Generate form APDF.
	 *
	 * @param hdrViewDto the hdr view dto
	 * @return the map
	 */
	private Map<String, Object> generateFormAPDF(LocDistributionHdrViewDto hdrViewDto,List<LocDistributionDtlViewDto> dtlDataList) {
		
		Map<String, Object> inputMap = null;
		Map<String, Object> resultMap = null;
		inputMap = new HashMap<>();
		inputMap.put("header", hdrViewDto);
		inputMap.put("detail", dtlDataList);
		inputMap.put("currDate", new Date());
		inputMap.put("lcTotalInWord", null != hdrViewDto.getBalanceLcAmt() ? LocNumberToWordsConverter.convert(hdrViewDto.getBalanceLcAmt()) : null);
		Double stateLcIssuedTotal = dtlDataList.stream().map(LocDistributionDtlViewDto :: getCenterAmount).mapToDouble(Double::doubleValue).sum();
		Double centerLcIssuedTotal = dtlDataList.stream().map(LocDistributionDtlViewDto :: getStateAmount).mapToDouble(Double::doubleValue).sum();
		inputMap.put("stateLcIssuedTotal", stateLcIssuedTotal);
		inputMap.put("centerLcIssuedTotal", centerLcIssuedTotal);
		inputMap.put("qrCode", LocUtility.generateBase64QRCodeImage(getQRDetail(hdrViewDto)));
		resultMap = new HashMap<>();
		resultMap.put("base64String", pdfService.generatePDF(LocURLConstant.FORMA_FTL_FILE, inputMap,
				LocConstant.FORMA_PDF_FILE_NAME + hdrViewDto.getLcNo()));
		resultMap.put("fileName", LocConstant.FORMA_PDF_FILE_NAME  + hdrViewDto.getLcNo());
		return resultMap;
	}
	
	/**
	 * Gets the QR detail.
	 *
	 * @param hdrDtlDto the hdr dtl dto
	 * @return the QR detail
	 */
	private String getQRDetail(LocDistributionHdrViewDto hdrDtlDto) {
		StringBuilder grnBuilder = new StringBuilder();
		grnBuilder.append(hdrDtlDto.getLcNo() + "\n" +"\n");
		grnBuilder.append(LocConstant.LC_NUMBER_LABLE + (!hdrDtlDto.getLcNo().isEmpty()?hdrDtlDto.getLcNo().substring((hdrDtlDto.getLcNo().length())-4):null) + "\n");
		grnBuilder.append(LocConstant.DIVISION_CODE + (hdrDtlDto.getDivCode() +" - " + hdrDtlDto.getDivName()) + "\n");
		grnBuilder.append(LocConstant.CIRCLE_CODE_LABLE + (hdrDtlDto.getCircleCode() +" - " +hdrDtlDto.getCircleName()) + "\n");
		grnBuilder.append(LocConstant.DISTRICT_LABLE + (hdrDtlDto.getDistCode() +" - " + hdrDtlDto.getDistCodeName()) + "\n");
		grnBuilder.append(LocConstant.TO_OFFICE +( hdrDtlDto.getToOfficeName())+ "\n");
		grnBuilder.append(LocConstant.LC_TYPE_LABLE + hdrDtlDto.getEntryType() + "\n");
		grnBuilder.append(LocConstant.LC_AMOUNT_LABLE + (LocNumberToWordsConverter.roundBy2Decimal(hdrDtlDto.getBalanceLcAmt())) + "\n");
		grnBuilder.append(LocConstant.LC_DATE_LABLE + LocUtility.getFormattedDate(hdrDtlDto.getLcIssueDate()) + "\n");
		return grnBuilder.toString();
	}
	
}
