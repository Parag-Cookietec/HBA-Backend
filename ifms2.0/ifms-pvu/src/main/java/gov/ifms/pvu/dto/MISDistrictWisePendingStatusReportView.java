package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class MISDistrictWisePendingStatusReportView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String employeeNo;
	
	@NativeQueryResultColumn(index = 1)
	private String employeeName;

	@NativeQueryResultColumn(index = 2)
	private String pPan;

	@NativeQueryResultColumn(index = 3)
	private String gpf;
	
	@NativeQueryResultColumn(index = 4)
	private String officeName;
	
	@NativeQueryResultColumn(index = 5)
	private String endorsement;
	
	@NativeQueryResultColumn(index = 6)
	private String status;
	
	@NativeQueryResultColumn(index = 7)
	private String lyingWith;
	
	@NativeQueryResultColumn(index = 8)
	private Date inwardDate;
	
	@NativeQueryResultColumn(index = 9)
	private String eventName;

	@NativeQueryResultColumn(index = 10)
	private Date createdDate;

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getpPan() {
		return pPan;
	}

	public void setpPan(String pPan) {
		this.pPan = pPan;
	}

	public String getGpf() {
		return gpf;
	}

	public void setGpf(String gpf) {
		this.gpf = gpf;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getEndorsement() {
		return endorsement;
	}

	public void setEndorsement(String endorsement) {
		this.endorsement = endorsement;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLyingWith() {
		return lyingWith;
	}

	public void setLyingWith(String lyingWith) {
		this.lyingWith = lyingWith;
	}

	public Date getInwardDate() {
		return inwardDate;
	}

	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}





	
	
	
	
}
