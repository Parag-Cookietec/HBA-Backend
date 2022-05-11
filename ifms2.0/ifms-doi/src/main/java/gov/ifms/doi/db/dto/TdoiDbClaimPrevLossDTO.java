package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_CLAIM_PREV_LOSS database table.
 * 
 */

public class TdoiDbClaimPrevLossDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long prevLossId;

	private double claimAmount;

	private String claimDesc;

	private long claimYearId;

	private short lossSrno;

	// bi-directional many-to-one association to TdoiDbClaimEntry

	private TdoiDbClaimEntryDTO tdoiDbClaimEntry;

	public TdoiDbClaimPrevLossDTO() {
	}

	public long getPrevLossId() {
		return this.prevLossId;
	}

	public void setPrevLossId(long prevLossId) {
		this.prevLossId = prevLossId;
	}

	public double getClaimAmount() {
		return this.claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getClaimDesc() {
		return this.claimDesc;
	}

	public void setClaimDesc(String claimDesc) {
		this.claimDesc = claimDesc;
	}

	public long getClaimYearId() {
		return this.claimYearId;
	}

	public void setClaimYearId(long claimYearId) {
		this.claimYearId = claimYearId;
	}

	public short getLossSrno() {
		return this.lossSrno;
	}

	public void setLossSrno(short lossSrno) {
		this.lossSrno = lossSrno;
	}

	public TdoiDbClaimEntryDTO getTdoiDbClaimEntry() {
		return this.tdoiDbClaimEntry;
	}

	public void setTdoiDbClaimEntry(TdoiDbClaimEntryDTO tdoiDbClaimEntry) {
		this.tdoiDbClaimEntry = tdoiDbClaimEntry;
	}

}
