package gov.ifms.dmo.dto;

import java.time.LocalDate;

import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class DMONssfLoanReceiptDto.
 */
@NativeQueryResultEntity
public class DMOLoanRepayListReportDto {

	private String financialYr;
	private LocalDate installmentDt;
	private Double openingBalance = 0.0;
	private Double principalAmount = 0.0;
	private Double interestAmount = 0.0;
	private Double principalPaidAmount = 0.0;
	private Double interestPaidAmount = 0.0;
	private Double closingBalance = 0.0;
	private Double loanROI = 0.0;
	
	public String getFinancialYr() {
		return financialYr;
	}
	public void setFinancialYr(String financialYr) {
		this.financialYr = financialYr;
	}
	public LocalDate getInstallmentDt() {
		return installmentDt;
	}
	public void setInstallmentDt(LocalDate installmentDt) {
		this.installmentDt = installmentDt;
	}
	public Double getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
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
	public Double getPrincipalPaidAmount() {
		return principalPaidAmount;
	}
	public void setPrincipalPaidAmount(Double principalPaidAmount) {
		this.principalPaidAmount = principalPaidAmount;
	}
	public Double getInterestPaidAmount() {
		return interestPaidAmount;
	}
	public void setInterestPaidAmount(Double interestPaidAmount) {
		this.interestPaidAmount = interestPaidAmount;
	}
	public Double getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}
	public Double getLoanROI() {
		return loanROI;
	}
	public void setLoanROI(Double loanROI) {
		this.loanROI = loanROI;
	}
	
}
