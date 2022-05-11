package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsHodEntity.
 * 
 * @version 1.0
 * @created 2020/01/16 15:36:07
 *
 */
@Entity
@Table(name = "MS_HOD", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsHodEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The hod id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HOD_ID")
	private Long hodId;

	/** The hod name. */
	@Column(name = "HOD_NAME")
	private String hodName;

	/** The hod name guj. */
	@Column(name = "HOD_NAME_GUJ")
	private String hodNameGuj;

	/** The hod desc. */
	@Column(name = "HOD_DESC")
	private String hodDesc;

	/** The hod desc guj. */
	@Column(name = "HOD_DESC_GUJ")
	private String hodDescGuj;

	/** The hod code. */
	@Column(name = "HOD_CODE")
	private String hodCode;

	/** The hod code guj. */
	@Column(name = "HOD_CODE_GUJ")
	private String hodCodeGuj;

	/** The hod short name. */
	@Column(name = "HOD_SHORT_NAME")
	private String hodShortName;

	/** The hod short name guj. */
	@Column(name = "HOD_SHORT_NAME_GUJ")
	private String hodShortNameGuj;

	/** The department id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_ID")
	private EDPMsDepartmentEntity departmentId;

	/**
	 * EDPMsHodDto Constructor.
	 */
	public EDPMsHodEntity() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(hodId, hodName, hodNameGuj, hodDesc, hodDescGuj, hodCode, hodCodeGuj, hodShortName,
				hodShortNameGuj, departmentId);
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
		if (!(obj instanceof EDPMsHodEntity)) {
			return false;
		}

		EDPMsHodEntity other = (EDPMsHodEntity) obj;

		return Objects.equals(hodId, other.hodId) && Objects.equals(hodName, other.hodName)
				&& Objects.equals(hodNameGuj, other.hodNameGuj) && Objects.equals(hodDesc, other.hodDesc)
				&& Objects.equals(hodDescGuj, other.hodDescGuj) && Objects.equals(hodCode, other.hodCode)
				&& Objects.equals(hodCodeGuj, other.hodCodeGuj) && Objects.equals(hodShortName, other.hodShortName)
				&& Objects.equals(hodShortNameGuj, other.hodShortNameGuj)
				&& Objects.equals(departmentId, other.departmentId);
	}

	/**
	 * getter setter.
	 *
	 * @return the hod id
	 */

	/**
	 * @return the hodId
	 */
	public Long getHodId() {
		return hodId;
	}

	/**
	 * Sets the hod id.
	 *
	 * @param hodId the hodId to set
	 */
	public void setHodId(Long hodId) {
		this.hodId = hodId;
	}

	/**
	 * Gets the hod name.
	 *
	 * @return the hodName
	 */
	public String getHodName() {
		return hodName;
	}

	/**
	 * Sets the hod name.
	 *
	 * @param hodName the hodName to set
	 */
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	/**
	 * Gets the hod name guj.
	 *
	 * @return the hodNameGuj
	 */
	public String getHodNameGuj() {
		return hodNameGuj;
	}

	/**
	 * Sets the hod name guj.
	 *
	 * @param hodNameGuj the hodNameGuj to set
	 */
	public void setHodNameGuj(String hodNameGuj) {
		this.hodNameGuj = hodNameGuj;
	}

	/**
	 * Gets the hod desc.
	 *
	 * @return the hodDesc
	 */
	public String getHodDesc() {
		return hodDesc;
	}

	/**
	 * Sets the hod desc.
	 *
	 * @param hodDesc the hodDesc to set
	 */
	public void setHodDesc(String hodDesc) {
		this.hodDesc = hodDesc;
	}

	/**
	 * Gets the hod desc guj.
	 *
	 * @return the hodDescGuj
	 */
	public String getHodDescGuj() {
		return hodDescGuj;
	}

	/**
	 * Sets the hod desc guj.
	 *
	 * @param hodDescGuj the hodDescGuj to set
	 */
	public void setHodDescGuj(String hodDescGuj) {
		this.hodDescGuj = hodDescGuj;
	}

	/**
	 * Gets the hod code.
	 *
	 * @return the hodCode
	 */
	public String getHodCode() {
		return hodCode;
	}

	/**
	 * Sets the hod code.
	 *
	 * @param hodCode the hodCode to set
	 */
	public void setHodCode(String hodCode) {
		this.hodCode = hodCode;
	}

	/**
	 * Gets the hod code guj.
	 *
	 * @return the hodCodeGuj
	 */
	public String getHodCodeGuj() {
		return hodCodeGuj;
	}

	/**
	 * Sets the hod code guj.
	 *
	 * @param hodCodeGuj the hodCodeGuj to set
	 */
	public void setHodCodeGuj(String hodCodeGuj) {
		this.hodCodeGuj = hodCodeGuj;
	}

	/**
	 * Gets the hod short name.
	 *
	 * @return the hodShortName
	 */
	public String getHodShortName() {
		return hodShortName;
	}

	/**
	 * Sets the hod short name.
	 *
	 * @param hodShortName the hodShortName to set
	 */
	public void setHodShortName(String hodShortName) {
		this.hodShortName = hodShortName;
	}

	/**
	 * Gets the hod short name guj.
	 *
	 * @return the hodShortNameGuj
	 */
	public String getHodShortNameGuj() {
		return hodShortNameGuj;
	}

	/**
	 * Sets the hod short name guj.
	 *
	 * @param hodShortNameGuj the hodShortNameGuj to set
	 */
	public void setHodShortNameGuj(String hodShortNameGuj) {
		this.hodShortNameGuj = hodShortNameGuj;
	}

	/**
	 * Gets the department id.
	 *
	 * @return the departmentId
	 */
	public EDPMsDepartmentEntity getDepartmentId() {
		return departmentId;
	}

	/**
	 * Sets the department id.
	 *
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(EDPMsDepartmentEntity departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @param hodId
	 */
	public EDPMsHodEntity(Long hodId) {
		super();
		this.hodId = hodId;
	}

	

}
