package gov.ifms.pvu.entity;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;


/**
 * The Class PVUEmployeAssuredCareerProgressionEntity.
 *
 * @version v 1.0
 * @created 2020/01/11 13:52:57
 */
@Entity
@Table(name = "T_PVU_AP_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUEmployeAssuredCareerProgressionEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	

	public PVUEmployeAssuredCareerProgressionEntity(Long id) {
		super();
		this.id = id;
	}

	/** The acp event id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_AP_EVNT_ID")
	private Long id;

	/** The trx no. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The office id. */
	@OneToOne(optional = false)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The pay commission. */
	@OneToOne(optional = false)
	@JoinColumn(name = "PAY_COMM", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payCommission;

	/** The acp order no. */
	@Column(name = "ACP_ORDER_NO")
	private String eventOrderNo;

	/** The event order date. */
	@Column(name = "EVNT_ORDER_DATE")
	private Date eventOrderDate;

	/** The event eff date. */
	@Column(name = "EVNT_EFF_DATE")
	private Date eventEffectiveDate;

	/**
	 * The pvu employe entity.
	 */
	@OneToOne
	@JoinColumn(name = "EMP_ID")
	private PVUEmployeEntity employeeNo;

	/** The dec reg prm. */
	@OneToOne(optional = false)
	@JoinColumn(name = "DEC_REG_PRM", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity decRegPrm;

	/**
	 * The pay level.
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity payLevel;

	/**
	 * The cell id.
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cellId;

	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private Long basicPay;

	/** The ben eff date. */
	@Column(name = "BEN_EFF_DATE")
	private Date benEffDate;

	/**
	 * The status id.
	 */
	@OneToOne(optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	
	@Column(name = "TYPE")
	private Long type;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ACP_TYPE", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity acpType;
	
	@Column(name = "CLASS_ID")
	private Long classId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity payScale;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IS_PRINTABLE")
	private EDPLuLookUpInfoEntity isPrintAble;
	

	public EDPLuLookUpInfoEntity getIsPrintAble() {
		return isPrintAble;
	}

	public void setIsPrintAble(EDPLuLookUpInfoEntity isPrintAble) {
		this.isPrintAble = isPrintAble;
	}

	@Column(name = "PAY_BAND_VALUE")
	private Long payBandValue;

	
	
	/** The autitor remarks. */
	@Column(name = "AUDITOR_REMARKS")
	private String auditorRemarks;

	/** The class two remarks. */
	@Column(name = "CLASS_II_REMARKS")
	private String classTwoRemarks;

	/** The print remarks. */
	@Column(name = "PRINT_REMARKS")
	private String printRemarks;

	@Column(name = "PRINT_COUNT")
	private Long printCount;
	
	/** The autdi return reason. */
	@Column(name = "AUDI_RET_RES")
	private Long auditorReturnReason;

	/** The class two return reason. */
	@Column(name = "CLASS_II_RET_RES")
	private Long classTwoReturnReason;

	/** The print return reason. */
	@Column(name = "PRINT_RET_RES")
	private String printReturnReason;
	
    /** The approve date. */
    @Column(name = "APPR_DATE")
    private LocalDateTime approveDate;
    
    
    /** The approve date. */
    @Column(name = "DATE_NXT_INCR")
    private Date dateOfNextIncrement;

    /** The authorize date. */
    @Column(name = "AUTH_DATE")
    private LocalDateTime authorizeDate;
    
    @Column(name = "CURRENT_DETAILS_EVENT_ID")
    private Long currentDetailsEventId;
    
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity cPayBandId;

	@Column(name = "C_PAY_BAND_VALUE")
	private Long cPayBandValue;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity cGradePayId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity cPayScale;
	
	@Column(name = "C_BASIC_PAY")
	private Long cBasicPay;
	
	@Column(name = "C_CLASS_ID")
	private Long cClassId;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity gradePay;
	
	/** The pay band. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_BAND", nullable = false, referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity payBand;
	
	@Column(name = "CLASS_ONE_RETURN_REASON")
	private Long classOneReturnReason;
	
	@Column(name = "INIT_DATE")
	private LocalDateTime initDate;
	
	@Column(name = "VERIFIER_RETURN_REASON")
	private Long verifierReturnReason;
	
	@Column(name = "VERIFIER_REMARKS")
	private String verifierRemarks;
	
	@Column(name = "CLASS_ONE_REMARKS")
	private String classOneRemarks;
	
	/** The init date. */
	@Column(name = "AUTHORIZE_BY")
	private Long authorizeBy;

	/** The init date. */
	@Column(name = "AUTHORIZER_REMARK")
	private String authorizerRemark;
	
//	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;
	
	@Column(name = "REF_DATE")
    private LocalDateTime refDate;


	@Column(name = "C_DATE_NEXT_INC")
	private Date cDateOfNextIncrement;

	public Date getcDateOfNextIncrement() {
		return cDateOfNextIncrement;
	}

	public void setcDateOfNextIncrement(Date cDateOfNextIncrement) {
		this.cDateOfNextIncrement = cDateOfNextIncrement;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getcClassId() {
		return cClassId;
	}

	public void setcClassId(Long cClassId) {
		this.cClassId = cClassId;
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
	 * @return the gradePay
	 */
	public PVUMsGradePayEntity getGradePay() {
		return gradePay;
	}

	/**
	 * @param gradePay the gradePay to set
	 */
	public void setGradePay(PVUMsGradePayEntity gradePay) {
		this.gradePay = gradePay;
	}

	/**
	 * @return the payBand
	 */
	public PVUMsPayBandEntity getPayBand() {
		return payBand;
	}

	/**
	 * @param payBand the payBand to set
	 */
	public void setPayBand(PVUMsPayBandEntity payBand) {
		this.payBand = payBand;
	}

	/**
	 * @return the cPayScale
	 */
	public PVUMsPayScaleEntity getcPayScale() {
		return cPayScale;
	}

	/**
	 * @param cPayScale the cPayScale to set
	 */
	public void setcPayScale(PVUMsPayScaleEntity cPayScale) {
		this.cPayScale = cPayScale;
	}

	/**
	 * @return the cPayBandId
	 */
	public PVUMsPayBandEntity getcPayBandId() {
		return cPayBandId;
	}

	/**
	 * @param cPayBandId the cPayBandId to set
	 */
	public void setcPayBandId(PVUMsPayBandEntity cPayBandId) {
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
	public PVUMsGradePayEntity getcGradePayId() {
		return cGradePayId;
	}

	/**
	 * @param cGradePayId the cGradePayId to set
	 */
	public void setcGradePayId(PVUMsGradePayEntity cGradePayId) {
		this.cGradePayId = cGradePayId;
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

	

	
	public Date getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	public void setDateOfNextIncrement(Date dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	public LocalDateTime getAuthorizeDate() {
		return authorizeDate;
	}

	public void setAuthorizeDate(LocalDateTime authorizeDate) {
		this.authorizeDate = authorizeDate;
	}

	public LocalDateTime getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
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
	 * PVUEmployeAssuredCareerProgressionEntity Constructor.
	 */
	public PVUEmployeAssuredCareerProgressionEntity() {
		super();
	}

	/**
	 * Gets the acp event id.
	 *
	 * @return the acpEventId
	 */
	public Long getId() {
		return id;
	}
/**
	 * Sets the acp event id.
	 *
	 * @param id the acpEventId to set
	 */

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the trx no.
	 *
	 * @return the trxNo
	 */
	public String getTrnNo() {
		return trnNo;
	}
	/**
	 * Sets the trx no.
	 *
	 * @param trnNo the trxNo to set
	 *
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}



	public static long getSerialVersionUID() {
		return serialVersionUID;
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
	 * Gets the pay commission.
	 *
	 * @return the payCommission
	 */
	public EDPLuLookUpInfoEntity getPayCommission() {
		return payCommission;
	}

	/**
	 * Sets the pay commission.
	 *
	 * @param payCommission the payCommission to set
	 */
	public void setPayCommission(EDPLuLookUpInfoEntity payCommission) {
		this.payCommission = payCommission;
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
	 * Gets the event order date.
	 *
	 * @return the eventOrderDate
	 */
	public Date getEventOrderDate() {
		return eventOrderDate;
	}

	/**
	 * Sets the event order date.
	 *
	 * @param eventOrderDate the eventOrderDate to set
	 */
	public void setEventOrderDate(Date eventOrderDate) {
		this.eventOrderDate = eventOrderDate;
	}

	/**
	 * Gets the event eff date.
	 *
	 * @return the eventEffDate
	 */
	public Date getEventEffectiveDate() {
		return eventEffectiveDate;
	}

	/**
	 * Sets the event eff date.
	 *
	 * @param eventEffectiveDate the eventEffDate to set
	 */
	public void setEventEffectiveDate(Date eventEffectiveDate) {
		this.eventEffectiveDate = eventEffectiveDate;
	}

	

	/**
	 * Gets the dec reg prm.
	 *
	 * @return the decRegPrm
	 */
	public EDPLuLookUpInfoEntity getDecRegPrm() {
		return decRegPrm;
	}

	/**
	 * Sets the dec reg prm.
	 *
	 * @param decRegPrm the decRegPrm to set
	 */
	public void setDecRegPrm(EDPLuLookUpInfoEntity decRegPrm) {
		this.decRegPrm = decRegPrm;
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
	 * Gets the basic pay.
	 *
	 * @return the basicPay
	 */
	public Long getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(Long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Gets the ben eff date.
	 *
	 * @return the benEffDate
	 */
	public Date getBenEffDate() {
		return benEffDate;
	}

	/**
	 * Sets the ben eff date.
	 *
	 * @param benEffDate the benEffDate to set
	 */
	public void setBenEffDate(Date benEffDate) {
		this.benEffDate = benEffDate;
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

	

	/**
	 * @return the type
	 */
	public Long getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Long type) {
		this.type = type;
	}

	public EDPLuLookUpInfoEntity getAcpType() {
		return acpType;
	}

	public void setAcpType(EDPLuLookUpInfoEntity acpType) {
		this.acpType = acpType;
	}

	/**
	 * @return the classId
	 */
	public Long getClassId() {
		return classId;
	}

	/**
	 * @param classId the classId to set
	 */
	public void setClassId(Long classId) {
		this.classId = classId;
	}

	

	public PVUMsPayScaleEntity getPayScale() {
		return payScale;
	}

	public void setPayScale(PVUMsPayScaleEntity payScale) {
		this.payScale = payScale;
	}

	/**
	 * @return the employeeNo
	 */
	public PVUEmployeEntity getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(PVUEmployeEntity employeeNo) {
		this.employeeNo = employeeNo;
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


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUEmployeAssuredCareerProgressionEntity)) return false;
		PVUEmployeAssuredCareerProgressionEntity that = (PVUEmployeAssuredCareerProgressionEntity) o;
		return Objects.equals(getId(), that.getId()) &&
				Objects.equals(getTrnNo(), that.getTrnNo()) &&
				Objects.equals(getOfficeId(), that.getOfficeId()) &&
				Objects.equals(getPayCommission(), that.getPayCommission()) &&
				Objects.equals(getEventOrderNo(), that.getEventOrderNo()) &&
				Objects.equals(getEventOrderDate(), that.getEventOrderDate()) &&
				Objects.equals(getEventEffectiveDate(), that.getEventEffectiveDate()) &&
				Objects.equals(getEmployeeNo(), that.getEmployeeNo()) &&
				Objects.equals(getDecRegPrm(), that.getDecRegPrm()) &&
				Objects.equals(getPayLevel(), that.getPayLevel()) &&
				Objects.equals(getCellId(), that.getCellId()) &&
				Objects.equals(getBasicPay(), that.getBasicPay()) &&
				Objects.equals(getBenEffDate(), that.getBenEffDate()) &&
				Objects.equals(getStatusId(), that.getStatusId()) &&
				Objects.equals(getType(), that.getType()) &&
				Objects.equals(getAcpType(), that.getAcpType()) &&
				Objects.equals(getClassId(), that.getClassId()) &&
				Objects.equals(getPayScale(), that.getPayScale()) &&
				Objects.equals(getIsPrintAble(), that.getIsPrintAble()) &&
				Objects.equals(getPayBandValue(), that.getPayBandValue()) &&
				Objects.equals(getAuditorRemarks(), that.getAuditorRemarks()) &&
				Objects.equals(getClassTwoRemarks(), that.getClassTwoRemarks()) &&
				Objects.equals(getPrintRemarks(), that.getPrintRemarks()) &&
				Objects.equals(getPrintCount(), that.getPrintCount()) &&
				Objects.equals(getAuditorReturnReason(), that.getAuditorReturnReason()) &&
				Objects.equals(getClassTwoReturnReason(), that.getClassTwoReturnReason()) &&
				Objects.equals(getPrintReturnReason(), that.getPrintReturnReason()) &&
				Objects.equals(getApproveDate(), that.getApproveDate()) &&
				Objects.equals(getDateOfNextIncrement(), that.getDateOfNextIncrement()) &&
				Objects.equals(getAuthorizeDate(), that.getAuthorizeDate()) &&
				Objects.equals(getCurrentDetailsEventId(), that.getCurrentDetailsEventId()) &&
				Objects.equals(getcPayBandId(), that.getcPayBandId()) &&
				Objects.equals(getcPayBandValue(), that.getcPayBandValue()) &&
				Objects.equals(getcGradePayId(), that.getcGradePayId()) &&
				Objects.equals(getcPayScale(), that.getcPayScale()) &&
				Objects.equals(getcBasicPay(), that.getcBasicPay()) &&
				Objects.equals(getcClassId(), that.getcClassId()) &&
				Objects.equals(getGradePay(), that.getGradePay()) &&
				Objects.equals(getPayBand(), that.getPayBand()) &&
				Objects.equals(getClassOneReturnReason(), that.getClassOneReturnReason()) &&
				Objects.equals(getInitDate(), that.getInitDate()) &&
				Objects.equals(getVerifierReturnReason(), that.getVerifierReturnReason()) &&
				Objects.equals(getVerifierRemarks(), that.getVerifierRemarks()) &&
				Objects.equals(getClassOneRemarks(), that.getClassOneRemarks()) &&
				Objects.equals(getAuthorizeBy(), that.getAuthorizeBy()) &&
				Objects.equals(getAuthorizerRemark(), that.getAuthorizerRemark()) &&
				Objects.equals(getRemarks(), that.getRemarks()) &&
				Objects.equals(getRefDate(), that.getRefDate()) &&
				Objects.equals(getcDateOfNextIncrement(), that.getcDateOfNextIncrement());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getTrnNo(), getOfficeId(), getPayCommission(), getEventOrderNo(), getEventOrderDate(), getEventEffectiveDate(), getEmployeeNo(), getDecRegPrm(), getPayLevel(), getCellId(), getBasicPay(), getBenEffDate(), getStatusId(), getType(), getAcpType(), getClassId(), getPayScale(), getIsPrintAble(), getPayBandValue(), getAuditorRemarks(), getClassTwoRemarks(), getPrintRemarks(), getPrintCount(), getAuditorReturnReason(), getClassTwoReturnReason(), getPrintReturnReason(), getApproveDate(), getDateOfNextIncrement(), getAuthorizeDate(), getCurrentDetailsEventId(), getcPayBandId(), getcPayBandValue(), getcGradePayId(), getcPayScale(), getcBasicPay(), getcClassId(), getGradePay(), getPayBand(), getClassOneReturnReason(), getInitDate(), getVerifierReturnReason(), getVerifierRemarks(), getClassOneRemarks(), getAuthorizeBy(), getAuthorizerRemark(), getRemarks(), getRefDate(), getcDateOfNextIncrement());
	}
}
