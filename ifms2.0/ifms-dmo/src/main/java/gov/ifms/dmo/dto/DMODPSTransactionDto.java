package gov.ifms.dmo.dto;
import java.io.Serializable;

public class DMODPSTransactionDto implements Serializable{


	private static final long serialVersionUID = 1L;
	
	/**
     * The Transaction Type ID
     */
	private Long id;
	
	/**
     * The Transaction Type.
     */
	private String transactionType;
	

	public DMODPSTransactionDto() {
		super();
	}

	public DMODPSTransactionDto(Long id, String transactionType) {
		super();
		this.id = id;
		this.transactionType = transactionType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	
}
