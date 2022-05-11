package gov.ifms.doi.ac.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

public class TdoiAcTeExpenditureDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long teExpenDtlId;

	private long edpCode;

	private double expenditureAmt;

	private String transFrmOrTo;

	private long transfrDtlId;

	public long getTeExpenDtlId() {
		return this.teExpenDtlId;
	}

	public void setTeExpenDtlId(long teExpenDtlId) {
		this.teExpenDtlId = teExpenDtlId;
	}

	public long getEdpCode() {
		return this.edpCode;
	}

	public void setEdpCode(long edpCode) {
		this.edpCode = edpCode;
	}

	public double getExpenditureAmt() {
		return this.expenditureAmt;
	}

	public void setExpenditureAmt(double expenditureAmt) {
		this.expenditureAmt = expenditureAmt;
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
