package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class PVUCsEventDView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** cs Event Id */
	private Long id;

	/** Transaction Number */
	private String trnNo;

	/** The event code. */
	private String eventCode;

	/** Office Id */
	private String officeId;

	/** Pay Commission */
	private String payCommId;

	/** Event Order Number */
	private String eventOrderNo;

	/** Event Order Date */
	private LocalDate eventOrderDate;

	/** Event Effective Date */
	private LocalDate eventEffectiveDate;

	private LocalDate benefitEffectiveDate;

	/** Employee Id */
	private String employeeId;

	/** The employee no. */
	private String employeeNo;

	/** Scale */
	private String payScale;

	/** Pay Level */
	private String payLevelId;

	/** Cell Id */
	private String cellId;

	/** Pay Band */
	private String payBandId;

	/** Pay Band Value */
	private Long payBandValue;

	/** Grade Pay */
	private String gradePayId;

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

	/** The return reasons. */
	private List<PVUEventRemarksDto> returnReasons;

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public LocalDate getBenefitEffectiveDate() {
		return benefitEffectiveDate;
	}

	public void setBenefitEffectiveDate(LocalDate benefitEffectiveDate) {
		this.benefitEffectiveDate = benefitEffectiveDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventOrderNo() {
		return eventOrderNo;
	}

	public void setEventOrderNo(String eventOrderNo) {
		this.eventOrderNo = eventOrderNo;
	}

	public String getGradePayId() {
		return gradePayId;
	}

	public void setGradePayId(String gradePayId) {
		this.gradePayId = gradePayId;
	}

	public String getTrnNo() {
		return trnNo;
	}

	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getPayCommId() {
		return payCommId;
	}

	public void setPayCommId(String payCommId) {
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

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getPayScale() {
		return payScale;
	}

	public void setPayScale(String payScale) {
		this.payScale = payScale;
	}

	public String getPayLevelId() {
		return payLevelId;
	}

	public void setPayLevelId(String payLevelId) {
		this.payLevelId = payLevelId;
	}

	public String getCellId() {
		return cellId;
	}

	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	public String getPayBandId() {
		return payBandId;
	}

	public void setPayBandId(String payBandId) {
		this.payBandId = payBandId;
	}

	public Long getPayBandValue() {
		return payBandValue;
	}

	public void setPayBandValue(Long payBandValue) {
		this.payBandValue = payBandValue;
	}

	public LocalDate getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	public LocalDate getNotionalFromDate() {
		return notionalFromDate;
	}

	public void setNotionalFromDate(LocalDate notionalFromDate) {
		this.notionalFromDate = notionalFromDate;
	}

	public LocalDate getNotionalToDate() {
		return notionalToDate;
	}

	public void setNotionalToDate(LocalDate notionalToDate) {
		this.notionalToDate = notionalToDate;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(Long basicPay) {
		this.basicPay = basicPay;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
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

}
