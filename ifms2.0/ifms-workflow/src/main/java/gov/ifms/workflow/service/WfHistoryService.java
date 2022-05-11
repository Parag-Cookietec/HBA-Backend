package gov.ifms.workflow.service;


import gov.ifms.common.exception.CustomException;
import gov.ifms.workflow.dto.WfHSTDto;
import gov.ifms.workflow.dto.WfReqHistoryDto;

import java.util.List;

public interface WfHistoryService {

    List<WfHSTDto> getWFHistory(WfReqHistoryDto dto) throws CustomException;

}
