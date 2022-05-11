package gov.ifms.doi.ac.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TDOI_AC_CASHBOOK_RECEIPT database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

@Entity
@Table(name = "TDOI_AC_CASHBOOK_RECEIPT", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiAcCashbookReceiptEntity.findAll", query = "SELECT t FROM TdoiAcCashbookReceiptEntity t")
public class TdoiAcCashbookReceiptEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CB_RECEIPT_ID", unique = true, nullable = false)
	private long cbReceiptId;

	private double advance;

	@Column(name = "ALLOWANCE_PAY")
	private double allowancePay;

	@Column(name = "BILL_RECEIPT_SRNO")
	private long billReceiptSrno;

	@Column(name = "CHEQUE_DD_NO")
	private long chequeDdNo;

	@Column(name = "DRAWN_AMT_TYPE_ID")
	private long drawnAmtTypeId;

	@Column(name = "DRAWN_BILL_AMT")
	private double drawnBillAmt;

	@Column(name = "GOVT_ACC_RECEIPT", length = 60)
	private String govtAccReceipt;

	@Column(name = "MAJORHEAD_ID")
	private long majorheadId;

	@Column(name = "MINORHEAD_ID")
	private long minorheadId;

	@Column(name = "MISC_AMT")
	private double miscAmt;

	@Column(name = "PAYMENT_DT", nullable = false)
	private Date paymentDt;

	@Column(name = "PERM_ADV_RECOUP")
	private double permAdvRecoup;

	@Column(name = "RECEIVE_FROM_NAME", length = 100)
	private String receiveFromName;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "SUBHEAD_ID")
	private long subheadId;

	@Column(name = "SUBMAJORHEAD_ID")
	private long submajorheadId;

	@Column(name = "TOT_ALLOWANCE")
	private double totAllowance;

	@Column(name = "TOTAL_AMT")
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
