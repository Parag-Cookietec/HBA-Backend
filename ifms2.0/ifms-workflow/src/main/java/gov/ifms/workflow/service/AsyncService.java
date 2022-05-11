package gov.ifms.workflow.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.workflow.dto.TrnSubmitAssignedToDto;
import gov.ifms.workflow.dto.WfReqNoDto;

import java.util.concurrent.Future;

public interface AsyncService {
    Future<WfReqNoDto> submitWfBulkOp(TrnSubmitAssignedToDto dto) throws CustomException;

    long getWfReqId(String wfReqNo) throws CustomException;

    String getWfReqStatusByWfReqNo(String wfReqNo) throws CustomException;

    void updateWfReqStatus(String wfReqNo, String luName, String luInfoName) throws CustomException;
}
