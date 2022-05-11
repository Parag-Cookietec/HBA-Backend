package gov.ifms.dmo.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMOMarketLoanReportSearchDto;
import gov.ifms.dmo.dto.DMONSSFLoanReportSearchDto;
import gov.ifms.dmo.service.impl.DMOMarketLoanReportService;
import gov.ifms.dmo.service.impl.DMONSSFLoanReportService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.URL_DMO_REPORT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMOReportController {
	@Autowired
	DMONSSFLoanReportService dmoNSSFLoanReportService;
	@Autowired
	DMOMarketLoanReportService dmoMarketLoanReportService;
	
	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_NSSF_REPORT_DTL)
	public ResponseEntity<ApiResponse> getDmoNssfReportDetails(
			@RequestParam String reportType,
			@RequestBody DMONSSFLoanReportSearchDto pageDetail) throws CustomException, ParseException {
		return resolveNssfReportTypeAndGetResponse(reportType, pageDetail);
	}
	
	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_MARKET_REPORT_DTL)
	public ResponseEntity<ApiResponse> getDmoMarketReportDetails(
			@RequestParam String reportType,
			@RequestBody DMOMarketLoanReportSearchDto pageDetail) throws CustomException, ParseException {
		return resolveMarketReportTypeAndGetResponse(reportType, pageDetail);
	}
	
	private ResponseEntity<ApiResponse> resolveNssfReportTypeAndGetResponse(final String reportType, final DMONSSFLoanReportSearchDto pageDetail) throws CustomException, ParseException {
		switch(reportType) {
		case "NSSF_OUTSTANDING_YEARLY":
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST,
					dmoNSSFLoanReportService.getNssfLoanOutstandingYearly(pageDetail));
		case "NSSF_OUTSTANDING_MONTHLY":
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST,
					dmoNSSFLoanReportService.getNssfLoanOutstandingMonthly(pageDetail));
		case "NSSF_OUTSTANDING_DATE_WISE":
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST,
					dmoNSSFLoanReportService.nssfOutstandingDateWise(pageDetail));
		default :
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST,
					null);
		}
	}
	
	private ResponseEntity<ApiResponse> resolveMarketReportTypeAndGetResponse(final String reportType, final DMOMarketLoanReportSearchDto pageDetail) throws CustomException, ParseException {
		switch(reportType) {
		case "MARKET_OUTSTANDING_YEARLY":
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST,
					dmoMarketLoanReportService.getMarketLoanOutstandingYearly(pageDetail));
		case "MARKET_OUTSTANDING_MONTHLY":
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST,
					dmoMarketLoanReportService.getMarketLoanOutstandingMonthly(pageDetail));
		case "MARKET_OUTSTANDING_DATE_WISE":
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST,
					dmoMarketLoanReportService.getMarketOutstandingDateWise(pageDetail));
		default :
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST,
					null);
		}
	}

}
