package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUCareerAdvanceCurrentDetailsView.
 *
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 *
 */

@NativeQueryResultEntity
public class PVUCareerAdvanceCurrentDetailsView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The emp Id. */
	@NativeQueryResultColumn(index = 0)
	private String empId;

	/** The emp name. */
	@NativeQueryResultColumn(index = 1)
	private String employeeName;

	/** The class Id. */
	@NativeQueryResultColumn(index = 2)
	private String classId;
	
	/** The class. */
	@NativeQueryResultColumn(index = 3)
	private String className;
	
	/** The designation Id. */
	@NativeQueryResultColumn(index = 4)
	private String designationId;

	/** The designation. */
	@NativeQueryResultColumn(index = 5)
	private String designationName;
	
	/** The scale Id. */
	@NativeQueryResultColumn(index = 6)
	private String payScale;

	/** The scale Name. */
	@NativeQueryResultColumn(index = 7)
	private String scaleName;

	/** The pay band id. */
	@NativeQueryResultColumn(index = 8)
	private String payBandId;
	
	/** The pay band disp val. */
	@NativeQueryResultColumn(index = 9)
	private String payBandName;
	
	/** The pay band value. */
	@NativeQueryResultColumn(index = 10)
	private String payBandValue;
	
	/** The grade pay id. */
	@NativeQueryResultColumn(index = 11)
	private String gradePayId;
	
	/** The grade pay. */
	@NativeQueryResultColumn(index = 12)
	private String gradePay;
	
	/** The pay level id. */
	@NativeQueryResultColumn(index = 13)
	private String payLevelId;
	
	/** The pay level. */
	@NativeQueryResultColumn(index = 14)
	private String payLevel;
	
	/** The cell id. */
	@NativeQueryResultColumn(index = 15)
	private String cellId;
	
	/** The cell. */
	@NativeQueryResultColumn(index = 16)
	private String cell;

	/** The basic pay. */
	@NativeQueryResultColumn(index = 17)
	private String empBasicPay;

	/** The date joining. */
	@NativeQueryResultColumn(index = 18)
	private String dateJoining;
	
	/** The retirement date. */
	@NativeQueryResultColumn(index = 19)
	private String retirementDate;
	
	/** The office name. */
	@NativeQueryResultColumn(index = 20)
	private String officeName;

	/** The date next incr. */
	@NativeQueryResultColumn(index = 21)
	private String dateNxtIncr;
	
	/** The ss eff date. */
	@NativeQueryResultColumn(index = 22)
	private String ssEffDate;
	
	/** The sg eff date. */
	@NativeQueryResultColumn(index = 23)
	private String sgEffDate;
	
	/** The office name. */
	@NativeQueryResultColumn(index = 24)
	private String uniAppLectType;

	/** The office name. */
	@NativeQueryResultColumn(index = 25)
	private String oriCertDate;

	/** The office name. */
	@NativeQueryResultColumn(index = 26)
	private String ssrefCertDate;

	@NativeQueryResultColumn(index = 27)
	private String sgrefCertDate;

	@NativeQueryResultColumn(index = 28)
	private String sgrefCertDate3yr;

	/** The pay comm id. */
	@NativeQueryResultColumn(index = 29)
	private String payCommId;

	/** The pay comm value. */
	@NativeQueryResultColumn(index = 30)
	private String payCommValue;
	
	/** The pay comm value. */
	@NativeQueryResultColumn(index = 31)
	private String deptCategory;
	
	/** The pay comm value. */
	@NativeQueryResultColumn(index = 32)
	private String deptCatValue;

	/** The pay comm value. */
	@NativeQueryResultColumn(index = 33)
	private String currentDetailsEventId;

	@NativeQueryResultColumn(index = 34)
	private long casType;

	@NativeQueryResultColumn(index = 35)
	private String sgEffDate3Yr;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDesignationId() {
		return designationId;
	}

	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getPayScale() {
		return payScale;
	}

	public void setPayScale(String payScale) {
		this.payScale = payScale;
	}

	public String getScaleName() {
		return scaleName;
	}

	public void setScaleName(String scaleName) {
		this.scaleName = scaleName;
	}

	public String getPayBandId() {
		return payBandId;
	}

	public void setPayBandId(String payBandId) {
		this.payBandId = payBandId;
	}

	public String getPayBandName() {
		return payBandName;
	}

	public void setPayBandName(String payBandName) {
		this.payBandName = payBandName;
	}

	public String getPayBandValue() {
		return payBandValue;
	}

	public void setPayBandValue(String payBandValue) {
		this.payBandValue = payBandValue;
	}

	public String getGradePayId() {
		return gradePayId;
	}

	public void setGradePayId(String gradePayId) {
		this.gradePayId = gradePayId;
	}

	public String getGradePay() {
		return gradePay;
	}

	public void setGradePay(String gradePay) {
		this.gradePay = gradePay;
	}

	public String getPayLevelId() {
		return payLevelId;
	}

	public void setPayLevelId(String payLevelId) {
		this.payLevelId = payLevelId;
	}

	public String getPayLevel() {
		return payLevel;
	}

	public void setPayLevel(String payLevel) {
		this.payLevel = payLevel;
	}

	public String getCellId() {
		return cellId;
	}

	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getEmpBasicPay() {
		return empBasicPay;
	}

	public void setEmpBasicPay(String empBasicPay) {
		this.empBasicPay = empBasicPay;
	}

	public String getDateJoining() {
		return dateJoining;
	}

	public void setDateJoining(String dateJoining) {
		this.dateJoining = dateJoining;
	}

	public String getRetirementDate() {
		return retirementDate;
	}

	public void setRetirementDate(String retirementDate) {
		this.retirementDate = retirementDate;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getDateNxtIncr() {
		return dateNxtIncr;
	}

	public void setDateNxtIncr(String dateNxtIncr) {
		this.dateNxtIncr = dateNxtIncr;
	}

	public String getSsEffDate() {
		return ssEffDate;
	}

	public void setSsEffDate(String ssEffDate) {
		this.ssEffDate = ssEffDate;
	}

	public String getSgEffDate() {
		return sgEffDate;
	}

	public void setSgEffDate(String sgEffDate) {
		this.sgEffDate = sgEffDate;
	}

	public String getUniAppLectType() {
		return uniAppLectType;
	}

	public void setUniAppLectType(String uniAppLectType) {
		this.uniAppLectType = uniAppLectType;
	}

	public String getOriCertDate() {
		return oriCertDate;
	}

	public void setOriCertDate(String oriCertDate) {
		this.oriCertDate = oriCertDate;
	}

	public String getSsrefCertDate() {
		return ssrefCertDate;
	}

	public void setSsrefCertDate(String ssrefCertDate) {
		this.ssrefCertDate = ssrefCertDate;
	}

	public String getSgrefCertDate() {
		return sgrefCertDate;
	}

	public void setSgrefCertDate(String sgrefCertDate) {
		this.sgrefCertDate = sgrefCertDate;
	}

	public String getSgrefCertDate3yr() {
		return sgrefCertDate3yr;
	}

	public void setSgrefCertDate3yr(String sgrefCertDate3yr) {
		this.sgrefCertDate3yr = sgrefCertDate3yr;
	}

	public String getPayCommId() {
		return payCommId;
	}

	public void setPayCommId(String payCommId) {
		this.payCommId = payCommId;
	}

	public String getPayCommValue() {
		return payCommValue;
	}

	public void setPayCommValue(String payCommValue) {
		this.payCommValue = payCommValue;
	}

	public String getDeptCategory() {
		return deptCategory;
	}

	public void setDeptCategory(String deptCategory) {
		this.deptCategory = deptCategory;
	}

	public String getDeptCatValue() {
		return deptCatValue;
	}

	public void setDeptCatValue(String deptCatValue) {
		this.deptCatValue = deptCatValue;
	}

	public String getCurrentDetailsEventId() {
		return currentDetailsEventId;
	}

	public void setCurrentDetailsEventId(String currentDetailsEventId) {
		this.currentDetailsEventId = currentDetailsEventId;
	}

	public long getCasType() {
		return casType;
	}

	public void setCasType(long casType) {
		this.casType = casType;
	}

	public String getSgEffDate3Yr() {
		return sgEffDate3Yr;
	}

	public void setSgEffDate3Yr(String sgEffDate3Yr) {
		this.sgEffDate3Yr = sgEffDate3Yr;
	}

	@Override
	public String toString() {
		return "PVUCareerAdvanceCurrentDetailsView{" +
				"empId='" + empId + '\'' +
				", employeeName='" + employeeName + '\'' +
				", classId='" + classId + '\'' +
				", className='" + className + '\'' +
				", designationId='" + designationId + '\'' +
				", designationName='" + designationName + '\'' +
				", payScale='" + payScale + '\'' +
				", scaleName='" + scaleName + '\'' +
				", payBandId='" + payBandId + '\'' +
				", payBandName='" + payBandName + '\'' +
				", payBandValue='" + payBandValue + '\'' +
				", gradePayId='" + gradePayId + '\'' +
				", gradePay='" + gradePay + '\'' +
				", payLevelId='" + payLevelId + '\'' +
				", payLevel='" + payLevel + '\'' +
				", cellId='" + cellId + '\'' +
				", cell='" + cell + '\'' +
				", empBasicPay='" + empBasicPay + '\'' +
				", dateJoining='" + dateJoining + '\'' +
				", retirementDate='" + retirementDate + '\'' +
				", officeName='" + officeName + '\'' +
				", dateNxtIncr='" + dateNxtIncr + '\'' +
				", ssEffDate='" + ssEffDate + '\'' +
				", sgEffDate='" + sgEffDate + '\'' +
				", uniAppLectType='" + uniAppLectType + '\'' +
				", oriCertDate='" + oriCertDate + '\'' +
				", ssrefCertDate='" + ssrefCertDate + '\'' +
				", sgrefCertDate='" + sgrefCertDate + '\'' +
				", sgrefCertDate3yr='" + sgrefCertDate3yr + '\'' +
				", payCommId='" + payCommId + '\'' +
				", payCommValue='" + payCommValue + '\'' +
				", deptCategory='" + deptCategory + '\'' +
				", deptCatValue='" + deptCatValue + '\'' +
				", currentDetailsEventId='" + currentDetailsEventId + '\'' +
				", casType=" + casType +
				", sgEffDate3Yr='" + sgEffDate3Yr + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUCareerAdvanceCurrentDetailsView)) return false;
		PVUCareerAdvanceCurrentDetailsView that = (PVUCareerAdvanceCurrentDetailsView) o;
		return getCasType() == that.getCasType() &&
				Objects.equals(getEmpId(), that.getEmpId()) &&
				Objects.equals(getEmployeeName(), that.getEmployeeName()) &&
				Objects.equals(getClassId(), that.getClassId()) &&
				Objects.equals(getClassName(), that.getClassName()) &&
				Objects.equals(getDesignationId(), that.getDesignationId()) &&
				Objects.equals(getDesignationName(), that.getDesignationName()) &&
				Objects.equals(getPayScale(), that.getPayScale()) &&
				Objects.equals(getScaleName(), that.getScaleName()) &&
				Objects.equals(getPayBandId(), that.getPayBandId()) &&
				Objects.equals(getPayBandName(), that.getPayBandName()) &&
				Objects.equals(getPayBandValue(), that.getPayBandValue()) &&
				Objects.equals(getGradePayId(), that.getGradePayId()) &&
				Objects.equals(getGradePay(), that.getGradePay()) &&
				Objects.equals(getPayLevelId(), that.getPayLevelId()) &&
				Objects.equals(getPayLevel(), that.getPayLevel()) &&
				Objects.equals(getCellId(), that.getCellId()) &&
				Objects.equals(getCell(), that.getCell()) &&
				Objects.equals(getEmpBasicPay(), that.getEmpBasicPay()) &&
				Objects.equals(getDateJoining(), that.getDateJoining()) &&
				Objects.equals(getRetirementDate(), that.getRetirementDate()) &&
				Objects.equals(getOfficeName(), that.getOfficeName()) &&
				Objects.equals(getDateNxtIncr(), that.getDateNxtIncr()) &&
				Objects.equals(getSsEffDate(), that.getSsEffDate()) &&
				Objects.equals(getSgEffDate(), that.getSgEffDate()) &&
				Objects.equals(getUniAppLectType(), that.getUniAppLectType()) &&
				Objects.equals(getOriCertDate(), that.getOriCertDate()) &&
				Objects.equals(getSsrefCertDate(), that.getSsrefCertDate()) &&
				Objects.equals(getSgrefCertDate(), that.getSgrefCertDate()) &&
				Objects.equals(getSgrefCertDate3yr(), that.getSgrefCertDate3yr()) &&
				Objects.equals(getPayCommId(), that.getPayCommId()) &&
				Objects.equals(getPayCommValue(), that.getPayCommValue()) &&
				Objects.equals(getDeptCategory(), that.getDeptCategory()) &&
				Objects.equals(getDeptCatValue(), that.getDeptCatValue()) &&
				Objects.equals(getCurrentDetailsEventId(), that.getCurrentDetailsEventId()) &&
				Objects.equals(getSgEffDate3Yr(), that.getSgEffDate3Yr());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getEmpId(), getEmployeeName(), getClassId(), getClassName(), getDesignationId(), getDesignationName(), getPayScale(), getScaleName(), getPayBandId(), getPayBandName(), getPayBandValue(), getGradePayId(), getGradePay(), getPayLevelId(), getPayLevel(), getCellId(), getCell(), getEmpBasicPay(), getDateJoining(), getRetirementDate(), getOfficeName(), getDateNxtIncr(), getSsEffDate(), getSgEffDate(), getUniAppLectType(), getOriCertDate(), getSsrefCertDate(), getSgrefCertDate(), getSgrefCertDate3yr(), getPayCommId(), getPayCommValue(), getDeptCategory(), getDeptCatValue(), getCurrentDetailsEventId(), getCasType(), getSgEffDate3Yr());
	}
}
