package gov.ifms.gst.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Stmt {
	
	@JsonProperty("Id")
	private long id;
	
	@JsonProperty("StmtPgntn")
	private StmtPgntn stmtPgntn = new StmtPgntn();
	
	@JsonProperty("CreDtTm")
	private LocalDateTime creDtTm;  
	
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
	//@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<Ntry> ntry = new ArrayList<>();

	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public StmtPgntn getStmtPgntn() {
		return stmtPgntn;
	}

	public void setStmtPgntn(StmtPgntn stmtPgntn) {
		this.stmtPgntn = stmtPgntn;
	}

	public LocalDateTime getCreDtTm() {
		return creDtTm;
	}

	public void setCreDtTm(LocalDateTime creDtTm) {
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

	public List<Bal> getBal() {
		
		bal.add(new Bal());
		bal.add(new Bal());
		return bal;
	}

	public void setBal(List<Bal> bal) {
		this.bal = bal;
	}

	public TxsSummry getTxsSummry() {
		return txsSummry;
	}

	public void setTxsSummry(TxsSummry txsSummry) {
		this.txsSummry = txsSummry;
	}

	public List<Ntry> getNtry() {
		
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		ntry.add(new Ntry());
		
		return ntry;
	}

	public void setNtry(List<Ntry> ntry) {
		this.ntry = ntry;
	}

	
	
	

	
	
	

}
