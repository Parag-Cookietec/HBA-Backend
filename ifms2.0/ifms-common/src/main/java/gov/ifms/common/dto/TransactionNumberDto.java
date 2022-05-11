package gov.ifms.common.dto;

import java.io.Serializable;

public class TransactionNumberDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String transactionNumber;

	public TransactionNumberDto() {
		super();
	}

	public TransactionNumberDto(String transactionNumber) {
		super();
		this.transactionNumber = transactionNumber;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

}
