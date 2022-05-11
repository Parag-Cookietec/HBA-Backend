package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Amount {
	
	@JacksonXmlProperty(isAttribute = true , localName = "Ccy")
	private String ccy  = "INR";
	
	@JacksonXmlText
	private Double value  = 3957890131.00;

	
	public Double getValue() {
		return value;	
		
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

}
