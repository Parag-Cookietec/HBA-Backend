package gov.ifms.common.pagination;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.util.Constant;

/**
 * The Class SearchCriteria.
 */
public class SearchCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The key. */
	private String key;

	/** The operation. */
	private String operation;

	/** The value. */
	private transient Object value;

	/**
	 * Instantiates a new search criteria.
	 *
	 * @param key the key
	 * @param operation the operation
	 * @param value the value
	 */
	public SearchCriteria(String key, String operation, Object value) {
		this.key = key;
		this.operation = operation;
		this.value = value;
	}

	/**
	 * Instantiates a new search criteria.
	 */
	public SearchCriteria() {
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Gets the operation.
	 *
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * Sets the operation.
	 *
	 * @param operation the new operation
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * Gets the specification details.
	 *
	 * @param <T> the generic type
	 * @param spec the spec
	 * @param jsonArr the json arr
	 * @return the specification details
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public <T> Specification<T> getSpecificationDetails(SpecificationImpl<T> spec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));
			
		}

		return spec.build();
	}

	 
	public <MsWorkflowEntity> Specification<MsWorkflowEntity> getSpecificationDetail(SpecificationImpl<MsWorkflowEntity> empSpec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			empSpec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));
		}

		return  empSpec.build();
	}
}
