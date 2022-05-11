package gov.ifms.edp.service;


import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPLuLookUpInfoConverter;
import gov.ifms.edp.converter.EDPMsBranchConverter;
import gov.ifms.edp.converter.EDPTedpBrCrDtlItrConverter;
import gov.ifms.edp.converter.EDPTedpBrHdrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPBrDtlDto;
import gov.ifms.edp.dto.EDPBranchCrViewDto;
import gov.ifms.edp.dto.EDPEmployeePostView;
import gov.ifms.edp.dto.EDPMsBranchDto;
import gov.ifms.edp.dto.EDPTedpBrDtlDto;
import gov.ifms.edp.dto.EDPTedpBrHdrDto;
import gov.ifms.edp.dto.EDPUsrBrMapSearchView;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsBranchEntity;
import gov.ifms.edp.entity.EDPTedpBrCrDtlEntity;
import gov.ifms.edp.entity.EDPTedpBrCrDtlItrEntity;
import gov.ifms.edp.entity.EDPTedpBrDtlEntity;
import gov.ifms.edp.entity.EDPTedpBrHdrEntity;
import gov.ifms.edp.entity.EDPTrnPouBrMapEntity;
import gov.ifms.edp.entity.EDPTrnPouBrMapItrEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsBranchRepository;
import gov.ifms.edp.repository.EDPTedpBrCrDtlItrRepository;
import gov.ifms.edp.repository.EDPTedpBrCrDtlRepository;
import gov.ifms.edp.repository.EDPTedpBrDtlRepository;
import gov.ifms.edp.repository.EDPTedpBrHdrRepository;
import gov.ifms.edp.repository.EDPTrnPouBrMapItrRepository;
import gov.ifms.edp.repository.EDPTrnPouBrMapRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPMsBranchServiceImpl.
 */
@Service
public class EDPMsBranchServiceImpl implements EDPMsBranchService{

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	/** The repository. */
	@Autowired
	private EDPMsBranchRepository repository;
	
	/** The converter. */
	@Autowired
	private EDPMsBranchConverter converter;
	
	/** The edp tedp br hdr converter. */
	@Autowired
	private EDPTedpBrHdrConverter edpTedpBrHdrConverter;
	
	/** The lookup info service. */
	@Autowired
	private EDPLuLookUpInfoService lookupInfoService;
	
	/** The lookupinfoconverter. */
	@Autowired
	private EDPLuLookUpInfoConverter lookupinfoconverter;
	
	/** The edp tedp br hdr repository. */
	@Autowired
	private EDPTedpBrHdrRepository edpTedpBrHdrRepository;
	
	/** The edp tedp br cr dtl repository. */
	@Autowired
	private EDPTedpBrCrDtlRepository edpTedpBrCrDtlRepository; 

	/** The edp tedp br cr dtl itr repository. */
	@Autowired
	private EDPTedpBrCrDtlItrRepository edpTedpBrCrDtlItrRepository; 
	
	/** The EDP tedp br cr dtl itr converter. */
	@Autowired
	private EDPTedpBrCrDtlItrConverter edpTedpBrCrDtlItrConverter;

	@Autowired
	private EDPTedpBrDtlRepository edpTedpBrDtlRepository;
	
	/**
	 * Gets the branch listby branch type.
	 *
	 * @param branchTypeId the branch type id
	 * @return the branch listby branch type
	 */

	@Autowired
	private EDPLuLookUpInfoRepository edpLuLookupInfoRepository;

	@Autowired
	private EDPTrnPouBrMapRepository edpTrnPouBrMapRepository;

	@Autowired
	private EDPTrnPouBrMapItrRepository edpTrnPouBrMapItrRepository;

	@Autowired
	private EDPLkPoOffUserRepository edpLkPoOffUserRepository;
	
	@Override
	public List<EDPMsBranchEntity> getBranchListbyBranchType(Long branchTypeId) {
		return repository.findByBranchTypeIdLookUpInfoIdAndActiveStatus(branchTypeId, EDPConstant.ACTIVE_STATUS_TRUE);
	}

	/**
	 * Find all active branches.
	 *
	 * @return the list
	 */
	@Override
	public List<EDPMsBranchDto> findAllActiveBranches() {
		return converter.toDTO(repository.findByActiveStatus(Constant.ACTIVE_STATUS));
	}

	/**
	 * Gets the branch data.
	 *
	 * @return the branch data
	 */
	@Override
	public List<ClueDto> getBranchData() {
		return getAllBranchType();
	}
	
	/**
	 * Gets the all branch type.
	 *
	 * @return the all branch type
	 */
	private List<ClueDto> getAllBranchType() {
		return lookupinfoconverter.toClueDTO(lookupInfoService
				.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(EDPConstant.LOOKUP_BRANCH_TYPE_ID));
	}

	/**
	 * Save branch.
	 *
	 * @param hdrDto the hdr dto
	 * @return the EDP tedp br hdr dto
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public EDPTedpBrHdrDto saveBranch(EDPTedpBrHdrDto hdrDto) throws CustomException {
		validateRequest(hdrDto);
		hdrEntityDataStore(hdrDto);
		EDPTedpBrCrDtlEntity dtlEntity = edpTedpBrCrDtlRepository.findByTedpBrHdrIdTedpBrHdrIdAndActiveStatus(hdrDto.getTedpBrHdrId(),Constant.ACTIVE_STATUS);
		if(null == dtlEntity) {
			dtlEntity = edpTedpBrHdrConverter.hdrDtoToBrCrDtlEntity(hdrDto);
			saveDtlEntity(hdrDto, dtlEntity);
		} else {
			if(!dtlEntity.getBranchName().equals(hdrDto.getBranchName()) || 
					dtlEntity.getBranchTypeId().getLookUpInfoId() != hdrDto.getBranchType().longValue()) {
				dtlEntity.setBranchName(hdrDto.getBranchName());
				dtlEntity.setBranchTypeId(new EDPLuLookUpInfoEntity(hdrDto.getBranchType()));
				saveDtlEntity(hdrDto, dtlEntity);
			}
		}
		if(hdrDto.getFormAction().equals(Status.SUBMITTED)) {
			submiteBranch(hdrDto,dtlEntity);
		}
		return hdrDto;
	}

	private void saveDtlEntity(EDPTedpBrHdrDto hdrDto, EDPTedpBrCrDtlEntity dtlEntity) {
		dtlEntity = edpTedpBrCrDtlRepository.save(dtlEntity);
		EDPTedpBrCrDtlItrEntity itrEntity = edpTedpBrCrDtlItrConverter.dtlEntityToItrEntity(hdrDto,dtlEntity);
		edpTedpBrCrDtlItrRepository.save(itrEntity);
	}

	/**
	 * Validate request.
	 * @param hdrDto 
	 * @throws CustomException 
	 */
	private void validateRequest(EDPTedpBrHdrDto hdrDto) throws CustomException {
	  List<Object[]> branchList= repository.getBranchAndBranchTypeByOfficeId(hdrDto.getOfficeId(),Constant.ACTIVE_STATUS);
	  checkBudgetBranchIsCreatedInOffice(hdrDto, branchList);
	  checkRequestInBranchMaster(hdrDto, branchList);
	  checkRequestInHdrAndDtlTbl(hdrDto);
	}

	/**
	 * Check request in branch master.
	 *
	 * @param branch the branch
	 * @throws CustomException 
	 */
	private void checkRequestInBranchMaster(EDPTedpBrHdrDto hdrDto,List<Object[]> branchList) throws CustomException {
		for(Object[] branch : branchList) {
			String branchName = EDPUtility.convertObjectToString(branch[0]);
			Long branchId = EDPUtility.convertObjectToLong(branch[3]);
			if(hdrDto.getBranchName().equals(branchName) && (null == hdrDto.getBranchId() || 
					!branchId.equals(hdrDto.getBranchId()))) {
				 throw new CustomException(10096,MessageFormat.format(MsgConstant.EDP_BRANCH_ALREADY_EXISTS,hdrDto.getBranchName()));
			}
		}
	}

	/**
	 * Check request.
	 *
	 * @param hdrDto the hdr dto
	 * @param branch the branch
	 * @throws CustomException the custom exception
	 */
	private void checkRequestInHdrAndDtlTbl(EDPTedpBrHdrDto hdrDto) throws CustomException {
		  List<Object[]> dataList = edpTedpBrCrDtlRepository.getBranchDataFromOfficeAndBranchTypeAndBranchName(Constant.SAVE_AS_DRAFT_STATUS_ID,Constant.ACTIVE_STATUS,
				  hdrDto.getOfficeId(),hdrDto.getBranchName(),EDPConstant.LOOKUP_BRANCH_CREATION_REQUEST_TYPE);
		  if(!CollectionUtils.isEmpty(dataList)) {
			  if(null == hdrDto.getTedpBrHdrId()){
				  throw new CustomException(10096,MessageFormat.format(MsgConstant.EDP_BRANCH_REQUEST_ALREADY_EXISTS,hdrDto.getBranchName()));
			  } else {
				  if(dataList.size()>1) {
					  throw new CustomException(10096,MessageFormat.format(MsgConstant.EDP_BRANCH_REQUEST_ALREADY_EXISTS,hdrDto.getBranchName()));
				  } else {
					  Long hdrId = EDPUtility.convertObjectToLong(dataList.get(0)[4]);
					  if(!hdrDto.getTedpBrHdrId().equals(hdrId)) {
						  throw new CustomException(10096,MessageFormat.format(MsgConstant.EDP_BRANCH_REQUEST_ALREADY_EXISTS,hdrDto.getBranchName()));
					  }
				  }
			  }
		  }
	}

	/**
	 * Check budget branch is created in office.
	 *
	 * @param hdrDto the hdr dto
	 * @param branch the branch
	 * @throws CustomException the custom exception
	 */
	private void checkBudgetBranchIsCreatedInOffice(EDPTedpBrHdrDto hdrDto, List<Object[]> branchList)
			throws CustomException {
		if(EDPConstant.LOOKUP_INFO_BUDGET_BRANCH_ID.equals(hdrDto.getBranchType())){
			 Optional<Object[]> budgetBranchPresent = branchList.stream().filter(obj-> null != obj[1] &&  
					    EDPConstant.LOOKUP_INFO_BUDGET_BRANCH_ID.equals(EDPUtility.convertObjectToLong(obj[1]))).findFirst();
			 if((budgetBranchPresent.isPresent())
					 && ((null == hdrDto.getBranchId()) || (null != hdrDto.getBranchId() 
						 && !hdrDto.getBranchId().equals(EDPUtility.convertObjectToLong(budgetBranchPresent.get()[3])))))
					 throw new CustomException(ErrorResponse.ERROR_EDP_BRANCH_BUDGET_ALREADY_EXISTS);
		}
	}

	
	/**
	 * Hdr entity data store.
	 *
	 * @param hdrDto the hdr dto
	 */
	private void hdrEntityDataStore(EDPTedpBrHdrDto hdrDto) {
		if(null == hdrDto.getTedpBrHdrId()) {
		   saveHdrEntity(hdrDto);
		} else if(null != hdrDto.getTedpBrHdrId() && hdrDto.getFormAction() == Status.SUBMITTED) {
			updateHdrStatus(hdrDto.getTedpBrHdrId());
		} else {
			updateHdrUpdatedDate(hdrDto.getTedpBrHdrId());
		}
	}

	/**
	 * Save hdr entity.
	 *
	 * @param hdrDto the hdr dto
	 */
	private void saveHdrEntity(EDPTedpBrHdrDto hdrDto) {
		EDPTedpBrHdrEntity hdrEntity = edpTedpBrHdrConverter.hdrDtoToHdrEntity(hdrDto);
		hdrEntity.setTrnNo(repository.generateTrnNo(Constant.EDP_SCHEMA, EDPConstant.SP_GET_EDP_TRN_NO_GEN, hdrDto.getMenuCode()));
		hdrEntity = edpTedpBrHdrRepository.save(hdrEntity);
		hdrDto.setTedpBrHdrId(hdrEntity.getTedpBrHdrId());
		hdrDto.setTrnNo(hdrEntity.getTrnNo());
		hdrDto.setCreatedDate(hdrEntity.getCreatedDate());
		hdrDto.setStatusId(hdrEntity.getStatusId().getLookUpInfoId());
	}
	
	/**
	 * Update hdr status.
	 *
	 * @param hdrDto the hdr dto
	 */
	private void updateHdrStatus(Long hdrId) {
		edpTedpBrHdrRepository.updateHdrStatus(EDPConstant.STATUS_APPROVE_ID,hdrId,OAuthUtility.getCurrentUserUserId(),
				new Date(),OAuthUtility.getCurrentUserLkPOUId());
	}
	
	/**
	 * Update hdr updated date.
	 *
	 * @param hdrDto the hdr dto
	 */
	private void updateHdrUpdatedDate(Long hdrId) {
		edpTedpBrHdrRepository.updateHdrUpdatedDate(hdrId,new Date());
	}
	
	
	/**
	 * Gets the branch request type.
	 *
	 * @return the branch request type
	 */
	@Override
	public List<ClueDto> getBranchRequestType() {
		List<Integer> lookupInfoValue = new ArrayList<>();
		lookupInfoValue.add(Constant.INT_ONE_VALUE);
		lookupInfoValue.add(Constant.INT_TWO_VALUE);	
		List<EDPLuLookUpInfoEntity> lookupEntities =  edpLuLookupInfoRepository.findByEdpLuLookUpEntityLookUpIdAndLookUpInfoValueInAndActiveStatus(EDPConstant.EDP_BRANCH_REQUEST_TYPE,lookupInfoValue, Constant.ACTIVE_STATUS);
		List<ClueDto> requestTypes = new ArrayList<>();
		lookupEntities.forEach(e ->{
			ClueDto clueDto = new ClueDto();
			clueDto.setId(e.getLookUpInfoId());
			clueDto.setName(e.getLookUpInfoName());
			requestTypes.add(clueDto);
		});
		return requestTypes;
	}

	/**
	 * Gets the emp post in office.
	 *
	 * @param officeId the office id
	 * @return the emp post in office
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPEmployeePostView> getEmpPostInOffice(Long officeId) throws CustomException {
		Map<String, Object> paramMap = new LinkedHashMap<>();
		paramMap.put(EDPConstant.IN_OFFICE_ID_VALUE, officeId);
		String procName = Constant.EDP_SCHEMA
				.concat(Constant.DOT.concat(EDPConstant.SP_GET_EMP_AND_POST_BY_OFFICE));
		List<Object[]> result = repository.callStoredProcedure(procName, paramMap);
		List<EDPEmployeePostView> empPostView = new ArrayList<>();
		if(!CollectionUtils.isEmpty(result)) {
			result.forEach(obj ->{
				String displayName = EDPUtility.convertObjectToString(obj[1]).concat(Constant.SINGLE_SPACE).concat(Constant.DASH).concat(Constant.SINGLE_SPACE)
						.concat(EDPUtility.convertObjectToString(obj[2])).concat(Constant.SINGLE_SPACE).concat(Constant.DASH).concat(Constant.SINGLE_SPACE)
						.concat(EDPUtility.convertObjectToString(obj[3]));
				EDPEmployeePostView postView = new EDPEmployeePostView();
				postView.setPostOfficeUserId(EDPUtility.convertObjectToLong(obj[0]));
				postView.setDisplayName(displayName);
				empPostView.add(postView);
			});			
		}
		return empPostView;
	}

	/**
	 * Submite branch.
	 *
	 * @param hdrDto the hdr dto
	 */
	private void submiteBranch(EDPTedpBrHdrDto hdrDto,EDPTedpBrCrDtlEntity dtlEntity) {
		if(null == hdrDto.getBranchId()) {
			EDPMsBranchEntity branchEntity = converter.hdrDtoToBranchEntity(hdrDto);
			branchEntity = repository.save(branchEntity);
			dtlEntity.setBranchId(branchEntity);
			saveDtlEntity(hdrDto, dtlEntity);
		} else {
			updateBranchData(hdrDto);
		}
	}

	/**
	 * Update branch data.
	 *
	 * @param hdrDto the hdr dto
	 */
	private void updateBranchData(EDPTedpBrHdrDto hdrDto) {
		Optional<EDPMsBranchEntity> optionalBranch = repository.findById(hdrDto.getBranchId());
		if(optionalBranch.isPresent()) {
			EDPMsBranchEntity branch = optionalBranch.get();
			branch.setBranchName(hdrDto.getBranchName());
			branch.setBranchTypeId(new EDPLuLookUpInfoEntity(hdrDto.getBranchType()));
			branch.setUpdatedDate(new Date());
			branch.setUpdatedBy(OAuthUtility.getCurrentUserUserId());
			branch.setUpdatedByPost(OAuthUtility.getCurrentUserLkPOUId());
			repository.save(branch);
		}
	}

	/**
	 * Search list.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPBranchCrViewDto> searchList(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> argsMap = populateArgumentsBrCrList(pageDetail);
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_EDP_BRANCH_CR_LISTING));
			List<Object[]> objectSp = repository.callStoredProcedure(procName, argsMap);
			List<EDPBranchCrViewDto> response = NativeQueryResultsMapper.map(objectSp, EDPBranchCrViewDto.class);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, response.isEmpty() ? 0 : response.get(0).getCount(),response);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
	/**
	 * Populate arguments br cr list.
	 *
	 * @param pageDetail the page detail
	 * @return the map
	 */
	private Map<String, Object> populateArgumentsBrCrList(PageDetails pageDetail) {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		argsMap.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		argsMap.put(Constant.IN_LK_POU_ID, OAuthUtility.getCurrentUserLkPOUId());
		argsMap.put(Constant.IN_OFFICE_ID, OAuthUtility.getCurrentUserOfficeIdFromToken());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		Map<String, String> map= EDPConstant.getSearchBranchCreEDPList();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(search -> argsMap.put(map.get(search.getKey()),
							StringUtils.isEmpty(search.getValue()) ? "" : search.getValue()));
		} else {
			map.forEach((k, v) -> argsMap.put(map.get(k), 0));
		}
		return argsMap;
	}
	
	@Override
	public List<ClueDto> getBranchesForOffice(){
		Long officeId = OAuthUtility.getCurrentUserOfficeIdFromToken();
		List<ClueDto> branches = new ArrayList<>();
		List<EDPMsBranchEntity> officeBranches = repository.findByEdpMsOfficeOfficeIdAndActiveStatus(officeId,Constant.ACTIVE_STATUS);
		officeBranches.forEach(e ->{
			ClueDto clueDto = new ClueDto();
			clueDto.setId(e.getBranchId());
			clueDto.setName(e.getBranchName());
			branches.add(clueDto);
		});
		return branches;
	}
	
	@Override
	public EDPBrDtlDto getEmpMappedBranches(Long pouId) throws CustomException {
		List<Object[]> result = null;
		Map<String, Object> paramMap = new LinkedHashMap<>();
		paramMap.put(EDPConstant.IN_POU_ID_VALUE, pouId);
		String procName = Constant.EDP_SCHEMA
				.concat(Constant.DOT.concat(EDPConstant.SP_GET_EMP_MAPPED_BRANCH));
		result = repository.callStoredProcedure(procName, paramMap);
		Object[] object = result.get(0);
		EDPBrDtlDto branchView = new EDPBrDtlDto();
		branchView.setPostOfficeUserId(EDPUtility.convertObjectToLong(object[0]));
		branchView.setEmpNo(EDPUtility.convertObjectToString(object[1]));
		branchView.setEmpName(EDPUtility.convertObjectToString(object[2]));
		branchView.setPostName(EDPUtility.convertObjectToString(object[3]));
		List<Long> mappedBranches = new ArrayList<>();
		result.forEach(obj -> {
			if(obj[4] != null)
				mappedBranches.add(EDPUtility.convertObjectToLong(obj[4]));
		});
		branchView.setMappedBranches(mappedBranches);
		return branchView;
	}

	/**
	 * Delete branch cr request.
	 *
	 * @param hdrId the hdr id
	 * @throws CustomException the custom exception
	 */
	@Override
	public void deleteBranchCrRequest(Long hdrId) throws CustomException {
		try {
			edpTedpBrHdrRepository.updateHdrActiveStatus(Constant.IN_ACTIVE_STATUS, hdrId,OAuthUtility.getCurrentUserUserId(),
					new Date(),OAuthUtility.getCurrentUserLkPOUId());
			edpTedpBrCrDtlRepository.updateDtlEntityActiveStatusByHdrId(Constant.IN_ACTIVE_STATUS, hdrId,OAuthUtility.getCurrentUserUserId(),
					new Date(),OAuthUtility.getCurrentUserLkPOUId());
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE);
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public EDPTedpBrDtlDto saveBranchMapping(EDPTedpBrDtlDto dtlDto) throws CustomException {
		if(null == dtlDto.getTedpBrHdrId()) {
			saveHdrEntity(dtlDto);
			saveDtlEntity(dtlDto, dtlDto.getBranchesToBeMapped());
		} else {
			updateBranchMapping(dtlDto);
		}
		if(dtlDto.getFormAction() == Status.SUBMITTED)
		{
			if(!EDPConstant.BRANCH_TRANSFER_REQ_TYPE_ID.equals(dtlDto.getRequestType()))
				submitBranchMapping(dtlDto);
			else
				submitBranchTransfer(dtlDto);
		}
		return getBrMapDtlByHdr(dtlDto.getTedpBrHdrId());
	}
	
	private  void updateBranchMapping(EDPTedpBrDtlDto dtlDto) {
		List<EDPTedpBrDtlEntity> dtlEntities = edpTedpBrDtlRepository.findByTedpBrHdrIdTedpBrHdrId(dtlDto.getTedpBrHdrId());
		List<EDPTedpBrDtlEntity> updateEntities = dtlEntities.stream().filter(e -> dtlDto.getBranchesToBeMapped().contains(e.getBranchId().getBranchId())).collect(Collectors.toList());
		List<Long> mappedBranches = dtlEntities.stream().map(e -> e.getBranchId().getBranchId()).collect(Collectors.toList());
		List<Long> branchToBeAdded = new ArrayList<>();
		List<Long> branchToBeRemoved = new ArrayList<>();
		dtlDto.getBranchesToBeMapped().forEach(branch ->{
			if(!mappedBranches.contains(branch)) {
				branchToBeAdded.add(branch);
			}
		});
		if(!branchToBeAdded.isEmpty())
			saveDtlEntity(dtlDto, branchToBeAdded);
		mappedBranches.forEach(mapped ->{
			if(!dtlDto.getBranchesToBeMapped().contains(mapped))
				branchToBeRemoved.add(mapped);
		});
		if(!branchToBeRemoved.isEmpty())
			deactivateMappingByHdrId(dtlDto.getTedpBrHdrId(), branchToBeRemoved);
		if(!updateEntities.isEmpty()) {
			updateEntities.forEach(e -> updateDtlEntities(e, dtlDto));
			edpTedpBrDtlRepository.saveAll(updateEntities);
		}
		updateHdrUpdatedDate(dtlDto.getTedpBrHdrId());
	}
	
	private EDPTedpBrHdrEntity saveHdrEntity(EDPTedpBrDtlDto dtlDto) {
		dtlDto.setTrnNo(repository.generateTrnNo(Constant.EDP_SCHEMA, EDPConstant.SP_GET_EDP_TRN_NO_GEN, EDPConstant.BRANCH_MAPPING_MENU_CODE));
		EDPTedpBrHdrEntity hdrEntity = edpTedpBrHdrConverter.brMapDtoToEntity(dtlDto);
		hdrEntity = edpTedpBrHdrRepository.save(hdrEntity);
		dtlDto.setTedpBrHdrId(hdrEntity.getTedpBrHdrId());
		return hdrEntity;
	}

	private void saveDtlEntity(EDPTedpBrDtlDto dtlDto, List<Long> branchToBeAdded) {
		List<EDPTedpBrDtlEntity> dtlEntities = new ArrayList<>();
		branchToBeAdded.forEach(branchId ->{
			EDPTedpBrDtlEntity dtlEntity = edpTedpBrHdrConverter.hdrDtoToBrDtlEntity(dtlDto);				
			dtlEntity.setBranchId(new EDPMsBranchEntity(branchId));
			dtlEntities.add(dtlEntity);
		});
		edpTedpBrDtlRepository.saveAll(dtlEntities);
	}
	
	private int deactivateMappingByHdrId(Long hdrId, List<Long> branchToBeRemoved) {
		return edpTedpBrDtlRepository.updateActiveStatusByHdrIdAndBranch(Constant.INACTIVE_STATUS, hdrId, branchToBeRemoved);
	}
	
	private void submitBranchMapping(EDPTedpBrDtlDto dtlDto) {
		updateHdrStatus(dtlDto.getTedpBrHdrId());
		dtlDto.getBranchesToBeMapped().forEach(branchId -> insertMasterData(dtlDto.getFromPouId(), dtlDto.getFromPouId(), branchId) );		
	}
	
	private void insertMasterData(Long fromPouId, Long toPouId, Long branchId) {
		EDPTrnPouBrMapEntity msBrMapEntity = new EDPTrnPouBrMapEntity();
			msBrMapEntity.setTrFromPOUId(new EDPLkPoOffUserEntity(fromPouId));
			msBrMapEntity.setEdpLkPoOffUserId(new EDPLkPoOffUserEntity(toPouId));
			msBrMapEntity.setEdpMsBranchEntity(new EDPMsBranchEntity(branchId));
			msBrMapEntity = edpTrnPouBrMapRepository.save(msBrMapEntity);			

			insertMasterItrData(msBrMapEntity, fromPouId, toPouId, branchId);
	}

	@Override
	public ClueDto getSearchFilter() {
		ClueDto searchFilter = new ClueDto();
		
		List<ClueDto> statusList = new ArrayList<>();
		statusList.add(idAndNameClueDto(Constant.SAVE_AS_DRAFT_STATUS_ID, EDPConstant.LK_STATUS_VAL_DRAFT));
		statusList.add(idAndNameClueDto(Constant.LU_APPROVED_LOOKUP_INFO_ID, EDPConstant.LK_STATUS_VAL_APPROVED));
		searchFilter.setStatusList(statusList);
		searchFilter.setRequestTypes(getBranchRequestType());
		
		return searchFilter;
	}
	
	private ClueDto idAndNameClueDto(Long id, String name) {
		ClueDto clueDto = new ClueDto();
		clueDto.setId(id);
		clueDto.setName(name);
		return clueDto;
	}
	
	@Override
	public PagebleDTO<EDPUsrBrMapSearchView> getBranchMappingList(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> argsMap = EDPUtility.populateArgumentsBrMap(pageDetail, 10);
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_EDP_BRANCH_MAPPING_LISTING));
			List<Object[]> objectSp = edpTedpBrHdrRepository.callStoredProcedure(procName, argsMap);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objectSp.isEmpty() ? 0 : objectSp.size(),
					NativeQueryResultsMapper.map(objectSp, EDPUsrBrMapSearchView.class));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public EDPTedpBrDtlDto getBrMapDtlByHdr(Long hdrId) throws CustomException{
		Map<String, Object> hdrMap = new HashMap<>();
		hdrMap.put(Constant.IN_HDR_ID, hdrId);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_BR_MAP_DTL_BY_HDR));
		List<Object[]> objectSp = edpTedpBrHdrRepository.callStoredProcedure(procName, hdrMap);

		EDPTedpBrDtlDto dtlDto = new EDPTedpBrDtlDto();
		if(!CollectionUtils.isEmpty(objectSp)) {
			Object[] dtlObj = objectSp.get(0);
			Long requestTypeId = EDPUtility.convertObjectToLong(dtlObj[2]);
			Long fromPouId = EDPUtility.convertObjectToLong(dtlObj[4]);
			
			dtlDto.setTedpBrHdrId(hdrId);
			dtlDto.setTrnNo(EDPUtility.convertObjectToString(dtlObj[0]));
			dtlDto.setCreatedDate(EDPUtility.convertObjectToDate(dtlObj[1]));
			dtlDto.setRequestType(requestTypeId);
			dtlDto.setRequestTypeName(EDPUtility.convertObjectToString(dtlObj[3]));
			dtlDto.setFromPouId(fromPouId);
			
			EDPBrDtlDto fromEmpDtlDto = new EDPBrDtlDto();
			String fromUserMappedBranchesString = EDPUtility.convertObjectToString(dtlObj[13]);
			fromEmpDtlDto.setEmpNo(EDPUtility.convertObjectToString(dtlObj[6]));
			fromEmpDtlDto.setEmpName(EDPUtility.convertObjectToString(dtlObj[5]));
			fromEmpDtlDto.setPostName(EDPUtility.convertObjectToString(dtlObj[7]));
			fromEmpDtlDto.setPostOfficeUserId(fromPouId);
			setUserBranches(fromUserMappedBranchesString, fromEmpDtlDto);
			
			dtlDto.setFromUserBranch(fromEmpDtlDto);

			if(EDPConstant.BRANCH_TRANSFER_REQ_TYPE_ID.equals(requestTypeId)) {
				EDPBrDtlDto toEmpDtlDto = new EDPBrDtlDto();
				String toUserMappedBranchesString = EDPUtility.convertObjectToString(dtlObj[14]);
				toEmpDtlDto.setEmpNo(EDPUtility.convertObjectToString(dtlObj[11]));
				toEmpDtlDto.setEmpName(EDPUtility.convertObjectToString(dtlObj[10]));
				toEmpDtlDto.setPostName(EDPUtility.convertObjectToString(dtlObj[12]));
				toEmpDtlDto.setPostOfficeUserId(EDPUtility.convertObjectToLong(dtlObj[9]));				
				dtlDto.setToPouId(EDPUtility.convertObjectToLong(dtlObj[9]));
				
				setUserBranches(toUserMappedBranchesString, toEmpDtlDto);
				dtlDto.setToUserBranch(toEmpDtlDto);
			}
			List<Long> mappedBranches = new ArrayList<>();
			
			objectSp.forEach(obj -> mappedBranches.add(EDPUtility.convertObjectToLong(obj[8])) );
			dtlDto.setBranchesToBeMapped(mappedBranches);
		}
		
		return dtlDto;
				
	}
	
	private void setUserBranches(String userMappedBranchesString, EDPBrDtlDto empDtlDto) {
		List<String> userMappedBranchesList = (!userMappedBranchesString.isEmpty()) ?
				Stream.of(userMappedBranchesString.split(",")).collect(Collectors.toList())
				: new ArrayList<>();
		List<Long> userMappedBranches = new ArrayList<>();
		if(!CollectionUtils.isEmpty(userMappedBranchesList))
			userMappedBranchesList.forEach(s -> userMappedBranches.add(EDPUtility.convertObjectToLong(s)) );
		empDtlDto.setMappedBranches(userMappedBranches);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteBrMapRequest(Long hdrId) throws CustomException {
		try {
			edpTedpBrHdrRepository.updateHdrActiveStatus(Constant.IN_ACTIVE_STATUS, hdrId,OAuthUtility.getCurrentUserUserId(),
					new Date(),OAuthUtility.getCurrentUserLkPOUId());
			edpTedpBrDtlRepository.deactivateByHdrId(Constant.IN_ACTIVE_STATUS, hdrId,OAuthUtility.getCurrentUserUserId(),
					new Date(),OAuthUtility.getCurrentUserLkPOUId());
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE);
		}
	}
		
	@Override
	public void checkForExistingRequest(Long pouId) throws CustomException {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(Constant.IN_POU_ID,pouId);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.CHECK_BRMAP_REQUEST_EXISTS));
		List<Object[]> requestdList = repository.callStoredProcedure(procName, argMap);
		if(!requestdList.isEmpty()) {
			getErrorMessage(requestdList);
		}	
	}

	private void getErrorMessage(List<Object[]> requestdList) throws CustomException {
		String errorMessage = MessageFormat.format(MsgConstant.EDP_REQUEST_INITIATE_BRANCH_MAPPING,
				EDPUtility.convertObjectToString(requestdList.get(0)[0]),EDPUtility.convertObjectToString(requestdList.get(0)[9]), 
				EDPUtility.convertObjectToString(requestdList.get(0)[10]),EDPUtility.convertObjectToString(requestdList.get(0)[8]),
				requestdList.get(0)[7], requestdList.get(0)[1], requestdList.get(0)[2], requestdList.get(0)[3],
				requestdList.get(0)[4], EDPUtility.convertObjectToString(requestdList.get(0)[5]),
				EDPUtility.convertObjectToString(requestdList.get(0)[11]));
		throw new CustomException(10098, errorMessage);
	}

	private void submitBranchTransfer(EDPTedpBrDtlDto dtlDto) {
		List<Long> toPouMappedBranches =  edpTrnPouBrMapRepository.getMappedBranchesForPou(dtlDto.getToPouId(), dtlDto.getToPouId(),  Constant.ACTIVE_STATUS);
		dtlDto.getBranchesToBeMapped().forEach(branchId ->{
			if(!toPouMappedBranches.contains(branchId))
				insertMasterData(dtlDto.getToPouId(), dtlDto.getToPouId(), branchId);
		});
		updateMasterData(dtlDto);
		updateHdrStatus(dtlDto.getTedpBrHdrId());
	}
	
	private void updateMasterData(EDPTedpBrDtlDto dtlDto) {
		List<EDPTrnPouBrMapEntity> updateBrMapEntities = edpTrnPouBrMapRepository.findByTrFromPOUIdLkPoOffUserIdAndEdpLkPoOffUserIdLkPoOffUserIdAndEdpMsBranchEntityBranchIdInAndActiveStatus(dtlDto.getFromPouId(), dtlDto.getFromPouId(), dtlDto.getBranchesToBeMapped(), Constant.ACTIVE_STATUS);
		Set<Long> brMapUpdateIds = updateBrMapEntities.stream().map(EDPTrnPouBrMapEntity::getTrnPouBrMapId).collect(Collectors.toSet());
		edpTrnPouBrMapRepository.updateBrMapEntityById(dtlDto.getToPouId(), brMapUpdateIds,OAuthUtility.getCurrentUserUserId(),
				new Date(),OAuthUtility.getCurrentUserLkPOUId());
		updateBrMapEntities.forEach(e -> insertMasterItrData(e, dtlDto.getFromPouId(), dtlDto.getToPouId(), e.getEdpMsBranchEntity().getBranchId()));
	}
	
	private void insertMasterItrData(EDPTrnPouBrMapEntity msBrMapEntity, Long fromPouId, Long toPouId, Long branchId) {
		
		EDPTrnPouBrMapItrEntity msBrMapItrEntity = new EDPTrnPouBrMapItrEntity();
		msBrMapItrEntity.setTrFromPOUId(new EDPLkPoOffUserEntity(fromPouId));
		msBrMapItrEntity.setEdpLkPoOffUserId(new EDPLkPoOffUserEntity(toPouId));
		msBrMapItrEntity.setEdpMsBranchEntity(new EDPMsBranchEntity(branchId));
		msBrMapItrEntity.setTrnPouBrMapId(msBrMapEntity);
		edpTrnPouBrMapItrRepository.save(msBrMapItrEntity);		
	}
	
	private void updateDtlEntities(EDPTedpBrDtlEntity e, EDPTedpBrDtlDto dtlDto) {
		e.setFromPouId(new EDPLkPoOffUserEntity(dtlDto.getFromPouId()));
		e.setToPouId(EDPConstant.BRANCH_TRANSFER_REQ_TYPE_ID.equals(dtlDto.getRequestType()) ? 
				new EDPLkPoOffUserEntity(dtlDto.getToPouId())
				: new EDPLkPoOffUserEntity(dtlDto.getFromPouId()));
		e.setUpdatedBy(OAuthUtility.getCurrentUserUserId());
		e.setUpdatedByPost(OAuthUtility.getCurrentUserLkPOUId());
		e.setUpdatedDate(new Date());
		e.setActiveStatus(Constant.ACTIVE_STATUS);
	}
	
	@Override
	public Map<String, Object> checkUserAccess(Long fromPouId, Long toPouId){
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(EDPConstant.IN_FROM_LK_POU_ID,fromPouId);
		argMap.put(EDPConstant.IN_TO_LK_POU_ID,toPouId);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_BRANCH_USER_MENU_ROLEPRM_WF));
		List<Object[]> requestdList = repository.callStoredProcedure(procName, argMap);
		List<Object[]> fromPouDetails = requestdList.stream().filter(obj -> fromPouId.equals(EDPUtility.convertObjectToLong(obj[6]))).collect(Collectors.toList());
		List<Object[]> toPouDetails = requestdList.stream().filter(obj -> toPouId.equals(EDPUtility.convertObjectToLong(obj[6]))).collect(Collectors.toList());
		Set<Long> menuIds = fromPouDetails.stream().map(obj -> EDPUtility.convertObjectToLong(obj[0])).distinct().collect(Collectors.toSet());
		List<ClueDto> responseDto = new ArrayList<>();
		menuIds.forEach(menuId ->checkForMenuwiseAccess(menuId,fromPouDetails, toPouDetails, responseDto));
		Map<String, Object> responseMap = new HashMap<>();
		if(!responseDto.isEmpty()) {			
			String empNo = (toPouDetails.isEmpty()) ? edpLkPoOffUserRepository.getOne(toPouId).getUserId().getUserCode().toString()
					: EDPUtility.convertObjectToString(toPouDetails.get(0)[7]);
			String errorMsg = MessageFormat.format(MsgConstant.EDP_USER_BRANCH_ACCESS,
					empNo);
			responseMap.put("message", errorMsg);
			responseMap.put("response", responseDto);
		}
			return responseMap;
	}
	
	private void checkForMenuwiseAccess(Long menuId, List<Object[]> fromPouDetails, List<Object[]> toPouDetails, List<ClueDto> responseDto) {
		List<Object[]> fromPouMenuDetails = fromPouDetails.stream().filter(obj -> menuId.equals(EDPUtility.convertObjectToLong(obj[0]))).collect(Collectors.toList());
		List<Object[]> toPouMenuDetails = toPouDetails.stream().filter(obj -> menuId.equals(EDPUtility.convertObjectToLong(obj[0]))).collect(Collectors.toList());
		String toRolePrmString = (toPouMenuDetails.isEmpty()) ? EDPConstant.EMPTY_STRING : EDPUtility.convertObjectToString(toPouMenuDetails.get(0)[3]);
		String fromRolePrmString =(fromPouMenuDetails.isEmpty()) ? EDPConstant.EMPTY_STRING : EDPUtility.convertObjectToString(fromPouMenuDetails.get(0)[3]);
		
		List<String> toRolePrm = (toRolePrmString.equals(EDPConstant.EMPTY_STRING))? new ArrayList<>() : Arrays.asList(toRolePrmString.split(Constant.COMMA));
		List<String> fromRolePrm = (fromRolePrmString.equals(EDPConstant.EMPTY_STRING))? new ArrayList<>() : Arrays.asList(fromRolePrmString.split(Constant.COMMA));
		fromRolePrm = fromRolePrm.stream().filter(a -> !toRolePrm.contains(a)).collect(Collectors.toList());
		Set<String> fromRolePrms = new HashSet<>();
		fromRolePrms.addAll(fromRolePrm);
		Set<String> fromWfRoles = fromPouMenuDetails.stream().map(obj -> EDPUtility.convertObjectToString(obj[5])).distinct().collect(Collectors.toSet());
		Set<String> toWfRoles = toPouMenuDetails.stream().map(obj -> EDPUtility.convertObjectToString(obj[5])).distinct().collect(Collectors.toSet());
		fromWfRoles = fromWfRoles.stream().filter(a -> !toWfRoles.contains(a)).collect(Collectors.toSet());
		if(!fromRolePrm.isEmpty() || !fromWfRoles.isEmpty()) {
			ClueDto clueDto = new ClueDto();
			clueDto.setMenuId(menuId);
			clueDto.setMenu(EDPUtility.convertObjectToString(fromPouMenuDetails.get(0)[1]));
			clueDto.setRolePrm(fromRolePrms);
			clueDto.setWfRoles(fromWfRoles);
			responseDto.add(clueDto);
		}
	}
	
	@Override
	public List<EDPMsBranchEntity> getBranchListbyBranchTypeAndOfficeId(Long branchTypeId) {
		return repository.findBranchByBranchTypeIdAndOfficeId(branchTypeId, OAuthUtility.getCurrentUserOfficeIdFromToken() ,EDPConstant.ACTIVE_STATUS_TRUE);
	}
}
