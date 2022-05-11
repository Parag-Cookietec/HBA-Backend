package gov.ifms.gst.workflow.dto;


import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class GstReportDtlsManualAccountingDto.
 *
 * @version 1.0
 * @created 2022/01/09 17:21:07
 *
 */
public class GstReportDtlsManualAccountingDto {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/**
	 * Instantiates a new gst report dtls manual accounting dto.
	 */
	public GstReportDtlsManualAccountingDto() {
		super();
	}

	@NativeQueryResultColumn(index = 0)
	private String transactionReferenceNumber;
	@NativeQueryResultColumn(index = 1)
	private String cin;
	@NativeQueryResultColumn(index = 2)
	private String debitHead;
	@NativeQueryResultColumn(index = 3)
	private String creditHead;
	@NativeQueryResultColumn(index = 4)
	private Double amount;
	@NativeQueryResultColumn(index = 5)
	private String type;
	@NativeQueryResultColumn(index = 6)
	private String status;


	public GstReportDtlsManualAccountingDto(String transactionReferenceNumber, String cin, String debitHead,
			String creditHead, Double amount, String type, String status) {
		super();
		this.transactionReferenceNumber = transactionReferenceNumber;
		this.cin = cin;
		this.debitHead = debitHead;
		this.creditHead = creditHead;
		this.amount = amount;
		this.type = type;
		this.status = status;
	}


	public String getTransactionReferenceNumber() {
		return transactionReferenceNumber;
	}


	public void setTransactionReferenceNumber(String transactionReferenceNumber) {
		this.transactionReferenceNumber = transactionReferenceNumber;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getDebitHead() {
		return debitHead;
	}


	public void setDebitHead(String debitHead) {
		this.debitHead = debitHead;
	}


	public String getCreditHead() {
		return creditHead;
	}


	public void setCreditHead(String creditHead) {
		this.creditHead = creditHead;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

		
}
