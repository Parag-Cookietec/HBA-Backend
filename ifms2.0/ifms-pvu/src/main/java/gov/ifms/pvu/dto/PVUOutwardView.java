package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUSSPInwardView.
 */
@NativeQueryResultEntity
public class PVUOutwardView implements Serializable {

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


	public int getOutWardCount() {
		return outWardCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getOutwardFlag() {
		return outwardFlag;
	}

	public void setOutwardFlag(Long outwardFlag) {
		this.outwardFlag = outwardFlag;
	}

	/**
	 * @param outWardCount outWardCount
	 */
	public void setOutWardCount(int outWardCount) {
		this.outWardCount = outWardCount;
	}

	/**
	 * Gets the trans no.
	 *
	 * @return the trans no
	 */
	public String getOutWardNo() {
		return outWardNo;
	}

	/**
	 * Sets the trans no.
	 *
	 * @param outWardNo the new trans no
	 */
	public void setOutWardNo(String outWardNo) {
		this.outWardNo = outWardNo;
	}

	/**
	 * Gets the inward date.
	 *
	 * @return the inward date
	 */
	public Date getOutWardDate() {
		return outWardDate;
	}

	/**
	 * Sets the inward date.
	 *
	 * @param outWardDate the new inward date
	 */
	public void setOutWardDate(Date outWardDate) {
		this.outWardDate = outWardDate;
	}

	/**
	 * Gets the inward number.
	 *
	 * @return the inward number
	 */
	public String getPostConsignmentNumber() {
		return postConsignmentNumber;
	}

	/**
	 * Sets the inward number.
	 *
	 * @param postConsignmentNumber the new inward number
	 */
	public void setPostConsignmentNumber(String postConsignmentNumber) {
		this.postConsignmentNumber = postConsignmentNumber;
	}

	/**
	 * Gets the employee no.
	 *
	 * @return the employee no
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * Sets the employee no.
	 *
	 * @param employeeNo the new employee no
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * Gets the employee name.
	 *
	 * @return the employee name
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * Sets the employee name.
	 *
	 * @param employeeName the new employee name
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public Date getAuthDate() {
		return authDate;
	}

	/**
	 * Sets the designation.
	 *
	 * @param authDate the new designation
	 */
	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the office name
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the new office name
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the rop event id.
	 *
	 * @return the rop event id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the rop event id.
	 *
	 * @param id the new rop event id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the wf status.
	 *
	 * @return the wf status
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * Sets the wf status.
	 *
	 * @param wfStatus the new wf status
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getTrnStatus() {
		return trnStatus;
	}

	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PVUOutwardView that = (PVUOutwardView) o;
		return recordCount == that.recordCount &&
				outWardCount == that.outWardCount &&
				Objects.equals(outWardNo, that.outWardNo) &&
				Objects.equals(outWardDate, that.outWardDate) &&
				Objects.equals(postConsignmentNumber, that.postConsignmentNumber) &&
				Objects.equals(employeeNo, that.employeeNo) &&
				Objects.equals(employeeName, that.employeeName) &&
				Objects.equals(authDate, that.authDate) &&
				Objects.equals(returnDate, that.returnDate) &&
				Objects.equals(officeName, that.officeName) &&
				Objects.equals(id, that.id) &&
				Objects.equals(trnStatus, that.trnStatus) &&
				Objects.equals(wfStatus, that.wfStatus);
	}

	@Override
	public int hashCode() {
		return Objects.hash(recordCount, outWardNo, outWardDate, postConsignmentNumber, employeeNo, employeeName, authDate, returnDate, officeName, id, trnStatus, wfStatus, outWardCount);
	}

	@Override
	public String toString() {
		return "PVUOutwardView{" +
				"recordCount=" + recordCount +
				", outWardNo='" + outWardNo + '\'' +
				", outWardDate=" + outWardDate +
				", postConsignmentNo='" + postConsignmentNumber + '\'' +
				", employeeNo='" + employeeNo + '\'' +
				", employeeName='" + employeeName + '\'' +
				", authDate=" + authDate +
				", returnDate=" + returnDate +
				", officeName='" + officeName + '\'' +
				", id=" + id +
				", trnStatus='" + trnStatus + '\'' +
				", wfStatus='" + wfStatus + '\'' +
				", outWardCount=" + outWardCount +
				'}';
	}
}
