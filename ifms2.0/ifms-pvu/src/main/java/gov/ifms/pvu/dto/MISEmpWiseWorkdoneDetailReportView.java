package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.common.util.Utils;

/**
 * 
 * MISEmpWiseWorkdoneDetailReportView class
 */
@NativeQueryResultEntity
public class MISEmpWiseWorkdoneDetailReportView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The Constant serialVersionUID. */

	@NativeQueryResultColumn(index = 0)
	private Long totalRowCount;

	@NativeQueryResultColumn(index = 1)
	private String employeeNo;

	@NativeQueryResultColumn(index = 2)
	private String employeeName;

	@NativeQueryResultColumn(index = 3)
	private String pPan;

	@NativeQueryResultColumn(index = 4)
	private String gpf;

	@NativeQueryResultColumn(index = 5)
	private String officeName;

	@NativeQueryResultColumn(index = 6)
	private String endorsement;

	@NativeQueryResultColumn(index = 7)
	private String status;

	@NativeQueryResultColumn(index = 8)
	private String lyingWith;

	@NativeQueryResultColumn(index = 9)
	private Date inwardDate;

	@NativeQueryResultColumn(index = 10)
	private Date authDate;

	@NativeQueryResultColumn(index = 11)
	private Date returnDate;

	@NativeQueryResultColumn(index = 12)
	private Date outwardDate;

	@NativeQueryResultColumn(index = 13)
	private String eventType;

	@NativeQueryResultColumn(index = 14)
	private String trnId;

	@NativeQueryResultColumn(index = 15)
	private String eventCode;

	@NativeQueryResultColumn(index = 16)
	private String remarks;

	
	
	public Long getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(Long totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

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
		return !Utils.isEmpty(gpf) ? gpf : String.valueOf(pPan);
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

	public Date getAuthDate() {
		return authDate;
	}

	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getOutwardDate() {
		return outwardDate;
	}

	public void setOutwardDate(Date outwardDate) {
		this.outwardDate = outwardDate;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getTrnId() {
		return trnId;
	}

	public void setTrnId(String trnId) {
		this.trnId = trnId;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
