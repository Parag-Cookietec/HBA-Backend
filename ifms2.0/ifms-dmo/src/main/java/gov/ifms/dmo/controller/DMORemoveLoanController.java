package gov.ifms.dmo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.SerachApprovedDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.service.impl.DMORemoveLoanService;
import gov.ifms.dmo.utils.DMOURLConstant;

/**
 * The Class DMOInstitueLoanController.
 * 
 * @version v 2.0.
 * @created 2021/07/13 15:19:32
 *
 */

@RestController
@RequestMapping(DMOURLConstant.DMO_REMOVE_LOAN_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMORemoveLoanController {

	@Autowired
	private DMORemoveLoanService service;
	
	@Trace
	@PostMapping(DMOURLConstant.DELETE_REMOVE_LOAN_BASE_URL)
	public ResponseEntity<ApiResponse> removeLoan(@RequestBody SerachApprovedDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.REMOVE_LOAN_MSG_DELETE, service.removeLoan(dto));
	}
	
	@Trace
	@PostMapping(DMOURLConstant.SEARCH_REMOVE_LOAN_BASE_URL)
	public ResponseEntity<ApiResponse> searchLoan(@RequestBody SerachApprovedDto dto) {
		String message = "";
		if(service.searchLoan(dto).isEmpty()) {
			message = "No data found";
		}else {
			message = "Data for Remove Loan";
		}
		return ResponseUtil.getResponse(HttpStatus.OK, message, service.searchLoan(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.GET_LOAN_DESC_BASE_URL)
	public ResponseEntity<ApiResponse> loanDesc() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GET_REMOVE_LOAN_MSG, service.loanDesc());
	}
	@Trace
	@PostMapping(DMOURLConstant.GET_INSTITUTE_BASE_URL)
	public ResponseEntity<ApiResponse> institute() throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GET_REMOVE_LOAN_MSG, service.institute());
	}
	@Trace
	@PostMapping(DMOURLConstant.GET_TENCHE_BASE_URL)
	public ResponseEntity<ApiResponse> tenche(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GET_REMOVE_LOAN_MSG, service.tenche(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.GET_SANCTION_NO_BASE_URL)
	public ResponseEntity<ApiResponse> sanctionNo() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GET_REMOVE_LOAN_MSG, service.sanctionNo());
	}
	
	
}
