package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class DMONssfLoanReceiptDto.
 */
@NativeQueryResultEntity
public class DMOLoanRepayReportDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String sanctionNo;
	private String loanDescription;
	private String accountNo;
	private LocalDate loanStartDt;
	private Integer loanTenure = 0;
	private Integer moratoriumPeriod = 0;
	private Double loanROI = 0.0;
	private Double loanAmount = 0.0;
	private List<DMOLoanRepayListReportDto> loanRepay = new ArrayList<>();
	
	public String getSanctionNo() {
		return sanctionNo;
	}

	public void setSanctionNo(String sanctionNo) {
		this.sanctionNo = sanctionNo;
	}

	public String getLoanDescription() {
		return loanDescription;
	}

	public void setLoanDescription(String loanDescription) {
		this.loanDescription = loanDescription;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DMOLoanRepayListReportDto> getLoanRepay() {
		return loanRepay;
	}

	public void setLoanRepay(List<DMOLoanRepayListReportDto> loanRepay) {
		this.loanRepay = loanRepay;
	}

}
