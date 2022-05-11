package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import gov.ifms.pvu.common.PVUCurrentDto;
import gov.ifms.pvu.util.PvuConstant;


/**
 * The Class PVUEmployeHigherPayScaleEventDto.
 *
 * @version v 1.0
 * @created 2020/01/07 16:13:21
 *
 */
public class PVUEmployeHigherPayScaleEventDto extends PVUCurrentDto implements Serializable  {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The higher scale event id. */
	private long id;

	/** The trx no. */
	private String trnNo;

	/** The event code. */
	private String eventCode = PvuConstant.EVENT_CODE_HP;

	/** The office id. */
	private long officeId;

	/**
	 * Gets the event id.
	 *
	 * @return the event id
	 */
	public long getEventId() {
		return eventId;
	}

	/**
	 * Sets the event id.
	 *
	 * @param eventId the new event id
	 */
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	/** The pay commision. */
	private long payCommId;
	/**
	 * The eventId.
	 */
	private long eventId;
	/** The event order no. */
	private String eventOrderNo;

	/** The event order DATE. */
	private LocalDate eventOrderDate;

	/** The event eff date. */
	private LocalDate eventEffectiveDate;

	/** The status id. */
	private long statusId;

	/** The hp scale for. */
	private long hpScaleFor;

	/** The hp scale for name. */
	private String hpScaleForName;

	/**
	 * Gets the hp scale for name.
	 *
	 * @return the hp scale for name
	 */
	public String getHpScaleForName() {
		return hpScaleForName;
	}

	/**
	 * Sets the hp scale for name.
	 *
	 * @param hpScaleForName the new hp scale for name
	 */
	public void setHpScaleForName(String hpScaleForName) {
		this.hpScaleForName = hpScaleForName;
	}

	/**
	 * Gets the hp scale type name.
	 *
	 * @return the hp scale type name
	 */
	public String getHpScaleTypeName() {
		return hpScaleTypeName;
	}

	/**
	 * Sets the hp scale type name.
	 *
	 * @param hpScaleTypeName the new hp scale type name
	 */
	public void setHpScaleTypeName(String hpScaleTypeName) {
		this.hpScaleTypeName = hpScaleTypeName;
	}

	/**
	 * Gets the hp type name.
	 *
	 * @return the hp type name
	 */
	public String getHpTypeName() {
		return hpTypeName;
	}

	/**
	 * Sets the hp type name.
	 *
	 * @param hpTypeName the new hp type name
	 */
	public void setHpTypeName(String hpTypeName) {
		this.hpTypeName = hpTypeName;
	}

	/**
	 * Gets the hp emp type name.
	 *
	 * @return the hp emp type name
	 */
	public String getHpEmpTypeName() {
		return hpEmpTypeName;
	}

	/**
	 * Sets the hp emp type name.
	 *
	 * @param hpEmpTypeName the new hp emp type name
	 */
	public void setHpEmpTypeName(String hpEmpTypeName) {
		this.hpEmpTypeName = hpEmpTypeName;
	}

	/**
	 * Gets the option available name.
	 *
	 * @return the option available name
	 */
	public String getOptionAvailableName() {
		return optionAvailableName;
	}

	/**
	 * Sets the option available name.
	 *
	 * @param optionAvailableName the new option available name
	 */
	public void setOptionAvailableName(String optionAvailableName) {
		this.optionAvailableName = optionAvailableName;
	}

	/** The hp scale type. */
	private long hpScaleType;

	/** The hp scale type name. */
	private String hpScaleTypeName;

	/** The hp type. */
	private long hpType;

	/** The hp type name. */
	private String hpTypeName;

	/** The hp emp type. */
	private long hpEmpType;

	/** The hp emp type name. */
	private String hpEmpTypeName;

	/** The opt avail. */
	private long optionAvailableId;

	/** The option available name. */
	private String optionAvailableName;

	/** The opt avail date. */
	private LocalDate optionAvailableDate;

	/** The pay level. */
	private long payLevelId;

	/** The cell id. */
	private long cellId;

	/** The payband. */
	private long payBandId;

	/** The pay band value. */
	private long payBandValue;

	/** The grade pay. */
	private long gradePayId;

	/** The basic pay. */
	private long basicPay;

	/** The hg eff date. */
	private LocalDate hgEffDate;

	/** The next incr date. */
	private LocalDate dateOfNextIncrement;

	/** The remarks. */
	private String remarks;

	/** The emp id. */
	private long employeeId;

	/** The pay scale. */
	private long payScale;

	/** The employee no. */
	private Long employeeNo;

	/** The auditor remarks. */
	private String auditorRemarks;

	/** The verifier remarks. */
	private String verifierRemarks;

	/** The class two remarks. */
	private String classTwoRemarks;

	/** The class one remarks. */
	private String classOneRemarks;

	/** The print remarks. */
	private String printRemarks;

	/** The auditor return reason. */
	private Long auditorReturnReason;

	/** The verifier return reason. */
	private Long verifierReturnReason;

	/** The class two return reason. */
	private Long classTwoReturnReason;

	/** The class one return reason. */
	private Long classOneReturnReason;

	/** The print return reason. */
	private Long printReturnReason;

	/** The print count. */
	private Long printCount;

	/** The ref date. */
	private LocalDateTime refDate;

	private Long oaBasicPayValue;

	private Long oaPayScaleId;

	private Long oaPayBandId;

	private Long oaPayBandValue;

	private Long oaGradePayId;

	private Long oaPayLevelId;

	private Long oaCellIdValue;

	private Long oaPayCellId;

	public Long getOaBasicPayValue() {
		return oaBasicPayValue;
	}

	public void setOaBasicPayValue(Long oaBasicPayValue) {
		this.oaBasicPayValue = oaBasicPayValue;
	}

	public Long getOaPayScaleId() {
		return oaPayScaleId;
	}

	public void setOaPayScaleId(Long oaPayScaleId) {
		this.oaPayScaleId = oaPayScaleId;
	}

	public Long getOaPayBandId() {
		return oaPayBandId;
	}

	public void setOaPayBandId(Long oaPayBandId) {
		this.oaPayBandId = oaPayBandId;
	}

	public Long getOaPayBandValue() {
		return oaPayBandValue;
	}

	public void setOaPayBandValue(Long oaPayBandValue) {
		this.oaPayBandValue = oaPayBandValue;
	}

	public Long getOaGradePayId() {
		return oaGradePayId;
	}

	public void setOaGradePayId(Long oaGradePayId) {
		this.oaGradePayId = oaGradePayId;
	}

	public Long getOaPayLevelId() {
		return oaPayLevelId;
	}

	public void setOaPayLevelId(Long oaPayLevelId) {
		this.oaPayLevelId = oaPayLevelId;
	}

	public Long getOaCellIdValue() {
		return oaCellIdValue;
	}

	public void setOaCellIdValue(Long oaCellIdValue) {
		this.oaCellIdValue = oaCellIdValue;
	}

	public Long getOaPayCellId() {
		return oaPayCellId;
	}

	public void setOaPayCellId(Long oaPayCellId) {
		this.oaPayCellId = oaPayCellId;
	}

	/**
	 * Gets the auditor remarks.
	 *
	 * @return the auditor remarks
	 */
	public String getAuditorRemarks() {
		return auditorRemarks;
	}

	/**
	 * Sets the auditor remarks.
	 *
	 * @param auditorRemarks the new auditor remarks
	 */
	public void setAuditorRemarks(String auditorRemarks) {
		this.auditorRemarks = auditorRemarks;
	}

	/**
	 * Gets the verifier remarks.
	 *
	 * @return the verifier remarks
	 */
	public String getVerifierRemarks() {
		return verifierRemarks;
	}

	/**
	 * Sets the verifier remarks.
	 *
	 * @param verifierRemarks the new verifier remarks
	 */
	public void setVerifierRemarks(String verifierRemarks) {
		this.verifierRemarks = verifierRemarks;
	}

	/**
	 * Gets the class two remarks.
	 *
	 * @return the class two remarks
	 */
	public String getClassTwoRemarks() {
		return classTwoRemarks;
	}

	/**
	 * Sets the class two remarks.
	 *
	 * @param classTwoRemarks the new class two remarks
	 */
	public void setClassTwoRemarks(String classTwoRemarks) {
		this.classTwoRemarks = classTwoRemarks;
	}

	/**
	 * Gets the class one remarks.
	 *
	 * @return the class one remarks
	 */
	public String getClassOneRemarks() {
		return classOneRemarks;
	}

	/**
	 * Sets the class one remarks.
	 *
	 * @param classOneRemarks the new class one remarks
	 */
	public void setClassOneRemarks(String classOneRemarks) {
		this.classOneRemarks = classOneRemarks;
	}

	/**
	 * Gets the prints the remarks.
	 *
	 * @return the prints the remarks
	 */
	public String getPrintRemarks() {
		return printRemarks;
	}

	/**
	 * Sets the prints the remarks.
	 *
	 * @param printRemarks the new prints the remarks
	 */
	public void setPrintRemarks(String printRemarks) {
		this.printRemarks = printRemarks;
	}

	/**
	 * Gets the auditor return reason.
	 *
	 * @return the auditor return reason
	 */
	public Long getAuditorReturnReason() {
		return auditorReturnReason;
	}

	/**
	 * Sets the auditor return reason.
	 *
	 * @param auditorReturnReason the new auditor return reason
	 */
	public void setAuditorReturnReason(Long auditorReturnReason) {
		this.auditorReturnReason = auditorReturnReason;
	}

	/**
	 * Gets the verifier return reason.
	 *
	 * @return the verifier return reason
	 */
	public Long getVerifierReturnReason() {
		return verifierReturnReason;
	}

	/**
	 * Sets the verifier return reason.
	 *
	 * @param verifierReturnReason the new verifier return reason
	 */
	public void setVerifierReturnReason(Long verifierReturnReason) {
		this.verifierReturnReason = verifierReturnReason;
	}

	/**
	 * Gets the class two return reason.
	 *
	 * @return the class two return reason
	 */
	public Long getClassTwoReturnReason() {
		return classTwoReturnReason;
	}

	/**
	 * Sets the class two return reason.
	 *
	 * @param classTwoReturnReason the new class two return reason
	 */
	public void setClassTwoReturnReason(Long classTwoReturnReason) {
		this.classTwoReturnReason = classTwoReturnReason;
	}

	/**
	 * Gets the class one return reason.
	 *
	 * @return the class one return reason
	 */
	public Long getClassOneReturnReason() {
		return classOneReturnReason;
	}

	/**
	 * Sets the class one return reason.
	 *
	 * @param classOneReturnReason the new class one return reason
	 */
	public void setClassOneReturnReason(Long classOneReturnReason) {
		this.classOneReturnReason = classOneReturnReason;
	}

	/**
	 * Gets the prints the return reason.
	 *
	 * @return the prints the return reason
	 */
	public Long getPrintReturnReason() {
		return printReturnReason;
	}

	/**
	 * Sets the prints the return reason.
	 *
	 * @param printReturnReason the new prints the return reason
	 */
	public void setPrintReturnReason(Long printReturnReason) {
		this.printReturnReason = printReturnReason;
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
	 * Gets the ref date.
	 *
	 * @return the ref date
	 */
	public LocalDateTime getRefDate() {
		return refDate;
	}

	/**
	 * Sets the ref date.
	 *
	 * @param refDate the new ref date
	 */
	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	/**
	 * Gets the pay level name.
	 *
	 * @return the pay level name
	 */
	public String getPayLevelName() {
		return payLevelName;
	}

	/**
	 * Sets the pay level name.
	 *
	 * @param payLevelName the new pay level name
	 */
	public void setPayLevelName(String payLevelName) {
		this.payLevelName = payLevelName;
	}

	/**
	 * Gets the cell name.
	 *
	 * @return the cell name
	 */
	public String getCellName() {
		return cellName;
	}

	/**
	 * Sets the cell name.
	 *
	 * @param cellName the new cell name
	 */
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}

	/**
	 * Gets the pay band name.
	 *
	 * @return the pay band name
	 */
	public String getPayBandName() {
		return payBandName;
	}

	/**
	 * Sets the pay band name.
	 *
	 * @param payBandName the new pay band name
	 */
	public void setPayBandName(String payBandName) {
		this.payBandName = payBandName;
	}

	/**
	 * Gets the grade pay name.
	 *
	 * @return the grade pay name
	 */
	public String getGradePayName() {
		return gradePayName;
	}

	/**
	 * Sets the grade pay name.
	 *
	 * @param gradePayName the new grade pay name
	 */
	public void setGradePayName(String gradePayName) {
		this.gradePayName = gradePayName;
	}

	/**
	 * Gets the scale name.
	 *
	 * @return the scale name
	 */
	public String getScaleName() {
		return scaleName;
	}

	/**
	 * Sets the scale name.
	 *
	 * @param scaleName the new scale name
	 */
	public void setScaleName(String scaleName) {
		this.scaleName = scaleName;
	}

	/** The pay level name. */
	private String payLevelName;

	/** The cell name. */
	private String cellName;

	/** The pay band name. */
	private String payBandName;

	/**
	 * Gets the office name.
	 *
	 * @return the office name
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the new office name
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/** The grade pay name. */
	private String gradePayName;

	/** The scale name. */
	private String scaleName;

	/** The office name. */
	private String officeName;


	/**
	 * PVUEmployeHigherPayScaleEventDto Constructor.
	 */
	public PVUEmployeHigherPayScaleEventDto() {
		super();
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
	 * @param id the new id
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
	 * Gets the hp scale for.
	 *
	 * @return the hpScaleFor
	 */
	public long getHpScaleFor() {
		return hpScaleFor;
	}

	/**
	 * Sets the hp scale for.
	 *
	 * @param hpScaleFor the hpScaleFor to set
	 */
	public void setHpScaleFor(long hpScaleFor) {
		this.hpScaleFor = hpScaleFor;
	}

	/**
	 * Gets the hp scale type.
	 *
	 * @return the hpScaleType
	 */
	public long getHpScaleType() {
		return hpScaleType;
	}

	/**
	 * Sets the hp scale type.
	 *
	 * @param hpScaleType the hpScaleType to set
	 */
	public void setHpScaleType(long hpScaleType) {
		this.hpScaleType = hpScaleType;
	}

	/**
	 * Gets the hp type.
	 *
	 * @return the hpType
	 */
	public long getHpType() {
		return hpType;
	}

	/**
	 * Sets the hp type.
	 *
	 * @param hpType the hpType to set
	 */
	public void setHpType(long hpType) {
		this.hpType = hpType;
	}

	/**
	 * Gets the hp emp type.
	 *
	 * @return the hpEmpType
	 */
	public long getHpEmpType() {
		return hpEmpType;
	}

	/**
	 * Sets the hp emp type.
	 *
	 * @param hpEmpType the hpEmpType to set
	 */
	public void setHpEmpType(long hpEmpType) {
		this.hpEmpType = hpEmpType;
	}

	/**
	 * Gets the option available id.
	 *
	 * @return the optionAvailableId
	 */
	public long getOptionAvailableId() {
		return optionAvailableId;
	}

	/**
	 * Sets the option available id.
	 *
	 * @param optionAvailableId the optionAvailableId to set
	 */
	public void setOptionAvailableId(long optionAvailableId) {
		this.optionAvailableId = optionAvailableId;
	}

	/**
	 * Gets the pay level id.
	 *
	 * @return the payLevelId
	 */
	public long getPayLevelId() {
		return payLevelId;
	}

	/**
	 * Sets the pay level id.
	 *
	 * @param payLevelId the payLevelId to set
	 */
	public void setPayLevelId(long payLevelId) {
		this.payLevelId = payLevelId;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cellId
	 */
	public long getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the cellId to set
	 */
	public void setCellId(long cellId) {
		this.cellId = cellId;
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
	 * Gets the pay band value.
	 *
	 * @return the payBandValue
	 */
	public long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(long payBandValue) {
		this.payBandValue = payBandValue;
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
	 * Gets the event order date.
	 *
	 * @return the event order date
	 */
	public LocalDate getEventOrderDate() {
		return eventOrderDate;
	}

	/**
	 * Sets the event order date.
	 *
	 * @param eventOrderDate the new event order date
	 */
	public void setEventOrderDate(LocalDate eventOrderDate) {
		this.eventOrderDate = eventOrderDate;
	}

	/**
	 * Gets the event effective date.
	 *
	 * @return the event effective date
	 */
	public LocalDate getEventEffectiveDate() {
		return eventEffectiveDate;
	}

	/**
	 * Sets the event effective date.
	 *
	 * @param eventEffectiveDate the new event effective date
	 */
	public void setEventEffectiveDate(LocalDate eventEffectiveDate) {
		this.eventEffectiveDate = eventEffectiveDate;
	}

	/**
	 * Gets the option available date.
	 *
	 * @return the option available date
	 */
	public LocalDate getOptionAvailableDate() {
		return optionAvailableDate;
	}

	/**
	 * Sets the option available date.
	 *
	 * @param optionAvailableDate the new option available date
	 */
	public void setOptionAvailableDate(LocalDate optionAvailableDate) {
		this.optionAvailableDate = optionAvailableDate;
	}

	/**
	 * Gets the hg eff date.
	 *
	 * @return the hg eff date
	 */
	public LocalDate getHgEffDate() {
		return hgEffDate;
	}

	/**
	 * Sets the hg eff date.
	 *
	 * @param hgEffDate the new hg eff date
	 */
	public void setHgEffDate(LocalDate hgEffDate) {
		this.hgEffDate = hgEffDate;
	}

	/**
	 * Gets the date of next increment.
	 *
	 * @return the date of next increment
	 */
	public LocalDate getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * Sets the date of next increment.
	 *
	 * @param dateOfNextIncrement the new date of next increment
	 */
	public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		PVUEmployeHigherPayScaleEventDto that = (PVUEmployeHigherPayScaleEventDto) o;
		return id == that.id &&
				officeId == that.officeId &&
				payCommId == that.payCommId &&
				eventId == that.eventId &&
				statusId == that.statusId &&
				hpScaleFor == that.hpScaleFor &&
				hpScaleType == that.hpScaleType &&
				hpType == that.hpType &&
				hpEmpType == that.hpEmpType &&
				optionAvailableId == that.optionAvailableId &&
				payLevelId == that.payLevelId &&
				cellId == that.cellId &&
				payBandId == that.payBandId &&
				payBandValue == that.payBandValue &&
				gradePayId == that.gradePayId &&
				basicPay == that.basicPay &&
				employeeId == that.employeeId &&
				payScale == that.payScale &&
				Objects.equals(trnNo, that.trnNo) &&
				Objects.equals(eventCode, that.eventCode) &&
				Objects.equals(eventOrderNo, that.eventOrderNo) &&
				Objects.equals(eventOrderDate, that.eventOrderDate) &&
				Objects.equals(eventEffectiveDate, that.eventEffectiveDate) &&
				Objects.equals(hpScaleForName, that.hpScaleForName) &&
				Objects.equals(hpScaleTypeName, that.hpScaleTypeName) &&
				Objects.equals(hpTypeName, that.hpTypeName) &&
				Objects.equals(hpEmpTypeName, that.hpEmpTypeName) &&
				Objects.equals(optionAvailableName, that.optionAvailableName) &&
				Objects.equals(optionAvailableDate, that.optionAvailableDate) &&
				Objects.equals(hgEffDate, that.hgEffDate) &&
				Objects.equals(dateOfNextIncrement, that.dateOfNextIncrement) &&
				Objects.equals(remarks, that.remarks) &&
				Objects.equals(employeeNo, that.employeeNo) &&
				Objects.equals(auditorRemarks, that.auditorRemarks) &&
				Objects.equals(verifierRemarks, that.verifierRemarks) &&
				Objects.equals(classTwoRemarks, that.classTwoRemarks) &&
				Objects.equals(classOneRemarks, that.classOneRemarks) &&
				Objects.equals(printRemarks, that.printRemarks) &&
				Objects.equals(auditorReturnReason, that.auditorReturnReason) &&
				Objects.equals(verifierReturnReason, that.verifierReturnReason) &&
				Objects.equals(classTwoReturnReason, that.classTwoReturnReason) &&
				Objects.equals(classOneReturnReason, that.classOneReturnReason) &&
				Objects.equals(printReturnReason, that.printReturnReason) &&
				Objects.equals(printCount, that.printCount) &&
				Objects.equals(refDate, that.refDate) &&
				Objects.equals(oaBasicPayValue, that.oaBasicPayValue) &&
				Objects.equals(oaPayScaleId, that.oaPayScaleId) &&
				Objects.equals(oaPayBandId, that.oaPayBandId) &&
				Objects.equals(oaPayBandValue, that.oaPayBandValue) &&
				Objects.equals(oaGradePayId, that.oaGradePayId) &&
				Objects.equals(oaPayLevelId, that.oaPayLevelId) &&
				Objects.equals(oaCellIdValue, that.oaCellIdValue) &&
				Objects.equals(oaPayCellId, that.oaPayCellId) &&
				Objects.equals(payLevelName, that.payLevelName) &&
				Objects.equals(cellName, that.cellName) &&
				Objects.equals(payBandName, that.payBandName) &&
				Objects.equals(gradePayName, that.gradePayName) &&
				Objects.equals(scaleName, that.scaleName) &&
				Objects.equals(officeName, that.officeName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), id, trnNo, eventCode, officeId, payCommId, eventId, eventOrderNo, eventOrderDate, eventEffectiveDate, statusId, hpScaleFor, hpScaleForName, hpScaleType, hpScaleTypeName, hpType, hpTypeName, hpEmpType, hpEmpTypeName, optionAvailableId, optionAvailableName, optionAvailableDate, payLevelId, cellId, payBandId, payBandValue, gradePayId, basicPay, hgEffDate, dateOfNextIncrement, remarks, employeeId, payScale, employeeNo, auditorRemarks, verifierRemarks, classTwoRemarks, classOneRemarks, printRemarks, auditorReturnReason, verifierReturnReason, classTwoReturnReason, classOneReturnReason, printReturnReason, printCount, refDate, oaBasicPayValue, oaPayScaleId, oaPayBandId, oaPayBandValue, oaGradePayId, oaPayLevelId, oaCellIdValue, oaPayCellId, payLevelName, cellName, payBandName, gradePayName, scaleName, officeName);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PVUEmployeHigherPayScaleEventDto{");
		sb.append("id=").append(id);
		sb.append(", trnNo='").append(trnNo).append('\'');
		sb.append(", eventCode='").append(eventCode).append('\'');
		sb.append(", officeId=").append(officeId);
		sb.append(", payCommId=").append(payCommId);
		sb.append(", eventId=").append(eventId);
		sb.append(", eventOrderNo='").append(eventOrderNo).append('\'');
		sb.append(", eventOrderDate=").append(eventOrderDate);
		sb.append(", eventEffectiveDate=").append(eventEffectiveDate);
		sb.append(", statusId=").append(statusId);
		sb.append(", hpScaleFor=").append(hpScaleFor);
		sb.append(", hpScaleForName='").append(hpScaleForName).append('\'');
		sb.append(", hpScaleType=").append(hpScaleType);
		sb.append(", hpScaleTypeName='").append(hpScaleTypeName).append('\'');
		sb.append(", hpType=").append(hpType);
		sb.append(", hpTypeName='").append(hpTypeName).append('\'');
		sb.append(", hpEmpType=").append(hpEmpType);
		sb.append(", hpEmpTypeName='").append(hpEmpTypeName).append('\'');
		sb.append(", optionAvailableId=").append(optionAvailableId);
		sb.append(", optionAvailableName='").append(optionAvailableName).append('\'');
		sb.append(", optionAvailableDate=").append(optionAvailableDate);
		sb.append(", payLevelId=").append(payLevelId);
		sb.append(", cellId=").append(cellId);
		sb.append(", payBandId=").append(payBandId);
		sb.append(", payBandValue=").append(payBandValue);
		sb.append(", gradePayId=").append(gradePayId);
		sb.append(", basicPay=").append(basicPay);
		sb.append(", hgEffDate=").append(hgEffDate);
		sb.append(", dateOfNextIncrement=").append(dateOfNextIncrement);
		sb.append(", remarks='").append(remarks).append('\'');
		sb.append(", employeeId=").append(employeeId);
		sb.append(", payScale=").append(payScale);
		sb.append(", employeeNo=").append(employeeNo);
		sb.append(", auditorRemarks='").append(auditorRemarks).append('\'');
		sb.append(", verifierRemarks='").append(verifierRemarks).append('\'');
		sb.append(", classTwoRemarks='").append(classTwoRemarks).append('\'');
		sb.append(", classOneRemarks='").append(classOneRemarks).append('\'');
		sb.append(", printRemarks='").append(printRemarks).append('\'');
		sb.append(", auditorReturnReason=").append(auditorReturnReason);
		sb.append(", verifierReturnReason=").append(verifierReturnReason);
		sb.append(", classTwoReturnReason=").append(classTwoReturnReason);
		sb.append(", classOneReturnReason=").append(classOneReturnReason);
		sb.append(", printReturnReason=").append(printReturnReason);
		sb.append(", printCount=").append(printCount);
		sb.append(", refDate=").append(refDate);
		sb.append(", oaBasicPayValue=").append(oaBasicPayValue);
		sb.append(", oaPayScaleId=").append(oaPayScaleId);
		sb.append(", oaPayBandId=").append(oaPayBandId);
		sb.append(", oaPayBandValue=").append(oaPayBandValue);
		sb.append(", oaGradePayId=").append(oaGradePayId);
		sb.append(", oaPayLevelId=").append(oaPayLevelId);
		sb.append(", oaCellIdValue=").append(oaCellIdValue);
		sb.append(", oaPayCellId=").append(oaPayCellId);
		sb.append(", payLevelName='").append(payLevelName).append('\'');
		sb.append(", cellName='").append(cellName).append('\'');
		sb.append(", payBandName='").append(payBandName).append('\'');
		sb.append(", gradePayName='").append(gradePayName).append('\'');
		sb.append(", scaleName='").append(scaleName).append('\'');
		sb.append(", officeName='").append(officeName).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
