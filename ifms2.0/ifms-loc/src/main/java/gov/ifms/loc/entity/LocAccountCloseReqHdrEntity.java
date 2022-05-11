package gov.ifms.loc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.loc.util.LocConstant;

/**
 * The Class LocAccountCloseReqHdrEntity.
 * 
 * @version 1.0
 * @created 2021/01/31 12:52:20
 *
 */
@Entity
@Table(name = "TLOC_LC_CLOSING_REQUEST_HDR", schema = LocConstant.LOC_SCHEMA)
public class LocAccountCloseReqHdrEntity extends BaseEntity implements Serializable {
	
	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

		/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LC_CLOSING_REQUEST_HDR_ID")
	private Long lcCloseReqHdrId;

	/** The reference no. */
	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	/** The reference dt. */
	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	/** The Status Id. */
	@Column(name = "STATUS_ID")
	private String statusId;
	

	/** The approval dt. */
	@Column(name = "APPROVAL_DT")
	private Date approvalDt;

	
	/** The lcClosing dt. */
	@Column(name = "LC_CLOSING_DT")
	private Date lcclosingDt;
	
	
	
	/** The Closure Remarks. */
	@Column(name = "CLOSURE_REMARK")
	private String closureRemark;
	
	
	
	/** The Closure Remarks. */
	@Column(name = "AG_CLOSURE_REMARK")
	private String agClosureRemark;
	
    

	/** The lc open req hdr id. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LC_OPEN_REQUEST_ID", referencedColumnName = "LC_OPEN_REQUEST_ID")
    private LocAccountOpeningRequestHdrEntity lcOpenRequestId;
	

	/** The wf id. */
	@Column(name = "WF_ID")
	private Long wfId;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;
	
	/** The office id re lay. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;
	
	/**
	 * LocAccountCloseReqHdrDto Constructor
	 */
	public LocAccountCloseReqHdrEntity() {
		super();
	}

	/**
	 * Instantiates a new loc account Close req hdr entity.
	 *
	 * @param lcCloseReqHdrId the lc Close req hdr id
	 */
	public LocAccountCloseReqHdrEntity(Long lcCloseReqHdrId) {
		super();
		this.lcCloseReqHdrId = lcCloseReqHdrId;
	}


	/**
	 * hascode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lcCloseReqHdrId, referenceNo, referenceDt, approvalDt, lcclosingDt,
				closureRemark, agClosureRemark, lcOpenRequestId,  statusId, wfId, wfRoleId);
	}
	
	
	/**
	 * equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LocAccountCloseReqHdrEntity)) {
			return false;
		}

		LocAccountCloseReqHdrEntity other = (LocAccountCloseReqHdrEntity) obj;
	

		return Objects.equals(lcCloseReqHdrId, other.lcCloseReqHdrId)
				&& Objects.equals(referenceNo, other.referenceNo)
				&& Objects.equals(referenceDt, other.referenceDt)
				&& Objects.equals(approvalDt, other.approvalDt)
				&& Objects.equals(lcclosingDt, other.lcclosingDt)
				&& Objects.equals(closureRemark, other.closureRemark) && Objects.equals(agClosureRemark, other.agClosureRemark)
				&& Objects.equals(lcOpenRequestId, other.lcOpenRequestId) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(wfId, other.wfId) && Objects.equals(wfRoleId, other.wfRoleId)
				 && Objects.equals(officeId, other.officeId);
	}
	
	/**
	 * Gets the lc close req hdr id.
	 *
	 * @return the lc close req hdr id
	 */
	public Long getLcCloseReqHdrId() {
		return lcCloseReqHdrId;
	}

	/**
	 * Sets the lc close req hdr id.
	 *
	 * @param lcCloseReqHdrId the new lc close req hdr id
	 */
	public void setLcCloseReqHdrId(Long lcCloseReqHdrId) {
		this.lcCloseReqHdrId = lcCloseReqHdrId;
	}

	/**
	 * Gets the reference no.
	 *
	 * @return the reference no
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * Sets the reference no.
	 *
	 * @param referenceNo the new reference no
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/**
	 * Gets the reference dt.
	 *
	 * @return the reference dt
	 */
	public Date getReferenceDt() {
		return referenceDt;
	}

	/**
	 * Sets the reference dt.
	 *
	 * @param referenceDt the new reference dt
	 */
	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	
	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public String getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	
	/**
	 * Gets the approval dt.
	 *
	 * @return the approval dt
	 */
	public Date getApprovalDt() {
		return approvalDt;
	}

	/**
	 * Sets the approval dt.
	 *
	 * @param approvalDt the new approval dt
	 */
	public void setApprovalDt(Date approvalDt) {
		this.approvalDt = approvalDt;
	}

	/**
	 * Gets the lcclosing dt.
	 *
	 * @return the lcclosing dt
	 */
	public Date getLcclosingDt() {
		return lcclosingDt;
	}

	/**
	 * Sets the lcclosing dt.
	 *
	 * @param lcclosingDt the new lcclosing dt
	 */
	public void setLcclosingDt(Date lcclosingDt) {
		this.lcclosingDt = lcclosingDt;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the closure remark.
	 *
	 * @return the closure remark
	 */
	public String getClosureRemark() {
		return closureRemark;
	}

	/**
	 * Sets the closure remark.
	 *
	 * @param closureRemark the new closure remark
	 */
	public void setClosureRemark(String closureRemark) {
		this.closureRemark = closureRemark;
	}

	/**
	 * Gets the ag closure remark.
	 *
	 * @return the ag closure remark
	 */
	public String getAgClosureRemark() {
		return agClosureRemark;
	}

	/**
	 * Sets the ag closure remark.
	 *
	 * @param agClosureRemark the new ag closure remark
	 */
	public void setAgClosureRemark(String agClosureRemark) {
		this.agClosureRemark = agClosureRemark;
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
	 * Gets the lc open request id.
	 *
	 * @return the lc open request id
	 */
	public LocAccountOpeningRequestHdrEntity getLcOpenRequestId() {
		return lcOpenRequestId;
	}

	/**
	 * Sets the lc open request id.
	 *
	 * @param lcOpenRequestId the new lc open request id
	 */
	public void setLcOpenRequestId(LocAccountOpeningRequestHdrEntity lcOpenRequestId) {
		this.lcOpenRequestId = lcOpenRequestId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "LocAccountCloseReqHdrEntity [lcCloseReqHdrId=" + lcCloseReqHdrId + ", referenceNo=" + referenceNo
				+ ", referenceDt=" + referenceDt + ", statusId ="+statusId+",approvalDt=" + approvalDt + ", lcclosingDt="
				+ lcclosingDt + ", closureRemark=" + closureRemark + ", agClosureRemark=" + agClosureRemark + ", lcOpenRequestId="
				+ lcOpenRequestId + ", wfId=" + wfId + ", wfRoleId=" + wfRoleId + ",officeId = "+officeId+",]";
	}

	

}
