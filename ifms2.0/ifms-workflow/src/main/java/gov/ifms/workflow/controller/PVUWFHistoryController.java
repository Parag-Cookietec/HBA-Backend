package gov.ifms.workflow.controller;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.constant.URLConstant;
import gov.ifms.common.dto.ApiResponse;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.workflow.dto.PVUWFReqHistoryDto;
import gov.ifms.workflow.service.PVUWfHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The Class PVUWFHistoryController
 */
@RestController
@RequestMapping(URLConstant.URL_WORKFLOW_HISTORY)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PVUWFHistoryController {

    /**
     * The logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PVUWFHistoryController.class.getName());


    /**
     * The PVUWfHistoryService
     */
    @Autowired
    private PVUWfHistoryService service;

    /**
     * Fetch EmployeeWFHistory
     *
     * @param pvuWfHistory
     * @return List<PVUWfHSTDto>
     * @throws CustomException
     */
    @Trace
    @PostMapping(URLConstant.URL_PVU_WF_HST)
    public ResponseEntity<ApiResponse> getEmployeeWFHistory(@RequestBody PVUWFReqHistoryDto pvuWfHistory) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getWFHistory(pvuWfHistory));
        } catch (DataIntegrityViolationException ex) {
            LOGGER.info(ex.getMessage(), ex);
            return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
        } catch (Exception ex) {
            LOGGER.info(ex.getMessage(), ex);
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    /**
     * Fetch EmployeePvuWFHistory
     *
     * @param wfRequestDto wfRequestDto
     * @return List<PVUWfHSTDto>
     * @throws CustomException
     */
    @Trace
    @PostMapping(URLConstant.URL_PVU_OFC_WF_HST)
    public ResponseEntity<ApiResponse> getEmployeePvuWFHistory(@RequestBody PVUWFReqHistoryDto wfRequestDto) throws CustomException {
        try {
            return ResponseUtil.getResponse(HttpStatus.OK, MsgConstant.IFMS_MSG_FETCH, service.getPvuWFHistory(wfRequestDto));
        } catch (DataIntegrityViolationException ex) {
            LOGGER.info(ex.getMessage(), ex);
            return ResponseUtil.getResponse(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), null);
        } catch (Exception ex) {
            LOGGER.info(ex.getMessage(), ex);
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }
}
