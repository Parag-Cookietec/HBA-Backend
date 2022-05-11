package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.BaseDto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Class PVUIncrementEmpDto.
 * 
 * @version v 1.0
 * @created 2020/01/12 19:19:14
 *
 */
public class PVUIncrementSTPSDDto extends BaseDto implements Serializable {

	private long id;

	private long empId;

	private Long resionForStop;

	private String resionForStopValue;

	private Date stopIncOrderDate;

	private String stopIncOrderNo;

	private long inEventId;

	private Date stpStartDate;

	private Date stpEndDate;

	private Date whStartDate;

	private Date whEndDate;

	private long pvuIncrementEmpSDId;

	private long statusId;

	private long exclusionReasion;

	private String exclusionReasionValue;

	private long  stopIncMonth;

	private String stopIncMonthValue;

	private long  stopIncYear;

	private String stopIncYearValue;

	private long  stopIncrementDuration;

	private String stopIncrementDurationValue;

	private long stopIncNumber;

	private String stopIncNumberValue;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}


	public Long getResionForStop() {
		return resionForStop;
	}

	public void setResionForStop(Long resionForStop) {
		this.resionForStop = resionForStop;
	}

	public Date getStopIncOrderDate() {
		return stopIncOrderDate;
	}

	public void setStopIncOrderDate(Date stopIncOrderDate) {
		this.stopIncOrderDate = stopIncOrderDate;
	}

	public String getStopIncOrderNo() {
		return stopIncOrderNo;
	}

	public void setStopIncOrderNo(String stopIncOrderNo) {
		this.stopIncOrderNo = stopIncOrderNo;
	}


	public long getInEventId() {
		return inEventId;
	}

	public void setInEventId(long inEventId) {
		this.inEventId = inEventId;
	}

	public Date getStpStartDate() {
		return stpStartDate;
	}

	public void setStpStartDate(Date stpStartDate) {
		this.stpStartDate = stpStartDate;
	}

	public Date getStpEndDate() {
		return stpEndDate;
	}

	public void setStpEndDate(Date stpEndDate) {
		this.stpEndDate = stpEndDate;
	}

	public Date getWhStartDate() {
		return whStartDate;
	}

	public void setWhStartDate(Date whStartDate) {
		this.whStartDate = whStartDate;
	}

	public Date getWhEndDate() {
		return whEndDate;
	}

	public void setWhEndDate(Date whEndDate) {
		this.whEndDate = whEndDate;
	}

	public long getPvuIncrementEmpSDId() {
		return pvuIncrementEmpSDId;
	}

	public void setPvuIncrementEmpSDId(long pvuIncrementEmpSDId) {
		this.pvuIncrementEmpSDId = pvuIncrementEmpSDId;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public long getExclusionReasion() {
		return exclusionReasion;
	}

	public void setExclusionReasion(long exclusionReasion) {
		this.exclusionReasion = exclusionReasion;
	}

	public String getExclusionReasionValue() {
		return exclusionReasionValue;
	}

	public void setExclusionReasionValue(String exclusionReasionValue) {
		this.exclusionReasionValue = exclusionReasionValue;
	}

	public String getResionForStopValue() {
		return resionForStopValue;
	}

	public void setResionForStopValue(String resionForStopValue) {
		this.resionForStopValue = resionForStopValue;
	}

	public long getStopIncMonth() {
		return stopIncMonth;
	}

	public void setStopIncMonth(long stopIncMonth) {
		this.stopIncMonth = stopIncMonth;
	}

	public String getStopIncMonthValue() {
		return stopIncMonthValue;
	}

	public void setStopIncMonthValue(String stopIncMonthValue) {
		this.stopIncMonthValue = stopIncMonthValue;
	}

	public long getStopIncYear() {
		return stopIncYear;
	}

	public void setStopIncYear(long stopIncYear) {
		this.stopIncYear = stopIncYear;
	}

	public String getStopIncYearValue() {
		return stopIncYearValue;
	}

	public void setStopIncYearValue(String stopIncYearValue) {
		this.stopIncYearValue = stopIncYearValue;
	}

	public long getStopIncrementDuration() {
		return stopIncrementDuration;
	}

	public void setStopIncrementDuration(long stopIncrementDuration) {
		this.stopIncrementDuration = stopIncrementDuration;
	}

	public String getStopIncrementDurationValue() {
		return stopIncrementDurationValue;
	}

	public void setStopIncrementDurationValue(String stopIncrementDurationValue) {
		this.stopIncrementDurationValue = stopIncrementDurationValue;
	}

	public long getStopIncNumber() {
		return stopIncNumber;
	}

	public void setStopIncNumber(long stopIncNumber) {
		this.stopIncNumber = stopIncNumber;
	}

	public String getStopIncNumberValue() {
		return stopIncNumberValue;
	}

	public void setStopIncNumberValue(String stopIncNumberValue) {
		this.stopIncNumberValue = stopIncNumberValue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUIncrementSTPSDDto)) return false;
		if (!super.equals(o)) return false;
		PVUIncrementSTPSDDto that = (PVUIncrementSTPSDDto) o;
		return getId() == that.getId() && getEmpId() == that.getEmpId() && getInEventId() == that.getInEventId() && getPvuIncrementEmpSDId() == that.getPvuIncrementEmpSDId() && getStatusId() == that.getStatusId() && getExclusionReasion() == that.getExclusionReasion() && getStopIncMonth() == that.getStopIncMonth() && getStopIncYear() == that.getStopIncYear() && getStopIncrementDuration() == that.getStopIncrementDuration() && getStopIncNumber() == that.getStopIncNumber() && Objects.equals(getResionForStop(), that.getResionForStop()) && Objects.equals(getResionForStopValue(), that.getResionForStopValue()) && Objects.equals(getStopIncOrderDate(), that.getStopIncOrderDate()) && Objects.equals(getStopIncOrderNo(), that.getStopIncOrderNo()) && Objects.equals(getStpStartDate(), that.getStpStartDate()) && Objects.equals(getStpEndDate(), that.getStpEndDate()) && Objects.equals(getWhStartDate(), that.getWhStartDate()) && Objects.equals(getWhEndDate(), that.getWhEndDate()) && Objects.equals(getExclusionReasionValue(), that.getExclusionReasionValue()) && Objects.equals(getStopIncMonthValue(), that.getStopIncMonthValue()) && Objects.equals(getStopIncYearValue(), that.getStopIncYearValue()) && Objects.equals(getStopIncrementDurationValue(), that.getStopIncrementDurationValue()) && Objects.equals(getStopIncNumberValue(), that.getStopIncNumberValue());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId(), getEmpId(), getResionForStop(), getResionForStopValue(), getStopIncOrderDate(), getStopIncOrderNo(), getInEventId(), getStpStartDate(), getStpEndDate(), getWhStartDate(), getWhEndDate(), getPvuIncrementEmpSDId(), getStatusId(), getExclusionReasion(), getExclusionReasionValue(), getStopIncMonth(), getStopIncMonthValue(), getStopIncYear(), getStopIncYearValue(), getStopIncrementDuration(), getStopIncrementDurationValue(), getStopIncNumber(), getStopIncNumberValue());
	}

	@Override
	public String toString() {
		return "PVUIncrementSTPSDDto{" +
				"id=" + id +
				", empId=" + empId +
				", resionForStop=" + resionForStop +
				", resionForStopValue='" + resionForStopValue + '\'' +
				", stopIncOrderDate=" + stopIncOrderDate +
				", stopIncOrderNo='" + stopIncOrderNo + '\'' +
				", inEventId=" + inEventId +
				", stpStartDate=" + stpStartDate +
				", stpEndDate=" + stpEndDate +
				", whStartDate=" + whStartDate +
				", whEndDate=" + whEndDate +
				", pvuIncrementEmpSDId=" + pvuIncrementEmpSDId +
				", statusId=" + statusId +
				", exclusionReasion=" + exclusionReasion +
				", exclusionReasionValue='" + exclusionReasionValue + '\'' +
				", stopIncMonth=" + stopIncMonth +
				", stopIncMonthValue='" + stopIncMonthValue + '\'' +
				", stopIncYear=" + stopIncYear +
				", stopIncYearValue='" + stopIncYearValue + '\'' +
				", stopIncrementDuration=" + stopIncrementDuration +
				", stopIncrementDurationValue='" + stopIncrementDurationValue + '\'' +
				", stopIncNumber=" + stopIncNumber +
				", stopIncNumberValue='" + stopIncNumberValue + '\'' +
				'}';
	}
}
