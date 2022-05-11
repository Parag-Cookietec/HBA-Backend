package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;


/**
 * The Class EDPBranchCrViewDto.
 */
@NativeQueryResultEntity
public class EDPBranchCrViewDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trn no. */
	@NativeQueryResultColumn(index = 0)
	private String trnNo;

	/** The reference date. */
	@NativeQueryResultColumn(index = 1)
	private String referenceDate;

	/** The district. */
	@NativeQueryResultColumn(index = 2)
	private String district;
	
	/** The ddo no. */
	@NativeQueryResultColumn(index = 3)
	private String ddoNo;
	
	/** The cardex no. */
	@NativeQueryResultColumn(index = 4)
	private String cardexNo;
	
	/** The office name. */
	@NativeQueryResultColumn(index = 5)
	private String officeName;
	
	/** The branch name. */
	@NativeQueryResultColumn(index = 6)
	private String branchName;

	/** The branch type name. */
	@NativeQueryResultColumn(index = 7)
	private String branchTypeName;
	
	/** The transaction status. */
	@NativeQueryResultColumn(index = 8)
	private String transactionStatus;

	/** The tedp br hdr id. */
	@NativeQueryResultColumn(index = 9)
	private Long tedpBrHdrId;
	
	/** The branch id. */
	@NativeQueryResultColumn(index = 10)
	private Long branchId;
	
	@NativeQueryResultColumn(index = 11)
	private int activeStatus;
	
	/** The office id. */
	@NativeQueryResultColumn(index = 12)
	private Long officeId;
	
	/** The branch type id. */
	@NativeQueryResultColumn(index = 13)
	private Long branchTypeId;
	
	/** The count. */
	@NativeQueryResultColumn(index = 14)
	private int count;

	/** The created by. */
	@NativeQueryResultColumn(index = 15)
	private String createdBy;
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
	 * Gets the reference date.
	 *
	 * @return the referenceDate
	 */
	public String getReferenceDate() {
		return referenceDate;
	}

	/**
	 * Sets the reference date.
	 *
	 * @param referenceDate the referenceDate to set
	 */
	public void setReferenceDate(String referenceDate) {
		this.referenceDate = referenceDate;
	}

	/**
	 * Gets the district.
	 *
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * Sets the district.
	 *
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
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
	 * Gets the branch name.
	 *
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * Sets the branch name.
	 *
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * Gets the branch type name.
	 *
	 * @return the branchTypeName
	 */
	public String getBranchTypeName() {
		return branchTypeName;
	}

	/**
	 * Sets the branch type name.
	 *
	 * @param branchTypeName the branchTypeName to set
	 */
	public void setBranchTypeName(String branchTypeName) {
		this.branchTypeName = branchTypeName;
	}

	/**
	 * Gets the transaction status.
	 *
	 * @return the transactionStatus
	 */
	public String getTransactionStatus() {
		return transactionStatus;
	}

	/**
	 * Sets the transaction status.
	 *
	 * @param transactionStatus the transactionStatus to set
	 */
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	/**
	 * Gets the tedp br hdr id.
	 *
	 * @return the tedpBrHdrId
	 */
	public Long getTedpBrHdrId() {
		return tedpBrHdrId;
	}

	/**
	 * Sets the tedp br hdr id.
	 *
	 * @param tedpBrHdrId the tedpBrHdrId to set
	 */
	public void setTedpBrHdrId(Long tedpBrHdrId) {
		this.tedpBrHdrId = tedpBrHdrId;
	}

	/**
	 * Gets the branch id.
	 *
	 * @return the branchId
	 */
	public Long getBranchId() {
		return branchId;
	}

	/**
	 * Sets the branch id.
	 *
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
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
	 * Gets the branch type id.
	 *
	 * @return the branchTypeId
	 */
	public Long getBranchTypeId() {
		return branchTypeId;
	}

	/**
	 * Sets the branch type id.
	 *
	 * @param branchTypeId the branchTypeId to set
	 */
	public void setBranchTypeId(Long branchTypeId) {
		this.branchTypeId = branchTypeId;
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
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
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
	 * @return the activeStatus
	 */
	public int getActiveStatus() {
		return activeStatus;
	}

	/**
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(activeStatus, branchId, branchName, branchTypeId, branchTypeName, cardexNo, count,
				createdBy, ddoNo, district, officeId, officeName, referenceDate, tedpBrHdrId,
				transactionStatus, trnNo);
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
		if (!(obj instanceof EDPBranchCrViewDto)) {
			return false;
		}
		EDPBranchCrViewDto other = (EDPBranchCrViewDto) obj;
		return activeStatus == other.activeStatus && Objects.equals(branchId, other.branchId)
				&& Objects.equals(branchName, other.branchName) && Objects.equals(branchTypeId, other.branchTypeId)
				&& Objects.equals(branchTypeName, other.branchTypeName) && Objects.equals(cardexNo, other.cardexNo)
				&& count == other.count && Objects.equals(createdBy, other.createdBy)
				&& Objects.equals(ddoNo, other.ddoNo)
				&& Objects.equals(district, other.district) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(officeName, other.officeName) && Objects.equals(referenceDate, other.referenceDate)
				&& Objects.equals(tedpBrHdrId, other.tedpBrHdrId)
				&& Objects.equals(transactionStatus, other.transactionStatus) && Objects.equals(trnNo, other.trnNo);
	}

}
