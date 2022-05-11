package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Class PVURegistryEntity.
 * 
 * @version v 1.0
 * @created 2020/01/12 12:05:26
 *
 */
@Entity
@Table(name = "T_PVU_EVENT_IO", schema = Constant.PVU_SCHEMA)
public class PVURegistryEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event io id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_EVENT_IO_ID")
	private long eventIoId;

	/** The emp id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", nullable = false, referencedColumnName = "EMP_ID")
	private PVUEmployeEntity empId;

	/** The trans id. */
	@Column(name = "TRANSACTION_ID")
	private long transId;

	/** The event id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EVENT_ID", nullable = false, referencedColumnName = "MS_PVU_EVENTS_ID")
	private PVUMsEventEntity id;

	/** The inward date. */
	@Column(name = "INWARD_DATE")
	private Date inwardDate;

	/** The inward number. */
	@Column(name = "INWARD_NUMBER")
	private long inwardNumber;

	/** The outward date. */
	@Column(name = "OUTWARD_DATE")
	private Date outwardDate;

	/** The outward number. */
	@Column(name = "OUTWARD_NUMBER")
	private long outwardNumber;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

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
	public PVUEmployeEntity getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(PVUEmployeEntity empId) {
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
	public PVUMsEventEntity getId() {
		return id;
	}

	/**
	 * Sets the event id.
	 *
	 * @param id the new event id
	 */
	public void setId(PVUMsEventEntity id) {
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
	 * @return the statusId
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(empId, eventIoId, id, inwardDate, inwardNumber, outwardDate, outwardNumber, statusId,
				transId);
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
		if (!(obj instanceof PVURegistryEntity)) {
			return false;
		}
		PVURegistryEntity other = (PVURegistryEntity) obj;
		return Objects.equals(empId, other.empId) && eventIoId == other.eventIoId && Objects.equals(id, other.id)
				&& Objects.equals(inwardDate, other.inwardDate) && inwardNumber == other.inwardNumber
				&& Objects.equals(outwardDate, other.outwardDate) && outwardNumber == other.outwardNumber
				&& Objects.equals(statusId, other.statusId) && transId == other.transId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVURegistryEntity [eventIoId=" + eventIoId + ", empId=" + empId + ", transId=" + transId + ", id=" + id
				+ ", inwardDate=" + inwardDate + ", inwardNumber=" + inwardNumber + ", outwardDate=" + outwardDate
				+ ", outwardNumber=" + outwardNumber + ", statusId=" + statusId + "]";
	}

	/**
	 * PVURegistryEntity Constructor.
	 */
	public PVURegistryEntity() {
		super();
	}

}
