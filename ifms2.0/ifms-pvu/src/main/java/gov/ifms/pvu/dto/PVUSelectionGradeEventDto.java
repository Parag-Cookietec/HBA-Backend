package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.ifms.pvu.common.PVUCurrentDto;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUSelectionGradeEventDto.
 * 
 * @version v 1.0
 * @created 2019/12/18 11:56:47
 *
 */
public class PVUSelectionGradeEventDto  extends PVUCurrentDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private long id;

	/** The event code. */
	private String eventCode = PvuConstant.EVENT_CODE_SELECTION_GRAD;

	/** The trn no. */
	private String trnNo;

	/** The office id. */
	private Long officeId;

	/** The pay comm id. */
	private Long payCommId;

	/** The event order no. */
	private String eventOrderNo;

	/** The event order date. */
	private LocalDate eventOrderDate;

	/** The event effective date. */
	private LocalDate eventEffectiveDate;

	/**
     * The benefit effective date.
     */
    private LocalDate benefitEffectiveDate;
	
	/** The employee id. */
	private Long employeeId;

	/** The employee no. */
	private Long employeeNo;

	/** The designation id. */
	private Long designationId;

	/** The pay level id. */
	private Long payLevelId;

	/** The pay band id. */
	private Long payBandId;

	/** The grade pay id. */
	private Long gradePayId;

	/** The cell id. */
	private Long cellId;

	/** The grade. */
	private Long grade;

	/** The pay scale. */
	private Long payScale;

	/** The pay band value. */
	private Long payBandValue;

	/** The bene effict date. */
	private LocalDate beneEffictDate;

	/** The date of next increment. */
	private LocalDate dateOfNextIncrement;

	/** The basic pay. */
	private long basicPay;

	/** The personal pay. */
	private String personalPay;

	/** The remarks. */
	private String remarks;

	/** The status id. */
	private Long statusId;
	
	private LocalDateTime refDate; 
	
	
	@JsonIgnore
	private String payLevelName;

	/**
	 * The cellName
	 */
	@JsonIgnore
	private String cellName;

	/**
	 * The payBandName
	 */
	@JsonIgnore
	private String payBandName;

	/**
	 * The gradePayName.
	 */
	@JsonIgnore
	private String gradePayName;

	/**
	 * The scaleName.
	 */
	@JsonIgnore
	private String scaleName;

	/** The approve date. */
	private LocalDateTime approveDate;

	/** The authorize date. */
	private LocalDateTime authorizeDate;

	private Long isPrintAble;

	private String auditorRemarks;

	private String verifierRemarks;

	private String classTwoRemarks;

	private String classOneRemarks;

	private String printRemarks;

	private Long verifierReturnReason;

	private Long classOneReturnReason;

	/** The auditor return reason. */
	private Long auditorReturnReason;

	/** The class two return reason. */
	private Long classTwoReturnReason;

	private Long printReturnReason;

	private Long printCount;

	private LocalDateTime initDate;

	/** The return reasons. */
	private List<PVUEventRemarksDto> returnReasons;

	/** The wf role id. */
	private Long wfRoleId;
	
	private String officeName;
	
	/** Scale Value */
	private String payScaleValue;
	

	public String getPayScaleValue() {
		return payScaleValue;
	}

	public void setPayScaleValue(String payScaleValue) {
		this.payScaleValue = payScaleValue;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
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
	public void setId(Long id) {
		this.id = id;
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
	 * Gets the pay comm id.
	 *
	 * @return the payCommId
	 */
	public Long getPayCommId() {
		return payCommId;
	}

	/**
	 * Sets the pay comm id.
	 *
	 * @param payCommId the payCommId to set
	 */
	public void setPayCommId(Long payCommId) {
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
	 * Gets the employee id.
	 *
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the employee no.
	 *
	 * @return the employeeNo
	 */
	public Long getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * Sets the employee no.
	 *
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public Long getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the pay level id.
	 *
	 * @return the payLevelId
	 */
	public Long getPayLevelId() {
		return payLevelId;
	}

	/**
	 * Sets the pay level id.
	 *
	 * @param payLevelId the payLevelId to set
	 */
	public void setPayLevelId(Long payLevelId) {
		this.payLevelId = payLevelId;
	}

	/**
	 * Gets the pay band id.
	 *
	 * @return the payBandId
	 */
	public Long getPayBandId() {
		return payBandId;
	}

	/**
	 * Sets the pay band id.
	 *
	 * @param payBandId the payBandId to set
	 */
	public void setPayBandId(Long payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * Gets the grade pay id.
	 *
	 * @return the gradePayId
	 */
	public Long getGradePayId() {
		return gradePayId;
	}

	/**
	 * Sets the grade pay id.
	 *
	 * @param gradePayId the gradePayId to set
	 */
	public void setGradePayId(Long gradePayId) {
		this.gradePayId = gradePayId;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cellId
	 */
	public Long getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the cellId to set
	 */
	public void setCellId(Long cellId) {
		this.cellId = cellId;
	}

	/**
	 * Gets the grade.
	 *
	 * @return the grade
	 */
	public Long getGrade() {
		return grade;
	}

	/**
	 * Sets the grade.
	 *
	 * @param grade the grade to set
	 */
	public void setGrade(Long grade) {
		this.grade = grade;
	}

	/**
	 * Gets the pay scale.
	 *
	 * @return the payScale
	 */
	public Long getPayScale() {
		return payScale;
	}

	/**
	 * Sets the pay scale.
	 *
	 * @param payScale the payScale to set
	 */
	public void setPayScale(Long payScale) {
		this.payScale = payScale;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return the payBandValue
	 */
	public Long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(Long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Gets the bene effict date.
	 *
	 * @return the beneEffictDate
	 */
	public LocalDate getBeneEffictDate() {
		return beneEffictDate;
	}

	/**
	 * Sets the bene effict date.
	 *
	 * @param beneEffictDate the beneEffictDate to set
	 */
	public void setBeneEffictDate(LocalDate beneEffictDate) {
		this.beneEffictDate = beneEffictDate;
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
	 * Gets the personal pay.
	 *
	 * @return the personalPay
	 */
	public String getPersonalPay() {
		return personalPay;
	}

	/**
	 * Sets the personal pay.
	 *
	 * @param personalPay the personalPay to set
	 */
	public void setPersonalPay(String personalPay) {
		this.personalPay = personalPay;
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
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public LocalDate getBenefitEffectiveDate() {
		return benefitEffectiveDate;
	}

	public void setBenefitEffectiveDate(LocalDate benefitEffectiveDate) {
		this.benefitEffectiveDate = benefitEffectiveDate;
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

	public LocalDateTime getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(LocalDateTime approveDate) {
		this.approveDate = approveDate;
	}

	public LocalDateTime getAuthorizeDate() {
		return authorizeDate;
	}

	public void setAuthorizeDate(LocalDateTime authorizeDate) {
		this.authorizeDate = authorizeDate;
	}

	public Long getIsPrintAble() {
		return isPrintAble;
	}

	public void setIsPrintAble(Long isPrintAble) {
		this.isPrintAble = isPrintAble;
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

	public Long getVerifierReturnReason() {
		return verifierReturnReason;
	}

	public void setVerifierReturnReason(Long verifierReturnReason) {
		this.verifierReturnReason = verifierReturnReason;
	}

	public Long getClassOneReturnReason() {
		return classOneReturnReason;
	}

	public void setClassOneReturnReason(Long classOneReturnReason) {
		this.classOneReturnReason = classOneReturnReason;
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

	public LocalDateTime getInitDate() {
		return initDate;
	}

	public void setInitDate(LocalDateTime initDate) {
		this.initDate = initDate;
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

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the refDate
	 */
	public LocalDateTime getRefDate() {
		return refDate;
	}

	/**
	 * @param refDate the refDate to set
	 */
	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(basicPay, beneEffictDate, cellId, dateOfNextIncrement, designationId, employeeId,
				employeeNo, eventCode, eventEffectiveDate, eventOrderDate, eventOrderNo, grade, gradePayId, id,
				officeId, payBandId, payBandValue, payCommId, payLevelId, payScale, personalPay, remarks, statusId,
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
		if (!(obj instanceof PVUSelectionGradeEventDto)) {
			return false;
		}
		PVUSelectionGradeEventDto other = (PVUSelectionGradeEventDto) obj;
		return basicPay == other.basicPay && Objects.equals(beneEffictDate, other.beneEffictDate)
				&& cellId == other.cellId && Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& designationId == other.designationId && employeeId == other.employeeId
				&& employeeNo == other.employeeNo && Objects.equals(eventCode, other.eventCode)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate)
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventOrderNo, other.eventOrderNo) && grade == other.grade
				&& gradePayId == other.gradePayId && id == other.id && officeId == other.officeId
				&& payBandId == other.payBandId && payBandValue == other.payBandValue && payCommId == other.payCommId
				&& payLevelId == other.payLevelId && payScale == other.payScale
				&& Objects.equals(personalPay, other.personalPay) && Objects.equals(remarks, other.remarks)
				&& statusId == other.statusId && Objects.equals(trnNo, other.trnNo);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUSelectionGradeEventDto [id=" + id + ", eventCode=" + eventCode + ", trnNo=" + trnNo + ", officeId="
				+ officeId + ", payCommId=" + payCommId + ", eventOrderNo=" + eventOrderNo + ", eventOrderDate="
				+ eventOrderDate + ", eventEffectiveDate=" + eventEffectiveDate + ", employeeId=" + employeeId
				+ ", employeeNo=" + employeeNo + ", empType=" + ", designationId=" + designationId + ", payLevelId="
				+ payLevelId + ", payBandId=" + payBandId + ", gradePayId=" + gradePayId + ", cellId=" + cellId
				+ ", grade=" + grade + ", payScale=" + payScale + ", payBandValue=" + payBandValue + ", beneEffictDate="
				+ beneEffictDate + ", dateOfNextIncrement=" + dateOfNextIncrement + ", basicPay=" + basicPay
				+ ", personalPay=" + personalPay + ", remarks=" + remarks + ", statusId=" + statusId + "]";
	}

}
