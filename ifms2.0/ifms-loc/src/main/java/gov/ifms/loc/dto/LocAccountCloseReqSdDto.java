package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocAccountCloseReqSdDto.
 */
public class LocAccountCloseReqSdDto extends BaseDto implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The lc close req Sd id.
	 */
	private Long lcCloseReqSdId;

	/**
	 * The reference no.
	 */
	private String referenceNo;

	/**
	 * The reference dt.
	 */
	private Date referenceDt;

	/**
	 * The statusId.
	 */
	private String statusId;

	/**
	 * The approvalDt.
	 */
	private Date approvalDt;

	/**
	 * The lcclosingDt.
	 */
	private Date lcclosingDt;

	/**
	 * The closure Remarks.
	 */
	private String closureRemark;

	/**
	 * The Agclosure Remarks.
	 */
	private String agClosureRemark;

	/**
	 * The LCopenReq Id .
	 */
	private Long lcOpenRequestId;

	/**
	 * The LCCloseReq Id .
	 */
	private Long lcCloseReqHdrId;

	/**
	 * The wf id.
	 */
	private Long wfId;

	/**
	 * The wf role id.
	 */
	private Long wfRoleId;

	/**
	 * LocAccountCloseReqSdDto Constructor.
	 */
	public LocAccountCloseReqSdDto() {
		super();

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
	 * Gets the lc open request id.
	 *
	 * @return the lc open request id
	 */
	public Long getLcOpenRequestId() {
		return lcOpenRequestId;
	}

	/**
	 * Sets the lc open request id.
	 *
	 * @param lcOpenRequestId the new lc open request id
	 */
	public void setLcOpenRequestId(Long lcOpenRequestId) {
		this.lcOpenRequestId = lcOpenRequestId;
	}

	/**
	 * Gets the lc close req sd id.
	 *
	 * @return the lc close req sd id
	 */
	public Long getLcCloseReqSdId() {
		return lcCloseReqSdId;
	}

	/**
	 * Sets the lc close req sd id.
	 *
	 * @param lcCloseReqSdId the new lc close req sd id
	 */
	public void setLcCloseReqSdId(Long lcCloseReqSdId) {
		this.lcCloseReqSdId = lcCloseReqSdId;
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

}
