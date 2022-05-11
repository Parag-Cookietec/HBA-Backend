package gov.ifms.gst.dto;

import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsRbiDaywiseChallanCountDto {

	@NativeQueryResultColumn(index = 0)
	private Date paymentDate;
	@NativeQueryResultColumn(index = 1)
	private Integer noOfTotalTrns;
	@NativeQueryResultColumn(index = 2)
	private Double amount;

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GstReportDtlsRbiDaywiseChallanCountDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param paymentDate
	 * @param noOfTotalTrns
	 * @param amount
	 */
	public GstReportDtlsRbiDaywiseChallanCountDto(Date paymentDate, Integer noOfTotalTrns, Double amount) {
		super();
		this.paymentDate = paymentDate;
		this.noOfTotalTrns = noOfTotalTrns;
		this.amount = amount;
	}

	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * @return the noOfTotalTrns
	 */
	public Integer getNoOfTotalTrns() {
		return noOfTotalTrns;
	}

	/**
	 * @param noOfTotalTrns the noOfTotalTrns to set
	 */
	public void setNoOfTotalTrns(Integer noOfTotalTrns) {
		this.noOfTotalTrns = noOfTotalTrns;
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
