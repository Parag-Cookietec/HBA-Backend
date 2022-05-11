package gov.ifms.dmo.dto;

import java.time.LocalDate;

public class DMOLoanEstimateDto {
	
	private Long id;
	private Long financialYearId;
	
	private Double nssfLoanAmt;
	
	private Double marketLoanAmt;
	
	private Double goiLoanAmt;
	
	private Double instituteLoanAmt;
	
	private LocalDate effectiveFrmDt;
	
	private LocalDate effectiveToDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFinancialYearId() {
		return financialYearId;
	}

	public void setFinancialYearId(Long financialYearId) {
		this.financialYearId = financialYearId;
	}

	public Double getNssfLoanAmt() {
		return nssfLoanAmt;
	}

	public void setNssfLoanAmt(Double nssfLoanAmt) {
		this.nssfLoanAmt = nssfLoanAmt;
	}

	public Double getMarketLoanAmt() {
		return marketLoanAmt;
	}

	public void setMarketLoanAmt(Double marketLoanAmt) {
		this.marketLoanAmt = marketLoanAmt;
	}

	public Double getGoiLoanAmt() {
		return goiLoanAmt;
	}

	public void setGoiLoanAmt(Double goiLoanAmt) {
		this.goiLoanAmt = goiLoanAmt;
	}

	public Double getInstituteLoanAmt() {
		return instituteLoanAmt;
	}

	public void setInstituteLoanAmt(Double instituteLoanAmt) {
		this.instituteLoanAmt = instituteLoanAmt;
	}

	public LocalDate getEffectiveFrmDt() {
		return effectiveFrmDt;
	}

	public void setEffectiveFrmDt(LocalDate effectiveFrmDt) {
		this.effectiveFrmDt = effectiveFrmDt;
	}

	public LocalDate getEffectiveToDt() {
		return effectiveToDt;
	}

	public void setEffectiveToDt(LocalDate effectiveToDt) {
		this.effectiveToDt = effectiveToDt;
	}

}
