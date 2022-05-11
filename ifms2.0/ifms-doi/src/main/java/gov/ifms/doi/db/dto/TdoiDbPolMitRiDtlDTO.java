package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_POL_MIT_RI_DTL database table.
 * 
 */

public class TdoiDbPolMitRiDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long polMitRiDtlId;

	private double riAmount;

	private String riBrnchOffice;

	private String riCompName;

	private double riSharePerc;

	// bi-directional many-to-one association to TdoiDbPolMoneyIntransit

	private TdoiDbPolMoneyIntransitDTO tdoiDbPolMoneyIntransit;

	public TdoiDbPolMitRiDtlDTO() {
	}

	public long getPolMitRiDtlId() {
		return this.polMitRiDtlId;
	}

	public void setPolMitRiDtlId(long polMitRiDtlId) {
		this.polMitRiDtlId = polMitRiDtlId;
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

	public TdoiDbPolMoneyIntransitDTO getTdoiDbPolMoneyIntransit() {
		return this.tdoiDbPolMoneyIntransit;
	}

	public void setTdoiDbPolMoneyIntransit(TdoiDbPolMoneyIntransitDTO tdoiDbPolMoneyIntransit) {
		this.tdoiDbPolMoneyIntransit = tdoiDbPolMoneyIntransit;
	}

}
