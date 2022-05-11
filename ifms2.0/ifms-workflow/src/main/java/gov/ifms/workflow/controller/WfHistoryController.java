package gov.ifms.workflow.controller;


import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;

import gov.ifms.workflow.dto.WfReqHistoryDto;
import gov.ifms.workflow.service.WfHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(URLConstant.URL_COMMON_WORKFLOW_HISTORY)
public class WfHistoryController {


    private static final Logger LOGGER = LoggerFactory.getLogger(WfHistoryController.class.getName());

    @Autowired
    private WfHistoryService wfHistoryService;


    @Trace
    @PostMapping(URLConstant.URL_GET_BY_ID)
    public ResponseEntity<ApiResponse> getEmployeeWFHistory(@RequestBody WfReqHistoryDto wfReqHistoryDto) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, wfHistoryService.getWFHistory(wfReqHistoryDto));
        } catch (Exception ex) {
            LOGGER.info(ex.getMessage(), ex);
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }
}
