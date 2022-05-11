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
 * The persistent class for the TDOI_AC_CHALLAN_REGISTER database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

@Entity
@Table(name = "TDOI_AC_CHALLAN_REGISTER", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiAcChallanRegisterEntity.findAll", query = "SELECT t FROM TdoiAcChallanRegisterEntity t")
public class TdoiAcChallanRegisterEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHALLAN_REG_ID", unique = true, nullable = false)
	private long challanRegId;

	@Column(name = "BANK_ID")
	private long bankId;

	@Column(name = "BANK_NAME", length = 60)
	private String bankName;

	@Column(name = "BTR_RECEIPT_DT")
	private Date btrReceiptDt;

	@Column(name = "CHALLAN_NO")
	private long challanNo;

	@Column(name = "CHEQUE_DD_AMT")
	private double chequeDdAmt;

	@Temporal(TemporalType.DATE)
	@Column(name = "CHEQUE_DD_DT")
	private Date chequeDdDt;

	@Column(name = "CHEQUE_DD_NO")
	private long chequeDdNo;

	@Column(name = "CURRENT_DT")
	private Date currentDt;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "SERIAL_NO", length = 30)
	private String serialNo;

	public long getChallanRegId() {
		return this.challanRegId;
	}

	public void setChallanRegId(long challanRegId) {
		this.challanRegId = challanRegId;
	}

	public long getBankId() {
		return this.bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Date getBtrReceiptDt() {
		return this.btrReceiptDt;
	}

	public void setBtrReceiptDt(Date btrReceiptDt) {
		this.btrReceiptDt = btrReceiptDt;
	}

	public long getChallanNo() {
		return this.challanNo;
	}

	public void setChallanNo(long challanNo) {
		this.challanNo = challanNo;
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

	public Date getCurrentDt() {
		return this.currentDt;
	}

	public void setCurrentDt(Date currentDt) {
		this.currentDt = currentDt;
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

	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

}
