package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class EDPRightsMappingReportDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The designation id. */
	@NativeQueryResultColumn(index = 0)
	private String trnNo;
	
	@NativeQueryResultColumn(index = 1)
	private String trnDate;
	
	@NativeQueryResultColumn(index = 2)
	private String districtName;
	
	@NativeQueryResultColumn(index = 3)
	private String ddoNo;
	
	@NativeQueryResultColumn(index = 4)
	private String cardexNo;
	
	@NativeQueryResultColumn(index = 5)
	private String officeName;
	
	@NativeQueryResultColumn(index = 6)
	private Long employeeNo;
	
	@NativeQueryResultColumn(index = 7)
	private String employeeName;
	
	@NativeQueryResultColumn(index = 8)
	private String employeePost;
	
	@NativeQueryResultColumn(index = 9)
	private String lyingWith;
	
	@NativeQueryResultColumn(index = 10)
	private String workflowName;
	
	@NativeQueryResultColumn(index = 11)
	private String trnStatus;
	
	@NativeQueryResultColumn(index = 12)
	private int count;

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
	 * @return the trnDate
	 */
	public String getTrnDate() {
		return trnDate;
	}

	/**
	 * @param trnDate the trnDate to set
	 */
	public void setTrnDate(String trnDate) {
		this.trnDate = trnDate;
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
	public String getCardexNo() {
		return cardexNo;
	}

	/**
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(String cardexNo) {
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
	 * @return the employeeNo
	 */
	public Long getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(Long employeeNo) {
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
	 * @return the employeePost
	 */
	public String getEmployeePost() {
		return employeePost;
	}

	/**
	 * @param employeePost the employeePost to set
	 */
	public void setEmployeePost(String employeePost) {
		this.employeePost = employeePost;
	}

	/**
	 * @return the lyingWith
	 */
	public String getLyingWith() {
		return lyingWith;
	}

	/**
	 * @param lyingWith the lyingWith to set
	 */
	public void setLyingWith(String lyingWith) {
		this.lyingWith = lyingWith;
	}

	/**
	 * @return the workflowName
	 */
	public String getWorkflowName() {
		return workflowName;
	}

	/**
	 * @param workflowName the workflowName to set
	 */
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	/**
	 * @return the trnStatus
	 */
	public String getTrnStatus() {
		return trnStatus;
	}

	/**
	 * @param trnStatus the trnStatus to set
	 */
	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardexNo, count, ddoNo, districtName, employeeName, employeeNo, employeePost, lyingWith,
				officeName, trnDate, trnNo, trnStatus, workflowName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPRightsMappingReportDto)) {
			return false;
		}
		EDPRightsMappingReportDto other = (EDPRightsMappingReportDto) obj;
		return Objects.equals(cardexNo, other.cardexNo) && Objects.equals(count, other.count)
				&& Objects.equals(ddoNo, other.ddoNo) && Objects.equals(districtName, other.districtName)
				&& Objects.equals(employeeName, other.employeeName) && Objects.equals(employeeNo, other.employeeNo)
				&& Objects.equals(employeePost, other.employeePost) && Objects.equals(lyingWith, other.lyingWith)
				&& Objects.equals(officeName, other.officeName) && Objects.equals(trnDate, other.trnDate)
				&& Objects.equals(trnNo, other.trnNo) && Objects.equals(trnStatus, other.trnStatus)
				&& Objects.equals(workflowName, other.workflowName);
	}
	
	
	
	
}
