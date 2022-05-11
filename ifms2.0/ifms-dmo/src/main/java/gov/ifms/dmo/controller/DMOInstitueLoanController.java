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
import gov.ifms.common.exception.ResourceNotFoundException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMOInstitutionalLoanDto;
import gov.ifms.dmo.service.impl.DMOInstituteLoanService;
import gov.ifms.dmo.utils.DMOURLConstant;

/**
 * The Class DMOInstitueLoanController.
 * 
 * @version v 2.0.
 * @created 2021/07/13 15:19:32
 *
 */

@RestController
@RequestMapping(DMOURLConstant.INSTITUTIONAL_LOAN_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMOInstitueLoanController {

	@Autowired
	private DMOInstituteLoanService service;
	
	@Trace
	@PostMapping(DMOURLConstant.URL_POST)
	public ResponseEntity<ApiResponse> save(@RequestBody DMOInstitutionalLoanDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG_CREATE, service.save(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> update(@RequestBody DMOInstitutionalLoanDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG_CREATE, service.update(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_UPDATE_LETTER)
	public ResponseEntity<ApiResponse> updateLetter(@RequestBody SerachApprovedDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG_CREATE, service.updateLetter(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getById(@RequestBody IdDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG, service.getById(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getAll() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG, service.getAll());
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL_REF)
	public ResponseEntity<ApiResponse> getAllRef() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG, service.getAllRef());
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_BY_REF)
	public ResponseEntity<ApiResponse> getByRef(@RequestBody SerachApprovedDto dto) throws ResourceNotFoundException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG, service.getByRef(dto));
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_BY_INSTITUTE)
	public ResponseEntity<ApiResponse> getByInstitute(@RequestBody SerachApprovedDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG, service.getByInstitute(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.INSTITUTIONAL_LOAN_APPROVED_BASE_URL)
	public ResponseEntity<ApiResponse> getAllApproved(@RequestBody SerachApprovedDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG, service.getAllApproved(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.REMOVE_LOAN_BASE_URL)
	public ResponseEntity<ApiResponse> removeLoan(@RequestBody SerachApprovedDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG_DELETE, service.removeLoan(dto));
	}
	
	
}
