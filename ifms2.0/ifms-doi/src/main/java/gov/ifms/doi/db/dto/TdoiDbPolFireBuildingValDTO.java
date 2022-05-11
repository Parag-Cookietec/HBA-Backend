package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_POL_FIRE_BUILDING_VAL database table.
 * 
 */

public class TdoiDbPolFireBuildingValDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long buildValId;

	private String blockDesc;

	private long buildingAgeYrs;

	private String buildingHeight;

	private double buildingPathAmt;

	private String construction;

	private long dbProposalId;

	private double fAndFAmt;

	private double insurPropAmt;

	private double mAndAAmt;

	private double sspAmt;

	private double totalAmt;

	// bi-directional many-to-one association to TdoiDbPolFirePeril

	private TdoiDbPolFirePerilDTO tdoiDbPolFirePeril;

	public TdoiDbPolFireBuildingValDTO() {
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

	public long getDbProposalId() {
		return this.dbProposalId;
	}

	public void setDbProposalId(long dbProposalId) {
		this.dbProposalId = dbProposalId;
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

	public TdoiDbPolFirePerilDTO getTdoiDbPolFirePeril() {
		return this.tdoiDbPolFirePeril;
	}

	public void setTdoiDbPolFirePeril(TdoiDbPolFirePerilDTO tdoiDbPolFirePeril) {
		this.tdoiDbPolFirePeril = tdoiDbPolFirePeril;
	}

}
