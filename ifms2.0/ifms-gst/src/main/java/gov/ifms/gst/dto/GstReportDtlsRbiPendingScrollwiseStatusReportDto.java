package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsRbiPendingScrollwiseStatusReportDto {

	@NativeQueryResultColumn(index = 0)
	private String filename;
	@NativeQueryResultColumn(index = 1)
	private Integer noOfTransactions;
	@NativeQueryResultColumn(index = 2)
	private Double amount;
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public GstReportDtlsRbiPendingScrollwiseStatusReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * @return the noOfTransactions
	 */
	public Integer getNoOfTransactions() {
		return noOfTransactions;
	}
	/**
	 * @param noOfTransactions the noOfTransactions to set
	 */
	public void setNoOfTransactions(Integer noOfTransactions) {
		this.noOfTransactions = noOfTransactions;
	}
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
