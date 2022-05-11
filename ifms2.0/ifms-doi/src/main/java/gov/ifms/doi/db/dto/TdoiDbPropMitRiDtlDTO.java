package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_PROP_MIT_RI_DTL database table.
 * 
 */

public class TdoiDbPropMitRiDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long propMitRiDtlId;

	private double riAmount;

	private String riBrnchOffice;

	private String riCompName;

	private double riSharePerc;

	// bi-directional many-to-one association to TdoiDbPropMoneyIntransit

	private TdoiDbPropMoneyIntransitDTO tdoiDbPropMoneyIntransit;

	public TdoiDbPropMitRiDtlDTO() {
	}

	public long getPropMitRiDtlId() {
		return this.propMitRiDtlId;
	}

	public void setPropMitRiDtlId(long propMitRiDtlId) {
		this.propMitRiDtlId = propMitRiDtlId;
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

	public TdoiDbPropMoneyIntransitDTO getTdoiDbPropMoneyIntransit() {
		return this.tdoiDbPropMoneyIntransit;
	}

	public void setTdoiDbPropMoneyIntransit(TdoiDbPropMoneyIntransitDTO tdoiDbPropMoneyIntransit) {
		this.tdoiDbPropMoneyIntransit = tdoiDbPropMoneyIntransit;
	}

}
