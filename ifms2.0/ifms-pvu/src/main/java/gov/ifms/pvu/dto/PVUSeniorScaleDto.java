package gov.ifms.pvu.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.ifms.pvu.common.PVUCurrentDto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The Class PVUSeniorScaleEntity.
 */

public class PVUSeniorScaleDto extends PVUCurrentDto implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    private long id;

    /**
     * The submit flag.
     */
    private boolean submit = false;

    /**
     * The submit flag.
     */
    private boolean same = true;

    /**
     * The trn no.
     */
    private String trnNo;

    /**
     * The office id.
     */
    private long officeId;

    /**
     * The office id.
     */
    private String officeName;

    /**
     * The pay comm id.
     */
    private long payCommId;

    /**
     * The event order no.
     */
    private String eventOrderNo;

    /**
     * The event order date.
     */
    private LocalDate eventOrderDate;

    /**
     * The event effective date.
     */
    private LocalDate eventEffectiveDate;

    /**
     * The employee id.
     */
    private long employeeId;

    /**
     * The pay level id.
     */
    private long payLevelId;

    /**
     * The pay level id.
     */
    private String payLevelName;

    /**
     * The cell id.
     */
    private long cellId;

    /**
     * The pay level id.
     */
    private String cellName;

    /**
     * The basic pay.
     */
    private long basicPay;

    /**
     * The pay band id.
     */
    private long payBandId;

    /**
     * The pay level id.
     */
    private String payBandName;

    /**
     * The pay band value.
     */
    private long payBandValue;

    /**
     * The grade pay id.
     */
    private long gradePayId;

    /**
     * The pay level id.
     */
    private String gradePayName;

    /**
     * The scale id.
     */
    private long scaleId;

    /**
     * The pay level id.
     */
    private String scaleName;

    /**
     * The remarks.
     */
    private String remarks;

    /**
     * The benefit effective date.
     */
    private LocalDate benefitEffectiveDate;

    private LocalDate approveDate;

    /**
     * The date of next increment.
     */
    private LocalDate dateOfNextIncrement;

    /**
     * The status id.
     */
    private long statusId;

    /**
     * The employee no.
     */
    private long employeeNo;

    /**
     * The event code.
     */
    private String eventCode;

    /**
     * The eventId.
     */
    private long eventId;

    /**
     * The departmentCategoryId.
     */
    private Long departmentCategoryId;

    private long personalPay;

    private String auditorRemarks;

    private String verifierRemarks;

    private String classTwoRemarks;

    private String classOneRemarks;

    private String printRemarks;

    private Long auditorReturnReason;

    private Long verifierReturnReason;

    private Long classTwoReturnReason;

    private Long classOneReturnReason;

    private Long printReturnReason;

    private LocalDateTime refDate;

    public LocalDateTime getRefDate() {
        return refDate;
    }

    public LocalDate getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(LocalDate approveDate) {
        this.approveDate = approveDate;
    }

    public void setRefDate(LocalDateTime refDate) {
        this.refDate = refDate;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getPayLevelName() {
        return payLevelName;
    }

    public void setPayLevelName(String payLevelName) {
        this.payLevelName = payLevelName;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getPayBandName() {
        return payBandName;
    }

    public void setPayBandName(String payBandName) {
        this.payBandName = payBandName;
    }

    public String getGradePayName() {
        return gradePayName;
    }

    public void setGradePayName(String gradePayName) {
        this.gradePayName = gradePayName;
    }

    public String getScaleName() {
        return scaleName;
    }

    public void setScaleName(String scaleName) {
        this.scaleName = scaleName;
    }

    /* Getter Setter */

    /**
     * Gets the event id.
     *
     * @return the event id
     */
    public long getEventId() {
        return eventId;
    }

    /**
     * Sets the event id.
     *
     * @param eventId the new event id
     */
    public void setEventId(long eventId) {
        this.eventId = eventId;
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
     * Gets the employee id.
     *
     * @return the employeeId
     */
    public long getEmployeeId() {
        return employeeId;
    }

    /**
     * Set employeeId.
     *
     * @param employeeId employeeId
     */
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets the benefit effective date.
     *
     * @return the optionAvailableDate
     */
    public LocalDate getBenefitEffectiveDate() {
        return benefitEffectiveDate;
    }

    /**
     * Set optionAvailableDate.
     *
     * @param benefitEffectiveDate optionAvailableDate
     */
    public void setBenefitEffectiveDate(LocalDate benefitEffectiveDate) {
        this.benefitEffectiveDate = benefitEffectiveDate;
    }

    /**
     * Gets the scale id.
     *
     * @return the scaleId
     */
    public long getScaleId() {
        return scaleId;
    }

    /**
     * Set scaleId.
     *
     * @param scaleId scaleId
     */
    public void setScaleId(long scaleId) {
        this.scaleId = scaleId;
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
     * Set payLevelId.
     *
     * @param payLevelId payLevelId
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
     * Set cellId.
     *
     * @param cellId cellId
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
     * Set payBandId.
     *
     * @param payBandId payBandId
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
     * Set payBandValue.
     *
     * @param payBandValue payBandValue
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
     * Set gradePayId.
     *
     * @param gradePayId gradePayId
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
     * Set basicPay.
     *
     * @param basicPay basicPay
     */
    public void setBasicPay(long basicPay) {
        this.basicPay = basicPay;
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
     * Set dateOfNextIncrement.
     *
     * @param dateOfNextIncrement dateOfNextIncrement
     */
    public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
        this.dateOfNextIncrement = dateOfNextIncrement;
    }

    /**
     * Gets the remarks.
     *
     * @return the
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Set remarks.
     *
     * @param remarks remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
     * Getter for property 'submit'.
     *
     * @return Value for property 'submit'.
     */
    public boolean isSubmit() {
        return submit;
    }

    /**
     * Setter for property 'submit'.
     *
     * @param submit Value to set for property 'submit'.
     */
    public void setSubmit(boolean submit) {
        this.submit = submit;
    }


    /**
     * Getter for property 'personalPay'.
     *
     * @return Value for property 'personalPay'.
     */
    public long getPersonalPay() {
        return personalPay;
    }

    /**
     * Setter for property 'personalPay'.
     *
     * @param personalPay Value to set for property 'personalPay'.
     */
    public void setPersonalPay(long personalPay) {
        this.personalPay = personalPay;
    }

    /**
     * Getter for property 'departmentCategoryId'.
     *
     * @return Value for property 'departmentCategoryId'.
     */
    public Long getDepartmentCategoryId() {
        return departmentCategoryId;
    }

    /**
     * Setter for property 'departmentCategoryId'.
     *
     * @param departmentCategoryId Value to set for property 'departmentCategoryId'.
     */
    public void setDepartmentCategoryId(Long departmentCategoryId) {
        this.departmentCategoryId = departmentCategoryId;
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

    public String getAuditorRemarks() {
        return auditorRemarks;
    }

    public void setAuditorRemarks(String auditorRemarks) {
        this.auditorRemarks = auditorRemarks;
    }

    public String getVerifierRemarks() {
        return verifierRemarks;
    }

    public void setVerifierRemarks(String verifierRemarks) {
        this.verifierRemarks = verifierRemarks;
    }

    public String getClassTwoRemarks() {
        return classTwoRemarks;
    }

    public void setClassTwoRemarks(String classTwoRemarks) {
        this.classTwoRemarks = classTwoRemarks;
    }

    public String getClassOneRemarks() {
        return classOneRemarks;
    }

    public void setClassOneRemarks(String classOneRemarks) {
        this.classOneRemarks = classOneRemarks;
    }

    public String getPrintRemarks() {
        return printRemarks;
    }

    public void setPrintRemarks(String printRemarks) {
        this.printRemarks = printRemarks;
    }

    public Long getAuditorReturnReason() {
        return auditorReturnReason;
    }

    public void setAuditorReturnReason(Long auditorReturnReason) {
        this.auditorReturnReason = auditorReturnReason;
    }

    public Long getVerifierReturnReason() {
        return verifierReturnReason;
    }

    public void setVerifierReturnReason(Long verifierReturnReason) {
        this.verifierReturnReason = verifierReturnReason;
    }

    public Long getClassTwoReturnReason() {
        return classTwoReturnReason;
    }

    public void setClassTwoReturnReason(Long classTwoReturnReason) {
        this.classTwoReturnReason = classTwoReturnReason;
    }

    public Long getClassOneReturnReason() {
        return classOneReturnReason;
    }

    public void setClassOneReturnReason(Long classOneReturnReason) {
        this.classOneReturnReason = classOneReturnReason;
    }

    public Long getPrintReturnReason() {
        return printReturnReason;
    }

    public void setPrintReturnReason(Long printReturnReason) {
        this.printReturnReason = printReturnReason;
    }

    /**
     * Equals.
     *
     * @param o the o
     * @return true, if successful
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PVUSeniorScaleDto that = (PVUSeniorScaleDto) o;
        return id == that.id &&
                submit == that.submit &&
                same == that.same &&
                officeId == that.officeId &&
                payCommId == that.payCommId &&
                employeeId == that.employeeId &&
                payLevelId == that.payLevelId &&
                cellId == that.cellId &&
                basicPay == that.basicPay &&
                payBandId == that.payBandId &&
                payBandValue == that.payBandValue &&
                gradePayId == that.gradePayId &&
                scaleId == that.scaleId &&
                statusId == that.statusId &&
                employeeNo == that.employeeNo &&
                eventId == that.eventId &&
                personalPay == that.personalPay &&
                Objects.equals(trnNo, that.trnNo) &&
                Objects.equals(officeName, that.officeName) &&
                Objects.equals(eventOrderNo, that.eventOrderNo) &&
                Objects.equals(eventOrderDate, that.eventOrderDate) &&
                Objects.equals(eventEffectiveDate, that.eventEffectiveDate) &&
                Objects.equals(payLevelName, that.payLevelName) &&
                Objects.equals(cellName, that.cellName) &&
                Objects.equals(payBandName, that.payBandName) &&
                Objects.equals(gradePayName, that.gradePayName) &&
                Objects.equals(scaleName, that.scaleName) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(benefitEffectiveDate, that.benefitEffectiveDate) &&
                Objects.equals(dateOfNextIncrement, that.dateOfNextIncrement) &&
                Objects.equals(eventCode, that.eventCode) &&
                Objects.equals(departmentCategoryId, that.departmentCategoryId) &&
                Objects.equals(auditorRemarks, that.auditorRemarks) &&
                Objects.equals(verifierRemarks, that.verifierRemarks) &&
                Objects.equals(classTwoRemarks, that.classTwoRemarks) &&
                Objects.equals(classOneRemarks, that.classOneRemarks) &&
                Objects.equals(printRemarks, that.printRemarks) &&
                Objects.equals(auditorReturnReason, that.auditorReturnReason) &&
                Objects.equals(verifierReturnReason, that.verifierReturnReason) &&
                Objects.equals(classTwoReturnReason, that.classTwoReturnReason) &&
                Objects.equals(classOneReturnReason, that.classOneReturnReason) &&
                Objects.equals(printReturnReason, that.printReturnReason);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, submit, same, trnNo, officeId, officeName,
                payCommId, eventOrderNo, eventOrderDate, eventEffectiveDate,
                employeeId, payLevelId, payLevelName, cellId, cellName, basicPay,
                payBandId, payBandName, payBandValue, gradePayId, gradePayName,
                scaleId, scaleName, remarks, benefitEffectiveDate, dateOfNextIncrement,
                statusId, employeeNo, eventCode, eventId, departmentCategoryId,
                personalPay, auditorRemarks, verifierRemarks, classTwoRemarks,
                classOneRemarks, printRemarks, auditorReturnReason, verifierReturnReason,
                classTwoReturnReason, classOneReturnReason, printReturnReason);
    }


    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String
    toString() {
        return "PVUSeniorScaleDto{" +
                "id=" + id +
                ", submit=" + submit +
                ", same=" + same +
                ", trnNo='" + trnNo + '\'' +
                ", officeId=" + officeId +
                ", officeName='" + officeName + '\'' +
                ", payCommId=" + payCommId +
                ", eventOrderNo='" + eventOrderNo + '\'' +
                ", eventOrderDate=" + eventOrderDate +
                ", eventEffectiveDate=" + eventEffectiveDate +
                ", employeeId=" + employeeId +
                ", payLevelId=" + payLevelId +
                ", payLevelName='" + payLevelName + '\'' +
                ", cellId=" + cellId +
                ", cellName='" + cellName + '\'' +
                ", basicPay=" + basicPay +
                ", payBandId=" + payBandId +
                ", payBandName='" + payBandName + '\'' +
                ", payBandValue=" + payBandValue +
                ", gradePayId=" + gradePayId +
                ", gradePayName='" + gradePayName + '\'' +
                ", scaleId=" + scaleId +
                ", scaleName='" + scaleName + '\'' +
                ", remarks='" + remarks + '\'' +
                ", benefitEffectiveDate=" + benefitEffectiveDate +
                ", dateOfNextIncrement=" + dateOfNextIncrement +
                ", statusId=" + statusId +
                ", employeeNo=" + employeeNo +
                ", eventCode='" + eventCode + '\'' +
                ", eventId=" + eventId +
                ", departmentCategoryId=" + departmentCategoryId +
                ", personalPay=" + personalPay +
                ", auditorRemarks='" + auditorRemarks + '\'' +
                ", verifierRemarks='" + verifierRemarks + '\'' +
                ", classTwoRemarks='" + classTwoRemarks + '\'' +
                ", classOneRemarks='" + classOneRemarks + '\'' +
                ", printRemarks='" + printRemarks + '\'' +
                ", auditorReturnReason=" + auditorReturnReason +
                ", verifierReturnReason=" + verifierReturnReason +
                ", classTwoReturnReason=" + classTwoReturnReason +
                ", classOneReturnReason=" + classOneReturnReason +
                ", printReturnReason=" + printReturnReason +
                '}';
    }

    @JsonIgnore
    public boolean isNew() {
        return this.id == 0;
    }

}
