package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_POL_AVIATION_RI_DTL database table.
 * 
 */

public class TdoiDbPolAviationRiDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long polAviatRiDtlId;

	private double riAmount;

	private String riBrnchOffice;

	private String riCompName;

	private double riSharePerc;

	// bi-directional many-to-one association to TdoiDbPolAviation

	private TdoiDbPolAviationDTO tdoiDbPolAviation;

	public TdoiDbPolAviationRiDtlDTO() {
	}

	public long getPolAviatRiDtlId() {
		return this.polAviatRiDtlId;
	}

	public void setPolAviatRiDtlId(long polAviatRiDtlId) {
		this.polAviatRiDtlId = polAviatRiDtlId;
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

	public TdoiDbPolAviationDTO getTdoiDbPolAviation() {
		return this.tdoiDbPolAviation;
	}

	public void setTdoiDbPolAviation(TdoiDbPolAviationDTO tdoiDbPolAviation) {
		this.tdoiDbPolAviation = tdoiDbPolAviation;
	}

}
