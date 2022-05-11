package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUEmployeShettyPayDto.
 *
 * @version v 1.0
 * @created 2020/01/06 12:53:37
 *
 */
/**
 * @author HP
 *
 */
public class PVUEmployeShettyPayDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event id. */
	private long id;

	/** The trn no. */
	private String trnNo;

	/** The event code. */
	private String eventCode = PvuConstant.EVENT_CODE_SHETTY_PAY;

	/** The office id. */
	private long officeId;

	/** The event order no. */
	@NotNull
	private String eventOrderNo;

	/** The event order LocalDate. */
	@NotNull
	@PastOrPresent
	private LocalDate eventOrderDate;
	/** The event eff LocalDate. */
	@NotNull
	@PastOrPresent
	private LocalDate eventEffectiveDate;

	/** The status id. */
	private long statusId;

	/** The emp id. */
	private long employeeId;

	/** The employee no. */
	private long employeeNo;

	/** The pay band value. */
	private Long payBandValue;

	private Long cPayScale;

	private Long cPayBandId;

	private Long cPayBandValue;

	/** Pay Band Id */
	private String cPayBandIdValue;

	/** Grade Value */
	private String cGradePayIdValue;

	/** Scale Value */
	private String cPayScaleValue;

	/** Pay Commission */
	private Long payCommId;

	private boolean submit;

	private String officeName;

	private Long currentDetailsEventId;

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
	private List<PVURopRemarksDto> returnReasons;

	/** The wf role id. */
	private Long wfRoleId;

	private LocalDateTime refDate;

	private Long authorizeBy;

	private String authorizerRemark;

	/**
	 * @return the cPayBandIdValue
	 */
	public String getcPayBandIdValue() {
		return cPayBandIdValue;
	}

	/**
	 * @param cPayBandIdValue the cPayBandIdValue to set
	 */
	public void setcPayBandIdValue(String cPayBandIdValue) {
		this.cPayBandIdValue = cPayBandIdValue;
	}

	/**
	 * @return the cGradePayIdValue
	 */
	public String getcGradePayIdValue() {
		return cGradePayIdValue;
	}

	/**
	 * @param cGradePayIdValue the cGradePayIdValue to set
	 */
	public void setcGradePayIdValue(String cGradePayIdValue) {
		this.cGradePayIdValue = cGradePayIdValue;
	}

	/**
	 * @return the cPayScaleValue
	 */
	public String getcPayScaleValue() {
		return cPayScaleValue;
	}

	/**
	 * @param cPayScaleValue the cPayScaleValue to set
	 */
	public void setcPayScaleValue(String cPayScaleValue) {
		this.cPayScaleValue = cPayScaleValue;
	}

	private Long cGradePayId;

	private Long cBasicPay;

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

	/** The scale. */
	private long payScale;

	/** The basic pay. */
	private long basicPay;

	/** The benefit eff LocalDate. */

	private LocalDate benefitEffectiveDate;

	/** The nxtincr LocalDate. */
	@NotNull
	private LocalDate dateOfNextIncrement;

	/** The remarks. */
	private String remarks;

	/** The pay band. */
	private long payBandId;

	/** The grade pay. */
	private long gradePayId;

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
	 * Gets the event order LocalDate.
	 *
	 * @return the eventOrderDate
	 */
	public LocalDate getEventOrderDate() {
		return eventOrderDate;
	}

	/**
	 * Sets the event order LocalDate.
	 *
	 * @param eventOrderDate the eventOrderDate to set
	 */
	public void setEventOrderDate(LocalDate eventOrderDate) {
		this.eventOrderDate = eventOrderDate;
	}

	/**
	 * Gets the event effective LocalDate.
	 *
	 * @return the eventEffectiveDate
	 */
	public LocalDate getEventEffectiveDate() {
		return eventEffectiveDate;
	}

	/**
	 * Sets the event effective LocalDate.
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
	 * Gets the benefit effective LocalDate.
	 *
	 * @return the benefitEffectiveDate
	 */
	public LocalDate getBenefitEffectiveDate() {
		return benefitEffectiveDate;
	}

	/**
	 * Sets the benefit effective LocalDate.
	 *
	 * @param benefitEffectiveDate the benefitEffectiveDate to set
	 */
	public void setBenefitEffectiveDate(LocalDate benefitEffectiveDate) {
		this.benefitEffectiveDate = benefitEffectiveDate;
	}

	/**
	 * Gets the LocalDate of next increment.
	 *
	 * @return the dateOfNextIncrement
	 */
	public LocalDate getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * Sets the LocalDate of next increment.
	 *
	 * @param dateOfNextIncrement the dateOfNextIncrement to set
	 */
	public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
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

	@Override
	public String toString() {
		return "PVUEmployeShettyPayDto [id=" + id + ", trnNo=" + trnNo + ", eventCode=" + eventCode + ", officeId="
				+ officeId + ", eventOrderNo=" + eventOrderNo + ", eventOrderDate=" + eventOrderDate
				+ ", eventEffectiveDate=" + eventEffectiveDate + ", statusId=" + statusId + ", employeeId=" + employeeId
				+ ", employeeNo=" + employeeNo + ", payBandValue=" + payBandValue + ", cPayScale=" + cPayScale
				+ ", cPayBandId=" + cPayBandId + ", cPayBandValue=" + cPayBandValue + ", cGradePayId=" + cGradePayId
				+ ", cBasicPay=" + cBasicPay + ", payScale=" + payScale + ", basicPay=" + basicPay
				+ ", benefitEffectiveDate=" + benefitEffectiveDate + ", dateOfNextIncrement=" + dateOfNextIncrement
				+ ", remarks=" + remarks + ", payBandId=" + payBandId + ", gradePayId=" + gradePayId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(approveDate, auditorRemarks, auditorReturnReason, authorizeBy, authorizeDate,
				authorizerRemark, basicPay, benefitEffectiveDate, cBasicPay, cGradePayId, cGradePayIdValue, cPayBandId,
				cPayBandIdValue, cPayBandValue, cPayScale, cPayScaleValue, classOneRemarks, classOneReturnReason,
				classTwoRemarks, classTwoReturnReason, currentDetailsEventId, dateOfNextIncrement, employeeId,
				employeeNo, eventCode, eventEffectiveDate, eventOrderDate, eventOrderNo, gradePayId, id, initDate,
				isPrintAble, officeId, officeName, payBandId, payBandValue, payCommId, payScale, printCount,
				printRemarks, printReturnReason, refDate, remarks, returnReasons, statusId, submit, trnNo,
				verifierRemarks, verifierReturnReason, wfRoleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUEmployeShettyPayDto)) {
			return false;
		}
		PVUEmployeShettyPayDto other = (PVUEmployeShettyPayDto) obj;
		return Objects.equals(approveDate, other.approveDate) && Objects.equals(auditorRemarks, other.auditorRemarks)
				&& Objects.equals(auditorReturnReason, other.auditorReturnReason)
				&& Objects.equals(authorizeBy, other.authorizeBy) && Objects.equals(authorizeDate, other.authorizeDate)
				&& Objects.equals(authorizerRemark, other.authorizerRemark) && basicPay == other.basicPay
				&& Objects.equals(benefitEffectiveDate, other.benefitEffectiveDate)
				&& Objects.equals(cBasicPay, other.cBasicPay) && Objects.equals(cGradePayId, other.cGradePayId)
				&& Objects.equals(cGradePayIdValue, other.cGradePayIdValue)
				&& Objects.equals(cPayBandId, other.cPayBandId)
				&& Objects.equals(cPayBandIdValue, other.cPayBandIdValue)
				&& Objects.equals(cPayBandValue, other.cPayBandValue) && Objects.equals(cPayScale, other.cPayScale)
				&& Objects.equals(cPayScaleValue, other.cPayScaleValue)
				&& Objects.equals(classOneRemarks, other.classOneRemarks)
				&& Objects.equals(classOneReturnReason, other.classOneReturnReason)
				&& Objects.equals(classTwoRemarks, other.classTwoRemarks)
				&& Objects.equals(classTwoReturnReason, other.classTwoReturnReason)
				&& Objects.equals(currentDetailsEventId, other.currentDetailsEventId)
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement) && employeeId == other.employeeId
				&& employeeNo == other.employeeNo && Objects.equals(eventCode, other.eventCode)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate)
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventOrderNo, other.eventOrderNo) && gradePayId == other.gradePayId && id == other.id
				&& Objects.equals(initDate, other.initDate) && Objects.equals(isPrintAble, other.isPrintAble)
				&& officeId == other.officeId && Objects.equals(officeName, other.officeName)
				&& payBandId == other.payBandId && Objects.equals(payBandValue, other.payBandValue)
				&& Objects.equals(payCommId, other.payCommId) && payScale == other.payScale
				&& Objects.equals(printCount, other.printCount) && Objects.equals(printRemarks, other.printRemarks)
				&& Objects.equals(printReturnReason, other.printReturnReason) && Objects.equals(refDate, other.refDate)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(returnReasons, other.returnReasons)
				&& statusId == other.statusId && submit == other.submit && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(verifierRemarks, other.verifierRemarks)
				&& Objects.equals(verifierReturnReason, other.verifierReturnReason)
				&& Objects.equals(wfRoleId, other.wfRoleId);
	}

	/**
	 * PVUEmployeShettyPayDto Constructor.
	 */
	public PVUEmployeShettyPayDto() {
		super();
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
	 * @return the cPayScale
	 */
	public Long getcPayScale() {
		return cPayScale;
	}

	/**
	 * @param cPayScale the cPayScale to set
	 */
	public void setcPayScale(Long cPayScale) {
		this.cPayScale = cPayScale;
	}

	/**
	 * @return the cPayBandId
	 */
	public Long getcPayBandId() {
		return cPayBandId;
	}

	/**
	 * @param cPayBandId the cPayBandId to set
	 */
	public void setcPayBandId(Long cPayBandId) {
		this.cPayBandId = cPayBandId;
	}

	/**
	 * @return the cPayBandValue
	 */
	public Long getcPayBandValue() {
		return cPayBandValue;
	}

	/**
	 * @param cPayBandValue the cPayBandValue to set
	 */
	public void setcPayBandValue(Long cPayBandValue) {
		this.cPayBandValue = cPayBandValue;
	}

	/**
	 * @return the cGradePayId
	 */
	public Long getcGradePayId() {
		return cGradePayId;
	}

	/**
	 * @param cGradePayId the cGradePayId to set
	 */
	public void setcGradePayId(Long cGradePayId) {
		this.cGradePayId = cGradePayId;
	}

	/**
	 * @return the cBasicPay
	 */
	public Long getcBasicPay() {
		return cBasicPay;
	}

	/**
	 * @param cBasicPay the cBasicPay to set
	 */
	public void setcBasicPay(Long cBasicPay) {
		this.cBasicPay = cBasicPay;
	}

	/**
	 * @return the payCommId
	 */
	public Long getPayCommId() {
		return payCommId;
	}

	/**
	 * @param payCommId the payCommId to set
	 */
	public void setPayCommId(Long payCommId) {
		this.payCommId = payCommId;
	}

	/**
	 * @return the submit
	 */
	public boolean isSubmit() {
		return submit;
	}

	/**
	 * @param submit the submit to set
	 */
	public void setSubmit(boolean submit) {
		this.submit = submit;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the currentDetailsEventId
	 */
	public Long getCurrentDetailsEventId() {
		return currentDetailsEventId;
	}

	/**
	 * @param currentDetailsEventId the currentDetailsEventId to set
	 */
	public void setCurrentDetailsEventId(Long currentDetailsEventId) {
		this.currentDetailsEventId = currentDetailsEventId;
	}

	/**
	 * @return the approveDate
	 */
	public LocalDateTime getApproveDate() {
		return approveDate;
	}

	/**
	 * @param approveDate the approveDate to set
	 */
	public void setApproveDate(LocalDateTime approveDate) {
		this.approveDate = approveDate;
	}

	/**
	 * @return the authorizeDate
	 */
	public LocalDateTime getAuthorizeDate() {
		return authorizeDate;
	}

	/**
	 * @param authorizeDate the authorizeDate to set
	 */
	public void setAuthorizeDate(LocalDateTime authorizeDate) {
		this.authorizeDate = authorizeDate;
	}

	/**
	 * @return the isPrintAble
	 */
	public Long getIsPrintAble() {
		return isPrintAble;
	}

	/**
	 * @param isPrintAble the isPrintAble to set
	 */
	public void setIsPrintAble(Long isPrintAble) {
		this.isPrintAble = isPrintAble;
	}

	/**
	 * @return the auditorRemarks
	 */
	public String getAuditorRemarks() {
		return auditorRemarks;
	}

	/**
	 * @param auditorRemarks the auditorRemarks to set
	 */
	public void setAuditorRemarks(String auditorRemarks) {
		this.auditorRemarks = auditorRemarks;
	}

	/**
	 * @return the verifierRemarks
	 */
	public String getVerifierRemarks() {
		return verifierRemarks;
	}

	/**
	 * @param verifierRemarks the verifierRemarks to set
	 */
	public void setVerifierRemarks(String verifierRemarks) {
		this.verifierRemarks = verifierRemarks;
	}

	/**
	 * @return the classTwoRemarks
	 */
	public String getClassTwoRemarks() {
		return classTwoRemarks;
	}

	/**
	 * @param classTwoRemarks the classTwoRemarks to set
	 */
	public void setClassTwoRemarks(String classTwoRemarks) {
		this.classTwoRemarks = classTwoRemarks;
	}

	/**
	 * @return the classOneRemarks
	 */
	public String getClassOneRemarks() {
		return classOneRemarks;
	}

	/**
	 * @param classOneRemarks the classOneRemarks to set
	 */
	public void setClassOneRemarks(String classOneRemarks) {
		this.classOneRemarks = classOneRemarks;
	}

	/**
	 * @return the printRemarks
	 */
	public String getPrintRemarks() {
		return printRemarks;
	}

	/**
	 * @param printRemarks the printRemarks to set
	 */
	public void setPrintRemarks(String printRemarks) {
		this.printRemarks = printRemarks;
	}

	/**
	 * @return the verifierReturnReason
	 */
	public Long getVerifierReturnReason() {
		return verifierReturnReason;
	}

	/**
	 * @param verifierReturnReason the verifierReturnReason to set
	 */
	public void setVerifierReturnReason(Long verifierReturnReason) {
		this.verifierReturnReason = verifierReturnReason;
	}

	/**
	 * @return the classOneReturnReason
	 */
	public Long getClassOneReturnReason() {
		return classOneReturnReason;
	}

	/**
	 * @param classOneReturnReason the classOneReturnReason to set
	 */
	public void setClassOneReturnReason(Long classOneReturnReason) {
		this.classOneReturnReason = classOneReturnReason;
	}

	/**
	 * @return the auditorReturnReason
	 */
	public Long getAuditorReturnReason() {
		return auditorReturnReason;
	}

	/**
	 * @param auditorReturnReason the auditorReturnReason to set
	 */
	public void setAuditorReturnReason(Long auditorReturnReason) {
		this.auditorReturnReason = auditorReturnReason;
	}

	/**
	 * @return the classTwoReturnReason
	 */
	public Long getClassTwoReturnReason() {
		return classTwoReturnReason;
	}

	/**
	 * @param classTwoReturnReason the classTwoReturnReason to set
	 */
	public void setClassTwoReturnReason(Long classTwoReturnReason) {
		this.classTwoReturnReason = classTwoReturnReason;
	}

	/**
	 * @return the printCount
	 */
	public Long getPrintCount() {
		return printCount;
	}

	/**
	 * @param printCount the printCount to set
	 */
	public void setPrintCount(Long printCount) {
		this.printCount = printCount;
	}

	/**
	 * @return the initDate
	 */
	public LocalDateTime getInitDate() {
		return initDate;
	}

	/**
	 * @param initDate the initDate to set
	 */
	public void setInitDate(LocalDateTime initDate) {
		this.initDate = initDate;
	}

	/**
	 * @return the returnReasons
	 */
	public List<PVURopRemarksDto> getReturnReasons() {
		return returnReasons;
	}

	/**
	 * @param returnReasons the returnReasons to set
	 */
	public void setReturnReasons(List<PVURopRemarksDto> returnReasons) {
		this.returnReasons = returnReasons;
	}

	/**
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * @param printReturnReason the printReturnReason to set
	 */
	public void setPrintReturnReason(Long printReturnReason) {
		this.printReturnReason = printReturnReason;
	}

	/**
	 * @return the printReturnReason
	 */
	public Long getPrintReturnReason() {
		return printReturnReason;
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
	 * @return the authorizeBy
	 */
	public Long getAuthorizeBy() {
		return authorizeBy;
	}

	/**
	 * @param authorizeBy the authorizeBy to set
	 */
	public void setAuthorizeBy(Long authorizeBy) {
		this.authorizeBy = authorizeBy;
	}

	/**
	 * @return the authorizerRemark
	 */
	public String getAuthorizerRemark() {
		return authorizerRemark;
	}

	/**
	 * @param authorizerRemark the authorizerRemark to set
	 */
	public void setAuthorizerRemark(String authorizerRemark) {
		this.authorizerRemark = authorizerRemark;
	}

}
