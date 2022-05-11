package gov.ifms.doi.ac.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the TDOI_AC_CHALLAN_DTL database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

public class TdoiAcChallanDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long challanDtlId;

	private long btrReceiptNo;

	private String challanNo;

	private String chequeAmtInWords;

	private double chequeDdAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date chequeDdDt;

	private long chequeDdNo;

	private long detailHeadId;

	private long majorheadId;

	private long minorheadId;

	private long mobileNo;

	private String partyDesc;

	private String partyName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private long subheadId;

	private long submajorheadId;

	public long getChallanDtlId() {
		return this.challanDtlId;
	}

	public void setChallanDtlId(long challanDtlId) {
		this.challanDtlId = challanDtlId;
	}

	public long getBtrReceiptNo() {
		return this.btrReceiptNo;
	}

	public void setBtrReceiptNo(long btrReceiptNo) {
		this.btrReceiptNo = btrReceiptNo;
	}

	public String getChallanNo() {
		return this.challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public String getChequeAmtInWords() {
		return this.chequeAmtInWords;
	}

	public void setChequeAmtInWords(String chequeAmtInWords) {
		this.chequeAmtInWords = chequeAmtInWords;
	}

	public double getChequeDdAmt() {
		return this.chequeDdAmt;
	}

	public void setChequeDdAmt(double chequeDdAmt) {
		this.chequeDdAmt = chequeDdAmt;
	}

	public Date getChequeDdDt() {
		return this.chequeDdDt;
	}

	public void setChequeDdDt(Date chequeDdDt) {
		this.chequeDdDt = chequeDdDt;
	}

	public long getChequeDdNo() {
		return this.chequeDdNo;
	}

	public void setChequeDdNo(long chequeDdNo) {
		this.chequeDdNo = chequeDdNo;
	}

	public long getDetailHeadId() {
		return this.detailHeadId;
	}

	public void setDetailHeadId(long detailHeadId) {
		this.detailHeadId = detailHeadId;
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

	public long getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPartyDesc() {
		return this.partyDesc;
	}

	public void setPartyDesc(String partyDesc) {
		this.partyDesc = partyDesc;
	}

	public String getPartyName() {
		return this.partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
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

}
