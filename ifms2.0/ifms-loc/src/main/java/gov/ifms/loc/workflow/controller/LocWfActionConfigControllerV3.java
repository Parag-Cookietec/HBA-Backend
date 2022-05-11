package gov.ifms.loc.workflow.controller;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.loc.util.LocURLConstant;
import gov.ifms.loc.workflow.converter.LocWfActionConfigConverter;
import gov.ifms.loc.workflow.converter.LocWfRequestConverter;
import gov.ifms.loc.workflow.dto.LocTrnSubmitAssignedToDto;
import gov.ifms.loc.workflow.dto.LocWfReqNoDto;
import gov.ifms.loc.workflow.dto.WfLoginUserDetDto;
import gov.ifms.loc.workflow.dto.WfReqNoGenDto;
import gov.ifms.loc.workflow.dto.WfUserRequestDtoV3;
import gov.ifms.loc.workflow.entity.LocWfActionConfigEntity;
import gov.ifms.loc.workflow.service.LocWfActionConfigServiceV3;
import gov.ifms.loc.workflow.util.LocWorkFlowConstant;


/**
 * The Class LocWfActionConfigControllerV3.
 */
@RestController
@RequestMapping(LocURLConstant.URL_LOC_ACTION_CONFIG_WORKFLOW+"/"+LocURLConstant.V30)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocWfActionConfigControllerV3 {


    /** The logger. */
    Logger logger = LoggerFactory.getLogger(LocWfActionConfigControllerV3.class);

    /** The loc wf action config conv. */
    @Autowired
    private LocWfActionConfigConverter locWfActionConfigConv;

    /** The service V 3. */
    @Autowired
    private LocWfActionConfigServiceV3 serviceV3;

    /** The wf request converter. */
    @Autowired
    private LocWfRequestConverter wfRequestConverter;

    /** The future wf buld ins V 3. */
    private HashMap<String, Future<LocWfReqNoDto>> futureWfBuldInsV3 = new HashMap<>();
    
    /**
     * Gets the loc work flow action.
     *
     * @param dto the dto
     * @return the loc work flow action
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(URLConstant.URL_WORKFLOW_NEXT_ACTIONS)
    public ResponseEntity<ApiResponse> getLocWorkFlowAction(@Valid @RequestBody IdDto dto) throws CustomException {
        if(dto.getId()==null){
            throw new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED);
        }
        List<LocWfActionConfigEntity> nextWfActions = serviceV3.getNextWfActions(dto.getId());
        if(nextWfActions.isEmpty() || nextWfActions==null){
            throw new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED);
        }
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
        		locWfActionConfigConv.toWfActionDTO(nextWfActions));
    }
    
   

    

    /**
     * Gets the loc wf users by action config.
     *
     * @param dto the dto
     * @return the loc wf users by action config
     * @throws CustomException the custom exception
     */
    @Trace
    @PostMapping(URLConstant.URL_WF_USER_BY_ACTION_CONFIG)
    public ResponseEntity<ApiResponse> getLocWfUsersByActionConfig(@Valid @RequestBody WfUserRequestDtoV3 dto) throws CustomException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.WORKFLOW_MSG_FETCH_LIST,
                serviceV3.getUsersByWfActConfigId(dto));
    }

    /**
     * Gen wf request no.
     *
     * @param dto the dto
     * @return the response entity
     * @throws SQLException the SQL exception
     */
    @Trace
    @PostMapping(URLConstant.URL_WF_REQ_GEN)
    public ResponseEntity<ApiResponse> genWfRequestNo(@RequestBody WfReqNoGenDto dto) throws SQLException {
        return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.BUDGET_MSG_CREATE,
                wfRequestConverter.toDTO(serviceV3.genWfRequestNo(wfRequestConverter.toEntity(dto))));
    }

    /**
     * Submit wf config trn.
     *
     * @param dto the dto
     * @return the deferred result
     * @throws CustomException the custom exception
     */
    @PostMapping(URLConstant.URL_WF_TRN_SUBMIT)
    public DeferredResult<ResponseEntity<ApiResponse>> submitWfConfigTrn(@RequestBody LocTrnSubmitAssignedToDto dto) throws CustomException {
        DeferredResult<ResponseEntity<ApiResponse>> deferredResult = new DeferredResult<>();
        long wfReqId = serviceV3.getWfReqId(dto.getWfRequestNo());
        WfLoginUserDetDto wfDetFromToken = getWfDetFromToken(dto.getMenuId());
        ResponseEntity<ApiResponse> responseEntity;
        if(wfReqId!=0) {
            serviceV3.updateWfReqStatus(dto.getWfRequestNo(), LocWorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS, LocWorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS_IN_PROGRESS,wfDetFromToken);
            serviceV3.submitWfBulkOpLoc(dto,wfDetFromToken);
            responseEntity = ResponseUtil.getResponse(HttpStatus.ACCEPTED, String.format(LocWorkFlowConstant.WF_REQ_INITIATED_MSG,dto.getWfRequestNo()),String.format(LocWorkFlowConstant.WF_REQ_INITIATED_RESULT,LocURLConstant.URL_LOC_ACTION_CONFIG_WORKFLOW+"/"+LocURLConstant.V30+URLConstant.URL_WF_TRN_SUBMIT_GET_LIST));
            deferredResult.setResult(responseEntity);
        }
        return deferredResult;
        
    }

    /**
     * Gets the submitted wf config trn.
     *
     * @param dto the dto
     * @return the submitted wf config trn
     */
    @PostMapping(URLConstant.URL_WF_TRN_SUBMIT_GET_LIST)
    public DeferredResult<ResponseEntity<ApiResponse>> getSubmittedWfConfigTrn(@RequestBody LocWfReqNoDto dto){
        DeferredResult<ResponseEntity<ApiResponse>> deferredResult = new DeferredResult<>();
        try {
            Future<LocWfReqNoDto> output = futureWfBuldInsV3.get(dto.getWfRequestNo());                                                            // get future from HashMap
            StringBuilder statusMsg = new StringBuilder();
            statusMsg.append("Status of your Request ")
                    .append(dto.getWfRequestNo())
                    .append(" is ")
                    .append(serviceV3.getWfReqStatusByWfReqNo(dto.getWfRequestNo()));
            if (output.isDone()) {                                                                                         // has the future ended?
                LocWfReqNoDto submittedTrn = output.get();
                ResponseEntity<ApiResponse> responseEntity = ResponseUtil.getResponse(HttpStatus.CREATED, statusMsg.toString(), submittedTrn);               // returns someObject, the actual result
                deferredResult.setResult(responseEntity);
            } else {
                ResponseEntity<ApiResponse> responseEntity = ResponseUtil.getResponse(HttpStatus.ACCEPTED, statusMsg.toString());
                deferredResult.setResult(responseEntity);
            }
        } catch (Exception e) {
            ResponseEntity<ApiResponse> responseEntity = ResponseUtil.getResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Some Error Occured for Request no. "+dto.getWfRequestNo());
            deferredResult.setResult(responseEntity);
        }
        return deferredResult;
    }

    /**
     * Gets the wf det from token.
     *
     * @param menuID the menu ID
     * @return the wf det from token
     */
    private WfLoginUserDetDto getWfDetFromToken(long menuID){
        WfLoginUserDetDto loginUserDetDto = new WfLoginUserDetDto();
        EDPMsPostDto postDto = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
        loginUserDetDto.setUserId(OAuthUtility.getCurrentUserUserId());
        loginUserDetDto.setPostId(postDto.getPostId());
        loginUserDetDto.setPouId(postDto.getLkPoOffUserId());
        loginUserDetDto.setOfficeDto(postDto.getOauthTokenPostDTO().getEdpMsOfficeDto());
        loginUserDetDto.setWfRoleIds(OAuthUtility.getWfRoleOfMenuWithLinkMenuUsingMenuId(menuID));
        loginUserDetDto.setBranches(postDto.getBranches());
        return loginUserDetDto;
    }

}
