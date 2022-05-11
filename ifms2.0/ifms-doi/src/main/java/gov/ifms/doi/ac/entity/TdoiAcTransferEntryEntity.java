package gov.ifms.doi.ac.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TDOI_AC_TRANSFER_ENTRY database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

@Entity
@Table(name = "TDOI_AC_TRANSFER_ENTRY", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiAcTransferEntryEntity.findAll", query = "SELECT t FROM TdoiAcTransferEntryEntity t")
public class TdoiAcTransferEntryEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRANSFER_ENTRY_ID", unique = true, nullable = false)
	private long transferEntryId;

	@Column(name = "CARDEX_NO", length = 30)
	private String cardexNo;

	@Column(name = "CASHBOOK_ENTRY_DT")
	private Date cashbookEntryDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "CHEQUE_EPAY_DT")
	private Date chequeEpayDt;

	@Column(name = "CHEQUE_NO")
	private long chequeNo;

	@Column(name = "ENCAH_DELIV_DT")
	private Date encahDelivDt;

	@Column(name = "EPAYMENT_NO", length = 30)
	private String epaymentNo;

	@Column(name = "FROM_MAJORHEAD_ID")
	private long fromMajorheadId;

	@Column(name = "LAST_TE_NO_USED", length = 30)
	private String lastTeNoUsed;

	@Column(name = "MESSENGER_NAME", length = 60)
	private String messengerName;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(length = 100)
	private String remarks;

	@Column(name = "TE_AMOUNT")
	private double teAmount;

	@Column(name = "TE_FROM_TYPE_ID")
	private long teFromTypeId;

	@Column(name = "TE_TO_TYPE_ID")
	private long teToTypeId;

	@Column(name = "TE_TYPE_ID")
	private long teTypeId;

	@Column(name = "TO_MAJORHEAD_ID")
	private long toMajorheadId;

	@Column(name = "TRANSFER_DT")
	private Date transferDt;

	@Column(name = "TRANSFER_ENTRY_DT")
	private Date transferEntryDt;

	@Column(name = "TRANSFER_ENTRY_NO", length = 30)
	private String transferEntryNo;

	// bi-directional many-to-one association to TdoiAcTransferEntryDtlEntity
	@OneToMany(mappedBy = "tdoiAcTransferEntry")
	private List<TdoiAcTransferEntryDtlEntity> TdoiAcTransferEntryDtlEntitys;

	public long getTransferEntryId() {
		return this.transferEntryId;
	}

	public void setTransferEntryId(long transferEntryId) {
		this.transferEntryId = transferEntryId;
	}

	public String getCardexNo() {
		return this.cardexNo;
	}

	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
	}

	public Date getCashbookEntryDt() {
		return this.cashbookEntryDt;
	}

	public void setCashbookEntryDt(Date cashbookEntryDt) {
		this.cashbookEntryDt = cashbookEntryDt;
	}

	public Date getChequeEpayDt() {
		return this.chequeEpayDt;
	}

	public void setChequeEpayDt(Date chequeEpayDt) {
		this.chequeEpayDt = chequeEpayDt;
	}

	public long getChequeNo() {
		return this.chequeNo;
	}

	public void setChequeNo(long chequeNo) {
		this.chequeNo = chequeNo;
	}

	public Date getEncahDelivDt() {
		return this.encahDelivDt;
	}

	public void setEncahDelivDt(Date encahDelivDt) {
		this.encahDelivDt = encahDelivDt;
	}

	public String getEpaymentNo() {
		return this.epaymentNo;
	}

	public void setEpaymentNo(String epaymentNo) {
		this.epaymentNo = epaymentNo;
	}

	public long getFromMajorheadId() {
		return this.fromMajorheadId;
	}

	public void setFromMajorheadId(long fromMajorheadId) {
		this.fromMajorheadId = fromMajorheadId;
	}

	public String getLastTeNoUsed() {
		return this.lastTeNoUsed;
	}

	public void setLastTeNoUsed(String lastTeNoUsed) {
		this.lastTeNoUsed = lastTeNoUsed;
	}

	public String getMessengerName() {
		return this.messengerName;
	}

	public void setMessengerName(String messengerName) {
		this.messengerName = messengerName;
	}

	public Date getReferenceDt() {
		return this.referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getReferenceNo() {
		return this.referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public double getTeAmount() {
		return this.teAmount;
	}

	public void setTeAmount(double teAmount) {
		this.teAmount = teAmount;
	}

	public long getTeFromTypeId() {
		return this.teFromTypeId;
	}

	public void setTeFromTypeId(long teFromTypeId) {
		this.teFromTypeId = teFromTypeId;
	}

	public long getTeToTypeId() {
		return this.teToTypeId;
	}

	public void setTeToTypeId(long teToTypeId) {
		this.teToTypeId = teToTypeId;
	}

	public long getTeTypeId() {
		return this.teTypeId;
	}

	public void setTeTypeId(long teTypeId) {
		this.teTypeId = teTypeId;
	}

	public long getToMajorheadId() {
		return this.toMajorheadId;
	}

	public void setToMajorheadId(long toMajorheadId) {
		this.toMajorheadId = toMajorheadId;
	}

	public Date getTransferDt() {
		return this.transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}

	public Date getTransferEntryDt() {
		return this.transferEntryDt;
	}

	public void setTransferEntryDt(Date transferEntryDt) {
		this.transferEntryDt = transferEntryDt;
	}

	public String getTransferEntryNo() {
		return this.transferEntryNo;
	}

	public void setTransferEntryNo(String transferEntryNo) {
		this.transferEntryNo = transferEntryNo;
	}

	public List<TdoiAcTransferEntryDtlEntity> getTdoiAcTransferEntryDtlEntitys() {
		return this.TdoiAcTransferEntryDtlEntitys;
	}

	public void setTdoiAcTransferEntryDtlEntitys(List<TdoiAcTransferEntryDtlEntity> TdoiAcTransferEntryDtlEntitys) {
		this.TdoiAcTransferEntryDtlEntitys = TdoiAcTransferEntryDtlEntitys;
	}

}
