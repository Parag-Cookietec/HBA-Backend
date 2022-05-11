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
import gov.ifms.common.dto.SerachApprovedDto;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMOInstitutionalLoanMemoDto;
import gov.ifms.dmo.service.impl.DMOInstituteLoanMemoService;
import gov.ifms.dmo.utils.DMOURLConstant;

/**
 * The Class DMOGOILoanController.
 * 
 * @version v 2.0.
 * @created 2021/07/13 15:19:32
 *
 */

@RestController
@RequestMapping(DMOURLConstant.INSTITUTIONAL_LOAN_MEMO_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMOInstitueLoanMemoController {

	@Autowired
	private DMOInstituteLoanMemoService service;
	
	@Trace
	@PostMapping(DMOURLConstant.URL_POST)
	public ResponseEntity<ApiResponse> save(@RequestBody DMOInstitutionalLoanMemoDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG_CREATE, service.save(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> update(@RequestBody DMOInstitutionalLoanMemoDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG_UPDATE, service.update(dto));
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_UPDATE_BY_REF)
	public ResponseEntity<ApiResponse> updateByRef(@RequestBody SerachApprovedDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG_UPDATE, service.updateByRef(dto));
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_UPDATE_BY_MEMO)
	public ResponseEntity<ApiResponse> updateByMemo(@RequestBody SerachApprovedDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG_UPDATE, service.updateByMemo(dto));
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_UPDATE_BY_CHEQUE)
	public ResponseEntity<ApiResponse> updateByCheque(@RequestBody SerachApprovedDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG_UPDATE, service.updateByCheque(dto));
	}
	
	@Trace
	@PostMapping(DMOURLConstant.INSTITUTIONAL_DELETE_BASE_URL)
	public ResponseEntity<ApiResponse> update(@RequestBody SerachApprovedDto serachApprovedDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG_DELETE, service.delete(serachApprovedDto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getAll() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG, service.getAll());
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL_MEMO)
	public ResponseEntity<ApiResponse> getAllMemo() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG, service.getAllMemo());
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL_MEMO_DELETE)
	public ResponseEntity<ApiResponse> getAllMemoDelete() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG, service.getAllMemoDelete());
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_BY_MEMO)
	public DMOInstitutionalLoanMemoDto getByMemo(@RequestBody SerachApprovedDto serachApprovedDto) {
		return service.getByMemo(serachApprovedDto);
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL_CHEQUE)
	public ResponseEntity<ApiResponse> getAllCheque() {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG, service.getAllCheque());
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_BY_CHEQUE)
	public ResponseEntity<ApiResponse> getByCheque(@RequestBody SerachApprovedDto serachApprovedDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG, service.getByCheque(serachApprovedDto));
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL_MEMO_REPAY)
	public ResponseEntity<ApiResponse> getByMemoRepay(@RequestBody SerachApprovedDto serachApprovedDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.INSTITUTE_LOAN_RECEIVED_MSG, service.getByMemoRepay(serachApprovedDto));
	}
}
