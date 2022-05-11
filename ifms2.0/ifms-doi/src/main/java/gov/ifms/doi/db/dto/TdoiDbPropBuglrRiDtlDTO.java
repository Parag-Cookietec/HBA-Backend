package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_PROP_BUGLR_RI_DTL database table.
 * 
 */

public class TdoiDbPropBuglrRiDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long buglrRiDtlId;

	private double riAmount;

	private String riBrnchOffice;

	private String riCompName;

	private double riSharePerc;

	// bi-directional many-to-one association to TdoiDbPropslBurglary

	private TdoiDbPropslBurglaryDTO tdoiDbPropslBurglary;

	public TdoiDbPropBuglrRiDtlDTO() {
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

	public TdoiDbPropslBurglaryDTO getTdoiDbPropslBurglary() {
		return this.tdoiDbPropslBurglary;
	}

	public void setTdoiDbPropslBurglary(TdoiDbPropslBurglaryDTO tdoiDbPropslBurglary) {
		this.tdoiDbPropslBurglary = tdoiDbPropslBurglary;
	}

}
