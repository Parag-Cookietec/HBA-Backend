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
 * The persistent class for the TDOI_DB_PROP_MIT_INSURANCE database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_PROP_MIT_INSURANCE", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPropMitInsuranceEntity.findAll", query = "SELECT t FROM TdoiDbPropMitInsuranceEntity t")
public class TdoiDbPropMitInsuranceEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROP_MIT_INSURANCE_ID", unique = true, nullable = false)
	private long propMitInsuranceId;

	@Column(name = "GIF_LIAB_LMT_DUR_YR")
	private double gifLiabLmtDurYr;

	@Column(name = "GIF_LIABILITY_LMT")
	private double gifLiabilityLmt;

	@Column(name = "PROPERTY_INSURANCE", length = 100)
	private String propertyInsurance;

	@Column(name = "TRANS_AMT_DUR_YR")
	private double transAmtDurYr;

	// bi-directional many-to-one association to TdoiDbPropMoneyIntransit
	@ManyToOne
	@JoinColumn(name = "PROP_MONEY_INTRANS_ID", nullable = false)
	private TdoiDbPropMoneyIntransitEntity tdoiDbPropMoneyIntransit;

	public TdoiDbPropMitInsuranceEntity() {
	}

	public long getPropMitInsuranceId() {
		return this.propMitInsuranceId;
	}

	public void setPropMitInsuranceId(long propMitInsuranceId) {
		this.propMitInsuranceId = propMitInsuranceId;
	}

	public double getGifLiabLmtDurYr() {
		return this.gifLiabLmtDurYr;
	}

	public void setGifLiabLmtDurYr(double gifLiabLmtDurYr) {
		this.gifLiabLmtDurYr = gifLiabLmtDurYr;
	}

	public double getGifLiabilityLmt() {
		return this.gifLiabilityLmt;
	}

	public void setGifLiabilityLmt(double gifLiabilityLmt) {
		this.gifLiabilityLmt = gifLiabilityLmt;
	}

	public String getPropertyInsurance() {
		return this.propertyInsurance;
	}

	public void setPropertyInsurance(String propertyInsurance) {
		this.propertyInsurance = propertyInsurance;
	}

	public double getTransAmtDurYr() {
		return this.transAmtDurYr;
	}

	public void setTransAmtDurYr(double transAmtDurYr) {
		this.transAmtDurYr = transAmtDurYr;
	}

	public TdoiDbPropMoneyIntransitEntity getTdoiDbPropMoneyIntransit() {
		return this.tdoiDbPropMoneyIntransit;
	}

	public void setTdoiDbPropMoneyIntransit(TdoiDbPropMoneyIntransitEntity tdoiDbPropMoneyIntransit) {
		this.tdoiDbPropMoneyIntransit = tdoiDbPropMoneyIntransit;
	}

}