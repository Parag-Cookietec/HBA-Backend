package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotCdtEntryNo {

	@JsonProperty("NbOfNtries")
	private String nbOfNtries  = "67";
	
	@JsonProperty("Sum")
	private String sum  = "964292612.00";

	public String getNbOfNtries() {
		return nbOfNtries;
	}

	public void setNbOfNtries(String nbOfNtries) {
		this.nbOfNtries = nbOfNtries;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	
}
