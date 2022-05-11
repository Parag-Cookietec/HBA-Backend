package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_POL_FIRE_RI_DTL database table.
 * 
 */

public class TdoiDbPolFireRiDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long polFireRiDtlId;

	private double riAmount;

	private String riBrnchOffice;

	private String riCompName;

	private double riSharePerc;

	// bi-directional many-to-one association to TdoiDbPolFirePeril

	private TdoiDbPolFirePerilDTO tdoiDbPolFirePeril;

	public TdoiDbPolFireRiDtlDTO() {
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

	public TdoiDbPolFirePerilDTO getTdoiDbPolFirePeril() {
		return this.tdoiDbPolFirePeril;
	}

	public void setTdoiDbPolFirePeril(TdoiDbPolFirePerilDTO tdoiDbPolFirePeril) {
		this.tdoiDbPolFirePeril = tdoiDbPolFirePeril;
	}

}
