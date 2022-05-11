package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_POL_FIRE_SUM_INSURED database table.
 * 
 */

public class TdoiDbPolFireSumInsuredDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long sumInsuredId;

	private long dbProposalId;

	private long perilCauseId;

	private double premiumAmt;

	private long prmRiskCode;

	private long prmRiskRateCode;

	private long riskCode;

	private long riskCoverId;

	private double riskRate;

	private long riskRateCode;

	private double sumInsured;

	// bi-directional many-to-one association to TdoiDbPolFirePeril

	private TdoiDbPolFirePerilDTO tdoiDbPolFirePeril;

	public TdoiDbPolFireSumInsuredDTO() {
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

	public TdoiDbPolFirePerilDTO getTdoiDbPolFirePeril() {
		return this.tdoiDbPolFirePeril;
	}

	public void setTdoiDbPolFirePeril(TdoiDbPolFirePerilDTO tdoiDbPolFirePeril) {
		this.tdoiDbPolFirePeril = tdoiDbPolFirePeril;
	}

}
