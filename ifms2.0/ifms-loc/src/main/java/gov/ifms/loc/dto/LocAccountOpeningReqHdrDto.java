package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocAccountOpeningReqHdrDto.
 */
public class LocAccountOpeningReqHdrDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The lc open request id.
	 */
	private Long lcOpenRequestId;

	/** The reference no. */
	private String referenceNo;

	/** The reference dt. */
	private Date referenceDt;

	/** The lc account name. */
	private String lcAccountName;

	/** The status cd. */
	private String statusCd;

	/** The requesting office id. */
	private Long requestingOfficeId;

	/** The to office id. */
	private Long toOfficeId;

	/** The dept id re hdr. */
	private Long deptIdReHdr;

	/** The division cd. */
	private Long divisionCd;

	/** The circle id. */
	private Long circleId;

	/** The circle name. */
	private String circleName;

	/** The hod idre hdr. */
	private Long hodIdreHdr;

	/** The hod name. */
	private String hodName;

	/** The cardex no. */
	private Long cardexNo;

	/** The ddo no. */
	private Long ddoNo;

	/** The remarks. */
	private String remarks;

	/**
	 * The ag authorization no.
	 */
	private Long agAuthorizationNo;

	/**
	 * The ag authorization dt.
	 */
	private Date agAuthorizationDt;

	/**
	 * The ag remarks.
	 */
	private String agRemarks;

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
	 * The bank id.
	 */
	private Long bankId;

	/**
	 * The bank branch id.
	 */
	private Long bankBranchId;

	/**
	 * The bank remarks.
	 */
	private String bankRemarks;

	/**
	 * The division remarks.
	 */
	private String divisionRemarks;

	/** The pending with user id. */
	private Long pendingWithUserId;

	/** The created by user id. */
	private Long createdByUserId;

	/** The created by post id. */
	private Long createdByPostId;

	/**
	 * The wf id.
	 */
	private Long wfId;

	/**
	 * The wf role id.
	 */
	private Long wfRoleId;

	/** The division office address. */
	private String divisionOfficeAddress;

	/** The district id. */
	private long districtId;

	/** The division code. */
	private String divisionCode;

	/** The division name. */
	private String divisionName;

	/** The circle code. */
	private String circleCode;

	/**
	 * LocAccountOpeningReqHdrDto Constructor.
	 */
	public LocAccountOpeningReqHdrDto() {
		super();
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
	 * Gets the lc account name.
	 *
	 * @return the lc account name
	 */
	public String getLcAccountName() {
		return lcAccountName;
	}

	/**
	 * Sets the lc account name.
	 *
	 * @param lcAccountName the new lc account name
	 */
	public void setLcAccountName(String lcAccountName) {
		this.lcAccountName = lcAccountName;
	}

	/**
	 * Gets the status cd.
	 *
	 * @return the status cd
	 */
	public String getStatusCd() {
		return statusCd;
	}

	/**
	 * Sets the status cd.
	 *
	 * @param statusCd the new status cd
	 */
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}

	/**
	 * Gets the requesting office id.
	 *
	 * @return the requesting office id
	 */
	public Long getRequestingOfficeId() {
		return requestingOfficeId;
	}

	/**
	 * Sets the requesting office id.
	 *
	 * @param requestingOfficeId the new requesting office id
	 */
	public void setRequestingOfficeId(Long requestingOfficeId) {
		this.requestingOfficeId = requestingOfficeId;
	}

	/**
	 * Gets the to office id.
	 *
	 * @return the to office id
	 */
	public Long getToOfficeId() {
		return toOfficeId;
	}

	/**
	 * Sets the to office id.
	 *
	 * @param toOfficeId the new to office id
	 */
	public void setToOfficeId(Long toOfficeId) {
		this.toOfficeId = toOfficeId;
	}

	/**
	 * Gets the dept id re hdr.
	 *
	 * @return the dept id re hdr
	 */
	public Long getDeptIdReHdr() {
		return deptIdReHdr;
	}

	/**
	 * Sets the dept id re hdr.
	 *
	 * @param deptIdReHdr the new dept id re hdr
	 */
	public void setDeptIdReHdr(Long deptIdReHdr) {
		this.deptIdReHdr = deptIdReHdr;
	}

	/**
	 * Gets the division cd.
	 *
	 * @return the division cd
	 */
	public Long getDivisionCd() {
		return divisionCd;
	}

	/**
	 * Sets the division cd.
	 *
	 * @param divisionCd the new division cd
	 */
	public void setDivisionCd(Long divisionCd) {
		this.divisionCd = divisionCd;
	}

	/**
	 * Gets the circle id.
	 *
	 * @return the circle id
	 */
	public Long getCircleId() {
		return circleId;
	}

	/**
	 * Sets the circle id.
	 *
	 * @param circleId the new circle id
	 */
	public void setCircleId(Long circleId) {
		this.circleId = circleId;
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

	/**
	 * Gets the hod idre hdr.
	 *
	 * @return the hod idre hdr
	 */
	public Long getHodIdreHdr() {
		return hodIdreHdr;
	}

	/**
	 * Sets the hod idre hdr.
	 *
	 * @param hodIdreHdr the new hod idre hdr
	 */
	public void setHodIdreHdr(Long hodIdreHdr) {
		this.hodIdreHdr = hodIdreHdr;
	}

	/**
	 * Gets the hod name.
	 *
	 * @return the hod name
	 */
	public String getHodName() {
		return hodName;
	}

	/**
	 * Sets the hod name.
	 *
	 * @param hodName the new hod name
	 */
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardex no
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the new cardex no
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddo no
	 */
	public Long getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the new ddo no
	 */
	public void setDdoNo(Long ddoNo) {
		this.ddoNo = ddoNo;
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
	 * @param remarks the new remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Gets the ag authorization no.
	 *
	 * @return the ag authorization no
	 */
	public Long getAgAuthorizationNo() {
		return agAuthorizationNo;
	}

	/**
	 * Sets the ag authorization no.
	 *
	 * @param agAuthorizationNo the new ag authorization no
	 */
	public void setAgAuthorizationNo(Long agAuthorizationNo) {
		this.agAuthorizationNo = agAuthorizationNo;
	}

	/**
	 * Gets the ag authorization dt.
	 *
	 * @return the ag authorization dt
	 */
	public Date getAgAuthorizationDt() {
		return agAuthorizationDt;
	}

	/**
	 * Sets the ag authorization dt.
	 *
	 * @param agAuthorizationDt the new ag authorization dt
	 */
	public void setAgAuthorizationDt(Date agAuthorizationDt) {
		this.agAuthorizationDt = agAuthorizationDt;
	}

	/**
	 * Gets the ag remarks.
	 *
	 * @return the ag remarks
	 */
	public String getAgRemarks() {
		return agRemarks;
	}

	/**
	 * Sets the ag remarks.
	 *
	 * @param agRemarks the new ag remarks
	 */
	public void setAgRemarks(String agRemarks) {
		this.agRemarks = agRemarks;
	}

	/**
	 * Gets the major head id.
	 *
	 * @return the major head id
	 */
	public Long getMajorHeadId() {
		return majorHeadId;
	}

	/**
	 * Sets the major head id.
	 *
	 * @param majorHeadId the new major head id
	 */
	public void setMajorHeadId(Long majorHeadId) {
		this.majorHeadId = majorHeadId;
	}

	/**
	 * Gets the sub major head id.
	 *
	 * @return the sub major head id
	 */
	public Long getSubMajorHeadId() {
		return subMajorHeadId;
	}

	/**
	 * Sets the sub major head id.
	 *
	 * @param subMajorHeadId the new sub major head id
	 */
	public void setSubMajorHeadId(Long subMajorHeadId) {
		this.subMajorHeadId = subMajorHeadId;
	}

	/**
	 * Gets the minor head id.
	 *
	 * @return the minor head id
	 */
	public Long getMinorHeadId() {
		return minorHeadId;
	}

	/**
	 * Sets the minor head id.
	 *
	 * @param minorHeadId the new minor head id
	 */
	public void setMinorHeadId(Long minorHeadId) {
		this.minorHeadId = minorHeadId;
	}

	/**
	 * Gets the sub head id.
	 *
	 * @return the sub head id
	 */
	public Long getSubHeadId() {
		return subHeadId;
	}

	/**
	 * Sets the sub head id.
	 *
	 * @param subHeadId the new sub head id
	 */
	public void setSubHeadId(Long subHeadId) {
		this.subHeadId = subHeadId;
	}

	/**
	 * Gets the detail head id.
	 *
	 * @return the detail head id
	 */
	public Long getDetailHeadId() {
		return detailHeadId;
	}

	/**
	 * Sets the detail head id.
	 *
	 * @param detailHeadId the new detail head id
	 */
	public void setDetailHeadId(Long detailHeadId) {
		this.detailHeadId = detailHeadId;
	}

	/**
	 * Gets the bank id.
	 *
	 * @return the bank id
	 */
	public Long getBankId() {
		return bankId;
	}

	/**
	 * Sets the bank id.
	 *
	 * @param bankId the new bank id
	 */
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	/**
	 * Gets the bank branch id.
	 *
	 * @return the bank branch id
	 */
	public Long getBankBranchId() {
		return bankBranchId;
	}

	/**
	 * Sets the bank branch id.
	 *
	 * @param bankBranchId the new bank branch id
	 */
	public void setBankBranchId(Long bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	/**
	 * Gets the bank remarks.
	 *
	 * @return the bank remarks
	 */
	public String getBankRemarks() {
		return bankRemarks;
	}

	/**
	 * Sets the bank remarks.
	 *
	 * @param bankRemarks the new bank remarks
	 */
	public void setBankRemarks(String bankRemarks) {
		this.bankRemarks = bankRemarks;
	}

	/**
	 * Gets the division remarks.
	 *
	 * @return the division remarks
	 */
	public String getDivisionRemarks() {
		return divisionRemarks;
	}

	/**
	 * Sets the division remarks.
	 *
	 * @param divisionRemarks the new division remarks
	 */
	public void setDivisionRemarks(String divisionRemarks) {
		this.divisionRemarks = divisionRemarks;
	}

	/**
	 * Gets the pending with user id.
	 *
	 * @return the pending with user id
	 */
	public Long getPendingWithUserId() {
		return pendingWithUserId;
	}

	/**
	 * Sets the pending with user id.
	 *
	 * @param pendingWithUserId the new pending with user id
	 */
	public void setPendingWithUserId(Long pendingWithUserId) {
		this.pendingWithUserId = pendingWithUserId;
	}

	/**
	 * Gets the created by user id.
	 *
	 * @return the created by user id
	 */
	public Long getCreatedByUserId() {
		return createdByUserId;
	}

	/**
	 * Sets the created by user id.
	 *
	 * @param createdByUserId the new created by user id
	 */
	public void setCreatedByUserId(Long createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	/**
	 * Gets the created by post id.
	 *
	 * @return the created by post id
	 */
	public Long getCreatedByPostId() {
		return createdByPostId;
	}

	/**
	 * Sets the created by post id.
	 *
	 * @param createdByPostId the new created by post id
	 */
	public void setCreatedByPostId(Long createdByPostId) {
		this.createdByPostId = createdByPostId;
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
	 * Gets the division office address.
	 *
	 * @return the division office address
	 */
	public String getDivisionOfficeAddress() {
		return divisionOfficeAddress;
	}

	/**
	 * Sets the division office address.
	 *
	 * @param divisionOfficeAddress the new division office address
	 */
	public void setDivisionOfficeAddress(String divisionOfficeAddress) {
		this.divisionOfficeAddress = divisionOfficeAddress;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the district id
	 */
	public long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the new district id
	 */
	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	/**
	 * Gets the division code.
	 *
	 * @return the division code
	 */
	public String getDivisionCode() {
		return divisionCode;
	}

	/**
	 * Sets the division code.
	 *
	 * @param divisionCode the new division code
	 */
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	/**
	 * Gets the division name.
	 *
	 * @return the division name
	 */
	public String getDivisionName() {
		return divisionName;
	}

	/**
	 * Sets the division name.
	 *
	 * @param divisionName the new division name
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	/**
	 * Gets the circle code.
	 *
	 * @return the circle code
	 */
	public String getCircleCode() {
		return circleCode;
	}

	/**
	 * Sets the circle code.
	 *
	 * @param circleCode the new circle code
	 */
	public void setCircleCode(String circleCode) {
		this.circleCode = circleCode;
	}

}
