package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_CLAIM_PROP_DTL database table.
 * 
 */

public class TdoiDbClaimPropDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long propDtlId;

	private double claimedAmount;

	private double itemActualValue;

	private String itemDesc;

	private short itemNumSrno;

	private String itemSrno;

	private double lossTimeValue;

	// bi-directional many-to-one association to TdoiDbClaimEntry

	private TdoiDbClaimEntryDTO tdoiDbClaimEntry;

	public TdoiDbClaimPropDtlDTO() {
	}

	public long getPropDtlId() {
		return this.propDtlId;
	}

	public void setPropDtlId(long propDtlId) {
		this.propDtlId = propDtlId;
	}

	public double getClaimedAmount() {
		return this.claimedAmount;
	}

	public void setClaimedAmount(double claimedAmount) {
		this.claimedAmount = claimedAmount;
	}

	public double getItemActualValue() {
		return this.itemActualValue;
	}

	public void setItemActualValue(double itemActualValue) {
		this.itemActualValue = itemActualValue;
	}

	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public short getItemNumSrno() {
		return this.itemNumSrno;
	}

	public void setItemNumSrno(short itemNumSrno) {
		this.itemNumSrno = itemNumSrno;
	}

	public String getItemSrno() {
		return this.itemSrno;
	}

	public void setItemSrno(String itemSrno) {
		this.itemSrno = itemSrno;
	}

	public double getLossTimeValue() {
		return this.lossTimeValue;
	}

	public void setLossTimeValue(double lossTimeValue) {
		this.lossTimeValue = lossTimeValue;
	}

	public TdoiDbClaimEntryDTO getTdoiDbClaimEntry() {
		return this.tdoiDbClaimEntry;
	}

	public void setTdoiDbClaimEntry(TdoiDbClaimEntryDTO tdoiDbClaimEntry) {
		this.tdoiDbClaimEntry = tdoiDbClaimEntry;
	}

}
