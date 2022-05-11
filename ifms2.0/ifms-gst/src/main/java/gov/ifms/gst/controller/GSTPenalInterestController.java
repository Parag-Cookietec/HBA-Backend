package gov.ifms.gst.controller;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.pagination.PageDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.dto.ApiResponse;
import gov.ifms.gst.dto.*;
import gov.ifms.gst.service.GSTPenalInterestService;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.gst.dto.GSTBankWisePenalInterestDto;
import gov.ifms.gst.dto.GSTPenalGetClaimAmountParams;
import gov.ifms.gst.dto.GSTPenalInterestDto;
import gov.ifms.gst.dto.GSTPenalInterestSearchDto;
import gov.ifms.gst.service.GSTPenalInterestService;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(GstURLConstant.URL_PENAL_INTEREST_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GSTPenalInterestController {
	

	@Autowired
	private GSTPenalInterestService service;	
	
	/**
	 * Fetch Penal interest of Particular bank for Month and Year
	 * 
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(GstURLConstant.URL_PENAL_INTEREST_GET_BANK_WISE_INTEREST)
	public ResponseEntity<ApiResponse> getBankwisePenalInterestUsingMonthAndYear(@RequestBody GSTPenalGetClaimAmountParams dtoParams) {
		GSTBankWisePenalInterestDto dto = service.getBankwisePenalInterestUsingMonthAndYear(dtoParams.getBankId(),dtoParams.getMonth(),dtoParams.getYear());
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, dto);
	}
	
	/**
	 * Save Penal interest
	 * 
	 * @param GSTPenalInterestDto 
	 * @return dto
	 */
	@Trace
	@PostMapping(GstURLConstant.URL_PENAL_INTEREST_SAVE)
	public ResponseEntity<ApiResponse> savePenalInterest(@RequestBody PenalIntrestEntryDto dtoParams) throws CustomException {
		
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_CREATE, service.savePenalInterest(dtoParams));

	}
	
	/**
	 * Fetch Penal interest of Particular bank for Month and Year
	 * 
	 * @param id
	 * @return dto
	 */
	@Trace
	@PostMapping(GstURLConstant.URL_PENAL_INTEREST_LISTING)
	public ResponseEntity<ApiResponse> listingPenalInterest(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, service.listingPenalInterest(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getById(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, service.getById(idDto.getId()));
	}

	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteById(@RequestBody IdDto idDto) {
		service.deleteById(idDto.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_DELETE, null);
	}

	@Trace
	@PostMapping(GstURLConstant.URL_PENAL_INTEREST_LISTING+URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> searchList(@RequestBody PageDetails pageDetail) throws CustomException {
		PagebleDTO<PenalInterestLstResDto> data = service.getPenalInterestWfList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}
}
