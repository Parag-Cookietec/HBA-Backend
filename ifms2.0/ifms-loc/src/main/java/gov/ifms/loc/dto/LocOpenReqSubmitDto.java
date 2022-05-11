package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class LocOpenReqSubmitDto.
 */
public class LocOpenReqSubmitDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lc open req hdr id. */
	@NativeQueryResultColumn(index = 0)
	private Long lcOpenReqHdrId;

	/** The division office address. */
	@NativeQueryResultColumn(index = 1)
	private String divisionOfficeAddress;

	/** The Office name id. */
	@NativeQueryResultColumn(index = 2)
	private Long officeNameId;

	/** The Office name. */
	@NativeQueryResultColumn(index = 3)
	private String officeName;

	/** The department id. */
	@NativeQueryResultColumn(index = 4)
	private Long departmentId;

	/** The department name. */
	@NativeQueryResultColumn(index = 5)
	private String departmentName;

	/** The hod id. */
	@NativeQueryResultColumn(index = 6)
	private Long hodId;

	/** The hod office name. */
	@NativeQueryResultColumn(index = 7)
	private String hodOfficeName;

	/** The to office id. */
	@NativeQueryResultColumn(index = 8)
	private Long toOfficeId;

	/** The to office name. */
	@NativeQueryResultColumn(index = 9)
	private String toOfficeName;

	/** The district id. */
	@NativeQueryResultColumn(index = 10)
	private Long districtId;

	/** The district name. */
	@NativeQueryResultColumn(index = 11)
	private String districtName;

	/** The cardex no. */
	@NativeQueryResultColumn(index = 12)
	private Long cardexNo;

	/** The ddo no. */
	@NativeQueryResultColumn(index = 13)
	private Long ddoNo;

	/** The reference no. */
	@NativeQueryResultColumn(index = 14)
	private String referenceNo;

	/** The reference dt. */
	@NativeQueryResultColumn(index = 15)
	private Date referenceDt;

	/** The wf id. */
	@NativeQueryResultColumn(index = 16)
	private Long wfId;

	/** The wf role id. */
	@NativeQueryResultColumn(index = 17)
	private Long wfRoleId;

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
	 * @return the divisionOfficeAddress
	 */
	public String getDivisionOfficeAddress() {
		return divisionOfficeAddress;
	}

	/**
	 * @param divisionOfficeAddress the divisionOfficeAddress to set
	 */
	public void setDivisionOfficeAddress(String divisionOfficeAddress) {
		this.divisionOfficeAddress = divisionOfficeAddress;
	}

	/**
	 * @return the officeNameId
	 */

	/**
	 * @param officeNameId the officeNameId to set
	 */
	public void setOfficeNameId(Long officeNameId) {
		this.officeNameId = officeNameId;
	}

	/**
	 * @return the officeName
	 */
	public Long getOfficeNameId() {
		return officeNameId;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the hodId
	 */
	public Long getHodId() {
		return hodId;
	}

	/**
	 * @param hodId the hodId to set
	 */
	public void setHodId(Long hodId) {
		this.hodId = hodId;
	}

	/**
	 * @return the hodOfficeName
	 */
	public String getHodOfficeName() {
		return hodOfficeName;
	}

	/**
	 * @param hodOfficeName the hodOfficeName to set
	 */
	public void setHodOfficeName(String hodOfficeName) {
		this.hodOfficeName = hodOfficeName;
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
	 * @return the toOfficeName
	 */
	public String getToOfficeName() {
		return toOfficeName;
	}

	/**
	 * @param toOfficeName the toOfficeName to set
	 */
	public void setToOfficeName(String toOfficeName) {
		this.toOfficeName = toOfficeName;
	}

	/**
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * @return the cardexNo
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * @return the ddoNo
	 */
	public Long getDdoNo() {
		return ddoNo;
	}

	/**
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(Long ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * @param referenceNo the referenceNo to set
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

}
