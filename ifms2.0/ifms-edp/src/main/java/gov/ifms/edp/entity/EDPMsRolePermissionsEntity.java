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
 * The Class EDPMsRolePermissionsEntity.
 */
@Entity
@Table(name = "MS_ROLE_PERMISSIONS", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsRolePermissionsEntity extends BaseEntity implements Serializable {

	/**
	 * Instantiates a new EDP ms role permissions entity.
	 *
	 * @param rolePrmId the role prm id
	 */
	public EDPMsRolePermissionsEntity(Long rolePrmId) {
		super();
		this.rolePrmId = rolePrmId;
	}
	
	/**
	 * Instantiates a new EDP ms role permissions entity.
	 */
	public EDPMsRolePermissionsEntity() {
		super();
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The role prm id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_PRM_ID")
	private Long rolePrmId;

	/** The role prm name. */
	@Column(name = "ROLE_PRM_NAME")
	private String rolePrmName;

	/** The role prm name guj. */
	@Column(name = "ROLE_PRM_NAME_GUJ")
	private String rolePrmNameGuj;

	/** The role prm description. */
	@Column(name = "ROLE_PRM_DESC")
	private String rolePrmDescription;

	/** The role prm description guj. */
	@Column(name = "ROLE_PRM_DESC_GUJ")
	private String rolePrmDescriptionGuj;

	/** The role prm code. */
	@Column(name = "ROLE_PRM_CODE")
	private String rolePrmCode;

	/** The role prm code name. */
	@Column(name = "ROLE_PRM_CODE_NAME")
	private String rolePrmCodeName;

	/** The roel prm type id. */
	@Column(name = "ROLE_PRM_TYPE_ID")
	private int roelPrmTypeId;

	/** The p parent role id. */
	@Column(name = "P_ROLE_PRM_ID")
	private int pParentRoleId;

	/**
	 * Gets the role activity id.
	 *
	 * @return the role activity id
	 */
	public Long getRoleActivityId() {
		return rolePrmId;
	}

	/**
	 * Sets the role activity id.
	 *
	 * @param roleActivityId the new role activity id
	 */
	public void setRoleActivityId(Long roleActivityId) {
		this.rolePrmId = roleActivityId;
	}

	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	public String getRoleName() {
		return rolePrmName;
	}

	/**
	 * Sets the role name.
	 *
	 * @param roleName the new role name
	 */
	public void setRoleName(String roleName) {
		this.rolePrmName = roleName;
	}

	/**
	 * Gets the role name guj.
	 *
	 * @return the role name guj
	 */
	public String getRoleNameGuj() {
		return rolePrmNameGuj;
	}

	/**
	 * Sets the role name guj.
	 *
	 * @param roleNameGuj the new role name guj
	 */
	public void setRoleNameGuj(String roleNameGuj) {
		this.rolePrmNameGuj = roleNameGuj;
	}

	/**
	 * Gets the role description.
	 *
	 * @return the role description
	 */
	public String getRoleDescription() {
		return rolePrmDescription;
	}

	/**
	 * Sets the role description.
	 *
	 * @param roleDescription the new role description
	 */
	public void setRoleDescription(String roleDescription) {
		this.rolePrmDescription = roleDescription;
	}

	/**
	 * Gets the role description guj.
	 *
	 * @return the role description guj
	 */
	public String getRoleDescriptionGuj() {
		return rolePrmDescriptionGuj;
	}

	/**
	 * Sets the role description guj.
	 *
	 * @param roleDescriptionGuj the new role description guj
	 */
	public void setRoleDescriptionGuj(String roleDescriptionGuj) {
		this.rolePrmDescriptionGuj = roleDescriptionGuj;
	}

	/**
	 * Gets the role code.
	 *
	 * @return the role code
	 */
	public String getRoleCode() {
		return rolePrmCode;
	}

	/**
	 * Sets the role code.
	 *
	 * @param roleCode the new role code
	 */
	public void setRoleCode(String roleCode) {
		this.rolePrmCode = roleCode;
	}

	/**
	 * Gets the role code name.
	 *
	 * @return the role code name
	 */
	public String getRoleCodeName() {
		return rolePrmCodeName;
	}

	/**
	 * Sets the role code name.
	 *
	 * @param roleCodeName the new role code name
	 */
	public void setRoleCodeName(String roleCodeName) {
		this.rolePrmCodeName = roleCodeName;
	}

	/**
	 * Gets the roel type id.
	 *
	 * @return the roel type id
	 */
	public int getRoelTypeId() {
		return roelPrmTypeId;
	}

	/**
	 * Sets the roel type id.
	 *
	 * @param roelTypeId the new roel type id
	 */
	public void setRoelTypeId(int roelTypeId) {
		this.roelPrmTypeId = roelTypeId;
	}

	/**
	 * Gets the parent role id.
	 *
	 * @return the parent role id
	 */
	public int getParentRoleId() {
		return pParentRoleId;
	}

	/**
	 * Sets the parent role id.
	 *
	 * @param parentRoleId the new parent role id
	 */
	public void setParentRoleId(int parentRoleId) {
		this.pParentRoleId = parentRoleId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(pParentRoleId, roelPrmTypeId, rolePrmId, rolePrmCode, rolePrmCodeName, rolePrmDescription,
				rolePrmDescriptionGuj, rolePrmName, rolePrmNameGuj);
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
		if (!(obj instanceof EDPMsRolePermissionsEntity)) {
			return false;
		}
		EDPMsRolePermissionsEntity other = (EDPMsRolePermissionsEntity) obj;
		return pParentRoleId == other.pParentRoleId && roelPrmTypeId == other.roelPrmTypeId
				&& rolePrmId == other.rolePrmId && Objects.equals(rolePrmCode, other.rolePrmCode)
				&& Objects.equals(rolePrmCodeName, other.rolePrmCodeName)
				&& Objects.equals(rolePrmDescription, other.rolePrmDescription)
				&& Objects.equals(rolePrmDescriptionGuj, other.rolePrmDescriptionGuj)
				&& Objects.equals(rolePrmName, other.rolePrmName)
				&& Objects.equals(rolePrmNameGuj, other.rolePrmNameGuj);
	}

}
