package gov.ifms.edp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPMsFinancialYearConverter;
import gov.ifms.edp.service.EDPMsFinancialYearService;

/**
 * The Class EDPMsFinancialYearController.
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_MASTER_FINANCIAL_YEAR)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EDPMsFinancialYearController {
	
	/** The service. */
	@Autowired
	private EDPMsFinancialYearService service;
	
	/** The converter. */
	@Autowired
	private EDPMsFinancialYearConverter converter;
	
	/**
	 * Gets the ms department.
	 *
	 * @return the ms department
	 */
	@Trace
	@PostMapping(URLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsDepartment() {
		return  ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,converter.convertToDtos(service.getAll()));
	}
	
	
	@Trace
	@PostMapping(URLConstant.URL_EDP_GET_FINANCIAL_YEAR_LAST_TEN)
	public ResponseEntity<ApiResponse> getLastTenFinacialYear() {
		return  ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.EDP_MSG_FETCH,converter.convertToDtos(service.getLastTenYear()));
	}

}
