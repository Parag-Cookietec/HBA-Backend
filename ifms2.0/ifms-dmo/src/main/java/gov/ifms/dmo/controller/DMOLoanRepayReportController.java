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
import gov.ifms.dmo.dto.DMOLoanRepayReportSearchDto;
import gov.ifms.dmo.service.impl.DMOLoanRepayReportService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.URL_DMO_LOAN_REPAY_REPORT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMOLoanRepayReportController {
	@Autowired
	DMOLoanRepayReportService service;
	
	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_LOAN_REPAY_SECH_REPORT)
	public ResponseEntity<ApiResponse> dmoLoanRepayReport(@RequestBody DMOLoanRepayReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.dmoLoanRepayReport(pageDetail));
	}

	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_LOAN_REPAY_DETAIL_REPORT)
	public ResponseEntity<ApiResponse> loanRepayDetailReport(@RequestBody DMOLoanRepayReportSearchDto pageDetail) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DP_SHEET_MSG_FETCH_LIST, service.loanRepayDetailReport(pageDetail));
	}

}
