package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * The Class PVUEmployeEventView.
 */
@NativeQueryResultEntity
public class PVUEmployeEventView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event id. */
	@NativeQueryResultColumn(index = 0)
	private long eventId;

	/** The transac number. */
	@NativeQueryResultColumn(index = 1)
	private String transacNumber;

	/** The event name. */
	@NativeQueryResultColumn(index = 2)
	private String eventName;

	/** The event date. */
	@NativeQueryResultColumn(index = 3)
	private String eventDate;

	/** The emp pay band. */
	@NativeQueryResultColumn(index = 4)
	private String empPayBand;

	/** The pay band value. */
	@NativeQueryResultColumn(index = 5)
	private String payBandValue;

	/** The grade pay. */
	@NativeQueryResultColumn(index = 6)
	private String employeePayLevel;

	/** The emp basic pay. */
	@NativeQueryResultColumn(index = 7)
	private String empBasicPay;

	/** The increment date. */
	@NativeQueryResultColumn(index = 8)
	private String incrementDate;

	/** The designation. */
	@NativeQueryResultColumn(index = 9)
	private String designation;

	/** The option opted. */
	@NativeQueryResultColumn(index = 10)
	private String optionOpted;

	/** The approval date. */
	@NativeQueryResultColumn(index = 11)
	private String approvalDate;

	/** The recored. */
	@NativeQueryResultColumn(index = 12)
	private String recored;

	/** The recored. */
	@NativeQueryResultColumn(index = 13)
	private String personalPay;

	/**
	 * Gets the event id.
	 *
	 * @return the eventId
	 */
	public long getEventId() {
		return eventId;
	}

	/**
	 * Sets the event id.
	 *
	 * @param eventId the eventId to set
	 */
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	/**
	 * Gets the transac number.
	 *
	 * @return the transacNumber
	 */
	public String getTransacNumber() {
		return transacNumber;
	}

	/**
	 * Sets the transac number.
	 *
	 * @param transacNumber the transacNumber to set
	 */
	public void setTransacNumber(String transacNumber) {
		this.transacNumber = transacNumber;
	}

	/**
	 * Gets the event name.
	 *
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * Sets the event name.
	 *
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * Gets the event date.
	 *
	 * @return the eventDate
	 */
	public String getEventDate() {
		return eventDate;
	}

	/**
	 * Sets the event date.
	 *
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * Gets the emp pay band.
	 *
	 * @return the empPayBand
	 */
	public String getEmpPayBand() {
		return empPayBand;
	}

	/**
	 * Sets the emp pay band.
	 *
	 * @param empPayBand the empPayBand to set
	 */
	public void setEmpPayBand(String empPayBand) {
		this.empPayBand = empPayBand;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return the payBandValue
	 */
	public String getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(String payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Gets the emp basic pay.
	 *
	 * @return the empBasicPay
	 */
	public String getEmpBasicPay() {
		return empBasicPay;
	}

	/**
	 * Sets the emp basic pay.
	 *
	 * @param empBasicPay the empBasicPay to set
	 */
	public void setEmpBasicPay(String empBasicPay) {
		this.empBasicPay = empBasicPay;
	}

	/**
	 * Gets the increment date.
	 *
	 * @return the incrementDate
	 */
	public String getIncrementDate() {
		return incrementDate;
	}

	/**
	 * Sets the increment date.
	 *
	 * @param incrementDate the incrementDate to set
	 */
	public void setIncrementDate(String incrementDate) {
		this.incrementDate = incrementDate;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Gets the option opted.
	 *
	 * @return the optionOpted
	 */
	public String getOptionOpted() {
		return optionOpted;
	}

	/**
	 * Sets the option opted.
	 *
	 * @param optionOpted the optionOpted to set
	 */
	public void setOptionOpted(String optionOpted) {
		this.optionOpted = optionOpted;
	}

	/**
	 * Gets the approval date.
	 *
	 * @return the approvalDate
	 */
	public String getApprovalDate() {
		return approvalDate;
	}

	/**
	 * Sets the approval date.
	 *
	 * @param approvalDate the approvalDate to set
	 */
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	/**
	 * Gets the employee pay level.
	 *
	 * @return the employeePayLevel
	 */
	public String getEmployeePayLevel() {
		return employeePayLevel;
	}

	/**
	 * Sets the employee pay level.
	 *
	 * @param employeePayLevel the employeePayLevel to set
	 */
	public void setEmployeePayLevel(String employeePayLevel) {
		this.employeePayLevel = employeePayLevel;
	}

	/**
	 * Gets the recored.
	 *
	 * @return the recored
	 */
	public String getRecored() {
		return recored;
	}

	/**
	 * Sets the recored.
	 *
	 * @param recored the recored to set
	 */
	public void setRecored(String recored) {
		this.recored = recored;
	}

	/**
	 * Getter for property 'personalPay'.
	 *
	 * @return Value for property 'personalPay'.
	 */
	public String getPersonalPay() {
		return personalPay;
	}

	/**
	 * Setter for property 'personalPay'.
	 *
	 * @param personalPay Value to set for property 'personalPay'.
	 */
	public void setPersonalPay(String personalPay) {
		this.personalPay = personalPay;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUEmployeEventView)) return false;
		PVUEmployeEventView that = (PVUEmployeEventView) o;
		return eventId == that.eventId &&
				Objects.equals(transacNumber, that.transacNumber) &&
				Objects.equals(eventName, that.eventName) &&
				Objects.equals(eventDate, that.eventDate) &&
				Objects.equals(empPayBand, that.empPayBand) &&
				Objects.equals(payBandValue, that.payBandValue) &&
				Objects.equals(employeePayLevel, that.employeePayLevel) &&
				Objects.equals(empBasicPay, that.empBasicPay) &&
				Objects.equals(incrementDate, that.incrementDate) &&
				Objects.equals(designation, that.designation) &&
				Objects.equals(optionOpted, that.optionOpted) &&
				Objects.equals(approvalDate, that.approvalDate) &&
				Objects.equals(recored, that.recored) &&
				Objects.equals(personalPay, that.personalPay);
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventId, transacNumber, eventName, eventDate, empPayBand, payBandValue,
				employeePayLevel, empBasicPay, incrementDate, designation,
				optionOpted, approvalDate, recored, personalPay);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", PVUEmployeEventView.class.getSimpleName() + "[", "]")
				.add("eventId=" + eventId)
				.add("transacNumber='" + transacNumber + "'")
				.add("eventName='" + eventName + "'")
				.add("eventDate='" + eventDate + "'")
				.add("empPayBand='" + empPayBand + "'")
				.add("payBandValue='" + payBandValue + "'")
				.add("employeePayLevel='" + employeePayLevel + "'")
				.add("empBasicPay='" + empBasicPay + "'")
				.add("incrementDate='" + incrementDate + "'")
				.add("designation='" + designation + "'")
				.add("optionOpted='" + optionOpted + "'")
				.add("approvalDate='" + approvalDate + "'")
				.add("recored='" + recored + "'")
				.add("personalPay='" + personalPay + "'")
				.toString();
	}

}
