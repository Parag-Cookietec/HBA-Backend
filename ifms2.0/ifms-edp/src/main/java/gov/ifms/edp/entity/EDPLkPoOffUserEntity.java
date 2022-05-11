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
 * The Class EDPLkPoOffUserEntity.
 */
@Entity
@Table(name = "LK_PO_OFF_USER", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLkPoOffUserEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk po off user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LK_PO_OFF_USER_ID")
	private Long lkPoOffUserId;

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

	/**
	 * EDPLkPostOfficeUserDto Constructor.
	 *
	 * @param l the l
	 */
	public EDPLkPoOffUserEntity(long l) {
	this.lkPoOffUserId =l;
	}

	/**
	 * Instantiates a new EDP lk po off user entity.
	 *
	 * @param lkPoOffUserId the lk po off user id
	 */
	public EDPLkPoOffUserEntity(Long lkPoOffUserId) {
		this.lkPoOffUserId = lkPoOffUserId;
	}

	/**
	 * Instantiates a new EDP lk po off user entity.
	 */
	public EDPLkPoOffUserEntity() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lkPoOffUserId, lkPostOfficeId, userId, isPrimaryPost);
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
		if (!(obj instanceof EDPLkPoOffUserEntity)) {
			return false;
		}

		EDPLkPoOffUserEntity other = (EDPLkPoOffUserEntity) obj;

		return Objects.equals(lkPoOffUserId, other.lkPoOffUserId)
				&& Objects.equals(lkPostOfficeId, other.lkPostOfficeId) && Objects.equals(userId, other.userId)
				&& Objects.equals(isPrimaryPost, other.isPrimaryPost);
	}

	/**
	 * Sets the lk po off user id.
	 *
	 * @param lkPoOffUserId the new lk po off user id
	 */
	public void setLkPoOffUserId(Long lkPoOffUserId) {
		this.lkPoOffUserId = lkPoOffUserId;
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
	 * Gets the lk po off user id.
	 *
	 * @return the lkPoOffUserId
	 */
	public Long getLkPoOffUserId() {
		return lkPoOffUserId;
	}
	
	

}
