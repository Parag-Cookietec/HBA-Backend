package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsRbiScrollStmntDaywiseReportDto {

	@NativeQueryResultColumn(index = 0)
	private String scroll_No;
	@NativeQueryResultColumn(index = 1)
	private Integer no_Of_Transaction;
	@NativeQueryResultColumn(index = 2)
	private Double transaction_Amount;
	@NativeQueryResultColumn(index = 3)
	private Integer no_Notification;
	@NativeQueryResultColumn(index = 4)
	private Double notification_Amount;
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GstReportDtlsRbiScrollStmntDaywiseReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the scroll_No
	 */
	public String getScroll_No() {
		return scroll_No;
	}

	/**
	 * @param scroll_No the scroll_No to set
	 */
	public void setScroll_No(String scroll_No) {
		this.scroll_No = scroll_No;
	}

	/**
	 * @return the no_Of_Transaction
	 */
	public Integer getNo_Of_Transaction() {
		return no_Of_Transaction;
	}

	/**
	 * @param no_Of_Transaction the no_Of_Transaction to set
	 */
	public void setNo_Of_Transaction(Integer no_Of_Transaction) {
		this.no_Of_Transaction = no_Of_Transaction;
	}

	/**
	 * @return the transaction_Amount
	 */
	public Double getTransaction_Amount() {
		return transaction_Amount;
	}

	/**
	 * @param transaction_Amount the transaction_Amount to set
	 */
	public void setTransaction_Amount(Double transaction_Amount) {
		this.transaction_Amount = transaction_Amount;
	}

	/**
	 * @return the no_Notification
	 */
	public Integer getNo_Notification() {
		return no_Notification;
	}

	/**
	 * @param no_Notification the no_Notification to set
	 */
	public void setNo_Notification(Integer no_Notification) {
		this.no_Notification = no_Notification;
	}

	/**
	 * @return the notification_Amount
	 */
	public Double getNotification_Amount() {
		return notification_Amount;
	}

	/**
	 * @param notification_Amount the notification_Amount to set
	 */
	public void setNotification_Amount(Double notification_Amount) {
		this.notification_Amount = notification_Amount;
	}
}
