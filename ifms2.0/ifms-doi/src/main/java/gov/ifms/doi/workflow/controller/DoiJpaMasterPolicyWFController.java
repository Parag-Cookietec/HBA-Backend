package gov.ifms.doi.workflow.controller;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_SCHEME_MASTER_POLICY_WF_ENTRY;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_SCHEME_MASTER_POLICY_WF_ENTRY_LISTING;

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
import gov.ifms.doi.workflow.dto.DoiJpaMasterPolicyWFDTO;
import gov.ifms.doi.workflow.service.DoiJPAMasterPolicyWFService;

/**
 * 
 * @author Sagar Jadhav
 *
 */
@RestController
public class DoiJpaMasterPolicyWFController {

	@Autowired
	DoiJPAMasterPolicyWFService doiJPAMasterPolicyService;

	/**
	 * creates a new scheme
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(value = JPA_SCHEME_MASTER_POLICY_WF_ENTRY, produces = "application/json", consumes = "application/json")
	public ResponseEntity<ApiResponse> saveOrUpdateMasterPolicy(@RequestBody DoiJpaMasterPolicyWFDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG,
				doiJPAMasterPolicyService.saveOrUpdate(dto));
	}

	@Trace
	@GetMapping(JPA_SCHEME_MASTER_POLICY_WF_ENTRY_LISTING)
	public ResponseEntity<ApiResponse> getAllActiveMasterPolicyWF() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH,
				doiJPAMasterPolicyService.findAll());
	}

}
