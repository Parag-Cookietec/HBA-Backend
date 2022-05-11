package gov.ifms.doi.ac.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the TDOI_AC_CASHBOOK_PAYMENT database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

public class TdoiAcCashbookPaymentDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long cbPaymentId;

	private double advance;

	private double allowancePay;

	private long drawnAmtTypeId;

	private double drawnBillAmt;

	private String govtAccReceipt;

	private long majorheadId;

	private long minorheadId;

	private double miscAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date paymentDt;

	private double permAdvRecoup;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private long subheadId;

	private long submajorheadId;

	private long subvoucherSrno;

	private double totAllowance;

	private double totalAmt;

	private String whomPaidName;

	public long getCbPaymentId() {
		return this.cbPaymentId;
	}

	public void setCbPaymentId(long cbPaymentId) {
		this.cbPaymentId = cbPaymentId;
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

	public long getSubvoucherSrno() {
		return this.subvoucherSrno;
	}

	public void setSubvoucherSrno(long subvoucherSrno) {
		this.subvoucherSrno = subvoucherSrno;
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

	public String getWhomPaidName() {
		return this.whomPaidName;
	}

	public void setWhomPaidName(String whomPaidName) {
		this.whomPaidName = whomPaidName;
	}

}
