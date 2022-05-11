package gov.ifms.doi.coinsurance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.edp.entity.BaseEntity;


/**
 * @author Rudra
 *
 */
@Entity
@Table(name="TDOI_COINS_CLAIM_RI_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiCoinsClaimRiDtlEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3285202581649380790L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RI_CLAIM_DTL_ID", unique=true, nullable=false)
	private long riClaimDtlId;

	@Column(name="COINS_RI_NAME", length=100)
	private String coinsRiName;

	@Column(name="RI_CLAIM_AMT")
	private double riClaimAmt;

	@Column(name="RI_SHARE_PERC")
	private double riSharePerc;

	@Column(name="RI_SURVEY_AMT")
	private double riSurveyAmt;

	@Column(name="RI_TOT_AMT")
	private double riTotAmt;

	//bi-directional many-to-one association to DoiCoinsClaimHdrEntity
	@ManyToOne
	@JoinColumn(name="COINS_CLAIM_ID", nullable=false)
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