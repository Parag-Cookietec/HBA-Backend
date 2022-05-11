package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsRbiScrollStmntMonthwiseReportDto {

	@NativeQueryResultColumn(index = 0)
	private String noOfScrolls;
	@NativeQueryResultColumn(index = 1)
	private Double transactionAmount;
	@NativeQueryResultColumn(index = 2)
	private String noNotification;
	@NativeQueryResultColumn(index = 3)
	private Double notificationAmount;
	@NativeQueryResultColumn(index = 4)
	private Double diffAmount;
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GstReportDtlsRbiScrollStmntMonthwiseReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the noOfScrolls
	 */
	public String getNoOfScrolls() {
		return noOfScrolls;
	}

	/**
	 * @param noOfScrolls the noOfScrolls to set
	 */
	public void setNoOfScrolls(String noOfScrolls) {
		this.noOfScrolls = noOfScrolls;
	}

	/**
	 * @return the transactionAmount
	 */
	public Double getTransactionAmount() {
		return transactionAmount;
	}

	/**
	 * @param transactionAmount the transactionAmount to set
	 */
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	/**
	 * @return the noNotification
	 */
	public String getNoNotification() {
		return noNotification;
	}

	/**
	 * @param noNotification the noNotification to set
	 */
	public void setNoNotification(String noNotification) {
		this.noNotification = noNotification;
	}

	/**
	 * @return the notificationAmount
	 */
	public Double getNotificationAmount() {
		return notificationAmount;
	}

	/**
	 * @param notificationAmount the notificationAmount to set
	 */
	public void setNotificationAmount(Double notificationAmount) {
		this.notificationAmount = notificationAmount;
	}

	/**
	 * @return the diffAmount
	 */
	public Double getDiffAmount() {
		return diffAmount;
	}

	/**
	 * @param diffAmount the diffAmount to set
	 */
	public void setDiffAmount(Double diffAmount) {
		this.diffAmount = diffAmount;
	}
}
