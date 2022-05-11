package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bal {

	@JsonProperty("Tp")
	private Tp tp = new Tp();
	
	@JsonProperty("Amt")
	private Amount amount  = new Amount();
	
	@JsonProperty("CdtDbtInd")
	private String cdtDbtInd = "CRDT1";
	
	@JsonProperty("Dt")
	private Dt dt = new Dt();

	public Tp getTp() {
		return tp;
	}

	public void setTp(Tp tp) {
		this.tp = tp;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public String getCdtDbtInd() {
		return cdtDbtInd;
	}

	public void setCdtDbtInd(String cdtDbtInd) {
		this.cdtDbtInd = cdtDbtInd;
	}

	public Dt getDt() {
		return dt;
	}

	public void setDt(Dt dt) {
		this.dt = dt;
	}

	
}
