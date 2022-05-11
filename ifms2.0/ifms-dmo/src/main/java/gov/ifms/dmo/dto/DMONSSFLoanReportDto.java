package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class DMONssfLoanReceiptDto.
 */
@NativeQueryResultEntity
public class DMONSSFLoanReportDto implements Serializable, Comparable {

	private static final long serialVersionUID = 1L;

	//SANCTION_ORDER_NO
	private String sanctionNo;

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
	private BigDecimal loanAmount;

	//FY
	private String financialYr;

	private String monthName;
	private String monthNo;
	private String yearName;
	private Long yearId;
	private LocalDate paymentDt;
	private BigDecimal principalAmount;
	private BigDecimal interestAmount;
	private BigDecimal totalAmount;
	private Double outstandingAmount = 0.0;
	//Repayment Outstanding Percentage
	private Double repaymentOutstandingPercentage = 0.0;
	private BigDecimal openingBalanceAmount;
	private BigDecimal closingAmount;
	private BigDecimal newLoansRecieved;
	private BigDecimal loanRepaid;
	private Double weightedAverageInterestRate = 0.0;
	private String monthWithYear;
	
	
	public String getMonthWithYear() {
		return monthWithYear;
	}

	public void setMonthWithYear(String monthWithYear) {
		this.monthWithYear = monthWithYear;
	}

	public BigDecimal getOpeningBalanceAmount() {
		return openingBalanceAmount;
	}

	public void setOpeningBalanceAmount(BigDecimal openingBalanceAmount) {
		this.openingBalanceAmount = openingBalanceAmount;
	}

	public BigDecimal getClosingAmount() {
		return closingAmount;
	}

	public void setClosingAmount(BigDecimal closingAmount) {
		this.closingAmount = closingAmount;
	}

	public BigDecimal getNewLoansRecieved() {
		return newLoansRecieved;
	}

	public void setNewLoansRecieved(BigDecimal newLoansRecieved) {
		this.newLoansRecieved = newLoansRecieved;
	}

	public BigDecimal getLoanRepaid() {
		return loanRepaid;
	}

	public void setLoanRepaid(BigDecimal loanRepaid) {
		this.loanRepaid = loanRepaid;
	}

	public Double getWeightedAverageInterestRate() {
		return weightedAverageInterestRate;
	}

	public void setWeightedAverageInterestRate(Double weightedAverageInterestRate) {
		this.weightedAverageInterestRate = weightedAverageInterestRate;
	}

	public String getYearName() {
		return yearName;
	}

	public void setYearName(String yearName) {
		this.yearName = yearName;
	}

	public Long getYearId() {
		return yearId;
	}

	public void setYearId(Long yearId) {
		this.yearId = yearId;
	}

	public Double getRepaymentOutstandingPercentage() {
		return repaymentOutstandingPercentage;
	}

	public void setRepaymentOutstandingPercentage(final Double repaymentOutstandingPercentage) {
		this.repaymentOutstandingPercentage = repaymentOutstandingPercentage;
	}

	public BigDecimal getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(BigDecimal principalAmount) {
		this.principalAmount = principalAmount;
	}

	public BigDecimal getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(BigDecimal interestAmount) {
		this.interestAmount = interestAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public String getSanctionNo() {
		return sanctionNo;
	}

	public void setSanctionNo(String sanctionNo) {
		this.sanctionNo = sanctionNo;
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

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
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

	public LocalDate getPaymentDt() {
		return paymentDt;
	}

	public void setPaymentDt(LocalDate paymentDt) {
		this.paymentDt = paymentDt;
	}

	public Double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(Double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public LocalDate getLoanReceiptDt() {
		return loanReceiptDt;
	}

	public void setLoanReceiptDt(LocalDate loanReceiptDt) {
		this.loanReceiptDt = loanReceiptDt;
	}

	public String getMonthNo() {
		return monthNo;
	}

	public void setMonthNo(String monthNo) {
		this.monthNo = monthNo;
	}

	@Override
	public int compareTo(Object obj) {
		DMONSSFLoanReportDto dto = (DMONSSFLoanReportDto) obj;
		    int deptComp = financialYr.compareTo(dto.getFinancialYr());
		    return ((deptComp == 0) ? monthNo.compareTo(dto.getMonthNo()) : deptComp);
	}
	
	public boolean equals(Object obj) {
	    if (!(obj instanceof DMONSSFLoanReportDto)) {
	      return false;
	    }
	    DMONSSFLoanReportDto dto = (DMONSSFLoanReportDto) obj;
	    return financialYr.equals(dto.getFinancialYr()) && monthNo.equals(dto.getMonthNo());
	  }

}
