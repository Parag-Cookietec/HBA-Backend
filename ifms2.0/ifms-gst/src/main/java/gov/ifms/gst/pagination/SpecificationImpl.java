package gov.ifms.gst.pagination;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import gov.ifms.common.util.Constant;

/**
 * The Class SpecificationImpl.
 *
 * @param <T> the generic type
 * @param <T>
 */
public class SpecificationImpl<T> implements Specification<T>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The criteria. */
	private SearchCriteria criteria;

	/** The params. */
	private List<SearchCriteria> params = new ArrayList<>();

	/**
	 * With.
	 *
	 * @param key       the key
	 * @param operation the operation
	 * @param value     the value
	 * @return the specification impl
	 */
	public SpecificationImpl<T> with(String key, String operation, Object value) {
		params.add(new SearchCriteria(key, operation, value));
		return this;
	}

	/**h
	 * Instantiates a new specification impl.
	 */
	public SpecificationImpl() {
	}

	/**
	 * Instantiates a new specification impl.
	 *
	 * @param searchCriteria the search criteria
	 */
	public SpecificationImpl(SearchCriteria searchCriteria) {
		this.criteria = searchCriteria;
	}

	/**
	 * Builds the.
	 *
	 * @param <T> the generic type
	 * @return the specification
	 */
	@SuppressWarnings("hiding")
	public <T> Specification<T> build() {
		if (params.isEmpty()) {
			return null;
		}

		List<Specification<T>> specs = params.stream().map(SpecificationImpl<T>::new).collect(Collectors.toList());

		Specification<T> result = specs.get(0);

		for (int i = 1; i < params.size(); i++) {
			result = Specification.where(result).and(specs.get(i));
		}
		return result;
	}

	/**
	 * To predicate.
	 *
	 * @param root    the root
	 * @param query   the query
	 * @param builder the builder
	 * @return the predicate
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		if (criteria.getOperation().equalsIgnoreCase(Constant.COLON)) {
			Path<Comparable> path = getPath(root);

			return builder.equal(path, criteria.getValue());
		}else if(criteria.getOperation().equalsIgnoreCase(">=")){
			return builder.greaterThanOrEqualTo(root.get(criteria.getKey()).as(Date.class), (Date) criteria.getValue());
		}else if(criteria.getOperation().equalsIgnoreCase("<=")){
			return builder.lessThanOrEqualTo(root.get(criteria.getKey()).as(Date.class), (Date) criteria.getValue());
		}else if(criteria.getOperation().equalsIgnoreCase(">")){
			return builder.greaterThan(root.get(criteria.getKey()).as(Date.class), (Date) criteria.getValue());
		}else if(criteria.getOperation().equalsIgnoreCase("<")){
			return builder.lessThan(root.get(criteria.getKey()).as(Date.class), (Date) criteria.getValue());
		}else if(criteria.getOperation().equalsIgnoreCase("like")){
			return builder.like(root.get(criteria.getKey()), criteria.getValue().toString());
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	protected Path<Comparable> getPath(Root<T> root) {
		Path<Comparable> path;
		if (criteria.getKey().contains(".")) {
			String[] split = criteria.getKey().split("\\.");
			int keyPosition = 0;
			path = root.get(split[keyPosition]);
			for (String criteriaKeys : split) {
				if (keyPosition > 0) {
					path = path.get(criteriaKeys);
				}
				keyPosition++;
			}
		} else {
			path = root.get(criteria.getKey());
		}
		return path;
	}

}