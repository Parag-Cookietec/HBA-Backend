package gov.ifms.workflow.service;

import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.workflow.dto.PVUWFReqHistoryDto;
import gov.ifms.workflow.dto.PVUWfHSTDto;


/**
 *  The Interface PVUWfHistoryService.
 */
public interface PVUWfHistoryService {

	/**
	 * getWFHistory
	 *
	 * @param dto
	 * @return List<PVUWfHSTDto>
	 * @throws CustomException
	 */
	public List<PVUWfHSTDto> getWFHistory(PVUWFReqHistoryDto dto) throws CustomException;

	/**
	 * getPvuWFHistory
	 *
	 * @param pvuWfHistory
	 * @return List<PVUWfHSTDto>
	 * @throws CustomException
	 */
	public List<PVUWfHSTDto> getPvuWFHistory(PVUWFReqHistoryDto pvuWfHistory) throws CustomException;
}
