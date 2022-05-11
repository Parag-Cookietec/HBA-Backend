package gov.ifms.doi.coinsurance.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="TDOI_COINS_POLICY_RI", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiCoinsPolicyRiEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1255912745295555181L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COINS_POLICY_RI_ID", unique=true, nullable=false)
	private long coinsPolicyRiId;

	@Temporal(TemporalType.DATE)
	@Column(name="CHALLAN_DT")
	private Date challanDt;

	@Column(name="CHALLAN_NO", length=30)
	private String challanNo;

	@Temporal(TemporalType.DATE)
	@Column(name="PAYMENT_RECV_DT")
	private Date paymentRecvDt;

	@Column(name="PAYMENT_RECV_THRU")
	private long paymentRecvThru;

	@Column(name="RI_ADDRESS", length=100)
	private String riAddress;

	@Column(name="RI_NAME", length=60)
	private String riName;

	@Column(name="RI_PREMIUM_AMT")
	private double riPremiumAmt;

	@Column(name="RI_SHARE_PC")
	private double riSharePc;

	//bi-directional many-to-one association to DoiCoinsPolicyHdrEntity
	@ManyToOne
	@JoinColumn(name="COINS_POLICY_HDR_ID", nullable=false)
	private DoiCoinsPolicyHdrEntity doiCoinsPolicyHdrEntity;

	/**
	 * @return the coinsPolicyRiId
	 */
	public long getCoinsPolicyRiId() {
		return coinsPolicyRiId;
	}

	/**
	 * @param coinsPolicyRiId the coinsPolicyRiId to set
	 */
	public void setCoinsPolicyRiId(long coinsPolicyRiId) {
		this.coinsPolicyRiId = coinsPolicyRiId;
	}

	/**
	 * @return the challanDt
	 */
	public Date getChallanDt() {
		return challanDt;
	}

	/**
	 * @param challanDt the challanDt to set
	 */
	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	/**
	 * @return the challanNo
	 */
	public String getChallanNo() {
		return challanNo;
	}

	/**
	 * @param challanNo the challanNo to set
	 */
	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	/**
	 * @return the paymentRecvDt
	 */
	public Date getPaymentRecvDt() {
		return paymentRecvDt;
	}

	/**
	 * @param paymentRecvDt the paymentRecvDt to set
	 */
	public void setPaymentRecvDt(Date paymentRecvDt) {
		this.paymentRecvDt = paymentRecvDt;
	}

	/**
	 * @return the paymentRecvThru
	 */
	public long getPaymentRecvThru() {
		return paymentRecvThru;
	}

	/**
	 * @param paymentRecvThru the paymentRecvThru to set
	 */
	public void setPaymentRecvThru(long paymentRecvThru) {
		this.paymentRecvThru = paymentRecvThru;
	}

	/**
	 * @return the riAddress
	 */
	public String getRiAddress() {
		return riAddress;
	}

	/**
	 * @param riAddress the riAddress to set
	 */
	public void setRiAddress(String riAddress) {
		this.riAddress = riAddress;
	}

	/**
	 * @return the riName
	 */
	public String getRiName() {
		return riName;
	}

	/**
	 * @param riName the riName to set
	 */
	public void setRiName(String riName) {
		this.riName = riName;
	}

	/**
	 * @return the riPremiumAmt
	 */
	public double getRiPremiumAmt() {
		return riPremiumAmt;
	}

	/**
	 * @param riPremiumAmt the riPremiumAmt to set
	 */
	public void setRiPremiumAmt(double riPremiumAmt) {
		this.riPremiumAmt = riPremiumAmt;
	}

	/**
	 * @return the riSharePc
	 */
	public double getRiSharePc() {
		return riSharePc;
	}

	/**
	 * @param riSharePc the riSharePc to set
	 */
	public void setRiSharePc(double riSharePc) {
		this.riSharePc = riSharePc;
	}

	/**
	 * @return the doiCoinsPolicyHdrEntity
	 */
	public DoiCoinsPolicyHdrEntity getDoiCoinsPolicyHdrEntity() {
		return doiCoinsPolicyHdrEntity;
	}

	/**
	 * @param doiCoinsPolicyHdrEntity the doiCoinsPolicyHdrEntity to set
	 */
	public void setDoiCoinsPolicyHdrEntity(DoiCoinsPolicyHdrEntity doiCoinsPolicyHdrEntity) {
		this.doiCoinsPolicyHdrEntity = doiCoinsPolicyHdrEntity;
	}

}