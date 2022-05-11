package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class MISOutwardCaseForEventCountView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String eventName;
	
	@NativeQueryResultColumn(index = 1)
	private Long outwardCases;
	
	@NativeQueryResultColumn(index = 2)
	private Long eventId;

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Long getOutwardCases() {
		return outwardCases;
	}

	public void setOutwardCases(Long outwardCases) {
		this.outwardCases = outwardCases;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}





	
	
	
	
}
