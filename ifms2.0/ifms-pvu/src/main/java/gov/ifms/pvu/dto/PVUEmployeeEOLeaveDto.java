package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import gov.ifms.common.base.ValidateDateRange;
import gov.ifms.edp.dto.BaseDto;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUEmployeeEOLeaveDto.
 * 
 * @version v 1.0
 * @created 2019/11/30 10:42:45
 *
 */
@ValidateDateRange(start = "startDate", end = "endDate")
public class PVUEmployeeEOLeaveDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp eol id. */
	@NotNull
	private long empEolId;

	/** The emp id. */
	@NotNull
	private long empId;
	
	/** The event code. */
	private String eventCode = PvuConstant.EVENT_CODE_EOL;

	/** The office id. */
	@NotNull
	private long officeId;
	
	/** The post id. */
	@NotNull
	private long postId;

	/** The trans no. */
	private String transNo;

	/** The initiation date. */
	private Date initiationDate;

	/** The start date. */
	@NotNull
	private LocalDate startDate;

	/** The end date. */
	@NotNull
	private LocalDate endDate;

	/** The no of days. */
	private int noOfDays;

	/** The order no date. */
	@NotEmpty
	private String orderNoDate;

	/** The remarks. */
	//@NotEmpty
	private String remarks;

	/** The status id. */
	private long statusId;

	private long employeeNo;

	/** The init date. */
	private LocalDateTime refDate;

	public LocalDateTime getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the emp eol id.
	 *
	 * @return the emp eol id
	 */
	public long getEmpEolId() {
		return empEolId;
	}

	/**
	 * Sets the emp eol id.
	 *
	 * @param empEolId the new emp eol id
	 */
	public void setEmpEolId(long empEolId) {
		this.empEolId = empEolId;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * @return the employeeNo
	 */
	public long getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(long employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * Gets the trans no.
	 *
	 * @return the trans no
	 */
	public String getTransNo() {
		return transNo;
	}

	/**
	 * Sets the trans no.
	 *
	 * @param transNo the new trans no
	 */
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}
	
	public Date getInitiationDate() {
		return initiationDate;
	}

	public void setInitiationDate(Date initiationDate) {
		this.initiationDate = initiationDate;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the postId
	 */
	public long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the postId to set
	 */
	public void setPostId(long postId) {
		this.postId = postId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the no of days.
	 *
	 * @return the no of days
	 */
	public int getNoOfDays() {
		return noOfDays;
	}

	/**
	 * Sets the no of days.
	 *
	 * @param noOfDays the new no of days
	 */
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	/**
	 * Gets the order no date.
	 *
	 * @return the order no date
	 */
	public String getOrderNoDate() {
		return orderNoDate;
	}

	/**
	 * Sets the order no date.
	 *
	 * @param orderNoDate the new order no date
	 */
	public void setOrderNoDate(String orderNoDate) {
		this.orderNoDate = orderNoDate;
	}

	/**
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the new remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(empEolId, empId, employeeNo, endDate, initiationDate, noOfDays, officeId, orderNoDate,
				postId, remarks, startDate, statusId, transNo);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUEmployeeEOLeaveDto)) {
			return false;
		}
		PVUEmployeeEOLeaveDto other = (PVUEmployeeEOLeaveDto) obj;
		return empEolId == other.empEolId && empId == other.empId && employeeNo == other.employeeNo
				&& Objects.equals(endDate, other.endDate) && Objects.equals(initiationDate, other.initiationDate)
				&& noOfDays == other.noOfDays && officeId == other.officeId
				&& Objects.equals(orderNoDate, other.orderNoDate) && postId == other.postId
				&& Objects.equals(remarks, other.remarks) && Objects.equals(startDate, other.startDate)
				&& statusId == other.statusId && Objects.equals(transNo, other.transNo);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeeEOLeaveDto [empEolId=" + empEolId + ", empId=" + empId + ", officeId=" + officeId
				+ ", postId=" + postId + ", transNo=" + transNo + ", initiationDate=" + initiationDate + ", startDate="
				+ startDate + ", endDate=" + endDate + ", noOfDays=" + noOfDays + ", orderNoDate=" + orderNoDate
				+ ", remarks=" + remarks + ", statusId=" + statusId + ", employeeNo=" + employeeNo + "]";
	}

	
}
