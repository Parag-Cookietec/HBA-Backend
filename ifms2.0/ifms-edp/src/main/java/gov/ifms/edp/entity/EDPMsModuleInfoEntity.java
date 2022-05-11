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

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsModuleInfoEntity.
 */
@Entity
@Table(name = "MS_MODULE_INFO", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsModuleInfoEntity extends BaseEntity implements Serializable {
	
	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The module info id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MODULE_INFO_ID")
	private long moduleInfoId;

	/** The module info name. */
	@Column(name = "MODULE_INFO_NAME")
	private String moduleInfoName;

	/** The module info name guj. */
	@Column(name = "MODULE_INFO_NAME_GUJ")
	private String moduleInfoNameGuj;

	/** The module info D escription. */
	@Column(name = "MODULE_INFO_DESCRIPTION")
	private String moduleInfoDEscription;

	/** The module info desciption guj. */
	@Column(name = "MODULE_INFO_DESCRIPTION_GUJ")
	private String moduleInfoDesciptionGuj;

	/** The parent module id. */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PARENT_MODULE_ID", referencedColumnName = "MODULE_ID")
	private EDPMsModuleEntity parentModuleId;

	/**
	 * Instantiates a new EDP ms module info entity.
	 */
	public EDPMsModuleInfoEntity() {
		super();
	}
	
	/**
	 * Instantiates a new EDP ms module info entity.
	 *
	 * @param moduleInfoId the module info id
	 */
	public EDPMsModuleInfoEntity(long moduleInfoId) {
		super();
		this.moduleInfoId = moduleInfoId;
	}

	/**
	 * Gets the module info id.
	 *
	 * @return the moduleInfoId
	 */
	public long getModuleInfoId() {
		return moduleInfoId;
	}

	/**
	 * Sets the module info id.
	 *
	 * @param moduleInfoId the moduleInfoId to set
	 */
	public void setModuleInfoId(long moduleInfoId) {
		this.moduleInfoId = moduleInfoId;
	}

	/**
	 * Gets the module info name.
	 *
	 * @return the moduleInfoName
	 */
	public String getModuleInfoName() {
		return moduleInfoName;
	}

	/**
	 * Sets the module info name.
	 *
	 * @param moduleInfoName the moduleInfoName to set
	 */
	public void setModuleInfoName(String moduleInfoName) {
		this.moduleInfoName = moduleInfoName;
	}

	/**
	 * Gets the module info name guj.
	 *
	 * @return the moduleInfoNameGuj
	 */
	public String getModuleInfoNameGuj() {
		return moduleInfoNameGuj;
	}

	/**
	 * Sets the module info name guj.
	 *
	 * @param moduleInfoNameGuj the moduleInfoNameGuj to set
	 */
	public void setModuleInfoNameGuj(String moduleInfoNameGuj) {
		this.moduleInfoNameGuj = moduleInfoNameGuj;
	}

	/**
	 * Gets the module info D escription.
	 *
	 * @return the moduleInfoDEscription
	 */
	public String getModuleInfoDEscription() {
		return moduleInfoDEscription;
	}

	/**
	 * Sets the module info D escription.
	 *
	 * @param moduleInfoDEscription the moduleInfoDEscription to set
	 */
	public void setModuleInfoDEscription(String moduleInfoDEscription) {
		this.moduleInfoDEscription = moduleInfoDEscription;
	}

	/**
	 * Gets the module info desciption guj.
	 *
	 * @return the moduleInfoDesciptionGuj
	 */
	public String getModuleInfoDesciptionGuj() {
		return moduleInfoDesciptionGuj;
	}

	/**
	 * Sets the module info desciption guj.
	 *
	 * @param moduleInfoDesciptionGuj the moduleInfoDesciptionGuj to set
	 */
	public void setModuleInfoDesciptionGuj(String moduleInfoDesciptionGuj) {
		this.moduleInfoDesciptionGuj = moduleInfoDesciptionGuj;
	}

	/**
	 * Gets the parent module id.
	 *
	 * @return the parentModuleId
	 */
	public EDPMsModuleEntity getParentModuleId() {
		return parentModuleId;
	}

	/**
	 * Sets the parent module id.
	 *
	 * @param parentModuleId the parentModuleId to set
	 */
	public void setParentModuleId(EDPMsModuleEntity parentModuleId) {
		this.parentModuleId = parentModuleId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(moduleInfoDEscription, moduleInfoDesciptionGuj, moduleInfoId, moduleInfoName,
				moduleInfoNameGuj, parentModuleId);
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
		if (!(obj instanceof EDPMsModuleInfoEntity)) {
			return false;
		}
		EDPMsModuleInfoEntity other = (EDPMsModuleInfoEntity) obj;
		return Objects.equals(moduleInfoDEscription, other.moduleInfoDEscription)
				&& Objects.equals(moduleInfoDesciptionGuj, other.moduleInfoDesciptionGuj)
				&& moduleInfoId == other.moduleInfoId && Objects.equals(moduleInfoName, other.moduleInfoName)
				&& Objects.equals(moduleInfoNameGuj, other.moduleInfoNameGuj)
				&& Objects.equals(parentModuleId, other.parentModuleId);
	}

}