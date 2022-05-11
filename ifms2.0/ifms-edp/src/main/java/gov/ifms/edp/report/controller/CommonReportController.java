package gov.ifms.edp.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.report.dto.CommonReportMasterDto;
import gov.ifms.edp.report.dto.CommonReportPageDetails;
import gov.ifms.edp.report.dto.CommonReportViewPageDetails;
import gov.ifms.edp.report.service.CommonReportService;
import gov.ifms.edp.report.util.CommonURLConstant;

/**
 * The Class CommonReportController.
 */
@RestController
@RequestMapping(URLConstant.BASE_URL_COMMON_REPORT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommonReportController {

	/** The service. */
	@Autowired
	private CommonReportService service;
	
	/**
	 * Generate common report.
	 *
	 * @param pageDetails the page details
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(CommonURLConstant.URL_GENERATE_BASE_64_STRING)
	public ResponseEntity<ApiResponse> generateCommonReport(@RequestBody CommonReportPageDetails pageDetails) 
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.generateReport(pageDetails));
	}
	
	/**
	 * Gets the screen display details.
	 *
	 * @param idDto the id dto
	 * @return the screen display details
	 */
	@Trace
	@PostMapping(CommonURLConstant.URL_SCREEN_DISPLAY_DETAILS)
	public ResponseEntity<ApiResponse> getScreenDisplayDetails(@RequestBody CommonReportMasterDto reportMasterDto) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, 
				service.getScreenDisplayDetails(reportMasterDto));
	}
	
	/**
	 * View report details.
	 *
	 * @param reportMasterDto the report master dto
	 * @return the response entity
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(CommonURLConstant.URL_VIEW_REPORT_DETAILS)
	public ResponseEntity<ApiResponse> viewReportDetails(@RequestBody CommonReportViewPageDetails pageDetails) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, 
				service.viewReportDetails(pageDetails));
	}
}
