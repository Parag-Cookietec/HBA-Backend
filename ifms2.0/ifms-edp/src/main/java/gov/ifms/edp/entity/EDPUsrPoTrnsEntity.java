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
import gov.ifms.edp.employe.EDPEmployeEntity;

/**
 * The Class EDPUsrPoTrnsEntity.
 */
@Entity
@Table(name = "TEDP_UPT", schema = Constant.EDP_SCHEMA)

public class EDPUsrPoTrnsEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The edp usr po trns id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDP_UPT_ID")
	private Long edpUsrPoTrnsId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LK_POST_OFFICE_ID", referencedColumnName = "LK_POST_OFFICE_ID")
	private EDPLkPostOfficeEntity postOfficeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEDP_UPT_HDR_ID", referencedColumnName = "TEDP_UPT_HDR_ID")
	private EDPUsrPoTrnsHeaderEntity edpUsrPoTrnsHeaderId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FROM_USER_ID", referencedColumnName = "USER_ID")
	private EDPMsUserEntity fromUserId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TO_USER_ID", referencedColumnName = "USER_ID")
	private EDPMsUserEntity toUserId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TO_EMP_ID", referencedColumnName = "EMP_ID")
	private EDPEmployeEntity toEmpId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WILL_BE_PRIMARY", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity willBePrimary;

	/**
	 * Instantiates a new EDP usr po trns entity.
	 *
	 * @param edpUsrPoTrnsId the edp usr po trns id
	 */
	public EDPUsrPoTrnsEntity(Long edpUsrPoTrnsId) {
		this.edpUsrPoTrnsId = edpUsrPoTrnsId;
	}

	/**
	 * Instantiates a new EDP usr po trns entity.
	 */
	public EDPUsrPoTrnsEntity() {
	}

	/**
	 * Gets the edp usr po trns id.
	 *
	 * @return the edp usr po trns id
	 */
	public Long getEdpUsrPoTrnsId() {
		return edpUsrPoTrnsId;
	}

	/**
	 * Sets the edp usr po trns id.
	 *
	 * @param edpUsrPoTrnsId the new edp usr po trns id
	 */
	public void setEdpUsrPoTrnsId(Long edpUsrPoTrnsId) {
		this.edpUsrPoTrnsId = edpUsrPoTrnsId;
	}

	/**
	 * Gets the post office id.
	 *
	 * @return the post office id
	 */
	public EDPLkPostOfficeEntity getPostOfficeId() {
		return postOfficeId;
	}

	/**
	 * Sets the post office id.
	 *
	 * @param postOfficeId the new post office id
	 */
	public void setPostOfficeId(EDPLkPostOfficeEntity postOfficeId) {
		this.postOfficeId = postOfficeId;
	}

	/**
	 * Gets the edp usr po trns header id.
	 *
	 * @return the edpUsrPoTrnsHeaderId
	 */
	public EDPUsrPoTrnsHeaderEntity getEdpUsrPoTrnsHeaderId() {
		return edpUsrPoTrnsHeaderId;
	}

	/**
	 * Sets the edp usr po trns header id.
	 *
	 * @param edpUsrPoTrnsHeaderId the edpUsrPoTrnsHeaderId to set
	 */
	public void setEdpUsrPoTrnsHeaderId(EDPUsrPoTrnsHeaderEntity edpUsrPoTrnsHeaderId) {
		this.edpUsrPoTrnsHeaderId = edpUsrPoTrnsHeaderId;
	}

	/**
	 * @return the fromUserId
	 */
	public EDPMsUserEntity getFromUserId() {
		return fromUserId;
	}

	/**
	 * @param fromUserId the fromUserId to set
	 */
	public void setFromUserId(EDPMsUserEntity fromUserId) {
		this.fromUserId = fromUserId;
	}

	/**
	 * @return the toUserId
	 */
	public EDPMsUserEntity getToUserId() {
		return toUserId;
	}

	/**
	 * @param toUserId the toUserId to set
	 */
	public void setToUserId(EDPMsUserEntity toUserId) {
		this.toUserId = toUserId;
	}

	/**
	 * @return the willBePrimary
	 */
	public EDPLuLookUpInfoEntity getWillBePrimary() {
		return willBePrimary;
	}

	/**
	 * @param willBePrimary the willBePrimary to set
	 */
	public void setWillBePrimary(EDPLuLookUpInfoEntity willBePrimary) {
		this.willBePrimary = willBePrimary;
	}

	/**
	 * @return the toEmpId
	 */
	public EDPEmployeEntity getToEmpId() {
		return toEmpId;
	}

	/**
	 * @param toEmpId the toEmpId to set
	 */
	public void setToEmpId(EDPEmployeEntity toEmpId) {
		this.toEmpId = toEmpId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edpUsrPoTrnsHeaderId, edpUsrPoTrnsId, fromUserId, postOfficeId, toEmpId, toUserId,
				willBePrimary);
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
		if (!(obj instanceof EDPUsrPoTrnsEntity)) {
			return false;
		}
		EDPUsrPoTrnsEntity other = (EDPUsrPoTrnsEntity) obj;
		return Objects.equals(edpUsrPoTrnsHeaderId, other.edpUsrPoTrnsHeaderId)
				&& Objects.equals(edpUsrPoTrnsId, other.edpUsrPoTrnsId) && Objects.equals(fromUserId, other.fromUserId)
				&& Objects.equals(postOfficeId, other.postOfficeId) && Objects.equals(toEmpId, other.toEmpId)
				&& Objects.equals(toUserId, other.toUserId) && Objects.equals(willBePrimary, other.willBePrimary);
	}
	

}
