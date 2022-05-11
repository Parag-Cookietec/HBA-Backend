package gov.ifms.gst.dto;

public class Dtos {
	private String description;
	private short noOfTransaction;
	private Double amount;
	private String debitedHead;

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

	public String getDebitedHead() {
		return debitedHead;
	}

	public void setDebitedHead(String debitedHead) {
		this.debitedHead = debitedHead;
	}

}
