package gov.ifms.pvu.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.common.PVUCurrentEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The Class PVUSeniorScaleEntity.
 */

@Entity
@Table(name = "T_PVU_SS_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUSeniorScaleEntity extends PVUCurrentEntity implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_PVU_SS_EVNT_ID")
    private long id;

    /**
     * The event.
     */
    @ManyToOne
    @JoinColumn(name = "PVU_EVENT_ID", referencedColumnName = "MS_PVU_EVENTS_ID")
    private PVUMsEventEntity event;

    /**
     * The trn no.
     */
    @Column(name = "TRN_NO")
    private String trnNo;

    /**
     * The office.
     */
    @ManyToOne
    @JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
    private EDPMsOfficeEntity office;

    /**
     * The pay comm.
     */
    @ManyToOne
    @JoinColumn(name = "PAY_COMM")
    private EDPLuLookUpInfoEntity payComm;

    /**
     * The event order no.
     */
    @Column(name = "EVNT_ORDER_NO")
    private String eventOrderNo;

    /**
     * The event order date.
     */
    @Column(name = "EVNT_ORDER_DATE")
    private LocalDate eventOrderDate;

    /**
     * The event effective date.
     */
    @Column(name = "EVNT_EFF_DATE")
    private LocalDate eventEffectiveDate;

    /**
     * The pay level.
     */
    @ManyToOne
    @JoinColumn(name = "PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
    private PVUMsPayLevelEntity payLevel;

    /**
     * The cell.
     */
    @ManyToOne
    @JoinColumn(name = "CELL_ID", referencedColumnName = "PAY_CELL_ID")
    private PVUMsPayCellEntity cell;

    /**
     * The basic pay.
     */
    @Column(name = "BASIC_PAY")
    private long basicPay;

    /**
     * The pay band.
     */
    @ManyToOne
    @JoinColumn(name = "PAY_BAND", referencedColumnName = "PAY_BAND_ID")
    private PVUMsPayBandEntity payBand;

    /**
     * The pay band value.
     */
    // Based on Band value will come
    @Column(name = "PAY_BAND_VALUE")
    private long payBandValue;

    /**
     * The grade pay.
     */
    @ManyToOne
    @JoinColumn(name = "GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
    private PVUMsGradePayEntity gradePay;

    /**
     * The scale.
     */
    @ManyToOne
    @JoinColumn(name = "SCALE")
    private PVUMsPayScaleEntity scale;

    /**
     * The remarks.
     */
    @Column(name = "REMARKS")
    private String remarks;

    /**
     * The benefit effective date.
     */
    @Column(name = "BEN_EFF_DATE")
    private LocalDate benefitEffectiveDate;

    /**
     * The date of next increment.
     */
    @Column(name = "NEXT_INCR_DATE")
    private LocalDate dateOfNextIncrement;

    /**
     * The status.
     */
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
    private EDPLuLookUpInfoEntity status;

    /** The approve date. */
    @Column(name = "APPR_DATE")
    private LocalDateTime approveDate;

    /** The authorize date. */
    @Column(name = "AUTH_DATE")
    private LocalDateTime authorizeDate;

    /**
     * The personalPay.
     */
    @Column(name = "PERSONAL_PAY")
    private long personalPay;

    /**
     * The departmentCategoryId.
     */
    @Column(name = "DEPT_CAT_ID")
    private Long departmentCategoryId;

    /**
     * The departmentCategoryId.
     */
    @Column(name = "CURRENT_DETAILS_EVENT_ID")
    private Long currentDetailsEventId;

    /** The is print able. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IS_PRINTABLE")
    private EDPLuLookUpInfoEntity isPrintAble;

    @Column(name = "AUDITOR_REMARKS") //ALTER TABLE PVU.T_PVU_SS_EVNT ADD AUDITOR_REMARKS VARCHAR(500);
    private String auditorRemarks;

    @Column(name = "VERIFIER_REMARKS") //ALTER TABLE PVU.T_PVU_SS_EVNT ADD VERIFIER_REMARKS VARCHAR(500);
    private String verifierRemarks;

    @Column(name = "CLASS_TWO_REMARKS") //ALTER TABLE PVU.T_PVU_SS_EVNT ADD CLASS_TWO_REMARKS VARCHAR(500);
    private String classTwoRemarks;

    @Column(name = "CLASS_ONE_REMARKS") //ALTER TABLE PVU.T_PVU_SS_EVNT ADD CLASS_ONE_REMARKS VARCHAR(500);
    private String classOneRemarks;

    @Column(name = "PRINT_REMARKS") //ALTER TABLE PVU.T_PVU_SS_EVNT ADD PRINT_REMARKS VARCHAR(500);
    private String printRemarks;

    @Column(name = "AUDITOR_RETURN_REASON") // ALTER TABLE PVU.T_PVU_SS_EVNT ADD AUDITOR_RETURN_REASON BIGINT;
    private Long auditorReturnReason;

    @Column(name = "VERIFIER_RETURN_REASON") // ALTER TABLE PVU.T_PVU_SS_EVNT ADD VERIFIER_RETURN_REASON BIGINT;
    private Long verifierReturnReason;

    @Column(name = "CLASS_TWO_RETURN_REASON") // ALTER TABLE PVU.T_PVU_SS_EVNT ADD CLASS_TWO_RETURN_REASON BIGINT;
    private Long classTwoReturnReason;

    @Column(name = "CLASS_ONE_RETURN_REASON") // ALTER TABLE PVU.T_PVU_SS_EVNT ADD CLASS_ONE_RETURN_REASON BIGINT;
    private Long classOneReturnReason;

    @Column(name = "PRINT_RETURN_REASON") // ALTER TABLE PVU.T_PVU_SS_EVNT ADD PRINT_RETURN_REASON BIGINT;
    private Long printReturnReason;

    /** The init date. */
    @Column(name = "REF_DATE")
    private LocalDateTime refDate;

    /** The init date. */
    @Column(name = "AUTHORIZE_BY")
    private Long authorizeBy;

    /** The init date. */
    @Column(name = "AUTHORIZER_REMARK")
    private String authorizerRemark;

    public PVUSeniorScaleEntity(Long id) {
        this.id = id;
    }

    public LocalDateTime getRefDate() {
        return refDate;
    }

    public void setRefDate(LocalDateTime initDate) {
        this.refDate = initDate;
    }

    public PVUSeniorScaleEntity() {
    }

    /* Getter Setter */

    /**
     * Gets the event.
     *
     * @return the employee
     */
    public PVUMsEventEntity getEvent() {
        return event;
    }

    /**
     * Set event.
     *
     * @param event event
     */
    public void setEvent(PVUMsEventEntity event) {
        this.event = event;
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
     * Gets the scale.
     *
     * @return the scale
     */
    public PVUMsPayScaleEntity getScale() {
        return scale;
    }

    /**
     * Set scale.
     *
     * @param scale scale
     */
    public void setScale(PVUMsPayScaleEntity scale) {
        this.scale = scale;
    }

    /**
     * Gets the pay level.
     *
     * @return the payLevel
     */
    public PVUMsPayLevelEntity getPayLevel() {
        return payLevel;
    }

    /**
     * Set payLevel.
     *
     * @param payLevel payLevel
     */
    public void setPayLevel(PVUMsPayLevelEntity payLevel) {
        this.payLevel = payLevel;
    }

    /**
     * Gets the cell.
     *
     * @return the cell
     */
    public PVUMsPayCellEntity getCell() {
        return cell;
    }

    /**
     * Set cell.
     *
     * @param cell cell
     */
    public void setCell(PVUMsPayCellEntity cell) {
        this.cell = cell;
    }

    /**
     * Gets the pay band.
     *
     * @return the payBand
     */
    public PVUMsPayBandEntity getPayBand() {
        return payBand;
    }

    /**
     * Set payBand.
     *
     * @param payBand payBand
     */
    public void setPayBand(PVUMsPayBandEntity payBand) {
        this.payBand = payBand;
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
     * Gets the grade pay.
     *
     * @return the gradePay
     */
    public PVUMsGradePayEntity getGradePay() {
        return gradePay;
    }

    /**
     * Set gradePay.
     *
     * @param gradePay gradePay
     */
    public void setGradePay(PVUMsGradePayEntity gradePay) {
        this.gradePay = gradePay;
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
     * Gets the office.
     *
     * @return the office
     */
    public EDPMsOfficeEntity getOffice() {
        return office;
    }

    /**
     * Sets the office.
     *
     * @param office the office to set
     */
    public void setOffice(EDPMsOfficeEntity office) {
        this.office = office;
    }

    /**
     * Gets the pay comm.
     *
     * @return the payComm
     */
    public EDPLuLookUpInfoEntity getPayComm() {
        return payComm;
    }

    /**
     * Sets the pay comm.
     *
     * @param payComm the payComm to set
     */
    public void setPayComm(EDPLuLookUpInfoEntity payComm) {
        this.payComm = payComm;
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
    public EDPLuLookUpInfoEntity getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the status to set
     */
    public void setStatus(EDPLuLookUpInfoEntity status) {
        this.status = status;
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
     * Getter for property 'currentDetailsEventId'.
     *
     * @return Value for property 'currentDetailsEventId'.
     */
    public Long getCurrentDetailsEventId() {
        return currentDetailsEventId;
    }

    /**
     * Setter for property 'currentDetailsEventId'.
     *
     * @param currentDetailsEventId Value to set for property 'currentDetailsEventId'.
     */
    public void setCurrentDetailsEventId(Long currentDetailsEventId) {
        this.currentDetailsEventId = currentDetailsEventId;
    }

    public LocalDateTime getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(LocalDateTime approveDate) {
        this.approveDate = approveDate;
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

    public LocalDateTime getAuthorizeDate() {
        return authorizeDate;
    }

    public void setAuthorizeDate(LocalDateTime authorizeDate) {
        this.authorizeDate = authorizeDate;
    }

    /**
     * Gets the checks if is print able.
     *
     * @return the checks if is print able
     */
    public EDPLuLookUpInfoEntity getIsPrintAble() {
        return isPrintAble;
    }

    /**
     * Sets the checks if is print able.
     *
     * @param isPrintAble the new checks if is print able
     */
    public void setIsPrintAble(EDPLuLookUpInfoEntity isPrintAble) {
        this.isPrintAble = isPrintAble;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, event, trnNo, office, payComm, eventOrderNo,
                eventOrderDate, eventEffectiveDate, payLevel, cell,
                basicPay, payBand, payBandValue, gradePay, scale, remarks, benefitEffectiveDate,
                dateOfNextIncrement, status, approveDate, authorizeDate, personalPay, departmentCategoryId,
                currentDetailsEventId, isPrintAble,authorizerRemark,authorizeBy, auditorRemarks, verifierRemarks, classTwoRemarks,
                classOneRemarks, printRemarks, auditorReturnReason, verifierReturnReason, classTwoReturnReason,
                classOneReturnReason, printReturnReason);
    }

    /**
     * Hash code.
     *
     * @return the int
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PVUSeniorScaleEntity entity = (PVUSeniorScaleEntity) o;
        return id == entity.id &&
                basicPay == entity.basicPay &&
                payBandValue == entity.payBandValue &&
                personalPay == entity.personalPay &&
                Objects.equals(event, entity.event) &&
                Objects.equals(trnNo, entity.trnNo) &&
                Objects.equals(office, entity.office) &&
                Objects.equals(payComm, entity.payComm) &&
                Objects.equals(eventOrderNo, entity.eventOrderNo) &&
                Objects.equals(eventOrderDate, entity.eventOrderDate) &&
                Objects.equals(eventEffectiveDate, entity.eventEffectiveDate) &&
                Objects.equals(payLevel, entity.payLevel) &&
                Objects.equals(cell, entity.cell) &&
                Objects.equals(payBand, entity.payBand) &&
                Objects.equals(gradePay, entity.gradePay) &&
                Objects.equals(scale, entity.scale) &&
                Objects.equals(remarks, entity.remarks) &&
                Objects.equals(benefitEffectiveDate, entity.benefitEffectiveDate) &&
                Objects.equals(dateOfNextIncrement, entity.dateOfNextIncrement) &&
                Objects.equals(status, entity.status) &&
                Objects.equals(approveDate, entity.approveDate) &&
                Objects.equals(authorizeDate, entity.authorizeDate) &&
                Objects.equals(departmentCategoryId, entity.departmentCategoryId) &&
                Objects.equals(currentDetailsEventId, entity.currentDetailsEventId) &&
                Objects.equals(isPrintAble, entity.isPrintAble) &&
                Objects.equals(auditorRemarks, entity.auditorRemarks) &&
                Objects.equals(verifierRemarks, entity.verifierRemarks) &&
                Objects.equals(classTwoRemarks, entity.classTwoRemarks) &&
                Objects.equals(classOneRemarks, entity.classOneRemarks) &&
                Objects.equals(printRemarks, entity.printRemarks) &&
                Objects.equals(auditorReturnReason, entity.auditorReturnReason) &&
                Objects.equals(verifierReturnReason, entity.verifierReturnReason) &&
                Objects.equals(authorizeBy, entity.authorizeBy) &&
                Objects.equals(authorizerRemark, entity.authorizerRemark) &&
                Objects.equals(classTwoReturnReason, entity.classTwoReturnReason) &&
                Objects.equals(classOneReturnReason, entity.classOneReturnReason) &&
                Objects.equals(printReturnReason, entity.printReturnReason);
    }

    public Long getAuthorizeBy() {
        return authorizeBy;
    }

    public void setAuthorizeBy(Long authorizeBy) {
        this.authorizeBy = authorizeBy;
    }

    public String getAuthorizerRemark() {
        return authorizerRemark;
    }

    public void setAuthorizerRemark(String authorizerRemark) {
        this.authorizerRemark = authorizerRemark;
    }
}

