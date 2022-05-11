package gov.ifms.doi.workflow.controller;

import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_LEGAL_ENTERY_WF_ENTRY;
import static gov.ifms.doi.jpa.constant.DoiJPAUrlConstants.JPA_LEGAL_ENTERY_WF_ENTRY_LISTING;

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
import gov.ifms.doi.workflow.dto.DOIJpaLegalEntryWFDTO;
import gov.ifms.doi.workflow.service.DoiJPALegalEntryWFService;

/**
 * 
 * @author Rudra
 *
 */
@RestController
public class DoiJpaLegalEntryWFController {

	@Autowired
	DoiJPALegalEntryWFService doiJPALegalEntryWFService;

	/**
	 * creates a new scheme
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(value = JPA_LEGAL_ENTERY_WF_ENTRY, produces = "application/json", consumes = "application/json")
	public ResponseEntity<ApiResponse> saveOrUpdateClaimEntryWF(@RequestBody DOIJpaLegalEntryWFDTO dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, doiJPALegalEntryWFService.saveOrUpdate(dto));
	}

	@Trace
	@GetMapping(JPA_LEGAL_ENTERY_WF_ENTRY_LISTING)
	public ResponseEntity<ApiResponse> getAllActiveClaimEntryWF() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, doiJPALegalEntryWFService.findAll());
	}
}
