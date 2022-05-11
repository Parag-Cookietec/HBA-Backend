package gov.ifms.dmo.scheduler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ntry {

	@JsonProperty("NtryRef")
	private String ntryRef  = "";
	
	@JsonProperty("Amt")
	private Amount amount = new Amount();
	
	@JsonProperty("CdtDbtInd")
	private String cdtDbtInd ;
	
	@JsonProperty("RvslInd")
	private boolean rvslInd  = false;
	
	@JsonProperty("Sts")
	private String sts  = "BOOK";
	
	@JsonProperty("BookgDt")
	private BookingDt bookgDt = new BookingDt();
	
	@JsonProperty("ValDt")
	private ValDt valDt = new ValDt();
	
	@JsonProperty("BkTxCd")
	private BkTxCd bkTxCd = new BkTxCd();

	@JsonProperty("NtryDtls")
	private NtryDtls ntryDtls = new NtryDtls();

	public String getNtryRef() {
		return ntryRef;
	}

	public void setNtryRef(String ntryRef) {
		this.ntryRef = ntryRef;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public String getCdtDbtInd() {
		return cdtDbtInd;
	}

	public void setCdtDbtInd(String cdtDbtInd) {
		this.cdtDbtInd = cdtDbtInd;
	}

	public boolean isRvslInd() {
		return rvslInd;
	}

	public void setRvslInd(boolean rvslInd) {
		this.rvslInd = rvslInd;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public BookingDt getBookgDt() {
		return bookgDt;
	}

	public void setBookgDt(BookingDt bookgDt) {
		this.bookgDt = bookgDt;
	}

	public ValDt getValDt() {
		return valDt;
	}

	public void setValDt(ValDt valDt) {
		this.valDt = valDt;
	}

	public BkTxCd getBkTxCd() {
		return bkTxCd;
	}

	public void setBkTxCd(BkTxCd bkTxCd) {
		this.bkTxCd = bkTxCd;
	}

	public NtryDtls getNtryDtls() {
		return ntryDtls;
	}

	public void setNtryDtls(NtryDtls ntryDtls) {
		this.ntryDtls = ntryDtls;
	}

}
