package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

/**
 * The Class PVUDepartmentCategoryEntity.
 * 
 * @version v 1.0
 * @created 2019/12/31 16:57:07
 *
 */
@Entity
@Table(name = "MS_DEPT_CATEGORY", schema = Constant.PVU_SCHEMA_MASTER)
public class PVUDepartmentCategoryEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public PVUDepartmentCategoryEntity(long deptCategoryId) {
		this.deptCategoryId = deptCategoryId;
	}

	/** The emp address id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPT_CATEGORY_ID")
	private long deptCategoryId;

	/** The department category name. */
	@Column(name = "DEPT_CATEGORY_NAME")
	private String departmentCategoryName;

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

	/** The department category name guj. */
	@Column(name = "DEPT_CAT_NAME_GUJ")
	private String departmentCategoryNameGuj;

	/** The department category designation. */
	@Column(name = "DEPT_CAT_DESC")
	private String departmentCategoryDesignation;

	/** The department category designation guj. */
	@Column(name = "DEPT_CAT_DESC_GUJ")
	private String departmentCategoryDesignationGuj;

	/** The department category code. */
	@Column(name = "DEPT_CAT_CODE")
	private String departmentCategoryCode;

	/** The department category code guj. */
	@Column(name = "DEPT_CAT_CODE_GUJ")
	private String departmentCategoryCodeGuj;

	/** The department category code name. */
	@Column(name = "DEPT_CAT_CODE_NAME")
	private String departmentCategoryCodeName;

	/** The department category type id. */
	@Column(name = "DEPT_CAT_TYPE_ID")
	private long departmentCategoryTypeId;

	/** The department category id. */
	@Column(name = "P_DEPT_CAT_ID")
	private long departmentCategoryId;

	/**
	 * PVUDepartmentCategoryEntity Constructor.
	 */
	public PVUDepartmentCategoryEntity() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(departmentCategoryName, departmentCategoryNameGuj, departmentCategoryDesignation,
				departmentCategoryDesignationGuj, departmentCategoryCode, departmentCategoryCodeGuj,
				departmentCategoryCodeName, departmentCategoryTypeId, departmentCategoryId);
	}

	/**
	 * equals method.
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
		if (!(obj instanceof PVUDepartmentCategoryEntity)) {
			return false;
		}

		PVUDepartmentCategoryEntity other = (PVUDepartmentCategoryEntity) obj;

		return Objects.equals(departmentCategoryName, other.departmentCategoryName)
				&& Objects.equals(departmentCategoryNameGuj, other.departmentCategoryNameGuj)
				&& Objects.equals(departmentCategoryDesignation, other.departmentCategoryDesignation)
				&& Objects.equals(departmentCategoryDesignationGuj, other.departmentCategoryDesignationGuj)
				&& Objects.equals(departmentCategoryCode, other.departmentCategoryCode)
				&& Objects.equals(departmentCategoryCodeGuj, other.departmentCategoryCodeGuj)
				&& Objects.equals(departmentCategoryCodeName, other.departmentCategoryCodeName)
				&& departmentCategoryTypeId == other.departmentCategoryTypeId
				&& departmentCategoryId == other.departmentCategoryId;
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUDepartmentCategoryEntity [departmentCategoryName = " + departmentCategoryName
				+ ",departmentCategoryNameGuj = " + departmentCategoryNameGuj + ",departmentCategoryDesignation = "
				+ departmentCategoryDesignation + ",departmentCategoryDesignationGuj = "
				+ departmentCategoryDesignationGuj + ",departmentCategoryCode = " + departmentCategoryCode
				+ ",departmentCategoryCodeGuj = " + departmentCategoryCodeGuj + ",departmentCategoryCodeName = "
				+ departmentCategoryCodeName + ",departmentCategoryTypeId = " + departmentCategoryTypeId
				+ ",departmentCategoryId = " + departmentCategoryId + ",]";
	}

	/**
	 * getter setter.
	 *
	 * @return the department category name
	 */

	/**
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

}
