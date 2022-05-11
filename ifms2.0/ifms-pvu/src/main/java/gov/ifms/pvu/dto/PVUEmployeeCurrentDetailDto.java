package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeShettyPayDto.
 *
 * @version v 1.0
 * @created 2020/01/06 12:53:37
 *
 */
/**
 * @author HP
 *
 */
public class PVUEmployeeCurrentDetailDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private LocalDate eventEffectiveDate;

	private String payLevelId;

	/** The trn no. */
	private String trnNo;

	private String cellId;

	/** The employee no. */
	private String employeeNo;

	private String employeeName;

	/** The event code. */
	private String eventCode;

	/** The office id. */
	private String personalPay;

	private String dateNxtIncr;

	private String officeName;

	private String payCommId;

	private String empBasicPay;

	private String eventOrderDate;

	private String benefitEffectiveDate;

	private String eventOrderNo;

	private String remarks;

	private String employeeClass;

	private String designationName;

	private String payBandName;

	private String payBandValue;

	private String gradePayName;

	private String payScaleName;

	private String retirementDate;

	private String dateJoining;

	/**
	 * @return the eventEffectiveDate
	 */
	public LocalDate getEventEffectiveDate() {
		return eventEffectiveDate;
	}

	/**
	 * @param eventEffectiveDate the eventEffectiveDate to set
	 */
	public void setEventEffectiveDate(LocalDate eventEffectiveDate) {
		this.eventEffectiveDate = eventEffectiveDate;
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
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
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
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}

	/**
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * @return the personalPay
	 */
	public String getPersonalPay() {
		return personalPay;
	}

	/**
	 * @param personalPay the personalPay to set
	 */
	public void setPersonalPay(String personalPay) {
		this.personalPay = personalPay;
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
	 * @return the payCommId
	 */
	public String getPayCommId() {
		return payCommId;
	}

	/**
	 * @param payCommId the payCommId to set
	 */
	public void setPayCommId(String payCommId) {
		this.payCommId = payCommId;
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
	 * @return the eventOrderDate
	 */
	public String getEventOrderDate() {
		return eventOrderDate;
	}

	/**
	 * @param eventOrderDate the eventOrderDate to set
	 */
	public void setEventOrderDate(String eventOrderDate) {
		this.eventOrderDate = eventOrderDate;
	}

	/**
	 * @return the benefitEffectiveDate
	 */
	public String getBenefitEffectiveDate() {
		return benefitEffectiveDate;
	}

	/**
	 * @param benefitEffectiveDate the benefitEffectiveDate to set
	 */
	public void setBenefitEffectiveDate(String benefitEffectiveDate) {
		this.benefitEffectiveDate = benefitEffectiveDate;
	}

	/**
	 * @return the eventOrderNo
	 */
	public String getEventOrderNo() {
		return eventOrderNo;
	}

	/**
	 * @param eventOrderNo the eventOrderNo to set
	 */
	public void setEventOrderNo(String eventOrderNo) {
		this.eventOrderNo = eventOrderNo;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

}
