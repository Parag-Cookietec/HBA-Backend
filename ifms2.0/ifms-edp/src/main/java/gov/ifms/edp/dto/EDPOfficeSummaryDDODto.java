package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPOfficeSummaryDDODto.
 */
@NativeQueryResultEntity
public class EDPOfficeSummaryDDODto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The district code. */
	@NativeQueryResultColumn(index = 0)
	private String districtCode;

	/** The district id. */
	@NativeQueryResultColumn(index = 1)
	private long districtId;

	/** The district name. */
	@NativeQueryResultColumn(index = 2)
	private String districtName;

	/** The ddo no. */
	@NativeQueryResultColumn(index = 3)
	private long ddoNo;

	/** The cardex no. */
	@NativeQueryResultColumn(index = 4)
	private long cardexNo;

	/** The desg ddo id. */
	@NativeQueryResultColumn(index = 5)
	private long desgDdoId;

	/** The design name. */
	@NativeQueryResultColumn(index = 6)
	private String designName;

	/** The office name. */
	@NativeQueryResultColumn(index = 7)
	private String officeName;

	/** The ddo type. */
	@NativeQueryResultColumn(index = 8)
	private String ddoType;

	/** The status id. */
	@NativeQueryResultColumn(index = 9)
	private long statusId;

	/** The reference date. */
	@NativeQueryResultColumn(index = 10)
	private Date referenceDate;

	/** The end date. */
	@NativeQueryResultColumn(index = 13)
	private Date endDate;

	/** The office id. */
	@NativeQueryResultColumn(index = 11)
	private long officeId;

	/** The status. */
	@NativeQueryResultColumn(index = 12)
	private String status;

	/** The office type id. */
	@NativeQueryResultColumn(index = 14)
	private String officeTypeId;

	/** The is cnt office. */
	@NativeQueryResultColumn(index = 15)
	private String isCntOffice;

	/** The total count. */
	@NativeQueryResultColumn(index = 16)
	private int totalCount;

	/**
	 * Gets the district code.
	 *
	 * @return the districtCode
	 */
	public String getDistrictCode() {
		return districtCode;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddoNo
	 */
	public long getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(long ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardexNo
	 */
	public long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the desg ddo id.
	 *
	 * @return the desgDdoId
	 */
	public long getDesgDdoId() {
		return desgDdoId;
	}

	/**
	 * Sets the desg ddo id.
	 *
	 * @param desgDdoId the desgDdoId to set
	 */
	public void setDesgDdoId(long desgDdoId) {
		this.desgDdoId = desgDdoId;
	}

	/**
	 * Gets the design name.
	 *
	 * @return the designName
	 */
	public String getDesignName() {
		return designName;
	}

	/**
	 * Sets the design name.
	 *
	 * @param designName the designName to set
	 */
	public void setDesignName(String designName) {
		this.designName = designName;
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
	 * Gets the ddo type.
	 *
	 * @return the ddoType
	 */
	public String getDdoType() {
		return ddoType;
	}

	/**
	 * Sets the ddo type.
	 *
	 * @param ddoType the ddoType to set
	 */
	public void setDdoType(String ddoType) {
		this.ddoType = ddoType;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the reference date.
	 *
	 * @return the referenceDate
	 */
	public Date getReferenceDate() {
		return referenceDate;
	}

	/**
	 * Sets the reference date.
	 *
	 * @param referenceDate the referenceDate to set
	 */
	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the districtId
	 */
	public long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Sets the district code.
	 *
	 * @param districtCode the districtCode to set
	 */
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
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
	 * Gets the end date.
	 *
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the office type id.
	 *
	 * @return the office type id
	 */
	public String getOfficeTypeId() {
		return officeTypeId;
	}

	/**
	 * Sets the office type id.
	 *
	 * @param officeTypeId the new office type id
	 */
	public void setOfficeTypeId(String officeTypeId) {
		this.officeTypeId = officeTypeId;
	}

	/**
	 * Gets the checks if is cnt office.
	 *
	 * @return the checks if is cnt office
	 */
	public String getIsCntOffice() {
		return isCntOffice;
	}

	/**
	 * Sets the checks if is cnt office.
	 *
	 * @param isCntOffice the new checks if is cnt office
	 */
	public void setIsCntOffice(String isCntOffice) {
		this.isCntOffice = isCntOffice;
	}

	/**
	 * Instantiates a new EDP office summary DDO dto.
	 */
	public EDPOfficeSummaryDDODto() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cardexNo, ddoNo, ddoType, desgDdoId, designName, districtCode, districtId, districtName,
				endDate, officeId, officeName, referenceDate, status, statusId);
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
		EDPOfficeSummaryDDODto other = (EDPOfficeSummaryDDODto) obj;
		return cardexNo == other.cardexNo && ddoNo == other.ddoNo && Objects.equals(ddoType, other.ddoType)
				&& desgDdoId == other.desgDdoId && Objects.equals(designName, other.designName)
				&& Objects.equals(districtCode, other.districtCode) && districtId == other.districtId
				&& Objects.equals(districtName, other.districtName) && Objects.equals(endDate, other.endDate)
				&& officeId == other.officeId && Objects.equals(officeName, other.officeName)
				&& Objects.equals(referenceDate, other.referenceDate) && Objects.equals(status, other.status)
				&& statusId == other.statusId;
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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
