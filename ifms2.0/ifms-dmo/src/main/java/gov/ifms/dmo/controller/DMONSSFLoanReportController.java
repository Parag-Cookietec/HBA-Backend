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
import gov.ifms.dmo.dto.DMONSSFLoanReportSearchDto;
import gov.ifms.dmo.service.impl.DMONSSFLoanReportService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.URL_DMO_NSSF_REPORT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMONSSFLoanReportController {
	@Autowired
	DMONSSFLoanReportService service;
	
	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_NSSF_RECEIPT_REPORT)
	public ResponseEntity<ApiResponse> nssfReceiptReport(@RequestBody DMONSSFLoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.nssfReceiptReport(pageDetail));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_NSSF_MONTHLY_RECEIPT_REPORT)
	public ResponseEntity<ApiResponse> nssfMonthlyReceipt(@RequestBody DMONSSFLoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.nssfMonthlyReceipt(pageDetail));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_NSSF_OUTSTANDING_REPORT)
	public ResponseEntity<ApiResponse> nssfOutstanding(@RequestBody DMONSSFLoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.nssfOutstanding(pageDetail));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_NSSF_REPAID_YEARLY_REPORT)
	public ResponseEntity<ApiResponse> nssfRepaidYearly(@RequestBody DMONSSFLoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.nssfRepaidYearly(pageDetail));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_NSSF_REPAID_MONTHLY_REPORT)
	public ResponseEntity<ApiResponse> nssfRepaidMonthly(@RequestBody DMONSSFLoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.nssfRepaidMonthly(pageDetail));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_NSSF_REPAID_DATE_WISE_REPORT)
	public ResponseEntity<ApiResponse> nssfRepaidDateWise(@RequestBody DMONSSFLoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.nssfRepaidDateWise(pageDetail));
	}

}
