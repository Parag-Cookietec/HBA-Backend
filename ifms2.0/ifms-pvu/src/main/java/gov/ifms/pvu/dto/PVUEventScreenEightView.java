package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUEventScreenEightView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event traNo. */
	@NativeQueryResultColumn(index = 0)
	private String traNo;

	/** The event empNo. */
	@NativeQueryResultColumn(index = 1)
	private String empNo;

	/** The event empName. */
	@NativeQueryResultColumn(index = 2)
	private String empName;

	/** The event designation. */
	@NativeQueryResultColumn(index = 3)
	private String designation;

	/** The event empType. */
	@NativeQueryResultColumn(index = 4)
	private String empType;

	/** The event officeName. */
	@NativeQueryResultColumn(index = 5)
	private String officeName;

	/** The event status. */
	@NativeQueryResultColumn(index = 6)
	private String status;

	/** The event eventCode. */
	@NativeQueryResultColumn(index = 7)
	private String eventCode;

	/** The event recordsCount. */
	@NativeQueryResultColumn(index = 8)
	private String recordsCount;

	/** The event id. */
	@NativeQueryResultColumn(index = 9)
	private String eventId;

	/** The event eventUpdateDate. */
	@NativeQueryResultColumn(index = 10)
	private String eventUpdateDate;

	/** The event isEdit. */
	@NativeQueryResultColumn(index = 11)
	private String isEdit;
	
	@NativeQueryResultColumn(index = 12)
	private String wfStatus;

	@NativeQueryResultColumn(index = 13)
	private String eventName;

	public String getTraNo() {
		return traNo;
	}

	public void setTraNo(String traNo) {
		this.traNo = traNo;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getRecordsCount() {
		return recordsCount;
	}

	public void setRecordsCount(String recordsCount) {
		this.recordsCount = recordsCount;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventUpdateDate() {
		return eventUpdateDate;
	}

	public void setEventUpdateDate(String eventUpdateDate) {
		this.eventUpdateDate = eventUpdateDate;
	}

	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
}