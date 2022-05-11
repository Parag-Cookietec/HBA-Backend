package gov.ifms.dmo.dto;

import java.math.BigDecimal;

import javax.persistence.Lob;

/**
 * The Class BaseDto.
 */
public class DMOGOILoanReportSearchDto {

	private String fromDate = "";
	private String toDate = "";
	private String pageIndex = "0";
	private String pageSize = "10";
	private String loanROI = "";
	private String loanAmount = "";
	private String loanTenure = "";
	private String loanPurpose = "";
	private String ministryName = "";
	private String schemeName = "";
	private String financialYr = "";
	private String yearNo = "";
	private String monthNo = "";
	private String loanROIEquals = "";
	private String loanROIGreaterThan = "";
	private String loanROILessThan = "";
	private String loanROIBetweenFrom = "";
	private String loanROIBetweenTo = "";
	private String loanAmountEquals = "";
	private String loanAmountGreaterThan = "";
	private String loanAmountLessThan = "";
	private String loanAmountBetweenFrom = "";
	private String loanAmountBetweenTo = "";
	private String financialYearId = "";
	private String amountIn = "";
	private BigDecimal openingBalanceAmount;
	private BigDecimal closingAmount;
	private BigDecimal newLoansRecieved;
	private BigDecimal loanRepaid;
	private Double weightedAverageInterestRate = 0.0;
	private Long yearId;
	@Lob
	private String getResult;
	
	
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
	public Long getYearId() {
		return yearId;
	}
	public void setYearId(Long yearId) {
		this.yearId = yearId;
	}
	public String getLoanROIEquals() {
		return loanROIEquals;
	}
	public void setLoanROIEquals(String loanROIEquals) {
		this.loanROIEquals = loanROIEquals;
	}
	public String getLoanROIGreaterThan() {
		return loanROIGreaterThan;
	}
	public void setLoanROIGreaterThan(String loanROIGreaterThan) {
		this.loanROIGreaterThan = loanROIGreaterThan;
	}
	public String getLoanROILessThan() {
		return loanROILessThan;
	}
	public void setLoanROILessThan(String loanROILessThan) {
		this.loanROILessThan = loanROILessThan;
	}
	public String getLoanROIBetweenFrom() {
		return loanROIBetweenFrom;
	}
	public void setLoanROIBetweenFrom(String loanROIBetweenFrom) {
		this.loanROIBetweenFrom = loanROIBetweenFrom;
	}
	public String getLoanROIBetweenTo() {
		return loanROIBetweenTo;
	}
	public void setLoanROIBetweenTo(String loanROIBetweenTo) {
		this.loanROIBetweenTo = loanROIBetweenTo;
	}
	public String getLoanAmountEquals() {
		return loanAmountEquals;
	}
	public void setLoanAmountEquals(String loanAmountEquals) {
		this.loanAmountEquals = loanAmountEquals;
	}
	public String getLoanAmountGreaterThan() {
		return loanAmountGreaterThan;
	}
	public void setLoanAmountGreaterThan(String loanAmountGreaterThan) {
		this.loanAmountGreaterThan = loanAmountGreaterThan;
	}
	public String getLoanAmountLessThan() {
		return loanAmountLessThan;
	}
	public void setLoanAmountLessThan(String loanAmountLessThan) {
		this.loanAmountLessThan = loanAmountLessThan;
	}
	public String getLoanAmountBetweenFrom() {
		return loanAmountBetweenFrom;
	}
	public void setLoanAmountBetweenFrom(String loanAmountBetweenFrom) {
		this.loanAmountBetweenFrom = loanAmountBetweenFrom;
	}
	public String getLoanAmountBetweenTo() {
		return loanAmountBetweenTo;
	}
	public void setLoanAmountBetweenTo(String loanAmountBetweenTo) {
		this.loanAmountBetweenTo = loanAmountBetweenTo;
	}
	public String getFinancialYearId() {
		return financialYearId;
	}
	public void setFinancialYearId(String financialYearId) {
		this.financialYearId = financialYearId;
	}
	public String getAmountIn() {
		return amountIn;
	}
	public void setAmountIn(String amountIn) {
		this.amountIn = amountIn;
	}
	public String getYearNo() {
		return yearNo;
	}
	public void setYearNo(String yearNo) {
		this.yearNo = yearNo;
	}
	public String getMonthNo() {
		return monthNo;
	}
	public void setMonthNo(String monthNo) {
		this.monthNo = monthNo;
	}
	public String getGetResult() {
		return getResult;
	}
	public void setGetResult(String getResult) {
		this.getResult = getResult;
	}
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getLoanROI() {
		return loanROI;
	}
	public void setLoanROI(String loanROI) {
		this.loanROI = loanROI;
	}
	public String getLoanTenure() {
		return loanTenure;
	}
	public void setLoanTenure(String loanTenure) {
		this.loanTenure = loanTenure;
	}
	public String getMinistryName() {
		return ministryName;
	}
	public void setMinistryName(String ministryName) {
		this.ministryName = ministryName;
	}
	public String getFinancialYr() {
		return financialYr;
	}
	public void setFinancialYr(String financialYr) {
		this.financialYr = financialYr;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public String getLoanPurpose() {
		return loanPurpose;
	}
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	
}
