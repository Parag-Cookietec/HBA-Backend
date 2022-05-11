package gov.ifms.gst.dto;

public class CreditHeadDto {
	private String description;
	private short noOfTransaction;
	private Double amount;
	private String creditHead;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public short getNoOfTransaction() {
		return noOfTransaction;
	}
	public void setNoOfTransaction(short noOfTransaction) {
		this.noOfTransaction = noOfTransaction;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getCreditHead() {
		return creditHead;
	}
	public void setCreditHead(String creditHead) {
		this.creditHead = creditHead;
	}
	
}
