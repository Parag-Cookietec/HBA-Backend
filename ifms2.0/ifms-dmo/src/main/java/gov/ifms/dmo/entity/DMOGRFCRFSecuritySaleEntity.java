package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_GRF_CRF_SECURITY_SALE", schema = Constant.DMO_SCHEMA)
public class DMOGRFCRFSecuritySaleEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRF_CRF_SEC_SALE_ID")
	private Long id;

	/** The is ACCOUNT_TYPE_ID. */
	@Column(name = "ACCOUNT_TYPE_ID")
	private Long accountTypeId;

	/** The is TRANSACT_TYPE_ID. */
	@Column(name = "TRANSACT_TYPE_ID")
	private Long transactTypeId;

	/** The is SALE_DT. */
	@Column(name = "SALE_DT")
	private LocalDate saleDt;

	/** The is RBI_ADVICE_NO. */
	@Column(name = "RBI_ADVICE_NO")
	private String rbiAdviceNo;

	/** The is RBI_ADVICE_DT. */
	@Column(name = "RBI_ADVICE_DT")
	private LocalDate rbiAdviceDt;

	/** The is CURR_ACC_BAL. */
	@Column(name = "CURR_ACC_BAL")
	private Double currAccBal;

	/** The is TRANSACTION_DT. */
	@Column(name = "TRANSACTION_DT")
	private LocalDate transactionDt;

	/** The is INTEREST_AMT. */
	@Column(name = "INTEREST_AMT")
	private Double interestAmt;

	/** The is TOT_DEBITED_AMT. */
	@Column(name = "TOTAL_SECURITY_AMT")
	private Double totalSecurityAmt;

	/** The is ST_ACC_TRANSFR_AMT. */
	@Column(name = "ST_ACC_TRANSFR_AMT")
	private Double stAccTransfrAmt;

	/** The is PROG_BAL_ACC. */
	@Column(name = "PROG_BAL_ACC")
	private Double progBalAcc;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "securitySale")
	private List<DMOGRFCRFSecurityDtlEntity> securityDetails = new ArrayList<>();

	public void addSecurityDetails(DMOGRFCRFSecurityDtlEntity securityDetail) {
		this.securityDetails.add(securityDetail);
	}

	public List<DMOGRFCRFSecurityDtlEntity> getSecurityDetails() {
		return securityDetails;
	}

	public void setSecurityDetails(List<DMOGRFCRFSecurityDtlEntity> securityDetails) {
		this.securityDetails = securityDetails;
	}

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

	public LocalDate getSaleDt() {
		return saleDt;
	}

	public void setSaleDt(LocalDate saleDt) {
		this.saleDt = saleDt;
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

	public LocalDate getTransactionDt() {
		return transactionDt;
	}

	public void setTransactionDt(LocalDate transactionDt) {
		this.transactionDt = transactionDt;
	}

	public Double getInterestAmt() {
		return interestAmt;
	}

	public void setInterestAmt(Double interestAmt) {
		this.interestAmt = interestAmt;
	}

	public Double getTotalSecurityAmt() {
		return totalSecurityAmt;
	}

	public void setTotalSecurityAmt(Double totalSecurityAmt) {
		this.totalSecurityAmt = totalSecurityAmt;
	}

	public Double getStAccTransfrAmt() {
		return stAccTransfrAmt;
	}

	public void setStAccTransfrAmt(Double stAccTransfrAmt) {
		this.stAccTransfrAmt = stAccTransfrAmt;
	}

	public Double getProgBalAcc() {
		return progBalAcc;
	}

	public void setProgBalAcc(Double progBalAcc) {
		this.progBalAcc = progBalAcc;
	}

}
