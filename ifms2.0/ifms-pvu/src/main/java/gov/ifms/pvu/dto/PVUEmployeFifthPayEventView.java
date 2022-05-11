package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUEmployeJoinPayEventView.
 */
@NativeQueryResultEntity
public class PVUEmployeFifthPayEventView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp event id. */
	@NativeQueryResultColumn(index = 0)
	private long empEventId;

	/** The emp id. */
	@NativeQueryResultColumn(index = 1)
	private long empId;

	/** The transac number. */
	@NativeQueryResultColumn(index = 2)
	private String transacNumber;

	/** The event name. */
	@NativeQueryResultColumn(index = 3)
	private String eventName;

	/** The event date. */
	@NativeQueryResultColumn(index = 4)
	private String eventDate;

	/** The pay scale. */
	@NativeQueryResultColumn(index = 5)
	private String payScale;

	/** The pay scale value. */
	@NativeQueryResultColumn(index = 6)
	private String payScaleValue;

	/** The emp basic pay. */
	@NativeQueryResultColumn(index = 7)
	private String empBasicPay;

	/** The pay commission. */
	@NativeQueryResultColumn(index = 8)
	private String payCommission;

	/** The designation. */
	@NativeQueryResultColumn(index = 9)
	private Long designationId;
	
	@NativeQueryResultColumn(index = 10)
	private String designation;
	
	@NativeQueryResultColumn(index = 11)
	private String dateOfNextIncrement;

	@NativeQueryResultColumn(index = 12)
	private String optionOpted;

	/** The approval date. */
	@NativeQueryResultColumn(index = 13)
	private String approvalDate;

	/** The office id. */
	@NativeQueryResultColumn(index = 14)
	private Long officeId;

	/** The event id. */
	@NativeQueryResultColumn(index = 15)
	private Long eventId;

	/** The src event id. */
	@NativeQueryResultColumn(index = 16)
	private Long srcEventId;

	/** The dept cat id. */
	@NativeQueryResultColumn(index = 17)
	private Long deptCatId;

	/** The emp class. */
	@NativeQueryResultColumn(index = 18)
	private String empClass;

	/** The src trn no. */
	@NativeQueryResultColumn(index = 19)
	private String srcTrnNo;

	/** The active status. */
	@NativeQueryResultColumn(index = 20)
	private int activeStatus;

	/** The recored. */
	@NativeQueryResultColumn(index = 21)
	private String recored;

	/**
	 * Gets the emp event id.
	 *
	 * @return the empEventId
	 */
	public long getEmpEventId() {
		return empEventId;
	}

	/**
	 * Sets the emp event id.
	 *
	 * @param empEventId the empEventId to set
	 */
	public void setEmpEventId(long empEventId) {
		this.empEventId = empEventId;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the transac number.
	 *
	 * @return the transacNumber
	 */
	public String getTransacNumber() {
		return transacNumber;
	}

	/**
	 * Sets the transac number.
	 *
	 * @param transacNumber the transacNumber to set
	 */
	public void setTransacNumber(String transacNumber) {
		this.transacNumber = transacNumber;
	}

	/**
	 * Gets the event name.
	 *
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * Sets the event name.
	 *
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * Gets the event date.
	 *
	 * @return the eventDate
	 */
	public String getEventDate() {
		return eventDate;
	}

	/**
	 * Sets the event date.
	 *
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * Gets the pay scale.
	 *
	 * @return the payScale
	 */
	public String getPayScale() {
		return payScale;
	}

	/**
	 * Sets the pay scale.
	 *
	 * @param payScale the payScale to set
	 */
	public void setPayScale(String payScale) {
		this.payScale = payScale;
	}

	/**
	 * Gets the pay scale value.
	 *
	 * @return the payScaleValue
	 */
	public String getPayScaleValue() {
		return payScaleValue;
	}

	/**
	 * Sets the pay scale value.
	 *
	 * @param payScaleValue the payScaleValue to set
	 */
	public void setPayScaleValue(String payScaleValue) {
		this.payScaleValue = payScaleValue;
	}

	/**
	 * Gets the emp basic pay.
	 *
	 * @return the empBasicPay
	 */
	public String getEmpBasicPay() {
		return empBasicPay;
	}

	/**
	 * Sets the emp basic pay.
	 *
	 * @param empBasicPay the empBasicPay to set
	 */
	public void setEmpBasicPay(String empBasicPay) {
		this.empBasicPay = empBasicPay;
	}

	/**
	 * Gets the pay commission.
	 *
	 * @return the payCommission
	 */
	public String getPayCommission() {
		return payCommission;
	}

	/**
	 * Sets the pay commission.
	 *
	 * @param payCommission the payCommission to set
	 */
	public void setPayCommission(String payCommission) {
		this.payCommission = payCommission;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Gets the option opted.
	 *
	 * @return the optionOpted
	 */
	public String getOptionOpted() {
		return optionOpted;
	}

	/**
	 * Sets the option opted.
	 *
	 * @param optionOpted the optionOpted to set
	 */
	public void setOptionOpted(String optionOpted) {
		this.optionOpted = optionOpted;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the event id.
	 *
	 * @return the eventId
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * Sets the event id.
	 *
	 * @param eventId the eventId to set
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * Gets the src event id.
	 *
	 * @return the srcEventId
	 */
	public Long getSrcEventId() {
		return srcEventId;
	}

	/**
	 * Sets the src event id.
	 *
	 * @param srcEventId the srcEventId to set
	 */
	public void setSrcEventId(Long srcEventId) {
		this.srcEventId = srcEventId;
	}

	/**
	 * Gets the dept cat id.
	 *
	 * @return the deptCatId
	 */
	public Long getDeptCatId() {
		return deptCatId;
	}

	/**
	 * Sets the dept cat id.
	 *
	 * @param deptCatId the deptCatId to set
	 */
	public void setDeptCatId(Long deptCatId) {
		this.deptCatId = deptCatId;
	}

	/**
	 * Gets the emp class.
	 *
	 * @return the empClass
	 */
	public String getEmpClass() {
		return empClass;
	}

	/**
	 * Sets the emp class.
	 *
	 * @param empClass the empClass to set
	 */
	public void setEmpClass(String empClass) {
		this.empClass = empClass;
	}

	/**
	 * Gets the src trn no.
	 *
	 * @return the srcTrnNo
	 */
	public String getSrcTrnNo() {
		return srcTrnNo;
	}

	/**
	 * Sets the src trn no.
	 *
	 * @param srcTrnNo the srcTrnNo to set
	 */
	public void setSrcTrnNo(String srcTrnNo) {
		this.srcTrnNo = srcTrnNo;
	}

	/**
	 * Gets the active status.
	 *
	 * @return the activeStatus
	 */
	public int getActiveStatus() {
		return activeStatus;
	}

	/**
	 * Sets the active status.
	 *
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * Gets the recored.
	 *
	 * @return the recored
	 */
	public String getRecored() {
		return recored;
	}

	/**
	 * Sets the recored.
	 *
	 * @param recored the recored to set
	 */
	public void setRecored(String recored) {
		this.recored = recored;
	}

	/**
	 * @return the designationId
	 */
	public Long getDesignationId() {
		return designationId;
	}

	/**
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	/**
	 * @return the dateOfNextIncrement
	 */
	public String getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * @param dateOfNextIncrement the dateOfNextIncrement to set
	 */
	public void setDateOfNextIncrement(String dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	/**
	 * @return the approvalDate
	 */
	public String getApprovalDate() {
		return approvalDate;
	}

	/**
	 * @param approvalDate the approvalDate to set
	 */
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

}
