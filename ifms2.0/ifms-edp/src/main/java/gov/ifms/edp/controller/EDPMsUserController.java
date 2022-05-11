package gov.ifms.edp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.FieldDto;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPMsUserConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPEmployeePostSearchView;
import gov.ifms.edp.dto.EDPMsUserDto;
import gov.ifms.edp.dto.EDPUserRightsDto;
import gov.ifms.edp.dto.MinisterUserReqDto;
import gov.ifms.edp.employe.EDPEmployeDto;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.service.EDPMsUserService;

/**
 * The Class EDPMsUserController.
 * 
 * @version 1.0.
 * @created 2019/08/29 15:19:32.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsUserController {

	/** The service. */
	@Autowired
	private EDPMsUserService service;

	/** The converter. */
	@Trace
	@Autowired
	private EDPMsUserConverter converter;

	/**
	 * Fetch MsUsers by given MsUsers id.
	 *
	 * @param id the id
	 * @return dto
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMsUser(@RequestBody IdDto id) {
		EDPMsUserEntity entity = service.getMsUser(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, this.converter.toDTO(entity));

	}

	/**
	 * creates a new MsUsers.
	 *
	 * @param dto the dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsUser(@RequestBody EDPMsUserDto dto) {

		EDPMsUserEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsUser(entity)));

	}

	/**
	 * Update the MsUsers.
	 *
	 * @param dto the dto
	 * @return the updated entity in dto type
	 */
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsUser(@RequestBody EDPMsUserDto dto) {

		EDPMsUserEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsUser(entity)));
	}

	/**
	 * Fetch all the MsUsers items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsUserDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsUsers(@RequestBody PageDetails pageDetail) {
		PagebleDTO<EDPMsUserDto> data = service.edpMsUserAsMethodNameSearch(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, data);
	}

	/**
	 * Gets the dependent user ids.
	 *
	 * @return the dependent user ids
	 */
	@Trace
	@PostMapping(URLConstant.GET_DEPENDENT_USER)
	public ResponseEntity<ApiResponse> getDependentUserIds() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				service.getDependentUerIdByUserId(OAuthUtility.getCurrentUserUserId()));
	}

	/**
	 * Gets the ms users by post id.
	 *
	 * @param id the id
	 * @return the ms users by post id
	 */
	@Trace
	@PostMapping(URLConstant.GET_BY_POST_ID)
	public ResponseEntity<ApiResponse> getMsUsersByPostId(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				converter.toDTO(service.getMsUserByPostId(id.getId())));
	}

	/**
	 * Gets the id code.
	 *
	 * @return the id code
	 */
	@Trace
	@PostMapping(URLConstant.URL_ALL_ESTIMATION_FOR)
	public ResponseEntity<ApiResponse> getIdCode() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getAllCodeAndId());
	}

	/**
	 * Gets the ms users by post id.
	 *
	 * @param clueDto the clue dto
	 * @return the ms users by post id
	 */
	@Trace
	@PostMapping(URLConstant.GET_BY_USER_CODE)
	public ResponseEntity<ApiResponse> getMsUsersByPostId(@RequestBody ClueDto clueDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,
				converter.toDTO(service.findUserByUserCode(clueDto.getId())));
	}

	/**
	 * Gets the employeefor global password.
	 *
	 * @param dto the dto
	 * @return the employeefor global password
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL_EMPLOYEE_GLOBAL)
	public ResponseEntity<ApiResponse> getEmployeeforGlobalPassword(@RequestBody ClueDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				service.findAllUsersforGloblePassword(dto.getId()));
	}

	/**
	 * Gets the employeefor reset password.
	 *
	 * @param dto the dto
	 * @return the employeefor reset password
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL_EMPLOYEE_RESET)
	public ResponseEntity<ApiResponse> getEmployeeforResetPassword(@RequestBody ClueDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				service.findUserforResetpwd(dto.getId()));
	}

	/**
	 * Reset password.
	 *
	 * @param fieldDto the field dto
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_RESET)
	public ResponseEntity<ApiResponse> resetPassword(@RequestBody FieldDto fieldDto) {
		try {
			if (service.resetPassword(fieldDto, Boolean.TRUE)) {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_RESET_PASSWORD, Boolean.TRUE);
			} else {
				return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, MsgConstant.RECORD_NOT_FOUND,
						Boolean.FALSE);
			}
		} catch (CustomException e) {
			return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, MsgConstant.RECORD_NOT_FOUND,
					Boolean.FALSE);
		}
	}

	/**
	 * Globle password.
	 *
	 * @param fieldDto the field dto
	 * @return the response entity
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_GLOBLE)
	public ResponseEntity<ApiResponse> globlePassword(@RequestBody FieldDto fieldDto) {
		try {
			if (service.resetPassword(fieldDto, Boolean.FALSE)) {
				return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_RESET_PASSWORD, Boolean.TRUE);
			} else {
				return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, MsgConstant.RECORD_NOT_FOUND,
						Boolean.FALSE);
			}
		} catch (CustomException e) {
			return ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR, MsgConstant.RECORD_NOT_FOUND,
					Boolean.FALSE);
		}
	}

	/**
	 * Added by Shaunak for User Role Mapping Screen Gets the ms Employees &
	 * employees by post id.
	 *
	 * @param employeeNo the employee no
	 * @return the ms users by post id
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.GET_EMPLOYEES_BY_EMP_NO)
	public ResponseEntity<ApiResponse> getMsEmployeesByPostId(@RequestBody EDPEmployeDto employeeNo)
			throws CustomException {
		List<EDPEmployeePostSearchView> list = service.getEdpEmployeePostByEmpNo(employeeNo.getEmpId(),
				employeeNo.getOfficeId());
		if (!list.isEmpty()) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, list);
		} else {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.RECORD_NOT_FOUND, null);
		}

	}

	/**
	 * Gets the user rights by post officer user id.
	 *
	 * @param postofficeId the postoffice id
	 * @return the user rights by post officer user id
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.GET_USER_RIGHTS_BY_POST_OFFICE_USER)
	public ResponseEntity<ApiResponse> getUserRightsByPostOfficerUserId(@RequestBody IdDto postofficeId)
			throws CustomException {
		if(null != postofficeId.getId()) {
			service.checkHasExistingRightsMappingRequest(postofficeId.getId());		
			return ResponseUtil.getResponse(HttpStatus.OK, "");
		} else {
		throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}

	/**
	 * Gets the user photo with user id.
	 *
	 * @param userCode the user code
	 * @return the user photo with user id
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_USER_PHOTO_BY_USER_CODE)
	public ResponseEntity<ApiResponse> getUserPhotoWithUserId(@RequestBody IdDto userCode) throws CustomException {
		try {
			ClueDto clueDto = service.getUserPhotoByUserId(userCode.getId());
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, clueDto);
		} catch (Exception ex) {
			return ResponseUtil.getResponse(HttpStatus.OK, ErrorResponse.ERROR_WHILE_DOWNLOAD.getMessage());
		}
	}

	/*
	 * Approved User Rights By Post Office User Id
	 */
	@Trace
	@PostMapping(URLConstant.GET_APPROVED_USER_RIGHTS_BY_POST_OFFICE_USER)
	public ResponseEntity<ApiResponse> getApprovedUserRightsByPostOfficerUserId(@RequestBody IdDto id)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getUserRights(id.getId()));
	}

	/*
	 * Saved User Rights By Post Office User Id
	 */

	@Trace
	@PostMapping(URLConstant.GET_SAVED_USER_RIGHTS_BY_POST_OFFICE_USER)
	public ResponseEntity<ApiResponse> getSavedUserRightsByPostOfficerUserId(@RequestBody IdDto postofficeId)
			throws CustomException {
		List<EDPUserRightsDto> userRights = service.getSavedUserRights(postofficeId.getId(), Boolean.TRUE);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_UN_APPROVED_RECORD, userRights);
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_MINISTER_INCHARGE)
	public ResponseEntity<ApiResponse> getMininsterUser(@RequestBody MinisterUserReqDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH, service.getMinisterWfUser(dto));
	}
}
