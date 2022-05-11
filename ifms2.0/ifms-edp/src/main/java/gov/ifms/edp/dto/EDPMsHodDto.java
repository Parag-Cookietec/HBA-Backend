package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsHodDto.
 * 
 * @version 1.0
 * @created 2020/01/16 15:36:07
 *
 */
public class EDPMsHodDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The hod id. */
	private Long hodId;

	/** The hod name. */
	private String hodName;

	/** The hod name guj. */
	private String hodNameGuj;

	/** The hod desc. */
	private String hodDesc;

	/** The hod desc guj. */
	private String hodDescGuj;

	/** The hod code. */
	private String hodCode;

	/** The hod code guj. */
	private String hodCodeGuj;

	/** The hod short name. */
	private String hodShortName;

	/** The hod short name guj. */
	private String hodShortNameGuj;

	/** The department id. */
	private Long departmentId;

	/**
	 * EDPMsHodDto Constructor.
	 */
	public EDPMsHodDto() {
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
		if (!(obj instanceof EDPMsHodDto)) {
			return false;
		}

		EDPMsHodDto other = (EDPMsHodDto) obj;

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

}
