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
 * The Class EDPLkPoOffUserItrEntity.
 */
@Entity
@Table(name = "LK_PO_OFF_USER_ITR", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLkPoOffUserItrEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk po off user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LK_PO_OFF_USR_ITR_ID")
	private Long lkPoOffUserItrId;
	
	/** The lk po off user id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LK_PO_OFF_USER_ID", nullable = false, referencedColumnName = "LK_PO_OFF_USER_ID")
	private EDPLkPoOffUserEntity lkPoOffUserId;
	
	/** The lk post office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LK_POST_OFFICE_ID", nullable = false, referencedColumnName = "LK_POST_OFFICE_ID")
	private EDPLkPostOfficeEntity lkPostOfficeId;

	/** The user id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID", nullable = false, referencedColumnName = "USER_ID")
	private EDPMsUserEntity userId;

	/** The is primary post. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_PRIMARY_POST", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isPrimaryPost;
	
	/** The menu id. */
	@Column(name = "MENU_ID")
	private Long menuId;
	

	/**
	 * Instantiates a new EDP lk po off user entity.
	 */
	public EDPLkPoOffUserItrEntity() {
		super();
	}

	/**
	 * Gets the lk post office id.
	 *
	 * @return the lkPostOfficeId
	 */
	public EDPLkPostOfficeEntity getLkPostOfficeId() {
		return lkPostOfficeId;
	}

	/**
	 * Sets the lk post office id.
	 *
	 * @param lkPostOfficeId the lkPostOfficeId to set
	 */
	public void setLkPostOfficeId(EDPLkPostOfficeEntity lkPostOfficeId) {
		this.lkPostOfficeId = lkPostOfficeId;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public EDPMsUserEntity getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(EDPMsUserEntity userId) {
		this.userId = userId;
	}

	/**
	 * Gets the checks if is primary post.
	 *
	 * @return the isPrimaryPost
	 */
	public EDPLuLookUpInfoEntity getIsPrimaryPost() {
		return isPrimaryPost;
	}

	/**
	 * Sets the checks if is primary post.
	 *
	 * @param isPrimaryPost the isPrimaryPost to set
	 */
	public void setIsPrimaryPost(EDPLuLookUpInfoEntity isPrimaryPost) {
		this.isPrimaryPost = isPrimaryPost;
	}

	/**
	 * @return the lkPoOffUserItrId
	 */
	public Long getLkPoOffUserItrId() {
		return lkPoOffUserItrId;
	}

	/**
	 * @param lkPoOffUserItrId the lkPoOffUserItrId to set
	 */
	public void setLkPoOffUserItrId(Long lkPoOffUserItrId) {
		this.lkPoOffUserItrId = lkPoOffUserItrId;
	}

	/**
	 * @return the lkPoOffUserId
	 */
	public EDPLkPoOffUserEntity getLkPoOffUserId() {
		return lkPoOffUserId;
	}

	/**
	 * @param lkPoOffUserId the lkPoOffUserId to set
	 */
	public void setLkPoOffUserId(EDPLkPoOffUserEntity lkPoOffUserId) {
		this.lkPoOffUserId = lkPoOffUserId;
	}

	/**
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(isPrimaryPost, lkPoOffUserId, lkPoOffUserItrId, lkPostOfficeId, menuId, userId);
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
		if (!(obj instanceof EDPLkPoOffUserItrEntity)) {
			return false;
		}
		EDPLkPoOffUserItrEntity other = (EDPLkPoOffUserItrEntity) obj;
		return Objects.equals(isPrimaryPost, other.isPrimaryPost) && Objects.equals(lkPoOffUserId, other.lkPoOffUserId)
				&& Objects.equals(lkPoOffUserItrId, other.lkPoOffUserItrId)
				&& Objects.equals(lkPostOfficeId, other.lkPostOfficeId) && Objects.equals(menuId, other.menuId)
				&& Objects.equals(userId, other.userId);
	}

}
