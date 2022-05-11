package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TtlDbtNtries {
	
	@JsonProperty("NbOfNtries")
	private String nbOfNtries  = "0";
	
	@JsonProperty("Sum")
	private String sum  = "0.00";

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
