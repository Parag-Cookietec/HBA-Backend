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

import gov.ifms.loc.converter.*;
import gov.ifms.loc.dto.*;
import gov.ifms.loc.entity.*;
import gov.ifms.loc.repository.*;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.GenericDaoImpl;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.loc.notification.LocNotificationService;
import gov.ifms.loc.service.LocAccountOpenReqService;
import gov.ifms.loc.service.LocPDFService;
import gov.ifms.loc.util.LocConstant;
import gov.ifms.loc.util.LocDBConstants;
import gov.ifms.loc.util.LocMessageConstant;
import gov.ifms.loc.util.LocURLConstant;
import gov.ifms.loc.util.LocUtility;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;

/**
 * The Class LocAccountOpenReqServiceImpl.
 *
 * @version 1.0
 * @created 2020/12/22 12:52:20
 */
@Service
public class LocAccountOpenReqServiceImpl implements LocAccountOpenReqService {

	/**
	 * The Constant logger.
	 */
	private static final Logger logg = LoggerFactory.getLogger(LocAccountOpenReqServiceImpl.class);

	/**
	 * The LocAccountOpenReqHdrAsMethodName repository.
	 */
	@Autowired
	private LocAccountOpenReqHdrRepository hdrRepo;

	/**
	 * The LocAccountOpenReqHdrAsMethodName helper.
	 */
	@Autowired
	private LocAccountOpenReqHdrConverter hdrConverter;

	/**
	 * The LocAccountOpenReqSdAsMethodName repository.
	 */
	@Autowired
	private LocAccountOpenReqSdRepository sdRepo;

	/**
	 * The LocAccountOpenReqSdAsMethodName helper.
	 */
	@Autowired
	private LocAccountOpenReqSdConverter sdConverter;

	/**
	 * The LocAccountOpenReqDtlAsMethodName repository.
	 */
	@Autowired
	private LocAccountOpenReqDtlRepository dtlRepository;

	/**
	 * The LocAccountOpenReqDtlAsMethodName helper.
	 */
	@Autowired
	private LocAccountOpenReqDtlConverter dtlConverter;

	/**
	 * The LocAccountOpenReqItrAsMethodName repository.
	 */
	@Autowired
	private LocAccountOpenReqItrRepository itrRepository;

	/**
	 * The LocAccountOpenReqItrAsMethodName helper.
	 */
	@Autowired
	private LocAccountOpenReqItrConverter itrConverter;

	/**
	 * The ms major head repo.
	 */
	@Autowired
	private LocMsMajorHeadRepository msMajorHeadRepo;

	/**
	 * The ms sub major head repo.
	 */
	@Autowired
	private LocMsSubMajorHeadRepository msSubMajorHeadRepo;

	/**
	 * The ms minor head repo.
	 */
	@Autowired
	private LocMsMinorHeadRepository msMinorHeadRepo;

	/**
	 * The ms sub head repo.
	 */
	@Autowired
	private LocMsSubHeadRepository msSubHeadRepo;

	/**
	 * The ms detail head repo.
	 */
	@Autowired
	private LocMsDetailHeadRepository msDetailHeadRepo;

	/**
	 * The generic dao.
	 */
	@Autowired
	private GenericDaoImpl genericDao;

	/**
	 * The loc account open req wf repository.
	 */
	@Autowired
	private LocAccountOpenReqWfRepository locAccountOpenReqWfRepository;

	/**
	 * The loc wf action config service.
	 */
	@Autowired
	private LocWfActionConfigService locWfActionConfigService;

	/**
	 * The loc acc open req ag sd repo.
	 */
	@Autowired
	private LocAccountOpenReqAgSdRepository locAccOpenReqAgSdRepo;

	/**
	 * The loc acc open req ag dtl repo.
	 */
	@Autowired
	private LocAccountOpenReqAgDtlRepository locAccOpenReqAgDtlRepo;

	/**
	 * The loc acc open req ag sd con.
	 */
	@Autowired
	private LocAccountOpenReqAgSdConverter locAccOpenReqAgSdCon;

	/**
	 * The look up info repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/**
	 * The loc acc openreq bank repo.
	 */
	@Autowired
	private LocAccountOpenReqBankDtlRepository locAccOpenreqBankRepo;

	/**
	 * The loc acc openreq divi repo.
	 */
	@Autowired
	private LocAccountOpenReqDivisionDtlRepository locAccOpenreqDiviRepo;

	/**
	 * The loc account open req bank sd converter.
	 */
	@Autowired
	private LocAccountOpenReqBankSdConverter locAccountOpenReqBankSdConverter;

	/**
	 * The loc account open req bank sd repository.
	 */
	@Autowired
	private LocAccountOpenReqBankSdRepository locAccountOpenReqBankSdRepository;

	/**
	 * The loc account open req division sd converter.
	 */
	@Autowired
	private LocAccountOpenReqDivisionSdConverter locAccountOpenReqDivisionSdConverter;

	/**
	 * The loc account open req division sd repository.
	 */
	@Autowired
	private LocAccountOpenReqDivisionSdRepository locAccountOpenReqDivisionSdRepository;

	/** The chq book hdr repo. */
	@Autowired
	private LocChequeBookHdrRepository chqBookHdrRepo;

	/** The pdf service. */
	@Autowired
	private LocPDFService pdfService;

	/** The notificationService. */
	@Autowired
	private LocNotificationService notificationService;

	@Autowired
	private LocMsCircleRepository circleRepo;

	@Autowired
	private LocMsCircleConvertor circleConvertor;

	@Override
	public LocAccountOpenReqHdrEntity getAccountOpenReqHdr(Long id) {
		return hdrRepo.getOne(id);
	}

	@Override
	public LocAccountOpenReqHdrEntity saveOrUpdateAccountOpenReqHdr(LocAccountOpenReqHdrEntity entity) {
		return hdrRepo.save(entity);
	}

	/**
	 * Gets the account open req hdrs.
	 *
	 * @param pageDetail the page detail
	 * @return the account open req hdrs
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<LocAccountOpenReqHdrDto> getAccountOpenReqHdrs(PageDetails pageDetail) throws CustomException {

		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();
		SpecificationImpl<LocAccountOpenReqHdrEntity> spec = new SpecificationImpl<>();
		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<LocAccountOpenReqHdrEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<LocAccountOpenReqHdrEntity> page = hdrRepo.findAll(dataSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				hdrConverter.toDTO(page.getContent()));

	}
	@Override
	public LocAccountOpenReqSdEntity getAccountOpenReqSd(Long id) {
		return sdRepo.getOne(id);
	}

	@Override
	public LocAccountOpenReqSdEntity saveOrUpdateAccountOpenReqSd(LocAccountOpenReqSdEntity entity) {
		return sdRepo.save(entity);
	}

	@Override
	public PagebleDTO<LocAccountOpenReqSdDto> getAccountOpenReqSds(PageDetails pageDetail) throws CustomException {

		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();
		SpecificationImpl<LocAccountOpenReqSdEntity> spec = new SpecificationImpl<>();
		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<LocAccountOpenReqSdEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<LocAccountOpenReqSdEntity> page = sdRepo.findAll(dataSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				sdConverter.toDTO(page.getContent()));

	}
	@Override
	public PagebleDTO<LocAccountOpenReqDtlDto> getAccountOpenReqDtls(PageDetails pageDetail) throws CustomException {

		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();
		SpecificationImpl<LocAccountOpenReqDtlEntity> spec = new SpecificationImpl<>();
		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<LocAccountOpenReqDtlEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<LocAccountOpenReqDtlEntity> page = dtlRepository.findAll(dataSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				dtlConverter.toDTO(page.getContent()));

	}

	@Override
	public PagebleDTO<LocAccountOpenReqItrDto> getAccountOpenReqItrs(PageDetails pageDetail) throws CustomException {

		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();
		SpecificationImpl<LocAccountOpenReqItrEntity> spec = new SpecificationImpl<>();
		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<LocAccountOpenReqItrEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<LocAccountOpenReqItrEntity> page = itrRepository.findAll(dataSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				itrConverter.toDTO(page.getContent()));

	}

	@Override
	public List<LocCircleDto> getAllCircle() throws CustomException {
		List<Object[]> circleList = hdrRepo.getAllCircle();
		return !circleList.isEmpty() ? NativeQueryResultsMapper.map(circleList, LocCircleDto.class)
				: Collections.emptyList();
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public LocAccountOpenReqHdrDto createLocAccReqHdr(LocAccountOpenReqHdrDto locActOpnReqHdrDto)
			throws CustomException {
		try {
			LocAccountOpenReqHdrEntity locAccountOpenReqHdrEntity = null;

			Object[] divisionOfficeList = hdrRepo.getDivsionIdFromOfficeId(locActOpnReqHdrDto.getCardexNo(),
					locActOpnReqHdrDto.getDepartmentId(), String.valueOf(locActOpnReqHdrDto.getDdoNo()),
					locActOpnReqHdrDto.getDistrictId(), Constant.ACTIVE_STATUS,
					(short) Constant.LU_APPROVED_LOOKUP_INFO_ID, Constant.LU_ACTIVE_LOOKUP_INFO_ID);
			if (divisionOfficeList.length == 0) {
				Long hdrId = this.trnExistCheck(locActOpnReqHdrDto);
				if (null == hdrId) {
					locAccountOpenReqHdrEntity = hdrRepo.save(hdrConverter.toEntity(locActOpnReqHdrDto));
					LocAccountOpenReqSdDto locAccountOpenReqSdDto = locActOpnReqHdrDto.getLocAccountOpenReqSdDto();
					locAccountOpenReqSdDto.setLcOpenReqHdrId(locAccountOpenReqHdrEntity.getLcOpenReqHdrId());
					sdRepo.save(sdConverter.toEntity(locAccountOpenReqSdDto));
				} else {

					locActOpnReqHdrDto.getLocAccountOpenReqSdDto().setLcOpenReqHdrId(hdrId);
					sdRepo.updateAccountOpenReqSd(hdrId,
							locActOpnReqHdrDto.getLocAccountOpenReqSdDto().getDivisionName(),
							locActOpnReqHdrDto.getLocAccountOpenReqSdDto().getCircleId(),
							locActOpnReqHdrDto.getLocAccountOpenReqSdDto().getCircleCode(),
							locActOpnReqHdrDto.getLocAccountOpenReqSdDto().getRemarks(),
							locActOpnReqHdrDto.getLocAccountOpenReqSdDto().getCircleName());
				}
				if (locAccountOpenReqWfRepository.findByTrnIdLcOpenReqHdrIdAndActiveStatus(hdrId,
						Constant.ACTIVE_STATUS) == null) {
					WfUserReqSDDto wfUserReqSDDto = locActOpnReqHdrDto.getWfUserReqSDDto();
					wfUserReqSDDto.setTrnId(null != hdrId ? hdrId : locAccountOpenReqHdrEntity.getLcOpenReqHdrId());
					callWorkflow(wfUserReqSDDto);
				}

			} else {
				locActOpnReqHdrDto.setErrorMessage("Division Already exists for Requesting Office");
			}

		} catch (CustomException e) {
			logg.error(e.getMessage());
		}
		return locActOpnReqHdrDto;
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

	@SuppressWarnings("unchecked")
	@Override
	public LocTreasuryDto getTreasuryByDistrictIdAndDepartmentId(LocTreasuryParamDto locTreasuryParamDto)
			throws CustomException {
		LocTreasuryDto locTreasuryDto = null;
		Map<String, Object> attributesMap = new HashedMap();
		attributesMap.put("districtId", locTreasuryParamDto.getDistrictId());
		try {
			locTreasuryDto = genericDao.executeSQLQuerySingle(LocDBConstants.getTreasuryByDistrictIdAndDepartmentId(),
					attributesMap, LocTreasuryDto.class);
		} catch (CustomException ex) {
			throwsExcetion(ex);
		}
		return locTreasuryDto;
	}

	@Override
	public LocAccOpenReqDtlDto getAccountOpenReqDtl(Long hdrId, int isEditable) {
		if (isEditable == Constant.ACTIVE_STATUS) {
			return sdRepo.getAccountOpenReqDtlByHdrIdAndActiveStatus(hdrId, Constant.ACTIVE_STATUS);
		} else {
			return dtlRepository.getAccountOpenReqDtlByHdrIdAndActiveStatus(hdrId, Constant.ACTIVE_STATUS);
		}
	}

	@Override
	public List<ClueDto> getMajorHead() throws CustomException {
		List<ClueDto> clueDtos = new ArrayList<>();
		List<LocMsMajorHeadEntity> locMsMajorHeadEntityFatch = msMajorHeadRepo.getMajorHeadesByDemandId(
				LocConstant.PURP_DEMAND_ID, LocConstant.PURP_MAJORHEAD_CODE, Constant.ACTIVE_STATUS);
		for (LocMsMajorHeadEntity locMsMajorHeadEntity : locMsMajorHeadEntityFatch) {
			ClueDto clueDto = new ClueDto();
			clueDto.setId(locMsMajorHeadEntity.getMajorHeadId());
			clueDto.setName(locMsMajorHeadEntity.getMajorHeadName());
			clueDto.setCode(locMsMajorHeadEntity.getMajorHeadCode());
			clueDto.setCodeName(locMsMajorHeadEntity.getMajorHeadCodeName());
			clueDto.setDescription(locMsMajorHeadEntity.getMajorHeadDesc());
			clueDtos.add(clueDto);
		}
		return clueDtos;
	}
	@Override
	public List<ClueDto> getSubMajorHead(LocMasterIdDto dto) throws CustomException {
		List<ClueDto> clueDtos = new ArrayList<>();
		List<LocMsSubMajorHeadEntity> locMsSubMajorHeadEntitys = msSubMajorHeadRepo
				.findByDemandIdAndMajorHeadEntityMajorHeadIdAndActiveStatusOrderBySubMajorHeadCode(
						LocConstant.PURP_DEMAND_ID, dto.getMajorHeadId(), Constant.ACTIVE_STATUS);
		for (LocMsSubMajorHeadEntity locMsSubMajorHeadEntity : locMsSubMajorHeadEntitys) {
			ClueDto clueDto = new ClueDto();
			clueDto.setId(locMsSubMajorHeadEntity.getSubMajorHeadId());
			clueDto.setName(locMsSubMajorHeadEntity.getSubmajorHeadName());
			clueDto.setCode(locMsSubMajorHeadEntity.getSubMajorHeadCode());
			clueDto.setCodeName(locMsSubMajorHeadEntity.getSubMajorHeadCodeNames());
			clueDto.setDescription(locMsSubMajorHeadEntity.getSubMajorHeadDesc());
			clueDtos.add(clueDto);
		}
		return clueDtos;
	}

	@Override
	public List<ClueDto> getMinorHead(LocMasterIdDto dto) throws CustomException {
		List<ClueDto> clueDtos = new ArrayList<>();
		List<LocMsMinorHeadEntity> locMsMinorHeadEntitys = msMinorHeadRepo
				.findByDemandIdAndMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndActiveStatusOrderByMinorHeadCode(
						LocConstant.PURP_DEMAND_ID, dto.getMajorHeadId(), dto.getSubMajorHeadId(),
						Constant.ACTIVE_STATUS);
		for (LocMsMinorHeadEntity locMsMinorHeadEntity : locMsMinorHeadEntitys) {
			ClueDto clueDto = new ClueDto();
			clueDto.setId(locMsMinorHeadEntity.getMinorHeadId());
			clueDto.setCode(locMsMinorHeadEntity.getMinorHeadCode());
			clueDto.setName(locMsMinorHeadEntity.getMinorHeadName());
			clueDto.setCodeName(locMsMinorHeadEntity.getMinorHeadCodeName());
			clueDto.setDescription(locMsMinorHeadEntity.getMinorHeadDesc());
			clueDtos.add(clueDto);
		}
		return clueDtos;
	}

	@Override
	public List<ClueDto> getSubHead(LocMasterIdDto dto) throws CustomException {
		List<ClueDto> clueDtos = new ArrayList<>();
		List<LocMsSubHeadEntity> locMsSubHeadEntitys = msSubHeadRepo
				.findByDemandIdAndMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadIdAndActiveStatusOrderBySubHeadCodeAsc(
						LocConstant.PURP_DEMAND_ID, dto.getMajorHeadId(), dto.getSubMajorHeadId(), dto.getMinorHeadId(),
						Constant.ACTIVE_STATUS);
		for (LocMsSubHeadEntity locMsSubHeadEntity : locMsSubHeadEntitys) {
			ClueDto clueDto = new ClueDto();
			clueDto.setId(locMsSubHeadEntity.getSubHeadId());
			clueDto.setName(locMsSubHeadEntity.getSubHeadName());
			clueDto.setCode(locMsSubHeadEntity.getSubHeadCode());
			clueDto.setCodeName(locMsSubHeadEntity.getSubHeadCodeName());
			clueDto.setDescription(locMsSubHeadEntity.getSubHeadDesc());
			clueDtos.add(clueDto);
		}
		return clueDtos;
	}

	@Override
	public List<ClueDto> getDetailHead(LocMasterIdDto dto) throws CustomException {
		List<ClueDto> clueDtos = new ArrayList<>();
		List<LocMsDetailHeadEntity> locMsDetailHeadEntitys = msDetailHeadRepo
				.findByDemandIdAndMajorHeadEntityMajorHeadIdAndSubMajorHeadEntitySubMajorHeadIdAndMinorHeadEntityMinorHeadIdAndSubHeadEntitySubHeadIdAndAndActiveStatusOrderByDetailHeadCode(
						LocConstant.PURP_DEMAND_ID, dto.getMajorHeadId(), dto.getSubMajorHeadId(), dto.getMinorHeadId(),
						dto.getSubHeadId(), Constant.ACTIVE_STATUS);
		for (LocMsDetailHeadEntity locMsDetailHeadEntity : locMsDetailHeadEntitys) {
			ClueDto clueDto = new ClueDto();
			clueDto.setId(locMsDetailHeadEntity.getDetailHeadId());
			clueDto.setName(locMsDetailHeadEntity.getDetailHeadName());
			clueDto.setCode(locMsDetailHeadEntity.getDetailHeadCode());
			clueDto.setCodeName(locMsDetailHeadEntity.getDetailHeadCodeName());
			clueDto.setDescription(locMsDetailHeadEntity.getDetailHeadDesc());
			clueDtos.add(clueDto);
		}
		return clueDtos;
	}

	@Override
	public LocAccountOpenReqAgSdDto createAgOfficeDetail(LocAccountOpenReqAgSdDto dto) throws CustomException {
		LocAccountOpenReqAgSdEntity locAccountOpenReqAgSdEntity = locAccOpenReqAgSdRepo
				.findByLcOpenReqHdrIdLcOpenReqHdrIdAndActiveStatus(dto.getLcOpenReqHdrId(), Constant.ACTIVE_STATUS);
		validateAGAuthDate(dto.getAgAuthorizationDt());
		if (null != locAccountOpenReqAgSdEntity) {
			dto.setLcOpenReqAgId(locAccountOpenReqAgSdEntity.getLcOpenReqAgId());
		}
		locAccountOpenReqAgSdEntity = locAccOpenReqAgSdRepo.save(locAccOpenReqAgSdCon.toEntity(dto));

		return locAccOpenReqAgSdCon.toDTO(locAccountOpenReqAgSdEntity);
	}

	private void validateAGAuthDate(Date agAuthorizationDt) throws CustomException {
		if (Objects.nonNull(agAuthorizationDt) && !LocUtility.validateFromDate(agAuthorizationDt)) {
			throw new CustomException(HttpStatus.CONFLICT, LocMessageConstant.LOC_CURRENT_DT_VALIDATION);
		}
	}

	@Override
	public LocAgReqDtlDto getAgOfficeDetail(Long hdrId, Integer isEditable) throws CustomException {
		if (isEditable == Constant.ACTIVE_STATUS) {

			List<Object[]> chqInvList = locAccOpenReqAgSdRepo.getEditViewData(hdrId, Constant.ACTIVE_STATUS);
			List<LocAgReqDtlDto> list = !chqInvList.isEmpty()
					? NativeQueryResultsMapper.map(chqInvList, LocAgReqDtlDto.class)
					: Collections.emptyList();
			if (!list.isEmpty()) {
				return list.get(0);
			} else {
				return new LocAgReqDtlDto();
			}

		} else {
			List<Object[]> chqInvList1 = locAccOpenReqAgDtlRepo.getEditViewData(hdrId, Constant.ACTIVE_STATUS);
			List<LocAgReqDtlDto> list = !chqInvList1.isEmpty()
					? NativeQueryResultsMapper.map(chqInvList1, LocAgReqDtlDto.class)
					: Collections.emptyList();
			if (!list.isEmpty()) {
				return list.get(0);
			} else {
				return new LocAgReqDtlDto();
			}

		}
	}

	@Override
	public LocOpenReqSubmitDto getLocOpenReqSubmitDetails(Long hdrId) throws CustomException {
		try {
			Map<String, Object> argsMap = new LinkedHashMap<>();
			argsMap.put(LocConstant.IN_LC_HDR_ID, hdrId);
			String procName = LocConstant.LOC_SCHEMA.concat(LocConstant.DOT)
					.concat(LocDBConstants.SP_LOC_OPEN_REQ_SUBMIT_TAB);
			List<Object[]> spObjects = hdrRepo.callStoredProcedure(procName, argsMap);
			List<LocOpenReqSubmitDto> historyDtoList = !spObjects.isEmpty()
					? NativeQueryResultsMapper.map(spObjects, LocOpenReqSubmitDto.class)
					: Collections.emptyList();
			if (!historyDtoList.isEmpty()) {
				return historyDtoList.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the argument map for get history details.
	 *
	 * @param pageDetails the page details
	 * @return the argument map for get history details
	 */
	private Map<String, Object> getArgumentMapForGetHistoryDetails(PageDetails pageDetails) {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_PAGE_INDEX, pageDetails.getPageIndex());
		argsMap.put(Constant.IN_PAGE_SIZE, pageDetails.getPageElement());
		List<SearchParam> searchParams = pageDetails.getJsonArr();
		searchParams.forEach(searchParam -> argsMap
				.put(LocConstant.getOpenReqHisSearchParam().get(searchParam.getKey()), searchParam.getValue()));
		return argsMap;
	}

	@Override
	public PagebleDTO<LocOpenReqViewDto> getLocOpenReqViewDetails(PageDetails pageDetails) throws CustomException {
		try {
			Map<String, Object> map = getArgumentMapForGetHistoryDetails(pageDetails);
			String procName = LocConstant.LOC_SCHEMA.concat(LocConstant.DOT)
					.concat(LocDBConstants.LOC_OPEN_REQ_VIEW_HISTORY);
			List<LocOpenReqViewDto> historyDtoList = this.callStoreProc(procName, map, LocOpenReqViewDto.class);
			Long totalPages = (long) (!historyDtoList.isEmpty() ? (historyDtoList.get(0).getRecordCount())
					: historyDtoList.size());
			return new PagebleDTO<>(pageDetails.getPageElement(), 0, totalPages, historyDtoList);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<LocOpenReqAgViewDto> getLocOpenReqAgViewDetails(PageDetails pageDetails) throws CustomException {
		try {
			Map<String, Object> map = getArgumentMapForGetHistoryDetails(pageDetails);
			String procName = LocConstant.LOC_SCHEMA.concat(LocConstant.DOT)
					.concat(LocDBConstants.LOC_OPEN_REQ_AG_VIEW_HISTORY);
			List<LocOpenReqAgViewDto> historyDtoList = this.callStoreProc(procName, map, LocOpenReqAgViewDto.class);
			Long totalPages = (long) (!historyDtoList.isEmpty() ? (historyDtoList.get(0).getRecordCount())
					: historyDtoList.size());
			return new PagebleDTO<>(pageDetails.getPageElement(), 0, totalPages, historyDtoList);

		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	@Override
	public PagebleDTO<LocOpenReqBankViewDto> getLocOpenReqBankViewDetails(PageDetails pageDetails)
			throws CustomException {
		try {
			Map<String, Object> map = getArgumentMapForGetHistoryDetails(pageDetails);
			String procName = LocConstant.LOC_SCHEMA.concat(LocConstant.DOT)
					.concat(LocDBConstants.LOC_OPEN_REQ_BANK_VIEW_HISTORY);
			List<LocOpenReqBankViewDto> historyDtoList = this.callStoreProc(procName, map, LocOpenReqBankViewDto.class);
			Long totalPages = (long) (!historyDtoList.isEmpty() ? (historyDtoList.get(0).getRecordCount())
					: historyDtoList.size());
			return new PagebleDTO<>(pageDetails.getPageElement(), 0, totalPages, historyDtoList);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public PagebleDTO<LocOpenReqDiviViewDto> getLocOpenReqDiviViewDetails(PageDetails pageDetails)
			throws CustomException {
		try {
			Map<String, Object> map = getArgumentMapForGetHistoryDetails(pageDetails);
			String procName = LocConstant.LOC_SCHEMA.concat(LocConstant.DOT)
					.concat(LocDBConstants.LOC_OPEN_REQ_DIVI_VIEW_HISTORY);
			List<LocOpenReqDiviViewDto> historyDtoList = this.callStoreProc(procName, map, LocOpenReqDiviViewDto.class);
			Long totalPages = (long) (!historyDtoList.isEmpty() ? (historyDtoList.get(0).getRecordCount())
					: historyDtoList.size());
			return new PagebleDTO<>(pageDetails.getPageElement(), 0, totalPages, historyDtoList);
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public void submitData(LocSubmitWfDto submitWfDto) throws CustomException {
		try {
			Map<String, Object> argsMap = new LinkedHashMap<>();
			argsMap.put(LocConstant.IN_LC_HDR_ID, submitWfDto.getTrnId());
			setSubmitDataStatus(submitWfDto.getTrnStatus(), argsMap);
			argsMap.put(Constant.IN_WORKFLOW_ID, submitWfDto.getWfId());
			argsMap.put(Constant.IN_WF_ROLE_ID, submitWfDto.getAssignByWfRoleId());

			argsMap.put(Constant.IN_UPDATED_BY, OAuthUtility.getCurrentUserUserId());
			argsMap.put(Constant.IN_UPDATED_BY_POST, OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());
			String procName = LocConstant.LOC_SCHEMA.concat(LocConstant.DOT)
					.concat(LocDBConstants.LOC_OPEN_REQ_SUBMIT_DATA);
			this.hdrRepo.callStoredProcedureWithNoResult(procName, argsMap);

			submitProc(submitWfDto);

		} catch (Exception e) {
			logg.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CALL_SP);
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

	/**
	 * Submit proc.
	 *
	 * @param submitWfDto the submit wf dto
	 */
	@Async
	private void submitProc(LocSubmitWfDto submitWfDto) {
		try {
			logg.info("Enter Asyn Loc Open Request submit procedure calling");
			if (Boolean.TRUE.equals(submitWfDto.getIsAg())) {
				submitProcTabWise(submitWfDto, LocDBConstants.LOC_OPEN_REQ_AG_SUBMIT_DATA);
			} else if (Boolean.TRUE.equals(submitWfDto.getIsTo())) {
				submitProcTabWise(submitWfDto, LocDBConstants.LOC_OPEN_REQ_DIVI_SUBMIT_DATA);
			} else {
				submitProcTabWise(submitWfDto, LocDBConstants.LOC_OPEN_REQ_BANK_SUBMIT_DATA);
			}
			saveDivisionDetails(submitWfDto);
			boolean isAuthorized = submitWfDto.getTrnStatus().equals(LocConstant.AUTHORIZED);
			if (isAuthorized && Boolean.TRUE.equals(submitWfDto.getIsDat())) {
				this.insertMsCircle(submitWfDto.getTrnId());
				submitOPenReqestDivsionInsertionProc(submitWfDto, LocDBConstants.SP_LOC_OPEN_REQ_DIVISION_INSERT);
				submitProcTabWise(submitWfDto, LocDBConstants.SP_LOC_OPEN_REQ_HDR_SUBMIT);// submitOpenRequestProc

			}
			if (submitWfDto.getWfActionId().equals(LocConstant.APPROVED_ACTION)) {
				notificationService.sendNotification(submitWfDto);

			}
			logg.info("Exit Asyn Loc Open Request submit procedure calling");
		} catch (Exception e) {
			logg.error(e.getMessage(), e);
		}
	}

	/**
	 * Submit O pen reqest divsion insertion proc.
	 *
	 * @param submitWfDto the submit wf dto
	 * @param procNameIn  the proc name in
	 * @throws CustomException the custom exception
	 */
	private void submitOPenReqestDivsionInsertionProc(LocSubmitWfDto submitWfDto, String procNameIn)
			throws CustomException {
		try {
			Map<String, Object> argsMap = new LinkedHashMap<>();

			argsMap.put(LocConstant.IN_LC_HDR_ID, submitWfDto.getTrnId());
			String procName = LocConstant.LOC_SCHEMA.concat(LocConstant.DOT).concat(procNameIn);

			this.hdrRepo.callStoredProcedureWithNoResult(procName, argsMap);
		} catch (Exception e) {
			logg.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CALL_SP);
		}
	}

	/**
	 * Divi submit proc.
	 *
	 * @param submitWfDto the submit wf dto
	 * @param procNameIn  the proc name in
	 * @throws CustomException the custom exception
	 */
	private void submitProcTabWise(LocSubmitWfDto submitWfDto, String procNameIn) throws CustomException {
		try {
			Map<String, Object> argsMap = new LinkedHashMap<>();
			argsMap.put(LocConstant.IN_LC_HDR_ID, submitWfDto.getTrnId());
			setSubmitDataStatus(submitWfDto.getTrnStatus(), argsMap);
			argsMap.put(Constant.IN_WORKFLOW_ID, submitWfDto.getWfId());
			argsMap.put(Constant.IN_WF_ROLE_ID, submitWfDto.getAssignByWfRoleId());

			argsMap.put(Constant.IN_UPDATED_BY, OAuthUtility.getCurrentUserUserId());
			argsMap.put(Constant.IN_UPDATED_BY_POST, OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());

			String procName = LocConstant.LOC_SCHEMA.concat(LocConstant.DOT).concat(procNameIn);
			this.hdrRepo.callStoredProcedureWithNoResult(procName, argsMap);
		} catch (Exception e) {
			logg.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CALL_SP);
		}
	}

	@Override
	public PagebleDTO<LocOpenReqListDto> getOpenListingData(PageDetails pageDetail) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(
					search -> map.put(LocDBConstants.getLocOpenReqListing().get(search.getKey()), search.getValue()));
		} else {
			LocDBConstants.getLocOpenReqListing()
					.forEach((k, v) -> map.put(LocDBConstants.getLocOpenReqListing().get(k), 0));
		}
		String procName = LocDBConstants.LOC_SCHEMA
				.concat(Constant.DOT.concat(LocDBConstants.SP_LOC_OPEN_REQ_LISTING_DATA));
		List<LocOpenReqListDto> objectSp = this.callStoreProc(procName, map, LocOpenReqListDto.class);
		Long totalPages = !objectSp.isEmpty() ? objectSp.get(0).getRecordCount() : objectSp.size();
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
	public LocOpenListingParamDto getRequestParam() throws CustomException {
		List<Object[]> paramList = hdrRepo.getOpenReqSrchPrm();
		List<LocOpenListingParamDto> resultList = !paramList.isEmpty()
				? NativeQueryResultsMapper.map(paramList, LocOpenListingParamDto.class)
				: Collections.emptyList();
		LocOpenListingParamDto srchPram = new LocOpenListingParamDto();

		srchPram.setWfList(resultList.stream()
				.filter(distinctByKeys( LocOpenListingParamDto::getWfName))
				.filter(e -> e.getWfId() != null).map(e -> {
					LocOpenListingParamDto wf = new LocOpenListingParamDto();
					wf.setWfId(e.getWfId());
					wf.setWfName(e.getWfName());
					return wf;
				}).collect(Collectors.toList()));

		srchPram.setStatusList(resultList.stream()
				.filter(distinctByKeys(LocOpenListingParamDto::getStatusId, LocOpenListingParamDto::getStatusName))
				.filter(f -> f.getStatusId() != null).map(e -> {
					LocOpenListingParamDto status = new LocOpenListingParamDto();
					status.setStatusId(e.getStatusId());
					status.setStatusName(e.getStatusName());
					return status;
				}).collect(Collectors.toList()));

		srchPram.setOfficeList(resultList.stream()
				.filter(distinctByKeys(LocOpenListingParamDto::getOfficeId, LocOpenListingParamDto::getOfficeName))
				.filter(e -> e.getOfficeId() != null).map(e -> {
					LocOpenListingParamDto status = new LocOpenListingParamDto();
					status.setOfficeId(e.getOfficeId());
					status.setOfficeName(e.getOfficeName());
					return status;
				}).collect(Collectors.toList()));

		srchPram.setDeptList(resultList.stream()
				.filter(distinctByKeys(LocOpenListingParamDto::getDeptId, LocOpenListingParamDto::getDeptName))
				.filter(e -> e.getDeptId() != null).map(e -> {
					LocOpenListingParamDto dept = new LocOpenListingParamDto();
					dept.setDeptId(e.getDeptId());
					dept.setDeptName(e.getDeptName());
					return dept;
				}).collect(Collectors.toList()));

		srchPram.setDistrictList(resultList.stream()
				.filter(distinctByKeys(LocOpenListingParamDto::getDistrictId, LocOpenListingParamDto::getDistrictName))
				.filter(e -> e.getDistrictId() != null).map(e -> {
					LocOpenListingParamDto dist = new LocOpenListingParamDto();
					dist.setDistrictId(e.getDistrictId());
					dist.setDistrictName(e.getDistrictName());
					return dist;
				}).collect(Collectors.toList()));

		srchPram.setCircleNameList(resultList.stream()
				.filter(distinctByKeys(LocOpenListingParamDto::getCircleId, LocOpenListingParamDto::getCircleName))
				.filter(e -> e.getCircleId() != null).map(e -> {
					LocOpenListingParamDto circleName = new LocOpenListingParamDto();
					circleName.setCircleId(e.getCircleId());
					circleName.setCircleName(e.getCircleName());
					return circleName;
				}).collect(Collectors.toList()));

		srchPram.setCircleCodeList(resultList.stream()
				.filter(distinctByKeys(LocOpenListingParamDto::getCircleId, LocOpenListingParamDto::getCircleCode))
				.filter(e -> e.getCircleId() != null).map(e -> {
					LocOpenListingParamDto circleCode = new LocOpenListingParamDto();
					circleCode.setCircleId(e.getCircleId());
					circleCode.setCircleCode(e.getCircleCode());
					return circleCode;
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
	public Boolean validateAgOfficeDetail(LocAccountOpenReqAgDtlDto dto) throws CustomException {
		LocAccountOpenReqAgSdEntity locAccountOpenReqAgSdEntity = locAccOpenReqAgSdRepo
				.findByLcOpenReqHdrIdLcOpenReqHdrIdAndActiveStatus(dto.getLcOpenReqHdrId(), Constant.ACTIVE_STATUS);
		return locAccountOpenReqAgSdEntity != null;
	}

	@Override
	public LocBankDetailsDto getAllBankDetails(IdDto dto) throws CustomException {

		List<Object[]> paramList = hdrRepo.getBankDetails(dto.getId(), Constant.ACTIVE_STATUS);
		List<LocBankDetailsDto> resultList = !paramList.isEmpty()
				? NativeQueryResultsMapper.map(paramList, LocBankDetailsDto.class)
				: Collections.emptyList();
		LocBankDetailsDto result = new LocBankDetailsDto();
		result.setBankBranchList(resultList.stream().filter(distinctByKeys(LocBankDetailsDto::getBankId)).map(e -> {
			LocBankDetailsDto bankList = new LocBankDetailsDto();
			bankList.setBankId(e.getBankId());
			bankList.setBankName(e.getBankName());
			bankList.setBankBranchList(
					resultList
							.stream().filter(distinctByKeys(LocBankDetailsDto::getBankId,
									LocBankDetailsDto::getBankBranchId, LocBankDetailsDto::getBankBranchName))
							.map(f -> {
								LocBankDetailsDto branchList = new LocBankDetailsDto();
								branchList.setBankBranchId(f.getBankBranchId());
								branchList.setBankBranchName(f.getBankBranchName());
								branchList.setBankBranchCode(f.getBankBranchCode());
								return branchList;
							}).collect(Collectors.toList()));
			return bankList;
		}).collect(Collectors.toList()));

		return result;
	}

	@Override
	public LocAccountOpenReqBankSdDto createBankOfficeDetail(LocAccountOpenReqBankSdDto dto) throws CustomException {
		LocAccountOpenReqBankSdEntity locAccountOpenReqBankSdEntity = null;
		locAccountOpenReqBankSdEntity = locAccountOpenReqBankSdRepository
				.findByLcOpenReqHdrIdLcOpenReqHdrIdAndActiveStatus(dto.getLcOpenReqHdrId(), dto.getActiveStatus());
		if (null == locAccountOpenReqBankSdEntity) {
			locAccountOpenReqBankSdEntity = locAccountOpenReqBankSdRepository
					.save(locAccountOpenReqBankSdConverter.toEntity(dto));
			return locAccountOpenReqBankSdConverter.toDTO(locAccountOpenReqBankSdEntity);
		} else {
			dto.setLcOpenReqBankSdId(locAccountOpenReqBankSdEntity.getLcOpenReqBankSdId());
			locAccountOpenReqBankSdRepository.updateAccountOpenReqBankSd(dto.getLcOpenReqHdrId(), dto.getActiveStatus(),
					dto.getBankCode(), dto.getBankBranchId(), dto.getBankRemarks());
			return dto;
		}
	}

	@Override
	public LocBankReqDtlDto getBankOfficeDetail(Long hdrId, Integer isEditable) throws CustomException {
		LocBankReqDtlDto bankReqDtlDto = null;
		if (isEditable == Constant.ACTIVE_STATUS) {
			bankReqDtlDto = locAccountOpenReqBankSdRepository.getBankReqDtlByHdrIdAndActiveStatus(hdrId,
					Constant.ACTIVE_STATUS);
		} else {
			bankReqDtlDto = locAccOpenreqBankRepo.getBankReqDtlByHdrIdAndActiveStatus(hdrId, Constant.ACTIVE_STATUS);
		}
		return bankReqDtlDto;
	}

	@Override
	public LocAccountOpenReqDivisionSdDto createDivisionOfficeDetail(LocAccountOpenReqDivisionSdDto dto)
			throws CustomException {
		if (null != dto.getDivisionCd() && !dto.getDivisionCd().isEmpty()) {
			Object id = hdrRepo.getDivCdFromLocSd(dto.getLcOpenReqHdrId(), dto.getDivisionCd(), Constant.ACTIVE_STATUS);

			if (id != null && !dto.getLcOpenReqHdrId().equals(Long.parseLong(id.toString()))
					|| null != hdrRepo.getDivCdFromMsDiv(dto.getLcOpenReqHdrId(), dto.getDivisionCd(),
							Constant.ACTIVE_STATUS)
					|| null != hdrRepo.checkCircleCode(dto.getDivisionCd(), dto.getActiveStatus())) {
				throw new CustomException(ErrorResponse.RECORD_ALREADY_EXISTS);
			}
		}

		LocAccountOpenReqDivisionSdEntity locAccountOpenReqDivisionSdEntity = null;
		locAccountOpenReqDivisionSdEntity = locAccountOpenReqDivisionSdRepository
				.findByLcOpenReqHdrIdLcOpenReqHdrIdAndActiveStatus(dto.getLcOpenReqHdrId(), dto.getActiveStatus());
		if (null == locAccountOpenReqDivisionSdEntity) {
			locAccountOpenReqDivisionSdEntity = locAccountOpenReqDivisionSdRepository
					.save(locAccountOpenReqDivisionSdConverter.toEntity(dto));
			return locAccountOpenReqDivisionSdConverter.toDTO(locAccountOpenReqDivisionSdEntity);
		} else {
			dto.setLcOpenReqDiviSdId(locAccountOpenReqDivisionSdEntity.getLcOpenReqDiviSdId());
			locAccountOpenReqDivisionSdRepository.updateAccountOpenReqDiviSd(dto.getLcOpenReqHdrId(),
					dto.getActiveStatus(), dto.getDivisionCd(), dto.getDivisionRemarks());
			return dto;
		}
	}

	@Override
	public LocDiviReqDtlDto getDivisionOfficeDetail(Long hdrId, Integer isEditable) {
		LocDiviReqDtlDto dto = null;
		if (isEditable == Constant.ACTIVE_STATUS) {
			dto = locAccountOpenReqDivisionSdRepository.getDiviReqDtlByHdrIdAndActiveStatus(hdrId,
					Constant.ACTIVE_STATUS);
		} else {
			dto = locAccOpenreqDiviRepo.getDiviReqDtlByHdrIdAndActiveStatus(hdrId, Constant.ACTIVE_STATUS);
		}
		return dto;
	}

	/**
	 * Save division details.
	 *
	 * @param submitWfDto the submit wf dto
	 */
	private void saveDivisionDetails(LocSubmitWfDto submitWfDto) {
		hdrRepo.getOne(submitWfDto.getTrnId());

	}

	@Override
	public int getDivisionValidation(LocAccountOpenReqHdrDto locActOpnReqHdrDto) throws CustomException {
		if (null != this.trnExistCheck(locActOpnReqHdrDto)) {
			return Constant.INT_ONE_VALUE;
		} else {
			return Constant.OUTWARD_FLAG_ZERO;
		}

	}

	@Override
	public List<LocCircleDto> getCircleByDepartment(Long id) throws CustomException {
		List<Object[]> circleList = hdrRepo.getCircleByDepartmentId(id, Constant.ACTIVE_STATUS);
		List<LocCircleDto> circleDtoList = !circleList.isEmpty()
				? NativeQueryResultsMapper.map(circleList, LocCircleDto.class)
				: Collections.emptyList();
		for (LocIdNameDto idNameDto : this.getLookupIdName(LocConstant.LOC_CIRCLE_OTHERS)) {
			circleDtoList.add(new LocCircleDto(idNameDto.getId(), idNameDto.getName()));
		}
		return circleDtoList;
	}

	@Override
	public IdDto deleteById(IdDto dto) throws CustomException {
		hdrRepo.softDeleteById(dto.getId());
		return dto;
	}

	/**
	 * Gets the lookup id name.
	 *
	 * @param parentLookupId the parent lookup id
	 * @return the lookup id name
	 * @throws CustomException the custom exception
	 */
	private List<LocIdNameDto> getLookupIdName(Long parentLookupId) throws CustomException {
		List<Object[]> paramList = chqBookHdrRepo.getLookupIdandName(parentLookupId, Constant.ACTIVE_STATUS);
		return !paramList.isEmpty() ? NativeQueryResultsMapper.map(paramList, LocIdNameDto.class)
				: Collections.emptyList();
	}

	/**
	 * Throws excetion.
	 *
	 * @param ex the ex
	 * @throws CustomException the custom exception
	 */
	private void throwsExcetion(Exception ex) throws CustomException {
		logg.error(ex.toString());
		throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
	}


	/**
	 * Gen auth letter.
	 *
	 * @param id the id
	 * @return the map
	 * @throws CustomException the custom exception
	 */
	public Map<String, Object> genAuthLetter(IdDto id) throws CustomException {
		LocAccOpenReqDtlDto entity = dtlRepository.getAccountOpenReqDtlByHdrIdAndActiveStatus(id.getId(),
				Constant.ACTIVE_STATUS);
		List<Object[]> chqInvList1 = locAccOpenReqAgDtlRepo.getEditViewData(id.getId(), Constant.ACTIVE_STATUS);
		List<LocAgReqDtlDto> list = !chqInvList1.isEmpty()
				? NativeQueryResultsMapper.map(chqInvList1, LocAgReqDtlDto.class)
				: Collections.emptyList();


		return genAuthLetterPDF(entity, list.get(0));
	}

	/**
	 * Gen auth letter PDF.
	 *
	 * @param hdrDtlDto the hdr dtl dto
	 * @param agDtlDto  the ag dtl dto
	 * @return the map
	 */
	private Map<String, Object> genAuthLetterPDF(LocAccOpenReqDtlDto hdrDtlDto, LocAgReqDtlDto agDtlDto) {
		Map<String, Object> inputMap = null;
		Map<String, Object> resultMap = null;
		inputMap = new HashMap<>();
		inputMap.put("header", hdrDtlDto);
		inputMap.put("agOffcDtl", agDtlDto);
		inputMap.put("currDate", new Date());
		resultMap = new HashMap<>();
		resultMap.put("base64String", pdfService.generatePDF(LocURLConstant.AUTH_LETTER_FTL_FILE, inputMap,
				LocConstant.AUTH_LETTER_PDF_FILE_NAME + hdrDtlDto.getRefNo()));
		resultMap.put("fileName", LocConstant.AUTH_LETTER_PDF_FILE_NAME + "" + hdrDtlDto.getRefNo());
		return resultMap;
	}

	/**
	 * Trn exist check.
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws CustomException the custom exception
	 */
	private Long trnExistCheck(LocAccountOpenReqHdrDto dto) throws CustomException {
		List<Long> hdrIdList = hdrRepo.getExistTrnId(dto.getDepartmentId(), dto.getDistrictId(), dto.getHodId(),
				dto.getToOfficeId(), Constant.ACTIVE_STATUS, Constant.CANCELLED_LOOKUP_NAME,
				Constant.REJECTED_LOOKUP_NAME,LocConstant.APPROVED_BY_DAT);
		hdrIdList.remove(null);
		return hdrIdList.isEmpty() ? null : hdrIdList.get(0);
	}
	/**
	 * Insert ms circle.
	 *
	 * @param hdrId the hdr id
	 */
	private void insertMsCircle(Long hdrId) {

		LocMsCircleDto circleDto = new LocMsCircleDto();
		List<Object[]> circleData = hdrRepo.getCircleNameCode(hdrId, Constant.ACTIVE_STATUS);
		if(null!=circleData.get(0)[0]) {
		circleDto.setCircleName(circleData.get(0)[0].toString());
		circleDto.setCircleCd(circleData.get(0)[1].toString());
			LocMsCircleEntity circleEntity = circleRepo.save(circleConvertor.toEntity(circleDto));
				dtlRepository.updateCircleId(hdrId,circleEntity.getId(), Constant.ACTIVE_STATUS);
		}

	}

}
