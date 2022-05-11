package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class DMONssfLoanReceiptDto.
 */
@NativeQueryResultEntity
public class DMOGOILoanReportDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String departmentName;
	private String schemeName;

	//LOAN_START_DT
	private LocalDate loanStartDt;
	private LocalDate loanReceiptDt;

	//LOAN_TENURE
	private Integer loanTenure = 0;

	//MORATORIUM_PERIOD
	private Integer moratoriumPeriod = 0;

	//LOAN_ROI
	private Double loanROI = 0.0;

	//LOAN_AMOUNT
	private Double loanAmount = 0.0;

	//FY
	private String financialYr;
	private String sanctionOrderNo;
	private String monthName;
	private Double principalAmount = 0.0;
	private Double interestAmount = 0.0;
	private Double totalAmount = 0.0;
	private LocalDate paymentDt;
	
	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public Double getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(Double principalAmount) {
		this.principalAmount = principalAmount;
	}

	public Double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(Double interestAmount) {
		this.interestAmount = interestAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getLoanStartDt() {
		return loanStartDt;
	}

	public void setLoanStartDt(LocalDate loanStartDt) {
		this.loanStartDt = loanStartDt;
	}

	public Integer getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(Integer loanTenure) {
		this.loanTenure = loanTenure;
	}

	public Integer getMoratoriumPeriod() {
		return moratoriumPeriod;
	}

	public void setMoratoriumPeriod(Integer moratoriumPeriod) {
		this.moratoriumPeriod = moratoriumPeriod;
	}

	public Double getLoanROI() {
		return loanROI;
	}

	public void setLoanROI(Double loanROI) {
		this.loanROI = loanROI;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getFinancialYr() {
		return financialYr;
	}

	public void setFinancialYr(String financialYr) {
		this.financialYr = financialYr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LocalDate getLoanReceiptDt() {
		return loanReceiptDt;
	}

	public void setLoanReceiptDt(LocalDate loanReceiptDt) {
		this.loanReceiptDt = loanReceiptDt;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getSanctionOrderNo() {
		return sanctionOrderNo;
	}

	public void setSanctionOrderNo(String sanctionOrderNo) {
		this.sanctionOrderNo = sanctionOrderNo;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public LocalDate getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(LocalDate paymentDt) {
		this.paymentDt = paymentDt;
	}

}
