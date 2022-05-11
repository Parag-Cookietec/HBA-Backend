package gov.ifms.edp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.Status;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPUserRoleMappingConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPEmpByOffIdDto;
import gov.ifms.edp.dto.EDPGetPostByMenuOffIdViewDto;
import gov.ifms.edp.dto.EDPGetWfRoleByMenuIdViewDto;
import gov.ifms.edp.dto.EDPRightsMappingDto;
import gov.ifms.edp.dto.EdpUserRightsRequestDto;
import gov.ifms.edp.dto.PostOfficeMenuDto;
import gov.ifms.edp.entity.EDPUserRoleMappingEntity;
import gov.ifms.edp.service.EDPMsUserService;
import gov.ifms.edp.service.EDPUserRoleMappingService;

/**
 * The Class EDPUserRoleMappingController.
 * 
 * @version 1.0.
 * @created 2019/12/30 11:27:53.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_USERROLEMAPPING)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPUserRoleMappingController {

	/** The service. */
	@Autowired
	private EDPUserRoleMappingService service;

	@Autowired
	private EDPMsUserService userService;

	/** The converter. */
	@Autowired
	private EDPUserRoleMappingConverter converter;

	/**
	 * Fetch UserRoleMappings by given UserRoleMappings id.
	 *
	 * @param id the id
	 * @return dto
	 * @throws CustomException
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getUserRoleMapping(@RequestBody IdDto id) throws CustomException {
		if (null != id.getId()) {
			EDPUserRoleMappingEntity entity = service.getUserRoleMapping(id.getId());
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}

	/**
	 * Creates the user role mappings.
	 *
	 * @param dtos the dtos
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_ROLE_MAPPING_SAVE)
	public ResponseEntity<ApiResponse> createUserRoleMappings(@Valid @RequestBody EDPRightsMappingDto dto)
			throws CustomException {
		try {

			return dto.getFormAction() == Status.SUBMITTED
					? ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
							service.saveUserRoleMapping(dto))
					: ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
							service.saveUserRoleMapping(dto));
		} catch (DataIntegrityViolationException ex) {
			return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
		} catch (CustomException e) {
			throw e;
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Fetch all the UserRoleMappings items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPUserRoleMappingDto>
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getUserRoleMappings(@Valid @RequestBody PageDetails pageDetail)
			throws CustomException {
		if (null != pageDetail.getJsonArr() && !pageDetail.getJsonArr().isEmpty()) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
					service.getUserRoleMappings(pageDetail));
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}


	/**
	 * Gets the given removal role mapping.
	 *
	 * @param id the id
	 * @return the given removal role mapping
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_EMP_BY_OFF_ID)
	public ResponseEntity<ApiResponse> getEmpByOffId(@RequestBody IdDto id) throws CustomException {
		if (null != id.getId()) {

			List<EDPEmpByOffIdDto> dtos = service.getEmpByOfficeId(id.getId());
			if(!dtos.isEmpty()) {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, dtos);				
			}else {
				throw new CustomException(ErrorResponse.ERROR_EDP_EMP_NOT_FOUND);
			}
			
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}

	/**
	 * update empIdPostOffid
	 *
	 * @param id the id
	 * @return the given removal role mapping
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_UPDATE_RGMAP_BY_EMP_PO_OFF_ID)
	public ResponseEntity<ApiResponse> updateEmpIdPostOffId(@RequestParam long oldUserId,
			@RequestParam long oldPoOffUserId, @RequestParam long newUserId, @RequestParam long newPoOffUserId)
			throws CustomException {
		service.updateRgMapByEmpIdAndPoOffId(oldUserId, oldPoOffUserId, newUserId, newPoOffUserId);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE);
	}

	/**
	 * update empIdPostOffid
	 *
	 * @param id the id
	 * @return the given removal role mapping
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_POST_BY_MENU_OFF_ID)
	public ResponseEntity<ApiResponse> getPostByMenuIdAndOffId(@RequestBody EdpUserRightsRequestDto dto)
			throws CustomException {
		if((null != dto.getMenuId()) && (null != dto.getOfficeId()) && (null != dto.getWfRoleIds()))
		{
			List<EDPGetPostByMenuOffIdViewDto> listDto = service.getPostByMenuOffId(dto.getMenuId(), dto.getOfficeId(),
					 dto.getWfRoleIds());
			if(!listDto.isEmpty())
			{
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, listDto);			
			} else {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.RECORD_NOT_FOUND, null);
			}
			
		}else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}

	/**
	 * get Workflow By UserMenuId
	 *
	 * @param id the id
	 * @return the given removal role mapping
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_WF_BY_USER_MENU_ID)
	public ResponseEntity<ApiResponse> getWorkflowByUserMenuId(@RequestBody IdDto idDto) throws CustomException {
		if (null != idDto.getId()) {
			List<EDPGetWfRoleByMenuIdViewDto> listEntity = service.getWfByMenuId(idDto.getId());
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, listEntity);
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}

	/**
	 * Gets the approved user rights by post officer user id.
	 *
	 * @param dto the dto
	 * @return the approved user rights by post officer user id
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_WF_BY_POST_OFC_USER_MENU_ID)
	public ResponseEntity<ApiResponse> getApprovedUserRightsByPostOfficerUserId(@RequestBody PostOfficeMenuDto dto)
			throws CustomException {
		if(null != dto) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
					userService.getWorkFlowsForMenu(dto.getPostOfficeUserId(), dto.getMenuId(), Boolean.TRUE));			
		}else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}

	/**
	 * get District By State Id
	 *
	 * @param id the id
	 * @return the given removal role mapping
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_DISTRICT_BY_STATE_ID)
	public ResponseEntity<ApiResponse> getDistrictByStateId() throws CustomException {
		List<ClueDto> listEntity = service.getDistrictByStateId();
		if(!listEntity.isEmpty()) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, listEntity);			
		}else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}

	/**
	 * Gets the modules for office type.
	 *
	 * @param dto the dto
	 * @return the modules for office type
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_MODULE_FOR_OFFICE)
	public ResponseEntity<ApiResponse> getModulesForOfficeType(@RequestBody EdpUserRightsRequestDto dto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
					service.getModulesForOfficeType(dto.getOfficeId()));
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the sub module or menu.
	 *
	 * @param dto the dto
	 * @return the sub module or menu
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_MOD_OFF_ID)
	public ResponseEntity<ApiResponse> getSubModuleOrMenu(@RequestBody EdpUserRightsRequestDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
					service.getSubModulesOrMenu(dto.getLkModOffTypeId()));
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the menus for sub module.
	 *
	 * @param dto the dto
	 * @return the menus for sub module
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_MENU_FOR_SUBMODULE)
	public ResponseEntity<ApiResponse> getMenusForSubModule(@RequestBody EdpUserRightsRequestDto dto)
			throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
					service.getMenusForSubmodule(dto.getLkModOffTypeId(), dto.getSubModuleId()));
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the approved user rights by post officer user id.
	 *
	 * @param id the id
	 * @return the approved user rights by post officer user id
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.GET_APPROVED_USER_RIGHTS)
	public ResponseEntity<ApiResponse> getApprovedUserRightsByPostOfficerUserId(@RequestBody IdDto id)
			throws CustomException {
		if (null != id.getId()) {

			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
					service.getApproveUserRights(id.getId()));
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}

	/**
	 * Gets the saved user rights.
	 *
	 * @param id the id
	 * @return the saved user rights
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_GET_SAVED_RIGHTS)
	public ResponseEntity<ApiResponse> getSavedUserRights(@RequestBody IdDto id) throws CustomException {
		if (null != id.getId()) {

			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
					service.getSavedUserRights(id.getId()));
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}

	/**
	 * Delete saved user role mappings.
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_REMOVE_SAVED_ROLEMAPPINGS)
	public ResponseEntity<ApiResponse> deleteSavedUserRoleMappings(@RequestBody IdDto id) throws CustomException {
		if (null != id.getId()) {

			service.deActiveOldTransctionListbyRgMapId(id.getId());
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE);
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}

	/**
	 * Delete user role mappings.
	 *
	 * @param id the id
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_REMOVE_ROLEMAPPINGS)
	public ResponseEntity<ApiResponse> deleteUserRoleMappings(@RequestBody IdDto id) throws CustomException {
		if (null != id.getId()) {

			service.deleteUserRoleMappings(id.getId());
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE);
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}
	
	/**
	 * Gets the menu office details.
	 *
	 * @param dto the dto
	 * @return the menu office details
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_MENU_OFFICE_DETAILS)
	public ResponseEntity<ApiResponse> getMenuOfficeDetails(@RequestBody EdpUserRightsRequestDto dto) throws CustomException{
		if((null != dto.getMenuId()) && (null != dto.getModuleId()) && (null != dto.getSubModuleId()) && (null != dto.getOfficeId())) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
					service.getMenuOfficeDetails(dto.getMenuId(), dto.getOfficeId(), dto.getModuleId(), dto.getSubModuleId()));
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}
	
	/**
	 * Gets the checks if is workflow required.
	 *
	 * @param dto the dto
	 * @return the checks if is workflow required
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_CHECK_PT_WF)
	public ResponseEntity<ApiResponse> getIsWorkflowRequired() throws CustomException{
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.isWorkflowRequired());			
	}
	
	/**
	 * Gets the listing filter data api.
	 *
	 * @return the listing filter data api
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_PT_SEARCHSTATUS)
	public ResponseEntity<ApiResponse> getListingFilterDataApi() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getListingFilterData());
	}
}