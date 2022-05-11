package gov.ifms.gst.dto;

import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsMoeTrackingGenerateSubReportDto {
	
	@NativeQueryResultColumn(index = 0)
	private String cin;
	@NativeQueryResultColumn(index = 1)
	private Date cin_date;
	@NativeQueryResultColumn(index = 2)
	private Double gstn_Amount;	
	@NativeQueryResultColumn(index = 3)
	private Double rbi_Amount;
	@NativeQueryResultColumn(index = 4)
	private Integer reason;
	@NativeQueryResultColumn(index = 3)
	private Double moe_Amount;
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GstReportDtlsMoeTrackingGenerateSubReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the cin
	 */
	public String getCin() {
		return cin;
	}

	/**
	 * @param cin the cin to set
	 */
	public void setCin(String cin) {
		this.cin = cin;
	}

	/**
	 * @return the cin_date
	 */
	public Date getCin_date() {
		return cin_date;
	}

	/**
	 * @param cin_date the cin_date to set
	 */
	public void setCin_date(Date cin_date) {
		this.cin_date = cin_date;
	}

	/**
	 * @return the gstn_Amount
	 */
	public Double getGstn_Amount() {
		return gstn_Amount;
	}

	/**
	 * @param gstn_Amount the gstn_Amount to set
	 */
	public void setGstn_Amount(Double gstn_Amount) {
		this.gstn_Amount = gstn_Amount;
	}

	/**
	 * @return the rbi_Amount
	 */
	public Double getRbi_Amount() {
		return rbi_Amount;
	}

	/**
	 * @param rbi_Amount the rbi_Amount to set
	 */
	public void setRbi_Amount(Double rbi_Amount) {
		this.rbi_Amount = rbi_Amount;
	}

	/**
	 * @return the reason
	 */
	public Integer getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(Integer reason) {
		this.reason = reason;
	}

	/**
	 * @return the moe_Amount
	 */
	public Double getMoe_Amount() {
		return moe_Amount;
	}

	/**
	 * @param moe_Amount the moe_Amount to set
	 */
	public void setMoe_Amount(Double moe_Amount) {
		this.moe_Amount = moe_Amount;
	}
}
