package gov.ifms.gst.dto;

import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsCinModewiseTaxpayertDto {

	@NativeQueryResultColumn(index = 0)
	private String paymentMode;
	@NativeQueryResultColumn(index = 1)
	private Integer challanCount;
	@NativeQueryResultColumn(index = 2)
	private Double amount;

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GstReportDtlsCinModewiseTaxpayertDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/**
	 * @return the challanCount
	 */
	public Integer getChallanCount() {
		return challanCount;
	}

	/**
	 * @param challanCount the challanCount to set
	 */
	public void setChallanCount(Integer challanCount) {
		this.challanCount = challanCount;
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
