package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPLkUserMenuDto.
 */
public class EDPLkUserMenuDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk puo menu roles id. */
	private Long lkUserMenuId;

	/** The post user office id. */
	private long poOffUserId;

	/** The menu ID. */
	private long menuID;

	/**
	 * Instantiates a new EDP lk puo menu roles entity.
	 */
	public EDPLkUserMenuDto() {
		super();
	}

	/**
	 * Gets the lk user menu id.
	 *
	 * @return the lkUserMenuId
	 */
	public Long getLkUserMenuId() {
		return lkUserMenuId;
	}

	/**
	 * Sets the lk user menu id.
	 *
	 * @param lkUserMenuId the lkUserMenuId to set
	 */
	public void setLkUserMenuId(Long lkUserMenuId) {
		this.lkUserMenuId = lkUserMenuId;
	}

	/**
	 * Gets the menu ID.
	 *
	 * @return the menuID
	 */
	public Long getMenuID() {
		return menuID;
	}

	/**
	 * Sets the menu ID.
	 *
	 * @param menuID the menuID to set
	 */
	public void setMenuID(Long menuID) {
		this.menuID = menuID;
	}

	/**
	 * Gets the po off user id.
	 *
	 * @return the poOffUserId
	 */
	public long getPoOffUserId() {
		return poOffUserId;
	}

	/**
	 * Sets the po off user id.
	 *
	 * @param poOffUserId the poOffUserId to set
	 */
	public void setPoOffUserId(long poOffUserId) {
		this.poOffUserId = poOffUserId;
	}

	/**
	 * Sets the menu ID.
	 *
	 * @param menuID the menuID to set
	 */
	public void setMenuID(long menuID) {
		this.menuID = menuID;
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
		result = prime * result + Objects.hash(lkUserMenuId, menuID, poOffUserId);
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
		if (!(obj instanceof EDPLkUserMenuDto)) {
			return false;
		}
		EDPLkUserMenuDto other = (EDPLkUserMenuDto) obj;
		return Objects.equals(lkUserMenuId, other.lkUserMenuId) && menuID == other.menuID
				&& poOffUserId == other.poOffUserId;
	}
	
}
