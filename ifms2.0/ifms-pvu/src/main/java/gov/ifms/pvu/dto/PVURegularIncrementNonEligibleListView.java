package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;

@NativeQueryResultEntity
public class PVURegularIncrementNonEligibleListView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The in emp id. */
	@NativeQueryResultColumn(index = 0)
	private Long inEmpId;

	/** The emp id. */
	@NativeQueryResultColumn(index = 1)
	private Long empId;

	@NativeQueryResultColumn(index = 2)
	private Long empNo;

	/** The emp id. */
	@NativeQueryResultColumn(index = 3)
	private String empName;

	@NativeQueryResultColumn(index = 4)
	private String gpf;

	@NativeQueryResultColumn(index = 5)
	private Long classId;

	/** The cur pay level. */
	@NativeQueryResultColumn(index = 6)
	private String className;

	@NativeQueryResultColumn(index = 7)
	private Long designationId;

	/** The cur cell id. */
	@NativeQueryResultColumn(index = 8)
	private String designationName;

	/** The cur grade. */
	@NativeQueryResultColumn(index = 9)
	private Date dateOfJoining;

	/** The cur pay level. */
	@NativeQueryResultColumn(index = 10)
	private Long curPayLevel;

	/** The cur pay level. */
	@NativeQueryResultColumn(index = 11)
	private String curPayLevelValue;

	/** The cur cell id. */
	@NativeQueryResultColumn(index = 12)
	private Long curCellId;

	@NativeQueryResultColumn(index = 13)
	private Long curCellIdValue;

	/** The cur grade. */
	@NativeQueryResultColumn(index = 14)
	private Long curGrade;

	/** The cur grade. */
	@NativeQueryResultColumn(index = 15)
	private String curGradeValue;

	/** The cur scale. */
	@NativeQueryResultColumn(index = 16)
	private Long curScale;

	@NativeQueryResultColumn(index = 17)
	private String curScaleValue;

	/** The cur pay band value. */
	@NativeQueryResultColumn(index = 18)
	private Long curPayBandValue;

	/** The cur grade pay. */
	@NativeQueryResultColumn(index = 19)
	private Long curGradePay;

	@NativeQueryResultColumn(index = 20)
	private String curGradePayValue;

	/** The cur basic pay. */
	@NativeQueryResultColumn(index = 21)
	private Long curBasicPay;

	/** The rev pay level. */
	@NativeQueryResultColumn(index = 22)
	private Long revPayLevel;

	@NativeQueryResultColumn(index = 23)
	private String revPayLevelValue;

	/** The rev cell id. */
	@NativeQueryResultColumn(index = 24)
	private Long revCellId;

	@NativeQueryResultColumn(index = 25)
	private Long revCellIdValue;

	/** The rev grade. */
	@NativeQueryResultColumn(index = 26)
	private Long revGrade;

	@NativeQueryResultColumn(index = 27)
	private String revGradeValue;

	/** The rev scale. */
	@NativeQueryResultColumn(index = 28)
	private Long revScale;

	@NativeQueryResultColumn(index = 29)
	private String revScaleValue;

	/** The rev pay band value. */
	@NativeQueryResultColumn(index = 30)
	private Long revPayBandValue;

	/** The rev grade pay. */
	@NativeQueryResultColumn(index = 31)
	private Long revGradePay;

	@NativeQueryResultColumn(index = 32)
	private String revGradePayValue;

	/** The rev basic pay. */
	@NativeQueryResultColumn(index = 33)
	private Long revBasicPay;

	/** The rev eff date. */
	@NativeQueryResultColumn(index = 34)
	private Date revEffDate;

	/** The rev date nex inc. */
	@NativeQueryResultColumn(index = 35)
	private Date revDateNexInc;

	/** The diff amt. */
	@NativeQueryResultColumn(index = 36)
	private Long diffAmt;

	/** The reason for exclude. */
	@NativeQueryResultColumn(index = 37)
	private Long reasonForExclude;

	@NativeQueryResultColumn(index = 38)
	private String reasonForExcludeValue;

	@NativeQueryResultColumn(index = 39)
	private Long stopIncrementType;

	@NativeQueryResultColumn(index = 40)
	private String stopIncrementTypeValue;

	/** The from date. */
	@NativeQueryResultColumn(index = 41)
	private Date stopIncFromDate;

	/** The to date. */
	@NativeQueryResultColumn(index = 42)
	private Date stopIncToDate;

	/** The date nxt inc. */
	@NativeQueryResultColumn(index = 43)
	private Date dateNxtInc;

	@NativeQueryResultColumn(index = 44)
	private Date susStartDate;

	@NativeQueryResultColumn(index = 45)
	private Date susEndDate;

	@NativeQueryResultColumn(index = 46)
	private Date eolStartDate;

	@NativeQueryResultColumn(index = 47)
	private Date eolEndDate;

	@NativeQueryResultColumn(index = 48)
	private String remarks;

	@NativeQueryResultColumn(index = 49)
	private Long recordCount;

	@NativeQueryResultColumn(index = 50)
	private Long aplPayComm;

	@NativeQueryResultColumn(index = 51)
	private Integer systemExcluded;

	@NativeQueryResultColumn(index = 52)
	private Integer systemExcludedBy;

	@NativeQueryResultColumn(index = 53)
	private Long curPayBand;

	@NativeQueryResultColumn(index = 54)
	private String curPayBandRange;

	@NativeQueryResultColumn(index = 55)
	private Long revPayBand;

	@NativeQueryResultColumn(index = 56)
	private String revPayBandRange;

	@NativeQueryResultColumn(index = 57)
	private String incrementType;

	@NativeQueryResultColumn(index = 58)
	private Long empType;

	@NativeQueryResultColumn(index = 59)
	private Integer isEligible;

	@NativeQueryResultColumn(index = 60)
	private Integer isIncluded;

	@NativeQueryResultColumn(index = 61)
	private Integer deptCategory;

	@NativeQueryResultColumn(index = 62)
	private Integer whlIsEligible;

	@NativeQueryResultColumn(index = 63)
	private Long lastPayScale;

	@NativeQueryResultColumn(index = 64)
	private Long lastGradepay;

	@NativeQueryResultColumn(index = 65)
	private Long lastPayLevel;

	@NativeQueryResultColumn(index = 66)
	private String userRemarks;

	public Long getInEmpId() {
		return inEmpId;
	}

	public void setInEmpId(Long inEmpId) {
		this.inEmpId = inEmpId;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getGpf() {
		return gpf;
	}

	public void setGpf(String gpf) {
		this.gpf = gpf;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
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

	public Long getCurPayLevel() {
		return curPayLevel;
	}

	public void setCurPayLevel(Long curPayLevel) {
		this.curPayLevel = curPayLevel;
	}

	public String getCurPayLevelValue() {
		return curPayLevelValue;
	}

	public void setCurPayLevelValue(String curPayLevelValue) {
		this.curPayLevelValue = curPayLevelValue;
	}

	public Long getCurCellId() {
		return curCellId;
	}

	public void setCurCellId(Long curCellId) {
		this.curCellId = curCellId;
	}

	public Long getCurCellIdValue() {
		return curCellIdValue;
	}

	public void setCurCellIdValue(Long curCellIdValue) {
		this.curCellIdValue = curCellIdValue;
	}

	public Long getCurGrade() {
		return curGrade;
	}

	public void setCurGrade(Long curGrade) {
		this.curGrade = curGrade;
	}

	public String getCurGradeValue() {
		return curGradeValue;
	}

	public void setCurGradeValue(String curGradeValue) {
		this.curGradeValue = curGradeValue;
	}

	public Long getCurScale() {
		return curScale;
	}

	public void setCurScale(Long curScale) {
		this.curScale = curScale;
	}

	public String getCurScaleValue() {
		return curScaleValue;
	}

	public void setCurScaleValue(String curScaleValue) {
		this.curScaleValue = curScaleValue;
	}

	public Long getCurPayBandValue() {
		return curPayBandValue;
	}

	public void setCurPayBandValue(Long curPayBandValue) {
		this.curPayBandValue = curPayBandValue;
	}

	public Long getCurGradePay() {
		return curGradePay;
	}

	public void setCurGradePay(Long curGradePay) {
		this.curGradePay = curGradePay;
	}

	public String getCurGradePayValue() {
		return curGradePayValue;
	}

	public void setCurGradePayValue(String curGradePayValue) {
		this.curGradePayValue = curGradePayValue;
	}

	public Long getCurBasicPay() {
		return curBasicPay;
	}

	public void setCurBasicPay(Long curBasicPay) {
		this.curBasicPay = curBasicPay;
	}

	public Long getRevPayLevel() {
		return revPayLevel;
	}

	public void setRevPayLevel(Long revPayLevel) {
		this.revPayLevel = revPayLevel;
	}

	public String getRevPayLevelValue() {
		return revPayLevelValue;
	}

	public void setRevPayLevelValue(String revPayLevelValue) {
		this.revPayLevelValue = revPayLevelValue;
	}

	public Long getRevCellId() {
		return revCellId;
	}

	public void setRevCellId(Long revCellId) {
		this.revCellId = revCellId;
	}

	public Long getRevCellIdValue() {
		return revCellIdValue;
	}

	public void setRevCellIdValue(Long revCellIdValue) {
		this.revCellIdValue = revCellIdValue;
	}

	public Long getRevGrade() {
		return revGrade;
	}

	public void setRevGrade(Long revGrade) {
		this.revGrade = revGrade;
	}

	public String getRevGradeValue() {
		return revGradeValue;
	}

	public void setRevGradeValue(String revGradeValue) {
		this.revGradeValue = revGradeValue;
	}

	public Long getRevScale() {
		return revScale;
	}

	public void setRevScale(Long revScale) {
		this.revScale = revScale;
	}

	public String getRevScaleValue() {
		return revScaleValue;
	}

	public void setRevScaleValue(String revScaleValue) {
		this.revScaleValue = revScaleValue;
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

	public String getRevGradePayValue() {
		return revGradePayValue;
	}

	public void setRevGradePayValue(String revGradePayValue) {
		this.revGradePayValue = revGradePayValue;
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

	public Long getReasonForExclude() {
		return reasonForExclude;
	}

	public void setReasonForExclude(Long reasonForExclude) {
		this.reasonForExclude = reasonForExclude;
	}

	public String getReasonForExcludeValue() {
		return reasonForExcludeValue;
	}

	public void setReasonForExcludeValue(String reasonForExcludeValue) {
		this.reasonForExcludeValue = reasonForExcludeValue;
	}

	public Long getStopIncrementType() {
		return stopIncrementType;
	}

	public void setStopIncrementType(Long stopIncrementType) {
		this.stopIncrementType = stopIncrementType;
	}

	public String getStopIncrementTypeValue() {
		return stopIncrementTypeValue;
	}

	public void setStopIncrementTypeValue(String stopIncrementTypeValue) {
		this.stopIncrementTypeValue = stopIncrementTypeValue;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}

	public Long getAplPayComm() {
		return aplPayComm;
	}

	public void setAplPayComm(Long aplPayComm) {
		this.aplPayComm = aplPayComm;
	}

	public Integer getSystemExcluded() {
		return systemExcluded;
	}

	public void setSystemExcluded(Integer systemExcluded) {
		this.systemExcluded = systemExcluded;
	}

	public Integer getSystemExcludedBy() {
		return systemExcludedBy;
	}

	public void setSystemExcludedBy(Integer systemExcludedBy) {
		this.systemExcludedBy = systemExcludedBy;
	}

	public Long getCurPayBand() {
		return curPayBand;
	}

	public void setCurPayBand(Long curPayBand) {
		this.curPayBand = curPayBand;
	}

	public String getCurPayBandRange() {
		return curPayBandRange;
	}

	public void setCurPayBandRange(String curPayBandRange) {
		this.curPayBandRange = curPayBandRange;
	}

	public Long getRevPayBand() {
		return revPayBand;
	}

	public void setRevPayBand(Long revPayBand) {
		this.revPayBand = revPayBand;
	}

	public String getRevPayBandRange() {
		return revPayBandRange;
	}

	public void setRevPayBandRange(String revPayBandRange) {
		this.revPayBandRange = revPayBandRange;
	}

	public String getIncrementType() {
		return incrementType;
	}

	public void setIncrementType(String incrementType) {
		this.incrementType = incrementType;
	}

	public Long getEmpType() {
		return empType;
	}

	public void setEmpType(Long empType) {
		this.empType = empType;
	}

	public Integer getIsEligible() {
		return isEligible;
	}

	public void setIsEligible(Integer isEligible) {
		this.isEligible = isEligible;
	}

	public Integer getIsIncluded() {
		return isIncluded;
	}

	public void setIsIncluded(Integer isIncluded) {
		this.isIncluded = isIncluded;
	}

	public Integer getDeptCategory() {
		return deptCategory;
	}

	public void setDeptCategory(Integer deptCategory) {
		this.deptCategory = deptCategory;
	}

	public Integer getWhlIsEligible() {
		return whlIsEligible;
	}

	public void setWhlIsEligible(Integer whlIsEligible) {
		this.whlIsEligible = whlIsEligible;
	}

	public Long getLastPayScale() {
		return lastPayScale;
	}

	public void setLastPayScale(Long lastPayScale) {
		this.lastPayScale = lastPayScale;
	}

	public Long getLastGradepay() {
		return lastGradepay;
	}

	public void setLastGradepay(Long lastGradepay) {
		this.lastGradepay = lastGradepay;
	}

	public Long getLastPayLevel() {
		return lastPayLevel;
	}

	public void setLastPayLevel(Long lastPayLevel) {
		this.lastPayLevel = lastPayLevel;
	}

	public String getUserRemarks() {
		return userRemarks;
	}

	public void setUserRemarks(String userRemarks) {
		this.userRemarks = userRemarks;
	}

	public PVURegularIncrementNonEligibleListView() {
	}
}
