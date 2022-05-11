package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUForgoDto.
 * 
 * @version v 1.0
 * @created 2019/12/23 11:00:23
 *
 */

public class PVUEmployeForgoDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event id. */

	private long id;

	/** The trans no. */
	private String trnNo;

	/** The event code. */
	private String eventCode = PvuConstant.EVENT_CODE_FORGO;

	/** The emp id. */
	private long employeeId;

	/** The employee no. */
	private long employeeNo;

	/** The officeId id. */

	private long officeId;

	/** The pay comm. */

	private long payCommId;

	/** The event order no. */

	private String eventOrderNo;

	/** The event order LocalDate. */
	@NotNull
	@PastOrPresent
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate eventOrderDate;

	/** The event eff LocalDate. */
	private LocalDate eventEffectiveDate;

	/** The status id. */

	private long status;

	/** The emp event. */

	private long empEvent;

	/** The emp class. */

	private long employeeClassId;

	/** The designation id. */

	private long designationId;

	/** The pay level. */

	private long payLevelId;

	/** The cell id. */

	private long cellId;

	/** The basic pay. */

	private long basicPay;

	/** The promo LocalDate. */
	@NotNull
	@PastOrPresent
	private LocalDate promoDate;

	/** The join promotion post. */

	private long joinPromotionPost;

	/** The join promotion LocalDate. */
	@NotNull
	@PastOrPresent
	private LocalDate joinPromotionDate;

	/** The promo forgo LocalDate. */
	@NotNull
	@PastOrPresent
	private LocalDate promoForgoDate;

	/** The nxt incent LocalDate. */
	@NotNull
	private LocalDate dateOfNextIncrement;

	/** The high grade sel. */

	private long highGradeSel;

	/** The evnt effective LocalDate. */

	/** The pay band. */

	private long payBandId;

	/** The pay band value. */

	private long payBandValue;

	/** The grade pay. */

	private long gradePayId;

	/** The pay scale. */

	private long payScale;

	/** The LocalDate of high grade 1. */
	private LocalDate dateOfHighGrade1;

	/** The LocalDate of high grade 2. */
	private LocalDate dateOfHighGrade2;

	/** The LocalDate of high grade 3. */
	private LocalDate dateOfHighGrade3;

	/** The status id. */
	private long statusId;

	/** The is submit. */
	private boolean isSubmit;


	/** The remarks. */
	private String remarks;

	/**
	 * Property based validation.
	 *
	 * @return the sets the
	 */
	@Override
	public Set<String> propertyBasedValidation() {
		Set<String> fields = new HashSet<>();
		fields.add("eventEffectiveDate");
		fields.add("eventOrderDate");
		fields.add("eventOrderNo");
		fields.add("dateOfHighGrade1");
		fields.add("dateOfHighGrade2");
		fields.add("dateOfHighGrade3");
		fields.add("promoForgoDate");
		fields.add("dateOfNextIncrement");
		fields.add("joinPromotionDate");
		fields.add("promoDate");

		return fields;
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
	 * Gets the status.
	 *
	 * @return the status
	 */
	public long getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(long status) {
		this.status = status;
	}

	/**
	 * Gets the emp event.
	 *
	 * @return the empEvent
	 */
	public long getEmpEvent() {
		return empEvent;
	}

	/**
	 * Sets the emp event.
	 *
	 * @param empEvent the empEvent to set
	 */
	public void setEmpEvent(long empEvent) {
		this.empEvent = empEvent;
	}

	/**
	 * Gets the emp class.
	 *
	 * @return the employeeClassId
	 */
	public long getEmployeeClassId() {
		return employeeClassId;
	}

	/**
	 * Sets the emp class.
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
	 * Gets the promo date.
	 *
	 * @return the promoDate
	 */
	public LocalDate getPromoDate() {
		return promoDate;
	}

	/**
	 * Sets the promo date.
	 *
	 * @param promoDate the promoDate to set
	 */
	public void setPromoDate(LocalDate promoDate) {
		this.promoDate = promoDate;
	}

	/**
	 * Gets the join promotion post.
	 *
	 * @return the joinPromotionPost
	 */
	public long getJoinPromotionPost() {
		return joinPromotionPost;
	}

	/**
	 * Sets the join promotion post.
	 *
	 * @param joinPromotionPost the joinPromotionPost to set
	 */
	public void setJoinPromotionPost(long joinPromotionPost) {
		this.joinPromotionPost = joinPromotionPost;
	}

	/**
	 * Gets the join promotion date.
	 *
	 * @return the joinPromotionDate
	 */
	public LocalDate getJoinPromotionDate() {
		return joinPromotionDate;
	}

	/**
	 * Sets the join promotion date.
	 *
	 * @param joinPromotionDate the joinPromotionDate to set
	 */
	public void setJoinPromotionDate(LocalDate joinPromotionDate) {
		this.joinPromotionDate = joinPromotionDate;
	}

	/**
	 * Gets the promo forgo date.
	 *
	 * @return the promoForgoDate
	 */
	public LocalDate getPromoForgoDate() {
		return promoForgoDate;
	}

	/**
	 * Sets the promo forgo date.
	 *
	 * @param promoForgoDate the promoForgoDate to set
	 */
	public void setPromoForgoDate(LocalDate promoForgoDate) {
		this.promoForgoDate = promoForgoDate;
	}

	/**
	 * Gets the high grade sel.
	 *
	 * @return the highGradeSel
	 */
	public long getHighGradeSel() {
		return highGradeSel;
	}

	/**
	 * Sets the high grade sel.
	 *
	 * @param highGradeSel the highGradeSel to set
	 */
	public void setHighGradeSel(long highGradeSel) {
		this.highGradeSel = highGradeSel;
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
	 * Gets the date of high grade 1.
	 *
	 * @return the dateOfHighGrade1
	 */
	public LocalDate getDateOfHighGrade1() {
		return dateOfHighGrade1;
	}

	/**
	 * Sets the date of high grade 1.
	 *
	 * @param dateOfHighGrade1 the dateOfHighGrade1 to set
	 */
	public void setDateOfHighGrade1(LocalDate dateOfHighGrade1) {
		this.dateOfHighGrade1 = dateOfHighGrade1;
	}

	/**
	 * Gets the date of high grade 2.
	 *
	 * @return the dateOfHighGrade2
	 */
	public LocalDate getDateOfHighGrade2() {
		return dateOfHighGrade2;
	}

	/**
	 * Sets the date of high grade 2.
	 *
	 * @param dateOfHighGrade2 the dateOfHighGrade2 to set
	 */
	public void setDateOfHighGrade2(LocalDate dateOfHighGrade2) {
		this.dateOfHighGrade2 = dateOfHighGrade2;
	}

	/**
	 * Gets the date of high grade 3.
	 *
	 * @return the dateOfHighGrade3
	 */
	public LocalDate getDateOfHighGrade3() {
		return dateOfHighGrade3;
	}

	/**
	 * Sets the date of high grade 3.
	 *
	 * @param dateOfHighGrade3 the dateOfHighGrade3 to set
	 */
	public void setDateOfHighGrade3(LocalDate dateOfHighGrade3) {
		this.dateOfHighGrade3 = dateOfHighGrade3;
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

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public boolean isSubmit() {
		return isSubmit;
	}

	public void setSubmit(boolean isSubmit) {
		this.isSubmit = isSubmit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(basicPay, cellId, dateOfHighGrade1, dateOfHighGrade2, dateOfHighGrade3,
				dateOfNextIncrement, designationId, empEvent, employeeClassId, employeeId, employeeNo, eventCode,
				eventEffectiveDate, eventOrderDate, eventOrderNo, gradePayId, highGradeSel, id, isSubmit,
				joinPromotionDate, joinPromotionPost, officeId, payBandId, payBandValue, payCommId, payLevelId,
				payScale, promoDate, promoForgoDate, remarks, status, statusId, trnNo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof PVUEmployeForgoDto)) {
			return false;
		}
		PVUEmployeForgoDto other = (PVUEmployeForgoDto) obj;
		return basicPay == other.basicPay && cellId == other.cellId
				&& Objects.equals(dateOfHighGrade1, other.dateOfHighGrade1)
				&& Objects.equals(dateOfHighGrade2, other.dateOfHighGrade2)
				&& Objects.equals(dateOfHighGrade3, other.dateOfHighGrade3)
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& designationId == other.designationId && empEvent == other.empEvent
				&& employeeClassId == other.employeeClassId && employeeId == other.employeeId
				&& employeeNo == other.employeeNo && Objects.equals(eventCode, other.eventCode)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate)
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventOrderNo, other.eventOrderNo) && gradePayId == other.gradePayId
				&& highGradeSel == other.highGradeSel && id == other.id && isSubmit == other.isSubmit
				&& Objects.equals(joinPromotionDate, other.joinPromotionDate)
				&& joinPromotionPost == other.joinPromotionPost && officeId == other.officeId
				&& payBandId == other.payBandId && payBandValue == other.payBandValue && payCommId == other.payCommId
				&& payLevelId == other.payLevelId && payScale == other.payScale
				&& Objects.equals(promoDate, other.promoDate) && Objects.equals(promoForgoDate, other.promoForgoDate)
				&& Objects.equals(remarks, other.remarks) && status == other.status && statusId == other.statusId
				&& Objects.equals(trnNo, other.trnNo);
	}

	@Override
	public String toString() {
		return "PVUEmployeForgoDto [id=" + id + ", trnNo=" + trnNo + ", eventCode=" + eventCode + ", employeeId="
				+ employeeId + ", employeeNo=" + employeeNo + ", officeId=" + officeId + ", payCommId=" + payCommId
				+ ", eventOrderNo=" + eventOrderNo + ", eventOrderDate=" + eventOrderDate + ", eventEffectiveDate="
				+ eventEffectiveDate + ", status=" + status + ", empEvent=" + empEvent + ", employeeClassId="
				+ employeeClassId + ", designationId=" + designationId + ", payLevelId=" + payLevelId + ", cellId="
				+ cellId + ", basicPay=" + basicPay + ", promoDate=" + promoDate + ", joinPromotionPost="
				+ joinPromotionPost + ", joinPromotionDate=" + joinPromotionDate + ", promoForgoDate=" + promoForgoDate
				+ ", dateOfNextIncrement=" + dateOfNextIncrement + ", highGradeSel=" + highGradeSel + ", payBandId="
				+ payBandId + ", payBandValue=" + payBandValue + ", gradePayId=" + gradePayId + ", payScale=" + payScale
				+ ", dateOfHighGrade1=" + dateOfHighGrade1 + ", dateOfHighGrade2=" + dateOfHighGrade2
				+ ", dateOfHighGrade3=" + dateOfHighGrade3 + ", statusId=" + statusId + ", isSubmit=" + isSubmit
				+ ", remarks=" + remarks + "]";
	}

}
