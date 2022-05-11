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
 * The persistent class for the TDOI_DB_FIRE_SUM_INSURED database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_FIRE_SUM_INSURED", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbFireSumInsuredEntity.findAll", query = "SELECT t FROM TdoiDbFireSumInsuredEntity t")
public class TdoiDbFireSumInsuredEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUM_INSURED_ID", unique = true, nullable = false)
	private long sumInsuredId;

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

	// bi-directional many-to-one association to TdoiDbProposal
	@ManyToOne
	@JoinColumn(name = "DB_PROPOSAL_ID", nullable = false)
	private TdoiDbProposalEntity tdoiDbProposal;

	// bi-directional many-to-one association to TdoiDbPropslFirePeril
	@ManyToOne
	@JoinColumn(name = "FIRE_PERIL_ID", nullable = false)
	private TdoiDbPropslFirePerilEntity tdoiDbPropslFirePeril;

	public TdoiDbFireSumInsuredEntity() {
	}

	public long getSumInsuredId() {
		return this.sumInsuredId;
	}

	public void setSumInsuredId(long sumInsuredId) {
		this.sumInsuredId = sumInsuredId;
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

	public TdoiDbProposalEntity getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalEntity tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

	public TdoiDbPropslFirePerilEntity getTdoiDbPropslFirePeril() {
		return this.tdoiDbPropslFirePeril;
	}

	public void setTdoiDbPropslFirePeril(TdoiDbPropslFirePerilEntity tdoiDbPropslFirePeril) {
		this.tdoiDbPropslFirePeril = tdoiDbPropslFirePeril;
	}

}