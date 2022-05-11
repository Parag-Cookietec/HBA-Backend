package gov.ifms.gst.controller;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.gst.pagination.PageDetails;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.gst.dto.GSTChallanAccountingListingDTO;
import gov.ifms.gst.dto.ReconcileDetailsDto;
import gov.ifms.gst.service.ChallanAccountingService;
import gov.ifms.gst.util.GstMessageConstant;
import gov.ifms.gst.util.GstURLConstant;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(GstURLConstant.URL_CHALLAN_ACCT_BASEURL)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChallanAccountingController {

	@Autowired
	private ChallanAccountingService service;

	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getChallanList(@RequestBody PageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, service.getChallanList(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getById(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, service.getById(idDto.getId()));
	}

	@Trace
	@PostMapping(GstURLConstant.URL_RECONCILE_DETAILS)
	public ResponseEntity<ApiResponse> getReconcileDetails(@RequestBody IdDto idDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH, service.getReconcileDetails(idDto.getId()));
	}

	@Trace
	@PostMapping(GstURLConstant.URL_POST_SUBMIT)
	public ResponseEntity<ApiResponse> submitReconciliation(@RequestBody ReconcileDetailsDto dto) {
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_CREATE, service.saveOrUpdate(dto));
	}
	
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL+URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getChallanAccountingListing(@RequestBody PageDetails pageDetail) throws CustomException, ParseException {
		PagebleDTO<GSTChallanAccountingListingDTO> data = service.getChallanAccountingListing(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, GstMessageConstant.GST_MSG_FETCH_LIST, data);
	}
	
}
