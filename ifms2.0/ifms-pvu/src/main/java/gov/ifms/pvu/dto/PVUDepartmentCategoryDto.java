package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUDepartmentCategoryDto.
 *
 * @version v 1.0
 * @created 2019/12/31 16:57:07
 */
public class PVUDepartmentCategoryDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The department category name. */
	private String departmentCategoryName;

	/** The department category name guj. */
	private String departmentCategoryNameGuj;

	/** The department category designation. */
	private String departmentCategoryDesignation;

	/** The department category designation guj. */
	private String departmentCategoryDesignationGuj;

	/** The department category code. */
	private String departmentCategoryCode;

	/** The department category code guj. */
	private String departmentCategoryCodeGuj;

	/** The department category code name. */
	private String departmentCategoryCodeName;

	/** The department category type id. */
	private long departmentCategoryTypeId;

	/** The department category id. */
	private long departmentCategoryId;

	/** The dept category id. */
	private long deptCategoryId;

	/**
	 * Gets the dept category id.
	 *
	 * @return the deptCategoryId
	 */
	public long getDeptCategoryId() {
		return deptCategoryId;
	}

	/**
	 * Sets the dept category id.
	 *
	 * @param deptCategoryId the deptCategoryId to set
	 */
	public void setDeptCategoryId(long deptCategoryId) {
		this.deptCategoryId = deptCategoryId;
	}

	/**
	 * getter setter.
	 *
	 * @return the int
	 */

	/**
	 * Gets the department category name.
	 *
	 * @return the departmentCategoryName
	 */
	public String getDepartmentCategoryName() {
		return departmentCategoryName;
	}

	/**
	 * Sets the department category name.
	 *
	 * @param departmentCategoryName the departmentCategoryName to set
	 */
	public void setDepartmentCategoryName(String departmentCategoryName) {
		this.departmentCategoryName = departmentCategoryName;
	}

	/**
	 * Gets the department category name guj.
	 *
	 * @return the departmentCategoryNameGuj
	 */
	public String getDepartmentCategoryNameGuj() {
		return departmentCategoryNameGuj;
	}

	/**
	 * Sets the department category name guj.
	 *
	 * @param departmentCategoryNameGuj the departmentCategoryNameGuj to set
	 */
	public void setDepartmentCategoryNameGuj(String departmentCategoryNameGuj) {
		this.departmentCategoryNameGuj = departmentCategoryNameGuj;
	}

	/**
	 * Gets the department category designation.
	 *
	 * @return the departmentCategoryDesignation
	 */
	public String getDepartmentCategoryDesignation() {
		return departmentCategoryDesignation;
	}

	/**
	 * Sets the department category designation.
	 *
	 * @param departmentCategoryDesignation the departmentCategoryDesignation to set
	 */
	public void setDepartmentCategoryDesignation(String departmentCategoryDesignation) {
		this.departmentCategoryDesignation = departmentCategoryDesignation;
	}

	/**
	 * Gets the department category designation guj.
	 *
	 * @return the departmentCategoryDesignationGuj
	 */
	public String getDepartmentCategoryDesignationGuj() {
		return departmentCategoryDesignationGuj;
	}

	/**
	 * Sets the department category designation guj.
	 *
	 * @param departmentCategoryDesignationGuj the departmentCategoryDesignationGuj
	 *                                         to set
	 */
	public void setDepartmentCategoryDesignationGuj(String departmentCategoryDesignationGuj) {
		this.departmentCategoryDesignationGuj = departmentCategoryDesignationGuj;
	}

	/**
	 * Gets the department category code.
	 *
	 * @return the departmentCategoryCode
	 */
	public String getDepartmentCategoryCode() {
		return departmentCategoryCode;
	}

	/**
	 * Sets the department category code.
	 *
	 * @param departmentCategoryCode the departmentCategoryCode to set
	 */
	public void setDepartmentCategoryCode(String departmentCategoryCode) {
		this.departmentCategoryCode = departmentCategoryCode;
	}

	/**
	 * Gets the department category code guj.
	 *
	 * @return the departmentCategoryCodeGuj
	 */
	public String getDepartmentCategoryCodeGuj() {
		return departmentCategoryCodeGuj;
	}

	/**
	 * Sets the department category code guj.
	 *
	 * @param departmentCategoryCodeGuj the departmentCategoryCodeGuj to set
	 */
	public void setDepartmentCategoryCodeGuj(String departmentCategoryCodeGuj) {
		this.departmentCategoryCodeGuj = departmentCategoryCodeGuj;
	}

	/**
	 * Gets the department category code name.
	 *
	 * @return the departmentCategoryCodeName
	 */
	public String getDepartmentCategoryCodeName() {
		return departmentCategoryCodeName;
	}

	/**
	 * Sets the department category code name.
	 *
	 * @param departmentCategoryCodeName the departmentCategoryCodeName to set
	 */
	public void setDepartmentCategoryCodeName(String departmentCategoryCodeName) {
		this.departmentCategoryCodeName = departmentCategoryCodeName;
	}

	/**
	 * Gets the department category type id.
	 *
	 * @return the departmentCategoryTypeId
	 */
	public long getDepartmentCategoryTypeId() {
		return departmentCategoryTypeId;
	}

	/**
	 * Sets the department category type id.
	 *
	 * @param departmentCategoryTypeId the departmentCategoryTypeId to set
	 */
	public void setDepartmentCategoryTypeId(long departmentCategoryTypeId) {
		this.departmentCategoryTypeId = departmentCategoryTypeId;
	}

	/**
	 * Gets the department category id.
	 *
	 * @return the departmentCategoryId
	 */
	public long getDepartmentCategoryId() {
		return departmentCategoryId;
	}

	/**
	 * Sets the department category id.
	 *
	 * @param departmentCategoryId the departmentCategoryId to set
	 */
	public void setDepartmentCategoryId(long departmentCategoryId) {
		this.departmentCategoryId = departmentCategoryId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentCategoryCode, departmentCategoryCodeGuj, departmentCategoryCodeName,
				departmentCategoryDesignation, departmentCategoryDesignationGuj, departmentCategoryId,
				departmentCategoryName, departmentCategoryNameGuj, departmentCategoryTypeId, deptCategoryId);
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
		PVUDepartmentCategoryDto other = (PVUDepartmentCategoryDto) obj;
		return Objects.equals(departmentCategoryCode, other.departmentCategoryCode)
				&& Objects.equals(departmentCategoryCodeGuj, other.departmentCategoryCodeGuj)
				&& Objects.equals(departmentCategoryCodeName, other.departmentCategoryCodeName)
				&& Objects.equals(departmentCategoryDesignation, other.departmentCategoryDesignation)
				&& Objects.equals(departmentCategoryDesignationGuj, other.departmentCategoryDesignationGuj)
				&& departmentCategoryId == other.departmentCategoryId
				&& Objects.equals(departmentCategoryName, other.departmentCategoryName)
				&& Objects.equals(departmentCategoryNameGuj, other.departmentCategoryNameGuj)
				&& departmentCategoryTypeId == other.departmentCategoryTypeId && deptCategoryId == other.deptCategoryId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUDepartmentCategoryDto [departmentCategoryName=" + departmentCategoryName
				+ ", departmentCategoryNameGuj=" + departmentCategoryNameGuj + ", departmentCategoryDesignation="
				+ departmentCategoryDesignation + ", departmentCategoryDesignationGuj="
				+ departmentCategoryDesignationGuj + ", departmentCategoryCode=" + departmentCategoryCode
				+ ", departmentCategoryCodeGuj=" + departmentCategoryCodeGuj + ", departmentCategoryCodeName="
				+ departmentCategoryCodeName + ", departmentCategoryTypeId=" + departmentCategoryTypeId
				+ ", departmentCategoryId=" + departmentCategoryId + ", deptCategoryId=" + deptCategoryId + "]";
	}

	/**
	 * PVUDepartmentCategoryDto Constructor.
	 */
	public PVUDepartmentCategoryDto() {
		super();
	}

}
