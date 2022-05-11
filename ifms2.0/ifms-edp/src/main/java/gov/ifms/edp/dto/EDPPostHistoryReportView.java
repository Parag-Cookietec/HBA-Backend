package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPPostSearchView.
 */
@NativeQueryResultEntity
public class EDPPostHistoryReportView extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String districtName;

	@NativeQueryResultColumn(index = 1)
	private String ddoNo;

	@NativeQueryResultColumn(index = 2)
	private long cardexNo;

	@NativeQueryResultColumn(index = 3)
	private String officeName;

	@NativeQueryResultColumn(index = 4)
	private String postName;

	@NativeQueryResultColumn(index = 5)
	private String employeeVacant;

	@NativeQueryResultColumn(index = 6)
	private String postFromDate;

	@NativeQueryResultColumn(index = 7)
	private long postToDate;

	private int totalCount;

	

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
	 * @return the postName
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * @param postName the postName to set
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * @return the employeeVacant
	 */
	public String getEmployeeVacant() {
		return employeeVacant;
	}

	/**
	 * @param employeeVacant the employeeVacant to set
	 */
	public void setEmployeeVacant(String employeeVacant) {
		this.employeeVacant = employeeVacant;
	}

	/**
	 * @return the postFromDate
	 */
	public String getPostFromDate() {
		return postFromDate;
	}

	/**
	 * @param postFromDate the postFromDate to set
	 */
	public void setPostFromDate(String postFromDate) {
		this.postFromDate = postFromDate;
	}

	/**
	 * @return the postToDate
	 */
	public long getPostToDate() {
		return postToDate;
	}

	/**
	 * @param postToDate the postToDate to set
	 */
	public void setPostToDate(long postToDate) {
		this.postToDate = postToDate;
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * @return the cardexNo
	 */
	public long getCardexNo() {
		return cardexNo;
	}

	/**
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(long cardexNo) {
		this.cardexNo = cardexNo;
	}
	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardexNo, ddoNo, districtName, employeeVacant, officeName, postFromDate, postName,
				postToDate, totalCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPPostHistoryReportView other = (EDPPostHistoryReportView) obj;
		return cardexNo == other.cardexNo && Objects.equals(ddoNo, other.ddoNo)
				&& Objects.equals(districtName, other.districtName)
				&& Objects.equals(employeeVacant, other.employeeVacant) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(postFromDate, other.postFromDate) && Objects.equals(postName, other.postName)
				&& postToDate == other.postToDate && totalCount == other.totalCount;
	}

}