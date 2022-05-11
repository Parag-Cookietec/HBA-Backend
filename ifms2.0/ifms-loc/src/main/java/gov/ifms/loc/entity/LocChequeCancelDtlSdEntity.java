package gov.ifms.loc.entity;

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

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocConstant;

/**
 * The Class LocChequeCancelDtlSdEntity.
 *
 * @version v 1.0
 * @created 2021/03/06 17:39:31
 */
@Entity
@Table(name = "TLOC_CHEQUE_CANCEL_DTL_SD", schema = LocConstant.LOC_SCHEMA)
public class LocChequeCancelDtlSdEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The dtl id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TLOC_CHEQUE_CANCEL_DTL_SD_ID")
	private Long id;

	/** The hdr id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "TLOC_CHEQUE_CANCEL_HDR_ID", referencedColumnName = "CHEQUE_CANCELLATION_ID")
	private LocChequeCancelHdrEntity hdrId;

	/** The advice id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "TLOC_ADVICE_HDR_ID", referencedColumnName = "TLOC_ADVICE_HDR_ID")
	private LocAdvicePrepHdrEntity adviceId;

	/** The head wise id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LC_ADVICE_HEADWISE_ID", referencedColumnName = "LC_ADVICE_HEADWISE_ID")
	private LocAdvicePartHeadwisedetaisEntity headWiseId;

	/** The head cancel chq amt. */
	@Column(name = "HEAD_CANCEL_CHEQUE_AMT")
	private Double headCancelChqAmt;

	/** The wf id. */
	@Column(name = "WF_ID")
	private Long wfId;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/** The status id. */
	@Column(name = "STATUS_ID")
	private Long statusId;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdr id
	 */
	public LocChequeCancelHdrEntity getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the new hdr id
	 */
	public void setHdrId(LocChequeCancelHdrEntity hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * Gets the advice id.
	 *
	 * @return the advice id
	 */
	public LocAdvicePrepHdrEntity getAdviceId() {
		return adviceId;
	}

	/**
	 * Sets the advice id.
	 *
	 * @param adviceId the new advice id
	 */
	public void setAdviceId(LocAdvicePrepHdrEntity adviceId) {
		this.adviceId = adviceId;
	}

	/**
	 * Gets the head wise id.
	 *
	 * @return the headWiseId
	 */
	public LocAdvicePartHeadwisedetaisEntity getHeadWiseId() {
		return headWiseId;
	}

	/**
	 * Sets the head wise id.
	 *
	 * @param headWiseId the headWiseId to set
	 */
	public void setHeadWiseId(LocAdvicePartHeadwisedetaisEntity headWiseId) {
		this.headWiseId = headWiseId;
	}

	/**
	 * Gets the head cancel chq amt.
	 *
	 * @return the headCancelChqAmt
	 */
	public Double getHeadCancelChqAmt() {
		return headCancelChqAmt;
	}

	/**
	 * Sets the head cancel chq amt.
	 *
	 * @param headCancelChqAmt the headCancelChqAmt to set
	 */
	public void setHeadCancelChqAmt(Double headCancelChqAmt) {
		this.headCancelChqAmt = headCancelChqAmt;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wf id
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the new wf id
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wf role id
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the new wf role id
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LocChequeCancelDtlSdEntity))
			return false;
		LocChequeCancelDtlSdEntity that = (LocChequeCancelDtlSdEntity) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getHdrId(), that.getHdrId())
				&& Objects.equals(getAdviceId(), that.getAdviceId())
				&& Objects.equals(getHeadWiseId(), that.getHeadWiseId())
				&& Objects.equals(getHeadCancelChqAmt(), that.getHeadCancelChqAmt())
				&& Objects.equals(getWfId(), that.getWfId()) && Objects.equals(getWfRoleId(), that.getWfRoleId())
				&& Objects.equals(getStatusId(), that.getStatusId());
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getId(), getHdrId(), getAdviceId(), getHeadWiseId(), getHeadCancelChqAmt(), getWfId(),
				getWfRoleId(), getStatusId());
	}

	/**
	 * Instantiates a new loc cheque cancel dtl sd entity.
	 */
	public LocChequeCancelDtlSdEntity() {
		super();

	}

}
