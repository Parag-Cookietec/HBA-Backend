package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import gov.ifms.pvu.common.PVUCurrentDto;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUPromotionDto.
 *
 * @version 1.0
 *N @created 2019/12/20 14:45:46
 */
public class PVUDeemedDateDto extends PVUCurrentDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The trn no. */
	private String trnNo;

	/**
	 * The submit flag.
	 */
	private boolean same = true;


	/** The pay comm id. */
	private long payCommId;

	/** The office id. */
	private long officeId;

	/** The event order no. */
	private String eventOrderNo;

	/** The event order date. */
	private LocalDate eventOrderDate;

	/** The event effective date. */
	private LocalDate eventEffectiveDate;

	/** The employee id. */
	private long employeeId;

	/** The employee no. */
	private long employeeNo;

	/** The employee class id. */
	private long employeeClassId;

	/** The designation id. */
	private long designationId;

	/** The option available id. */
	private long optionAvailableId;

	/** The pay band id. */
	private long payBandId;

	/** The pay band value. */
	private long payBandValue;

	/** The grade pay id. */
	private long gradePayId;

	/** The basic pay. */
	private long basicPay;

	/** The benefit effective date. */
	private LocalDate benefitEffectiveDate;

	/** The deemed date. */
	private LocalDate deemedDate;

	/** The actual date promo. */
	private LocalDate actualDatePromo;

	/** The duration. */
	private int duration;

	/** The remarks. */
	private String remarks;

	/** The status id. */
	private long statusId;

	/** The against employee id. */
	private long againstEmployeeId;

	/** The against employee no. */
	private long againstEmployeeNo;

	/** The option available date. */
	private LocalDate optionAvailableDate;

	/** The date of next increment. */
	private LocalDate dateOfNextIncrement;

	/** The pay scale. */

	private long payScale;

	private Long departmentCategoryId;

	private LocalDateTime refDate;

	private Long srSeniorNo;

	private Long jrSeniorNo;
	
	/** The oa basic pay value. */
	private Long oaBasicPayValue;

	/** The oa pay scale id. */
	private Long oaPayScaleId;

	/** The oa pay band id. */
	private Long oaPayBandId;

	/** The oa pay band value. */
	private Long oaPayBandValue;

	/** The oa grade pay id. */
	private Long oaGradePayId;

	/** The oa pay level id. */
	private Long oaPayLevelId;

	/** The oa cell id value. */
	private Long oaCellIdValue;

	/** The oa pay cell id. */
	private Long oaPayCellId;

	/** The pay band name. */
	private String payBandName;

	/** The grade pay name. */
	private String gradePayName;

	/** The pay level name. */
	private String payLevelName;

	/** The scale name. */
	private String scaleName;
	
	public Long getSrSeniorNo() {
		return srSeniorNo;
	}

	public void setSrSeniorNo(Long srSeniorNo) {
		this.srSeniorNo = srSeniorNo;
	}

	public Long getJrSeniorNo() {
		return jrSeniorNo;
	}

	public void setJrSeniorNo(Long jrSeniorNo) {
		this.jrSeniorNo = jrSeniorNo;
	}

	public LocalDateTime getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}




	/**
	 * Getter for property 'same'.
	 *
	 * @return Value for property 'same'.
	 */
	public boolean isSame() {
		return same;
	}

	/**
	 * Setter for property 'same'.
	 *
	 * @param same Value to set for property 'same'.
	 */
	public void setSame(boolean same) {
		this.same = same;
	}

	/**
	 * Gets the pay scale.
	 *
	 * @return the pay scale
	 */
	public long getPayScale() {
		return payScale;
	}

	/**
	 * Sets the pay scale.
	 *
	 * @param payScale the new pay scale
	 */
	public void setPayScale(long payScale) {
		this.payScale = payScale;
	}

	/**
	 * Gets the pay level.
	 *
	 * @return the pay level
	 */
	public long getPayLevelId() {
		return payLevelId;
	}

	/**
	 * Sets the pay level.
	 *
	 * @param payLevelId the new pay level
	 */
	public void setPayLevelId(long payLevelId) {
		this.payLevelId = payLevelId;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cell id
	 */
	public long getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the new cell id
	 */
	public void setCellId(long cellId) {
		this.cellId = cellId;
	}

	/** The pay level. */
	private long payLevelId;

	/** The cell id. */
	private long cellId;


	/** The event code. */
	private String eventCode = PvuConstant.EVENT_CODE_DEEMED_DATE;
	
	/** The is submit. */
	private boolean isSubmit;
	/* Getter Setter */

	/**
	 * Sets the submit.
	 *
	 * @param submit the new submit
	 */
	public void setSubmit(boolean submit) {
		isSubmit = submit;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	 * Gets the status id.
	 *
	 * @return statusId
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the employee id.
	 *
	 * @return employeeId
	 */
	public long getEmployeeId() {
		return employeeId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return designationId
	 */
	public long getDesignationId() {
		return designationId;
	}

	/**
	 * Gets the option available id.
	 *
	 * @return optionAvailableId
	 */
	public long getOptionAvailableId() {
		return optionAvailableId;
	}

	/**
	 * Gets the benefit effective date.
	 *
	 * @return benefitEffectiveDate
	 */
	public LocalDate getBenefitEffectiveDate() {
		return benefitEffectiveDate;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return payBandValue
	 */
	public long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Gets the basic pay.
	 *
	 * @return basicPay
	 */
	public long getBasicPay() {
		return basicPay;
	}

	/**
	 * Gets the remarks.
	 *
	 * @return remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Gets the pay band id.
	 *
	 * @return payBandId
	 */
	public long getPayBandId() {
		return payBandId;
	}

	/**
	 * Gets the grade pay id.
	 *
	 * @return gradePayId
	 */
	public long getGradePayId() {
		return gradePayId;
	}

	/**
	 * Set employeeId.
	 *
	 * @param employeeId the employeeId
	 */
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Set designationId.
	 *
	 * @param designationId the designationId
	 */
	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}

	/**
	 * Set optionAvailableId.
	 *
	 * @param optionAvailableId the optionAvailableId
	 */
	public void setOptionAvailableId(long optionAvailableId) {
		this.optionAvailableId = optionAvailableId;
	}

	/**
	 * Set benefitEffectiveDate.
	 *
	 * @param benefitEffectiveDate the benefitEffectiveDate
	 */
	public void setBenefitEffectiveDate(LocalDate benefitEffectiveDate) {
		this.benefitEffectiveDate = benefitEffectiveDate;
	}


	/**
	 * Checks if is submit.
	 *
	 * @return true, if is submit
	 */
	public boolean isSubmit() {
		return isSubmit;
	}

	/**
	 * Set payBandValue.
	 *
	 * @param payBandValue the payBandValue
	 */
	public void setPayBandValue(long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Set basicPay.
	 *
	 * @param basicPay the basicPay
	 */
	public void setBasicPay(long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Set remarks.
	 *
	 * @param remarks the remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Set payBandId.
	 *
	 * @param payBandId the payBandId
	 */
	public void setPayBandId(long payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * Set gradePayId.
	 *
	 * @param gradePayId the gradePayId
	 */
	public void setGradePayId(long gradePayId) {
		this.gradePayId = gradePayId;
	}

	/**
	 * Set gradePayId.
	 *
	 * @param employeeClassId the classId
	 */
	public void setEmployeeClassId(long employeeClassId) {
		this.employeeClassId = employeeClassId;
	}

	/**
	 * Set gradePayId.
	 *
	 * @param deemedDate the deemDate
	 */
	public void setDeemedDate(LocalDate deemedDate) {
		this.deemedDate = deemedDate;
	}

	/**
	 * Set gradePayId.
	 *
	 * @param actualDatePromo the actualPromotionDate
	 */
	public void setActualDatePromo(LocalDate actualDatePromo) {
		this.actualDatePromo = actualDatePromo;
	}

	/**
	 * Set gradePayId.
	 *
	 * @param duration the notionalDuration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Gets the employee class id.
	 *
	 * @return classId
	 */
	public long getEmployeeClassId() {
		return employeeClassId;
	}

	/**
	 * Gets the deemed date.
	 *
	 * @return deemDate
	 */
	public LocalDate getDeemedDate() {
		return deemedDate;
	}

	/**
	 * Gets the actual date promo.
	 *
	 * @return actualPromotionDate
	 */
	public LocalDate getActualDatePromo() {
		return actualDatePromo;
	}

	/**
	 * Gets the duration.
	 *
	 * @return notionalDuration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Gets the against employee id.
	 *
	 * @return notionalDuration
	 */
	public long getAgainstEmployeeId() {
		return againstEmployeeId;
	}

	/**
	 * Set againstEmployeeId.
	 *
	 * @param againstEmployeeId the againstEmployeeId
	 */
	public void setAgainstEmployeeId(long againstEmployeeId) {
		this.againstEmployeeId = againstEmployeeId;
	}

	/**
	 * Gets the option available date.
	 *
	 * @return the option available date
	 */
	public LocalDate getOptionAvailableDate() {
		return optionAvailableDate;
	}

	/**
	 * Sets the option available date.
	 *
	 * @param optionAvailableDate the new option available date
	 */
	public void setOptionAvailableDate(LocalDate optionAvailableDate) {
		this.optionAvailableDate = optionAvailableDate;
	}

	/**
	 * Gets the date of next increment.
	 *
	 * @return the date of next increment
	 */
	public LocalDate getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * Sets the date of next increment.
	 *
	 * @param dateOfNextIncrement the new date of next increment
	 */
	public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	/**
	 * Gets the employee no.
	 *
	 * @return the employee no
	 */
	public long getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * Sets the employee no.
	 *
	 * @param employeeNo the new employee no
	 */
	public void setEmployeeNo(long employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * Gets the event code.
	 *
	 * @return the event code
	 */
	public String getEventCode() {
		return eventCode;
	}

	/**
	 * Sets the event code.
	 *
	 * @param eventCode the new event code
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * Gets the against employee no.
	 *
	 * @return the against employee no
	 */
	public long getAgainstEmployeeNo() {
		return againstEmployeeNo;
	}

	/**
	 * Sets the against employee no.
	 *
	 * @param againstEmployeeNo the new against employee no
	 */
	public void setAgainstEmployeeNo(long againstEmployeeNo) {
		this.againstEmployeeNo = againstEmployeeNo;
	}
	public Long getDepartmentCategoryId() {
		return departmentCategoryId;
	}

	public void setDepartmentCategoryId(Long departmentCategoryId) {
		this.departmentCategoryId = departmentCategoryId;
	}
	
	
	
	/**
	 * @return the oaBasicPayValue
	 */
	public Long getOaBasicPayValue() {
		return oaBasicPayValue;
	}

	/**
	 * @param oaBasicPayValue the oaBasicPayValue to set
	 */
	public void setOaBasicPayValue(Long oaBasicPayValue) {
		this.oaBasicPayValue = oaBasicPayValue;
	}

	/**
	 * @return the oaPayScaleId
	 */
	public Long getOaPayScaleId() {
		return oaPayScaleId;
	}

	/**
	 * @param oaPayScaleId the oaPayScaleId to set
	 */
	public void setOaPayScaleId(Long oaPayScaleId) {
		this.oaPayScaleId = oaPayScaleId;
	}

	/**
	 * @return the oaPayBandId
	 */
	public Long getOaPayBandId() {
		return oaPayBandId;
	}

	/**
	 * @param oaPayBandId the oaPayBandId to set
	 */
	public void setOaPayBandId(Long oaPayBandId) {
		this.oaPayBandId = oaPayBandId;
	}

	/**
	 * @return the oaPayBandValue
	 */
	public Long getOaPayBandValue() {
		return oaPayBandValue;
	}

	/**
	 * @param oaPayBandValue the oaPayBandValue to set
	 */
	public void setOaPayBandValue(Long oaPayBandValue) {
		this.oaPayBandValue = oaPayBandValue;
	}

	/**
	 * @return the oaGradePayId
	 */
	public Long getOaGradePayId() {
		return oaGradePayId;
	}

	/**
	 * @param oaGradePayId the oaGradePayId to set
	 */
	public void setOaGradePayId(Long oaGradePayId) {
		this.oaGradePayId = oaGradePayId;
	}

	/**
	 * @return the oaPayLevelId
	 */
	public Long getOaPayLevelId() {
		return oaPayLevelId;
	}

	/**
	 * @param oaPayLevelId the oaPayLevelId to set
	 */
	public void setOaPayLevelId(Long oaPayLevelId) {
		this.oaPayLevelId = oaPayLevelId;
	}

	/**
	 * @return the oaCellIdValue
	 */
	public Long getOaCellIdValue() {
		return oaCellIdValue;
	}

	/**
	 * @param oaCellIdValue the oaCellIdValue to set
	 */
	public void setOaCellIdValue(Long oaCellIdValue) {
		this.oaCellIdValue = oaCellIdValue;
	}

	/**
	 * @return the oaPayCellId
	 */
	public Long getOaPayCellId() {
		return oaPayCellId;
	}

	/**
	 * @param oaPayCellId the oaPayCellId to set
	 */
	public void setOaPayCellId(Long oaPayCellId) {
		this.oaPayCellId = oaPayCellId;
	}

	/**
	 * @return the payBandName
	 */
	public String getPayBandName() {
		return payBandName;
	}

	/**
	 * @param payBandName the payBandName to set
	 */
	public void setPayBandName(String payBandName) {
		this.payBandName = payBandName;
	}

	/**
	 * @return the gradePayName
	 */
	public String getGradePayName() {
		return gradePayName;
	}

	/**
	 * @param gradePayName the gradePayName to set
	 */
	public void setGradePayName(String gradePayName) {
		this.gradePayName = gradePayName;
	}

	/**
	 * @return the payLevelName
	 */
	public String getPayLevelName() {
		return payLevelName;
	}

	/**
	 * @param payLevelName the payLevelName to set
	 */
	public void setPayLevelName(String payLevelName) {
		this.payLevelName = payLevelName;
	}

	/**
	 * @return the scaleName
	 */
	public String getScaleName() {
		return scaleName;
	}

	/**
	 * @param scaleName the scaleName to set
	 */
	public void setScaleName(String scaleName) {
		this.scaleName = scaleName;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(actualDatePromo, againstEmployeeId, againstEmployeeNo, basicPay, benefitEffectiveDate,
				cellId, dateOfNextIncrement, deemedDate, designationId, duration, employeeClassId, employeeId,
				employeeNo, eventCode, eventEffectiveDate, eventOrderDate, eventOrderNo, gradePayId, id, isSubmit,
				officeId, optionAvailableDate, optionAvailableId, payBandId, payBandValue, payCommId, payLevelId,
				payScale, remarks, statusId, trnNo,departmentCategoryId, oaCellIdValue, oaBasicPayValue,
				oaGradePayId, oaPayBandId, oaPayBandValue, oaPayCellId, oaPayScaleId, oaPayLevelId);
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
		PVUDeemedDateDto other = (PVUDeemedDateDto) obj;
		return Objects.equals(actualDatePromo, other.actualDatePromo) && againstEmployeeId == other.againstEmployeeId
				&& againstEmployeeNo == other.againstEmployeeNo && basicPay == other.basicPay
				&& Objects.equals(benefitEffectiveDate, other.benefitEffectiveDate) && cellId == other.cellId
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& Objects.equals(deemedDate, other.deemedDate) && designationId == other.designationId
				&& duration == other.duration && employeeClassId == other.employeeClassId
				&& employeeId == other.employeeId && employeeNo == other.employeeNo
				&& Objects.equals(eventCode, other.eventCode)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate)
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventOrderNo, other.eventOrderNo) && gradePayId == other.gradePayId
				&& Objects.equals(id, other.id) && isSubmit == other.isSubmit && officeId == other.officeId
				&& Objects.equals(optionAvailableDate, other.optionAvailableDate)
				&& optionAvailableId == other.optionAvailableId && payBandId == other.payBandId
				&& payBandValue == other.payBandValue && payCommId == other.payCommId && payLevelId == other.payLevelId
				&& payScale == other.payScale && Objects.equals(remarks, other.remarks) && statusId == other.statusId
				&& Objects.equals(trnNo, other.trnNo)
				&&  Objects.equals(departmentCategoryId, other.departmentCategoryId)
				&& Objects.equals(oaBasicPayValue, other.oaBasicPayValue)
				&& Objects.equals(oaCellIdValue, other.oaCellIdValue)
				&& Objects.equals(oaGradePayId, other.oaGradePayId)
				&& Objects.equals(oaPayBandId, other.oaPayBandId)
				&& Objects.equals(oaPayBandValue, other.oaPayBandValue)
				&& Objects.equals(oaPayCellId, other.oaPayCellId)
				&& Objects.equals(oaPayLevelId, other.oaPayLevelId)
				&& Objects.equals(oaPayScaleId, other.oaPayScaleId);
	}


	@Override
	public String toString() {
		return "PVUDeemedDateDto [id=" + id + ", trnNo=" + trnNo + ", same=" + same + ", payCommId=" + payCommId
				+ ", officeId=" + officeId + ", eventOrderNo=" + eventOrderNo + ", eventOrderDate=" + eventOrderDate
				+ ", eventEffectiveDate=" + eventEffectiveDate + ", employeeId=" + employeeId + ", employeeNo="
				+ employeeNo + ", employeeClassId=" + employeeClassId + ", designationId=" + designationId
				+ ", optionAvailableId=" + optionAvailableId + ", payBandId=" + payBandId + ", payBandValue="
				+ payBandValue + ", gradePayId=" + gradePayId + ", basicPay=" + basicPay + ", benefitEffectiveDate="
				+ benefitEffectiveDate + ", deemedDate=" + deemedDate + ", actualDatePromo=" + actualDatePromo
				+ ", duration=" + duration + ", remarks=" + remarks + ", statusId=" + statusId + ", againstEmployeeId="
				+ againstEmployeeId + ", againstEmployeeNo=" + againstEmployeeNo + ", optionAvailableDate="
				+ optionAvailableDate + ", dateOfNextIncrement=" + dateOfNextIncrement + ", payScale=" + payScale
				+ ", departmentCategoryId=" + departmentCategoryId + ", refDate=" + refDate + ", srSeniorNo="
				+ srSeniorNo + ", jrSeniorNo=" + jrSeniorNo + ", oaBasicPayValue=" + oaBasicPayValue + ", oaPayScaleId="
				+ oaPayScaleId + ", oaPayBandId=" + oaPayBandId + ", oaPayBandValue=" + oaPayBandValue
				+ ", oaGradePayId=" + oaGradePayId + ", oaPayLevelId=" + oaPayLevelId + ", oaCellIdValue="
				+ oaCellIdValue + ", oaPayCellId=" + oaPayCellId + ", payBandName=" + payBandName + ", gradePayName="
				+ gradePayName + ", payLevelName=" + payLevelName + ", scaleName=" + scaleName + ", payLevelId="
				+ payLevelId + ", cellId=" + cellId + ", eventCode=" + eventCode + ", isSubmit=" + isSubmit + "]";
	}

	/**
	 * Checks if is new.
	 *
	 * @return true, if is new
	 */
	public boolean isNew() {
		return this.id == null || this.id == 0;
	}

}
