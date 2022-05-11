package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPHeaderParam;

public interface EDPWorkflowAliasService {
	
	/**
	 * Gets the office details by alias.
	 *
	 * @param alias the alias
	 * @param officeId the office id
	 * @return the office details by alias
	 */
	ClueDto getOfficeDetailsByAlias(String alias, Long districtId);
	
	/**
	 * Gets the wf comman header.
	 *
	 * @param dto the dto
	 * @return the wf comman header
	 * @throws CustomException 
	 */
	List<EDPHeaderParam> getWfCommanHeader(ClueDto dto) throws CustomException;
	
}
