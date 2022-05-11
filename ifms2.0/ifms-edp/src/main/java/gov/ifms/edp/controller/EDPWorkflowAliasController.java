package gov.ifms.edp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPIdDto;
import gov.ifms.edp.service.EDPWorkflowAliasService;

/**
 * The Class EDPWorkflowAliasController.
 */
@RestController
@RequestMapping(URLConstant.URL_EDP_ALIAS)
public class EDPWorkflowAliasController {

	/** The service. */
	@Autowired
	private EDPWorkflowAliasService service;

	/**
	 * Gets the office for alias.
	 *
	 * @param dto the dto
	 * @return the office for alias
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_PT_OFFICE_ALIAS)
	public ResponseEntity<ApiResponse> getOfficeForAlias(@RequestBody EDPIdDto dto) throws CustomException {
		if (null != dto.getAlias()) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
					service.getOfficeDetailsByAlias(dto.getAlias(), dto.getDistrictId()));
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}

	}
	
	/**
	 * Gets the wf comman header.
	 *
	 * @param dto the dto
	 * @return the wf comman header
	 * @throws CustomException the custom exception
	 */
	@Trace
	@PostMapping(URLConstant.URL_EDP_WF_COMMAN_HEADER)
	public ResponseEntity<ApiResponse> getWfCommanHeader(@RequestBody ClueDto dto) throws CustomException {
		if (null != dto.getId() && null != dto.getMenuId()) {
			return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,service.getWfCommanHeader(dto));
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}
	

}
