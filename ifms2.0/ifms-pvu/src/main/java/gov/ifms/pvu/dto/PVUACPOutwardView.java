package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class PVUACPOutwardView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trans no. */
	@NativeQueryResultColumn(index = 0)
	private String recordCount;

	/** The inward number. */
	@NativeQueryResultColumn(index = 1)
	private String outWardNo;

	/** The inward date. */
	@NativeQueryResultColumn(index = 2)
	private Date outWardDate;

	/** The POST_CONSIGNMENT_NO */
	@NativeQueryResultColumn(index = 3)
	private String postConsignmentNumber;

	/** The employee no. */
	@NativeQueryResultColumn(index = 4)
	private String employeeNo;

	/** The employee name. */
	@NativeQueryResultColumn(index = 5)
	private String employeeName;

	/** The auth date. */
	@NativeQueryResultColumn(index = 6)
	private Date authDate;

	/** The return date. */
	@NativeQueryResultColumn(index = 7)
	private Date returnDate;

	/** The office name. */
	@NativeQueryResultColumn(index = 8)
	private String officeName;

	/** The trans no. */
	@NativeQueryResultColumn(index = 9)
	private int id;

	/** The wf status. */
	@NativeQueryResultColumn(index = 10)
	private String trnStatus;

	/** The wf status. */
	@NativeQueryResultColumn(index = 11)
	private String wfStatus;

	@NativeQueryResultColumn(index = 12)
	private int outwardCount;

	@NativeQueryResultColumn(index = 13)
	private int outwardFlag;

	@NativeQueryResultColumn(index = 14)
	private String status;

	public String getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
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

	

	public String getPostConsignmentNumber() {
		return postConsignmentNumber;
	}

	public void setPostConsignmentNumber(String postConsignmentNumber) {
		this.postConsignmentNumber = postConsignmentNumber;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrnStatus() {
		return trnStatus;
	}

	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public int getOutwardCount() {
		return outwardCount;
	}

	public void setOutwardCount(int outwardCount) {
		this.outwardCount = outwardCount;
	}

	public int getOutwardFlag() {
		return outwardFlag;
	}

	public void setOutwardFlag(int outwardFlag) {
		this.outwardFlag = outwardFlag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authDate, employeeName, employeeNo, id, officeName, outWardDate, outWardNo, outwardCount,
				outwardFlag, postConsignmentNumber, recordCount, returnDate, status, trnStatus, wfStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUACPOutwardView other = (PVUACPOutwardView) obj;
		return Objects.equals(authDate, other.authDate) && Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(employeeNo, other.employeeNo) && id == other.id
				&& Objects.equals(officeName, other.officeName) && Objects.equals(outWardDate, other.outWardDate)
				&& Objects.equals(outWardNo, other.outWardNo) && outwardCount == other.outwardCount
				&& outwardFlag == other.outwardFlag
				&& Objects.equals(postConsignmentNumber, other.postConsignmentNumber)
				&& Objects.equals(recordCount, other.recordCount) && Objects.equals(returnDate, other.returnDate)
				&& Objects.equals(status, other.status) && Objects.equals(trnStatus, other.trnStatus)
				&& Objects.equals(wfStatus, other.wfStatus);
	}

	@Override
	public String toString() {
		return "PVUACPOutwardView [recordCount=" + recordCount + ", outWardNo=" + outWardNo + ", outWardDate="
				+ outWardDate + ", postConsignmentNumber=" + postConsignmentNumber + ", employeeNo=" + employeeNo
				+ ", employeeName=" + employeeName + ", authDate=" + authDate + ", returnDate=" + returnDate
				+ ", officeName=" + officeName + ", id=" + id + ", trnStatus=" + trnStatus + ", wfStatus=" + wfStatus
				+ ", outwardCount=" + outwardCount + ", outwardFlag=" + outwardFlag + ", status=" + status + "]";
	}

	
	
		
	
		
	
}
