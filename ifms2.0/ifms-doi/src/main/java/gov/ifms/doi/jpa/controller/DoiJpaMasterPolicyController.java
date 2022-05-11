package gov.ifms.doi.jpa.controller;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.CONTENT_TYPE_APP_JSON;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_SCHEME_MASTER_POLICY_DELETE;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_SCHEME_MASTER_POLICY_ENTRY;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_SCHEME_MASTER_POLICY_LISTING;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_SCHEME_MASTER_POLICY_LISTING_BY_SCHEME_ID;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_SCHEME_MASTER_POLICY_TYPES;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_SCHEME_MASTER_STATUS;

import java.util.List;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_SCHEME_MASTER_POLICY_LIST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.jpa.dto.DoiJpaMasterPolicyDTO;
import gov.ifms.doi.jpa.pagination.PageDetails;
import gov.ifms.doi.jpa.service.DoiJPAMasterPolicyService;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@RestController
public class DoiJpaMasterPolicyController {

	@Autowired
	DoiJPAMasterPolicyService doiJPAMasterPolicyService;

	/**
	 * creates a new scheme
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(value = JPA_SCHEME_MASTER_POLICY_ENTRY, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> saveOrUpdateMasterPolicy(@RequestBody List<DoiJpaMasterPolicyDTO> dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, "Record added Successfully",
				doiJPAMasterPolicyService.saveOrUpdate(dto));
	}

	@Trace
	@PostMapping(value = JPA_SCHEME_MASTER_POLICY_LISTING, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllActiveMasterPolicy(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiJPAMasterPolicyService.getJpaPolicyMasterPage(pageDetail));
	}
	


	@Trace
	@DeleteMapping(value = JPA_SCHEME_MASTER_POLICY_DELETE, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> deleteMasterPolicy(@RequestParam(name = "pathVariable") Long id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE,
				doiJPAMasterPolicyService.deleteByPolicyId(id));
	}

	@Trace
	@GetMapping(value = JPA_SCHEME_MASTER_POLICY_LISTING_BY_SCHEME_ID, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> findBySchemeId(@RequestParam(name = "pathVariable") Long id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiJPAMasterPolicyService.findBySchemeId(id));
	}
	
	@Trace
	@GetMapping(value = JPA_SCHEME_MASTER_POLICY_LIST, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllSchemes() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiJPAMasterPolicyService.getAllSchemes());
	}
	
	@Trace
	@GetMapping(value = JPA_SCHEME_MASTER_POLICY_TYPES, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getPolicyTypes() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiJPAMasterPolicyService.getAllPolicyTypes());
	}
	
	@Trace
	@GetMapping(value = JPA_SCHEME_MASTER_STATUS, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllStatus() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiJPAMasterPolicyService.getAllStatus());
	}
}
