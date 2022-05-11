package gov.ifms.gst.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class GSTPenalInterestListingDto  implements Serializable{
 
	private static final long serialVersionUID = 2L;

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public LocalDate getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(LocalDate referenceDate) {
		this.referenceDate = referenceDate;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public int getActiveStatusId() {
		return activeStatusId;
	}

	public void setActiveStatusId(int activeStatusId) {
		this.activeStatusId = activeStatusId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}
 
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/** The referenceNumber. */
	private String referenceNumber;

	/** The referenceDate. */
	private LocalDate referenceDate;

	/** The activeStatus. */
	private String  activeStatus;
	
	/** The activeStatusId. */
	private int activeStatusId; 
	
	/** The id. */
	private long id;

	/** The bankId. */
	private long bankId;

	public String getModeOfReceipt() {
		return modeOfReceipt;
	}

	public void setModeOfReceipt(String modeOfReceipt) {
		this.modeOfReceipt = modeOfReceipt;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getModeOfReceiptId() {
		return modeOfReceiptId;
	}

	public void setModeOfReceiptId(long modeOfReceiptId) {
		this.modeOfReceiptId = modeOfReceiptId;
	}

	/** The modeOfReceipt. */
	private String modeOfReceipt;

	/** The bankName. */
	private String bankName;
	
	/** The modeOfReceiptId */
	private long modeOfReceiptId;

	/** The Amount. */
	private Double amount;
	
	
	
	
	
	

	
}
