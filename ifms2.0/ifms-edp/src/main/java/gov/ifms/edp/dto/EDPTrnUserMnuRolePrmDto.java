package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Min;

/**
 * The Class EDPTrnUserMnuRolePrmDto.
 */
public class EDPTrnUserMnuRolePrmDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trn usr role prm id. */
	private Long trnUsrRolePrmId;

	/** The lk user menu id. */
	private long lkUserMenuId;

	/** The role prm id. */
	private long rolePrmId;

	/** The menu id. */
	@Min(1)
	private long menuId;

	/**
	 * @return the trnUsrRolePrmId
	 */
	public Long getTrnUsrRolePrmId() {
		return trnUsrRolePrmId;
	}

	/**
	 * @param trnUsrRolePrmId the trnUsrRolePrmId to set
	 */
	public void setTrnUsrRolePrmId(Long trnUsrRolePrmId) {
		this.trnUsrRolePrmId = trnUsrRolePrmId;
	}

	/**
	 * @return the lkUserMenuId
	 */
	public long getLkUserMenuId() {
		return lkUserMenuId;
	}

	/**
	 * @param lkUserMenuId the lkUserMenuId to set
	 */
	public void setLkUserMenuId(long lkUserMenuId) {
		this.lkUserMenuId = lkUserMenuId;
	}

	/**
	 * @return the rolePrmId
	 */
	public long getRolePrmId() {
		return rolePrmId;
	}

	/**
	 * @param rolePrmId the rolePrmId to set
	 */
	public void setRolePrmId(long rolePrmId) {
		this.rolePrmId = rolePrmId;
	}

	/**
	 * @return the menuId
	 */
	public long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
		result = prime * result + Objects.hash(lkUserMenuId, menuId, rolePrmId, trnUsrRolePrmId);
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
		if (!(obj instanceof EDPTrnUserMnuRolePrmDto)) {
			return false;
		}
		EDPTrnUserMnuRolePrmDto other = (EDPTrnUserMnuRolePrmDto) obj;
		return lkUserMenuId == other.lkUserMenuId && menuId == other.menuId && rolePrmId == other.rolePrmId
				&& Objects.equals(trnUsrRolePrmId, other.trnUsrRolePrmId);
	}
	
	
	

}
