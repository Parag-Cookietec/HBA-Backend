package gov.ifms.doi.coinsurance.dto;

import java.util.Date;

import gov.ifms.doi.coinsurance.entity.DoiCoinsPolicyHdrEntity;
import gov.ifms.doi.jpa.dto.BaseDto;


/**
 * @author Rudra
 *
 */

public class DoiCoinsPolicyRiDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6623626127354929438L;

	private long coinsPolicyRiId;

	private Date challanDt;

	private String challanNo;

	private Date paymentRecvDt;

	private long paymentRecvThru;

	private String riAddress;

	private String riName;

	private double riPremiumAmt;

	private double riSharePc;

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