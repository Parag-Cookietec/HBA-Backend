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
 * The persistent class for the TDOI_DB_PROPSL_POL_ADDON database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_PROPSL_POL_ADDON", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPropslPolAddonEntity.findAll", query = "SELECT t FROM TdoiDbPropslPolAddonEntity t")
public class TdoiDbPropslPolAddonEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROPSL_POL_ADDON_ID", unique = true, nullable = false)
	private long propslPolAddonId;

	@Column(name = "BUILDING_TYPE_ID", nullable = false)
	private long buildingTypeId;

	@Column(nullable = false)
	private double coverage;

	@Column(name = "PREMIUM_AMOUNT")
	private double premiumAmount;

	@Column(name = "UNIT_TYPE")
	private long unitType;

	// bi-directional many-to-one association to TdoiDbProposal
	@ManyToOne
	@JoinColumn(name = "DB_PROPOSAL_ID", nullable = false)
	private TdoiDbProposalEntity tdoiDbProposal;

	public TdoiDbPropslPolAddonEntity() {
	}

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

	public TdoiDbProposalEntity getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalEntity tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

}