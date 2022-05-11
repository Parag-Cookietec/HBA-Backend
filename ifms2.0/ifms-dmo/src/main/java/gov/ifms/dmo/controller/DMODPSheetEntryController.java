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
import gov.ifms.dmo.dto.DMODPDateSearchDto;
import gov.ifms.dmo.dto.DMODPSheetHDREntryPostDto;
import gov.ifms.dmo.service.DMODPSheetEntryService;
import gov.ifms.dmo.utils.DMOURLConstant;

/**
 * The Class DMODPSheetEntryController.
 * 
 * @version v 2.0.
 * @created 2021/07/10 15:19:32
 *
 */

@RestController
@RequestMapping(DMOURLConstant.DMO_DP_SHEET_BASE_URL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMODPSheetEntryController {

	@Autowired
	DMODPSheetEntryService service;
	
	/**
	 * creates a DP Sheet Entry Record
	 * 
	 * @param dto
	 * @return newly created entity in dto type
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_POST)
	public ResponseEntity<ApiResponse> saveOrUpdateNSSFLoanReceived(@RequestBody DMODPSheetHDREntryPostDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DPSHEET_CREATE_MSG, service.saveOrUpdateDPSheet(dto));
	}
	

	/**
	 * DP Sheet Listing.
	 *
	 * @param pageDetail the page detail
	 * @return List<> include DP sheet listing
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> dpSheetListing(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.dpSheetListing(pageDetail));
	}

	/**
	 * DP Sheet Listing.
	 *
	 * @param pageDetail the page detail
	 * @return List<> include DP sheet listing
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(DMOURLConstant.GOI_LOAN_DP_SHEET_BASE_URL)
	public ResponseEntity<ApiResponse> dpSheetListingGoi(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.dpSheetListingGoi(pageDetail));
	}
	@Trace
	@PostMapping(DMOURLConstant.NSSF_LOAN_DP_SHEET_BASE_URL)
	public ResponseEntity<ApiResponse> dpSheetListingNssf(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.dpSheetListingNssf(pageDetail));
	}
	@Trace
	@PostMapping(DMOURLConstant.MARKET_LOAN_DP_SHEET_BASE_URL)
	public ResponseEntity<ApiResponse> dpSheetListingMarket(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.dpSheetListingMarket(pageDetail));
	}
	@Trace
	@PostMapping(DMOURLConstant.INSTITUTIONAL_LOAN_DP_SHEET_BASE_URL)
	public ResponseEntity<ApiResponse> dpSheetListingInstitute(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.dpSheetListingInstitute(pageDetail));
	}

	
	/**
	 * GET DP Sheet By Id
	 * 
	 * @param id
	 * @return fetch newly created entity in dto type
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getDPSheetById(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_GET_MSG, service.findById(idDto.getId()));
	}
	
	/**
	 * DP Sheet Listing.
	 *
	 * @param pageDetail the page detail
	 * @return List<> include DP sheet listing
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(DMOURLConstant.URL_SEARCH_DATE)
	public ResponseEntity<ApiResponse> searchByDate(@RequestBody DMODPDateSearchDto dateSearchDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.searchByDate(dateSearchDto));
	}
	
	
	
}



