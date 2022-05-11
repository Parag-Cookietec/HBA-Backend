package gov.ifms.gst.accounting.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Cin {
	
	
	@JsonProperty("otc")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	 private List<CinOtc> otc;
	
	
	@JsonProperty("epy")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<CinEpy> epy;
	
	@JsonProperty("ner")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<CinNer> ner;

	public List<CinOtc> getOtc() {
		return otc;
	}

	public void setOtc(List<CinOtc> otc) {
		this.otc = otc;
	}

	public List<CinEpy> getEpy() {
		return epy;
	}

	public void setEpy(List<CinEpy> epy) {
		this.epy = epy;
	}

	public List<CinNer> getNer() {
		return ner;
	}

	public void setNer(List<CinNer> ner) {
		this.ner = ner;
	}

}
