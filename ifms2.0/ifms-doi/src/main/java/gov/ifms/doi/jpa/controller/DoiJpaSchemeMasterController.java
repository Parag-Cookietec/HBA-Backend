
package gov.ifms.doi.jpa.controller;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.CONTENT_TYPE_APP_JSON;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_SCHEME_MASTER_DELETE;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_SCHEME_MASTER_ENTRY;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_SCHEME_MASTER_LIST;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_SCHEME_MASTER_LISTING;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_SCHEME_MASTER_UPDATE;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.GET_JPA_SCHEME_MASTER;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.jpa.dto.DoiJpaSchemeMasterDTO;
import gov.ifms.doi.jpa.pagination.PageDetails;
import gov.ifms.doi.jpa.service.DoiJPASchemeMasterService;

/**
 * 
 * @author Sagar Patil
 *
 */
@RestController
public class DoiJpaSchemeMasterController {

	@Autowired
	DoiJPASchemeMasterService doiJPASchemeMasterService;

	/**
	 * creates a new scheme
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(value = JPA_SCHEME_MASTER_ENTRY, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> saveOrUpdateJPA(@RequestBody List<DoiJpaSchemeMasterDTO> dto) {
		return ResponseUtil.getResponse(HttpStatus.OK,  "Record added Successfully",
				doiJPASchemeMasterService.saveOrUpdate(dto));
	}

	/**
	 * Fetch all the schemes
	 * 
	 * @param dto
	 * @return all the schemes
	 */
	@Trace
	@GetMapping(value = JPA_SCHEME_MASTER_LIST, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllSchemes() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiJPASchemeMasterService.getAllActiveSchemes());
	}
	@Trace
	@PostMapping(value = JPA_SCHEME_MASTER_LISTING, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllSchemes(@RequestBody PageDetails pageDetails) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiJPASchemeMasterService.getAllActiveSchemes(pageDetails));
	}
	

	@Trace
	@DeleteMapping(value = JPA_SCHEME_MASTER_DELETE, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> softDeleteBySchemeId(@RequestParam(name = "pathVariable") Long pathVariable) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE,
				doiJPASchemeMasterService.softDeleteBySchemeId(pathVariable));
	}

	@Trace
	@PostMapping(value = JPA_SCHEME_MASTER_UPDATE, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> updateSchemeStatusBySchemeId(@RequestBody DoiJpaSchemeMasterDTO dto) {	
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_UPDATE, doiJPASchemeMasterService.updateSchemeStatusBySchemeId(dto.getSchemeId(), dto.getStatus()));
	}
	
	@Trace
	@GetMapping(value = GET_JPA_SCHEME_MASTER, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getSchemeBySchemeId(@PathVariable("schemeId") Long  schemeId) throws CustomException {	
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_UPDATE, doiJPASchemeMasterService.getSchemeBySchemeId(schemeId));
	}
}
