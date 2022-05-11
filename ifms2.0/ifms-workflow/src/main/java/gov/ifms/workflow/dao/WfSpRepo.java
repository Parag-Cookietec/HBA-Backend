package gov.ifms.workflow.dao;

import java.util.List;
import java.util.Map;

/**
 *  The interface WfSpRepo
 */
public interface WfSpRepo{
	/**
	 * callWfSP
	 *
	 * @param spName
	 * @param attributesMap
	 * @return the list
	 */
	List<Object[]> callWfSP(String spName, Map<String, Object> attributesMap);

	/**
	 * callWfSPLong
	 *
	 * @param spName
	 * @param attributesMap
	 * @return the long
	 */
	Long callWfSPLong(String spName, Map<String, Object> attributesMap);
}
