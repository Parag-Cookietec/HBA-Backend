package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;

/**
 * The Class LocAccountOpenReqHdrDto.
 *
 * @version 1.0
 * @created 2020/12/22 12:52:20
 */
public class LocAccountOpenReqHdrDto extends BaseDto implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The lc open req hdr id.
	 */
	private Long lcOpenReqHdrId;

	/**
	 * The reference no.
	 */
	private String referenceNo;

	/**
	 * The reference dt.
	 */
	private Date referenceDt;

	/**
	 * The division office address.
	 */

	private String divisionOfficeAddress;

	/**
	 * The department id.
	 */
	@NotNull
	private Long departmentId;

	/**
	 * The hod id.
	 */
	@NotNull
	private Long hodId;

	/**
	 * The office id.
	 */
	@NotNull
	private Long toOfficeId;

	/**
	 * The district id.
	 */
	@NotNull
	private Long districtId;

	/**
	 * The cardex no.
	 */
	@NotNull
	private Long cardexNo;

	/**
	 * The ddo no.
	 */
	@NotNull
	private Long ddoNo;

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
	 * The pending with user id.
	 */
	private Long pendingWithUserId;

	/**
	 * The requesting office id.
	 */
	private Long requestingOfficeId;

	/**
	 * The office id.
	 */
	private Long officeNameId;

	/**
	 * The loc account open req sd dto.
	 */
	private LocAccountOpenReqSdDto locAccountOpenReqSdDto;

	private WfUserReqSDDto wfUserReqSDDto;

	private String errorMessage;

	/**
	 * LocAccountOpenReqHdrDto Constructor.
	 */
	public LocAccountOpenReqHdrDto() {
		super();
	}

	/**
	 * Gets the lc open req hdr id.
	 *
	 * @return the lc open req hdr id
	 */
	public Long getLcOpenReqHdrId() {
		return lcOpenReqHdrId;
	}

	/**
	 * Sets the lc open req hdr id.
	 *
	 * @param lcOpenReqHdrId the new lc open req hdr id
	 */
	public void setLcOpenReqHdrId(Long lcOpenReqHdrId) {
		this.lcOpenReqHdrId = lcOpenReqHdrId;
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
	 * @return the referenceDt
	 */
	public Date getReferenceDt() {
		return referenceDt;
	}

	/**
	 * @param referenceDt the referenceDt to set
	 */
	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
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
	 * Gets the department id.
	 *
	 * @return the department id
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * Sets the department id.
	 *
	 * @param departmentId the new department id
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * Gets the hod id.
	 *
	 * @return the hod id
	 */
	public Long getHodId() {
		return hodId;
	}

	/**
	 * Sets the hod id.
	 *
	 * @param hodId the new hod id
	 */
	public void setHodId(Long hodId) {
		this.hodId = hodId;
	}

	/**
	 * @return the toOfficeId
	 */
	public Long getToOfficeId() {
		return toOfficeId;
	}

	/**
	 * @param toOfficeId the toOfficeId to set
	 */
	public void setToOfficeId(Long toOfficeId) {
		this.toOfficeId = toOfficeId;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the district id
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the new district id
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
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
	 * Gets the loc account open req sd dto.
	 *
	 * @return the loc account open req sd dto
	 */
	public LocAccountOpenReqSdDto getLocAccountOpenReqSdDto() {
		return locAccountOpenReqSdDto;
	}

	/**
	 * Sets the loc account open req sd dto.
	 *
	 * @param locAccountOpenReqSdDto the new loc account open req sd dto
	 */
	public void setLocAccountOpenReqSdDto(LocAccountOpenReqSdDto locAccountOpenReqSdDto) {
		this.locAccountOpenReqSdDto = locAccountOpenReqSdDto;
	}

	/**
	 * @return the officeNameId
	 */
	public Long getOfficeNameId() {
		return officeNameId;
	}

	/**
	 * @param officeNameId the officeNameId to set
	 */
	public void setOfficeNameId(Long officeNameId) {
		this.officeNameId = officeNameId;
	}

	/**
	 * @return the wfUserReqSDDto
	 */
	public WfUserReqSDDto getWfUserReqSDDto() {
		return wfUserReqSDDto;
	}

	/**
	 * @param wfUserReqSDDto the wfUserReqSDDto to set
	 */
	public void setWfUserReqSDDto(WfUserReqSDDto wfUserReqSDDto) {
		this.wfUserReqSDDto = wfUserReqSDDto;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
