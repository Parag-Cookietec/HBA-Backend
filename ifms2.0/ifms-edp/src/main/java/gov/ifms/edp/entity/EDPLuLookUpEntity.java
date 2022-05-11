package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;


/**
 * The Class EDPLuLookUpEntity.
 */
@Entity
@Table(name = "LU_LOOKUP", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLuLookUpEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The look up id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOOKUP_ID")
	private long lookUpId;

	/** The look up name. */
	@Column(name = "LOOKUP_NAME")
	private String lookUpName;

	/** The look up name guj. */
	@Column(name = "LOOKUP_NAME_GUJ")
	private String lookUpNameGuj;

	/** The look up description. */
	@Column(name = "LOOKUP_DESCRIPTION")
	private String lookUpDescription;

	/** The look up description guj. */
	@Column(name = "LOOKUP_DESCRIPTION_GUJ")
	private String lookUpDescriptionGuj;

	/** The order id. */
	@Column(name = "ORDER_ID")
	private short orderId;

	/**
	 * Gets the look up id.
	 *
	 * @return the lookUpId
	 */
	public long getLookUpId() {
		return lookUpId;
	}

	/**
	 * Sets the look up id.
	 *
	 * @param lookUpId the lookUpId to set
	 */
	public void setLookUpId(long lookUpId) {
		this.lookUpId = lookUpId;
	}

	/**
	 * Gets the look up name.
	 *
	 * @return the lookUpName
	 */
	public String getLookUpName() {
		return lookUpName;
	}

	/**
	 * Sets the look up name.
	 *
	 * @param lookUpName the lookUpName to set
	 */
	public void setLookUpName(String lookUpName) {
		this.lookUpName = lookUpName;
	}

	/**
	 * Gets the look up name guj.
	 *
	 * @return the lookUpNameGuj
	 */
	public String getLookUpNameGuj() {
		return lookUpNameGuj;
	}

	/**
	 * Sets the look up name guj.
	 *
	 * @param lookUpNameGuj the lookUpNameGuj to set
	 */
	public void setLookUpNameGuj(String lookUpNameGuj) {
		this.lookUpNameGuj = lookUpNameGuj;
	}

	/**
	 * Gets the look up description.
	 *
	 * @return the lookUpDescription
	 */
	public String getLookUpDescription() {
		return lookUpDescription;
	}

	/**
	 * Sets the look up description.
	 *
	 * @param lookUpDescription the lookUpDescription to set
	 */
	public void setLookUpDescription(String lookUpDescription) {
		this.lookUpDescription = lookUpDescription;
	}

	/**
	 * Gets the look up description guj.
	 *
	 * @return the lookUpDescriptionGuj
	 */
	public String getLookUpDescriptionGuj() {
		return lookUpDescriptionGuj;
	}

	/**
	 * Sets the look up description guj.
	 *
	 * @param lookUpDescriptionGuj the lookUpDescriptionGuj to set
	 */
	public void setLookUpDescriptionGuj(String lookUpDescriptionGuj) {
		this.lookUpDescriptionGuj = lookUpDescriptionGuj;
	}

	/**
	 * Instantiates a new EDP lu look up entity.
	 */
	public EDPLuLookUpEntity() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lookUpDescription, lookUpDescriptionGuj, lookUpId, lookUpName, lookUpNameGuj, orderId);
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
		if (!(obj instanceof EDPLuLookUpEntity)) {
			return false;
		}
		EDPLuLookUpEntity other = (EDPLuLookUpEntity) obj;
		return Objects.equals(lookUpDescription, other.lookUpDescription)
				&& Objects.equals(lookUpDescriptionGuj, other.lookUpDescriptionGuj) && lookUpId == other.lookUpId
				&& Objects.equals(lookUpName, other.lookUpName) && Objects.equals(lookUpNameGuj, other.lookUpNameGuj)
				&& orderId == other.orderId;
	}

}
