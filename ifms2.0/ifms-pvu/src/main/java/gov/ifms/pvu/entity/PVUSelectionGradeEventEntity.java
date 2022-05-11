package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;

/**
 * The Class PVUSelectionGradeEventEntity.
 *
 * @version v 1.0
 * @created 2019/12/18 11:56:47
 *
 */
@Entity
@Table(name = "T_PVU_SG_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUSelectionGradeEventEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_SG_EVNT_ID")
	private long id;

	/** The trn no. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The office id. */
	@ManyToOne
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The pay comm. */
	@ManyToOne
	@JoinColumn(name = "PAY_COMM", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payComm;

	/** The event order no. */
	@Column(name = "EVNT_ORDER_NO")
	private String eventOrderNo;

	/** The event order date. */
	@Column(name = "EVNT_ORDER_DATE")
	private LocalDate eventOrderDate;

	/** The event effective date. */
	@Column(name = "EVNT_EFF_DATE")
	private LocalDate eventEffectiveDate;

	/** The designation id. */

	@OneToOne
	@JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	/** The cur pay band. */
	@ManyToOne
	@JoinColumn(name = "PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity payBand;

	/** The pay band value. */
	@Column(name = "PAY_BAND_VALUE")
	private Long payBandValue;

	/** The grade pay. */
	@ManyToOne
	@JoinColumn(name = "GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity gradePay;

	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private long basicPay;

	/** The pay level. */
	@ManyToOne
	@JoinColumn(name = "PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity payLevel;

	/** The cur cell id. */
	@ManyToOne
	@JoinColumn(name = "CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cellId;

	/** The bene effict date. */
	@Column(name = "BENE_EFF_DATE")
	private LocalDate beneEffictDate;

	/** The date of next increment. */
	@Column(name = "DATE_NXT_INCR")
	private LocalDate dateOfNextIncrement;

	/** The personal pay. */
	@Column(name = "PERSONAL_PAY")
	private String personalPay;

	/** The employee no. */
	@Column(name = "EMPLOYEE_NO")
	private Long employeeNo;

	/** The pay scale. */
	@Column(name = "PAY_SCALE")
	private Long payScale;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The emp id. */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity empId;

	/** The status id. */
	@ManyToOne
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The approve date. */
	@Column(name = "APPR_DATE")
	private LocalDateTime approveDate;

	/** The authorize date. */
	@Column(name = "AUTH_DATE")
	private Date authorizeDate;

	@Column(name = "CURRENT_DETAILS_EVENT_ID")
	private Long currentDetailsEventId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IS_PRINTABLE")
	private EDPLuLookUpInfoEntity isPrintAble;

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

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_PAY_LEVEL", nullable = true, referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity cPayLevelId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cCellId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity cPayBandId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity cGradePayId;

	@Column(name = "C_PAY_BAND_VALUE")
	private Long cPayBandValue;

	@Column(name = "C_BASIC_PAY")
	private Long cBasicPay;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity cPayScale;
	
	@ManyToOne
	@JoinColumn(name = "C_CLASS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity cClass;
	
	@Column(name = "C_DATE_NXT_INC")
	private LocalDate cDateOfNextIncrement;
	
	@ManyToOne
	@JoinColumn(name = "C_OFFICE", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity cOfficeId;
	
	@ManyToOne
	@JoinColumn(name = "C_DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity cDesignation;

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

	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	public EDPLuLookUpInfoEntity getPayComm() {
		return payComm;
	}

	public void setPayComm(EDPLuLookUpInfoEntity payComm) {
		this.payComm = payComm;
	}

	public String getEventOrderNo() {
		return eventOrderNo;
	}

	public void setEventOrderNo(String eventOrderNo) {
		this.eventOrderNo = eventOrderNo;
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

	public EDPMsDesignationEntity getDesignationId() {
		return designationId;
	}

	public void setDesignationId(EDPMsDesignationEntity designationId) {
		this.designationId = designationId;
	}

	public PVUMsPayBandEntity getPayBand() {
		return payBand;
	}

	public void setPayBand(PVUMsPayBandEntity payBand) {
		this.payBand = payBand;
	}

	public Long getPayBandValue() {
		return payBandValue;
	}

	public void setPayBandValue(Long payBandValue) {
		this.payBandValue = payBandValue;
	}

	public PVUMsGradePayEntity getGradePay() {
		return gradePay;
	}

	public void setGradePay(PVUMsGradePayEntity gradePay) {
		this.gradePay = gradePay;
	}

	public long getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(long basicPay) {
		this.basicPay = basicPay;
	}

	public PVUMsPayLevelEntity getPayLevel() {
		return payLevel;
	}

	public void setPayLevel(PVUMsPayLevelEntity payLevel) {
		this.payLevel = payLevel;
	}

	public PVUMsPayCellEntity getCellId() {
		return cellId;
	}

	public void setCellId(PVUMsPayCellEntity cellId) {
		this.cellId = cellId;
	}

	public LocalDate getBeneEffictDate() {
		return beneEffictDate;
	}

	public void setBeneEffictDate(LocalDate beneEffictDate) {
		this.beneEffictDate = beneEffictDate;
	}

	public LocalDate getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	public String getPersonalPay() {
		return personalPay;
	}

	public void setPersonalPay(String personalPay) {
		this.personalPay = personalPay;
	}

	public Long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}

	public Long getPayScale() {
		return payScale;
	}

	public void setPayScale(Long payScale) {
		this.payScale = payScale;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public PVUEmployeEntity getEmpId() {
		return empId;
	}

	public void setEmpId(PVUEmployeEntity empId) {
		this.empId = empId;
	}

	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	public LocalDateTime getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(LocalDateTime approveDate) {
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

	public LocalDateTime getInitDate() {
		return initDate;
	}

	public void setInitDate(LocalDateTime initDate) {
		this.initDate = initDate;
	}

	public PVUSelectionGradeEventEntity(long id) {
		super();
		this.id = id;
	}

	public PVUSelectionGradeEventEntity() {
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

	public PVUMsPayLevelEntity getcPayLevelId() {
		return cPayLevelId;
	}

	public void setcPayLevelId(PVUMsPayLevelEntity cPayLevelId) {
		this.cPayLevelId = cPayLevelId;
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

	public PVUMsGradePayEntity getcGradePayId() {
		return cGradePayId;
	}

	public void setcGradePayId(PVUMsGradePayEntity cGradePayId) {
		this.cGradePayId = cGradePayId;
	}

	public Long getcPayBandValue() {
		return cPayBandValue;
	}

	public void setcPayBandValue(Long cPayBandValue) {
		this.cPayBandValue = cPayBandValue;
	}

	public Long getcBasicPay() {
		return cBasicPay;
	}

	public void setcBasicPay(Long cBasicPay) {
		this.cBasicPay = cBasicPay;
	}

	public PVUMsPayScaleEntity getcPayScale() {
		return cPayScale;
	}

	public void setcPayScale(PVUMsPayScaleEntity cPayScale) {
		this.cPayScale = cPayScale;
	}

	public EDPLuLookUpInfoEntity getcClass() {
		return cClass;
	}

	public void setcClass(EDPLuLookUpInfoEntity cClass) {
		this.cClass = cClass;
	}

	public LocalDate getcDateOfNextIncrement() {
		return cDateOfNextIncrement;
	}

	public void setcDateOfNextIncrement(LocalDate cDateOfNextIncrement) {
		this.cDateOfNextIncrement = cDateOfNextIncrement;
	}

	public EDPMsOfficeEntity getcOfficeId() {
		return cOfficeId;
	}

	public void setcOfficeId(EDPMsOfficeEntity cOfficeId) {
		this.cOfficeId = cOfficeId;
	}

	public EDPMsDesignationEntity getcDesignation() {
		return cDesignation;
	}

	public void setcDesignation(EDPMsDesignationEntity cDesignation) {
		this.cDesignation = cDesignation;
	}
	
}
