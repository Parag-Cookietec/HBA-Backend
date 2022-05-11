package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsRbiDaywiseScrollMonitoringReportDto {

	@NativeQueryResultColumn(index = 0)
	private String date;
	@NativeQueryResultColumn(index = 1)
	private Integer recvd_No_Of_Scrolls;
	@NativeQueryResultColumn(index = 2)
	private Integer recvd_No_Of_Challans;
	@NativeQueryResultColumn(index = 3)
	private Double jotted_Amount;
	@NativeQueryResultColumn(index = 4)
	private Integer jott_No_Of_Scrolls;
	@NativeQueryResultColumn(index = 5)
	private Integer jott_No_Of_Challans;
	@NativeQueryResultColumn(index = 6)
	private Double recvd_Amount;	
	@NativeQueryResultColumn(index = 7)
	private Integer posted_Scrolls;
	@NativeQueryResultColumn(index = 8)
	private Integer posted_Total_Challans;
	@NativeQueryResultColumn(index = 9)
	private Double posted_Amount;
	@NativeQueryResultColumn(index = 10)
	private Integer inprocess_Scrolls;
	@NativeQueryResultColumn(index = 11)
	private Integer inprocess_Total_Challans;
	@NativeQueryResultColumn(index = 12)
	private Double inprocess_Amount;
	@NativeQueryResultColumn(index = 13)
	private Integer pending_Scrolls;
	@NativeQueryResultColumn(index = 14)
	private Integer pending_Total_Challans;
	@NativeQueryResultColumn(index = 15)
	private Double pending_Amount;
	
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GstReportDtlsRbiDaywiseScrollMonitoringReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the recvd_No_Of_Scrolls
	 */
	public Integer getRecvd_No_Of_Scrolls() {
		return recvd_No_Of_Scrolls;
	}

	/**
	 * @param recvd_No_Of_Scrolls the recvd_No_Of_Scrolls to set
	 */
	public void setRecvd_No_Of_Scrolls(Integer recvd_No_Of_Scrolls) {
		this.recvd_No_Of_Scrolls = recvd_No_Of_Scrolls;
	}

	/**
	 * @return the recvd_No_Of_Challans
	 */
	public Integer getRecvd_No_Of_Challans() {
		return recvd_No_Of_Challans;
	}

	/**
	 * @param recvd_No_Of_Challans the recvd_No_Of_Challans to set
	 */
	public void setRecvd_No_Of_Challans(Integer recvd_No_Of_Challans) {
		this.recvd_No_Of_Challans = recvd_No_Of_Challans;
	}

	/**
	 * @return the jotted_Amount
	 */
	public Double getJotted_Amount() {
		return jotted_Amount;
	}

	/**
	 * @param jotted_Amount the jotted_Amount to set
	 */
	public void setJotted_Amount(Double jotted_Amount) {
		this.jotted_Amount = jotted_Amount;
	}

	/**
	 * @return the jott_No_Of_Scrolls
	 */
	public Integer getJott_No_Of_Scrolls() {
		return jott_No_Of_Scrolls;
	}

	/**
	 * @param jott_No_Of_Scrolls the jott_No_Of_Scrolls to set
	 */
	public void setJott_No_Of_Scrolls(Integer jott_No_Of_Scrolls) {
		this.jott_No_Of_Scrolls = jott_No_Of_Scrolls;
	}

	/**
	 * @return the jott_No_Of_Challans
	 */
	public Integer getJott_No_Of_Challans() {
		return jott_No_Of_Challans;
	}

	/**
	 * @param jott_No_Of_Challans the jott_No_Of_Challans to set
	 */
	public void setJott_No_Of_Challans(Integer jott_No_Of_Challans) {
		this.jott_No_Of_Challans = jott_No_Of_Challans;
	}

	/**
	 * @return the recvd_Amount
	 */
	public Double getRecvd_Amount() {
		return recvd_Amount;
	}

	/**
	 * @param recvd_Amount the recvd_Amount to set
	 */
	public void setRecvd_Amount(Double recvd_Amount) {
		this.recvd_Amount = recvd_Amount;
	}

	/**
	 * @return the posted_Scrolls
	 */
	public Integer getPosted_Scrolls() {
		return posted_Scrolls;
	}

	/**
	 * @param posted_Scrolls the posted_Scrolls to set
	 */
	public void setPosted_Scrolls(Integer posted_Scrolls) {
		this.posted_Scrolls = posted_Scrolls;
	}

	/**
	 * @return the posted_Total_Challans
	 */
	public Integer getPosted_Total_Challans() {
		return posted_Total_Challans;
	}

	/**
	 * @param posted_Total_Challans the posted_Total_Challans to set
	 */
	public void setPosted_Total_Challans(Integer posted_Total_Challans) {
		this.posted_Total_Challans = posted_Total_Challans;
	}

	/**
	 * @return the posted_Amount
	 */
	public Double getPosted_Amount() {
		return posted_Amount;
	}

	/**
	 * @param posted_Amount the posted_Amount to set
	 */
	public void setPosted_Amount(Double posted_Amount) {
		this.posted_Amount = posted_Amount;
	}

	/**
	 * @return the inprocess_Scrolls
	 */
	public Integer getInprocess_Scrolls() {
		return inprocess_Scrolls;
	}

	/**
	 * @param inprocess_Scrolls the inprocess_Scrolls to set
	 */
	public void setInprocess_Scrolls(Integer inprocess_Scrolls) {
		this.inprocess_Scrolls = inprocess_Scrolls;
	}

	/**
	 * @return the inprocess_Total_Challans
	 */
	public Integer getInprocess_Total_Challans() {
		return inprocess_Total_Challans;
	}

	/**
	 * @param inprocess_Total_Challans the inprocess_Total_Challans to set
	 */
	public void setInprocess_Total_Challans(Integer inprocess_Total_Challans) {
		this.inprocess_Total_Challans = inprocess_Total_Challans;
	}

	/**
	 * @return the inprocess_Amount
	 */
	public Double getInprocess_Amount() {
		return inprocess_Amount;
	}

	/**
	 * @param inprocess_Amount the inprocess_Amount to set
	 */
	public void setInprocess_Amount(Double inprocess_Amount) {
		this.inprocess_Amount = inprocess_Amount;
	}

	/**
	 * @return the pending_Scrolls
	 */
	public Integer getPending_Scrolls() {
		return pending_Scrolls;
	}

	/**
	 * @param pending_Scrolls the pending_Scrolls to set
	 */
	public void setPending_Scrolls(Integer pending_Scrolls) {
		this.pending_Scrolls = pending_Scrolls;
	}

	/**
	 * @return the pending_Total_Challans
	 */
	public Integer getPending_Total_Challans() {
		return pending_Total_Challans;
	}

	/**
	 * @param pending_Total_Challans the pending_Total_Challans to set
	 */
	public void setPending_Total_Challans(Integer pending_Total_Challans) {
		this.pending_Total_Challans = pending_Total_Challans;
	}

	/**
	 * @return the pending_Amount
	 */
	public Double getPending_Amount() {
		return pending_Amount;
	}

	/**
	 * @param pending_Amount the pending_Amount to set
	 */
	public void setPending_Amount(Double pending_Amount) {
		this.pending_Amount = pending_Amount;
	}
}
