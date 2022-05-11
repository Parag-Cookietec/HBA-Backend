package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class PVUJoiningEmployeeView.
 */
@NativeQueryResultEntity
public class PVUTransferEmployeeView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String transNo;

	/** The emp id. */
	@NativeQueryResultColumn(index = 1)
	private Long empNo;

	/** The emp name. */
	@NativeQueryResultColumn(index = 2)
	private String empName;

	/** The designation. */
	@NativeQueryResultColumn(index = 3)
	private String designation;

	/** The office name. */
	@NativeQueryResultColumn(index = 4)
	private String officeName;


	/** The end date. */
	@NativeQueryResultColumn(index = 5)
	private Date relivingDate;

	/** The no of days. */
	@NativeQueryResultColumn(index = 6)
	private String status;

	@NativeQueryResultColumn(index = 7)
	private String workflowAction;

	@NativeQueryResultColumn(index = 8)
	private String workflowStatus;

	@NativeQueryResultColumn(index = 9)
	private int isEditable;

	@NativeQueryResultColumn(index = 10)
	private long empId;

	@NativeQueryResultColumn(index = 11)
	private long transId;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@NativeQueryResultColumn(index = 5)
	private Date createdDate;

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public Date getRelivingDate() {
		return relivingDate;
	}

	public void setRelivingDate(Date relivingDate) {
		this.relivingDate = relivingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWorkflowAction() {
		return workflowAction;
	}

	public void setWorkflowAction(String workflowAction) {
		this.workflowAction = workflowAction;
	}

	public String getWorkflowStatus() {
		return workflowStatus;
	}

	public void setWorkflowStatus(String workflowStatus) {
		this.workflowStatus = workflowStatus;
	}

	public int getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(int isEditable) {
		this.isEditable = isEditable;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public long getTransId() {
		return transId;
	}

	public void setTransId(long transId) {
		this.transId = transId;
	}
}
