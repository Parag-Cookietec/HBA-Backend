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
 * The Class EDPLkUserMenuEntity.
 */
@Entity
@Table(name = "LK_USER_MENU", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLkUserMenuEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk puo menu roles id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LK_USER_MENU_ID")
	private Long lkUserMenuId;

	/** The post user office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LK_PO_OFF_USER_ID", nullable = false, referencedColumnName = "LK_PO_OFF_USER_ID")
	private EDPLkPoOffUserEntity poOffUserId;

	/** The menu ID. */
	@Column(name = "MENU_ID")
	private Long menuID;

	/**
	 * Instantiates a new EDP lk puo menu roles entity.
	 */
	public EDPLkUserMenuEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP lk user menu entity.
	 *
	 * @param lkUserMenuId the lk user menu id
	 */
	public EDPLkUserMenuEntity(Long lkUserMenuId) {
		super();
		this.lkUserMenuId = lkUserMenuId;
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
	public EDPLkPoOffUserEntity getPoOffUserId() {
		return poOffUserId;
	}

	/**
	 * Sets the po off user id.
	 *
	 * @param poOffUserId the poOffUserId to set
	 */
	public void setPoOffUserId(EDPLkPoOffUserEntity poOffUserId) {
		this.poOffUserId = poOffUserId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lkUserMenuId, menuID, poOffUserId);
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
		if (!(obj instanceof EDPLkUserMenuEntity)) {
			return false;
		}
		EDPLkUserMenuEntity other = (EDPLkUserMenuEntity) obj;
		return Objects.equals(lkUserMenuId, other.lkUserMenuId) && Objects.equals(menuID, other.menuID)
				&& Objects.equals(poOffUserId, other.poOffUserId);
	}

	
}
