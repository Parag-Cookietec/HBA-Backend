package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVURopView.
 *
 * @author Admin
 */
@NativeQueryResultEntity
public class PVURopView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private Long id;

	/** The emp id. */
	@NativeQueryResultColumn(index = 1)
	private Long empId;

	/** The emp no. */
	@NativeQueryResultColumn(index = 2)
	private Long empNo;

	/** The emp name. */
	@NativeQueryResultColumn(index = 3)
	private String empName;

	/** The trn no. */
	@NativeQueryResultColumn(index = 4)
	private String trnNo;

	/** The order no. */
	@NativeQueryResultColumn(index = 5)
	private String orderNo;

	/** The order date. */
	@NativeQueryResultColumn(index = 6)
	private String orderDate;

	/** The rev next increment date. */
	@NativeQueryResultColumn(index = 7)
	private String revNextIncrementDate;

	/** The rop type. */
	@NativeQueryResultColumn(index = 8)
	private Long ropType;

	/** The rop type value. */
	@NativeQueryResultColumn(index = 9)
	private String ropTypeValue;

	/** The class id. */
	@NativeQueryResultColumn(index = 10)
	private Long classId;

	/** The class name. */
	@NativeQueryResultColumn(index = 11)
	private String className;

	/** The designation id. */
	@NativeQueryResultColumn(index = 12)
	private Long designationId;

	/** The designation name. */
	@NativeQueryResultColumn(index = 13)
	private String designationName;

	/** The date of joining. */
	@NativeQueryResultColumn(index = 14)
	private String dateOfJoining;

	/** The cur scale. */
	@NativeQueryResultColumn(index = 15)
	private Long curScale;

	/** The cur scale name. */
	@NativeQueryResultColumn(index = 16)
	private String curScaleName;

	/** The cur pay band value. */
	@NativeQueryResultColumn(index = 17)
	private Long curPayBandValue;

	/** The cur grade pay. */
	@NativeQueryResultColumn(index = 18)
	private Long curGradePay;

	/** The cur grade pay value. */
	@NativeQueryResultColumn(index = 19)
	private String curGradePayValue;

	/** The cur basic pay. */
	@NativeQueryResultColumn(index = 20)
	private String curBasicPay;

	/** The rev pay level. */
	@NativeQueryResultColumn(index = 21)
	private Long revPayLevel;

	/** The rev pay level value. */
	@NativeQueryResultColumn(index = 22)
	private String revPayLevelValue;

	/** The rev cell id. */
	@NativeQueryResultColumn(index = 23)
	private Long revCellId;

	/** The rev cell value. */
	@NativeQueryResultColumn(index = 24)
	private Long revCellValue;

	/** The rev pay band value. */
	@NativeQueryResultColumn(index = 25)
	private Long revPayBandValue;

	/** The rev grade pay. */
	@NativeQueryResultColumn(index = 26)
	private Long revGradePay;

	/** The rev grade pay value. */
	@NativeQueryResultColumn(index = 27)
	private Long revGradePayValue;

	/** The rev basic pay. */
	@NativeQueryResultColumn(index = 28)
	private Long revBasicPay;

	/** The retirment date. */
	@NativeQueryResultColumn(index = 29)
	private Date retirmentDate;

	/** The office id. */
	@NativeQueryResultColumn(index = 30)
	private Long officeId;

	/** The office name. */
	@NativeQueryResultColumn(index = 31)
	private String officeName;

	/** The effective date. */
	@NativeQueryResultColumn(index = 32)
	private String effectiveDate;

	/** The rop change eff date. */
	@NativeQueryResultColumn(index = 33)
	private Long ropChangeEffDate;

	/** The rop change. */
	@NativeQueryResultColumn(index = 34)
	private String ropChange;

	/** The remarks. */
	@NativeQueryResultColumn(index = 35)
	private String remarks;

	/** The cur pay band. */
	@NativeQueryResultColumn(index = 36)
	private Long curPayBand;

	/** The cur pay band name. */
	@NativeQueryResultColumn(index = 37)
	private String curPayBandName;

	/** The rev pay band. */
	@NativeQueryResultColumn(index = 38)
	private Long revPayBand;

	/** The rev pay band name. */
	@NativeQueryResultColumn(index = 39)
	private String revPayBandName;

	/** The cur next increment date. */
	@NativeQueryResultColumn(index = 40)
	private Date curNextIncrementDate;

	/** The created date. */
	@NativeQueryResultColumn(index = 41)
	private Date createdDate;

	/** The auditor remarks. */
	@NativeQueryResultColumn(index = 42)
	private String auditorRemarks;

	/** The class two remarks. */
	@NativeQueryResultColumn(index = 43)
	private String classTwoRemarks;

	/** The print remarks. */
	@NativeQueryResultColumn(index = 44)
	private String printRemarks;

	/** The auditor return reason. */
	@NativeQueryResultColumn(index = 45)
	private Long auditorReturnReason;

	/** The class two ret res. */
	@NativeQueryResultColumn(index = 46)
	private Long classTwoRetRes;

	/** The print count. */
	@NativeQueryResultColumn(index = 47)
	private Long printCount;

	/** The print ret res. */
	@NativeQueryResultColumn(index = 48)
	private Long printRetRes;

	/** The print flag. */
	@NativeQueryResultColumn(index = 49)
	private Integer printFlag;

	/** The approve date. */
	@NativeQueryResultColumn(index = 50)
	private Date approveDate;

	/** The authorize date. */
	@NativeQueryResultColumn(index = 51)
	private Date authorizeDate;

	/** The npa. */
	@NativeQueryResultColumn(index = 52)
	private Long npa;

	/** The npa value. */
	@NativeQueryResultColumn(index = 53)
	private String npaValue;

	/** The auto six valid basic. */
	@NativeQueryResultColumn(index = 54)
	private Long autoSixValidBasic;

	/** The auto six valid pay value. */
	@NativeQueryResultColumn(index = 55)
	private Long autoSixValidPayValue;

	/** The auto six valid flag. */
	@NativeQueryResultColumn(index = 56)
	private Long autoSixValidFlag;

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
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the emp no.
	 *
	 * @return the empNo
	 */
	public Long getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	/**
	 * Gets the emp name.
	 *
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * Sets the emp name.
	 *
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
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
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * Sets the order date.
	 *
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Gets the rop type.
	 *
	 * @return the ropType
	 */
	public Long getRopType() {
		return ropType;
	}

	/**
	 * Sets the rop type.
	 *
	 * @param ropType the ropType to set
	 */
	public void setRopType(Long ropType) {
		this.ropType = ropType;
	}

	/**
	 * Gets the rop type value.
	 *
	 * @return the ropTypeValue
	 */
	public String getRopTypeValue() {
		return ropTypeValue;
	}

	/**
	 * Sets the rop type value.
	 *
	 * @param ropTypeValue the ropTypeValue to set
	 */
	public void setRopTypeValue(String ropTypeValue) {
		this.ropTypeValue = ropTypeValue;
	}

	/**
	 * Gets the class id.
	 *
	 * @return the classId
	 */
	public Long getClassId() {
		return classId;
	}

	/**
	 * Sets the class id.
	 *
	 * @param classId the classId to set
	 */
	public void setClassId(Long classId) {
		this.classId = classId;
	}

	/**
	 * Gets the class name.
	 *
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Sets the class name.
	 *
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public Long getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the designation name.
	 *
	 * @return the designationName
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * Sets the designation name.
	 *
	 * @param designationName the designationName to set
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	/**
	 * Gets the date of joining.
	 *
	 * @return the dateOfJoining
	 */
	public String getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * Sets the date of joining.
	 *
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * Gets the cur scale.
	 *
	 * @return the curScale
	 */
	public Long getCurScale() {
		return curScale;
	}

	/**
	 * Sets the cur scale.
	 *
	 * @param curScale the curScale to set
	 */
	public void setCurScale(Long curScale) {
		this.curScale = curScale;
	}

	/**
	 * Gets the cur scale name.
	 *
	 * @return the curScaleName
	 */
	public String getCurScaleName() {
		return curScaleName;
	}

	/**
	 * Sets the cur scale name.
	 *
	 * @param curScaleName the curScaleName to set
	 */
	public void setCurScaleName(String curScaleName) {
		this.curScaleName = curScaleName;
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
	 * Gets the cur grade pay.
	 *
	 * @return the curGradePay
	 */
	public Long getCurGradePay() {
		return curGradePay;
	}

	/**
	 * Sets the cur grade pay.
	 *
	 * @param curGradePay the curGradePay to set
	 */
	public void setCurGradePay(Long curGradePay) {
		this.curGradePay = curGradePay;
	}

	/**
	 * Gets the cur basic pay.
	 *
	 * @return the curBasicPay
	 */
	public String getCurBasicPay() {
		return curBasicPay;
	}

	/**
	 * Sets the cur basic pay.
	 *
	 * @param curBasicPay the curBasicPay to set
	 */
	public void setCurBasicPay(String curBasicPay) {
		this.curBasicPay = curBasicPay;
	}

	/**
	 * Gets the rev pay level.
	 *
	 * @return the revPayLevel
	 */
	public Long getRevPayLevel() {
		return revPayLevel;
	}

	/**
	 * Sets the rev pay level.
	 *
	 * @param revPayLevel the revPayLevel to set
	 */
	public void setRevPayLevel(Long revPayLevel) {
		this.revPayLevel = revPayLevel;
	}

	/**
	 * Gets the rev pay level value.
	 *
	 * @return the revPayLevelValue
	 */
	public String getRevPayLevelValue() {
		return revPayLevelValue;
	}

	/**
	 * Sets the rev pay level value.
	 *
	 * @param revPayLevelValue the revPayLevelValue to set
	 */
	public void setRevPayLevelValue(String revPayLevelValue) {
		this.revPayLevelValue = revPayLevelValue;
	}

	/**
	 * Gets the rev cell id.
	 *
	 * @return the revCellId
	 */
	public Long getRevCellId() {
		return revCellId;
	}

	/**
	 * Sets the rev cell id.
	 *
	 * @param revCellId the revCellId to set
	 */
	public void setRevCellId(Long revCellId) {
		this.revCellId = revCellId;
	}

	/**
	 * Gets the rev cell value.
	 *
	 * @return the revCellValue
	 */
	public Long getRevCellValue() {
		return revCellValue;
	}

	/**
	 * Sets the rev cell value.
	 *
	 * @param revCellValue the revCellValue to set
	 */
	public void setRevCellValue(Long revCellValue) {
		this.revCellValue = revCellValue;
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
	public Long getRevGradePay() {
		return revGradePay;
	}

	/**
	 * Sets the rev grade pay.
	 *
	 * @param revGradePay the revGradePay to set
	 */
	public void setRevGradePay(Long revGradePay) {
		this.revGradePay = revGradePay;
	}

	/**
	 * Gets the rev grade pay value.
	 *
	 * @return the revGradePayValue
	 */
	public Long getRevGradePayValue() {
		return revGradePayValue;
	}

	/**
	 * Sets the rev grade pay value.
	 *
	 * @param revGradePayValue the revGradePayValue to set
	 */
	public void setRevGradePayValue(Long revGradePayValue) {
		this.revGradePayValue = revGradePayValue;
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
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the effective date.
	 *
	 * @return the effectiveDate
	 */
	public String getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * Sets the effective date.
	 *
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Gets the rop change eff date.
	 *
	 * @return the ropChangeEffDate
	 */
	public Long getRopChangeEffDate() {
		return ropChangeEffDate;
	}

	/**
	 * Sets the rop change eff date.
	 *
	 * @param ropChangeEffDate the ropChangeEffDate to set
	 */
	public void setRopChangeEffDate(Long ropChangeEffDate) {
		this.ropChangeEffDate = ropChangeEffDate;
	}

	/**
	 * Gets the rop change.
	 *
	 * @return the ropChange
	 */
	public String getRopChange() {
		return ropChange;
	}

	/**
	 * Sets the rop change.
	 *
	 * @param ropChange the ropChange to set
	 */
	public void setRopChange(String ropChange) {
		this.ropChange = ropChange;
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
	 * Gets the cur pay band.
	 *
	 * @return the curPayBand
	 */
	public Long getCurPayBand() {
		return curPayBand;
	}

	/**
	 * Sets the cur pay band.
	 *
	 * @param curPayBand the curPayBand to set
	 */
	public void setCurPayBand(Long curPayBand) {
		this.curPayBand = curPayBand;
	}

	/**
	 * Gets the cur pay band name.
	 *
	 * @return the curPayBandName
	 */
	public String getCurPayBandName() {
		return curPayBandName;
	}

	/**
	 * Sets the cur pay band name.
	 *
	 * @param curPayBandName the curPayBandName to set
	 */
	public void setCurPayBandName(String curPayBandName) {
		this.curPayBandName = curPayBandName;
	}

	/**
	 * Gets the rev pay band.
	 *
	 * @return the revPayBand
	 */
	public Long getRevPayBand() {
		return revPayBand;
	}

	/**
	 * Sets the rev pay band.
	 *
	 * @param revPayBand the revPayBand to set
	 */
	public void setRevPayBand(Long revPayBand) {
		this.revPayBand = revPayBand;
	}

	/**
	 * Gets the rev pay band name.
	 *
	 * @return the revPayBandName
	 */
	public String getRevPayBandName() {
		return revPayBandName;
	}

	/**
	 * Sets the rev pay band name.
	 *
	 * @param revPayBandName the revPayBandName to set
	 */
	public void setRevPayBandName(String revPayBandName) {
		this.revPayBandName = revPayBandName;
	}

	/**
	 * Gets the rev next increment date.
	 *
	 * @return the revNextIncrementDate
	 */
	public String getRevNextIncrementDate() {
		return revNextIncrementDate;
	}

	/**
	 * Sets the rev next increment date.
	 *
	 * @param revNextIncrementDate the revNextIncrementDate to set
	 */
	public void setRevNextIncrementDate(String revNextIncrementDate) {
		this.revNextIncrementDate = revNextIncrementDate;
	}

	/**
	 * Gets the retirment date.
	 *
	 * @return the retirmentDate
	 */
	public Date getRetirmentDate() {
		return retirmentDate;
	}

	/**
	 * Sets the retirment date.
	 *
	 * @param retirmentDate the retirmentDate to set
	 */
	public void setRetirmentDate(Date retirmentDate) {
		this.retirmentDate = retirmentDate;
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
	 * Gets the created date.
	 *
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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
	 * Gets the class two ret res.
	 *
	 * @return the classTwoRetRes
	 */
	public Long getClassTwoRetRes() {
		return classTwoRetRes;
	}

	/**
	 * Sets the class two ret res.
	 *
	 * @param classTwoRetRes the classTwoRetRes to set
	 */
	public void setClassTwoRetRes(Long classTwoRetRes) {
		this.classTwoRetRes = classTwoRetRes;
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
	 * Gets the prints the ret res.
	 *
	 * @return the printRetRes
	 */
	public Long getPrintRetRes() {
		return printRetRes;
	}

	/**
	 * Sets the prints the ret res.
	 *
	 * @param printRetRes the printRetRes to set
	 */
	public void setPrintRetRes(Long printRetRes) {
		this.printRetRes = printRetRes;
	}

	/**
	 * Gets the prints the flag.
	 *
	 * @return the printFlag
	 */
	public Integer getPrintFlag() {
		return printFlag;
	}

	/**
	 * Sets the prints the flag.
	 *
	 * @param printFlag the printFlag to set
	 */
	public void setPrintFlag(Integer printFlag) {
		this.printFlag = printFlag;
	}

	/**
	 * Gets the approve date.
	 *
	 * @return the approveDate
	 */
	public Date getApproveDate() {
		return approveDate;
	}

	/**
	 * Sets the approve date.
	 *
	 * @param approveDate the approveDate to set
	 */
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	/**
	 * Gets the authorize date.
	 *
	 * @return the authorizeDate
	 */
	public Date getAuthorizeDate() {
		return authorizeDate;
	}

	/**
	 * Sets the authorize date.
	 *
	 * @param authorizeDate the authorizeDate to set
	 */
	public void setAuthorizeDate(Date authorizeDate) {
		this.authorizeDate = authorizeDate;
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
	 * Gets the npa value.
	 *
	 * @return the npaValue
	 */
	public String getNpaValue() {
		return npaValue;
	}

	/**
	 * Sets the npa value.
	 *
	 * @param npaValue the npaValue to set
	 */
	public void setNpaValue(String npaValue) {
		this.npaValue = npaValue;
	}

	/**
	 * Gets the cur grade pay value.
	 *
	 * @return the curGradePayValue
	 */
	public String getCurGradePayValue() {
		return curGradePayValue;
	}

	/**
	 * Sets the cur grade pay value.
	 *
	 * @param curGradePayValue the curGradePayValue to set
	 */
	public void setCurGradePayValue(String curGradePayValue) {
		this.curGradePayValue = curGradePayValue;
	}

	/**
	 * Instantiates a new PVU rop view.
	 */
	public PVURopView() {
		super();
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
				autoSixValidFlag, autoSixValidPayValue, classId, className, classTwoRemarks, classTwoRetRes,
				createdDate, curBasicPay, curGradePay, curGradePayValue, curNextIncrementDate, curPayBand,
				curPayBandName, curPayBandValue, curScale, curScaleName, dateOfJoining, designationId, designationName,
				effectiveDate, empId, empName, empNo, id, npa, npaValue, officeId, officeName, orderDate, orderNo,
				printCount, printFlag, printRemarks, printRetRes, remarks, retirmentDate, revBasicPay, revCellId,
				revCellValue, revGradePay, revGradePayValue, revNextIncrementDate, revPayBand, revPayBandName,
				revPayBandValue, revPayLevel, revPayLevelValue, ropChange, ropChangeEffDate, ropType, ropTypeValue,
				trnNo);
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
		if (!(obj instanceof PVURopView)) {
			return false;
		}
		PVURopView other = (PVURopView) obj;
		return Objects.equals(approveDate, other.approveDate) && Objects.equals(auditorRemarks, other.auditorRemarks)
				&& Objects.equals(auditorReturnReason, other.auditorReturnReason)
				&& Objects.equals(authorizeDate, other.authorizeDate)
				&& Objects.equals(autoSixValidBasic, other.autoSixValidBasic)
				&& Objects.equals(autoSixValidFlag, other.autoSixValidFlag)
				&& Objects.equals(autoSixValidPayValue, other.autoSixValidPayValue)
				&& Objects.equals(classId, other.classId) && Objects.equals(className, other.className)
				&& Objects.equals(classTwoRemarks, other.classTwoRemarks)
				&& Objects.equals(classTwoRetRes, other.classTwoRetRes)
				&& Objects.equals(createdDate, other.createdDate) && Objects.equals(curBasicPay, other.curBasicPay)
				&& Objects.equals(curGradePay, other.curGradePay)
				&& Objects.equals(curGradePayValue, other.curGradePayValue)
				&& Objects.equals(curNextIncrementDate, other.curNextIncrementDate)
				&& Objects.equals(curPayBand, other.curPayBand) && Objects.equals(curPayBandName, other.curPayBandName)
				&& Objects.equals(curPayBandValue, other.curPayBandValue) && Objects.equals(curScale, other.curScale)
				&& Objects.equals(curScaleName, other.curScaleName)
				&& Objects.equals(dateOfJoining, other.dateOfJoining)
				&& Objects.equals(designationId, other.designationId)
				&& Objects.equals(designationName, other.designationName)
				&& Objects.equals(effectiveDate, other.effectiveDate) && Objects.equals(empId, other.empId)
				&& Objects.equals(empName, other.empName) && Objects.equals(empNo, other.empNo)
				&& Objects.equals(id, other.id) && Objects.equals(npa, other.npa)
				&& Objects.equals(npaValue, other.npaValue) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(officeName, other.officeName) && Objects.equals(orderDate, other.orderDate)
				&& Objects.equals(orderNo, other.orderNo) && Objects.equals(printCount, other.printCount)
				&& Objects.equals(printFlag, other.printFlag) && Objects.equals(printRemarks, other.printRemarks)
				&& Objects.equals(printRetRes, other.printRetRes) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(retirmentDate, other.retirmentDate) && Objects.equals(revBasicPay, other.revBasicPay)
				&& Objects.equals(revCellId, other.revCellId) && Objects.equals(revCellValue, other.revCellValue)
				&& Objects.equals(revGradePay, other.revGradePay)
				&& Objects.equals(revGradePayValue, other.revGradePayValue)
				&& Objects.equals(revNextIncrementDate, other.revNextIncrementDate)
				&& Objects.equals(revPayBand, other.revPayBand) && Objects.equals(revPayBandName, other.revPayBandName)
				&& Objects.equals(revPayBandValue, other.revPayBandValue)
				&& Objects.equals(revPayLevel, other.revPayLevel)
				&& Objects.equals(revPayLevelValue, other.revPayLevelValue)
				&& Objects.equals(ropChange, other.ropChange)
				&& Objects.equals(ropChangeEffDate, other.ropChangeEffDate) && Objects.equals(ropType, other.ropType)
				&& Objects.equals(ropTypeValue, other.ropTypeValue) && Objects.equals(trnNo, other.trnNo);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format(
				"PVURopView [id=%s, empId=%s, empNo=%s, empName=%s, trnNo=%s, orderNo=%s, orderDate=%s, revNextIncrementDate=%s, ropType=%s, ropTypeValue=%s, classId=%s, className=%s, designationId=%s, designationName=%s, dateOfJoining=%s, curScale=%s, curScaleName=%s, curPayBandValue=%s, curGradePay=%s, curGradePayValue=%s, curBasicPay=%s, revPayLevel=%s, revPayLevelValue=%s, revCellId=%s, revCellValue=%s, revPayBandValue=%s, revGradePay=%s, revGradePayValue=%s, revBasicPay=%s, retirmentDate=%s, officeId=%s, officeName=%s, effectiveDate=%s, ropChangeEffDate=%s, ropChange=%s, remarks=%s, curPayBand=%s, curPayBandName=%s, revPayBand=%s, revPayBandName=%s, curNextIncrementDate=%s, createdDate=%s, auditorRemarks=%s, classTwoRemarks=%s, printRemarks=%s, auditorReturnReason=%s, classTwoRetRes=%s, printCount=%s, printRetRes=%s, printFlag=%s, approveDate=%s, authorizeDate=%s, npa=%s, npaValue=%s, autoSixValidBasic=%s, autoSixValidPayValue=%s, autoSixValidFlag=%s]",
				id, empId, empNo, empName, trnNo, orderNo, orderDate, revNextIncrementDate, ropType, ropTypeValue,
				classId, className, designationId, designationName, dateOfJoining, curScale, curScaleName,
				curPayBandValue, curGradePay, curGradePayValue, curBasicPay, revPayLevel, revPayLevelValue, revCellId,
				revCellValue, revPayBandValue, revGradePay, revGradePayValue, revBasicPay, retirmentDate, officeId,
				officeName, effectiveDate, ropChangeEffDate, ropChange, remarks, curPayBand, curPayBandName, revPayBand,
				revPayBandName, curNextIncrementDate, createdDate, auditorRemarks, classTwoRemarks, printRemarks,
				auditorReturnReason, classTwoRetRes, printCount, printRetRes, printFlag, approveDate, authorizeDate,
				npa, npaValue, autoSixValidBasic, autoSixValidPayValue, autoSixValidFlag);
	}

}
