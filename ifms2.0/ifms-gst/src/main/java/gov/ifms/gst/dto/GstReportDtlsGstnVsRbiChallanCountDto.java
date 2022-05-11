package gov.ifms.gst.dto;

import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsGstnVsRbiChallanCountDto {

	@NativeQueryResultColumn(index = 0)
	private String paymentDate;
	@NativeQueryResultColumn(index = 1)
	private Integer gstnTotalTrns;
	@NativeQueryResultColumn(index = 2)
	private Double gstnTotalAmount;
	@NativeQueryResultColumn(index = 3)
	private Integer rbiTotalTrns;
	@NativeQueryResultColumn(index = 4)
	private Double rbiTotalAmount;

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GstReportDtlsGstnVsRbiChallanCountDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the paymentDate
	 */
	public String getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}



	/**
	 * @return the gstnTotalTrns
	 */
	public Integer getGstnTotalTrns() {
		return gstnTotalTrns;
	}

	/**
	 * @param gstnTotalTrns the gstnTotalTrns to set
	 */
	public void setGstnTotalTrns(Integer gstnTotalTrns) {
		this.gstnTotalTrns = gstnTotalTrns;
	}

	/**
	 * @return the gstnTotalAmount
	 */
	public Double getGstnTotalAmount() {
		return gstnTotalAmount;
	}

	/**
	 * @param gstnTotalAmount the gstnTotalAmount to set
	 */
	public void setGstnTotalAmount(Double gstnTotalAmount) {
		this.gstnTotalAmount = gstnTotalAmount;
	}

	/**
	 * @return the rbiTotalTrns
	 */
	public Integer getRbiTotalTrns() {
		return rbiTotalTrns;
	}

	/**
	 * @param rbiTotalTrns the rbiTotalTrns to set
	 */
	public void setRbiTotalTrns(Integer rbiTotalTrns) {
		this.rbiTotalTrns = rbiTotalTrns;
	}

	/**
	 * @return the rbiTotalAmount
	 */
	public Double getRbiTotalAmount() {
		return rbiTotalAmount;
	}

	/**
	 * @param rbiTotalAmount the rbiTotalAmount to set
	 */
	public void setRbiTotalAmount(Double rbiTotalAmount) {
		this.rbiTotalAmount = rbiTotalAmount;
	}
}
