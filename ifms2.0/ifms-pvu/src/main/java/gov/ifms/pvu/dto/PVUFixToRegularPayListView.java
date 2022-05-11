package gov.ifms.pvu.dto;

import java.io.Serializable;

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
public class PVUFixToRegularPayListView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp date. */
	@NativeQueryResultColumn(index = 0)
	private Long fixRegId;

	/** The emp name. */
	@NativeQueryResultColumn(index = 1)
	private Long employeeId;

	/** The emp name. */
	@NativeQueryResultColumn(index = 2)
	private String trnNo;

	/** The employee no. */
	@NativeQueryResultColumn(index = 3)
	private String employeeNo;

	/** The emp name. */
	@NativeQueryResultColumn(index = 4)
	private String employeeName;

	/** The designation. */
	@NativeQueryResultColumn(index = 5)
	private String designationName;

	/** The designation. */
	@NativeQueryResultColumn(index = 6)
	private String preEmpPayType;

	/** The designation. */
	@NativeQueryResultColumn(index = 7)
	private String updatedPayType;

	/** office Name. */
	@NativeQueryResultColumn(index = 8)
	private String officeName;

	/** office Name. */
	@NativeQueryResultColumn(index = 9)
	private String status;

	/** office Name. */
	@NativeQueryResultColumn(index = 10)
	private Long recordCount;

	/** office Name. */
	@NativeQueryResultColumn(index = 11)
	private int isEditable;

	/** office Name. */
	@NativeQueryResultColumn(index = 12)
	private String updatedDate;
	
	/** office Name. */
	@NativeQueryResultColumn(index = 13)
	private String refDate;

	/**
	 * @return the fixRegId
	 */
	public Long getFixRegId() {
		return fixRegId;
	}

	/**
	 * @param fixRegId the fixRegId to set
	 */
	public void setFixRegId(Long fixRegId) {
		this.fixRegId = fixRegId;
	}

	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
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
	 * @return the preEmpPayType
	 */
	public String getPreEmpPayType() {
		return preEmpPayType;
	}

	/**
	 * @param preEmpPayType the preEmpPayType to set
	 */
	public void setPreEmpPayType(String preEmpPayType) {
		this.preEmpPayType = preEmpPayType;
	}

	/**
	 * @return the updatedPayType
	 */
	public String getUpdatedPayType() {
		return updatedPayType;
	}

	/**
	 * @param updatedPayType the updatedPayType to set
	 */
	public void setUpdatedPayType(String updatedPayType) {
		this.updatedPayType = updatedPayType;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the isEditable
	 */
	public int getIsEditable() {
		return isEditable;
	}

	/**
	 * @param isEditable the isEditable to set
	 */
	public void setIsEditable(int isEditable) {
		this.isEditable = isEditable;
	}

	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the refDate
	 */
	public String getRefDate() {
		return refDate;
	}

	/**
	 * @param refDate the refDate to set
	 */
	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

	
}
