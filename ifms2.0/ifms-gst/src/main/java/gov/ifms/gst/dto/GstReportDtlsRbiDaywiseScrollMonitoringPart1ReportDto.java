package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsRbiDaywiseScrollMonitoringPart1ReportDto {

	@NativeQueryResultColumn(index = 0)
	private Integer recvd_No_Of_Scrolls;
	@NativeQueryResultColumn(index = 1)
	private Integer recvd_No_Of_Challans;
	@NativeQueryResultColumn(index = 2)
	private Double jotted_Amount;
	@NativeQueryResultColumn(index = 3)
	private Integer jott_No_Of_Scrolls;
	@NativeQueryResultColumn(index = 4)
	private Integer jott_No_Of_Challans;
	@NativeQueryResultColumn(index = 5)
	private Double recvd_Amount;		
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GstReportDtlsRbiDaywiseScrollMonitoringPart1ReportDto() {
		super();
		// TODO Auto-generated constructor stub
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
}
