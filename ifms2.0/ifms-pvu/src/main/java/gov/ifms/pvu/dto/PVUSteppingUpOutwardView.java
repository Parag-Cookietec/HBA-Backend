package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUSteppingUpInwardView.
 */
@NativeQueryResultEntity
public class PVUSteppingUpOutwardView implements Serializable {

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

	public String getTrnStatus() {
		return trnStatus;
	}

	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}


	



}
