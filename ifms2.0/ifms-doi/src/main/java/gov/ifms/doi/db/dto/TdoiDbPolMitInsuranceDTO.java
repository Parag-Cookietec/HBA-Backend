package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_POL_MIT_INSURANCE database table.
 * 
 */

public class TdoiDbPolMitInsuranceDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long polMitInsuranceId;

	private double gifLiabLmtDurYr;

	private double gifLiabilityLmt;

	private String propertyInsurance;

	private double transAmtDurYr;

	// bi-directional many-to-one association to TdoiDbPolMoneyIntransit

	private TdoiDbPolMoneyIntransitDTO tdoiDbPolMoneyIntransit;

	public TdoiDbPolMitInsuranceDTO() {
	}

	public long getPolMitInsuranceId() {
		return this.polMitInsuranceId;
	}

	public void setPolMitInsuranceId(long polMitInsuranceId) {
		this.polMitInsuranceId = polMitInsuranceId;
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

	public TdoiDbPolMoneyIntransitDTO getTdoiDbPolMoneyIntransit() {
		return this.tdoiDbPolMoneyIntransit;
	}

	public void setTdoiDbPolMoneyIntransit(TdoiDbPolMoneyIntransitDTO tdoiDbPolMoneyIntransit) {
		this.tdoiDbPolMoneyIntransit = tdoiDbPolMoneyIntransit;
	}

}
