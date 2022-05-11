package gov.ifms.doi.ac.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the TDOI_AC_CASHBOOK_RECEIPT database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

public class TdoiAcCashbookReceiptDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long cbReceiptId;

	private double advance;

	private double allowancePay;

	private long billReceiptSrno;

	private long chequeDdNo;

	private long drawnAmtTypeId;

	private double drawnBillAmt;

	private String govtAccReceipt;

	private long majorheadId;

	private long minorheadId;

	private double miscAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date paymentDt;

	private double permAdvRecoup;

	private String receiveFromName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private long subheadId;

	private long submajorheadId;

	private double totAllowance;

	private double totalAmt;

	public long getCbReceiptId() {
		return this.cbReceiptId;
	}

	public void setCbReceiptId(long cbReceiptId) {
		this.cbReceiptId = cbReceiptId;
	}

	public double getAdvance() {
		return this.advance;
	}

	public void setAdvance(double advance) {
		this.advance = advance;
	}

	public double getAllowancePay() {
		return this.allowancePay;
	}

	public void setAllowancePay(double allowancePay) {
		this.allowancePay = allowancePay;
	}

	public long getBillReceiptSrno() {
		return this.billReceiptSrno;
	}

	public void setBillReceiptSrno(long billReceiptSrno) {
		this.billReceiptSrno = billReceiptSrno;
	}

	public long getChequeDdNo() {
		return this.chequeDdNo;
	}

	public void setChequeDdNo(long chequeDdNo) {
		this.chequeDdNo = chequeDdNo;
	}

	public long getDrawnAmtTypeId() {
		return this.drawnAmtTypeId;
	}

	public void setDrawnAmtTypeId(long drawnAmtTypeId) {
		this.drawnAmtTypeId = drawnAmtTypeId;
	}

	public double getDrawnBillAmt() {
		return this.drawnBillAmt;
	}

	public void setDrawnBillAmt(double drawnBillAmt) {
		this.drawnBillAmt = drawnBillAmt;
	}

	public String getGovtAccReceipt() {
		return this.govtAccReceipt;
	}

	public void setGovtAccReceipt(String govtAccReceipt) {
		this.govtAccReceipt = govtAccReceipt;
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

	public double getMiscAmt() {
		return this.miscAmt;
	}

	public void setMiscAmt(double miscAmt) {
		this.miscAmt = miscAmt;
	}

	public Date getPaymentDt() {
		return this.paymentDt;
	}

	public void setPaymentDt(Date paymentDt) {
		this.paymentDt = paymentDt;
	}

	public double getPermAdvRecoup() {
		return this.permAdvRecoup;
	}

	public void setPermAdvRecoup(double permAdvRecoup) {
		this.permAdvRecoup = permAdvRecoup;
	}

	public String getReceiveFromName() {
		return this.receiveFromName;
	}

	public void setReceiveFromName(String receiveFromName) {
		this.receiveFromName = receiveFromName;
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

	public double getTotAllowance() {
		return this.totAllowance;
	}

	public void setTotAllowance(double totAllowance) {
		this.totAllowance = totAllowance;
	}

	public double getTotalAmt() {
		return this.totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}

}
