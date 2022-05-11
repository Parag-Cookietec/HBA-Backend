package gov.ifms.pvu.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUCSPOutwardView {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trans no. */
	@JsonIgnore
	@NativeQueryResultColumn(index = 0)
	private long recordCount;

	/** The trans no. */
	@NativeQueryResultColumn(index = 1)
	private String outWardNo;

	/** The inward date. */
	@NativeQueryResultColumn(index = 2)
	private Date outWardDate;

	/** The inward number. */
	@NativeQueryResultColumn(index = 3)
	private String postConsignmentNumber;

	/** The employee no. */
	@NativeQueryResultColumn(index = 4)
	private String employeeNo;

	/** The employee name. */
	@NativeQueryResultColumn(index = 5)
	private String employeeName;

	/** The designation. */
	@NativeQueryResultColumn(index = 6)
	private Date authDate;

	/** The designation. */
	@NativeQueryResultColumn(index = 7)
	private Date returnDate;

	/** The office name. */
	@NativeQueryResultColumn(index = 8)
	private String officeName;

	/** The office name. */
	@NativeQueryResultColumn(index = 9)
	private Long id;

	/** The office name. */
	@NativeQueryResultColumn(index = 10)
	private String trnStatus;

	/** The wf status. */
	@NativeQueryResultColumn(index = 11)
	private String wfStatus;

	@JsonIgnore
	@NativeQueryResultColumn(index = 12)
	private int outWardCount;

	@NativeQueryResultColumn(index = 13)
	private Long outwardFlag;

	@NativeQueryResultColumn(index = 14)
	private String status;

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}


	/**
	 * @return the postConsignmentNumber
	 */
	public String getPostConsignmentNumber() {
		return postConsignmentNumber;
	}

	/**
	 * @param postConsignmentNumber the postConsignmentNumber to set
	 */
	public void setPostConsignmentNumber(String postConsignmentNumber) {
		this.postConsignmentNumber = postConsignmentNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrnStatus() {
		return trnStatus;
	}

	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	public int getOutWardCount() {
		return outWardCount;
	}

	public void setOutWardCount(int outWardCount) {
		this.outWardCount = outWardCount;
	}

	public Long getOutwardFlag() {
		return outwardFlag;
	}

	public void setOutwardFlag(Long outwardFlag) {
		this.outwardFlag = outwardFlag;
	}

	public String getOutWardNo() {
		return outWardNo;
	}

	public void setOutWardNo(String outWardNo) {
		this.outWardNo = outWardNo;
	}

	public Date getOutWardDate() {
		return outWardDate;
	}

	public void setOutWardDate(Date outWardDate) {
		this.outWardDate = outWardDate;
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

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

}
