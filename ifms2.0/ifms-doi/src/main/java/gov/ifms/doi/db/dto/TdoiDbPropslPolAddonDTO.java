package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_PROPSL_POL_ADDON database table.
 * 
 */

public class TdoiDbPropslPolAddonDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long propslPolAddonId;

	private long buildingTypeId;

	private double coverage;

	private double premiumAmount;

	private long unitType;

	private TdoiDbProposalDTO tdoiDbProposal;

	public long getPropslPolAddonId() {
		return this.propslPolAddonId;
	}

	public void setPropslPolAddonId(long propslPolAddonId) {
		this.propslPolAddonId = propslPolAddonId;
	}

	public long getBuildingTypeId() {
		return this.buildingTypeId;
	}

	public void setBuildingTypeId(long buildingTypeId) {
		this.buildingTypeId = buildingTypeId;
	}

	public double getCoverage() {
		return this.coverage;
	}

	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}

	public double getPremiumAmount() {
		return this.premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public long getUnitType() {
		return this.unitType;
	}

	public void setUnitType(long unitType) {
		this.unitType = unitType;
	}

	public TdoiDbProposalDTO getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalDTO tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

}
