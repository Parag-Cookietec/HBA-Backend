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

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.converter.EDPLuLookUpInfoConverter;
import gov.ifms.edp.converter.EDPMsDepartmentConverter;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.converter.EDPMsOfficeConverter;
import gov.ifms.edp.converter.EDPMsPostConverter;
import gov.ifms.edp.converter.EDPMsTalukaConverter;
import gov.ifms.edp.converter.EDPMsUserConverter;
import gov.ifms.edp.converter.EDPOfficeItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPIdDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.dto.EDPOffTypeAndSubTypeDto;
import gov.ifms.edp.dto.EDPOfficeDetailsDto;
import gov.ifms.edp.dto.EDPOfficeDivisionDto;
import gov.ifms.edp.dto.EDPOfficeDto;
import gov.ifms.edp.dto.EDPOfficeHistoryReportView;
import gov.ifms.edp.dto.EDPOfficeTransferDetails;
import gov.ifms.edp.dto.EDPWorkflowStatusDto;
import gov.ifms.edp.employe.EDPEmployeConverter;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.employe.EDPEmployeRepository;
import gov.ifms.edp.entity.EDPLkEmpUserEntity;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.entity.EDPLkUserMenuEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPOfficeBillMapEntity;
import gov.ifms.edp.entity.EDPOfficeBillMapItrEntity;
import gov.ifms.edp.entity.EDPOfficeItrEntity;
import gov.ifms.edp.entity.EDPOfficeModuleEntity;
import gov.ifms.edp.entity.EDPTrnUserMnuRolePrmEntity;
import gov.ifms.edp.entity.EDPTrnUsrMnuWfRole;
import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;
import gov.ifms.edp.entity.EDPUserRoleMappingEntity;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLkEmpUserRepository;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLkPostUserOfficeRepository;
import gov.ifms.edp.repository.EDPLkPuoMenuRLWFRepository;
import gov.ifms.edp.repository.EDPLkPuoMenuRolesRepository;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDepartmentRepository;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsMenuRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPMsPostRepository;
import gov.ifms.edp.repository.EDPMsRolePermissionsRepository;
import gov.ifms.edp.repository.EDPMsTalukaRepository;
import gov.ifms.edp.repository.EDPMsUserRepository;
import gov.ifms.edp.repository.EDPOfficeBillMapItrRepository;
import gov.ifms.edp.repository.EDPOfficeBillMapRepository;
import gov.ifms.edp.repository.EDPOfficeItrRepository;
import gov.ifms.edp.repository.EDPOfficeModuleRepository;
import gov.ifms.edp.repository.EDPTrnUserMnuRolePrmRepository;
import gov.ifms.edp.repository.EDPUpdateOfficeTrnRepository;
import gov.ifms.edp.repository.EDPUserRoleMappingRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsHeaderRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPNativeSQLUtil;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.edp.workflow.service.EDPWorkflowRequestHandler;

/**
 * The Class EDPMsOfficeServiceImpl.
 */
@Service
public class EDPMsOfficeServiceImpl implements EDPMsOfficeService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPMsOfficeAsMethodName repository. */
	@Autowired
	private EDPMsOfficeRepository repository;

	/** The EDPMsOfficeAsMethodName helper. */
	@Autowired
	private EDPMsOfficeConverter converter;

	/** The look up info repository. */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/** The edp ms district repository. */
	@Autowired
	private EDPMsDistrictRepository edpMsDistrictRepository;

	/** The edp ms taluka repository. */
	@Autowired
	private EDPMsTalukaRepository edpMsTalukaRepository;

	/** The service. */
	@Autowired
	private EDPLuLookUpInfoService lookupinfoservice;

	/** The converter. */
	@Trace
	@Autowired
	private EDPLuLookUpInfoConverter lookupinfoconverter;

	/** The edpmsdepartmentservice. */
	@Autowired
	private EDPMsDepartmentService edpmsdepartmentservice;

	/** The edp ms department converter. */
	@Autowired
	private EDPMsDepartmentConverter edpMsDepartmentConverter;

	/** The edp lu look up info repository. */
	@Autowired
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	/** The edp ms office converter. */
	@Autowired
	private EDPMsOfficeConverter edpMsOfficeConverter;

	/** The office itr repository. */
	@Autowired
	private EDPOfficeItrRepository officeItrRepository;

	/** The office itr converter. */
	@Autowired
	private EDPOfficeItrConverter officeItrConverter;

	/** The designation repository. */
	@Autowired
	private EDPMsDesignationRepository designationRepository;

	/** The post repository. */
	@Autowired
	private EDPMsPostRepository postRepository;

	/** The district converter. */
	@Autowired
	private EDPMsDistrictConverter districtConverter;

	/** The taluka converter. */
	@Autowired
	private EDPMsTalukaConverter talukaConverter;

	/** The post user office repository. */
	@Autowired
	private EDPLkPostUserOfficeRepository postUserOfficeRepository;

	/** The emp user repository. */
	@Autowired
	private EDPLkEmpUserRepository empUserRepository;

	/** The menu repository. */
	@Autowired
	private EDPMsMenuRepository menuRepository;

	/** The role permissions repository. */
	@Autowired
	private EDPMsRolePermissionsRepository rolePermissionsRepository;

	/** The menu roles repository. */
	@Autowired
	private EDPLkPuoMenuRolesRepository menuRolesRepository;

	/** The user repository. */
	@Autowired
	private EDPMsUserRepository userRepository;

	/** The employe repository. */
	@Autowired
	private EDPEmployeRepository employeRepository;

	/** The user converter. */
	@Autowired
	private EDPMsUserConverter userConverter;

	/** The pvu employe converter. */
	@Autowired
	private EDPEmployeConverter pvuEmployeConverter;

	/** The office bill map repository. */
	@Autowired
	private EDPOfficeBillMapRepository officeBillMapRepository;

	/** The office bill map itr repository. */
	@Autowired
	private EDPOfficeBillMapItrRepository officeBillMapItrRepository;

	/** The office module repository. */
	@Autowired
	private EDPOfficeModuleRepository officeModuleRepository;

	/** The lk po off user repository. */
	@Autowired
	private EDPLkPoOffUserRepository lkPoOffUserRepository;

	/** The trn user mnu role prm repository. */
	@Autowired
	private EDPTrnUserMnuRolePrmRepository trnUserMnuRolePrmRepository;

	/** The office bill map service. */
	@Autowired
	private EDPOfficeBillMapService officeBillMapService;

	/** The edp ms post converter. */
	@Autowired
	private EDPMsPostConverter edpMsPostConverter;

	/** The district repository. */
	@Autowired
	private EDPMsDistrictRepository districtRepository;

	/** The edp ms sub office service impl. */
	@Autowired
	private EDPMsSubOfficeServiceImpl edpMsSubOfficeServiceImpl;

	/** The lk puo menu RLWF repository. */
	@Autowired
	private EDPLkPuoMenuRLWFRepository lkPuoMenuRLWFRepository;

	/** The edp user role mapping repository. */
	@Autowired
	private EDPUserRoleMappingRepository edpUserRoleMappingRepository;

	/** * EDP User Transaction Header Repository. */
	@Autowired
	EDPUsrPoTrnsHeaderRepository edpUsrPoTrnsHeaderRepository;

	/** The wf request handler. */
	@Autowired
	private EDPWorkflowRequestHandler wfRequestHandler;

	/** The edp ms sub office service. */
	@Autowired
	private EDPMsSubOfficeService edpMsSubOfficeService;

	/** The update repository. */
	@Autowired
	private EDPUpdateOfficeTrnRepository edpOfficeTrnRepository;

	/** The EDPMsTreasuryServiceImpl. */
	@Autowired
	private EDPMsTreasuryServiceImpl edpMsTreasuryServiceImpl;

	@Autowired
	private EntityManager entityManager;

	/** The edpmsdepartmentservice. */
	@Autowired
	private EDPMsDepartmentServiceImpl edpmsdepartmentserviceImpl;

	@Autowired
	private EDPMsDepartmentRepository edpDepartmentRepository;

	/**
	 * Returns all instances of the EDPMsOfficeEntity type.
	 *
	 * @return all EDPMsOfficeEntity
	 */
	@Override
	public List<EDPMsOfficeEntity> getMsOffices() {
		return repository.findAll();
	}

	/**
	 * Retrieves an EDPMsOfficeEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the EDPMsOfficeEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsOfficeDto getMsOffice(Long id) {
		EDPMsOfficeEntity entity = repository.findByOfficeIdAndActiveStatus(id, EDPConstant.ACTIVE_STATUS_TRUE);
		EDPMsOfficeDto officeDto = edpMsOfficeConverter.toDTO(entity);
		if (entity.getIsUpdate().getLookUpInfoId() == EDPConstant.LOOKUP_INFO_YES) {
			List<EDPOfficeBillMapItrEntity> billMapEntitiesItr = officeBillMapItrRepository
					.findByOfficeIdAndActiveStatus(id, Constant.ACTIVE_STATUS);
			if (!CollectionUtils.isEmpty(billMapEntitiesItr)) {
				officeDto.setBillSubmittedTo(billMapEntitiesItr.get(0).getBillSubmittedTo());
				officeDto.setBillType(billMapEntitiesItr.get(0).getBillType());
				officeDto.setSelectedBills(billMapEntitiesItr.stream().map(EDPOfficeBillMapItrEntity::getBillListId)
						.collect(Collectors.toSet()));
			}
		} else {
			List<EDPOfficeBillMapEntity> billMapEntitiesItr = officeBillMapRepository.findByOfficeIdAndActiveStatus(id,
					Constant.ACTIVE_STATUS);
			if (!CollectionUtils.isEmpty(billMapEntitiesItr)) {
				officeDto.setBillSubmittedTo(billMapEntitiesItr.get(0).getBillSubmittedTo());
				officeDto.setBillType(billMapEntitiesItr.get(0).getBillType());
				officeDto.setSelectedBills(billMapEntitiesItr.stream().map(EDPOfficeBillMapEntity::getBillListId)
						.collect(Collectors.toSet()));
			}
		}

		List<EDPOfficeModuleEntity> officeModuleEntities = officeModuleRepository.findByOfficeIdAndActiveStatus(id,
				Constant.ACTIVE_STATUS);
		setNameById(entity, officeDto, officeModuleEntities);
		Long prvOfficeStatusId = officeItrRepository.findLastApprovedOfficeStatus(id);
		if (prvOfficeStatusId != null) {
			EDPLuLookUpInfoEntity lookUpInfo = lookUpInfoRepository.findBylookUpInfoId(prvOfficeStatusId);
			if (lookUpInfo != null) {
				officeDto.setPrvOfficeStatusId(prvOfficeStatusId);
				officeDto.setPrvOfficeStatus(lookUpInfo.getLookUpInfoName());
			}
		}
		return officeDto;
	}

	/**
	 * Sets the name by id.
	 *
	 * @param entity               the entity
	 * @param officeDto            the office dto
	 * @param officeModuleEntities the office module entities
	 */
	public void setNameById(EDPMsOfficeEntity entity, EDPMsOfficeDto officeDto,
			List<EDPOfficeModuleEntity> officeModuleEntities) {
		if (!CollectionUtils.isEmpty(officeModuleEntities)) {
			officeDto.setModuleId(
					officeModuleEntities.stream().map(EDPOfficeModuleEntity::getModuleId).collect(Collectors.toList()));
		}
		if (null != entity.getLevelId()) {
			officeDto.setLevelName(getNameByLookUpId(entity.getLevelId()));
		}
		if (null != entity.getDdoType()) {
			officeDto.setDdoTypeName(getNameByLookUpId(Long.parseLong(entity.getDdoType() + "")));
		}
		if (null != entity.getNonDdo()) {
			officeDto.setNonDdoTypeName(getNameByLookUpId(entity.getNonDdo()));
		}
		if (null != entity.getPvuId()) {
			officeDto.setPvuName(getNameByLookUpId(entity.getPvuId()));
		}
		if (null != entity.getRequestTo()) {
			officeDto.setRequestToName(getNameByLookUpId(entity.getRequestTo()));
		}
		if (null != entity.getTreasuryType()) {
			officeDto.setTreasuryTypeName(getNameByLookUpId(entity.getTreasuryType()));
		}
		if (null != entity.getIsCo()) {
			officeDto.setIsCoName(getNameByLookUpId(entity.getIsCo()));
		} else {
			officeDto.setIsCoName(getNameByLookUpId(1l));
		}
		if (null != entity.getHodId()) {
			EDPMsOfficeEntity hodEntity = repository.getOne(Long.parseLong(entity.getHodId() + ""));
			officeDto.setHodName(hodEntity.getOfficeName());
		}
		if (null != entity.getCoId()) {
			officeDto.setCoDesgName(getDesignationNameById(Long.parseLong(entity.getCoId() + "")));
		}
		if (null != entity.getDesgDdoId()) {
			officeDto.setDesgDdoName(getDesignationNameById(entity.getDesgDdoId()));
		}
	}

	/**
	 * Gets the designation name by id.
	 *
	 * @param id the id
	 * @return the designation name by id
	 */
	public String getDesignationNameById(Long id) {
		Optional<EDPMsDesignationEntity> designationEntityPresent = designationRepository.findById(id);
		if (designationEntityPresent.isPresent()) {
			EDPMsDesignationEntity designationEntity = designationEntityPresent.get();
			return designationEntity.getDesignationName();
		}
		return null;
	}

	/**
	 * Gets the name by look up id.
	 *
	 * @param id the id
	 * @return the name by look up id
	 */
	public String getNameByLookUpId(Long id) {
		EDPLuLookUpInfoEntity lookUpInfoEnties = lookUpInfoRepository.findBylookUpInfoId(id);
		return lookUpInfoEnties != null ? lookUpInfoEnties.getLookUpInfoName() : "";
	}

	/**
	 * Saves a given EDPMsOfficeEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param officeEntity the office entity
	 * @param isCreate     the is create
	 * @param isUpdate     the is update
	 * @param dto          the dto
	 * @return the saved EDPMsOfficeEntity
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class, CustomException.class })
	public EDPMsOfficeEntity saveAsDraftMsOffice(EDPMsOfficeEntity officeEntity, boolean isCreate, boolean isUpdate,
			EDPMsOfficeDto dto) throws CustomException {
		EDPMsOfficeEntity edpMsOfficeEntity = null;
		if (dto.getOfficeId() == 0) {
			setTransactionNumber(officeEntity, isCreate, isUpdate, dto);
			officeEntity.setInitiatedBy(dto.getInitiatedBy());
			officeEntity.setWfInRequest(dto.getWfInRequest());
		}
		try {
			if (dto.getOfficeTypeId() != null && dto.getHodId() != null
					&& dto.getOfficeTypeId().equals(EDPConstant.DDO_TYPE_ID)) {
				officeEntity.setParentOfficeId(Long.valueOf(dto.getHodId()));
			}
			if (isUpdate || (dto.getOfficeStatus() != null && (dto.getOfficeStatus() == 281
					|| dto.getOfficeStatus() == 282 || dto.getOfficeStatus() == 283))) {
				officeEntity.setIsUpdate(new EDPLuLookUpInfoEntity(2l));
				officeEntity.setStatusId(Short.valueOf(String.valueOf(205)));
			} else {
				officeEntity.setStatusId(Short.valueOf(String.valueOf(205)));
				officeEntity.setIsUpdate(new EDPLuLookUpInfoEntity(1l));
			}
			if (isUpdate) {
				setCurrentUserDataInCreatedData(officeEntity);
			}
			if (officeEntity != null && officeEntity.getOfficeTypeId() != null
					&& officeEntity.getOfficeTypeId().getLookUpInfoId() == EDPConstant.HOD_ID) {
				officeEntity.setIsHod(2l);
			} else {
				officeEntity.setIsHod(1l);
			}
			officeEntity.setObjection(dto.getObjection());
			officeEntity.setObjectionRemarks(dto.getObjectionRemarks());
			edpMsOfficeEntity = performSubmitAction(officeEntity, isUpdate, dto);
			if (officeEntity.getPvuId() != null && officeEntity.getPvuId() == 0) {
				edpMsOfficeEntity.setPvuId(edpMsOfficeEntity.getOfficeId());
				repository.updatePVUIdByOfficeId(edpMsOfficeEntity.getOfficeId(), edpMsOfficeEntity.getOfficeId());
			}
			EDPOfficeItrEntity edpOfficeItrEntity = officeItrConverter.toEntity(edpMsOfficeEntity);
			officeItrRepository.save(edpOfficeItrEntity);
			dto.setOfficeId(edpMsOfficeEntity.getOfficeId());
			officeBillMapService.saveOfficeBillMap(dto, isUpdate);
			edpMsSubOfficeServiceImpl.updateAllSubOfficeData(edpMsOfficeEntity);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
		return edpMsOfficeEntity;
	}

	/**
	 * given api checks whether workflow is required or not.
	 *
	 * @param menuId the menu id
	 * @return boolean
	 */
	@Override
	public Boolean isWorkflowRequired(Long menuId) {
		EDPMsOfficeDto office = OAuthUtility.getCurrentUserOfficeOauthToken();
		boolean isDatOff = null != office && !StringUtils.isEmpty(office.getOfficeDivision())
				&& office.getOfficeDivision().equalsIgnoreCase(EDPConstant.DAT_OFFICE) ? Boolean.TRUE : Boolean.FALSE;
		boolean isWfReq = Boolean.TRUE;
		Set<Long> roleIds = OAuthUtility.getWfRoleUsingMenuId(menuId);

		/*
		 * If any user of DAT office has Super Admin or “WF=NO” related WF
		 * roles/rights/configuration, System should approve request without workflow.
		 */
		if (isDatOff && (roleIds.isEmpty() || roleIds.contains(45L))) {
			isWfReq = Boolean.FALSE;
		}
		return isWfReq;
	}

	/**
	 * Perform submit action.
	 *
	 * @param officeEntity the office entity
	 * @param isUpdate     the is update
	 * @param dto          the dto
	 * @return the EDP ms office entity
	 * @throws CustomException the custom exception
	 */
	private EDPMsOfficeEntity performSubmitAction(EDPMsOfficeEntity officeEntity, boolean isUpdate,
			EDPMsOfficeDto dto) {
		EDPMsOfficeEntity edpMsOfficeEntity;
		if (isUpdate || (dto.getOfficeStatus() != null
				&& (dto.getOfficeStatus() == 281 || dto.getOfficeStatus() == 282 || dto.getOfficeStatus() == 283))) {
			edpMsOfficeEntity = officeEntity;
			edpMsOfficeEntity.setIsUpdate(new EDPLuLookUpInfoEntity(2l));
			if (dto.getFormAction() == Status.SUBMITTED) {
				if (officeEntity.getOfficeId() != null && officeEntity.getOfficeId() == 38L) {
					officeEntity.setOfficeDivision("DAT");
					officeEntity.setOfficeNameAlias(EDPConstant.PVU_OFF_GANDHINAGAR);
					officeEntity.setOfficePVU(EDPConstant.FIND_PVU);
				} else if (officeEntity.getOfficeId() != null && officeEntity.getOfficeId() == 87L) {
					officeEntity.setOfficeDivision("GAD");
				}
				edpMsOfficeEntity = repository.save(officeEntity);
			}
		} else {
			edpMsOfficeEntity = repository.save(officeEntity);
		}
		return edpMsOfficeEntity;
	}

	/**
	 * Sets the transaction number.
	 *
	 * @param officeEntity the office entity
	 * @param isCreate     the is create
	 * @param isUpdate     the is update
	 * @param dto          the dto
	 * @throws CustomException the custom exception
	 */
	private void setTransactionNumber(EDPMsOfficeEntity officeEntity, boolean isCreate, boolean isUpdate,
			EDPMsOfficeDto dto) throws CustomException {
		Map<String, Object> argMap = new HashMap<>();
		Long transactionNumber = null;
		if (isCreate || isUpdate) {
			if (dto.getMenuShName() == null) {
				throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
			}
			if (dto.getMenuShName().equals(EDPConstant.OFFICE_MENU_CODE) && dto.getOfficeId() == 0l
					&& dto.getTransactionNo() == null) {
				argMap.put(Constant.TRN_SCREEN, dto.getMenuShName());
				String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_EDP_TRN_NO_GEN));
				List<Object[]> responseList = repository.callStoredProcedure(procName, argMap);
				officeEntity.setTransactionNo(EDPUtility.convertObjectToString(responseList.get(0)[0]));

			} else if ((isUpdate && dto.getFormAction() == Status.SUBMITTED
					&& StringUtils.isEmpty(dto.getTransactionNo()))
					|| (isUpdate && dto.getFormAction() == Status.DRAFT
							&& StringUtils.isEmpty(dto.getTransactionNo()))) {
				transactionNumber = officeItrRepository.findLastTransactionNumber(dto.getMenuShName());
				officeEntity.setTransactionNo(EDPUtility.convertObjectToString(transactionNumber));
			}
		}
	}

	/**
	 * Pull Transaction Number based on MenuCode provided.
	 *
	 * @param dto the dto
	 * @return the string
	 */
	private String generateTrnNo(EDPMsOfficeDto dto) {
		// Add some condition

		Map<String, Object> attributes = new HashMap<>();
		attributes.put(Constant.TRN_SCREEN, dto.getMenuShName());

		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_EDP_TRN_NO_GEN));
		List<Object[]> responseList = repository.callStoredProcedure(procName, attributes);
		return EDPUtility.convertObjectToString(responseList.get(0)[0]);
	}

	/**
	 * Save office with unique id.
	 *
	 * @param officeEntity the office entity
	 * @return the EDP ms office entity
	 */
	private String generateUniqueId(EDPMsOfficeEntity officeEntity) {
		if (officeEntity.getDistrictId().getDistrictId() != null && !StringUtils.isEmpty(officeEntity.getDdoNo())
				&& officeEntity.getCardexno() != null) {
			EDPMsDistrictEntity districtEntity = districtRepository.findByDistrictIdAndActiveStatus(
					officeEntity.getDistrictId().getDistrictId(), Constant.ACTIVE_STATUS);
			return districtEntity.getDistrictCode() + "/" + officeEntity.getDdoNo() + "/"
					+ officeEntity.getCardexno().toString() + "/00";
		}
		return null;
	}

	/**
	 * Sets the created by data.
	 *
	 * @param officeEntity the new created by data
	 */
	private void setCurrentUserDataInCreatedData(EDPMsOfficeEntity officeEntity) {
		EDPMsPostDto dDPMsPostDto = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
		officeEntity.setCreatedBy(OAuthUtility.getCurrentUserUserId());
		officeEntity.setCreatedByPost(dDPMsPostDto.getPostId());
		officeEntity.setCreatedDate(new Date());
	}

	/**
	 * Creates the default post.
	 *
	 * @param officeEntity      the office entity
	 * @param edpMsOfficeEntity the edp ms office entity
	 */
	private void createDefaultPost(EDPMsOfficeEntity officeEntity, EDPMsOfficeEntity edpMsOfficeEntity) {
		if (null != officeEntity.getDesgDdoId()) {
			Optional<EDPMsDesignationEntity> designationEntityPresent = designationRepository
					.findById(officeEntity.getDesgDdoId());
			if (designationEntityPresent.isPresent()) {
				EDPMsDesignationEntity designationEntity = designationEntityPresent.get();
				EDPMsPostEntity postEntity = new EDPMsPostEntity();
				postEntity.setPostName(designationEntity.getDesignationName());
				postEntity.setDesignationId(designationEntity);
				postEntity = postRepository.save(postEntity);

				EDPLkPoOffUserEntity lkPoOffUserEntity = postMapWithUser(edpMsOfficeEntity, postEntity);
				menuRoleMapping(lkPoOffUserEntity);
			}
		}
	}

	/**
	 * Menu role mapping.
	 *
	 * @param lkPoOffUserEntity the lk po off user entity
	 */
	private void menuRoleMapping(EDPLkPoOffUserEntity lkPoOffUserEntity) {
		Set<String> menuNames = new HashSet<>();
		menuNames.add(Constant.MENU_EDP);
		menuNames.add(Constant.RESET_PASWD);
		menuNames.add(Constant.PAY_FIX_AND_PAY_VER);
		menuNames.add(Constant.PAY_FIX);
		menuNames.add(Constant.EMP_CREATION);
		menuNames.add(Constant.EMP_CREATION_LIST);
		menuNames.add(Constant.UPDATE_OFFICE_LIST);
		menuNames.add(Constant.OFFICE_DETAIL_SUMMARY);

		List<EDPMsMenuEntity> menuEntities = menuRepository.findByActiveStatusAndMenuNameIn(Constant.ACTIVE_STATUS,
				menuNames);

		Set<String> rolePermissions = new HashSet<>();
		rolePermissions.add(EDPConstant.ROLE_PERMISSION_CREATE);
		rolePermissions.add(EDPConstant.ROLE_PERMISSION_VIEW);
		rolePermissions.add(EDPConstant.ROLE_PERMISSION_EDIT);

		assignRolePermissions(lkPoOffUserEntity, menuEntities, rolePermissions);
	}

	/**
	 * Assign role permissions.
	 *
	 * @param lkPoOffUserEntity the lk po off user entity
	 * @param menuEntities      the menu entities
	 * @param rolePermissions   the role permissions
	 */
	private void assignRolePermissions(EDPLkPoOffUserEntity lkPoOffUserEntity, List<EDPMsMenuEntity> menuEntities,
			Set<String> rolePermissions) {
		Map<String, Object> argMap = new HashMap<>();
		List<EDPMsRolePermissionsEntity> rolePermissionsEnties = rolePermissionsRepository
				.findByRolePrmNameIn(rolePermissions);

		EDPUserRoleMappingEntity edpUserRoleMappingEntity = new EDPUserRoleMappingEntity();
		EDPLkEmpUserEntity empUserEntity = empUserRepository
				.findByUserIdUserIdAndActiveStatus(lkPoOffUserEntity.getUserId().getUserId(), Constant.ACTIVE_STATUS);
		edpUserRoleMappingEntity.setEmployeeId(empUserEntity.getEmpId().getEmpId());
		edpUserRoleMappingEntity.setPostOfficeUserId(lkPoOffUserEntity);
		edpUserRoleMappingEntity.setTransactionNumber("");
		edpUserRoleMappingEntity.setCreatedDate(new Date());
		edpUserRoleMappingEntity.setUpdatedDate(new Date());
		edpUserRoleMappingEntity.setSubmissionStatus(new EDPLuLookUpInfoEntity(EDPConstant.STATUS_APPROVE_ID));
		edpUserRoleMappingEntity.setCreatedByPost(OAuthUtility.getCurrentUserPrimaryPostOauthToken().getPostId());
		argMap.put(Constant.TRN_SCREEN, EDPConstant.RIGHTS_MAPPING_TRN_SCREEN_NAME);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_EDP_TRN_NO_GEN));
		List<Object[]> responseList = repository.callStoredProcedure(procName, argMap);
		edpUserRoleMappingEntity.setTransactionNumber(EDPUtility.convertObjectToString(responseList.get(0)[0]));
		edpUserRoleMappingRepository.save(edpUserRoleMappingEntity);
		List<EDPLkUserMenuEntity> userMenus = new ArrayList<>();
		for (EDPMsMenuEntity menuEntity : menuEntities) {
			EDPLkUserMenuEntity menuRolesEntity = new EDPLkUserMenuEntity();
			menuRolesEntity.setMenuID(menuEntity.getMenuId());
			menuRolesEntity.setPoOffUserId(lkPoOffUserEntity);
			menuRolesEntity = menuRolesRepository.save(menuRolesEntity);
			userMenus.add(menuRolesEntity);
		}

		for (EDPMsRolePermissionsEntity rolePermissionsEntity : rolePermissionsEnties) {
			for (EDPLkUserMenuEntity menuRolesEntity : userMenus) {
				EDPTrnUserMnuRolePrmEntity trnUserMnuRolePrmEntity = new EDPTrnUserMnuRolePrmEntity();
				trnUserMnuRolePrmEntity.setLkUserMenuId(menuRolesEntity);
				trnUserMnuRolePrmEntity.setRolePrmId(rolePermissionsEntity.getRoleActivityId());
				trnUserMnuRolePrmRepository.save(trnUserMnuRolePrmEntity);

				EDPTrnUsrMnuWfRole trnUserMnuWfRolw = new EDPTrnUsrMnuWfRole();
				trnUserMnuWfRolw.setLkUserMenuId(menuRolesEntity);
				trnUserMnuWfRolw.setWorkflowRoleId(rolePermissionsEntity.getRoleActivityId());
				trnUserMnuWfRolw.setIsMappedFrmLinkdMnu(1l);// as discussed with Vishal it is for URM screen default
															// will be 1 for new office
				lkPuoMenuRLWFRepository.save(trnUserMnuWfRolw);
			}
		}
	}

	/**
	 * Post map with user.
	 *
	 * @param edpMsOfficeEntity the edp ms office entity
	 * @param postEntity        the post entity
	 * @return the EDP lk post user office entity
	 */
	private EDPLkPoOffUserEntity postMapWithUser(EDPMsOfficeEntity edpMsOfficeEntity, EDPMsPostEntity postEntity) {
		EDPLkPostOfficeEntity postOfficeEntity = new EDPLkPostOfficeEntity();
		postOfficeEntity.setPostEntity(postEntity);
		postOfficeEntity.setOfficeEntity(edpMsOfficeEntity);
		postOfficeEntity.setIsVacant(new EDPLuLookUpInfoEntity(2l));
		postOfficeEntity = postUserOfficeRepository.save(postOfficeEntity);

		EDPMsUserEntity userEntity = userRepository
				.findByUserCodeAndActiveStatus(Long.valueOf(edpMsOfficeEntity.getEmployeeNo()), Constant.ACTIVE_STATUS);
		Optional<EDPEmployeEntity> employeEntityOp = employeRepository.findByEmployeeCodeAndActiveStatus(
				Long.valueOf(edpMsOfficeEntity.getEmployeeNo()), Constant.ACTIVE_STATUS);
		if (userEntity == null && employeEntityOp.isPresent()) {
			EDPEmployeEntity emp = employeEntityOp.get();
			EDPMsUserEntity user = userConverter.employeeToUserDto(pvuEmployeConverter.toClueDto(emp));
			userEntity = userRepository.save(user);

		}

		if (null != userEntity && null != userEntity.getUserCode()) {
			Optional<EDPLkEmpUserEntity> empUserentity = empUserRepository
					.findByUserIdUserCodeAndActiveStatus(userEntity.getUserCode(), Constant.ACTIVE_STATUS);
			if (!empUserentity.isPresent() && employeEntityOp.isPresent()) {
				EDPLkEmpUserEntity lkuserentity = new EDPLkEmpUserEntity();
				lkuserentity.setEmpId(employeEntityOp.get());
				lkuserentity.setUserId(userEntity);
				empUserRepository.save(lkuserentity);
			}
		}
		return savePostOfficeUser(postOfficeEntity, userEntity != null ? userEntity : new EDPMsUserEntity());
	}

	/**
	 * Save post office user.
	 *
	 * @param postOfficeEntity the post office entity
	 * @param userEntity       the user entity
	 * @return the EDP lk po off user entity
	 */
	private EDPLkPoOffUserEntity savePostOfficeUser(EDPLkPostOfficeEntity postOfficeEntity,
			EDPMsUserEntity userEntity) {
		postOfficeEntity.setIsVacant(new EDPLuLookUpInfoEntity(1l));
		EDPLkPoOffUserEntity lkPoOffUserEntity = new EDPLkPoOffUserEntity();
		lkPoOffUserEntity.setLkPostOfficeId(postOfficeEntity);
		lkPoOffUserEntity.setUserId(userEntity);
		List<EDPLkPoOffUserEntity> list = lkPoOffUserRepository
				.findByUserIdUserIdAndActiveStatus(userEntity.getUserId(), Constant.ACTIVE_STATUS);
		if (!CollectionUtils.isEmpty(list)) {
			lkPoOffUserEntity.setIsPrimaryPost(new EDPLuLookUpInfoEntity(1l));
		} else {
			lkPoOffUserEntity.setIsPrimaryPost(new EDPLuLookUpInfoEntity(2l));
		}

		return lkPoOffUserRepository.save(lkPoOffUserEntity);
	}

	/**
	 * Deletes the EDPMsOfficeEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */

	@Override
	public void deleteMsOffice(Long id) {
		repository.deleteById(id);

	}

	/**
	 * Saves all given EDPMsOfficeEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	@Override
	public List<EDPMsOfficeEntity> saveMsOffices(List<EDPMsOfficeEntity> entities) {
		return repository.saveAll(entities);
	}

	/**
	 * Fetch all the EDPMsOffice items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsOfficeDto>
	 */

	@Override
	public PagebleDTO<EDPMsOfficeDto> edpMsOfficeAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPMsOfficeEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();

		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<EDPMsOfficeEntity> empSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<EDPMsOfficeEntity> page = repository.findAll(empSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				converter.toDTO(page.getContent()));
	}

	/**
	 * This method is used to find office by post id.
	 *
	 * @param userId the user id
	 * @param postId the post id
	 * @return List of ClueDto
	 */
	@Override
	public List<ClueDto> findOfficeByPostId(Long userId, Long postId) {
		List<ClueDto> clueDtos = new ArrayList<>();
		List<EDPLkPoOffUserEntity> listPostId = lkPoOffUserRepository
				.findByUserIdUserIdAndLkPostOfficeIdPostEntityPostIdAndActiveStatus(userId, postId,
						Constant.ACTIVE_STATUS);
		for (EDPLkPoOffUserEntity postUserOffice : listPostId) {
			getEstimatedFrom(clueDtos, postUserOffice.getLkPostOfficeId().getOfficeEntity().getOfficeTypeId());
		}
		return clueDtos;
	}

	/**
	 * Gets the estimated from.
	 *
	 * @param clueDtos         the clue dtos
	 * @param lookUpInfoEntity the edp ms office entity
	 * @return the estimated from
	 */
	private void getEstimatedFrom(List<ClueDto> clueDtos, EDPLuLookUpInfoEntity lookUpInfoEntity) {
		ClueDto clueDto = new ClueDto();
		clueDto.setId(lookUpInfoEntity.getLookUpInfoId());
		clueDto.setName(lookUpInfoEntity.getLookUpInfoName());
		clueDto.setCode(lookUpInfoEntity.getLookUpInfoName());
		clueDto.setCodeName(lookUpInfoEntity.getLookUpInfoName());
		clueDtos.add(clueDto);
	}

	/**
	 * This method is used to find office by id.
	 *
	 * @param userId   the user id
	 * @param postId   the post id
	 * @param officeId the office id
	 * @return List of ClueDto
	 */
	@Override
	public List<ClueDto> findOfficeById(Long userId, Long postId, Long officeId) {
		List<EDPLkPoOffUserEntity> listPostId = lkPoOffUserRepository
				.findByUserIdUserIdAndLkPostOfficeIdPostEntityPostIdAndLkPostOfficeIdOfficeEntityOfficeIdAndActiveStatus(
						userId, postId, officeId, Constant.ACTIVE_STATUS);
		return listPostId.stream().map(entity -> {
			ClueDto clueDto = new ClueDto();
			EDPMsOfficeEntity officeEntity = entity.getLkPostOfficeId().getOfficeEntity();
			clueDto.setId(officeEntity.getOfficeId());
			clueDto.setCode(officeEntity.getOfficeCode());
			clueDto.setName(officeEntity.getOfficeName());
			clueDto.setCodeName(officeEntity.getOfficeCodeName());
			return clueDto;
		}).collect(Collectors.toList());
	}

	/**
	 * Find id code estimation from.
	 *
	 * @return the list
	 */
	@Override
	public List<ClueDto> findIdCodeEstimationFrom() {
		List<EDPLuLookUpInfoEntity> lookUpInfoEnties = lookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(Constant.LOOKUP_NAME_OFFICE_TYPE,
						Constant.ACTIVE_STATUS,
						EDPUtility.getJpaSort(EDPConstant.LOOKUP_INFO_ID, EDPConstant.ORDER_ASC));
		return lookUpInfoEnties.stream().map(lookUpInfoEntity -> {
			ClueDto clueDto = new ClueDto();
			clueDto.setId(lookUpInfoEntity.getLookUpInfoId());
			clueDto.setName(lookUpInfoEntity.getLookUpInfoName());
			return clueDto;
		}).collect(Collectors.toList());
	}

	/**
	 * Find Office Details.
	 *
	 * @return the list
	 */
	@Override
	public EDPOfficeDetailsDto getOfficeDetails() {
		// Test
		EDPOfficeDetailsDto officedetailsdto = new EDPOfficeDetailsDto();
		List<ClueDto> distList = districtConverter.toClueDTO(
				edpMsDistrictRepository.findByActiveStatusAndStateId(Constant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ,
						EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC)));

		List<ClueDto> talukaList = talukaConverter.toClueDTO(edpMsTalukaRepository.findByActiveStatus(
				Constant.ACTIVE_STATUS, EDPUtility.getJpaSort(EDPConstant.TALUKA_NAME, EDPConstant.ORDER_ASC)));

		EDPLuLookUpInfoEntity approveLookUpInfo = edpLuLookUpInfoRepository
				.findByLookUpInfoNameAndActiveStatusAndEdpLuLookUpEntityLookUpId(EDPConstant.LK_STATUS_VAL_APPROVED,
						Constant.ACTIVE_STATUS, 62);
		officedetailsdto.setDistricts(getDistrictDtoWithTalukas(distList, talukaList));
		officedetailsdto
				.setLevel(lookupinfoconverter.toClueDTO(lookupinfoservice.findByLookUpName(EDPConstant.FIND_LEVEL)));
		officedetailsdto.setOfficeType(
				lookupinfoconverter.toClueDTO(lookupinfoservice.findByLookUpName(EDPConstant.FIND_OFFICE_TYPE)));

		List<EDPMsOfficeEntity> officeEntities = repository.findByOfficePVUAndActiveStatus(EDPConstant.FIND_PVU,
				EDPConstant.ACTIVE_STATUS_TRUE);
		EDPMsOfficeEntity officeEntity = new EDPMsOfficeEntity();
		officeEntity.setOfficeId(0l);
		officeEntity.setOfficeNameAlias("Pay Verification Unit, Self");
		officeEntities.add(officeEntity);
		officedetailsdto.setPvu(lookupinfoconverter.toOfficeDto(officeEntities));

		List<ClueDto> coOffices = lookupinfoconverter.toClueDTO(lookupinfoservice.findByLookUpName(
				OAuthConstant.LOOK_UP_CONDITIONCHECK, EDPConstant.LOOKUP_INFO_ID, EDPConstant.ORDER_DESC));

		officedetailsdto.setControllingOffice(coOffices);
		officedetailsdto.setRequestTos(getRequestToMapping());

		officedetailsdto.setDesignationOfDdo(edpMsPostConverter
				.toDesignationClueDTO(designationRepository.findByStatusIdLookUpInfoNameOrStatusIdIsNullAndActiveStatus(
						EDPConstant.LK_STATUS_VAL_APPROVED, OAuthConstant.ACTIVE_STATUS,
						EDPUtility.getJpaSort(EDPConstant.DESIGNATION_NAME, EDPConstant.ORDER_ASC))));
		EDPLuLookUpInfoEntity edpLuLookUpInfoEntity = edpLuLookUpInfoRepository
				.findByLookUpInfoName(OAuthConstant.LOOK_UP_INFO_NAME_YES);
		EDPMsPostDto postdto = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
		if (postdto.getOauthTokenPostDTO() != null && postdto.getOauthTokenPostDTO().getEdpMsOfficeDto() != null
				&& postdto.getOauthTokenPostDTO().getEdpMsOfficeDto().getDepartmentId() != null) {
			officedetailsdto.setDepartment(edpMsDepartmentConverter.toClueDTO(edpmsdepartmentservice
					.getMsDepartment(postdto.getOauthTokenPostDTO().getEdpMsOfficeDto().getDepartmentId())));
		}
		if (postdto.getOauthTokenPostDTO() != null && postdto.getOauthTokenPostDTO().getEdpMsOfficeDto() != null
				&& postdto.getOauthTokenPostDTO().getEdpMsOfficeDto().getIsHod() != null
				&& postdto.getOauthTokenPostDTO().getEdpMsOfficeDto()
						.getIsHod() == (edpLuLookUpInfoEntity.getLookUpInfoId())) {
			officedetailsdto.setHod(edpMsOfficeConverter.toClueDTO(postdto.getOauthTokenPostDTO().getEdpMsOfficeDto()));
		}

		officedetailsdto.setCoOffice(converter
				.toClueDTO(repository.findByIsCoAndActiveStatusAndStatusId(edpLuLookUpInfoEntity.getLookUpInfoId(),
						Constant.ACTIVE_STATUS, (short) approveLookUpInfo.getLookUpInfoId(),
						EDPUtility.getJpaSort(EDPConstant.OFFICE_NAME, EDPConstant.ORDER_ASC))));
		/**
		 * fetching wrong data.
		 *
		 * officedetailsdto.setBillSubmittedTo(
		 * edpMsTreasuryConverter.toClueDTO(edpMsTreasuryRepository.findByActiveStatus(
		 * Constant.ACTIVE_STATUS)));
		 */

		/**
		 * commented as not in use
		 *
		 * officedetailsdto.setModuleType(
		 * edpMsModuleConverter.toClueDTO(edpMsModuleRepository.findByActiveStatus(
		 * Constant.ACTIVE_STATUS)));
		 */
		officedetailsdto.setBillType(
				lookupinfoconverter.toClueDTO(lookupinfoservice.findByLookUpName(OAuthConstant.LOOK_UP_BILLTYPE)));

		officedetailsdto
				.setStatus(toLookUpInfoClueDTO(lookupinfoservice.findByLookUpName(OAuthConstant.LOOK_UP_STATUSID)));

		officedetailsdto.setListsofBill(
				lookupinfoconverter.toClueDTO(lookupinfoservice.findByLookUpName(OAuthConstant.LOOK_UP_LISTOFBILL)));
		officedetailsdto.setNonDdoType(
				lookupinfoconverter.toClueDTO(lookupinfoservice.findByLookUpName(EDPConstant.ARG_NONDDOTYPE)));
		officedetailsdto
				.setDdoType(lookupinfoconverter.toClueDTO(lookupinfoservice.findByLookUpName(EDPConstant.ARG_DDOTYPE)));
		officedetailsdto.setDepartments(edpmsdepartmentservice.getAllCodeAndId());

		List<ClueDto> statusList = lookupinfoconverter
				.toClueDTO(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(
						OAuthConstant.LOOK_UP_STATUS_OFFICE, EDPConstant.ACTIVE_STATUS_TRUE,
						EDPUtility.getJpaSort(EDPConstant.LOOKUP_INFO_ID, EDPConstant.ORDER_DESC)));

		officedetailsdto.setUpdateStatus(statusList);

		Map<String, Object> argMap = new HashMap<>();
		argMap.put(EDPConstant.ARGS_MENU_ID, EDPConstant.CREATE_OFFICE_MENU_ID);
		List<Object[]> dataList = repository
				.executeNativeSQLQuery(EDPNativeSQLUtil.GET_EDP_WF_TRN_STATUS_BY_MENU_ID_QUERY, argMap);
		Set<ClueDto> wfStatusList = new HashSet<>();
		Set<ClueDto> trnStatusList = new HashSet<>();
		dataList.forEach(obj -> {
			if (null != obj[0])
				trnStatusList.add(getClueDtoForStatus(obj[0]));
			if (null != obj[1])
				trnStatusList.add(getClueDtoForStatus(obj[1]));
			if (null != obj[2])
				wfStatusList.add(getClueDtoForStatus(obj[2]));
			if (null != obj[3])
				wfStatusList.add(getClueDtoForStatus(obj[3]));
		});
		officedetailsdto.setTransStatusList(trnStatusList);
		officedetailsdto.setWfStatus(wfStatusList);
		return officedetailsdto;
	}

	/**
	 * Gets the request to mapping.
	 *
	 * @return the request to mapping
	 */
	private List<ClueDto> getRequestToMapping() {
		List<ClueDto> requestToDto = lookupinfoconverter
				.toClueDTO(lookupinfoservice.findByLookUpName(EDPConstant.FIND_REQUESTTO));
		return requestToDto.stream().map(requestdto -> {
			requestdto.setTresuryType(
					lookupinfoconverter.toClueDTO(lookupinfoservice.findByLookUpName(requestdto.getName())));
			return requestdto;
		}).collect(Collectors.toList());
	}

	/**
	 * Gets the district dto with talukas.
	 *
	 * @param districtlist the districtlist
	 * @param talukalist   the talukalist
	 * @return the district dto with talukas
	 */
	private List<ClueDto> getDistrictDtoWithTalukas(List<ClueDto> districtlist, List<ClueDto> talukalist) {
		return districtlist.stream().map(disEntity -> {
			disEntity.setTaluka(
					talukalist.stream().filter(talukaEntitiy -> talukaEntitiy.getParentId().equals(disEntity.getId()))
							.collect(Collectors.toList()));
			return disEntity;
		}).collect(Collectors.toList());
	}

	/**
	 * Gets the next cardex no.
	 *
	 * @param districtId the district id
	 * @return the next cardex no
	 */
	@Override
	public ClueDto getNextCardexNo(Long districtId) {
		Long cardex = repository.findMaxCardexNoUsingDistrictId(districtId);
		if (cardex != null)
			return new ClueDto(cardex + 1l);
		return new ClueDto(1L);
	}

	/**
	 * Update active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @throws CustomException the custom exception
	 */
	@Override
	public void updateActiveStatus(Long id, int activeStatus) throws CustomException {
		try {
			this.repository.updateActiveStatusByOfficeId(id, activeStatus, OAuthUtility.getCurrentUserUserId(),
					new Date());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE_ACTIVESTATUS);
		}
	}

	/**
	 * Gets the district wise office details.
	 *
	 * @return the district wise office details
	 */
	@Override
	public List<ClueDto> getDistrictWiseOfficeDetails() {
		List<Object[]> districtList = repository.callStoredProcedure(
				Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_DISTRICT_WISE_OFFICE_DTL)));
		HashSet<Long> districtIdList = new HashSet<>();
		return districtList.stream()
				.filter(object -> !districtIdList.contains(EDPUtility.convertObjectToLong(object[0]))).map(object -> {
					ClueDto districtDto = new ClueDto();
					districtDto.setId(EDPUtility.convertObjectToLong(object[0]));
					districtDto.setName(EDPUtility.convertObjectToString(object[1]));
					districtDto.setOfficeList(getOfficeByDistrictDto(districtList, districtDto.getId()));
					districtIdList.add(districtDto.getId());
					return districtDto;
				}).sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).collect(Collectors.toList());
	}

	/**
	 * Gets the office by district dto.
	 *
	 * @param districtList the district list
	 * @param districtId   the district id
	 * @return the office by district dto
	 */
	public List<ClueDto> getOfficeByDistrictDto(List<Object[]> districtList, Long districtId) {
		return districtList.stream().filter(object -> districtId.equals(EDPUtility.convertObjectToLong(object[0])))
				.map(object -> {
					ClueDto officeDto = new ClueDto();
					officeDto.setId(EDPUtility.convertObjectToLong(object[3]));
					officeDto.setName(EDPUtility.convertObjectToString(object[2]));
					officeDto.setCardexNo(EDPUtility.convertObjectToLong(object[4]));
					officeDto.setDdoNo(EDPUtility.convertObjectToString(object[5]));
					return officeDto;
				}).collect(Collectors.toList());
	}

	/**
	 * Gets the all departments with hod.
	 *
	 * @return the all code and id
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<ClueDto> getAllDepartmentsWithHod() throws CustomException {
		try {
			EDPLuLookUpInfoEntity approveLookUpInfo = edpLuLookUpInfoRepository
					.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED);
			Short lookupId = approveLookUpInfo != null
					? Short.valueOf(String.valueOf(approveLookUpInfo.getLookUpInfoId()))
					: 0;

			EDPLuLookUpInfoEntity activeStatus = edpLuLookUpInfoRepository
					.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_ACTIVE);
			Long officeStatusId = activeStatus != null ? Long.valueOf(String.valueOf(activeStatus.getLookUpInfoId()))
					: 0;

			EDPLuLookUpInfoEntity yesInfoEntity = edpLuLookUpInfoRepository
					.findByLookUpInfoName(EDPConstant.LOOKUP_NAME_YES);
			Long lookUpYesId = yesInfoEntity != null ? yesInfoEntity.getLookUpInfoId() : 0l;
			List<EDPMsOfficeEntity> listMsOffices = repository.findByIsHodAndStatusIdAndOfficeStatusAndActiveStatus(
					lookUpYesId, lookupId, officeStatusId, EDPConstant.ACTIVE_STATUS_TRUE);

			List<EDPMsOfficeDto> adOffices = getByOfficeType(EDPConstant.OFFICE_TYPE_AD);
			List<ClueDto> departmentClueDtoList = adOffices.stream().map(adOfficesList -> {
				ClueDto clueDto = new ClueDto();
				clueDto.setId(adOfficesList.getOfficeId());
				clueDto.setName(adOfficesList.getOfficeName());
				clueDto.setCode(adOfficesList.getOfficeCode());
				return clueDto;
			}).collect(Collectors.toList());

			return departmentClueDtoList.stream().map(department -> {
				List<ClueDto> officeInDepartment = listMsOffices.stream()
						.filter(office -> office.getParentOfficeId() != null
								&& office.getParentOfficeId().equals(department.getId()))
						.map(office -> edpMsOfficeConverter.toClueDTO(edpMsOfficeConverter.toDTO(office)))
						.collect(Collectors.toList());
				department.setOfficeList(officeInDepartment);
				return department;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the by departments with hod.
	 *
	 * @param departmentId the department id
	 * @return the by departments with hod
	 * @throws CustomException the custom exception
	 */
	public List<ClueDto> getByDepartmentsWithHod(Long departmentId) throws CustomException {
		try {
			Set<String> statusNameList = new HashSet<>();
			statusNameList.add(EDPConstant.LK_STATUS_VAL_APPROVED);
			statusNameList.add(EDPConstant.LK_STATUS_VAL_ACTIVE);
			List<EDPLuLookUpInfoEntity> approveLookUpInfo = edpLuLookUpInfoRepository
					.findByLookUpInfoNameIn(statusNameList);
			Set<Short> statusIdList = approveLookUpInfo.stream()
					.map(entity -> Short.valueOf(String.valueOf(entity.getLookUpInfoId()))).collect(Collectors.toSet());
			EDPLuLookUpInfoEntity yesInfoEntity = edpLuLookUpInfoRepository
					.findByLookUpInfoName(EDPConstant.LOOKUP_NAME_YES);
			Long lookUpYesId = yesInfoEntity != null ? yesInfoEntity.getLookUpInfoId() : 0l;
			List<EDPMsOfficeEntity> listMsOffices = repository.findAllHodOffice(statusIdList, lookUpYesId,
					EDPConstant.ACTIVE_STATUS_TRUE);
			return listMsOffices.stream()
					.filter(office -> office.getDepartmentId() != null
							&& office.getDepartmentId().getDepartmentId().equals(departmentId))
					.map(office -> edpMsOfficeConverter.toClueDTO(edpMsOfficeConverter.toDTO(office)))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * To look up info clue DTO.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<ClueDto> toLookUpInfoClueDTO(List<EDPLuLookUpInfoEntity> list) {
		return list.stream().filter(entity -> entity.getLookUpInfoName().equals(EDPConstant.LK_STATUS_VAL_SAVAS_DRAFT)
				|| entity.getLookUpInfoName().equals(EDPConstant.LK_STATUS_VAL_APPROVED)).map(entityInList -> {
					ClueDto dto = new ClueDto();
					dto.setId(entityInList.getLookUpInfoId());
					dto.setName(entityInList.getLookUpInfoName());
					return dto;
				}).collect(Collectors.toList());
	}

	/**
	 * Check and update cardex no.
	 *
	 * @param dto    the dto
	 * @param entity the entity
	 */
	public void checkAndUpdateCardexNo(EDPMsOfficeDto dto, EDPMsOfficeEntity entity) {
		Long cardexNo = getNextCardexNo(dto.getDistrictId()).getId();
		if (!cardexNo.equals(dto.getCardexno())) {
			dto.setCardexno(cardexNo);
			entity.setCardexno(cardexNo);
		}
	}

	/**
	 * Search for office history report.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPOfficeHistoryReportView> searchForOfficeHistoryReport(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> argsMap = EDPUtility.populateArguments(pageDetail, 8);
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.REPORT_OFFICE_HISTORY));
			List<Object[]> objectSp = this.repository.callStoredProcedure(procName, argsMap);
			List<EDPOfficeHistoryReportView> postList = NativeQueryResultsMapper.map(objectSp,
					EDPOfficeHistoryReportView.class);
			int count = !postList.isEmpty() && null != postList.get(0) ? postList.size() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, count, postList);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	/**
	 * Gets the offices by district.
	 *
	 * @param distId the dist id
	 * @return the offices by district
	 */
	@Override
	public List<EDPMsOfficeDto> getOfficesByDistrict(Long distId) {
		EDPLuLookUpInfoEntity approveLookUpInfo = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED);
		Short lookupId = approveLookUpInfo != null ? Short.valueOf(String.valueOf(approveLookUpInfo.getLookUpInfoId()))
				: 0;
		EDPLuLookUpInfoEntity activeStatus = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_ACTIVE);
		Long officeStatusId = activeStatus != null ? Long.valueOf(String.valueOf(activeStatus.getLookUpInfoId())) : 0;

		List<EDPMsOfficeEntity> officesEntity = repository
				.findByDistrictIdDistrictIdAndStatusIdAndOfficeStatusAndActiveStatus(distId, lookupId, officeStatusId,
						OAuthConstant.ACTIVE_STATUS);
		return converter.toDTO(officesEntity);
	}

	/**
	 * Gets the by office type.
	 *
	 * @param officeType the office type
	 * @return the by office type
	 */
	@Override
	public List<EDPMsOfficeDto> getByOfficeType(String officeType) {
		//EDPLuLookUpInfoEntity approveLookUpInfo = edpLuLookUpInfoRepository.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED);
//		Short statusId = approveLookUpInfo != null ? Short.valueOf(String.valueOf(approveLookUpInfo.getLookUpInfoId()))
//				: 0;
//
//		EDPLuLookUpInfoEntity activeStatus = edpLuLookUpInfoRepository
//				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_ACTIVE);
//		Long officeStatusId = activeStatus != null ? Long.valueOf(String.valueOf(activeStatus.getLookUpInfoId())) : 0;
//
//		EDPLuLookUpInfoEntity officeTypeInfo = edpLuLookUpInfoRepository
//				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(EDPConstant.FIND_OFFICE_TYPE,
//						OAuthConstant.ACTIVE_STATUS, officeType);
//		Long officeTypeId = officeTypeInfo != null ? Long.valueOf(String.valueOf(officeTypeInfo.getLookUpInfoId())) : 0;

		List<EDPMsOfficeEntity> officesEntity = repository
				.findByOfficeTypeIdLookUpInfoIdAndStatusIdAndOfficeStatusAndActiveStatusAndIsFdNot(EDPConstant.LOOKUP_INFO_ADMINI_DEPT, EDPConstant.STATUS_APPROVED_ID,
						EDPConstant.OFFICE_STATUS_ID, OAuthConstant.ACTIVE_STATUS,EDPConstant.LOOKUP_INFO_YES,
						EDPUtility.getJpaSort(EDPConstant.OFFICE_NAME, EDPConstant.ORDER_ASC));

		return converter.toDTO(officesEntity);
	}

	/**
	 * Gets the parent office.
	 *
	 * @param officeId the office id
	 * @return the parent office
	 */
	@Override
	public EDPMsOfficeDto getParentOffice(Long officeId) {
		EDPMsOfficeEntity officeEntity = repository.findByOfficeIdAndActiveStatus(officeId,
				OAuthConstant.ACTIVE_STATUS);
		if (officeEntity != null && officeEntity.getParentOfficeId() != null) {
			EDPMsOfficeEntity parentOffice = repository.findByOfficeIdAndActiveStatus(officeEntity.getParentOfficeId(),
					OAuthConstant.ACTIVE_STATUS);
			return converter.toDTO(parentOffice);
		}
		return null;
	}

	/**
	 * Gets the child office list.
	 *
	 * @param officeId the office id
	 * @return the child office list
	 */
	@Override
	public List<EDPMsOfficeDto> getChildOfficeList(Long officeId) {
		EDPLuLookUpInfoEntity approveLookUpInfo = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED);
		Short statusId = approveLookUpInfo != null ? Short.valueOf(String.valueOf(approveLookUpInfo.getLookUpInfoId()))
				: 0;

		EDPLuLookUpInfoEntity activeStatus = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_ACTIVE);
		Long officeStatusId = activeStatus != null ? Long.valueOf(String.valueOf(activeStatus.getLookUpInfoId())) : 0;

		List<EDPMsOfficeEntity> officesEntity = repository
				.findByParentOfficeIdAndStatusIdAndOfficeStatusAndActiveStatus(officeId, statusId, officeStatusId,
						OAuthConstant.ACTIVE_STATUS);
		return converter.toDTO(officesEntity);
	}

	/**
	 * Gets the HOD list basedon department office.
	 *
	 * @param officeId the office id
	 * @return the HOD list basedon department office
	 */
	@Override
	public List<EDPMsOfficeDto> getHODListBasedonDepartmentOffice(Long officeId) {
		EDPLuLookUpInfoEntity approveLookUpInfo = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED);
		Short statusId = approveLookUpInfo != null ? Short.valueOf(String.valueOf(approveLookUpInfo.getLookUpInfoId()))
				: 0;

		EDPLuLookUpInfoEntity activeStatus = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_ACTIVE);
		Long officeStatusId = activeStatus != null ? Long.valueOf(String.valueOf(activeStatus.getLookUpInfoId())) : 0;

		EDPLuLookUpInfoEntity yesInfoEntity = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LOOKUP_NAME_YES);
		Long lookUpYesId = yesInfoEntity != null ? yesInfoEntity.getLookUpInfoId() : 0l;

		List<EDPMsOfficeEntity> officesEntity = repository
				.findByParentOfficeIdAndIsHodAndStatusIdAndOfficeStatusAndActiveStatus(officeId, lookUpYesId, statusId,
						officeStatusId, OAuthConstant.ACTIVE_STATUS);
		return converter.toDTO(officesEntity);
	}

	/**
	 * Gets the CO list by hod office id.
	 *
	 * @param officeId the office id
	 * @return the CO list by hod office id
	 */
	@Override
	public List<EDPMsOfficeDto> getCOListByHodOfficeId(Long officeId) {
		EDPLuLookUpInfoEntity approveLookUpInfo = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED);
		Short statusId = approveLookUpInfo != null ? Short.valueOf(String.valueOf(approveLookUpInfo.getLookUpInfoId()))
				: 0;

		EDPLuLookUpInfoEntity activeStatus = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_ACTIVE);
		Long officeStatusId = activeStatus != null ? Long.valueOf(String.valueOf(activeStatus.getLookUpInfoId())) : 0;

		EDPLuLookUpInfoEntity yesInfoEntity = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LOOKUP_NAME_YES);
		Long lookUpYesId = yesInfoEntity != null ? yesInfoEntity.getLookUpInfoId() : 0l;

		List<EDPMsOfficeEntity> officesEntity = repository
				.findByParentOfficeIdAndIsCoAndStatusIdAndOfficeStatusAndActiveStatus(officeId, lookUpYesId, statusId,
						officeStatusId, OAuthConstant.ACTIVE_STATUS);
		return converter.toDTO(officesEntity);
	}

	/**
	 * Gets the offices by flag list.
	 *
	 * @param names the names
	 * @return the offices by flag list
	 */
	@Override
	public EDPOfficeDivisionDto getOfficesByFlagList(List<ClueDto> names) {
		EDPOfficeDivisionDto officeDivisionDto = new EDPOfficeDivisionDto();

		EDPLuLookUpInfoEntity approveLookUpInfo = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED);
		Short statusId = approveLookUpInfo != null ? Short.valueOf(String.valueOf(approveLookUpInfo.getLookUpInfoId()))
				: 0;

		EDPLuLookUpInfoEntity activeStatus = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_ACTIVE);
		Long officeStatusId = activeStatus != null ? Long.valueOf(String.valueOf(activeStatus.getLookUpInfoId())) : 0;

		for (ClueDto name : names) {
			if (name.getName().equals(EDPConstant.FL_PVU)) {
				EDPMsOfficeEntity officeEntity = repository.findByOfficePVUAndStatusIdAndOfficeStatusAndActiveStatus(
						name.getName(), statusId, officeStatusId, OAuthConstant.ACTIVE_STATUS);
				officeDivisionDto.setPvuOffice(converter.toDTO(officeEntity));
			} else if (name.getName().equals(EDPConstant.FL_TO)) {
				officeDivisionDto.setToOffice(getOfficeByOffDiv(statusId, officeStatusId, name));
			} else if (name.getName().equals(EDPConstant.FL_STO)) {
				officeDivisionDto.setStoOffice(getOfficeByOffDiv(statusId, officeStatusId, name));
			} else if (name.getName().equals(EDPConstant.FL_DPPF)) {
				officeDivisionDto.setDppfOffice(getOfficeByOffDiv(statusId, officeStatusId, name));
			} else if (name.getName().equals(EDPConstant.FL_FD)) {
				officeDivisionDto.setFdOffice(getOfficeByOffDiv(statusId, officeStatusId, name));
			} else if (name.getName().equals(EDPConstant.FL_LOCAL_FUND)) {
				officeDivisionDto.setLocalFundOffice(getOfficeByOffDiv(statusId, officeStatusId, name));
			}
		}
		return officeDivisionDto;
	}

	/**
	 * Gets the office by off div.
	 *
	 * @param statusId       the status id
	 * @param officeStatusId the office status id
	 * @param name           the name
	 * @return the office by off div
	 */
	private EDPMsOfficeDto getOfficeByOffDiv(Short statusId, Long officeStatusId, ClueDto name) {
		EDPMsOfficeEntity officeEntity = repository.findByOfficeDivisionAndStatusIdAndOfficeStatusAndActiveStatus(
				name.getName(), statusId, officeStatusId, OAuthConstant.ACTIVE_STATUS);
		if (officeEntity != null) {
			return converter.toDTO(officeEntity);
		}
		return null;
	}

	/**
	 * Gets the by office type by office type id.
	 *
	 * @param officeTypeId the office type id
	 * @return the by office type by office type id
	 */
	@Override
	public List<EDPMsOfficeDto> getByOfficeTypeByOfficeTypeId(Long officeTypeId) {
		EDPLuLookUpInfoEntity approveLookUpInfo = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED);
		Short statusId = approveLookUpInfo != null ? Short.valueOf(String.valueOf(approveLookUpInfo.getLookUpInfoId()))
				: 0;
		EDPLuLookUpInfoEntity activeStatus = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_ACTIVE);
		Long officeStatusId = activeStatus != null ? Long.valueOf(String.valueOf(activeStatus.getLookUpInfoId())) : 0;
		List<EDPMsOfficeEntity> officesEntity = repository
				.findByOfficeTypeIdLookUpInfoIdAndStatusIdAndOfficeStatusAndActiveStatus(officeTypeId, statusId,
						officeStatusId, OAuthConstant.ACTIVE_STATUS,
						EDPUtility.getJpaSort(EDPConstant.OFFICE_NAME, EDPConstant.ORDER_ASC));
		return converter.toOfficeIdAndOfficeName(officesEntity);
	}

	/**
	 * Gets the fd office.
	 *
	 * @return the fd office
	 */
	@Override
	public List<EDPMsOfficeDto> getFdOffice() {
		EDPLuLookUpInfoEntity approveLookUpInfo = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED);
		Short statusId = approveLookUpInfo != null ? Short.valueOf(String.valueOf(approveLookUpInfo.getLookUpInfoId()))
				: 0;
		List<EDPMsOfficeEntity> fdOfficeList = repository
				.findByOfficeTypeIdLookUpInfoIdAndIsFdAndCardexnoAndStatusIdAndOfficeStatusAndActiveStatus(
						Constant.LU_MS_OFFICE_TYPE_AD, Constant.LU_YES_LOOKUP_INFO_ID, Constant.EDP_FD_OFFICE_CARDEX_NO,
						statusId, Constant.LU_ACTIVE_LOOKUP_INFO_ID, Constant.ACTIVE_STATUS);
		return converter.toOfficeIdAndOfficeName(fdOfficeList);
	}

	/**
	 * Gets the office by district and pvu id.
	 *
	 * @param officeDto the office dto
	 * @return the office by district and pvu id
	 */
	@Override
	public List<ClueDto> getOfficeByDistrictAndPvuId(EDPMsOfficeDto officeDto) {
		EDPLuLookUpInfoEntity approveLookUpInfo = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED);
		Short lookupId = approveLookUpInfo != null ? Short.valueOf(String.valueOf(approveLookUpInfo.getLookUpInfoId()))
				: 0;
		EDPLuLookUpInfoEntity activeStatus = edpLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_ACTIVE);
		Long officeStatusId = activeStatus != null ? Long.parseLong(String.valueOf(activeStatus.getLookUpInfoId())) : 0;
		List<EDPMsOfficeEntity> msOfficeEntityList;

		if (!Utils.isEmpty(officeDto.getDistrictId())) {
			if (Utils.isNonEmpty(officeDto.getPvuId())) {
				msOfficeEntityList = repository
						.findByDistrictIdDistrictIdAndPvuIdAndStatusIdAndOfficeStatusAndActiveStatus(
								officeDto.getDistrictId(), officeDto.getPvuId(), lookupId, officeStatusId,
								OAuthConstant.ACTIVE_STATUS);
			} else {
				msOfficeEntityList = repository.findByDistrictIdDistrictIdAndStatusIdAndOfficeStatusAndActiveStatus(
						officeDto.getDistrictId(), lookupId, officeStatusId, OAuthConstant.ACTIVE_STATUS);
			}
		} else if (Utils.isNonEmpty(officeDto.getPvuId()) && Utils.isEmpty(officeDto.getDistrictId())) {
			msOfficeEntityList = repository
					.findByPvuIdAndStatusIdOrStatusIdIsNullAndOfficeStatusOrOfficeStatusIsNullAndActiveStatus(
							officeDto.getPvuId(), lookupId, officeStatusId, OAuthConstant.ACTIVE_STATUS);
		} else {
			msOfficeEntityList = repository
					.findByStatusIdOrStatusIdIsNullAndOfficeStatusOrOfficeStatusIsNullAndActiveStatus(lookupId,
							officeStatusId, OAuthConstant.ACTIVE_STATUS);
		}

		return msOfficeEntityList.stream().map(edpMsOfficeEntity -> {
			ClueDto officeDtos = new ClueDto();
			officeDtos.setId(edpMsOfficeEntity.getOfficeId());
			officeDtos.setName(edpMsOfficeEntity.getOfficeName());
			officeDtos.setCardexNo(edpMsOfficeEntity.getCardexno());
			officeDtos.setDdoNo(edpMsOfficeEntity.getDdoNo());
			return officeDtos;
		}).collect(Collectors.toList());
	}

	/**
	 * Saves a given EDPMsOfficeEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param officeEntity the office entity
	 * @param isCreate     the is create
	 * @param isUpdate     the is update
	 * @param dto          the dto
	 * @return the saved EDPMsOfficeEntity
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPMsOfficeEntity saveOrUpdateMsOffice(EDPMsOfficeEntity officeEntity, boolean isCreate, boolean isUpdate,
			EDPMsOfficeDto dto) throws CustomException {
		EDPMsOfficeEntity edpMsOfficeEntity = saveAsDraftMsOffice(officeEntity, isCreate, isUpdate, dto);
		if (dto.getTransactionNo() == null) {
			wfRequestHandler.saveAsDraftWf(dto.getCurMenuId(), edpMsOfficeEntity.getOfficeId());
		}
		if (dto.getWfStatus() != null && (EDPConstant.LK_STATUS_VAL_REJECTED.equalsIgnoreCase(dto.getWfStatus())
				|| EDPConstant.LK_STATUS_VAL_CANCELLED.equalsIgnoreCase(dto.getWfStatus()))) {
			repository.updateStatusToRejectOrCancelByOfficeId(edpMsOfficeEntity.getOfficeId(), dto.getWfStatus());
			return edpMsOfficeEntity;
		} else {
			submitOffice(officeEntity, dto, edpMsOfficeEntity);
			return edpMsOfficeEntity;
		}
	}

	/**
	 * Updates Sub Offices and Office Bills in respective request tables. Perform
	 * other operations for workflow request.
	 *
	 * @param officeEntity    the office entity
	 * @param dto             the dto
	 * @param officeTrnEntity the office trn entity
	 * @throws CustomException the custom exception
	 */
	private void updateOfficeItr(EDPMsOfficeEntity officeEntity, EDPMsOfficeDto dto,
			EDPUpdateOfficeTrnEntity officeTrnEntity) throws CustomException {
		edpMsSubOfficeService.updateAllSubOfficeData(officeEntity);

		EDPMsDepartmentEntity deptEntity = null;

		officeEntity.setUniqueId(generateUniqueId(officeEntity));
		if (EDPConstant.LK_STATUS_VAL_REJECTED.equals(dto.getWfStatus())) {
			officeTrnEntity.setStatusId(EDPConstant.STATUS_REJECTED_ID);
		} else if (EDPConstant.LK_STATUS_VAL_APPROVED.equals(dto.getWfStatus())) {
			officeTrnEntity.setStatusId(EDPConstant.STATUS_APPROVE_ID);

			if (officeEntity.getOfficeTypeId() != null
					&& EDPConstant.LOOKUP_INFO_ADMINI_DEPT.equals(officeEntity.getOfficeTypeId().getLookUpInfoId())) {
				deptEntity = updateDepartmentDetails(officeEntity);
			}
			officeBillMapService.approveOfficeBillMap(dto);
		} else if (EDPConstant.LK_STATUS_VAL_CANCELLED.equals(dto.getWfStatus())) {
			officeTrnEntity.setStatusId(EDPConstant.STATUS_CANCELLED_ID);
		}
		edpOfficeTrnRepository.save(officeTrnEntity);

		if (EDPConstant.LOOKUP_INFO_YES.equals(dto.getWfInRequest())
				&& EDPConstant.LK_STATUS_VAL_APPROVED.equals(dto.getWfStatus())) {
			officeEntity.setStatusId(EDPConstant.STATUS_APPROVED_ID);
			officeEntity = repository.save(officeEntity);

			if (deptEntity != null) {
				edpDepartmentRepository.save(deptEntity);
			}

			edpMsSubOfficeService.approveAllSubOfficeUpdate(officeEntity.getOfficeId(),
					officeTrnEntity.getUpdOffcTrnId());
		} else if (EDPConstant.LOOKUP_INFO_NO.equals(dto.getWfInRequest())) {
			officeEntity.setStatusId(EDPConstant.STATUS_APPROVED_ID);
			officeEntity = repository.save(officeEntity);

			if (deptEntity != null) {
				edpDepartmentRepository.save(deptEntity);
			}

			edpMsSubOfficeService.approveAllSubOfficeUpdate(officeEntity.getOfficeId(),
					officeTrnEntity.getUpdOffcTrnId());
			wfRequestHandler.wfDirectSubmiteApiCall(dto.getCurMenuId(), officeTrnEntity.getUpdOffcTrnId());
		}
	}

	/**
	 * Updates master department office
	 * 
	 * @param officeEntity
	 * @return EDPMsDepartmentEntity
	 */
	private EDPMsDepartmentEntity updateDepartmentDetails(EDPMsOfficeEntity officeEntity) {
		EDPMsDepartmentEntity deptEntity = officeEntity.getDepartmentId();

		deptEntity.setDepartmentName(officeEntity.getOfficeName());
		deptEntity.setDepartmentNameGuj(officeEntity.getOfficeNameGuj());
		deptEntity.setUpdatedBy(OAuthUtility.getCurrentUserUserId());
		deptEntity.setUpdatedByPost(OAuthUtility.getCurrentUserLkPOUId());
		deptEntity.setUpdatedDate(new Date());
		deptEntity.setDepartmentShort(officeEntity.getOfficeShortName());

		if (EDPConstant.LOOKUP_INFO_ACTIVE.equals(officeEntity.getOfficeStatus())) {
			deptEntity.setActiveStatus(EDPConstant.ACTIVE_STATUS_TRUE);
		} else {
			deptEntity.setActiveStatus(EDPConstant.INACTIVE_STATUS);
		}

		return deptEntity;
	}

	/**
	 * submit office details and approve sub offices.
	 *
	 * @param officeEntity      the office entity
	 * @param dto               the dto
	 * @param edpMsOfficeEntity the edp ms office entity
	 * @throws CustomException the custom exception
	 */
	private void submitOffice(EDPMsOfficeEntity officeEntity, EDPMsOfficeDto dto, EDPMsOfficeEntity edpMsOfficeEntity)
			throws CustomException {
		if (EDPConstant.LOOKUP_INFO_YES.equals(dto.getWfInRequest()) && dto.getFormAction() != null
				&& dto.getFormAction() == Status.SUBMITTED) {
			repository.save(officeEntity);
			// on EDP director approver
			if (dto.getWfFinalSubmit().equals(EDPConstant.LOOKUP_INFO_YES)) {
				if (EDPConstant.LOOKUP_INFO_ADMINI_DEPT.equals(dto.getOfficeTypeId())) {
					edpmsdepartmentserviceImpl.createDeparmtment(edpMsOfficeEntity);
				}
				officeEntity.setDepartmentId(edpMsOfficeEntity.getDepartmentId());
				setOfficeEntityData(officeEntity, dto, edpMsOfficeEntity);
				repository.save(officeEntity);
				edpMsSubOfficeServiceImpl.approveAllSubOfficeByOfficeId(officeEntity.getOfficeId());
				edpMsTreasuryServiceImpl.saveTreasurySubTresuryOffice(officeEntity.getOfficeId());
			}
		}
		if (EDPConstant.LOOKUP_INFO_NO.equals(dto.getWfInRequest()) && dto.getFormAction() != null
				&& dto.getFormAction().equals(Status.SUBMITTED)) {
			superAdminSubmit(officeEntity, dto, edpMsOfficeEntity);
		}
	}

	/**
	 * Sets the office entity data.
	 *
	 * @param officeEntity      the office entity
	 * @param dto               the dto
	 * @param edpMsOfficeEntity the edp ms office entity
	 */
	private void setOfficeEntityData(EDPMsOfficeEntity officeEntity, EDPMsOfficeDto dto,
			EDPMsOfficeEntity edpMsOfficeEntity) {
		officeEntity.setUniqueId(generateUniqueId(officeEntity));
		officeEntity.setStatusId(EDPConstant.STATUS_APPROVED_ID);
		if (Boolean.TRUE.equals(dto.getIsNewOffice())) {
			createDefaultPost(officeEntity, edpMsOfficeEntity);
			officeEntity.setOfficeStatus(officeEntity.getOfficeStatus() == null ? EDPConstant.OFFICE_STATUS_ID
					: officeEntity.getOfficeStatus());
		}
	}

	/**
	 * if user is super admin then office is approved without WF.
	 *
	 * @param officeEntity      the office entity
	 * @param dto               the dto
	 * @param edpMsOfficeEntity the edp ms office entity
	 * @throws CustomException the custom exception
	 */
	private void superAdminSubmit(EDPMsOfficeEntity officeEntity, EDPMsOfficeDto dto,
			EDPMsOfficeEntity edpMsOfficeEntity) throws CustomException {
		/* when user is DAT i.e Super admin */
		officeEntity.setStatusId(EDPConstant.STATUS_APPROVED_ID);
		officeEntity.setUniqueId(generateUniqueId(officeEntity));
		if (dto.getOfficeTypeId() != null && EDPConstant.LOOKUP_INFO_ADMINI_DEPT.equals(dto.getOfficeTypeId())) {
			edpmsdepartmentserviceImpl.createDeparmtment(edpMsOfficeEntity);
		}
		wfRequestHandler.wfDirectSubmiteApiCall(dto.getCurMenuId(), edpMsOfficeEntity.getOfficeId());
		officeEntity.setDepartmentId(edpMsOfficeEntity.getDepartmentId());
		if (Boolean.TRUE.equals(dto.getIsNewOffice())) {
			createDefaultPost(officeEntity, edpMsOfficeEntity);
			officeEntity.setOfficeStatus(officeEntity.getOfficeStatus() == null ? EDPConstant.OFFICE_STATUS_ID
					: officeEntity.getOfficeStatus());
			repository.save(officeEntity);
		} else {
			repository.save(officeEntity);
		}
		edpMsSubOfficeServiceImpl.approveAllSubOfficeByOfficeId(officeEntity.getOfficeId());
		edpMsTreasuryServiceImpl.saveTreasurySubTresuryOffice(officeEntity.getOfficeId());
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
	 * Updates OfficeItr entity based on inputs provided and returns saved instance
	 * for further operations.
	 *
	 * @param dto the dto
	 * @return officeItr entity
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPMsOfficeEntity updateMsOffice(EDPMsOfficeDto dto) throws CustomException {
		EDPMsOfficeEntity newOfficeEntity = converter.toEntity(dto);

		EDPOfficeItrEntity officeItrEntity = updateOfficeItrDetails(newOfficeEntity, dto);
		EDPUpdateOfficeTrnEntity officeTrnEntity = officeItrEntity.getOfficeTrnEntity();
		newOfficeEntity.setOfficeTrnEntity(officeTrnEntity);

		if (dto.getTransactionNo() == null || dto.getTransactionNo().isEmpty()) {
			wfRequestHandler.saveAsDraftWf(dto.getCurMenuId(), officeTrnEntity.getUpdOffcTrnId());
			edpMsSubOfficeService.copyMsSubOffice(newOfficeEntity, officeTrnEntity);
		}

		officeBillMapService.updateOfficeBillsItr(dto);
		edpMsSubOfficeService.updateSubOfficeItr(newOfficeEntity);

		return newOfficeEntity;
	}

	/**
	 * Update office itr details.
	 *
	 * @param newOfficeEntity the new office entity
	 * @param dto             the dto
	 * @return the EDP office itr entity
	 */
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public EDPOfficeItrEntity updateOfficeItrDetails(EDPMsOfficeEntity newOfficeEntity, EDPMsOfficeDto dto) {
		EDPUpdateOfficeTrnEntity officeTrnEntity = validateUpdateRequest(dto);

		convertToOfficeEntity(newOfficeEntity, dto);

		EDPOfficeItrEntity edpOfficeItrEntity = officeItrConverter.toEntity(newOfficeEntity);
		edpOfficeItrEntity.setOfficeTrnEntity(officeTrnEntity);
		if (dto.getFormAction() == Status.SUBMITTED) {
			edpOfficeItrEntity.setStatusId(EDPConstant.STATUS_SUBMIT_ID.shortValue());
		}

		return officeItrRepository.save(edpOfficeItrEntity);
	}

	/**
	 * Converts input to Master Office Entity
	 * 
	 * @param newOfficeEntity
	 * 
	 * @param dto
	 * @return
	 */
	private void convertToOfficeEntity(EDPMsOfficeEntity newOfficeEntity, EDPMsOfficeDto dto) {
		/** Generate new Transaction Number if empty */
		if (StringUtils.isEmpty(dto.getTransactionNo())) {
			newOfficeEntity.setTransactionNo(generateTrnNo(dto));
		}

		if (dto.getHodId() != null && EDPConstant.DDO_TYPE_ID.equals(dto.getOfficeTypeId())) {
			newOfficeEntity.setParentOfficeId(Long.valueOf(dto.getHodId()));
		}

		newOfficeEntity.setStatusId(EDPConstant.OFFICE_STATUS_DRAFT_ID.shortValue());
		newOfficeEntity.setIsUpdate(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));

		setCurrentUserDataInCreatedData(newOfficeEntity);

		if (newOfficeEntity.getOfficeTypeId() != null
				&& newOfficeEntity.getOfficeTypeId().getLookUpInfoId() == EDPConstant.HOD_ID) {
			newOfficeEntity.setIsHod(EDPConstant.LOOKUP_INFO_YES);
		} else {
			newOfficeEntity.setIsHod(EDPConstant.LOOKUP_INFO_NO);
		}

		newOfficeEntity.setObjection(dto.getObjection());
		newOfficeEntity.setObjectionRemarks(dto.getObjectionRemarks());
		if (dto.getOfficeId() != null && dto.getOfficeId() == 0) {
			newOfficeEntity.setInitiatedBy(OAuthUtility.getCurrentUserLkPOUId());
			newOfficeEntity.setWfInRequest(dto.getWfInRequest());
		}

		if (newOfficeEntity.getPvuId() != null && newOfficeEntity.getPvuId() == 0)
			newOfficeEntity.setPvuId(newOfficeEntity.getOfficeId());

		if (Status.SUBMITTED == dto.getFormAction()) {
			if (newOfficeEntity.getOfficeId() == 38L) {
				newOfficeEntity.setOfficeDivision("DAT");
				newOfficeEntity.setOfficeNameAlias(EDPConstant.PVU_OFF_GANDHINAGAR);
				newOfficeEntity.setOfficePVU(EDPConstant.FIND_PVU);
			} else if (newOfficeEntity.getOfficeId() == 87L) {
				newOfficeEntity.setOfficeDivision("GAD");
			}
		}
	}

	/**
	 * Validate update request.
	 *
	 * @param dto the dto
	 * @return true, if successful
	 */
	private EDPUpdateOfficeTrnEntity validateUpdateRequest(EDPMsOfficeDto dto) {
		EDPUpdateOfficeTrnEntity officeTrnEntity = initOfficeTrn(dto);

		/**
		 * boolean trnOwner = officeTrnEntity.getUpdatedBy() ==
		 * OAuthUtility.getCurrentUserUserId(); if (!trnOwner) { assigned to other
		 * 
		 * // throw new CustomException() }
		 */

		return officeTrnEntity;
	}

	/**
	 * Checks for Workflow init status.
	 *
	 * @param dto the dto
	 * @return boolean
	 */
	private EDPUpdateOfficeTrnEntity initOfficeTrn(EDPMsOfficeDto dto) {
		EDPUpdateOfficeTrnEntity entity = getLastOfficeTrn(dto.getOfficeId(), EDPConstant.ACTIVE_STATUS_TRUE);

		if (entity == null || !EDPConstant.STATUS_SUBMIT_ID.equals(entity.getStatusId())) {
			entity = new EDPUpdateOfficeTrnEntity();
			entity.setCreatedDate(new Date());
			entity.setCreatedByPost(OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());
			entity.setCreatedBy(OAuthUtility.getCurrentUserUserId());
			entity.setMsOfficeEntity(new EDPMsOfficeEntity(dto.getOfficeId()));
			entity.setStatusId(EDPConstant.STATUS_SUBMIT_ID);
		}

		entity.setUpdatedBy(OAuthUtility.getCurrentUserUserId());
		entity.setUpdatedDate(new Date());
		entity.setUpdatedByPost(OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());
		return edpOfficeTrnRepository.save(entity);
	}

	/**
	 * Fetch last submitted transaction based on office id and active status
	 * 
	 * @param officeId
	 * @param activeStatus
	 * @return
	 */
	@Override
	public EDPUpdateOfficeTrnEntity getLastOfficeTrn(Long officeId, int activeStatus) {
		TypedQuery<EDPUpdateOfficeTrnEntity> query = entityManager.createQuery(
				"SELECT trn FROM EDPUpdateOfficeTrnEntity trn WHERE trn.msOfficeEntity.officeId = :officeId "
						+ "AND trn.activeStatus = :activeStatus ORDER BY trn.updOffcTrnId DESC",
				EDPUpdateOfficeTrnEntity.class);

		query.setParameter("officeId", officeId);
		query.setParameter("activeStatus", activeStatus);
		query.setMaxResults(1);

		List<EDPUpdateOfficeTrnEntity> result = query.getResultList();

		return result != null && !result.isEmpty() ? result.get(0) : null;
	}

	/**
	 * Gets the offices and status by district.
	 *
	 * @param districtId the district id
	 * @param ddoNo      the ddo no
	 * @param cardexNo   the cardex no
	 * @param office     the office
	 * @return the offices and status by district
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPOfficeDto> getOfficesAndStatusByDistrict(Long districtId, String ddoNo, Long cardexNo, String office)
			throws CustomException {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(EDPConstant.DISTRICT_VALUE, districtId);
		argsMap.put(EDPConstant.DDO_NO_VALUE, ddoNo);
		argsMap.put(EDPConstant.CARDEX_NO_VALUE, cardexNo);
		argsMap.put(EDPConstant.OFFICE_NAME_VALUE, office);
		String procName = Constant.EDP_SCHEMA
				.concat(Constant.DOT.concat(EDPConstant.SP_EDP_GET_OFFICE_DTL_BY_DISTRICT));
		List<Object[]> objectSp = repository.callStoredProcedure(procName, argsMap);
		return NativeQueryResultsMapper.map(objectSp, EDPOfficeDto.class);
	}

	/**
	 * Check for Workflow already initiated status.
	 *
	 * @param dto the dto
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(readOnly = true)
	public List<EDPWorkflowStatusDto> checkWfStatus(EDPIdDto dto) throws CustomException {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(EDPConstant.IN_OFFICE_ID_VALUE, dto.getOfficeId());
		String procName = getProcName(Constant.EDP_SCHEMA, EDPConstant.SP_EDP_CHECK_UPD_OFFICE_REQUEST_EXISTS);

		List<Object[]> objectSp = repository.callStoredProcedure(procName, argsMap);

		List<EDPWorkflowStatusDto> result = NativeQueryResultsMapper.map(objectSp, EDPWorkflowStatusDto.class);

		return result == null ? new ArrayList<>() : result;
	}

	/**
	 * Returns Procedure name.
	 *
	 * @param schema   the schema
	 * @param procName the proc name
	 * @return the proc name
	 */
	private String getProcName(String schema, String procName) {
		if ((schema == null || schema.length() < 1) || (procName == null || procName.length() < 1)) {
			return null;
		}

		return schema.concat(Constant.DOT.concat(procName));
	}

	/**
	 * Build the error msg based on input provided.
	 *
	 * @param dto the dto
	 * @return the error message
	 */
	@Override
	public String getWfInitErrorMessage(EDPWorkflowStatusDto dto) {
		if (dto == null)
			return "";

		return MessageFormat.format(MsgConstant.EDP_REQUEST_INITIATE_UPDATE_OFFICE_MSG, dto.getTrnNo(), dto.getEmpNo(),
				dto.getEmpName(), dto.getPostName(), dto.getOfficeName(), dto.getDistrict(), dto.getDdoNo(),
				dto.getCardexNo());
	}

	/**
	 * check ddo no by district id if present then true else false.
	 *
	 * @param districtId the district id
	 * @param ddoNo      the ddo no
	 * @return boolean
	 */
	@Override
	public boolean checkDdoNoByDistrictId(Long districtId, String ddoNo) {
		List<String> ddoNos = repository.findDdoNoByDistrictIdDistrictIdAndActiveStatus(districtId,
				Constant.ACTIVE_STATUS);
		if (ddoNos.contains(ddoNo)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;

	}

	/**
	 * Gets the bills by office id.
	 *
	 * @param id the id
	 * @return the bills by office id
	 */
	@Override
	public List<ClueDto> getBillsByOfficeId(Long id) {
		try {
			Map<String, Object> argMap = new HashMap<>();
			argMap.put(EDPConstant.IN_OFFICE_ID_VALUE, id);
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_REPORT_OFFICE_GET_BILL));
			List<Object[]> responseList = repository.callStoredProcedure(procName, argMap);
			if (!CollectionUtils.isEmpty(responseList)) {
				return responseList.stream().map(res -> {
					ClueDto dto = new ClueDto();
					dto.setName(EDPUtility.convertObjectToString(res[0]));
					return dto;
				}).collect(Collectors.toList());
			} else {
				return Collections.emptyList();
			}
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

	/**
	 * Approve office update.
	 *
	 * @param dto the dto
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void approveOfficeUpdate(EDPMsOfficeDto dto) throws CustomException {
		EDPMsOfficeEntity officeEntity = converter.toEntity(dto);
		convertToOfficeEntity(officeEntity, dto);
		officeEntity.setObjRemark(null);
		officeEntity.setObjectionRemarks(null);
		officeEntity.setObjection(1L);
		officeEntity.setObjStatus(1);

		EDPUpdateOfficeTrnEntity officeTrnEntity = getLastOfficeTrn(dto.getOfficeId(), EDPConstant.ACTIVE_STATUS_TRUE);

		if (officeTrnEntity == null) {
			throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
		}

		EDPOfficeItrEntity edpOfficeItrEntity = officeItrConverter.toEntity(officeEntity);
		edpOfficeItrEntity.setOfficeTrnEntity(officeTrnEntity);
		if (dto.getFormAction() == Status.SUBMITTED) {
			edpOfficeItrEntity.setStatusId(EDPConstant.STATUS_SUBMIT_ID.shortValue());
		}
		officeItrRepository.save(edpOfficeItrEntity);

		updateOfficeItr(officeEntity, dto, officeTrnEntity);
	}

	/**
	 * Gets details of Office based on Id.
	 * 
	 * @param id
	 * @return the EDPMsOfficeEntityDto or {@literal} null} if none found
	 */
	@Override
	public EDPMsOfficeDto getMasterOfficeDetails(Long id) {
		EDPMsOfficeEntity officeEntity = repository.findByOfficeIdAndActiveStatus(id, EDPConstant.ACTIVE_STATUS_TRUE);
		if (officeEntity == null) {
			return null;
		}

		EDPMsOfficeDto officeDto = edpMsOfficeConverter.toDTO(officeEntity);

		List<EDPOfficeBillMapEntity> billMapEntitiesItr = officeBillMapRepository.findByOfficeIdAndActiveStatus(id,
				Constant.ACTIVE_STATUS);
		if (!CollectionUtils.isEmpty(billMapEntitiesItr)) {
			officeDto.setBillSubmittedTo(billMapEntitiesItr.get(0).getBillSubmittedTo());
			officeDto.setBillType(billMapEntitiesItr.get(0).getBillType());
			officeDto.setSelectedBills(
					billMapEntitiesItr.stream().map(EDPOfficeBillMapEntity::getBillListId).collect(Collectors.toSet()));
		}

		List<EDPOfficeModuleEntity> officeModuleEntities = officeModuleRepository.findByOfficeIdAndActiveStatus(id,
				Constant.ACTIVE_STATUS);

		setNameById(officeEntity, officeDto, officeModuleEntities);

		Long prvOfficeStatusId = officeItrRepository.findLastApprovedOfficeStatus(id);
		if (prvOfficeStatusId != null) {
			EDPLuLookUpInfoEntity lookUpInfo = lookUpInfoRepository.findBylookUpInfoId(prvOfficeStatusId);
			if (lookUpInfo != null) {
				officeDto.setPrvOfficeStatusId(prvOfficeStatusId);
				officeDto.setPrvOfficeStatus(lookUpInfo.getLookUpInfoName());
			}
		}

		if (officeEntity.getOfficeTransferId() != null) {
			officeDto.setOfficeTransferDetails(getOfficeTransferDetails(officeEntity.getOfficeTransferId()));
		}

		return officeDto;
	}

	/**
	 * Get Transfered Office Details based on input
	 * 
	 * @param officeId
	 * @return EDPOfficeTransferDetails
	 */
	private EDPOfficeTransferDetails getOfficeTransferDetails(Long officeId) {
		EDPMsOfficeEntity transOfficeEntity = repository.findByOfficeIdAndActiveStatus(officeId,
				EDPConstant.ACTIVE_STATUS_TRUE);
		if (transOfficeEntity == null) {
			return null;
		}

		EDPOfficeTransferDetails officeTransDto = new EDPOfficeTransferDetails();
		officeTransDto.setOfficeId(transOfficeEntity.getOfficeId());
		officeTransDto.setOfficeName(transOfficeEntity.getOfficeName());
		officeTransDto.setOfficeName(transOfficeEntity.getOfficeName());
		officeTransDto.setDistrictId(
				transOfficeEntity.getDistrictId() != null ? transOfficeEntity.getDistrictId().getDistrictId() : null);
		officeTransDto.setCardexNo(transOfficeEntity.getCardexno().toString());
		officeTransDto.setDdoNo(transOfficeEntity.getDdoNo());

		return officeTransDto;
	}

	@Override
	public List<EDPMsOfficeDto> getTrsPaoOffices(IdDto idDto) {
		Set<Long> districts = new HashSet<>();
		districts.add(idDto.getId());
		if(idDto.getId().equals(EDPConstant.DISTRICT_GANDHINAGAR_PAO_ID)){
			districts.add(EDPConstant.DISTRICT_GANDHINAGAR_ID);
		}else if(idDto.getId().equals(EDPConstant.DISTRICT_AHMEDABAD_PAO_ID)){
			districts.add(EDPConstant.DISTRICT_AHMEDABAD_ID);
		}else if(idDto.getId().equals(EDPConstant.DISTRICT_GANDHINAGAR_ID)){
			districts.add(EDPConstant.DISTRICT_GANDHINAGAR_PAO_ID);
		}else if(idDto.getId().equals(EDPConstant.DISTRICT_AHMEDABAD_ID)){
			districts.add(EDPConstant.DISTRICT_AHMEDABAD_PAO_ID);
		}
		Set<Long> officeSubTypes = new HashSet<>();
		officeSubTypes.add(EDPConstant.EDP_OFF_SUB_TYPE_TO);
		officeSubTypes.add(EDPConstant.EDP_OFF_SUB_TYPE_STO);
		officeSubTypes.add(EDPConstant.EDP_OFF_SUB_TYPE_PAO);
		List<EDPMsOfficeEntity> trsOffices = repository.findTrsPaoOfficesByDist(districts,
				EDPConstant.STATUS_APPROVED_ID, EDPConstant.LOOKUP_TRUE, officeSubTypes, EDPConstant.LOOKUP_INFO_ACTIVE);
		if (trsOffices != null && !trsOffices.isEmpty()) {
			return converter.toDTO(trsOffices);
		}

		return new ArrayList<>();
	}

	@Override
	public boolean validateCardexNo(Long cardexNo) {
		List<Long> cardex = repository.findByCardexNo(cardexNo, Constant.ACTIVE_STATUS);
		if (null != cardex && !cardex.isEmpty()) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public List<EDPMsOfficeDto> getBillSubmitToByOffice(Long officeId) {
		List<EDPMsOfficeEntity> officesEntity = repository
				.getBillSubmitToByOffice(officeId, EDPConstant.STATUS_APPROVED_ID,
						EDPConstant.OFFICE_STATUS_ID, OAuthConstant.ACTIVE_STATUS);
		return converter.toOfficeIdAndOfficeName(officesEntity);
	}
	
	@Override
	public List<EDPMsOfficeDto> getOfficeByOfficeTypeAndSubOfficeType(EDPOffTypeAndSubTypeDto dto) {
		List<EDPMsOfficeEntity> officesEntity = repository
				.findByOfficeTypeIdLookUpInfoIdAndSubTypeSubTypeIdAndStatusIdAndOfficeStatusAndActiveStatus(dto.getOfficeTypeId(),dto.getOfficeSubTypeId(), EDPConstant.STATUS_APPROVED_ID,
						EDPConstant.OFFICE_STATUS_ID, OAuthConstant.ACTIVE_STATUS,
						EDPUtility.getJpaSort(EDPConstant.OFFICE_NAME, EDPConstant.ORDER_ASC));
		return converter.toOfficeIdAndOfficeName(officesEntity);
	}
	
	@Override
	public List<EDPMsOfficeDto>  getTreasuryOfficeByDistrictId(Long districtId) {
		List<EDPMsOfficeEntity> officesEntity = repository
				.findTreasuryOfficeByDistriceId(districtId,EDPConstant.TREASURY_OFFICE_SUB_TYPE, EDPConstant.LOOKUP_TRUE ,EDPConstant.STATUS_APPROVED_ID,
						EDPConstant.OFFICE_STATUS_ID, OAuthConstant.ACTIVE_STATUS);
		return converter.toOfficeIdAndOfficeName(officesEntity);
	}


	@Override
	public List<ClueDto> validateCardexNoAndDdoNo(List<Long> officeId) {
		List<EDPMsOfficeEntity> list = repository.validateCardexNoAndDdoNoByPouId(officeId, Constant.ACTIVE_STATUS);
		if (list != null && !list.isEmpty()) {
			List<ClueDto> responseList = new ArrayList<>();
			for (EDPMsOfficeEntity edpMsOfficeEntity : list) {
				ClueDto clueDto = new ClueDto();
				clueDto.setCardexNo(edpMsOfficeEntity.getCardexno());
				clueDto.setDdoNo(edpMsOfficeEntity.getDdoNo());
				clueDto.setOfficeName(edpMsOfficeEntity.getOfficeName());
				responseList.add(clueDto);
			}
			return responseList;
		}

		return new ArrayList<>();
	}

	
	@Override
	public List<EDPMsOfficeDto> getCOListByDepartmentId(Long departmentId) {
		List<EDPMsOfficeEntity> officesEntity = repository
				.findByDepartmentIdDepartmentIdAndSubTypeSubTypeNameAndStatusIdAndOfficeStatusAndActiveStatus(departmentId, EDPConstant.OFFICE_SUB_TYPE_CIRCLE_OFFICE, EDPConstant.STATUS_APPROVED_ID,
						EDPConstant.OFFICE_STATUS_ID, OAuthConstant.ACTIVE_STATUS);
		return converter.toDTO(officesEntity);
	}


	@Override
	public List<EDPMsOfficeDto> getHODListByDepartmentOffice(Long departmentId) {
		EDPLuLookUpInfoEntity officeTypeEntity = edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(EDPConstant.OFFICE_TYPE_ID_LU_NAME,Constant.ACTIVE_STATUS,EDPConstant.OFFICE_TYPE_ID_HOD_LU_INFO_NAME);

		Long hodOfficeTypeId = officeTypeEntity != null ? officeTypeEntity.getLookUpInfoId(): 0l;

		List<EDPMsOfficeEntity> officesEntity = repository
				.findByDepartmentIdDepartmentIdAndOfficeTypeIdLookUpInfoIdAndStatusIdAndOfficeStatusAndActiveStatus(departmentId, hodOfficeTypeId, EDPConstant.STATUS_APPROVED_ID,
						EDPConstant.OFFICE_STATUS_ID, OAuthConstant.ACTIVE_STATUS);
		return converter.toDTO(officesEntity);
	}
	
}
