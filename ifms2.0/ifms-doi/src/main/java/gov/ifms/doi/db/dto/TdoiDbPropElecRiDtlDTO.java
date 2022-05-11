package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_PROP_ELEC_RI_DTL database table.
 * 
 */

public class TdoiDbPropElecRiDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long elecRiDtlId;

	private double riAmount;

	private String riBrnchOffice;

	private String riCompName;

	private double riSharePerc;

	// bi-directional many-to-one association to TdoiDbPropslElecEquip

	private TdoiDbPropslElecEquipDTO tdoiDbPropslElecEquip;

	public TdoiDbPropElecRiDtlDTO() {
	}

	public long getElecRiDtlId() {
		return this.elecRiDtlId;
	}

	public void setElecRiDtlId(long elecRiDtlId) {
		this.elecRiDtlId = elecRiDtlId;
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

	public TdoiDbPropslElecEquipDTO getTdoiDbPropslElecEquip() {
		return this.tdoiDbPropslElecEquip;
	}

	public void setTdoiDbPropslElecEquip(TdoiDbPropslElecEquipDTO tdoiDbPropslElecEquip) {
		this.tdoiDbPropslElecEquip = tdoiDbPropslElecEquip;
	}

}
