package gov.ifms.doi.ac.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

public class TdoiAcTeRecoveryDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long teRecoveryDtlId;

	private long edpCode;

	private double recoveryAmt;

	private String transFrmOrTo;

	private long transfrDtlId;

	public long getTeRecoveryDtlId() {
		return this.teRecoveryDtlId;
	}

	public void setTeRecoveryDtlId(long teRecoveryDtlId) {
		this.teRecoveryDtlId = teRecoveryDtlId;
	}

	public long getEdpCode() {
		return this.edpCode;
	}

	public void setEdpCode(long edpCode) {
		this.edpCode = edpCode;
	}

	public double getRecoveryAmt() {
		return this.recoveryAmt;
	}

	public void setRecoveryAmt(double recoveryAmt) {
		this.recoveryAmt = recoveryAmt;
	}

	public String getTransFrmOrTo() {
		return this.transFrmOrTo;
	}

	public void setTransFrmOrTo(String transFrmOrTo) {
		this.transFrmOrTo = transFrmOrTo;
	}

	public long getTransfrDtlId() {
		return this.transfrDtlId;
	}

	public void setTransfrDtlId(long transfrDtlId) {
		this.transfrDtlId = transfrDtlId;
	}

}
