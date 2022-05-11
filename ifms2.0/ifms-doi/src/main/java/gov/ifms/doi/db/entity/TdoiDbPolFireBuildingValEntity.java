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
 * The persistent class for the TDOI_DB_POL_FIRE_BUILDING_VAL database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_POL_FIRE_BUILDING_VAL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPolFireBuildingValEntity.findAll", query = "SELECT t FROM TdoiDbPolFireBuildingValEntity t")
public class TdoiDbPolFireBuildingValEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUILD_VAL_ID", unique = true, nullable = false)
	private long buildValId;

	@Column(name = "BLOCK_DESC", length = 100)
	private String blockDesc;

	@Column(name = "BUILDING_AGE_YRS")
	private long buildingAgeYrs;

	@Column(name = "BUILDING_HEIGHT", length = 20)
	private String buildingHeight;

	@Column(name = "BUILDING_PATH_AMT")
	private double buildingPathAmt;

	@Column(length = 100)
	private String construction;

	@Column(name = "DB_PROPOSAL_ID", nullable = false)
	private long dbProposalId;

	@Column(name = "F_AND_F_AMT")
	private double fAndFAmt;

	@Column(name = "INSUR_PROP_AMT")
	private double insurPropAmt;

	@Column(name = "M_AND_A_AMT")
	private double mAndAAmt;

	@Column(name = "SSP_AMT")
	private double sspAmt;

	@Column(name = "TOTAL_AMT")
	private double totalAmt;

	// bi-directional many-to-one association to TdoiDbPolFirePeril
	@ManyToOne
	@JoinColumn(name = "POL_FIRE_PERIL_ID", nullable = false)
	private TdoiDbPolFirePerilEntity tdoiDbPolFirePeril;

	public TdoiDbPolFireBuildingValEntity() {
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

	public TdoiDbPolFirePerilEntity getTdoiDbPolFirePeril() {
		return this.tdoiDbPolFirePeril;
	}

	public void setTdoiDbPolFirePeril(TdoiDbPolFirePerilEntity tdoiDbPolFirePeril) {
		this.tdoiDbPolFirePeril = tdoiDbPolFirePeril;
	}

}