package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Strd {
	
	@JsonProperty("RfrdDocInf")
	private RfrdDocInf dbtrAgt = new RfrdDocInf();

	public RfrdDocInf getDbtrAgt() {
		return dbtrAgt;
	}

	public void setDbtrAgt(RfrdDocInf dbtrAgt) {
		this.dbtrAgt = dbtrAgt;
	}

}
