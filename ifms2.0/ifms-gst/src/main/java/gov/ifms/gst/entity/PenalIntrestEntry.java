package gov.ifms.gst.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TPAO_PENAL_INTEREST_ENTRY", schema = GSTConstant.GST_SCHEMA)
public class PenalIntrestEntry extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_PIE = "PIE";
	public static final Object TRN_SCREEN_PES = "PES";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PENAL_INTRST_ID")
	private long id;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "BANK_ID")
	private long bankId;

	@Column(name = "BANK_NAME")
	private String bankName;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "RECEIPT_MODE_ID", referencedColumnName = "LOOKUP_INFO_ID", nullable = false)
	private EDPLuLookUpInfoEntity receiptMode;

	@Column(name = "CHQ_REFERENCE_NO")
	private String chqCeferenceNo;

	@Column(name = "RECEIPT_DT")
	private Date receiptDt;

	@Column(name = "GOVT_CREDIT_DT")
	private Date govtCreditDt;

	@Column(name = "INTEREST_AMOUNT")
	private Double interestAmount;

	@Column(name = "ENTRY_STATUS_ID")
	private long entryStatusId;

	@Column(name = "ENTRY_STATUS")
	private String entryStatus;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PENAL_INTRST_ID")
	public List<PenalIntrestDTL> penalIntrestDTLList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Date getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}


	public EDPLuLookUpInfoEntity getReceiptMode() {
		return receiptMode;
	}

	public void setReceiptMode(EDPLuLookUpInfoEntity receiptMode) {
		this.receiptMode = receiptMode;
	}

	public String getChqCeferenceNo() {
		return chqCeferenceNo;
	}

	public void setChqCeferenceNo(String chqCeferenceNo) {
		this.chqCeferenceNo = chqCeferenceNo;
	}

	public Date getReceiptDt() {
		return receiptDt;
	}

	public void setReceiptDt(Date receiptDt) {
		this.receiptDt = receiptDt;
	}

	public Date getGovtCreditDt() {
		return govtCreditDt;
	}

	public void setGovtCreditDt(Date govtCreditDt) {
		this.govtCreditDt = govtCreditDt;
	}

	public Double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(Double interestAmount) {
		this.interestAmount = interestAmount;
	}

	public long getEntryStatusId() {
		return entryStatusId;
	}

	public void setEntryStatusId(long entryStatusId) {
		this.entryStatusId = entryStatusId;
	}

	public String getEntryStatus() {
		return entryStatus;
	}

	public void setEntryStatus(String entryStatus) {
		this.entryStatus = entryStatus;
	}

	public List<PenalIntrestDTL> getPenalIntrestDTLList() {
		return penalIntrestDTLList;
	}

	public void setPenalIntrestDTLList(List<PenalIntrestDTL> penalIntrestDTLList) {
		this.penalIntrestDTLList = penalIntrestDTLList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PenalIntrestEntry that = (PenalIntrestEntry) o;
		return id == that.id && bankId == that.bankId && entryStatusId == that.entryStatusId && Objects.equals(referenceNo, that.referenceNo) && Objects.equals(bankName, that.bankName) && Objects.equals(referenceDt, that.referenceDt) && Objects.equals(receiptMode, that.receiptMode) && Objects.equals(chqCeferenceNo, that.chqCeferenceNo) && Objects.equals(receiptDt, that.receiptDt) && Objects.equals(govtCreditDt, that.govtCreditDt) && Objects.equals(interestAmount, that.interestAmount) && Objects.equals(entryStatus, that.entryStatus) && Objects.equals(penalIntrestDTLList, that.penalIntrestDTLList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, referenceNo, bankId, bankName, referenceDt, receiptMode, chqCeferenceNo, receiptDt, govtCreditDt, interestAmount, entryStatusId, entryStatus, penalIntrestDTLList);
	}
}
