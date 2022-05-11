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

/**
 * The Class PVUIncrementEmpEntity.
 * 
 * @version v 1.0
 * @created 2020/01/12 19:19:14
 *
 */
@Entity
@Table(name = "T_PVU_IN_EMP", schema = Constant.PVU_SCHEMA)
public class PVUIncrementEmpEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The in emp id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_IN_EMP_ID")
	private Long inEmpId;

	/** The in event id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_PVU_IN_EVNT_ID", referencedColumnName = "T_PVU_IN_EVNT_ID")
	private PVUIncrementEventEntity inEventId;

	/** The emp id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity empId;

	/** The cur pay level. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity curPayLevel;

	/** The cur cell id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity curCellId;

	/** The cur grade. */
	@Column(name = "C_GRADE")
	private Long curGrade;

	/** The cur scale. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity curScale;

	/** The cur pay band. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity curPayBand;

	/** The cur pay band value. */
	@Column(name = "C_PAY_BAND_VALUE")
	private long curPayBandValue;

	/** The cur grade pay. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity curGradePay;

	/** The cur basic pay. */
	@Column(name = "C_BASIC_PAY")
	private long curBasicPay;

	/** The rev pay level. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "R_PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity revPayLevel;

	/** The rev cell id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "R_CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity revCellId;

	/** The rev grade. */
	@Column(name = "R_GRADE")
	private Long revGrade;

	/** The rev scale. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "R_SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity revScale;

	/** The rev pay band. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "R_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity revPayBand;

	/** The rev pay band value. */
	@Column(name = "R_PAY_BAND_VALUE")
	private long revPayBandValue;

	/** The rev grade pay. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "R_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity revGradePay;

	/** The rev basic pay. */
	@Column(name = "R_BASIC_PAY")
	private long revBasicPay;

	/** The rev eff date. */
	@Column(name = "R_EFF_DATE")
	private Date revEffDate;

	/** The rev date nex inc. */
	@Column(name = "R_DATE_OF_INC")
	private Date revDateNexInc;

	/** The diff amt. */
	@Column(name = "DIFF_AMT")
	private long diffAmt;

	/** The REASON FOR EXCLUDE. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REASON_FOR_EXCLUDE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity reasonForExclude;

	/** The stop increment type. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STOP_INCREMENT_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity stopIncrementType;

	/** The from date. */
	@Column(name = "FROM_DATE")
	private Date stopIncFromDate;

	/** The to date. */
	@Column(name = "TO_DATE")
	private Date stopIncToDate;

	/** The date nxt inc. */
	@Column(name = "DATE_NXT_INC")
	private Date dateNxtInc;

	/** The sus start date. */
	@Column(name = "SUS_START_DATE")
	private Date susStartDate;

	/** The sus end date. */
	@Column(name = "SUS_END_DATE")
	private Date susEndDate;

	/** The eol start date. */
	@Column(name = "EOL_START_DATE")
	private Date eolStartDate;

	/** The eol end date. */
	@Column(name = "EOL_END_DATE")
	private Date eolEndDate;

	/** The cur emp class. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLASS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity classId;

	/** The cur emp dsgn. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	/** The emp type. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_TYPE", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity empType;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The status id. */
	@Column(name = "SYSTEM_EXCL")
	private int systemExcluded;

	/** The remarks. */
	@Column(name = "INCREMENT_TYPE")
	private String incrementType;

	/** The gpf no. */
	@Column(name = "GPF")
	private String gpf;

	/**
	 * PVUIncrementEmpEntity Constructor.
	 */
	public PVUIncrementEmpEntity() {
		super();
	}

	/**
	 * Gets the in emp id.
	 *
	 * @return the inEmpId
	 */
	public long getInEmpId() {
		return inEmpId;
	}

	/**
	 * Sets the in emp id.
	 *
	 * @param inEmpId the inEmpId to set
	 */
	public void setInEmpId(long inEmpId) {
		this.inEmpId = inEmpId;
	}

	/**
	 * Gets the in event id.
	 *
	 * @return the inEventId
	 */
	public PVUIncrementEventEntity getInEventId() {
		return inEventId;
	}

	/**
	 * Sets the in event id.
	 *
	 * @param inEventId the inEventId to set
	 */
	public void setInEventId(PVUIncrementEventEntity inEventId) {
		this.inEventId = inEventId;
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
	 * Gets the cur grade.
	 *
	 * @return the curGrade
	 */
	public Long getCurGrade() {
		return curGrade;
	}

	/**
	 * Sets the cur grade.
	 *
	 * @param curGrade the curGrade to set
	 */
	public void setCurGrade(Long curGrade) {
		this.curGrade = curGrade;
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
	 * Gets the rev grade.
	 *
	 * @return the revGrade
	 */
	public Long getRevGrade() {
		return revGrade;
	}

	/**
	 * Sets the rev grade.
	 *
	 * @param revGrade the revGrade to set
	 */
	public void setRevGrade(Long revGrade) {
		this.revGrade = revGrade;
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
	public long getRevPayBandValue() {
		return revPayBandValue;
	}

	/**
	 * Sets the rev pay band value.
	 *
	 * @param revPayBandValue the revPayBandValue to set
	 */
	public void setRevPayBandValue(long revPayBandValue) {
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
	public long getRevBasicPay() {
		return revBasicPay;
	}

	/**
	 * Sets the rev basic pay.
	 *
	 * @param revBasicPay the revBasicPay to set
	 */
	public void setRevBasicPay(long revBasicPay) {
		this.revBasicPay = revBasicPay;
	}

	/**
	 * Gets the rev eff date.
	 *
	 * @return the revEffDate
	 */
	public Date getRevEffDate() {
		return revEffDate;
	}

	/**
	 * Sets the rev eff date.
	 *
	 * @param revEffDate the revEffDate to set
	 */
	public void setRevEffDate(Date revEffDate) {
		this.revEffDate = revEffDate;
	}

	/**
	 * Gets the rev date nex inc.
	 *
	 * @return the revDateNexInc
	 */
	public Date getRevDateNexInc() {
		return revDateNexInc;
	}

	/**
	 * Sets the rev date nex inc.
	 *
	 * @param revDateNexInc the revDateNexInc to set
	 */
	public void setRevDateNexInc(Date revDateNexInc) {
		this.revDateNexInc = revDateNexInc;
	}

	/**
	 * Gets the diff amt.
	 *
	 * @return the diffAmt
	 */
	public long getDiffAmt() {
		return diffAmt;
	}

	/**
	 * Sets the diff amt.
	 *
	 * @param diffAmt the diffAmt to set
	 */
	public void setDiffAmt(long diffAmt) {
		this.diffAmt = diffAmt;
	}

	/**
	 * Gets the reason for exclude.
	 *
	 * @return the reasonForExclude
	 */
	public EDPLuLookUpInfoEntity getReasonForExclude() {
		return reasonForExclude;
	}

	/**
	 * Sets the reason for exclude.
	 *
	 * @param reasonForExclude the reasonForExclude to set
	 */
	public void setReasonForExclude(EDPLuLookUpInfoEntity reasonForExclude) {
		this.reasonForExclude = reasonForExclude;
	}

	/**
	 * Gets the stop increment type.
	 *
	 * @return the stopIncrementType
	 */
	public EDPLuLookUpInfoEntity getStopIncrementType() {
		return stopIncrementType;
	}

	/**
	 * Sets the stop increment type.
	 *
	 * @param stopIncrementType the stopIncrementType to set
	 */
	public void setStopIncrementType(EDPLuLookUpInfoEntity stopIncrementType) {
		this.stopIncrementType = stopIncrementType;
	}

	/**
	 * Gets the stop inc from date.
	 *
	 * @return the stopIncFromDate
	 */
	public Date getStopIncFromDate() {
		return stopIncFromDate;
	}

	/**
	 * Sets the stop inc from date.
	 *
	 * @param stopIncFromDate the stopIncFromDate to set
	 */
	public void setStopIncFromDate(Date stopIncFromDate) {
		this.stopIncFromDate = stopIncFromDate;
	}

	/**
	 * Gets the stop inc to date.
	 *
	 * @return the stopIncToDate
	 */
	public Date getStopIncToDate() {
		return stopIncToDate;
	}

	/**
	 * Sets the stop inc to date.
	 *
	 * @param stopIncToDate the stopIncToDate to set
	 */
	public void setStopIncToDate(Date stopIncToDate) {
		this.stopIncToDate = stopIncToDate;
	}

	/**
	 * Gets the date nxt inc.
	 *
	 * @return the dateNxtInc
	 */
	public Date getDateNxtInc() {
		return dateNxtInc;
	}

	/**
	 * Sets the date nxt inc.
	 *
	 * @param dateNxtInc the dateNxtInc to set
	 */
	public void setDateNxtInc(Date dateNxtInc) {
		this.dateNxtInc = dateNxtInc;
	}

	/**
	 * Gets the sus start date.
	 *
	 * @return the susStartDate
	 */
	public Date getSusStartDate() {
		return susStartDate;
	}

	/**
	 * Sets the sus start date.
	 *
	 * @param susStartDate the susStartDate to set
	 */
	public void setSusStartDate(Date susStartDate) {
		this.susStartDate = susStartDate;
	}

	/**
	 * Gets the sus end date.
	 *
	 * @return the susEndDate
	 */
	public Date getSusEndDate() {
		return susEndDate;
	}

	/**
	 * Sets the sus end date.
	 *
	 * @param susEndDate the susEndDate to set
	 */
	public void setSusEndDate(Date susEndDate) {
		this.susEndDate = susEndDate;
	}

	/**
	 * Gets the eol start date.
	 *
	 * @return the eolStartDate
	 */
	public Date getEolStartDate() {
		return eolStartDate;
	}

	/**
	 * Sets the eol start date.
	 *
	 * @param eolStartDate the eolStartDate to set
	 */
	public void setEolStartDate(Date eolStartDate) {
		this.eolStartDate = eolStartDate;
	}

	/**
	 * Gets the eol end date.
	 *
	 * @return the eolEndDate
	 */
	public Date getEolEndDate() {
		return eolEndDate;
	}

	/**
	 * Sets the eol end date.
	 *
	 * @param eolEndDate the eolEndDate to set
	 */
	public void setEolEndDate(Date eolEndDate) {
		this.eolEndDate = eolEndDate;
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
	 * Gets the rev scale.
	 *
	 * @return the revScale
	 */
	public PVUMsPayScaleEntity getRevScale() {
		return revScale;
	}

	/**
	 * Sets the rev scale.
	 *
	 * @param revScale the revScale to set
	 */
	public void setRevScale(PVUMsPayScaleEntity revScale) {
		this.revScale = revScale;
	}

	/**
	 * Sets the in emp id.
	 *
	 * @param inEmpId the inEmpId to set
	 */
	public void setInEmpId(Long inEmpId) {
		this.inEmpId = inEmpId;
	}

	/**
	 * Gets the system excluded.
	 *
	 * @return the systemExcluded
	 */
	public int getSystemExcluded() {
		return systemExcluded;
	}

	/**
	 * Sets the system excluded.
	 *
	 * @param systemExcluded the systemExcluded to set
	 */
	public void setSystemExcluded(int systemExcluded) {
		this.systemExcluded = systemExcluded;
	}

	/**
	 * Gets the increment type.
	 *
	 * @return the incrementType
	 */
	public String getIncrementType() {
		return incrementType;
	}

	/**
	 * Sets the increment type.
	 *
	 * @param incrementType the incrementType to set
	 */
	public void setIncrementType(String incrementType) {
		this.incrementType = incrementType;
	}

	/**
	 * Gets the gpf no.
	 *
	 * @return the gpfNo
	 */
	public String getGpf() {
		return gpf;
	}

	/**
	 * Sets the gpf no.
	 *
	 * @param gpf the new gpf
	 */
	public void setGpf(String gpf) {
		this.gpf = gpf;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(classId, curBasicPay, curCellId, curGrade, curGradePay, curPayBand, curPayBandValue,
				curPayLevel, curScale, dateNxtInc, designationId, diffAmt, empId, empType, eolEndDate, eolStartDate,
				gpf, inEmpId, inEventId, incrementType, reasonForExclude, remarks, revBasicPay, revCellId,
				revDateNexInc, revEffDate, revGrade, revGradePay, revPayBand, revPayBandValue, revPayLevel, revScale,
				statusId, stopIncFromDate, stopIncToDate, stopIncrementType, susEndDate, susStartDate, systemExcluded);
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
		if (!(obj instanceof PVUIncrementEmpEntity)) {
			return false;
		}
		PVUIncrementEmpEntity other = (PVUIncrementEmpEntity) obj;
		return Objects.equals(classId, other.classId) && curBasicPay == other.curBasicPay
				&& Objects.equals(curCellId, other.curCellId) && Objects.equals(curGrade, other.curGrade)
				&& Objects.equals(curGradePay, other.curGradePay) && Objects.equals(curPayBand, other.curPayBand)
				&& curPayBandValue == other.curPayBandValue && Objects.equals(curPayLevel, other.curPayLevel)
				&& Objects.equals(curScale, other.curScale) && Objects.equals(dateNxtInc, other.dateNxtInc)
				&& Objects.equals(designationId, other.designationId) && diffAmt == other.diffAmt
				&& Objects.equals(empId, other.empId) && Objects.equals(empType, other.empType)
				&& Objects.equals(eolEndDate, other.eolEndDate) && Objects.equals(eolStartDate, other.eolStartDate)
				&& Objects.equals(gpf, other.gpf) && Objects.equals(inEmpId, other.inEmpId)
				&& Objects.equals(inEventId, other.inEventId) && Objects.equals(incrementType, other.incrementType)
				&& Objects.equals(reasonForExclude, other.reasonForExclude) && Objects.equals(remarks, other.remarks)
				&& revBasicPay == other.revBasicPay && Objects.equals(revCellId, other.revCellId)
				&& Objects.equals(revDateNexInc, other.revDateNexInc) && Objects.equals(revEffDate, other.revEffDate)
				&& Objects.equals(revGrade, other.revGrade) && Objects.equals(revGradePay, other.revGradePay)
				&& Objects.equals(revPayBand, other.revPayBand) && revPayBandValue == other.revPayBandValue
				&& Objects.equals(revPayLevel, other.revPayLevel) && Objects.equals(revScale, other.revScale)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(stopIncFromDate, other.stopIncFromDate)
				&& Objects.equals(stopIncToDate, other.stopIncToDate)
				&& Objects.equals(stopIncrementType, other.stopIncrementType)
				&& Objects.equals(susEndDate, other.susEndDate) && Objects.equals(susStartDate, other.susStartDate)
				&& systemExcluded == other.systemExcluded;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format(
				"PVUIncrementEmpEntity [inEmpId=%s, inEventId=%s, empId=%s, curPayLevel=%s, curCellId=%s, curGrade=%s, curScale=%s, curPayBand=%s, curPayBandValue=%s, curGradePay=%s, curBasicPay=%s, revPayLevel=%s, revCellId=%s, revGrade=%s, revScale=%s, revPayBand=%s, revPayBandValue=%s, revGradePay=%s, revBasicPay=%s, revEffDate=%s, revDateNexInc=%s, diffAmt=%s, reasonForExclude=%s, stopIncrementType=%s, stopIncFromDate=%s, stopIncToDate=%s, dateNxtInc=%s, susStartDate=%s, susEndDate=%s, eolStartDate=%s, eolEndDate=%s, classId=%s, designationId=%s, empType=%s, remarks=%s, statusId=%s, systemExcluded=%s, incrementType=%s, gpf=%s]",
				inEmpId, inEventId, empId, curPayLevel, curCellId, curGrade, curScale, curPayBand, curPayBandValue,
				curGradePay, curBasicPay, revPayLevel, revCellId, revGrade, revScale, revPayBand, revPayBandValue,
				revGradePay, revBasicPay, revEffDate, revDateNexInc, diffAmt, reasonForExclude, stopIncrementType,
				stopIncFromDate, stopIncToDate, dateNxtInc, susStartDate, susEndDate, eolStartDate, eolEndDate, classId,
				designationId, empType, remarks, statusId, systemExcluded, incrementType, gpf);
	}

}
