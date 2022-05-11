package gov.ifms.dmo.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import gov.ifms.common.util.Constant;

public class GenericDaoImpl implements GenericDao{

	
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
	public List<Object[]> callStoredProcedure(String spName, Map<String, Object> attributesMap) {
		StoredProcedureQuery query = getEntityManager().createStoredProcedureQuery(spName);
		for (Map.Entry<String, Object> entry : attributesMap.entrySet()) {
			checkInstance(entry, query);
			query.setParameter(entry.getKey(), entry.getValue());
		}
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
}
