package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.BaseDto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Class PVUIncrementEmpDto.
 * 
 * @version v 1.0
 * @created 2020/01/12 19:19:14
 *
 */
/**
 * @author AM20098888
 *
 */
public class PVUIncrementEmpSDDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The in emp id. */
	private long idEmpSDId;

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
	private Long revPayLevel;

	/** The rev cell id. */
	private Long revCellId;

	/** The rev grade. */
	private Long revGrade;

	/** The rev scale. */
	private Long revScale;

	/** The rev pay band. */
	private Long revPayBand;

	/** The rev pay band value. */
	private Long revPayBandValue;

	/** The rev grade pay. */
	private Long revGradePay;

	/** The rev basic pay. */
	private Long revBasicPay;

	/** The rev eff date. */
	private Date revEffDate;

	/** The rev date nex inc. */
	private Date revDateNexInc;

	/** The diff amt. */
	private Long diffAmt;

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
	

	private long isEligible;
	private long isIncluded;
	private long deptCategory;
	private long lastPayScale;
	private long whlIsEligible;
	private long lastPayLevel;
	private long lastGradePay;
	private long  empNo;
	private String empName;
	private String className;
	private String designationName;
	private Date dateOfJoining;
	private String curPayLevelValue;
	private long curCellIdValue;
	private String curPayBandRange;
	private String curGradePayValue;
	private String curScaleValue;
	private PVUIncrementSTPSDDto reasonForExclusion;
	private String reasonForExcludeValue;
	private String  userRemarks;


	public String getUserRemarks() {
		return userRemarks;
	}

	public void setUserRemarks(String userRemarks) {
		this.userRemarks = userRemarks;
	}

	/**
	 * PVUIncrementEmpDto Constructor.
	 */
	public PVUIncrementEmpSDDto() {
		super();
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

	public long getIdEmpSDId() {
		return idEmpSDId;
	}

	public void setIdEmpSDId(long idEmpSDId) {
		this.idEmpSDId = idEmpSDId;
	}

	public void setCurGradePay(long curGradePay) {
		this.curGradePay = curGradePay;
	}

	public long getCurBasicPay() {
		return curBasicPay;
	}

	public void setCurBasicPay(long curBasicPay) {
		this.curBasicPay = curBasicPay;
	}

	public Long getRevPayLevel() {
		return revPayLevel;
	}

	public void setRevPayLevel(Long revPayLevel) {
		this.revPayLevel = revPayLevel;
	}

	public Long getRevCellId() {
		return revCellId;
	}

	public void setRevCellId(Long revCellId) {
		this.revCellId = revCellId;
	}

	public Long getRevGrade() {
		return revGrade;
	}

	public void setRevGrade(Long revGrade) {
		this.revGrade = revGrade;
	}

	public Long getRevScale() {
		return revScale;
	}

	public void setRevScale(Long revScale) {
		this.revScale = revScale;
	}

	public Long getRevPayBand() {
		return revPayBand;
	}

	public void setRevPayBand(Long revPayBand) {
		this.revPayBand = revPayBand;
	}

	public Long getRevPayBandValue() {
		return revPayBandValue;
	}

	public void setRevPayBandValue(Long revPayBandValue) {
		this.revPayBandValue = revPayBandValue;
	}

	public Long getRevGradePay() {
		return revGradePay;
	}

	public void setRevGradePay(Long revGradePay) {
		this.revGradePay = revGradePay;
	}

	public Long getRevBasicPay() {
		return revBasicPay;
	}

	public void setRevBasicPay(Long revBasicPay) {
		this.revBasicPay = revBasicPay;
	}

	public Date getRevEffDate() {
		return revEffDate;
	}

	public void setRevEffDate(Date revEffDate) {
		this.revEffDate = revEffDate;
	}

	public Date getRevDateNexInc() {
		return revDateNexInc;
	}

	public void setRevDateNexInc(Date revDateNexInc) {
		this.revDateNexInc = revDateNexInc;
	}

	public Long getDiffAmt() {
		return diffAmt;
	}

	public void setDiffAmt(Long diffAmt) {
		this.diffAmt = diffAmt;
	}

	public long getReasonForExclude() {
		return reasonForExclude;
	}

	public void setReasonForExclude(long reasonForExclude) {
		this.reasonForExclude = reasonForExclude;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public long getStopIncrementType() {
		return stopIncrementType;
	}

	public void setStopIncrementType(long stopIncrementType) {
		this.stopIncrementType = stopIncrementType;
	}

	public Date getStopIncFromDate() {
		return stopIncFromDate;
	}

	public void setStopIncFromDate(Date stopIncFromDate) {
		this.stopIncFromDate = stopIncFromDate;
	}

	public Date getStopIncToDate() {
		return stopIncToDate;
	}

	public void setStopIncToDate(Date stopIncToDate) {
		this.stopIncToDate = stopIncToDate;
	}

	public Date getDateNxtInc() {
		return dateNxtInc;
	}

	public void setDateNxtInc(Date dateNxtInc) {
		this.dateNxtInc = dateNxtInc;
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}

	public Date getSusStartDate() {
		return susStartDate;
	}

	public void setSusStartDate(Date susStartDate) {
		this.susStartDate = susStartDate;
	}

	public Date getSusEndDate() {
		return susEndDate;
	}

	public void setSusEndDate(Date susEndDate) {
		this.susEndDate = susEndDate;
	}

	public Date getEolStartDate() {
		return eolStartDate;
	}

	public void setEolStartDate(Date eolStartDate) {
		this.eolStartDate = eolStartDate;
	}

	public Date getEolEndDate() {
		return eolEndDate;
	}

	public void setEolEndDate(Date eolEndDate) {
		this.eolEndDate = eolEndDate;
	}

	public int getSystemExcluded() {
		return systemExcluded;
	}

	public void setSystemExcluded(int systemExcluded) {
		this.systemExcluded = systemExcluded;
	}

	public String getIncrementType() {
		return incrementType;
	}

	public void setIncrementType(String incrementType) {
		this.incrementType = incrementType;
	}

	public long getEmpType() {
		return empType;
	}

	public void setEmpType(long empType) {
		this.empType = empType;
	}

	public String getGpf() {
		return gpf;
	}

	public void setGpf(String gpf) {
		this.gpf = gpf;
	}

	public long getIsEligible() {
		return isEligible;
	}

	public void setIsEligible(long isEligible) {
		this.isEligible = isEligible;
	}

	public long getIsIncluded() {
		return isIncluded;
	}

	public void setIsIncluded(long isIncluded) {
		this.isIncluded = isIncluded;
	}

	public long getDeptCategory() {
		return deptCategory;
	}

	public void setDeptCategory(long deptCategory) {
		this.deptCategory = deptCategory;
	}

	public long getLastPayScale() {
		return lastPayScale;
	}

	public void setLastPayScale(long lastPayScale) {
		this.lastPayScale = lastPayScale;
	}

	public long getWhlIsEligible() {
		return whlIsEligible;
	}

	public void setWhlIsEligible(long whlIsEligible) {
		this.whlIsEligible = whlIsEligible;
	}

	public long getLastPayLevel() {
		return lastPayLevel;
	}

	public void setLastPayLevel(long lastPayLevel) {
		this.lastPayLevel = lastPayLevel;
	}

	public long getLastGradePay() {
		return lastGradePay;
	}

	public void setLastGradePay(long lastGradePay) {
		this.lastGradePay = lastGradePay;
	}

	public long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(long empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getCurPayLevelValue() {
		return curPayLevelValue;
	}

	public void setCurPayLevelValue(String curPayLevelValue) {
		this.curPayLevelValue = curPayLevelValue;
	}

	public long getCurCellIdValue() {
		return curCellIdValue;
	}

	public void setCurCellIdValue(long curCellIdValue) {
		this.curCellIdValue = curCellIdValue;
	}

	public String getCurPayBandRange() {
		return curPayBandRange;
	}

	public void setCurPayBandRange(String curPayBandRange) {
		this.curPayBandRange = curPayBandRange;
	}

	public String getCurGradePayValue() {
		return curGradePayValue;
	}

	public void setCurGradePayValue(String curGradePayValue) {
		this.curGradePayValue = curGradePayValue;
	}

	public String getCurScaleValue() {
		return curScaleValue;
	}

	public void setCurScaleValue(String curScaleValue) {
		this.curScaleValue = curScaleValue;
	}

	public PVUIncrementSTPSDDto getReasonForExclusion() {
		return reasonForExclusion;
	}

	public void setReasonForExclusion(PVUIncrementSTPSDDto reasonForExclusion) {
		this.reasonForExclusion = reasonForExclusion;
	}

	public String getReasonForExcludeValue() {
		return reasonForExcludeValue;
	}

	public void setReasonForExcludeValue(String reasonForExcludeValue) {
		this.reasonForExcludeValue = reasonForExcludeValue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUIncrementEmpSDDto)) return false;
		if (!super.equals(o)) return false;
		PVUIncrementEmpSDDto that = (PVUIncrementEmpSDDto) o;
		return getIdEmpSDId() == that.getIdEmpSDId() && getInEventId() == that.getInEventId() && getEmpId() == that.getEmpId() && getCurPayLevel() == that.getCurPayLevel() && getCurCellId() == that.getCurCellId() && getCurGrade() == that.getCurGrade() && getCurScale() == that.getCurScale() && getCurPayBand() == that.getCurPayBand() && getCurPayBandValue() == that.getCurPayBandValue() && getCurGradePay() == that.getCurGradePay() && getCurBasicPay() == that.getCurBasicPay() && getReasonForExclude() == that.getReasonForExclude() && getStatusId() == that.getStatusId() && getStopIncrementType() == that.getStopIncrementType() && getClassId() == that.getClassId() && getDesignationId() == that.getDesignationId() && getSystemExcluded() == that.getSystemExcluded() && getEmpType() == that.getEmpType() && getIsEligible() == that.getIsEligible() && getIsIncluded() == that.getIsIncluded() && getDeptCategory() == that.getDeptCategory() && getLastPayScale() == that.getLastPayScale() && getWhlIsEligible() == that.getWhlIsEligible() && getLastPayLevel() == that.getLastPayLevel() && getLastGradePay() == that.getLastGradePay() && getEmpNo() == that.getEmpNo() && getCurCellIdValue() == that.getCurCellIdValue() && Objects.equals(getRevPayLevel(), that.getRevPayLevel()) && Objects.equals(getRevCellId(), that.getRevCellId()) && Objects.equals(getRevGrade(), that.getRevGrade()) && Objects.equals(getRevScale(), that.getRevScale()) && Objects.equals(getRevPayBand(), that.getRevPayBand()) && Objects.equals(getRevPayBandValue(), that.getRevPayBandValue()) && Objects.equals(getRevGradePay(), that.getRevGradePay()) && Objects.equals(getRevBasicPay(), that.getRevBasicPay()) && Objects.equals(getRevEffDate(), that.getRevEffDate()) && Objects.equals(getRevDateNexInc(), that.getRevDateNexInc()) && Objects.equals(getDiffAmt(), that.getDiffAmt()) && Objects.equals(getRemarks(), that.getRemarks()) && Objects.equals(getStopIncFromDate(), that.getStopIncFromDate()) && Objects.equals(getStopIncToDate(), that.getStopIncToDate()) && Objects.equals(getDateNxtInc(), that.getDateNxtInc()) && Objects.equals(getSusStartDate(), that.getSusStartDate()) && Objects.equals(getSusEndDate(), that.getSusEndDate()) && Objects.equals(getEolStartDate(), that.getEolStartDate()) && Objects.equals(getEolEndDate(), that.getEolEndDate()) && Objects.equals(getIncrementType(), that.getIncrementType()) && Objects.equals(getGpf(), that.getGpf()) && Objects.equals(getEmpName(), that.getEmpName()) && Objects.equals(getClassName(), that.getClassName()) && Objects.equals(getDesignationName(), that.getDesignationName()) && Objects.equals(getDateOfJoining(), that.getDateOfJoining()) && Objects.equals(getCurPayLevelValue(), that.getCurPayLevelValue()) && Objects.equals(getCurPayBandRange(), that.getCurPayBandRange()) && Objects.equals(getCurGradePayValue(), that.getCurGradePayValue()) && Objects.equals(getCurScaleValue(), that.getCurScaleValue()) && Objects.equals(getReasonForExclusion(), that.getReasonForExclusion()) && Objects.equals(getReasonForExcludeValue(), that.getReasonForExcludeValue());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getIdEmpSDId(), getInEventId(), getEmpId(), getCurPayLevel(), getCurCellId(), getCurGrade(), getCurScale(), getCurPayBand(), getCurPayBandValue(), getCurGradePay(), getCurBasicPay(), getRevPayLevel(), getRevCellId(), getRevGrade(), getRevScale(), getRevPayBand(), getRevPayBandValue(), getRevGradePay(), getRevBasicPay(), getRevEffDate(), getRevDateNexInc(), getDiffAmt(), getReasonForExclude(), getRemarks(), getStatusId(), getStopIncrementType(), getStopIncFromDate(), getStopIncToDate(), getDateNxtInc(), getClassId(), getDesignationId(), getSusStartDate(), getSusEndDate(), getEolStartDate(), getEolEndDate(), getSystemExcluded(), getIncrementType(), getEmpType(), getGpf(), getIsEligible(), getIsIncluded(), getDeptCategory(), getLastPayScale(), getWhlIsEligible(), getLastPayLevel(), getLastGradePay(), getEmpNo(), getEmpName(), getClassName(), getDesignationName(), getDateOfJoining(), getCurPayLevelValue(), getCurCellIdValue(), getCurPayBandRange(), getCurGradePayValue(), getCurScaleValue(), getReasonForExclusion(), getReasonForExcludeValue());
	}

	@Override
	public String toString() {
		return "PVUIncrementEmpSDDto{" +
				"idEmpSDId=" + idEmpSDId +
				", inEventId=" + inEventId +
				", empId=" + empId +
				", curPayLevel=" + curPayLevel +
				", curCellId=" + curCellId +
				", curGrade=" + curGrade +
				", curScale=" + curScale +
				", curPayBand=" + curPayBand +
				", curPayBandValue=" + curPayBandValue +
				", curGradePay=" + curGradePay +
				", curBasicPay=" + curBasicPay +
				", revPayLevel=" + revPayLevel +
				", revCellId=" + revCellId +
				", revGrade=" + revGrade +
				", revScale=" + revScale +
				", revPayBand=" + revPayBand +
				", revPayBandValue=" + revPayBandValue +
				", revGradePay=" + revGradePay +
				", revBasicPay=" + revBasicPay +
				", revEffDate=" + revEffDate +
				", revDateNexInc=" + revDateNexInc +
				", diffAmt=" + diffAmt +
				", reasonForExclude=" + reasonForExclude +
				", remarks='" + remarks + '\'' +
				", statusId=" + statusId +
				", stopIncrementType=" + stopIncrementType +
				", stopIncFromDate=" + stopIncFromDate +
				", stopIncToDate=" + stopIncToDate +
				", dateNxtInc=" + dateNxtInc +
				", classId=" + classId +
				", designationId=" + designationId +
				", susStartDate=" + susStartDate +
				", susEndDate=" + susEndDate +
				", eolStartDate=" + eolStartDate +
				", eolEndDate=" + eolEndDate +
				", systemExcluded=" + systemExcluded +
				", incrementType='" + incrementType + '\'' +
				", empType=" + empType +
				", gpf='" + gpf + '\'' +
				", isEligible=" + isEligible +
				", isIncluded=" + isIncluded +
				", deptCategory=" + deptCategory +
				", lastPayScale=" + lastPayScale +
				", whlIsEligible=" + whlIsEligible +
				", lastPayLevel=" + lastPayLevel +
				", lastGradePay=" + lastGradePay +
				", empNo=" + empNo +
				", empName='" + empName + '\'' +
				", className='" + className + '\'' +
				", designationName='" + designationName + '\'' +
				", dateOfJoining=" + dateOfJoining +
				", curPayLevelValue='" + curPayLevelValue + '\'' +
				", curCellIdValue=" + curCellIdValue +
				", curPayBandRange='" + curPayBandRange + '\'' +
				", curGradePayValue='" + curGradePayValue + '\'' +
				", curScaleValue='" + curScaleValue + '\'' +
				", reasonForExclusion=" + reasonForExclusion +
				", reasonForExcludeValue='" + reasonForExcludeValue + '\'' +
				'}';
	}
}
