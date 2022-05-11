package gov.ifms.dmo.dao;

import java.util.List;
import java.util.Map;

public interface GenericDao {

	List<Object[]> callStoredProcedure(String spName, Map<String, Object> attributesMap);
}
