package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class PVURopEmployeView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The employee id. */
	@NativeQueryResultColumn(index = 0)
	private Long employeeId;

	/** The employee no. */
	@NativeQueryResultColumn(index = 1)
	private Long employeeNo;

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

	/** The empPayType. */
	@NativeQueryResultColumn(index = 8)
	private Long empPayType;

	/** The dateOfJoining. */
	@NativeQueryResultColumn(index = 9)
	private Date dateOfJoining;

	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the employeeNo
	 */
	public Long getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
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
	 * @return the classLevel
	 */
	public String getClassLevel() {
		return classLevel;
	}

	/**
	 * @param classLevel the classLevel to set
	 */
	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}

	/**
	 * @return the empType
	 */
	public String getEmpType() {
		return empType;
	}

	/**
	 * @param empType the empType to set
	 */
	public void setEmpType(String empType) {
		this.empType = empType;
	}

	/**
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}

	/**
	 * @param pan the pan to set
	 */
	public void setPan(String pan) {
		this.pan = pan;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the empPayType
	 */
	public Long getEmpPayType() {
		return empPayType;
	}

	/**
	 * @param empPayType the empPayType to set
	 */
	public void setEmpPayType(Long empPayType) {
		this.empPayType = empPayType;
	}

	/**
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

}
