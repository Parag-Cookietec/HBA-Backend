package gov.ifms.gst.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class RBIAccHdrDto {

	private long id;
	private String cinNo;
	private String referenceNo;
	private LocalDateTime referenceDt;
	private Date govtCreditDt;
	private Double creditAmount;
	private String scrollNo;
	private LocalDateTime scrollDt;
	private char isEntryMatched;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public LocalDateTime getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(LocalDateTime referenceDt) {
		this.referenceDt = referenceDt;
	}

	public Date getGovtCreditDt() {
		return govtCreditDt;
	}

	public void setGovtCreditDt(Date govtCreditDt) {
		this.govtCreditDt = govtCreditDt;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getScrollNo() {
		return scrollNo;
	}

	public void setScrollNo(String scrollNo) {
		this.scrollNo = scrollNo;
	}

	public LocalDateTime getScrollDt() {
		return scrollDt;
	}

	public void setScrollDt(LocalDateTime scrollDt) {
		this.scrollDt = scrollDt;
	}

	public char getIsEntryMatched() {
		return isEntryMatched;
	}

	public void setIsEntryMatched(char isEntryMatched) {
		this.isEntryMatched = isEntryMatched;
	}

}
