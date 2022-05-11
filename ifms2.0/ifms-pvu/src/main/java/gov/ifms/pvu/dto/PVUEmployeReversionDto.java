package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import gov.ifms.pvu.common.PVUCurrentDto;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUEmployeReversionEventDto.
 */
public class PVUEmployeReversionDto extends PVUCurrentDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The rev event id. */
	private long id;

	/** The trans num. */
	private String trnNo;

	/** The event code. */
	private String eventCode = PvuConstant.EVENT_CODE_REVERSION;

	/** The office id. */
	private long officeId;

	/** The pay comm. */
	private long payCommId;

	/** The status Id. */
	private long statusId;

	/** The event order num. */
	@NotNull
	private String eventOrderNo;

	/** The event order date. */
	@NotNull
	@PastOrPresent
	private LocalDate eventOrderDate;

	/** The event effective date. */
	@NotNull
	@PastOrPresent
	private LocalDate eventEffectiveDate;

	/** The emp id. */
	private long employeeId;

	/** The employee no. */
	private long employeeNo;

	/** The emp class. */
	private long employeeClassId;

	/** The designation id. */
	private long designationId;

	/** The pay scale. */

	private long payScale;

	/** The pay level. */
	private long payLevelId;

	/** The cell id. */
	private long cellId;

	/** The pay band. */
	private long payBandId;

	/** The pay band value. */
	private long payBandValue;

	/** The grade pay. */
	private long gradePayId;

	/** The basic pay. */
	private long basicPay;

	/** The effective date. */
	@NotNull
	private LocalDate effectiveDate;

	/** The date next incr. */
	@NotNull
	private LocalDate dateOfNextIncrement;

	/** The remarks. */
	@NotNull
	private String remarks;
	
	private boolean isSubmit;

	private LocalDateTime refDate;
	
    private Long departmentCategoryId;

	public LocalDateTime getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the trn no.
	 *
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the pay comm id.
	 *
	 * @return the payCommId
	 */
	public long getPayCommId() {
		return payCommId;
	}

	/**
	 * Sets the pay comm id.
	 *
	 * @param payCommId the payCommId to set
	 */
	public void setPayCommId(long payCommId) {
		this.payCommId = payCommId;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the event order no.
	 *
	 * @return the eventOrderNo
	 */
	public String getEventOrderNo() {
		return eventOrderNo;
	}

	/**
	 * Sets the event order no.
	 *
	 * @param eventOrderNo the eventOrderNo to set
	 */
	public void setEventOrderNo(String eventOrderNo) {
		this.eventOrderNo = eventOrderNo;
	}

	/**
	 * Gets the event order date.
	 *
	 * @return the eventOrderDate
	 */
	public LocalDate getEventOrderDate() {
		return eventOrderDate;
	}

	/**
	 * Sets the event order date.
	 *
	 * @param eventOrderDate the eventOrderDate to set
	 */
	public void setEventOrderDate(LocalDate eventOrderDate) {
		this.eventOrderDate = eventOrderDate;
	}

	/**
	 * Gets the event effective date.
	 *
	 * @return the eventEffectiveDate
	 */
	public LocalDate getEventEffectiveDate() {
		return eventEffectiveDate;
	}

	/**
	 * Sets the event effective date.
	 *
	 * @param eventEffectiveDate the eventEffectiveDate to set
	 */
	public void setEventEffectiveDate(LocalDate eventEffectiveDate) {
		this.eventEffectiveDate = eventEffectiveDate;
	}

	/**
	 * Gets the employee id.
	 *
	 * @return the employeeId
	 */
	public long getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the employee class id.
	 *
	 * @return the employeeClassId
	 */
	public long getEmployeeClassId() {
		return employeeClassId;
	}

	/**
	 * Sets the employee class id.
	 *
	 * @param employeeClassId the employeeClassId to set
	 */
	public void setEmployeeClassId(long employeeClassId) {
		this.employeeClassId = employeeClassId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public long getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the pay scale.
	 *
	 * @return the payScale
	 */
	public long getPayScale() {
		return payScale;
	}

	/**
	 * Sets the pay scale.
	 *
	 * @param payScale the payScale to set
	 */
	public void setPayScale(long payScale) {
		this.payScale = payScale;
	}

	/**
	 * Gets the pay level id.
	 *
	 * @return the payLevelId
	 */
	public long getPayLevelId() {
		return payLevelId;
	}

	/**
	 * Sets the pay level id.
	 *
	 * @param payLevelId the payLevelId to set
	 */
	public void setPayLevelId(long payLevelId) {
		this.payLevelId = payLevelId;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cellId
	 */
	public long getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the cellId to set
	 */
	public void setCellId(long cellId) {
		this.cellId = cellId;
	}

	/**
	 * Gets the pay band id.
	 *
	 * @return the payBandId
	 */
	public long getPayBandId() {
		return payBandId;
	}

	/**
	 * Sets the pay band id.
	 *
	 * @param payBandId the payBandId to set
	 */
	public void setPayBandId(long payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return the payBandValue
	 */
	public long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Gets the grade pay id.
	 *
	 * @return the gradePayId
	 */
	public long getGradePayId() {
		return gradePayId;
	}

	/**
	 * Sets the grade pay id.
	 *
	 * @param gradePayId the gradePayId to set
	 */
	public void setGradePayId(long gradePayId) {
		this.gradePayId = gradePayId;
	}

	/**
	 * Gets the basic pay.
	 *
	 * @return the basicPay
	 */
	public long getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Gets the effective date.
	 *
	 * @return the effectiveDate
	 */
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * Sets the effective date.
	 *
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Gets the date of next increment.
	 *
	 * @return the dateOfNextIncrement
	 */
	public LocalDate getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * Sets the date of next increment.
	 *
	 * @param dateOfNextIncrement the dateOfNextIncrement to set
	 */
	public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	/**
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Gets the employee no.
	 *
	 * @return the employeeNo
	 */
	public long getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * Sets the employee no.
	 *
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(long employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * Gets the event code.
	 *
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}

	/**
	 * Sets the event code.
	 *
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public boolean isSubmit() {
		return isSubmit;
	}

	public void setSubmit(boolean isSubmit) {
		this.isSubmit = isSubmit;
	}
	
	/**
	 * @return the departmentCategoryId
	 */
	public Long getDepartmentCategoryId() {
		return departmentCategoryId;
	}

	/**
	 * @param departmentCategoryId the departmentCategoryId to set
	 */
	public void setDepartmentCategoryId(Long departmentCategoryId) {
		this.departmentCategoryId = departmentCategoryId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(basicPay, cellId, dateOfNextIncrement, designationId, effectiveDate, employeeClassId,
				employeeId, employeeNo, eventCode, eventEffectiveDate, eventOrderDate, eventOrderNo, //fileAttachment,
				gradePayId, id, officeId, payBandId, payBandValue, payCommId, payLevelId, payScale, remarks, statusId,
				trnNo);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUEmployeReversionDto)) {
			return false;
		}
		PVUEmployeReversionDto other = (PVUEmployeReversionDto) obj;
		return basicPay == other.basicPay && cellId == other.cellId
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& designationId == other.designationId && Objects.equals(effectiveDate, other.effectiveDate)
				&& employeeClassId == other.employeeClassId && employeeId == other.employeeId
				&& employeeNo == other.employeeNo && Objects.equals(eventCode, other.eventCode)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate)
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventOrderNo, other.eventOrderNo)
				/*&& Objects.equals(fileAttachment, other.fileAttachment)*/ && gradePayId == other.gradePayId
				&& id == other.id && officeId == other.officeId && payBandId == other.payBandId
				&& payBandValue == other.payBandValue && payCommId == other.payCommId && payLevelId == other.payLevelId
				&& payScale == other.payScale && Objects.equals(remarks, other.remarks) && statusId == other.statusId
				&& Objects.equals(trnNo, other.trnNo);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeReversionDto [id=" + id + ", trnNo=" + trnNo + ", eventCode=" + eventCode + ", officeId="
				+ officeId + ", payCommId=" + payCommId + ", statusId=" + statusId + ", eventOrderNo=" + eventOrderNo
				+ ", eventOrderDate=" + eventOrderDate + ", eventEffectiveDate=" + eventEffectiveDate + ", employeeId="
				+ employeeId + ", employeeNo=" + employeeNo + ", employeeClassId=" + employeeClassId
				+ ", designationId=" + designationId + ", payScale=" + payScale + ", payLevelId=" + payLevelId
				+ ", cellId=" + cellId + ", payBandId=" + payBandId + ", payBandValue=" + payBandValue + ", gradePayId="
				+ gradePayId + ", basicPay=" + basicPay + ", effectiveDate=" + effectiveDate + ", dateOfNextIncrement="
				+ dateOfNextIncrement + ", remarks=" + remarks + ", fileAttachment=" + /*fileAttachment +*/ "]";
	}

	
}
