package gov.ifms.pvu.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.ifms.edp.dto.BaseDto;
import gov.ifms.pvu.util.PvuConstant;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PVUEmployeTikuPayDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private long id;

    private String trnNo;

    private boolean isSubmit;
    private String officeName;
    private String eventOrderNo;
    private long payCommId;

    @NotNull
    private LocalDate eventOrderDate;
    @NotNull
    private LocalDate eventEffectiveDate;

    private String eventCode = PvuConstant.EVENT_CODE_TIKU;
    private long tikuType;

    private long adhocId;
    private LocalDate adhocFromDate;
    private LocalDate adhocToDate;
    private long serviceRegularisedId;
    private long gpscExamPassedId;
    private LocalDate gpscExamPassedDate;
    private LocalDate dojRegularServiceDate;
    private long employeeClassId;
    private long designationId;
    private long optionAvailableId;
    private LocalDate optionAvailableDate;
    private long basicPay;
    private LocalDate benEffDate;
    private LocalDate dateOfNextIncrement;

    private LocalDate tikuPay1;
    private LocalDate tikuPay2;


    private long payLevelId;
    private long cellId;

    private long eventId;
    private long statusId;
    private long employeeId;
    private long officeId;
    private long employeeNo;
    private long departmentCategoryId;


    @NotNull
    private long payScale;
    private long payBandId;
    private long payBandValue;
    private long grade;
    private long gradePayId;

    private long cCellId;
    private long cDesignationId;
    private long cPayLevelId;
    private long cPayScaleId;
    private long cClassId;
    private long cPayBandId;
    private long cPayBandValue;
    private long cGradePayId;
    private long cBasicPay;
    private LocalDate cDateOfRetiremnet;
    private LocalDateTime refDate;

    private String remarks;
    private String auditorRemarks;
    private String verifierRemarks;
    private String classTwoRemarks;
    private String classOneRemarks;
    private String printRemarks;

    private Long auditorReturnReason;
    private Long verifierReturnReason;
    private Long classOneReturnReason;
    private Long classTwoReturnReason;
    private Long printReturnReason;
    private Long printCount;
    private List<PVUEventRemarksDto> returnReasons;
    private Long wfRoleId;
    private Long currentDetailsEventId;
    private LocalDate cDateOfNextIncrement;
    
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
    

    public Long getCurrentDetailsEventId() {
		return currentDetailsEventId;
	}

	public void setCurrentDetailsEventId(Long currentDetailsEventId) {
		this.currentDetailsEventId = currentDetailsEventId;
	}

	public LocalDateTime getRefDate() {
        return refDate;
    }

    public void setRefDate(LocalDateTime refDate) {
        this.refDate = refDate;
    }

    private Long empId;

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

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Long getClassOneReturnReason() {
        return classOneReturnReason;
    }

    public void setClassOneReturnReason(Long classOneReturnReason) {
        this.classOneReturnReason = classOneReturnReason;
    }

    public Long getWfRoleId() {
        return wfRoleId;
    }

    public void setWfRoleId(Long wfRoleId) {
        this.wfRoleId = wfRoleId;
    }

    public List<PVUEventRemarksDto> getReturnReasons() {
        return returnReasons;
    }

    public void setReturnReasons(List<PVUEventRemarksDto> returnReasons) {
        this.returnReasons = returnReasons;
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

    public long getcCellId() {
        return cCellId;
    }

    public void setcCellId(long cCellId) {
        this.cCellId = cCellId;
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

    public long getcPayScaleId() {
        return cPayScaleId;
    }

    public void setcPayScaleId(long cPayScaleId) {
        this.cPayScaleId = cPayScaleId;
    }

    public long getcClassId() {
        return cClassId;
    }

    public void setcClassId(long cClassId) {
        this.cClassId = cClassId;
    }

    public long getcPayBandId() {
        return cPayBandId;
    }

    public void setcPayBandId(long cPayBandId) {
        this.cPayBandId = cPayBandId;
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

    public long getcBasicPay() {
        return cBasicPay;
    }

    public void setcBasicPay(long cBasicPay) {
        this.cBasicPay = cBasicPay;
    }

    public LocalDate getcDateOfRetiremnet() {
        return cDateOfRetiremnet;
    }

    public void setcDateOfRetiremnet(LocalDate cDateOfRetiremnet) {
        this.cDateOfRetiremnet = cDateOfRetiremnet;
    }

    public boolean isSubmit() {
        return isSubmit;
    }

    public void setSubmit(boolean isSubmit) {
        this.isSubmit = isSubmit;
    }

    public long getPayScale() {
        return payScale;
    }

    public void setPayScale(long payScale) {
        this.payScale = payScale;
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

    public long getGrade() {
        return grade;
    }

    public void setGrade(long grade) {
        this.grade = grade;
    }

    public long getGradePayId() {
        return gradePayId;
    }

    public void setGradePayId(long gradePayId) {
        this.gradePayId = gradePayId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrnNo() {
        return trnNo;
    }

    public void setTrnNo(String trnNo) {
        this.trnNo = trnNo;
    }

    public LocalDate getTikuPay1() {
        return tikuPay1;
    }

    public void setTikuPay1(LocalDate tikuPay1) {
        this.tikuPay1 = tikuPay1;
    }

    public LocalDate getTikuPay2() {
        return tikuPay2;
    }

    public void setTikuPay2(LocalDate tikuPay2) {
        this.tikuPay2 = tikuPay2;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getEventOrderNo() {
        return eventOrderNo;
    }

    public void setEventOrderNo(String eventOrderNo) {
        this.eventOrderNo = eventOrderNo;
    }

    public long getPayCommId() {
        return payCommId;
    }

    public void setPayCommId(long payCommId) {
        this.payCommId = payCommId;
    }

    public LocalDate getEventOrderDate() {
        return eventOrderDate;
    }

    public void setEventOrderDate(LocalDate eventOrderDate) {
        this.eventOrderDate = eventOrderDate;
    }

    public LocalDate getEventEffectiveDate() {
        return eventEffectiveDate;
    }

    public void setEventEffectiveDate(LocalDate eventEffectiveDate) {
        this.eventEffectiveDate = eventEffectiveDate;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public long getTikuType() {
        return tikuType;
    }

    public void setTikuType(long tikuType) {
        this.tikuType = tikuType;
    }

    public long getAdhocId() {
        return adhocId;
    }

    public void setAdhocId(long adhocId) {
        this.adhocId = adhocId;
    }

    public LocalDate getAdhocFromDate() {
        return adhocFromDate;
    }

    public void setAdhocFromDate(LocalDate adhocFromDate) {
        this.adhocFromDate = adhocFromDate;
    }

    public LocalDate getAdhocToDate() {
        return adhocToDate;
    }

    public void setAdhocToDate(LocalDate adhocToDate) {
        this.adhocToDate = adhocToDate;
    }

    public long getServiceRegularisedId() {
        return serviceRegularisedId;
    }

    public void setServiceRegularisedId(long serviceRegularisedId) {
        this.serviceRegularisedId = serviceRegularisedId;
    }

    public long getGpscExamPassedId() {
        return gpscExamPassedId;
    }

    public void setGpscExamPassedId(long gpscExamPassedId) {
        this.gpscExamPassedId = gpscExamPassedId;
    }

    public LocalDate getGpscExamPassedDate() {
        return gpscExamPassedDate;
    }

    public void setGpscExamPassedDate(LocalDate gpscExamPassedDate) {
        this.gpscExamPassedDate = gpscExamPassedDate;
    }

    public LocalDate getDojRegularServiceDate() {
        return dojRegularServiceDate;
    }

    public void setDojRegularServiceDate(LocalDate dojRegularServiceDate) {
        this.dojRegularServiceDate = dojRegularServiceDate;
    }

    public long getOptionAvailableId() {
        return optionAvailableId;
    }

    public void setOptionAvailableId(long optionAvailableId) {
        this.optionAvailableId = optionAvailableId;
    }

    public LocalDate getOptionAvailableDate() {
        return optionAvailableDate;
    }

    public void setOptionAvailableDate(LocalDate optionAvailableDate) {
        this.optionAvailableDate = optionAvailableDate;
    }

    public long getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(long basicPay) {
        this.basicPay = basicPay;
    }

    public LocalDate getBenEffDate() {
        return benEffDate;
    }

    public void setBenEffDate(LocalDate benEffDate) {
        this.benEffDate = benEffDate;
    }

    public LocalDate getDateOfNextIncrement() {
        return dateOfNextIncrement;
    }

    public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
        this.dateOfNextIncrement = dateOfNextIncrement;
    }

    public long getPayLevelId() {
        return payLevelId;
    }

    public void setPayLevelId(long payLevelId) {
        this.payLevelId = payLevelId;
    }

    public long getCellId() {
        return cellId;
    }

    public void setCellId(long cellId) {
        this.cellId = cellId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public long getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(long employeeNo) {
        this.employeeNo = employeeNo;
    }

    public long getDepartmentCategoryId() {
        return departmentCategoryId;
    }

    public void setDepartmentCategoryId(long departmentCategoryId) {
        this.departmentCategoryId = departmentCategoryId;
    }

    public long getEmployeeClassId() {
        return employeeClassId;
    }

    public void setEmployeeClassId(long employeeClassId) {
        this.employeeClassId = employeeClassId;
    }

    public long getDesignationId() {
        return designationId;
    }

    public void setDesignationId(long designationId) {
        this.designationId = designationId;
    }

    public LocalDate getcDateOfNextIncrement() {
        return cDateOfNextIncrement;
    }

    public void setcDateOfNextIncrement(LocalDate cDateOfNextIncrement) {
        this.cDateOfNextIncrement = cDateOfNextIncrement;
    }

    @NotNull
    @JsonIgnore
    public boolean isNew() {
        return this.id == 0;
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

	@Override
	public String toString() {
		return "PVUEmployeTikuPayDto [id=" + id + ", trnNo=" + trnNo + ", isSubmit=" + isSubmit + ", officeName="
				+ officeName + ", eventOrderNo=" + eventOrderNo + ", payCommId=" + payCommId + ", eventOrderDate="
				+ eventOrderDate + ", eventEffectiveDate=" + eventEffectiveDate + ", eventCode=" + eventCode
				+ ", tikuType=" + tikuType + ", adhocId=" + adhocId + ", adhocFromDate=" + adhocFromDate
				+ ", adhocToDate=" + adhocToDate + ", serviceRegularisedId=" + serviceRegularisedId
				+ ", gpscExamPassedId=" + gpscExamPassedId + ", gpscExamPassedDate=" + gpscExamPassedDate
				+ ", dojRegularServiceDate=" + dojRegularServiceDate + ", employeeClassId=" + employeeClassId
				+ ", designationId=" + designationId + ", optionAvailableId=" + optionAvailableId
				+ ", optionAvailableDate=" + optionAvailableDate + ", basicPay=" + basicPay + ", benEffDate="
				+ benEffDate + ", dateOfNextIncrement=" + dateOfNextIncrement + ", tikuPay1=" + tikuPay1 + ", tikuPay2="
				+ tikuPay2 + ", payLevelId=" + payLevelId + ", cellId=" + cellId + ", eventId=" + eventId
				+ ", statusId=" + statusId + ", employeeId=" + employeeId + ", officeId=" + officeId + ", employeeNo="
				+ employeeNo + ", departmentCategoryId=" + departmentCategoryId + ", payScale=" + payScale
				+ ", payBandId=" + payBandId + ", payBandValue=" + payBandValue + ", grade=" + grade + ", gradePayId="
				+ gradePayId + ", cCellId=" + cCellId + ", cDesignationId=" + cDesignationId + ", cPayLevelId="
				+ cPayLevelId + ", cPayScaleId=" + cPayScaleId + ", cClassId=" + cClassId + ", cPayBandId=" + cPayBandId
				+ ", cPayBandValue=" + cPayBandValue + ", cGradePayId=" + cGradePayId + ", cBasicPay=" + cBasicPay
				+ ", cDateOfRetiremnet=" + cDateOfRetiremnet + ", refDate=" + refDate + ", remarks=" + remarks
				+ ", auditorRemarks=" + auditorRemarks + ", verifierRemarks=" + verifierRemarks + ", classTwoRemarks="
				+ classTwoRemarks + ", classOneRemarks=" + classOneRemarks + ", printRemarks=" + printRemarks
				+ ", auditorReturnReason=" + auditorReturnReason + ", verifierReturnReason=" + verifierReturnReason
				+ ", classOneReturnReason=" + classOneReturnReason + ", classTwoReturnReason=" + classTwoReturnReason
				+ ", printReturnReason=" + printReturnReason + ", printCount=" + printCount + ", returnReasons="
				+ returnReasons + ", wfRoleId=" + wfRoleId + ", currentDetailsEventId=" + currentDetailsEventId
				+ ", cDateOfNextIncrement=" + cDateOfNextIncrement + ", oaBasicPayValue=" + oaBasicPayValue
				+ ", oaPayScaleId=" + oaPayScaleId + ", oaPayBandId=" + oaPayBandId + ", oaPayBandValue="
				+ oaPayBandValue + ", oaGradePayId=" + oaGradePayId + ", oaPayLevelId=" + oaPayLevelId
				+ ", oaCellIdValue=" + oaCellIdValue + ", oaPayCellId=" + oaPayCellId + ", payBandName=" + payBandName
				+ ", gradePayName=" + gradePayName + ", payLevelName=" + payLevelName + ", scaleName=" + scaleName
				+ ", empId=" + empId + "]";
	}
    
    

}
