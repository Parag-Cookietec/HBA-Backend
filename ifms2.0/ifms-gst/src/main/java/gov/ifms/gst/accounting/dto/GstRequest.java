package gov.ifms.gst.accounting.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GstRequest {
	
	@JsonProperty("type")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<Object> type = null;
	
	@JsonProperty("name")
	private String name = null;
	
	@JsonProperty("namespace")
	private String namespace = null;
	
	@JsonProperty("doc")
	private String doc = null;
	
	@JsonProperty("default")
	private String mdefault = null;
	
	@JsonProperty("fields")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<GstRequest> fields = null;

	public List<Object> getType() {
		return type;
	}

	public void setType(List<Object> type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	
	public List<GstRequest> getFields() {
		return fields;
	}

	public void setFields(List<GstRequest> fields) {
		this.fields = fields;
	}

	public String getMdefault() {
		return mdefault;
	}

	public void setMdefault(String mdefault) {
		this.mdefault = mdefault;
	}

	
	
	

}
