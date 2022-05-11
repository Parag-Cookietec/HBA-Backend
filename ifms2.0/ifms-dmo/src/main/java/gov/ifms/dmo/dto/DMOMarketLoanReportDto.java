package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class DMONssfLoanReceiptDto.
 */
@NativeQueryResultEntity
public class DMOMarketLoanReportDto implements Serializable {

	private static final long serialVersionUID = 1L;

	//SANCTION_ORDER_NO
	private String loanDescription;

	//LOAN_START_DT
	private LocalDate maturityDt;
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
	//SANCTION_ORDER_NO
	private String sanctionNo;

	//FY
	private String financialYr;

	private String monthName;
	private String monthNo;
	private LocalDate paymentDt;
	private BigDecimal principalAmount;
	private BigDecimal interestAmount;
	private BigDecimal totalAmount;
	private Double outstandingAmount = 0.0;
	private BigDecimal openingBalanceAmount;
	private BigDecimal closingAmount;
	private BigDecimal newLoansRecieved;
	private BigDecimal loanRepaid;
	private Double weightedAverageInterestRate = 0.0;
	private String monthWithYear;
	private String yearName;
	private Long yearId;
	
	
	public String getSanctionNo() {
		return sanctionNo;
	}

	public void setSanctionNo(String sanctionNo) {
		this.sanctionNo = sanctionNo;
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

	public String getMonthWithYear() {
		return monthWithYear;
	}

	public void setMonthWithYear(String monthWithYear) {
		this.monthWithYear = monthWithYear;
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

	public String getLoanDescription() {
		return loanDescription;
	}

	public void setLoanDescription(String loanDescription) {
		this.loanDescription = loanDescription;
	}

	public LocalDate getMaturityDt() {
		return maturityDt;
	}

	public void setMaturityDt(LocalDate maturityDt) {
		this.maturityDt = maturityDt;
	}

}
