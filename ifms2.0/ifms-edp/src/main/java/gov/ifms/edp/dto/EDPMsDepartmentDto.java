package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;


/**
 * The Class EDPMsDepartmentDto.
 * 
 * @version 1.0
 * @created 2019/08/29 15:05:35
 *
 */
public class EDPMsDepartmentDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The department id. */
	private long departmentId;

	/** The department name. */
	private String departmentName;

	/** The department name guj. */
	private String departmentNameGuj;

	/** The department description. */
	private String departmentDescription;

	/** The department description guj. */
	private String departmentDescriptionGuj;

	/** The department short. */
	private String departmentShort;

	/** The department short guj. */
	private String departmentShortGuj;

	/** The department code. */
	private String departmentCode;

	/** The department code guj. */
	private String departmentCodeGuj;

	/** The department code name. */
	private String departmentCodeName;

	/** The department type id. */
	private int departmentTypeId;

	/** The parent department id. */
	private int parentDepartmentId;
	
	/** The bpn code. */
	private String bpnCode;
	
	/** The bpn id. */
	private Long bpnId;

	/**
	 * Gets the bpn id.
	 *
	 * @return the bpn id
	 */
	public Long getBpnId() {
		return bpnId;
	}

	/**
	 * Sets the bpn id.
	 *
	 * @param bpnId the new bpn id
	 */
	public void setBpnId(Long bpnId) {
		this.bpnId = bpnId;
	}

	/**
	 * Gets the bpn code.
	 *
	 * @return the bpn code
	 */
	public String getBpnCode() {
		return bpnCode;
	}

	/**
	 * Sets the bpn code.
	 *
	 * @param bpnCode the new bpn code
	 */
	public void setBpnCode(String bpnCode) {
		this.bpnCode = bpnCode;
	}

	/**
	 * Gets the department id.
	 *
	 * @return the departmentId
	 */
	public long getDepartmentId() {
		return departmentId;
	}

	/**
	 * Sets the department id.
	 *
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(long departmentId) {
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
	 * Gets the department code name.
	 *
	 * @return the departmentCodeName
	 */
	public String getDepartmentCodeName() {
		return departmentCodeName;
	}

	/**
	 * Sets the department code name.
	 *
	 * @param departmentCodeName the departmentCodeName to set
	 */
	public void setDepartmentCodeName(String departmentCodeName) {
		this.departmentCodeName = departmentCodeName;
	}

	/**
	 * Gets the department type id.
	 *
	 * @return the departmentTypeId
	 */
	public int getDepartmentTypeId() {
		return departmentTypeId;
	}

	/**
	 * Sets the department type id.
	 *
	 * @param departmentTypeId the departmentTypeId to set
	 */
	public void setDepartmentTypeId(int departmentTypeId) {
		this.departmentTypeId = departmentTypeId;
	}

	/**
	 * Gets the parent department id.
	 *
	 * @return the parentDepartmentId
	 */
	public int getParentDepartmentId() {
		return parentDepartmentId;
	}

	/**
	 * Sets the parent department id.
	 *
	 * @param parentDepartmentId the parentDepartmentId to set
	 */
	public void setParentDepartmentId(int parentDepartmentId) {
		this.parentDepartmentId = parentDepartmentId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bpnCode, bpnId, departmentCode, departmentCodeGuj, departmentCodeName,
				departmentDescription, departmentDescriptionGuj, departmentId, departmentName, departmentNameGuj,
				departmentShort, departmentShortGuj, departmentTypeId, parentDepartmentId);
		return result;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPMsDepartmentDto)) {
			return false;
		}
		EDPMsDepartmentDto other = (EDPMsDepartmentDto) obj;
		return Objects.equals(bpnCode, other.bpnCode) && Objects.equals(bpnId, other.bpnId)
				&& Objects.equals(departmentCode, other.departmentCode)
				&& Objects.equals(departmentCodeGuj, other.departmentCodeGuj)
				&& Objects.equals(departmentCodeName, other.departmentCodeName)
				&& Objects.equals(departmentDescription, other.departmentDescription)
				&& Objects.equals(departmentDescriptionGuj, other.departmentDescriptionGuj)
				&& departmentId == other.departmentId && Objects.equals(departmentName, other.departmentName)
				&& Objects.equals(departmentNameGuj, other.departmentNameGuj)
				&& Objects.equals(departmentShort, other.departmentShort)
				&& Objects.equals(departmentShortGuj, other.departmentShortGuj)
				&& departmentTypeId == other.departmentTypeId && parentDepartmentId == other.parentDepartmentId;
	}

}
