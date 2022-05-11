package gov.ifms.edp.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.dto.ConditionDto;

public interface EDPWfConditionService {

	String getCommonCondition(ConditionDto conditionDto);

	String getConditionForAddNewDesignation(ConditionDto conditionDto);

	String getConditionForRightsMapping(ConditionDto conditionDto)throws CustomException;

}
