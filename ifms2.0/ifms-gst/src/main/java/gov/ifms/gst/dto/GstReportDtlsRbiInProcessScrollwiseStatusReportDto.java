package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsRbiInProcessScrollwiseStatusReportDto {

	@NativeQueryResultColumn(index = 0)
	private String filename;
	@NativeQueryResultColumn(index = 1)
	private Integer noOfChallans;
	@NativeQueryResultColumn(index = 2)
	private Integer challanPosted;
	@NativeQueryResultColumn(index = 2)
	private Integer challanPending;
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public GstReportDtlsRbiInProcessScrollwiseStatusReportDto() {
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
	 * @return the noOfChallans
	 */
	public Integer getNoOfChallans() {
		return noOfChallans;
	}

	/**
	 * @param noOfChallans the noOfChallans to set
	 */
	public void setNoOfChallans(Integer noOfChallans) {
		this.noOfChallans = noOfChallans;
	}

	/**
	 * @return the challanPosted
	 */
	public Integer getChallanPosted() {
		return challanPosted;
	}

	/**
	 * @param challanPosted the challanPosted to set
	 */
	public void setChallanPosted(Integer challanPosted) {
		this.challanPosted = challanPosted;
	}

	/**
	 * @return the challanPending
	 */
	public Integer getChallanPending() {
		return challanPending;
	}

	/**
	 * @param challanPending the challanPending to set
	 */
	public void setChallanPending(Integer challanPending) {
		this.challanPending = challanPending;
	}
}
