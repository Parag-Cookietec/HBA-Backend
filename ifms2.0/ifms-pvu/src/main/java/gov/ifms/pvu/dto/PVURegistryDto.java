package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVURegistryDto.
 * 
 * @version v 1.0
 * @created 2020/01/12 12:05:26
 *
 */
public class PVURegistryDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event io id. */

	private long eventIoId;

	/** The emp id. */
	private long empId;

	/** The trans id. */
	private long transId;

	/** The event id. */
	private long id;

	/** The inward date. */
	private Date inwardDate;

	/** The inward number. */
	private long inwardNumber;

	/** The outward date. */
	private Date outwardDate;

	/** The outward number. */
	private long outwardNumber;

	/** The status id. */
	private long statusId;

	/**
	 * Gets the event io id.
	 *
	 * @return the event io id
	 */
	public long getEventIoId() {
		return eventIoId;
	}

	/**
	 * Sets the event io id.
	 *
	 * @param eventIoId the new event io id
	 */
	public void setEventIoId(long eventIoId) {
		this.eventIoId = eventIoId;
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
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the trans id.
	 *
	 * @return the trans id
	 */
	public long getTransId() {
		return transId;
	}

	/**
	 * Sets the trans id.
	 *
	 * @param transId the new trans id
	 */
	public void setTransId(long transId) {
		this.transId = transId;
	}

	/**
	 * Gets the event id.
	 *
	 * @return the event id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the event id.
	 *
	 * @param id the new event id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the inward date.
	 *
	 * @return the inward date
	 */
	public Date getInwardDate() {
		return inwardDate;
	}

	/**
	 * Sets the inward date.
	 *
	 * @param inwardDate the new inward date
	 */
	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
	}

	/**
	 * Gets the inward number.
	 *
	 * @return the inward number
	 */
	public long getInwardNumber() {
		return inwardNumber;
	}

	/**
	 * Sets the inward number.
	 *
	 * @param inwardNumber the new inward number
	 */
	public void setInwardNumber(long inwardNumber) {
		this.inwardNumber = inwardNumber;
	}

	/**
	 * Gets the outward date.
	 *
	 * @return the outward date
	 */
	public Date getOutwardDate() {
		return outwardDate;
	}

	/**
	 * Sets the outward date.
	 *
	 * @param outwardDate the new outward date
	 */
	public void setOutwardDate(Date outwardDate) {
		this.outwardDate = outwardDate;
	}

	/**
	 * Gets the outward number.
	 *
	 * @return the outward number
	 */
	public long getOutwardNumber() {
		return outwardNumber;
	}

	/**
	 * Sets the outward number.
	 *
	 * @param outwardNumber the new outward number
	 */
	public void setOutwardNumber(long outwardNumber) {
		this.outwardNumber = outwardNumber;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVURegistryDto [eventIoId=" + eventIoId + ", empId=" + empId + ", transId=" + transId + ", id="
				+ id + ", inwardDate=" + inwardDate + ", inwardNumber=" + inwardNumber + ", outwardDate="
				+ outwardDate + ", outwardNumber=" + outwardNumber + ", statusId=" + statusId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, eventIoId, id, inwardDate, inwardNumber, outwardDate, outwardNumber, statusId,
				transId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVURegistryDto other = (PVURegistryDto) obj;
		return empId == other.empId && eventIoId == other.eventIoId && id == other.id
				&& Objects.equals(inwardDate, other.inwardDate) && inwardNumber == other.inwardNumber
				&& Objects.equals(outwardDate, other.outwardDate) && outwardNumber == other.outwardNumber
				&& statusId == other.statusId && transId == other.transId;
	}

	/**
	 * PVURegistryDto Constructor.
	 */
	public PVURegistryDto() {
		super();
	}

}
