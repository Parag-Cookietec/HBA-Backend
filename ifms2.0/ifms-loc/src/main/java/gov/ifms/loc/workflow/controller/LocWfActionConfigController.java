package gov.ifms.loc.workflow.controller;


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
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.loc.util.LocURLConstant;
import gov.ifms.loc.workflow.converter.LocWfActionConfigConverter;
import gov.ifms.loc.workflow.dto.WfActConfUserRequestDto;
import gov.ifms.loc.workflow.dto.WfActionConfigSubmitTrnDto;
import gov.ifms.loc.workflow.dto.WfRequestDto;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.entity.LocWfActionConfigEntity;
import gov.ifms.loc.workflow.service.LocWfActionConfigService;

/**
 * The Class LocWfActionConfigController.
 */
@RestController
@RequestMapping(LocURLConstant.URL_LOC_ACTION_CONFIG_WORKFLOW+"/"+LocURLConstant.V20)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocWfActionConfigController {


    /** The loc wf action config converter. */
    @Autowired
    private LocWfActionConfigConverter locWfActionConfigConverter;

    /** The service. */
    @Autowired
    private LocWfActionConfigService service;

    /**
     * Gets the loc work flow action.
     *
     * @param dto the dto
     * @return the loc work flow action
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(LocURLConstant.URL_WORKFLOW_NEXT_ACTIONS)
    public ResponseEntity<ApiResponse> getLocWorkFlowAction(@Valid @RequestBody WfRequestDto dto) throws CustomException {
        List<LocWfActionConfigEntity> nextWfActions = service.getNextWfActions(dto);
        if(nextWfActions.isEmpty()){
            throw new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED);
        }
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
                locWfActionConfigConverter.toWfActionDTO(nextWfActions));
    }
    
    /**
     * Gets the loc wf users by action config.
     *
     * @param dto the dto
     * @return the loc wf users by action config
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(LocURLConstant.URL_WF_USER_BY_ACTION_CONFIG)
    public ResponseEntity<ApiResponse> getLocWfUsersByActionConfig(@Valid @RequestBody WfActConfUserRequestDto dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
                service.getUsersByWfActConfigId(dto));
    }
    
    /**
     * Submit loc wf config trn.
     *
     * @param dto the dto
     * @return the response entity
     * @throws SQLException the SQL exception
     * @throws CustomException the custom exception
     */
    @Trace
	@PostMapping(LocURLConstant.URL_WF_TRN_SUBMIT)
	public ResponseEntity<ApiResponse> submitLocWfConfigTrn(@RequestBody WfActionConfigSubmitTrnDto dto) throws SQLException, CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_SUBMIT,
				service.submitWfActConfigTrn(dto));
	}

    
    /**
     * Save loc wf config trn.
     *
     * @param dto the dto
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace
   	@PostMapping(LocURLConstant.URL_WF_TRN_SAVE)
   	public ResponseEntity<ApiResponse> saveLocWfConfigTrn(@RequestBody WfUserReqSDDto dto) throws CustomException {
   		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
   				service.saveWfActConfigTrn(dto));
   	}
}
