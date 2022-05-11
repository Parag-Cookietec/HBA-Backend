package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsActivitiesHeadDto.
 * 
 * @version 1.0
 * @created 2019/08/31 12:56:51
 *
 */
public class EDPMsActivitiesHeadDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The activities id. */
	private long activitiesId;

	/** The activities name. */
	private String activitiesName;

	/** The activities name guj. */
	private String activitiesNameGuj;

	/** The activities desc. */
	private String activitiesDesc;

	/** The activities desc guj. */
	private String activitiesDescGuj;

	/** The activities code. */
	private String activitiesCode;

	/** The activities code guj. */
	private String activitiesCodeGuj;

	/** The activities code name. */
	private String activitiesCodeName;

	/** The activities type id. */
	private int activitiesTypeId;

	/** The parent activities id. */
	private int parentActivitiesId;

	/** The office id. */
	private long officeId;

	/**
	 * Gets the activities id.
	 *
	 * @return the activitiesId
	 */
	public long getActivitiesId() {
		return activitiesId;
	}

	/**
	 * Sets the activities id.
	 *
	 * @param activitiesId the activitiesId to set
	 */
	public void setActivitiesId(long activitiesId) {
		this.activitiesId = activitiesId;
	}

	/**
	 * Gets the activities name.
	 *
	 * @return the activitiesName
	 */
	public String getActivitiesName() {
		return activitiesName;
	}

	/**
	 * Sets the activities name.
	 *
	 * @param activitiesName the activitiesName to set
	 */
	public void setActivitiesName(String activitiesName) {
		this.activitiesName = activitiesName;
	}

	/**
	 * Gets the activities name guj.
	 *
	 * @return the activitiesNameGuj
	 */
	public String getActivitiesNameGuj() {
		return activitiesNameGuj;
	}

	/**
	 * Sets the activities name guj.
	 *
	 * @param activitiesNameGuj the activitiesNameGuj to set
	 */
	public void setActivitiesNameGuj(String activitiesNameGuj) {
		this.activitiesNameGuj = activitiesNameGuj;
	}

	/**
	 * Gets the activities desc.
	 *
	 * @return the activitiesDesc
	 */
	public String getActivitiesDesc() {
		return activitiesDesc;
	}

	/**
	 * Sets the activities desc.
	 *
	 * @param activitiesDesc the activitiesDesc to set
	 */
	public void setActivitiesDesc(String activitiesDesc) {
		this.activitiesDesc = activitiesDesc;
	}

	/**
	 * Gets the activities desc guj.
	 *
	 * @return the activitiesDescGuj
	 */
	public String getActivitiesDescGuj() {
		return activitiesDescGuj;
	}

	/**
	 * Sets the activities desc guj.
	 *
	 * @param activitiesDescGuj the activitiesDescGuj to set
	 */
	public void setActivitiesDescGuj(String activitiesDescGuj) {
		this.activitiesDescGuj = activitiesDescGuj;
	}

	/**
	 * Gets the activities code.
	 *
	 * @return the activitiesCode
	 */
	public String getActivitiesCode() {
		return activitiesCode;
	}

	/**
	 * Sets the activities code.
	 *
	 * @param activitiesCode the activitiesCode to set
	 */
	public void setActivitiesCode(String activitiesCode) {
		this.activitiesCode = activitiesCode;
	}

	/**
	 * Gets the activities code guj.
	 *
	 * @return the activitiesCodeGuj
	 */
	public String getActivitiesCodeGuj() {
		return activitiesCodeGuj;
	}

	/**
	 * Sets the activities code guj.
	 *
	 * @param activitiesCodeGuj the activitiesCodeGuj to set
	 */
	public void setActivitiesCodeGuj(String activitiesCodeGuj) {
		this.activitiesCodeGuj = activitiesCodeGuj;
	}

	/**
	 * Gets the activities code name.
	 *
	 * @return the activitiesCodeName
	 */
	public String getActivitiesCodeName() {
		return activitiesCodeName;
	}

	/**
	 * Sets the activities code name.
	 *
	 * @param activitiesCodeName the activitiesCodeName to set
	 */
	public void setActivitiesCodeName(String activitiesCodeName) {
		this.activitiesCodeName = activitiesCodeName;
	}

	/**
	 * Gets the activities type id.
	 *
	 * @return the activitiesTypeId
	 */
	public int getActivitiesTypeId() {
		return activitiesTypeId;
	}

	/**
	 * Sets the activities type id.
	 *
	 * @param activitiesTypeId the activitiesTypeId to set
	 */
	public void setActivitiesTypeId(int activitiesTypeId) {
		this.activitiesTypeId = activitiesTypeId;
	}

	/**
	 * Gets the parent activities id.
	 *
	 * @return the parentActivitiesId
	 */
	public int getParentActivitiesId() {
		return parentActivitiesId;
	}

	/**
	 * Sets the parent activities id.
	 *
	 * @param parentActivitiesId the parentActivitiesId to set
	 */
	public void setParentActivitiesId(int parentActivitiesId) {
		this.parentActivitiesId = parentActivitiesId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(activitiesCode, activitiesCodeGuj, activitiesCodeName, activitiesDesc,
				activitiesDescGuj, activitiesId, activitiesName, activitiesNameGuj, activitiesTypeId, officeId,
				parentActivitiesId);
		return result;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPMsActivitiesHeadDto)) {
			return false;
		}
		EDPMsActivitiesHeadDto other = (EDPMsActivitiesHeadDto) obj;
		return Objects.equals(activitiesCode, other.activitiesCode)
				&& Objects.equals(activitiesCodeGuj, other.activitiesCodeGuj)
				&& Objects.equals(activitiesCodeName, other.activitiesCodeName)
				&& Objects.equals(activitiesDesc, other.activitiesDesc)
				&& Objects.equals(activitiesDescGuj, other.activitiesDescGuj) && activitiesId == other.activitiesId
				&& Objects.equals(activitiesName, other.activitiesName)
				&& Objects.equals(activitiesNameGuj, other.activitiesNameGuj)
				&& activitiesTypeId == other.activitiesTypeId && officeId == other.officeId
				&& parentActivitiesId == other.parentActivitiesId;
	}

}
