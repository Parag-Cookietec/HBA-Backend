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
import gov.ifms.edp.entity.EDPMsOfficeEntity;

/**
 * The Class PVUEmployeShettyPayEntity.
 *
 * @version v 1.0
 * @created 2020/01/06 12:53:37
 *
 */
/**
 * @author HP
 *
 */
@Entity
@Table(name = "T_PVU_SP_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUEmployeShettyPayEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_SP_EVNT_ID")
	private long id;

	/** The trn no. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The office id. */
	@ManyToOne
	@JoinColumn(name = "OFFICE_ID", nullable = false, referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The event order no. */
	@Column(name = "EVNT_ORDER_NO")
	private String eventOrderNo;

	/** The event order LocalDate. */
	@Column(name = "EVNT_ORDER_DATE")
	private LocalDate eventOrderDate;

	/** The event eff LocalDate. */
	@Column(name = "EVNT_EFF_DATE")
	private LocalDate eventEffectiveDate;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The emp id. */
	@ManyToOne
	@JoinColumn(name = "EMP_ID", nullable = false, referencedColumnName = "EMP_ID")
	private PVUEmployeEntity empId;

	/** The scale. */
	@ManyToOne
	@JoinColumn(name = "SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity payScale;

	/** The basic pay. */
	@Column(name = "BASIC_PAY")
	private long basicPay;

	/** The pay band. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_BAND", nullable = false, referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity payBand;

	/** The grade pay. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity gradePay;

	/** The benefit eff LocalDate. */
	@Column(name = "BEN_EFF_DATE")
	private LocalDate benefitEffectiveDate;

	/** The nxtincr LocalDate. */
	@Column(name = "DATE_NXT_INCR")
	private LocalDate dateOfNextIncrement;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The pay band value. */
	@Column(name = "PAY_BAND_VALUE")
	private Long payBandValue;

	@ManyToOne
	@JoinColumn(name = "C_SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity cPayScale;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity cPayBandId;

	@Column(name = "C_PAY_BAND_VALUE")
	private Long cPayBandValue;

	@ManyToOne
	@JoinColumn(name = "C_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity cGradePayId;

	@Column(name = "C_BASIC_PAY")
	private Long cBasicPay;

	/** The pay commission. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAY_COMM", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payCommission;

	@Column(name = "CURRENT_DETAILS_EVENT_ID")
	private Long currentDetailsEventId;

	/** The approve date. */
	@Column(name = "APPR_DATE")
	private LocalDateTime approveDate;

	/** The authorize date. */
	@Column(name = "AUTH_DATE")
	private LocalDateTime authorizeDate;

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
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public PVUEmployeEntity getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(PVUEmployeEntity empId) {
		this.empId = empId;
	}

	/**
	 * @return the payScale
	 */
	public PVUMsPayScaleEntity getPayScale() {
		return payScale;
	}

	/**
	 * @param payScale the payScale to set
	 */
	public void setPayScale(PVUMsPayScaleEntity payScale) {
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

	@Override
	public int hashCode() {
		return Objects.hash(approveDate, auditorRemarks, auditorReturnReason, authorizeBy, authorizeDate,
				authorizerRemark, basicPay, benefitEffectiveDate, cBasicPay, cGradePayId, cPayBandId, cPayBandValue,
				cPayScale, classOneRemarks, classOneReturnReason, classTwoRemarks, classTwoReturnReason,
				currentDetailsEventId, dateOfNextIncrement, empId, eventEffectiveDate, eventOrderDate, eventOrderNo,
				gradePay, id, initDate, isPrintAble, officeId, payBand, payBandValue, payCommission, payScale,
				printCount, printRemarks, printReturnReason, refDate, remarks, statusId, trnNo, verifierRemarks,
				verifierReturnReason);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUEmployeShettyPayEntity)) {
			return false;
		}
		PVUEmployeShettyPayEntity other = (PVUEmployeShettyPayEntity) obj;
		return Objects.equals(approveDate, other.approveDate) && Objects.equals(auditorRemarks, other.auditorRemarks)
				&& Objects.equals(auditorReturnReason, other.auditorReturnReason)
				&& Objects.equals(authorizeBy, other.authorizeBy) && Objects.equals(authorizeDate, other.authorizeDate)
				&& Objects.equals(authorizerRemark, other.authorizerRemark) && basicPay == other.basicPay
				&& Objects.equals(benefitEffectiveDate, other.benefitEffectiveDate)
				&& Objects.equals(cBasicPay, other.cBasicPay) && Objects.equals(cGradePayId, other.cGradePayId)
				&& Objects.equals(cPayBandId, other.cPayBandId) && Objects.equals(cPayBandValue, other.cPayBandValue)
				&& Objects.equals(cPayScale, other.cPayScale) && Objects.equals(classOneRemarks, other.classOneRemarks)
				&& Objects.equals(classOneReturnReason, other.classOneReturnReason)
				&& Objects.equals(classTwoRemarks, other.classTwoRemarks)
				&& Objects.equals(classTwoReturnReason, other.classTwoReturnReason)
				&& Objects.equals(currentDetailsEventId, other.currentDetailsEventId)
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement) && Objects.equals(empId, other.empId)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate)
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventOrderNo, other.eventOrderNo) && Objects.equals(gradePay, other.gradePay)
				&& id == other.id && Objects.equals(initDate, other.initDate)
				&& Objects.equals(isPrintAble, other.isPrintAble) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(payBand, other.payBand) && Objects.equals(payBandValue, other.payBandValue)
				&& Objects.equals(payCommission, other.payCommission) && Objects.equals(payScale, other.payScale)
				&& Objects.equals(printCount, other.printCount) && Objects.equals(printRemarks, other.printRemarks)
				&& Objects.equals(printReturnReason, other.printReturnReason) && Objects.equals(refDate, other.refDate)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(trnNo, other.trnNo) && Objects.equals(verifierRemarks, other.verifierRemarks)
				&& Objects.equals(verifierReturnReason, other.verifierReturnReason);
	}

	@Override
	public String toString() {
		return "PVUEmployeShettyPayEntity [id=" + id + ", trnNo=" + trnNo + ", officeId=" + officeId + ", eventOrderNo="
				+ eventOrderNo + ", eventOrderDate=" + eventOrderDate + ", eventEffectiveDate=" + eventEffectiveDate
				+ ", statusId=" + statusId + ", empId=" + empId + ", payScale=" + payScale + ", basicPay=" + basicPay
				+ ", payBand=" + payBand + ", gradePay=" + gradePay + ", benefitEffectiveDate=" + benefitEffectiveDate
				+ ", dateOfNextIncrement=" + dateOfNextIncrement + ", remarks=" + remarks + ", payBandValue="
				+ payBandValue + ", cPayScale=" + cPayScale + ", cPayBandId=" + cPayBandId + ", cPayBandValue="
				+ cPayBandValue + ", cGradePayId=" + cGradePayId + ", cBasicPay=" + cBasicPay + "]";
	}

	/**
	 * Instantiates a new PVU employe shetty pay entity.
	 *
	 * @param id the id
	 */
	public PVUEmployeShettyPayEntity(long id) {
		super();
		this.id = id;
	}

	/**
	 * Instantiates a new PVU employe shetty pay entity.
	 */
	public PVUEmployeShettyPayEntity() {
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
	 * @return the payCommission
	 */
	public EDPLuLookUpInfoEntity getPayCommission() {
		return payCommission;
	}

	/**
	 * @param payCommission the payCommission to set
	 */
	public void setPayCommission(EDPLuLookUpInfoEntity payCommission) {
		this.payCommission = payCommission;
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
	public EDPLuLookUpInfoEntity getIsPrintAble() {
		return isPrintAble;
	}

	/**
	 * @param isPrintAble the isPrintAble to set
	 */
	public void setIsPrintAble(EDPLuLookUpInfoEntity isPrintAble) {
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
	 * @return the printReturnReason
	 */
	public Long getPrintReturnReason() {
		return printReturnReason;
	}

	/**
	 * @param printReturnReason the printReturnReason to set
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
