package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class LocOpenReqDiviViewDto.
 */
public class LocOpenReqDiviViewDto implements Serializable {

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

	/** The designation. */
	@NativeQueryResultColumn(index = 4)
	private String divisionCd;

	/** The date time. */
	@NativeQueryResultColumn(index = 5)
	private String dateTime;

	/** The bank remarks. */
	@NativeQueryResultColumn(index = 6)
	private String diviRemarks;

	/** The record count. */
	@NativeQueryResultColumn(index = 7)
	private int recordCount;

	/**
	 * @return the empNumber
	 */
	public String getEmpNumber() {
		return empNumber;
	}

	/**
	 * @param empNumber the empNumber to set
	 */
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the divisionCd
	 */
	public String getDivisionCd() {
		return divisionCd;
	}

	/**
	 * @param divisionCd the divisionCd to set
	 */
	public void setDivisionCd(String divisionCd) {
		this.divisionCd = divisionCd;
	}

	/**
	 * @return the dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the diviRemarks
	 */
	public String getDiviRemarks() {
		return diviRemarks;
	}

	/**
	 * @param diviRemarks the diviRemarks to set
	 */
	public void setDiviRemarks(String diviRemarks) {
		this.diviRemarks = diviRemarks;
	}

	/**
	 * @return the recordCount
	 */
	public int getRecordCount() {
		return recordCount;
	}

	/**
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

}
