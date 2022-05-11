package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUEmployeeTypeSPDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private Long empId;

	@NativeQueryResultColumn(index = 1)
	private Long empNo;
	
	@NativeQueryResultColumn(index = 2)
	private String  empName;

	@NativeQueryResultColumn(index = 3)
	private Long desigId;

	@NativeQueryResultColumn(index = 4)
	private String desigName;

	@NativeQueryResultColumn(index = 5)
	private Long empClassId;

	@NativeQueryResultColumn(index = 6)
	private String empClassName;
	
	@NativeQueryResultColumn(index = 7)
	private  Long empTypeId;

	@NativeQueryResultColumn(index = 8)
	private String empTypeName;
	
	@NativeQueryResultColumn(index = 9)
	private Long currentPayType;
	
	@NativeQueryResultColumn(index = 10)
	private String empPayTypeName;
	
	@NativeQueryResultColumn(index = 11)
	private String panNo;

	@NativeQueryResultColumn(index = 12)
	private Long  officeId;
	
	@NativeQueryResultColumn(index = 13)
	private String officeName;
	
	@NativeQueryResultColumn(index = 14)
	private String doj;

	/**
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * @return the empNo
	 */
	public Long getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
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
	 * @return the desigId
	 */
	public Long getDesigId() {
		return desigId;
	}

	/**
	 * @param desigId the desigId to set
	 */
	public void setDesigId(Long desigId) {
		this.desigId = desigId;
	}

	/**
	 * @return the desigName
	 */
	public String getDesigName() {
		return desigName;
	}

	/**
	 * @param desigName the desigName to set
	 */
	public void setDesigName(String desigName) {
		this.desigName = desigName;
	}

	/**
	 * @return the empClassId
	 */
	public Long getEmpClassId() {
		return empClassId;
	}

	/**
	 * @param empClassId the empClassId to set
	 */
	public void setEmpClassId(Long empClassId) {
		this.empClassId = empClassId;
	}

	/**
	 * @return the empClassName
	 */
	public String getEmpClassName() {
		return empClassName;
	}

	/**
	 * @param empClassName the empClassName to set
	 */
	public void setEmpClassName(String empClassName) {
		this.empClassName = empClassName;
	}

	/**
	 * @return the empTypeId
	 */
	public Long getEmpTypeId() {
		return empTypeId;
	}

	/**
	 * @param empTypeId the empTypeId to set
	 */
	public void setEmpTypeId(Long empTypeId) {
		this.empTypeId = empTypeId;
	}

	/**
	 * @return the empTypeName
	 */
	public String getEmpTypeName() {
		return empTypeName;
	}

	/**
	 * @param empTypeName the empTypeName to set
	 */
	public void setEmpTypeName(String empTypeName) {
		this.empTypeName = empTypeName;
	}

	/**
	 * @return the currentPayType
	 */
	public Long getCurrentPayType() {
		return currentPayType;
	}

	/**
	 * @param currentPayType the currentPayType to set
	 */
	public void setCurrentPayType(Long currentPayType) {
		this.currentPayType = currentPayType;
	}

	/**
	 * @return the empPayTypeName
	 */
	public String getEmpPayTypeName() {
		return empPayTypeName;
	}

	/**
	 * @param empPayTypeName the empPayTypeName to set
	 */
	public void setEmpPayTypeName(String empPayTypeName) {
		this.empPayTypeName = empPayTypeName;
	}

	/**
	 * @return the panNo
	 */
	public String getPanNo() {
		return panNo;
	}

	/**
	 * @param panNo the panNo to set
	 */
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	/**
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
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
	 * @return the doj
	 */
	public String getDoj() {
		return doj;
	}

	/**
	 * @param doj the doj to set
	 */
	public void setDoj(String doj) {
		this.doj = doj;
	}

}
