package gov.ifms.pvu.common;

import java.io.Serializable;
import java.time.LocalDate;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUCurrentDto.
 */

public class PVUCurrentDto extends BaseDto implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private Long cPayLevelId;

    private Long cCellId;

    private Long cPayBandId;

    private Long cGradePayId;

    private String cPayLevelName;

    private int cCellName;

    private String cPayBandName;

    private String cGradePayName;

    private Long cPayBandValue;

    private Long cPayScaleId;

    private String cPayScaleName;

    private Long cDesignationId;

    private String cDesignationName;

    private LocalDate cDateOfRetirement;

    private Long cClassId;

    private String cClassName;

    private Long cBasicPay;

    private LocalDate cDateOfNextIncrement;
    private LocalDate cDateOfJoining;
    private String cEmployeeName;

    public String getcEmployeeName() {
        return cEmployeeName;
    }

    public void setcEmployeeName(String cEmployeeName) {
        this.cEmployeeName = cEmployeeName;
    }

    public LocalDate getcDateOfJoining() {
        return cDateOfJoining;
    }

    public void setcDateOfJoining(LocalDate cDateOfJoining) {
        this.cDateOfJoining = cDateOfJoining;
    }

    public Long getcOfficeId() {
        return cOfficeId;
    }

    public void setcOfficeId(Long cOfficeId) {
        this.cOfficeId = cOfficeId;
    }

    public String getcOfficeName() {
        return cOfficeName;
    }

    public void setcOfficeName(String cOfficeName) {
        this.cOfficeName = cOfficeName;
    }

    private Long cOfficeId;
    private String cOfficeName;



    /**
     * The currentDetailsEventId.
     */
    private Long currentDetailsEventId;

    public Long getCurrentDetailsEventId() {
        return currentDetailsEventId;
    }

    public void setCurrentDetailsEventId(Long currentDetailsEventId) {
        this.currentDetailsEventId = currentDetailsEventId;
    }

    public PVUCurrentDto(Long currentDetailsEventId) {
        this.currentDetailsEventId = currentDetailsEventId;
    }

    public PVUCurrentDto() {
        super();
    }


    public Long getcPayLevelId() {
        return cPayLevelId;
    }

    public void setcPayLevelId(Long cPayLevelId) {
        this.cPayLevelId = cPayLevelId;
    }

    public Long getcCellId() {
        return cCellId;
    }

    public void setcCellId(Long cCellId) {
        this.cCellId = cCellId;
    }

    public Long getcPayBandId() {
        return cPayBandId;
    }

    public void setcPayBandId(Long cPayBandId) {
        this.cPayBandId = cPayBandId;
    }

    public Long getcGradePayId() {
        return cGradePayId;
    }

    public void setcGradePayId(Long cGradePayId) {
        this.cGradePayId = cGradePayId;
    }

    public String getcPayLevelName() {
        return cPayLevelName;
    }

    public void setcPayLevelName(String cPayLevelName) {
        this.cPayLevelName = cPayLevelName;
    }

    public int getcCellName() {
        return cCellName;
    }

    public void setcCellName(int cCellName) {
        this.cCellName = cCellName;
    }

    public String getcPayBandName() {
        return cPayBandName;
    }

    public void setcPayBandName(String cPayBandName) {
        this.cPayBandName = cPayBandName;
    }

    public String getcGradePayName() {
        return cGradePayName;
    }

    public void setcGradePayName(String cGradePayName) {
        this.cGradePayName = cGradePayName;
    }

    public Long getcPayBandValue() {
        return cPayBandValue;
    }

    public void setcPayBandValue(Long cPayBandValue) {
        this.cPayBandValue = cPayBandValue;
    }

    public Long getcPayScaleId() {
        return cPayScaleId;
    }

    public void setcPayScaleId(Long cPayScaleId) {
        this.cPayScaleId = cPayScaleId;
    }

    public String getcPayScaleName() {
        return cPayScaleName;
    }

    public void setcPayScaleName(String cPayScaleName) {
        this.cPayScaleName = cPayScaleName;
    }

    public String getcDesignationName() {
        return cDesignationName;
    }

    public void setcDesignationName(String cDesignationName) {
        this.cDesignationName = cDesignationName;
    }

    public Long getcDesignationId() {
        return cDesignationId;
    }

    public void setcDesignationId(Long cDesignationId) {
        this.cDesignationId = cDesignationId;
    }

    public LocalDate getcDateOfRetirement() {
        return cDateOfRetirement;
    }

    public void setcDateOfRetirement(LocalDate cDateOfRetirement) {
        this.cDateOfRetirement = cDateOfRetirement;
    }

    public Long getcClassId() {
        return cClassId;
    }

    public void setcClassId(Long cClassId) {
        this.cClassId = cClassId;
    }

    public String getcClassName() {
        return cClassName;
    }

    public void setcClassName(String cClassName) {
        this.cClassName = cClassName;
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
