package gov.ifms.workflow.controller;

import java.sql.SQLException;
import java.util.List;

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
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.workflow.converter.WfConfigTrnConverter;
import gov.ifms.workflow.dto.WfConfigTrnDto;
import gov.ifms.workflow.service.WfConfigTrnService;

/**
 * The Class WfConfigTrnController.
 */
@RestController
@RequestMapping(URLConstant.URL_WF_CONFIG_TRN)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WfConfigTrnController {

	@Autowired
	private WfConfigTrnService service;

	@Trace
	@Autowired
	private WfConfigTrnConverter converter;

	/**
	 * Gets the wf rl cd by rop trn id.
	 *
	 * @param id the id
	 * @return the wf rl cd by rop trn id
	 */
	@Trace
	@PostMapping(URLConstant.URL_WF_RL_CD_ROP_TRN_ID)
	public ResponseEntity<ApiResponse> getWfRlCdByRopTrnId(@RequestBody IdDto id) {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH,
				service.getWfRlCdByRopTrnId(id.getId()));
	}

	
	@Trace
	@PostMapping(URLConstant.URL_POST)
	public ResponseEntity<ApiResponse> submitWfConfigTrn(@Valid @RequestBody WfConfigTrnDto dto) {
		dto = service.setPOUId(dto);
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
				converter.toView(service.submitWfConfigTrn(dto)));
	}

	
	@Trace
	@PostMapping(URLConstant.URL_POST_LIST)
	public ResponseEntity<ApiResponse> submitWfConfigTrnList(@Valid @RequestBody List<WfConfigTrnDto> dtos)
			throws SQLException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
				service.submitWfConfigTrnList(dtos));
	}
}
