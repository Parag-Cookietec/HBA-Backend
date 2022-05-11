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
 * The persistent class for the TDOI_AC_STAMP_REGISTER database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

@Entity
@Table(name = "TDOI_AC_STAMP_REGISTER", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiAcStampRegisterEntity.findAll", query = "SELECT t FROM TdoiAcStampRegisterEntity t")
public class TdoiAcStampRegisterEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STAMP_REG_ID", unique = true, nullable = false)
	private long stampRegId;

	@Column(name = "AVAILABLE_AMT")
	private double availableAmt;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(length = 200)
	private String remarks;

	@Column(name = "STAMP_AMT")
	private double stampAmt;

	@Column(name = "STAMP_REFERENCE_NO", length = 30)
	private String stampReferenceNo;

	@Column(name = "TRANSACTION_DT", nullable = false)
	private Date transactionDt;

	@Column(name = "TRANSACTION_TYPE_ID")
	private long transactionTypeId;

	public long getStampRegId() {
		return this.stampRegId;
	}

	public void setStampRegId(long stampRegId) {
		this.stampRegId = stampRegId;
	}

	public double getAvailableAmt() {
		return this.availableAmt;
	}

	public void setAvailableAmt(double availableAmt) {
		this.availableAmt = availableAmt;
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

	public double getStampAmt() {
		return this.stampAmt;
	}

	public void setStampAmt(double stampAmt) {
		this.stampAmt = stampAmt;
	}

	public String getStampReferenceNo() {
		return this.stampReferenceNo;
	}

	public void setStampReferenceNo(String stampReferenceNo) {
		this.stampReferenceNo = stampReferenceNo;
	}

	public Date getTransactionDt() {
		return this.transactionDt;
	}

	public void setTransactionDt(Date transactionDt) {
		this.transactionDt = transactionDt;
	}

	public long getTransactionTypeId() {
		return this.transactionTypeId;
	}

	public void setTransactionTypeId(long transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

}
