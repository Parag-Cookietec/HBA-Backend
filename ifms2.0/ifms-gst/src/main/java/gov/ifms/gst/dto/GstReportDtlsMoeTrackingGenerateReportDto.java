package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsMoeTrackingGenerateReportDto {
	
	@NativeQueryResultColumn(index = 0)
	private String bank;
	@NativeQueryResultColumn(index = 1)
	private String status;
	@NativeQueryResultColumn(index = 2)
	private Integer count;
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GstReportDtlsMoeTrackingGenerateReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}	
}
