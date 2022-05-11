package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUIncrementListView.
 */
@NativeQueryResultEntity
public class PVUIncrementListView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event id. */
	@NativeQueryResultColumn(index = 0)
	private long eventId;

	/** The tran no. */
	@NativeQueryResultColumn(index = 1)
	private String tranNo;

	/** The tran status. */
	@NativeQueryResultColumn(index = 2)
	private String tranStatus;

	/** The increment for. */
	@NativeQueryResultColumn(index = 3)
	private String incrementFor;

	/** The increment type. */
	@NativeQueryResultColumn(index = 4)
	private String incrementType;

	/** The class id. */
	@NativeQueryResultColumn(index = 5)
	private String classId;

	/** The wf status. */
	@NativeQueryResultColumn(index = 6)
	private String wfStatus;

	/** The emp type. */
	@NativeQueryResultColumn(index = 7)
	private String empType;

	/** The record count. */
	@NativeQueryResultColumn(index = 8)
	private long recordCount;

	/** The isEditable. */
	@NativeQueryResultColumn(index = 9)
	private long isEditable;

	/** The updated date. */
	@NativeQueryResultColumn(index = 10)
	private Date updatedDate;

	/** The isEditable. */
	@NativeQueryResultColumn(index = 11)
	private String empPayType;

	/** The status. */
	@NativeQueryResultColumn(index = 12)
	private String status;

	/** The delete flag. */
	@NativeQueryResultColumn(index = 13)
	private Integer deleteFlag;

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
	 * Gets the tran no.
	 *
	 * @return the tranNo
	 */
	public String getTranNo() {
		return tranNo;
	}

	/**
	 * Sets the tran no.
	 *
	 * @param tranNo the tranNo to set
	 */
	public void setTranNo(String tranNo) {
		this.tranNo = tranNo;
	}

	/**
	 * Gets the tran status.
	 *
	 * @return the tranStatus
	 */
	public String getTranStatus() {
		return tranStatus;
	}

	/**
	 * Sets the tran status.
	 *
	 * @param tranStatus the tranStatus to set
	 */
	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}

	/**
	 * Gets the increment for.
	 *
	 * @return the incrementFor
	 */
	public String getIncrementFor() {
		return incrementFor;
	}

	/**
	 * Sets the increment for.
	 *
	 * @param incrementFor the incrementFor to set
	 */
	public void setIncrementFor(String incrementFor) {
		this.incrementFor = incrementFor;
	}

	/**
	 * Gets the increment type.
	 *
	 * @return the incrementType
	 */
	public String getIncrementType() {
		return incrementType;
	}

	/**
	 * Sets the increment type.
	 *
	 * @param incrementType the incrementType to set
	 */
	public void setIncrementType(String incrementType) {
		this.incrementType = incrementType;
	}

	/**
	 * Gets the wf status.
	 *
	 * @return the wfStatus
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * Sets the wf status.
	 *
	 * @param wfStatus the wfStatus to set
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * Gets the emp type.
	 *
	 * @return the empType
	 */
	public String getEmpType() {
		return empType;
	}

	/**
	 * Sets the emp type.
	 *
	 * @param empType the empType to set
	 */
	public void setEmpType(String empType) {
		this.empType = empType;
	}

	/**
	 * Gets the record count.
	 *
	 * @return the recordCount
	 */
	public long getRecordCount() {
		return recordCount;
	}

	/**
	 * Sets the record count.
	 *
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * Gets the class id.
	 *
	 * @return the classId
	 */
	public String getClassId() {
		return classId;
	}

	/**
	 * Sets the class id.
	 *
	 * @param classId the classId to set
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}

	/**
	 * Gets the checks if is editable.
	 *
	 * @return the isEditable
	 */
	public long getIsEditable() {
		return isEditable;
	}

	/**
	 * Sets the checks if is editable.
	 *
	 * @param isEditable the isEditable to set
	 */
	public void setIsEditable(long isEditable) {
		this.isEditable = isEditable;
	}

	/**
	 * Gets the updated date.
	 *
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Sets the updated date.
	 *
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * Gets the emp pay type.
	 *
	 * @return the empPayType
	 */
	public String getEmpPayType() {
		return empPayType;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the delete flag.
	 *
	 * @return the deleteFlag
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * Sets the delete flag.
	 *
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * Sets the emp pay type.
	 *
	 * @param empPayType the empPayType to set
	 */
	public void setEmpPayType(String empPayType) {
		this.empPayType = empPayType;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(classId, deleteFlag, empPayType, empType, eventId, incrementFor, incrementType, isEditable,
				recordCount, status, tranNo, tranStatus, updatedDate, wfStatus);
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
		if (!(obj instanceof PVUIncrementListView)) {
			return false;
		}
		PVUIncrementListView other = (PVUIncrementListView) obj;
		return Objects.equals(classId, other.classId) && Objects.equals(deleteFlag, other.deleteFlag)
				&& Objects.equals(empPayType, other.empPayType) && Objects.equals(empType, other.empType)
				&& eventId == other.eventId && Objects.equals(incrementFor, other.incrementFor)
				&& Objects.equals(incrementType, other.incrementType) && isEditable == other.isEditable
				&& recordCount == other.recordCount && Objects.equals(status, other.status)
				&& Objects.equals(tranNo, other.tranNo) && Objects.equals(tranStatus, other.tranStatus)
				&& Objects.equals(updatedDate, other.updatedDate) && Objects.equals(wfStatus, other.wfStatus);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format(
				"PVUIncrementListView [eventId=%s, tranNo=%s, tranStatus=%s, incrementFor=%s, incrementType=%s, classId=%s, wfStatus=%s, empType=%s, recordCount=%s, isEditable=%s, updatedDate=%s, empPayType=%s, status=%s, deleteFlag=%s]",
				eventId, tranNo, tranStatus, incrementFor, incrementType, classId, wfStatus, empType, recordCount,
				isEditable, updatedDate, empPayType, status, deleteFlag);
	}

}
