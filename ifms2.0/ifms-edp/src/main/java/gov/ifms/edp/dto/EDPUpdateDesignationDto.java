package gov.ifms.edp.dto;

import java.util.Objects;

/**
 * The Class EDPUpdateDesignationDto.
 */
public class EDPUpdateDesignationDto {
	
	/** The district id. */
	private Long districtId;
	
	/** The ddo no. */
	private String ddoNo;
	
	/** The cardex no. */
	private Long cardexNo;
	
	/** The office id. */
	private Long officeId;
	
	/** The employee id. */
	private Long employeeId;
	
	/** The employee name. */
	private String employeeName;
	
	/** The active post id. */
	private Long activePostId;
	
	/** The designation id. */
	private Long designationId;
	
	/** The post name. */
	private String postName;
	
	/**
	 * Gets the district id.
	 *
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}
	
	/**
	 * Sets the district id.
	 *
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
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
	public Long getCardexNo() {
		return cardexNo;
	}
	
	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
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
	 * Gets the active post id.
	 *
	 * @return the activePostId
	 */
	public Long getActivePostId() {
		return activePostId;
	}
	
	/**
	 * Sets the active post id.
	 *
	 * @param activePostId the activePostId to set
	 */
	public void setActivePostId(Long activePostId) {
		this.activePostId = activePostId;
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
	 * Gets the post name.
	 *
	 * @return the postName
	 */
	public String getPostName() {
		return postName;
	}
	
	/**
	 * Sets the post name.
	 *
	 * @param postName the postName to set
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(activePostId, cardexNo, ddoNo, designationId, districtId, employeeId, employeeName,
				officeId, postName);
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
		if (!(obj instanceof EDPUpdateDesignationDto)) {
			return false;
		}
		EDPUpdateDesignationDto other = (EDPUpdateDesignationDto) obj;
		return Objects.equals(activePostId, other.activePostId) && Objects.equals(cardexNo, other.cardexNo)
				&& Objects.equals(ddoNo, other.ddoNo) && Objects.equals(designationId, other.designationId)
				&& Objects.equals(districtId, other.districtId) && Objects.equals(employeeId, other.employeeId)
				&& Objects.equals(employeeName, other.employeeName) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(postName, other.postName);
	}
	
}
