package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPAddDesignationSearchViewDto.
 */
@NativeQueryResultEntity
public class EDPAddDesignationSearchViewDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The designation id. */
	@NativeQueryResultColumn(index = 0)
	private Long designationId;

	/** The transaction number. */
	@NativeQueryResultColumn(index = 1)
	private String transactionNumber;

	/** The transaction date. */
	@NativeQueryResultColumn(index = 2)
	private Date transactionDate;

	/** The district name. */
	@NativeQueryResultColumn(index = 3)
	private String districtName;

	/** The ddo no. */
	@NativeQueryResultColumn(index = 4)
	private String ddoNo;

	/** The cardex no. */
	@NativeQueryResultColumn(index = 5)
	private String cardexNo;

	/** The office name. */
	@NativeQueryResultColumn(index = 6)
	private String officeName;

	/** The designation name. */
	@NativeQueryResultColumn(index = 7)
	private String designationName;

	/** The total count. */
	@NativeQueryResultColumn(index = 9)
	private int totalCount;

	/** The lying with. */
	@NativeQueryResultColumn(index = 10)
	private String lyingWith;

	/** The status. */
	@NativeQueryResultColumn(index = 13)
	private String status;

	/** The status. */
	@NativeQueryResultColumn(index = 12)
	private String wfStatus;

	/** The status. */
	@NativeQueryResultColumn(index = 14)
	private int isEditable;

	/** The remarks. */
	private String remarks;

	/**
	 * Gets the transaction number.
	 *
	 * @return the transactionNumber
	 */
	public String getTransactionNumber() {
		return transactionNumber;
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
	 * Sets the transaction date.
	 *
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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
	 * Sets the district name.
	 *
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * @return the wfStatus
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * @param wfStatus the wfStatus to set
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
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
	 * Gets the cardex no.
	 *
	 * @return the cardexNo
	 */
	public String getCardexNo() {
		return cardexNo;
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
	 * Gets the office name.
	 *
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
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
	 * Sets the office name.
	 *
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
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
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
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
	 * Sets the remarks.
	 *
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Instantiates a new EDP add designation search view dto.
	 */
	public EDPAddDesignationSearchViewDto() {
		super();
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */

	@Override
	public int hashCode() {
		return Objects.hash(cardexNo, ddoNo, designationId, designationName, districtName, isEditable, lyingWith,
				officeName, remarks, status, totalCount, transactionDate, transactionNumber, wfStatus);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPAddDesignationSearchViewDto other = (EDPAddDesignationSearchViewDto) obj;
		return Objects.equals(cardexNo, other.cardexNo) && Objects.equals(ddoNo, other.ddoNo)
				&& Objects.equals(designationId, other.designationId)
				&& Objects.equals(designationName, other.designationName)
				&& Objects.equals(districtName, other.districtName) && isEditable == other.isEditable
				&& Objects.equals(lyingWith, other.lyingWith) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(status, other.status)
				&& totalCount == other.totalCount && Objects.equals(transactionDate, other.transactionDate)
				&& Objects.equals(transactionNumber, other.transactionNumber)
				&& Objects.equals(wfStatus, other.wfStatus);
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
