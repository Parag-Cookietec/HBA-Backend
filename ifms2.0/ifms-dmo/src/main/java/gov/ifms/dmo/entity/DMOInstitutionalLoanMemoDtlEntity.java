package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_INST_LOAN_MEMO_DTL", schema = Constant.DMO_SCHEMA)
public class DMOInstitutionalLoanMemoDtlEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The GOI loan Loan RePayment Id **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INST_MEMO_DTL_ID")
	private Long id;
	
	/** The is DP_SHEET_ID. */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INST_LOAN_MEMO_ID", referencedColumnName = "INST_LOAN_MEMO_ID")
	private DMOInstitutionalLoanMemoEntity instituteLoanMemoId;
	
	/** The is DP_SHEET_ID. */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INSTITUT_LOAN_HDR_ID", referencedColumnName = "INSTITUT_LOAN_HDR_ID")
	private DMOInstitutionalLoanEntity instituteLoanId;
	
	/** The MEMO_DTL_SRNO **/
	@Column(name = "MEMO_DTL_SRNO")
	private int memoDtlSrNo;
	
	/** The TRANCHE_DESC **/
	@Column(name = "TRANCHE_DESC")
	private String trancheDesc;

	/** The LOAN_ACC_NUMBER **/
	@Column(name = "LOAN_ACC_NUMBER")
	private String loanAccNumber;
	
	/** The LOAN_AMOUNT.**/
	@Column(name = "LOAN_AMOUNT")
	private Double loanAmount;
	
	/** The LOAN_OUTSTAND_AMT.**/
	@Column(name = "LOAN_OUTSTAND_AMT")
	private Double loanOutstandAmount;
	
	/** The NET_AMT_PAYABLE.**/
	@Column(name = "REPAY_DUE_AMT")
	private Double repayDueAmount;
	
	/** The CHEQUE_DT.**/
	@Column(name = "REPAY_DUE_DT")
	private LocalDate repayDueDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DMOInstitutionalLoanMemoEntity getInstituteLoanMemoId() {
		return instituteLoanMemoId;
	}

	public void setInstituteLoanMemoId(DMOInstitutionalLoanMemoEntity instituteLoanMemoId) {
		this.instituteLoanMemoId = instituteLoanMemoId;
	}

	public DMOInstitutionalLoanEntity getInstituteLoanId() {
		return instituteLoanId;
	}

	public void setInstituteLoanId(DMOInstitutionalLoanEntity instituteLoanId) {
		this.instituteLoanId = instituteLoanId;
	}

	public int getMemoDtlSrNo() {
		return memoDtlSrNo;
	}

	public void setMemoDtlSrNo(int memoDtlSrNo) {
		this.memoDtlSrNo = memoDtlSrNo;
	}

	public String getTrancheDesc() {
		return trancheDesc;
	}

	public void setTrancheDesc(String trancheDesc) {
		this.trancheDesc = trancheDesc;
	}

	public String getLoanAccNumber() {
		return loanAccNumber;
	}

	public void setLoanAccNumber(String loanAccNumber) {
		this.loanAccNumber = loanAccNumber;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getLoanOutstandAmount() {
		return loanOutstandAmount;
	}

	public void setLoanOutstandAmount(Double loanOutstandAmount) {
		this.loanOutstandAmount = loanOutstandAmount;
	}

	public Double getRepayDueAmount() {
		return repayDueAmount;
	}

	public void setRepayDueAmount(Double repayDueAmount) {
		this.repayDueAmount = repayDueAmount;
	}

	public LocalDate getRepayDueDate() {
		return repayDueDate;
	}

	public void setRepayDueDate(LocalDate repayDueDate) {
		this.repayDueDate = repayDueDate;
	}

}
