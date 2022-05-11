package gov.ifms.doi.jpa.pagination;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.util.Constant;

/**
 * @author Rudra
 *
 */
public class SpecificationImplimentation<T> extends gov.ifms.common.pagination.SpecificationImpl<T> implements Specification<T>, Serializable {

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
	@Override
	public SpecificationImplimentation<T> with(String key, String operation, Object value) {
		params.add(new SearchCriteria(key, operation, value));
		return this;
	}

	/**
	 * Instantiates a new specification impl.
	 */
	public SpecificationImplimentation() {
	}

	/**
	 * Instantiates a new specification impl.
	 *
	 * @param searchCriteria the search criteria
	 */
	public SpecificationImplimentation(SearchCriteria searchCriteria) {
		this.criteria = searchCriteria;
	}

	/**
	 * Builds the.
	 *
	 * @param <T> the generic type
	 * @return the specification
	 */
	@SuppressWarnings("hiding")
	@Override
	public <T> Specification<T> build() {
		if (params.isEmpty()) {
			return null;
		}

		List<Specification<T>> specs = params.stream().map(SpecificationImplimentation<T>::new).collect(Collectors.toList());

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
			Object currentValue = criteria.getValue();
			try {
				Class<? extends Comparable> javatype = path.getJavaType();
				currentValue = Utility.converter(javatype, criteria.getValue().toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return builder.equal(path, currentValue);
		}else if (criteria.getOperation().equalsIgnoreCase(">=")) {
			return greaterThanEqualToCriteria(root, builder);
		}else if (criteria.getOperation().equalsIgnoreCase("<=")) {
			return lessThanEqualToCriteria(root, builder);
		}else if (criteria.getOperation().equalsIgnoreCase(">")) {
			return greaterThanCriteria(root, builder);
		}else if (criteria.getOperation().equalsIgnoreCase("<")) {
			return lessThanCriteria(root, builder);
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	private Predicate greaterThanEqualToCriteria(Root<T> root, CriteriaBuilder builder) {
		Path<?> path = getPath(root);
		Object currentValue = criteria.getValue();
		try {
			
			@SuppressWarnings("unchecked")
			Class<? extends Comparable> clazz = (Class<? extends Comparable>) path.getJavaType();
			
			if (clazz == int.class) {
				return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), Integer.parseInt(currentValue.toString()));
			} else if (clazz == String.class) {
				return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), currentValue.toString());
			} else if (clazz == Date.class) {
				return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), new SimpleDateFormat(Utility.DATE_FORMAT).parse(currentValue.toString()));
			} else if (clazz == LocalDate.class) {
				return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), LocalDate.parse(currentValue.toString(), DateTimeFormatter.ofPattern(Utility.DATE_FORMAT)));
			} else if (clazz == Double.class) {
				return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), Double.parseDouble(currentValue.toString()));
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), currentValue.toString());
	}

	@SuppressWarnings("rawtypes")
	private Predicate greaterThanCriteria(Root<T> root, CriteriaBuilder builder) {
		Path<?> path = getPath(root);
		Object currentValue = criteria.getValue();
		try {

			@SuppressWarnings("unchecked")
			Class<? extends Comparable> clazz = (Class<? extends Comparable>) path.getJavaType();

			if (clazz == int.class) {
				return builder.greaterThan(root.get(criteria.getKey()), Integer.parseInt(currentValue.toString()));
			} else if (clazz == String.class) {
				return builder.greaterThan(root.get(criteria.getKey()), currentValue.toString());
			} else if (clazz == Date.class) {
				return builder.greaterThan(root.get(criteria.getKey()), new SimpleDateFormat(Utility.DATE_FORMAT).parse(currentValue.toString()));
			} else if (clazz == LocalDate.class) {
				return builder.greaterThan(root.get(criteria.getKey()), LocalDate.parse(currentValue.toString(), DateTimeFormatter.ofPattern(Utility.DATE_FORMAT)));
			} else if (clazz == Double.class) {
				return builder.greaterThan(root.get(criteria.getKey()), Double.parseDouble(currentValue.toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.greaterThan(root.get(criteria.getKey()), currentValue.toString());
	}
	
	@SuppressWarnings("rawtypes")
	private Predicate lessThanEqualToCriteria(Root<T> root, CriteriaBuilder builder) {
		Path<?> path = getPath(root);
		Object currentValue = criteria.getValue();
		try {
			@SuppressWarnings("unchecked")
			Class<? extends Comparable> clazz = (Class<? extends Comparable>) path.getJavaType();
			
			if (clazz == int.class) {
				return builder.lessThanOrEqualTo(root.get(criteria.getKey()), Integer.parseInt(currentValue.toString()));
			} else if (clazz == String.class) {
				return builder.lessThanOrEqualTo(root.get(criteria.getKey()), currentValue.toString());
			} else if (clazz == Date.class) {
				return builder.lessThanOrEqualTo(root.get(criteria.getKey()), new SimpleDateFormat(Utility.DATE_FORMAT).parse(currentValue.toString()));
			} else if (clazz == LocalDate.class) {
				return builder.lessThanOrEqualTo(root.get(criteria.getKey()), LocalDate.parse(currentValue.toString(), DateTimeFormatter.ofPattern(Utility.DATE_FORMAT)));
			} else if (clazz == Double.class) {
				return builder.lessThanOrEqualTo(root.get(criteria.getKey()), Double.parseDouble(currentValue.toString()));
			} else {
				return builder.lessThanOrEqualTo(root.get(criteria.getKey()), currentValue.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), currentValue.toString());
	}

	@SuppressWarnings("rawtypes")
	private Predicate lessThanCriteria(Root<T> root, CriteriaBuilder builder) {
		Path<?> path = getPath(root);
		Object currentValue = criteria.getValue();
		try {
			@SuppressWarnings("unchecked")
			Class<? extends Comparable> clazz = (Class<? extends Comparable>) path.getJavaType();

			if (clazz == int.class) {
				return builder.lessThan(root.get(criteria.getKey()), Integer.parseInt(currentValue.toString()));
			} else if (clazz == String.class) {
				return builder.lessThan(root.get(criteria.getKey()), currentValue.toString());
			} else if (clazz == Date.class) {
				return builder.lessThan(root.get(criteria.getKey()), new SimpleDateFormat(Utility.DATE_FORMAT).parse(currentValue.toString()));
			} else if (clazz == LocalDate.class) {
				return builder.lessThan(root.get(criteria.getKey()), LocalDate.parse(currentValue.toString(), DateTimeFormatter.ofPattern(Utility.DATE_FORMAT)));
			} else if (clazz == Double.class) {
				return builder.lessThan(root.get(criteria.getKey()), Double.parseDouble(currentValue.toString()));
			} else {
				return builder.lessThan(root.get(criteria.getKey()), currentValue.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.lessThan(root.get(criteria.getKey()), currentValue.toString());
	}

	@SuppressWarnings("rawtypes")
	@Override
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