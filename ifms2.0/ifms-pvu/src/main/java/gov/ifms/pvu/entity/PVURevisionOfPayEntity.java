package gov.ifms.pvu.entity;

import java.io.Serializable;
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
 * The Class PVURevisionOfPayEntity.
 *
 * @version v 1.0
 * @created 2020/01/09 12:59:56
 */
/**
 * @author Admin
 *
 */
/**
 * @author Admin
 *
 */
@Entity
@Table(name = "T_PVU_RP_EVNT", schema = Constant.PVU_SCHEMA)
public class PVURevisionOfPayEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_RP_EVNT_ID")
	private Long id;

	/** The trans no. */
	@Column(name = "TRN_NO")
	private String trnNo;

	/** The next increment date. */
	@Column(name = "R_NEXT_INCR_DATE")
	private Date revNextIncrementDate;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The emp id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity empId;

	/** The rop type. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ROP_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity ropType;

	/** The pay level. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "R_PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity revPayLevel;

	/** The cell id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "R_CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity revCellId;

	/** The pay band. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "R_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity revPayBand;

	/** The pay band value. */
	@Column(name = "R_PAY_BAND_VALUE")
	private Long revPayBandValue;

	/** The grade pay. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "R_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity revGradePay;

	/** The basic pay. */
	@Column(name = "R_BASIC_PAY")
	private Long revBasicPay;

	/** The effective date. */
	@Column(name = "BEN_EFF_DATE")
	private Date effectiveDate;

	/** The rop change eff date. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "REASON_CHNG_EFF_DATE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity ropChangeEffDate;

	/** The order no. */
	@Column(name = "ROP_ORDER_NO")
	private String orderNo;

	/** The order date. */
	@Column(name = "ROP_ORDER_DATE")
	private Date orderDate;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The autitor remarks. */
	@Column(name = "AUDITOR_REMARKS")
	private String auditorRemarks;

	/** The class two remarks. */
	@Column(name = "CLASS_II_REMARKS")
	private String classTwoRemarks;

	/** The print remarks. */
	@Column(name = "PRINT_REMARKS")
	private String printRemarks;

	/** The autdi return reason. */
	@Column(name = "AUDI_RET_RES")
	private Long auditorReturnReason;

	/** The class two return reason. */
	@Column(name = "CLASS_II_RET_RES")
	private Long classTwoReturnReason;

	/** The print return reason. */
	@Column(name = "PRINT_RET_RES")
	private String printReturnReason;

	/** The print count. */
	@Column(name = "PRINT_COUNT")
	private Long printCount;

	/** The class id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CLASS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity classId;

	/** The designation id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	/** The cur scale. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity curScale;

	/** The cur grade pay. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity curGradePay;

	/** The cur pay band. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "C_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity curPayBand;

	/** The cur basic pay. */
	@Column(name = "C_BASIC_PAY")
	private Long curBasicPay;

	/** The cur pay band value. */
	@Column(name = "C_PAY_BAND_VALUE")
	private Long curPayBandValue;

	/** The curnextIncrementDate date. */
	@Column(name = "C_NEXT_INCR_DATE")
	private Date curNextIncrementDate;

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

	/** The npa. */
	@Column(name = "NPA")
	private Long npa;

	/** The auto six valid basic. */
	@Column(name = "AUTO_6_VALD_BASIC")
	private Long autoSixValidBasic;

	/** The auto six valid pay value. */
	@Column(name = "AUTO_6_VALD_PAY_VAL")
	private Long autoSixValidPayValue;

	/** The auto six valid flag. */
	@Column(name = "AUTO_6_VALD_FLAG")
	private Long autoSixValidFlag;

	/**
	 * Gets the approve date.
	 *
	 * @return the approve date
	 */
	public Date getApproveDate() {
		return approveDate;
	}

	/**
	 * Sets the approve date.
	 *
	 * @param approveDate the new approve date
	 */
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	/**
	 * Gets the authorize date.
	 *
	 * @return the authorize date
	 */
	public Date getAuthorizeDate() {
		return authorizeDate;
	}

	/**
	 * Sets the authorize date.
	 *
	 * @param authorizeDate the new authorize date
	 */
	public void setAuthorizeDate(Date authorizeDate) {
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
	 * Instantiates a new PVU revision of pay entity.
	 *
	 * @param id the id
	 */
	public PVURevisionOfPayEntity(Long id) {
		this.id = id;
	}

	/**
	 * Instantiates a new PVU revision of pay entity.
	 */
	public PVURevisionOfPayEntity() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
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
	 * Gets the rev next increment date.
	 *
	 * @return the revNextIncrementDate
	 */
	public Date getRevNextIncrementDate() {
		return revNextIncrementDate;
	}

	/**
	 * Sets the rev next increment date.
	 *
	 * @param revNextIncrementDate the revNextIncrementDate to set
	 */
	public void setRevNextIncrementDate(Date revNextIncrementDate) {
		this.revNextIncrementDate = revNextIncrementDate;
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
	 * Gets the rop type.
	 *
	 * @return the ropType
	 */
	public EDPLuLookUpInfoEntity getRopType() {
		return ropType;
	}

	/**
	 * Sets the rop type.
	 *
	 * @param ropType the ropType to set
	 */
	public void setRopType(EDPLuLookUpInfoEntity ropType) {
		this.ropType = ropType;
	}

	/**
	 * Gets the rev pay level.
	 *
	 * @return the revPayLevel
	 */
	public PVUMsPayLevelEntity getRevPayLevel() {
		return revPayLevel;
	}

	/**
	 * Sets the rev pay level.
	 *
	 * @param revPayLevel the revPayLevel to set
	 */
	public void setRevPayLevel(PVUMsPayLevelEntity revPayLevel) {
		this.revPayLevel = revPayLevel;
	}

	/**
	 * Gets the rev cell id.
	 *
	 * @return the revCellId
	 */
	public PVUMsPayCellEntity getRevCellId() {
		return revCellId;
	}

	/**
	 * Sets the rev cell id.
	 *
	 * @param revCellId the revCellId to set
	 */
	public void setRevCellId(PVUMsPayCellEntity revCellId) {
		this.revCellId = revCellId;
	}

	/**
	 * Gets the rev pay band.
	 *
	 * @return the revPayBand
	 */
	public PVUMsPayBandEntity getRevPayBand() {
		return revPayBand;
	}

	/**
	 * Sets the rev pay band.
	 *
	 * @param revPayBand the revPayBand to set
	 */
	public void setRevPayBand(PVUMsPayBandEntity revPayBand) {
		this.revPayBand = revPayBand;
	}

	/**
	 * Gets the rev pay band value.
	 *
	 * @return the revPayBandValue
	 */
	public Long getRevPayBandValue() {
		return revPayBandValue;
	}

	/**
	 * Sets the rev pay band value.
	 *
	 * @param revPayBandValue the revPayBandValue to set
	 */
	public void setRevPayBandValue(Long revPayBandValue) {
		this.revPayBandValue = revPayBandValue;
	}

	/**
	 * Gets the rev grade pay.
	 *
	 * @return the revGradePay
	 */
	public PVUMsGradePayEntity getRevGradePay() {
		return revGradePay;
	}

	/**
	 * Sets the rev grade pay.
	 *
	 * @param revGradePay the revGradePay to set
	 */
	public void setRevGradePay(PVUMsGradePayEntity revGradePay) {
		this.revGradePay = revGradePay;
	}

	/**
	 * Gets the rev basic pay.
	 *
	 * @return the revBasicPay
	 */
	public Long getRevBasicPay() {
		return revBasicPay;
	}

	/**
	 * Sets the rev basic pay.
	 *
	 * @param revBasicPay the revBasicPay to set
	 */
	public void setRevBasicPay(Long revBasicPay) {
		this.revBasicPay = revBasicPay;
	}

	/**
	 * Gets the effective date.
	 *
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * Sets the effective date.
	 *
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Gets the rop change eff date.
	 *
	 * @return the ropChangeEffDate
	 */
	public EDPLuLookUpInfoEntity getRopChangeEffDate() {
		return ropChangeEffDate;
	}

	/**
	 * Sets the rop change eff date.
	 *
	 * @param ropChangeEffDate the ropChangeEffDate to set
	 */
	public void setRopChangeEffDate(EDPLuLookUpInfoEntity ropChangeEffDate) {
		this.ropChangeEffDate = ropChangeEffDate;
	}

	/**
	 * Gets the order no.
	 *
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * Sets the order no.
	 *
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * Gets the order date.
	 *
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * Sets the order date.
	 *
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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
	 * Gets the auditor remarks.
	 *
	 * @return the auditorRemarks
	 */
	public String getAuditorRemarks() {
		return auditorRemarks;
	}

	/**
	 * Sets the auditor remarks.
	 *
	 * @param auditorRemarks the auditorRemarks to set
	 */
	public void setAuditorRemarks(String auditorRemarks) {
		this.auditorRemarks = auditorRemarks;
	}

	/**
	 * Gets the class two remarks.
	 *
	 * @return the classTwoRemarks
	 */
	public String getClassTwoRemarks() {
		return classTwoRemarks;
	}

	/**
	 * Sets the class two remarks.
	 *
	 * @param classTwoRemarks the classTwoRemarks to set
	 */
	public void setClassTwoRemarks(String classTwoRemarks) {
		this.classTwoRemarks = classTwoRemarks;
	}

	/**
	 * Gets the prints the remarks.
	 *
	 * @return the printRemarks
	 */
	public String getPrintRemarks() {
		return printRemarks;
	}

	/**
	 * Sets the prints the remarks.
	 *
	 * @param printRemarks the printRemarks to set
	 */
	public void setPrintRemarks(String printRemarks) {
		this.printRemarks = printRemarks;
	}

	/**
	 * Gets the auditor return reason.
	 *
	 * @return the auditorReturnReason
	 */
	public Long getAuditorReturnReason() {
		return auditorReturnReason;
	}

	/**
	 * Sets the auditor return reason.
	 *
	 * @param auditorReturnReason the auditorReturnReason to set
	 */
	public void setAuditorReturnReason(Long auditorReturnReason) {
		this.auditorReturnReason = auditorReturnReason;
	}

	/**
	 * Gets the class two return reason.
	 *
	 * @return the classTwoReturnReason
	 */
	public Long getClassTwoReturnReason() {
		return classTwoReturnReason;
	}

	/**
	 * Sets the class two return reason.
	 *
	 * @param classTwoReturnReason the classTwoReturnReason to set
	 */
	public void setClassTwoReturnReason(Long classTwoReturnReason) {
		this.classTwoReturnReason = classTwoReturnReason;
	}

	/**
	 * Gets the prints the return reason.
	 *
	 * @return the printReturnReason
	 */
	public String getPrintReturnReason() {
		return printReturnReason;
	}

	/**
	 * Sets the prints the return reason.
	 *
	 * @param printReturnReason the printReturnReason to set
	 */
	public void setPrintReturnReason(String printReturnReason) {
		this.printReturnReason = printReturnReason;
	}

	/**
	 * Gets the prints the count.
	 *
	 * @return the printCount
	 */
	public Long getPrintCount() {
		return printCount;
	}

	/**
	 * Sets the prints the count.
	 *
	 * @param printCount the printCount to set
	 */
	public void setPrintCount(Long printCount) {
		this.printCount = printCount;
	}

	/**
	 * Gets the class id.
	 *
	 * @return the classId
	 */
	public EDPLuLookUpInfoEntity getClassId() {
		return classId;
	}

	/**
	 * Sets the class id.
	 *
	 * @param classId the classId to set
	 */
	public void setClassId(EDPLuLookUpInfoEntity classId) {
		this.classId = classId;
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
	 * Gets the cur basic pay.
	 *
	 * @return the curBasicPay
	 */
	public Long getCurBasicPay() {
		return curBasicPay;
	}

	/**
	 * Sets the cur basic pay.
	 *
	 * @param curBasicPay the curBasicPay to set
	 */
	public void setCurBasicPay(Long curBasicPay) {
		this.curBasicPay = curBasicPay;
	}

	/**
	 * Gets the cur pay band value.
	 *
	 * @return the curPayBandValue
	 */
	public Long getCurPayBandValue() {
		return curPayBandValue;
	}

	/**
	 * Sets the cur pay band value.
	 *
	 * @param curPayBandValue the curPayBandValue to set
	 */
	public void setCurPayBandValue(Long curPayBandValue) {
		this.curPayBandValue = curPayBandValue;
	}

	/**
	 * Gets the cur next increment date.
	 *
	 * @return the curNextIncrementDate
	 */
	public Date getCurNextIncrementDate() {
		return curNextIncrementDate;
	}

	/**
	 * Sets the cur next increment date.
	 *
	 * @param curNextIncrementDate the curNextIncrementDate to set
	 */
	public void setCurNextIncrementDate(Date curNextIncrementDate) {
		this.curNextIncrementDate = curNextIncrementDate;
	}

	/**
	 * Gets the npa.
	 *
	 * @return the npa
	 */
	public Long getNpa() {
		return npa;
	}

	/**
	 * Sets the npa.
	 *
	 * @param npa the npa to set
	 */
	public void setNpa(Long npa) {
		this.npa = npa;
	}

	/**
	 * Gets the auto six valid basic.
	 *
	 * @return the autoSixValidBasic
	 */
	public Long getAutoSixValidBasic() {
		return autoSixValidBasic;
	}

	/**
	 * Sets the auto six valid basic.
	 *
	 * @param autoSixValidBasic the autoSixValidBasic to set
	 */
	public void setAutoSixValidBasic(Long autoSixValidBasic) {
		this.autoSixValidBasic = autoSixValidBasic;
	}

	/**
	 * Gets the auto six valid pay value.
	 *
	 * @return the autoSixValidPayValue
	 */
	public Long getAutoSixValidPayValue() {
		return autoSixValidPayValue;
	}

	/**
	 * Sets the auto six valid pay value.
	 *
	 * @param autoSixValidPayValue the autoSixValidPayValue to set
	 */
	public void setAutoSixValidPayValue(Long autoSixValidPayValue) {
		this.autoSixValidPayValue = autoSixValidPayValue;
	}

	/**
	 * Gets the auto six valid flag.
	 *
	 * @return the autoSixValidFlag
	 */
	public Long getAutoSixValidFlag() {
		return autoSixValidFlag;
	}

	/**
	 * Sets the auto six valid flag.
	 *
	 * @param autoSixValidFlag the autoSixValidFlag to set
	 */
	public void setAutoSixValidFlag(Long autoSixValidFlag) {
		this.autoSixValidFlag = autoSixValidFlag;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(approveDate, auditorRemarks, auditorReturnReason, authorizeDate, autoSixValidBasic,
				autoSixValidFlag, autoSixValidPayValue, classId, classTwoRemarks, classTwoReturnReason, curBasicPay,
				curGradePay, curNextIncrementDate, curPayBand, curPayBandValue, curScale, designationId, effectiveDate,
				empId, id, isPrintAble, npa, officeId, orderDate, orderNo, printCount, printRemarks, printReturnReason,
				remarks, revBasicPay, revCellId, revGradePay, revNextIncrementDate, revPayBand, revPayBandValue,
				revPayLevel, ropChangeEffDate, ropType, statusId, trnNo);
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
		if (!(obj instanceof PVURevisionOfPayEntity)) {
			return false;
		}
		PVURevisionOfPayEntity other = (PVURevisionOfPayEntity) obj;
		return Objects.equals(approveDate, other.approveDate) && Objects.equals(auditorRemarks, other.auditorRemarks)
				&& Objects.equals(auditorReturnReason, other.auditorReturnReason)
				&& Objects.equals(authorizeDate, other.authorizeDate)
				&& Objects.equals(autoSixValidBasic, other.autoSixValidBasic)
				&& Objects.equals(autoSixValidFlag, other.autoSixValidFlag)
				&& Objects.equals(autoSixValidPayValue, other.autoSixValidPayValue)
				&& Objects.equals(classId, other.classId) && Objects.equals(classTwoRemarks, other.classTwoRemarks)
				&& Objects.equals(classTwoReturnReason, other.classTwoReturnReason)
				&& Objects.equals(curBasicPay, other.curBasicPay) && Objects.equals(curGradePay, other.curGradePay)
				&& Objects.equals(curNextIncrementDate, other.curNextIncrementDate)
				&& Objects.equals(curPayBand, other.curPayBand)
				&& Objects.equals(curPayBandValue, other.curPayBandValue) && Objects.equals(curScale, other.curScale)
				&& Objects.equals(designationId, other.designationId)
				&& Objects.equals(effectiveDate, other.effectiveDate) && Objects.equals(empId, other.empId)
				&& Objects.equals(id, other.id) && Objects.equals(isPrintAble, other.isPrintAble)
				&& Objects.equals(npa, other.npa) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(orderDate, other.orderDate) && Objects.equals(orderNo, other.orderNo)
				&& Objects.equals(printCount, other.printCount) && Objects.equals(printRemarks, other.printRemarks)
				&& Objects.equals(printReturnReason, other.printReturnReason) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(revBasicPay, other.revBasicPay) && Objects.equals(revCellId, other.revCellId)
				&& Objects.equals(revGradePay, other.revGradePay)
				&& Objects.equals(revNextIncrementDate, other.revNextIncrementDate)
				&& Objects.equals(revPayBand, other.revPayBand)
				&& Objects.equals(revPayBandValue, other.revPayBandValue)
				&& Objects.equals(revPayLevel, other.revPayLevel)
				&& Objects.equals(ropChangeEffDate, other.ropChangeEffDate) && Objects.equals(ropType, other.ropType)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(trnNo, other.trnNo);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format(
				"PVURevisionOfPayEntity [id=%s, trnNo=%s, revNextIncrementDate=%s, statusId=%s, empId=%s, ropType=%s, revPayLevel=%s, revCellId=%s, revPayBand=%s, revPayBandValue=%s, revGradePay=%s, revBasicPay=%s, effectiveDate=%s, ropChangeEffDate=%s, orderNo=%s, orderDate=%s, officeId=%s, remarks=%s, auditorRemarks=%s, classTwoRemarks=%s, printRemarks=%s, auditorReturnReason=%s, classTwoReturnReason=%s, printReturnReason=%s, printCount=%s, classId=%s, designationId=%s, curScale=%s, curGradePay=%s, curPayBand=%s, curBasicPay=%s, curPayBandValue=%s, curNextIncrementDate=%s, isPrintAble=%s, approveDate=%s, authorizeDate=%s, npa=%s, autoSixValidBasic=%s, autoSixValidPayValue=%s, autoSixValidFlag=%s]",
				id, trnNo, revNextIncrementDate, statusId, empId, ropType, revPayLevel, revCellId, revPayBand,
				revPayBandValue, revGradePay, revBasicPay, effectiveDate, ropChangeEffDate, orderNo, orderDate,
				officeId, remarks, auditorRemarks, classTwoRemarks, printRemarks, auditorReturnReason,
				classTwoReturnReason, printReturnReason, printCount, classId, designationId, curScale, curGradePay,
				curPayBand, curBasicPay, curPayBandValue, curNextIncrementDate, isPrintAble, approveDate, authorizeDate,
				npa, autoSixValidBasic, autoSixValidPayValue, autoSixValidFlag);
	}

}
