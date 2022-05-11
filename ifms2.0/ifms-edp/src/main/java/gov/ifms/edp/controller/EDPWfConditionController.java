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
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.dto.ConditionDto;
import gov.ifms.edp.service.EDPWfConditionService;

@RestController
@RequestMapping(URLConstant.URL_EDP_CONDITION)
public class EDPWfConditionController {

    @Autowired
    private EDPWfConditionService service;
    
    @Trace
    @PostMapping(URLConstant.URL_WORKFLOW_CONDITION)
    public ResponseEntity<ApiResponse> getEdpWorkflowConditionCheck(@RequestBody ConditionDto dto) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
                service.getCommonCondition(dto));
    }

    @Trace
    @PostMapping(URLConstant.URL_WORKFLOW_CONDITION_ADD_NEW_DESIGNATION)
    public ResponseEntity<ApiResponse> getEdpWorkflowConditionCheckForAddNewDesignation(@RequestBody ConditionDto dto) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
                service.getConditionForAddNewDesignation(dto));
    }
    
    @Trace
    @PostMapping(URLConstant.URL_WORKFLOW_CONDITION_RIGHTS_MAPPING)
    public ResponseEntity<ApiResponse> getConditionForRightsMapping(@RequestBody ConditionDto dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
                service.getConditionForRightsMapping(dto));
    }

}
