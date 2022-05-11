package gov.ifms.pvu.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;

/**
 * The Class PVUPayDetailsView.
 */
@NativeQueryResultEntity
public class PVUPayDetailsView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lookup type. */
	@JsonIgnore
	@NativeQueryResultColumn(index = 0)
	private String lookupType;

	/** The lookup info id. */
	@NativeQueryResultColumn(index = 1)
	private Long id;

	/** The lookup info name. */
	@NativeQueryResultColumn(index = 2)
	private String name;

	@NativeQueryResultColumn(index = 3)
	private Integer order;

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}


	/**
	 * @return the lookupType
	 */
	public String getLookupType() {
		return lookupType;
	}

	/**
	 * @param lookupType the lookupType to set
	 */
	public void setLookupType(String lookupType) {
		this.lookupType = lookupType;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
