package gov.ifms.gst.workflow.controller;


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
import gov.ifms.gst.util.GstURLConstant;
import gov.ifms.gst.workflow.converter.GstWfActionConfigConverter;
import gov.ifms.gst.workflow.dto.WfActConfUserRequestDto;
import gov.ifms.gst.workflow.dto.WfActionConfigSubmitTrnDto;
import gov.ifms.gst.workflow.dto.WfUserReqSDDto;
import gov.ifms.gst.workflow.entity.GstWfActionConfigEntity;
import gov.ifms.gst.workflow.service.GstWfActionConfigService;


/**
 * The Class GstWfActionConfigController.
 */
@RestController
@RequestMapping(GstURLConstant.URL_GST_ACTION_CONFIG_WORKFLOW+"/"+GstURLConstant.V20)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GstWfActionConfigController {


    /** The GST wf action config converter. */
    @Autowired
    private GstWfActionConfigConverter gstWfActionConfigConverter;

    /** The service. */
    @Autowired
    private GstWfActionConfigService service;

    /**
     * Gets the gst work flow action.
     *
     * @param dto the dto
     * @return the gst work flow action
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(GstURLConstant.URL_WORKFLOW_NEXT_ACTIONS)
    public ResponseEntity<ApiResponse> getGstWorkFlowAction(@Valid @RequestBody gov.ifms.gst.workflow.dto.WfRequestDto dto) throws CustomException {
        List<GstWfActionConfigEntity> nextWfActions = service.getNextWfActions(dto);
        if(nextWfActions.isEmpty()){
            throw new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED);
        }
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
                gstWfActionConfigConverter.toWfActionDTO(nextWfActions));
    }
    
    /**
     * Gets the Gst wf users by action config.
     *
     * @param dto the dto
     * @return the Gst wf users by action config
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(GstURLConstant.URL_WF_USER_BY_ACTION_CONFIG)
    public ResponseEntity<ApiResponse> getGstWfUsersByActionConfig(@Valid @RequestBody WfActConfUserRequestDto
    		dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
                service.getUsersByWfActConfigId(dto));
    }
    
    /**
     * Submit gst wf config trn.
     *
     * @param dto the dto
     * @return the response entity
     * @throws SQLException the SQL exception
     * @throws CustomException the custom exception
     */
    @Trace
	@PostMapping(GstURLConstant.URL_WF_TRN_SUBMIT)
	public ResponseEntity<ApiResponse> submitGstWfConfigTrn(@RequestBody WfActionConfigSubmitTrnDto dto) throws SQLException, CustomException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_SUBMIT,
				service.submitWfActConfigTrn(dto));
	}

    
    /**
     * Save gst wf config trn.
     *
     * @param dto the dto
     * @return the response entity
     * @throws CustomException the custom exception
     */
    @Trace
   	@PostMapping(GstURLConstant.URL_WF_TRN_SAVE)
   	public ResponseEntity<ApiResponse> saveGstWfConfigTrn(@RequestBody WfUserReqSDDto dto) throws CustomException {
   		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
   				service.saveWfActConfigTrn(dto));
   	}
}
