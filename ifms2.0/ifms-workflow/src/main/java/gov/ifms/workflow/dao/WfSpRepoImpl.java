package gov.ifms.workflow.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Component;

import gov.ifms.common.util.Constant;

/**
 * The Class WfSpRepoImpl
 */
@Component
public class WfSpRepoImpl implements WfSpRepo {

	/**
	 * The EntityManager
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * setEntityManager
	 * @param entityManager
	 */
	@PersistenceContext
	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * getEntityManager
	 *
	 * @return EntityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 *
	 * @param spName
	 * @param attributesMap
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> callWfSP(String spName, Map<String, Object> attributesMap) {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
			checkInstance(entry, query);
			query.setParameter(entry.getKey(), entry.getValue());
		}
		query.registerStoredProcedureParameter(Constant.PROC_RESULT, Class.class, ParameterMode.OUT);
		return query.getResultList();
	}

	/**
	 * checkInstance
	 *
	 * @param entry
	 * @param query
	 * @return the query
	 */
	public StoredProcedureQuery checkInstance(Entry<String, Object> entry, StoredProcedureQuery query) {
		if (entry.getValue() instanceof Integer) {
			query.registerStoredProcedureParameter(entry.getKey(), Integer.class, ParameterMode.IN);
		} else if (entry.getValue() instanceof String) {
			query.registerStoredProcedureParameter(entry.getKey(), String.class, ParameterMode.IN);
		} else {
			query.registerStoredProcedureParameter(entry.getKey(), Long.class, ParameterMode.IN);
		}
		return query;
	}

	/**
	 * callWfSPLong
	 *
	 * @param spName
	 * @param attributesMap
	 * @return the long
	 */
	@Override
	public Long callWfSPLong(String spName, Map<String, Object> attributesMap) {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
			checkInstance(entry, query);
			query.setParameter(entry.getKey(), entry.getValue());
		}
		query.registerStoredProcedureParameter(Constant.PROC_RESULT, Class.class, ParameterMode.OUT);
		return Long.parseLong(query.getSingleResult().toString());
	}
}
