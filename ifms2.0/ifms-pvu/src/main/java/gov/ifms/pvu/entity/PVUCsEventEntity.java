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
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.pvu.common.PVUCurrentEntity;

/**
 * The Class PVUCsEventEntity.
 */
@Entity
@Table(name = "T_PVU_CS_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUCsEventEntity extends PVUCurrentEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** The cs event id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_CS_EVNT_ID")
	private Long id;

	/** The trn no. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The pay commission. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_COMM", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payCommission;

	/** The event order no. */
	@Column(name = "EVNT_ORDER_NO")
	private String eventOrderNo;

	/** The event order date. */
	@Column(name = "EVNT_ORDER_DATE")
	private LocalDate eventOrderDate;

	/** The event effective date. */
	@Column(name = "EVNT_EFF_DATE")
	private LocalDate eventEffectiveDate;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity scale;

	/** The pay level. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_LEVEL", nullable = true, referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity payLevel;

	/** The cell id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity cellId;

	/** The pay band. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity payBand;

	/** The pay band value. */
	@Column(name = "PAY_BAND_VALUE")
	private Long payBandValue;

	/** The grade pay. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity gradePay;

	/** The next increment date. */
	@Column(name = "DATE_NXT_INC")
	private LocalDate dateOfNextIncrement;

	/** The notional from date. */
	@Column(name = "NOTIONAL_FROM_DATE")
	private LocalDate notionalFromDate;

	/** The notional to date. */
	@Column(name = "NOTIONAL_TO_DATE")
	private LocalDate notionalToDate;

	/** The notional duration. */
	@Column(name = "NOTIONAL_DURATION")
	private Integer notionalDuration;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private Long basicPay;

	/** The event id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PVU_EVENT_ID", referencedColumnName = "MS_PVU_EVENTS_ID")
	private PVUMsEventEntity eventId;

	/** The personal pay. */
	@Column(name = "PERSONAL_PAY")
	private Long personalPay;
	
	/** The autitor remarks. */
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

	/** The verifier remarks. */
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

	/** The is print able. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "IS_PRINTABLE")
	private EDPLuLookUpInfoEntity isPrintAble;

	/** The approve date. */
	@Column(name = "APPR_DATE")
	private LocalDateTime approveDate;

	/** The authorize date. */
	@Column(name = "AUTH_DATE")
	private LocalDateTime authorizeDate;

	/** The authorize date. */
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
	/**
     * The departmentCategoryId.
     */
    @Column(name = "DEPT_CAT_ID")
    private Long departmentCategoryId;
    
	/**
	 * @return the departmentCategoryId
	 */
	public Long getDepartmentCategoryId() {
		return departmentCategoryId;
	}

	/**
	 * @param departmentCategoryId the departmentCategoryId to set
	 */
	public void setDepartmentCategoryId(Long departmentCategoryId) {
		this.departmentCategoryId = departmentCategoryId;
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

	public PVUMsPayScaleEntity getScale() {
		return scale;
	}

	public void setScale(PVUMsPayScaleEntity scale) {
		this.scale = scale;
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

	public EDPLuLookUpInfoEntity getIsPrintAble() {
		return isPrintAble;
	}

	public void setIsPrintAble(EDPLuLookUpInfoEntity isPrintAble) {
		this.isPrintAble = isPrintAble;
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

	/**
	 * PVUCsEventEntity Constructor.
	 */
	public PVUCsEventEntity() {

	}

	/**
	 * Instantiates a new PVU cs event entity.
	 *
	 * @param id the cs event id
	 */
	public PVUCsEventEntity(Long id) {
		this.id = id;
	}

	/**
	 * @return the cs Event Id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the cs event id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	 * Gets the pay band.
	 *
	 * @return the payBand
	 */
	public PVUMsPayBandEntity getPayBand() {
		return payBand;
	}

	/**
	 * Sets the pay band.
	 *
	 * @param payBand the payBand to set
	 */
	public void setPayBand(PVUMsPayBandEntity payBand) {
		this.payBand = payBand;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return the payBandValue
	 */
	public Long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(Long payBandValue) {
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
	 * Gets the date of next increment.
	 *
	 * @return the dateOfNextIncrement
	 */
	public LocalDate getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * @param dateOfNextIncrement the dateOfNextIncrement to set
	 */
	public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	/**
	 * Gets the notional from date.
	 *
	 * @return the notionalFromDate
	 */
	public LocalDate getNotionalFromDate() {
		return notionalFromDate;
	}

	/**
	 * Sets the notional from date.
	 *
	 * @param notionalFromDate the notionalFromDate to set
	 */
	public void setNotionalFromDate(LocalDate notionalFromDate) {
		this.notionalFromDate = notionalFromDate;
	}

	/**
	 * Gets the notional to date.
	 *
	 * @return the notionalToDate
	 */
	public LocalDate getNotionalToDate() {
		return notionalToDate;
	}

	/**
	 * Sets the notional to date.
	 *
	 * @param notionalToDate the notionalToDate to set
	 */
	public void setNotionalToDate(LocalDate notionalToDate) {
		this.notionalToDate = notionalToDate;
	}

	/**
	 * Gets the notional duration.
	 *
	 * @return the notionalDuration
	 */
	public Integer getNotionalDuration() {
		return notionalDuration;
	}

	/**
	 * Sets the notional duration.
	 *
	 * @param notionalDuration the notionalDuration to set
	 */
	public void setNotionalDuration(Integer notionalDuration) {
		this.notionalDuration = notionalDuration;
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
	 * Gets the event id.
	 *
	 * @return the eventId
	 */
	public PVUMsEventEntity getEventId() {
		return eventId;
	}

	/**
	 * Sets the event id.
	 *
	 * @param eventId the eventId to set
	 */
	public void setEventId(PVUMsEventEntity eventId) {
		this.eventId = eventId;
	}

	/**
	 * Gets the personal pay.
	 *
	 * @return the personalPay
	 */
	public Long getPersonalPay() {
		return personalPay;
	}

	/**
	 * Sets the personal pay.
	 *
	 * @param personalPay the personalPay to set
	 */
	public void setPersonalPay(Long personalPay) {
		this.personalPay = personalPay;
	}

	/**
	 * hashcode method.
	 *
	 * @return the Integer
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, trnNo, officeId, payCommission, eventOrderNo, eventOrderDate, eventEffectiveDate,
				statusId, scale, payLevel, cellId, payBand, payBandValue, gradePay, dateOfNextIncrement,
				notionalFromDate, notionalToDate, notionalDuration, remarks, basicPay, eventId, personalPay);
	}

	/**
	 * equals method.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUCsEventEntity)) {
			return false;
		}

		PVUCsEventEntity other = (PVUCsEventEntity) obj;

		return id == other.id && Objects.equals(trnNo, other.trnNo) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(payCommission, other.payCommission)
				&& Objects.equals(eventOrderNo, other.eventOrderNo)
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate)
				&& Objects.equals(statusId, other.statusId) 
				&& scale == other.scale && Objects.equals(payLevel, other.payLevel)
				&& Objects.equals(cellId, other.cellId) && Objects.equals(payBand, other.payBand)
				&& payBandValue == other.payBandValue && Objects.equals(gradePay, other.gradePay)
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& Objects.equals(notionalFromDate, other.notionalFromDate)
				&& Objects.equals(notionalToDate, other.notionalToDate) && notionalDuration == other.notionalDuration
				&& Objects.equals(remarks, other.remarks) && basicPay == other.basicPay
				&& Objects.equals(eventId, other.eventId) && personalPay == other.personalPay;
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUCsEventEntity [csEventId = " + id + ", trnNo = " + trnNo + ", officeId = " + officeId
				+ ", payCommission = " + payCommission + ", eventOrderNo = " + eventOrderNo + ", eventOrderDate = "
				+ eventOrderDate + ", eventEffectiveDate = " + eventEffectiveDate + ", statusId = " + statusId
				+ ", scale = " + scale + ", payLevel = " + payLevel + ", cellId = " + cellId
				+ ", payBand = " + payBand + ", payBandValue = " + payBandValue + ", gradePay = " + gradePay
				+ ", dateOfNextIncrement = " + dateOfNextIncrement + ", notionalFromDate = " + notionalFromDate
				+ ", notionalToDate = " + notionalToDate + ", notionalDuration = " + notionalDuration + ", remarks = "
				+ remarks + ", basicPay = " + basicPay + ", eventId = " + eventId + ", personalPay = " + personalPay
				+ "]";
	}

}
