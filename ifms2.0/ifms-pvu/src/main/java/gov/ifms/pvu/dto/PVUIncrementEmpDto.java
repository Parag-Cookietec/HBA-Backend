package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUIncrementEmpDto.
 * 
 * @version v 1.0
 * @created 2020/01/12 19:19:14
 *
 */
public class PVUIncrementEmpDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The in emp id. */
	private long inEmpId;

	/** The in event id. */
	private long inEventId;

	/** The emp id. */
	private long empId;

	/** The cur pay level. */
	private long curPayLevel;

	/** The cur cell id. */
	private long curCellId;

	/** The cur grade. */
	private long curGrade;

	/** The cur scale. */
	private long curScale;

	/** The cur pay band. */
	private long curPayBand;

	/** The cur pay band value. */
	private long curPayBandValue;

	/** The cur grade pay. */
	private long curGradePay;

	/** The cur basic pay. */
	private long curBasicPay;

	/** The rev pay level. */
	private long revPayLevel;

	/** The rev cell id. */
	private long revCellId;

	/** The rev grade. */
	private long revGrade;

	/** The rev scale. */
	private long revScale;

	/** The rev pay band. */
	private long revPayBand;

	/** The rev pay band value. */
	private long revPayBandValue;

	/** The rev grade pay. */
	private long revGradePay;

	/** The rev basic pay. */
	private long revBasicPay;

	/** The rev eff date. */
	private Date revEffDate;

	/** The rev date nex inc. */
	private Date revDateNexInc;

	/** The diff amt. */
	private long diffAmt;

	/** The reason for exclude. */
	private long reasonForExclude;

	/** The remarks. */
	private String remarks;

	/** The status id. */
	private long statusId;

	/** The stop increment type. */
	private long stopIncrementType;

	/** The from date. */
	private Date stopIncFromDate;

	/** The to date. */
	private Date stopIncToDate;

	/** The date nxt inc. */
	private Date dateNxtInc;

	/** The class id. */
	private long classId;

	/** The designation id. */
	private long designationId;

	/** The sus start date. */
	private Date susStartDate;

	/** The sus end date. */
	private Date susEndDate;

	/** The eol start date. */
	private Date eolStartDate;

	/** The eol end date. */
	private Date eolEndDate;

	/** The exclude by. */
	private int systemExcluded;

	/** The increment type. */
	private String incrementType;

	/** The emp type. */
	private long empType;

	/** The gpf. */
	private String gpf;

	/**
	 * PVUIncrementEmpDto Constructor.
	 */
	public PVUIncrementEmpDto() {
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
	public long getInEventId() {
		return inEventId;
	}

	/**
	 * Sets the in event id.
	 *
	 * @param inEventId the inEventId to set
	 */
	public void setInEventId(long inEventId) {
		this.inEventId = inEventId;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the cur pay level.
	 *
	 * @return the curPayLevel
	 */
	public long getCurPayLevel() {
		return curPayLevel;
	}

	/**
	 * Sets the cur pay level.
	 *
	 * @param curPayLevel the curPayLevel to set
	 */
	public void setCurPayLevel(long curPayLevel) {
		this.curPayLevel = curPayLevel;
	}

	/**
	 * Gets the cur cell id.
	 *
	 * @return the curCellId
	 */
	public long getCurCellId() {
		return curCellId;
	}

	/**
	 * Sets the cur cell id.
	 *
	 * @param curCellId the curCellId to set
	 */
	public void setCurCellId(long curCellId) {
		this.curCellId = curCellId;
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
	public long getCurScale() {
		return curScale;
	}

	/**
	 * Sets the cur scale.
	 *
	 * @param curScale the curScale to set
	 */
	public void setCurScale(long curScale) {
		this.curScale = curScale;
	}

	/**
	 * Gets the cur pay band.
	 *
	 * @return the curPayBand
	 */
	public long getCurPayBand() {
		return curPayBand;
	}

	/**
	 * Sets the cur pay band.
	 *
	 * @param curPayBand the curPayBand to set
	 */
	public void setCurPayBand(long curPayBand) {
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
	public long getCurGradePay() {
		return curGradePay;
	}

	/**
	 * Sets the cur grade pay.
	 *
	 * @param curGradePay the curGradePay to set
	 */
	public void setCurGradePay(long curGradePay) {
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
	public long getRevPayLevel() {
		return revPayLevel;
	}

	/**
	 * Sets the rev pay level.
	 *
	 * @param revPayLevel the revPayLevel to set
	 */
	public void setRevPayLevel(long revPayLevel) {
		this.revPayLevel = revPayLevel;
	}

	/**
	 * Gets the rev cell id.
	 *
	 * @return the revCellId
	 */
	public long getRevCellId() {
		return revCellId;
	}

	/**
	 * Sets the rev cell id.
	 *
	 * @param revCellId the revCellId to set
	 */
	public void setRevCellId(long revCellId) {
		this.revCellId = revCellId;
	}

	/**
	 * Gets the rev grade.
	 *
	 * @return the revGrade
	 */
	public long getRevGrade() {
		return revGrade;
	}

	/**
	 * Sets the rev grade.
	 *
	 * @param revGrade the revGrade to set
	 */
	public void setRevGrade(long revGrade) {
		this.revGrade = revGrade;
	}

	/**
	 * Gets the rev scale.
	 *
	 * @return the revScale
	 */
	public long getRevScale() {
		return revScale;
	}

	/**
	 * Sets the rev scale.
	 *
	 * @param revScale the revScale to set
	 */
	public void setRevScale(long revScale) {
		this.revScale = revScale;
	}

	/**
	 * Gets the rev pay band.
	 *
	 * @return the revPayBand
	 */
	public long getRevPayBand() {
		return revPayBand;
	}

	/**
	 * Sets the rev pay band.
	 *
	 * @param revPayBand the revPayBand to set
	 */
	public void setRevPayBand(long revPayBand) {
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
	public long getRevGradePay() {
		return revGradePay;
	}

	/**
	 * Sets the rev grade pay.
	 *
	 * @param revGradePay the revGradePay to set
	 */
	public void setRevGradePay(long revGradePay) {
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
	public long getReasonForExclude() {
		return reasonForExclude;
	}

	/**
	 * Sets the reason for exclude.
	 *
	 * @param reasonForExclude the reasonForExclude to set
	 */
	public void setReasonForExclude(long reasonForExclude) {
		this.reasonForExclude = reasonForExclude;
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
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the stop increment type.
	 *
	 * @return the stopIncrementType
	 */
	public long getStopIncrementType() {
		return stopIncrementType;
	}

	/**
	 * Sets the stop increment type.
	 *
	 * @param stopIncrementType the stopIncrementType to set
	 */
	public void setStopIncrementType(long stopIncrementType) {
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
	 * Gets the class id.
	 *
	 * @return the classId
	 */
	public long getClassId() {
		return classId;
	}

	/**
	 * Sets the class id.
	 *
	 * @param classId the classId to set
	 */
	public void setClassId(long classId) {
		this.classId = classId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public long getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(long designationId) {
		this.designationId = designationId;
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
	 * Gets the emp type.
	 *
	 * @return the empType
	 */
	public long getEmpType() {
		return empType;
	}

	/**
	 * Sets the emp type.
	 *
	 * @param empType the empType to set
	 */
	public void setEmpType(long empType) {
		this.empType = empType;
	}

	/**
	 * Gets the gpf.
	 *
	 * @return the gpf
	 */
	public String getGpf() {
		return gpf;
	}

	/**
	 * Sets the gpf.
	 *
	 * @param gpf the gpf to set
	 */
	public void setGpf(String gpf) {
		this.gpf = gpf;
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
		if (!(obj instanceof PVUIncrementEmpDto)) {
			return false;
		}
		PVUIncrementEmpDto other = (PVUIncrementEmpDto) obj;
		return classId == other.classId && curBasicPay == other.curBasicPay && curCellId == other.curCellId
				&& curGrade == other.curGrade && curGradePay == other.curGradePay && curPayBand == other.curPayBand
				&& curPayBandValue == other.curPayBandValue && curPayLevel == other.curPayLevel
				&& curScale == other.curScale && Objects.equals(dateNxtInc, other.dateNxtInc)
				&& designationId == other.designationId && diffAmt == other.diffAmt && empId == other.empId
				&& empType == other.empType && Objects.equals(eolEndDate, other.eolEndDate)
				&& Objects.equals(eolStartDate, other.eolStartDate) && Objects.equals(gpf, other.gpf)
				&& inEmpId == other.inEmpId && inEventId == other.inEventId
				&& Objects.equals(incrementType, other.incrementType) && reasonForExclude == other.reasonForExclude
				&& Objects.equals(remarks, other.remarks) && revBasicPay == other.revBasicPay
				&& revCellId == other.revCellId && Objects.equals(revDateNexInc, other.revDateNexInc)
				&& Objects.equals(revEffDate, other.revEffDate) && revGrade == other.revGrade
				&& revGradePay == other.revGradePay && revPayBand == other.revPayBand
				&& revPayBandValue == other.revPayBandValue && revPayLevel == other.revPayLevel
				&& revScale == other.revScale && statusId == other.statusId
				&& Objects.equals(stopIncFromDate, other.stopIncFromDate)
				&& Objects.equals(stopIncToDate, other.stopIncToDate) && stopIncrementType == other.stopIncrementType
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
				"PVUIncrementEmpDto [inEmpId=%s, inEventId=%s, empId=%s, curPayLevel=%s, curCellId=%s, curGrade=%s, curScale=%s, curPayBand=%s, curPayBandValue=%s, curGradePay=%s, curBasicPay=%s, revPayLevel=%s, revCellId=%s, revGrade=%s, revScale=%s, revPayBand=%s, revPayBandValue=%s, revGradePay=%s, revBasicPay=%s, revEffDate=%s, revDateNexInc=%s, diffAmt=%s, reasonForExclude=%s, remarks=%s, statusId=%s, stopIncrementType=%s, stopIncFromDate=%s, stopIncToDate=%s, dateNxtInc=%s, classId=%s, designationId=%s, susStartDate=%s, susEndDate=%s, eolStartDate=%s, eolEndDate=%s, systemExcluded=%s, incrementType=%s, empType=%s, gpf=%s]",
				inEmpId, inEventId, empId, curPayLevel, curCellId, curGrade, curScale, curPayBand, curPayBandValue,
				curGradePay, curBasicPay, revPayLevel, revCellId, revGrade, revScale, revPayBand, revPayBandValue,
				revGradePay, revBasicPay, revEffDate, revDateNexInc, diffAmt, reasonForExclude, remarks, statusId,
				stopIncrementType, stopIncFromDate, stopIncToDate, dateNxtInc, classId, designationId, susStartDate,
				susEndDate, eolStartDate, eolEndDate, systemExcluded, incrementType, empType, gpf);
	}

}
