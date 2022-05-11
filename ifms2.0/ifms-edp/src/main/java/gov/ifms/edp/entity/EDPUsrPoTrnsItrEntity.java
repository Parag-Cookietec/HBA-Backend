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
 * The Class EDPUsrPoTrnsItrEntity.
 */
@Entity
@Table(name = "TEDP_UPT_ITR", schema = Constant.EDP_SCHEMA)
public class EDPUsrPoTrnsItrEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The edp usr po trns itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDP_UPT_ITR_ID")
	private Long edpUsrPoTrnsItrId;

	/** The edp usr po trns id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEDP_UPT_ID", referencedColumnName = "TEDP_UPT_ID")
	private EDPUsrPoTrnsEntity edpUsrPoTrnsId;

	/** The post office id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LK_POST_OFFICE_ID", referencedColumnName = "LK_POST_OFFICE_ID")
	private EDPLkPostOfficeEntity postOfficeId;

	/** The edp usr po trns hearer id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEDP_UPT_HDR_ID", referencedColumnName = "TEDP_UPT_HDR_ID")
	private EDPUsrPoTrnsHeaderEntity edpUsrPoTrnsHearerId;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

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
	 * EDPUserPoTrnsDto Constructor.
	 */
	public EDPUsrPoTrnsItrEntity() {
		super();
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * Gets the edp usr po trns itr id.
	 *
	 * @return the edpUsrPoTrnsItrId
	 */
	public Long getEdpUsrPoTrnsItrId() {
		return edpUsrPoTrnsItrId;
	}

	/**
	 * Sets the edp usr po trns itr id.
	 *
	 * @param edpUsrPoTrnsItrId the edpUsrPoTrnsItrId to set
	 */
	public void setEdpUsrPoTrnsItrId(Long edpUsrPoTrnsItrId) {
		this.edpUsrPoTrnsItrId = edpUsrPoTrnsItrId;
	}

	/**
	 * Gets the edp usr po trns id.
	 *
	 * @return the edpUsrPoTrnsId
	 */
	public EDPUsrPoTrnsEntity getEdpUsrPoTrnsId() {
		return edpUsrPoTrnsId;
	}

	/**
	 * Sets the edp usr po trns id.
	 *
	 * @param edpUsrPoTrnsId the edpUsrPoTrnsId to set
	 */
	public void setEdpUsrPoTrnsId(EDPUsrPoTrnsEntity edpUsrPoTrnsId) {
		this.edpUsrPoTrnsId = edpUsrPoTrnsId;
	}

	/**
	 * Gets the post office id.
	 *
	 * @return the postOfficeId
	 */
	public EDPLkPostOfficeEntity getPostOfficeId() {
		return postOfficeId;
	}

	/**
	 * Sets the post office id.
	 *
	 * @param postOfficeId the postOfficeId to set
	 */
	public void setPostOfficeId(EDPLkPostOfficeEntity postOfficeId) {
		this.postOfficeId = postOfficeId;
	}

	/**
	 * Gets the edp usr po trns hearer id.
	 *
	 * @return the edpUsrPoTrnsHearerId
	 */
	public EDPUsrPoTrnsHeaderEntity getEdpUsrPoTrnsHearerId() {
		return edpUsrPoTrnsHearerId;
	}

	/**
	 * Sets the edp usr po trns hearer id.
	 *
	 * @param edpUsrPoTrnsHearerId the edpUsrPoTrnsHearerId to set
	 */
	public void setEdpUsrPoTrnsHearerId(EDPUsrPoTrnsHeaderEntity edpUsrPoTrnsHearerId) {
		this.edpUsrPoTrnsHearerId = edpUsrPoTrnsHearerId;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edpUsrPoTrnsHearerId, edpUsrPoTrnsId, edpUsrPoTrnsItrId, fromUserId, postOfficeId, toEmpId,
				toUserId, wfRoleId, willBePrimary);
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
		if (!(obj instanceof EDPUsrPoTrnsItrEntity)) {
			return false;
		}
		EDPUsrPoTrnsItrEntity other = (EDPUsrPoTrnsItrEntity) obj;
		return Objects.equals(edpUsrPoTrnsHearerId, other.edpUsrPoTrnsHearerId)
				&& Objects.equals(edpUsrPoTrnsId, other.edpUsrPoTrnsId)
				&& Objects.equals(edpUsrPoTrnsItrId, other.edpUsrPoTrnsItrId)
				&& Objects.equals(fromUserId, other.fromUserId) && Objects.equals(postOfficeId, other.postOfficeId)
				&& Objects.equals(toEmpId, other.toEmpId) && Objects.equals(toUserId, other.toUserId)
				&& Objects.equals(wfRoleId, other.wfRoleId) && Objects.equals(willBePrimary, other.willBePrimary);
	}

	
}
