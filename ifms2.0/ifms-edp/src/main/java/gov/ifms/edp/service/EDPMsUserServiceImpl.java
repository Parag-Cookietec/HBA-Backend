package gov.ifms.edp.service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.filenet.api.core.Document;
import com.filenet.api.util.Id;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.FieldDto;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.FilenetUtility;
import gov.ifms.edp.converter.EDPMsUserConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPEmployeePostSearchView;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPMsUserDto;
import gov.ifms.edp.dto.EDPMsUserPasswordResetDisplayDto;
import gov.ifms.edp.dto.EDPUserRightsDto;
import gov.ifms.edp.dto.EDPWfRolesMenuDto;
import gov.ifms.edp.dto.MinisterUserReqDto;
import gov.ifms.edp.dto.UserDto;
import gov.ifms.edp.employe.EDPEmployeRepository;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLkPostUserEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPMsUserPassHistEntity;
import gov.ifms.edp.oauth.service.OAuthService;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLkEmpUserRepository;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLkPostUserRepository;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPMsUserPassHistRepository;
import gov.ifms.edp.repository.EDPMsUserRepository;
import gov.ifms.edp.repository.EDPUserRoleMappingRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPNativeSQLUtil;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPMsUserServiceImpl.
 */
@Service
public class EDPMsUserServiceImpl implements EDPMsUserService {

	/** The EDPMsUserAsMethodName repository. */
	@Autowired
	private EDPMsUserRepository repository;

	/** The post user repo. */
	@Autowired
	private EDPLkPostUserRepository postUserRepo;

	/** The EDPMsUserAsMethodName helper. */
	@Autowired
	private EDPMsUserConverter converter;

	/** The edp lk po off user repository. */
	@Autowired
	private EDPLkPoOffUserRepository edpLkPoOffUserRepository;

	/** The edp ms office repository. */
	@Autowired
	private EDPMsOfficeRepository edpMsOfficeRepository;

	/** The edp lu look up info repository. */
	@Autowired
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	/** The edp lk emp user repository. */
	@Autowired
	EDPLkEmpUserRepository edpLkEmpUserRepository;
	
	/** The lookupinforepository. */
	@Autowired
	EDPLuLookUpInfoRepository lookupinforepository;

	/** The edp ms user pass hist repository. */
	@Autowired
	private EDPMsUserPassHistRepository edpMsUserPassHistRepository;

	/** The encrypt decrypt utill. */
	@Autowired
	private EncryptDecryptUtil encryptDecryptUtill;

	/** The oauth service. */
	@Autowired
	OAuthService oauthService;

	/** The edp user role mapping repository. */
	@Autowired
	private EDPUserRoleMappingRepository edpUserRoleMappingRepository;
	
	/** The edp employe repository. */
	@Autowired
	private EDPEmployeRepository edpEmployeRepository;
	
	/**
	 * Returns all instances of the EDPMsUserEntity type.
	 * 
	 * @return all EDPMsUserEntity
	 */
	@Override
	public List<EDPMsUserEntity> getMsUsers() {
		return repository.findAll();
	}

	/**
	 * Retrieves an EDPMsUserEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsUserEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsUserEntity getMsUser(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsUserEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param bpn the bpn
	 * @return the saved EDPMsUserEntity
	 */
	@Override
	public EDPMsUserEntity saveOrUpdateMsUser(EDPMsUserEntity bpn) {
		return repository.save(bpn);
	}

	/**
	 * Deletes the EDPMsUserEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */

	@Override
	public void deleteMsUser(Long id) {
		repository.deleteById(id);

	}

	/**
	 * Saves all given EDPMsUserEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	@Override
	public List<EDPMsUserEntity> saveMsUsers(List<EDPMsUserEntity> entities) {
		return repository.saveAll(entities);
	}

	/**
	 * Fetch all the EDPMsUser items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsUserDto>
	 */

	@Override
	public PagebleDTO<EDPMsUserDto> edpMsUserAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPMsUserEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();

		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<EDPMsUserEntity> empSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
		Page<EDPMsUserEntity> page = repository.findAll(empSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				converter.toDTO(page.getContent()));
	}

	/**
	 * Gets the dependent uer id by user id.
	 *
	 * @param userId the user id
	 * @return the dependent uer id by user id
	 */
	@Override
	public List<IdDto> getDependentUerIdByUserId(Long userId) {
		List<IdDto> idDtos = new ArrayList<>();
		List<EDPLkPoOffUserEntity> lkPoOffUserEntityList = edpLkPoOffUserRepository
				.findByUserIdUserIdAndActiveStatus(userId, OAuthConstant.ACTIVE_STATUS);

		lkPoOffUserEntityList.forEach(edpLkPoOffUserEntity -> {
			EDPMsOfficeEntity edpMsOfficeEntity = edpLkPoOffUserEntity.getLkPostOfficeId().getOfficeEntity();
			if (edpMsOfficeEntity != null && edpMsOfficeEntity.getOfficeTypeId() != null) {
				if (edpMsOfficeEntity.getOfficeTypeId().getOrderId() == 1) {
					IdDto idDto = new IdDto();
					idDto.setId(userId);
					idDtos.add(idDto);
				} else {
					Set<Long> lookUpInfoIds = new HashSet<>();

					// For decrease order, use for loop
					IntStream.range(0, edpMsOfficeEntity.getOfficeTypeId().getOrderId())
							.map(i -> 0 + (edpMsOfficeEntity.getOfficeTypeId().getOrderId() - 1 - i))
							.forEach(i -> lookUpInfoIds.add(edpMsOfficeEntity.getOfficeTypeId().getLookUpInfoId()));

					List<EDPMsOfficeEntity> officeEntities = edpMsOfficeRepository
							.findByOfficeTypeIdLookUpInfoIdIn(lookUpInfoIds);
					officeEntities.forEach(officeEntity -> {
						List<EDPLkPoOffUserEntity> userOfficeEntities = edpLkPoOffUserRepository
								.findByLkPostOfficeIdOfficeEntityOfficeIdAndActiveStatus(officeEntity.getOfficeId(),
										OAuthConstant.ACTIVE_STATUS);
						userOfficeEntities.forEach(userOfficeEntity -> {
							IdDto idDto = new IdDto();
							idDto.setId(userOfficeEntity.getUserId().getUserId());
							idDtos.add(idDto);
						});
					});
				}
			}
		});
		return idDtos;
	}

	/**
	 * Find By UserName And Password.
	 *
	 * @param userName the user name
	 * @param passwrod the passwrod
	 * @return the EDP ms user entity
	 */
	public EDPMsUserEntity findUserByNameAndPassword(String userName, String passwrod) {
		return repository.findByUserNameContainingIgnoreCaseAndPassword(userName, passwrod);
	}

	/**
	 * Find By UserName.
	 *
	 * @param userName the user name
	 * @return the EDP ms user entity
	 */
	public EDPMsUserEntity findUserByName(String userName) {
		return repository.findByUserNameContainingIgnoreCase(userName);
	}

	/**
	 * Gets the ms user by post id.
	 *
	 * @param id the id
	 * @return the ms user by post id
	 */
	@Override
	public List<EDPMsUserEntity> getMsUserByPostId(Long id) {
		return postUserRepo.findByEdpMsPostsPostId(id).stream().map(EDPLkPostUserEntity::getEdpMsUsers)
				.collect(Collectors.toList());
	}

	/**
	 * Gets the all code and id.
	 *
	 * @return the all code and id
	 */
	@Override
	public List<ClueDto> getAllCodeAndId() {
		return EDPUtility.getFromObject(repository.findCodeAndId());
	}

	/**
	 * Find user by user code.
	 *
	 * @param userCode the user code
	 * @return the EDP ms user entity
	 */
	public EDPMsUserEntity findUserByUserCode(Long userCode) {
		Optional<EDPMsUserEntity> entity = repository.findByUserCode(userCode);
		if (entity.isPresent()) {
			return entity.get();
		} else {
			return null;
		}
	}

	/**
	 * Find user by user code and password.
	 *
	 * @param userCode the user code
	 * @param password the password
	 * @return the EDP ms user entity
	 */
	public EDPMsUserEntity findUserByUserCodeAndPassword(String userCode, String password) {
		return repository.findByUserCodeAndPassword(Long.valueOf(userCode), password);
	}

	/**
	 * Find all usersfor globle password.
	 *
	 * @param userCode the user code
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<EDPMsUserPasswordResetDisplayDto> findAllUsersforGloblePassword(Long userCode) throws CustomException {
		List<EDPMsUserPasswordResetDisplayDto> edpMsUserPasswordResetDisplayDtoList = new ArrayList<>();
		if (Long.parseLong(OAuthUtility.getCurrentUserCode()) != userCode) {
			EDPMsUserEntity userEntity = repository.findByUserCodeAndActiveStatus(userCode, Constant.ACTIVE_STATUS);
			if (null != userEntity) {
				Optional<EDPLkPoOffUserEntity> userofficeentity = edpLkPoOffUserRepository
						.findByUserIdUserIdAndActiveStatusAndIsPrimaryPostLookUpInfoName(userEntity.getUserId(),
								Constant.ACTIVE_STATUS, Constant.LOOKUP_YES);
				if (userofficeentity.isPresent()) {
					EDPLkPoOffUserEntity searchuserofficeentity = userofficeentity.get();
					EDPMsOfficeEntity searchofficeEntity = userofficeentity.get().getLkPostOfficeId().getOfficeEntity();
					EDPMsUserPasswordResetDisplayDto edpMsUserPasswordResetDisplayDto = new EDPMsUserPasswordResetDisplayDto();
					edpMsUserPasswordResetDisplayDto.setUserCode(userEntity.getUserCode());
					edpMsUserPasswordResetDisplayDto.setUserName(userEntity.getUserName());
					edpMsUserPasswordResetDisplayDto
							.setUserId(encryptDecryptUtill.encrypt(Long.toString(userEntity.getUserId())));
					edpMsUserPasswordResetDisplayDto.setOfficeName(searchofficeEntity.getOfficeName());
					edpMsUserPasswordResetDisplayDto
							.setPostName(searchuserofficeentity.getLkPostOfficeId().getPostEntity().getPostName());
					if (searchuserofficeentity.getIsPrimaryPost().getLookUpInfoValue().equals(EDPConstant.VALUE_ONE)) {
						edpMsUserPasswordResetDisplayDto.setPostType(EDPConstant.PRIMARY_POST);
					} else {
						edpMsUserPasswordResetDisplayDto.setPostType(EDPConstant.SECONDARY_POST);
					}
					edpMsUserPasswordResetDisplayDtoList.add(edpMsUserPasswordResetDisplayDto);
				}
			} else {
				throw new CustomException(HttpStatus.OK, OAuthConstant.USER_CODE_NOT_FOUND);
			}
		} else {
			throw new CustomException(HttpStatus.OK, OAuthConstant.SELF_USER_CODE_FOUND);
		}
		return edpMsUserPasswordResetDisplayDtoList;
	}

	/**
	 * Find user for reset pwd.
	 *
	 * @param userCode the user code
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<EDPMsUserPasswordResetDisplayDto> findUserforResetpwd(Long userCode) throws CustomException {

		if (Long.parseLong(OAuthUtility.getCurrentUserCode()) != userCode) {
			EDPMsUserEntity userEntity = repository.findByUserCodeAndActiveStatus(userCode, Constant.ACTIVE_STATUS);
			if (null != userEntity) {
				Optional<EDPLkPoOffUserEntity> userofficeentity = edpLkPoOffUserRepository
						.findByUserIdUserIdAndActiveStatusAndIsPrimaryPostLookUpInfoName(userEntity.getUserId(),
								Constant.ACTIVE_STATUS, Constant.LOOKUP_YES);
				if (userofficeentity.isPresent()) {
					return checkUserOfficeAndDistricts(userEntity, userofficeentity.get());
				} else {
					throw new CustomException(HttpStatus.OK, OAuthConstant.NO_POST_MAP_TO_THIS_USER);
				}
			} else {
				throw new CustomException(HttpStatus.OK, OAuthConstant.USER_CODE_NOT_FOUND);
			}
		} else {
			throw new CustomException(HttpStatus.OK, OAuthConstant.SELF_USER_CODE_FOUND);
		}
	}

	/**
	 * Check user office and districts.
	 *
	 * @param userEntity             the user entity
	 * @param searchuserofficeentity the searchuserofficeentity
	 * @return the list
	 */
	private List<EDPMsUserPasswordResetDisplayDto> checkUserOfficeAndDistricts(EDPMsUserEntity userEntity,
			EDPLkPoOffUserEntity searchuserofficeentity) {

		List<EDPMsUserPasswordResetDisplayDto> edpMsUserPasswordResetDisplayDtoList = new ArrayList<>();
		EDPMsOfficeDto officeEntity = OAuthUtility.getCurrentUserOfficeOauthToken();
		EDPMsOfficeEntity searchofficeEntity = searchuserofficeentity.getLkPostOfficeId().getOfficeEntity();
		EDPLuLookUpInfoEntity lookUpObj = edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.LOOKUP_YES);

		if (officeEntity.getOfficeId().equals(searchofficeEntity.getOfficeId()) || (null != officeEntity.getIsTreasury()
				&& officeEntity.getIsTreasury() == ((short) lookUpObj.getLookUpInfoId())
				&& null != searchofficeEntity.getDistrictId()
				&& searchofficeEntity.getDistrictId().getDistrictId().equals(officeEntity.getDistrictId()))) {
			EDPMsUserPasswordResetDisplayDto edpMsUserPasswordResetDisplayDto = new EDPMsUserPasswordResetDisplayDto();
			edpMsUserPasswordResetDisplayDto.setUserCode(userEntity.getUserCode());
			edpMsUserPasswordResetDisplayDto.setUserName(userEntity.getUserName());
			edpMsUserPasswordResetDisplayDto
					.setUserId(encryptDecryptUtill.encrypt(Long.toString(userEntity.getUserId())));
			edpMsUserPasswordResetDisplayDto.setOfficeName(searchofficeEntity.getOfficeName());
			edpMsUserPasswordResetDisplayDto
					.setPostName(searchuserofficeentity.getLkPostOfficeId().getPostEntity().getPostName());
			edpMsUserPasswordResetDisplayDto.setPostType(EDPConstant.PRIMARY_POST);
			edpMsUserPasswordResetDisplayDtoList.add(edpMsUserPasswordResetDisplayDto);
		}
		return edpMsUserPasswordResetDisplayDtoList;
	}

	/**
	 * Reset password.
	 *
	 * @param fieldDto     the field dto
	 * @param resetPwdFlag the reset pwd flag
	 * @return true, if successful
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean resetPassword(FieldDto fieldDto, Boolean resetPwdFlag) throws CustomException {
		try {
			Optional<EDPMsUserEntity> optionalEdpMsUserEntity = repository
					.findById(Long.parseLong(encryptDecryptUtill.decrypt(fieldDto.getFieldValue())));
			if (optionalEdpMsUserEntity.isPresent()) {
				String newpwd = oauthService.encodePassword(EDPConstant.DEFAULT_PASWD);
				EDPMsUserEntity updateEntity = optionalEdpMsUserEntity.get();
				insertPasswordHistory(newpwd, optionalEdpMsUserEntity.get().getUserId());
				long loginUserId = OAuthUtility.getCurrentUserUserId();
				updateEntity.setPassword(newpwd);
				updateEntity.setPwdChangedDate(new Date());
				updateEntity.setUpdatedBy(loginUserId);
				updateEntity.setUpdatedDate(new Date());
				updateEntity.setUpdatedByPost(loginUserId);
				updateEntity.setIsPassReset(OAuthConstant.IS_RESET_PWD_VALUE);
				updateEntity.setFirstLogin(Constant.IN_ACTIVE_STATUS);
				repository.save(updateEntity);
				return Boolean.TRUE;
			} else {
				throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
			}
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE);
		}
	}

	/**
	 * Insert password history.
	 *
	 * @param newPassword the new password
	 * @param userId      the user id
	 */
	private void insertPasswordHistory(String newPassword, long userId) {
		EDPMsUserPassHistEntity edpMsUserPassHistEntity = new EDPMsUserPassHistEntity();
		edpMsUserPassHistEntity.setBrowser(EDPUtility.getRequestBrowser());
		edpMsUserPassHistEntity.setIpAddress(EDPUtility.getRequestUserIPAddress());
		edpMsUserPassHistEntity.setUserId(new EDPMsUserEntity(userId));
		edpMsUserPassHistEntity.setPassword(newPassword);
		edpMsUserPassHistEntity.setCreatedBy(userId);
		edpMsUserPassHistEntity.setCreatedByPost(1);
		edpMsUserPassHistEntity.setCreatedDate(new Date());
		edpMsUserPassHistEntity.setUpdatedBy(userId);
		edpMsUserPassHistEntity.setUpdatedByPost(userId);
		edpMsUserPassHistEntity.setUpdatedDate(new Date());
		edpMsUserPassHistRepository.save(edpMsUserPassHistEntity);
	}

	/**
	 * Gets the edp employee post by emp no.
	 *
	 * @param empNo    the emp no
	 * @param officeId the office id
	 * @return the edp employee post by emp no
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPEmployeePostSearchView> getEdpEmployeePostByEmpNo(Long empNo, Long officeId) throws CustomException {
		List<Object[]> result = null;
		Map<String, Object> paramMap = new LinkedHashMap<>();
		paramMap.put(EDPConstant.IN_OFFICE_ID_VALUE, officeId);
		paramMap.put(EDPConstant.EMP_NO_VALUE, empNo);
		String procName = Constant.EDP_SCHEMA
				.concat(Constant.DOT.concat(EDPConstant.SP_GET_EMP_POST_BY_EMP_AND_OFFICE));
		result = repository.callStoredProcedure(procName, paramMap);
		return NativeQueryResultsMapper.map(result, EDPEmployeePostSearchView.class);
	}

	/**
	 * Gets the user rights.
	 *
	 * @param lkPouId the lk pou id
	 * @return the user rights
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<ClueDto> getUserRights(Long lkPouId) throws CustomException {
		try {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(EDPConstant.IN_LK_POU_ID, lkPouId);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_USER_MENU_ROLEPRM_WF));
		List<Object[]> responseList = edpUserRoleMappingRepository.callStoredProcedure(procName, argMap);
		List<ClueDto> response = new ArrayList<>();
		if (!CollectionUtils.isEmpty(responseList)) {
			Map<Long, List<Object[]>> moduleMap = new HashMap<>();
			responseList.forEach(obj -> {
				Long moduleId = EDPUtility.convertObjectToLong(obj[8]);
				if (obj != null && moduleMap.containsKey(moduleId)) {
					List<Object[]> value = moduleMap.get(moduleId);
					value.add(obj);
					moduleMap.replace(moduleId, value);
				} else {
					List<Object[]> objList = new ArrayList<>();
					objList.add(obj);
					moduleMap.put(moduleId, objList);
				}
			});

			moduleMap.forEach((key, value) -> {
				List<ClueDto> subModuleList = getSubModuleList(value);
				if(!CollectionUtils.isEmpty(subModuleList)) {
					ClueDto dto = new ClueDto();
					dto.setId(key);
					dto.setName(EDPUtility.convertObjectToString(value.get(0)[9]));
					dto.setListValue(subModuleList);
					response.add(dto);
				}
			});
		}
		return response;
		}catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the sub module list.
	 *
	 * @param subModuleObjList the sub module obj list
	 * @return the sub module list
	 */
	private List<ClueDto> getSubModuleList(List<Object[]> subModuleObjList) {
		List<ClueDto> response = new ArrayList<>();
		Map<Long, List<Object[]>> submoduleMap = new HashMap<>();
		subModuleObjList.forEach(obj -> {
			Long subModuleId = null != obj[6] ? EDPUtility.convertObjectToLong(obj[6]) : null;
			if (obj != null && submoduleMap.containsKey(subModuleId)) {
				List<Object[]> kayValue = submoduleMap.get(subModuleId);
				kayValue.add(obj);
				submoduleMap.replace(subModuleId, kayValue);
			} else {
				List<Object[]> objList = new ArrayList<>();
				objList.add(obj);
				submoduleMap.put(subModuleId, objList);
			}
		});

		submoduleMap.forEach((key, value) -> {
			List<ClueDto> menuList = getMenuList(value);
			if(!CollectionUtils.isEmpty(menuList)) {
				ClueDto dto = new ClueDto();
				dto.setId(null != key ? EDPUtility.convertObjectToLong(key) : null);
				dto.setName(null != value && !CollectionUtils.isEmpty(value) && null != value.get(0)[6]
						? EDPUtility.convertObjectToString(value.get(0)[7])
								: null);
				dto.setListValue(menuList);
				response.add(dto);
			}
		});
		return response;
	}

	/**
	 * Gets the menu list.
	 *
	 * @param menuObjList the menu obj list
	 * @return the menu list
	 */
	private List<ClueDto> getMenuList(List<Object[]> menuObjList) {
		List<ClueDto> response = new ArrayList<>();
		Map<Long,List<Object[]>> menuModuleMap = new HashMap<>();
		menuObjList.forEach(obj -> {
			if(null != obj[2] || null != obj[4]) {
			Long menuId = EDPUtility.convertObjectToLong(obj[0]);
			if(obj != null && menuModuleMap.containsKey(menuId)) {
				List<Object[]> kayValue = menuModuleMap.get(menuId);
				kayValue.add(obj);
				menuModuleMap.replace(menuId,kayValue);
			} else {
				List<Object[]> objList = new ArrayList<>();
				objList.add(obj);
				menuModuleMap.put(menuId, objList);
			}
			}
		});
		
		menuModuleMap.forEach((key,value)->{
			ClueDto dto = new ClueDto();
			dto.setId(EDPUtility.convertObjectToLong(value.get(0)[0]));
			dto.setName(EDPUtility.convertObjectToString(value.get(0)[1]));
			Optional<String> rolePrmOp  = value.stream().filter(obj->null != obj[3]).map(obj->EDPUtility.convertObjectToString(obj[3])).findFirst();
			dto.setMenuRolePrm(rolePrmOp.isPresent()?rolePrmOp.get():EDPConstant.EMPTY_STRING);
			Set<String> wfRoleSet = value.stream().map(obj->EDPUtility.convertObjectToString(obj[5])).sorted().collect(Collectors.toSet());
			List<String> wfRoleList = wfRoleSet.stream().collect(Collectors.toList());
			wfRoleList.sort(String.CASE_INSENSITIVE_ORDER);
			dto.setMenuWfRole(wfRoleList.stream().collect(Collectors.joining(",")));
			response.add(dto);
		});
		return response;
	}

	/**
	 * Gets the user rights.
	 *
	 * @param id the id
	 * @param isRequestForApproved the is request for approved
	 * @return the user rights
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPUserRightsDto> getSavedUserRights(Long id, Boolean isRequestForApproved) throws CustomException {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(EDPConstant.ARGS_POST_OFC_USERID, id);

		return NativeQueryResultsMapper.map(repository
				.executeSQLQuery(EDPNativeSQLUtil.getSavedUserRightsBypostOfficeUserId(isRequestForApproved), paramMap),
				EDPUserRightsDto.class);

	}

	/**
	 * Find by user code.
	 *
	 * @param userCode the user code
	 * @return the optional
	 */
	@Override
	public EDPMsUserEntity findByUserCode(Long userCode) {
		return repository.findByUserCodeAndActiveStatus(userCode, OAuthConstant.ACTIVE_STATUS);
	}

	/**
	 * Gets the user photo by user id.
	 *
	 * @param userCode the user code
	 * @return the user photo by user id
	 * @throws CustomException the custom exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Override
	public ClueDto getUserPhotoByUserId(Long userCode) throws CustomException, IOException {
		List<Object[]> employeeData = edpEmployeRepository.getEmployeePhoto(userCode);
		if (!CollectionUtils.isEmpty(employeeData) && null != employeeData.get(0)[0] && null != employeeData.get(0)[1]) {
				Id id = new Id(EDPUtility.convertObjectToString(employeeData.get(0)[0]));
				final Document document = FilenetUtility.retrieveDocument(id);
				String base64String = EDPUtility
						.convertFilenetDocumentIntoBase64String(document.accessContentStream(0));
				ClueDto dto = new ClueDto();
				dto.setImage(base64String);
				dto.setName(EDPUtility.convertObjectToString(employeeData.get(0)[1]));
				return dto;
		}
		throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
	}

	/**
	 * Gets the work flows for menu.
	 *
	 * @param id the id
	 * @param menuId the menu id
	 * @param isRequestForApproved the is request for approved
	 * @return the work flows for menu
	 * @throws CustomException the custom exception
	 */
	@Override
	public Map<String, Object> getWorkFlowsForMenu(Long id, Long menuId, Boolean isRequestForApproved)
			throws CustomException {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(EDPConstant.ARGS_POST_OFC_USERID, id);
		paramMap.put(EDPConstant.ARGS_MENU_ID, menuId);

		List<EDPWfRolesMenuDto> edpWfRights = NativeQueryResultsMapper.map(
				repository.executeSQLQuery(
						EDPNativeSQLUtil.getUserWfRolesByPostOffUserIdForMenu(true), paramMap),
				EDPWfRolesMenuDto.class);
		paramMap.clear();
		paramMap.put(EDPConstant.EDP_WF_RIGHTS, edpWfRights);
		return paramMap;
	}

	/**
	 * Gets the minister wf user.
	 *
	 * @param dto the dto
	 * @return the minister wf user
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<UserDto> getMinisterWfUser(MinisterUserReqDto dto) throws CustomException {
		List<UserDto> lstMinisterUser = repository.findMisterUserByNextMinisterRole(dto.getOfficeId(), dto.getMenuId(),
				Constant.WF_ROLE_ID_MINISTER, Constant.ACTIVE_STATUS);
		Long ministerId = repository.getPOUIdBasedOnMinister(dto.getMinisterId(),Constant.ACTIVE_STATUS);
		for (UserDto wfUserDto : lstMinisterUser) {
			if (wfUserDto.getPouId() == ministerId) { // pouId as minister POU_ID
				List<UserDto> returnUser = new ArrayList<>();
				returnUser.add(wfUserDto);
				return returnUser;
			}
		}
		throw new CustomException(ErrorResponse.ERROR_MINISTER_IN_CHARGE_NOT_FOUND);
	}
	
	/**
	 * Check has existing rights mapping request.
	 *
	 * @param postOfficeUserId the post office user id
	 * @throws CustomException the custom exception
	 */
	@Override
	public void checkHasExistingRightsMappingRequest(Long postOfficeUserId) throws CustomException {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(EDPConstant.IN_LK_POU_ID,postOfficeUserId);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_CHECK_RGMAP_REQUEST_EXISTS));
		List<Object[]> requestdList = edpUserRoleMappingRepository.callStoredProcedure(procName, argMap);
		if(!requestdList.isEmpty()) {
			String loggedInUser = OAuthUtility.getCurrentUserCode();
			String mappingForUser = EDPUtility.convertObjectToString(requestdList.get(0)[0]);
			String mappingByUser = EDPUtility.convertObjectToString(requestdList.get(0)[8]);
			boolean isReqFromSameUser = loggedInUser.equals(mappingByUser);
			getErrorMessage(requestdList, mappingForUser, isReqFromSameUser);
		}	
	}

	/**
	 * Gets the error message.
	 *
	 * @param mappingList the mapping list
	 * @param forUserCode the for user code
	 * @param isReqFromSameUser the is req from same user
	 * @return the error message
	 * @throws CustomException 
	 */
	public void getErrorMessage(List<Object[]> requestdList, String forUserCode, boolean isReqFromSameUser) throws CustomException {
			if(isReqFromSameUser) {
				String errorMessage = MessageFormat.format(MsgConstant.EDP_REQUEST_INITIATE_SAME, String.valueOf(forUserCode),
						EDPUtility.convertObjectToString(requestdList.get(0)[8]), requestdList.get(0)[9],requestdList.get(0)[2],
						requestdList.get(0)[3], requestdList.get(0)[4], requestdList.get(0)[5], EDPUtility.convertObjectToString(requestdList.get(0)[6]),requestdList.get(0)[10]);			
				throw new CustomException(10001, errorMessage);

			} else {
				String errorMessage = MessageFormat.format(MsgConstant.EDP_REQUEST_INITIATE_NOT_SAME, String.valueOf(forUserCode),
						EDPUtility.convertObjectToString(requestdList.get(0)[8]), requestdList.get(0)[9],requestdList.get(0)[2],
						requestdList.get(0)[3], requestdList.get(0)[4], requestdList.get(0)[5],EDPUtility.convertObjectToString(requestdList.get(0)[6]),requestdList.get(0)[10]);							
				throw new CustomException(10002, errorMessage);
			}
	}
	
}
