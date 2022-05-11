package gov.ifms.dmo.dto;
import java.io.Serializable;
import java.util.List;


public class DMODPSMainTransactionDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * The Transaction Type ID
     */
	private Long id;
	
	/**
     * The Transaction Type.
     */
	private String transactionType;
	 
	/**
	 * Lists of transactions subType
	 */
	private List<DMODPSTransactionDto> transactionSubType;
	
	public DMODPSMainTransactionDto() {}
	
	public DMODPSMainTransactionDto(Long id, String transactionType) {
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

	public List<DMODPSTransactionDto> getTransactionSubType() {
		return transactionSubType;
	}

	public void setTransactionSubType(List<DMODPSTransactionDto> transactionSubType) {
		this.transactionSubType = transactionSubType;
	}
	

}
