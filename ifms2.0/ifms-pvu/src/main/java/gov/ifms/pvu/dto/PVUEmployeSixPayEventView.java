package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUEmployeSixPayEventView.
 */
@NativeQueryResultEntity
public class PVUEmployeSixPayEventView implements Serializable {

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

	/** The pay band. */
	@NativeQueryResultColumn(index = 5)
	private String payBand;

	/** The pay band dis value. */
	@NativeQueryResultColumn(index = 6)
	private String payBandDisValue;

	/** The emp grd pay. */
	@NativeQueryResultColumn(index = 7)
	private String empGrdPay;

	/** The grade pay value. */
	@NativeQueryResultColumn(index = 8)
	private String gradePayValue;

	/** The pay band value. */
	@NativeQueryResultColumn(index = 9)
	private String payBandValue;

	/** The emp basic pay. */
	@NativeQueryResultColumn(index = 10)
	private String empBasicPay;

	/** The pay commission. */
	@NativeQueryResultColumn(index = 11)
	private String payCommission;

	/** The designation. */
	@NativeQueryResultColumn(index = 12)
	private String designationId;

	/** The designation. */
	@NativeQueryResultColumn(index = 13)
	private String designation;

	@NativeQueryResultColumn(index = 14)
	private String dateOfNextIncrement;

	/** The option opted. */
	@NativeQueryResultColumn(index = 15)
	private String optionOpted;

	/** The approval date. */
	@NativeQueryResultColumn(index = 16)
	private String approvalDate;

	/** The office id. */
	@NativeQueryResultColumn(index = 17)
	private Long officeId;

	/** The event id. */
	@NativeQueryResultColumn(index = 18)
	private Long eventId;

	/** The src event id. */
	@NativeQueryResultColumn(index = 19)
	private Long srcEventId;

	/** The dept cat id. */
	@NativeQueryResultColumn(index = 20)
	private Long deptCatId;

	/** The emp class. */
	@NativeQueryResultColumn(index = 21)
	private String empClass;

	/** The src trn no. */
	@NativeQueryResultColumn(index = 22)
	private String srcTrnNo;

	/** The active status. */
	@NativeQueryResultColumn(index = 23)
	private int activeStatus;

	/** The recored. */
	@NativeQueryResultColumn(index = 24)
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
	 * Gets the pay band.
	 *
	 * @return the payBand
	 */
	public String getPayBand() {
		return payBand;
	}

	/**
	 * Sets the pay band.
	 *
	 * @param payBand the payBand to set
	 */
	public void setPayBand(String payBand) {
		this.payBand = payBand;
	}

	/**
	 * Gets the pay band dis value.
	 *
	 * @return the payBandDisValue
	 */
	public String getPayBandDisValue() {
		return payBandDisValue;
	}

	/**
	 * Sets the pay band dis value.
	 *
	 * @param payBandDisValue the payBandDisValue to set
	 */
	public void setPayBandDisValue(String payBandDisValue) {
		this.payBandDisValue = payBandDisValue;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return the payBandValue
	 */
	public String getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(String payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Gets the grade pay value.
	 *
	 * @return the gradePayValue
	 */
	public String getGradePayValue() {
		return gradePayValue;
	}

	/**
	 * Sets the grade pay value.
	 *
	 * @param gradePayValue the gradePayValue to set
	 */
	public void setGradePayValue(String gradePayValue) {
		this.gradePayValue = gradePayValue;
	}

	/**
	 * Gets the emp grd pay.
	 *
	 * @return the empGrdPay
	 */
	public String getEmpGrdPay() {
		return empGrdPay;
	}

	/**
	 * Sets the emp grd pay.
	 *
	 * @param empGrdPay the empGrdPay to set
	 */
	public void setEmpGrdPay(String empGrdPay) {
		this.empGrdPay = empGrdPay;
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
	public String getDesignationId() {
		return designationId;
	}

	/**
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(String designationId) {
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(activeStatus, approvalDate, deptCatId, designation, empBasicPay, empClass, empEventId,
				empGrdPay, empId, eventDate, eventId, eventName, gradePayValue, officeId, optionOpted, payBand,
				payBandDisValue, payBandValue, payCommission, recored, srcEventId, srcTrnNo, transacNumber);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUEmployeSixPayEventView other = (PVUEmployeSixPayEventView) obj;
		return activeStatus == other.activeStatus && Objects.equals(approvalDate, other.approvalDate)
				&& Objects.equals(deptCatId, other.deptCatId) && Objects.equals(designation, other.designation)
				&& Objects.equals(empBasicPay, other.empBasicPay) && Objects.equals(empClass, other.empClass)
				&& empEventId == other.empEventId && Objects.equals(empGrdPay, other.empGrdPay) && empId == other.empId
				&& Objects.equals(eventDate, other.eventDate) && Objects.equals(eventId, other.eventId)
				&& Objects.equals(eventName, other.eventName) && Objects.equals(gradePayValue, other.gradePayValue)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(optionOpted, other.optionOpted)
				&& Objects.equals(payBand, other.payBand) && Objects.equals(payBandDisValue, other.payBandDisValue)
				&& Objects.equals(payBandValue, other.payBandValue)
				&& Objects.equals(payCommission, other.payCommission) && Objects.equals(recored, other.recored)
				&& Objects.equals(srcEventId, other.srcEventId) && Objects.equals(srcTrnNo, other.srcTrnNo)
				&& Objects.equals(transacNumber, other.transacNumber);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeSixPayEventView [empEventId=" + empEventId + ", empId=" + empId + ", transacNumber="
				+ transacNumber + ", eventName=" + eventName + ", eventDate=" + eventDate + ", payBand=" + payBand
				+ ", payBandDisValue=" + payBandDisValue + ", payBandValue=" + payBandValue + ", gradePayValue="
				+ gradePayValue + ", empGrdPay=" + empGrdPay + ", empBasicPay=" + empBasicPay + ", payCommission="
				+ payCommission + ", designation=" + designation + ", optionOpted=" + optionOpted + ", approvalDate="
				+ approvalDate + ", officeId=" + officeId + ", eventId=" + eventId + ", srcEventId=" + srcEventId
				+ ", deptCatId=" + deptCatId + ", empClass=" + empClass + ", srcTrnNo=" + srcTrnNo + ", activeStatus="
				+ activeStatus + ", recored=" + recored + "]";
	}

}
