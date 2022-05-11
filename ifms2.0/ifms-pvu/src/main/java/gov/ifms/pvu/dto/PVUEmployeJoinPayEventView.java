package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUEmployeEventView.
 */
@NativeQueryResultEntity
public class PVUEmployeJoinPayEventView implements Serializable {

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

	/** The event name. */
	@NativeQueryResultColumn(index = 4)
	private String empName;

	/** The emp pay band. */
	@NativeQueryResultColumn(index = 5)
	private String empPayScalPayBand;

	/** The pay band value. */
	@NativeQueryResultColumn(index = 6)
	private String gradPayPayLevel;

	/** The grade pay. */
	@NativeQueryResultColumn(index = 7)
	private String payGrandValuCellId;

	/** The emp basic pay. */
	@NativeQueryResultColumn(index = 8)
	private String empBasicPay;

	/** The increment date. */
	@NativeQueryResultColumn(index = 9)
	private String incrementDate;

	/** The designation. */
	@NativeQueryResultColumn(index = 10)
	private String designation;

	/** The approval date. */
	@NativeQueryResultColumn(index = 11)
	private String approvalDate;

	/** The recored. */
	@NativeQueryResultColumn(index = 12)
	private String recored;

	@NativeQueryResultColumn(index = 13)
	private String status;

	/** The recored. */
	@NativeQueryResultColumn(index = 14)
	private String personalPay;

	/**
	 * @return the eventId
	 */
	public long getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the transacNumber
	 */
	public String getTransacNumber() {
		return transacNumber;
	}

	/**
	 * @param transacNumber the transacNumber to set
	 */
	public void setTransacNumber(String transacNumber) {
		this.transacNumber = transacNumber;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the eventDate
	 */
	public String getEventDate() {
		return eventDate;
	}

	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the empPayScalPayBand
	 */
	public String getEmpPayScalPayBand() {
		return empPayScalPayBand;
	}

	/**
	 * @param empPayScalPayBand the empPayScalPayBand to set
	 */
	public void setEmpPayScalPayBand(String empPayScalPayBand) {
		this.empPayScalPayBand = empPayScalPayBand;
	}

	/**
	 * @return the gradPayPayLevel
	 */
	public String getGradPayPayLevel() {
		return gradPayPayLevel;
	}

	/**
	 * @param gradPayPayLevel the gradPayPayLevel to set
	 */
	public void setGradPayPayLevel(String gradPayPayLevel) {
		this.gradPayPayLevel = gradPayPayLevel;
	}

	/**
	 * @return the payGrandValuCellId
	 */
	public String getPayGrandValuCellId() {
		return payGrandValuCellId;
	}

	/**
	 * @param payGrandValuCellId the payGrandValuCellId to set
	 */
	public void setPayGrandValuCellId(String payGrandValuCellId) {
		this.payGrandValuCellId = payGrandValuCellId;
	}

	/**
	 * @return the empBasicPay
	 */
	public String getEmpBasicPay() {
		return empBasicPay;
	}

	/**
	 * @param empBasicPay the empBasicPay to set
	 */
	public void setEmpBasicPay(String empBasicPay) {
		this.empBasicPay = empBasicPay;
	}

	/**
	 * @return the incrementDate
	 */
	public String getIncrementDate() {
		return incrementDate;
	}

	/**
	 * @param incrementDate the incrementDate to set
	 */
	public void setIncrementDate(String incrementDate) {
		this.incrementDate = incrementDate;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the approvalDate
	 */
	public String getApprovalDate() {
		return approvalDate;
	}

	/**
	 * @param approvalDate the approvalDate to set
	 */
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	/**
	 * @return the recored
	 */
	public String getRecored() {
		return recored;
	}

	/**
	 * @param recored the recored to set
	 */
	public void setRecored(String recored) {
		this.recored = recored;
	}

	/**
	 * @return the personalPay
	 */
	public String getPersonalPay() {
		return personalPay;
	}

	/**
	 * @param personalPay the personalPay to set
	 */
	public void setPersonalPay(String personalPay) {
		this.personalPay = personalPay;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
