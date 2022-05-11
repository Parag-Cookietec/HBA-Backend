package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_FIRE_BUILDING_VAL database table.
 * 
 */

public class TdoiDbFireBuildingValDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long buildValId;

	private String blockDesc;

	private long buildingAgeYrs;

	private String buildingHeight;

	private double buildingPathAmt;

	private String construction;

	private double fAndFAmt;

	private double insurPropAmt;

	private double mAndAAmt;

	private double sspAmt;

	private double totalAmt;

	// bi-directional many-to-one association to TdoiDbProposal

	private TdoiDbProposalDTO tdoiDbProposal;

	// bi-directional many-to-one association to TdoiDbPropslFirePeril

	private TdoiDbPropslFirePerilDTO tdoiDbPropslFirePeril;

	public TdoiDbFireBuildingValDTO() {
	}

	public long getBuildValId() {
		return this.buildValId;
	}

	public void setBuildValId(long buildValId) {
		this.buildValId = buildValId;
	}

	public String getBlockDesc() {
		return this.blockDesc;
	}

	public void setBlockDesc(String blockDesc) {
		this.blockDesc = blockDesc;
	}

	public long getBuildingAgeYrs() {
		return this.buildingAgeYrs;
	}

	public void setBuildingAgeYrs(long buildingAgeYrs) {
		this.buildingAgeYrs = buildingAgeYrs;
	}

	public String getBuildingHeight() {
		return this.buildingHeight;
	}

	public void setBuildingHeight(String buildingHeight) {
		this.buildingHeight = buildingHeight;
	}

	public double getBuildingPathAmt() {
		return this.buildingPathAmt;
	}

	public void setBuildingPathAmt(double buildingPathAmt) {
		this.buildingPathAmt = buildingPathAmt;
	}

	public String getConstruction() {
		return this.construction;
	}

	public void setConstruction(String construction) {
		this.construction = construction;
	}

	public double getFAndFAmt() {
		return this.fAndFAmt;
	}

	public void setFAndFAmt(double fAndFAmt) {
		this.fAndFAmt = fAndFAmt;
	}

	public double getInsurPropAmt() {
		return this.insurPropAmt;
	}

	public void setInsurPropAmt(double insurPropAmt) {
		this.insurPropAmt = insurPropAmt;
	}

	public double getMAndAAmt() {
		return this.mAndAAmt;
	}

	public void setMAndAAmt(double mAndAAmt) {
		this.mAndAAmt = mAndAAmt;
	}

	public double getSspAmt() {
		return this.sspAmt;
	}

	public void setSspAmt(double sspAmt) {
		this.sspAmt = sspAmt;
	}

	public double getTotalAmt() {
		return this.totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public TdoiDbProposalDTO getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalDTO tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

	public TdoiDbPropslFirePerilDTO getTdoiDbPropslFirePeril() {
		return this.tdoiDbPropslFirePeril;
	}

	public void setTdoiDbPropslFirePeril(TdoiDbPropslFirePerilDTO tdoiDbPropslFirePeril) {
		this.tdoiDbPropslFirePeril = tdoiDbPropslFirePeril;
	}

}
