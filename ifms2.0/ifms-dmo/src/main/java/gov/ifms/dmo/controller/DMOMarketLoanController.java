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
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMOGOISearchDto;
import gov.ifms.dmo.dto.DMOMarketLoanDto;
import gov.ifms.dmo.service.DMOMarketLoanService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.MARKET_LOAN_RECEIVED_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMOMarketLoanController {

	@Autowired
	DMOMarketLoanService service;
	
	/**
	 * creates a new Market Loan Received
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_POST)
	public ResponseEntity<ApiResponse> saveOrUpdateMarketLoan(@RequestBody DMOMarketLoanDto dto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.MARKET_LOAN_RECEIVED_MSG_CREATE, service.saveOrUpdate(dto));
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_PUT_BY_ID)
	public ResponseEntity<ApiResponse> updateMarketLoanReceived(@RequestBody DMOMarketLoanDto dto) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.MARKET_LOAN_RECEIVED_MSG_CREATE, service.updateMarketLoanReceived(dto));
	}
	/**
	 * GET new Market Loan Received By Id
	 * 
	 * @param id
	 * @return fetch newly created entity in dto type
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getMarketLoanReceived(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.MARKET_LOAN_RECEIVED_MSG, service.getMarketLoanReceived(idDto.getId()));
	}
	
	/**
	 * Gets the Market Loan Received.
	 *
	 * @param pageDetail the page detail
	 * @return the Market Loan Received
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL_LIST)
	public ResponseEntity<ApiResponse> getMarketLoanList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST, service.findAll(pageDetail));
	}
	
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getApprovedList(@RequestBody SerachApprovedDto pageDetail) throws CustomException {
		List<DMOMarketLoanDto> data = service.getApprovedList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST, data);
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL_REPAYMENTS)
	public ResponseEntity<ApiResponse> getAllRepayments(@RequestBody SerachApprovedDto pageDetail) throws CustomException{
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST, service.getAllRepayments(pageDetail));
	}
	@Trace
	@PostMapping(DMOURLConstant.URL_SEARCH_REPAY_GOI)
	public ResponseEntity<ApiResponse> search(@RequestBody DMOGOISearchDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST, service.searchRepay(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_SEARCH_GOI)
	public ResponseEntity<ApiResponse> searchMarket(@RequestBody DMOGOISearchDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST, service.searchMarket(dto));
	}
}
