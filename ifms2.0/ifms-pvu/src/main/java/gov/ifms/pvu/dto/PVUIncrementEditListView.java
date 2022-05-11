package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUIncrementEditListView implements Serializable {

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
	private long reasonForExclude;

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
	private int systemExcluded;

	@NativeQueryResultColumn(index = 52)
	private Long curPayBand;

	@NativeQueryResultColumn(index = 53)
	private String curPayBandRange;

	@NativeQueryResultColumn(index = 54)
	private Long revPayBand;

	@NativeQueryResultColumn(index = 55)
	private String revPayBandRange;

	@NativeQueryResultColumn(index = 56)
	private String incrementType;

	@NativeQueryResultColumn(index = 57)
	private Long empType;

	/**
	 * @return the inEmpId
	 */
	public Long getInEmpId() {
		return inEmpId;
	}

	/**
	 * @param inEmpId the inEmpId to set
	 */
	public void setInEmpId(Long inEmpId) {
		this.inEmpId = inEmpId;
	}

	/**
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * @return the empNo
	 */
	public Long getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the gpf
	 */
	public String getGpf() {
		return gpf;
	}

	/**
	 * @param gpf the gpf to set
	 */
	public void setGpf(String gpf) {
		this.gpf = gpf;
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

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the designationId
	 */
	public Long getDesignationId() {
		return designationId;
	}

	/**
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	/**
	 * @return the designationName
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * @param designationName the designationName to set
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	/**
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return the curPayLevel
	 */
	public Long getCurPayLevel() {
		return curPayLevel;
	}

	/**
	 * @param curPayLevel the curPayLevel to set
	 */
	public void setCurPayLevel(Long curPayLevel) {
		this.curPayLevel = curPayLevel;
	}

	/**
	 * @return the curPayLevelValue
	 */
	public String getCurPayLevelValue() {
		return curPayLevelValue;
	}

	/**
	 * @param curPayLevelValue the curPayLevelValue to set
	 */
	public void setCurPayLevelValue(String curPayLevelValue) {
		this.curPayLevelValue = curPayLevelValue;
	}

	/**
	 * @return the curCellId
	 */
	public Long getCurCellId() {
		return curCellId;
	}

	/**
	 * @param curCellId the curCellId to set
	 */
	public void setCurCellId(Long curCellId) {
		this.curCellId = curCellId;
	}

	/**
	 * @return the curCellIdValue
	 */
	public Long getCurCellIdValue() {
		return curCellIdValue;
	}

	/**
	 * @param curCellIdValue the curCellIdValue to set
	 */
	public void setCurCellIdValue(Long curCellIdValue) {
		this.curCellIdValue = curCellIdValue;
	}

	/**
	 * @return the curGrade
	 */
	public Long getCurGrade() {
		return curGrade;
	}

	/**
	 * @param curGrade the curGrade to set
	 */
	public void setCurGrade(Long curGrade) {
		this.curGrade = curGrade;
	}

	/**
	 * @return the curGradeValue
	 */
	public String getCurGradeValue() {
		return curGradeValue;
	}

	/**
	 * @param curGradeValue the curGradeValue to set
	 */
	public void setCurGradeValue(String curGradeValue) {
		this.curGradeValue = curGradeValue;
	}

	/**
	 * @return the curScale
	 */
	public Long getCurScale() {
		return curScale;
	}

	/**
	 * @param curScale the curScale to set
	 */
	public void setCurScale(Long curScale) {
		this.curScale = curScale;
	}

	/**
	 * @return the curScaleValue
	 */
	public String getCurScaleValue() {
		return curScaleValue;
	}

	/**
	 * @param curScaleValue the curScaleValue to set
	 */
	public void setCurScaleValue(String curScaleValue) {
		this.curScaleValue = curScaleValue;
	}

	/**
	 * @return the curPayBandValue
	 */
	public Long getCurPayBandValue() {
		return curPayBandValue;
	}

	/**
	 * @param curPayBandValue the curPayBandValue to set
	 */
	public void setCurPayBandValue(Long curPayBandValue) {
		this.curPayBandValue = curPayBandValue;
	}

	/**
	 * @return the curGradePay
	 */
	public Long getCurGradePay() {
		return curGradePay;
	}

	/**
	 * @param curGradePay the curGradePay to set
	 */
	public void setCurGradePay(Long curGradePay) {
		this.curGradePay = curGradePay;
	}

	/**
	 * @return the curGradePayValue
	 */
	public String getCurGradePayValue() {
		return curGradePayValue;
	}

	/**
	 * @param curGradePayValue the curGradePayValue to set
	 */
	public void setCurGradePayValue(String curGradePayValue) {
		this.curGradePayValue = curGradePayValue;
	}

	/**
	 * @return the curBasicPay
	 */
	public Long getCurBasicPay() {
		return curBasicPay;
	}

	/**
	 * @param curBasicPay the curBasicPay to set
	 */
	public void setCurBasicPay(Long curBasicPay) {
		this.curBasicPay = curBasicPay;
	}

	/**
	 * @return the revPayLevel
	 */
	public Long getRevPayLevel() {
		return revPayLevel;
	}

	/**
	 * @param revPayLevel the revPayLevel to set
	 */
	public void setRevPayLevel(Long revPayLevel) {
		this.revPayLevel = revPayLevel;
	}

	/**
	 * @return the revPayLevelValue
	 */
	public String getRevPayLevelValue() {
		return revPayLevelValue;
	}

	/**
	 * @param revPayLevelValue the revPayLevelValue to set
	 */
	public void setRevPayLevelValue(String revPayLevelValue) {
		this.revPayLevelValue = revPayLevelValue;
	}

	/**
	 * @return the revCellId
	 */
	public Long getRevCellId() {
		return revCellId;
	}

	/**
	 * @param revCellId the revCellId to set
	 */
	public void setRevCellId(Long revCellId) {
		this.revCellId = revCellId;
	}

	/**
	 * @return the revCellIdValue
	 */
	public Long getRevCellIdValue() {
		return revCellIdValue;
	}

	/**
	 * @param revCellIdValue the revCellIdValue to set
	 */
	public void setRevCellIdValue(Long revCellIdValue) {
		this.revCellIdValue = revCellIdValue;
	}

	/**
	 * @return the revGrade
	 */
	public Long getRevGrade() {
		return revGrade;
	}

	/**
	 * @param revGrade the revGrade to set
	 */
	public void setRevGrade(Long revGrade) {
		this.revGrade = revGrade;
	}

	/**
	 * @return the revGradeValue
	 */
	public String getRevGradeValue() {
		return revGradeValue;
	}

	/**
	 * @param revGradeValue the revGradeValue to set
	 */
	public void setRevGradeValue(String revGradeValue) {
		this.revGradeValue = revGradeValue;
	}

	/**
	 * @return the revScale
	 */
	public Long getRevScale() {
		return revScale;
	}

	/**
	 * @param revScale the revScale to set
	 */
	public void setRevScale(Long revScale) {
		this.revScale = revScale;
	}

	/**
	 * @return the revScaleValue
	 */
	public String getRevScaleValue() {
		return revScaleValue;
	}

	/**
	 * @param revScaleValue the revScaleValue to set
	 */
	public void setRevScaleValue(String revScaleValue) {
		this.revScaleValue = revScaleValue;
	}

	/**
	 * @return the revPayBandValue
	 */
	public Long getRevPayBandValue() {
		return revPayBandValue;
	}

	/**
	 * @param revPayBandValue the revPayBandValue to set
	 */
	public void setRevPayBandValue(Long revPayBandValue) {
		this.revPayBandValue = revPayBandValue;
	}

	/**
	 * @return the revGradePay
	 */
	public Long getRevGradePay() {
		return revGradePay;
	}

	/**
	 * @param revGradePay the revGradePay to set
	 */
	public void setRevGradePay(Long revGradePay) {
		this.revGradePay = revGradePay;
	}

	/**
	 * @return the revGradePayValue
	 */
	public String getRevGradePayValue() {
		return revGradePayValue;
	}

	/**
	 * @param revGradePayValue the revGradePayValue to set
	 */
	public void setRevGradePayValue(String revGradePayValue) {
		this.revGradePayValue = revGradePayValue;
	}

	/**
	 * @return the revBasicPay
	 */
	public Long getRevBasicPay() {
		return revBasicPay;
	}

	/**
	 * @param revBasicPay the revBasicPay to set
	 */
	public void setRevBasicPay(Long revBasicPay) {
		this.revBasicPay = revBasicPay;
	}

	/**
	 * @return the revEffDate
	 */
	public Date getRevEffDate() {
		return revEffDate;
	}

	/**
	 * @param revEffDate the revEffDate to set
	 */
	public void setRevEffDate(Date revEffDate) {
		this.revEffDate = revEffDate;
	}

	/**
	 * @return the revDateNexInc
	 */
	public Date getRevDateNexInc() {
		return revDateNexInc;
	}

	/**
	 * @param revDateNexInc the revDateNexInc to set
	 */
	public void setRevDateNexInc(Date revDateNexInc) {
		this.revDateNexInc = revDateNexInc;
	}

	/**
	 * @return the diffAmt
	 */
	public Long getDiffAmt() {
		return diffAmt;
	}

	/**
	 * @param diffAmt the diffAmt to set
	 */
	public void setDiffAmt(Long diffAmt) {
		this.diffAmt = diffAmt;
	}

	/**
	 * @return the reasonForExclude
	 */
	public long getReasonForExclude() {
		return reasonForExclude;
	}

	/**
	 * @param reasonForExclude the reasonForExclude to set
	 */
	public void setReasonForExclude(long reasonForExclude) {
		this.reasonForExclude = reasonForExclude;
	}

	/**
	 * @return the reasonForExcludeValue
	 */
	public String getReasonForExcludeValue() {
		return reasonForExcludeValue;
	}

	/**
	 * @param reasonForExcludeValue the reasonForExcludeValue to set
	 */
	public void setReasonForExcludeValue(String reasonForExcludeValue) {
		this.reasonForExcludeValue = reasonForExcludeValue;
	}

	/**
	 * @return the stopIncrementType
	 */
	public Long getStopIncrementType() {
		return stopIncrementType;
	}

	/**
	 * @param stopIncrementType the stopIncrementType to set
	 */
	public void setStopIncrementType(Long stopIncrementType) {
		this.stopIncrementType = stopIncrementType;
	}

	/**
	 * @return the dateNxtInc
	 */
	public Date getDateNxtInc() {
		return dateNxtInc;
	}

	/**
	 * @param dateNxtInc the dateNxtInc to set
	 */
	public void setDateNxtInc(Date dateNxtInc) {
		this.dateNxtInc = dateNxtInc;
	}

	public Date getSusStartDate() {
		return susStartDate;
	}

	public void setSusStartDate(Date susStartDate) {
		this.susStartDate = susStartDate;
	}

	/**
	 * @return the susEndDate
	 */
	public Date getSusEndDate() {
		return susEndDate;
	}

	/**
	 * @param susEndDate the susEndDate to set
	 */
	public void setSusEndDate(Date susEndDate) {
		this.susEndDate = susEndDate;
	}

	public Date getEolStartDate() {
		return eolStartDate;
	}

	public void setEolStartDate(Date eolStartDate) {
		this.eolStartDate = eolStartDate;
	}

	/**
	 * @return the eolEndDate
	 */
	public Date getEolEndDate() {
		return eolEndDate;
	}

	/**
	 * @param eolEndDate the eolEndDate to set
	 */
	public void setEolEndDate(Date eolEndDate) {
		this.eolEndDate = eolEndDate;
	}

	/**
	 * @return the recordCount
	 */
	public Long getRecordCount() {
		return recordCount;
	}

	/**
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * @return the stopIncrementTypeValue
	 */
	public String getStopIncrementTypeValue() {
		return stopIncrementTypeValue;
	}

	/**
	 * @param stopIncrementTypeValue the stopIncrementTypeValue to set
	 */
	public void setStopIncrementTypeValue(String stopIncrementTypeValue) {
		this.stopIncrementTypeValue = stopIncrementTypeValue;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the stopIncFromDate
	 */
	public Date getStopIncFromDate() {
		return stopIncFromDate;
	}

	/**
	 * @param stopIncFromDate the stopIncFromDate to set
	 */
	public void setStopIncFromDate(Date stopIncFromDate) {
		this.stopIncFromDate = stopIncFromDate;
	}

	/**
	 * @return the stopIncToDate
	 */
	public Date getStopIncToDate() {
		return stopIncToDate;
	}

	/**
	 * @param stopIncToDate the stopIncToDate to set
	 */
	public void setStopIncToDate(Date stopIncToDate) {
		this.stopIncToDate = stopIncToDate;
	}

	/**
	 * @return the aplPayComm
	 */
	public Long getAplPayComm() {
		return aplPayComm;
	}

	/**
	 * @param aplPayComm the aplPayComm to set
	 */
	public void setAplPayComm(Long aplPayComm) {
		this.aplPayComm = aplPayComm;
	}

	/**
	 * @return the systemExcluded
	 */
	public int getSystemExcluded() {
		return systemExcluded;
	}

	/**
	 * @param systemExcluded the systemExcluded to set
	 */
	public void setSystemExcluded(int systemExcluded) {
		this.systemExcluded = systemExcluded;
	}

	/**
	 * @return the curPayBand
	 */
	public Long getCurPayBand() {
		return curPayBand;
	}

	/**
	 * @param curPayBand the curPayBand to set
	 */
	public void setCurPayBand(Long curPayBand) {
		this.curPayBand = curPayBand;
	}

	/**
	 * @return the curPayBandRange
	 */
	public String getCurPayBandRange() {
		return curPayBandRange;
	}

	/**
	 * @param curPayBandRange the curPayBandRange to set
	 */
	public void setCurPayBandRange(String curPayBandRange) {
		this.curPayBandRange = curPayBandRange;
	}

	/**
	 * @return the revPayBand
	 */
	public Long getRevPayBand() {
		return revPayBand;
	}

	/**
	 * @param revPayBand the revPayBand to set
	 */
	public void setRevPayBand(Long revPayBand) {
		this.revPayBand = revPayBand;
	}

	/**
	 * @return the revPayBandRange
	 */
	public String getRevPayBandRange() {
		return revPayBandRange;
	}

	/**
	 * @param revPayBandRange the revPayBandRange to set
	 */
	public void setRevPayBandRange(String revPayBandRange) {
		this.revPayBandRange = revPayBandRange;
	}

	/**
	 * @return the incrementType
	 */
	public String getIncrementType() {
		return incrementType;
	}

	/**
	 * @param incrementType the incrementType to set
	 */
	public void setIncrementType(String incrementType) {
		this.incrementType = incrementType;
	}

	/**
	 * @return the empType
	 */
	public Long getEmpType() {
		return empType;
	}

	/**
	 * @param empType the empType to set
	 */
	public void setEmpType(Long empType) {
		this.empType = empType;
	}

}
