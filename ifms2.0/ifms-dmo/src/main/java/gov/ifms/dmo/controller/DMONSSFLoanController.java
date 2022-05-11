package gov.ifms.dmo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.SerachApprovedDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMOGOISearchDto;
import gov.ifms.dmo.dto.DMONSSFLoanHDRRespDto;
import gov.ifms.dmo.dto.DMONSSFLoanPostDto;
import gov.ifms.dmo.service.DMONSSFLoanService;
import gov.ifms.dmo.utils.DMOURLConstant;

/**
 * The Class DMONSSFLoanController.
 * 
 * @version v 2.0.
 * @created 2021/07/13 15:19:32
 *
 */

@RestController
@RequestMapping(DMOURLConstant.NSSF_LOAN_RECEIVED_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMONSSFLoanController {

	
	@Autowired
	DMONSSFLoanService service;
	
	/**
	 * creates a new NSSF Loan Received
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_POST)
	public ResponseEntity<ApiResponse> saveOrUpdateNSSFLoanReceived(@RequestBody DMONSSFLoanPostDto dto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.NSFF_LOAN_RECEIVED_MSG_CREATE, service.saveOrUpdateNSSFLoanReceived(dto));
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateNSSFLoanReceived(@RequestBody DMONSSFLoanPostDto dto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.NSFF_LOAN_RECEIVED_MSG_CREATE, service.updateNSSFLoanReceived(dto));
	}
	/**
	 * GET NSSF Loan Received By Id
	 * 
	 * @param id
	 * @return fetch newly created entity in dto type
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getNSSFLoanReceived(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.NSFF_LOAN_RECEIVED_MSG, service.getNSSFLoanReceived(idDto.getId()));
	}
	
	/**
	 * Gets the NSSF Loan Received.
	 *
	 * @param pageDetail the page detail
	 * @return the NSSF Loan Received
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getNSSFLoanApprovedList(@RequestBody SerachApprovedDto pageDetail) throws CustomException {
		PagebleDTO<DMONSSFLoanHDRRespDto> data = service.getNSSFLoanApprovedList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GRFCRF_FETCH_DROP_DOWN_LIST, data);
	}
	
	/**
	 * Gets All Repayments by nssfId
	 *
	 * @param pageDetail the page detail
	 * @return the NSSF Loan Received
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL_REPAYMENTS)
	public ResponseEntity<ApiResponse> getAllRepayments(@RequestBody SerachApprovedDto pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST, service.getAllRepayments(pageDetail));
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_SEARCH_REPAY_GOI)
	public ResponseEntity<ApiResponse> search(@RequestBody DMOGOISearchDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST, service.searchRepay(dto));
	}
	
}
