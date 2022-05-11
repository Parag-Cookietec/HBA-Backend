package gov.ifms.loc.controller;

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
import gov.ifms.common.dto.ConditionDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.loc.service.LocWfConditionService;
import gov.ifms.loc.util.LocURLConstant;

/**
 * The Class LocWfConditionalController.
 */
@RestController
@RequestMapping(LocURLConstant.URL_LOC)
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class LocWfConditionalController {

	/** The service. */
	@Autowired
	LocWfConditionService service;

	/**
	 * Gets the open conditional check.
	 *
	 * @param dto the dto
	 * @return the open conditional check
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ACCOUNT_OPEN_REQ)
	public ResponseEntity<ApiResponse> getOpenConditionalCheck(@RequestBody ConditionDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
				service.getLocOpenReqCondition(dto));
	}

	/**
	 * Gets the close conditional check.
	 *
	 * @param dto the dto
	 * @return the close conditional check
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_ACCOUNT_CLOSE_REQ)
	public ResponseEntity<ApiResponse> getCloseConditionalCheck(@RequestBody ConditionDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
				service.getLocCloseReqCondition(dto));
	}

	/**
	 * Gets the close conditional check.
	 *
	 * @param dto the dto
	 * @return the close conditional check
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(LocURLConstant.URL_LOC_CHEQUEBOOK_ACT_INACT)
	public ResponseEntity<ApiResponse> getLocChequebookActInactCondition(@RequestBody ConditionDto dto) throws CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
				service.getLocChequebookActInactCondition(dto));
	}
}
