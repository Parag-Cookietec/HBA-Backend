package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the MDOI_DB_FIRE_SUM_INSR_MST database table.
 * 
 */

public class MdoiDbFireSumInsrMstDTO extends BaseDto {
	private static final long serialVersionUID = 1L;
	private long riskCoverId;

	private String riskCoverType;

	public long getRiskCoverId() {
		return this.riskCoverId;
	}

	public void setRiskCoverId(long riskCoverId) {
		this.riskCoverId = riskCoverId;
	}

	public String getRiskCoverType() {
		return this.riskCoverType;
	}

	public void setRiskCoverType(String riskCoverType) {
		this.riskCoverType = riskCoverType;
	}

}
