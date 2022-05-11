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
 * The Class EDPLkPostUserOfficeEntity.
 * 
 * @version 1.0
 * @created 2019/09/11 16:43:32
 *
 */
@Entity
@Table(name = "LK_POST_USER_OFFICE", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPLkPostUserOfficeEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_USER_OFFICE_ID")
	private Long postUserId;

	/** The user entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID",referencedColumnName= "USER_ID")
	private EDPMsUserEntity userEntity;
	
	/** The post entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_ID",referencedColumnName= "POST_ID")
	private EDPMsPostEntity postEntity;
	
	/** The office entity. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFICE_ID",referencedColumnName= "OFFICE_ID")
	private EDPMsOfficeEntity officeEntity;
	
	/** The is primary post. */
	@Column(name="IS_PRIMARY_POST")
	private boolean isPrimaryPost;
	
	/**
	 * Gets the post user id.
	 *
	 * @return the postUserId
	 */
	public Long getPostUserId() {
		return postUserId;
	}

	/**
	 * Sets the post user id.
	 *
	 * @param postUserId the postUserId to set
	 */
	public void setPostUserId(Long postUserId) {
		this.postUserId = postUserId;
	}

	/**
	 * Gets the user entity.
	 *
	 * @return the user entity
	 */
	public EDPMsUserEntity getUserEntity() {
		return userEntity;
	}

	/**
	 * Sets the user entity.
	 *
	 * @param userEntity the new user entity
	 */
	public void setUserEntity(EDPMsUserEntity userEntity) {
		this.userEntity = userEntity;
	}

	/**
	 * Gets the post entity.
	 *
	 * @return the post entity
	 */
	public EDPMsPostEntity getPostEntity() {
		return postEntity;
	}

	/**
	 * Sets the post entity.
	 *
	 * @param postEntity the new post entity
	 */
	public void setPostEntity(EDPMsPostEntity postEntity) {
		this.postEntity = postEntity;
	}

	/**
	 * Gets the office entity.
	 *
	 * @return the office entity
	 */
	public EDPMsOfficeEntity getOfficeEntity() {
		return officeEntity;
	}

	/**
	 * Sets the office entity.
	 *
	 * @param officeEntity the new office entity
	 */
	public void setOfficeEntity(EDPMsOfficeEntity officeEntity) {
		this.officeEntity = officeEntity;
	}

	/**
	 * Checks if is primary post.
	 *
	 * @return true, if is primary post
	 */
	public boolean isPrimaryPost() {
		return isPrimaryPost;
	}

	/**
	 * Sets the primary post.
	 *
	 * @param isPrimaryPost the new primary post
	 */
	public void setPrimaryPost(boolean isPrimaryPost) {
		this.isPrimaryPost = isPrimaryPost;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(officeEntity, postEntity, postUserId, userEntity,isPrimaryPost);
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
		if (!(obj instanceof EDPLkPostUserOfficeEntity)) {
			return false;
		}
		EDPLkPostUserOfficeEntity other = (EDPLkPostUserOfficeEntity) obj;
		return Objects.equals(officeEntity, other.officeEntity) && Objects.equals(postEntity, other.postEntity)
				&& Objects.equals(postUserId, other.postUserId) && Objects.equals(userEntity, other.userEntity)
				&& Objects.equals(isPrimaryPost, other.isPrimaryPost);
	}

	@Override
	public String toString() {
		return "EDPLkPostUserOfficeEntity [postUserId=" + postUserId + ", userEntity=" + userEntity + ", postEntity="
				+ postEntity + ", officeEntity=" + officeEntity + ", isPrimaryPost=" + isPrimaryPost + "]";
	}
	
}
