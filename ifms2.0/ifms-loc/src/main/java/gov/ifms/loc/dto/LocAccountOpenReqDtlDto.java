package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocAccountOpenReqDtlDto.
 *
 * @version 1.0
 * @created 2020/12/23 11:53:12
 */
public class LocAccountOpenReqDtlDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The lc open request id.
	 */
	private Long lcOpenRequestId;

	/**
	 * The lc open req hdr id.
	 */
	private Long lcOpenReqHdrId;

	/**
	 * The ag authorization no.
	 */
	private Long agAuthorizationNo;

	/**
	 * The ag authorization dt.
	 */
	private Date agAuthorizationDt;

	/**
	 * The major head id.
	 */
	private Long majorHeadId;

	/**
	 * The sub major head id.
	 */
	private Long subMajorHeadId;

	/**
	 * The minor head id.
	 */
	private Long minorHeadId;

	/**
	 * The sub head id.
	 */
	private Long subHeadId;

	/**
	 * The detail head id.
	 */
	private Long detailHeadId;

	/**
	 * The ag remarks.
	 */
	private String agRemarks;

	/**
	 * The bank id.
	 */
	private Long bankId;

	/**
	 * The bank branch id.
	 */
	private Long bankBranchId;

	/**
	 * The bank code.
	 */
	private Long bankCode;

	/**
	 * The bank remarks.
	 */
	private String bankRemarks;

	/**
	 * The division name.
	 */
	private String divisionName;

	/**
	 * The division remarks.
	 */
	private String divisionRemarks;

	/**
	 * The status id.
	 */
	private Long statusId;

	/**
	 * The wf id.
	 */
	private Long wfId;

	/**
	 * The wf role id.
	 */
	private Long wfRoleId;

	/**
	 * The remarks.
	 */
	private String remarks;

	/**
	 * The circle id.
	 */
	private Long circleId;

	/**
	 * The circle code.
	 */
	private Long circleCode;

	/**
	 * The is editable.
	 */
	private Integer isEditable;

	/** The circle name. */
	private String circleName;

	/**
	 * LocAccountOpenReqDtlDto Constructor.
	 */
	public LocAccountOpenReqDtlDto() {
		super();
	}

	/**
	 * getter setter.
	 *
	 * @return the lc open request id
	 */

	/**
	 * @return the lcOpenRequestId
	 */
	public Long getLcOpenRequestId() {
		return lcOpenRequestId;
	}

	/**
	 * Sets the lc open request id.
	 *
	 * @param lcOpenRequestId the lcOpenRequestId to set
	 */
	public void setLcOpenRequestId(Long lcOpenRequestId) {
		this.lcOpenRequestId = lcOpenRequestId;
	}

	/**
	 * Gets the lc open req hdr id.
	 *
	 * @return the lcOpenReqHdrId
	 */
	public Long getLcOpenReqHdrId() {
		return lcOpenReqHdrId;
	}

	/**
	 * Sets the lc open req hdr id.
	 *
	 * @param lcOpenReqHdrId the lcOpenReqHdrId to set
	 */
	public void setLcOpenReqHdrId(Long lcOpenReqHdrId) {
		this.lcOpenReqHdrId = lcOpenReqHdrId;
	}

	/**
	 * Gets the ag authorization no.
	 *
	 * @return the agAuthorizationNo
	 */
	public Long getAgAuthorizationNo() {
		return agAuthorizationNo;
	}

	/**
	 * Sets the ag authorization no.
	 *
	 * @param agAuthorizationNo the agAuthorizationNo to set
	 */
	public void setAgAuthorizationNo(Long agAuthorizationNo) {
		this.agAuthorizationNo = agAuthorizationNo;
	}

	/**
	 * Gets the ag authorization dt.
	 *
	 * @return the agAuthorizationDt
	 */
	public Date getAgAuthorizationDt() {
		return agAuthorizationDt;
	}

	/**
	 * Sets the ag authorization dt.
	 *
	 * @param agAuthorizationDt the agAuthorizationDt to set
	 */
	public void setAgAuthorizationDt(Date agAuthorizationDt) {
		this.agAuthorizationDt = agAuthorizationDt;
	}

	/**
	 * Gets the major head id.
	 *
	 * @return the majorHeadId
	 */
	public Long getMajorHeadId() {
		return majorHeadId;
	}

	/**
	 * Sets the major head id.
	 *
	 * @param majorHeadId the majorHeadId to set
	 */
	public void setMajorHeadId(Long majorHeadId) {
		this.majorHeadId = majorHeadId;
	}

	/**
	 * Gets the sub major head id.
	 *
	 * @return the subMajorHeadId
	 */
	public Long getSubMajorHeadId() {
		return subMajorHeadId;
	}

	/**
	 * Sets the sub major head id.
	 *
	 * @param subMajorHeadId the subMajorHeadId to set
	 */
	public void setSubMajorHeadId(Long subMajorHeadId) {
		this.subMajorHeadId = subMajorHeadId;
	}

	/**
	 * Gets the minor head id.
	 *
	 * @return the minorHeadId
	 */
	public Long getMinorHeadId() {
		return minorHeadId;
	}

	/**
	 * Sets the minor head id.
	 *
	 * @param minorHeadId the minorHeadId to set
	 */
	public void setMinorHeadId(Long minorHeadId) {
		this.minorHeadId = minorHeadId;
	}

	/**
	 * Gets the sub head id.
	 *
	 * @return the subHeadId
	 */
	public Long getSubHeadId() {
		return subHeadId;
	}

	/**
	 * Sets the sub head id.
	 *
	 * @param subHeadId the subHeadId to set
	 */
	public void setSubHeadId(Long subHeadId) {
		this.subHeadId = subHeadId;
	}

	/**
	 * Gets the detail head id.
	 *
	 * @return the detailHeadId
	 */
	public Long getDetailHeadId() {
		return detailHeadId;
	}

	/**
	 * Sets the detail head id.
	 *
	 * @param detailHeadId the detailHeadId to set
	 */
	public void setDetailHeadId(Long detailHeadId) {
		this.detailHeadId = detailHeadId;
	}

	/**
	 * Gets the ag remarks.
	 *
	 * @return the agRemarks
	 */
	public String getAgRemarks() {
		return agRemarks;
	}

	/**
	 * Sets the ag remarks.
	 *
	 * @param agRemarks the agRemarks to set
	 */
	public void setAgRemarks(String agRemarks) {
		this.agRemarks = agRemarks;
	}

	/**
	 * Gets the bank id.
	 *
	 * @return the bankId
	 */
	public Long getBankId() {
		return bankId;
	}

	/**
	 * Sets the bank id.
	 *
	 * @param bankId the bankId to set
	 */
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	/**
	 * Gets the bank branch id.
	 *
	 * @return the bankBranchId
	 */
	public Long getBankBranchId() {
		return bankBranchId;
	}

	/**
	 * Sets the bank branch id.
	 *
	 * @param bankBranchId the bankBranchId to set
	 */
	public void setBankBranchId(Long bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	/**
	 * Gets the bank code.
	 *
	 * @return the bankCode
	 */
	public Long getBankCode() {
		return bankCode;
	}

	/**
	 * Sets the bank code.
	 *
	 * @param bankCode the bankCode to set
	 */
	public void setBankCode(Long bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * Gets the bank remarks.
	 *
	 * @return the bankRemarks
	 */
	public String getBankRemarks() {
		return bankRemarks;
	}

	/**
	 * Sets the bank remarks.
	 *
	 * @param bankRemarks the bankRemarks to set
	 */
	public void setBankRemarks(String bankRemarks) {
		this.bankRemarks = bankRemarks;
	}

	/**
	 * Gets the division name.
	 *
	 * @return the divisionName
	 */
	public String getDivisionName() {
		return divisionName;
	}

	/**
	 * Sets the division name.
	 *
	 * @param divisionName the divisionName to set
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	/**
	 * Gets the division remarks.
	 *
	 * @return the divisionRemarks
	 */
	public String getDivisionRemarks() {
		return divisionRemarks;
	}

	/**
	 * Sets the division remarks.
	 *
	 * @param divisionRemarks the divisionRemarks to set
	 */
	public void setDivisionRemarks(String divisionRemarks) {
		this.divisionRemarks = divisionRemarks;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wfId
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the wfId to set
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
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
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Gets the circle id.
	 *
	 * @return the circleId
	 */
	public Long getCircleId() {
		return circleId;
	}

	/**
	 * Sets the circle id.
	 *
	 * @param circleId the circleId to set
	 */
	public void setCircleId(Long circleId) {
		this.circleId = circleId;
	}

	/**
	 * Gets the circle code.
	 *
	 * @return the circleCode
	 */
	public Long getCircleCode() {
		return circleCode;
	}

	/**
	 * Sets the circle code.
	 *
	 * @param circleCode the circleCode to set
	 */
	public void setCircleCode(Long circleCode) {
		this.circleCode = circleCode;
	}

	/**
	 * Gets the checks if is editable.
	 *
	 * @return the checks if is editable
	 */
	public Integer getIsEditable() {
		return isEditable;
	}

	/**
	 * Sets the checks if is editable.
	 *
	 * @param isEditable the new checks if is editable
	 */
	public void setIsEditable(Integer isEditable) {
		this.isEditable = isEditable;
	}

	/**
	 * Gets the circle name.
	 *
	 * @return the circle name
	 */
	public String getCircleName() {
		return circleName;
	}

	/**
	 * Sets the circle name.
	 *
	 * @param circleName the new circle name
	 */
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}
}
