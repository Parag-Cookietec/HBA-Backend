package gov.ifms.workflow.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.workflow.dto.TrnSubmitAssignedToDto;
import gov.ifms.workflow.dto.WfReqNoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Future;

@Service
public class AsyncServiceImpl implements AsyncService{

    Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Autowired
    private WfActionConfigService wfActionConfigService;

    @Override
    @Async("asyncExecutor")
    public Future<WfReqNoDto> submitWfBulkOp(TrnSubmitAssignedToDto dto) throws CustomException {
        logger.info("Async Submit bulk operation start...");
        Instant start = Instant.now();
        WfReqNoDto wfReqNoDto = new WfReqNoDto();
        wfReqNoDto.setResponseList(wfActionConfigService.submitWfBulkIns(dto));
        Instant end = Instant.now();
        logger.info("Async Submit bulk operation ends...");
        logger.info("Execution time of bulk operation is {} ms", Duration.between(start,end).toMillis());
        return new AsyncResult<>(wfReqNoDto);
    }

    @Override
    public long getWfReqId(String wfReqNo) throws CustomException {
        return wfActionConfigService.getWfReqId(wfReqNo);
    }

    @Override
    public String getWfReqStatusByWfReqNo(String wfReqNo) throws CustomException {
        return wfActionConfigService.getWfReqStatusByWfReqNo(wfReqNo);
    }

    @Override
    public void updateWfReqStatus(String wfReqNo, String luName, String luInfoName) throws CustomException {
        wfActionConfigService.updateWfReqStatus(wfReqNo,luName,luInfoName);
    }
}
