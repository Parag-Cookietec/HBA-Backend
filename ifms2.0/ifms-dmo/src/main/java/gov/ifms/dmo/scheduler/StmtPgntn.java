package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StmtPgntn {
	
	@JsonProperty("PgNb")
	private String pgNb  = "1";
	
	@JsonProperty("LastPgInd")
	private String lastPgInd  = "true";

	public String getPgNb() {
		return pgNb;
	}

	public void setPgNb(String pgNb) {
		this.pgNb = pgNb;
	}

	public String getLastPgInd() {
		return lastPgInd;
	}

	public void setLastPgInd(String lastPgInd) {
		this.lastPgInd = lastPgInd;
	}

}
