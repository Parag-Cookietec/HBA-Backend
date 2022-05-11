package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUStEventDto.
 *
 * @version v 1.0
 * @created 2019/12/17 18:44:21
 *
 */
public class PVUSteppingUpEventDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The st event id. */
	private long id;

	/** The trn no. */
	private String trnNo;

	/** The event code. */
	private String eventCode = PvuConstant.EVENT_CODE_STEPPIN_UP;

	/** The office id. */
	@NotNull
	private long officeId;
	
	/** The office name. */
	@JsonIgnore
	private String officeName;


	/** The event order no. */
	@NotNull
	private String eventOrderNo;

	/** The event order date. */
	@NotNull
	private LocalDate eventOrderDate;

	/** The event eff date. */
	@NotNull
	private LocalDate eventEffectiveDate;

	/** The pay comm. */
	@NotNull
	private long payCommId;

	/** The employee id. */
	private long employeeId;

	/** The employee no. */

	private long employeeNo;
	
	/** The employee name. */
	private String employeeName;
	
	/** The cur emp no. */
	private long curEmpNo;

	/** The cur emp id. */
	private long curEmpId;

	/** The cur emp class. */
	private long curEmpClass;

	/** The cur emp dsgn. */
	private long curEmpDsgn;

	/** The cur office. */
	private long curOffice;

	/** The cur grade. */
	private long curGrade;

	/** The cur scale. */
	private long curScale;

	/** The cur pay level. */
	private long curPayLevel;

	/** The cur pay band. */
	private long curPayBand;

	/** The cur pay band value. */
	private long curPayBandValue;

	/** The cur grade pay. */
	private long curGradePay;

	/** The cur cell id. */
	private long curCellId;

	/** The cur basic pay. */
	private long curBasicPay;

	/** The cur date next inc. */
	private LocalDate curDateNextInc;

	/** The jr emp no. */
	private long jrEmpNo;

	/** The jr emp id. */
	private long jrEmpId;

	/** The jr emp name */
	private String jrEmpName;

	/** The jr emp class. */
	private long jrEmpClass;

	/** The jr pay comm. */
	private long jrPayCommId;

	/** The jr emp dsgn. */
	private long jrEmpDsgn;

	/** The jr office name. */
	private long jrOfficeId;

	/** The jr grade. */
	private long jrGrade;

	/** The jr scale. */
	private long jrScale;

	/** The jr pay level. */
	private long jrPayLevel;

	/** The jr pay band. */
	private long jrPayBand;

	/** The jr pay band value. */
	private long jrPayBandValue;

	/** The Jr grade pay. */
	private long jrGradePay;

	/** The jr cell id. */
	private long jrCellId;

	/** The jr basic pay. */
	private long jrBasicPay;

	/** The jr date nex inc. */
	private LocalDate jrDateNexInc;

	/**** Post Changes for Senior employee set data START *****/

	/** The ch class. */
	private long chEmpClass;

	/** The ch dsgn. */
	private long chEmpDsgn;

	/** The ch grade. */
	private long chGrade;

	/** The ch scale. */
	private long payScale;


	/** The ch pay band. */
	private long payBandId;

	/** The ch pay band value. */
	private long payBandValue;

	/** The ch grade pay. */
	private long gradePayId;

	/** The ch pay level. */
	private long payLevelId;

	
	/** The ch cell id. */
	private long cellId;

	/** The ch basic pay. */
	private long basicPay;

	/** The ch date nex inc. */
	private LocalDate dateOfNextIncrSrJnr;

	/** The ch bene eff date. */
	private LocalDate chBeneEffDate;

	/** The ch pay disp value. */
	@JsonIgnore
	private String payBandDispValue;

	/** The ch pay disp value. */
	@JsonIgnore
	private String gradePayDispValue;

	/** The ch pay disp value. */
	@JsonIgnore
	private String payLevelDispValue;

	/** The ch pay disp value. */
	@JsonIgnore
	private int cellIdDispValue;

	/** The ch payScaleDispValue. */
	@JsonIgnore
	private String payScaleDispValue;

	/**** Post Changes for Senior employee set data END *****/

	/** The status id. */
	private long statusId;

	/* Senior employee set data */

	private long cClassId;
	private long cDesignationId;

	private long cBasicPay;

	/* senior current 5th pay */
	private long cPayScale;
	/* 5th pay */

	/* senior current 6th pay */
	private String cPayBandIdValue;
	private long cPayBandId;
	private long cPayBandValue;
	private long cGradePayId;
	/* 6th pay */

	/* senior current 7th pay */
	private long cPayLevelId;
	private long cCellId;
	/* 7th pay */

	/** The stepping up type */
	@JsonIgnore
	private String steppingUpType;

	/** The stepping up type id */
	private long steppingUpTypeId;
	
	
	/** The empClassName */
	private String empClassName;

	private String remarks;
	/** The auditor remarks. */
	private String auditorRemarks;
	
	/** The verifier remarks. */
	private String verifierRemarks;
	
	/** The class two remarks. */
	private String classTwoRemarks;
	
	/** The class two remarks. */
	private String classOneRemarks;

	/** The print remarks. */
	private String printRemarks;

	/** The auditor return reason. */
	private Long auditorReturnReason;
	
	/** The auditor return reason. */
	private Long verifierReturnReason;
	
	/** The class two return reason. */
	private Long classTwoReturnReason;
	
	/** The class two return reason. */
	private Long classOneReturnReason;

	/** The print return reason. */
	private Long printReturnReason;
	
	/** The print count. */
	private Long printCount;
	/** The return reasons. */
	private List<PVUEventRemarksDto> returnReasons;
	/** The wf role id. */
	private Long wfRoleId;
	
	/** The submit. */
	private boolean submit;
	
	/** The refDate. */
	private LocalDateTime refDate;

	
    /**
     * The currentDetailsEventId.
     */
    private Long currentDetailsEventId;
    
	private Long srSeniorNo;
	
	private Long jrSeniorNo;

	private String prvStpAvailDtls;

	private Long isStpAvail;
	

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

	public String getPrvStpAvailDtls() {
		return prvStpAvailDtls;
	}

	public void setPrvStpAvailDtls(String prvStpAvailDtls) {
		this.prvStpAvailDtls = prvStpAvailDtls;
	}

	public Long getIsStpAvail() {
		return isStpAvail;
	}

	public void setIsStpAvail(Long isStpAvail) {
		this.isStpAvail = isStpAvail;
	}

	public Long getCurrentDetailsEventId() {
        return currentDetailsEventId;
    }

    public void setCurrentDetailsEventId(Long currentDetailsEventId) {
        this.currentDetailsEventId = currentDetailsEventId;
    }


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
		return fields;
	}
	


	public LocalDateTime getRefDate() {
		return refDate;
	}



	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}



	public boolean isSubmit() {
		return submit;
	}



	public void setSubmit(boolean submit) {
		this.submit = submit;
	}



	public String getOfficeName() {
		return officeName;
	}

	public String getVerifierRemarks() {
		return verifierRemarks;
	}

	public void setVerifierRemarks(String verifierRemarks) {
		this.verifierRemarks = verifierRemarks;
	}

	public String getClassOneRemarks() {
		return classOneRemarks;
	}

	public void setClassOneRemarks(String classOneRemarks) {
		this.classOneRemarks = classOneRemarks;
	}

	public Long getVerifierReturnReason() {
		return verifierReturnReason;
	}

	public void setVerifierReturnReason(Long verifierReturnReason) {
		this.verifierReturnReason = verifierReturnReason;
	}

	public List<PVUEventRemarksDto> getReturnReasons() {
		return returnReasons;
	}

	public void setReturnReasons(List<PVUEventRemarksDto> returnReasons) {
		this.returnReasons = returnReasons;
	}

	public Long getWfRoleId() {
		return wfRoleId;
	}

	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAuditorRemarks() {
		return auditorRemarks;
	}

	public void setAuditorRemarks(String auditorRemarks) {
		this.auditorRemarks = auditorRemarks;
	}

	public String getClassTwoRemarks() {
		return classTwoRemarks;
	}

	public void setClassTwoRemarks(String classTwoRemarks) {
		this.classTwoRemarks = classTwoRemarks;
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

	public Long getClassOneReturnReason() {
		return classOneReturnReason;
	}

	public void setClassOneReturnReason(Long classOneReturnReason) {
		this.classOneReturnReason = classOneReturnReason;
	}

	public Long getClassTwoReturnReason() {
		return classTwoReturnReason;
	}

	public void setClassTwoReturnReason(Long classTwoReturnReason) {
		this.classTwoReturnReason = classTwoReturnReason;
	}

	public Long getPrintReturnReason() {
		return printReturnReason;
	}

	public void setPrintReturnReason(Long printReturnReason) {
		this.printReturnReason = printReturnReason;
	}

	public Long getPrintCount() {
		return printCount;
	}

	public void setPrintCount(Long printCount) {
		this.printCount = printCount;
	}

	public String getEmpClassName() {
		return empClassName;
	}

	public void setEmpClassName(String empClassName) {
		this.empClassName = empClassName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getPayScaleDispValue() {
		return payScaleDispValue;
	}

	public void setPayScaleDispValue(String payScaleDispValue) {
		this.payScaleDispValue = payScaleDispValue;
	}

	public String getPayLevelDispValue() {
		return payLevelDispValue;
	}

	public void setPayLevelDispValue(String payLevelDispValue) {
		this.payLevelDispValue = payLevelDispValue;
	}

	public int getCellIdDispValue() {
		return cellIdDispValue;
	}

	public void setCellIdDispValue(int cellIdDispValue) {
		this.cellIdDispValue = cellIdDispValue;
	}

	public String getPayBandDispValue() {
		return payBandDispValue;
	}

	public void setPayBandDispValue(String payBandDispValue) {
		this.payBandDispValue = payBandDispValue;
	}

	public String getGradePayDispValue() {
		return gradePayDispValue;
	}

	public void setGradePayDispValue(String gradePayDispValue) {
		this.gradePayDispValue = gradePayDispValue;
	}

	public long getPayScale() {
		return payScale;
	}

	public void setPayScale(long payScale) {
		this.payScale = payScale;
	}
	
	
	public long getPayLevelId() {
		return payLevelId;
	}



	public void setPayLevelId(long payLevelId) {
		this.payLevelId = payLevelId;
	}



	public long getPayBandId() {
		return payBandId;
	}

	public void setPayBandId(long payBandId) {
		this.payBandId = payBandId;
	}

	public long getPayBandValue() {
		return payBandValue;
	}

	public void setPayBandValue(long payBandValue) {
		this.payBandValue = payBandValue;
	}

	public long getGradePayId() {
		return gradePayId;
	}

	public void setGradePayId(long gradePayId) {
		this.gradePayId = gradePayId;
	}

	public long getCellId() {
		return cellId;
	}

	public void setCellId(long cellId) {
		this.cellId = cellId;
	}

	public long getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(long basicPay) {
		this.basicPay = basicPay;
	}

	public LocalDate getDateOfNextIncrSrJnr() {
		return dateOfNextIncrSrJnr;
	}

	public void setDateOfNextIncrSrJnr(LocalDate dateOfNextIncrSrJnr) {
		this.dateOfNextIncrSrJnr = dateOfNextIncrSrJnr;
	}

	public long getcClassId() {
		return cClassId;
	}

	public void setcClassId(long cClassId) {
		this.cClassId = cClassId;
	}

	public long getcDesignationId() {
		return cDesignationId;
	}

	public void setcDesignationId(long cDesignationId) {
		this.cDesignationId = cDesignationId;
	}

	public long getcPayLevelId() {
		return cPayLevelId;
	}

	public void setcPayLevelId(long cPayLevelId) {
		this.cPayLevelId = cPayLevelId;
	}

	public long getcCellId() {
		return cCellId;
	}

	public void setcCellId(long cCellId) {
		this.cCellId = cCellId;
	}

	public long getcBasicPay() {
		return cBasicPay;
	}

	public void setcBasicPay(long cBasicPay) {
		this.cBasicPay = cBasicPay;
	}

	public long getcPayBandId() {
		return cPayBandId;
	}

	public void setcPayBandId(long cPayBandId) {
		this.cPayBandId = cPayBandId;
	}

	public String getcPayBandIdValue() {
		return cPayBandIdValue;
	}

	public void setcPayBandIdValue(String cPayBandIdValue) {
		this.cPayBandIdValue = cPayBandIdValue;
	}

	public long getcPayBandValue() {
		return cPayBandValue;
	}

	public void setcPayBandValue(long cPayBandValue) {
		this.cPayBandValue = cPayBandValue;
	}

	public long getcGradePayId() {
		return cGradePayId;
	}

	public void setcGradePayId(long cGradePayId) {
		this.cGradePayId = cGradePayId;
	}

	public long getcPayScale() {
		return cPayScale;
	}

	public void setcPayScale(long cPayScale) {
		this.cPayScale = cPayScale;
	}

	public String getJrEmpName() {
		return jrEmpName;
	}

	public void setJrEmpName(String jrEmpName) {
		this.jrEmpName = jrEmpName;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getSteppingUpType() {
		return steppingUpType;
	}

	/**
	 * Sets the type.
	 *
	 * @return the type
	 */
	public void setSteppingUpType(String steppingUpType) {
		this.steppingUpType = steppingUpType;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getSteppingUpTypeId() {
		return steppingUpTypeId;
	}

	/**
	 * Sets the id.
	 *
	 * @return the id
	 */
	public void setSteppingUpTypeId(long steppingUpTypeId) {
		this.steppingUpTypeId = steppingUpTypeId;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getJrPayCommId() {
		return jrPayCommId;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id
	 */
	public void setJrPayCommId(long jrPayCommId) {
		this.jrPayCommId = jrPayCommId;
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
	 * Gets the cur emp no.
	 *
	 * @return the curEmpNo
	 */
	public long getCurEmpNo() {
		return curEmpNo;
	}

	/**
	 * Sets the cur emp no.
	 *
	 * @param curEmpNo the curEmpNo to set
	 */
	public void setCurEmpNo(long curEmpNo) {
		this.curEmpNo = curEmpNo;
	}

	/**
	 * Gets the cur emp id.
	 *
	 * @return the curEmpId
	 */
	public long getCurEmpId() {
		return curEmpId;
	}

	/**
	 * Sets the cur emp id.
	 *
	 * @param curEmpId the curEmpId to set
	 */
	public void setCurEmpId(long curEmpId) {
		this.curEmpId = curEmpId;
	}

	/**
	 * Gets the cur emp class.
	 *
	 * @return the curEmpClass
	 */
	public long getCurEmpClass() {
		return curEmpClass;
	}

	/**
	 * Sets the cur emp class.
	 *
	 * @param curEmpClass the curEmpClass to set
	 */
	public void setCurEmpClass(long curEmpClass) {
		this.curEmpClass = curEmpClass;
	}

	/**
	 * Gets the cur emp dsgn.
	 *
	 * @return the curEmpDsgn
	 */
	public long getCurEmpDsgn() {
		return curEmpDsgn;
	}

	/**
	 * Sets the cur emp dsgn.
	 *
	 * @param curEmpDsgn the curEmpDsgn to set
	 */
	public void setCurEmpDsgn(long curEmpDsgn) {
		this.curEmpDsgn = curEmpDsgn;
	}

	/**
	 * Gets the cur office.
	 *
	 * @return the curOffice
	 */
	public long getCurOffice() {
		return curOffice;
	}

	/**
	 * Sets the cur office.
	 *
	 * @param curOffice the curOffice to set
	 */
	public void setCurOffice(long curOffice) {
		this.curOffice = curOffice;
	}

	/**
	 * Gets the cur grade.
	 *
	 * @return the curGrade
	 */
	public long getCurGrade() {
		return curGrade;
	}

	/**
	 * Sets the cur grade.
	 *
	 * @param curGrade the curGrade to set
	 */
	public void setCurGrade(long curGrade) {
		this.curGrade = curGrade;
	}

	/**
	 * Gets the cur scale.
	 *
	 * @return the curScale
	 */
	public long getCurScale() {
		return curScale;
	}

	/**
	 * Sets the cur scale.
	 *
	 * @param curScale the curScale to set
	 */
	public void setCurScale(long curScale) {
		this.curScale = curScale;
	}

	/**
	 * Gets the cur pay level.
	 *
	 * @return the curPayLevel
	 */
	public long getCurPayLevel() {
		return curPayLevel;
	}

	/**
	 * Sets the cur pay level.
	 *
	 * @param curPayLevel the curPayLevel to set
	 */
	public void setCurPayLevel(long curPayLevel) {
		this.curPayLevel = curPayLevel;
	}

	/**
	 * Gets the cur pay band.
	 *
	 * @return the curPayBand
	 */
	public long getCurPayBand() {
		return curPayBand;
	}

	/**
	 * Sets the cur pay band.
	 *
	 * @param curPayBand the curPayBand to set
	 */
	public void setCurPayBand(long curPayBand) {
		this.curPayBand = curPayBand;
	}

	/**
	 * Gets the cur pay band value.
	 *
	 * @return the curPayBandValue
	 */
	public long getCurPayBandValue() {
		return curPayBandValue;
	}

	/**
	 * Sets the cur pay band value.
	 *
	 * @param curPayBandValue the curPayBandValue to set
	 */
	public void setCurPayBandValue(long curPayBandValue) {
		this.curPayBandValue = curPayBandValue;
	}

	/**
	 * Gets the cur grade pay.
	 *
	 * @return the curGradePay
	 */
	public long getCurGradePay() {
		return curGradePay;
	}

	/**
	 * Sets the cur grade pay.
	 *
	 * @param curGradePay the curGradePay to set
	 */
	public void setCurGradePay(long curGradePay) {
		this.curGradePay = curGradePay;
	}

	/**
	 * Gets the cur cell id.
	 *
	 * @return the curCellId
	 */
	public long getCurCellId() {
		return curCellId;
	}

	/**
	 * Sets the cur cell id.
	 *
	 * @param curCellId the curCellId to set
	 */
	public void setCurCellId(long curCellId) {
		this.curCellId = curCellId;
	}

	/**
	 * Gets the cur basic pay.
	 *
	 * @return the curBasicPay
	 */
	public long getCurBasicPay() {
		return curBasicPay;
	}

	/**
	 * Sets the cur basic pay.
	 *
	 * @param curBasicPay the curBasicPay to set
	 */
	public void setCurBasicPay(long curBasicPay) {
		this.curBasicPay = curBasicPay;
	}

	/**
	 * Gets the cur date next inc.
	 *
	 * @return the curDateNextInc
	 */
	public LocalDate getCurDateNextInc() {
		return curDateNextInc;
	}

	/**
	 * Sets the cur date next inc.
	 *
	 * @param curDateNextInc the curDateNextInc to set
	 */
	public void setCurDateNextInc(LocalDate curDateNextInc) {
		this.curDateNextInc = curDateNextInc;
	}

	/**
	 * Gets the jr emp no.
	 *
	 * @return the jrEmpNo
	 */
	public long getJrEmpNo() {
		return jrEmpNo;
	}

	/**
	 * Sets the jr emp no.
	 *
	 * @param jrEmpNo the jrEmpNo to set
	 */
	public void setJrEmpNo(long jrEmpNo) {
		this.jrEmpNo = jrEmpNo;
	}

	/**
	 * Gets the jr emp id.
	 *
	 * @return the jrEmpId
	 */
	public long getJrEmpId() {
		return jrEmpId;
	}

	/**
	 * Sets the jr emp id.
	 *
	 * @param jrEmpId the jrEmpId to set
	 */
	public void setJrEmpId(long jrEmpId) {
		this.jrEmpId = jrEmpId;
	}

	/**
	 * Gets the jr emp class.
	 *
	 * @return the jrEmpClass
	 */
	public long getJrEmpClass() {
		return jrEmpClass;
	}

	/**
	 * Sets the jr emp class.
	 *
	 * @param jrEmpClass the jrEmpClass to set
	 */
	public void setJrEmpClass(long jrEmpClass) {
		this.jrEmpClass = jrEmpClass;
	}

	/**
	 * Gets the jr emp dsgn.
	 *
	 * @return the jrEmpDsgn
	 */
	public long getJrEmpDsgn() {
		return jrEmpDsgn;
	}

	/**
	 * Sets the jr emp dsgn.
	 *
	 * @param jrEmpDsgn the jrEmpDsgn to set
	 */
	public void setJrEmpDsgn(long jrEmpDsgn) {
		this.jrEmpDsgn = jrEmpDsgn;
	}

	/**
	 * Gets the jr office name.
	 *
	 * @return the jrOfficeId
	 */
	public long getJrOfficeId() {
		return jrOfficeId;
	}

	/**
	 * Sets the jr office name.
	 *
	 * @param jrOfficeName the new jr office id
	 */
	public void setJrOfficeId(long jrOfficeName) {
		this.jrOfficeId = jrOfficeName;
	}

	/**
	 * Gets the jr grade.
	 *
	 * @return the jrGrade
	 */
	public long getJrGrade() {
		return jrGrade;
	}

	/**
	 * Sets the jr grade.
	 *
	 * @param jrGrade the jrGrade to set
	 */
	public void setJrGrade(long jrGrade) {
		this.jrGrade = jrGrade;
	}

	/**
	 * Gets the jr scale.
	 *
	 * @return the jrScale
	 */
	public long getJrScale() {
		return jrScale;
	}

	/**
	 * Sets the jr scale.
	 *
	 * @param jrScale the jrScale to set
	 */
	public void setJrScale(long jrScale) {
		this.jrScale = jrScale;
	}

	/**
	 * Gets the jr pay level.
	 *
	 * @return the jrPayLevel
	 */
	public long getJrPayLevel() {
		return jrPayLevel;
	}

	/**
	 * Sets the jr pay level.
	 *
	 * @param jrPayLevel the jrPayLevel to set
	 */
	public void setJrPayLevel(long jrPayLevel) {
		this.jrPayLevel = jrPayLevel;
	}

	/**
	 * Gets the jr pay band.
	 *
	 * @return the jrPayBand
	 */
	public long getJrPayBand() {
		return jrPayBand;
	}

	/**
	 * Sets the jr pay band.
	 *
	 * @param jrPayBand the jrPayBand to set
	 */
	public void setJrPayBand(long jrPayBand) {
		this.jrPayBand = jrPayBand;
	}

	/**
	 * Gets the jr pay band value.
	 *
	 * @return the jrPayBandValue
	 */
	public long getJrPayBandValue() {
		return jrPayBandValue;
	}

	/**
	 * Sets the jr pay band value.
	 *
	 * @param jrPayBandValue the jrPayBandValue to set
	 */
	public void setJrPayBandValue(long jrPayBandValue) {
		this.jrPayBandValue = jrPayBandValue;
	}

	/**
	 * Gets the jr grade pay.
	 *
	 * @return the jrGradePay
	 */
	public long getJrGradePay() {
		return jrGradePay;
	}

	/**
	 * Sets the jr grade pay.
	 *
	 * @param jrGradePay the jrGradePay to set
	 */
	public void setJrGradePay(long jrGradePay) {
		this.jrGradePay = jrGradePay;
	}

	/**
	 * Gets the jr cell id.
	 *
	 * @return the jrCellId
	 */
	public long getJrCellId() {
		return jrCellId;
	}

	/**
	 * Sets the jr cell id.
	 *
	 * @param jrCellId the jrCellId to set
	 */
	public void setJrCellId(long jrCellId) {
		this.jrCellId = jrCellId;
	}

	/**
	 * Gets the jr basic pay.
	 *
	 * @return the jrBasicPay
	 */
	public long getJrBasicPay() {
		return jrBasicPay;
	}

	/**
	 * Sets the jr basic pay.
	 *
	 * @param jrBasicPay the jrBasicPay to set
	 */
	public void setJrBasicPay(long jrBasicPay) {
		this.jrBasicPay = jrBasicPay;
	}

	/**
	 * Gets the jr date nex inc.
	 *
	 * @return the jrDateNexInc
	 */
	public LocalDate getJrDateNexInc() {
		return jrDateNexInc;
	}

	/**
	 * Sets the jr date nex inc.
	 *
	 * @param jrDateNexInc the jrDateNexInc to set
	 */
	public void setJrDateNexInc(LocalDate jrDateNexInc) {
		this.jrDateNexInc = jrDateNexInc;
	}

	/**
	 * Gets the ch emp class.
	 *
	 * @return the chEmpClass
	 */
	public long getChEmpClass() {
		return chEmpClass;
	}

	/**
	 * Sets the ch emp class.
	 *
	 * @param chEmpClass the chEmpClass to set
	 */
	public void setChEmpClass(long chEmpClass) {
		this.chEmpClass = chEmpClass;
	}

	/**
	 * Gets the ch emp dsgn.
	 *
	 * @return the chEmpDsgn
	 */
	public long getChEmpDsgn() {
		return chEmpDsgn;
	}

	/**
	 * Sets the ch emp dsgn.
	 *
	 * @param chEmpDsgn the chEmpDsgn to set
	 */
	public void setChEmpDsgn(long chEmpDsgn) {
		this.chEmpDsgn = chEmpDsgn;
	}

	/**
	 * Gets the ch grade.
	 *
	 * @return the chGrade
	 */
	public long getChGrade() {
		return chGrade;
	}

	/**
	 * Sets the ch grade.
	 *
	 * @param chGrade the chGrade to set
	 */
	public void setChGrade(long chGrade) {
		this.chGrade = chGrade;
	}



	/**
	 * Gets the ch bene eff date.
	 *
	 * @return the chBeneEffDate
	 */
	public LocalDate getChBeneEffDate() {
		return chBeneEffDate;
	}

	/**
	 * Sets the ch bene eff date.
	 *
	 * @param chBeneEffDate the chBeneEffDate to set
	 */
	public void setChBeneEffDate(LocalDate chBeneEffDate) {
		this.chBeneEffDate = chBeneEffDate;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(basicPay, chBeneEffDate, cellId, dateOfNextIncrSrJnr, chEmpClass, chEmpDsgn, chGrade,
				gradePayId, payBandId, payBandValue, payLevelId, payScale, curBasicPay, curCellId, curDateNextInc,
				curEmpClass, curEmpDsgn, curEmpId, curEmpNo, curGrade, curGradePay, curOffice, curPayBand,
				curPayBandValue, curPayLevel, curScale, employeeId, employeeNo, eventCode, eventEffectiveDate,
				eventOrderDate, eventOrderNo, id, jrBasicPay, jrCellId, jrDateNexInc, jrEmpClass, jrEmpDsgn, jrEmpId,
				jrEmpNo, jrGrade, jrGradePay, jrOfficeId, jrPayBand, jrPayBandValue, jrPayLevel, jrScale, officeId,
				payCommId, statusId, trnNo, jrPayCommId, steppingUpType, steppingUpTypeId, jrEmpName, cClassId,
				cDesignationId, cPayLevelId, cCellId, cBasicPay, cPayBandId, cPayBandIdValue, cPayBandValue,
				cGradePayId, cPayScale, payBandDispValue, gradePayDispValue, payLevelDispValue, cellIdDispValue,
				payScaleDispValue,officeName,employeeName);
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
		if (!(obj instanceof PVUSteppingUpEventDto)) {
			return false;
		}
		PVUSteppingUpEventDto other = (PVUSteppingUpEventDto) obj;
		return basicPay == other.basicPay && Objects.equals(chBeneEffDate, other.chBeneEffDate)
				&& cellId == other.cellId && Objects.equals(dateOfNextIncrSrJnr, other.dateOfNextIncrSrJnr)
				&& chEmpClass == other.chEmpClass && chEmpDsgn == other.chEmpDsgn && chGrade == other.chGrade
				&& gradePayId == other.gradePayId && payBandId == other.payBandId && payBandValue == other.payBandValue
				&& Objects.equals(payLevelId,other.payLevelId) && Objects.equals(payScale, other.payScale) && curBasicPay == other.curBasicPay
				&& curCellId == other.curCellId && Objects.equals(curDateNextInc, other.curDateNextInc)
				&& curEmpClass == other.curEmpClass && curEmpDsgn == other.curEmpDsgn && curEmpId == other.curEmpId
				&& curEmpNo == other.curEmpNo && curGrade == other.curGrade && curGradePay == other.curGradePay
				&& curOffice == other.curOffice && curPayBand == other.curPayBand
				&& curPayBandValue == other.curPayBandValue && curPayLevel == other.curPayLevel
				&& Objects.equals(curScale ,other.curScale) && employeeId == other.employeeId && employeeNo == other.employeeNo
				&& Objects.equals(eventCode, other.eventCode)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate)
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventOrderNo, other.eventOrderNo) && id == other.id && jrBasicPay == other.jrBasicPay
				&& jrCellId == other.jrCellId && Objects.equals(jrDateNexInc, other.jrDateNexInc)
				&& jrEmpClass == other.jrEmpClass && jrEmpDsgn == other.jrEmpDsgn && jrEmpId == other.jrEmpId
				&& jrEmpNo == other.jrEmpNo && jrGrade == other.jrGrade && jrGradePay == other.jrGradePay
				&& jrOfficeId == other.jrOfficeId && jrPayBand == other.jrPayBand
				&& jrPayBandValue == other.jrPayBandValue && jrPayLevel == other.jrPayLevel && jrScale == other.jrScale
				&& officeId == other.officeId && payCommId == other.payCommId && statusId == other.statusId
				&& jrPayCommId == other.jrPayCommId && steppingUpType == other.steppingUpType
				&& Objects.equals(jrEmpName, other.jrEmpName) && Objects.equals(steppingUpTypeId , other.steppingUpTypeId)
				&& Objects.equals(trnNo, other.trnNo) && Objects.equals(cClassId, other.cClassId)
				&& Objects.equals(cDesignationId, other.cDesignationId)
				&& Objects.equals(cPayLevelId, other.cPayLevelId) && Objects.equals(cCellId, other.cCellId)
				&& Objects.equals(cBasicPay, other.cBasicPay) && Objects.equals(cPayBandId, other.cPayBandId)
				&& Objects.equals(cPayBandIdValue, other.cPayBandIdValue)
				&& Objects.equals(cPayBandValue, other.cPayBandValue) && Objects.equals(cGradePayId, other.cGradePayId)
				&& Objects.equals(cPayScale, other.cPayScale)
				&& Objects.equals(payBandDispValue, other.payBandDispValue)
				&& Objects.equals(gradePayDispValue, other.gradePayDispValue)
				&& Objects.equals(payLevelDispValue, other.payLevelDispValue)
				&& Objects.equals(payScaleDispValue, other.payScaleDispValue)&& Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(cellIdDispValue, other.cellIdDispValue)&& Objects.equals(officeName, other.officeName);
	}



	@Override
	public String toString() {
		return "PVUSteppingUpEventDto [id=" + id + ", trnNo=" + trnNo + ", eventCode=" + eventCode + ", officeId="
				+ officeId + ", officeName=" + officeName + ", eventOrderNo=" + eventOrderNo + ", eventOrderDate="
				+ eventOrderDate + ", eventEffectiveDate=" + eventEffectiveDate + ", payCommId=" + payCommId
				+ ", employeeId=" + employeeId + ", employeeNo=" + employeeNo + ", employeeName=" + employeeName
				+ ", curEmpNo=" + curEmpNo + ", curEmpId=" + curEmpId + ", curEmpClass=" + curEmpClass + ", curEmpDsgn="
				+ curEmpDsgn + ", curOffice=" + curOffice + ", curGrade=" + curGrade + ", curScale=" + curScale
				+ ", curPayLevel=" + curPayLevel + ", curPayBand=" + curPayBand + ", curPayBandValue=" + curPayBandValue
				+ ", curGradePay=" + curGradePay + ", curCellId=" + curCellId + ", curBasicPay=" + curBasicPay
				+ ", curDateNextInc=" + curDateNextInc + ", jrEmpNo=" + jrEmpNo + ", jrEmpId=" + jrEmpId
				+ ", jrEmpName=" + jrEmpName + ", jrEmpClass=" + jrEmpClass + ", jrPayCommId=" + jrPayCommId
				+ ", jrEmpDsgn=" + jrEmpDsgn + ", jrOfficeId=" + jrOfficeId + ", jrGrade=" + jrGrade + ", jrScale="
				+ jrScale + ", jrPayLevel=" + jrPayLevel + ", jrPayBand=" + jrPayBand + ", jrPayBandValue="
				+ jrPayBandValue + ", jrGradePay=" + jrGradePay + ", jrCellId=" + jrCellId + ", jrBasicPay="
				+ jrBasicPay + ", jrDateNexInc=" + jrDateNexInc + ", chEmpClass=" + chEmpClass + ", chEmpDsgn="
				+ chEmpDsgn + ", chGrade=" + chGrade + ", payScale=" + payScale + ", payLevelId=" + payLevelId
				+ ", payBandId=" + payBandId + ", payBandValue=" + payBandValue + ", gradePayId=" + gradePayId
				+ ", cellId=" + cellId + ", basicPay=" + basicPay + ", dateOfNextIncrSrJnr=" + dateOfNextIncrSrJnr
				+ ", chBeneEffDate=" + chBeneEffDate + ", payBandDispValue=" + payBandDispValue + ", gradePayDispValue="
				+ gradePayDispValue + ", payLevelDispValue=" + payLevelDispValue + ", cellIdDispValue="
				+ cellIdDispValue + ", payScaleDispValue=" + payScaleDispValue + ", statusId=" + statusId
				+ ", cClassId=" + cClassId + ", cDesignationId=" + cDesignationId + ", cBasicPay=" + cBasicPay
				+ ", cPayScale=" + cPayScale + ", cPayBandIdValue=" + cPayBandIdValue + ", cPayBandId=" + cPayBandId
				+ ", cPayBandValue=" + cPayBandValue + ", cGradePayId=" + cGradePayId + ", cPayLevelId=" + cPayLevelId
				+ ", cCellId=" + cCellId + ", steppingUpType=" + steppingUpType + ", steppingUpTypeId="
				+ steppingUpTypeId + ", empClassName=" + empClassName + ", remarks=" + remarks + ", auditorRemarks="
				+ auditorRemarks + ", verifierRemarks=" + verifierRemarks + ", classTwoRemarks=" + classTwoRemarks
				+ ", classOneRemarks=" + classOneRemarks + ", printRemarks=" + printRemarks + ", auditorReturnReason="
				+ auditorReturnReason + ", verifierReturnReason=" + verifierReturnReason + ", classTwoReturnReason="
				+ classTwoReturnReason + ", classOneReturnReason=" + classOneReturnReason + ", printReturnReason="
				+ printReturnReason + ", printCount=" + printCount + ", returnReasons=" + returnReasons + ", wfRoleId="
				+ wfRoleId + ", submit=" + submit + "]";
	}


	

}
