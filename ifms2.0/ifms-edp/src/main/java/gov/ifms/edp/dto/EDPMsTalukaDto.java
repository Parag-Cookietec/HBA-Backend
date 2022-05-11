package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsTalukaDto.
 * 
 * @version 1.0
 * @created 2019/12/11 11:50:41
 *
 */
public class EDPMsTalukaDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The taluka id. */
	private Long talukaId;

	/** The lang id. */
	private Long langId;

	/** The district id. */
	private Long districtId;

	/** The taluka name. */
	private String talukaName;

	/** The taluka code. */
	private String talukaCode;

	/** The vidhansabha id. */
	private Long vidhansabhaId;

	/**
	 * EDPMsTalukaDto Constructor.
	 */
	public EDPMsTalukaDto() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(talukaId, langId, districtId, talukaName, talukaCode, vidhansabhaId);
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
		if (!(obj instanceof EDPMsTalukaDto)) {
			return false;
		}

		EDPMsTalukaDto other = (EDPMsTalukaDto) obj;

		return Objects.equals(talukaId, other.talukaId) && Objects.equals(langId, other.langId)
				&& Objects.equals(districtId, other.districtId) && Objects.equals(talukaName, other.talukaName)
				&& Objects.equals(talukaCode, other.talukaCode) && Objects.equals(vidhansabhaId, other.vidhansabhaId);
	}

	/**
	 * getter setter.
	 *
	 * @return the taluka id
	 */

	/**
	 * @return the talukaId
	 */
	public Long getTalukaId() {
		return talukaId;
	}

	/**
	 * Sets the taluka id.
	 *
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(Long talukaId) {
		this.talukaId = talukaId;
	}

	/**
	 * Gets the lang id.
	 *
	 * @return the langId
	 */
	public Long getLangId() {
		return langId;
	}

	/**
	 * Sets the lang id.
	 *
	 * @param langId the langId to set
	 */
	public void setLangId(Long langId) {
		this.langId = langId;
	}

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
	 * Gets the taluka name.
	 *
	 * @return the talukaName
	 */
	public String getTalukaName() {
		return talukaName;
	}

	/**
	 * Sets the taluka name.
	 *
	 * @param talukaName the talukaName to set
	 */
	public void setTalukaName(String talukaName) {
		this.talukaName = talukaName;
	}

	/**
	 * Gets the taluka code.
	 *
	 * @return the talukaCode
	 */
	public String getTalukaCode() {
		return talukaCode;
	}

	/**
	 * Sets the taluka code.
	 *
	 * @param talukaCode the talukaCode to set
	 */
	public void setTalukaCode(String talukaCode) {
		this.talukaCode = talukaCode;
	}

	/**
	 * Gets the vidhansabha id.
	 *
	 * @return the vidhansabhaId
	 */
	public Long getVidhansabhaId() {
		return vidhansabhaId;
	}

	/**
	 * Sets the vidhansabha id.
	 *
	 * @param vidhansabhaId the vidhansabhaId to set
	 */
	public void setVidhansabhaId(Long vidhansabhaId) {
		this.vidhansabhaId = vidhansabhaId;
	}

}
