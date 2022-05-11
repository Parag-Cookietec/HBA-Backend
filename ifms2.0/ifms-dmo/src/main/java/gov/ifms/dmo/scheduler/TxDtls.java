package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TxDtls {

	@JsonProperty("Refs")
	private Refs refs = new Refs();

	@JsonProperty("RltdPties")
	private RltdPties rltdPties = new RltdPties();

	@JsonProperty("RltdAgts")
	private RltdAgts rltdAgts = new RltdAgts();

	@JsonProperty("AddtlTxInf")
	private String addtlTxInf = "";

	public Refs getRefs() {
		return refs;
	}

	public void setRefs(Refs refs) {
		this.refs = refs;
	}

	public RltdPties getRltdPties() {
		return rltdPties;
	}

	public void setRltdPties(RltdPties rltdPties) {
		this.rltdPties = rltdPties;
	}

	public RltdAgts getRltdAgts() {
		return rltdAgts;
	}

	public void setRltdAgts(RltdAgts rltdAgts) {
		this.rltdAgts = rltdAgts;
	}

	public String getAddtlTxInf() {
		return addtlTxInf;
	}

	public void setAddtlTxInf(String addtlTxInf) {
		this.addtlTxInf = addtlTxInf;
	}
	
}
