package gov.ifms.pvu.controller;


import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.converter.EDPLuLookUpInfoConverter;
import gov.ifms.edp.service.EDPLuLookUpInfoService;
import gov.ifms.edp.util.EDPConstant;

import gov.ifms.pvu.converter.PVUExpressEmployeeConverter;
import gov.ifms.pvu.dto.response.PVUExpressEmployeeDto;
import gov.ifms.pvu.service.PVUExpressEmployeeService;
import gov.ifms.pvu.util.PvuConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * PVUExpressEmployeeController
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_EXPRESS_EMPLOYEE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUExpressEmployeeController {

	/** The lookupinfoconverter. */
	@Autowired
	private EDPLuLookUpInfoConverter lookupinfoconverter;

	/** The lookupinfoservice. */
	@Autowired
	private EDPLuLookUpInfoService lookupinfoservice;

	@Autowired
	private PVUExpressEmployeeService service;


	@Trace
	@PostMapping(URLConstant.URL_PAY_TYPE_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getPayTypeLuLookUpInfo() throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lookupinfoconverter.toClueDTO(lookupinfoservice
					.findByLookUpName(PvuConstant.LU_EMP_PAY_TYPE, Constant.LOOKUP_INFO_ID, EDPConstant.ORDER_ASC)));
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	@Trace
	@PostMapping(URLConstant.URL_SALUTATION_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getSalutationLuLookUpInfo() throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lookupinfoconverter.toClueDTO(lookupinfoservice
					.findByLookUpName(PvuConstant.LU_SALUTATION, Constant.LOOKUP_INFO_ID, EDPConstant.ORDER_ASC)));
		} catch (Exception exception) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_SAVEFILE);
		}
	}

	@Trace
	@PostMapping(URLConstant.URL_POST_SUBMIT)
	public ResponseEntity<ApiResponse> createExpressEmployee(@Valid @RequestBody PVUExpressEmployeeDto expressEmployeeDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, service.saveOrUpdateExpEmp(expressEmployeeDto));
	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_EXPRESS_EMPLOYEE_BY_CASE_NO + URLConstant.URL_GET_BY_FIELDS)
	public ResponseEntity<ApiResponse> getExpEmpByCaseNo(@RequestBody PVUExpressEmployeeDto expressEmployeeDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getExpEmpByCaseNo(expressEmployeeDto));
	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_EXP_EMP_LIST)
	public ResponseEntity<ApiResponse> getNwConItmEstHeadList(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST,
				service.getExpEmpSearchList(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_EXPRESS_EMPLOYEE_BY_PAN_NO + URLConstant.URL_GET_BY_FIELDS)
	public ResponseEntity<ApiResponse> getExpEmpByPanNo(@RequestBody PVUExpressEmployeeDto expressEmployeeDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getExpEmpByPanNo(expressEmployeeDto.getPanNo()));
	}

	@Trace
	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getExpressEmployeeEmpId(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_CREATE, service.getExpEmpByEmpId(idDto.getId()));
	}
}
