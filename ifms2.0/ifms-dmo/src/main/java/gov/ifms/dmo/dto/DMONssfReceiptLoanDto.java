package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class DMONssfReceiptLoanDto implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	@NativeQueryResultColumn(index = 0)
	private String sanctionOrderNo;
	
	@NativeQueryResultColumn(index = 1)
	private LocalDate loanStartDate;

	@NativeQueryResultColumn(index = 2)
	private int loanTenure;
	
	@NativeQueryResultColumn(index = 3)
	private int moratariumPeriod;
	
	@NativeQueryResultColumn(index = 4)
	private Double loanROI;

	@NativeQueryResultColumn(index = 5)
	private Double loanAmount;

	@NativeQueryResultColumn(index = 6)
	private String financialYr;

	public String getSanctionOrderNo() {
		return sanctionOrderNo;
	}

	public void setSanctionOrderNo(String sanctionOrderNo) {
		this.sanctionOrderNo = sanctionOrderNo;
	}

	public LocalDate getLoanStartDate() {
		return loanStartDate;
	}

	public void setLoanStartDate(LocalDate loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	public int getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	public int getMoratariumPeriod() {
		return moratariumPeriod;
	}

	public void setMoratariumPeriod(int moratariumPeriod) {
		this.moratariumPeriod = moratariumPeriod;
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

}
