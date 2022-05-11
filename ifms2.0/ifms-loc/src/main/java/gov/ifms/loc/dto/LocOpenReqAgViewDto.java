package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class LocOpenReqAgViewDto.
 */
public class LocOpenReqAgViewDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp number. */
	@NativeQueryResultColumn(index = 0)
	private String empNumber;

	/** The emp name. */
	@NativeQueryResultColumn(index = 1)
	private String empName;

	/** The user role. */
	@NativeQueryResultColumn(index = 2)
	private String userRole;

	/** The designation. */
	@NativeQueryResultColumn(index = 3)
	private String designation;

	/** The ag auth no. */
	@NativeQueryResultColumn(index = 4)
	private String agAuthNo;

	/** The ag auth date. */
	@NativeQueryResultColumn(index = 5)
	private String agAuthDate;

	/** The major head code. */
	@NativeQueryResultColumn(index = 6)
	private Long majorHeadId;

	/** The major head name. */
	@NativeQueryResultColumn(index = 7)
	private String majorHeadName;

	/** The major head code. */
	@NativeQueryResultColumn(index = 8)
	private String majorHeadCode;

	/** The sub major head code. */
	@NativeQueryResultColumn(index = 9)
	private Long subMajorHeadId;

	/** The sub major head code. */
	@NativeQueryResultColumn(index = 10)
	private String subMajorHeadName;

	/** The sub major head code. */
	@NativeQueryResultColumn(index = 11)
	private String subMajorHeadCode;

	/** The minor head code. */
	@NativeQueryResultColumn(index = 12)
	private Long minorHeadId;

	/** The minor head name. */
	@NativeQueryResultColumn(index = 13)
	private String minorHeadName;

	/** The minor head code. */
	@NativeQueryResultColumn(index = 14)
	private String minorHeadCode;

	/** The sub head code. */
	@NativeQueryResultColumn(index = 15)
	private Long subHeadId;

	/** The sub head name. */
	@NativeQueryResultColumn(index = 16)
	private String subHeadName;

	/** The sub head code. */
	@NativeQueryResultColumn(index = 17)
	private String subHeadCode;

	/** The detail head code. */
	@NativeQueryResultColumn(index = 18)
	private Long detailHeadId;

	/** The detail head name. */
	@NativeQueryResultColumn(index = 19)
	private String detailHeadName;

	/** The detail head code. */
	@NativeQueryResultColumn(index = 20)
	private String detailHeadCode;

	/** The date time. */
	@NativeQueryResultColumn(index = 21)
	private String dateTime;

	/** The remarks. */
	@NativeQueryResultColumn(index = 22)
	private String agRemarks;

	/** The record count. */
	@NativeQueryResultColumn(index = 23)
	private int recordCount;

	/**
	 * Gets the emp number.
	 *
	 * @return the empNumber
	 */
	public String getEmpNumber() {
		return empNumber;
	}

	/**
	 * Sets the emp number.
	 *
	 * @param empNumber the empNumber to set
	 */
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	/**
	 * Gets the emp name.
	 *
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * Sets the emp name.
	 *
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * Gets the user role.
	 *
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * Sets the user role.
	 *
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Gets the ag auth no.
	 *
	 * @return the agAuthNo
	 */
	public String getAgAuthNo() {
		return agAuthNo;
	}

	/**
	 * Sets the ag auth no.
	 *
	 * @param agAuthNo the agAuthNo to set
	 */
	public void setAgAuthNo(String agAuthNo) {
		this.agAuthNo = agAuthNo;
	}

	/**
	 * Gets the ag auth date.
	 *
	 * @return the agAuthDate
	 */
	public String getAgAuthDate() {
		return agAuthDate;
	}

	/**
	 * Sets the ag auth date.
	 *
	 * @param agAuthDate the agAuthDate to set
	 */
	public void setAgAuthDate(String agAuthDate) {
		this.agAuthDate = agAuthDate;
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
	 * Gets the major head name.
	 *
	 * @return the majorHeadName
	 */
	public String getMajorHeadName() {
		return majorHeadName;
	}

	/**
	 * Sets the major head name.
	 *
	 * @param majorHeadName the majorHeadName to set
	 */
	public void setMajorHeadName(String majorHeadName) {
		this.majorHeadName = majorHeadName;
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
	 * Gets the sub major head name.
	 *
	 * @return the subMajorHeadName
	 */
	public String getSubMajorHeadName() {
		return subMajorHeadName;
	}

	/**
	 * Sets the sub major head name.
	 *
	 * @param subMajorHeadName the subMajorHeadName to set
	 */
	public void setSubMajorHeadName(String subMajorHeadName) {
		this.subMajorHeadName = subMajorHeadName;
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
	 * Gets the minor head name.
	 *
	 * @return the minorHeadName
	 */
	public String getMinorHeadName() {
		return minorHeadName;
	}

	/**
	 * Sets the minor head name.
	 *
	 * @param minorHeadName the minorHeadName to set
	 */
	public void setMinorHeadName(String minorHeadName) {
		this.minorHeadName = minorHeadName;
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
	 * Gets the sub head name.
	 *
	 * @return the subHeadName
	 */
	public String getSubHeadName() {
		return subHeadName;
	}

	/**
	 * Sets the sub head name.
	 *
	 * @param subHeadName the subHeadName to set
	 */
	public void setSubHeadName(String subHeadName) {
		this.subHeadName = subHeadName;
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
	 * Gets the detail head name.
	 *
	 * @return the detailHeadName
	 */
	public String getDetailHeadName() {
		return detailHeadName;
	}

	/**
	 * Sets the detail head name.
	 *
	 * @param detailHeadName the detailHeadName to set
	 */
	public void setDetailHeadName(String detailHeadName) {
		this.detailHeadName = detailHeadName;
	}

	/**
	 * Gets the date time.
	 *
	 * @return the dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * Sets the date time.
	 *
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
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
	 * Gets the record count.
	 *
	 * @return the recordCount
	 */
	public int getRecordCount() {
		return recordCount;
	}

	/**
	 * Sets the record count.
	 *
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * Gets the major head code.
	 *
	 * @return the majorHeadCode
	 */
	public String getMajorHeadCode() {
		return majorHeadCode;
	}

	/**
	 * Sets the major head code.
	 *
	 * @param majorHeadCode the majorHeadCode to set
	 */
	public void setMajorHeadCode(String majorHeadCode) {
		this.majorHeadCode = majorHeadCode;
	}

	/**
	 * Gets the sub major head code.
	 *
	 * @return the subMajorHeadCode
	 */
	public String getSubMajorHeadCode() {
		return subMajorHeadCode;
	}

	/**
	 * Sets the sub major head code.
	 *
	 * @param subMajorHeadCode the subMajorHeadCode to set
	 */
	public void setSubMajorHeadCode(String subMajorHeadCode) {
		this.subMajorHeadCode = subMajorHeadCode;
	}

	/**
	 * Gets the sub head code.
	 *
	 * @return the subHeadCode
	 */
	public String getSubHeadCode() {
		return subHeadCode;
	}

	/**
	 * Sets the sub head code.
	 *
	 * @param subHeadCode the subHeadCode to set
	 */
	public void setSubHeadCode(String subHeadCode) {
		this.subHeadCode = subHeadCode;
	}

	/**
	 * Gets the minor head code.
	 *
	 * @return the minorHeadCode
	 */
	public String getMinorHeadCode() {
		return minorHeadCode;
	}

	/**
	 * Sets the minor head code.
	 *
	 * @param minorHeadCode the minorHeadCode to set
	 */
	public void setMinorHeadCode(String minorHeadCode) {
		this.minorHeadCode = minorHeadCode;
	}

	/**
	 * Gets the detail head code.
	 *
	 * @return the detailHeadCode
	 */
	public String getDetailHeadCode() {
		return detailHeadCode;
	}

	/**
	 * Sets the detail head code.
	 *
	 * @param detailHeadCode the detailHeadCode to set
	 */
	public void setDetailHeadCode(String detailHeadCode) {
		this.detailHeadCode = detailHeadCode;
	}

}
