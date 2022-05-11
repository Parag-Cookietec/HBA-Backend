package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;


import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
/**
 * The Class EDPMsRolePermissionsDto.
 */
@NativeQueryResultEntity
public class EDPMsRolePermissionsDto extends BaseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The role prm id. */
	@NativeQueryResultColumn(index = 0)
	private long rolePrmId;

	/** The role prm name. */
	@NativeQueryResultColumn(index = 1)
	private String rolePrmName;

	/** The role prm name guj. */
	@NativeQueryResultColumn(index = 2)
	private String rolePrmNameGuj;

	/** The role prm description. */
	@NativeQueryResultColumn(index = 3)
	private String rolePrmDescription;

	/** The role prm description guj. */
	private String rolePrmDescriptionGuj;

	/** The role prm code. */
	private String rolePrmCode;

	/** The role prm code name. */
	private String rolePrmCodeName;

	/** The roel prm type id. */
	private int roelPrmTypeId;

	/** The p parent role id. */
	private int pParentRoleId;

	/**
	 * Gets the role activity id.
	 *
	 * @return the role activity id
	 */
	public long getRoleActivityId() {
		return rolePrmId;
	}

	/**
	 * Sets the role activity id.
	 *
	 * @param roleActivityId the new role activity id
	 */
	public void setRoleActivityId(long roleActivityId) {
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(pParentRoleId, roelPrmTypeId, rolePrmId, rolePrmCode, rolePrmCodeName,
				rolePrmDescription, rolePrmDescriptionGuj, rolePrmName, rolePrmNameGuj);
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
		if (!(obj instanceof EDPMsRolePermissionsDto)) {
			return false;
		}
		EDPMsRolePermissionsDto other = (EDPMsRolePermissionsDto) obj;
		return pParentRoleId == other.pParentRoleId && roelPrmTypeId == other.roelPrmTypeId
				&& rolePrmId == other.rolePrmId && Objects.equals(rolePrmCode, other.rolePrmCode)
				&& Objects.equals(rolePrmCodeName, other.rolePrmCodeName)
				&& Objects.equals(rolePrmDescription, other.rolePrmDescription)
				&& Objects.equals(rolePrmDescriptionGuj, other.rolePrmDescriptionGuj)
				&& Objects.equals(rolePrmName, other.rolePrmName)
				&& Objects.equals(rolePrmNameGuj, other.rolePrmNameGuj);
	}

}
