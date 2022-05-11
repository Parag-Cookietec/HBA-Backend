package gov.ifms.common.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

import javax.persistence.PersistenceException;

import gov.ifms.common.exception.CustomException;

public interface GenericDao {

	Map<String, Object> jdbcCallStoredProcedureForBillWfHeaderApi(Long trnId, Long menuId) throws CustomException;

	void executeNativeUpdateSQLQueryOnly(String queryString) throws CustomException;

	List<Object[]> executeSQLQuery(String query, Map<String, Object> var);

	List<Object[]> callSP(String spName, Map<String, Object> var);

	List<Object[]> callStoredProcedure(String spName, Map<String, Object> attributesMap);

	List<Object[]> callStoredProcedure(String spName);

	List<Object[]> executeHQLQuery(String query, Map<String, Object> var);

	<T> List<T> executeSQLQuery(String query, Map<String, Object> var, Class<T> clazz) throws CustomException;

	<T> T executeSQLQuerySingle(String query, Map<String, Object> var, Class<T> clazz) throws CustomException;
	
	<T> List<T> executeNativeSQLQuery(String queryString, Map<String, Object> attributesMap);
	
	<T> T executeNativeSQLQuerySingle(String queryString, Map<String, Object> attributesMap);

	Object[] executeNativeSQLQuerySingleResult(String queryString, Map<String, Object> attributesMap);
	
	boolean callStoreProcBatch(String queryString, List<Map<Integer, Object>> attributesMap) throws SQLException;

	<T> List<T> storeProc(String procName, Map<String, Object> map, Class<T> clazz) throws CustomException;

	<T> List<T> storeProc(String procName, Class<T> clazz) throws CustomException;

	List<Object[]> executeSQLQueryOnly(String queryString);
	
	Object callUsingCallableStmt(String spName, Map<String, Object> attributesMap);
	
	
	List<Object[]> callStoredProcedureWithNoResult(String spName, Map<String, Object> attributesMap);
	Long callSPLong(String spName, Map<String, Object> attributesMap);

	int updateDeleteSQLQuery(String query, Map<String, Object> var);

	int executeNativeUpdateSQLQuery(String queryString, Map<String, Object> attributesMap);

	Long callWfSPLong(String spName, Map<String, Object> attributesMap);

	boolean callWfStoredProcedure(String spName, Map<String, Object> attributesMap);

	List<Object[]> callStoredProcedureWithSQLErrorCode(String spName, Map<String, Object> attributesMap) throws PersistenceException;

	Map<String, Object> jdbcCallStoredProcedureForEDPWfHeaderApi(Long trnId, Long menuId) throws CustomException;

	/**
	 * Generate trn no.
	 *
	 * @param schemaName the schema name
	 * @param procedureName the procedure name
	 * @param menuCode the menu code
	 * @return the string
	 */
	String generateTrnNo(String schemaName,String procedureName,String menuCode);

	<T> List<T>  executeTypedHQLQuery(String query, Map<String, Object> var , Class<T> clazz);

	<T> T  executeTypedHQLQuerySingle(String query, Map<String, Object> var , Class<T> clazz);

	List<Object[]> callStoredProcedure(String spName, Map<String, Object> attributesMap, String outputName);


	Map<String, Object> callStoredProcedureMap(String spName,Map<String, Object> var);

	List<Object> getSingleListOfObject(String query, Map<String, Object> var );

	/**
	 * Jdbc call stored procedure for bill wf header api.
	 *
	 * @param trnId the trn id
	 * @param menuId the menu id
	 * @param officeId the office id
	 * @param paoAuditorMapId the pao auditor map id
	 * @param tokenNo the token no
	 * @return the map
	 * @throws CustomException the custom exception
	 */
	Map<String, Object> jdbcCallStoredProcedureForBillWfHeaderApi(Long trnId, Long menuId,Long officeId,Long paoAuditorMapId, String tokenNo) throws CustomException;

	boolean callStoredProcedureWithNoResultOut(String spName, Map<String, Object> attributesMap);

	BigDecimal executeNativeSQLQuerySingleResult(String queryString, Map<String, Object> attributesMap, Boolean flag);
	
	List<List> callStoredProcedureWithMultipleOutput(String spName, Map<String, Object> attributesMap) throws PersistenceException;

	Object callStoredProcedureOutParam(String spName, Map<String, Object> attributesMap);

	Object callStoredProcedureOutParams(String spName, Map<String, Object> inAttributesMap, Map<String, Object> outAttributesMap);

	List<Long> callStoredProcedureLong(String spName, Map<String, Object> attributesMap);
}
