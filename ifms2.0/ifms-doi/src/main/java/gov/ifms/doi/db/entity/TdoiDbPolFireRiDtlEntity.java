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
 * The persistent class for the TDOI_DB_POL_FIRE_RI_DTL database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_POL_FIRE_RI_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPolFireRiDtlEntity.findAll", query = "SELECT t FROM TdoiDbPolFireRiDtlEntity t")
public class TdoiDbPolFireRiDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POL_FIRE_RI_DTL_ID", unique = true, nullable = false)
	private long polFireRiDtlId;

	@Column(name = "RI_AMOUNT")
	private double riAmount;

	@Column(name = "RI_BRNCH_OFFICE", length = 100)
	private String riBrnchOffice;

	@Column(name = "RI_COMP_NAME", length = 100)
	private String riCompName;

	@Column(name = "RI_SHARE_PERC")
	private double riSharePerc;

	// bi-directional many-to-one association to TdoiDbPolFirePeril
	@ManyToOne
	@JoinColumn(name = "POL_FIRE_PERIL_ID", nullable = false)
	private TdoiDbPolFirePerilEntity tdoiDbPolFirePeril;

	public TdoiDbPolFireRiDtlEntity() {
	}

	public long getPolFireRiDtlId() {
		return this.polFireRiDtlId;
	}

	public void setPolFireRiDtlId(long polFireRiDtlId) {
		this.polFireRiDtlId = polFireRiDtlId;
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

	public TdoiDbPolFirePerilEntity getTdoiDbPolFirePeril() {
		return this.tdoiDbPolFirePeril;
	}

	public void setTdoiDbPolFirePeril(TdoiDbPolFirePerilEntity tdoiDbPolFirePeril) {
		this.tdoiDbPolFirePeril = tdoiDbPolFirePeril;
	}

}