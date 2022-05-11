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
 * The Class EDPMsSubModuleEntity.
 */
@Entity
@Table(name = "MS_SUB_MODULE", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsSubModuleEntity  extends BaseEntity implements Serializable{

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The sub module id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUB_MODULE_ID ")
	private long subModuleId;

	/** The sub module name. */
	@Column(name = "SUB_MODULE_NAME")
	private String subModuleName;

	/** The sub module name guj. */
	@Column(name = "SUB_MODULE_NAME_GUJ")
	private String subModuleNameGuj;

	/** The sub module desc. */
	@Column(name = "SUB_MODULE_DESC")
	private String subModuleDesc;

	/** The sub moduile desc guj. */
	@Column(name = "SUB_MODULE_DESC_GUJ")
	private String subModuileDescGuj;
	

	/** The module id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "MODULE_ID", referencedColumnName = "MODULE_ID")
	private EDPMsModuleEntity moduleId;


	/**
	 * Gets the sub module id.
	 *
	 * @return the sub module id
	 */
	public long getSubModuleId() {
		return subModuleId;
	}


	/**
	 * Sets the sub module id.
	 *
	 * @param subModuleId the new sub module id
	 */
	public void setSubModuleId(long subModuleId) {
		this.subModuleId = subModuleId;
	}


	/**
	 * Gets the sub module name.
	 *
	 * @return the sub module name
	 */
	public String getSubModuleName() {
		return subModuleName;
	}


	/**
	 * Sets the sub module name.
	 *
	 * @param subModuleName the new sub module name
	 */
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}


	/**
	 * Gets the sub module name guj.
	 *
	 * @return the sub module name guj
	 */
	public String getSubModuleNameGuj() {
		return subModuleNameGuj;
	}


	/**
	 * Sets the sub module name guj.
	 *
	 * @param subModuleNameGuj the new sub module name guj
	 */
	public void setSubModuleNameGuj(String subModuleNameGuj) {
		this.subModuleNameGuj = subModuleNameGuj;
	}


	/**
	 * Gets the sub module desc.
	 *
	 * @return the sub module desc
	 */
	public String getSubModuleDesc() {
		return subModuleDesc;
	}


	/**
	 * Sets the sub module desc.
	 *
	 * @param subModuleDesc the new sub module desc
	 */
	public void setSubModuleDesc(String subModuleDesc) {
		this.subModuleDesc = subModuleDesc;
	}


	/**
	 * Gets the sub moduile desc guj.
	 *
	 * @return the sub moduile desc guj
	 */
	public String getSubModuileDescGuj() {
		return subModuileDescGuj;
	}


	/**
	 * Sets the sub moduile desc guj.
	 *
	 * @param subModuileDescGuj the new sub moduile desc guj
	 */
	public void setSubModuileDescGuj(String subModuileDescGuj) {
		this.subModuileDescGuj = subModuileDescGuj;
	}


	/**
	 * Gets the module id.
	 *
	 * @return the module id
	 */
	public EDPMsModuleEntity getModuleId() {
		return moduleId;
	}


	/**
	 * Sets the module id.
	 *
	 * @param moduleId the new module id
	 */
	public void setModuleId(EDPMsModuleEntity moduleId) {
		this.moduleId = moduleId;
	}

	
	

	/**
	 * Instantiates a new EDP ms sub module entity.
	 *
	 * @param subModuleId the sub module id
	 */
	public EDPMsSubModuleEntity(long subModuleId) {
		super();
		this.subModuleId = subModuleId;
		
	}

	

	/**
	 * Instantiates a new EDP ms sub module entity.
	 */
	public EDPMsSubModuleEntity() {
		super();
	}


	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(moduleId, subModuileDescGuj, subModuleDesc, subModuleId, subModuleName, subModuleNameGuj);
	}


	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPMsSubModuleEntity other = (EDPMsSubModuleEntity) obj;
		return Objects.equals(moduleId, other.moduleId) && Objects.equals(subModuileDescGuj, other.subModuileDescGuj)
				&& Objects.equals(subModuleDesc, other.subModuleDesc) && subModuleId == other.subModuleId
				&& Objects.equals(subModuleName, other.subModuleName)
				&& Objects.equals(subModuleNameGuj, other.subModuleNameGuj);
	}
	
}
