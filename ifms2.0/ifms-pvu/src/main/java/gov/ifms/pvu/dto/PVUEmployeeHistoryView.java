package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.edp.dto.BaseDto;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeHistoryDto.
 * 
 * @version v 1.0
 * @created 2021/11/23 17:29:29
 *
 */

@NativeQueryResultEntity
public class PVUEmployeeHistoryView implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String employementTypeName;

	/** The dept name. */
	@NativeQueryResultColumn(index = 1)
	private String departmentName;

	/** The office name. */
	@NativeQueryResultColumn(index = 2)
	private String currentOfficeName;

	/** The office add. */
	@NativeQueryResultColumn(index = 3)
	private String officeAddress;

	/** The emp designation hist. */
	@NativeQueryResultColumn(index = 4)
	private String employeeDesignation;

	/** The from date. */
	@NativeQueryResultColumn(index = 5)
	private String fromDate;

	/** The to date. */
	@NativeQueryResultColumn(index = 6)
	private String toDate;

	/** The last pay drawn. */
	@NativeQueryResultColumn(index = 7)
	private String lastPayDrawn;

	/** The order no date. */
	@NativeQueryResultColumn(index = 8)
	private String order;

	@NativeQueryResultColumn(index = 9)
	private String updateByUpdateDate;

	@NativeQueryResultColumn(index = 10)
	private String updateByUserCode;

	@NativeQueryResultColumn(index = 11)
	private String updateByUserName;

	@NativeQueryResultColumn(index = 12)
	private String updateByPostName;

	@NativeQueryResultColumn(index = 13)
	private String officeName;

	// upatedRecord = 1, newRecord = 2 , RecordDelete =3
	@NativeQueryResultColumn(index = 14)
	private String changeType ;

	@NativeQueryResultColumn(index = 15)
	private String orderNumber;

	/**
	 * @return the employementTypeName
	 */
	public String getEmployementTypeName() {
		return employementTypeName;
	}

	/**
	 * @param employementTypeName the employementTypeName to set
	 */
	public void setEmployementTypeName(String employementTypeName) {
		this.employementTypeName = employementTypeName;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the currentOfficeName
	 */
	public String getCurrentOfficeName() {
		return currentOfficeName;
	}

	/**
	 * @param currentOfficeName the currentOfficeName to set
	 */
	public void setCurrentOfficeName(String currentOfficeName) {
		this.currentOfficeName = currentOfficeName;
	}

	/**
	 * @return the officeAddress
	 */
	public String getOfficeAddress() {
		return officeAddress;
	}

	/**
	 * @param officeAddress the officeAddress to set
	 */
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	/**
	 * @return the employeeDesignation
	 */
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	/**
	 * @param employeeDesignation the employeeDesignation to set
	 */
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {

		this.fromDate = PvuUtils.getDateToStringDMYFormatValue(fromDate);
	}

	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = PvuUtils.getDateToStringDMYFormatValue(toDate);
	}

	/**
	 * @return the lastPayDrawn
	 */
	public String getLastPayDrawn() {
		return lastPayDrawn;
	}

	/**
	 * @param lastPayDrawn the lastPayDrawn to set
	 */
	public void setLastPayDrawn(String lastPayDrawn) {
		this.lastPayDrawn = lastPayDrawn;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return PvuUtils.ternaryOperator(order);
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = PvuUtils.ternaryOperator(order);
	}

	/**
	 * @return the updateByUpdateDate
	 */
	public String getUpdateByUpdateDate() {
		return updateByUpdateDate;
	}

	/**
	 * @param updateByUpdateDate the updateByUpdateDate to set
	 */
	public void setUpdateByUpdateDate(String updateByUpdateDate) {
		this.updateByUpdateDate = updateByUpdateDate;
	}

	/**
	 * @return the updateByUserCode
	 */
	public String getUpdateByUserCode() {
		return updateByUserCode;
	}

	/**
	 * @param updateByUserCode the updateByUserCode to set
	 */
	public void setUpdateByUserCode(String updateByUserCode) {
		this.updateByUserCode = updateByUserCode;
	}

	/**
	 * @return the updateByUserName
	 */
	public String getUpdateByUserName() {
		return PvuUtils.ternaryOperator(updateByUserName);
	}

	/**
	 * @param updateByUserName the updateByUserName to set
	 */
	public void setUpdateByUserName(String updateByUserName) {
		this.updateByUserName = updateByUserName;
	}

	/**
	 * @return the updateByPostName
	 */
	public String getUpdateByPostName() {
		return updateByPostName;
	}

	/**
	 * @param updateByPostName the updateByPostName to set
	 */
	public void setUpdateByPostName(String updateByPostName) {
		this.updateByPostName = updateByPostName;
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
	 * @return the changeType
	 */
	public String getChangeType() {
		return changeType;
	}

	/**
	 * @param changeType the changeType to set
	 */
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	public String getOrderNumber() {
		return PvuUtils.ternaryOperator(orderNumber);
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
}
