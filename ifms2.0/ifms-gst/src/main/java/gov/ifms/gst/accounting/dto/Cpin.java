package gov.ifms.gst.accounting.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Cpin {
	
	@JsonProperty("otc")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	  private List<Otc> otc = null;
	
	@JsonProperty("epy")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	  private List<Epy> epy = null;
	
	@JsonProperty("ner")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	  private List<Ner> ner = null;

	public List<Otc> getOtc() {
		return otc;
	}

	public void setOtc(List<Otc> otc) {
		this.otc = otc;
	}

	public List<Epy> getEpy() {
		return epy;
	}

	public void setEpy(List<Epy> epy) {
		this.epy = epy;
	}

	public List<Ner> getNer() {
		return ner;
	}

	public void setNer(List<Ner> ner) {
		this.ner = ner;
	}

}
