package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUSteppingUpInwardView.
 */
@NativeQueryResultEntity
public class PVUSteppingUpInwardView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	
	/** The RECORD_COUNT. */
	@NativeQueryResultColumn(index = 0)
	private int recordCount;

	/** The TRN_NO. */
	@NativeQueryResultColumn(index = 1)
	private String transNo;

	@NativeQueryResultColumn(index = 2)
	private Date inwardDate;

	/** The employee no. */
	@NativeQueryResultColumn(index = 3)
	private String inwardNumber;

	/** The employee name. */
	@NativeQueryResultColumn(index = 4)
	private Long employeeNo;

	/** The designation. */
	@NativeQueryResultColumn(index = 5)
	private String employeeName;

	/** The retirement date. */
	@NativeQueryResultColumn(index = 6)
	private String designation;

	/** The employee type. */
	@NativeQueryResultColumn(index = 7)
	private Date retirementDate;

	/** The office name. */
	@NativeQueryResultColumn(index = 8)
	private String employeeType;

	/** The inward id. */
	@NativeQueryResultColumn(index = 9)
	private String officeName;

	/** The  status. */
	@NativeQueryResultColumn(index = 10)
	private String status;

	/** The forwarded date. */
	@NativeQueryResultColumn(index = 11)
	private Date forwardedDate;

	/** The wf status. */
	@NativeQueryResultColumn(index = 12)
	private String wfStatus;
	
	@NativeQueryResultColumn(index = 13)
	private String eventName;
	
	@NativeQueryResultColumn(index = 14)
	private int inwardCount;

	@NativeQueryResultColumn(index = 15)
	private Long id;

	
	
	/**Setters getters **/
	
	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public Date getInwardDate() {
		return inwardDate;
	}

	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
	}

	public String getInwardNumber() {
		return inwardNumber;
	}

	public void setInwardNumber(String inwardNumber) {
		this.inwardNumber = inwardNumber;
	}

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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getRetirementDate() {
		return retirementDate;
	}

	public void setRetirementDate(Date retirementDate) {
		this.retirementDate = retirementDate;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
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

	public Date getForwardedDate() {
		return forwardedDate;
	}

	public void setForwardedDate(Date forwardedDate) {
		this.forwardedDate = forwardedDate;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getInwardCount() {
		return inwardCount;
	}

	public void setInwardCount(int inwardCount) {
		this.inwardCount = inwardCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	
	



	


}
