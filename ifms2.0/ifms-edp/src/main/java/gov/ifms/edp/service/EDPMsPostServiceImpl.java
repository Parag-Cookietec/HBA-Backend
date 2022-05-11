package gov.ifms.edp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.converter.EDPMsPostConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.dto.EDPPostCountDTO;
import gov.ifms.edp.dto.EDPPostHistoryReportView;
import gov.ifms.edp.dto.EDPPostOfficeDetailsDto;
import gov.ifms.edp.dto.EDPPostSearchView;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPPostItrEntity;
import gov.ifms.edp.oauth.dto.OAuthTokenPostDTO;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLkPostOfficeRepository;
import gov.ifms.edp.repository.EDPLkPostUserRepository;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsPostRepository;
import gov.ifms.edp.repository.EDPPostItrRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPNativeSQLUtil;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.edp.workflow.service.EDPWorkflowRequestHandler;

/**
 * The Class EDPMsPostServiceImpl.
 */
@Service
public class EDPMsPostServiceImpl implements EDPMsPostService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	/** The EDPMsPostAsMethodName repository. */
	@Autowired
	private EDPMsPostRepository repository;

	/** The EDPMsPostAsMethodName helper. */
	@Autowired
	private EDPMsPostConverter converter;

	/** The edp ms district repository. */
	@Autowired
	private EDPMsDistrictRepository edpMsDistrictRepository;

	/** The edp lk post office repository. */
	@Autowired
	private EDPLkPostOfficeRepository edpLkPostOfficeRepository;

	/** The lookupinforepository. */
	@Autowired
	private EDPLuLookUpInfoRepository lookupinforepository;

	/** The edp post itr repository. */
	@Autowired
	private EDPPostItrRepository edpPostItrRepository;

	/** The edpms designationrepository. */
	@Autowired
	private EDPMsDesignationRepository edpmsDesignationrepository;

	/** The edp lk post user repository. */
	@Autowired
	EDPLkPostUserRepository edpLkPostUserRepository;

	@Autowired
	private EDPWorkflowRequestHandler wfRequestHandler;

	/** The district converter. */
	@Autowired
	private EDPMsDistrictConverter districtConverter;

	/** The district repository. */
	@Autowired
	private EDPMsDistrictRepository districtRepository;

	/**
	 * Returns all instances of the EDPMsPostEntity type.
	 * 
	 * @return all EDPMsPostEntity
	 */
	@Override
	public List<EDPMsPostEntity> getMsPosts() {
		return repository.findAll();
	}

	/**
	 * Retrieves an EDPMsPostEntity by its id.
	 *
	 * @param idDto the id dto
	 * @return the EDPMsPostEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsPostDto getMsPost(IdDto idDto) {
		if (null != idDto.getId()) {
			Optional<EDPMsPostEntity> postentity = repository.findById(idDto.getId());
			if (postentity.isPresent()) {
				EDPMsPostDto dto = converter.toDTO(postentity.get());
				EDPLkPostOfficeEntity lkPostEntity = edpLkPostOfficeRepository.findByPostEntityPostIdAndActiveStatus( postentity.get().getPostId(), Constant.ACTIVE_STATUS);
				EDPMsOfficeEntity office = lkPostEntity.getOfficeEntity();
				if(dto.getWfInRequest().equals(Boolean.TRUE)) {
					Map<String, Object> argMap = new HashMap<>();
					argMap.put(EDPConstant.TRN_ID, postentity.get().getPostId());
					Object obj = repository
							.executeNativeSQLQuery(EDPNativeSQLUtil.GET_LEVEL_FOR_POST_WF, argMap).get(0);
					int level = EDPUtility.convertObjectToInt(obj);
					dto.setIsObjectionRequired(level != 0);					
				}
				dto.setOfficeId(office.getOfficeId());
 				dto.setCardexNo(office.getCardexno());
				dto.setDdoNo(office.getDdoNo());
				dto.setDdoOffice(office.getOfficeName());
				if (null != office.getDistrictId()) {
					dto.setDistrict(new ClueDto(office.getDistrictId().getDistrictId(),
							office.getDistrictId().getDistrictName(), null, null));
				}
				return dto;
			}
		}
		return null;
	}

	/**
	 * Saves a given EDPMsPostEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved EDPMsPostEntity
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPMsPostDto saveMsPost(EDPMsPostDto dto) throws CustomException {
		generateTrnNo(dto);
		EDPMsPostDto responseDto = saveRequestAsDraft(dto);
		
		if (Boolean.TRUE.equals(responseDto.getIsWfSaveDrftApiCall())) {
			wfRequestHandler.saveAsDraftWf(dto.getCurMenuId(), dto.getPostId());
		}
		if (!Boolean.TRUE.equals(responseDto.getWfInRequest())
				&& responseDto.getFormAction().equals(Status.SUBMITTED)) {
			wfRequestHandler.wfDirectSubmiteApiCall(dto.getCurMenuId(), dto.getPostId());
		}
		return responseDto;

	}

	@Transactional(rollbackFor = CustomException.class)
	public EDPMsPostDto saveRequestAsDraft(EDPMsPostDto edpMsPostDto) throws CustomException {
		try {

			EDPMsPostEntity headerEntity = converter.toEntity(edpMsPostDto);
			if (edpMsPostDto.getPostId() == null || edpMsPostDto.getPostId() == 0) {
				createValidNewPostname(edpMsPostDto);
				headerEntity = getHdrEntityData(edpMsPostDto);
				repository.flush();
				edpMsPostDto.setPostId(headerEntity.getPostId());
				EDPPostItrEntity edpPostItrEntity = converter.toItrEntity(edpMsPostDto);
				edpPostItrRepository.save(edpPostItrEntity);
				EDPLkPostOfficeEntity edpLkPostOfficeEntity = new EDPLkPostOfficeEntity();
				edpLkPostOfficeEntity.setPostEntity(headerEntity);
				edpLkPostOfficeEntity.setOfficeEntity(new EDPMsOfficeEntity(edpMsPostDto.getOfficeId()));
				edpLkPostOfficeEntity.setIsVacant(new EDPLuLookUpInfoEntity(EDPConstant.ARG_POST_VACANT_YES));
				edpLkPostOfficeRepository.save(edpLkPostOfficeEntity);
			}

			updateHdrEntityStatus(edpMsPostDto);
			edpMsPostDto.setStatusId(headerEntity.getStatusId().getLookUpInfoId());
			edpMsPostDto.setTrnDate(headerEntity.getCreatedDate());
			return edpMsPostDto;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private EDPMsPostEntity getHdrEntityData(EDPMsPostDto msPostDto) {
		msPostDto.setStatusId(Constant.SAVE_AS_DRAFT_STATUS_ID);
		msPostDto.setInitiatedBy(OAuthUtility.getCurrentUserLkPOUId());
		EDPMsPostEntity msPostEntity = converter.toEntity(msPostDto);
		return repository.save(msPostEntity);

	}

	private void updateHdrEntityStatus(EDPMsPostDto msPostDto) {
		if ((null != msPostDto.getIsObjectionRequired() && msPostDto.getIsObjectionRequired())) {
			repository.updateObjectionForHeader(EDPConstant.LOOKUP_INFO_YES, msPostDto.getObjectionRemarks(),
					msPostDto.getPostId());
		}
		if ((!msPostDto.getWfInRequest() || msPostDto.getIsWfSubmit()) && null != msPostDto.getPostId()
				&& msPostDto.getFormAction().equals(Status.SUBMITTED)) {
			repository.updateUserPostStatus(msPostDto.getPostId(), Constant.LU_APPROVED_LOOKUP_INFO_ID,
					OAuthUtility.getCurrentUserUserId(), new Date());
		}
	}

	/**
	 * Creates the valid new postname.
	 *
	 * @param dto the dto
	 * @throws CustomException the custom exception
	 */
	private void createValidNewPostname(EDPMsPostDto dto) throws CustomException {
		List<EDPLkPostOfficeEntity> postOfficeList = edpLkPostOfficeRepository
				.findByPostEntityPostNameAndOfficeEntityOfficeId(dto.getPostName(), dto.getOfficeId());
		if (CollectionUtils.isNotEmpty(postOfficeList)) {
			dto.setPostName(createNewPostName(dto));
		}
	}

	/**
	 * Creates the new post name.
	 *
	 * @param dto the dto
	 * @return the string
	 * @throws CustomException the custom exception
	 */
	private String createNewPostName(EDPMsPostDto dto) throws CustomException {
		EDPPostCountDTO countdto = new EDPPostCountDTO();
		countdto.setDesignationId(dto.getDesignationId());
		countdto.setOfficeId(dto.getOfficeId());
		if (null != dto.getPostId()) {
			countdto.setPostId(dto.getPostId());
		}

		Long postCount = getPostCount(countdto).getCount();
		Optional<EDPMsDesignationEntity> designationEntity = edpmsDesignationrepository
				.findByActiveStatusAndDesignationId(Constant.ACTIVE_STATUS, countdto.getDesignationId());
		if (designationEntity.isPresent()) {
			if (postCount > 1) {
				return new StringBuilder(designationEntity.get().getDesignationName()).append(Constant.SINGLE_SPACE)
						.append(Constant.DASH).append(Constant.SINGLE_SPACE).append(postCount).toString();
			} else {
				return designationEntity.get().getDesignationName();
			}
		}
		throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
	}

	/**
	 * Update ms post.
	 *
	 * @param dto the dto
	 * @return the EDP ms post dto
	 * @throws CustomException the custom exception
	 */
	@Transactional(rollbackFor = { Exception.class })
	public EDPMsPostDto updateMsPost(EDPMsPostDto dto) throws CustomException {
		EDPMsPostDto postDto = null;
		try {
			if (null != dto.getPostId()) {
				
				Optional<EDPMsPostEntity> lastmspostentity = repository.findById(dto.getPostId());
				if (lastmspostentity.isPresent()) {
					String transactionNo = lastmspostentity.get().getTransactionNo();
					dto.setTransactionNo(transactionNo);
					
					dto.setInitiatedBy(lastmspostentity.get().getInitiatedBy().getLkPoOffUserId());
					setStatus(dto);
					if (!Boolean.TRUE.equals(dto.getWfInRequest())
							&& dto.getFormAction().equals(Status.SUBMITTED)) {
						wfRequestHandler.wfDirectSubmiteApiCall(dto.getCurMenuId(), dto.getPostId());
					}
					createValidNewPostname(dto);
					EDPMsPostEntity mspostentity = converter.toEntity(dto);
					mspostentity = repository.save(mspostentity);

					
					EDPPostItrEntity edpPostItrEntity = converter.toItrEntity(dto);
					edpPostItrRepository.save(edpPostItrEntity);
					postDto = converter.toDTO(mspostentity);
					postDto.setWfSubmit(dto.getIsWfSubmit());
				
				} else {
					throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE);
				}
			} else {
				throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE);
		}
		return postDto;
	}

	private void setStatus(EDPMsPostDto dto) {
		if ((!dto.getWfInRequest() || dto.getIsWfSubmit()) && dto.getFormAction() == Status.SUBMITTED)
			dto.setStatusId(lookupinforepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED)
					.getLookUpInfoId());
		else
			dto.setStatusId(lookupinforepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_SAVAS_DRAFT)
					.getLookUpInfoId());
	}

	/**
	 * Delete ms post.
	 *
	 * @param id the id
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteMsPost(Long id) throws CustomException {
		try {
			Optional<EDPMsPostEntity> edpPostEntity = repository.findById(id);
			List<EDPLkPostOfficeEntity> list = edpLkPostOfficeRepository
					.findByActiveStatusAndPostEntityPostId(Constant.ACTIVE_STATUS, id);
			if (CollectionUtils.isNotEmpty(list)) {
				edpLkPostOfficeRepository.deleteLkPostOffice(list.get(0).getPostOfficeId(), Constant.IN_ACTIVE_STATUS,
						OAuthUtility.getCurrentUserUserId(), new java.util.Date());
			}
			int activeStatus = edpPostEntity.isPresent() ? edpPostEntity.get().getActiveStatus() : 0;

			if (activeStatus == 1) {
				edpPostEntity.get().setActiveStatus(0);
				repository.save(edpPostEntity.get());
			}
		} catch (DataIntegrityViolationException ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}
	}

	/**
	 * Saves all given EDPMsPostEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	@Override
	public List<EDPMsPostEntity> saveMsPosts(List<EDPMsPostEntity> entities) {
		return (List<EDPMsPostEntity>) repository.saveAll(entities);
	}

	/**
	 * Fetch all the EDPMsPost items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsPostDto>
	 */

	@Override
	public PagebleDTO<EDPMsPostDto> edpMsPostAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPMsPostEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();

		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<EDPMsPostEntity> empSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
		Page<EDPMsPostEntity> page = repository.findAll(empSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				converter.toDTO(page.getContent()));
	}

	/**
	 * Gets the EDP ms post by post id.
	 *
	 * @param idList the id list
	 * @return the EDP ms post by post id
	 */
	@Override
	public List<EDPMsPostEntity> getEDPMsPostByPostId(Set<Long> idList) {
		return repository.findByPostIdIn(idList);
	}

	/**
	 * Gets the officedetails.
	 *
	 * @return the officedetails
	 */
	@Override
	public EDPPostOfficeDetailsDto getpostAndofficedetails() {

		EDPPostOfficeDetailsDto postofficedetailsdto = new EDPPostOfficeDetailsDto();

		EDPMsOfficeDto officedto = null;
		OAuthTokenPostDTO dto = OAuthUtility.getCurrentUserLoginPostFromOauthToken().getOauthTokenPostDTO();
		if (null != dto) {
			officedto = dto.getEdpMsOfficeDto();
			if (null != officedto) {
				postofficedetailsdto.setCardexNo(officedto.getCardexno());
				postofficedetailsdto.setDdoNo(officedto.getDdoNo());
				postofficedetailsdto.setDdoOffice(officedto.getOfficeName());
				Optional<EDPMsDistrictEntity> entity = edpMsDistrictRepository.findById(officedto.getDistrictId());
				if (entity.isPresent()) {
					postofficedetailsdto.setDistrict(
							new ClueDto(entity.get().getDistrictId(), entity.get().getDistrictName(), null, null));
				}
				postofficedetailsdto.setOfficeId(officedto.getOfficeId());
				Long officeid = officedto.getOfficeId();
				postofficedetailsdto.setVacantPost(converter.objectToClueDTO(
						edpLkPostUserRepository.findVacantPost(officeid, EDPConstant.ARG_POST_VACANT_YES,
								Constant.ACTIVE_STATUS, EDPConstant.STATUS_APPROVED_ID)));
				postofficedetailsdto.setDesignations(converter.toDesignationClueDTO(
						edpmsDesignationrepository.findByStatusIdLookUpInfoNameOrStatusIdIsNullAndActiveStatus(
								EDPConstant.LK_STATUS_VAL_APPROVED, OAuthConstant.ACTIVE_STATUS,
								EDPUtility.getJpaSort(EDPConstant.DESIGNATION_NAME, EDPConstant.ORDER_ASC))));
			}
		}
		return postofficedetailsdto;

	}

	/**
	 * Search listfor posts.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPPostSearchView> searchListforPosts(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> argsMap = populateArguments(pageDetail, 3);
			String procName = Constant.EDP_SCHEMA
					.concat(Constant.DOT.concat(EDPConstant.SP_POST_CREATION_SEARCH_LIST_WF));

			List<Object[]> objectSp = this.repository.callStoredProcedure(procName, argsMap);
			List<EDPPostSearchView> postList = NativeQueryResultsMapper.map(objectSp, EDPPostSearchView.class);
			int count = !postList.isEmpty() && null != postList.get(0) ? postList.get(0).getTotalCount() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, count, postList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	/**
	 * Populate arguments.
	 *
	 * @param pageDetail the page detail
	 * @param index      the index
	 * @return the map
	 */
	private Map<String, Object> populateArguments(PageDetails pageDetail, int index) {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		argsMap.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		argsMap.put(Constant.IN_USER_LIST, OAuthUtility.getCurrentUserLkPOUId().toString());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(
					search -> argsMap.put(EDPConstant.getSearchList(index).get(search.getKey()), search.getValue()));
		} else {
			EDPConstant.getSearchList(index).forEach((k, v) -> argsMap.put(EDPConstant.getSearchList(index).get(k), 0));
		}
		return argsMap;
	}

	/**
	 * Gets the post count.
	 *
	 * @param countDto the count dto
	 * @return the post count
	 */
	@Override
	public EDPPostCountDTO getPostCount(EDPPostCountDTO countDto) {
		if (countDto.getPostId() != null && countDto.getPostId() != 0) {
			List<EDPPostItrEntity> postIteEntity = edpPostItrRepository
					.findByPostIdAndDesignationIdDesignationIdAndOfficeId(countDto.getPostId(),
							countDto.getDesignationId(), countDto.getOfficeId());
			List<EDPLkPostOfficeEntity> poOfficeEntityList = getPoOfficeEntityList(countDto);
			if (CollectionUtils.isNotEmpty(postIteEntity) && CollectionUtils.isNotEmpty(poOfficeEntityList)) {
				String[] strPostName = postIteEntity.get(0).getPostName().split(Constant.DASH);
				if (strPostName.length > 1 && NumberUtils.isDigits(strPostName[strPostName.length - 1].trim())) {
					countDto.setCount(Long.parseLong(strPostName[strPostName.length - 1].trim()));
				} else {
					countDto.setCount(1l);
				}
			} else {
				newPostCount(countDto);
			}
		} else {
			newPostCount(countDto);
		}

		return countDto;
	}

	/**
	 * Gets the po office entity list.
	 *
	 * @param countDto the count dto
	 * @return the po office entity list
	 */
	private List<EDPLkPostOfficeEntity> getPoOfficeEntityList(EDPPostCountDTO countDto) {
		return edpLkPostOfficeRepository
				.findByPostEntityPostId(countDto.getPostId()).stream().filter(poOfficeEntity -> {
					if (poOfficeEntity.getOfficeEntity() != null) {
						return poOfficeEntity.getOfficeEntity().getOfficeId().equals(countDto.getOfficeId());
					} else {
						return false;
					}
				}).collect(Collectors.toList());
	}

	/**
	 * New post count.
	 *
	 * @param countDto the count dto
	 */
	private void newPostCount(EDPPostCountDTO countDto) {
		EDPMsDesignationEntity designationEntity = edpmsDesignationrepository.getOne(countDto.getDesignationId());
		Long highestCount1 = repository.findPostCoundInItrByThreeDigit(countDto.getDesignationId(),
				countDto.getOfficeId(), designationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER);
		Long highestCount2 = repository.findPostCoundInByThreeDigit(countDto.getDesignationId(), countDto.getOfficeId(),
				designationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER);
		Long highestCount = compareCount(highestCount1, highestCount2);
		if (highestCount != null && highestCount > 0) {
			countDto.setCount(highestCount + EDPConstant.VALUE_ONE);
		} else {
			highestCount1 = repository.findPostCoundInItrByTwoDigit(countDto.getDesignationId(), countDto.getOfficeId(),
					designationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER);
			highestCount2 = repository.findPostCoundInByTwoDigit(countDto.getDesignationId(), countDto.getOfficeId(),
					designationEntity.getDesignationName() + EDPConstant.ARG_LIKE_OPER);
			highestCount = compareCount(highestCount1, highestCount2);
			if (highestCount != null) {
				countDto.setCount(highestCount + EDPConstant.VALUE_ONE);
			} else {
				String postName = repository.findPostNameInItr(countDto.getDesignationId(), countDto.getOfficeId(),
						designationEntity.getDesignationName());
				if (postName == null) {
					postName = repository.findPostNameIn(countDto.getDesignationId(), countDto.getOfficeId(),
							designationEntity.getDesignationName());
					if (postName == null)
						countDto.setCount(EDPConstant.LONG_VALUE_ONE);
					else
						countDto.setCount(EDPConstant.LONG_VALUE_ONE + EDPConstant.LONG_VALUE_ONE);
				} else {
					countDto.setCount(EDPConstant.LONG_VALUE_ONE + EDPConstant.LONG_VALUE_ONE);
				}
			}
		}
	}

	/**
	 * Checks if is not null and positive.
	 *
	 * @param count the count
	 * @return true, if is not null and positive
	 */
	private boolean isNotNullAndPositive(Long count) {
		return (count != null && count > 0) ? Boolean.TRUE : Boolean.FALSE;
	}

	/**
	 * Compare count.
	 *
	 * @param count1 the count 1
	 * @param count2 the count 2
	 * @return the long
	 */
	private Long compareCount(Long count1, Long count2) {
		if (isNotNullAndPositive(count1) && isNotNullAndPositive(count2)) {
			return count1 > count2 ? count1 : count2;
		} else if (isNotNullAndPositive(count1)) {
			return count1;
		} else {
			return count2;
		}

	}

	/**
	 * Avilable vacant post.
	 *
	 * @param idDto the id dto
	 * @return the EDP post office details dto
	 */
	@Override
	public EDPPostOfficeDetailsDto avilableVacantPost(IdDto idDto) {
		EDPPostOfficeDetailsDto postofficedetailsdto = new EDPPostOfficeDetailsDto();
		postofficedetailsdto
				.setVacantPost(converter.objectToClueDTO(edpLkPostUserRepository.findVacantPost(idDto.getId(),
						EDPConstant.ARG_POST_VACANT_YES, Constant.ACTIVE_STATUS, EDPConstant.STATUS_APPROVED_ID)));
		return postofficedetailsdto;
	}

	/**
	 * Search for post history report.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPPostHistoryReportView> searchForPostHistoryReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> argsMap = populateArguments(pageDetail, 7);
			argsMap.remove(Constant.IN_USER_LIST);
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.REPORT_POST_HISTORY));
			List<Object[]> objectSp = this.repository.callStoredProcedure(procName, argsMap);
			List<EDPPostHistoryReportView> postList = NativeQueryResultsMapper.map(objectSp,
					EDPPostHistoryReportView.class);
			int count = !postList.isEmpty() && null != postList.get(0) ? postList.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, count, postList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	private void generateTrnNo(EDPMsPostDto edpMsPostDto) {
		if (!isNotNullAndNotZero(edpMsPostDto.getPostId())) {
			Map<String, Object> argMap = new HashMap<>();
			argMap.put(Constant.TRN_SCREEN, edpMsPostDto.getMenucode());
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_EDP_TRN_NO_GEN));
			List<Object[]> responseList = repository.callStoredProcedure(procName, argMap);
			edpMsPostDto.setTransactionNo(EDPUtility.convertObjectToString(responseList.get(0)[0]));
		}
	}

	private boolean isNotNullAndNotZero(Long t) {
		return !(t == null || t == 0);
	}

	/**
	 * Checks if is workflow required.
	 *
	 * @param officeId the office id
	 * @param userId   the user id
	 * @return the boolean
	 */
	@Override
	public Boolean isWorkflowRequired() {
		Set<Long> roleIds = OAuthUtility.getWfRoleUsingMenuId(EDPConstant.POST_CREATION_MENU_ID);
		if (OAuthUtility.isCurrentUserIsDAT() && (roleIds.isEmpty() || roleIds.contains(45L)))
			return Boolean.FALSE;
		else
			return true;
	}

	/**
	 * Gets the listing filter data.
	 *
	 * @return the listing filter data
	 */
	@Override
	public ClueDto getListingFilterData() {
		ClueDto officedetailsdto = new ClueDto();

		List<ClueDto> distList = districtConverter.toClueDTO(
				districtRepository.findByActiveStatusAndStateId(Constant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ,
						EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC)));

		List<Object[]> dataList = repository.executeNativeSQLQuery(EDPNativeSQLUtil.GET_EDP_WF_TRN_STATUS_QUERY, null);
		Set<ClueDto> wfStatusSet = new HashSet<>();
		Set<ClueDto> trnStatusSet = new HashSet<>();
		dataList.forEach(obj -> {
			if (null != obj[0])
				trnStatusSet.add(getClueDtoForStatus(obj[0]));
			if (null != obj[1])
				trnStatusSet.add(getClueDtoForStatus(obj[1]));
			if (null != obj[2])
				wfStatusSet.add(getClueDtoForStatus(obj[2]));
			if (null != obj[3])
				wfStatusSet.add(getClueDtoForStatus(obj[3]));
		});
		officedetailsdto.setDistricts(distList);
		List<ClueDto> wfStatusList = wfStatusSet.stream().sorted((o1, o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
		List<ClueDto> trnStatusList = trnStatusSet.stream().sorted((o1, o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
		officedetailsdto.setTransStatusList(trnStatusList);
		officedetailsdto.setWorkFlowStatusList(wfStatusList);
		return officedetailsdto;
	}

	/**
	 * Gets the clue dto for status.
	 *
	 * @param status the status
	 * @return the clue dto for status
	 */
	private ClueDto getClueDtoForStatus(Object status) {
		ClueDto dto = new ClueDto();
		dto.setStatusId(EDPUtility.convertObjectToString(status));
		dto.setName(EDPUtility.convertObjectToString(status));
		return dto;
	}
}
