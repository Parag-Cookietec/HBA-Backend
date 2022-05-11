package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUCommonEmployeView.
 *
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 *
 */

@NativeQueryResultEntity
public class PVUCareerAdvanceEmployeView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp date. */
	@NativeQueryResultColumn(index = 0)
	private String eventDate;

	/** The emp name. */
	@NativeQueryResultColumn(index = 1)
	private String employeeName;

	/** The class level. */
	@NativeQueryResultColumn(index = 2)
	private String classLevel;

	/** The designation. */
	@NativeQueryResultColumn(index = 3)
	private String designationName;

	/** retirement Date. */
	@NativeQueryResultColumn(index = 4)
	private String retirementDate;

	/** office Name. */
	@NativeQueryResultColumn(index = 5)
	private String officeName;

	/** date Nxt Incr. */
	@NativeQueryResultColumn(index = 6)
	private String dateNxtIncr;

	/** The office name. */
	@NativeQueryResultColumn(index = 7)
	private String empBasicPay;

	/** The office name. */
	@NativeQueryResultColumn(index = 8)
	private String dateJoining;

	/** The employee no. */
	@NativeQueryResultColumn(index = 9)
	private String employeeNo;

	/** The employee id. */
	@NativeQueryResultColumn(index = 10)
	private String employeeId;

	/** The office name. */
	@NativeQueryResultColumn(index = 11)
	private String cellId;

	/** The office name. */
	@NativeQueryResultColumn(index = 12)
	private String payBandValue;

	/** The office name. */
	@NativeQueryResultColumn(index = 13)
	private String payScale;

	/** The office name. */
	@NativeQueryResultColumn(index = 14)
	private String payBandId;

	/** The office name. */
	@NativeQueryResultColumn(index = 15)
	private String payLvlGrdPay;

	/** The office name. */
	@NativeQueryResultColumn(index = 15)
	private String payLvlGrdPay1;

	/** The office name. */
	@NativeQueryResultColumn(index = 16)
	private String uniAppLectType;

	/** The office name. */
	@NativeQueryResultColumn(index = 18)
	private String oriCertDate;

	/** The office name. */
	@NativeQueryResultColumn(index = 19)
	private String refCertDate;

	/** The office name. */
	@NativeQueryResultColumn(index = 20)
	private String evetEffDate;

	/** The office name. */
	@NativeQueryResultColumn(index = 21)
	private String evetEffDate1;

	/**
	 * @return the eventDate
	 */
	public String getEventDate() {
		return eventDate;
	}

	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the classLevel
	 */
	public String getClassLevel() {
		return classLevel;
	}

	/**
	 * @param classLevel the classLevel to set
	 */
	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
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
	 * @return the retirementDate
	 */
	public String getRetirementDate() {
		return retirementDate;
	}

	/**
	 * @param retirementDate the retirementDate to set
	 */
	public void setRetirementDate(String retirementDate) {
		this.retirementDate = retirementDate;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the dateNxtIncr
	 */
	public String getDateNxtIncr() {
		return dateNxtIncr;
	}

	/**
	 * @param dateNxtIncr the dateNxtIncr to set
	 */
	public void setDateNxtIncr(String dateNxtIncr) {
		this.dateNxtIncr = dateNxtIncr;
	}

	/**
	 * @return the empBasicPay
	 */
	public String getEmpBasicPay() {
		return empBasicPay;
	}

	/**
	 * @param empBasicPay the empBasicPay to set
	 */
	public void setEmpBasicPay(String empBasicPay) {
		this.empBasicPay = empBasicPay;
	}

	/**
	 * @return the dateJoining
	 */
	public String getDateJoining() {
		return dateJoining;
	}

	/**
	 * @param dateJoining the dateJoining to set
	 */
	public void setDateJoining(String dateJoining) {
		this.dateJoining = dateJoining;
	}

	/**
	 * @return the employeeNo
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the cellId
	 */
	public String getCellId() {
		return cellId;
	}

	/**
	 * @param cellId the cellId to set
	 */
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	/**
	 * @return the payBandValue
	 */
	public String getPayBandValue() {
		return payBandValue;
	}

	/**
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(String payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * @return the payScale
	 */
	public String getPayScale() {
		return payScale;
	}

	/**
	 * @param payScale the payScale to set
	 */
	public void setPayScale(String payScale) {
		this.payScale = payScale;
	}

	/**
	 * @return the payBandId
	 */
	public String getPayBandId() {
		return payBandId;
	}

	/**
	 * @param payBandId the payBandId to set
	 */
	public void setPayBandId(String payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * @return the payLvlGrdPay
	 */
	public String getPayLvlGrdPay() {
		return payLvlGrdPay;
	}

	/**
	 * @param payLvlGrdPay the payLvlGrdPay to set
	 */
	public void setPayLvlGrdPay(String payLvlGrdPay) {
		this.payLvlGrdPay = payLvlGrdPay;
	}

	/**
	 * @return the payLvlGrdPay1
	 */
	public String getPayLvlGrdPay1() {
		return payLvlGrdPay1;
	}

	/**
	 * @param payLvlGrdPay1 the payLvlGrdPay1 to set
	 */
	public void setPayLvlGrdPay1(String payLvlGrdPay1) {
		this.payLvlGrdPay1 = payLvlGrdPay1;
	}

	/**
	 * @return the uniAppLectType
	 */
	public String getUniAppLectType() {
		return uniAppLectType;
	}

	/**
	 * @param uniAppLectType the uniAppLectType to set
	 */
	public void setUniAppLectType(String uniAppLectType) {
		this.uniAppLectType = uniAppLectType;
	}

	/**
	 * @return the oriCertDate
	 */
	public String getOriCertDate() {
		return oriCertDate;
	}

	/**
	 * @param oriCertDate the oriCertDate to set
	 */
	public void setOriCertDate(String oriCertDate) {
		this.oriCertDate = oriCertDate;
	}

	/**
	 * @return the refCertDate
	 */
	public String getRefCertDate() {
		return refCertDate;
	}

	/**
	 * @param refCertDate the refCertDate to set
	 */
	public void setRefCertDate(String refCertDate) {
		this.refCertDate = refCertDate;
	}

	/**
	 * @return the evetEffDate
	 */
	public String getEvetEffDate() {
		return evetEffDate;
	}

	/**
	 * @param evetEffDate the evetEffDate to set
	 */
	public void setEvetEffDate(String evetEffDate) {
		this.evetEffDate = evetEffDate;
	}

	/**
	 * @return the evetEffDate1
	 */
	public String getEvetEffDate1() {
		return evetEffDate1;
	}

	/**
	 * @param evetEffDate1 the evetEffDate1 to set
	 */
	public void setEvetEffDate1(String evetEffDate1) {
		this.evetEffDate1 = evetEffDate1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cellId, classLevel, dateJoining, dateNxtIncr, designationName, empBasicPay, employeeId,
				employeeName, employeeNo, eventDate, evetEffDate, evetEffDate1, officeName, oriCertDate, payBandId,
				payBandValue, payLvlGrdPay, payLvlGrdPay1, payScale, refCertDate, retirementDate, uniAppLectType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUCareerAdvanceEmployeView)) {
			return false;
		}
		PVUCareerAdvanceEmployeView other = (PVUCareerAdvanceEmployeView) obj;
		return Objects.equals(cellId, other.cellId) && Objects.equals(classLevel, other.classLevel)
				&& Objects.equals(dateJoining, other.dateJoining) && Objects.equals(dateNxtIncr, other.dateNxtIncr)
				&& Objects.equals(designationName, other.designationName)
				&& Objects.equals(empBasicPay, other.empBasicPay) && Objects.equals(employeeId, other.employeeId)
				&& Objects.equals(employeeName, other.employeeName) && Objects.equals(employeeNo, other.employeeNo)
				&& Objects.equals(eventDate, other.eventDate) && Objects.equals(evetEffDate, other.evetEffDate)
				&& Objects.equals(evetEffDate1, other.evetEffDate1) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(oriCertDate, other.oriCertDate) && Objects.equals(payBandId, other.payBandId)
				&& Objects.equals(payBandValue, other.payBandValue) && Objects.equals(payLvlGrdPay, other.payLvlGrdPay)
				&& Objects.equals(payLvlGrdPay1, other.payLvlGrdPay1) && Objects.equals(payScale, other.payScale)
				&& Objects.equals(refCertDate, other.refCertDate)
				&& Objects.equals(retirementDate, other.retirementDate)
				&& Objects.equals(uniAppLectType, other.uniAppLectType);
	}

}
