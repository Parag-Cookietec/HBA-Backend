package gov.ifms.dmo.scheduler;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "RequestPayload")
public class DPDtlClearenceRequestPayload {
	
	@JsonProperty("AppHdr")
	@XmlElement
	private AppHdr appHdr = new AppHdr();

	@JsonProperty("Document")
	private Document document = new Document();

	public AppHdr getAppHdr() {
		return appHdr;
	}

	public void setAppHdr(AppHdr appHdr) {
		this.appHdr = appHdr;
	}
	
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	

}
