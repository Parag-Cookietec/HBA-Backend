package gov.ifms.loc.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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
import gov.ifms.loc.converter.LocChequeToChequeDetailSdConverter;
import gov.ifms.loc.converter.LocChequeToChequeHDRConverter;
import gov.ifms.loc.dto.LocAdviceReqParamDto;
import gov.ifms.loc.dto.LocCheckToCheckHdrInfoDto;
import gov.ifms.loc.dto.LocChequeToChequeDetailSdDto;
import gov.ifms.loc.dto.LocChequeToChequeEditViewDto;
import gov.ifms.loc.dto.LocChequeToChequeHDRDto;
import gov.ifms.loc.dto.LocChequeToChequeListingDto;
import gov.ifms.loc.dto.LocChequeToChequeSearchDto;
import gov.ifms.loc.dto.LocChequeToChequeSrchData;
import gov.ifms.loc.dto.LocChqToChqDto;
import gov.ifms.loc.dto.LocChqToChqEditViewDto;
import gov.ifms.loc.dto.LocSubmitWfDto;
import gov.ifms.loc.entity.LocChequeToChequeDetailSdEntity;
import gov.ifms.loc.entity.LocChequeToChequeHDREntity;
import gov.ifms.loc.repository.LocChequeToChequeDetailSdRepository;
import gov.ifms.loc.repository.LocChequeToChequeHDRRepository;
import gov.ifms.loc.repository.LocChequeToChequeWfRepository;
import gov.ifms.loc.service.LocChequeToChequeService;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocDBConstants;
import gov.ifms.loc.util.LocMessageConstant;
import gov.ifms.loc.util.LocUtility;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;

@Service
public class LocChequeToChequeServiceImpl implements LocChequeToChequeService {

	/** The hrd converter. */
	@Autowired
	private LocChequeToChequeHDRConverter hrdConverter;

	/** The hrd repositry. */
	@Autowired
	private LocChequeToChequeHDRRepository hrdRepository;

	/** The sd hrd converter. */
	@Autowired
	private LocChequeToChequeDetailSdConverter sdHrdConverter;

	/** The sd hrd repository. */
	@Autowired
	private LocChequeToChequeDetailSdRepository sdHrdRepository;

	/** The wf repository. */
	@Autowired
	private LocChequeToChequeWfRepository wfRepository;

	@Autowired
	private LocAdvicePrepServiceImpl advicePrepService;

	/**
	 * The look up info repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;
	/**
	 * The loc wf action config service.
	 */
	@Autowired
	private LocWfActionConfigService locWfActionConfigService;

	@Transactional
	@Override
	public LocChequeToChequeHDRDto saveAsDraft(LocChequeToChequeHDRDto dto) throws CustomException {
		LocChequeToChequeHDREntity hdrEntity = hrdConverter.toEntity(dto);
		hdrEntity = hrdRepository.save(hdrEntity);
		for (LocChequeToChequeDetailSdDto sdDto : dto.getChequeTochequeSdDto()) {
			sdDto.setHdrId(hdrEntity.getId());
			validationChequeDtAmount(sdDto.getChequeDate(),sdDto.getChequeAmt(),dto.getMissingChequeAmt());
			LocChequeToChequeDetailSdEntity sdEntity = sdHrdRepository.save(sdHrdConverter.toEntity(sdDto));
			sdDto.setId(sdEntity.getId());
		}

		if (wfRepository.findByIdAndActiveStatus(hdrEntity.getId(), Constant.ACTIVE_STATUS) == null) {
			WfUserReqSDDto wfDto = dto.getWfUserReqDto();
			wfDto.setTrnId(hdrEntity.getId());
			callWorkflow(wfDto);
		}
		dto.setId(hdrEntity.getId());
		dto.setMissingChequeNo(hdrEntity.getMissingChequeNo());
		return dto;
	}

	private void validationChequeDtAmount(Date chequeDt, Double chequeAmnt, Double missingChequeAmnt) throws CustomException {
		if (Objects.nonNull(chequeDt)
				&& !LocUtility.validateFromDate(chequeDt)) {
			throw new CustomException(HttpStatus.CONFLICT, LocMessageConstant.LOC_CURRENT_DT_VALIDATION);
		}
		if (!(Objects.nonNull(chequeAmnt)
				&& chequeAmnt.equals(missingChequeAmnt))) {
			throw new CustomException(HttpStatus.CONFLICT, LocMessageConstant.LOC_CHQ_2_CHQ_VALIDATION);
		}
		
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
	public LocCheckToCheckHdrInfoDto getCheckToCheckHeaderInfo(IdDto dto) throws CustomException {
		List<Object[]> pramList = hrdRepository.getHeaderChequeToChequeList(dto.getId(), Constant.ACTIVE_STATUS);
		List<LocCheckToCheckHdrInfoDto> hdrInfoList = !pramList.isEmpty()
				? NativeQueryResultsMapper.map(pramList, LocCheckToCheckHdrInfoDto.class)
				: Collections.emptyList();
		return hdrInfoList.get(0);
	}

	@Override
	public PagebleDTO<LocChequeToChequeListingDto> getChequeToChequeListing(PageDetails pageDetail)
			throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> map.put(LocDBConstants.getLocChequeToChequeListing().get(search.getKey()),
					search.getValue()));
		} else {
			LocDBConstants.getLocChequeToChequeListing()
					.forEach((k, v) -> map.put(LocDBConstants.getLocChequeToChequeListing().get(k), 0));
		}
		String procName = LocConstant.LOC_SCHEMA
				.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_CHEQUE2CHEQUE_LISTING));
		List<LocChequeToChequeListingDto> objectSp = this.callStoreProc(procName, map,
				LocChequeToChequeListingDto.class);
		long totalPages = !objectSp.isEmpty() ? objectSp.size() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	@Override
	public LocChequeToChequeSrchData getChequeData(LocChequeToChequeHDRDto dto) throws CustomException {
		List<Object[]> chqAuthList = hrdRepository.chqAuthStatus(dto.getMissingChequeNo(), Constant.ACTIVE_STATUS);
		if (!chqAuthList.isEmpty()) {
			if(null==dto.getId())
			{
				dto.setId(LocConstant.LONG_ZERO);
			}
			List<Object[]> chqInProcessList = hrdRepository.chqInProcess(dto.getMissingChequeNo(),
					Constant.ACTIVE_STATUS,dto.getId());
			if (chqInProcessList.isEmpty()) {
				List<Object[]> resultObj = hrdRepository.getChqToChqSrchData(dto.getMissingChequeNo(),
						Constant.ACTIVE_STATUS);

				List<LocChequeToChequeSrchData> resultList = !resultObj.isEmpty()
						? NativeQueryResultsMapper.map(resultObj, LocChequeToChequeSrchData.class)
						: Collections.emptyList();
				LocChequeToChequeSrchData resultDto = resultList.get(0);
				resultDto.setNextChqDtl(advicePrepService.getChequeBookData(this.reqParamDtoSetter(resultDto)));
				return resultDto;
			} else {
				throw new CustomException(HttpStatus.CONFLICT, LocMessageConstant.LOC_MISSING_CHEQUEBOOK_CHQ_PROCESSED);
			}
		} else {
			throw new CustomException(HttpStatus.CONFLICT, LocMessageConstant.LOC_MISSING_CHEQUEBOOK_AUTH);
		}
	}

	@Override
	public LocChqToChqDto getEditView(LocChequeToChequeEditViewDto dto) throws CustomException {
		LocChqToChqDto resultDto = new LocChqToChqDto();
		List<Object[]> resultObj = hrdRepository.getChqToChqHdr(dto.getHdrId(), Constant.ACTIVE_STATUS);
		List<LocChqToChqDto> resultList = !resultObj.isEmpty()
				? NativeQueryResultsMapper.map(resultObj, LocChqToChqDto.class)
				: Collections.emptyList();
		resultDto = resultList.get(0);
		List<LocChqToChqEditViewDto> chqList = new ArrayList<>();
		if (dto.getActionStatus().equals(LocConstant.VIEW_ACTION)) {
			List<Object[]> dtlData = hrdRepository.getDtlData(dto.getHdrId(), Constant.ACTIVE_STATUS);
			chqList = !dtlData.isEmpty() ? NativeQueryResultsMapper.map(dtlData, LocChqToChqEditViewDto.class)
					: Collections.emptyList();
			resultDto = resultList.get(0);
		} else if (dto.getActionStatus().equals(LocConstant.EDIT_ACTION)) {
			List<Object[]> sdData = hrdRepository.getSdData(dto.getHdrId(), Constant.ACTIVE_STATUS);
			chqList = !sdData.isEmpty() ? NativeQueryResultsMapper.map(sdData, LocChqToChqEditViewDto.class)
					: Collections.emptyList();
			LocChequeToChequeHDRDto hdrDto = new LocChequeToChequeHDRDto();
			hdrDto.setMissingChequeNo(resultDto.getChequeNO());
			resultDto = resultList.get(0);
			hdrDto.setId(dto.getHdrId());
			resultDto.setChequeSrchData(this.getChequeData(hdrDto));
		}
		resultDto.setChqList(chqList);

		return resultDto;
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
		List<Object[]> objectSp = hrdRepository.callStoredProcedure(procName, map);
		return !objectSp.isEmpty() ? NativeQueryResultsMapper.map(objectSp, view) : Collections.emptyList();
	}

	private LocAdviceReqParamDto reqParamDtoSetter(LocChequeToChequeSrchData dataDto) throws CustomException {
		LocAdviceReqParamDto resultDto = new LocAdviceReqParamDto();
		resultDto.setDdoNo(dataDto.getDdoNo());
		resultDto.setCardexNo(dataDto.getCardexNo());
		resultDto.setDepartmentId(dataDto.getDeptId());
		resultDto.setDistrictId(dataDto.getDistrictId());
		resultDto.setOfficeId(dataDto.getOfficeId());
		return resultDto;
	}

	@Override
	public void submitData(LocSubmitWfDto submitWfDto) throws CustomException {
		Optional<LocChequeToChequeHDREntity> hdrEntity = hrdRepository.findByActiveStatusAndId(Constant.ACTIVE_STATUS,
				submitWfDto.getTrnId());
		if (hdrEntity.isPresent()) {
			submitData(submitWfDto, LocDBConstants.SP_LOC_CHEQUE2CHEQUE_SUBMIT);
		}

	}

	/**
	 * Submit data.
	 *
	 * @param submitWfDto the submit wf dto
	 * @param procName    the proc name
	 */
	private void submitData(LocSubmitWfDto submitWfDto, String procName) {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(LocDBConstants.IN_CHEQUE2CHEQUE_ID, submitWfDto.getTrnId());
		setSubmitDataStatus(submitWfDto.getTrnStatus(), argsMap);
		argsMap.put(LocDBConstants.IN_WF_ROLE_ID, submitWfDto.getWfId());
		argsMap.put(LocDBConstants.IN_WORKFLOW_ID, submitWfDto.getAssignByWfRoleId());
		argsMap.put(Constant.IN_UPDATED_BY, OAuthUtility.getCurrentUserUserId());
		argsMap.put(Constant.IN_UPDATED_BY_POST, OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());
		String spName = LocDBConstants.LOC_SCHEMA.concat(LocConstant.DOT).concat(procName);
		this.hrdRepository.callStoredProcedureWithNoResult(spName, argsMap);

	}

	@Override
	@ExceptionHandler
	// @Transactional(rollbackFor = CustomException.class)
	public IdDto deleteById(IdDto dto) throws CustomException {
		LocChequeToChequeHDREntity hdrEntity = hrdRepository.findByIdAndActiveStatus(dto.getId(),
				Constant.ACTIVE_STATUS);
		hdrEntity.setActiveStatus(0);
		hrdRepository.save(hdrEntity);
		return dto;

	}

	@Override
	public LocChequeToChequeSearchDto getSearchParam() throws CustomException {
		List<Object[]> searchParam = hrdRepository.getSearchParam();
		List<LocChequeToChequeSearchDto> searchParamList = !searchParam.isEmpty()
				? NativeQueryResultsMapper.map(searchParam, LocChequeToChequeSearchDto.class)
				: Collections.emptyList();
		LocChequeToChequeSearchDto resultList = new LocChequeToChequeSearchDto();
		resultList.setWfList(searchParamList.stream().filter(distinctByKeys(LocChequeToChequeSearchDto::getWfStatus))
				.filter(e -> e.getWfStatus() != null).map(e -> {
					LocChequeToChequeSearchDto wfStatus = new LocChequeToChequeSearchDto();
					wfStatus.setWfStatus(e.getWfStatus());
					return wfStatus;
				}).collect(Collectors.toList()));

		resultList
				.setStatusList(searchParamList.stream()
						.filter(distinctByKeys(LocChequeToChequeSearchDto::getStatusName))
						.filter(e -> e.getStatusName() != null).map(e -> {
							LocChequeToChequeSearchDto status = new LocChequeToChequeSearchDto();
							status.setStatusId(e.getStatusId());
							status.setStatusName(e.getStatusName());
							return status;
						}).collect(Collectors.toList()));

		return resultList;
	}

	@Override
	public IdDto deleteCheque(IdDto dto) throws CustomException {
		LocChequeToChequeDetailSdEntity sdEntity = sdHrdRepository.findByIdAndActiveStatus(dto.getId(),
				Constant.ACTIVE_STATUS);
		sdEntity.setActiveStatus(0);
		sdHrdRepository.save(sdEntity);
		return dto;
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
}
