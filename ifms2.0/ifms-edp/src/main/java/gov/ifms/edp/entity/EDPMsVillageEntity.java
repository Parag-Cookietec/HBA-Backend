package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsVillageEntity.
 */
@Entity
@Table(name = "MS_VILLAGE",schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsVillageEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The village id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VILLAGE_ID")
	private Long villageId;

	/** The village name. */
	@Column(name = "VILLAGE_NAME")
	private String villageName;

	/** The village name guj. */
	@Column(name = "VILLAGE_NAME_GUJ")
	private String villageNameGuj;

	/** The village description. */
	@Column(name = "VILLAGE_DESCRIPTION")
	private String villageDescription;

	/** The village description guj. */
	@Column(name = "VILLAGE_DESCRIPTION_GUJ")
	private String villageDescriptionGuj;

	/** The village code. */
	@Column(name = "VILLAGE_CODE")
	private String villageCode;

	/** The village code guj. */
	@Column(name = "VILLAGE_CODE_GUJ")
	private String villageCodeGuj;

	/** The village code name. */
	@Column(name = "VILLAGE_CODE_NAME")
	private String villageCodeName;

	/** The taluka id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TALUKA_ID",referencedColumnName = "TALUKA_ID")
	private EDPMsTalukaEntity talukaId;

	/**
	 * EDPMsVillageEntityDto Constructor.
	 */
	public EDPMsVillageEntity() {
		super();
	}
	
	/**
	 * Instantiates a new EDP ms village entity.
	 *
	 * @param villageId the village id
	 */
	public EDPMsVillageEntity(Long villageId) {
		super();
		this.villageId = villageId;
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(villageId, villageName, villageNameGuj, villageDescription, villageDescriptionGuj,
				villageCode, villageCodeGuj, villageCodeName, talukaId);
	}

	/**
	 * equals method.
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
		if (!(obj instanceof EDPMsVillageEntity)) {
			return false;
		}

		EDPMsVillageEntity other = (EDPMsVillageEntity) obj;

		return Objects.equals(villageId, other.villageId) && Objects.equals(villageName, other.villageName)
				&& Objects.equals(villageNameGuj, other.villageNameGuj)
				&& Objects.equals(villageDescription, other.villageDescription)
				&& Objects.equals(villageDescriptionGuj, other.villageDescriptionGuj)
				&& Objects.equals(villageCode, other.villageCode)
				&& Objects.equals(villageCodeGuj, other.villageCodeGuj)
				&& Objects.equals(villageCodeName, other.villageCodeName) && Objects.equals(talukaId, other.talukaId);
	}

	/**
	 * getter setter.
	 *
	 * @return the village id
	 */

	/**
	 * @return the villageId
	 */
	public Long getVillageId() {
		return villageId;
	}

	/**
	 * Sets the village id.
	 *
	 * @param villageId the villageId to set
	 */
	public void setVillageId(Long villageId) {
		this.villageId = villageId;
	}

	/**
	 * Gets the village name.
	 *
	 * @return the villageName
	 */
	public String getVillageName() {
		return villageName;
	}

	/**
	 * Sets the village name.
	 *
	 * @param villageName the villageName to set
	 */
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	/**
	 * Gets the village name guj.
	 *
	 * @return the villageNameGuj
	 */
	public String getVillageNameGuj() {
		return villageNameGuj;
	}

	/**
	 * Sets the village name guj.
	 *
	 * @param villageNameGuj the villageNameGuj to set
	 */
	public void setVillageNameGuj(String villageNameGuj) {
		this.villageNameGuj = villageNameGuj;
	}

	/**
	 * Gets the village description.
	 *
	 * @return the villageDescription
	 */
	public String getVillageDescription() {
		return villageDescription;
	}

	/**
	 * Sets the village description.
	 *
	 * @param villageDescription the villageDescription to set
	 */
	public void setVillageDescription(String villageDescription) {
		this.villageDescription = villageDescription;
	}

	/**
	 * Gets the village description guj.
	 *
	 * @return the villageDescriptionGuj
	 */
	public String getVillageDescriptionGuj() {
		return villageDescriptionGuj;
	}

	/**
	 * Sets the village description guj.
	 *
	 * @param villageDescriptionGuj the villageDescriptionGuj to set
	 */
	public void setVillageDescriptionGuj(String villageDescriptionGuj) {
		this.villageDescriptionGuj = villageDescriptionGuj;
	}

	/**
	 * Gets the village code.
	 *
	 * @return the villageCode
	 */
	public String getVillageCode() {
		return villageCode;
	}

	/**
	 * Sets the village code.
	 *
	 * @param villageCode the villageCode to set
	 */
	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	/**
	 * Gets the village code guj.
	 *
	 * @return the villageCodeGuj
	 */
	public String getVillageCodeGuj() {
		return villageCodeGuj;
	}

	/**
	 * Sets the village code guj.
	 *
	 * @param villageCodeGuj the villageCodeGuj to set
	 */
	public void setVillageCodeGuj(String villageCodeGuj) {
		this.villageCodeGuj = villageCodeGuj;
	}

	/**
	 * Gets the village code name.
	 *
	 * @return the villageCodeName
	 */
	public String getVillageCodeName() {
		return villageCodeName;
	}

	/**
	 * Sets the village code name.
	 *
	 * @param villageCodeName the villageCodeName to set
	 */
	public void setVillageCodeName(String villageCodeName) {
		this.villageCodeName = villageCodeName;
	}

	/**
	 * Gets the taluka id.
	 *
	 * @return the talukaId
	 */
	public EDPMsTalukaEntity getTalukaId() {
		return talukaId;
	}

	/**
	 * Sets the taluka id.
	 *
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(EDPMsTalukaEntity talukaId) {
		this.talukaId = talukaId;
	}

}
