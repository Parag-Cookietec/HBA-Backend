package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Document {
	
	@JsonProperty("BkToCstmrStmt")
	private BkToCstmrStmt bkToCstmrStmt = new BkToCstmrStmt();
	
	public BkToCstmrStmt getBkToCstmrStmt() {
		return bkToCstmrStmt;
	}
	
	public void setBkToCstmrStmt(BkToCstmrStmt bkToCstmrStmt) {
		this.bkToCstmrStmt = bkToCstmrStmt;
	}

}
