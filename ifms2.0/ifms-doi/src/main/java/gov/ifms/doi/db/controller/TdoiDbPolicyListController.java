package gov.ifms.doi.db.controller;

import gov.ifms.doi.db.dto.TdoiDbClaimEntryDTO;
import gov.ifms.doi.db.service.TdoiDbClaimEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.db.dto.TdoiDbPolicyListDTO;
import gov.ifms.doi.db.service.TdoiDbPolicyListService;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.*;


@RestController
@RequestMapping(DOI_JPA_DB_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TdoiDbPolicyListController{

	@Autowired
	TdoiDbPolicyListService service;

	@Autowired
	TdoiDbClaimEntryService tdoiDbClaimEntryService;


	@Trace
	@PostMapping(value =DOI_JPA_DB_POLICYLIST_ENTRY , produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> saveOrUpdate(@RequestBody TdoiDbPolicyListDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdate(dto));
	}


	@Trace
	@PostMapping(value = DOI_JPA_DB_POLICYLIST_LISTING, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAll(@RequestBody TdoiDbPolicyListDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByCriteria(dto));
	}


	@Trace
	@DeleteMapping(value = DOI_JPA_DB_POLICYLIST_DELETE, produces = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> softDeleteById(@RequestParam(name = "id") Long id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_DELETE, service.softDeleteById(id));
	}


	@Trace
	@PostMapping(value = DOI_JPA_DB_POLICYLIST_LISTING_BY_STATUS, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllByStatus(@RequestBody TdoiDbPolicyListDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, service.findAllByStatus(dto));
	}

	@Trace
	@GetMapping(value = TDOI_DB_POLICY_LISTING, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> getAllPolicies() {
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Fetched", tdoiDbClaimEntryService.fetchClaims());
	}

	@Trace
	@PostMapping(value = TDOI_DB_ADD_CLAIM, produces = CONTENT_TYPE_APP_JSON, consumes = CONTENT_TYPE_APP_JSON)
	public ResponseEntity<ApiResponse> addClaim(@RequestBody TdoiDbClaimEntryDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, "Data Added", tdoiDbClaimEntryService.addClaim(dto));
	}

}

