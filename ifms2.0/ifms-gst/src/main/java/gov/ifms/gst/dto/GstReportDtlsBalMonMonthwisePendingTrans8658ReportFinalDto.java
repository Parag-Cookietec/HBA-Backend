package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsBalMonMonthwisePendingTrans8658ReportFinalDto {

	@NativeQueryResultColumn(index = 0)
	private String month;
	@NativeQueryResultColumn(index = 1)
	private Integer noOfTransactions;
	@NativeQueryResultColumn(index = 2)
	private Double amount;
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public GstReportDtlsBalMonMonthwisePendingTrans8658ReportFinalDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
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
