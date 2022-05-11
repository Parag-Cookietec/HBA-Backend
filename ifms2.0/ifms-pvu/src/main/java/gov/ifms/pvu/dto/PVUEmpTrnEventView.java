package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUEmployeEventView.
 */
@NativeQueryResultEntity
public class PVUEmpTrnEventView implements Serializable {

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

	/** The approval date. */
	@NativeQueryResultColumn(index = 4)
	private String approvalDate;

	/** The emp id. */
	@NativeQueryResultColumn(index = 5)
	private long empId;

	/** The designation. */
	@NativeQueryResultColumn(index = 6)
	private String designationId;

	/** The designation. */
	@NativeQueryResultColumn(index = 7)
	private String designation;

	/** The office id. */
	@NativeQueryResultColumn(index = 8)
	private Long officeId;

	/** The sus start date. */
	@NativeQueryResultColumn(index = 9)
	private String tranRelievingDate;

	/** The sus end date. */
	@NativeQueryResultColumn(index = 10)
	private String refDate;

	@NativeQueryResultColumn(index = 11)
	private String oldOffice;

	@NativeQueryResultColumn(index = 12)
	private String newOffice;

	/** The recored. */
	@NativeQueryResultColumn(index = 13)
	private String recored;

	/**
	 * @return the eventId
	 */
	public long getEventId() {
		return eventId;
	}

	/**
	 * @return the transacNumber
	 */
	public String getTransacNumber() {
		return transacNumber;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @return the eventDate
	 */
	public String getEventDate() {
		return eventDate;
	}

	/**
	 * @return the approvalDate
	 */
	public String getApprovalDate() {
		return approvalDate;
	}

	/**
	 * @return the empId
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * @return the designationId
	 */
	public String getDesignationId() {
		return designationId;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * @return the tranRelievingDate
	 */
	public String getTranRelievingDate() {
		return tranRelievingDate;
	}

	/**
	 * @return the refDate
	 */
	public String getRefDate() {
		return refDate;
	}

	/**
	 * @return the oldOffice
	 */
	public String getOldOffice() {
		return oldOffice;
	}

	/**
	 * @return the newOffice
	 */
	public String getNewOffice() {
		return newOffice;
	}

	/**
	 * @return the recored
	 */
	public String getRecored() {
		return recored;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	/**
	 * @param transacNumber the transacNumber to set
	 */
	public void setTransacNumber(String transacNumber) {
		this.transacNumber = transacNumber;
	}

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * @param approvalDate the approvalDate to set
	 */
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * @param tranRelievingDate the tranRelievingDate to set
	 */
	public void setTranRelievingDate(String tranRelievingDate) {
		this.tranRelievingDate = tranRelievingDate;
	}

	/**
	 * @param refDate the refDate to set
	 */
	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

	/**
	 * @param oldOffice the oldOffice to set
	 */
	public void setOldOffice(String oldOffice) {
		this.oldOffice = oldOffice;
	}

	/**
	 * @param newOffice the newOffice to set
	 */
	public void setNewOffice(String newOffice) {
		this.newOffice = newOffice;
	}

	/**
	 * @param recored the recored to set
	 */
	public void setRecored(String recored) {
		this.recored = recored;
	}

}
