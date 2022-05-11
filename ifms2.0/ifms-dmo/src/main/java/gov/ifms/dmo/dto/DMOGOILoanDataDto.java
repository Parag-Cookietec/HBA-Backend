package gov.ifms.dmo.dto;

import java.time.LocalDate;

/**
 * The Class DMOGOILoanPostDto.
 * 
 * @version 2.0
 * @created 2021/07/13 15:19:32
 *
 */
public class DMOGOILoanDataDto {

	private Double loanAmount;
	private String nameOfMinistry;
	private String planSchemeName;
	private Long srPageNo;
	private LocalDate dueDate;
	private Double interestRate;
	private Double loanOutstanding;
	private Double payablePrincipal;
	private Double payableInterest;
	private Double paidPrincipal;
	private Double paidInterest;
	private Long parentId;
	private Long id;
	
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	public String getNameOfMinistry() {
		return nameOfMinistry;
	}
	public void setNameOfMinistry(String nameOfMinistry) {
		this.nameOfMinistry = nameOfMinistry;
	}
	public String getPlanSchemeName() {
		return planSchemeName;
	}
	public void setPlanSchemeName(String planSchemeName) {
		this.planSchemeName = planSchemeName;
	}
	public Long getSrPageNo() {
		return srPageNo;
	}
	public void setSrPageNo(Long srPageNo) {
		this.srPageNo = srPageNo;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public Double getLoanOutstanding() {
		return loanOutstanding;
	}
	public void setLoanOutstanding(Double loanOutstanding) {
		this.loanOutstanding = loanOutstanding;
	}
	public Double getPayablePrincipal() {
		return payablePrincipal;
	}
	public void setPayablePrincipal(Double payablePrincipal) {
		this.payablePrincipal = payablePrincipal;
	}
	public Double getPayableInterest() {
		return payableInterest;
	}
	public void setPayableInterest(Double payableInterest) {
		this.payableInterest = payableInterest;
	}
	public Double getPaidPrincipal() {
		return paidPrincipal;
	}
	public void setPaidPrincipal(Double paidPrincipal) {
		this.paidPrincipal = paidPrincipal;
	}
	public Double getPaidInterest() {
		return paidInterest;
	}
	public void setPaidInterest(Double paidInterest) {
		this.paidInterest = paidInterest;
	}
}
