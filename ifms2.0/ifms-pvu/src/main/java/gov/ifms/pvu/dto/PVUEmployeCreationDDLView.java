package gov.ifms.pvu.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Objects;


/**
 * The Class PVUEmployeAddressView.
 *
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 *
 */
@NativeQueryResultEntity
public class PVUEmployeCreationDDLView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lookup type. */
	@JsonIgnore
	@NativeQueryResultColumn(index = 0)
	private String lookupType;

	/** The lookup info id. */
	@NativeQueryResultColumn(index = 1)
	private Long lookupInfoId;

	/** The lookup info name. */
	@NativeQueryResultColumn(index = 2)
	private String lookupInfoName;

	/**
	 * Gets the lookup type.
	 *
	 * @return the lookup type
	 */
	public String getLookupType() {
		return lookupType;
	}

	/**
	 * Sets the lookup type.
	 *
	 * @param lookupType the new lookup type
	 */
	public void setLookupType(String lookupType) {
		this.lookupType = lookupType.replaceAll("\\s+", "");
	}

	/**
	 * Gets the lookup info id.
	 *
	 * @return the lookup info id
	 */
	public Long getLookupInfoId() {
		return lookupInfoId;
	}

	/**
	 * Sets the lookup info id.
	 *
	 * @param lookupInfoId the new lookup info id
	 */
	public void setLookupInfoId(Long lookupInfoId) {
		this.lookupInfoId = lookupInfoId;
	}

	/**
	 * Gets the lookup info name.
	 *
	 * @return the lookup info name
	 */
	public String getLookupInfoName() {
		return lookupInfoName;
	}

	/**
	 * Sets the lookup info name.
	 *
	 * @param lookupInfoName the new lookup info name
	 */
	public void setLookupInfoName(String lookupInfoName) {
		this.lookupInfoName = lookupInfoName;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lookupInfoId, lookupInfoName, lookupType);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUEmployeCreationDDLView)) {
			return false;
		}
		PVUEmployeCreationDDLView other = (PVUEmployeCreationDDLView) obj;
		return Objects.equals(lookupInfoId, other.lookupInfoId) && Objects.equals(lookupInfoName, other.lookupInfoName)
				&& Objects.equals(lookupType, other.lookupType);
	}

	public PVUEmployeCreationDDLView(String lookupType, Long lookupInfoId, String lookupInfoName) {
		this.lookupType = lookupType;
		this.lookupInfoId = lookupInfoId;
		this.lookupInfoName = lookupInfoName;
	}

	public PVUEmployeCreationDDLView() {
	}
}
