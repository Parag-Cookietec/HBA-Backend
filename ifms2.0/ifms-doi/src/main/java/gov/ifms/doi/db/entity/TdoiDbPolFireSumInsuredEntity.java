package gov.ifms.doi.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_DB_POL_FIRE_SUM_INSURED database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_POL_FIRE_SUM_INSURED", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPolFireSumInsuredEntity.findAll", query = "SELECT t FROM TdoiDbPolFireSumInsuredEntity t")
public class TdoiDbPolFireSumInsuredEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUM_INSURED_ID", unique = true, nullable = false)
	private long sumInsuredId;

	@Column(name = "DB_PROPOSAL_ID", nullable = false)
	private long dbProposalId;

	@Column(name = "PERIL_CAUSE_ID", nullable = false)
	private long perilCauseId;

	@Column(name = "PREMIUM_AMT")
	private double premiumAmt;

	@Column(name = "PRM_RISK_CODE")
	private long prmRiskCode;

	@Column(name = "PRM_RISK_RATE_CODE")
	private long prmRiskRateCode;

	@Column(name = "RISK_CODE")
	private long riskCode;

	@Column(name = "RISK_COVER_ID", nullable = false)
	private long riskCoverId;

	@Column(name = "RISK_RATE")
	private double riskRate;

	@Column(name = "RISK_RATE_CODE")
	private long riskRateCode;

	@Column(name = "SUM_INSURED")
	private double sumInsured;

	// bi-directional many-to-one association to TdoiDbPolFirePeril
	@ManyToOne
	@JoinColumn(name = "POL_FIRE_PERIL_ID", nullable = false)
	private TdoiDbPolFirePerilEntity tdoiDbPolFirePeril;

	public TdoiDbPolFireSumInsuredEntity() {
	}

	public long getSumInsuredId() {
		return this.sumInsuredId;
	}

	public void setSumInsuredId(long sumInsuredId) {
		this.sumInsuredId = sumInsuredId;
	}

	public long getDbProposalId() {
		return this.dbProposalId;
	}

	public void setDbProposalId(long dbProposalId) {
		this.dbProposalId = dbProposalId;
	}

	public long getPerilCauseId() {
		return this.perilCauseId;
	}

	public void setPerilCauseId(long perilCauseId) {
		this.perilCauseId = perilCauseId;
	}

	public double getPremiumAmt() {
		return this.premiumAmt;
	}

	public void setPremiumAmt(double premiumAmt) {
		this.premiumAmt = premiumAmt;
	}

	public long getPrmRiskCode() {
		return this.prmRiskCode;
	}

	public void setPrmRiskCode(long prmRiskCode) {
		this.prmRiskCode = prmRiskCode;
	}

	public long getPrmRiskRateCode() {
		return this.prmRiskRateCode;
	}

	public void setPrmRiskRateCode(long prmRiskRateCode) {
		this.prmRiskRateCode = prmRiskRateCode;
	}

	public long getRiskCode() {
		return this.riskCode;
	}

	public void setRiskCode(long riskCode) {
		this.riskCode = riskCode;
	}

	public long getRiskCoverId() {
		return this.riskCoverId;
	}

	public void setRiskCoverId(long riskCoverId) {
		this.riskCoverId = riskCoverId;
	}

	public double getRiskRate() {
		return this.riskRate;
	}

	public void setRiskRate(double riskRate) {
		this.riskRate = riskRate;
	}

	public long getRiskRateCode() {
		return this.riskRateCode;
	}

	public void setRiskRateCode(long riskRateCode) {
		this.riskRateCode = riskRateCode;
	}

	public double getSumInsured() {
		return this.sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public TdoiDbPolFirePerilEntity getTdoiDbPolFirePeril() {
		return this.tdoiDbPolFirePeril;
	}

	public void setTdoiDbPolFirePeril(TdoiDbPolFirePerilEntity tdoiDbPolFirePeril) {
		this.tdoiDbPolFirePeril = tdoiDbPolFirePeril;
	}

}