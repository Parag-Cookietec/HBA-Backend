package gov.ifms.doi.ac.dto;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.ac.entity.TdoiAcTransferEntryEntity;
/**
 * The persistent class for the TDOI_AC_TRANSFER_ENTRY_DTL database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

public class TdoiAcTransferEntryDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long transfrDtlId;

	private long budgTypeId;

	private String cardexNo;

	private long classId;

	private long ddoOffcId;

	private long demandNo;

	private long detlHeadId;

	private String doOperator;

	private long expTypeId;

	private long fundTypeId;

	private long majorheadId;

	private long minorheadId;

	private long objClassId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private String schemeNo;

	private long subheadId;

	private long submajorheadId;

	private double teAmount;

	private long teTypeId;

	private String transFrmOrTo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date transferDt;

	private String transferEntryNo;

	// bi-directional many-to-one association to TdoiAcTransferEntry
	@ManyToOne
	@JoinColumn(name = "TRANSFER_ENTRY_ID", nullable = false)
	private TdoiAcTransferEntryEntity tdoiAcTransferEntry;

	public long getTransfrDtlId() {
		return this.transfrDtlId;
	}

	public void setTransfrDtlId(long transfrDtlId) {
		this.transfrDtlId = transfrDtlId;
	}

	public long getBudgTypeId() {
		return this.budgTypeId;
	}

	public void setBudgTypeId(long budgTypeId) {
		this.budgTypeId = budgTypeId;
	}

	public String getCardexNo() {
		return this.cardexNo;
	}

	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
	}

	public long getClassId() {
		return this.classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public long getDdoOffcId() {
		return this.ddoOffcId;
	}

	public void setDdoOffcId(long ddoOffcId) {
		this.ddoOffcId = ddoOffcId;
	}

	public long getDemandNo() {
		return this.demandNo;
	}

	public void setDemandNo(long demandNo) {
		this.demandNo = demandNo;
	}

	public long getDetlHeadId() {
		return this.detlHeadId;
	}

	public void setDetlHeadId(long detlHeadId) {
		this.detlHeadId = detlHeadId;
	}

	public String getDoOperator() {
		return this.doOperator;
	}

	public void setDoOperator(String doOperator) {
		this.doOperator = doOperator;
	}

	public long getExpTypeId() {
		return this.expTypeId;
	}

	public void setExpTypeId(long expTypeId) {
		this.expTypeId = expTypeId;
	}

	public long getFundTypeId() {
		return this.fundTypeId;
	}

	public void setFundTypeId(long fundTypeId) {
		this.fundTypeId = fundTypeId;
	}

	public long getMajorheadId() {
		return this.majorheadId;
	}

	public void setMajorheadId(long majorheadId) {
		this.majorheadId = majorheadId;
	}

	public long getMinorheadId() {
		return this.minorheadId;
	}

	public void setMinorheadId(long minorheadId) {
		this.minorheadId = minorheadId;
	}

	public long getObjClassId() {
		return this.objClassId;
	}

	public void setObjClassId(long objClassId) {
		this.objClassId = objClassId;
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

	public String getSchemeNo() {
		return this.schemeNo;
	}

	public void setSchemeNo(String schemeNo) {
		this.schemeNo = schemeNo;
	}

	public long getSubheadId() {
		return this.subheadId;
	}

	public void setSubheadId(long subheadId) {
		this.subheadId = subheadId;
	}

	public long getSubmajorheadId() {
		return this.submajorheadId;
	}

	public void setSubmajorheadId(long submajorheadId) {
		this.submajorheadId = submajorheadId;
	}

	public double getTeAmount() {
		return this.teAmount;
	}

	public void setTeAmount(double teAmount) {
		this.teAmount = teAmount;
	}

	public long getTeTypeId() {
		return this.teTypeId;
	}

	public void setTeTypeId(long teTypeId) {
		this.teTypeId = teTypeId;
	}

	public String getTransFrmOrTo() {
		return this.transFrmOrTo;
	}

	public void setTransFrmOrTo(String transFrmOrTo) {
		this.transFrmOrTo = transFrmOrTo;
	}

	public Date getTransferDt() {
		return this.transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}

	public String getTransferEntryNo() {
		return this.transferEntryNo;
	}

	public void setTransferEntryNo(String transferEntryNo) {
		this.transferEntryNo = transferEntryNo;
	}

	public TdoiAcTransferEntryEntity getTdoiAcTransferEntry() {
		return this.tdoiAcTransferEntry;
	}

	public void setTdoiAcTransferEntry(TdoiAcTransferEntryEntity tdoiAcTransferEntry) {
		this.tdoiAcTransferEntry = tdoiAcTransferEntry;
	}

}
