package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BkToCstmrStmt {
	
	@JsonProperty("GrpHdr")
	private GrpHdr grpHdr = new GrpHdr();
	
	@JsonProperty("Stmt")
	private Stmt stmt = new Stmt();
	
	public GrpHdr getGrpHdr() {
		return grpHdr;
	}

	public void setGrpHdr(GrpHdr grpHdr) {
		this.grpHdr = grpHdr;
	}
	
	public Stmt getStmt() {
		return stmt;
	}

	public void setStmt(Stmt stmt) {
		this.stmt = stmt;
	}
	
}
