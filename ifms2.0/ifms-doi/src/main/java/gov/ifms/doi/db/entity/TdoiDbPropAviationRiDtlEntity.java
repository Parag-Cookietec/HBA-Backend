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
 * The persistent class for the TDOI_DB_PROP_AVIATION_RI_DTL database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_PROP_AVIATION_RI_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPropAviationRiDtlEntity.findAll", query = "SELECT t FROM TdoiDbPropAviationRiDtlEntity t")
public class TdoiDbPropAviationRiDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROP_AVIAT_RI_DTL_ID", unique = true, nullable = false)
	private long propAviatRiDtlId;

	@Column(name = "RI_AMOUNT")
	private double riAmount;

	@Column(name = "RI_BRNCH_OFFICE", length = 100)
	private String riBrnchOffice;

	@Column(name = "RI_COMP_NAME", length = 100)
	private String riCompName;

	@Column(name = "RI_SHARE_PERC")
	private double riSharePerc;

	// bi-directional many-to-one association to TdoiDbPropslAviation
	@ManyToOne
	@JoinColumn(name = "PROP_AVIATION_ID", nullable = false)
	private TdoiDbPropslAviationEntity tdoiDbPropslAviation;

	public TdoiDbPropAviationRiDtlEntity() {
	}

	public long getPropAviatRiDtlId() {
		return this.propAviatRiDtlId;
	}

	public void setPropAviatRiDtlId(long propAviatRiDtlId) {
		this.propAviatRiDtlId = propAviatRiDtlId;
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

	public TdoiDbPropslAviationEntity getTdoiDbPropslAviation() {
		return this.tdoiDbPropslAviation;
	}

	public void setTdoiDbPropslAviation(TdoiDbPropslAviationEntity tdoiDbPropslAviation) {
		this.tdoiDbPropslAviation = tdoiDbPropslAviation;
	}

}