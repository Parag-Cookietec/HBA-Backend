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
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMOGOILoanPostDto;
import gov.ifms.dmo.dto.DMOGOILoanRePaymentDto;
import gov.ifms.dmo.dto.DMOGOISearchDto;
import gov.ifms.dmo.service.DMOGOILoanRePaymentService;
import gov.ifms.dmo.utils.DMOURLConstant;

/**
 * The Class DMONSSFLoanRepaymentScheduleController.
 * 
 * @version v 2.0.
 * @created 2021/07/20 10:19:32
 *
 */

@RestController
@RequestMapping(DMOURLConstant.GOI_LOAN_REPAYMENT_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMOGOILoanRepaymentScheduleController {

	
	@Autowired
	DMOGOILoanRePaymentService service;
	
	/**
	 * creates a new GOI Loan Received
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 * @throws CustomException 
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_POST)
	public ResponseEntity<ApiResponse> saveOrUpdateRepayment(@RequestBody DMOGOILoanPostDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.NSFF_LOAN_RECEIVED_MSG_CREATE, service.save(dto));
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateRepayment(@RequestBody DMOGOILoanRePaymentDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.NSFF_LOAN_RECEIVED_MSG_CREATE, service.update(dto));
	}
	
	/**
	 * Gets the GOI Loan Repayments Schedule.
	 *
	 * @param pageDetail the page detail
	 * @return the GOI Loan Repayments List
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> findAll(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST,  service.findAll(pageDetail));
	}
	
	/**
	 * GET GOI Loan Received Repayments Schedule Id
	 * 
	 * @param id
	 * @return fetch newly created entity in dto type
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> findById(@RequestBody IdDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH, service.findById(dto.getId()));
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_MATCH_WITH_PAYABLE)
	public ResponseEntity<ApiResponse> matchWithPayable(@RequestBody DMOGOISearchDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH, service.matchWithPayable(dto));
	}
}
