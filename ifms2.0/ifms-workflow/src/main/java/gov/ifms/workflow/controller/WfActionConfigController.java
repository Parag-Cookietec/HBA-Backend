package gov.ifms.workflow.controller;


import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import gov.ifms.common.constant.CommonConstant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.workflow.converter.WfRequestConverter;
import gov.ifms.workflow.dto.*;
import gov.ifms.workflow.entity.WfActionConfigEntity;
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
import gov.ifms.common.dto.officeIdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.workflow.converter.WfActionConfigConverter;
import gov.ifms.workflow.dto.WfActConfUserRequestDto;
import gov.ifms.workflow.dto.WfActionConfigSubmitTrnDto;
import gov.ifms.workflow.dto.WfRequestDto;
import gov.ifms.workflow.dto.WfUserReqSDDto;
import gov.ifms.workflow.service.WfActionConfigService;

@RestController
@RequestMapping(URLConstant.URL_ACTION_CONFIG_WORKFLOW)
public class WfActionConfigController {


    @Autowired
    private WfActionConfigConverter wfActionConfigConverter;

    @Autowired
    private WfActionConfigService service;

    @Autowired
    private WfRequestConverter wfRequestConverter;

    @Trace
    @PostMapping(URLConstant.URL_WORKFLOW_NEXT_ACTIONS)
    public ResponseEntity<ApiResponse> getWorkFlowAction(@Valid @RequestBody WfRequestDto dto) throws CustomException {
        List<WfActionConfigEntity> nextWfActions = service.getNextWfActions(dto);
        if(nextWfActions.isEmpty()){
            throw new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED);
        }
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
                wfActionConfigConverter.toWfActionDTO(nextWfActions));
    }
    
    @Trace
    @PostMapping(URLConstant.URL_WF_USER_BY_ACTION_CONFIG)
    public ResponseEntity<ApiResponse> getWfUsersByActionConfig(@Valid @RequestBody WfActConfUserRequestDto dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
                service.getUsersByWfActConfigId(dto));
    }
    
    @Trace
	@PostMapping(URLConstant.URL_WF_TRN_SUBMIT)
	public ResponseEntity<ApiResponse> submitWfConfigTrn(@RequestBody WfActionConfigSubmitTrnDto dto) throws SQLException {
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_SUBMIT,
				service.submitWfActConfigTrn(dto));
	}


    @Trace
    @PostMapping(URLConstant.URL_WF_TRN_CURRENT_STATUS)
    public ResponseEntity<ApiResponse> getCurrentWfTrn(@RequestBody WfRequestDto dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH_LIST, service.getCurrentTrnStatus(dto));
    }
    
    @Trace
   	@PostMapping(URLConstant.URL_WF_TRN_SAVE)
   	public ResponseEntity<ApiResponse> saveWfConfigTrn(@RequestBody WfUserReqSDDto dto) throws CustomException {
   		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
   				service.saveWfActConfigTrn(dto));
   	}

    @Trace
    @PostMapping(URLConstant.URL_WF_GET_TRN_CHILD_OFFICE)
    public ResponseEntity<ApiResponse> getTrnChildOffice(@RequestBody WfUserReqSDDto dto) {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
                service.getTrnChildOffice(dto));
    }


    /**
     * @param officeIdDto
     * @return
     */
	@Trace
	@PostMapping(URLConstant.URL_TRN_STATUS)
	public ResponseEntity<ApiResponse> getTrnStatus(@RequestBody officeIdDto officeIdDto) {
		List<String> trnStatus = service.getMsWorkflowTrnStatus(officeIdDto.getId(),officeIdDto.getOfficeId());
		return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH, trnStatus);
	}

    @Trace
    @PostMapping(URLConstant.URL_WF_TRN_DIRECT_SUBMIT)
    public ResponseEntity<ApiResponse> submitDirectWfConfigTrn(@RequestBody WfRequestDto dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
                service.defaultSubmitWf(dto));
	}

    @Trace
    @PostMapping(URLConstant.URL_WF_RETURN_OFFICE_CON_ACTION_CONFIG)
    public ResponseEntity<ApiResponse> returnToOfficeCon(@Valid @RequestBody WfRequestReOffConDto dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
                service.returnToOfficeCon(dto));
    }
    
    @Trace
    @PostMapping(URLConstant.URL_WF_RL_DCO_CO_CREATOR)
    public ResponseEntity<ApiResponse> getWfRlDcoCoCreatorForGrant() throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
                service.getWfRlDcoCoCreatorForGrant());
    }

    @Trace
    @PostMapping(URLConstant.URL_WF_GRANT_USER_BY_ACTION_CONFIG)
    public ResponseEntity<ApiResponse> getWfGrantUsersByActionConfig(@Valid @RequestBody WfGrantUserRequestDto dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
                service.getGrantUsersByWfActConfigId(dto));
    }

    @Trace
    @PostMapping(CommonConstant.V30+URLConstant.URL_WF_REQ_GEN)
    public ResponseEntity<ApiResponse> genWfRequestNo(@RequestBody WfReqNoGenDto dto) throws SQLException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
                wfRequestConverter.toDTO(service.genWfRequestNo(wfRequestConverter.toEntity(dto))));
    }
}
