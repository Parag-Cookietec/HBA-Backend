package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class PVUShettyPayOutwardView implements Serializable {

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

	/**
	 * @return the recordCount
	 */
	public String getRecordCount() {
		return recordCount;
	}

	/**
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * @return the outWardNo
	 */
	public String getOutWardNo() {
		return outWardNo;
	}

	/**
	 * @param outWardNo the outWardNo to set
	 */
	public void setOutWardNo(String outWardNo) {
		this.outWardNo = outWardNo;
	}

	/**
	 * @return the outWardDate
	 */
	public Date getOutWardDate() {
		return outWardDate;
	}

	/**
	 * @param outWardDate the outWardDate to set
	 */
	public void setOutWardDate(Date outWardDate) {
		this.outWardDate = outWardDate;
	}

	public String getPostConsignmentNumber() {
		return postConsignmentNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authDate, employeeName, employeeNo, id, officeName, outWardDate, outWardNo, outwardCount,
				outwardFlag, postConsignmentNumber, recordCount, returnDate, status, trnStatus, wfStatus);
	}

	public void setPostConsignmentNumber(String postConsignmentNumber) {
		this.postConsignmentNumber = postConsignmentNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUShettyPayOutwardView)) {
			return false;
		}
		PVUShettyPayOutwardView other = (PVUShettyPayOutwardView) obj;
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

	/**
	 * @return the employeeNo
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the authDate
	 */
	public Date getAuthDate() {
		return authDate;
	}

	/**
	 * @param authDate the authDate to set
	 */
	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}

	/**
	 * @return the returnDate
	 */
	public Date getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the trnStatus
	 */
	public String getTrnStatus() {
		return trnStatus;
	}

	/**
	 * @param trnStatus the trnStatus to set
	 */
	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	/**
	 * @return the wfStatus
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * @param wfStatus the wfStatus to set
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * @return the outwardCount
	 */
	public int getOutwardCount() {
		return outwardCount;
	}

	/**
	 * @param outwardCount the outwardCount to set
	 */
	public void setOutwardCount(int outwardCount) {
		this.outwardCount = outwardCount;
	}

	/**
	 * @return the outwardFlag
	 */
	public int getOutwardFlag() {
		return outwardFlag;
	}

	/**
	 * @param outwardFlag the outwardFlag to set
	 */
	public void setOutwardFlag(int outwardFlag) {
		this.outwardFlag = outwardFlag;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
