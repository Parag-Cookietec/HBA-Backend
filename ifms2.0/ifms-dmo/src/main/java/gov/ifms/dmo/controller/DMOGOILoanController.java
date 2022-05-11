package gov.ifms.dmo.controller;

import java.util.List;

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
import gov.ifms.dmo.dto.DMOGOILoanPostDto;
import gov.ifms.dmo.dto.DMOGOISearchDto;
import gov.ifms.dmo.service.DMOGOILoanService;
import gov.ifms.dmo.utils.DMOURLConstant;

/**
 * The Class DMOGOILoanController.
 * 
 * @version v 2.0.
 * @created 2021/07/13 15:19:32
 *
 */

@RestController
@RequestMapping(DMOURLConstant.GOI_LOAN_RECEIVED_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMOGOILoanController {

	
	@Autowired
	DMOGOILoanService service;
	
	/**
	 * creates a new GOI Loan Received
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_POST)
	public ResponseEntity<ApiResponse> saveOrUpdateGOILoanReceived(@RequestBody DMOGOILoanPostDto dto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GOI_LOAN_RECEIVED_MSG_CREATE, service.saveOrUpdateGOILoanReceived(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateGOILoanReceived(@RequestBody DMOGOILoanPostDto dto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GOI_LOAN_RECEIVED_MSG_CREATE, service.updateGOILoanReceived(dto));
	}
	
	/**
	 * GET GOI Loan Received By Id
	 * 
	 * @param id
	 * @return fetch newly created entity in dto type
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getGOILoanReceived(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.GOI_LOAN_RECEIVED_MSG, service.getGOILoanReceived(idDto.getId()));
	}
	
	/**
	 * Gets the GOI Loan Received.
	 *
	 * @param pageDetail the page detail
	 * @return the GOI Loan Received
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getGOILoanApprovedList(@RequestBody SerachApprovedDto pageDetail) throws CustomException {
		List<DMOGOILoanPostDto> data = service.getGOILoanApprovedList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST, data);
	}
	
	/**
	 * Gets All Repayments by goiId
	 *
	 * @param pageDetail the page detail
	 * @return the GOI Loan Received
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL_REPAYMENTS)
	public ResponseEntity<ApiResponse> getAllRepayments(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST, service.getAllRepayments(idDto.getId()));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_DELETE_GOI)
	public ResponseEntity<ApiResponse> deleteGoi(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST, service.deleteGoi(idDto.getId()));
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_SEARCH_GOI)
	public ResponseEntity<ApiResponse> search(@RequestBody DMOGOISearchDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST, service.search(dto));
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_SEARCH_REPAY_GOI)
	public ResponseEntity<ApiResponse> searchRepay(@RequestBody DMOGOISearchDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST, service.searchRepay(dto));
	}
	
	
}
