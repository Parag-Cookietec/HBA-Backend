package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_POL_BUGLR_RI_DTL database table.
 * 
 */

public class TdoiDbPolBuglrRiDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long buglrRiDtlId;

	private double riAmount;

	private String riBrnchOffice;

	private String riCompName;

	private double riSharePerc;

	// bi-directional many-to-one association to TdoiDbPolBurglary

	private TdoiDbPolBurglaryDTO tdoiDbPolBurglary;

	public TdoiDbPolBuglrRiDtlDTO() {
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

	public TdoiDbPolBurglaryDTO getTdoiDbPolBurglary() {
		return this.tdoiDbPolBurglary;
	}

	public void setTdoiDbPolBurglary(TdoiDbPolBurglaryDTO tdoiDbPolBurglary) {
		this.tdoiDbPolBurglary = tdoiDbPolBurglary;
	}

}
