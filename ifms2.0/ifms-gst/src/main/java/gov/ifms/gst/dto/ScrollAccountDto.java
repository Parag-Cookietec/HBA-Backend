package gov.ifms.gst.dto;

import java.util.Date;

public class ScrollAccountDto {
	private Double totalEAmount = 0.00;
	private Date month;
	private long noOfEScroll;
	private long noOfNotification;
	private Double amountEScroll;
	private Double amountAccounting;
	private Double totalAccountAmount = 0.00;
	private long TotalNoOfEScroll;
	private long TotalNoOfNotification;
	private Double diffrenceInAmount;

	public Double getDiffrenceInAmount() {
		return diffrenceInAmount;
	}

	public void setDiffrenceInAmount(Double diffrenceInAmount) {
		this.diffrenceInAmount = diffrenceInAmount;
	}

	public Double getTotalEAmount() {
		return totalEAmount;
	}

	public void setTotalEAmount(Double totalEAmount) {
		this.totalEAmount = totalEAmount;
	}

	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public long getNoOfEScroll() {
		return noOfEScroll;
	}

	public void setNoOfEScroll(long noOfEScroll) {
		this.noOfEScroll = noOfEScroll;
	}

	public long getNoOfNotification() {
		return noOfNotification;
	}

	public void setNoOfNotification(long noOfNotification) {
		this.noOfNotification = noOfNotification;
	}

	public Double getAmountEScroll() {
		return amountEScroll;
	}

	public void setAmountEScroll(Double amountEScroll) {
		this.amountEScroll = amountEScroll;
	}

	public Double getAmountAccounting() {
		return amountAccounting;
	}

	public void setAmountAccounting(Double amountAccounting) {
		this.amountAccounting = amountAccounting;
	}

	public Double getTotalAccountAmount() {
		return totalAccountAmount;
	}

	public void setTotalAccountAmount(Double totalAccountAmount) {
		this.totalAccountAmount = totalAccountAmount;
	}

	public long getTotalNoOfEScroll() {
		return TotalNoOfEScroll;
	}

	public void setTotalNoOfEScroll(long totalNoOfEScroll) {
		TotalNoOfEScroll = totalNoOfEScroll;
	}

	public long getTotalNoOfNotification() {
		return TotalNoOfNotification;
	}

	public void setTotalNoOfNotification(long totalNoOfNotification) {
		TotalNoOfNotification = totalNoOfNotification;
	}

}
