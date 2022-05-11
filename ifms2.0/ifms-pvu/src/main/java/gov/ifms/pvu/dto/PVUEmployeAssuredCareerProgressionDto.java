package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUEmployeAssuredCareerProgressionDto.
 * 
 * @version v 1.0
 * @created 2020/01/11 13:52:57
 *
 */
public class PVUEmployeAssuredCareerProgressionDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The acp event id. */
	private long id;

	/** The trx no. */
	private String trnNo;

	private String eventCode = PvuConstant.EVENT_CODE_ACP;

	private long employeeNo;

	/** The office id. */
	private long officeId;

	/** The pay commission. */
	private long payCommId;

	/** The acp order no. */
	private String eventOrderNo;

	/** The event order date. */
	private String eventOrderDate;

	/** The event eff date. */
	private String eventEffectiveDate;

	/** The emp id. */
	private long employeeId;

	/** The dec reg prm. */
	private long decRegPrm;

	/** The pay level. */
	private long payLevelId;

	/** The cell id. */
	private long cellId;

	/** The basic pay. */
	private long basicPay;

	/** The ben eff date. */
	private String benEffDate;

	/** The status id. */
	private long statusId;

	private long type;

	private long acpType;

	private Long classId;

	private Long payScale;

	private Long payBandId;

	private Long payBandValue;

	private long gradePayId;

	private Long currentDetailsEventId;

	public Long getCurrentDetailsEventId() {
		return currentDetailsEventId;
	}

	public void setCurrentDetailsEventId(Long currentDetailsEventId) {
		this.currentDetailsEventId = currentDetailsEventId;
	}

	private Long cBasicPay;

	private String scaleName;

	private String verifierRemarks;

	private String classOneRemarks;

	private Date dateOfNextIncrement;
	private long verifierReturnReason;

	private long classOneReturnReason;

	private String officeName;

	private LocalDateTime refDate;

	private Date cDateOfNextIncrement;

	public Date getcDateOfNextIncrement() {
		return cDateOfNextIncrement;
	}

	public void setcDateOfNextIncrement(Date cDateOfNextIncrement) {
		this.cDateOfNextIncrement = cDateOfNextIncrement;
	}

	public LocalDateTime getRefDate() {
		return refDate;
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
	 * @return the verifierReturnReason
	 */
	public long getVerifierReturnReason() {
		return verifierReturnReason;
	}

	/**
	 * @param verifierReturnReason the verifierReturnReason to set
	 */
	public void setVerifierReturnReason(long verifierReturnReason) {
		this.verifierReturnReason = verifierReturnReason;
	}

	/**
	 * @return the classOneReturnReason
	 */
	public long getClassOneReturnReason() {
		return classOneReturnReason;
	}

	/**
	 * @param classOneReturnReason the classOneReturnReason to set
	 */
	public void setClassOneReturnReason(long classOneReturnReason) {
		this.classOneReturnReason = classOneReturnReason;
	}

	public Long getcBasicPay() {
		return cBasicPay;
	}

	public void setcBasicPay(Long cBasicPay) {
		this.cBasicPay = cBasicPay;
	}

	/** The return reasons. */
	private List<PVURopRemarksDto> returnReasons;

	/** The wf role id. */
	private long wfRoleId;

	private String remarks;
	private String auditorRemarks;
	private String classTwoRemarks;
	private String printRemarks;
	private Long auditorReturnReason;
	private long classTwoReturnReason;
	private String printReturnReason;
	private long printCount;

	private long cPayScaleId;

	private long cPayBandId;

	private long cPayBandValue;

	/** Pay Band Id */
	private String cPayBandIdValue;

	/** Grade Value */
	private String cGradePayIdValue;

	/** Scale Value */
	private String cPayScaleValue;

	private long cGradePayId;

	public long getcPayScaleId() {
		return cPayScaleId;
	}

	public void setcPayScaleId(long cPayScaleId) {
		this.cPayScaleId = cPayScaleId;
	}

	/**
	 * @return the cGradePayId
	 */
	public long getcGradePayId() {
		return cGradePayId;
	}

	/**
	 * @param cGradePayId the cGradePayId to set
	 */
	public void setcGradePayId(long cGradePayId) {
		this.cGradePayId = cGradePayId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the cPayBandId
	 */
	public long getcPayBandId() {
		return cPayBandId;
	}

	/**
	 * @param cPayBandId the cPayBandId to set
	 */
	public void setcPayBandId(long cPayBandId) {
		this.cPayBandId = cPayBandId;
	}

	/**
	 * @return the cPayBandValue
	 */
	public long getcPayBandValue() {
		return cPayBandValue;
	}

	/**
	 * @param cPayBandValue the cPayBandValue to set
	 */
	public void setcPayBandValue(long cPayBandValue) {
		this.cPayBandValue = cPayBandValue;
	}

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

	public Long getPayScale() {
		return payScale;
	}

	public void setPayScale(Long payScale) {
		this.payScale = payScale;
	}

	public Long getPayBandId() {
		return payBandId;
	}

	public void setPayBandId(Long payBandId) {
		this.payBandId = payBandId;
	}

	public Long getPayBandValue() {
		return payBandValue;
	}

	public void setPayBandValue(Long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * @return the gradePayId
	 */
	public long getGradePayId() {
		return gradePayId;
	}

	/**
	 * @param gradePayId the gradePayId to set
	 */
	public void setGradePayId(long gradePayId) {
		this.gradePayId = gradePayId;
	}

	/**
	 * @return the wfRoleId
	 */
	public long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(long wfRoleId) {
		this.wfRoleId = wfRoleId;
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

	public Long getAuditorReturnReason() {
		return auditorReturnReason;
	}

	public void setAuditorReturnReason(Long auditorReturnReason) {
		this.auditorReturnReason = auditorReturnReason;
	}

	/**
	 * @return the classTwoReturnReason
	 */
	public long getClassTwoReturnReason() {
		return classTwoReturnReason;
	}

	/**
	 * @param classTwoReturnReason the classTwoReturnReason to set
	 */
	public void setClassTwoReturnReason(long classTwoReturnReason) {
		this.classTwoReturnReason = classTwoReturnReason;
	}

	/**
	 * @return the printReturnReason
	 */
	public String getPrintReturnReason() {
		return printReturnReason;
	}

	/**
	 * @param printReturnReason the printReturnReason to set
	 */
	public void setPrintReturnReason(String printReturnReason) {
		this.printReturnReason = printReturnReason;
	}

	/**
	 * @return the printCount
	 */
	public long getPrintCount() {
		return printCount;
	}

	/**
	 * @param printCount the printCount to set
	 */
	public void setPrintCount(long printCount) {
		this.printCount = printCount;
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
	 * PVUEmployeAssuredCareerProgressionDto Constructor.
	 */
	public PVUEmployeAssuredCareerProgressionDto() {
		super();
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

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(long employeeNo) {
		this.employeeNo = employeeNo;
	}

	public long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(long officeId) {
		this.officeId = officeId;
	}

	public long getPayCommId() {
		return payCommId;
	}

	public void setPayCommId(long payCommId) {
		this.payCommId = payCommId;
	}

	/**
	 * @return the eventOrderDate
	 */
	public String getEventOrderDate() {
		return eventOrderDate;
	}

	/**
	 * @param eventOrderDate the eventOrderDate to set
	 */
	public void setEventOrderDate(String eventOrderDate) {
		this.eventOrderDate = eventOrderDate;
	}

	/**
	 * @return the eventEffectiveDate
	 */
	public String getEventEffectiveDate() {
		return eventEffectiveDate;
	}

	/**
	 * @param eventEffectiveDate the eventEffectiveDate to set
	 */
	public void setEventEffectiveDate(String eventEffectiveDate) {
		this.eventEffectiveDate = eventEffectiveDate;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public long getDecRegPrm() {
		return decRegPrm;
	}

	public void setDecRegPrm(long decRegPrm) {
		this.decRegPrm = decRegPrm;
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

	public long getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * @return the benEffDate
	 */
	public String getBenEffDate() {
		return benEffDate;
	}

	/**
	 * @param benEffDate the benEffDate to set
	 */
	public void setBenEffDate(String benEffDate) {
		this.benEffDate = benEffDate;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUEmployeAssuredCareerProgressionDto)) return false;
		if (!super.equals(o)) return false;
		PVUEmployeAssuredCareerProgressionDto that = (PVUEmployeAssuredCareerProgressionDto) o;
		return getId() == that.getId() &&
				getEmployeeNo() == that.getEmployeeNo() &&
				getOfficeId() == that.getOfficeId() &&
				getPayCommId() == that.getPayCommId() &&
				getEmployeeId() == that.getEmployeeId() &&
				getDecRegPrm() == that.getDecRegPrm() &&
				getPayLevelId() == that.getPayLevelId() &&
				getCellId() == that.getCellId() &&
				getBasicPay() == that.getBasicPay() &&
				getStatusId() == that.getStatusId() &&
				getType() == that.getType() &&
				getAcpType() == that.getAcpType() &&
				getGradePayId() == that.getGradePayId() &&
				getVerifierReturnReason() == that.getVerifierReturnReason() &&
				getClassOneReturnReason() == that.getClassOneReturnReason() &&
				getWfRoleId() == that.getWfRoleId() &&
				getClassTwoReturnReason() == that.getClassTwoReturnReason() &&
				getPrintCount() == that.getPrintCount() &&
				getcPayScaleId() == that.getcPayScaleId() &&
				getcPayBandId() == that.getcPayBandId() &&
				getcPayBandValue() == that.getcPayBandValue() &&
				getcGradePayId() == that.getcGradePayId() &&
				Objects.equals(getTrnNo(), that.getTrnNo()) &&
				Objects.equals(getEventCode(), that.getEventCode()) &&
				Objects.equals(getEventOrderNo(), that.getEventOrderNo()) &&
				Objects.equals(getEventOrderDate(), that.getEventOrderDate()) &&
				Objects.equals(getEventEffectiveDate(), that.getEventEffectiveDate()) &&
				Objects.equals(getBenEffDate(), that.getBenEffDate()) &&
				Objects.equals(getClassId(), that.getClassId()) &&
				Objects.equals(getPayScale(), that.getPayScale()) &&
				Objects.equals(getPayBandId(), that.getPayBandId()) &&
				Objects.equals(getPayBandValue(), that.getPayBandValue()) &&
				Objects.equals(getCurrentDetailsEventId(), that.getCurrentDetailsEventId()) &&
				Objects.equals(getcBasicPay(), that.getcBasicPay()) &&
				Objects.equals(getScaleName(), that.getScaleName()) &&
				Objects.equals(getVerifierRemarks(), that.getVerifierRemarks()) &&
				Objects.equals(getClassOneRemarks(), that.getClassOneRemarks()) &&
				Objects.equals(getDateOfNextIncrement(), that.getDateOfNextIncrement()) &&
				Objects.equals(getOfficeName(), that.getOfficeName()) &&
				Objects.equals(getRefDate(), that.getRefDate()) &&
				Objects.equals(getcDateOfNextIncrement(), that.getcDateOfNextIncrement()) &&
				Objects.equals(getReturnReasons(), that.getReturnReasons()) &&
				Objects.equals(getRemarks(), that.getRemarks()) &&
				Objects.equals(getAuditorRemarks(), that.getAuditorRemarks()) &&
				Objects.equals(getClassTwoRemarks(), that.getClassTwoRemarks()) &&
				Objects.equals(getPrintRemarks(), that.getPrintRemarks()) &&
				Objects.equals(getAuditorReturnReason(), that.getAuditorReturnReason()) &&
				Objects.equals(getPrintReturnReason(), that.getPrintReturnReason()) &&
				Objects.equals(getcPayBandIdValue(), that.getcPayBandIdValue()) &&
				Objects.equals(getcGradePayIdValue(), that.getcGradePayIdValue()) &&
				Objects.equals(getcPayScaleValue(), that.getcPayScaleValue()) &&
				Objects.equals(getPayBandName(), that.getPayBandName()) &&
				Objects.equals(getGradePayName(), that.getGradePayName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId(), getTrnNo(), getEventCode(), getEmployeeNo(), getOfficeId(), getPayCommId(), getEventOrderNo(), getEventOrderDate(), getEventEffectiveDate(), getEmployeeId(), getDecRegPrm(), getPayLevelId(), getCellId(), getBasicPay(), getBenEffDate(), getStatusId(), getType(), getAcpType(), getClassId(), getPayScale(), getPayBandId(), getPayBandValue(), getGradePayId(), getCurrentDetailsEventId(), getcBasicPay(), getScaleName(), getVerifierRemarks(), getClassOneRemarks(), getDateOfNextIncrement(), getVerifierReturnReason(), getClassOneReturnReason(), getOfficeName(), getRefDate(), getcDateOfNextIncrement(), getReturnReasons(), getWfRoleId(), getRemarks(), getAuditorRemarks(), getClassTwoRemarks(), getPrintRemarks(), getAuditorReturnReason(), getClassTwoReturnReason(), getPrintReturnReason(), getPrintCount(), getcPayScaleId(), getcPayBandId(), getcPayBandValue(), getcPayBandIdValue(), getcGradePayIdValue(), getcPayScaleValue(), getcGradePayId(), getPayBandName(), getGradePayName());
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
	 * @return the type
	 */
	public long getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(long type) {
		this.type = type;
	}

	/**
	 * @return the acpType
	 */
	public long getAcpType() {
		return acpType;
	}

	/**
	 * @param acpType the acpType to set
	 */
	public void setAcpType(long acpType) {
		this.acpType = acpType;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	private String payBandName;

	public String getPayBandName() {
		return payBandName;
	}

	public void setPayBandName(String payBandName) {
		this.payBandName = payBandName;
	}

	private String gradePayName;

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

	public Date getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	public void setDateOfNextIncrement(Date dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

}
