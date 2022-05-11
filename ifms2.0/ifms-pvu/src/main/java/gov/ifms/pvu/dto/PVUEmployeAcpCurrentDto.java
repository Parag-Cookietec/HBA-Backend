package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

public class PVUEmployeAcpCurrentDto implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String employeeName; //
	private String designationName; //
	private String retirementDate; //
	private String officeName;//
	private Date dateNxtIncr; //
	private String empBasicPay; //
	private String dateJoining; //
	private String payBandValue;
	private String payBandName;
	private String gradePayName;
	private String payLevelName;
	private String employeeClass; //
	private String cellName;
	private String payScaleName; //
	
	
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	public String getRetirementDate() {
		return retirementDate;
	}
	public void setRetirementDate(String retirementDate) {
		this.retirementDate = retirementDate;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public Date getDateNxtIncr() {
		return dateNxtIncr;
	}
	public void setDateNxtIncr(Date dateNxtIncr) {
		this.dateNxtIncr = dateNxtIncr;
	}
	public String getEmpBasicPay() {
		return empBasicPay;
	}
	public void setEmpBasicPay(String empBasicPay) {
		this.empBasicPay = empBasicPay;
	}
	public String getDateJoining() {
		return dateJoining;
	}
	public void setDateJoining(String dateJoining) {
		this.dateJoining = dateJoining;
	}
	public String getPayBandValue() {
		return payBandValue;
	}
	public void setPayBandValue(String payBandValue) {
		this.payBandValue = payBandValue;
	}
	public String getPayBandName() {
		return payBandName;
	}
	public void setPayBandName(String payBandName) {
		this.payBandName = payBandName;
	}
	public String getGradePayName() {
		return gradePayName;
	}
	public void setGradePayName(String gradePayName) {
		this.gradePayName = gradePayName;
	}
	public String getPayLevelName() {
		return payLevelName;
	}
	public void setPayLevelName(String payLevelName) {
		this.payLevelName = payLevelName;
	}
	public String getEmployeeClass() {
		return employeeClass;
	}
	public void setEmployeeClass(String employeeClass) {
		this.employeeClass = employeeClass;
	}
	public String getCellName() {
		return cellName;
	}
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}
	public String getPayScaleName() {
		return payScaleName;
	}
	public void setPayScaleName(String payScaleName) {
		this.payScaleName = payScaleName;
	}

}
