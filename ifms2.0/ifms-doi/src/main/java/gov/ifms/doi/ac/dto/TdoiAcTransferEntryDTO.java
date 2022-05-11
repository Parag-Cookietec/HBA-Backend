package gov.ifms.doi.ac.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.ac.entity.TdoiAcTransferEntryDtlEntity;
/**
 * The persistent class for the TDOI_AC_TRANSFER_ENTRY database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

public class TdoiAcTransferEntryDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long transferEntryId;

	private String cardexNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date cashbookEntryDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date chequeEpayDt;

	private long chequeNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date encahDelivDt;

	private String epaymentNo;

	private long fromMajorheadId;

	private String lastTeNoUsed;

	private String messengerName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private String remarks;

	private double teAmount;

	private long teFromTypeId;

	private long teToTypeId;

	private long teTypeId;

	private long toMajorheadId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date transferDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date transferEntryDt;

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
