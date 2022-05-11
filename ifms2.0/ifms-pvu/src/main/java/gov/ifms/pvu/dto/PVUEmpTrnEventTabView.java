package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUEmployeEventView.
 */
@NativeQueryResultEntity
public class PVUEmpTrnEventTabView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event id. */
	@NativeQueryResultColumn(index = 0)
	private long eventId;

	/** The transac number. */
	@NativeQueryResultColumn(index = 1)
	private String trnNo;

	/** The designation. */
	@NativeQueryResultColumn(index = 2)
	private String designationId;

	/** The designation. */
	@NativeQueryResultColumn(index = 3)
	private String designation;

	/** The sus start date. */
	@NativeQueryResultColumn(index = 4)
	private String fromLocation;

	/** The sus end date. */
	@NativeQueryResultColumn(index = 5)
	private String toLocation;

	/** The event date. */
	@NativeQueryResultColumn(index = 6)
	private String relievingDate;

	/** The approval date. */
	@NativeQueryResultColumn(index = 7)
	private String status;

	@NativeQueryResultColumn(index = 8)
	private String recored;

	@NativeQueryResultColumn(index = 9)
	private String eventCode;

	@NativeQueryResultColumn(index = 10)
	private String visibleFlag;

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getDesignationId() {
		return designationId;
	}

	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRecored() {
		return recored;
	}

	public void setRecored(String recored) {
		this.recored = recored;
	}

	/**
	 * @return the relievingDate
	 */
	public String getRelievingDate() {
		return relievingDate;
	}

	/**
	 * @param relievingDate the relievingDate to set
	 */
	public void setRelievingDate(String relievingDate) {
		this.relievingDate = relievingDate;
	}

	/**
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}

	/**
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(designation, designationId, eventCode, eventId, fromLocation, recored, relievingDate,
				status, toLocation, trnNo, visibleFlag);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUEmpTrnEventTabView)) {
			return false;
		}
		PVUEmpTrnEventTabView other = (PVUEmpTrnEventTabView) obj;
		return Objects.equals(designation, other.designation) && Objects.equals(designationId, other.designationId)
				&& Objects.equals(eventCode, other.eventCode) && eventId == other.eventId
				&& Objects.equals(fromLocation, other.fromLocation) && Objects.equals(recored, other.recored)
				&& Objects.equals(relievingDate, other.relievingDate) && Objects.equals(status, other.status)
				&& Objects.equals(toLocation, other.toLocation) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(visibleFlag, other.visibleFlag);
	}

	/**
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * @return the visibleFlag
	 */
	public String getVisibleFlag() {
		return visibleFlag;
	}

	/**
	 * @param visibleFlag the visibleFlag to set
	 */
	public void setVisibleFlag(String visibleFlag) {
		this.visibleFlag = visibleFlag;
	}

}
