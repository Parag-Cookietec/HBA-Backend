package gov.ifms.pvu.common;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.entity.*;

/**
 * The Class PVUSeniorScaleEntity.
 */

@MappedSuperclass
public abstract class PVUCurrentEntity extends BaseEntity {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "CURRENT_DETAILS_EVENT_ID")
    private Long currentDetailsEventId;

    @ManyToOne
    @JoinColumn(name = "C_PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
    private PVUMsPayLevelEntity cPayLevel;

    @ManyToOne
    @JoinColumn(name = "C_CELL_ID", referencedColumnName = "PAY_CELL_ID")
    private PVUMsPayCellEntity cCell;

    @ManyToOne
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    private PVUEmployeEntity employee;

    @ManyToOne
    @JoinColumn(name = "C_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
    private PVUMsPayBandEntity cPayBand;

    @ManyToOne
    @JoinColumn(name = "C_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
    private PVUMsGradePayEntity cGradePay;

    @Column(name = "C_PAY_BAND_VALUE")
    private Long cPayBandValue;

    @ManyToOne
    @JoinColumn(name = "C_SCALE", referencedColumnName = "PAY_SCALE_ID")
    private PVUMsPayScaleEntity cPayScale;

    @ManyToOne
    @JoinColumn(name = "C_DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
    private EDPMsDesignationEntity cDesignation;

    @Column(name = "RETIREMENT_DATE")
    private LocalDate cDateOfRetirement;

    @ManyToOne
    @JoinColumn(name = "C_CLASS_ID", referencedColumnName = "LOOKUP_INFO_ID")
    private EDPLuLookUpInfoEntity cClass;

    @Column(name = "C_BASIC_PAY")
    private Long cBasicPay;

    @Column(name = "C_DATE_NEX_INC")
    private LocalDate cDateOfNextIncrement;

    @Column(name = "C_DATE_JOIN")
    private LocalDate cDateOfJoining;

    @ManyToOne
    @JoinColumn(name="C_OFFICE",referencedColumnName = "OFFICE_ID")
    private EDPMsOfficeEntity cOfficeId;

    public PVUEmployeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(PVUEmployeEntity employee) {
        this.employee = employee;
    }

    public LocalDate getcDateOfJoining() {
        return cDateOfJoining;
    }

    public void setcDateOfJoining(LocalDate cDateOfJoining) {
        this.cDateOfJoining = cDateOfJoining;
    }

    public EDPMsOfficeEntity getcOfficeId() {
        return cOfficeId;
    }

    public void setcOfficeId(EDPMsOfficeEntity cOfficeId) {
        this.cOfficeId = cOfficeId;
    }

    public Long getCurrentDetailsEventId() {
        return currentDetailsEventId;
    }

    public void setCurrentDetailsEventId(Long currentDetailsEventId) {
        this.currentDetailsEventId = currentDetailsEventId;
    }

    public PVUCurrentEntity(Long currentDetailsEventId) {
        this.currentDetailsEventId = currentDetailsEventId;
    }

    public PVUCurrentEntity() {
        super();
    }

    public PVUMsPayLevelEntity getcPayLevel() {
        return cPayLevel;
    }

    public void setcPayLevel(PVUMsPayLevelEntity cPayLevel) {
        this.cPayLevel = cPayLevel;
    }

    public PVUMsPayCellEntity getcCell() {
        return cCell;
    }

    public void setcCell(PVUMsPayCellEntity cCell) {
        this.cCell = cCell;
    }

    public PVUMsPayBandEntity getcPayBand() {
        return cPayBand;
    }

    public void setcPayBand(PVUMsPayBandEntity cPayBand) {
        this.cPayBand = cPayBand;
    }

    public PVUMsGradePayEntity getcGradePay() {
        return cGradePay;
    }

    public void setcGradePay(PVUMsGradePayEntity cGradePay) {
        this.cGradePay = cGradePay;
    }

    public Long getcPayBandValue() {
        return cPayBandValue;
    }

    public void setcPayBandValue(Long cPayBandValue) {
        this.cPayBandValue = cPayBandValue;
    }

    public PVUMsPayScaleEntity getcPayScale() {
        return cPayScale;
    }

    public void setcPayScale(PVUMsPayScaleEntity cPayScale) {
        this.cPayScale = cPayScale;
    }

    public EDPMsDesignationEntity getcDesignation() {
        return cDesignation;
    }

    public void setcDesignation(EDPMsDesignationEntity cDesignation) {
        this.cDesignation = cDesignation;
    }

    public LocalDate getcDateOfRetirement() {
        return cDateOfRetirement;
    }

    public void setcDateOfRetirement(LocalDate cDateOfRetirement) {
        this.cDateOfRetirement = cDateOfRetirement;
    }

    public EDPLuLookUpInfoEntity getcClass() {
        return cClass;
    }

    public void setcClass(EDPLuLookUpInfoEntity cClass) {
        this.cClass = cClass;
    }

    public Long getcBasicPay() {
        return cBasicPay;
    }

    public void setcBasicPay(Long cBasicPay) {
        this.cBasicPay = cBasicPay;
    }

    public LocalDate getcDateOfNextIncrement() {
        return cDateOfNextIncrement;
    }

    public void setcDateOfNextIncrement(LocalDate cDateOfNextIncrement) {
        this.cDateOfNextIncrement = cDateOfNextIncrement;
    }
}
