package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_PROP_MIT_INSURANCE database table.
 * 
 */

public class TdoiDbPropMitInsuranceDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long propMitInsuranceId;

	private double gifLiabLmtDurYr;

	private double gifLiabilityLmt;

	private String propertyInsurance;

	private double transAmtDurYr;

	// bi-directional many-to-one association to TdoiDbPropMoneyIntransit

	private TdoiDbPropMoneyIntransitDTO tdoiDbPropMoneyIntransit;

	public TdoiDbPropMitInsuranceDTO() {
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

	public TdoiDbPropMoneyIntransitDTO getTdoiDbPropMoneyIntransit() {
		return this.tdoiDbPropMoneyIntransit;
	}

	public void setTdoiDbPropMoneyIntransit(TdoiDbPropMoneyIntransitDTO tdoiDbPropMoneyIntransit) {
		this.tdoiDbPropMoneyIntransit = tdoiDbPropMoneyIntransit;
	}

}
