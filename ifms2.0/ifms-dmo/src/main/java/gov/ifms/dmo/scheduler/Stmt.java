package gov.ifms.dmo.scheduler;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class Stmt {
	
	@JsonProperty("Id")
	private String id;
	
	@JsonProperty("StmtPgntn")
	private StmtPgntn stmtPgntn = new StmtPgntn();
	
	@JsonProperty("CreDtTm")
	private String creDtTm;  
	
	@JsonProperty("FrToDt")
	private FrToDt frToDt = new FrToDt();
	
	
	@JsonProperty("Acct")
	private Acct acct = new Acct();
	
	@JsonProperty("Bal")
	@JacksonXmlElementWrapper(useWrapping=false)
	private List<Bal> bal = new ArrayList<>();
	
	
	@JsonProperty("TxsSummry")
	private TxsSummry txsSummry = new TxsSummry();
	
	@JsonProperty("Ntry")
	@JacksonXmlElementWrapper(useWrapping=false)
	private List<Ntry> ntry = new ArrayList<>();

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StmtPgntn getStmtPgntn() {
		return stmtPgntn;
	}

	public void setStmtPgntn(StmtPgntn stmtPgntn) {
		this.stmtPgntn = stmtPgntn;
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

	public Acct getAcct() {
		return acct;
	}

	public void setAcct(Acct acct) {
		this.acct = acct;
	}

	public TxsSummry getTxsSummry() {
		return txsSummry;
	}

	public void setTxsSummry(TxsSummry txsSummry) {
		this.txsSummry = txsSummry;
	}

	public List<Bal> getBal() {
		return bal;
	}

	public void setBal(List<Bal> bal) {
		this.bal = bal;
	}

	public List<Ntry> getNtry() {
		return ntry;
	}

	public void setNtry(List<Ntry> ntry) {
		this.ntry = ntry;
	}

}
