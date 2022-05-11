package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUCommonEmployeView.
 *
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 *
 */

@NativeQueryResultEntity
public class PVUCommonEmployeView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employee id. */
	@NativeQueryResultColumn(index = 0)
	private String employeeId;

	/** The employee no. */
	@NativeQueryResultColumn(index = 1)
	private String employeeNo;

	/** The emp name. */
	@NativeQueryResultColumn(index = 2)
	private String empName;

	/** The designation. */
	@NativeQueryResultColumn(index = 3)
	private String designation;

	/** The class level. */
	@NativeQueryResultColumn(index = 4)
	private String classLevel;

	/** The emp type. */
	@NativeQueryResultColumn(index = 5)
	private String empType;

	/** The pan. */
	@NativeQueryResultColumn(index = 6)
	private String pan;

	/** The office name. */
	@NativeQueryResultColumn(index = 7)
	private String officeName;

	/**
	 * Gets the employee id.
	 *
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the employee no.
	 *
	 * @return the employeeNo
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * Sets the employee no.
	 *
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
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
	 * Gets the class level.
	 *
	 * @return the classLevel
	 */
	public String getClassLevel() {
		return classLevel;
	}

	/**
	 * Sets the class level.
	 *
	 * @param classLevel the classLevel to set
	 */
	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}

	/**
	 * Gets the emp type.
	 *
	 * @return the empType
	 */
	public String getEmpType() {
		return empType;
	}

	/**
	 * Sets the emp type.
	 *
	 * @param empType the empType to set
	 */
	public void setEmpType(String empType) {
		this.empType = empType;
	}

	/**
	 * Gets the pan.
	 *
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}

	/**
	 * Sets the pan.
	 *
	 * @param pan the pan to set
	 */
	public void setPan(String pan) {
		this.pan = pan;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

}
