package gov.ifms.loc.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class LocOpenReqListDto.
 */
@NativeQueryResultEntity
public class LocCloseRequestEditViewDto implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The close request ID.
	 */
	@NativeQueryResultColumn(index = 0)
	private Long closeRequestID;

	/**
	 * The close request sd ID.
	 */
	@NativeQueryResultColumn(index = 1)
	private Long closeRequestSdID;

	/**
	 * The lc open request id.
	 */
	@NativeQueryResultColumn(index = 2)
	private Long lcOpenRequestId;

	/**
	 * The office name.
	 */
	@NativeQueryResultColumn(index = 3)
	private String officeName;

	/**
	 * The office name id.
	 */
	@NativeQueryResultColumn(index = 4)
	private Long officeNameId;

	/**
	 * The office address.
	 */
	@NativeQueryResultColumn(index = 5)
	private String officeAddress;

	/**
	 * The department name.
	 */
	@NativeQueryResultColumn(index = 6)
	private String departmentName;

	/**
	 * The department id.
	 */
	@NativeQueryResultColumn(index = 7)
	private Long departmentId;
	/**
	 * The hod office.
	 */
	@NativeQueryResultColumn(index = 8)
	private String hodOffice;

	/**
	 * The tooffice.
	 */
	@NativeQueryResultColumn(index = 9)
	private String tooffice;

	/**
	 * The office id.
	 */
	@NativeQueryResultColumn(index = 10)
	private Long officeId;
	/**
	 * The district name.
	 */
	@NativeQueryResultColumn(index = 11)
	private String districtName;

	/**
	 * The cardex no.
	 */
	@NativeQueryResultColumn(index = 12)
	private Long cardexNo;

	/**
	 * The ddo no.
	 */
	@NativeQueryResultColumn(index = 13)
	private Long ddoNo;

	/**
	 * The division code.
	 */
	@NativeQueryResultColumn(index = 14)
	private String divisionCode;

	/**
	 * The division name.
	 */
	@NativeQueryResultColumn(index = 15)
	private String divisionName;

	/**
	 * The circle code.
	 */
	@NativeQueryResultColumn(index = 16)
	private String circleCode;

	/**
	 * The circle name.
	 */
	@NativeQueryResultColumn(index = 17)
	private String circleName;

	/**
	 * The ag auth no.
	 */
	@NativeQueryResultColumn(index = 18)
	private String agAuthNo;

	/**
	 * The ag auth dt.
	 */
	@NativeQueryResultColumn(index = 19)
	private Date agAuthDt;

	/**
	 * The majorhead.
	 */
	@NativeQueryResultColumn(index = 20)
	private String majorhead;

	/** The majorhead name. */
	@NativeQueryResultColumn(index = 21)
	private String majorheadName;

	/**
	 * The submajorhead.
	 */
	@NativeQueryResultColumn(index = 22)
	private String submajorhead;

	/** The submajorhead name. */
	@NativeQueryResultColumn(index = 23)
	private String submajorheadName;

	/**
	 * The minor head.
	 */
	@NativeQueryResultColumn(index = 24)
	private String minorHead;

	/** The minor head name. */
	@NativeQueryResultColumn(index = 25)
	private String minorHeadName;
	/**
	 * The sub head.
	 */
	@NativeQueryResultColumn(index = 26)
	private String subHead;

	/** The sub head name. */
	@NativeQueryResultColumn(index = 27)
	private String subHeadName;

	/**
	 * The detailed head.
	 */
	@NativeQueryResultColumn(index = 28)
	private String detailedHead;

	/** The detailed head name. */
	@NativeQueryResultColumn(index = 29)
	private String detailedHeadName;
	/**
	 * The bank name.
	 */
	@NativeQueryResultColumn(index = 30)
	private String bankName;

	/**
	 * The branch name.
	 */
	@NativeQueryResultColumn(index = 31)
	private String branchName;

	/**
	 * The branch code.
	 */
	@NativeQueryResultColumn(index = 32)
	private String branchCode;

	/**
	 * The lcclsoing dt.
	 */
	@NativeQueryResultColumn(index = 33)
	private Date lcclsoingDt;

	/**
	 * The closure remark.
	 */
	@NativeQueryResultColumn(index = 34)
	private String closureRemark;

	/**
	 * The reference no.
	 */
	@NativeQueryResultColumn(index = 35)
	private String referenceNo;

	/**
	 * The reference dt.
	 */
	@NativeQueryResultColumn(index = 36)
	private Date referenceDt;

	/**
	 * Gets the close request ID.
	 *
	 * @return the close request ID
	 */
	public Long getCloseRequestID() {
		return closeRequestID;
	}

	/**
	 * Sets the close request ID.
	 *
	 * @param closeRequestID the new close request ID
	 */
	public void setCloseRequestID(Long closeRequestID) {
		this.closeRequestID = closeRequestID;
	}

	/**
	 * Gets the close request sd ID.
	 *
	 * @return the close request sd ID
	 */
	public Long getCloseRequestSdID() {
		return closeRequestSdID;
	}

	/**
	 * Sets the close request sd ID.
	 *
	 * @param closeRequestSdID the new close request sd ID
	 */
	public void setCloseRequestSdID(Long closeRequestSdID) {
		this.closeRequestSdID = closeRequestSdID;
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
	 * Gets the office name.
	 *
	 * @return the office name
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the new office name
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the office address.
	 *
	 * @return the office address
	 */
	public String getOfficeAddress() {
		return officeAddress;
	}

	/**
	 * Sets the office address.
	 *
	 * @param officeAddress the new office address
	 */
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	/**
	 * Gets the department name.
	 *
	 * @return the department name
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * Sets the department name.
	 *
	 * @param departmentName the new department name
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * Gets the hod office.
	 *
	 * @return the hod office
	 */
	public String getHodOffice() {
		return hodOffice;
	}

	/**
	 * Sets the hod office.
	 *
	 * @param hodOffice the new hod office
	 */
	public void setHodOffice(String hodOffice) {
		this.hodOffice = hodOffice;
	}

	/**
	 * Gets the tooffice.
	 *
	 * @return the tooffice
	 */
	public String getTooffice() {
		return tooffice;
	}

	/**
	 * Sets the tooffice.
	 *
	 * @param tooffice the new tooffice
	 */
	public void setTooffice(String tooffice) {
		this.tooffice = tooffice;
	}

	/**
	 * Gets the district name.
	 *
	 * @return the district name
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * Sets the district name.
	 *
	 * @param districtName the new district name
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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

	public String getAgAuthNo() {
		return agAuthNo;
	}

	public void setAgAuthNo(String agAuthNo) {
		this.agAuthNo = agAuthNo;
	}

	/**
	 * Gets the ag auth dt.
	 *
	 * @return the ag auth dt
	 */
	public Date getAgAuthDt() {
		return agAuthDt;
	}

	/**
	 * Sets the ag auth dt.
	 *
	 * @param agAuthDt the new ag auth dt
	 */
	public void setAgAuthDt(Date agAuthDt) {
		this.agAuthDt = agAuthDt;
	}

	/**
	 * Gets the majorhead.
	 *
	 * @return the majorhead
	 */
	public String getMajorhead() {
		return majorhead;
	}

	/**
	 * Sets the majorhead.
	 *
	 * @param majorhead the new majorhead
	 */
	public void setMajorhead(String majorhead) {
		this.majorhead = majorhead;
	}

	/**
	 * Gets the submajorhead.
	 *
	 * @return the submajorhead
	 */
	public String getSubmajorhead() {
		return submajorhead;
	}

	/**
	 * Sets the submajorhead.
	 *
	 * @param submajorhead the new submajorhead
	 */
	public void setSubmajorhead(String submajorhead) {
		this.submajorhead = submajorhead;
	}

	/**
	 * Gets the minor head.
	 *
	 * @return the minor head
	 */
	public String getMinorHead() {
		return minorHead;
	}

	/**
	 * Sets the minor head.
	 *
	 * @param minorHead the new minor head
	 */
	public void setMinorHead(String minorHead) {
		this.minorHead = minorHead;
	}

	/**
	 * Gets the sub head.
	 *
	 * @return the sub head
	 */
	public String getSubHead() {
		return subHead;
	}

	/**
	 * Sets the sub head.
	 *
	 * @param subHead the new sub head
	 */
	public void setSubHead(String subHead) {
		this.subHead = subHead;
	}

	/**
	 * Gets the detailed head.
	 *
	 * @return the detailed head
	 */
	public String getDetailedHead() {
		return detailedHead;
	}

	/**
	 * Sets the detailed head.
	 *
	 * @param detailedHead the new detailed head
	 */
	public void setDetailedHead(String detailedHead) {
		this.detailedHead = detailedHead;
	}

	/**
	 * Gets the bank name.
	 *
	 * @return the bank name
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * Sets the bank name.
	 *
	 * @param bankName the new bank name
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * Gets the branch name.
	 *
	 * @return the branch name
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * Sets the branch name.
	 *
	 * @param branchName the new branch name
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * Gets the lcclsoing dt.
	 *
	 * @return the lcclsoing dt
	 */
	public Date getLcclsoingDt() {
		return lcclsoingDt;
	}

	/**
	 * Sets the lcclsoing dt.
	 *
	 * @param lcclsoingDt the new lcclsoing dt
	 */
	public void setLcclsoingDt(Date lcclsoingDt) {
		this.lcclsoingDt = lcclsoingDt;
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
	 * Gets the branch code.
	 *
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * Sets the branch code.
	 *
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * Gets the office name id.
	 *
	 * @return the office name id
	 */
	public Long getOfficeNameId() {
		return officeNameId;
	}

	/**
	 * Sets the office name id.
	 *
	 * @param officeNameId the new office name id
	 */
	public void setOfficeNameId(Long officeNameId) {
		this.officeNameId = officeNameId;
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
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the majorhead name.
	 *
	 * @return the majorhead name
	 */
	public String getMajorheadName() {
		return majorheadName;
	}

	/**
	 * Sets the majorhead name.
	 *
	 * @param majorheadName the new majorhead name
	 */
	public void setMajorheadName(String majorheadName) {
		this.majorheadName = majorheadName;
	}

	/**
	 * Gets the submajorhead name.
	 *
	 * @return the submajorhead name
	 */
	public String getSubmajorheadName() {
		return submajorheadName;
	}

	/**
	 * Sets the submajorhead name.
	 *
	 * @param submajorheadName the new submajorhead name
	 */
	public void setSubmajorheadName(String submajorheadName) {
		this.submajorheadName = submajorheadName;
	}

	/**
	 * Gets the minor head name.
	 *
	 * @return the minor head name
	 */
	public String getMinorHeadName() {
		return minorHeadName;
	}

	/**
	 * Sets the minor head name.
	 *
	 * @param minorHeadName the new minor head name
	 */
	public void setMinorHeadName(String minorHeadName) {
		this.minorHeadName = minorHeadName;
	}

	/**
	 * Gets the sub head name.
	 *
	 * @return the sub head name
	 */
	public String getSubHeadName() {
		return subHeadName;
	}

	/**
	 * Sets the sub head name.
	 *
	 * @param subHeadName the new sub head name
	 */
	public void setSubHeadName(String subHeadName) {
		this.subHeadName = subHeadName;
	}

	/**
	 * Gets the detailed head name.
	 *
	 * @return the detailed head name
	 */
	public String getDetailedHeadName() {
		return detailedHeadName;
	}

	/**
	 * Sets the detailed head name.
	 *
	 * @param detailedHeadName the new detailed head name
	 */
	public void setDetailedHeadName(String detailedHeadName) {
		this.detailedHeadName = detailedHeadName;
	}
}
