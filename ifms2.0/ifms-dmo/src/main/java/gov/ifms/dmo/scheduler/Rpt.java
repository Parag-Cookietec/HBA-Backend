package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rpt {
	
	@JsonProperty("Id")
	private String id;
	
	@JsonProperty("CreDtTm")
	private String creDtTm;  
	
	@JsonProperty("FrToDt")
	private FrToDt frToDt = new FrToDt();
	
	@JsonProperty("TxsSummry")
	private TxsSummry txsSummry = new TxsSummry();

//	@JsonProperty("AddtlNtryInf")
//	private TxsSummry addtlNtryInf = new TxsSummry();
//	
//	@JsonProperty("AddtlRptInf")
//	private TxsSummry addtlRptInf = new TxsSummry();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreDtTm() {
		return creDtTm;
	}

	public void setCreDtTm(String creDtTm) {
		this.creDtTm = creDtTm;
	}

	public FrToDt getFrToDt() {
		return frToDt;
	}

	public void setFrToDt(FrToDt frToDt) {
		this.frToDt = frToDt;
	}

	public TxsSummry getTxsSummry() {
		return txsSummry;
	}

	public void setTxsSummry(TxsSummry txsSummry) {
		this.txsSummry = txsSummry;
	}

//	public TxsSummry getAddtlNtryInf() {
//		return addtlNtryInf;
//	}
//
//	public void setAddtlNtryInf(TxsSummry addtlNtryInf) {
//		this.addtlNtryInf = addtlNtryInf;
//	}
//
//	public TxsSummry getAddtlRptInf() {
//		return addtlRptInf;
//	}
//
//	public void setAddtlRptInf(TxsSummry addtlRptInf) {
//		this.addtlRptInf = addtlRptInf;
//	}

}
