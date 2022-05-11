package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TPAO_ACC_MANUAL_ENTRY_HDR", schema = GSTConstant.GST_SCHEMA)
public class AccManualEntryHdr extends BaseEntity implements Serializable{

	public static final String TRN_SCREEN_MES = "MES";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACC_MANUAL_HDR_ID")
	public Long id;

	@Column(name = "CIN_NO")
	public String cinNo;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ENTRY_FOR_TYPE_ID", referencedColumnName = "LOOKUP_INFO_ID", nullable = false)
	private EDPLuLookUpInfoEntity type;

	@Column(name = "ENTRY_STATUS_ID")
	public Long entryStatusId;

	@Column(name = "ENTRY_STATUS")
	public String entryStatus;

	@Column(name = "REFERENCE_NO")
	public String referenceNo;

	@Column(name = "REFERENCE_DT")
	public Date referenceDt;

	@Column(name = "TOT_ENTRY_AMOUNT")
	public Double totalEntryAmt;

	@Column(name = "TOT_DEBIT_AMOUNT")
	public Double totalDebitAmt;

	@Column(name = "TOT_CREDIT_AMOUNT")
	public Double totalCreditAmt;

	@Column(name = "MANUAL_ENTRY_DT")
	public Date manualEntryDt;

	@Column(name = "VALUED_DT")
	public Date valueDt;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ACC_MANUAL_HDR_ID")
	public List<AccManualEntryCr> creditEntries;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ACC_MANUAL_HDR_ID")
	public List<AccManualEntryDr> debitEntries;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public EDPLuLookUpInfoEntity getType() {
		return type;
	}

	public void setType(EDPLuLookUpInfoEntity type) {
		this.type = type;
	}

	public Long getEntryStatusId() {
		return entryStatusId;
	}

	public void setEntryStatusId(Long entryStatusId) {
		this.entryStatusId = entryStatusId;
	}

	public String getEntryStatus() {
		return entryStatus;
	}

	public void setEntryStatus(String entryStatus) {
		this.entryStatus = entryStatus;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public Double getTotalEntryAmt() {
		return totalEntryAmt;
	}

	public void setTotalEntryAmt(Double totalEntryAmt) {
		this.totalEntryAmt = totalEntryAmt;
	}

	public Double getTotalDebitAmt() {
		return totalDebitAmt;
	}

	public void setTotalDebitAmt(Double totalDebitAmt) {
		this.totalDebitAmt = totalDebitAmt;
	}

	public Double getTotalCreditAmt() {
		return totalCreditAmt;
	}

	public void setTotalCreditAmt(Double totalCreditAmt) {
		this.totalCreditAmt = totalCreditAmt;
	}

	public Date getManualEntryDt() {
		return manualEntryDt;
	}

	public void setManualEntryDt(Date manualEntryDt) {
		this.manualEntryDt = manualEntryDt;
	}

	public Date getValueDt() {
		return valueDt;
	}

	public void setValueDt(Date valueDt) {
		this.valueDt = valueDt;
	}

	public List<AccManualEntryCr> getCreditEntries() {
		return creditEntries;
	}

	public void setCreditEntries(List<AccManualEntryCr> creditEntries) {
		this.creditEntries = creditEntries;
	}

	public List<AccManualEntryDr> getDebitEntries() {
		return debitEntries;
	}

	public void setDebitEntries(List<AccManualEntryDr> debitEntries) {
		this.debitEntries = debitEntries;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AccManualEntryHdr that = (AccManualEntryHdr) o;
		return Objects.equals(id, that.id) && Objects.equals(cinNo, that.cinNo) && Objects.equals(type, that.type) && Objects.equals(entryStatusId, that.entryStatusId) && Objects.equals(entryStatus, that.entryStatus) && Objects.equals(referenceNo, that.referenceNo) && Objects.equals(referenceDt, that.referenceDt) && Objects.equals(totalEntryAmt, that.totalEntryAmt) && Objects.equals(totalDebitAmt, that.totalDebitAmt) && Objects.equals(totalCreditAmt, that.totalCreditAmt) && Objects.equals(manualEntryDt, that.manualEntryDt) && Objects.equals(valueDt, that.valueDt) && Objects.equals(creditEntries, that.creditEntries) && Objects.equals(debitEntries, that.debitEntries);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, cinNo, type, entryStatusId, entryStatus, referenceNo, referenceDt, totalEntryAmt, totalDebitAmt, totalCreditAmt, manualEntryDt, valueDt, creditEntries, debitEntries);
	}
}


