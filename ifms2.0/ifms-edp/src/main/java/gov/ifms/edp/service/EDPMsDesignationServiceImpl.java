package gov.ifms.edp.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPDesignationItrConverter;
import gov.ifms.edp.converter.EDPMsDesignationConverter;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.converter.EDPTrnUpdDsgnConverter;
import gov.ifms.edp.converter.EDPTrnUpdDsgnItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPAddDesignationSearchViewDto;
import gov.ifms.edp.dto.EDPEmpPostDsgnView;
import gov.ifms.edp.dto.EDPMsDesignationDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.dto.EDPOffEmpDto;
import gov.ifms.edp.dto.EDPTrnUpdDsgnDto;
import gov.ifms.edp.dto.EDPUpdateDesignationDetailsDto;
import gov.ifms.edp.dto.EDPUpdateDesignationSearchViewDto;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnEntity;
import gov.ifms.edp.entity.EDPTrnUpdDsgnItrEntity;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPDesignationItrRepository;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLkPostOfficeRepository;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsPostRepository;
import gov.ifms.edp.repository.EDPTrnUpdDsgnItrRepository;
import gov.ifms.edp.repository.EDPTrnUpdDsgnRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPNativeSQLUtil;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.edp.workflow.service.EDPWorkflowRequestHandler;

/**
 * The Class EDPMsDesignationServiceImpl.
 */
@Service
public class EDPMsDesignationServiceImpl implements EDPMsDesignationService {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(EDPMsDesignationServiceImpl.class);

	/** The EDPMsDesignationAsMethodName repository. */
	@Autowired
	private EDPMsDesignationRepository repository;

	/** The EDPMsDesignationAsMethodName repository. */
	@Autowired
	private EDPDesignationItrRepository itrRepository;

	/** The EDPMsDesignationAsMethodName helper. */
	@Autowired
	private EDPDesignationItrConverter itrConverter;

	/** The converter. */
	@Autowired
	private EDPMsDesignationConverter converter;

	/** The edp lk po off user repository. */
	@Autowired
	private EDPLkPoOffUserRepository edpLkPoOffUserRepository;

	/** The edp trn upd dsgn repository. */
	@Autowired
	private EDPTrnUpdDsgnRepository edpTrnUpdDsgnRepository;

	/** The edp trn upd dsgn converter. */
	@Autowired
	private EDPTrnUpdDsgnConverter edpTrnUpdDsgnConverter;

	/** The edp trn upd dsgn itr repository. */
	@Autowired
	private EDPTrnUpdDsgnItrRepository edpTrnUpdDsgnItrRepository;

	/** The edp trn upd dsgn itr converter. */
	@Autowired
	private EDPTrnUpdDsgnItrConverter edpTrnUpdDsgnItrConverter;

	/** The edp ms post repository. */
	@Autowired
	private EDPMsPostRepository edpMsPostRepository;

	/** The lookupinforepository. */
	@Autowired
	private EDPLuLookUpInfoRepository lookupinforepository;

	/** The post user office repository. */
	@Autowired
	private EDPLkPostOfficeRepository postOfficeRepository;

	/** The wf request handler. */
	@Autowired
	private EDPWorkflowRequestHandler wfRequestHandler;
	
	/** The district converter. */
	@Autowired
	private EDPMsDistrictConverter districtConverter;
	
	/** The district repository. */
	@Autowired
	private EDPMsDistrictRepository districtRepository;

	/**
	 * Returns all instances of the EDPMsDesignationEntity type.
	 * 
	 * @return all EDPMsDesignationEntity
	 */
	@Override
	public List<EDPMsDesignationEntity> getMsDesignations() {
		return repository.findAll();
	}

	/**
	 * Retrieves an EDPMsDesignationEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsDesignationEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsDesignationDto getMsDesignation(Long id) {
		EDPMsDesignationDto dto = converter.toDTO(repository.getOne(id));
		if(Boolean.TRUE.equals(dto.isWfInRequest())) {
			Map<String, Object> argMap = new HashMap<>();
			argMap.put(EDPConstant.TRN_ID, dto.getDesignationId());
			Object obj = repository
					.executeNativeSQLQuery(EDPNativeSQLUtil.GET_LEVEL_FOR_DSGN_WF, argMap).get(0);
			int level = EDPUtility.convertObjectToInt(obj);
			dto.setIsObjectionRequired(level != 0 );					
		}
		else {
			dto.setIsObjectionRequired(false);
		}
		return dto;
	}

	/**
	 * Saves a given EDPMsDesignationEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param desigDto the desig dto
	 * @return the saved EDPMsDesignationEntity
	 * @throws CustomException the custom exception
	 */
	@ExceptionHandler(CustomException.class)
	public EDPMsDesignationDto saveDesignation(EDPMsDesignationDto desigDto) throws CustomException {
		Long check=desigDto.getDesignationId();
		EDPMsDesignationDto responseDto = saveRequestAsDraft(desigDto);
		if (check == null && responseDto.isWfSaveDrftApiCall()) {
			wfRequestHandler.saveAsDraftWf(desigDto.getCurMenuId(), desigDto.getDesignationId());
		}
		if (Boolean.FALSE.equals(responseDto.isWfInRequest()) && responseDto.getFormAction().equals(Status.SUBMITTED)) {
			wfRequestHandler.wfDirectSubmiteApiCall(desigDto.getCurMenuId(), desigDto.getDesignationId());
		}
		return responseDto;
	}

	/**
	 * Save request as draft.
	 *
	 * @param desigDto the desig dto
	 * @return the EDP ms designation dto
	 * @throws CustomException the custom exception
	 */
	@Transactional(rollbackFor = CustomException.class)
	public EDPMsDesignationDto saveRequestAsDraft(EDPMsDesignationDto desigDto) throws CustomException {
		if (isValidDesignation(desigDto)) {
			try {

				if (desigDto.getDesignationId() == null) {
					if (!isNotNullAndNotZero(desigDto.getDesignationId())) {
						desigDto.setTrnNo(generateTrnNo(desigDto.getMenuCode()));
					}
					EDPMsDesignationEntity headerEntity = getHdrEntityData(desigDto);
					desigDto.setDesignationId(headerEntity.getDesignationId());
					desigDto.setTrnDate(headerEntity.getCreatedDate());
				}
				else {
					if(desigDto.isApprovedStatus())
						desigDto.setStatusId(EDPConstant.STATUS_APPROVE_ID);
					else
						desigDto.setStatusId(Constant.SAVE_AS_DRAFT_STATUS_ID);
				EDPMsDesignationEntity headerEntity = repository.getOne(desigDto.getDesignationId());
				desigDto.setTrnDate(headerEntity.getCreatedDate());
				headerEntity = converter.toEntity(desigDto);
				repository.save(headerEntity);
				itrRepository.save(itrConverter.toEntity(headerEntity));
				}
				updateHdrEntityStatus(desigDto);
				return desigDto;
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
			}
		} else {
			throw new CustomException(ErrorResponse.RECORD_ALREADY_EXISTS);
		}
	}

	/**
	 * Checks if is valid designation.
	 *
	 * @param dto the dto
	 * @return true, if is valid designation
	 */
	private boolean isValidDesignation(EDPMsDesignationDto dto) throws CustomException {
		if (dto.getDesignationId() != null) {
			Optional<EDPMsDesignationEntity> designationEntity = repository.findById(dto.getDesignationId());
			if (designationEntity.isPresent()) {
				return designationEntity.get().getDesignationName().equals(dto.getDesignationName()) ? Boolean.TRUE
						: isDesignationPresent(dto.getDesignationName());
			} else {
				return isDesignationPresent(dto.getDesignationName());
			}
		} else {
			return isDesignationPresent(dto.getDesignationName());
		}

	}

	/**
	 * Gets the hdr entity data.
	 *
	 * @param desigDto the desig dto
	 * @return the hdr entity data
	 */
	private EDPMsDesignationEntity getHdrEntityData(EDPMsDesignationDto desigDto) {
		desigDto.setStatusId(Constant.SAVE_AS_DRAFT_STATUS_ID);
		desigDto.setInitiatedBy(OAuthUtility.getCurrentUserLkPOUId());
		EDPMsDesignationEntity headerEntity = converter.toEntity(desigDto);
		repository.save(headerEntity);
		itrRepository.save(itrConverter.toEntity(headerEntity));
		return headerEntity;
	}

	/**
	 * Update hdr entity status.
	 *
	 * @param desigDto the desig dto
	 */
	private void updateHdrEntityStatus(EDPMsDesignationDto desigDto) {
		if ((null != desigDto.getHasObjection() && desigDto.getHasObjection())) {
			repository.updateObjectionForHeader(EDPConstant.LOOKUP_INFO_YES, desigDto.getObjectionRemarks(),
					desigDto.getDesignationId());
		}
		if ((!desigDto.isWfInRequest() || desigDto.isWfSubmit()) && null != desigDto.getDesignationId()
				&& desigDto.getFormAction().equals(Status.SUBMITTED)) {
			repository.updateStatusForHeader(desigDto.getDesignationId(), Constant.LU_APPROVED_LOOKUP_INFO_ID,
					OAuthUtility.getCurrentUserUserId(), new Date());
		}
	}

	/**
	 * Checks if is designation present.
	 *
	 * @param designationName the designation name
	 * @return true, if is designation present
	 */
	public boolean isDesignationPresent(String designationName) throws CustomException {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(Constant.IN_DESIGNATION_NAME,designationName);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.CHECK_DESIGNATION_REQUEST_EXISTS));
		List<Object[]> requestdList = repository.callStoredProcedure(procName, argMap);
		if (CollectionUtils.isEmpty(requestdList)) {
			return Boolean.TRUE;
		} else {
			if(EDPUtility.convertObjectToLong(requestdList.get(0)[7]).equals(Constant.LU_APPROVED_LOOKUP_INFO_ID))
			{
				throw new CustomException(ErrorResponse.RECORD_ALREADY_EXISTS);
			}
			else {
				throw new CustomException(10002, getErrorMessage(requestdList,designationName));				
			}
		}
	}
	
	public String getErrorMessage(List<Object[]> requestdList,String designationName) throws CustomException {

    

            String errorMessage = MessageFormat.format(MsgConstant.EDP_REQUEST_INITIATE_DESIGNATION,designationName,EDPUtility.convertObjectToString(requestdList.get(0)[6]),

                    EDPUtility.convertObjectToString(requestdList.get(0)[5]), requestdList.get(0)[3],requestdList.get(0)[4],

                    requestdList.get(0)[2], requestdList.get(0)[0], requestdList.get(0)[1]);
            throw new CustomException(10002, errorMessage);

  
}


	/**
	 * Deletes the EDPMsDesignationEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @throws CustomException          the custom exception
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteMsDesignation(Long id) throws CustomException {

		repository.updateActiveStatusByDesignationId(id, EDPConstant.INACTIVE_STATUS,
				OAuthUtility.getCurrentUserUserId(), new java.util.Date());

	}

	/**
	 * Saves all given EDPMsDesignationEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	@Override
	public List<EDPMsDesignationEntity> saveMsDesignations(List<EDPMsDesignationEntity> entities) {
		return repository.saveAll(entities);
	}

	/**
	 * Fetch all the EDPMsDesignation items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsDesignationDto>
	 */
	@Override
	public PagebleDTO<EDPMsDesignationDto> edpMsDesignationAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPMsDesignationEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();

		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<EDPMsDesignationEntity> empSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<EDPMsDesignationEntity> page = repository.findAll(empSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				converter.toDTO(page.getContent()));
	}

	/**
	 * Findactiveedp ms designation.
	 *
	 * @return the list
	 */
	@Override
	public List<EDPMsDesignationEntity> findactiveedpMsDesignation() {
		return repository.findByActiveStatusEquals(Constant.ACTIVE_STATUS);
	}

	/**
	 * Gets the update designation details dto.
	 *
	 * @param officeId the office id
	 * @return the update designation details dto
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPUpdateDesignationDetailsDto getUpdateDesignationDetailsDto(Long officeId) throws CustomException {
		try {
			EDPUpdateDesignationDetailsDto dto = new EDPUpdateDesignationDetailsDto();
			dto.setOfficeEmpDetails(getEmpByOfficeId(officeId));
			dto.setDesignation(getDesignationList());
			return dto;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the designation list.
	 *
	 * @return the designation list
	 */
	@Override
	public List<ClueDto> getDesignationList() {
		List<EDPMsDesignationEntity> designationList = repository
				.findByStatusIdLookUpInfoNameOrStatusIdIsNullAndActiveStatus(EDPConstant.LK_STATUS_VAL_APPROVED,
						OAuthConstant.ACTIVE_STATUS,
						EDPUtility.getJpaSort(EDPConstant.DESIGNATION_NAME, EDPConstant.ORDER_ASC));
		return designationList.stream().map(designation -> {
			ClueDto cluedto = new ClueDto();
			cluedto.setId(designation.getDesignationId());
			cluedto.setName(designation.getDesignationName());
			return cluedto;
		}).collect(Collectors.toList());
	}


	/**
	 * Update designation.
	 *
	 * @param entity the entity
	 * @param isCreate the is create
	 * @param isUpdate the is update
	 * @param dto the dto
	 * @return the EDP trn upd dsgn dto
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPTrnUpdDsgnDto updateDesignation(boolean isCreate, boolean isUpdate,
			EDPTrnUpdDsgnDto dto) throws CustomException {
		EDPTrnUpdDsgnEntity dsgnEntity = null;
		if(isUpdate) {
			dsgnEntity = edpTrnUpdDsgnRepository.getOne(dto.getTedpUpdDsgnId());
			dto.setCreatedDate(dsgnEntity.getCreatedDate());
			dsgnEntity = edpTrnUpdDsgnConverter.toEntity(dto);
			
		}
		else
			dsgnEntity = edpTrnUpdDsgnConverter.toEntity(dto);
		dsgnEntity = updateDsgnSave(dsgnEntity, isCreate, isUpdate,dto);
		if (dto.isWfSaveDrftApiCall()) {
			wfRequestHandler.saveAsDraftWf(dto.getCurMenuId(),
					dto.getTedpUpdDsgnId());
		}
		if ((null != dto.getWfInRequest() && dto.getWfInRequest().equals(Boolean.FALSE)) && dto.getFormAction().equals(Status.SUBMITTED)) {
			wfRequestHandler.wfDirectSubmiteApiCall(dto.getCurMenuId(),
					dto.getTedpUpdDsgnId());
		}
		if(null == dsgnEntity.getCreatedDate())
			dsgnEntity.setCreatedDate(dto.getCreatedDate());
		EDPTrnUpdDsgnDto responseDto = edpTrnUpdDsgnConverter.toDTO(dsgnEntity);
		responseDto.setFormAction(dto.getFormAction());
		return responseDto;
	}

	/**
	 * Update dsgn save.
	 *
	 * @param entity   the entity
	 * @param isCreate the is create
	 * @param isUpdate the is update
	 * @param dto      the dto
	 * @return the EDP trn upd dsgn entity
	 * @throws CustomException the custom exception
	 */
	@Transactional(rollbackFor = CustomException.class)
	public EDPTrnUpdDsgnEntity updateDsgnSave(EDPTrnUpdDsgnEntity entity, boolean isCreate, boolean isUpdate,
			EDPTrnUpdDsgnDto dto) throws CustomException {
		try {
			if (isCreate) {
				dto.setWfSaveDrftApiCall(Boolean.TRUE);
				if (dto.getMenuShCode() == null)
					throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
				entity.setTrnNo(generateTrnNo(dto.getMenuShCode()));
				EDPMsPostEntity postEntity = createDefaultPost(entity, dto);
				entity.setPostId(postEntity);
				entity.setActiveStatus(OAuthConstant.ACTIVE_STATUS);
			}
			if (isUpdate) {
				if (null == dto.getPostId()) {
					EDPMsPostEntity postEntity = createDefaultPost(entity, dto);
					entity.setPostId(postEntity);
				} else {
					entity.setPostId(new EDPMsPostEntity(dto.getPostId()));
				}
			}

			if (((null != dto.getWfInRequest() && dto.getWfInRequest().equals(Boolean.FALSE)) 
					|| dto.isWfSubmit()) && dto.getFormAction() == Status.SUBMITTED)
				entity.setStatusId(lookupinforepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED));
			else
				entity.setStatusId(lookupinforepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_SAVAS_DRAFT));
			EDPMsPostEntity activePostEntity = edpMsPostRepository.getOne(dto.getActivePostId());
			entity.setActivePostId(activePostEntity);
			entity = edpTrnUpdDsgnRepository.save(entity);
			if(null == dto.getTedpUpdDsgnId() )
				dto.setTedpUpdDsgnId(entity.getTedpUpdDsgnId());
			
			EDPTrnUpdDsgnItrEntity itrEntity = edpTrnUpdDsgnItrConverter.edpTrnUpdDsgnEntityToEntity(entity, dto);
			itrEntity.setActivePostId(activePostEntity);
			edpTrnUpdDsgnItrRepository.save(itrEntity);
			checkForPostOfficeEntity(entity);
			return entity;
		} catch (CustomException ce) {
			throw ce;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Check for post office entity.
	 *
	 * @param entity the entity
	 * @throws CustomException the custom exception
	 */
	private void checkForPostOfficeEntity(EDPTrnUpdDsgnEntity entity) throws CustomException {
		if (entity.getActivePostId() != null && entity.getPostId() != null) {
			Optional<EDPLkPostOfficeEntity> isPostOfficeEntity = postOfficeRepository
					.findByPostEntityPostIdAndOfficeEntityOfficeIdAndActiveStatus(entity.getActivePostId().getPostId(),
							entity.getOfficeId().getOfficeId(), Constant.ACTIVE_STATUS);
			if (isPostOfficeEntity.isPresent())
				insertOrUpdateDataInLkTabel(entity, isPostOfficeEntity.get());
			else
				throw new CustomException(5001, MsgConstant.EDP_INVALID_ACTIVE_POST);
		}
		
	}
	
	/**
	 * Creates the default post.
	 *
	 * @param entity the entity
	 * @param dto    the dto
	 * @return the EDP ms post entity
	 * @throws CustomException the custom exception
	 */
	private EDPMsPostEntity createDefaultPost(EDPTrnUpdDsgnEntity entity, EDPTrnUpdDsgnDto dto) throws CustomException {
		if (null != entity.getDesignationId()) {
			EDPMsPostEntity postEntity = getDefultPostEntity(dto, entity);
			return edpMsPostRepository.save(postEntity);
		}
		return null;
	}

	/**
	 * Insert or update data in lk tabel.
	 *
	 * @param entity the entity
	 * @param activePostOfficeEntity the active post office entity
	 */
	public void insertOrUpdateDataInLkTabel(EDPTrnUpdDsgnEntity entity, EDPLkPostOfficeEntity activePostOfficeEntity) {
		Optional<EDPLkPostOfficeEntity> isPostOfficeEntity = postOfficeRepository
				.findByPostEntityPostIdAndOfficeEntityOfficeIdAndActiveStatus(entity.getPostId().getPostId(),
						entity.getOfficeId().getOfficeId(), Constant.ACTIVE_STATUS);
		if (!isPostOfficeEntity.isPresent()) {
			EDPLkPostOfficeEntity postOfficeEntity = getDefultEDPLkPostOfficeEntity(entity);
			postOfficeEntity = postOfficeRepository.save(postOfficeEntity);
			if (!entity.getStatusId().getLookUpInfoName().equals(EDPConstant.LK_STATUS_VAL_APPROVED))
				deActiveLkPostOffice(postOfficeEntity.getPostOfficeId());
			else
				updateLkPOUEntity(postOfficeEntity, activePostOfficeEntity);
		} else {
			if (entity.getStatusId().getLookUpInfoName().equals(EDPConstant.LK_STATUS_VAL_APPROVED)) {
				EDPLkPostOfficeEntity postOfficeEntity = isPostOfficeEntity.get();
				postOfficeEntity.setActiveStatus(EDPConstant.ACTIVE_STATUS_TRUE);
				postOfficeEntity = postOfficeRepository.save(postOfficeEntity);
				updateLkPOUEntity(postOfficeEntity, activePostOfficeEntity);
			}
		}
	}

	/**
	 * Update lk POU entity.
	 *
	 * @param postOfficeEntity the post office entity
	 * @param activePostOfficeEntity the active post office entity
	 */
	private void updateLkPOUEntity(EDPLkPostOfficeEntity postOfficeEntity,
			EDPLkPostOfficeEntity activePostOfficeEntity) {
		EDPLkPoOffUserEntity lkPoOffUserEntity = edpLkPoOffUserRepository
				.findByLkPostOfficeIdPostOfficeIdAndActiveStatus(activePostOfficeEntity.getPostOfficeId(),
						Constant.ACTIVE_STATUS);
		lkPoOffUserEntity.setLkPostOfficeId(postOfficeEntity);
		edpLkPoOffUserRepository.save(lkPoOffUserEntity);
	}

	/**
	 * De active lk post office.
	 *
	 * @param lkPostOfficeId the lk post office id
	 * @return the int
	 */
	public int deActiveLkPostOffice(Long lkPostOfficeId) {
		return postOfficeRepository.deleteLkPostOffice(lkPostOfficeId, EDPConstant.INACTIVE_STATUS,
				OAuthUtility.getCurrentUserUserId(), new Date());
	}

	/**
	 * Gets the defult EDP lk post office entity.
	 *
	 * @param entity the entity
	 * @return the defult EDP lk post office entity
	 */
	public EDPLkPostOfficeEntity getDefultEDPLkPostOfficeEntity(EDPTrnUpdDsgnEntity entity) {
		EDPLkPostOfficeEntity postOfficeEntity = new EDPLkPostOfficeEntity();
		postOfficeEntity.setPostEntity(entity.getPostId());
		postOfficeEntity.setOfficeEntity(entity.getOfficeId());
		postOfficeEntity.setIsVacant(new EDPLuLookUpInfoEntity(1l));
		return postOfficeEntity;
	}

	/**
	 * Gets the defult post entity.
	 *
	 * @param dto    the dto
	 * @param entity the entity
	 * @return the defult post entity
	 * @throws CustomException the custom exception
	 */
	private EDPMsPostEntity getDefultPostEntity(EDPTrnUpdDsgnDto dto, EDPTrnUpdDsgnEntity entity)
			throws CustomException {
		EDPMsPostEntity postEntity = new EDPMsPostEntity();
		String validPostName = getValidPostName(dto);
		postEntity.setDesignationId(entity.getDesignationId());
		postEntity.setPostName(validPostName);
		if (((null != dto.getWfInRequest() && dto.getWfInRequest().equals(Boolean.FALSE)) || 
				dto.isWfSubmit()) && dto.getFormAction() == Status.SUBMITTED)
			postEntity.setActiveStatus(EDPConstant.ACTIVE_STATUS_TRUE);
		else
			postEntity.setActiveStatus(EDPConstant.INACTIVE_STATUS);
		return postEntity;
	}

	/**
	 * Update dsgn delete.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	@Override
	public boolean updateDsgnDelete(Long id) {
		Optional<EDPTrnUpdDsgnEntity> entity = edpTrnUpdDsgnRepository.findById(id);
		if (!entity.isPresent())
			return false;
		EDPMsPostDto dDPMsPostDto = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
		entity.get().setUpdatedBy(OAuthUtility.getCurrentUserUserId());
		entity.get().setUpdatedByPost(dDPMsPostDto.getPostId());
		entity.get().setUpdatedDate(new Date());
		entity.get().setActiveStatus(EDPConstant.INACTIVE_STATUS);
		edpTrnUpdDsgnRepository.save(entity.get());
		return true;
	}

	/**
	 * Gets the upd dsgn by id.
	 *
	 * @param id the id
	 * @return the upd dsgn by id
	 * @throws CustomException 
	 */
	@Override
	public EDPTrnUpdDsgnDto getUpdDsgnById(Long id) throws CustomException {
		EDPTrnUpdDsgnDto dto = edpTrnUpdDsgnConverter.toDTO(edpTrnUpdDsgnRepository.getOne(id));
		List<EDPEmpPostDsgnView> empPostView= getActivePostForEmpInOffice(dto.getOfficeId(), dto.getEmpNo());
		List<String> postIds = empPostView.stream().map(EDPEmpPostDsgnView::getPostId).collect(Collectors.toList());
		if(!postIds.contains(dto.getActivePostId().toString())) {
			EDPMsPostEntity postEntity = edpMsPostRepository.getOne(dto.getActivePostId());
			EDPEmpPostDsgnView activePostView = new EDPEmpPostDsgnView();
			activePostView.setPostId(postEntity.getPostId().toString());
			activePostView.setPostName(postEntity.getPostName());
			activePostView.setDesignationId(postEntity.getDesignationId().getDesignationId().toString());
			if(!CollectionUtils.isEmpty(empPostView))
				activePostView.setEmpId(empPostView.get(0).getEmpId());
			empPostView.add(activePostView);
		}
		dto.setEmpPostView(empPostView);
		
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(EDPConstant.TRN_ID, id);
		Object obj = edpTrnUpdDsgnRepository
				.executeNativeSQLQuery(EDPNativeSQLUtil.GET_LEVEL_FOR_UPD_WF, argMap).get(0);
		int level = EDPUtility.convertObjectToInt(obj);
		dto.setObjectionRequired(level != 0 && dto.getWfInRequest().equals(Boolean.TRUE));
		return dto;
	}

	/**
	 * Search listfor upd dsg.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPUpdateDesignationSearchViewDto> searchListforUpdDsg(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> map = EDPUtility.populateArgumentsWfList(pageDetail, 9);
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_EDP_SEARCH_UPD_DSG));
			List<Object[]> objectSp = this.repository.callStoredProcedure(procName, map);
			int totalPages = objectSp.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), totalPages, totalPages,
					NativeQueryResultsMapper.map(objectSp, EDPUpdateDesignationSearchViewDto.class));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	/**
	 * Search listfor add designation.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPAddDesignationSearchViewDto> searchListforAddDesignation(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> argsMap = EDPUtility.populateArguments(pageDetail, 5);
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_EDP_SEARCH_ADD_DSG));
			List<Object[]> objectSp = repository.callStoredProcedure(procName, argsMap);
			List<EDPAddDesignationSearchViewDto> dsgnList = NativeQueryResultsMapper.map(objectSp,
					EDPAddDesignationSearchViewDto.class);
			int count = !dsgnList.isEmpty() && null != dsgnList.get(0) ? dsgnList.get(0).getTotalCount() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, count, dsgnList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	/**
	 * Gets the post details by designtion id.
	 *
	 * @param dto the dto
	 * @return the post details by designtion id
	 * @throws CustomException the custom exception
	 */
	@Override
	public ClueDto getPostDetailsByDesigntionId(ClueDto dto) throws CustomException {
		if (null == dto.getTrnNo()) {
			return getNewPostForOfficeAndDesignation(dto.getOfficeId(), dto.getDesignationId());
		} else {
			List<EDPTrnUpdDsgnItrEntity> itrEntityList = edpTrnUpdDsgnItrRepository
					.findByTrnNoAndDesignationIdDesignationIdAndOfficeIdOfficeId(dto.getTrnNo(), dto.getDesignationId(),
							dto.getOfficeId());
			if (CollectionUtils.isEmpty(itrEntityList)) {
				return getNewPostForOfficeAndDesignation(dto.getOfficeId(), dto.getDesignationId());
			} else {
				Optional<EDPMsPostEntity> post = itrEntityList.stream().map(EDPTrnUpdDsgnItrEntity::getPostId)
						.findFirst();
				if (post.isPresent()) {
					ClueDto clueDto = new ClueDto();
					clueDto.setId(post.get().getPostId());
					clueDto.setName(post.get().getPostName());
					return clueDto;
				}
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
			}
		}
	}

	/**
	 * Gets the new post for office and designation.
	 *
	 * @param officeId the office id
	 * @param designationId the designation id
	 * @return the new post for office and designation
	 */
	public ClueDto getNewPostForOfficeAndDesignation(Long officeId, Long designationId) {
		EDPMsDesignationEntity desi = repository.getOne(designationId);
		Long postCount = getPostCountFromPostItr(desi.getDesignationName(), officeId, designationId);
		Long postItrCount = getPostCountFromMsPost(desi.getDesignationName(), officeId, designationId);
		return getClueDtoForPostCount(postCount, postItrCount);
	}

	/**
	 * Gets the new post for office and designation.
	 *
	 * @param designationName the designation name
	 * @param officeId      the office id
	 * @param designationId the designation id
	 * @return the new post for office and designation
	 */
	public Long getPostCountFromPostItr(String designationName, Long officeId, Long designationId) {
		String designationNameLike = designationName + EDPConstant.ARG_LIKE_OPER;
		Long postCountThree = edpMsPostRepository.findPostCoundInItrByThreeDigit(designationId, officeId,
				designationNameLike);
		if (postCountThree == null || postCountThree < 0) {
			Long postCountTwo = edpMsPostRepository.findPostCoundInItrByTwoDigit(designationId, officeId,
					designationNameLike);
			if (postCountTwo == null) {
				String postName = edpMsPostRepository.findPostNameInItr(designationId, officeId, designationName);
				return null != postName ? 1l : 0l;
			} else {
				return postCountTwo;
			}
		} else {
			return postCountThree;
		}
	}

	/**
	 * Gets the post count from ms post.
	 *
	 * @param designationName the designation name
	 * @param officeId the office id
	 * @param designationId the designation id
	 * @return the post count from ms post
	 */
	public Long getPostCountFromMsPost(String designationName, Long officeId, Long designationId) {
		String designationNameLike = designationName + EDPConstant.ARG_LIKE_OPER;
		Long postCountThree = edpMsPostRepository.findPostCoundInByThreeDigit(designationId, officeId,
				designationNameLike);
		if (postCountThree == null || postCountThree < 0) {
			Long postCountTwo = edpMsPostRepository.findPostCoundInByTwoDigit(designationId, officeId,
					designationNameLike);
			if (postCountTwo == null) {
				String postName = edpMsPostRepository.findPostNameIn(designationId, officeId, designationName);
				return null != postName ? 1l : 0l;
			} else {
				return postCountTwo;
			}
		} else {
			return postCountThree;
		}
	}

	/**
	 * Gets the clue dto for post count.
	 *
	 * @param postCount the post count
	 * @param postItr the post itr
	 * @return the clue dto for post count
	 */
	private ClueDto getClueDtoForPostCount(Long postCount, Long postItr) {
		ClueDto dto = new ClueDto();
		if (postCount == null && postItr == null) {
			dto.setCount(1l);
		} else if (postCount == null) {
			dto.setCount(postItr + 1l);
		} else if (postItr == null) {
			dto.setCount(postCount + 1l);
		} else {
			Long count = postCount > postItr ? postCount : postItr;
			dto.setCount(count == 0l ? 1 : count + 1);
		}
		return dto;
	}

	/**
	 * Gets the valid post name.
	 *
	 * @param dto the dto
	 * @return the valid post name
	 * @throws CustomException the custom exception
	 */
	public String getValidPostName(EDPTrnUpdDsgnDto dto) throws CustomException {
		String validPostName = null;
		ClueDto clueDto = getClueDtoForPostName(dto);
		ClueDto postNameClueDto = getPostDetailsByDesigntionId(clueDto);
		if (null != postNameClueDto.getId()) {
			validPostName = postNameClueDto.getName();
		} else {
			String designationName = designationNameFromId(dto.getDesignationId());
			validPostName = postNameClueDto.getCount() > 1 ? designationName + Constant.SINGLE_SPACE + Constant.DASH
					+ Constant.SINGLE_SPACE + postNameClueDto.getCount() : designationName;
		}
		return validPostName;
	}

	/**
	 * Gets the clue dto for post name.
	 *
	 * @param dto the dto
	 * @return the clue dto for post name
	 */
	public ClueDto getClueDtoForPostName(EDPTrnUpdDsgnDto dto) {
		ClueDto clueDto = new ClueDto();
		clueDto.setOfficeId(dto.getOfficeId());
		clueDto.setDesignationId(dto.getDesignationId());
		if (null != dto.getTrnNo())
			clueDto.setTrnNo(dto.getTrnNo());
		return clueDto;
	}

	/**
	 * Designation name from id.
	 *
	 * @param designationId the designation id
	 * @return the string
	 */
	public String designationNameFromId(Long designationId) {
		Optional<EDPMsDesignationEntity> entity = repository.findById(designationId);
		return entity.isPresent() ? entity.get().getDesignationName() : EDPConstant.EMPTY_STRING;
	}

	/**
	 * Checks if is not null and not zero.
	 *
	 * @param t the t
	 * @return true, if is not null and not zero
	 */
	private boolean isNotNullAndNotZero(Long t) {
		return !(t == null || t == 0);
	}

	/**
	 * Generate trn no.
	 *
	 * @param menuCode the menu code
	 * @return the string
	 */
	private String generateTrnNo(String menuCode) {
			Map<String, Object> argMap = new HashMap<>();
			argMap.put(Constant.TRN_SCREEN, menuCode);
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_EDP_TRN_NO_GEN));
			List<Object[]> responseList = repository.callStoredProcedure(procName, argMap);
			return EDPUtility.convertObjectToString(responseList.get(0)[0]);
	}

	/**
	 * Checks if is workflow required.
	 * @return the boolean
	 */
	@Override
	public Boolean isWorkflowRequired() {
		Set<Long> roleIds = OAuthUtility.getWfRoleUsingMenuId(EDPConstant.ADD_NEW_DESIGNATION_MENU_ID);
		 return (!(OAuthUtility.isCurrentUserIsDAT() && (roleIds.isEmpty() || roleIds.contains(45L))));

	}
	
	/**
	 * Gets the listing filter data.
	 *
	 * @return the listing filter data
	 */
	@Override
	public ClueDto getListingFilterData() {
		ClueDto officedetailsdto = new ClueDto();		
		List<ClueDto> distList = getDistrictsDto();
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(EDPConstant.ARGS_MENU_ID, EDPConstant.ADD_NEW_DESIGNATION_MENU_ID);
		List<Object[]> dataList = repository.executeNativeSQLQuery(EDPNativeSQLUtil.GET_EDP_WF_TRN_STATUS_BY_MENU_ID_QUERY,argMap);
        officedetailsdto.setDistricts(distList);
        populateTrnAndWfStatus(officedetailsdto, dataList);
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

	/**
	 * Checks if is workflow required for update.
	 *
	 * @return the boolean
	 */
	@Override
	public Boolean isWorkflowRequiredForUpdate() {
		Set<Long> roleIds = OAuthUtility.getWfRoleUsingMenuId(EDPConstant.UPDATE_DESIGNATION_MENU_ID);
		 return (!(OAuthUtility.isCurrentUserIsDAT() && (roleIds.isEmpty() || roleIds.contains(45L))));
	}

	/**
	 * Gets the listing filter data for upd.
	 *
	 * @return the listing filter data for upd
	 */
	@Override
	public ClueDto getListingFilterDataForUpd() {
		ClueDto officedetailsdto = new ClueDto();
		List<ClueDto> distList = getDistrictsDto();
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(EDPConstant.ARGS_MENU_ID, EDPConstant.UPDATE_DESIGNATION_MENU_ID);
		List<Object[]> dataList = repository.executeNativeSQLQuery(EDPNativeSQLUtil.GET_EDP_WF_TRN_STATUS_BY_MENU_ID_QUERY,argMap);
		populateTrnAndWfStatus(officedetailsdto,dataList);
        officedetailsdto.setDistricts(distList);
	    return officedetailsdto;
	}

	/**
	 * Gets the districts dto.
	 *
	 * @return the districts dto
	 */
	private List<ClueDto> getDistrictsDto(){
		return districtConverter.toClueDTO(districtRepository.findByActiveStatusAndStateId(Constant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ,
				EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC)));
	}
	
	/**
	 * Populate trn and wf status.
	 *
	 * @param officedetailsdto the officedetailsdto
	 * @param dataList the data list
	 */
	private void populateTrnAndWfStatus(ClueDto officedetailsdto, List<Object[]> dataList) {
		Set<ClueDto> wfStatusSet = new HashSet<>();
		Set<ClueDto> trnStatusSet = new HashSet<>();
		dataList.forEach(obj->{
			if(null != obj[0]) 				
				trnStatusSet.add(getClueDtoForStatus(obj[0]));		
			if(null != obj[1]) 
				trnStatusSet.add(getClueDtoForStatus(obj[1]));	
			if(null != obj[2]) 			
				wfStatusSet.add(getClueDtoForStatus(obj[2]));	
			if(null != obj[3]) 
				wfStatusSet.add(getClueDtoForStatus(obj[3]));	
		});
		List<ClueDto> wfStatusList = wfStatusSet.stream().sorted((o1, o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
		List<ClueDto> trnStatusList = trnStatusSet.stream().sorted((o1, o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
        officedetailsdto.setTransStatusList(trnStatusList);
        officedetailsdto.setWorkFlowStatusList(wfStatusList);
	}

	@Override
	public List<EDPEmpPostDsgnView> getActivePostForEmpInOffice(Long officeId, String empNo) throws CustomException {
		List<Object[]> result = null;
		Map<String, Object> paramMap = new LinkedHashMap<>();
		paramMap.put(EDPConstant.IN_OFFICE_ID_VALUE, officeId);
		paramMap.put(EDPConstant.EMP_NO_VALUE, empNo);
		String procName = Constant.EDP_SCHEMA
				.concat(Constant.DOT.concat(EDPConstant.SP_GET_EMP_POST_AND_DSGN_BY_OFFICE));
		result = repository.callStoredProcedure(procName, paramMap);
		return NativeQueryResultsMapper.map(result, EDPEmpPostDsgnView.class);
	}
	
	private List<EDPOffEmpDto> getEmpByOfficeId(long officeId) throws CustomException {
		List<EDPLkPoOffUserEntity> lkPoOffUserEntity = edpLkPoOffUserRepository
				.findByLkPostOfficeIdOfficeEntityOfficeIdAndActiveStatusAndLkPostOfficeIdActiveStatus(officeId, Constant.ACTIVE_STATUS, Constant.ACTIVE_STATUS);

		Set<Long> userId = lkPoOffUserEntity.stream().map(entity -> entity.getUserId().getUserId())
				.collect(Collectors.toSet());

		List<EDPOffEmpDto> clueDtoSet = new ArrayList<>();
		if(!userId.isEmpty()) {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put(EDPConstant.USER_ID, userId);

			clueDtoSet = NativeQueryResultsMapper.map(
					repository.executeSQLQuery(EDPNativeSQLUtil.GET_OFFICE_EMPS, paramMap), EDPOffEmpDto.class);

			Collections.sort(clueDtoSet);
			
		}

		return clueDtoSet;

	}
	
	@Override
	public void checkUpdateDesignationRequestExists(Long postId) throws CustomException {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(Constant.IN_POST_ID,postId);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.CHECK_UPD_DESIGNATION_REQUEST_EXISTS));
		List<Object[]> requestdList = repository.callStoredProcedure(procName, argMap);
		if(!requestdList.isEmpty()) {
			getErrorMessageForUpd(requestdList);
		}	
	}

	private void getErrorMessageForUpd(List<Object[]> requestdList) throws CustomException {
		String errorMessage = MessageFormat.format(MsgConstant.EDP_REQUEST_INITIATE_UPDATE_DESIGNATION,
				EDPUtility.convertObjectToString(requestdList.get(0)[0]),EDPUtility.convertObjectToString(requestdList.get(0)[9]), 
				EDPUtility.convertObjectToString(requestdList.get(0)[10]),EDPUtility.convertObjectToString(requestdList.get(0)[7]),
				requestdList.get(0)[8], requestdList.get(0)[1], requestdList.get(0)[2], requestdList.get(0)[3],
				requestdList.get(0)[4], EDPUtility.convertObjectToString(requestdList.get(0)[5]));
		throw new CustomException(10001, errorMessage);
	}

}
