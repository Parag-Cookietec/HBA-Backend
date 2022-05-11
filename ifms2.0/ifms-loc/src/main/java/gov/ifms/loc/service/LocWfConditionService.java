package gov.ifms.loc.service;

import gov.ifms.common.dto.ConditionDto;
import gov.ifms.common.exception.CustomException;

/**
 * The Interface LocWfConditionService.
 */
public interface LocWfConditionService {

	/**
	 * Gets the loc open req condition.
	 *
	 * @param conditionDto the condition dto
	 * @return the loc open req condition
	 * @throws CustomException the custom exception
	 */
	public String getLocOpenReqCondition(ConditionDto conditionDto) throws CustomException;

	/**
	 * Gets the loc close req condition.
	 *
	 * @param conditionDto the condition dto
	 * @return the loc close req condition
	 * @throws CustomException the custom exception
	 */
	public String getLocCloseReqCondition(ConditionDto conditionDto) throws CustomException;

	/**
	 * Gets the loc chequebook act inact condition.
	 *
	 * @param conditionDto the condition dto
	 * @return the loc chequebook act inact condition
	 * @throws CustomException the custom exception
	 */
	public String getLocChequebookActInactCondition(ConditionDto conditionDto) throws CustomException;
}
