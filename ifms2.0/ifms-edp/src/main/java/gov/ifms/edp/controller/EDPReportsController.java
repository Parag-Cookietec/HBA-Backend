package gov.ifms.edp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.dto.EDPReportPageDetails;
import gov.ifms.edp.service.EDPReportsService;
import gov.ifms.edp.util.EDPConstant;

@Validated
@RestController
@RequestMapping(URLConstant.URL_EDP_REPORTS)
@CrossOrigin(origins = EDPConstant.STAR, allowedHeaders = EDPConstant.STAR)
public class EDPReportsController {	
		
	/** The edp reports service impl. */
	@Autowired
	EDPReportsService edpReportsService;
	
	/**
	 * Gets the forward case ddo wise report excel.
	 *
	 * @param pageDetail the page detail
	 * @return the forward case ddo wise report excel
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_REPORTS_GENERATION) 
	public ResponseEntity<ApiResponse> getEDPReport(@RequestBody EDPReportPageDetails pageDetail) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, edpReportsService.edpGenerateReport(pageDetail));
	}

	/**
	 * Gets the EDP report.
	 *
	 * @param dto the dto
	 * @return the EDP report
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_REPORTS_SEARCH_FILTER_DATA) 
	public ResponseEntity<ApiResponse> getEDPReport(@RequestBody IdDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, edpReportsService.edpGenerateReportFilterData(dto.getId()));
	}
	
	/**
	 * Gets the post history get post detail.
	 *
	 * @param dto the dto
	 * @return the post history get post detail
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_REPORTS_POST_HISTORY_GET_DETAIL) 
	public ResponseEntity<ApiResponse> getPostHistoryGetPostDetail(@RequestBody IdDto dto) throws CustomException {
		if(null != dto.getId())
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, edpReportsService.getPostDetailsPostReport(dto.getId()));
		else 
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
	}
	
	
	

}
