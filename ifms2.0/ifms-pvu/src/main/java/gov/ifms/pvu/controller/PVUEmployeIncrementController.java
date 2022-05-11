package gov.ifms.pvu.controller;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.pvu.converter.PVUIncrementEventConverter;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.entity.PVUIncrementEventEntity;
import gov.ifms.pvu.service.PVUEmployeIncrementService;
import gov.ifms.pvu.util.PvuConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * The Class PVUIncrementEventController.
 * 
 * @version v 1.0.
 * @created 2020/01/09 19:28:39.
 *
 */
@RestController
@RequestMapping(URLConstant.URL_PVU_EMPLOYEE_INCREMENT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUEmployeIncrementController {

	/** The service. */
	@Autowired
	private PVUEmployeIncrementService service;

	/** The converter. */
	@Autowired
	private PVUIncrementEventConverter converter;

	/**
	 * Gets the list look up info as map.
	 *
	 * @return the list look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_LIST_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getListLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service
				.getLookUpInfoAsMap(PvuConstant.PVU_EMP_INC_LIST_LOOKUPS_SP);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}

	/**
	 * Gets the creates the look up info as map.
	 *
	 * @return the creates the look up info as map
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(PvuConstant.URL_CREATION_LOOKUP_INFO)
	public ResponseEntity<ApiResponse> getCreateLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> lstLuLookUp = service
				.getLookUpInfoAsMap(PvuConstant.PVU_EMP_INC_GET_LIST_LOOKUP_SP);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, lstLuLookUp);
	}

	@Trace
	@PostMapping(URLConstant.URL_REGULAR_EMPLOYEE_INCREMENT_LIST)
	public ResponseEntity<ApiResponse> getRegularEmployeeIncrementList(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PVURegularIncrementListView data = service.getRegularEmployeeIncrementList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, data);
	}

	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> createIncrementEvent(@RequestBody PVUIncrementMainEventDto dto) throws CustomException {
		dto.validateAll();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
				service.saveOrUpdateIncrementEventEmpSummary(dto));
	}

	public static final String URL_EMPLOYEE_DATA_REPORT_EXCEL = "/excelGeneration/employeeData";
	@Trace
	@PostMapping(URL_EMPLOYEE_DATA_REPORT_EXCEL)
	public ResponseEntity<ApiResponse> getForwardCaseDdoWiseReportExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getEmployeeDataReportExcel(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_EMPLOYEE_INCREMENT_LIST)
	public ResponseEntity<ApiResponse> getPVUEmployeeIncrementList(@RequestBody PageDetails pageDetail)
			throws CustomException {
		PagebleDTO<PVUEmployeeIncrementListView> data = service.getPVUEmployeeIncrementList(pageDetail);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);

	}

	@Trace
	@PostMapping(URLConstant.URL_EMPLOYEE_INCREMENT_CONFIRM_PROCESS)
	public ResponseEntity<ApiResponse> pvuEmployeeIncrementConfirmAndProcess(@RequestBody PVUIncrementMainEventDto dto)
			throws CustomException {
		List<Object[]> data = service.pvuEmployeeIncrementConfirmAndProcess( dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, data);

	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_INSERT_INCREMENT_ITR)
	public ResponseEntity<ApiResponse> insertEmployeeIncrementItr(@RequestBody PvuWFWrapperDto pvuWFWrapperDto)
			throws CustomException {
			PVUIncrementMainEventDto pvuIncrementEventDto = service.insertIncrementItr(pvuWFWrapperDto);
			return ResponseUtil.getResponse(HttpStatus.OK, MessageFormat.format(MsgConstant.IFMS_MSG_PVU_COMMON_RESPONSE, pvuWFWrapperDto.getTrnStatus()), pvuIncrementEventDto);
	}

	@Trace
	@PostMapping(URLConstant.URL_EMPLOYEE_INCREMENT_INELIGIBLE_EMPLOYEE_LIST_EXCEL)
	public ResponseEntity<ApiResponse> getIneligileEmployeeListExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getIneligibleEmployeeListExcel(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_EMPLOYEE_INCREMENT_SUCCESS_COUNT_EXCEL)
	public ResponseEntity<ApiResponse> getSuccessCountExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getSuccessCountExcel(pageDetail));
	}

	@PostMapping(URLConstant.URL_GET_BY_ID)
	public ResponseEntity<ApiResponse> getIncrementEvent(@RequestBody IdDto id) throws CustomException {
		PVUIncrementMainEventDto dto = service.getIncrementEventEmpSummary(id.getId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_FETCH, dto);
	}

	@Trace
	@PostMapping(URLConstant.URL_EMPLOYEE_INCREMENT_PROCESSED_EMPLOYEE_LIST_EXCEL)
	public ResponseEntity<ApiResponse> getProcessedEmployeeListExcel(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getProcessedEmployeeListExcel(pageDetail));
	}
		@PostMapping(URLConstant.URL_PVU_VALIDATE_INCREMENT_SUBMIT)
	public ResponseEntity<ApiResponse> validateSubmit(@RequestBody PVUIncrementMainEventDto dto) throws CustomException {
		dto.validateAll();
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
				service.validateIncrementSubmit(dto));
	}

	@Trace
	@PostMapping(URLConstant.URL_DELETE_BY_ID)
	public ResponseEntity<ApiResponse> deleteIncrementEvent(@RequestBody IdDto idDto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_DELETE, service.deleteIncrementTrns(idDto));
	}

	//1 = success and 2 = failed status
	@Trace
	@PostMapping(URLConstant.URL_EMPLOYEE_INCREMENT_PROCESS_STATUS)
	public ResponseEntity<ApiResponse> getprocessStatus(@RequestBody PageDetails pageDetail)
			throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH,
				service.getprocessStatus(pageDetail));
	}

	@Trace
	@PostMapping(URLConstant.URL_PVU_GENERATE_PRINTENDORSEMENT)
	public ResponseEntity<ApiResponse> generatePrintEndorsement(@RequestBody IdDto dto) throws CustomException {
		try {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_SUBMITTED, service.generatePrintEndorsement(dto));
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
		}
	}






//URLConstant
}
