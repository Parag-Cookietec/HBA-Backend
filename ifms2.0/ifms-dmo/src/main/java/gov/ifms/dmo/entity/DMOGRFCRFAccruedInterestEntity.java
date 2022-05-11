package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_GRF_CRF_ACCUR_INTRST", schema = Constant.DMO_SCHEMA)
public class DMOGRFCRFAccruedInterestEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** The is GRF_CRF_INTIMATION_ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRF_CRF_ACCUR_ID")
	private Long id;
	
	/** The is ACCOUNT_TYPE_ID. */
	@Column(name = "ACCOUNT_TYPE_ID")
	private Long accountTypeId;
	
	/** The is TRANSACT_TYPE_ID. */
	@Column(name = "TRANSACT_TYPE_ID")
	private Long transactTypeId;
	
	/** The is RBI_ADVICE_NO. */
	@Column(name = "RBI_ADVICE_NO")
	private String rbiAdviceNo;

	/** The is RBI_ADVICE_DT. */
	@Column(name = "RBI_ADVICE_DT")
	private LocalDate rbiAdviceDt;
	
	/** The is CURR_ACC_BAL. */
	@Column(name = "CURR_ACC_BAL")
	private Double currAccBal;
	
	/** The is SECURITY_TYPE_ID. */
	@Column(name = "SECURITY_TYPE_ID")
	private Long securityTypeId;
	
	/** The is TRANSACTION_DT. */
	@Column(name = "TRANSACTION_DT")
	private LocalDate transactionDt;
	
	/** The is MATURITY_AMT. */
	@Column(name = "MATURITY_AMT")
	private Double maturityAmt;
	
	/** The is INTEREST_AMT. */
	@Column(name = "INTEREST_AMT")
	private Double interestAmt;
	
	/** The is TOTAL_AMOUNT. */
	@Column(name = "TOTAL_AMOUNT")
	private Double totalAmount;
	
	/** The is PROG_BAL_ACC. */
	@Column(name = "PROG_BAL_ACC")
	private Double progBalAcc;

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

	
}
