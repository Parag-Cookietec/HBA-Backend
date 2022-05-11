package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_INST_LOAN_MEMO", schema = Constant.DMO_SCHEMA)
public class DMOInstitutionalLoanMemoEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	/** The GOI loan Loan RePayment Id **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INST_LOAN_MEMO_ID")
	private Long id;
	
	/** The is DP_SHEET_ID. */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DP_SHEET_ID", referencedColumnName = "DP_SHEET_ID")
	private DMODPSheetEntryEntity dpSheetEntity;
	
	/** The is DP_SHEET_ID. */
	@JsonBackReference
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INSTITUT_LOAN_HDR_ID", referencedColumnName = "INSTITUT_LOAN_HDR_ID")
	private DMOInstitutionalLoanEntity instituteLoanId;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "INST_LOAN_MEMO_ID")
	private List<DMOInstitutionalLoanMemoDtlEntity> repayments = new ArrayList<>();
	
	/** The DP Sheet Received Date**/
	@Column(name = "DP_SHEET_RECV_DT")
	private LocalDate dpSheetRecDate;
	
	/** The GOI loan Reference No **/
	@Column(name = "REFERENCE_NO")
	private String refrenceNo;
	
	/** The GOI loan  Reference Date **/
	@Column(name = "REFERENCE_DT")
	private LocalDateTime refrenceDate;

	/** The GOI loan Reference No **/
	@Column(name = "MEMO_NO")
	private String memoNo;
	
	/** The GOI loan  Reference Date **/
	@Column(name = "MEMO_DT")
	private LocalDate memoDate;
	
	/** The PAYMENT_TYPE_ID  **/
	@Column(name = "PAYMENT_TYPE_ID")
	private Long paymentTypeId;
	
	/** The NET_AMT_PAYABLE.**/
	@Column(name = "NET_AMT_PAYABLE")
	private Double netAmountPayable;
	
	/** The CHEQUE_NO  **/
	@Column(name = "CHEQUE_NO")
	private Long chequeNo;
	
	/** The CHEQUE_PAID_DT.**/
	@Column(name = "CHEQUE_PAID_DT")
	private LocalDate chequePaidDate;

	/** The CHEQUE_DT.**/
	@Column(name = "CHEQUE_DT")
	private LocalDate chequeDate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DMODPSheetEntryEntity getDpSheetEntity() {
		return dpSheetEntity;
	}

	public void setDpSheetEntity(DMODPSheetEntryEntity dpSheetEntity) {
		this.dpSheetEntity = dpSheetEntity;
	}

	public LocalDate getDpSheetRecDate() {
		return dpSheetRecDate;
	}

	public void setDpSheetRecDate(LocalDate dpSheetRecDate) {
		this.dpSheetRecDate = dpSheetRecDate;
	}

	public String getRefrenceNo() {
		return refrenceNo;
	}

	public void setRefrenceNo(String refrenceNo) {
		this.refrenceNo = refrenceNo;
	}

	public LocalDateTime getRefrenceDate() {
		return refrenceDate;
	}

	public void setRefrenceDate(LocalDateTime refrenceDate) {
		this.refrenceDate = refrenceDate;
	}

	public DMOInstitutionalLoanEntity getIntLoanId() {
		return instituteLoanId;
	}

	public void setIntLoanId(DMOInstitutionalLoanEntity instituteLoanId) {
		this.instituteLoanId = instituteLoanId;
	}

	public String getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}

	public LocalDate getMemoDate() {
		return memoDate;
	}

	public void setMemoDate(LocalDate memoDate) {
		this.memoDate = memoDate;
	}

	public Long getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Long paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public Double getNetAmountPayable() {
		return netAmountPayable;
	}

	public void setNetAmountPayable(Double netAmountPayable) {
		this.netAmountPayable = netAmountPayable;
	}

	public Long getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}

	public LocalDate getChequePaidDate() {
		return chequePaidDate;
	}

	public void setChequePaidDate(LocalDate chequePaidDate) {
		this.chequePaidDate = chequePaidDate;
	}

	public LocalDate getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(LocalDate chequeDate) {
		this.chequeDate = chequeDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<DMOInstitutionalLoanMemoDtlEntity> getRepayments() {
		return repayments;
	}

	public void setRepayments(List<DMOInstitutionalLoanMemoDtlEntity> repayments) {
		this.repayments = repayments;
	}

}
