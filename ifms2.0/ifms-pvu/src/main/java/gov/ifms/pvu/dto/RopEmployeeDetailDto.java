package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.common.util.Utils;

@NativeQueryResultEntity
public class RopEmployeeDetailDto {

	@NativeQueryResultColumn(index = 0)
	private String eventDate;

	@NativeQueryResultColumn(index = 1)
	private String employeeName;

	@NativeQueryResultColumn(index = 2)
	private String deptName;

	@NativeQueryResultColumn(index = 3)
	private String designationName;

	@NativeQueryResultColumn(index = 4)
	private String retirementDate;

	@NativeQueryResultColumn(index = 5)
	private String officeName;

	@NativeQueryResultColumn(index = 6)
	private String dateNxtIncr;

	@NativeQueryResultColumn(index = 7)
	private String empBasicPay;

	@NativeQueryResultColumn(index = 8)
	private String dateJoining;

	@NativeQueryResultColumn(index = 9)
	private String employeeNo;

	@NativeQueryResultColumn(index = 10)
	private String employeeId;

	@NativeQueryResultColumn(index = 11)
	private String employeeClass;

	@NativeQueryResultColumn(index = 12)
	private String cellId;

	@NativeQueryResultColumn(index = 13)
	private String payBandValue;

	@NativeQueryResultColumn(index = 14)
	private String payScale;

	@NativeQueryResultColumn(index = 15)
	private String payBandId;

	@NativeQueryResultColumn(index = 16)
	private String payLevelId;

	@NativeQueryResultColumn(index = 17)
	private String gradePayId;

	@NativeQueryResultColumn(index = 18)
	private String payBandName;

	@NativeQueryResultColumn(index = 19)
	private String gradePayName;

	@NativeQueryResultColumn(index = 20)
	private String payLevelName;

	@NativeQueryResultColumn(index = 21)
	private String designationId;

	@NativeQueryResultColumn(index = 22)
	private String classId;

	@NativeQueryResultColumn(index = 23)
	private String cellName;

	@NativeQueryResultColumn(index = 24)
	private Long payCommId;

	@NativeQueryResultColumn(index = 25)
	private String payCommName;

	@NativeQueryResultColumn(index = 26)
	private String payScaleName;

	@NativeQueryResultColumn(index = 27)
	private Long empType;

	@NativeQueryResultColumn(index = 28)
	private Long npa;

	@NativeQueryResultColumn(index = 29)
	private String npaValue;

	@NativeQueryResultColumn(index = 30)
	private Long isSuspended;

	@NativeQueryResultColumn(index = 31)
	private Long isOldEol;

	@NativeQueryResultColumn(index = 32)
	private String eolResumeDate;

	@NativeQueryResultColumn(index = 33)
	private Long isOldSuspended;

	@NativeQueryResultColumn(index = 34)
	private String suspendedResumeDate;

	@NativeQueryResultColumn(index = 35)
	private Long officeId;

	/**
	 * @return the eventDate
	 */
	public String getEventDate() {
		return eventDate;
	}

	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the designationName
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * @param designationName the designationName to set
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	/**
	 * @return the retirementDate
	 */
	public String getRetirementDate() {
		return retirementDate;
	}

	/**
	 * @param retirementDate the retirementDate to set
	 */
	public void setRetirementDate(String retirementDate) {
		this.retirementDate = retirementDate;
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
	 * @return the dateNxtIncr
	 */
	public String getDateNxtIncr() {
		return dateNxtIncr;
	}

	/**
	 * @param dateNxtIncr the dateNxtIncr to set
	 */
	public void setDateNxtIncr(String dateNxtIncr) {
		this.dateNxtIncr = dateNxtIncr;
	}

	/**
	 * @return the empBasicPay
	 */
	public String getEmpBasicPay() {
		return empBasicPay;
	}

	/**
	 * @param empBasicPay the empBasicPay to set
	 */
	public void setEmpBasicPay(String empBasicPay) {
		this.empBasicPay = empBasicPay;
	}

	/**
	 * @return the dateJoining
	 */
	public String getDateJoining() {
		return dateJoining;
	}

	/**
	 * @param dateJoining the dateJoining to set
	 */
	public void setDateJoining(String dateJoining) {
		this.dateJoining = dateJoining;
	}

	/**
	 * @return the employeeNo
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the employeeClass
	 */
	public String getEmployeeClass() {
		return employeeClass;
	}

	/**
	 * @param employeeClass the employeeClass to set
	 */
	public void setEmployeeClass(String employeeClass) {
		this.employeeClass = employeeClass;
	}

	/**
	 * @return the cellId
	 */
	public String getCellId() {
		return cellId;
	}

	/**
	 * @param cellId the cellId to set
	 */
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	/**
	 * @return the payBandValue
	 */
	public String getPayBandValue() {
		return payBandValue;
	}

	/**
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(String payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * @return the payScale
	 */
	public String getPayScale() {
		return payScale;
	}

	/**
	 * @param payScale the payScale to set
	 */
	public void setPayScale(String payScale) {
		this.payScale = payScale;
	}

	/**
	 * @return the payBandId
	 */
	public String getPayBandId() {
		return payBandId;
	}

	/**
	 * @param payBandId the payBandId to set
	 */
	public void setPayBandId(String payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * @return the payLevelId
	 */
	public String getPayLevelId() {
		return payLevelId;
	}

	/**
	 * @param payLevelId the payLevelId to set
	 */
	public void setPayLevelId(String payLevelId) {
		this.payLevelId = payLevelId;
	}

	/**
	 * @return the gradePayId
	 */
	public String getGradePayId() {
		return gradePayId;
	}

	/**
	 * @param gradePayId the gradePayId to set
	 */
	public void setGradePayId(String gradePayId) {
		this.gradePayId = gradePayId;
	}

	/**
	 * @return the payBandName
	 */
	public String getPayBandName() {
		return payBandName;
	}

	/**
	 * @param payBandName the payBandName to set
	 */
	public void setPayBandName(String payBandName) {
		this.payBandName = payBandName;
	}

	/**
	 * @return the gradePayName
	 */
	public String getGradePayName() {
		return gradePayName;
	}

	/**
	 * @param gradePayName the gradePayName to set
	 */
	public void setGradePayName(String gradePayName) {
		this.gradePayName = gradePayName;
	}

	/**
	 * @return the payLevelName
	 */
	public String getPayLevelName() {
		return payLevelName;
	}

	/**
	 * @param payLevelName the payLevelName to set
	 */
	public void setPayLevelName(String payLevelName) {
		this.payLevelName = payLevelName;
	}

	/**
	 * @return the designationId
	 */
	public String getDesignationId() {
		return designationId;
	}

	/**
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	/**
	 * @return the classId
	 */
	public String getClassId() {
		return classId;
	}

	/**
	 * @param classId the classId to set
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}

	/**
	 * @return the cellName
	 */
	public String getCellName() {
		return cellName;
	}

	/**
	 * @param cellName the cellName to set
	 */
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}

	/**
	 * @return the payCommId
	 */
	public Long getPayCommId() {
		return payCommId;
	}

	/**
	 * @param payCommId the payCommId to set
	 */
	public void setPayCommId(Long payCommId) {
		this.payCommId = payCommId;
	}

	/**
	 * @return the payCommName
	 */
	public String getPayCommName() {
		return payCommName;
	}

	/**
	 * @param payCommName the payCommName to set
	 */
	public void setPayCommName(String payCommName) {
		this.payCommName = payCommName;
	}

	/**
	 * @return the payScaleName
	 */
	public String getPayScaleName() {
		return payScaleName;
	}

	/**
	 * @param payScaleName the payScaleName to set
	 */
	public void setPayScaleName(String payScaleName) {
		this.payScaleName = payScaleName;
	}

	/**
	 * @return the empType
	 */
	public Long getEmpType() {
		return empType;
	}

	/**
	 * @param empType the empType to set
	 */
	public void setEmpType(Long empType) {
		this.empType = empType;
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
	 * @param isSuspended the isSuspended to set
	 */
	public void setIsSuspended(Long isSuspended) {
		this.isSuspended = isSuspended;
	}

	/**
	 * @return the isSuspended
	 */
	public boolean isSuspended() {
		return Utils.isTrue(isSuspended);
	}

	/**
	 * @return the isOldSuspended
	 */
	public boolean isOldSuspended() {
		return Utils.isTrue(isOldSuspended);
	}

	/**
	 * @param isOldSuspended the isOldSuspended to set
	 */
	public void setIsOldSuspended(Long isOldSuspended) {
		this.isOldSuspended = isOldSuspended;
	}

	/**
	 * @return the isOldEol
	 */
	public boolean isOldEol() {
		return Utils.isTrue(isOldEol);
	}

	/**
	 * @param isOldEol the isOldEol to set
	 */
	public void setIsOldEol(Long isOldEol) {
		this.isOldEol = isOldEol;
	}

	/**
	 * @return the isOldEol
	 */
	public Long getIsOldEol() {
		return isOldEol;
	}

	/**
	 * @return the eolResumeDate
	 */
	public String getEolResumeDate() {
		return eolResumeDate;
	}

	/**
	 * @param eolResumeDate the eolResumeDate to set
	 */
	public void setEolResumeDate(String eolResumeDate) {
		this.eolResumeDate = eolResumeDate;
	}

	/**
	 * @return the suspendedResumeDate
	 */
	public String getSuspendedResumeDate() {
		return suspendedResumeDate;
	}

	/**
	 * @param suspendedResumeDate the suspendedResumeDate to set
	 */
	public void setSuspendedResumeDate(String suspendedResumeDate) {
		this.suspendedResumeDate = suspendedResumeDate;
	}

	/**
	 * @return the npaValue
	 */
	public String getNpaValue() {
		return npaValue;
	}

	/**
	 * @param npaValue the npaValue to set
	 */
	public void setNpaValue(String npaValue) {
		this.npaValue = npaValue;
	}

	/**
	 * @return the npa
	 */
	public Long getNpa() {
		return npa;
	}

	/**
	 * @param npa the npa to set
	 */
	public void setNpa(Long npa) {
		this.npa = npa;
	}
}
