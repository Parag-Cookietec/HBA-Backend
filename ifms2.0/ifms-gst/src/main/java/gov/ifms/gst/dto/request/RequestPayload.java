package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RequestPayload")
public class RequestPayload {
	
	@JsonProperty("AppHdr")
	@XmlElement
	private AppHdr appHdr = new AppHdr();

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
	@JsonProperty("Document")
	private Document document = new Document();
	

}
