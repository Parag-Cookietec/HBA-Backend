package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.ifms.pvu.common.PVUCurrentDto;

/**
 * The Class PVUCsEventDto.
 */
public class PVUCsEventDto extends PVUCurrentDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** cs Event Id */
	private Long id;

	/**
	 * The isSubmit flag.
	 */
	private boolean submit;

	/** Transaction Number */
	private String trnNo;

	/** The event code. */
	private String eventCode;

	/** The employee no. */
	private Long employeeNo;

	/** Office Id */
	private Long officeId;

	/** Pay Commission */
	private Long payCommId;

	/** Event Order Number */
	private String eventOrderNo;

	/** Event Order Date */
	private LocalDate eventOrderDate;

	/** Event Effective Date */
	private LocalDate eventEffectiveDate;

	/** Status Id */
	private Long statusId;

	/** Employee Id */
	private Long employeeId;

	/** Scale */
	private Long payScale;

	@JsonIgnore
	private String payscaleName;

	/** Pay Level */
	private Long payLevelId;

	@JsonIgnore
	private String payLevelName;

	/** Cell Id */
	private Long cellId;

	@JsonIgnore
	private String cellName;

	/** Pay Band */
	private Long payBandId;

	@JsonIgnore
	private String payBandName;

	/** Pay Band Value */
	private Long payBandValue;

	/** Grade Pay */
	private Long gradePayId;

	@JsonIgnore
	private String gradePayName;

	/** Next Increment Date */
	private LocalDate dateOfNextIncrement;

	/** Notional From Date */
	private LocalDate notionalFromDate;

	/** Notional To Date */
	private LocalDate notionalToDate;

	/** Notional Duration */
	private Integer duration;

	/** Remarks */
	private String remarks;

	/** Basic Pay */
	private Long basicPay;

	/** PVU Event Id */
	private Long eventId;

	/** Personal Pay */
	private Long personalPay;

	private Long cPayScale;
	
	private Long cDepartmentCategoryId;
	
	private Long departmentCategoryId;
	
	private LocalDate cDateOfRetiremnet;
	
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

	/** The wf role id. */
	private Long wfRoleId;

	private LocalDateTime refDate;

	/** The return reasons. */
	private List<PVUEventRemarksDto> returnReasons;

	/**
	 * @return the cDateOfRetiremnet
	 */
	public LocalDate getcDateOfRetiremnet() {
		return cDateOfRetiremnet;
	}

	/**
	 * @param cDateOfRetiremnet the cDateOfRetiremnet to set
	 */
	public void setcDateOfRetiremnet(LocalDate cDateOfRetiremnet) {
		this.cDateOfRetiremnet = cDateOfRetiremnet;
	}

	/**
	 * @return the cPayScale
	 */
	public Long getcPayScale() {
		return cPayScale;
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
	 * @param cPayScale the cPayScale to set
	 */
	public void setcPayScale(Long cPayScale) {
		this.cPayScale = cPayScale;
	}

	public LocalDateTime getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	public String getVerifierRemarks() {
		return verifierRemarks;
	}

	public void setVerifierRemarks(String verifierRemarks) {
		this.verifierRemarks = verifierRemarks;
	}

	public Long getVerifierReturnReason() {
		return verifierReturnReason;
	}

	public void setVerifierReturnReason(Long verifierReturnReason) {
		this.verifierReturnReason = verifierReturnReason;
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

	public Long getPrintCount() {
		return printCount;
	}

	public void setPrintCount(Long printCount) {
		this.printCount = printCount;
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

	public String getPayscaleName() {
		return payscaleName;
	}

	public void setPayscaleName(String payscaleName) {
		this.payscaleName = payscaleName;
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
	
	public Long getcDepartmentCategoryId() {
		return cDepartmentCategoryId;
	}

	public void setcDepartmentCategoryId(Long cDepartmentCategoryId) {
		this.cDepartmentCategoryId = cDepartmentCategoryId;
	}
	/**
	 * PVUCsEventDto Constructor
	 */
	public PVUCsEventDto() {
		super();
	}

	/**
	 * getter setter
	 */

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}

	/**
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * @return the employeeNo
	 */
	public Long getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * @return the payCommission
	 */
	public Long getPayCommId() {
		return payCommId;
	}

	/**
	 * @param payCommId the payCommission to set
	 */
	public void setPayCommId(Long payCommId) {
		this.payCommId = payCommId;
	}

	/**
	 * @return the eventOrderNo
	 */
	public String getEventOrderNo() {
		return eventOrderNo;
	}

	/**
	 * @param eventOrderNo the eventOrderNo to set
	 */
	public void setEventOrderNo(String eventOrderNo) {
		this.eventOrderNo = eventOrderNo;
	}

	/**
	 * @return the eventOrderDate
	 */
	public LocalDate getEventOrderDate() {
		return eventOrderDate;
	}

	/**
	 * @param eventOrderDate the eventOrderDate to set
	 */
	public void setEventOrderDate(LocalDate eventOrderDate) {
		this.eventOrderDate = eventOrderDate;
	}

	/**
	 * @return the eventEffectiveDate
	 */
	public LocalDate getEventEffectiveDate() {
		return eventEffectiveDate;
	}

	/**
	 * @param eventEffectiveDate the eventEffectiveDate to set
	 */
	public void setEventEffectiveDate(LocalDate eventEffectiveDate) {
		this.eventEffectiveDate = eventEffectiveDate;
	}

	/**
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the payScale
	 */
	public Long getPayScale() {
		return payScale;
	}

	/**
	 * @param payScale the payScale to set
	 */
	public void setPayScale(Long payScale) {
		this.payScale = payScale;
	}

	/**
	 * @return the payLevel
	 */
	public Long getPayLevelId() {
		return payLevelId;
	}

	/**
	 * @param payLevelId the payLevel to set
	 */
	public void setPayLevelId(Long payLevelId) {
		this.payLevelId = payLevelId;
	}

	/**
	 * @return the cellId
	 */
	public Long getCellId() {
		return cellId;
	}

	/**
	 * @param cellId the cellId to set
	 */
	public void setCellId(Long cellId) {
		this.cellId = cellId;
	}

	/**
	 * @return the payBand
	 */
	public Long getPayBandId() {
		return payBandId;
	}

	/**
	 * @param payBandId the payBand to set
	 */
	public void setPayBandId(Long payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * @return the payBandValue
	 */
	public Long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(Long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * @return the gradePay
	 */
	public Long getGradePayId() {
		return gradePayId;
	}

	/**
	 * @param gradePayId the gradePay to set
	 */
	public void setGradePayId(Long gradePayId) {
		this.gradePayId = gradePayId;
	}

	/**
	 * @return the nextIncrementDate
	 */
	public LocalDate getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * @param dateOfNextIncrement the nextIncrementDate to set
	 */
	public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	/**
	 * @return the notionalFromDate
	 */
	public LocalDate getNotionalFromDate() {
		return notionalFromDate;
	}

	/**
	 * @param notionalFromDate the notionalFromDate to set
	 */
	public void setNotionalFromDate(LocalDate notionalFromDate) {
		this.notionalFromDate = notionalFromDate;
	}

	/**
	 * @return the notionalToDate
	 */
	public LocalDate getNotionalToDate() {
		return notionalToDate;
	}

	/**
	 * @param notionalToDate the notionalToDate to set
	 */
	public void setNotionalToDate(LocalDate notionalToDate) {
		this.notionalToDate = notionalToDate;
	}

	/**
	 * @return the notionalDuration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration the notionalDuration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the basicPay
	 */
	public Long getBasicPay() {
		return basicPay;
	}

	/**
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(Long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * @return the eventId
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the personalPay
	 */
	public Long getPersonalPay() {
		return personalPay;
	}

	/**
	 * @param personalPay the personalPay to set
	 */
	public void setPersonalPay(Long personalPay) {
		this.personalPay = personalPay;
	}

	public boolean isSubmit() {
		return submit;
	}

	public void setSubmit(boolean submit) {
		this.submit = submit;
	}

	/**
	 * hashcode method
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, trnNo, officeId, payCommId, eventOrderNo, eventOrderDate, eventEffectiveDate, statusId,
				employeeId, payScale, payLevelId, cellId, payBandId, payBandValue, gradePayId, dateOfNextIncrement,
				notionalFromDate, notionalToDate, duration, remarks, basicPay, eventId, personalPay);
	}

	/**
	 * equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUCsEventDto)) {
			return false;
		}

		PVUCsEventDto other = (PVUCsEventDto) obj;

		return id == other.id && Objects.equals(trnNo, other.trnNo) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(payCommId, other.payCommId) && Objects.equals(eventOrderNo, other.eventOrderNo)
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(employeeId, other.employeeId)
				&& payScale == other.payScale && Objects.equals(payLevelId, other.payLevelId)
				&& Objects.equals(cellId, other.cellId) && Objects.equals(payBandId, other.payBandId)
				&& payBandValue == other.payBandValue && Objects.equals(gradePayId, other.gradePayId)
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& Objects.equals(notionalFromDate, other.notionalFromDate)
				&& Objects.equals(notionalToDate, other.notionalToDate) && duration == other.duration
				&& Objects.equals(remarks, other.remarks) && basicPay == other.basicPay
				&& Objects.equals(eventId, other.eventId) && personalPay == other.personalPay;
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "PVUCsEventDto [csEventId = " + id + ", trnNo = " + trnNo + ", officeId = " + officeId + ", payCommId = "
				+ payCommId + ", eventOrderNo = " + eventOrderNo + ", eventOrderDate = " + eventOrderDate
				+ ", eventEffectiveDate = " + eventEffectiveDate + ", statusId = " + statusId + ", employeeId = "
				+ employeeId + ", payScale = " + payScale + ", payLevelId = " + payLevelId + ", cellId = " + cellId
				+ ", payBandId = " + payBandId + ", payBandValue = " + payBandValue + ", gradePayId = " + gradePayId
				+ ", dateOfNextIncrement = " + dateOfNextIncrement + ", notionalFromDate = " + notionalFromDate
				+ ", notionalToDate = " + notionalToDate + ", notionalDuration = " + duration + ", remarks = " + remarks
				+ ", basicPay = " + basicPay + ", eventId = " + eventId + ", personalPay = " + personalPay + "]";
	}

	@JsonIgnore
	public boolean isNew() {
		return this.id == 0;
	}

}