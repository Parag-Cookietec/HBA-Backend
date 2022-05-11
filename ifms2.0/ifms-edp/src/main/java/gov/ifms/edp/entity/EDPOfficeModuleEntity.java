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
 * The Class EDPOfficeModuleEntity.
 * 
 * @version 1.0
 * @created 2019/12/06 15:00:28
 *
 */
@Entity
@Table(name = "T_EDP_OFF_MOD", schema = Constant.EDP_SCHEMA)
public class EDPOfficeModuleEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The office module id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EDP_OFF_MOD_ID")
	private Long officeModuleId;

	/** The office id. */
	@Column(name = "OFFICE_ID")
	private Long officeId;

	/** The module id. */
	@Column(name = "MODULE_ID")
	private Long moduleId;

	/**
	 * EDPOfficeModuleDto Constructor.
	 */
	public EDPOfficeModuleEntity() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(moduleId, officeId, officeModuleId);
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
		if (!(obj instanceof EDPOfficeModuleEntity)) {
			return false;
		}
		EDPOfficeModuleEntity other = (EDPOfficeModuleEntity) obj;
		return Objects.equals(moduleId, other.moduleId) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(officeModuleId, other.officeModuleId);
	}

	/**
	 * getter setter.
	 *
	 * @return the office module id
	 */

	/**
	 * @return the officeModuleId
	 */
	public Long getOfficeModuleId() {
		return officeModuleId;
	}

	/**
	 * Sets the office module id.
	 *
	 * @param officeModuleId the officeModuleId to set
	 */
	public void setOfficeModuleId(Long officeModuleId) {
		this.officeModuleId = officeModuleId;
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
	 * Gets the module id.
	 *
	 * @return the moduleId
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/**
	 * Sets the module id.
	 *
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

}
