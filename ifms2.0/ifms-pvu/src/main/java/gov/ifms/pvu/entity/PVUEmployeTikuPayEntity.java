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
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;


@Entity
@Table(name = "T_PVU_TK_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUEmployeTikuPayEntity extends BaseEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_TK_EVNT_ID")
	private long id;

	/** The trn no. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID", nullable = false, referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The pay comm. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_COMM", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payCommId;

	/** The evnt order no. */
	@Column(name = "EVNT_ORDER_NO")
	private String eventOrderNo;

	/** The evnt order LocalDate. */
	@Column(name = "EVNT_ORDER_DATE")
	private LocalDate eventOrderDate;

	/** The evnt eff LocalDate. */
	@Column(name = "EVNT_EFF_DATE")
	private LocalDate eventEffectiveDate;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity status;

	/** The emp type. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "TK_EMP_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity empType;

	/** The pay type. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "TK_PAY_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payType;

	/** The emp id. */
	 
	@ManyToOne
	@JoinColumn(name = "EMP_ID", nullable = false, referencedColumnName = "EMP_ID")
	private PVUEmployeEntity employeeId;

	/** The adhoc id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ADHOC_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity adhocId;

	/** The adhoc start LocalDate. */
	@Column(name = "ADHOC_FROM_DATE")
	private LocalDate adhocStartDate;

	/** The adhoc end LocalDate. */
	@Column(name = "ADHOC_TO_DATE")
	private LocalDate adhocEndDate;

	/** The is ser regularised. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ADHOC_SRV_RGL", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isSerRegularised;

	/** The is gpsc exam passed. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "GPSC_EXM_PASSED", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isGpscExamPassed;

	/** The gpsc exam passed LocalDate. */
	@Column(name = "GPSC_EXM_PASSED_DATE")
	private LocalDate gpscExamPassedDate;

	/** The LocalDate of joining. */
	@Column(name = "DATE_OF_JOIN")
	private LocalDate dateOfJoining;

	/** The class id. */

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CLASS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity classId;

	/** The designation id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	/** The opt availed. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OPT_AVAIL", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity optAvailed;

	/** The opt availed LocalDate. */
	@Column(name = "OPT_AVAIL_DATE")
	private LocalDate optAvailedDate;

	
	@ManyToOne
	@JoinColumn(name = "PAY_SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity payScale;
	
	/** The pay level. */
	@ManyToOne
	@JoinColumn(name = "PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity payLevelId;

	/** The cell id. */
	@ManyToOne
	@JoinColumn(name = "CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cellId;

	/** The pay band. */
	@ManyToOne
	@JoinColumn(name = "PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity payBandId;

	/** The pay band value. */
	@Column(name = "PAY_BAND_VALUE")
	private long payBandValue;
	
	/** The grade pay. */
	@ManyToOne
	@JoinColumn(name = "GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity gradePayId;
	
	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private long basicPay;

	/** The eff LocalDate. */
	@Column(name = "BENE_EFF_DATE")
	private LocalDate effDate;

	/** The nxtincr LocalDate. */
	@Column(name = "DATE_NXT_INCR")
	private LocalDate dateOfNextIncrement;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_CLASS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity cClassId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_DESGN_ID", nullable = false, referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity cDesignationId;
		
	@Column(name = "C_SCALE_ID")
	private long cScaleId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_PAY_SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity cPayScale;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_PAY_LEVEL", nullable = true, referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity cPayLevel;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cCellId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity cPayBandId;
	
	@Column(name = "C_PAY_BAND_VALUE")
	private long cPayBandValue;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity cGradePay;
	
	@Column(name = "C_BASIC_PAY")
	private long cBasicPay;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_OFFICE_ID", nullable = false, referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity cOfficeId;
	
	@Column(name = "C_NXT_INCR_DATE")
	private LocalDate cNextIncrementDate;
	
	@Column(name = "CURRENT_DETAILS_EVENT_ID")
    private Long currentDetailsEventId;
    
    @Column(name = "AUDITOR_REMARKS")
    private String auditorRemarks;
	
    @Column(name = "VERIFIER_REMARKS")
    private String verifierRemarks;
    
    @Column(name = "CLASS_TWO_REMARKS")
    private String classTwoRemarks;
    
    @Column(name = "CLASS_ONE_REMARKS")
    private String classOneRemarks;
    
    @Column(name = "PRINT_REMARKS")
    private String printRemarks;
    
    
    @Column(name = "AUDITOR_RETURN_REASON")
    private Long auditorReturnReason;
    
    @Column(name = "VERIFIER_RETURN_REASON")
    private Long verifierReturnReason;
    
    @Column(name = "CLASS_TWO_RETURN_REASON")
    private Long classTwoReturnReason;
    
    @Column(name = "CLASS_ONE_RETURN_REASON")
    private Long classOneReturnReason;
    
    @Column(name = "PRINT_RETURN_REASON")
    private Long printReturnReason;
    
    @Column(name = "PRINT_COUNT")
    private Long printCount;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IS_PRINTABLE")
	private EDPLuLookUpInfoEntity isPrintAble;
    
    @Column(name = "TIKU_PAY_1DATE")
    private LocalDate tikuPayDateOne;
    
    @Column(name = "TIKU_PAY_2DATE")
    private LocalDate tikuPayDateTwo;
    
    @Column(name = "APPR_DATE")
    private LocalDateTime approveDate;

    /** The authorize date. */
    @Column(name = "AUTH_DATE")
    private LocalDateTime authorizeDate;
	
    @Column(name = "INIT_DATE")
    private LocalDateTime initDate;
    
    /** The init date. */
	@Column(name = "REF_DATE")
	private LocalDateTime refDate;

	/** The init date. */
	@Column(name = "AUTHORIZE_BY")
	private Long authorizeBy;

	/** The init date. */
	@Column(name = "AUTHORIZER_REMARK")
	private String authorizerRemark;
	
	/** The oa basic pay value. */
	@Column(name = "OA_EMP_BASIC_PAY")
	private Long oaBasicPayValue;

	/** The oa pay scale id. */
	@Column(name = "OA_PAY_SCALE")
	private Long oaPayScaleId;

	/** The oa pay band id. */
	@Column(name = "OA_EMP_PAY_BAND")
	private Long oaPayBandId;

	/** The oa pay band value. */
	@Column(name = "OA_PAY_BAND_VALUE")
	private Long oaPayBandValue;

	/** The oa grade pay id. */
	@Column(name = "OA_EMP_GRD_PAY")
	private Long oaGradePayId;

	/** The oa pay level id. */
	@Column(name = "OA_EMP_PAY_LEVEL")
	private Long oaPayLevelId;

	/** The oa cell id value. */
	@Column(name = "OA_CELL_ID")
	private Long oaCellIdValue;

	/** The oa pay cell id. */
	@Column(name = "OA_PAY_CELL_ID")
	private Long oaPayCellId;

	
	public PVUEmployeTikuPayEntity(long id) {
		super();
		this.id = id;
	}
	
	public PVUEmployeTikuPayEntity() {
		super();
	}
	
	public LocalDateTime getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
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

	public LocalDateTime getInitDate() {
		return initDate;
	}

	public void setInitDate(LocalDateTime initDate) {
		this.initDate = initDate;
	}

	public EDPLuLookUpInfoEntity getIsPrintAble() {
		return isPrintAble;
	}

	public void setIsPrintAble(EDPLuLookUpInfoEntity isPrintAble) {
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

	public LocalDate getTikuPayDateOne() {
		return tikuPayDateOne;
	}

	public void setTikuPayDateOne(LocalDate tikuPayDateOne) {
		this.tikuPayDateOne = tikuPayDateOne;
	}

	public LocalDate getTikuPayDateTwo() {
		return tikuPayDateTwo;
	}

	public void setTikuPayDateTwo(LocalDate tikuPayDateTwo) {
		this.tikuPayDateTwo = tikuPayDateTwo;
	}

	public Long getCurrentDetailsEventId() {
		return currentDetailsEventId;
	}

	public void setCurrentDetailsEventId(Long currentDetailsEventId) {
		this.currentDetailsEventId = currentDetailsEventId;
	}


	public EDPLuLookUpInfoEntity getClassId() {
		return classId;
	}

	public void setClassId(EDPLuLookUpInfoEntity classId) {
		this.classId = classId;
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
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the pay comm id.
	 *
	 * @return the payCommId
	 */
	public EDPLuLookUpInfoEntity getPayCommId() {
		return payCommId;
	}

	/**
	 * Sets the pay comm id.
	 *
	 * @param payCommId the payCommId to set
	 */
	public void setPayCommId(EDPLuLookUpInfoEntity payCommId) {
		this.payCommId = payCommId;
	}

	/**
	 * Gets the evnt order no.
	 *
	 * @return the evntOrderNo
	 */
	public String getEventOrderNo() {
		return eventOrderNo;
	}

	/**
	 * Sets the evnt order no.
	 *
	 * @param eventOrderNo the evntOrderNo to set
	 */
	public void setEventOrderNo(String eventOrderNo) {
		this.eventOrderNo = eventOrderNo;
	}

	/**
	 * Gets the evnt order date.
	 *
	 * @return the evntOrderDate
	 */
	public LocalDate getEventOrderDate() {
		return eventOrderDate;
	}

	/**
	 * Sets the evnt order date.
	 *
	 * @param evntOrderDate the evntOrderDate to set
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
	 * Gets the emp type.
	 *
	 * @return the empType
	 */
	public EDPLuLookUpInfoEntity getEmpType() {
		return empType;
	}

	/**
	 * Sets the emp type.
	 *
	 * @param empType the empType to set
	 */
	public void setEmpType(EDPLuLookUpInfoEntity empType) {
		this.empType = empType;
	}

	/**
	 * Gets the pay type.
	 *
	 * @return the payType
	 */
	public EDPLuLookUpInfoEntity getPayType() {
		return payType;
	}

	/**
	 * Sets the pay type.
	 *
	 * @param payType the payType to set
	 */
	public void setPayType(EDPLuLookUpInfoEntity payType) {
		this.payType = payType;
	}

	/**
	 * Gets the employee id.
	 *
	 * @return the employeeId
	 */
	public PVUEmployeEntity getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(PVUEmployeEntity employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the adhoc id.
	 *
	 * @return the adhocId
	 */
	public EDPLuLookUpInfoEntity getAdhocId() {
		return adhocId;
	}

	/**
	 * Sets the adhoc id.
	 *
	 * @param adhocId the adhocId to set
	 */
	public void setAdhocId(EDPLuLookUpInfoEntity adhocId) {
		this.adhocId = adhocId;
	}

	/**
	 * Gets the adhoc start date.
	 *
	 * @return the adhocStartDate
	 */
	public LocalDate getAdhocStartDate() {
		return adhocStartDate;
	}

	/**
	 * Sets the adhoc start date.
	 *
	 * @param adhocStartDate the adhocStartDate to set
	 */
	public void setAdhocStartDate(LocalDate adhocStartDate) {
		this.adhocStartDate = adhocStartDate;
	}

	/**
	 * Gets the adhoc end date.
	 *
	 * @return the adhocEndDate
	 */
	public LocalDate getAdhocEndDate() {
		return adhocEndDate;
	}

	/**
	 * Sets the adhoc end date.
	 *
	 * @param adhocEndDate the adhocEndDate to set
	 */
	public void setAdhocEndDate(LocalDate adhocEndDate) {
		this.adhocEndDate = adhocEndDate;
	}

	/**
	 * Gets the checks if is ser regularised.
	 *
	 * @return the isSerRegularised
	 */
	public EDPLuLookUpInfoEntity getIsSerRegularised() {
		return isSerRegularised;
	}

	/**
	 * Sets the checks if is ser regularised.
	 *
	 * @param isSerRegularised the isSerRegularised to set
	 */
	public void setIsSerRegularised(EDPLuLookUpInfoEntity isSerRegularised) {
		this.isSerRegularised = isSerRegularised;
	}

	/**
	 * Gets the checks if is gpsc exam passed.
	 *
	 * @return the isGpscExamPassed
	 */
	public EDPLuLookUpInfoEntity getIsGpscExamPassed() {
		return isGpscExamPassed;
	}

	/**
	 * Sets the checks if is gpsc exam passed.
	 *
	 * @param isGpscExamPassed the isGpscExamPassed to set
	 */
	public void setIsGpscExamPassed(EDPLuLookUpInfoEntity isGpscExamPassed) {
		this.isGpscExamPassed = isGpscExamPassed;
	}

	/**
	 * Gets the gpsc exam passed date.
	 *
	 * @return the gpscExamPassedDate
	 */
	public LocalDate getGpscExamPassedDate() {
		return gpscExamPassedDate;
	}

	/**
	 * Sets the gpsc exam passed date.
	 *
	 * @param gpscExamPassedDate the gpscExamPassedDate to set
	 */
	public void setGpscExamPassedDate(LocalDate gpscExamPassedDate) {
		this.gpscExamPassedDate = gpscExamPassedDate;
	}
	

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public EDPMsDesignationEntity getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(EDPMsDesignationEntity designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the opt availed.
	 *
	 * @return the optAvailed
	 */
	public EDPLuLookUpInfoEntity getOptAvailed() {
		return optAvailed;
	}

	/**
	 * Sets the opt availed.
	 *
	 * @param optAvailed the optAvailed to set
	 */
	public void setOptAvailed(EDPLuLookUpInfoEntity optAvailed) {
		this.optAvailed = optAvailed;
	}

	/**
	 * Gets the opt availed date.
	 *
	 * @return the optAvailedDate
	 */
	public LocalDate getOptAvailedDate() {
		return optAvailedDate;
	}

	/**
	 * Sets the opt availed date.
	 *
	 * @param optAvailedDate the optAvailedDate to set
	 */
	public void setOptAvailedDate(LocalDate optAvailedDate) {
		this.optAvailedDate = optAvailedDate;
	}

	public PVUMsPayLevelEntity getPayLevelId() {
		return payLevelId;
	}

	/**
	 * Sets the pay level id.
	 *
	 * @param payLevelId the payLevelId to set
	 */
	public void setPayLevelId(PVUMsPayLevelEntity payLevelId) {
		this.payLevelId = payLevelId;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cellId
	 */
	public PVUMsPayCellEntity getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the cellId to set
	 */
	public void setCellId(PVUMsPayCellEntity cellId) {
		this.cellId = cellId;
	}

	/**
	 * Gets the pay band id.
	 *
	 * @return the payBandId
	 */
	public PVUMsPayBandEntity getPayBandId() {
		return payBandId;
	}

	/**
	 * Sets the pay band id.
	 *
	 * @param payBandId the payBandId to set
	 */
	public void setPayBandId(PVUMsPayBandEntity payBandId) {
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
	public PVUMsGradePayEntity getGradePayId() {
		return gradePayId;
	}

	/**
	 * Sets the grade pay id.
	 *
	 * @param gradePayId the gradePayId to set
	 */
	public void setGradePayId(PVUMsGradePayEntity gradePayId) {
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
	 * Gets the eff date.
	 *
	 * @return the effDate
	 */
	public LocalDate getEffDate() {
		return effDate;
	}

	/**
	 * Sets the eff date.
	 *
	 * @param effDate the effDate to set
	 */
	public void setEffDate(LocalDate effDate) {
		this.effDate = effDate;
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
	 * Instantiates a new PVU employe tiku pay entity.
	 *
	 * @param id the id
	 */

	public EDPMsDesignationEntity getcDesignationId() {
		return cDesignationId;
	}

	public void setcDesignationId(EDPMsDesignationEntity cDesignationId) {
		this.cDesignationId = cDesignationId;
	}

	public long getcScaleId() {
		return cScaleId;
	}

	public void setcScaleId(long cScaleId) {
		this.cScaleId = cScaleId;
	}

	public PVUMsPayScaleEntity getPayScale() {
		return payScale;
	}

	public void setPayScale(PVUMsPayScaleEntity payScale) {
		this.payScale = payScale;
	}

	public PVUMsPayScaleEntity getcPayScale() {
		return cPayScale;
	}

	public void setcPayScale(PVUMsPayScaleEntity cPayScale) {
		this.cPayScale = cPayScale;
	}

	public PVUMsPayLevelEntity getcPayLevel() {
		return cPayLevel;
	}

	public void setcPayLevel(PVUMsPayLevelEntity cPayLevel) {
		this.cPayLevel = cPayLevel;
	}

	public PVUMsPayCellEntity getcCellId() {
		return cCellId;
	}

	public void setcCellId(PVUMsPayCellEntity cCellId) {
		this.cCellId = cCellId;
	}

	public PVUMsPayBandEntity getcPayBandId() {
		return cPayBandId;
	}

	public void setcPayBandId(PVUMsPayBandEntity cPayBandId) {
		this.cPayBandId = cPayBandId;
	}

	public long getcPayBandValue() {
		return cPayBandValue;
	}

	public void setcPayBandValue(long cPayBandValue) {
		this.cPayBandValue = cPayBandValue;
	}

	public PVUMsGradePayEntity getcGradePay() {
		return cGradePay;
	}

	public void setcGradePay(PVUMsGradePayEntity cGradePay) {
		this.cGradePay = cGradePay;
	}

	public long getcBasicPay() {
		return cBasicPay;
	}

	public void setcBasicPay(long cBasicPay) {
		this.cBasicPay = cBasicPay;
	}

	public EDPMsOfficeEntity getcOfficeId() {
		return cOfficeId;
	}

	public void setcOfficeId(EDPMsOfficeEntity cOfficeId) {
		this.cOfficeId = cOfficeId;
	}

	public LocalDate getcNextIncrementDate() {
		return cNextIncrementDate;
	}

	public void setcNextIncrementDate(LocalDate cNextIncrementDate) {
		this.cNextIncrementDate = cNextIncrementDate;
	}
	
	public EDPLuLookUpInfoEntity getcClassId() {
		return cClassId;
	}

	public void setcClassId(EDPLuLookUpInfoEntity cClassId) {
		this.cClassId = cClassId;
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

	

	@Override
	public String toString() {
		return "PVUEmployeTikuPayEntity [id=" + id + ", trnNo=" + trnNo + ", officeId=" + officeId + ", payCommId="
				+ payCommId + ", eventOrderNo=" + eventOrderNo + ", eventOrderDate=" + eventOrderDate
				+ ", eventEffectiveDate=" + eventEffectiveDate + ", status=" + status + ", empType=" + empType
				+ ", payType=" + payType + ", employeeId=" + employeeId + ", adhocId=" + adhocId + ", adhocStartDate="
				+ adhocStartDate + ", adhocEndDate=" + adhocEndDate + ", isSerRegularised=" + isSerRegularised
				+ ", isGpscExamPassed=" + isGpscExamPassed + ", gpscExamPassedDate=" + gpscExamPassedDate
				+ ", dateOfJoining=" + dateOfJoining + ", classId=" + classId + ", designationId=" + designationId
				+ ", optAvailed=" + optAvailed + ", optAvailedDate=" + optAvailedDate + ", payScale=" + payScale
				+ ", payLevelId=" + payLevelId + ", cellId=" + cellId + ", payBandId=" + payBandId + ", payBandValue="
				+ payBandValue + ", gradePayId=" + gradePayId + ", basicPay=" + basicPay + ", effDate=" + effDate
				+ ", dateOfNextIncrement=" + dateOfNextIncrement + ", remarks=" + remarks + ", cClassId=" + cClassId
				+ ", cDesignationId=" + cDesignationId + ", cScaleId=" + cScaleId + ", cPayScale=" + cPayScale
				+ ", cPayLevel=" + cPayLevel + ", cCellId=" + cCellId + ", cPayBandId=" + cPayBandId
				+ ", cPayBandValue=" + cPayBandValue + ", cGradePay=" + cGradePay + ", cBasicPay=" + cBasicPay
				+ ", cOfficeId=" + cOfficeId + ", cNextIncrementDate=" + cNextIncrementDate + ", currentDetailsEventId="
				+ currentDetailsEventId + ", auditorRemarks=" + auditorRemarks + ", verifierRemarks=" + verifierRemarks
				+ ", classTwoRemarks=" + classTwoRemarks + ", classOneRemarks=" + classOneRemarks + ", printRemarks="
				+ printRemarks + ", auditorReturnReason=" + auditorReturnReason + ", verifierReturnReason="
				+ verifierReturnReason + ", classTwoReturnReason=" + classTwoReturnReason + ", classOneReturnReason="
				+ classOneReturnReason + ", printReturnReason=" + printReturnReason + ", printCount=" + printCount
				+ ", isPrintAble=" + isPrintAble + ", tikuPayDateOne=" + tikuPayDateOne + ", tikuPayDateTwo="
				+ tikuPayDateTwo + ", approveDate=" + approveDate + ", authorizeDate=" + authorizeDate + ", initDate="
				+ initDate + ", refDate=" + refDate + ", authorizeBy=" + authorizeBy + ", authorizerRemark="
				+ authorizerRemark + ", oaBasicPayValue=" + oaBasicPayValue + ", oaPayScaleId=" + oaPayScaleId
				+ ", oaPayBandId=" + oaPayBandId + ", oaPayBandValue=" + oaPayBandValue + ", oaGradePayId="
				+ oaGradePayId + ", oaPayLevelId=" + oaPayLevelId + ", oaCellIdValue=" + oaCellIdValue
				+ ", oaPayCellId=" + oaPayCellId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adhocEndDate, adhocId, adhocStartDate, approveDate, auditorRemarks, auditorReturnReason,
				authorizeBy, authorizeDate, authorizerRemark, basicPay, cBasicPay, cCellId, cClassId, cDesignationId,
				cGradePay, cNextIncrementDate, cOfficeId, cPayBandId, cPayBandValue, cPayLevel, cPayScale, cScaleId,
				cellId, classId, classOneRemarks, classOneReturnReason, classTwoRemarks, classTwoReturnReason,
				currentDetailsEventId, dateOfJoining, dateOfNextIncrement, designationId, effDate, empType, employeeId,
				eventEffectiveDate, eventOrderDate, eventOrderNo, gpscExamPassedDate, gradePayId, id, initDate,
				isGpscExamPassed, isPrintAble, isSerRegularised, officeId, optAvailed, optAvailedDate, payBandId,
				payBandValue, payCommId, payLevelId, payScale, payType, printCount, printRemarks, printReturnReason,
				refDate, remarks, status, tikuPayDateOne, tikuPayDateTwo, trnNo, verifierRemarks, verifierReturnReason,
				oaCellIdValue, oaBasicPayValue, oaGradePayId, oaPayBandId, oaPayBandValue, oaPayCellId, oaPayScaleId, oaPayLevelId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUEmployeTikuPayEntity)) {
			return false;
		}
		PVUEmployeTikuPayEntity other = (PVUEmployeTikuPayEntity) obj;
		return Objects.equals(adhocEndDate, other.adhocEndDate) && Objects.equals(adhocId, other.adhocId)
				&& Objects.equals(adhocStartDate, other.adhocStartDate)
				&& Objects.equals(approveDate, other.approveDate)
				&& Objects.equals(auditorRemarks, other.auditorRemarks)
				&& Objects.equals(auditorReturnReason, other.auditorReturnReason)
				&& Objects.equals(authorizeBy, other.authorizeBy) && Objects.equals(authorizeDate, other.authorizeDate)
				&& Objects.equals(authorizerRemark, other.authorizerRemark) && basicPay == other.basicPay
				&& cBasicPay == other.cBasicPay && Objects.equals(cCellId, other.cCellId)
				&& Objects.equals(cClassId, other.cClassId) && Objects.equals(cDesignationId, other.cDesignationId)
				&& Objects.equals(cGradePay, other.cGradePay)
				&& Objects.equals(cNextIncrementDate, other.cNextIncrementDate)
				&& Objects.equals(cOfficeId, other.cOfficeId) && Objects.equals(cPayBandId, other.cPayBandId)
				&& cPayBandValue == other.cPayBandValue && Objects.equals(cPayLevel, other.cPayLevel)
				&& Objects.equals(cPayScale, other.cPayScale) && cScaleId == other.cScaleId
				&& Objects.equals(cellId, other.cellId) && Objects.equals(classId, other.classId)
				&& Objects.equals(classOneRemarks, other.classOneRemarks)
				&& Objects.equals(classOneReturnReason, other.classOneReturnReason)
				&& Objects.equals(classTwoRemarks, other.classTwoRemarks)
				&& Objects.equals(classTwoReturnReason, other.classTwoReturnReason)
				&& Objects.equals(currentDetailsEventId, other.currentDetailsEventId)
				&& Objects.equals(dateOfJoining, other.dateOfJoining)
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& Objects.equals(designationId, other.designationId) && Objects.equals(effDate, other.effDate)
				&& Objects.equals(empType, other.empType) && Objects.equals(employeeId, other.employeeId)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate)
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventOrderNo, other.eventOrderNo)
				&& Objects.equals(gpscExamPassedDate, other.gpscExamPassedDate)
				&& Objects.equals(gradePayId, other.gradePayId) && id == other.id
				&& Objects.equals(initDate, other.initDate) && Objects.equals(isGpscExamPassed, other.isGpscExamPassed)
				&& Objects.equals(isPrintAble, other.isPrintAble)
				&& Objects.equals(isSerRegularised, other.isSerRegularised) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(optAvailed, other.optAvailed) && Objects.equals(optAvailedDate, other.optAvailedDate)
				&& Objects.equals(payBandId, other.payBandId) && payBandValue == other.payBandValue
				&& Objects.equals(payCommId, other.payCommId) && Objects.equals(payLevelId, other.payLevelId)
				&& Objects.equals(payScale, other.payScale) && Objects.equals(payType, other.payType)
				&& Objects.equals(printCount, other.printCount) && Objects.equals(printRemarks, other.printRemarks)
				&& Objects.equals(printReturnReason, other.printReturnReason) && Objects.equals(refDate, other.refDate)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(status, other.status)
				&& Objects.equals(tikuPayDateOne, other.tikuPayDateOne)
				&& Objects.equals(tikuPayDateTwo, other.tikuPayDateTwo) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(verifierRemarks, other.verifierRemarks)
				&& Objects.equals(verifierReturnReason, other.verifierReturnReason)
				&& Objects.equals(oaBasicPayValue, other.oaBasicPayValue)
				&& Objects.equals(oaCellIdValue, other.oaCellIdValue)
				&& Objects.equals(oaGradePayId, other.oaGradePayId)
				&& Objects.equals(oaPayBandId, other.oaPayBandId)
				&& Objects.equals(oaPayBandValue, other.oaPayBandValue)
				&& Objects.equals(oaPayCellId, other.oaPayCellId)
				&& Objects.equals(oaPayLevelId, other.oaPayLevelId)
				&& Objects.equals(oaPayScaleId, other.oaPayScaleId);
	}


	
}
