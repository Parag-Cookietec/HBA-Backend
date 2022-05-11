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
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMOGOILoanReportSearchDto;
import gov.ifms.dmo.service.impl.DMOGOILoanReportService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.URL_DMO_GOI_REPORT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMOGOILoanReportController {
	@Autowired
	DMOGOILoanReportService service;
	
	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_GOI_MINISTRY_REPORT)
	public ResponseEntity<ApiResponse> goiMinistryReport(@RequestBody DMOGOILoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.goiMinistryReport(pageDetail));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_GOI_CENTRAL_REPORT)
	public ResponseEntity<ApiResponse> goiCentralReport(@RequestBody DMOGOILoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.goiCentralReport(pageDetail));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_GOI_SCHEME_WISE_CENTRAL_REPORT)
	public ResponseEntity<ApiResponse> goiSchemeWiseCentralReport(@RequestBody DMOGOILoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.goiSchemeWiseCentralReport(pageDetail));
	}
	
	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_GOI_SCHEME_WISE_CENTRAL_OUTSTANDING_YEARLY_REPORT)
	public ResponseEntity<ApiResponse> goiSchemeWiseCentralOutstandingYearlyReport(@RequestBody DMOGOILoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.getGoiCentralOutstandingYearly(pageDetail));
	}

}
