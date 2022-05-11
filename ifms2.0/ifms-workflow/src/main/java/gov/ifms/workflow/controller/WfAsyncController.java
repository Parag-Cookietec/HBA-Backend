package gov.ifms.workflow.controller;

import gov.ifms.common.constant.CommonConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.workflow.dto.TrnSubmitAssignedToDto;
import gov.ifms.workflow.dto.WfReqNoDto;
import gov.ifms.workflow.service.AsyncService;
import gov.ifms.workflow.util.WorkFlowConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.concurrent.Future;

@RestController
@RequestMapping(URLConstant.URL_ACTION_CONFIG_WORKFLOW_ASYNC)
public class WfAsyncController {

    @Autowired
    private AsyncService service;

    private HashMap<String, Future<WfReqNoDto>> futureWfBuldInsV3 = new HashMap<>();

    Logger logger = LoggerFactory.getLogger(WfAsyncController.class);

    @PostMapping(CommonConstant.V30+ URLConstant.URL_WF_TRN_SUBMIT)
    public DeferredResult<ResponseEntity<ApiResponse>> submitWfConfigTrn(@RequestBody TrnSubmitAssignedToDto dto) throws CustomException {
        DeferredResult<ResponseEntity<ApiResponse>> deferredResult = new DeferredResult<>();
        long wfReqId = service.getWfReqId(dto.getWfRequestNo());
        ResponseEntity<ApiResponse> responseEntity;
        if(wfReqId!=0) {
            service.updateWfReqStatus(dto.getWfRequestNo(), WorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS, WorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS_IN_PROGRESS);
            Future<WfReqNoDto> output = service.submitWfBulkOp(dto);
            futureWfBuldInsV3.put(dto.getWfRequestNo(), output);
            responseEntity = ResponseUtil.getResponse(HttpStatus.ACCEPTED, "Your request is Initiated with Request No. " + dto.getWfRequestNo(),null);
            deferredResult.setResult(responseEntity);
        }
        return deferredResult;
    }

    @PostMapping(CommonConstant.V30+ URLConstant.URL_WF_TRN_SUBMIT_GET_LIST)
    public DeferredResult<ResponseEntity<ApiResponse>> getSubmittedWfConfigTrn(@RequestBody WfReqNoDto dto){
        DeferredResult<ResponseEntity<ApiResponse>> deferredResult = new DeferredResult<>();
        try {
            Future<WfReqNoDto> output = futureWfBuldInsV3.get(dto.getWfRequestNo());                                                            // get future from HashMap
            StringBuilder statusMsg = new StringBuilder();
            statusMsg.append("Status of your Request ")
                    .append(dto.getWfRequestNo())
                    .append(" is ")
                    .append(service.getWfReqStatusByWfReqNo(dto.getWfRequestNo()));
            if (output.isDone()) {                                                                                         // has the future ended?
                WfReqNoDto submittedTrn = output.get();
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
}
