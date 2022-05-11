package gov.ifms.dmo.controller;

import javax.validation.Valid;

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
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMOGRFCRFReportPostDto;
import gov.ifms.dmo.service.DMOGRFCRFReportService;
import gov.ifms.dmo.utils.DMOURLConstant;

@RestController
@RequestMapping(DMOURLConstant.URL_DMO_GRFCRF_REPORT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMOGRFCRFReportController {

	@Autowired
	private DMOGRFCRFReportService grfCrfReportService;

	@Trace
	@PostMapping(DMOURLConstant.DMO_GRFCRF_INVEST_SALE_REPORT)
	public ResponseEntity<ApiResponse> investmentSaleReport(@RequestBody @Valid DMOGRFCRFReportPostDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_GRFCRF_REPORT_CREATE,
				grfCrfReportService.investmentSaleReport(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.DMO_GRFCRF_STATEMENT_REPORT)
	public ResponseEntity<ApiResponse> statementReport(@RequestBody @Valid DMOGRFCRFReportPostDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_GRFCRF_REPORT_CREATE,
				grfCrfReportService.statementReport(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.DMO_GRFCRF_TOTAL_INVEST_REPORT)
	public ResponseEntity<ApiResponse> totalInvestmentSecurityReport(@RequestBody @Valid DMOGRFCRFReportPostDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_GRFCRF_REPORT_CREATE,
				grfCrfReportService.totalInvestmentSecurityReport(dto));
	}

	@Trace
	@PostMapping(DMOURLConstant.DMO_GRFCRF_YEAR_WISE_MATURITY_INVEST_REPORT)
	public ResponseEntity<ApiResponse> yearWiseMaturityInvestmentReport(@RequestBody @Valid DMOGRFCRFReportPostDto dto)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_GRFCRF_REPORT_CREATE,
				grfCrfReportService.yearWiseMaturityInvestmentReport(dto));
	}

}
