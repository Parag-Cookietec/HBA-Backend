package gov.ifms.edp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPMsDepartmentConverter;
import gov.ifms.edp.dto.EDPMsDepartmentDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.service.EDPMsDepartmentService;

/**
 * The Class EDPMsDepartmentController.
 * 
 * @version 1.0.
 * @created 2019/08/29 15:05:35.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_DEPARTMENT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsDepartmentController {


	/** The service. */
	@Autowired
	private EDPMsDepartmentService service;

	/** The converter. */
	@Trace
	@Autowired
	private EDPMsDepartmentConverter converter;
	
	
	/**
	 * creates a new MsDepartments
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createMsDepartment(@RequestBody EDPMsDepartmentDto dto) {

		EDPMsDepartmentEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse( HttpStatus.OK, MsgConstant.EDP_MSG_CREATE,
				converter.toDTO(service.saveOrUpdateMsDepartment(entity)));

	}

	/**
	 * Update the MsDepartments
	 * 
	 * @param dto
	 * @return the updated entity in dto type
	 */
	@Trace
	@PostMapping(URLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMsDepartment(@RequestBody EDPMsDepartmentDto dto) {

		EDPMsDepartmentEntity entity = converter.toEntity(dto);
		return ResponseUtil.getResponse( HttpStatus.OK, MsgConstant.EDP_MSG_UPDATE,
				converter.toDTO(service.saveOrUpdateMsDepartment(entity)));
	}

	
	/**
	 * Fetch all the MsDepartments items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsDepartmentDto>
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsDepartment(@RequestBody PageDetails pageDetail) {
		PagebleDTO<EDPMsDepartmentDto> data = service.edpMsDepartmentAsMethodNameSearch(pageDetail);
		return  ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,data);
	}
	
	/**
	 * Gets the ms department by user id.
	 *
	 * @return the ms department by user id
	 * @throws CustomException 
	 */
	@Trace
	@PostMapping(URLConstant.GET_BY_USER_ID)
	public ResponseEntity<ApiResponse> getMsDepartmentByUserId() throws CustomException {
		EDPMsPostDto eDPMsPostDto = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
		return  ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				service.getDepartmentByPostId(eDPMsPostDto.getPostId()));
	}

	/**
	 * Gets the dept by office type id.
	 *
	 * @param id the id
	 * @return the dept by office type id
	 */
	@Trace
	@PostMapping(URLConstant.GET_OFFICE_TYPE)
	public ResponseEntity<ApiResponse> getDeptByOfficeTypeId(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST,
				converter.toDTO(service.findByOfficeTypeId(id.getId())));
	}
	
	/**
	 * Gets the all department.
	 *
	 * @return the all department
	 */
	@Trace
	@PostMapping(URLConstant.URL_ALL_DEPARTMENT)
	public ResponseEntity<ApiResponse> getAllDepartment() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH_LIST, service.getAllCodeAndId());
	}
}
