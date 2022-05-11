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
import gov.ifms.dmo.dto.DMOMarketLoanReportSearchDto;
import gov.ifms.dmo.service.impl.DMOMarketLoanReportService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.URL_DMO_MARKET_REPORT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMOMarketLoanReportController {
	@Autowired
	DMOMarketLoanReportService service;
	
	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_MARKET_RECEIPT_REPORT)
	public ResponseEntity<ApiResponse> marketReceiptReport(@RequestBody DMOMarketLoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.marketReceiptReport(pageDetail));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_MARKET_MONTHLY_RECEIPT_REPORT)
	public ResponseEntity<ApiResponse> marketMonthlyReceipt(@RequestBody DMOMarketLoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.marketMonthlyReceipt(pageDetail));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_MARKET_REPAID_YEARLY_REPORT)
	public ResponseEntity<ApiResponse> nssfRepaidYearly(@RequestBody DMOMarketLoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.marketRepaidYearly(pageDetail));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_MARKET_REPAID_MONTHLY_REPORT)
	public ResponseEntity<ApiResponse> nssfRepaidMonthly(@RequestBody DMOMarketLoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.marketRepaidMonthly(pageDetail));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_MARKET_REPAID_DATE_WISE_REPORT)
	public ResponseEntity<ApiResponse> nssfRepaidDateWise(@RequestBody DMOMarketLoanReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.marketRepaidDateWise(pageDetail));
	}
}
