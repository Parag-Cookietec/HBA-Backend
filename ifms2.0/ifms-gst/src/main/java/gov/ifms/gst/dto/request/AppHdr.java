package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppHdr {
	
	@JsonProperty("Fr")
	private Fr fr = new Fr();

	
	@JsonProperty("To")
	private AppHdrTo to = new AppHdrTo();
	
	@JsonProperty("BizMsgIdr")
	private String bizMsgIdr  = "AS010400158560103720191217269404";
	
	
	@JsonProperty("MsgDefIdr")
	private String msgDefIdr  = "camt.053.001.06";
	
	@JsonProperty("BizSvc")
	private String bizSvc  = "BankToCustomerStatementV06";
	
	@JsonProperty("CreDt")
	private String creDt  = "2019-12-18T00:12:05";

	
	
	public String getBizMsgIdr() {
		return bizMsgIdr;
	}

	public void setBizMsgIdr(String bizMsgIdr) {
		this.bizMsgIdr = bizMsgIdr;
	}

	public String getMsgDefIdr() {
		return msgDefIdr;
	}

	public void setMsgDefIdr(String msgDefIdr) {
		this.msgDefIdr = msgDefIdr;
	}

	public String getBizSvc() {
		return bizSvc;
	}

	public void setBizSvc(String bizSvc) {
		this.bizSvc = bizSvc;
	}

	public String getCreDt() {
		return creDt;
	}

	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	public AppHdrTo getTo() {
		return to;
	}

	public void setTo(AppHdrTo to) {
		this.to = to;
	}

	public Fr getFr() {
		return fr;
	}

	public void setFr(Fr fr) {
		this.fr = fr;
	}

}
