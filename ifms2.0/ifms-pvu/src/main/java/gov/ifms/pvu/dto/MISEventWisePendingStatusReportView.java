package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class MISEventWisePendingStatusReportView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String eventName;
	
	@NativeQueryResultColumn(index = 1)
	private Long eventId;
	
	@NativeQueryResultColumn(index = 2)
	private Long pendingCases;

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getPendingCases() {
		return pendingCases;
	}

	public void setPendingCases(Long pendingCases) {
		this.pendingCases = pendingCases;
	}
	

	
	
	
}
