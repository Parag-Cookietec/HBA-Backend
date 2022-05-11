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
 * The Class EDPLkPostUserEntity.
 */
@Entity
@Table(name = "LK_POST_USER", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLkPostUserEntity extends BaseEntity implements Serializable {
	

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_USER_ID")
	private long postUserId;

	/** The edp ms posts. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_ID")
	private EDPMsPostEntity edpMsPosts;

	/** The edp ms users. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private EDPMsUserEntity edpMsUsers;

	/**
	 * Gets the post user id.
	 *
	 * @return the postUserId
	 */
	public long getPostUserId() {
		return postUserId;
	}

	/**
	 * Sets the post user id.
	 *
	 * @param postUserId the postUserId to set
	 */
	public void setPostUserId(long postUserId) {
		this.postUserId = postUserId;
	}

	/**
	 * Instantiates a new EDP lk post user entity.
	 *
	 * @param postUserId the post user id
	 * @param edpMsPosts the edp ms posts
	 * @param edpMsUsers the edp ms users
	 */
	public EDPLkPostUserEntity(long postUserId, EDPMsPostEntity edpMsPosts, EDPMsUserEntity edpMsUsers) {
		super();
		this.postUserId = postUserId;
		this.edpMsPosts = edpMsPosts;
		this.edpMsUsers = edpMsUsers;
	}

	/**
	 * Instantiates a new EDP lk post user entity.
	 */
	public EDPLkPostUserEntity() {
		super();
	}

	/**
	 * Gets the edp ms posts.
	 *
	 * @return the edp ms posts
	 */
	public EDPMsPostEntity getEdpMsPosts() {
		return edpMsPosts;
	}

	/**
	 * Sets the edp ms posts.
	 *
	 * @param edpMsPosts the new edp ms posts
	 */
	public void setEdpMsPosts(EDPMsPostEntity edpMsPosts) {
		this.edpMsPosts = edpMsPosts;
	}

	/**
	 * Gets the edp ms users.
	 *
	 * @return the edp ms users
	 */
	public EDPMsUserEntity getEdpMsUsers() {
		return edpMsUsers;
	}

	/**
	 * Sets the edp ms users.
	 *
	 * @param edpMsUsers the new edp ms users
	 */
	public void setEdpMsUsers(EDPMsUserEntity edpMsUsers) {
		this.edpMsUsers = edpMsUsers;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edpMsPosts, edpMsUsers, postUserId);
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
		if (!(obj instanceof EDPLkPostUserEntity)) {
			return false;
		}
		EDPLkPostUserEntity other = (EDPLkPostUserEntity) obj;
		return Objects.equals(edpMsPosts, other.edpMsPosts) && Objects.equals(edpMsUsers, other.edpMsUsers)
				&& postUserId == other.postUserId;
	}
	
}
