/*
 * 
 */
package gov.ifms.edp.service;

import java.util.ArrayList;
import java.util.Arrays;
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
import java.util.stream.Stream;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.converter.EDPtusrRgMapConverter;
import gov.ifms.edp.converter.EDPtusrRgMapDtlConverter;
import gov.ifms.edp.converter.EDPtusrRgMapDtlItrConverter;
import gov.ifms.edp.converter.EDPtusrRgMapWfDtlConverter;
import gov.ifms.edp.converter.EDPtusrRgMapWfDtlItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPEmpByOffIdDto;
import gov.ifms.edp.dto.EDPEmployeePostSearchView;
import gov.ifms.edp.dto.EDPGetPostByMenuOffIdViewDto;
import gov.ifms.edp.dto.EDPGetWfRoleByMenuIdViewDto;
import gov.ifms.edp.dto.EDPLkModuleOfficeDto;
import gov.ifms.edp.dto.EDPMenuUserRightsAndRolesViewDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPRightsMappingDataDto;
import gov.ifms.edp.dto.EDPRightsMappingDto;
import gov.ifms.edp.dto.EDPUserMenuRightsAddedDto;
import gov.ifms.edp.dto.EdpURMHeaderView;
import gov.ifms.edp.entity.EDPLkModuleOfficeEntity;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLkUserMenuEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;
import gov.ifms.edp.entity.EDPTrnUserMnuRolePrmEntity;
import gov.ifms.edp.entity.EDPTrnUsrMnuWfRole;
import gov.ifms.edp.entity.EDPUserRoleMappingEntity;
import gov.ifms.edp.entity.EDPtusrRgMapDtlEntity;
import gov.ifms.edp.entity.EDPtusrRgMapDtlItrEntity;
import gov.ifms.edp.entity.EDPtusrRgMapEntity;
import gov.ifms.edp.entity.EDPtusrRgMapWfDtlEntity;
import gov.ifms.edp.entity.EDPtusrRgMapWfDtlItrEntity;
import gov.ifms.edp.entity.EdpLkSubMenuOfficeTypeEntity;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLkModuleOfficeRepository;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLkPuoMenuRLWFRepository;
import gov.ifms.edp.repository.EDPLkUserMenuRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPMsRolePermissionsRepository;
import gov.ifms.edp.repository.EDPTrnUserMnuRolePrmRepository;
import gov.ifms.edp.repository.EDPUserRoleMappingRepository;
import gov.ifms.edp.repository.EDPtusrRgMapDtlItrRepository;
import gov.ifms.edp.repository.EDPtusrRgMapDtlRepository;
import gov.ifms.edp.repository.EDPtusrRgMapRepository;
import gov.ifms.edp.repository.EDPtusrRgMapWfDtlItrRepository;
import gov.ifms.edp.repository.EDPtusrRgMapWfDtlRepository;
import gov.ifms.edp.repository.EdpLkSubMenuOfficeRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPNativeSQLUtil;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.edp.workflow.service.EDPWorkflowRequestHandler;

/**
 * The Class EDPUserRoleMappingServiceImpl.
 */
@Service
public class EDPUserRoleMappingServiceImpl implements EDPUserRoleMappingService {
	
	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	/** The EDPUserRoleMappingAsMethodName repository. */
	@Autowired
	private EDPUserRoleMappingRepository repository;

	/** The edp trn user mnu role prm repository. */
	@Autowired
	private EDPTrnUserMnuRolePrmRepository edpTrnUserMnuRolePrmRepository;

	/** The edp lk po off user repository. */
	@Autowired
	private EDPLkPoOffUserRepository edpLkPoOffUserRepository;

	/** The edp ms district repository. */
	@Autowired
	private EDPMsDistrictRepository edpMsDistrictRepository;

	/** The edp lk sub menu office repository. */
	@Autowired
	private EdpLkSubMenuOfficeRepository edpLkSubMenuOfficeRepository;

	/** The edp tusr rg map repository. */
	@Autowired
	private EDPtusrRgMapRepository edpTusrRgMapRepository;

	/** The edptusr rg map converter. */
	@Autowired
	private EDPtusrRgMapConverter edptusrRgMapConverter;
	
	/** The edptusr rg map dtl repository. */
	@Autowired
	private EDPtusrRgMapDtlRepository edptusrRgMapDtlRepository;
	
	/** The edp ms role permissions repository. */
	@Autowired
	private EDPMsRolePermissionsRepository edpMsRolePermissionsRepository; 
	
	/** The edptusr rg map dtl converter. */
	@Autowired
	private EDPtusrRgMapDtlConverter edptusrRgMapDtlConverter; 
	
	/** The edptusr rg map wf dtl converter. */
	@Autowired
	private EDPtusrRgMapWfDtlConverter edptusrRgMapWfDtlConverter; 
	
	/** The edptusr rg map wf dtl repository. */
	@Autowired
	private EDPtusrRgMapWfDtlRepository edptusrRgMapWfDtlRepository;
	
	/** The edptusr rg map dtl itr converter. */
	@Autowired
	private EDPtusrRgMapDtlItrConverter edptusrRgMapDtlItrConverter;
	
	/** The edptusr rg map dtl itr repository. */
	@Autowired
	private EDPtusrRgMapDtlItrRepository edptusrRgMapDtlItrRepository;
	
	/** The edptusr rg map wf dtl itr converter. */
	@Autowired
	private EDPtusrRgMapWfDtlItrConverter edptusrRgMapWfDtlItrConverter;
	
	/** The edptusr rg map wf dtl itr repository. */
	@Autowired
	private EDPtusrRgMapWfDtlItrRepository edptusrRgMapWfDtlItrRepository;
	
	/** The edp lk puo menu RLWF repository. */
	@Autowired
	private EDPLkPuoMenuRLWFRepository edpLkPuoMenuRLWFRepository;
	
	/** The edp lk user menu repository. */
	@Autowired
	private EDPLkUserMenuRepository edpLkUserMenuRepository;

	/** The edp ms office repository. */
	@Autowired
	private EDPMsOfficeRepository edpMsOfficeRepository;
	
	/** The edp lk module office repository. */
	@Autowired
	private EDPLkModuleOfficeRepository edpLkModuleOfficeRepository;
	
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
	 * Retrieves an EDPUserRoleMappingEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPUserRoleMappingEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPUserRoleMappingEntity getUserRoleMapping(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Fetch all the EDPUserRoleMapping items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPUserRoleMappingDto>
	 * @throws CustomException the custom exception
	 */
	@Transactional
	@Override
	public PagebleDTO<EdpURMHeaderView> getUserRoleMappings(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = EDPUtility.populateArgumentsWfList(pageDetail, 7);
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(Constant.SP_ROLE_USER_MAPPING_LIST));
			List<Object[]> objectSp = this.repository.callStoredProcedure(procName, map);
			int totalPages = objectSp.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), totalPages, totalPages,
					NativeQueryResultsMapper.map(objectSp, EdpURMHeaderView.class));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}

	}

	/**
	 * Save user role mapping.
	 *
	 * @param dto the dto
	 * @return the EDP rights mapping dto
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPMenuUserRightsAndRolesViewDto saveUserRoleMapping(EDPRightsMappingDto dto) throws CustomException {
 		EDPRightsMappingDto response = saveRequest(dto);
		if (response.isWfSaveDrftApiCall()) {
			wfRequestHandler.saveAsDraftWf(response.getMenuId(),response.getTusrRgMapId());
		}
		if((!response.isWfInRequest() || response.isWfSubmit()) && response.getFormAction() == Status.SUBMITTED){
			submiteRequest(response);
		}
		if (!response.isWfInRequest() && response.getFormAction().equals(Status.SUBMITTED)) {
			wfRequestHandler.wfDirectSubmiteApiCall(response.getMenuId(),response.getTusrRgMapId());
		}
		return getSavedUserRights(response.getTusrRgMapId());
	}

	/**
	 * Save request.
	 *
	 * @param rightsMappingdto the dto
	 * @return the EDP rights mapping dto
	 * @throws CustomException the custom exception
	 */
	@Transactional(propagation= Propagation.REQUIRES_NEW, rollbackFor = CustomException.class)
	public EDPRightsMappingDto saveRequest(EDPRightsMappingDto rightsMappingdto) throws CustomException {
		try {
			/** IF Request All ready Have Then Throw Error Request Created  **/
			createDataListForRequest(rightsMappingdto);
			if (null == rightsMappingdto.getTusrRgMapId()) {
				EDPtusrRgMapEntity rgMapEntity = edptusrRgMapConverter.edpRightsMappingDtoToEntity(rightsMappingdto);
				rgMapEntity.setInitiatedBy(new EDPLkPoOffUserEntity(OAuthUtility.getCurrentUserLkPOUId()));
				if (rightsMappingdto.getFormAction() == Status.SUBMITTED)
					rgMapEntity.setStatusId(new EDPLuLookUpInfoEntity(Constant.LU_APPROVED_LOOKUP_INFO_ID));
				else
					rgMapEntity.setStatusId(new EDPLuLookUpInfoEntity(Constant.SAVE_AS_DRAFT_STATUS_ID));
				rgMapEntity.setTrnNo(generateTrnNo());
				rgMapEntity = edpTusrRgMapRepository.save(rgMapEntity);
				rightsMappingdto.setTrnNo(rgMapEntity.getTrnNo());
				rightsMappingdto.setTusrRgMapId(rgMapEntity.getTusrRgMapId());
			} else if (null != rightsMappingdto.getTusrRgMapId()) {
				updateStatusOfTrgMapRequest(rightsMappingdto.getTusrRgMapId(), rightsMappingdto);
			}
			List<EDPtusrRgMapDtlEntity> dtlSaveEntity = edptusrRgMapDtlRepository.findByTusrRgMapIdTusrRgMapId(rightsMappingdto.getTusrRgMapId());
			List<EDPtusrRgMapWfDtlEntity> wfDtlSaveEntity =  edptusrRgMapWfDtlRepository.findByTusrRgMapDtlIdTusrRgMapIdTusrRgMapId(rightsMappingdto.getTusrRgMapId());
			List<EDPMsRolePermissionsEntity> rolePrmList = edpMsRolePermissionsRepository.findByActiveStatus(Constant.ACTIVE_STATUS);
			if(!CollectionUtils.isEmpty(rightsMappingdto.getDataList())) {
				if(CollectionUtils.isEmpty(dtlSaveEntity)){		    	
			    	saveRequestDataAsNEw(rightsMappingdto,rolePrmList);
				} else if(dtlSaveEntity.size() > rightsMappingdto.getDataList().size()) {
					updateListAndDeActiveRemaingRecords(rightsMappingdto,rolePrmList,dtlSaveEntity,wfDtlSaveEntity);
				} else if(dtlSaveEntity.size() < rightsMappingdto.getDataList().size()) {
					updateListAndAddNewRecord(rightsMappingdto,rolePrmList,dtlSaveEntity,wfDtlSaveEntity);
				} else {
					 updateList(rightsMappingdto,rolePrmList,dtlSaveEntity,wfDtlSaveEntity);
				}
			} else {
				deActiveTransctionDetailsbyRgMapId(rightsMappingdto.getTusrRgMapId());
			}
			return rightsMappingdto;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	/**
	 * get the EDPEmpByOffIdDto with the given id.
	 *
	 * @param officeId the office id
	 * @return the emp by office id
	 * @throws CustomException          the custom exception
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public List<EDPEmpByOffIdDto> getEmpByOfficeId(long officeId) throws CustomException {
		List<Long> lkPoOffUserEntity = edpLkPoOffUserRepository.getAllUserCodeByOfficeId(officeId, Constant.ACTIVE_STATUS);
		Set<Long> userCodeList = lkPoOffUserEntity.stream().collect(Collectors.toSet());

		List<EDPEmpByOffIdDto> clueDtoSet = new ArrayList<>();
		if(!userCodeList.isEmpty()) {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put(EDPConstant.USER_ID, userCodeList);
			clueDtoSet = NativeQueryResultsMapper.map(
					repository.executeSQLQuery(EDPNativeSQLUtil.GET_EMPS_FOR_OFFICE, paramMap), EDPEmpByOffIdDto.class);

			Collections.sort(clueDtoSet);
			
		}

		return clueDtoSet;

	}

	/**
	 * update RgMap with given poUserOffId and userId.
	 *
	 * @param oldUserId      the old user id
	 * @param oldPoOffUserId the old po off user id
	 * @param newUserId      the new user id
	 * @param newPoOffUserId the new po off user id
	 * @throws CustomException          the custom exception
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void updateRgMapByEmpIdAndPoOffId(long oldUserId, long oldPoOffUserId, long newUserId, long newPoOffUserId)
			throws CustomException {
		List<Integer> idList = repository.getRgMapByEmpIdAndPoOffId(oldUserId, oldPoOffUserId, Constant.ACTIVE_STATUS);
		if (idList.isEmpty()) {
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		}
		this.repository.updateRgMapByEmpIdAndPoOffId(idList, newUserId, newPoOffUserId,
				OAuthUtility.getCurrentUserUserId(), new Date());
	}

	/**
	 * Gets the edp given removal rights.
	 *
	 * @param menuId   the menu id
	 * @param officeId the office id
	 * @param wfRoleIds the wf role ids
	 * @return the edp given removal rights
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPGetPostByMenuOffIdViewDto> getPostByMenuOffId(Long menuId, Long officeId, String wfRoleIds) throws CustomException{
		
		Map<String, Object> permArgMap = new LinkedHashMap<>();
		permArgMap.put(Constant.IN_OFFICE_ID, officeId);
		permArgMap.put(Constant.MENU_ID, menuId);
		
		Map<String, Object> wfArgMap = new LinkedHashMap<>();
		wfArgMap.put(Constant.IN_OFFICE_ID, officeId);
		wfArgMap.put(Constant.MENU_ID, menuId);

		List<EDPGetPostByMenuOffIdViewDto> viewList = new ArrayList<>();

			if (!wfRoleIds.equalsIgnoreCase(Constant.DEFAULT_LOCATION_CODE)) {
				wfArgMap.put(Constant.IN_ROLE_IDS, wfRoleIds);
				String wfProcName = Constant.EDP_SCHEMA
						.concat(Constant.DOT.concat(EDPConstant.SP_GET_WFROLES_FOR_OFFICE_AND_MENU));
				List<Object[]> objectWfSp = repository.callStoredProcedure(wfProcName, wfArgMap);
				if (!objectWfSp.isEmpty()) {
					Set<String> empIds = objectWfSp.stream().map(obj -> EDPUtility.convertObjectToString(obj[7]))
							.collect(Collectors.toSet());
					permArgMap.put(Constant.IN_EMP_ID, String.join(",", empIds));

					String permProcName = Constant.EDP_SCHEMA
							.concat(Constant.DOT.concat(EDPConstant.SP_GET_PERM_FOR_OFFICE_AND_MENU));
					List<Object[]> objectPermSp = repository.callStoredProcedure(permProcName, permArgMap);

					HashMap<Long, EDPGetPostByMenuOffIdViewDto> viewsMap = new HashMap<>();
					objectWfSp.forEach(wf1 -> {
						Long empId = EDPUtility.convertObjectToLong(wf1[7]);
						String postName = EDPUtility.convertObjectToString(wf1[2]);

						EDPGetPostByMenuOffIdViewDto viewDto = null;
						if (viewsMap.containsKey(empId)) {
							viewDto = viewsMap.get(empId);
						} else {
							viewDto = new EDPGetPostByMenuOffIdViewDto();
							//
							setViewDtoDetails(viewDto, wf1);
						}

						mergeWorkflowRoles(viewDto, empId, objectWfSp, postName);
						mergePermissionsWithWorkflow(viewDto, empId, objectPermSp, postName);
						viewsMap.putIfAbsent(empId, viewDto);
					});

					viewList.addAll(viewsMap.values());

				}
			} else {				
				setViewDtoPermissions(permArgMap, wfArgMap, viewList, Boolean.FALSE);
			}
		return viewList;
	}
	
	/**
	 * Sets the view dto permissions.
	 *
	 * @param permArgMap the perm arg map
	 * @param wfArgMap the wf arg map
	 * @param viewList the view list
	 * @param isOnlyPerm the is only perm
	 */
	private void setViewDtoPermissions(Map<String, Object> permArgMap, Map<String, Object> wfArgMap, List<EDPGetPostByMenuOffIdViewDto> viewList, boolean isOnlyPerm) {
		permArgMap.put(Constant.IN_EMP_ID, Constant.BLANK);

		String permProcName = Constant.EDP_SCHEMA
				.concat(Constant.DOT.concat(EDPConstant.SP_GET_PERM_FOR_OFFICE_AND_MENU));
		List<Object[]> objectPerm = repository.callStoredProcedure(permProcName, permArgMap);

		if(isOnlyPerm) {
			if (!objectPerm.isEmpty()) {
				objectPerm.forEach(perm -> populatePermissions(perm, viewList, isOnlyPerm, null) );
			}			
		}else {
			wfArgMap.put(Constant.IN_ROLE_IDS, Constant.BLANK);
			String wfProcName = Constant.EDP_SCHEMA
					.concat(Constant.DOT.concat(EDPConstant.SP_GET_WFROLES_FOR_OFFICE_AND_MENU));
			List<Object[]> objectWfSp = repository.callStoredProcedure(wfProcName, wfArgMap);

			if (!objectPerm.isEmpty()) {
				objectPerm.forEach(perm -> populatePermissions(perm, viewList, isOnlyPerm, objectWfSp));
			}
		}
		
	}
	
	/**
	 * Populate permissions.
	 *
	 * @param perm the perm
	 * @param viewList the view list
	 * @param isOnlyPerm the is only perm
	 * @param objectWfSp the object wf sp
	 */
	private void populatePermissions(Object[] perm, List<EDPGetPostByMenuOffIdViewDto> viewList, boolean isOnlyPerm, List<Object[]> objectWfSp) {

		EDPGetPostByMenuOffIdViewDto viewDto = new EDPGetPostByMenuOffIdViewDto();
		setViewDtoDetails(viewDto, perm);
		viewDto.setRolePermId(EDPUtility.convertObjectToString(perm[4]));
		viewDto.setRolePermName(EDPUtility.convertObjectToString(perm[5]));

		if(!isOnlyPerm) {
			String postName = EDPUtility.convertObjectToString(perm[2]);
			Long empId = EDPUtility.convertObjectToLong(perm[7]);
			populateWfRoles(objectWfSp, viewDto, empId, postName);			
		}
		viewList.add(viewDto);

	}
	
	/**
	 * Sets the view dto details.
	 *
	 * @param viewDto the view dto
	 * @param objSp the obj sp
	 * Method for setting common ViewDto details
	 */
	private void setViewDtoDetails(EDPGetPostByMenuOffIdViewDto viewDto, Object[] objSp) {
		Long posttype = EDPUtility.convertObjectToLong(objSp[3]);
		viewDto.setEmployeeNumber(EDPUtility.convertObjectToString(objSp[0]));
		viewDto.setEmployeeName(EDPUtility.convertObjectToString(objSp[1]));
		viewDto.setPostName(EDPUtility.convertObjectToString(objSp[2]));
		viewDto.setPostType((posttype.equals(Constant.LONG_TWO_VALUE) ? EDPConstant.PRIMARY_POST : EDPConstant.SECONDARY_POST));
		viewDto.setMenuName(EDPUtility.convertObjectToString(objSp[6]));

	}
	
	/**
	 * Merge permissions with workflow.
	 *
	 * @param viewDto the view dto
	 * @param empId the emp id
	 * @param objectPermSp the object perm sp
	 * @param postName the post name
	 * Merge permissions with workflow roles
	 * for the same user of the same post
	 */
	private void mergePermissionsWithWorkflow(EDPGetPostByMenuOffIdViewDto viewDto, Long empId, List<Object[]> objectPermSp,
			String postName) {
		if (!objectPermSp.isEmpty()) {
			for (Object[] perm : objectPermSp) {
				if (empId.equals(EDPUtility.convertObjectToLong(perm[7]))
						&& postName.equals(EDPUtility.convertObjectToString(perm[2]))) {
					viewDto.setRolePermId(EDPUtility.convertObjectToString(perm[4]));
					viewDto.setRolePermName(EDPUtility.convertObjectToString(perm[5]));
				}
			}
		}

	}
	
	/**
	 * Merge workflow roles.
	 *
	 * @param viewDto the view dto
	 * @param empId the emp id
	 * @param objectWfSp the object wf sp
	 * @param postName the post name
	 * Merge multiple workflow roles for a user
	 * into single viewDto object
	 */
	private void mergeWorkflowRoles(EDPGetPostByMenuOffIdViewDto viewDto, Long empId, List<Object[]> objectWfSp, String postName) {
		StringBuilder roleIds = new StringBuilder();
		StringBuilder roleNames = new StringBuilder();
		
		objectWfSp.forEach(wf2 -> {

			if(empId.equals(EDPUtility.convertObjectToLong(wf2[7])) && postName.equals(EDPUtility.convertObjectToString(wf2[2]))) {
				
				if(roleIds.length() > 0)
				{
					roleIds.append(",");
				}
				roleIds.append(EDPUtility.convertObjectToString(wf2[4]));
				if(roleNames.length() > 0)
				{
					roleNames.append(",");
				}
				roleNames.append(EDPUtility.convertObjectToString(wf2[5]));						

			}
		});
		viewDto.setWfRoleIds(roleIds.toString());
		viewDto.setWfRoleNames(roleNames.toString());

	}
	
	/**
	 * Populate wf roles.
	 *
	 * @param objectWfSp the object wf sp
	 * @param viewDto the view dto
	 * @param empId the emp id
	 * @param postName the post name
	 * Populate workflow roles with 
	 * permissions in the viewDto
	 */
	private void populateWfRoles(List<Object[]> objectWfSp, EDPGetPostByMenuOffIdViewDto viewDto, Long empId, String postName) {

		if(!objectWfSp.isEmpty()) {
			StringBuilder roleIds = new StringBuilder();
			StringBuilder roleNames = new StringBuilder();
			
			objectWfSp.forEach(wf ->{

				if(empId.equals(EDPUtility.convertObjectToLong(wf[7])) && postName.equals(EDPUtility.convertObjectToString(wf[2])))
				{

					if(roleIds.length() > 0)
					{
						roleIds.append(",");
					}
					roleIds.append(EDPUtility.convertObjectToString(wf[4]));
					if(roleNames.length() > 0)
					{
						roleNames.append(",");
					}
					roleNames.append(EDPUtility.convertObjectToString(wf[5]));						
				}
				viewDto.setWfRoleIds(roleIds.toString());
				viewDto.setWfRoleNames(roleNames.toString());

			});					

		}
	}

	/**
	 * Gets the workflow roles for Menu
	 * & office type .
	 *
	 * @param menuOfficeTypeId the menu office type id
	 * @return the edp given removal rights
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPGetWfRoleByMenuIdViewDto> getWfByMenuId(Long menuOfficeTypeId) throws CustomException {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(Constant.MENU_OFFICE_TYPE_ID, menuOfficeTypeId);
		return NativeQueryResultsMapper.map(repository.executeSQLQuery(EDPNativeSQLUtil.getWfByMenuId(), paramMap),
				EDPGetWfRoleByMenuIdViewDto.class);
	}

	/**
	 * Gets the district by state id.
	 *
	 * @return the district by state id
	 */
	@Override
	public List<ClueDto> getDistrictByStateId() {
		List<EDPMsDistrictEntity> allDistrictEntity = edpMsDistrictRepository.findByActiveStatusAndStateId(
				OAuthConstant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ,
				EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC));

		return allDistrictEntity.stream().map(districtEntity -> {
			ClueDto districtDto = new ClueDto();
			districtDto.setId(districtEntity.getDistrictId());
			districtDto.setName(districtEntity.getDistrictName());
			return districtDto;
		}).collect(Collectors.toList());
	}

	/**
	 * Gets the modules for office type.
	 *
	 * @param officeId the office id
	 * @return the modules for office type
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPLkModuleOfficeDto> getModulesForOfficeType(Long officeId) throws CustomException {

		EDPMsOfficeDto officeDto = setOfficeAndCategory(officeId);
		return NativeQueryResultsMapper.map(
				repository.executeSQLQueryOnly(EDPNativeSQLUtil
						.getModulesForOfficeType(officeDto.getOfficeTypeId(), officeDto.getOfficeSubType())),
				EDPLkModuleOfficeDto.class);

	}

	/**
	 * Gets the sub modules or menu.
	 *
	 * @param modOffTypeId the mod off type id
	 * @return the sub modules or menu
	 * @throws CustomException the custom exception
	 * Returns submodules if present for a module
	 * else returns menus if no submodules present
	 */
	@Override
	public ClueDto getSubModulesOrMenu(Long modOffTypeId) throws CustomException {
		List<EdpLkSubMenuOfficeTypeEntity> menuOffEntity = edpLkSubMenuOfficeRepository
				.findByModOffTypeIdLkModOffIdAndActiveStatusAndSubModuleIdNotNull(modOffTypeId, Constant.ACTIVE_STATUS);
		List<Long> subModuleIds = menuOffEntity.stream().map(entity -> entity.getSubModuleId().getSubModuleId())
				.collect(Collectors.toList());
		ClueDto subModulesOrMenus = new ClueDto();
		if (!subModuleIds.isEmpty()) {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put(EDPConstant.SUB_MODULE_ID, subModuleIds);
			List<Object[]> subModules = edpLkSubMenuOfficeRepository
					.executeNativeSQLQuery(EDPNativeSQLUtil.GET_SUBMODULE_FROM_ID, paramMap);
			List<ClueDto> subModuleList = new ArrayList<>();
			subModules.forEach(obj -> {
				ClueDto clueDto = new ClueDto();
				clueDto.setSubModuleId(EDPUtility.convertObjectToLong(obj[0]));
				clueDto.setSubModule(EDPUtility.convertObjectToString(obj[1]));
				subModuleList.add(clueDto);
			});
			subModulesOrMenus.setSubmoduleList(subModuleList);

		} else {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put(EDPConstant.MOD_OFF_TYPE_ID, modOffTypeId);
			List<Object[]> menus = edpLkSubMenuOfficeRepository.executeNativeSQLQuery(EDPNativeSQLUtil.GET_MENU_FROM_ID,
					paramMap);
			List<ClueDto> menuList = new ArrayList<>();
			menus.forEach(obj -> {
				ClueDto clueDto = new ClueDto();
				clueDto.setMenuId(EDPUtility.convertObjectToLong(obj[0]));
				clueDto.setMenu(EDPUtility.convertObjectToString(obj[1]));
				clueDto.setMenuOfficeTypeId(EDPUtility.convertObjectToLong(obj[2]));
				menuList.add(clueDto);
			});
			subModulesOrMenus.setMenuList(menuList);
		}

		return subModulesOrMenus;
	}

	/**
	 * Gets the menus for submodule.
	 *
	 * @param modOffTypeId the mod off type id
	 * @param subModuleId  the sub module id
	 * @return the menus for submodule
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<ClueDto> getMenusForSubmodule(Long modOffTypeId, Long subModuleId) throws CustomException {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(EDPConstant.SUB_MODULE_ID, subModuleId);
		paramMap.put(EDPConstant.MOD_OFF_TYPE_ID, modOffTypeId);
		List<ClueDto> menuList = new ArrayList<>();
		List<Object[]> menus = edpLkSubMenuOfficeRepository
				.executeNativeSQLQuery(EDPNativeSQLUtil.GET_MENU_FROM_ID_AND_SUBMODULE, paramMap);
		menus.forEach(obj -> {
			ClueDto clueDto = new ClueDto();
			clueDto.setMenuId(EDPUtility.convertObjectToLong(obj[0]));
			clueDto.setMenu(EDPUtility.convertObjectToString(obj[1]));
			clueDto.setMenuOfficeTypeId(EDPUtility.convertObjectToLong(obj[2]));
			menuList.add(clueDto);
		});
		return menuList;
	}

	/**
	 * Gets the approve user rights.
	 *
	 * @param lkpostOffUserId the lkpost off user id
	 * @return the approve user rights
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<ClueDto> getApproveUserRights(Long lkpostOffUserId) throws CustomException {
		try {
			Map<String, Object> argMap = new HashMap<>();
			argMap.put(EDPConstant.IN_LK_POU_ID, lkpostOffUserId);
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_USER_MENU_ROLEPRM_WF));
			List<Object[]> responseList = repository.callStoredProcedure(procName, argMap);
			List<ClueDto> response = new ArrayList<>();
			if (!CollectionUtils.isEmpty(responseList)) {
				Map<Long, List<Object[]>> menuMap = new HashMap<>();
				responseList.forEach(obj -> {
					Long menuId = EDPUtility.convertObjectToLong(obj[0]);
					if (obj != null && menuMap.containsKey(menuId)) {
						List<Object[]> value = menuMap.get(menuId);
						value.add(obj);
						menuMap.replace(menuId, value);
					} else {
						List<Object[]> objList = new ArrayList<>();
						objList.add(obj);
						menuMap.put(menuId, objList);
					}
				});
				return menuMap.entrySet().stream().map(entry -> {
					ClueDto menuDto = new ClueDto();
					ClueDto rolePrmList = new ClueDto();
					Set<ClueDto> wfroleList = new HashSet<>();
					menuDto.setMenuId(entry.getKey());
					menuDto.setMenu(EDPUtility.convertObjectToString(entry.getValue().get(0)[1]));
					if(null != entry.getValue().get(0)[2]) {
						rolePrmList.setId(EDPUtility.convertObjectToLong(entry.getValue().get(0)[2]));
						rolePrmList.setRolePrm(
							Stream.of(EDPUtility.convertObjectToString(entry.getValue().get(0)[3]).split(","))
									.collect(Collectors.toSet()));
					}
					menuDto.setRolePrmList(rolePrmList);
					entry.getValue().forEach(object -> {
						if(null != object[4]) {
						   ClueDto dto = new ClueDto();
						   dto.setId(EDPUtility.convertObjectToLong(object[4]));
						   dto.setName(EDPUtility.convertObjectToString(object[5]));
						   wfroleList.add(dto);
						}
					});
					menuDto.setWfRoleList(wfroleList);
					return menuDto;
				}).collect(Collectors.toList());
			}
			return response;
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Update status of trg map request.
	 *
	 * @param tusrRgMapId the tusr rg map id
	 * @param formAction  the form action
	 * @param rightsMappingdto 
	 */
	private void updateStatusOfTrgMapRequest(Long tusrRgMapId, EDPRightsMappingDto rightsMappingdto) {
		 Long statusId = (!rightsMappingdto.isWfInRequest() || rightsMappingdto.isWfSubmit())
					&& rightsMappingdto.getFormAction().equals(Status.SUBMITTED)
					?Constant.LU_APPROVED_LOOKUP_INFO_ID:Constant.SAVE_AS_DRAFT_STATUS_ID;
		 edpTusrRgMapRepository.updateStatusAndRemarksOfRgMap(tusrRgMapId, 
			statusId,OAuthUtility.getCurrentUserUserId(), OAuthUtility.getCurrentUserLkPOUId(), new Date(),
			rightsMappingdto.isHasObjection()?EDPConstant.LOOKUP_INFO_YES:EDPConstant.LOOKUP_INFO_NO, 
			rightsMappingdto.isHasObjection()?rightsMappingdto.getObjectionRemarks():StringUtils.EMPTY);
	}
	
	/**
	 * Generate trn no.
	 *
	 * @return the string
	 */
	private String generateTrnNo() {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(Constant.TRN_SCREEN, EDPConstant.RIGHTS_MAPPING_TRN_SCREEN_NAME);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_EDP_TRN_NO_GEN));
		List<Object[]> responseList = edpTusrRgMapRepository.callStoredProcedure(procName, argMap);
		return EDPUtility.convertObjectToString(responseList.get(0)[0]);
	}
	
	/**
	 * Save request as new request.
	 *
	 * @param dto the dto
	 * @param rolePrmList the role prm list
	 */
	private void saveRequestDataAsNEw(EDPRightsMappingDto dto, List<EDPMsRolePermissionsEntity> rolePrmList) {
		 dto.setWfSaveDrftApiCall(true);
		 List<EDPRightsMappingDataDto> dataList  = dto.getDataList();
		 List<EDPtusrRgMapDtlEntity> saveEntity = new ArrayList<>();
		 if(!CollectionUtils.isEmpty(dataList)) {
			 for(EDPRightsMappingDataDto dataDto : dataList) {
				 EDPtusrRgMapDtlEntity entity  = edptusrRgMapDtlConverter.rightsMappingDataDtotoEntity(dataDto,dto.getTusrRgMapId());
				 /** Old Rights List is Empty That Means User Not Have Any old  Rights **/
				 setRolePrmINRgMapDtl(rolePrmList, dataDto, entity);
				 entity =  edptusrRgMapDtlRepository.save(entity);
				 saveEntity.add(entity);
				 if(!CollectionUtils.isEmpty(dataDto.getWfRoleList())) {
					/** Is Condition True When Wf Role Given or Remove in this menu**/
					List<EDPtusrRgMapWfDtlEntity> wfDtlSave = saveWfDtlAsNewRequest(dataDto.getWfRoleList(),dataDto.getOldWfRoleList(), entity);
					saveTusrRgMapWfDtlItrEntity(wfDtlSave);
				 }
			 }
			 saveTusrRgMapDtlIntoItr(saveEntity);
		 }
	}

	/**
	 * Sets the role prm IN rg map dtl.
	 *
	 * @param rolePrmList the role prm list
	 * @param dataDto the data dto
	 * @param entity the entity
	 */
	private void setRolePrmINRgMapDtl(List<EDPMsRolePermissionsEntity> rolePrmList, EDPRightsMappingDataDto dataDto,
			EDPtusrRgMapDtlEntity entity) {
		if(!CollectionUtils.isEmpty(dataDto.getOldRightsList())){
			 EDPMsRolePermissionsEntity oldRolePrm = createOrGetRolePrm(dataDto.getOldRightsList(),rolePrmList);
			 entity.setOldRolePrmId(oldRolePrm); 
		 }
		 /** Rights List is Empty That Means No Rights Add Or Remove **/
		 if(!CollectionUtils.isEmpty(dataDto.getRightsList())){
			 EDPMsRolePermissionsEntity newRolePrm = createOrGetRolePrm(dataDto.getRightsList(),rolePrmList);
			 entity.setRolePrmId(newRolePrm); 
		 }
	}
	

	/**
	 * Update list and de active remaing records.
	 *
	 * @param rightsMappingdto the rights mappingdto
	 * @param rolePrmList the role prm list
	 * @param dtlSaveEntity the dtl save entity
	 * @param wfDtlSaveEntityList the wf dtl save entity list
	 */
	private void updateListAndDeActiveRemaingRecords(EDPRightsMappingDto rightsMappingdto,
			List<EDPMsRolePermissionsEntity> rolePrmList, List<EDPtusrRgMapDtlEntity> dtlSaveEntity,
			List<EDPtusrRgMapWfDtlEntity> wfDtlSaveEntityList) {
		List<EDPtusrRgMapWfDtlEntity> newWfDtlEntityList = new ArrayList<>();
		List<EDPRightsMappingDataDto> dataList = rightsMappingdto.getDataList();
		for (int i = 0; i < dtlSaveEntity.size(); i++) {
			EDPtusrRgMapDtlEntity savedEntity = dtlSaveEntity.get(i);
			if (dataList.size() > i) {
				savedEntity = edptusrRgMapDtlConverter.tusrRgMapDtlSaveEntitytoEntity(dataList.get(i),savedEntity);
				setRolePrmINRgMapDtl(rolePrmList, dataList.get(i), savedEntity);
				if(!CollectionUtils.isEmpty(dataList.get(i).getWfRoleList())) {
					List<EDPtusrRgMapWfDtlEntity> wfEntityList =  edptusrRgMapWfDtlConverter.rightsMappingDataDtotoEntity(dataList.get(i).getWfRoleList(),dataList.get(i).getOldWfRoleList(),savedEntity);
					newWfDtlEntityList.addAll(wfEntityList);
				}
			} else {
				savedEntity.setActiveStatus(Constant.INACTIVE_STATUS);
			}
		}
		edptusrRgMapDtlRepository.saveAll(dtlSaveEntity);
		saveTusrRgMapDtlIntoItr(dtlSaveEntity);
		updateWfDtlFromOldEntity(newWfDtlEntityList,wfDtlSaveEntityList);
	}
	

	/**
	 * Update list and add new record.
	 *
	 * @param rightsMappingdto the rights mappingdto
	 * @param rolePrmList the role prm list
	 * @param dtlSaveEntity the dtl save entity
	 * @param wfDtlSaveEntityList the wf dtl save entity list
	 */
	private void updateListAndAddNewRecord(EDPRightsMappingDto rightsMappingdto,
			List<EDPMsRolePermissionsEntity> rolePrmList, List<EDPtusrRgMapDtlEntity> dtlSaveEntity,
			List<EDPtusrRgMapWfDtlEntity> wfDtlSaveEntityList) {
		List<EDPtusrRgMapWfDtlEntity> newWfDtlEntityList = new ArrayList<>();
		List<EDPRightsMappingDataDto> dataList = rightsMappingdto.getDataList();
		for (int i = 0; i < dataList.size(); i++) {
			if (dtlSaveEntity.size() > i) {
				EDPtusrRgMapDtlEntity savedEntity = dtlSaveEntity.get(i);
				savedEntity = edptusrRgMapDtlConverter.tusrRgMapDtlSaveEntitytoEntity(dataList.get(i),savedEntity);
				setRolePrmINRgMapDtl(rolePrmList, dataList.get(i), savedEntity);
				if(!CollectionUtils.isEmpty(dataList.get(i).getWfRoleList())) {
					List<EDPtusrRgMapWfDtlEntity> wfEntityList = edptusrRgMapWfDtlConverter.rightsMappingDataDtotoEntity(dataList.get(i).getWfRoleList(),dataList.get(i).getOldWfRoleList(),savedEntity);
					newWfDtlEntityList.addAll(wfEntityList);
				}
			} else {
				 EDPtusrRgMapDtlEntity entity  = edptusrRgMapDtlConverter.rightsMappingDataDtotoEntity(dataList.get(i),rightsMappingdto.getTusrRgMapId());
				 /** Old Rights List is Empty That Means User Not Have Any old  Rights **/
				 setRolePrmINRgMapDtl(rolePrmList, dataList.get(i), entity);
				 entity =  edptusrRgMapDtlRepository.save(entity);
				 EDPtusrRgMapDtlItrEntity itrEntity = edptusrRgMapDtlItrConverter.tusrRgMapDtlEntitytoItrEntity(entity);
				 edptusrRgMapDtlItrRepository.save(itrEntity);
				 if(!CollectionUtils.isEmpty(dataList.get(i).getWfRoleList())) {
					/** Is Condition True When Wf Role Given or Remove in this menu**/
					List<EDPtusrRgMapWfDtlEntity> wfDtlSave = edptusrRgMapWfDtlConverter.rightsMappingDataDtotoEntity(dataList.get(i).getWfRoleList(),dataList.get(i).getOldWfRoleList(), entity);
					newWfDtlEntityList.addAll(wfDtlSave);
				 }
			}
		}
		edptusrRgMapDtlRepository.saveAll(dtlSaveEntity);
		saveTusrRgMapDtlIntoItr(dtlSaveEntity);
		updateWfDtlFromOldEntity(newWfDtlEntityList,wfDtlSaveEntityList);
	}
	

	/**
	 * Update list.
	 *
	 * @param rightsMappingdto the rights mappingdto
	 * @param rolePrmList the role prm list
	 * @param dtlSaveEntity the dtl save entity
	 * @param wfDtlSaveEntity the wf dtl save entity
	 */
	private void updateList(EDPRightsMappingDto rightsMappingdto, List<EDPMsRolePermissionsEntity> rolePrmList,
			List<EDPtusrRgMapDtlEntity> dtlSaveEntity, List<EDPtusrRgMapWfDtlEntity> wfDtlSaveEntity) {
		List<EDPtusrRgMapWfDtlEntity> newWfDtlEntityList = new ArrayList<>();
		List<EDPRightsMappingDataDto> dataList = rightsMappingdto.getDataList();
		for (int i = 0; i < dtlSaveEntity.size(); i++) {
			EDPtusrRgMapDtlEntity savedEntity = dtlSaveEntity.get(i);
			savedEntity = edptusrRgMapDtlConverter.tusrRgMapDtlSaveEntitytoEntity(dataList.get(i),savedEntity);
			setRolePrmINRgMapDtl(rolePrmList, dataList.get(i), savedEntity);
			if(!CollectionUtils.isEmpty(dataList.get(i).getWfRoleList())) {
				List<EDPtusrRgMapWfDtlEntity> wfEntityList =  edptusrRgMapWfDtlConverter.rightsMappingDataDtotoEntity(dataList.get(i).getWfRoleList(),dataList.get(i).getOldWfRoleList(),savedEntity);
				newWfDtlEntityList.addAll(wfEntityList);
			}
		}
		edptusrRgMapDtlRepository.saveAll(dtlSaveEntity);
		saveTusrRgMapDtlIntoItr(dtlSaveEntity);
		updateWfDtlFromOldEntity(newWfDtlEntityList,wfDtlSaveEntity);
	}

	
	/**
	 * Update wf dtl from old entity.
	 *
	 * @param newwfDtlEntityList the newwf dtl entity list
	 * @param wfDtlSaveEntityList the wf dtl save entity list
	 */
	private void updateWfDtlFromOldEntity(List<EDPtusrRgMapWfDtlEntity> newwfDtlEntityList,
			List<EDPtusrRgMapWfDtlEntity> wfDtlSaveEntityList) {
		List<EDPtusrRgMapWfDtlEntity> forSavEntity = new ArrayList<>();
		if(newwfDtlEntityList.size() > wfDtlSaveEntityList.size() || newwfDtlEntityList.size() == wfDtlSaveEntityList.size()) {
			for (int i = 0; i < newwfDtlEntityList.size(); i++) {
				if(wfDtlSaveEntityList.size() > i) {					
					EDPtusrRgMapWfDtlEntity savedEntity = edptusrRgMapWfDtlConverter
							.convertSavedEntityToNewEntity(wfDtlSaveEntityList.get(i),newwfDtlEntityList.get(i));
					forSavEntity.add(savedEntity);
				} else {
					forSavEntity.add(newwfDtlEntityList.get(i));
				}
			}
		} else {
			for (int i = 0; i < wfDtlSaveEntityList.size(); i++) {
				if (newwfDtlEntityList.size() > i) {
					   EDPtusrRgMapWfDtlEntity savedEntity = edptusrRgMapWfDtlConverter
								.convertSavedEntityToNewEntity(wfDtlSaveEntityList.get(i),newwfDtlEntityList.get(i));
					   forSavEntity.add(savedEntity);
				} else {
					 EDPtusrRgMapWfDtlEntity savedEntity = wfDtlSaveEntityList.get(i);
					 savedEntity.setActiveStatus(EDPConstant.INACTIVE_STATUS);
					forSavEntity.add(savedEntity);
				}
			}
		}
		List<EDPtusrRgMapWfDtlEntity> wfEntityList =  edptusrRgMapWfDtlRepository.saveAll(forSavEntity);
		saveTusrRgMapWfDtlItrEntity(wfEntityList);
	}

	/**
	 * Save wf dtl as new request.
	 *
	 * @param wfRoleList the wf role list
	 * @param oldWfRoleList the old wf role list
	 * @param entity the entity
	 * @return the list
	 */
	private List<EDPtusrRgMapWfDtlEntity> saveWfDtlAsNewRequest(List<ClueDto> wfRoleList, List<ClueDto> oldWfRoleList,
			EDPtusrRgMapDtlEntity entity) {
		List<EDPtusrRgMapWfDtlEntity> wfEntityList =  edptusrRgMapWfDtlConverter
				.rightsMappingDataDtotoEntity(wfRoleList,oldWfRoleList,entity);
		return  edptusrRgMapWfDtlRepository.saveAll(wfEntityList);
	}
	
	/**
	 * Creates the or get role prm.
	 *
	 * @param rolePrmList the role prm list
	 * @param savedRolePrmList the saved role prm list
	 * @return the EDP ms role permissions entity
	 */
	private EDPMsRolePermissionsEntity createOrGetRolePrm(List<String> rolePrmList,List<EDPMsRolePermissionsEntity> savedRolePrmList) {
		if(!CollectionUtils.isEmpty(rolePrmList)) {
			rolePrmList.sort(String.CASE_INSENSITIVE_ORDER);
			String newRolePrm = rolePrmList.stream().filter(str->!StringUtils.isEmpty(str)).collect(Collectors.joining(Constant.COMMA));
			if(!StringUtils.isEmpty(newRolePrm)) {
			Optional<EDPMsRolePermissionsEntity> savedRole = savedRolePrmList.stream().filter(role-> role.getRoleName().equals(newRolePrm)).findFirst();
			if(savedRole.isPresent()) {
				return savedRole.get();
			} else {
				EDPMsRolePermissionsEntity entity = new EDPMsRolePermissionsEntity();
				entity.setRoleName(newRolePrm);
				entity.setRoleCode(newRolePrm);
				entity.setRoelTypeId(1);
				entity.setParentRoleId(1);
				return edpMsRolePermissionsRepository.save(entity);
			} 
		  }
		}
		return null;
	}
	
	/**
	 * Save tusr rg map dtl into itr.
	 *
	 * @param entity the entity
	 */
	private void saveTusrRgMapDtlIntoItr(List<EDPtusrRgMapDtlEntity> entity) {
		List<EDPtusrRgMapDtlItrEntity> itrEntity = edptusrRgMapDtlItrConverter.tusrRgMapDtlEntitytoItrEntity(entity);
		edptusrRgMapDtlItrRepository.saveAll(itrEntity);
	}
	

	/**
	 * Save tusr rg map wf dtl itr entity.
	 *
	 * @param wfDtlSave the wf dtl save
	 */
	private void saveTusrRgMapWfDtlItrEntity(List<EDPtusrRgMapWfDtlEntity> wfDtlSave) {
		List<EDPtusrRgMapWfDtlItrEntity> itrEntity = edptusrRgMapWfDtlItrConverter.tusrRgMapWfDtlEntityToEntity(wfDtlSave);
		edptusrRgMapWfDtlItrRepository.saveAll(itrEntity);
	}

	
	/**
	 * De active old transction listby rg map id.
	 *
	 * @param tusrRgMapDtlId the tusr rg map dtl id
	 * @throws CustomException the custom exception
	 */
	@Override
	public void deActiveOldTransctionListbyRgMapId(Long tusrRgMapDtlId) throws CustomException{
	   Long updatedBy  = OAuthUtility.getCurrentUserUserId() ;
	   Long updatedByPosy = OAuthUtility.getCurrentUserLkPOUId(); 
	   Date updatedDate = new Date();	   
	   edptusrRgMapDtlRepository.updateActiveStatusByRgMapDtlId(tusrRgMapDtlId, Constant.INACTIVE_STATUS, updatedBy, updatedByPosy, updatedDate);
	   edptusrRgMapWfDtlRepository.updateActiveStatusByRgMapDtlId(tusrRgMapDtlId, Constant.INACTIVE_STATUS, updatedBy, updatedByPosy, updatedDate);
	}
	   
	/**
	 * Gets the saved user rights.
	 *
	 * @param userRoleMappingId the user role mapping id
	 * @return the saved user rights
	 */
	@Override
	public EDPMenuUserRightsAndRolesViewDto getSavedUserRights(Long userRoleMappingId){
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(Constant.IN_USER_ROLE_MAPPING_ID, userRoleMappingId);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_EDP_RM_GET_TRN_BY_RGMAP));
		List<Object[]> objectSp = repository.callStoredProcedure(procName, paramMap);
		
		EDPMenuUserRightsAndRolesViewDto viewDto = new EDPMenuUserRightsAndRolesViewDto(); 
		EDPEmployeePostSearchView postView = new EDPEmployeePostSearchView();

		if(!objectSp.isEmpty()) {
			String posttype = EDPUtility.convertObjectToString(objectSp.get(0)[9]);

			viewDto.setTrnId(userRoleMappingId);
			viewDto.setTrnNo(EDPUtility.convertObjectToString(objectSp.get(0)[0]));
			viewDto.setEmpId(EDPUtility.convertObjectToLong(objectSp.get(0)[1]));
			viewDto.setDistrict(EDPUtility.convertObjectToLong(objectSp.get(0)[6]));
			viewDto.setDdoOffice(EDPUtility.convertObjectToString(objectSp.get(0)[28]));
			viewDto.setCardexNo(EDPUtility.convertObjectToString(objectSp.get(0)[29]));
			viewDto.setDdoNo(EDPUtility.convertObjectToString(objectSp.get(0)[30]));
			viewDto.setEmpNo(EDPUtility.convertObjectToString(objectSp.get(0)[3]));
			viewDto.setEmpName(EDPUtility.convertObjectToString(objectSp.get(0)[2]));
			viewDto.setStatus(EDPUtility.convertObjectToString(objectSp.get(0)[31]));
			viewDto.setTrnDate(EDPUtility.convertObjectToDate(objectSp.get(0)[32]));
			viewDto.setWfInRequest(null!=objectSp.get(0)[36] && EDPConstant.LOOKUP_INFO_YES.equals(EDPUtility.convertObjectToLong(objectSp.get(0)[36]))
					?Boolean.TRUE:Boolean.FALSE);
			Long officeId = EDPUtility.convertObjectToLong(objectSp.get(0)[38]);
			if(!OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId().equals(officeId)){
				viewDto.setObjectionRequired(Boolean.TRUE);
				if(null != objectSp.get(0)[33] && EDPConstant.LOOKUP_INFO_YES.equals(EDPUtility.convertObjectToLong(objectSp.get(0)[33]))) {
					viewDto.setObjectionRemarks(EDPUtility.convertObjectToString(objectSp.get(0)[34]));
					viewDto.setHasObjection(Boolean.TRUE);
				} else {
					viewDto.setHasObjection(Boolean.FALSE);					
				}
			} else {
				viewDto.setObjectionRequired(Boolean.FALSE);
				viewDto.setHasObjection(Boolean.FALSE);
			}
			postView.setEmpName(EDPUtility.convertObjectToString(objectSp.get(0)[2]));
			postView.setEmpNo(EDPUtility.convertObjectToString(objectSp.get(0)[3]));
			postView.setPostName(EDPUtility.convertObjectToString(objectSp.get(0)[8]));
			postView.setPostType((posttype.equals(Constant.LOOKUP_YES) ? EDPConstant.PRIMARY_POST : EDPConstant.SECONDARY_POST));
			postView.setOfficeId(EDPUtility.convertObjectToString(objectSp.get(0)[5]));
			postView.setPostOfficeUserId(EDPUtility.convertObjectToString(objectSp.get(0)[4]));
			postView.setStatusId(EDPUtility.convertObjectToString(objectSp.get(0)[31]));
			populateRightsDto(viewDto, objectSp, posttype);
		}
		
		viewDto.setPostView(postView);

		return viewDto;
	}

	/**
	 * Populate rights dto.
	 * Added & removed rights list for grid
	 * @param viewDto the view dto
	 * @param objectSp the object sp
	 * @param posttype the posttype
	 */
	private void populateRightsDto(EDPMenuUserRightsAndRolesViewDto viewDto, List<Object[]> objectSp, String posttype) {
		List<EDPUserMenuRightsAddedDto> addedMenuRightsDto = new ArrayList<>();
		List<EDPUserMenuRightsAddedDto> removedMenuRightsDto = new ArrayList<>();

		if(!objectSp.isEmpty()) {
			Set<Long> menuIds = objectSp.stream().map(object -> EDPUtility.convertObjectToLong(object[10])).collect(Collectors.toSet());
			menuIds.forEach(menuId-> addOrRemoveRightsByMenu(menuId, objectSp, addedMenuRightsDto, removedMenuRightsDto, posttype) );
						
			Collections.sort(addedMenuRightsDto,(o1,o2)->o1.getModule().compareTo(o2.getModule()));
			Collections.sort(removedMenuRightsDto,(o1,o2)->o1.getModule().compareTo(o2.getModule()));
			viewDto.setAddedRightsDto(addedMenuRightsDto);
			viewDto.setRemovedRightsDto(removedMenuRightsDto);
		}
	}
	
	/**
	 * Submite request.
	 *
	 * @param response the response
	 * @throws CustomException the custom exception
	 */
	@Transactional(propagation= Propagation.REQUIRES_NEW, rollbackFor = CustomException.class)
	public void submiteRequest(EDPRightsMappingDto response) throws CustomException {
		Long rgMapId = response.getTusrRgMapId();
		submiteRgMapDtlRolePrm(rgMapId);
		submiteWfData(rgMapId);
	}

	/**
	 * Submite wf data.
	 *
	 * @param rgMapId the rg map id
	 * @throws CustomException the custom exception
	 */
	private void submiteWfData(Long rgMapId) throws CustomException {
		try {
			List<Object[]> wfDtlSaveEntity =  getWfDtlForSubmite(rgMapId);
			/** For compare Link menu Id Get Clue DtoFrom Request**/
			Set<ClueDto> menuIdAndWfList = getMenuAndWfRoleClueDto(wfDtlSaveEntity);
			wfDtlSaveEntity.forEach(obje->{
				Long lkPouId = EDPUtility.convertObjectToLong(obje[1]);
				Long menuId = EDPUtility.convertObjectToLong(obje[2]);
				Long lkUserMenuId = null!=obje[3]?EDPUtility.convertObjectToLong(obje[3]):null;
				Long wfRoleId = EDPUtility.convertObjectToLong(obje[4]);
				Long linkMenuId = null!=obje[6]?EDPUtility.convertObjectToLong(obje[6]):null;
				if(EDPUtility.convertObjectToInt(obje[5])==1) {
					/** WF ADD REQUEST **/
					Long lkUserMenu = null != lkUserMenuId ? lkUserMenuId:createNewLkUserMenu(lkPouId,menuId);
					saveTrnUsrWfRole(wfRoleId, lkUserMenu,Boolean.FALSE);
					if(null != linkMenuId) {
						updateLinkMenuWf(menuIdAndWfList, lkPouId, wfRoleId, linkMenuId);
					}
				}else {
					/** WF REMOVE REQUEST **/
					edpLkPuoMenuRLWFRepository.updateActiveStatusByLkMenuIdAndWfRole(lkUserMenuId,Constant.IN_ACTIVE_STATUS,wfRoleId,OAuthUtility.getCurrentUserUserId(),new Date());
					deActiveLinkMenuIfIsMappedFromBacEnd(lkPouId, wfRoleId, linkMenuId);
				}
			});
		}catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE);
		}
	}

	/**
	 * De active link menu if is mapped from bac end.
	 *
	 * @param lkPouId the lk pou id
	 * @param wfRoleId the wf role id
	 * @param linkMenuId the link menu id
	 */
	private void deActiveLinkMenuIfIsMappedFromBacEnd(Long lkPouId, Long wfRoleId, Long linkMenuId) {
		if(null != linkMenuId && null !=lkPouId &&  null != wfRoleId) {
			
		Optional<EDPLkUserMenuEntity> lkUseMenu = edpLkUserMenuRepository.findByPoOffUserIdLkPoOffUserIdAndMenuID(lkPouId,linkMenuId);
		if(lkUseMenu.isPresent()) {						
			Long lkMenuId = lkUseMenu.get().getLkUserMenuId();
			Optional<EDPTrnUsrMnuWfRole> wfROleEntity = edpLkPuoMenuRLWFRepository.findByLkUserMenuIdLkUserMenuIdAndWorkflowRoleId(lkMenuId,wfRoleId);
			if(wfROleEntity.isPresent()) {
				EDPTrnUsrMnuWfRole saveWfEntity = wfROleEntity.get();
				if(saveWfEntity.getIsMappedFrmLinkdMnu().equals(EDPConstant.LOOKUP_INFO_YES)) {
					edpLkPuoMenuRLWFRepository.updateActiveStatusByLkMenuIdAndWfRole(lkMenuId,Constant.IN_ACTIVE_STATUS,wfRoleId,OAuthUtility.getCurrentUserUserId(),new Date());
				}
			}
		}
		}

	}

	/**
	 * Update link menu wf.
	 *
	 * @param menuIdAndWfList the menu id and wf list
	 * @param lkPouId the lk pou id
	 * @param wfRoleId the wf role id
	 * @param linkMenuId the link menu id
	 */
	private void updateLinkMenuWf(Set<ClueDto> menuIdAndWfList, Long lkPouId, Long wfRoleId, Long linkMenuId) {
		Optional<ClueDto> isLinkMenuRequestForSameWfRole = menuIdAndWfList.stream().filter(m-> m.getId().equals(linkMenuId) && m.getCount().equals(wfRoleId)).findFirst();
		if(!isLinkMenuRequestForSameWfRole.isPresent()) {
			Optional<EDPLkUserMenuEntity> lkUseMenu = edpLkUserMenuRepository.findByPoOffUserIdLkPoOffUserIdAndMenuID(lkPouId,linkMenuId);
			Long lkMenuId = lkUseMenu.isPresent()?lkUseMenu.get().getLkUserMenuId():createNewLkUserMenu(lkPouId,linkMenuId);
			saveTrnUsrWfRole(wfRoleId,lkMenuId,Boolean.TRUE);
		}
	}

	/**
	 * Save trn usr wf role.
	 *
	 * @param wfRoleId the wf role id
	 * @param lkUserMenu the lk user menu
	 * @param isLinkedMenu the is linked menu
	 * @return the EDP trn usr mnu wf role
	 */
	private void saveTrnUsrWfRole(Long wfRoleId, Long lkUserMenu,boolean isLinkedMenu) {
		Optional<EDPTrnUsrMnuWfRole> wfROleEntity = edpLkPuoMenuRLWFRepository.findByLkUserMenuIdLkUserMenuIdAndWorkflowRoleId(lkUserMenu,wfRoleId);
		if(isLinkedMenu) {
			EDPTrnUsrMnuWfRole saveWfEntity = wfROleEntity.isPresent()?wfROleEntity.get():createTrnUsrMnuWfEntity(lkUserMenu,wfRoleId);
			if(Constant.ACTIVE_STATUS != saveWfEntity.getActiveStatus()) {
				saveWfEntity.setActiveStatus(Constant.ACTIVE_STATUS);
				saveWfEntity.setIsMappedFrmLinkdMnu(EDPConstant.LOOKUP_INFO_YES);
				edpLkPuoMenuRLWFRepository.save(saveWfEntity);
			}
		} else {
			EDPTrnUsrMnuWfRole saveWfEntity = wfROleEntity.isPresent()?wfROleEntity.get():createTrnUsrMnuWfEntity(lkUserMenu,wfRoleId);
			saveWfEntity.setActiveStatus(Constant.ACTIVE_STATUS);
			saveWfEntity.setIsMappedFrmLinkdMnu(EDPConstant.LOOKUP_INFO_NO);
			edpLkPuoMenuRLWFRepository.save(saveWfEntity);
		}
	}

	/**
	 * Gets the menu and wf role clue dto.
	 *
	 * @param wfDtlSaveEntity the wf dtl save entity
	 * @return the menu and wf role clue dto
	 */
	private Set<ClueDto> getMenuAndWfRoleClueDto(List<Object[]> wfDtlSaveEntity) {
		return wfDtlSaveEntity.stream().map(obj-> {
						ClueDto dto = new ClueDto();
						dto.setId(EDPUtility.convertObjectToLong(obj[2]));
						dto.setCount(EDPUtility.convertObjectToLong(obj[4]));
						return dto;
				}).collect(Collectors.toSet());
	}

	/**
	 * Creates the trn usr mnu wf entity.
	 *
	 * @param lkUserMenu the lk user menu
	 * @param wfRoleId the wf role id
	 * @return the EDP trn usr mnu wf role
	 */
	private EDPTrnUsrMnuWfRole createTrnUsrMnuWfEntity(Long lkUserMenu, Long wfRoleId) {
		EDPTrnUsrMnuWfRole role = new EDPTrnUsrMnuWfRole();
		role.setLkUserMenuId(new EDPLkUserMenuEntity(lkUserMenu));
		role.setWorkflowRoleId(wfRoleId);
		role.setActiveStatus(EDPConstant.INACTIVE_STATUS);
		return role;
	}

	/**
	 * Creates the new lk user menu.
	 *
	 * @param lkPouId the lk pou id
	 * @param menuId the menu id
	 * @return the EDP lk user menu entity
	 */
	private Long createNewLkUserMenu(Long lkPouId, Long menuId) {
		EDPLkUserMenuEntity lkUseMenu = new EDPLkUserMenuEntity();
		lkUseMenu.setMenuID(menuId);
		lkUseMenu.setPoOffUserId(new EDPLkPoOffUserEntity(lkPouId));
		lkUseMenu =  edpLkUserMenuRepository.save(lkUseMenu);
		return lkUseMenu.getLkUserMenuId();
	}

	/**
	 * Submite rg map dtl role prm.
	 *
	 * @param rgMapId the rg map id
	 */
	private void submiteRgMapDtlRolePrm(Long rgMapId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(EDPConstant.IN_T_USR_RG_MAP_ID, rgMapId);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_EDP_RM_GET_DTL_ROLE_PRM));
		List<Object[]> dtlList  = repository.callStoredProcedure(procName, paramMap);
		if(!CollectionUtils.isEmpty(dtlList)) {
			updateDtlDataInMasterTable(dtlList);
		}
	}
	
	/**
	 * Update dtl data in master table.
	 *
	 * @param dtlList the dtl list
	 */
	private void updateDtlDataInMasterTable(List<Object[]> dtlList) {
		Map<Long,List<Object[]>> menuWishDetails =getMenuWishMap(dtlList);
		menuWishDetails.entrySet().forEach(entry->{
			Long menuId = entry.getKey();
			List<Object[]> data = entry.getValue();
			if(data.size() < 2) {
				updateTrnDtlForSingleRecord(data.get(0),menuId);
			} else {
				updateTrnDtlForMultiRecord(data,menuId);
			}
		});
	}

	/**
	 * Gets the wf dtl for submite.
	 *
	 * @param rgMapId the rg map id
	 * @return the wf dtl for submite
	 */
	private List<Object[]> getWfDtlForSubmite(Long rgMapId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(EDPConstant.IN_T_USR_RG_MAP_ID, rgMapId);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_EDP_RG_GET_WF_REQUEST));
		return repository.callStoredProcedure(procName, paramMap);
	}

	/**
	 * Adds the or remove rights by menu.
	 *
	 * @param menuId the menu id
	 * @param objectSp the object List from sp
	 * @param addedMenuRightsDto the added menu rights dto
	 * @param removedMenuRightsDto the removed menu rights dto
	 * @param posttype the posttype
	 */
	private void addOrRemoveRightsByMenu(Long menuId, List<Object[]> objectSp, List<EDPUserMenuRightsAddedDto> addedMenuRightsDto,  List<EDPUserMenuRightsAddedDto> removedMenuRightsDto, String posttype) {
		objectSp.forEach(object -> {
			if(menuId.equals(EDPUtility.convertObjectToLong(object[10]))) {

				EDPUserMenuRightsAddedDto rightsDto = new EDPUserMenuRightsAddedDto();
				List<String> addedOrRemoved = new ArrayList<>();
				
				String wfRoleId = EDPUtility.convertObjectToString(object[21]);
				String oldWfRoleId = EDPUtility.convertObjectToString(object[23]);
				List<String> wfRoleIds = (wfRoleId.length()>0) ?  Arrays.asList(wfRoleId.split(",")) : new ArrayList<>();
				Set<String> oldWfRoleIds = new HashSet<>();
				oldWfRoleIds.addAll(Arrays.asList(oldWfRoleId.split(",")));
				String roleNames = EDPUtility.convertObjectToString(object[22]);
				List<String> wfRoles = Arrays.asList(roleNames.split(","));
				List<Long> oldRoleIds = new ArrayList<>();
				String wfRole = EDPUtility.convertObjectToString(object[22]);

				setWfRolesInRightsDto(rightsDto, wfRoleIds, wfRoles, wfRole);
				for(String id : oldWfRoleIds)
				{
					oldRoleIds.add(EDPUtility.convertObjectToLong(id));
				}

				rightsDto.setOldWfRoleIds(oldRoleIds);
				rightsDto.setEmpName(EDPUtility.convertObjectToString(object[2]));
				rightsDto.setEmpNo(EDPUtility.convertObjectToString(object[3]));
				rightsDto.setMenu(EDPUtility.convertObjectToString(object[11]));
				rightsDto.setModule(EDPUtility.convertObjectToString(object[13]));
				rightsDto.setPostName(EDPUtility.convertObjectToString(object[8]));
				rightsDto.setPostType((posttype.equals(Constant.LOOKUP_YES) ? EDPConstant.PRIMARY_POST : EDPConstant.SECONDARY_POST));
				rightsDto.setSubModule(EDPUtility.convertObjectToString(object[15]));
				rightsDto.setPermission(EDPUtility.convertObjectToString(object[17]));
				rightsDto.setMenuId(EDPUtility.convertObjectToLong(object[10]));
				rightsDto.setOldPrmId(EDPUtility.convertObjectToLong(object[18]));
				rightsDto.setPrmId(EDPUtility.convertObjectToLong(object[16]));
				rightsDto.setModuleId(EDPUtility.convertObjectToLong(object[12]));
				rightsDto.setSubModuleId(EDPUtility.convertObjectToLong(object[14]));
				rightsDto.setTusrRgMapDtlId(EDPUtility.convertObjectToLong(object[26]));
				rightsDto.setOfficeId(EDPUtility.convertObjectToLong(object[5]));

				//populate added or removed rights list based on isRemoved flag
				addOrRemoveRights(object, rightsDto, addedMenuRightsDto, removedMenuRightsDto, addedOrRemoved);
				rightsDto.setAddedOrRemovedRights(addedOrRemoved);
			}
		});
	}
	
	/**
	 * Sets the wf roles in rights dto.
	 *
	 * @param rightsDto the rights dto
	 * @param wfRoleIds the wf role ids
	 * @param wfRoles the wf roles
	 * @param wfRole the wf role
	 */
	private void setWfRolesInRightsDto(EDPUserMenuRightsAddedDto rightsDto, List<String> wfRoleIds,List<String> wfRoles, String wfRole) {
		List<Long> roleIds = new ArrayList<>();
		List<ClueDto> roles = new ArrayList<>();
		if (!wfRoleIds.isEmpty()) {
			for (int i = 0; i < wfRoleIds.size(); i++) {
				ClueDto clue = new ClueDto();
				clue.setId(EDPUtility.convertObjectToLong(wfRoleIds.get(i)));
				clue.setName(wfRoles.get(i));
				roles.add(clue);
			}

			for (String id : wfRoleIds) {
				roleIds.add(EDPUtility.convertObjectToLong(id));
			}
			List<String> wfRoleNameList = Arrays.asList(wfRole.split(Constant.COMMA));
			wfRoleNameList.sort(String.CASE_INSENSITIVE_ORDER);
			rightsDto.setWfRole(wfRoleNameList.stream().collect(Collectors.joining(	Constant.COMMA)));
			rightsDto.setWfRoleIds(roleIds);
		}
		rightsDto.setWfRoleList(roles);

	}
	
	/**
	 * Populate added or removed list.
	 *
	 * @param prmName the prm name
	 * @param oldPrmName the old prm name
	 * @param addedOrRemoved the added or removed
	 * @param isRemoved the is removed
	 */
	private void populateAddedOrRemovedList(String prmName,String oldPrmName, List<String> addedOrRemoved, boolean isRemoved) {
		List<String> prmNameList = (prmName.contains(",")) ? Arrays.asList(prmName.split(",")) : new ArrayList<>();
		List<String> oldPrmNameList = (oldPrmName.contains(",")) ?  Arrays.asList(oldPrmName.split(",")) : new ArrayList<>();
		if(prmNameList.isEmpty() && prmName.length() > 0){
			prmNameList.add(prmName);
		}
		if(oldPrmNameList.isEmpty() && oldPrmName.length() > 0) {
			oldPrmNameList.add(oldPrmName);
		}
		populateByAddedOrRemovedFlag(prmNameList, oldPrmNameList, addedOrRemoved, isRemoved);
	}
	
	/**
	 * Populate by added or removed flag.
	 *
	 * @param prmNameList the prm name list
	 * @param oldPrmNameList the old prm name list
	 * @param addedOrRemoved the added or removed
	 * @param isRemoved the is removed
	 */
	private void populateByAddedOrRemovedFlag(List<String> prmNameList, List<String> oldPrmNameList,List<String> addedOrRemoved, boolean isRemoved)
	{
		if(isRemoved && (prmNameList.size() == oldPrmNameList.size()) && oldPrmNameList.containsAll(prmNameList)) {
			addedOrRemoved.addAll(prmNameList);
		}else if(!isRemoved) {
			addNonMatchingPermsToList(prmNameList, oldPrmNameList, addedOrRemoved);
		}else {
			addNonMatchingPermsToList(oldPrmNameList, prmNameList, addedOrRemoved);
		}		
	}
	
	/**
	 * Adds the non matching perms to list.
	 *
	 * @param matchFromList the match from list
	 * @param matchToList the match to list
	 * @param addToList the add to list
	 */
	private void addNonMatchingPermsToList(List<String> matchFromList, List<String> matchToList, List<String> addToList) {
		for(String name : matchFromList) {
			if(!matchToList.contains(name) && null != name)
				addToList.add(name);			
		}
	}
	
	/**
	 * Adds the or remove rights.
	 *
	 * @param object the object from sp list
	 * @param rightsDto the rights dto
	 * @param addedMenuRightsDto the added menu rights dto
	 * @param removedMenuRightsDto the removed menu rights dto
	 * @param addedOrRemoved the added or removed
	 */
	private void addOrRemoveRights(Object[] object, EDPUserMenuRightsAddedDto rightsDto, List<EDPUserMenuRightsAddedDto> addedMenuRightsDto,  List<EDPUserMenuRightsAddedDto> removedMenuRightsDto, List<String> addedOrRemoved) {

		Long isPrmRemoved = null;
		Long isWfRoleRemoved = null;
		String prmName = EDPUtility.convertObjectToString(object[17]);
		String oldPrmName = EDPUtility.convertObjectToString(object[19]);

		if(null != object[20] )
		{
			isPrmRemoved = EDPUtility.convertObjectToLong(object[20]);						
		}
		if(null !=  object[24] )
		{
			isWfRoleRemoved = EDPUtility.convertObjectToLong(object[24]);
		}
		if((null != isPrmRemoved && isPrmRemoved.equals(Constant.LONG_ONE_VALUE)) || (null != isWfRoleRemoved && isWfRoleRemoved.equals(Constant.LONG_ONE_VALUE))) {
			rightsDto.setIsRemoved(Constant.LONG_ZERO_VALUE);
			populateAddedOrRemovedList(prmName, oldPrmName, addedOrRemoved, Boolean.FALSE);	
			addedMenuRightsDto.add(rightsDto);
		} else if((null != isPrmRemoved && isPrmRemoved.equals(Constant.LONG_TWO_VALUE)) || (null != isWfRoleRemoved && isWfRoleRemoved.equals(Constant.LONG_TWO_VALUE))){
			rightsDto.setIsRemoved(Constant.LONG_ONE_VALUE);
			populateAddedOrRemovedList(prmName, oldPrmName, addedOrRemoved, Boolean.TRUE);	
			removedMenuRightsDto.add(rightsDto);
		}

	}
	

	/**
	 * Creates the data list for request.
	 * 
	 * @param rightsMappingdto the rights mappingdto
	 */
	private void createDataListForRequest(EDPRightsMappingDto rightsMappingdto) {
		List<EDPRightsMappingDataDto> uiData = rightsMappingdto.getUiDataList();
		List<EDPRightsMappingDataDto> data = new ArrayList<>();
		uiData.forEach(menuData->{
			List<String> removeRights =  menuData.getOldRightsList().stream().filter(s->!menuData.getRightsList().contains(s)).collect(Collectors.toList());
			List<String> addRights = menuData.getRightsList().stream().filter(s->!menuData.getOldRightsList().contains(s)).collect(Collectors.toList());
			List<ClueDto> removeWf = menuData.getOldWfRoleList().stream().filter(s->!menuData.getWfRoleList().contains(s)).collect(Collectors.toList());
			List<ClueDto> addWf = menuData.getWfRoleList().stream().filter(s->!menuData.getOldWfRoleList().contains(s)).collect(Collectors.toList());
			if(!CollectionUtils.isEmpty(removeRights) || !CollectionUtils.isEmpty(removeWf)) {
				EDPRightsMappingDataDto dataDto = getRemoveRightsWfDto(menuData, removeRights, removeWf);
				data.add(dataDto);
			}
			if(!CollectionUtils.isEmpty(addRights) || !CollectionUtils.isEmpty(addWf)) {
				EDPRightsMappingDataDto dataDto = getAddRightsWfDto(menuData, addRights, addWf);
				data.add(dataDto);
			}
		});
		rightsMappingdto.setDataList(data);
	}

	/**
	 * Gets the adds the rights wf dto.
	 *
	 * @param menuData the menu data
	 * @param addRights the add rights
	 * @param addWf the add wf
	 * @return the adds the rights wf dto
	 */
	private EDPRightsMappingDataDto getAddRightsWfDto(EDPRightsMappingDataDto menuData, List<String> addRights,
			List<ClueDto> addWf) {
		EDPRightsMappingDataDto dataDto = new EDPRightsMappingDataDto();
		dataDto.setMenuId(menuData.getMenuId());
		if(!CollectionUtils.isEmpty(addRights)) {
			dataDto.setIsRightsRemoved(Boolean.FALSE);
			dataDto.setOldRightsList(menuData.getOldRightsList());
			dataDto.setRightsList(menuData.getRightsList());
		}
		if(!CollectionUtils.isEmpty(addWf)) {
			dataDto.setOldWfRoleList(menuData.getOldWfRoleList());
			dataDto.setWfRoleList(addWf.stream().map(dto->{
				dto.setIsWfRoleRemoved(Boolean.FALSE);
			  return dto;	
			}).collect(Collectors.toList()));
		}
		return dataDto;
	}

	/**
	 * Checks if is remove rights wf dto.
	 *
	 * @param menuData the menu data
	 * @param removeRights the remove rights
	 * @param removeWf the remove wf
	 * @return the EDP rights mapping data dto
	 */
	private EDPRightsMappingDataDto getRemoveRightsWfDto(EDPRightsMappingDataDto menuData, List<String> removeRights,
			List<ClueDto> removeWf) {
		EDPRightsMappingDataDto dataDto = new EDPRightsMappingDataDto();
		dataDto.setMenuId(menuData.getMenuId());
		if(!CollectionUtils.isEmpty(removeRights)) {
			dataDto.setIsRightsRemoved(Boolean.TRUE);
			dataDto.setOldRightsList(menuData.getOldRightsList());
			dataDto.setRightsList(!CollectionUtils.isEmpty(menuData.getRightsList())?menuData.getRightsList():removeRights);
		}
		if(!CollectionUtils.isEmpty(removeWf)) {
			dataDto.setOldWfRoleList(menuData.getOldWfRoleList());
			dataDto.setWfRoleList(removeWf.stream().map(dto->{
				dto.setIsWfRoleRemoved(Boolean.TRUE);
			  return dto;	
			}).collect(Collectors.toList()));
		}
		return dataDto;
	}
	
	/**
	 * Gets the menu wish map.
	 *
	 * @param dtlList the dtl list
	 * @return the menu wish map
	 */
	public Map<Long, List<Object[]>> getMenuWishMap(List<Object[]> dtlList){
		Map<Long,List<Object[]>> menuWishDetails = new HashMap<>();
		dtlList.forEach(obj -> {
			Long menuId = EDPUtility.convertObjectToLong(obj[0]);
			boolean isRightsAdd = null!=obj[4]?Boolean.TRUE:Boolean.FALSE;
			if(isRightsAdd) {				
				if (menuWishDetails.containsKey(menuId)) {
					List<Object[]> value = menuWishDetails.get(menuId);
					value.add(obj);
					menuWishDetails.replace(menuId, value);
				} else {
					List<Object[]> objList = new ArrayList<>();
					objList.add(obj);
					menuWishDetails.put(menuId, objList);
				}
			}
		});
		return menuWishDetails;
	}
	
	/**
	 * Creates the new EDP trn user mnu role prm entity.
	 *
	 * @param lkUserMenuId the lk user menu id
	 * @param rolePrmId the role prm id
	 * @return the EDP trn user mnu role prm entity
	 */
	public EDPTrnUserMnuRolePrmEntity createNewEDPTrnUserMnuRolePrmEntity(Long lkUserMenuId,Long rolePrmId) {
		EDPTrnUserMnuRolePrmEntity entity = new EDPTrnUserMnuRolePrmEntity();
		entity.setLkUserMenuId(new EDPLkUserMenuEntity(lkUserMenuId));
		entity.setRolePrmId(rolePrmId);
		return entity;
	}
	
	/**
	 * Update trn dtl for single record.
	 *
	 * @param dtlEntity the dtl entity
	 * @param menuId the menu id
	 */
	public void updateTrnDtlForSingleRecord(Object[] dtlEntity, Long menuId) {
		Long isRightsRemove = null != dtlEntity[8]?EDPUtility.convertObjectToLong(dtlEntity[8]):null;
		if(null != isRightsRemove) {					
			Long trnRolePrmId = null != dtlEntity[3]?EDPUtility.convertObjectToLong(dtlEntity[3]):null;
			Long trnRoleOldPrmId = null != dtlEntity[6]?EDPUtility.convertObjectToLong(dtlEntity[6]):null;
			Long requestPrmId  =  EDPUtility.convertObjectToLong(dtlEntity[4]);
			if(isRightsRemove.equals(EDPConstant.LOOKUP_INFO_YES)) {
				removeRightFromMaster(trnRolePrmId, trnRoleOldPrmId, requestPrmId);
			} else {
				Long pouId = EDPUtility.convertObjectToLong(dtlEntity[1]);
				Long lkUserMenu = null != dtlEntity[2] ? EDPUtility.convertObjectToLong(dtlEntity[2]):createNewLkUserMenu(pouId,menuId);
				addRightFromMaster(trnRolePrmId, requestPrmId, lkUserMenu);
			}

		}
	}

	/**
	 * Adds the right from master.
	 *
	 * @param trnRolePrmId the trn role prm id
	 * @param requestPrmId the request prm id
	 * @param lkUserMenu the lk user menu
	 */
	private void addRightFromMaster(Long trnRolePrmId, Long requestPrmId, Long lkUserMenu) {
		if(null != trnRolePrmId) {
			edpTrnUserMnuRolePrmRepository.updateActiveStatusAndRolePrmIdByTrnUsrRolePrmId(trnRolePrmId, Constant.ACTIVE_STATUS,OAuthUtility.getCurrentUserUserId(), new Date(),requestPrmId);
		} else {
			EDPTrnUserMnuRolePrmEntity newRolePrm = createNewEDPTrnUserMnuRolePrmEntity(lkUserMenu,requestPrmId);
			edpTrnUserMnuRolePrmRepository.save(newRolePrm);	
		}
	}

	/**
	 * Removes the right from master.
	 *
	 * @param trnRolePrmId the trn role prm id
	 * @param trnRoleOldPrmId the trn role old prm id
	 * @param requestPrmId the request prm id
	 */
	private void removeRightFromMaster(Long trnRolePrmId, Long trnRoleOldPrmId, Long requestPrmId) {
		if(requestPrmId.equals(trnRoleOldPrmId)) {
			edpTrnUserMnuRolePrmRepository.updateActiveStatusByTrnUsrRolePrmId(trnRolePrmId, Constant.IN_ACTIVE_STATUS,OAuthUtility.getCurrentUserUserId(), new Date());							
		} else {
			edpTrnUserMnuRolePrmRepository.updateActiveStatusAndRolePrmIdByTrnUsrRolePrmId(trnRolePrmId, Constant.ACTIVE_STATUS,OAuthUtility.getCurrentUserUserId(), new Date(),requestPrmId);
		}
	}
	
	/**
	 * Update trn dtl for multi record.
	 *
	 * @param data the data
	 * @param menuId the menu id
	 */
	private void updateTrnDtlForMultiRecord(List<Object[]> data,Long menuId) {
		
		Optional<Object[]> isAnyIsRemoveRequest = data.stream().filter(obj-> null != obj[8] 
				&& EDPConstant.LOOKUP_INFO_YES.equals(EDPUtility.convertObjectToLong(obj[8]))).findFirst();
		Optional<Object[]> isAnyIsAddRequest = data.stream().filter(obj-> null != obj[8] 
				&& EDPConstant.LOOKUP_INFO_NO.equals(EDPUtility.convertObjectToLong(obj[8]))).findFirst();
		if(isAnyIsRemoveRequest.isPresent() && isAnyIsAddRequest.isPresent()) {
			String rightForRemoveRecord = EDPUtility.convertObjectToString(isAnyIsRemoveRequest.get()[5]);
			String approveRightsForRemoveRecord = EDPUtility.convertObjectToString(isAnyIsRemoveRequest.get()[7]);
			List<String> removedRights = getRemovedRights(rightForRemoveRecord,approveRightsForRemoveRecord);
			EDPMsRolePermissionsEntity finalRights = getRightsFromRemoveRights(removedRights,EDPUtility.convertObjectToString(isAnyIsAddRequest.get()[5]));
			Long trnRolePrmId = EDPUtility.convertObjectToLong(isAnyIsRemoveRequest.get()[3]);
			Long lkUserMenu = EDPUtility.convertObjectToLong(isAnyIsRemoveRequest.get()[2]);
			addRightFromMaster(trnRolePrmId, finalRights.getRoleActivityId(), lkUserMenu);
		} else {
			updateTrnDtlForSingleRecord(data.get(0),menuId);
		}
	}


	/**
	 * Gets the removed rights.
	 *
	 * @param rightForRemoveRecord the right for remove record
	 * @param approveRightsForRemoveRecord the approve rights for remove record
	 * @return the removed rights
	 */
	private List<String> getRemovedRights(String rightForRemoveRecord, String approveRightsForRemoveRecord) {
		List<String> approveList = Arrays.asList(approveRightsForRemoveRecord.split(Constant.COMMA));
		List<String> requestRights = Arrays.asList(rightForRemoveRecord.split(Constant.COMMA));
		return approveList.stream().filter(ar->!requestRights.contains(ar)).collect(Collectors.toList());
	}

	/**
	 * Gets the rights from remove rights.
	 *
	 * @param removeRights the remove rights
	 * @param rights the rights
	 * @return the rights from remove rights
	 */
	private EDPMsRolePermissionsEntity getRightsFromRemoveRights(List<String> removeRights , String rights) {
		List<String> rightsAdd = new ArrayList<>();
		String[] r = rights.split(Constant.COMMA);
		Collections.addAll(rightsAdd, r);
		removeRights.forEach(ri->{
			if(rightsAdd.contains(ri)) 
				rightsAdd.remove(ri);
		});
		rightsAdd.sort(String.CASE_INSENSITIVE_ORDER);
		String newRolePrm = rightsAdd.stream().collect(Collectors.joining(Constant.COMMA));
		List<EDPMsRolePermissionsEntity> rolePrmList = edpMsRolePermissionsRepository.findByActiveStatus(Constant.ACTIVE_STATUS);
		Optional<EDPMsRolePermissionsEntity> savedRole = rolePrmList.stream().filter(role-> role.getRoleName().equals(newRolePrm)).findFirst();
		if(savedRole.isPresent()) {
			return savedRole.get();
		} else {
			EDPMsRolePermissionsEntity entity = new EDPMsRolePermissionsEntity();
			entity.setRoleName(newRolePrm);
			entity.setRoleCode(newRolePrm);
			entity.setRoelTypeId(1);
			entity.setParentRoleId(1);
			return edpMsRolePermissionsRepository.save(entity);
		}
	}

	/**
	 * Delete user role mappings.
	 *
	 * @param rgMapId the rg map id
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(propagation= Propagation.REQUIRES_NEW, rollbackFor = CustomException.class)
	public void deleteUserRoleMappings(Long rgMapId) throws CustomException{
		   Long updatedBy  = OAuthUtility.getCurrentUserUserId() ;
		   Long updatedByPost = OAuthUtility.getCurrentUserLkPOUId(); 
		   Date updatedDate = new Date();
		   edpTusrRgMapRepository.updateActiveStatusByRgMapId(rgMapId, Constant.INACTIVE_STATUS, updatedBy, updatedByPost, updatedDate);
		   edptusrRgMapDtlRepository.multipalUpdateActiveStatusByRgMapId(rgMapId,Constant.INACTIVE_STATUS,updatedBy,updatedByPost,updatedDate);
		   edptusrRgMapWfDtlRepository.multipalUpdateActiveStatusByRgMapId(rgMapId,Constant.INACTIVE_STATUS,updatedBy,updatedByPost,updatedDate);
	}

	/**
	 * Gets the menu office details.
	 *
	 * @param menuId the menu id
	 * @param officeId the office id
	 * @param moduleId the module id
	 * @param subModuleId the sub module id
	 * @return the menu office details
	 */
	@Override
	public ClueDto getMenuOfficeDetails(Long menuId, Long officeId, Long moduleId, Long subModuleId) {
			
		EDPMsOfficeDto officeDto = setOfficeAndCategory(officeId);
		return setModAndMenuOffType(moduleId, officeDto.getOfficeTypeId(), officeDto.getOfficeSubType(), subModuleId, menuId);

	}
	
	
	/**
	 * De active transction detailsby rg map id.
	 *
	 * @param tusrRgMapId the tusr rg map id
	 * @throws CustomException the custom exception
	 */
	private void deActiveTransctionDetailsbyRgMapId(Long tusrRgMapId) {
	   Long updatedBy  = OAuthUtility.getCurrentUserUserId() ;
	   Long updatedByPosy = OAuthUtility.getCurrentUserLkPOUId(); 
	   Date updatedDate = new Date();	   
	   edptusrRgMapDtlRepository.multipalUpdateActiveStatusByRgMapId(tusrRgMapId, Constant.INACTIVE_STATUS, updatedBy, updatedByPosy, updatedDate);
	   edptusrRgMapWfDtlRepository.multipalUpdateActiveStatusByRgMapId(tusrRgMapId, Constant.INACTIVE_STATUS, updatedBy, updatedByPosy, updatedDate);
	}

	/**
	 * Checks if is workflow required.
	 *
	 * @param officeId the office id
	 * @param userId the user id
	 * @return the boolean
	 */
	@Override
	public Boolean isWorkflowRequired() {
		Set<Long> roleIds = OAuthUtility.getWfRoleUsingMenuId(EDPConstant.POST_RIGHTS_MAPPING_MENU_ID);
		if ((roleIds.isEmpty() || roleIds.contains(45L))  && OAuthUtility.isCurrentUserIsDAT())
			return Boolean.FALSE;
		else
			return Boolean.TRUE;
	}

	/**
	 * Gets the listing filter data.
	 *
	 * @return the listing filter data
	 */
	@Override
	public ClueDto getListingFilterData() {
		ClueDto officedetailsdto = new ClueDto();
		
		List<ClueDto> distList = districtConverter.toClueDTO(districtRepository.findByActiveStatusAndStateId(Constant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ,
								EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC)));
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(EDPConstant.ARGS_MENU_ID, EDPConstant.POST_RIGHTS_MAPPING_MENU_ID);
		List<Object[]> dataList = edpTusrRgMapRepository.executeNativeSQLQuery(EDPNativeSQLUtil.GET_EDP_WF_TRN_STATUS_BY_MENU_ID_QUERY,argMap);
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
        officedetailsdto.setDistricts(distList);
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
	
	
	public ClueDto getMenuOfficeDetailsForWfRoles(Long menuId, Long officeId, Long moduleId, Long subModuleId) {
		
		
		EDPMsOfficeEntity officeEntity = edpMsOfficeRepository.getOne(officeId);
		Long officeCategoryId = null;
		
		if(!StringUtils.isEmpty(officeEntity.getOfficeDivision()) && officeEntity.getOfficeDivision().equalsIgnoreCase(EDPConstant.DAT_OFFICE))
		{
			officeCategoryId = EDPConstant.DAT_LOOKUP_VALUE;
		} else {
			Long officeSubTypeId = officeEntity.getOfficeSubType();
			if ((null != officeSubTypeId) && (officeSubTypeId.equals(EDPConstant.TO_LOOKUP_ID) || officeSubTypeId.equals(EDPConstant.PAO_LOOKUP_ID))) {
				officeCategoryId = officeSubTypeId;
			}
		}
		return setModAndMenuOffType(moduleId, officeEntity.getOfficeTypeId().getLookUpInfoId(), officeCategoryId, subModuleId, menuId);
	}

	private ClueDto setModAndMenuOffType(Long moduleId, Long officeTypeId, Long officeCategoryId, Long subModuleId, Long menuId) {
		EDPLkModuleOfficeEntity modOfficeEntity = (officeCategoryId != null && officeCategoryId > 0) ?
				edpLkModuleOfficeRepository.findByModuleIdModuleIDAndOfficeTypeIdLookUpInfoIdAndOfficeCategoryIdLookUpInfoIdAndActiveStatus(moduleId, officeTypeId, officeCategoryId, Constant.ACTIVE_STATUS)
				:edpLkModuleOfficeRepository.findByModuleIdModuleIDAndOfficeTypeIdLookUpInfoIdAndOfficeCategoryIdLookUpInfoIdIsNullAndActiveStatus(moduleId, officeTypeId, Constant.ACTIVE_STATUS);
		Long modOfficeTypeId = modOfficeEntity.getLkModOffId();
		EdpLkSubMenuOfficeTypeEntity menuOffTypeEntity =  edpLkSubMenuOfficeRepository.findByModOffTypeIdLkModOffIdAndSubModuleIdSubModuleIdAndMenuIdMenuIdAndActiveStatus(modOfficeTypeId, subModuleId, menuId, Constant.ACTIVE_STATUS);

		ClueDto dto = new ClueDto();
		dto.setModOfficeTypeId(modOfficeTypeId);
		if(null != menuOffTypeEntity) {
			dto.setMenuOfficeTypeId(menuOffTypeEntity.getLkMenuOffTypeId());			
		}
		return dto;		
	}

	private EDPMsOfficeDto setOfficeAndCategory(Long officeId) {
		EDPMsOfficeEntity officeEntity = null;
		Long officeCategoryId = 0L;

		Set<Long> roleIds = OAuthUtility.getWfRoleUsingMenuId(EDPConstant.POST_RIGHTS_MAPPING_MENU_ID);
		
		if(OAuthUtility.isCurrentUserIsDAT() && (roleIds.isEmpty() || roleIds.contains(45L)))
		{
			officeCategoryId = EDPConstant.DAT_LOOKUP_VALUE;
			officeEntity = edpMsOfficeRepository.findByOfficeIdAndActiveStatus(EDPConstant.DAT_OFFICE_ID, Constant.ACTIVE_STATUS);
		} else {
			officeEntity = edpMsOfficeRepository.findByOfficeIdAndActiveStatus(officeId, Constant.ACTIVE_STATUS);
			Long officeSubTypeId = officeEntity.getOfficeSubType();
			if ((null != officeSubTypeId) && (officeSubTypeId.equals(EDPConstant.TO_LOOKUP_ID) || officeSubTypeId.equals(EDPConstant.PAO_LOOKUP_ID))) {
				officeCategoryId = officeSubTypeId;
			}
		}
		EDPMsOfficeDto officeDto = new EDPMsOfficeDto();
		officeDto.setOfficeTypeId(officeEntity.getOfficeTypeId().getLookUpInfoId());
		officeDto.setOfficeSubType(officeCategoryId);
		return officeDto;
	}
}
