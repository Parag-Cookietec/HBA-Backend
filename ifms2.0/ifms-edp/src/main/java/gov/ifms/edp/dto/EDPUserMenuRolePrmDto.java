package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Class EDPUserMenuRolePrmDto.
 * 
 * @version 1.0
 * @created 2019/12/30 11:47:19
 *
 */
public class EDPUserMenuRolePrmDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user role prm id. */
	@NotNull(message = " YYYYYY should not be null")
	@Size(max = 2)
	private Long userRolePrmId;

	/** The user menu id. */
	@NotNull(message = " YYYYYY should not be null")
	@Size(max = 2)
	private Long userMenuId;

	/** The role prm id. */
	@NotNull(message = " YYYYYY should not be null")
	@Size(max = 2)
	private Long rolePrmId;

	/** The branch id. */
	@NotNull(message = " YYYYYY should not be null")
	@Size(max = 2)
	private Long branchId;

	/** The user role mapping id. */
	private Long userRoleMappingId;

	/** The is romoved. */
	private int isRomoved;

	/**
	 * Gets the user role prm id.
	 *
	 * @return the user role prm id
	 */
	public Long getUserRolePrmId() {
		return userRolePrmId;
	}

	/**
	 * Sets the user role prm id.
	 *
	 * @param userRolePrmId the new user role prm id
	 */
	public void setUserRolePrmId(Long userRolePrmId) {
		this.userRolePrmId = userRolePrmId;
	}

	/**
	 * Gets the user menu id.
	 *
	 * @return the user menu id
	 */
	public Long getUserMenuId() {
		return userMenuId;
	}

	/**
	 * Sets the user menu id.
	 *
	 * @param userMenuId the new user menu id
	 */
	public void setUserMenuId(Long userMenuId) {
		this.userMenuId = userMenuId;
	}

	/**
	 * Gets the role prm id.
	 *
	 * @return the role prm id
	 */
	public Long getRolePrmId() {
		return rolePrmId;
	}

	/**
	 * Sets the role prm id.
	 *
	 * @param rolePrmId the new role prm id
	 */
	public void setRolePrmId(Long rolePrmId) {
		this.rolePrmId = rolePrmId;
	}

	/**
	 * Gets the branch id.
	 *
	 * @return the branch id
	 */
	public Long getBranchId() {
		return branchId;
	}

	/**
	 * Sets the branch id.
	 *
	 * @param branchId the new branch id
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	/**
	 * Gets the user role mapping id.
	 *
	 * @return the user role mapping id
	 */
	public Long getUserRoleMappingId() {
		return userRoleMappingId;
	}

	/**
	 * Sets the user role mapping id.
	 *
	 * @param userRoleMappingId the new user role mapping id
	 */
	public void setUserRoleMappingId(Long userRoleMappingId) {
		this.userRoleMappingId = userRoleMappingId;
	}

	/**
	 * Gets the checks if is romoved.
	 *
	 * @return the checks if is romoved
	 */
	public int getIsRomoved() {
		return isRomoved;
	}

	/**
	 * Sets the checks if is romoved.
	 *
	 * @param isRomoved the new checks if is romoved
	 */
	public void setIsRomoved(int isRomoved) {
		this.isRomoved = isRomoved;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(branchId, isRomoved, rolePrmId, userMenuId, userRoleMappingId, userRolePrmId);
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
		EDPUserMenuRolePrmDto other = (EDPUserMenuRolePrmDto) obj;
		return Objects.equals(branchId, other.branchId) && isRomoved == other.isRomoved
				&& Objects.equals(rolePrmId, other.rolePrmId) && Objects.equals(userMenuId, other.userMenuId)
				&& Objects.equals(userRoleMappingId, other.userRoleMappingId)
				&& Objects.equals(userRolePrmId, other.userRolePrmId);
	}

	
}
