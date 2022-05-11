package gov.ifms.doi.legalentry.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.edp.entity.BaseEntity;


/**
 * @author Rudra
 *
 */
@Entity
@Table(name="TDOI_JPA_LEGAL_OTHR_PAYMENTS", schema = DoiJPAConstants.DOI_SCHEMA)
public class DOIJpaLegalOthrPaymentEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4203626250867001862L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OTHR_PAYMNTS_ID", unique=true, nullable=false)
	private long othrPaymntsId;

	@Temporal(TemporalType.DATE)
	@Column(name="CHEQUE_DT")
	private Date chequeDt;

	@Column(name="CHEQUE_NUM")
	private long chequeNum;

	@Column(name="COMMISSION_TYPE", nullable=false, length=20)
	private String commissionType;

	@Column(name="DD_NUM")
	private long ddNum;

	@Column(name="PAYMENT_AMOUNT")
	private double paymentAmount;

	@Column(name="PAYMENT_MODE_ID")
	private long paymentModeId;

	@Column(name="REFERENCE_NO", length=30)
	private String referenceNo;

	@Column(length=100)
	private String remarks;

	//bi-directional many-to-one association to TdoiJpaLegalDtl
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=DOIJpaLegalDtlEntity.class)
	@JoinColumn(name="LEGAL_DTLS_ID", nullable=false)
	private DOIJpaLegalDtlEntity doiJpaLegalDtl;


	/**
	 * @return the othrPaymntsId
	 */
	public long getOthrPaymntsId() {
		return othrPaymntsId;
	}

	/**
	 * @param othrPaymntsId the othrPaymntsId to set
	 */
	public void setOthrPaymntsId(long othrPaymntsId) {
		this.othrPaymntsId = othrPaymntsId;
	}

	/**
	 * @return the chequeDt
	 */
	public Date getChequeDt() {
		return chequeDt;
	}

	/**
	 * @param chequeDt the chequeDt to set
	 */
	public void setChequeDt(Date chequeDt) {
		this.chequeDt = chequeDt;
	}

	/**
	 * @return the chequeNum
	 */
	public long getChequeNum() {
		return chequeNum;
	}

	/**
	 * @param chequeNum the chequeNum to set
	 */
	public void setChequeNum(long chequeNum) {
		this.chequeNum = chequeNum;
	}

	/**
	 * @return the commissionType
	 */
	public String getCommissionType() {
		return commissionType;
	}

	/**
	 * @param commissionType the commissionType to set
	 */
	public void setCommissionType(String commissionType) {
		this.commissionType = commissionType;
	}

	/**
	 * @return the ddNum
	 */
	public long getDdNum() {
		return ddNum;
	}

	/**
	 * @param ddNum the ddNum to set
	 */
	public void setDdNum(long ddNum) {
		this.ddNum = ddNum;
	}

	/**
	 * @return the paymentAmount
	 */
	public double getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * @param paymentAmount the paymentAmount to set
	 */
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 * @return the paymentModeId
	 */
	public long getPaymentModeId() {
		return paymentModeId;
	}

	/**
	 * @param paymentModeId the paymentModeId to set
	 */
	public void setPaymentModeId(long paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	/**
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * @param referenceNo the referenceNo to set
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the doiJpaLegalDtl
	 */
	public DOIJpaLegalDtlEntity getDoiJpaLegalDtl() {
		return doiJpaLegalDtl;
	}

	/**
	 * @param doiJpaLegalDtl the doiJpaLegalDtl to set
	 */
	public void setDoiJpaLegalDtl(DOIJpaLegalDtlEntity doiJpaLegalDtl) {
		this.doiJpaLegalDtl = doiJpaLegalDtl;
	}

}