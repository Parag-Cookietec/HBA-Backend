package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsRbiDaywiseScrollMonitoringPart2ReportDto {

	@NativeQueryResultColumn(index = 0)
	private Integer posted_Scrolls;
	@NativeQueryResultColumn(index = 1)
	private Integer posted_Total_Challans;
	@NativeQueryResultColumn(index = 2)
	private Double posted_Amount;
	@NativeQueryResultColumn(index = 3)
	private Integer inprocess_Scrolls;
	@NativeQueryResultColumn(index = 4)
	private Integer inprocess_Total_Challans;
	@NativeQueryResultColumn(index = 5)
	private Double inprocess_Amount;
	@NativeQueryResultColumn(index = 6)
	private Integer pending_Scrolls;
	@NativeQueryResultColumn(index = 7)
	private Integer pending_Total_Challans;
	
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GstReportDtlsRbiDaywiseScrollMonitoringPart2ReportDto() {
		super();
		// TODO Auto-generated constructor stub
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
}
