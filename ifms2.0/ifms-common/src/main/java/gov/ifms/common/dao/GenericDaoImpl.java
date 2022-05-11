package gov.ifms.common.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import org.hibernate.internal.SessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.util.StringUtils;

import java.sql.*;
import java.util.*;

public class GenericDaoImpl implements GenericDao {

	/** The Constant STRING2. */
	private static final String STRING2 = "}";

	/** The Constant STRING. */
	private static final String STRING = "{";

	Logger logger = LoggerFactory.getLogger(GenericDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PersistenceContext
	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> executeSQLQuery(String queryString, Map<String, Object> attributesMap) {
		final Query query = entityManager.createNativeQuery(queryString);
		setQueryMap(query, attributesMap);
		return !StringUtils.isEmpty(query) ? query.getResultList() : Collections.emptyList();
	}

	private void setQueryMap(final Query query, final Map<String, Object> attributesMap) {
		if (!StringUtils.isEmpty(attributesMap)) {
			attributesMap.forEach(query::setParameter);
		}
	}

	private void setQueryMap(PreparedStatement cs, List<Map<Integer, Object>> attributesMap) throws NumberFormatException, SQLException {
		if (!StringUtils.isEmpty(attributesMap)) {
			for(Map<Integer, Object> map : attributesMap ){
				Iterator<Entry<Integer, Object>> itr = map.entrySet().iterator();
				while(itr.hasNext()) {
					Entry<Integer, Object> mapEntry = itr.next();
					if (mapEntry.getValue() instanceof Integer) {
						cs.setInt(mapEntry.getKey(), Integer.parseInt(mapEntry.getValue().toString()));
					} else if (mapEntry.getValue() instanceof String) {
						cs.setString(mapEntry.getKey(), mapEntry.getValue().toString());
					} else if (mapEntry.getValue() instanceof Long) {
						cs.setLong(mapEntry.getKey(),Long.parseLong(mapEntry.getValue().toString()));
					} else {
						cs.setNull(mapEntry.getKey(), Types.BIGINT);
					}
				}
				cs.addBatch();
			}
			/*
			attributesMap.stream().forEach(mapData -> {
				mapData.entrySet().forEach(mapEntry -> {
					try {
						if (mapEntry.getValue() instanceof Integer) {
							cs.setInt(mapEntry.getKey(), Integer.parseInt(mapEntry.getValue().toString()));
						} else if (mapEntry.getValue() instanceof String) {
							cs.setString(mapEntry.getKey(), mapEntry.getValue().toString());
						} else {
							cs.setLong(mapEntry.getKey(),
									mapEntry.getValue() != null ? Long.parseLong(mapEntry.getValue().toString())
											: null);
						}
					} catch (SQLException e) {
						e.printStackTrace();
						e.getNextException();
					}
				});
				try {
					cs.addBatch();
				} catch (SQLException e) {
					e.printStackTrace();
					e.getNextException();
				}
			});*/
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> callSP(String spName, Map<String, Object> attributesMap) {
		Query query = entityManager.createNativeQuery(Constant.CALL.concat(spName));
		setQueryMap(query, attributesMap);
		return !StringUtils.isEmpty(query) ? query.getResultList() : Collections.emptyList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> callStoredProcedure(String spName, Map<String, Object> attributesMap) {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
			checkInstance(entry, query);
			query.setParameter(entry.getKey(), entry.getValue());
		}
		query.registerStoredProcedureParameter(Constant.PROC_RESULT, Class.class, ParameterMode.OUT);
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> callStoredProcedure(String spName, Map<String, Object> attributesMap,String outputName) {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
			checkInstance(entry, query);
			query.setParameter(entry.getKey(), entry.getValue());
		}
		query.registerStoredProcedureParameter(outputName, Class.class, ParameterMode.OUT);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> callStoredProcedure(String spName) {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		query.registerStoredProcedureParameter(Constant.PROC_RESULT, Class.class, ParameterMode.OUT);
		return query.getResultList();
	}


	public StoredProcedureQuery checkInstance(Entry<String, Object> entry, StoredProcedureQuery query) {
		if (entry.getValue() instanceof Integer) {
			query.registerStoredProcedureParameter(entry.getKey(), Integer.class, ParameterMode.IN);
		} else if (entry.getValue() instanceof Long) {
			query.registerStoredProcedureParameter(entry.getKey(), Long.class, ParameterMode.IN);
		} else if (entry.getValue() instanceof BigInteger) {
			query.registerStoredProcedureParameter(entry.getKey(), BigInteger.class, ParameterMode.IN);
		} else if (entry.getValue() instanceof String) {
			query.registerStoredProcedureParameter(entry.getKey(), String.class, ParameterMode.IN);
		} else if (entry.getValue() instanceof Date) {
			query.registerStoredProcedureParameter(entry.getKey(), Date.class, ParameterMode.IN);
		} else if(entry.getValue() instanceof Double){
			query.registerStoredProcedureParameter(entry.getKey(), Double.class, ParameterMode.IN);
		}else if(entry.getValue() instanceof BigDecimal){
			query.registerStoredProcedureParameter(entry.getKey(), BigDecimal.class, ParameterMode.IN);
		}else {
			query.registerStoredProcedureParameter(entry.getKey(), Object.class, ParameterMode.IN);
		}
		return query;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> executeHQLQuery(String queryString, Map<String, Object> attributesMap) {
		final Query query = entityManager.createQuery(queryString);
		setQueryMap(query, attributesMap);
		return !StringUtils.isEmpty(query) ? query.getResultList() : Collections.emptyList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> executeSQLQuery(String queryString, Map<String, Object> attributesMap, Class<T> clazz)
			throws CustomException {
		final Query query = entityManager.createNativeQuery(queryString);
		setQueryMap(query, attributesMap);
		return !StringUtils.isEmpty(query) ? NativeQueryResultsMapper.map(query.getResultList(), clazz)
				: Collections.emptyList();
	}

	@Override
	public <T> T executeSQLQuerySingle(String queryString, Map<String, Object> attributesMap, Class<T> clazz)
			throws CustomException {
		final Query query = entityManager.createNativeQuery(queryString);
		setQueryMap(query, attributesMap);
		T t = null;
		try {
			t = NativeQueryResultsMapper.map(query.getSingleResult(), clazz);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> executeNativeSQLQuery(String queryString, Map<String, Object> attributesMap) {
		try {
			Query query = entityManager.createNativeQuery(queryString);
			setQueryMap(query, attributesMap);
			return (List<T>) query.getResultList();
		} catch (NoResultException e) {
			return Collections.emptyList();
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T executeNativeSQLQuerySingle(String queryString, Map<String, Object> attributesMap) {
		try {
			Query query = entityManager.createNativeQuery(queryString);
			setQueryMap(query, attributesMap);
			return (T) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}


	@Override
	public boolean callStoreProcBatch(String queryString, List<Map<Integer, Object>> attributesMap)
			throws SQLException {
		try(Connection cn = ((SessionImpl) entityManager.getDelegate()).connection()) {
			PreparedStatement ps = cn.prepareStatement(queryString);
			setQueryMap(ps, attributesMap);
			ps.executeBatch();
			return true;
		} catch (NoResultException|BatchUpdateException e) {
			logger.error(e.getMessage());
			return false;
		}
	}

	public Object[] executeNativeSQLQuerySingleResult(String queryString, Map<String, Object> attributesMap) {
		try {
			Query query = entityManager.createNativeQuery(queryString);
			setQueryMap(query, attributesMap);
			return (Object[]) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public <T> List<T> storeProc(String procName, Class<T> clazz) throws CustomException {
		List<Object[]> objectPvuSp = callStoredProcedure(procName);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, clazz) : Collections.emptyList();
	}

	@Override
	public <T> List<T> storeProc(String procName, Map<String, Object> map, Class<T> clazz) throws CustomException {
		List<Object[]> objectPvuSp = callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, clazz) : Collections.emptyList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> executeSQLQueryOnly(String queryString) {
		final Query query = entityManager.createNativeQuery(queryString);
		return !StringUtils.isEmpty(query) ? query.getResultList() : Collections.emptyList();
	}

	@Override
	public Object callUsingCallableStmt(String spName, Map<String, Object> attributesMap) {
		try{
			Connection cn = ((SessionImpl) entityManager.getDelegate()).connection();
			String queryString = "{call "+ spName +"(?, ?)}";
			CallableStatement cs = cn.prepareCall(queryString);
			for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
				cs.setString(entry.getKey(), entry.getValue().toString());
			}
			cs.registerOutParameter(Constant.PROC_RESULT.toUpperCase(), java.sql.Types.BIGINT);
			cs.executeUpdate();
			return cs.getObject(Constant.PROC_RESULT.toUpperCase());
		} catch (NoResultException|SQLException e) {
			logger.error(e.getMessage());
			return false;
		} 

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> callStoredProcedureWithSQLErrorCode(String spName, Map<String, Object> attributesMap) throws PersistenceException {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
			checkInstance(entry, query);
			query.setParameter(entry.getKey(), entry.getValue());
		}
		query.registerStoredProcedureParameter(Constant.PROC_RESULT, Class.class, ParameterMode.OUT);
		return query.getResultList();

	}
	@Override
	public List<List> callStoredProcedureWithMultipleOutput(String spName, Map<String, Object> attributesMap) throws PersistenceException {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
			checkInstance(entry, query);
			query.setParameter(entry.getKey(), entry.getValue());
		}
		query.registerStoredProcedureParameter(Constant.PROC_RESULT, Class.class, ParameterMode.OUT);
		query.registerStoredProcedureParameter(Constant.PROC_RESULT_TWO, Class.class, ParameterMode.OUT);
		List<List> multilist = new ArrayList<List>();
		do
		{
			int i=0;
			List<Objects> list=query.getResultList();
			multilist.add(i,list);
		}while(query.hasMoreResults());
		return multilist;
	}

	@Override
	public Object callStoredProcedureOutParam(String spName, Map<String, Object> attributesMap) {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
			checkInstance(entry, query);
			query.setParameter(entry.getKey(), entry.getValue());
		}
		query.registerStoredProcedureParameter(Constant.PROC_RESULT, String.class, ParameterMode.OUT);
		return query.getOutputParameterValue(Constant.PROC_RESULT);
	}

	@Override
	public Object callStoredProcedureOutParams(String spName, Map<String, Object> inAttributesMap, Map<String, Object> outAttributesMap) {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		inAttributesMap.entrySet().stream().forEach(e -> {
			checkInstance(e, query);
			query.setParameter(e.getKey(), e.getValue());
		});
		outAttributesMap.entrySet().stream().forEach(e -> {
			checkInstanceOut(e, query);
		});
		query.execute();
		outAttributesMap.entrySet().stream().forEach(e -> e.setValue(query.getOutputParameterValue(e.getKey())));
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> callStoredProcedureWithNoResult(String spName, Map<String, Object> attributesMap) {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
			checkInstance(entry, query);
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
	}
	
	@Override
	public Long callSPLong(String spName, Map<String, Object> attributesMap) {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
			checkInstanceDefaultLong(entry, query);
			query.setParameter(entry.getKey(), entry.getValue());
		}
		query.registerStoredProcedureParameter(Constant.PROC_RESULT, Class.class, ParameterMode.OUT);
		return Long.parseLong(query.getSingleResult().toString());
	}
	public StoredProcedureQuery checkInstanceDefaultLong(Entry<String, Object> entry, StoredProcedureQuery query) {
		if (entry.getValue() instanceof Integer) {
			query.registerStoredProcedureParameter(entry.getKey(), Integer.class, ParameterMode.IN);
		} else if (entry.getValue() instanceof Long) {
			query.registerStoredProcedureParameter(entry.getKey(), Long.class, ParameterMode.IN);
		} else if (entry.getValue() instanceof Double) {
			query.registerStoredProcedureParameter(entry.getKey(), Double.class, ParameterMode.IN);
		}  else if (entry.getValue() instanceof String) {
			query.registerStoredProcedureParameter(entry.getKey(), String.class, ParameterMode.IN);
		} else {
			query.registerStoredProcedureParameter(entry.getKey(), Long.class, ParameterMode.IN);
		}
		return query;
	}

	@Override
	public int updateDeleteSQLQuery(String query, Map<String, Object> var) {
		Query q = null;
		q = getEntityManager().createNativeQuery(query);
		setQueryMapData(q, var);
		return q == null ? 0 : q.executeUpdate();
	}

	private void setQueryMapData(Query q, Map<String, Object> var) {
		if (var != null) {
			Set<String> varnames = var.keySet();
			for (String key : varnames) {
				Object val = var.get(key);
				if (val instanceof String) {
					q.setParameter(key, val.toString());
				} else if (val instanceof Integer) {
					q.setParameter(key, val);
				} else if (val instanceof Date) {
					q.setParameter(key, val);
				} else if (val instanceof Long) {
					q.setParameter(key, val);
				} else if (val instanceof Object[]) {
					q.setParameter(key, (Object[]) val);
				} else if (val instanceof Collection) {
					q.setParameter(key, (Collection) val);
				} else if (val instanceof Double) {
					q.setParameter(key, (Double) val);
				} else if (val instanceof BigDecimal) {
					q.setParameter(key, (BigDecimal) val);
				}
			}
		}
	}


	@Transactional
	@Override
	public int executeNativeUpdateSQLQuery(String queryString, Map<String, Object> attributesMap) {
		try {
			Query query = entityManager.createNativeQuery(queryString);
			setQueryMap(query, attributesMap);
			entityManager.joinTransaction();
			return query.executeUpdate();
		} catch (NoResultException e) {
			return 0;
		}
	}

	@Override
	public Long callWfSPLong(String spName, Map<String, Object> attributesMap) {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
			checkInstanceForWf(entry, query);
			query.setParameter(entry.getKey(), entry.getValue());
		}
		//query.registerStoredProcedureParameter(Constant.PROC_RESULT, Class.class, ParameterMode.OUT);
		return Long.parseLong(query.getSingleResult().toString());
	}

	public StoredProcedureQuery checkInstanceForWf(Entry<String, Object> entry, StoredProcedureQuery query) {
		if (entry.getValue() instanceof Integer) {
			query.registerStoredProcedureParameter(entry.getKey(), Integer.class, ParameterMode.IN);
		} else if (entry.getValue() instanceof String) {
			query.registerStoredProcedureParameter(entry.getKey(), String.class, ParameterMode.IN);
		} else {
			query.registerStoredProcedureParameter(entry.getKey(), Long.class, ParameterMode.IN);
		}
		return query;
	}

	@Override
	public boolean callWfStoredProcedure(String spName, Map<String, Object> attributesMap) {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
			checkInstanceForWf(entry, query);
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.execute();
	}

	/**
	 * Jdbc call stored procedure for EDP wf header api.
	 *
	 * @param trnId the trn id
	 * @param menuId the menu id
	 * @return the map
	 * @throws CustomException the custom exception
	 */
	@Override
	public Map<String, Object> jdbcCallStoredProcedureForEDPWfHeaderApi(Long trnId, Long menuId) throws CustomException {
		try {
			final String procedureCall = getStoreProcName();
			Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection connection) throws SQLException {
				CallableStatement callableStatement = connection.prepareCall(procedureCall);
				callableStatement.setLong(1, trnId);
				callableStatement.setLong(2, menuId);
				callableStatement.registerOutParameter(3, Types.VARCHAR);
				return callableStatement;
				}
			}, getParamaterForEdpWfHeaderApiCall(trnId,menuId));
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(ErrorResponse.ERROR_WHILE_CALL_SP);
		}
	}
	
	/**
	 * Gets the paramater for edp wf header api call.
	 *
	 * @param trnId the trn id
	 * @param menuId the menu id
	 * @return the paramater for edp wf header api call
	 */
	public List<SqlParameter> getParamaterForEdpWfHeaderApiCall(Long trnId,Long menuId){
		SqlParameter trnParameter = new SqlParameter(Types.BIGINT);
		SqlParameter menuIdParameter = new SqlParameter(Types.BIGINT);
		SqlOutParameter outParameter = new SqlOutParameter("getResult", Types.VARCHAR);

		List<SqlParameter> paramList = new ArrayList<>();
		paramList.add(trnParameter);
		paramList.add(menuIdParameter);
		paramList.add(outParameter );
		return paramList;
	}

	/**
	 * Gets the store proc name.
	 *
	 * @param spCallableString the sp callable string
	 * @return the store proc name
	 */
	private String getStoreProcName() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(STRING);
		stringBuilder.append(Constant.EDP_WF_COMMAN_HEADER_SP_NAME);
		stringBuilder.append(STRING2);
		final String procedureCall = stringBuilder.toString();
		return procedureCall;
	}

	/**
	 * Generate edp trn no.
	 *
	 * @param schemaName the schema name
	 * @param menuCode the proc name
	 * @param procedureName the trn screen
	 * @return the string
	 */
	@Override
	public String generateTrnNo(String schemaName,String procedureName,String menuCode) {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(Constant.TRN_SCREEN, menuCode);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(procedureName));
		List<Object[]> responseList = callStoredProcedure(procName, argMap);
		if (null == responseList.get(0))
			return "";
		else {
			return String.valueOf(responseList.get(0));
		}
	}

	@Override
	public <T> List<T> executeTypedHQLQuery(String queryString, Map<String, Object> attributesMap , Class<T> clazz) {
		TypedQuery<T> query = entityManager.createQuery(queryString ,clazz);
		setQueryMap(query, attributesMap);
		return !StringUtils.isEmpty(query) ? query.getResultList() : Collections.emptyList();
	}

	@Override
	public <T> T executeTypedHQLQuerySingle(String queryString, Map<String, Object> attributesMap , Class<T> clazz) {
		TypedQuery<T> query = entityManager.createQuery(queryString ,clazz);
		setQueryMap(query, attributesMap);
		return !StringUtils.isEmpty(query) ? query.getSingleResult() : null;
	}

	@Override
	public Map<String, Object> callStoredProcedureMap(String spName, Map<String, Object> var) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withSchemaName(spName.split("\\.")[0])
				.withProcedureName(spName.split("\\.")[1]);
		SqlParameterSource in = new MapSqlParameterSource(var);
		return simpleJdbcCall.execute(in);
	}

	@Override
	public List<Object> getSingleListOfObject(String query, Map<String, Object> var) {
		Query queryString = entityManager.createNativeQuery(query);
		setQueryMap(queryString, var);
		return  queryString.getResultList();
	}


	

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
	@Override
	public Map<String, Object> jdbcCallStoredProcedureForBillWfHeaderApi(Long trnId, Long menuId, Long officeId, Long paoAuditorMapId, String tokenNo)
			throws CustomException {
		try {
			final String procedureCall = getPAOBillWfStoreProcName();
			return jdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection connection) throws SQLException {
					CallableStatement callableStatement = connection.prepareCall(procedureCall);
					callableStatement.registerOutParameter(1, Types.VARCHAR);
					callableStatement.setLong(2, trnId);
					callableStatement.setLong(3, menuId);
					callableStatement.setLong(4, officeId);
					callableStatement.setLong(5, paoAuditorMapId != null ? paoAuditorMapId : 0l);
					callableStatement.setString(6, tokenNo != null ? tokenNo : Constant.DASH);
					return callableStatement;
				}
			}, getParamaterForBillWfHeaderApiCall());
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(ErrorResponse.ERROR_WHILE_CALL_SP);
		}
	}

	/**
	 * Gets the paramater for bill wf header api call.
	 *
	 * @return the paramater for bill wf header api call
	 */
	private List<SqlParameter> getParamaterForBillWfHeaderApiCall() {
		SqlParameter trnParameter = new SqlParameter(Types.BIGINT);
		SqlParameter menuIdParameter = new SqlParameter(Types.BIGINT);
		SqlParameter officeIdParameter = new SqlParameter(Types.BIGINT);
		SqlParameter paoAuditorMapIdParameter = new SqlParameter(Types.BIGINT);
		SqlParameter tokenNoParameter = new SqlParameter(Types.VARCHAR);
		SqlOutParameter outParameter = new SqlOutParameter("getResult", Types.VARCHAR);

		List<SqlParameter> paramList = new ArrayList<>();
		paramList.add(outParameter );
		paramList.add(trnParameter);
		paramList.add(menuIdParameter);
		paramList.add(officeIdParameter);
		paramList.add(paoAuditorMapIdParameter);
		paramList.add(tokenNoParameter);
		return paramList;
	}

	/**
	 * Gets the PAO bill wf store proc name.
	 *
	 * @return the PAO bill wf store proc name
	 */
	private String getPAOBillWfStoreProcName() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(STRING);
		stringBuilder.append(Constant.BILL_PAO_WF_COMMON_HEADER_SP_NAME);
		stringBuilder.append(STRING2);
		return stringBuilder.toString();
	}
	@Transactional
	@Override
	public void executeNativeUpdateSQLQueryOnly(String queryString) throws CustomException{
		try {
			Query query = entityManager.createNativeQuery(queryString);
			entityManager.joinTransaction();
			query.executeUpdate();
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE);
		}
	}

	public Map<String, Object> jdbcCallStoredProcedureForBillWfHeaderApi(Long trnId, Long menuId)
			throws CustomException {
		try {
			final String procedureCall = getPAOBillWfStoreProcName();
			Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection connection) throws SQLException {
				CallableStatement callableStatement = connection.prepareCall(procedureCall);
				callableStatement.setLong(1, trnId);
				callableStatement.setLong(2, menuId);
				callableStatement.registerOutParameter(3, Types.VARCHAR);
				return callableStatement;
				}
			}, getParamaterForEdpWfHeaderApiCall(trnId,menuId));
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(ErrorResponse.ERROR_WHILE_CALL_SP);
		}
	}

	@Override
    public boolean callStoredProcedureWithNoResultOut(String spName, Map<String, Object> attributesMap) {
        StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
        for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
            checkInstance(entry, query);
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.execute();
    }

	public StoredProcedureQuery checkInstanceOut(Entry<String, Object> entry, StoredProcedureQuery query) {
		if (entry.getValue() instanceof Integer) {
			query.registerStoredProcedureParameter(entry.getKey(), Integer.class, ParameterMode.OUT);
		} else if (entry.getValue() instanceof Long) {
			query.registerStoredProcedureParameter(entry.getKey(), Long.class, ParameterMode.OUT);
		} else if (entry.getValue() instanceof BigInteger) {
			query.registerStoredProcedureParameter(entry.getKey(), BigInteger.class, ParameterMode.OUT);
		} else if (entry.getValue() instanceof String) {
			query.registerStoredProcedureParameter(entry.getKey(), String.class, ParameterMode.OUT);
		} else if (entry.getValue() instanceof Date) {
			query.registerStoredProcedureParameter(entry.getKey(), Date.class, ParameterMode.OUT);
		} else if(entry.getValue() instanceof Double){
			query.registerStoredProcedureParameter(entry.getKey(), Double.class, ParameterMode.OUT);
		}else if(entry.getValue() instanceof BigDecimal){
			query.registerStoredProcedureParameter(entry.getKey(), BigDecimal.class, ParameterMode.OUT);
		}else {
			query.registerStoredProcedureParameter(entry.getKey(), Long.class, ParameterMode.OUT);
		}
		return query;
	}
	@Override
    public BigDecimal executeNativeSQLQuerySingleResult(String queryString, Map<String, Object> attributesMap,
            Boolean flag) {
        try {
            Query query = entityManager.createNativeQuery(queryString);
            setQueryMap(query, attributesMap);
            return (BigDecimal) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Long> callStoredProcedureLong(String spName, Map<String, Object> attributesMap) {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
			checkInstance(entry, query);
			query.setParameter(entry.getKey(), entry.getValue());
		}
		query.registerStoredProcedureParameter(Constant.PROC_RESULT, Class.class, ParameterMode.OUT);
		return query.getResultList();
	}

}
