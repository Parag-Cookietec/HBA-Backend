package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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

/**
 * The Class PVUStEventEntity.
 *
 * @version v 1.0
 * @created 2019/12/17 18:44:21
 *
 */
/**
 * @author Admin
 *
 */
@Entity
@Table(name = "T_PVU_ST_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUSteppingUpEventEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The st event id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_ST_EVNT_ID")
	private long stEventId;

	/** The trn no. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID", nullable = false, referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The event order no. */
	@Column(name = "EVNT_ORDER_NO")
	private String eventOrderNo;

	/** The event order date. */
	@Column(name = "EVNT_ORDER_DATE")
	private LocalDate eventOrderDate;

	/** The event eff date. */
	@Column(name = "EVNT_EFF_DATE")
	private LocalDate eventEffectiveDate;

	/** The pay comm. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_COMM", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payComm;

	/** The cur emp no. */
	@Column(name = "C_EMPLOYEE_NO")
	private long curEmpNo;

	/** The cur emp id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", nullable = false, referencedColumnName = "EMP_ID")
	private PVUEmployeEntity curEmpId;

	/** The cur emp class. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_EMP_CLASS", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity curEmpClass;

	/** The cur emp dsgn. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_EMP_DSGN", nullable = false, referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity curEmpDsgn;

	/** The cur emp dsgn. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_OFFICE_ID", nullable = false, referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity curOffice;

	/** The cur grade. */
	@Column(name = "C_GRADE")
	private long curGrade;

	
    /**
     * The cur scale.
     */
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "C_SCALE",referencedColumnName = "PAY_SCALE_ID")
    private PVUMsPayScaleEntity curScale;


	/** The cur pay level. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity curPayLevel;

	/** The cur pay band. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity curPayBand;

	/** The cur pay band value. */
	@Column(name = "C_PAY_BAND_VALUE")
	private long curPayBandValue;

	/** The cur grade pay. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity curGradePay;

	/** The cur cell id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity curCellId;

	/** The cur basic pay. */
	@Column(name = "C_BASIC_PAY")
	private long curBasicPay;

	/** The cur date next inc. */
	@Column(name = "C_DATE_NEX_INC")
	private LocalDate curDateNextInc;

	/** The jr emp no. */
	@Column(name = "J_EMPLOYEE_NO")
	private long jrEmpNo;

	/** The jr emp id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "J_EMP_ID", nullable = false, referencedColumnName = "EMP_ID")
	private PVUEmployeEntity jrEmpId;

	/** The jr emp Name. */
	@Column(name = "J_EMPLOYEE_NAME")
	private String jrEmpName;


	/** The jr emp class. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "J_EMP_CLASS", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity jrEmpClass;

	/** The jr emp dsgn. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "J_EMP_DSGN", nullable = false, referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity jrEmpDsgn;

	/** The j office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "J_OFFICE_ID", nullable = false, referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity jrOfficeId;

	/** The jr grade. */
	@Column(name = "J_GRADE")
	private long jrGrade;

	/** The jr scale. */
	@Column(name = "J_SCALE")
	private long jrScale;

	/** The jr pay level. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "J_PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity jrPayLevel;

	/** The jr pay band. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "J_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity jrPayBand;

	/** The jr pay band value. */
	@Column(name = "J_PAY_BAND_VALUE")
	private long jrPayBandValue;

	/** The Jr grade pay. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "J_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity jrGradePay;

	/** The jr cell id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "J_CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity jrCellId;

	/** The jr basic pay. */
	@Column(name = "J_BASIC_PAY")
	private long jrBasicPay;

	/** The jr date nex inc. */
	@Column(name = "J_DATE_NEX_INC")
	private LocalDate jrDateNexInc;

	/** The ch class. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CH_EMP_CLASS", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity chEmpClass;

	/** The ch dsgn. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CH_EMP_DSGN", nullable = false, referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity chEmpDsgn;

	/** The ch grade. */
	@Column(name = "CH_GRADE")
	private long chGrade;


    /**
     * The scale.
     */
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "CH_SCALE",referencedColumnName = "PAY_SCALE_ID")
    private PVUMsPayScaleEntity chScale;

	
	
	/** The ch pay level. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CH_PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity chPayLevel;

	/** The jr pay band. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CH_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity chPayBand;

	/** The jr pay band value. */
	@Column(name = "CH_PAY_BAND_VALUE")
	private long chPayBandValue;

	/** The Jr grade pay. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CH_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity chGradePay;

	/** The ch cell id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CH_CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity chCellId;

	/** The ch basic pay. */
	@Column(name = "CH_BASIC_PAY")
	private long chBasicPay;

	/** The ch date nex inc. */
	@Column(name = "CH_DATE_NEX_INC")
	private LocalDate chDateNexInc;

	/** The ch bene eff date. */
	@Column(name = "CH_BENE_EFF_DATE")
	private LocalDate chBeneEffDate;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;


	/** The stepping up Type id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "TYPE_ID", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity steppingUpTypeId;


    /**
     * The currentDetailsEventId.
     */
    @Column(name = "CURR_DETAIL_EVENT_ID")
    private Long currentDetailsEventId;

    /** The is print able. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IS_PRINTABLE")
    private EDPLuLookUpInfoEntity isPrintAble;

    /** The approve date. */
    @Column(name = "APPR_DATE")
    private Date approveDate;

    /** The authorize date. */
    @Column(name = "AUTH_DATE")
    private Date authorizeDate;

    
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

    /** The authorize date. */
    @Column(name = "INIT_DATE")
    private Date initDate;

    /** The init date. */
    @Column(name = "AUTHORIZE_BY")
    private Long authorizeBy;

    /** The init date. */
    @Column(name = "AUTHORIZER_REMARK")
    private String authorizerRemark;

	/** The ref date. */
	@Column(name = "REF_DATE")
	private LocalDateTime refDate;
	
	@Column(name = "SR_SENIOR_NO")
	private Long srSeniorNo;

	@Column(name = "JR_SENIOR_NO")
	private Long jrSeniorNo;

	@Column(name = "PRV_STP_AVAIL_DTLS")
	private String prvStpAvailDtls;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IS_STP_AVAIL")
	private EDPLuLookUpInfoEntity isStpAvail;

	/** The date of last pf date. */
	@Column(name = "LAST_PF_DATE")
	private LocalDate lastPfDate;
	
	public LocalDate getLastPfDate() {
		return lastPfDate;
	}

	public void setLastPfDate(LocalDate lastPfDate) {
		this.lastPfDate = lastPfDate;
	}

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

	public EDPLuLookUpInfoEntity getIsStpAvail() {
		return isStpAvail;
	}

	public void setIsStpAvail(EDPLuLookUpInfoEntity isStpAvail) {
		this.isStpAvail = isStpAvail;
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

	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
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

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	public Date getAuthorizeDate() {
		return authorizeDate;
	}

	public void setAuthorizeDate(Date authorizeDate) {
		this.authorizeDate = authorizeDate;
	}

	public Long getCurrentDetailsEventId() {
		return currentDetailsEventId;
	}

	public void setCurrentDetailsEventId(Long currentDetailsEventId) {
		this.currentDetailsEventId = currentDetailsEventId;
	}

	public EDPLuLookUpInfoEntity getIsPrintAble() {
		return isPrintAble;
	}

	public void setIsPrintAble(EDPLuLookUpInfoEntity isPrintAble) {
		this.isPrintAble = isPrintAble;
	}

	public EDPLuLookUpInfoEntity getSteppingUpTypeId() {
		return steppingUpTypeId;
	}

	public void setSteppingUpTypeId(EDPLuLookUpInfoEntity steppingUpTypeId) {
		this.steppingUpTypeId = steppingUpTypeId;
	}

	/**
	 * PVUStEventEntity Constructor.
	 */
	public PVUSteppingUpEventEntity() {
		super();
	}

	public PVUSteppingUpEventEntity(Long stEventId) {
		this.stEventId = stEventId;
	}

	/**
	 * Gets the st event id.
	 *
	 * @return the stEventId
	 */
	public long getStEventId() {
		return stEventId;
	}

	/**
	 * Sets the st event id.
	 *
	 * @param stEventId the stEventId to set
	 */
	public void setStEventId(long stEventId) {
		this.stEventId = stEventId;
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
	public PVUEmployeEntity getCurEmpId() {
		return curEmpId;
	}

	/**
	 * Sets the cur emp id.
	 *
	 * @param curEmpId the curEmpId to set
	 */
	public void setCurEmpId(PVUEmployeEntity curEmpId) {
		this.curEmpId = curEmpId;
	}

	/**
	 * Gets the cur emp class.
	 *
	 * @return the curEmpClass
	 */
	public EDPLuLookUpInfoEntity getCurEmpClass() {
		return curEmpClass;
	}

	/**
	 * Sets the cur emp class.
	 *
	 * @param curEmpClass the curEmpClass to set
	 */
	public void setCurEmpClass(EDPLuLookUpInfoEntity curEmpClass) {
		this.curEmpClass = curEmpClass;
	}

	/**
	 * Gets the cur emp dsgn.
	 *
	 * @return the curEmpDsgn
	 */
	public EDPMsDesignationEntity getCurEmpDsgn() {
		return curEmpDsgn;
	}

	/**
	 * Sets the cur emp dsgn.
	 *
	 * @param curEmpDsgn the curEmpDsgn to set
	 */
	public void setCurEmpDsgn(EDPMsDesignationEntity curEmpDsgn) {
		this.curEmpDsgn = curEmpDsgn;
	}

	/**
	 * Gets the cur office.
	 *
	 * @return the curOffice
	 */
	public EDPMsOfficeEntity getCurOffice() {
		return curOffice;
	}

	/**
	 * Sets the cur office.
	 *
	 * @param curOffice the curOffice to set
	 */
	public void setCurOffice(EDPMsOfficeEntity curOffice) {
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
	public PVUMsPayScaleEntity getCurScale() {
		return curScale;
	}

	/**
	 * Sets the cur scale.
	 *
	 * @param curScale the curScale to set
	 */
	public void setCurScale(PVUMsPayScaleEntity curScale) {
		this.curScale = curScale;
	}

	/**
	 * Gets the cur pay level.
	 *
	 * @return the curPayLevel
	 */
	public PVUMsPayLevelEntity getCurPayLevel() {
		return curPayLevel;
	}

	/**
	 * Sets the cur pay level.
	 *
	 * @param curPayLevel the curPayLevel to set
	 */
	public void setCurPayLevel(PVUMsPayLevelEntity curPayLevel) {
		this.curPayLevel = curPayLevel;
	}

	/**
	 * Gets the cur pay band.
	 *
	 * @return the curPayBand
	 */
	public PVUMsPayBandEntity getCurPayBand() {
		return curPayBand;
	}

	/**
	 * Sets the cur pay band.
	 *
	 * @param curPayBand the curPayBand to set
	 */
	public void setCurPayBand(PVUMsPayBandEntity curPayBand) {
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
	public PVUMsGradePayEntity getCurGradePay() {
		return curGradePay;
	}

	/**
	 * Sets the cur grade pay.
	 *
	 * @param curGradePay the curGradePay to set
	 */
	public void setCurGradePay(PVUMsGradePayEntity curGradePay) {
		this.curGradePay = curGradePay;
	}

	/**
	 * Gets the cur cell id.
	 *
	 * @return the curCellId
	 */
	public PVUMsPayCellEntity getCurCellId() {
		return curCellId;
	}

	/**
	 * Sets the cur cell id.
	 *
	 * @param curCellId the curCellId to set
	 */
	public void setCurCellId(PVUMsPayCellEntity curCellId) {
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
	public PVUEmployeEntity getJrEmpId() {
		return jrEmpId;
	}

	/**
	 * Sets the jr emp id.
	 *
	 * @param jrEmpId the jrEmpId to set
	 */
	public void setJrEmpId(PVUEmployeEntity jrEmpId) {
		this.jrEmpId = jrEmpId;
	}

	/**
	 * Gets the jr emp class.
	 *
	 * @return the jrEmpClass
	 */
	public EDPLuLookUpInfoEntity getJrEmpClass() {
		return jrEmpClass;
	}

	/**
	 * Sets the jr emp class.
	 *
	 * @param jrEmpClass the jrEmpClass to set
	 */
	public void setJrEmpClass(EDPLuLookUpInfoEntity jrEmpClass) {
		this.jrEmpClass = jrEmpClass;
	}

	/**
	 * Gets the jr emp dsgn.
	 *
	 * @return the jrEmpDsgn
	 */
	public EDPMsDesignationEntity getJrEmpDsgn() {
		return jrEmpDsgn;
	}

	/**
	 * Sets the jr emp dsgn.
	 *
	 * @param jrEmpDsgn the jrEmpDsgn to set
	 */
	public void setJrEmpDsgn(EDPMsDesignationEntity jrEmpDsgn) {
		this.jrEmpDsgn = jrEmpDsgn;
	}

	/**
	 * Gets the jr office id.
	 *
	 * @return the jrOfficeId
	 */
	public EDPMsOfficeEntity getJrOfficeId() {
		return jrOfficeId;
	}

	/**
	 * Sets the jr office id.
	 *
	 * @param jrOfficeId the jrOfficeId to set
	 */
	public void setJrOfficeId(EDPMsOfficeEntity jrOfficeId) {
		this.jrOfficeId = jrOfficeId;
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
	public PVUMsPayLevelEntity getJrPayLevel() {
		return jrPayLevel;
	}

	/**
	 * Sets the jr pay level.
	 *
	 * @param jrPayLevel the jrPayLevel to set
	 */
	public void setJrPayLevel(PVUMsPayLevelEntity jrPayLevel) {
		this.jrPayLevel = jrPayLevel;
	}

	/**
	 * Gets the jr pay band.
	 *
	 * @return the jrPayBand
	 */
	public PVUMsPayBandEntity getJrPayBand() {
		return jrPayBand;
	}

	/**
	 * Sets the jr pay band.
	 *
	 * @param jrPayBand the jrPayBand to set
	 */
	public void setJrPayBand(PVUMsPayBandEntity jrPayBand) {
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
	public PVUMsGradePayEntity getJrGradePay() {
		return jrGradePay;
	}

	/**
	 * Sets the jr grade pay.
	 *
	 * @param jrGradePay the jrGradePay to set
	 */
	public void setJrGradePay(PVUMsGradePayEntity jrGradePay) {
		this.jrGradePay = jrGradePay;
	}

	/**
	 * Gets the jr cell id.
	 *
	 * @return the jrCellId
	 */
	public PVUMsPayCellEntity getJrCellId() {
		return jrCellId;
	}

	/**
	 * Sets the jr cell id.
	 *
	 * @param jrCellId the jrCellId to set
	 */
	public void setJrCellId(PVUMsPayCellEntity jrCellId) {
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
	public EDPLuLookUpInfoEntity getChEmpClass() {
		return chEmpClass;
	}

	/**
	 * Sets the ch emp class.
	 *
	 * @param chEmpClass the chEmpClass to set
	 */
	public void setChEmpClass(EDPLuLookUpInfoEntity chEmpClass) {
		this.chEmpClass = chEmpClass;
	}

	/**
	 * Gets the ch emp dsgn.
	 *
	 * @return the chEmpDsgn
	 */
	public EDPMsDesignationEntity getChEmpDsgn() {
		return chEmpDsgn;
	}

	/**
	 * Sets the ch emp dsgn.
	 *
	 * @param chEmpDsgn the chEmpDsgn to set
	 */
	public void setChEmpDsgn(EDPMsDesignationEntity chEmpDsgn) {
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
	 * Gets the ch scale.
	 *
	 * @return the chScale
	 */
	public PVUMsPayScaleEntity getChScale() {
		return chScale;
	}

	/**
	 * Sets the ch scale.
	 *
	 * @param chScale the chScale to set
	 */
	public void setChScale(PVUMsPayScaleEntity chScale) {
		this.chScale = chScale;
	}

	/**
	 * Gets the ch pay level.
	 *
	 * @return the chPayLevel
	 */
	public PVUMsPayLevelEntity getChPayLevel() {
		return chPayLevel;
	}

	/**
	 * Sets the ch pay level.
	 *
	 * @param chPayLevel the chPayLevel to set
	 */
	public void setChPayLevel(PVUMsPayLevelEntity chPayLevel) {
		this.chPayLevel = chPayLevel;
	}

	/**
	 * Gets the ch pay band.
	 *
	 * @return the chPayBand
	 */
	public PVUMsPayBandEntity getChPayBand() {
		return chPayBand;
	}

	/**
	 * Sets the ch pay band.
	 *
	 * @param chPayBand the chPayBand to set
	 */
	public void setChPayBand(PVUMsPayBandEntity chPayBand) {
		this.chPayBand = chPayBand;
	}

	/**
	 * Gets the ch pay band value.
	 *
	 * @return the chPayBandValue
	 */
	public long getChPayBandValue() {
		return chPayBandValue;
	}

	/**
	 * Sets the ch pay band value.
	 *
	 * @param chPayBandValue the chPayBandValue to set
	 */
	public void setChPayBandValue(long chPayBandValue) {
		this.chPayBandValue = chPayBandValue;
	}

	/**
	 * Gets the ch grade pay.
	 *
	 * @return the chGradePay
	 */
	public PVUMsGradePayEntity getChGradePay() {
		return chGradePay;
	}

	/**
	 * Sets the ch grade pay.
	 *
	 * @param chGradePay the chGradePay to set
	 */
	public void setChGradePay(PVUMsGradePayEntity chGradePay) {
		this.chGradePay = chGradePay;
	}

	/**
	 * Gets the ch cell id.
	 *
	 * @return the chCellId
	 */
	public PVUMsPayCellEntity getChCellId() {
		return chCellId;
	}

	/**
	 * Sets the ch cell id.
	 *
	 * @param chCellId the chCellId to set
	 */
	public void setChCellId(PVUMsPayCellEntity chCellId) {
		this.chCellId = chCellId;
	}

	/**
	 * Gets the ch basic pay.
	 *
	 * @return the chBasicPay
	 */
	public long getChBasicPay() {
		return chBasicPay;
	}

	/**
	 * Sets the ch basic pay.
	 *
	 * @param chBasicPay the chBasicPay to set
	 */
	public void setChBasicPay(long chBasicPay) {
		this.chBasicPay = chBasicPay;
	}

	/**
	 * Gets the ch date nex inc.
	 *
	 * @return the chDateNexInc
	 */
	public LocalDate getChDateNexInc() {
		return chDateNexInc;
	}

	/**
	 * Sets the ch date nex inc.
	 *
	 * @param chDateNexInc the chDateNexInc to set
	 */
	public void setChDateNexInc(LocalDate chDateNexInc) {
		this.chDateNexInc = chDateNexInc;
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
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}





	public String getJrEmpName() {
		return jrEmpName;
	}

	public void setJrEmpName(String jrEmpName) {
		this.jrEmpName = jrEmpName;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(chBasicPay, chBeneEffDate, chCellId, chDateNexInc, chEmpClass, chEmpDsgn, chGrade,
				chGradePay, chPayBand, chPayBandValue, chPayLevel, chScale, curBasicPay, curCellId, curDateNextInc,
				curEmpClass, curEmpDsgn, curEmpId, curEmpNo, curGrade, curGradePay, curOffice, curPayBand,
				curPayBandValue, curPayLevel, curScale, eventEffectiveDate, eventOrderDate, eventOrderNo, jrBasicPay,
				jrCellId, jrDateNexInc, jrEmpClass, jrEmpDsgn, jrEmpId, jrEmpNo, jrGrade, jrGradePay, jrOfficeId,
				jrPayBand, jrPayBandValue, jrPayLevel, jrScale, officeId, payComm, stEventId, statusId,
				trnNo,steppingUpTypeId,jrEmpName,currentDetailsEventId,isPrintAble,approveDate,authorizeDate);
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
		if (!(obj instanceof PVUSteppingUpEventEntity)) {
			return false;
		}
		PVUSteppingUpEventEntity other = (PVUSteppingUpEventEntity) obj;
		return chBasicPay == other.chBasicPay && Objects.equals(chBeneEffDate, other.chBeneEffDate)
				&& Objects.equals(chCellId, other.chCellId) && Objects.equals(chDateNexInc, other.chDateNexInc)
				&& Objects.equals(chEmpClass, other.chEmpClass) && Objects.equals(chEmpDsgn, other.chEmpDsgn)
				&& chGrade == other.chGrade && Objects.equals(chGradePay, other.chGradePay)
				&& Objects.equals(chPayBand, other.chPayBand) && chPayBandValue == other.chPayBandValue
				&& Objects.equals(chPayLevel, other.chPayLevel) && Objects.equals(chScale , other.chScale)
				&& curBasicPay == other.curBasicPay && Objects.equals(curCellId, other.curCellId)
				&& Objects.equals(curDateNextInc, other.curDateNextInc)
				&& Objects.equals(curEmpClass, other.curEmpClass) && Objects.equals(curEmpDsgn, other.curEmpDsgn)
				&& Objects.equals(curEmpId, other.curEmpId) && curEmpNo == other.curEmpNo && curGrade == other.curGrade
				&& Objects.equals(curGradePay, other.curGradePay) && Objects.equals(curOffice, other.curOffice)
				&& Objects.equals(curPayBand, other.curPayBand) && curPayBandValue == other.curPayBandValue
				&& Objects.equals(curPayLevel, other.curPayLevel) && Objects.equals(curScale , other.curScale)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate)
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventOrderNo, other.eventOrderNo) && jrBasicPay == other.jrBasicPay
				&& Objects.equals(jrCellId, other.jrCellId) && Objects.equals(jrDateNexInc, other.jrDateNexInc)
				&& Objects.equals(jrEmpClass, other.jrEmpClass) && Objects.equals(jrEmpDsgn, other.jrEmpDsgn)
				&& Objects.equals(jrEmpId, other.jrEmpId) && jrEmpNo == other.jrEmpNo && jrGrade == other.jrGrade
				&& Objects.equals(jrGradePay, other.jrGradePay) && Objects.equals(jrOfficeId, other.jrOfficeId)
				&& Objects.equals(jrPayBand, other.jrPayBand) && jrPayBandValue == other.jrPayBandValue
				&& Objects.equals(jrPayLevel, other.jrPayLevel) && jrScale == other.jrScale
				&& Objects.equals(officeId, other.officeId) && Objects.equals(payComm, other.payComm)
				&& stEventId == other.stEventId && jrEmpName == other.jrEmpName
				&& Objects.equals(statusId, other.statusId)
				&& Objects.equals(trnNo, other.trnNo)   && Objects.equals(steppingUpTypeId, other.steppingUpTypeId)
				&& Objects.equals(currentDetailsEventId, other.currentDetailsEventId) && Objects.equals(isPrintAble, other.isPrintAble)
				&& Objects.equals(approveDate, other.approveDate)   && Objects.equals(authorizeDate, other.authorizeDate)   ;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUSteppingUpEventEntity [stEventId=" + stEventId + ", trnNo=" + trnNo + ", officeId=" + officeId
				+ ", eventOrderNo=" + eventOrderNo + ", eventOrderDate=" + eventOrderDate + ", eventEffectiveDate="
				+ eventEffectiveDate + ", payComm=" + payComm + ", curEmpNo=" + curEmpNo + ", curEmpId=" + curEmpId
				+ ", curEmpClass=" + curEmpClass + ", curEmpDsgn=" + curEmpDsgn + ", curOffice=" + curOffice
				+ ", curGrade=" + curGrade + ", curScale=" + curScale + ", curPayLevel=" + curPayLevel + ", curPayBand="
				+ curPayBand + ", curPayBandValue=" + curPayBandValue + ", curGradePay=" + curGradePay + ", curCellId="
				+ curCellId + ", curBasicPay=" + curBasicPay + ", curDateNextInc=" + curDateNextInc + ", jrEmpNo="
				+ jrEmpNo + ", jrEmpId=" + jrEmpId + ", jrEmpName=" + jrEmpName + ", jrEmpClass=" + jrEmpClass
				+ ", jrEmpDsgn=" + jrEmpDsgn + ", jrOfficeId=" + jrOfficeId + ", jrGrade=" + jrGrade + ", jrScale="
				+ jrScale + ", jrPayLevel=" + jrPayLevel + ", jrPayBand=" + jrPayBand + ", jrPayBandValue="
				+ jrPayBandValue + ", jrGradePay=" + jrGradePay + ", jrCellId=" + jrCellId + ", jrBasicPay="
				+ jrBasicPay + ", jrDateNexInc=" + jrDateNexInc + ", chEmpClass=" + chEmpClass + ", chEmpDsgn="
				+ chEmpDsgn + ", chGrade=" + chGrade + ", chScale=" + chScale + ", chPayLevel=" + chPayLevel
				+ ", chPayBand=" + chPayBand + ", chPayBandValue=" + chPayBandValue + ", chGradePay=" + chGradePay
				+ ", chCellId=" + chCellId + ", chBasicPay=" + chBasicPay + ", chDateNexInc=" + chDateNexInc
				+ ", chBeneEffDate=" + chBeneEffDate + ", statusId=" + statusId + ", steppingUpTypeId="
				+ steppingUpTypeId + ", currentDetailsEventId=" + currentDetailsEventId + ", isPrintAble=" + isPrintAble
				+ ", approveDate=" + approveDate + ", authorizeDate=" + authorizeDate + "]";
	}

	

}
