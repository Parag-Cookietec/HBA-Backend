package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPOfficeItrView.
 */

@NativeQueryResultEntity
public class EDPOfficeHistoryReportView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String officeId;

	@NativeQueryResultColumn(index = 1)
	private String district;
	
	@NativeQueryResultColumn(index = 2)
	private String ddoNo;
	
	@NativeQueryResultColumn(index = 3)
	private Long cardexNo;
	
	@NativeQueryResultColumn(index = 4)
	private String officeName;
	
	@NativeQueryResultColumn(index = 5)
	private String designationName;

	@NativeQueryResultColumn(index = 6)
	private String departName;

	@NativeQueryResultColumn(index = 7)
	private String hodName;

	@NativeQueryResultColumn(index = 8)
	private String	 isCo;

	@NativeQueryResultColumn(index = 9)
	private String ddotype;

	@NativeQueryResultColumn(index = 10)
	private String mappedTo;
	
	@NativeQueryResultColumn(index = 11)
	private Date createdDate;
	
	@NativeQueryResultColumn(index = 12)
	private Date updateDate;

	@NativeQueryResultColumn(index = 13)
	private String status;
	
	@NativeQueryResultColumn(index = 14)
	private String billType;

	/**
	 * @return the officeId
	 */
	public String getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * @return the cardexNo
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
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
	 * @return the departName
	 */
	public String getDepartName() {
		return departName;
	}

	/**
	 * @param departName the departName to set
	 */
	public void setDepartName(String departName) {
		this.departName = departName;
	}

	/**
	 * @return the hodName
	 */
	public String getHodName() {
		return hodName;
	}

	/**
	 * @param hodName the hodName to set
	 */
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	/**
	 * @return the isCo
	 */
	public String getIsCo() {
		return isCo;
	}

	/**
	 * @param isCo the isCo to set
	 */
	public void setIsCo(String isCo) {
		this.isCo = isCo;
	}

	/**
	 * @return the ddotype
	 */
	public String getDdotype() {
		return ddotype;
	}

	/**
	 * @param ddotype the ddotype to set
	 */
	public void setDdotype(String ddotype) {
		this.ddotype = ddotype;
	}

	/**
	 * @return the mappedTo
	 */
	public String getMappedTo() {
		return mappedTo;
	}

	/**
	 * @param mappedTo the mappedTo to set
	 */
	public void setMappedTo(String mappedTo) {
		this.mappedTo = mappedTo;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
	 * @return the billType
	 */
	public String getBillType() {
		return billType;
	}

	/**
	 * @param billType the billType to set
	 */
	public void setBillType(String billType) {
		this.billType = billType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(billType, cardexNo, createdDate, ddoNo, ddotype, departName, designationName, district,
				hodName, isCo, mappedTo, officeId, officeName, status, updateDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPOfficeHistoryReportView other = (EDPOfficeHistoryReportView) obj;
		return Objects.equals(billType, other.billType) && Objects.equals(cardexNo, other.cardexNo)
				&& Objects.equals(createdDate, other.createdDate) && Objects.equals(ddoNo, other.ddoNo)
				&& Objects.equals(ddotype, other.ddotype) && Objects.equals(departName, other.departName)
				&& Objects.equals(designationName, other.designationName) && Objects.equals(district, other.district)
				&& Objects.equals(hodName, other.hodName) && Objects.equals(isCo, other.isCo)
				&& Objects.equals(mappedTo, other.mappedTo) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(officeName, other.officeName) && Objects.equals(status, other.status)
				&& Objects.equals(updateDate, other.updateDate);
	}



}
