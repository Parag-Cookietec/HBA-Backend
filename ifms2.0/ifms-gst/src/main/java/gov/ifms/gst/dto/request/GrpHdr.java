package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GrpHdr {
	
	
	@JsonProperty("MsgId")
	private String msgId  = "AS010400158560103720191217269404";
	
	@JsonProperty("CreDtTm")
	private String creDtTm  = "2019-12-18T00:12:05";

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getCreDtTm() {
		return creDtTm;
	}

	public void setCreDtTm(String creDtTm) {
		this.creDtTm = creDtTm;
	}
}
