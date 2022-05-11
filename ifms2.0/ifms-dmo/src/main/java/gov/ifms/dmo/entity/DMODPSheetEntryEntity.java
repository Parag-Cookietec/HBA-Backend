package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

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
@Table(name = "TDMO_DP_SHEET_DTL", schema = Constant.DMO_SCHEMA)
public class DMODPSheetEntryEntity extends BaseEntity implements Serializable {

	
	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DP_SHEET_ID")
	private Long dpSheetDtlId;

	@Column(name = "ADVICE_NO")
	private String adviceNo;

	@Column(name = "ADVICE_DT")
	private LocalDate adviceDate;

	@Column(name = "ADVICE_BY")
	private String adviceBy;

	@Column(name = "PAYMENT_TYPE_ID")
	private Long paymentTypeId;

	@Column(name = "PAYMENT_TYPE_DESC")
	private String paymentTypeDesc;

	@Column(name = "TRANSACT_TYPE_ID")
	private Long transactTypeId;

	@Column(name = "TRANSACTION_DESC")
	private String transactionDesc;

	@Column(name = "CREDIT_AMT")
	private Double creditAmt = 0d;

	@Column(name = "DEBIT_AMT")
	private Double debitAmt = 0d;

	@Column(name = "MEMO_NO")
	private String memoNo;

	/** The is DP_HDR_SHEET_ID. */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DP_SHEET_HDR_ID", referencedColumnName = "DP_SHEET_HDR_ID")
	private DMODPSheetHDREntity entity;
	
	
	
	public DMODPSheetEntryEntity() {
		super();
	}

	public DMODPSheetEntryEntity(Long dpSheetId) {
		super();
		this.dpSheetDtlId = dpSheetId;
	}

	public Long getDpSheetDtlId() {
		return dpSheetDtlId;
	}

	public void setDpSheetDtlId(Long id) {
		this.dpSheetDtlId = id;
	}

	public String getAdviceNo() {
		return adviceNo;
	}

	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}

	public LocalDate getAdviceDate() {
		return adviceDate;
	}

	public void setAdviceDate(LocalDate adviceDate) {
		this.adviceDate = adviceDate;
	}

	public String getAdviceBy() {
		return adviceBy;
	}

	public void setAdviceBy(String adviceBy) {
		this.adviceBy = adviceBy;
	}

	public Long getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Long paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getPaymentTypeDesc() {
		return paymentTypeDesc;
	}

	public void setPaymentTypeDesc(String paymentTypeDesc) {
		this.paymentTypeDesc = paymentTypeDesc;
	}

	public Long getTransactTypeId() {
		return transactTypeId;
	}

	public void setTransactTypeId(Long transactTypeId) {
		this.transactTypeId = transactTypeId;
	}

	public String getTransactionDesc() {
		return transactionDesc;
	}

	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}

	public Double getCreditAmt() {
		return creditAmt;
	}

	public void setCreditAmt(Double creditAmt) {
		this.creditAmt = creditAmt;
	}

	public Double getDebitAmt() {
		return debitAmt;
	}

	public void setDebitAmt(Double debitAmt) {
		this.debitAmt = debitAmt;
	}

	 public String getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}

	public DMODPSheetHDREntity getEntity() {
		return entity;
	}

	public void setEntity(DMODPSheetHDREntity entity) {
		this.entity = entity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adviceBy, adviceDate, adviceNo, creditAmt, debitAmt, entity, dpSheetDtlId, memoNo, paymentTypeDesc,
				paymentTypeId, transactTypeId, transactionDesc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DMODPSheetEntryEntity other = (DMODPSheetEntryEntity) obj;
		return Objects.equals(adviceBy, other.adviceBy) && Objects.equals(adviceDate, other.adviceDate)
				&& Objects.equals(adviceNo, other.adviceNo) && Objects.equals(creditAmt, other.creditAmt)
				&& Objects.equals(debitAmt, other.debitAmt) && Objects.equals(entity, other.entity)
				&& Objects.equals(dpSheetDtlId, other.dpSheetDtlId) && Objects.equals(memoNo, other.memoNo)
				&& Objects.equals(paymentTypeDesc, other.paymentTypeDesc)
				&& Objects.equals(paymentTypeId, other.paymentTypeId)
				&& Objects.equals(transactTypeId, other.transactTypeId)
				&& Objects.equals(transactionDesc, other.transactionDesc);
	}

	
}
