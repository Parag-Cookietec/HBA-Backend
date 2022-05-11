package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMOGRFCRFAccruedInterestPostDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long accountTypeId;
	@NotNull(message = "{txn.type.notNull}")
	private Long transactTypeId;
	@NotNull(message = "{rbi.advice.no.notNull}")
	private String rbiAdviceNo;
	@NotNull(message = "{rbi.advice.dt.notNull}")
	private LocalDate rbiAdviceDt;
	private Double currAccBal;
	@NotNull(message = "{security.type.id.notNull}")
	private Long securityTypeId;
	@NotNull(message = "{transaction.dt}")
	private LocalDate transactionDt;
//	@NotNull(message = "{maturity.amt.notNull}")
	private Double maturityAmt;
	@NotNull(message = "{interest.amt.notNull}")
	private Double interestAmt;
	@NotNull(message = "{total.amt.notNull}")
	private Double totalAmount;
	private Double progBalAcc;
	private String referenceNo;
	private LocalDateTime referenceDt;
	private String accountType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public Long getTransactTypeId() {
		return transactTypeId;
	}

	public void setTransactTypeId(Long transactTypeId) {
		this.transactTypeId = transactTypeId;
	}

	public String getRbiAdviceNo() {
		return rbiAdviceNo;
	}

	public void setRbiAdviceNo(String rbiAdviceNo) {
		this.rbiAdviceNo = rbiAdviceNo;
	}

	public LocalDate getRbiAdviceDt() {
		return rbiAdviceDt;
	}

	public void setRbiAdviceDt(LocalDate rbiAdviceDt) {
		this.rbiAdviceDt = rbiAdviceDt;
	}

	public Double getCurrAccBal() {
		return currAccBal;
	}

	public void setCurrAccBal(Double currAccBal) {
		this.currAccBal = currAccBal;
	}

	public Long getSecurityTypeId() {
		return securityTypeId;
	}

	public void setSecurityTypeId(Long securityTypeId) {
		this.securityTypeId = securityTypeId;
	}

	public LocalDate getTransactionDt() {
		return transactionDt;
	}

	public void setTransactionDt(LocalDate transactionDt) {
		this.transactionDt = transactionDt;
	}

	public Double getMaturityAmt() {
		return maturityAmt;
	}

	public void setMaturityAmt(Double maturityAmt) {
		this.maturityAmt = maturityAmt;
	}

	public Double getInterestAmt() {
		return interestAmt;
	}

	public void setInterestAmt(Double interestAmt) {
		this.interestAmt = interestAmt;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getProgBalAcc() {
		return progBalAcc;
	}

	public void setProgBalAcc(Double progBalAcc) {
		this.progBalAcc = progBalAcc;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public LocalDateTime getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(LocalDateTime referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
