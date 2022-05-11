package gov.ifms.gst.dto;

public class PenalIntrestDTLDto {

	private long id;
	private long penalIntrstId;
	private long receivedYearId;
	private short receivedYrYyyy;
	private long receivedMonthId;
	private String receivedMonth;
	private Double claimAmount;
	private Double earlierRecvAmount;
	private Double remainingAmount;
	private Double currRecvAmount;

	public long getPenalIntrstId() {
		return penalIntrstId;
	}

	public void setPenalIntrstId(long penalIntrstId) {
		this.penalIntrstId = penalIntrstId;
	}

	public long getReceivedYearId() {
		return receivedYearId;
	}

	public void setReceivedYearId(long receivedYearId) {
		this.receivedYearId = receivedYearId;
	}

	public short getReceivedYrYyyy() {
		return receivedYrYyyy;
	}

	public void setReceivedYrYyyy(short receivedYrYyyy) {
		this.receivedYrYyyy = receivedYrYyyy;
	}

	public long getReceivedMonthId() {
		return receivedMonthId;
	}

	public void setReceivedMonthId(long receivedMonthId) {
		this.receivedMonthId = receivedMonthId;
	}

	public String getReceivedMonth() {
		return receivedMonth;
	}

	public void setReceivedMonth(String receivedMonth) {
		this.receivedMonth = receivedMonth;
	}

	public Double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(Double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public Double getEarlierRecvAmount() {
		return earlierRecvAmount;
	}

	public void setEarlierRecvAmount(Double earlierRecvAmount) {
		this.earlierRecvAmount = earlierRecvAmount;
	}

	public Double getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(Double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public Double getCurrRecvAmount() {
		return currRecvAmount;
	}

	public void setCurrRecvAmount(Double currRecvAmount) {
		this.currRecvAmount = currRecvAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
