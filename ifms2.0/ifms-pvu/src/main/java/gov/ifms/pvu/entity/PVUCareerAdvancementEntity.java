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
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.common.PVUCurrentEntity;

/**
 * The Class PVUCarrearAdvancementEntity.
 * 
 * @version v 1.0
 * @created 2020/01/09 11:46:59
 *
 */
@Entity
@Table(name = "T_PVU_CA_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUCareerAdvancementEntity extends PVUCurrentEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_CA_EVNT_ID")
	private long id;

	/** The trn no. */
	@Column(name = "trnNo")
	private String trnNo;

	/** The office id. */
	@ManyToOne
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The pay comm. */
	@ManyToOne
	@JoinColumn(name = "PAY_COMM", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payCommId;

	/** The event order no. */
	@Column(name = "EVNT_ORDER_NO")
	private String eventOrderNo;

	/** The event order date. */
	@Column(name = "EVNT_ORDER_DATE")
	private LocalDate eventOrderDate;

	/** The event effective date. */
	@Column(name = "EVNT_EFF_DATE")
	private LocalDate eventEffectiveDate;

	/** The adv sch type. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_ADV_SCH_TYPE", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity advSchType;

	/** The designation id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	/** The relationship. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UNI_APP_LECT_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity uniAppLectType;

	/** The relationship. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OPT_AVAIL", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity optionAvailableId;

	/** The option available date. */
	@Column(name = "OPT_DATE")
	private LocalDate optionAvailableDate;

	/** The relationship. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ORI_COUR_ATTE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity oriCourAtte;

	/** The ori cert date. */
	@Column(name = "ORI_CERT_DATE")
	private LocalDate oriCertDate;

	/** The bene effict date. */
	@Column(name = "BENE_EFF_DATE")
	private LocalDate beneEffictDate;

	/** The date of next increment. */
	@Column(name = "DATE_NXT_INCR")
	private LocalDate dateOfNextIncrement;

	/** The ref cour atte. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "REF_COUR_ATTE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity refCourAtte;

	/** The ref cert date. */
	@Column(name = "REF_CERT_DATE")
	private LocalDate refCertDate;

	/** The pay scale. */
	@ManyToOne
	@JoinColumn(name = "PAY_SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity payScale;

	/** The grade pay. */
	@ManyToOne
	@JoinColumn(name = "GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity gradePayId;

	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private long basicPay;

	/** The cur pay band. */
	@ManyToOne
	@JoinColumn(name = "PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity payBandId;

	/** The pay band value. */
	@Column(name = "PAY_BAND_VALUE")
	private long payBandValue;

	/** The pay level. */
	@ManyToOne
	@JoinColumn(name = "PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity payLevelId;

	/** The cell id. */
	@ManyToOne
	@JoinColumn(name = "CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cellId;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;
	
	/** The c Employee No. */
	@Column(name = "C_EMPLOYEE_NO")
	private Long employeeNo;
	
	/** The c Employee Name. */
	@Column(name = "C_EMPLOYEE_NAME")
	private String cEmployeeName;

	@ManyToOne
	@JoinColumn(name = "PVU_EVENT_ID", referencedColumnName = "MS_PVU_EVENTS_ID")
	private PVUMsEventEntity event;

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
	private int printCount;

	@Column(name = "REF_DATE")
	private LocalDateTime refDate;

	/** The init date. */
	@Column(name = "AUTHORIZE_BY")
	private Long authorizeBy;

	/** The init date. */
	@Column(name = "AUTHORIZER_REMARK")
	private String authorizerRemark;

	@Column(name = "CONSIGNMENT_NUMBER")
	private String consignmentNumber;
	
	
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



	public PVUMsEventEntity getEvent() {
		return event;
	}

	public void setEvent(PVUMsEventEntity event) {
		this.event = event;
	}

	/**
	 * Instantiates a new PVU career advancement entity.
	 */
	public PVUCareerAdvancementEntity() {
		super();
	}

	/**
	 * Instantiates a new PVU career advancement entity.
	 *
	 * @param id the id
	 */
	public PVUCareerAdvancementEntity(long id) {
		super();
		this.id = id;
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

	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	public EDPLuLookUpInfoEntity getPayCommId() {
		return payCommId;
	}

	public void setPayCommId(EDPLuLookUpInfoEntity payCommId) {
		this.payCommId = payCommId;
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

	public EDPLuLookUpInfoEntity getAdvSchType() {
		return advSchType;
	}

	public void setAdvSchType(EDPLuLookUpInfoEntity advSchType) {
		this.advSchType = advSchType;
	}

	public EDPMsDesignationEntity getDesignationId() {
		return designationId;
	}

	public void setDesignationId(EDPMsDesignationEntity designationId) {
		this.designationId = designationId;
	}

	public EDPLuLookUpInfoEntity getUniAppLectType() {
		return uniAppLectType;
	}

	public void setUniAppLectType(EDPLuLookUpInfoEntity uniAppLectType) {
		this.uniAppLectType = uniAppLectType;
	}

	public EDPLuLookUpInfoEntity getOptionAvailableId() {
		return optionAvailableId;
	}

	public void setOptionAvailableId(EDPLuLookUpInfoEntity optionAvailableId) {
		this.optionAvailableId = optionAvailableId;
	}

	public LocalDate getOptionAvailableDate() {
		return optionAvailableDate;
	}

	public void setOptionAvailableDate(LocalDate optionAvailableDate) {
		this.optionAvailableDate = optionAvailableDate;
	}

	public EDPLuLookUpInfoEntity getOriCourAtte() {
		return oriCourAtte;
	}

	public void setOriCourAtte(EDPLuLookUpInfoEntity oriCourAtte) {
		this.oriCourAtte = oriCourAtte;
	}

	public LocalDate getOriCertDate() {
		return oriCertDate;
	}

	public void setOriCertDate(LocalDate oriCertDate) {
		this.oriCertDate = oriCertDate;
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

	public EDPLuLookUpInfoEntity getRefCourAtte() {
		return refCourAtte;
	}

	public void setRefCourAtte(EDPLuLookUpInfoEntity refCourAtte) {
		this.refCourAtte = refCourAtte;
	}

	public LocalDate getRefCertDate() {
		return refCertDate;
	}

	public void setRefCertDate(LocalDate refCertDate) {
		this.refCertDate = refCertDate;
	}

	public PVUMsPayScaleEntity getPayScale() {
		return payScale;
	}

	public void setPayScale(PVUMsPayScaleEntity payScale) {
		this.payScale = payScale;
	}

	public PVUMsGradePayEntity getGradePayId() {
		return gradePayId;
	}

	public void setGradePayId(PVUMsGradePayEntity gradePayId) {
		this.gradePayId = gradePayId;
	}

	public long getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(long basicPay) {
		this.basicPay = basicPay;
	}

	public PVUMsPayBandEntity getPayBandId() {
		return payBandId;
	}

	public void setPayBandId(PVUMsPayBandEntity payBandId) {
		this.payBandId = payBandId;
	}

	public long getPayBandValue() {
		return payBandValue;
	}

	public void setPayBandValue(long payBandValue) {
		this.payBandValue = payBandValue;
	}

	public PVUMsPayLevelEntity getPayLevelId() {
		return payLevelId;
	}

	public void setPayLevelId(PVUMsPayLevelEntity payLevelId) {
		this.payLevelId = payLevelId;
	}

	public PVUMsPayCellEntity getCellId() {
		return cellId;
	}

	public void setCellId(PVUMsPayCellEntity cellId) {
		this.cellId = cellId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	public Long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getcEmployeeName() {
		return cEmployeeName;
	}

	public void setcEmployeeName(String cEmployeeName) {
		this.cEmployeeName = cEmployeeName;
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

	public int getPrintCount() {
		return printCount;
	}

	public void setPrintCount(int printCount) {
		this.printCount = printCount;
	}

	public LocalDateTime getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
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

	public EDPLuLookUpInfoEntity getIsPrintAble() {
		return isPrintAble;
	}

	public void setIsPrintAble(EDPLuLookUpInfoEntity isPrintAble) {
		this.isPrintAble = isPrintAble;
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

	public String getConsignmentNumber() {
		return consignmentNumber;
	}

	public void setConsignmentNumber(String consignmentNumber) {
		this.consignmentNumber = consignmentNumber;
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUCareerAdvancementEntity)) return false;
		PVUCareerAdvancementEntity that = (PVUCareerAdvancementEntity) o;
		return getId() == that.getId() &&
				getBasicPay() == that.getBasicPay() &&
				getPayBandValue() == that.getPayBandValue() &&
				getcPayBandValue() == that.getcPayBandValue() &&
				getcBasicPay() == that.getcBasicPay() &&
				getPrintCount() == that.getPrintCount() &&
				Objects.equals(getTrnNo(), that.getTrnNo()) &&
				Objects.equals(getOfficeId(), that.getOfficeId()) &&
				Objects.equals(getPayCommId(), that.getPayCommId()) &&
				Objects.equals(getEventOrderNo(), that.getEventOrderNo()) &&
				Objects.equals(getEventOrderDate(), that.getEventOrderDate()) &&
				Objects.equals(getEventEffectiveDate(), that.getEventEffectiveDate()) &&
				Objects.equals(getAdvSchType(), that.getAdvSchType()) &&
				Objects.equals(getDesignationId(), that.getDesignationId()) &&
				Objects.equals(getUniAppLectType(), that.getUniAppLectType()) &&
				Objects.equals(getOptionAvailableId(), that.getOptionAvailableId()) &&
				Objects.equals(getOptionAvailableDate(), that.getOptionAvailableDate()) &&
				Objects.equals(getOriCourAtte(), that.getOriCourAtte()) &&
				Objects.equals(getOriCertDate(), that.getOriCertDate()) &&
				Objects.equals(getBeneEffictDate(), that.getBeneEffictDate()) &&
				Objects.equals(getDateOfNextIncrement(), that.getDateOfNextIncrement()) &&
				Objects.equals(getRefCourAtte(), that.getRefCourAtte()) &&
				Objects.equals(getRefCertDate(), that.getRefCertDate()) &&
				Objects.equals(getPayScale(), that.getPayScale()) &&
				Objects.equals(getGradePayId(), that.getGradePayId()) &&
				Objects.equals(getPayBandId(), that.getPayBandId()) &&
				Objects.equals(getPayLevelId(), that.getPayLevelId()) &&
				Objects.equals(getCellId(), that.getCellId()) &&
				Objects.equals(getRemarks(), that.getRemarks()) &&
				Objects.equals(getStatusId(), that.getStatusId()) &&
				Objects.equals(getEmployeeNo(), that.getEmployeeNo()) &&
				Objects.equals(getcEmployeeName(), that.getcEmployeeName()) &&
				Objects.equals(getcPayBand(), that.getcPayBand()) &&
				Objects.equals(getcGradePay(), that.getcGradePay()) &&
				Objects.equals(getcPayLevel(), that.getcPayLevel()) &&
				Objects.equals(getCurrentDetailsEventId(), that.getCurrentDetailsEventId()) &&
				Objects.equals(getEvent(), that.getEvent()) &&
				Objects.equals(getApproveDate(), that.getApproveDate()) &&
				Objects.equals(getAuthorizeDate(), that.getAuthorizeDate()) &&
				Objects.equals(getIsPrintAble(), that.getIsPrintAble()) &&
				Objects.equals(getAuditorRemarks(), that.getAuditorRemarks()) &&
				Objects.equals(getVerifierRemarks(), that.getVerifierRemarks()) &&
				Objects.equals(getClassTwoRemarks(), that.getClassTwoRemarks()) &&
				Objects.equals(getClassOneRemarks(), that.getClassOneRemarks()) &&
				Objects.equals(getPrintRemarks(), that.getPrintRemarks()) &&
				Objects.equals(getAuditorReturnReason(), that.getAuditorReturnReason()) &&
				Objects.equals(getVerifierReturnReason(), that.getVerifierReturnReason()) &&
				Objects.equals(getClassTwoReturnReason(), that.getClassTwoReturnReason()) &&
				Objects.equals(getClassOneReturnReason(), that.getClassOneReturnReason()) &&
				Objects.equals(getPrintReturnReason(), that.getPrintReturnReason()) &&
				Objects.equals(getRefDate(), that.getRefDate()) &&
				Objects.equals(getAuthorizeBy(), that.getAuthorizeBy()) &&
				Objects.equals(getAuthorizerRemark(), that.getAuthorizerRemark()) &&
				Objects.equals(getConsignmentNumber(), that.getConsignmentNumber())
				&& Objects.equals(oaBasicPayValue, that.oaBasicPayValue)
				&& Objects.equals(oaCellIdValue, that.oaCellIdValue)
				&& Objects.equals(oaGradePayId, that.oaGradePayId)
				&& Objects.equals(oaPayBandId, that.oaPayBandId)
				&& Objects.equals(oaPayBandValue, that.oaPayBandValue)
				&& Objects.equals(oaPayCellId, that.oaPayCellId)
				&& Objects.equals(oaPayLevelId, that.oaPayLevelId)
				&& Objects.equals(oaPayScaleId, that.oaPayScaleId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getTrnNo(), getOfficeId(), getPayCommId(), getEventOrderNo(), getEventOrderDate(), getEventEffectiveDate(),
				getAdvSchType(), getDesignationId(), getUniAppLectType(), getOptionAvailableId(), getOptionAvailableDate(), getOriCourAtte(),
				getOriCertDate(), getBeneEffictDate(), getDateOfNextIncrement(), getRefCourAtte(), getRefCertDate(), getPayScale(), getGradePayId(),
				getBasicPay(), getPayBandId(), getPayBandValue(), getPayLevelId(), getCellId(), getRemarks(), getStatusId(), getEmployeeNo(),
				getcEmployeeName(), getcPayBand(), getcPayBandValue(), getcGradePay(), getcPayLevel(), getcBasicPay(), getCurrentDetailsEventId(),
				getEvent(), getApproveDate(), getAuthorizeDate(), getIsPrintAble(), getAuditorRemarks(), getVerifierRemarks(), getClassTwoRemarks(),
				getClassOneRemarks(), getPrintRemarks(), getAuditorReturnReason(), getVerifierReturnReason(), getClassTwoReturnReason(),
				getClassOneReturnReason(), getPrintReturnReason(), getPrintCount(), getRefDate(), getAuthorizeBy(), getAuthorizerRemark(), getConsignmentNumber(),
				oaCellIdValue, oaBasicPayValue, oaGradePayId, oaPayBandId, oaPayBandValue, oaPayCellId, oaPayScaleId, oaPayLevelId);
	}

	@Override
	public String toString() {
		return "PVUCareerAdvancementEntity [id=" + id + ", trnNo=" + trnNo + ", officeId=" + officeId + ", payCommId="
				+ payCommId + ", eventOrderNo=" + eventOrderNo + ", eventOrderDate=" + eventOrderDate
				+ ", eventEffectiveDate=" + eventEffectiveDate + ", advSchType=" + advSchType + ", designationId="
				+ designationId + ", uniAppLectType=" + uniAppLectType + ", optionAvailableId=" + optionAvailableId
				+ ", optionAvailableDate=" + optionAvailableDate + ", oriCourAtte=" + oriCourAtte + ", oriCertDate="
				+ oriCertDate + ", beneEffictDate=" + beneEffictDate + ", dateOfNextIncrement=" + dateOfNextIncrement
				+ ", refCourAtte=" + refCourAtte + ", refCertDate=" + refCertDate + ", payScale=" + payScale
				+ ", gradePayId=" + gradePayId + ", basicPay=" + basicPay + ", payBandId=" + payBandId
				+ ", payBandValue=" + payBandValue + ", payLevelId=" + payLevelId + ", cellId=" + cellId + ", remarks="
				+ remarks + ", statusId=" + statusId + ", employeeNo=" + employeeNo + ", cEmployeeName=" + cEmployeeName
				+ ", event=" + event + ", approveDate=" + approveDate + ", authorizeDate=" + authorizeDate
				+ ", isPrintAble=" + isPrintAble + ", auditorRemarks=" + auditorRemarks + ", verifierRemarks="
				+ verifierRemarks + ", classTwoRemarks=" + classTwoRemarks + ", classOneRemarks=" + classOneRemarks
				+ ", printRemarks=" + printRemarks + ", auditorReturnReason=" + auditorReturnReason
				+ ", verifierReturnReason=" + verifierReturnReason + ", classTwoReturnReason=" + classTwoReturnReason
				+ ", classOneReturnReason=" + classOneReturnReason + ", printReturnReason=" + printReturnReason
				+ ", printCount=" + printCount + ", refDate=" + refDate + ", authorizeBy=" + authorizeBy
				+ ", authorizerRemark=" + authorizerRemark + ", consignmentNumber=" + consignmentNumber
				+ ", oaBasicPayValue=" + oaBasicPayValue + ", oaPayScaleId=" + oaPayScaleId + ", oaPayBandId="
				+ oaPayBandId + ", oaPayBandValue=" + oaPayBandValue + ", oaGradePayId=" + oaGradePayId
				+ ", oaPayLevelId=" + oaPayLevelId + ", oaCellIdValue=" + oaCellIdValue + ", oaPayCellId=" + oaPayCellId
				+ "]";
	}

	
}
