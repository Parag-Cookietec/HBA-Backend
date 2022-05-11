package gov.ifms.dmo.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
import gov.ifms.dmo.dto.DMOMsFinancialYearSearchDto;
import gov.ifms.dmo.utils.DMOURLConstant;
import gov.ifms.edp.converter.EDPMsFinancialYearConverter;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.service.EDPMsFinancialYearService;

/**
 * The Class EDPMsFinancialYearController.
 */
@RestController
@RequestMapping(DMOURLConstant.URL_DMO_MASTER_FINANCIAL_YEAR)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DMOMsFinancialYearController {

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
	@PostMapping(DMOURLConstant.URL_GET_ALL)
	public ResponseEntity<ApiResponse> getMsDepartment() {
		return  ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST,converter.convertToDtos(service.getAll()));
	}


	@Trace
	@PostMapping(DMOURLConstant.URL_DMO_GET_FINANCIAL_YEAR_BETWEEN_ID)
	public ResponseEntity<ApiResponse> getLastTenFinacialYear(@RequestBody DMOMsFinancialYearSearchDto dMOMsFinancialYearSearchDto) {
		List<EDPMsFinancialYearEntity> allFinancialYears = service.getAll().stream().filter(Objects::nonNull).filter(fy -> fy.getFinancialYearId() >= Long.valueOf(dMOMsFinancialYearSearchDto.getFromYearId()) &&
				fy.getFinancialYearId() <= Long.valueOf(dMOMsFinancialYearSearchDto.getToYearId())).collect(Collectors.toList());
		return  ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.DMO_MSG_FETCH_LIST,converter.convertToDtos(
				allFinancialYears));
	}

}
