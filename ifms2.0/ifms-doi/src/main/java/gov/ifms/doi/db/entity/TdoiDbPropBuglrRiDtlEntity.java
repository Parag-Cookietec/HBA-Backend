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
 * The persistent class for the TDOI_DB_PROP_BUGLR_RI_DTL database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_PROP_BUGLR_RI_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPropBuglrRiDtlEntity.findAll", query = "SELECT t FROM TdoiDbPropBuglrRiDtlEntity t")
public class TdoiDbPropBuglrRiDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BUGLR_RI_DTL_ID", unique = true, nullable = false)
	private long buglrRiDtlId;

	@Column(name = "RI_AMOUNT")
	private double riAmount;

	@Column(name = "RI_BRNCH_OFFICE", length = 100)
	private String riBrnchOffice;

	@Column(name = "RI_COMP_NAME", length = 100)
	private String riCompName;

	@Column(name = "RI_SHARE_PERC")
	private double riSharePerc;

	// bi-directional many-to-one association to TdoiDbPropslBurglary
	@ManyToOne
	@JoinColumn(name = "DB_BURGLARY_ID", nullable = false)
	private TdoiDbPropslBurglaryEntity tdoiDbPropslBurglary;

	public TdoiDbPropBuglrRiDtlEntity() {
	}

	public long getBuglrRiDtlId() {
		return this.buglrRiDtlId;
	}

	public void setBuglrRiDtlId(long buglrRiDtlId) {
		this.buglrRiDtlId = buglrRiDtlId;
	}

	public double getRiAmount() {
		return this.riAmount;
	}

	public void setRiAmount(double riAmount) {
		this.riAmount = riAmount;
	}

	public String getRiBrnchOffice() {
		return this.riBrnchOffice;
	}

	public void setRiBrnchOffice(String riBrnchOffice) {
		this.riBrnchOffice = riBrnchOffice;
	}

	public String getRiCompName() {
		return this.riCompName;
	}

	public void setRiCompName(String riCompName) {
		this.riCompName = riCompName;
	}

	public double getRiSharePerc() {
		return this.riSharePerc;
	}

	public void setRiSharePerc(double riSharePerc) {
		this.riSharePerc = riSharePerc;
	}

	public TdoiDbPropslBurglaryEntity getTdoiDbPropslBurglary() {
		return this.tdoiDbPropslBurglary;
	}

	public void setTdoiDbPropslBurglary(TdoiDbPropslBurglaryEntity tdoiDbPropslBurglary) {
		this.tdoiDbPropslBurglary = tdoiDbPropslBurglary;
	}

}