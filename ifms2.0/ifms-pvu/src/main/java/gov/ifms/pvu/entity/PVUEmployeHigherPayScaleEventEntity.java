package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;

/**
 * The Class PVUEmployeHigherPayScaleEventEntity.
 *
 * @version v 1.0
 * @created 2020/01/07 16:13:21
 *
 */
@Entity
@Table(name = "T_PVU_HP_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUEmployeHigherPayScaleEventEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The higher scale event id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_HP_EVNT_ID")
	private long id;

	/**
	 * Gets the serial version UID.
	 *
	 * @return the serial version UID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/** The trx no. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The office id. */
	@OneToOne(optional = false)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity office;

	/** The pay commision. */
	@OneToOne(optional = false)
	@JoinColumn(name = "PAY_COMM", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payComm;

	/** The event order no. */
	@Column(name = "EVNT_ORDER_NO")
	private String eventOrderNo;

	/** The approve date. */
	@Column(name = "APPR_DATE")
	private LocalDateTime approveDate;

	/** The authorize date. */
	@Column(name = "AUTH_DATE")
	private LocalDateTime authorizeDate;
	/** The is print able. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IS_PRINTABLE")
	private EDPLuLookUpInfoEntity isPrintAble;

	/** The auditor remarks. */
	@Column(name = "AUDITOR_REMARKS")
	private String auditorRemarks;

	/** The verifier remarks. */
	@Column(name = "VERIFIER_REMARKS")
	private String verifierRemarks;

	/** The class two remarks. */
	@Column(name = "CLASS_TWO_REMARKS")
	private String classTwoRemarks;

	/** The class one remarks. */
	@Column(name = "CLASS_ONE_REMARKS")
	private String classOneRemarks;

	/** The print remarks. */
	@Column(name = "PRINT_REMARKS")
	private String printRemarks;

	/** The auditor return reason. */
	@Column(name = "AUDITOR_RETURN_REASON")
	private Long auditorReturnReason;

	/** The verifier return reason. */
	@Column(name = "VERIFIER_RETURN_REASON")
	private Long verifierReturnReason;

	/** The class two return reason. */
	@Column(name = "CLASS_TWO_RETURN_REASON")
	private Long classTwoReturnReason;

	/** The class one return reason. */
	@Column(name = "CLASS_ONE_RETURN_REASON")
	private Long classOneReturnReason;

	/** The print return reason. */
	@Column(name = "PRINT_RETURN_REASON")
	private Long printReturnReason;

	/** The print count. */
	@Column(name = "PRINT_COUNT")
	private Long printCount;

	/** The init date. */
	@Column(name = "REF_DATE")
	private LocalDateTime refDate;

	@Column(name = "OA_EMP_BASIC_PAY")
	private Long oaBasicPayValue;

	@Column(name = "OA_PAY_SCALE")
	private Long oaPayScaleId;

	@Column(name = "OA_EMP_PAY_BAND")
	private Long oaPayBandId;

	@Column(name = "OA_PAY_BAND_VALUE")
	private Long oaPayBandValue;

	@Column(name = "OA_EMP_GRD_PAY")
	private Long oaGradePayId;

	@Column(name = "OA_EMP_PAY_LEVEL")
	private Long oaPayLevelId;

	@Column(name = "OA_CELL_ID")
	private Long oaCellIdValue;

	@Column(name = "OA_PAY_CELL_ID")
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

	public Long getAuthorizeBy() {
		return authorizeBy;
	}

	public void setAuthorizeBy(Long authorizeBy) {
		this.authorizeBy = authorizeBy;
	}

	public String getAuthorizerRemark() {
		return authorizerRemark;
	}

	public void setAuthorizerRemark(String authorizerRemark) {
		this.authorizerRemark = authorizerRemark;
	}

	@Column(name = "AUTHORIZE_BY")
	private Long authorizeBy;

	/** The init date. */
	@Column(name = "AUTHORIZER_REMARK")
	private String authorizerRemark;

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



	public Long getPrintCount() {
		return printCount;
	}

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
	 * Instantiates a new PVU employe higher pay scale event entity.
	 *
	 * @param id the id
	 */
	public PVUEmployeHigherPayScaleEventEntity(Long id) {
		this.id = id;
	}

	/**
	 * Instantiates a new PVU employe higher pay scale event entity.
	 */
	public PVUEmployeHigherPayScaleEventEntity() {
	}

	/**
	 * Gets the approve date.
	 *
	 * @return the approve date
	 */
	public LocalDateTime getApproveDate() {
		return approveDate;
	}

	/**
	 * Sets the approve date.
	 *
	 * @param approveDate the new approve date
	 */
	public void setApproveDate(LocalDateTime approveDate) {
		this.approveDate = approveDate;
	}

	/**
	 * Gets the authorize date.
	 *
	 * @return the authorize date
	 */
	public LocalDateTime getAuthorizeDate() {
		return authorizeDate;
	}

	/**
	 * Sets the authorize date.
	 *
	 * @param authorizeDate the new authorize date
	 */
	public void setAuthorizeDate(LocalDateTime authorizeDate) {
		this.authorizeDate = authorizeDate;
	}

	/**
	 * Gets the checks if is print able.
	 *
	 * @return the checks if is print able
	 */
	public EDPLuLookUpInfoEntity getIsPrintAble() {
		return isPrintAble;
	}

	/**
	 * Sets the checks if is print able.
	 *
	 * @param isPrintAble the new checks if is print able
	 */
	public void setIsPrintAble(EDPLuLookUpInfoEntity isPrintAble) {
		this.isPrintAble = isPrintAble;
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

	/** The event order date 1. */
	@Column(name = "EVNT_ORDER_DATE")
	private LocalDate eventOrderDate;

	/**
	 * Gets the current details event id.
	 *
	 * @return the current details event id
	 */
	public Long getCurrentDetailsEventId() {
		return currentDetailsEventId;
	}

	/**
	 * Sets the current details event id.
	 *
	 * @param currentDetailsEventId the new current details event id
	 */
	public void setCurrentDetailsEventId(Long currentDetailsEventId) {
		this.currentDetailsEventId = currentDetailsEventId;
	}

	/** The event eff date. */
	@Column(name = "EVNT_EFF_DATE")
	private LocalDate eventEffectiveDate;

	/** The current details event id. */
	@Column(name = "CURRENT_DETAILS_EVENT_ID")
	private Long currentDetailsEventId;
	/** The status id. */
	@OneToOne(optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity status;

	/** The hp scale for. */
	@OneToOne(optional = false)
	@JoinColumn(name = "HP_SCALE_FOR", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity hpScaleFor;

	/** The hp scale type. */
	@OneToOne(optional = false)
	@JoinColumn(name = "HP_SCALE_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity hpScaleType;

	/** The hp type. */
	@OneToOne(optional = false)
	@JoinColumn(name = "HP_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity hpType;

	/** The hp emp type. */
	@Column(name = "HP_EMP_TYPE")
	private long hpEmpType;

	/** The opt avail. */
	@OneToOne(optional = false)
	@JoinColumn(name = "OPT_AVAIL", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity optionAvailable;

	/** The opt avail date. */
	@Column(name = "OPT_AVAIL_DATE")
	private LocalDate optionAvailableDate;

	/** The pay level. */
	@OneToOne(optional = false)
	@JoinColumn(name = "PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity payLevel;

	/** The cell id. */
	@OneToOne(optional = false)
	@JoinColumn(name = "CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cell;

	/** The payband. */
	@OneToOne(optional = false)
	@JoinColumn(name = "PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity payband;

	/** The pay band value. */
	@Column(name = "PAY_BAND_VALUE")
	private long payBandValue;

	/** The grade pay. */
	@OneToOne(optional = false)
	@JoinColumn(name = "GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity gradePay;

	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private long basicPay;

	/** The hg eff date. */
	@Column(name = "HG_EFF_DATE")
	private LocalDate hgEffDate;

	/** The next incr date. */
	@Column(name = "DATE_NXT_INCR")
	private LocalDate dateOfNextIncrement;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The emp id. */
	@OneToOne(optional = false)
	@JoinColumn(name = "EMP_ID")
	private PVUEmployeEntity employee;

	/** The pay scale. */
	
	@Column(name = "PAY_SCALE")
	private Long payScale;

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
	 * Gets the office.
	 *
	 * @return the office
	 */
	public EDPMsOfficeEntity getOffice() {
		return office;
	}

	/**
	 * Sets the office.
	 *
	 * @param office the office to set
	 */
	public void setOffice(EDPMsOfficeEntity office) {
		this.office = office;
	}

	/**
	 * Gets the pay comm.
	 *
	 * @return the payComm
	 */
	public EDPLuLookUpInfoEntity getPayComm() {
		return payComm;
	}

	/**
	 * Sets the pay comm.
	 *
	 * @param payComm the payComm to set
	 */
	public void setPayComm(EDPLuLookUpInfoEntity payComm) {
		this.payComm = payComm;
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
	 * Gets the status.
	 *
	 * @return the status
	 */
	public EDPLuLookUpInfoEntity getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(EDPLuLookUpInfoEntity status) {
		this.status = status;
	}

	/**
	 * Gets the hp scale for.
	 *
	 * @return the hpScaleFor
	 */
	public EDPLuLookUpInfoEntity getHpScaleFor() {
		return hpScaleFor;
	}

	/**
	 * Sets the hp scale for.
	 *
	 * @param hpScaleFor the hpScaleFor to set
	 */
	public void setHpScaleFor(EDPLuLookUpInfoEntity hpScaleFor) {
		this.hpScaleFor = hpScaleFor;
	}

	/**
	 * Gets the hp scale type.
	 *
	 * @return the hpScaleType
	 */
	public EDPLuLookUpInfoEntity getHpScaleType() {
		return hpScaleType;
	}

	/**
	 * Sets the hp scale type.
	 *
	 * @param hpScaleType the hpScaleType to set
	 */
	public void setHpScaleType(EDPLuLookUpInfoEntity hpScaleType) {
		this.hpScaleType = hpScaleType;
	}

	/**
	 * Gets the hp type.
	 *
	 * @return the hpType
	 */
	public EDPLuLookUpInfoEntity getHpType() {
		return hpType;
	}

	/**
	 * Sets the hp type.
	 *
	 * @param hpType the hpType to set
	 */
	public void setHpType(EDPLuLookUpInfoEntity hpType) {
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
	 * Gets the option available.
	 *
	 * @return the optionAvailable
	 */
	public EDPLuLookUpInfoEntity getOptionAvailable() {
		return optionAvailable;
	}

	/**
	 * Sets the option available.
	 *
	 * @param optionAvailable the optionAvailable to set
	 */
	public void setOptionAvailable(EDPLuLookUpInfoEntity optionAvailable) {
		this.optionAvailable = optionAvailable;
	}

	/**
	 * Gets the option available date.
	 *
	 * @return the optionAvailableDate
	 */
	public LocalDate getOptionAvailableDate() {
		return optionAvailableDate;
	}

	/**
	 * Sets the option available date.
	 *
	 * @param optionAvailableDate the optionAvailableDate to set
	 */
	public void setOptionAvailableDate(LocalDate optionAvailableDate) {
		this.optionAvailableDate = optionAvailableDate;
	}

	/**
	 * Gets the pay level.
	 *
	 * @return the payLevel
	 */
	public PVUMsPayLevelEntity getPayLevel() {
		return payLevel;
	}

	/**
	 * Sets the pay level.
	 *
	 * @param payLevel the payLevel to set
	 */
	public void setPayLevel(PVUMsPayLevelEntity payLevel) {
		this.payLevel = payLevel;
	}

	/**
	 * Gets the cell.
	 *
	 * @return the cell
	 */
	public PVUMsPayCellEntity getCell() {
		return cell;
	}

	/**
	 * Sets the cell.
	 *
	 * @param cell the cell to set
	 */
	public void setCell(PVUMsPayCellEntity cell) {
		this.cell = cell;
	}

	/**
	 * Gets the payband.
	 *
	 * @return the payband
	 */
	public PVUMsPayBandEntity getPayband() {
		return payband;
	}

	/**
	 * Sets the payband.
	 *
	 * @param payband the payband to set
	 */
	public void setPayband(PVUMsPayBandEntity payband) {
		this.payband = payband;
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
	 * Gets the grade pay.
	 *
	 * @return the gradePay
	 */
	public PVUMsGradePayEntity getGradePay() {
		return gradePay;
	}

	/**
	 * Sets the grade pay.
	 *
	 * @param gradePay the gradePay to set
	 */
	public void setGradePay(PVUMsGradePayEntity gradePay) {
		this.gradePay = gradePay;
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
	 * Gets the hg eff date.
	 *
	 * @return the hgEffDate
	 */
	public LocalDate getHgEffDate() {
		return hgEffDate;
	}

	/**
	 * Sets the hg eff date.
	 *
	 * @param hgEffDate the hgEffDate to set
	 */
	public void setHgEffDate(LocalDate hgEffDate) {
		this.hgEffDate = hgEffDate;
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
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public PVUEmployeEntity getEmployee() {
		return employee;
	}

	/**
	 * Sets the employee.
	 *
	 * @param employee the employee to set
	 */
	public void setEmployee(PVUEmployeEntity employee) {
		this.employee = employee;
	}


	public Long getPayScale() {
		return payScale;
	}

	public void setPayScale(Long payScale) {
		this.payScale = payScale;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PVUEmployeHigherPayScaleEventEntity that = (PVUEmployeHigherPayScaleEventEntity) o;
		return id == that.id &&
				hpEmpType == that.hpEmpType &&
				payBandValue == that.payBandValue &&
				basicPay == that.basicPay &&
				Objects.equals(trnNo, that.trnNo) &&
				Objects.equals(office, that.office) &&
				Objects.equals(payComm, that.payComm) &&
				Objects.equals(eventOrderNo, that.eventOrderNo) &&
				Objects.equals(approveDate, that.approveDate) &&
				Objects.equals(authorizeDate, that.authorizeDate) &&
				Objects.equals(isPrintAble, that.isPrintAble) &&
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
				Objects.equals(authorizeBy, that.authorizeBy) &&
				Objects.equals(authorizerRemark, that.authorizerRemark) &&
				Objects.equals(eventOrderDate, that.eventOrderDate) &&
				Objects.equals(eventEffectiveDate, that.eventEffectiveDate) &&
				Objects.equals(currentDetailsEventId, that.currentDetailsEventId) &&
				Objects.equals(status, that.status) &&
				Objects.equals(hpScaleFor, that.hpScaleFor) &&
				Objects.equals(hpScaleType, that.hpScaleType) &&
				Objects.equals(hpType, that.hpType) &&
				Objects.equals(optionAvailable, that.optionAvailable) &&
				Objects.equals(optionAvailableDate, that.optionAvailableDate) &&
				Objects.equals(payLevel, that.payLevel) &&
				Objects.equals(cell, that.cell) &&
				Objects.equals(payband, that.payband) &&
				Objects.equals(gradePay, that.gradePay) &&
				Objects.equals(hgEffDate, that.hgEffDate) &&
				Objects.equals(dateOfNextIncrement, that.dateOfNextIncrement) &&
				Objects.equals(remarks, that.remarks) &&
				Objects.equals(employee, that.employee) &&
				Objects.equals(payScale, that.payScale);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, trnNo, office, payComm, eventOrderNo, approveDate, authorizeDate, isPrintAble, auditorRemarks, verifierRemarks, classTwoRemarks, classOneRemarks, printRemarks, auditorReturnReason, verifierReturnReason, classTwoReturnReason, classOneReturnReason, printReturnReason, printCount, refDate, oaBasicPayValue, oaPayScaleId, oaPayBandId, oaPayBandValue, oaGradePayId, oaPayLevelId, oaCellIdValue, oaPayCellId, authorizeBy, authorizerRemark, eventOrderDate, eventEffectiveDate, currentDetailsEventId, status, hpScaleFor, hpScaleType, hpType, hpEmpType, optionAvailable, optionAvailableDate, payLevel, cell, payband, payBandValue, gradePay, basicPay, hgEffDate, dateOfNextIncrement, remarks, employee, payScale);
	}
}
