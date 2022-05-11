package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPUsrPoTrnsSearchViewDto.
 */
@NativeQueryResultEntity
public class EDPUsrPoTrnsSearchViewDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The edp usr po trns header id. */
	@NativeQueryResultColumn(index = 0)
	private Long edpUsrPoTrnsHeaderId;

	/** The ddo office. */
	@NativeQueryResultColumn(index = 1)
	private String ddoOffice;
	
	/** The cardex no. */
	@NativeQueryResultColumn(index = 2)
	private String cardexNo;

	/** The ddo no. */
	@NativeQueryResultColumn(index = 3)
	private String ddoNo;

	/** The district name. */
	@NativeQueryResultColumn(index = 4)
	private String districtName;

	/** The from employee name. */
	@NativeQueryResultColumn(index = 5)
	private String fromEmployeeName;

	/** The from employee no. */
	@NativeQueryResultColumn(index = 6)
	private String fromEmployeeNo;

	/** The to employee name. */
	@NativeQueryResultColumn(index = 7)
	private String toEmployeeName;	

	/** The to employee no. */
	@NativeQueryResultColumn(index = 8)
	private String toEmployeeNo;

	/** The count. */
	@NativeQueryResultColumn(index = 9)
	private int count;


	/** The transaction number. */
	@NativeQueryResultColumn(index = 10)
	private String transactionNumber;
	
	/** The created date. */
	@NativeQueryResultColumn(index = 11)
	private Date createdDate;

	/** The updated date. */
	@NativeQueryResultColumn(index = 12)
	private Date updatedDate;

	/** The lying with. */
	@NativeQueryResultColumn(index = 13)
	private String lyingWith;
	
	/** The status. */
	@NativeQueryResultColumn(index = 14)
	private String status;
	
	/** The upt up date. */
	@NativeQueryResultColumn(index = 15)
	private Date uptUpDate;
	
	/** The request. */
	@NativeQueryResultColumn(index = 16)
	private String request;
	
	/** The wf status. */
	@NativeQueryResultColumn(index = 17)
	private String wfStatus;
	
	/** The is editable. */
	@NativeQueryResultColumn(index = 18)
	private int isEditable;

	/** The level. */
	@NativeQueryResultColumn(index = 19)
	private int level;

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
	 * Gets the ddo office.
	 *
	 * @return the ddoOffice
	 */
	public String getDdoOffice() {
		return ddoOffice;
	}

	/**
	 * Sets the ddo office.
	 *
	 * @param ddoOffice the ddoOffice to set
	 */
	public void setDdoOffice(String ddoOffice) {
		this.ddoOffice = ddoOffice;
	}

	/**
	 * Gets the from employee no.
	 *
	 * @return the fromEmployeeNo
	 */
	public String getFromEmployeeNo() {
		return fromEmployeeNo;
	}

	/**
	 * Sets the from employee no.
	 *
	 * @param fromEmployeeNo the fromEmployeeNo to set
	 */
	public void setFromEmployeeNo(String fromEmployeeNo) {
		this.fromEmployeeNo = fromEmployeeNo;
	}

	/**
	 * Gets the from employee name.
	 *
	 * @return the fromEmployeeName
	 */
	public String getFromEmployeeName() {
		return fromEmployeeName;
	}

	/**
	 * Sets the from employee name.
	 *
	 * @param fromEmployeeName the fromEmployeeName to set
	 */
	public void setFromEmployeeName(String fromEmployeeName) {
		this.fromEmployeeName = fromEmployeeName;
	}

	/**
	 * Gets the to employee no.
	 *
	 * @return the toEmployeeNo
	 */
	public String getToEmployeeNo() {
		return toEmployeeNo;
	}

	/**
	 * Sets the to employee no.
	 *
	 * @param toEmployeeNo the toEmployeeNo to set
	 */
	public void setToEmployeeNo(String toEmployeeNo) {
		this.toEmployeeNo = toEmployeeNo;
	}

	/**
	 * Gets the to employee name.
	 *
	 * @return the toEmployeeName
	 */
	public String getToEmployeeName() {
		return toEmployeeName;
	}

	/**
	 * Sets the to employee name.
	 *
	 * @param toEmployeeName the toEmployeeName to set
	 */
	public void setToEmployeeName(String toEmployeeName) {
		this.toEmployeeName = toEmployeeName;
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
	 * Gets the count.
	 *
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Gets the edp usr po trns header id.
	 *
	 * @return the edp usr po trns header id
	 */
	public Long getEdpUsrPoTrnsHeaderId() {
		return edpUsrPoTrnsHeaderId;
	}

	/**
	 * Sets the edp usr po trns header id.
	 *
	 * @param edpUsrPoTrnsHeaderId the new edp usr po trns header id
	 */
	public void setEdpUsrPoTrnsHeaderId(Long edpUsrPoTrnsHeaderId) {
		this.edpUsrPoTrnsHeaderId = edpUsrPoTrnsHeaderId;
	}

	/**
	 * Gets the updated date.
	 *
	 * @return the updated date
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Sets the updated date.
	 *
	 * @param updatedDate the new updated date
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the upt up date.
	 *
	 * @return the upt up date
	 */
	public Date getUptUpDate() {
		return uptUpDate;
	}

	/**
	 * Sets the upt up date.
	 *
	 * @param uptUpDate the new upt up date
	 */
	public void setUptUpDate(Date uptUpDate) {
		this.uptUpDate = uptUpDate;
	}

	/**
	 * Gets the request.
	 *
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * Sets the request.
	 *
	 * @param request the new request
	 */
	public void setRequest(String request) {
		this.request = request;
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
	 * Gets the level.
	 *
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public void setLevel(int level) {
		this.level = level;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cardexNo, count, createdDate, ddoNo, ddoOffice, districtName, edpUsrPoTrnsHeaderId,
				fromEmployeeName, fromEmployeeNo, lyingWith, request, status, toEmployeeName, toEmployeeNo,
				transactionNumber, updatedDate, uptUpDate, wfStatus, isEditable, level);
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
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPUsrPoTrnsSearchViewDto)) {
			return false;
		}
		EDPUsrPoTrnsSearchViewDto other = (EDPUsrPoTrnsSearchViewDto) obj;
		return Objects.equals(cardexNo, other.cardexNo) && count == other.count
				&& Objects.equals(createdDate, other.createdDate) && Objects.equals(ddoNo, other.ddoNo)
				&& Objects.equals(ddoOffice, other.ddoOffice) && Objects.equals(districtName, other.districtName)
				&& Objects.equals(edpUsrPoTrnsHeaderId, other.edpUsrPoTrnsHeaderId)
				&& Objects.equals(fromEmployeeName, other.fromEmployeeName)
				&& Objects.equals(fromEmployeeNo, other.fromEmployeeNo) && Objects.equals(lyingWith, other.lyingWith)
				&& Objects.equals(request, other.request) && Objects.equals(status, other.status)
				&& Objects.equals(toEmployeeName, other.toEmployeeName)
				&& Objects.equals(toEmployeeNo, other.toEmployeeNo)
				&& Objects.equals(transactionNumber, other.transactionNumber)
				&& Objects.equals(updatedDate, other.updatedDate) && Objects.equals(uptUpDate, other.uptUpDate)
				&& Objects.equals(wfStatus, other.wfStatus)
				&& Objects.equals(isEditable, other.isEditable)
				&& Objects.equals(level, other.level);
	}
	
}
