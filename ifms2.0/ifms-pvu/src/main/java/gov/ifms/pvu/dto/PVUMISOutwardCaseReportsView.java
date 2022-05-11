package gov.ifms.pvu.dto;


import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.common.util.Utils;



@NativeQueryResultEntity
public class PVUMISOutwardCaseReportsView implements Serializable{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
	
	
	@NativeQueryResultColumn(index = 0)
    private Long employeeNo;
	@NativeQueryResultColumn(index = 1)
    private String employeeName;
	@NativeQueryResultColumn(index = 2)
    private String ppanNo;
	@NativeQueryResultColumn(index = 3)
    private String gpfNo;
	@NativeQueryResultColumn(index = 4)
    private String officeName;
	@NativeQueryResultColumn(index = 5)
    private String endorsment;
	@NativeQueryResultColumn(index = 6)
    private String status;
	@NativeQueryResultColumn(index = 7)
    private String lyingwith;
	@NativeQueryResultColumn(index = 8)
    private Date inwardDate;
	@NativeQueryResultColumn(index = 9)
    private Date authDate;
	@NativeQueryResultColumn(index = 10)
    private Date returnDate;
	@NativeQueryResultColumn(index = 11)
    private Date outwardDate;
	@NativeQueryResultColumn(index = 12)
    private String eventName;
	
	
	public Long getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPpanNo() {
		return ppanNo;
	}
	public void setPpanNo(String ppanNo) {
		this.ppanNo = ppanNo;
	}
	public String getGpfNo() {
		return !Utils.isEmpty(gpfNo)  ?  gpfNo :  String.valueOf(ppanNo) ;
	}
	public void setGpfNo(String gpfNo) {
		this.gpfNo = gpfNo;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getEndorsment() {
		return endorsment;
	}
	public void setEndorsment(String endorsment) {
		this.endorsment = endorsment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLyingwith() {
		return lyingwith;
	}
	public void setLyingwith(String lyingwith) {
		this.lyingwith = lyingwith;
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
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	
}