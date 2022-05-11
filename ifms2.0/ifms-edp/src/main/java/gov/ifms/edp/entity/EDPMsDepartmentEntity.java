package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsDepartmentEntity.
 */
@Entity
@Table(name = "MS_DEPARTMENT", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsDepartmentEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The department id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;

	/** The department name. */
	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;

	/** The department name guj. */
	@Column(name = "DEPARTMENT_NAME_GUJ")
	private String departmentNameGuj;

	/** The department description. */
	@Column(name = "DEPARTMENT_DESC")
	private String departmentDescription;

	/** The department description guj. */
	@Column(name = "DEPARTMENT_DESC_GUJ")
	private String departmentDescriptionGuj;

	/** The department short. */
	@Column(name = "DEPT_SHORT_NAME")
	private String departmentShort;
	
	/** The department short guj. */
	@Column(name = "DEPT_SHORT_NAME_GUJ")
	private String departmentShortGuj;
	
	/** The department code. */
	@Column(name = "DEPARTMENT_CODE",unique = true)
	private String departmentCode;
	
	/** The department code guj. */
	@Column(name = "DEPARTMENT_CODE_GUJ")
	private String departmentCodeGuj;

	/** The parent department id. */
	@Column(name = "PARENT_DEPT_ID")
	private Long parentDepartmentId;
	

	/**
	 * Gets the department id.
	 *
	 * @return the departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * Sets the department id.
	 *
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * Gets the department name.
	 *
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * Sets the department name.
	 *
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * Gets the department name guj.
	 *
	 * @return the departmentNameGuj
	 */
	public String getDepartmentNameGuj() {
		return departmentNameGuj;
	}

	/**
	 * Sets the department name guj.
	 *
	 * @param departmentNameGuj the departmentNameGuj to set
	 */
	public void setDepartmentNameGuj(String departmentNameGuj) {
		this.departmentNameGuj = departmentNameGuj;
	}

	/**
	 * Gets the department description.
	 *
	 * @return the departmentDescription
	 */
	public String getDepartmentDescription() {
		return departmentDescription;
	}

	/**
	 * Sets the department description.
	 *
	 * @param departmentDescription the departmentDescription to set
	 */
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	/**
	 * Gets the department description guj.
	 *
	 * @return the departmentDescriptionGuj
	 */
	public String getDepartmentDescriptionGuj() {
		return departmentDescriptionGuj;
	}

	/**
	 * Sets the department description guj.
	 *
	 * @param departmentDescriptionGuj the departmentDescriptionGuj to set
	 */
	public void setDepartmentDescriptionGuj(String departmentDescriptionGuj) {
		this.departmentDescriptionGuj = departmentDescriptionGuj;
	}

	/**
	 * Gets the department short.
	 *
	 * @return the departmentShort
	 */
	public String getDepartmentShort() {
		return departmentShort;
	}

	/**
	 * Sets the department short.
	 *
	 * @param departmentShort the departmentShort to set
	 */
	public void setDepartmentShort(String departmentShort) {
		this.departmentShort = departmentShort;
	}

	/**
	 * Gets the department short guj.
	 *
	 * @return the departmentShortGuj
	 */
	public String getDepartmentShortGuj() {
		return departmentShortGuj;
	}

	/**
	 * Sets the department short guj.
	 *
	 * @param departmentShortGuj the departmentShortGuj to set
	 */
	public void setDepartmentShortGuj(String departmentShortGuj) {
		this.departmentShortGuj = departmentShortGuj;
	}

	/**
	 * Gets the department code.
	 *
	 * @return the departmentCode
	 */
	public String getDepartmentCode() {
		return departmentCode;
	}

	/**
	 * Sets the department code.
	 *
	 * @param departmentCode the departmentCode to set
	 */
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	/**
	 * Gets the department code guj.
	 *
	 * @return the departmentCodeGuj
	 */
	public String getDepartmentCodeGuj() {
		return departmentCodeGuj;
	}

	/**
	 * Sets the department code guj.
	 *
	 * @param departmentCodeGuj the departmentCodeGuj to set
	 */
	public void setDepartmentCodeGuj(String departmentCodeGuj) {
		this.departmentCodeGuj = departmentCodeGuj;
	}
	
	/**
	 * Gets the parent department id.
	 *
	 * @return the parentDepartmentId
	 */
	public Long getParentDepartmentId() {
		return parentDepartmentId;
	}

	/**
	 * Sets the parent department id.
	 *
	 * @param parentDepartmentId the parentDepartmentId to set
	 */
	public void setParentDepartmentId(Long parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}

	/**
	 * Instantiates a new EDP ms department entity.
	 */
	public EDPMsDepartmentEntity() {
		super();
	}

	/**
	 * Instantiates a new EDP ms department entity.
	 *
	 * @param departmentId the department id
	 */
	public EDPMsDepartmentEntity(long departmentId) {
		super();
		this.departmentId = departmentId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(departmentCode, departmentCodeGuj, departmentDescription, departmentDescriptionGuj,
				departmentId, departmentName, departmentNameGuj, departmentShort, departmentShortGuj,
				parentDepartmentId);
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
		if (!(obj instanceof EDPMsDepartmentEntity)) {
			return false;
		}
		EDPMsDepartmentEntity other = (EDPMsDepartmentEntity) obj;
		return Objects.equals(departmentCode, other.departmentCode)
				&& Objects.equals(departmentCodeGuj, other.departmentCodeGuj)
				&& Objects.equals(departmentDescription, other.departmentDescription)
				&& Objects.equals(departmentDescriptionGuj, other.departmentDescriptionGuj)
				&& Objects.equals(departmentId, other.departmentId)
				&& Objects.equals(departmentName, other.departmentName)
				&& Objects.equals(departmentNameGuj, other.departmentNameGuj)
				&& Objects.equals(departmentShort, other.departmentShort)
				&& Objects.equals(departmentShortGuj, other.departmentShortGuj)
				&& Objects.equals(parentDepartmentId, other.parentDepartmentId);
	}
	
}
