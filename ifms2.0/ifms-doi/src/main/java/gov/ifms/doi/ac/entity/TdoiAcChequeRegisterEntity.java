package gov.ifms.doi.ac.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TDOI_AC_CHEQUE_REGISTER database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

@Entity
@Table(name = "TDOI_AC_CHEQUE_REGISTER", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiAcChequeRegisterEntity.findAll", query = "SELECT t FROM TdoiAcChequeRegisterEntity t")
public class TdoiAcChequeRegisterEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHEQUE_REG_ID", unique = true, nullable = false)
	private long chequeRegId;

	@Column(name = "BILL_AMOUNT")
	private double billAmount;

	@Column(name = "BILL_NO", length = 30)
	private String billNo;

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

	@Column(name = "MESSENGER_NAME", length = 60)
	private String messengerName;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(length = 100)
	private String remarks;

	public long getChequeRegId() {
		return this.chequeRegId;
	}

	public void setChequeRegId(long chequeRegId) {
		this.chequeRegId = chequeRegId;
	}

	public double getBillAmount() {
		return this.billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
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

}
