package gov.ifms.doi.workflow.controller;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.COINS_POLICY_ENTERY_WF_ENTRY;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.COINS_POLICY_ENTERY_WF_ENTRY_LISTING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.doi.workflow.dto.DoiCoinsPolicyHdrWfDTO;
import gov.ifms.doi.workflow.service.DoiCoinsPolicyEntryWFService;

/**
 * 
 * @author Rudra
 *
 */
@RestController
public class DoiCoinsPolicyEntryWFController {

	@Autowired
	DoiCoinsPolicyEntryWFService doiCoinsPolicyEntryWFService;

	/**
	 * creates a new scheme
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(value = COINS_POLICY_ENTERY_WF_ENTRY, produces = "application/json", consumes = "application/json")
	public ResponseEntity<ApiResponse> saveOrUpdateClaimEntryWF(@RequestBody DoiCoinsPolicyHdrWfDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, doiCoinsPolicyEntryWFService.saveOrUpdate(dto));
	}

	@Trace
	@GetMapping(COINS_POLICY_ENTERY_WF_ENTRY_LISTING)
	public ResponseEntity<ApiResponse> getAllActiveClaimEntryWF() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, doiCoinsPolicyEntryWFService.findAll());
	}

}
