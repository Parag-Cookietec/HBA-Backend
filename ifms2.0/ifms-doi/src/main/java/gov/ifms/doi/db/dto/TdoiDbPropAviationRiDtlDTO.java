package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_PROP_AVIATION_RI_DTL database table.
 * 
 */

public class TdoiDbPropAviationRiDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long propAviatRiDtlId;

	private double riAmount;

	private String riBrnchOffice;

	private String riCompName;

	private double riSharePerc;

	// bi-directional many-to-one association to TdoiDbPropslAviation

	private TdoiDbPropslAviationDTO tdoiDbPropslAviation;

	public TdoiDbPropAviationRiDtlDTO() {
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

	public TdoiDbPropslAviationDTO getTdoiDbPropslAviation() {
		return this.tdoiDbPropslAviation;
	}

	public void setTdoiDbPropslAviation(TdoiDbPropslAviationDTO tdoiDbPropslAviation) {
		this.tdoiDbPropslAviation = tdoiDbPropslAviation;
	}

}
