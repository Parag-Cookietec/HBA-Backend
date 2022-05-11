package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RltdAgts {
	
	@JsonProperty("DbtrAgt")
	private DbtrAgt dbtrAgt = new DbtrAgt();

	public DbtrAgt getDbtrAgt() {
		return dbtrAgt;
	}

	public void setDbtrAgt(DbtrAgt dbtrAgt) {
		this.dbtrAgt = dbtrAgt;
	}

}
