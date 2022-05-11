package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocAccountOpenReqItrDto.
 *
 * @version 1.0
 * @created 2020/12/23 12:47:40
 */
public class LocAccountOpenReqItrDto extends BaseDto implements Serializable {

	/**
	 * The serialVersionUID
	 */
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
	 * LocAccountOpenReqItrDto Constructor
	 */
	public LocAccountOpenReqItrDto() {
		super();
	}

	/**
	 * getter setter
	 */

	/**
	 * @return the lcOpenRequestId
	 */
	public Long getLcOpenRequestId() {
		return lcOpenRequestId;
	}

	/**
	 * @param lcOpenRequestId the lcOpenRequestId to set
	 */
	public void setLcOpenRequestId(Long lcOpenRequestId) {
		this.lcOpenRequestId = lcOpenRequestId;
	}

	/**
	 * @return the lcOpenReqHdrId
	 */
	public Long getLcOpenReqHdrId() {
		return lcOpenReqHdrId;
	}

	/**
	 * @param lcOpenReqHdrId the lcOpenReqHdrId to set
	 */
	public void setLcOpenReqHdrId(Long lcOpenReqHdrId) {
		this.lcOpenReqHdrId = lcOpenReqHdrId;
	}

	/**
	 * @return the agAuthorizationNo
	 */
	public Long getAgAuthorizationNo() {
		return agAuthorizationNo;
	}

	/**
	 * @param agAuthorizationNo the agAuthorizationNo to set
	 */
	public void setAgAuthorizationNo(Long agAuthorizationNo) {
		this.agAuthorizationNo = agAuthorizationNo;
	}

	/**
	 * @return the agAuthorizationDt
	 */
	public Date getAgAuthorizationDt() {
		return agAuthorizationDt;
	}

	/**
	 * @param agAuthorizationDt the agAuthorizationDt to set
	 */
	public void setAgAuthorizationDt(Date agAuthorizationDt) {
		this.agAuthorizationDt = agAuthorizationDt;
	}

	/**
	 * @return the majorHeadId
	 */
	public Long getMajorHeadId() {
		return majorHeadId;
	}

	/**
	 * @param majorHeadId the majorHeadId to set
	 */
	public void setMajorHeadId(Long majorHeadId) {
		this.majorHeadId = majorHeadId;
	}

	/**
	 * @return the subMajorHeadId
	 */
	public Long getSubMajorHeadId() {
		return subMajorHeadId;
	}

	/**
	 * @param subMajorHeadId the subMajorHeadId to set
	 */
	public void setSubMajorHeadId(Long subMajorHeadId) {
		this.subMajorHeadId = subMajorHeadId;
	}

	/**
	 * @return the minorHeadId
	 */
	public Long getMinorHeadId() {
		return minorHeadId;
	}

	/**
	 * @param minorHeadId the minorHeadId to set
	 */
	public void setMinorHeadId(Long minorHeadId) {
		this.minorHeadId = minorHeadId;
	}

	/**
	 * @return the subHeadId
	 */
	public Long getSubHeadId() {
		return subHeadId;
	}

	/**
	 * @param subHeadId the subHeadId to set
	 */
	public void setSubHeadId(Long subHeadId) {
		this.subHeadId = subHeadId;
	}

	/**
	 * @return the detailHeadId
	 */
	public Long getDetailHeadId() {
		return detailHeadId;
	}

	/**
	 * @param detailHeadId the detailHeadId to set
	 */
	public void setDetailHeadId(Long detailHeadId) {
		this.detailHeadId = detailHeadId;
	}

	/**
	 * @return the agRemarks
	 */
	public String getAgRemarks() {
		return agRemarks;
	}

	/**
	 * @param agRemarks the agRemarks to set
	 */
	public void setAgRemarks(String agRemarks) {
		this.agRemarks = agRemarks;
	}

	/**
	 * @return the bankId
	 */
	public Long getBankId() {
		return bankId;
	}

	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the bankBranchId
	 */
	public Long getBankBranchId() {
		return bankBranchId;
	}

	/**
	 * @param bankBranchId the bankBranchId to set
	 */
	public void setBankBranchId(Long bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	/**
	 * @return the bankCode
	 */
	public Long getBankCode() {
		return bankCode;
	}

	/**
	 * @param bankCode the bankCode to set
	 */
	public void setBankCode(Long bankCode) {
		this.bankCode = bankCode;
	}

	/**
	 * @return the bankRemarks
	 */
	public String getBankRemarks() {
		return bankRemarks;
	}

	/**
	 * @param bankRemarks the bankRemarks to set
	 */
	public void setBankRemarks(String bankRemarks) {
		this.bankRemarks = bankRemarks;
	}

	/**
	 * @return the divisionName
	 */
	public String getDivisionName() {
		return divisionName;
	}

	/**
	 * @param divisionName the divisionName to set
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	/**
	 * @return the divisionRemarks
	 */
	public String getDivisionRemarks() {
		return divisionRemarks;
	}

	/**
	 * @param divisionRemarks the divisionRemarks to set
	 */
	public void setDivisionRemarks(String divisionRemarks) {
		this.divisionRemarks = divisionRemarks;
	}

	/**
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the wfId
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * @param wfId the wfId to set
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the circleId
	 */
	public Long getCircleId() {
		return circleId;
	}

	/**
	 * @param circleId the circleId to set
	 */
	public void setCircleId(Long circleId) {
		this.circleId = circleId;
	}

	/**
	 * @return the circleCode
	 */
	public Long getCircleCode() {
		return circleCode;
	}

	/**
	 * @param circleCode the circleCode to set
	 */
	public void setCircleCode(Long circleCode) {
		this.circleCode = circleCode;
	}

}
