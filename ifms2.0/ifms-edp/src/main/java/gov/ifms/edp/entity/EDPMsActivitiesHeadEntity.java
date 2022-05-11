package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class EDPMsActivitiesHeadEntity.
 * 
 * @version 1.0
 * @created 2019/08/31 12:56:51
 *
 */
@Entity
@Table(name = "MS_ACTIVITIESHEAD")
public class EDPMsActivitiesHeadEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The activities id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACTIVITIES_ID")
	private long activitiesId;

	/** The activities name. */
	@Column(name = "ACTIVITIES_NAME")
	private String activitiesName;

	/** The activities name guj. */
	@Column(name = "ACTIVITIES_NAME_GUJ")
	private String activitiesNameGuj;

	/** The activities desc. */
	@Column(name = "ACTIVITIES_DESC")
	private String activitiesDesc;

	/** The activities desc guj. */
	@Column(name = "ACTIVITIES_DESC_GUJ")
	private String activitiesDescGuj;

	/** The activities code. */
	@Column(name = "ACTIVITIES_CODE")
	private String activitiesCode;

	/** The activities code guj. */
	@Column(name = "ACTIVITIES_CODE_GUJ")
	private String activitiesCodeGuj;

	/** The activities code name. */
	@Column(name = "ACTIVITIES_CODE_NAME")
	private String activitiesCodeName;

	/** The activities type id. */
	@Column(name = "ACTIVITIES_TYPE_ID")
	private int activitiesTypeId;

	/** The parent activities id. */
	@Column(name = "PARENT_ACTIVITIES_ID")
	private int parentActivitiesId;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

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
	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	/**
	 * Instantiates a new EDP ms activities head entity.
	 */
	public EDPMsActivitiesHeadEntity() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(activitiesCode, activitiesCodeGuj, activitiesCodeName, activitiesDesc, activitiesDescGuj,
				activitiesId, activitiesName, activitiesNameGuj, activitiesTypeId, officeId, parentActivitiesId);
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
		if (!(obj instanceof EDPMsActivitiesHeadEntity)) {
			return false;
		}
		EDPMsActivitiesHeadEntity other = (EDPMsActivitiesHeadEntity) obj;
		return Objects.equals(activitiesCode, other.activitiesCode)
				&& Objects.equals(activitiesCodeGuj, other.activitiesCodeGuj)
				&& Objects.equals(activitiesCodeName, other.activitiesCodeName)
				&& Objects.equals(activitiesDesc, other.activitiesDesc)
				&& Objects.equals(activitiesDescGuj, other.activitiesDescGuj) && activitiesId == other.activitiesId
				&& Objects.equals(activitiesName, other.activitiesName)
				&& Objects.equals(activitiesNameGuj, other.activitiesNameGuj)
				&& activitiesTypeId == other.activitiesTypeId && Objects.equals(officeId, other.officeId)
				&& parentActivitiesId == other.parentActivitiesId;
	}

}
