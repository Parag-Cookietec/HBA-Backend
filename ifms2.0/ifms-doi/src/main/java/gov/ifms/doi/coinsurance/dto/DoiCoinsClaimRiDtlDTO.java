package gov.ifms.doi.coinsurance.dto;

import gov.ifms.doi.coinsurance.entity.DoiCoinsClaimHdrEntity;
import gov.ifms.doi.jpa.dto.BaseDto;


/**
 * @author Rudra
 *
 */

public class DoiCoinsClaimRiDtlDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6472218739482387027L;

	private long riClaimDtlId;

	private String coinsRiName;

	private double riClaimAmt;

	private double riSharePerc;

	private double riSurveyAmt;

	private double riTotAmt;

	private DoiCoinsClaimHdrEntity doiCoinsClaimHdrEntity;

	/**
	 * @return the riClaimDtlId
	 */
	public long getRiClaimDtlId() {
		return riClaimDtlId;
	}

	/**
	 * @param riClaimDtlId the riClaimDtlId to set
	 */
	public void setRiClaimDtlId(long riClaimDtlId) {
		this.riClaimDtlId = riClaimDtlId;
	}

	/**
	 * @return the coinsRiName
	 */
	public String getCoinsRiName() {
		return coinsRiName;
	}

	/**
	 * @param coinsRiName the coinsRiName to set
	 */
	public void setCoinsRiName(String coinsRiName) {
		this.coinsRiName = coinsRiName;
	}

	/**
	 * @return the riClaimAmt
	 */
	public double getRiClaimAmt() {
		return riClaimAmt;
	}

	/**
	 * @param riClaimAmt the riClaimAmt to set
	 */
	public void setRiClaimAmt(double riClaimAmt) {
		this.riClaimAmt = riClaimAmt;
	}

	/**
	 * @return the riSharePerc
	 */
	public double getRiSharePerc() {
		return riSharePerc;
	}

	/**
	 * @param riSharePerc the riSharePerc to set
	 */
	public void setRiSharePerc(double riSharePerc) {
		this.riSharePerc = riSharePerc;
	}

	/**
	 * @return the riSurveyAmt
	 */
	public double getRiSurveyAmt() {
		return riSurveyAmt;
	}

	/**
	 * @param riSurveyAmt the riSurveyAmt to set
	 */
	public void setRiSurveyAmt(double riSurveyAmt) {
		this.riSurveyAmt = riSurveyAmt;
	}

	/**
	 * @return the riTotAmt
	 */
	public double getRiTotAmt() {
		return riTotAmt;
	}

	/**
	 * @param riTotAmt the riTotAmt to set
	 */
	public void setRiTotAmt(double riTotAmt) {
		this.riTotAmt = riTotAmt;
	}

	/**
	 * @return the doiCoinsClaimHdrEntity
	 */
	public DoiCoinsClaimHdrEntity getDoiCoinsClaimHdrEntity() {
		return doiCoinsClaimHdrEntity;
	}

	/**
	 * @param doiCoinsClaimHdrEntity the doiCoinsClaimHdrEntity to set
	 */
	public void setDoiCoinsClaimHdrEntity(DoiCoinsClaimHdrEntity doiCoinsClaimHdrEntity) {
		this.doiCoinsClaimHdrEntity = doiCoinsClaimHdrEntity;
	}

}