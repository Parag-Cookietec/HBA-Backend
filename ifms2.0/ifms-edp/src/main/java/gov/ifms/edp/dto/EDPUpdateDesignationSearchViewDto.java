package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPUpdateDesignationSearchViewDto.
 */
@NativeQueryResultEntity
public class EDPUpdateDesignationSearchViewDto implements Serializable  {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The upd dsg id. */
	@NativeQueryResultColumn(index = 0)	
	private Long updDsgId;
	
	/** The transaction number. */
	@NativeQueryResultColumn(index = 1)
	private String transactionNumber;
	
	/** The transaction date. */
	@NativeQueryResultColumn(index = 2)
	private Date transactionDate;

	/** The district name. */
	@NativeQueryResultColumn(index = 3)
	private String districtName;

	/** The ddo name. */
	@NativeQueryResultColumn(index = 4)
	private String ddoName;

	/** The ddo designation. */
	@NativeQueryResultColumn(index = 5)
	private String ddoDesignation;
	
	/** The ddo no. */
	@NativeQueryResultColumn(index = 6)
	private String ddoNo;
	
	/** The cardex no. */
	@NativeQueryResultColumn(index = 7)
	private String cardexNo;
	
	/** The total count. */
	@NativeQueryResultColumn(index = 8)
	private int totalCount;
	
	/** The employee id. */
	@NativeQueryResultColumn(index = 9)
	private Long employeeId;
	
	/** The employee name. */
	@NativeQueryResultColumn(index = 10)
	private String employeeName;
	
	/** The lying with. */
	@NativeQueryResultColumn(index = 11)
	private String lyingWith;
	
	/** The wf status. */
	@NativeQueryResultColumn(index = 12)
	private String wfStatus;
	
	/** The wf status. */
	@NativeQueryResultColumn(index = 13)
	private String status;
	
	/** The is editable. */
	@NativeQueryResultColumn(index = 14)
	private int isEditable;
	
	/** The upt up date. */
	@NativeQueryResultColumn(index = 15)
	private Date updUpDate;

	/**
	 * Gets the transaction number.
	 *
	 * @return the transactionNumber
	 */
	public String getTransactionNumber() {
		return transactionNumber;
	}

	/**
	 * Sets the transaction number.
	 *
	 * @param transactionNumber the transactionNumber to set
	 */
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	/**
	 * Gets the transaction date.
	 *
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * Sets the transaction date.
	 *
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * Gets the district name.
	 *
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * Sets the district name.
	 *
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * Gets the ddo designation.
	 *
	 * @return the ddoDesignation
	 */
	public String getDdoDesignation() {
		return ddoDesignation;
	}

	/**
	 * Sets the ddo designation.
	 *
	 * @param ddoDesignation the ddoDesignation to set
	 */
	public void setDdoDesignation(String ddoDesignation) {
		this.ddoDesignation = ddoDesignation;
	}

	/**
	 * Gets the ddo name.
	 *
	 * @return the ddoName
	 */
	public String getDdoName() {
		return ddoName;
	}

	/**
	 * Sets the ddo name.
	 *
	 * @param ddoName the ddoName to set
	 */
	public void setDdoName(String ddoName) {
		this.ddoName = ddoName;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardexNo
	 */
	public String getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the lying with.
	 *
	 * @return the lyingWith
	 */
	public String getLyingWith() {
		return lyingWith;
	}

	/**
	 * Sets the lying with.
	 *
	 * @param lyingWith the lyingWith to set
	 */
	public void setLyingWith(String lyingWith) {
		this.lyingWith = lyingWith;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Gets the upd dsg id.
	 *
	 * @return the updDsgId
	 */
	public Long getUpdDsgId() {
		return updDsgId;
	}

	/**
	 * Sets the upd dsg id.
	 *
	 * @param updDsgId the updDsgId to set
	 */
	public void setUpdDsgId(Long updDsgId) {
		this.updDsgId = updDsgId;
	}

	/**
	 * Gets the employee id.
	 *
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the employee name.
	 *
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * Sets the employee name.
	 *
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * Gets the total count.
	 *
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * Sets the total count.
	 *
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * Gets the wf status.
	 *
	 * @return the wf status
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * Sets the wf status.
	 *
	 * @param wfStatus the new wf status
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * Gets the checks if is editable.
	 *
	 * @return the checks if is editable
	 */
	public int getIsEditable() {
		return isEditable;
	}

	/**
	 * Sets the checks if is editable.
	 *
	 * @param isEditable the new checks if is editable
	 */
	public void setIsEditable(int isEditable) {
		this.isEditable = isEditable;
	}

	/**
	 * Gets the upd up date.
	 *
	 * @return the upd up date
	 */
	public Date getUpdUpDate() {
		return updUpDate;
	}

	/**
	 * Sets the upd up date.
	 *
	 * @param updUpDate the new upd up date
	 */
	public void setUpdUpDate(Date updUpDate) {
		this.updUpDate = updUpDate;
	}
	
}
