package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class EDPOfficeModuleDto.
 * 
 * @version 1.0
 * @created 2019/12/06 15:00:28
 *
 */
public class EDPOfficeModuleDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The office module id. */
	private Long officeModuleId;

	/** The office id. */
	private Long officeId;

	/** The module id. */
	private List<Long> moduleId;

	/**
	 * EDPOfficeModuleDto Constructor.
	 */
	public EDPOfficeModuleDto() {
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
		if (!(obj instanceof EDPOfficeModuleDto)) {
			return false;
		}
		EDPOfficeModuleDto other = (EDPOfficeModuleDto) obj;
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
	 * @return the module id
	 */
	public List<Long> getModuleId() {
		return moduleId;
	}

	/**
	 * Sets the module id.
	 *
	 * @param moduleId the new module id
	 */
	public void setModuleId(List<Long> moduleId) {
		this.moduleId = moduleId;
	}
	
	/**
	 * Module id is empty.
	 *
	 * @return true, if successful
	 */
	public boolean moduleIdIsEmpty() {
		return moduleId.isEmpty();
	}
	
}
