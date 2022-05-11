package gov.ifms.gst.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TPAO_PENAL_INTEREST_DTL", schema = GSTConstant.GST_SCHEMA)
public class PenalIntrestDTL extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_PID = "PID";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PENAL_INTRST_DTL_ID")
	private long id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PENAL_INTRST_ID", referencedColumnName = "PENAL_INTRST_ID")
	public PenalIntrestEntry penalIntrestEntry;

	@Column(name = "RECEIVED_YEAR_ID")
	private long receivedYearId;

	@Column(name = "RECEIVED_YR_YYYY")
	private short receivedYrYyyy;

	@Column(name = "RECEIVED_MONTH_ID")
	private long receivedMonthId;

	@Column(name = "RECEIVED_MONTH")
	private String receivedMonth;

	@Column(name = "CLAIM_AMOUNT")
	private Double claimAmount;

	@Column(name = "EARLIER_RECV_AMOUNT")
	private Double earlierRecvAmount;

	@Column(name = "REMAINING_AMOUNT")
	private Double remainingAmount;

	@Column(name = "CURR_RECV_AMOUNT")
	private Double currRecvAmount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PenalIntrestEntry getPenalIntrestEntry() {
		return penalIntrestEntry;
	}

	public void setPenalIntrestEntry(PenalIntrestEntry penalIntrestEntry) {
		this.penalIntrestEntry = penalIntrestEntry;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PenalIntrestDTL that = (PenalIntrestDTL) o;
		return id == that.id && receivedYearId == that.receivedYearId && receivedYrYyyy == that.receivedYrYyyy && receivedMonthId == that.receivedMonthId && Objects.equals(penalIntrestEntry, that.penalIntrestEntry) && Objects.equals(receivedMonth, that.receivedMonth) && Objects.equals(claimAmount, that.claimAmount) && Objects.equals(earlierRecvAmount, that.earlierRecvAmount) && Objects.equals(remainingAmount, that.remainingAmount) && Objects.equals(currRecvAmount, that.currRecvAmount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, penalIntrestEntry, receivedYearId, receivedYrYyyy, receivedMonthId, receivedMonth, claimAmount, earlierRecvAmount, remainingAmount, currRecvAmount);
	}
}
