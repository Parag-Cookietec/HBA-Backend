package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsSubTreasuryDto.
 * 
 * @version 1.0
 * @created 2020/01/20 10:59:54
 *
 */
public class EDPMsSubTreasuryDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The sub treasury id. */
	private Long subTreasuryId;

	/** The sub treasury name. */
	private String subTreasuryName;

	/** The sub treasury name guj. */
	private String subTreasuryNameGuj;

	/** The sub treasury des. */
	private String subTreasuryDes;

	/** The sub treasury des guj. */
	private String subTreasuryDesGuj;

	/** The sub treasury code. */
	private String subTreasuryCode;

	/** The sub treasury code guj. */
	private String subTreasuryCodeGuj;

	/** The sub treasury code name. */
	private String subTreasuryCodeName;

	/** The treasury id. */
	private Long treasuryId;

	/**
	 * EDPMsSubTreasuryDto Constructor.
	 */
	public EDPMsSubTreasuryDto() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(subTreasuryId, subTreasuryName, subTreasuryNameGuj, subTreasuryDes, subTreasuryDesGuj,
				subTreasuryCode, subTreasuryCodeGuj, subTreasuryCodeName, treasuryId);
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
		if (!(obj instanceof EDPMsSubTreasuryDto)) {
			return false;
		}

		EDPMsSubTreasuryDto other = (EDPMsSubTreasuryDto) obj;

		return Objects.equals(subTreasuryId, other.subTreasuryId)
				&& Objects.equals(subTreasuryName, other.subTreasuryName)
				&& Objects.equals(subTreasuryNameGuj, other.subTreasuryNameGuj)
				&& Objects.equals(subTreasuryDes, other.subTreasuryDes)
				&& Objects.equals(subTreasuryDesGuj, other.subTreasuryDesGuj)
				&& Objects.equals(subTreasuryCode, other.subTreasuryCode)
				&& Objects.equals(subTreasuryCodeGuj, other.subTreasuryCodeGuj)
				&& Objects.equals(subTreasuryCodeName, other.subTreasuryCodeName)
				&& Objects.equals(treasuryId, other.treasuryId);
	}

	/**
	 * getter setter.
	 *
	 * @return the sub treasury id
	 */

	/**
	 * @return the subTreasuryId
	 */
	public Long getSubTreasuryId() {
		return subTreasuryId;
	}

	/**
	 * Sets the sub treasury id.
	 *
	 * @param subTreasuryId the subTreasuryId to set
	 */
	public void setSubTreasuryId(Long subTreasuryId) {
		this.subTreasuryId = subTreasuryId;
	}

	/**
	 * Gets the sub treasury name.
	 *
	 * @return the subTreasuryName
	 */
	public String getSubTreasuryName() {
		return subTreasuryName;
	}

	/**
	 * Sets the sub treasury name.
	 *
	 * @param subTreasuryName the subTreasuryName to set
	 */
	public void setSubTreasuryName(String subTreasuryName) {
		this.subTreasuryName = subTreasuryName;
	}

	/**
	 * Gets the sub treasury name guj.
	 *
	 * @return the subTreasuryNameGuj
	 */
	public String getSubTreasuryNameGuj() {
		return subTreasuryNameGuj;
	}

	/**
	 * Sets the sub treasury name guj.
	 *
	 * @param subTreasuryNameGuj the subTreasuryNameGuj to set
	 */
	public void setSubTreasuryNameGuj(String subTreasuryNameGuj) {
		this.subTreasuryNameGuj = subTreasuryNameGuj;
	}

	/**
	 * Gets the sub treasury des.
	 *
	 * @return the subTreasuryDes
	 */
	public String getSubTreasuryDes() {
		return subTreasuryDes;
	}

	/**
	 * Sets the sub treasury des.
	 *
	 * @param subTreasuryDes the subTreasuryDes to set
	 */
	public void setSubTreasuryDes(String subTreasuryDes) {
		this.subTreasuryDes = subTreasuryDes;
	}

	/**
	 * Gets the sub treasury des guj.
	 *
	 * @return the subTreasuryDesGuj
	 */
	public String getSubTreasuryDesGuj() {
		return subTreasuryDesGuj;
	}

	/**
	 * Sets the sub treasury des guj.
	 *
	 * @param subTreasuryDesGuj the subTreasuryDesGuj to set
	 */
	public void setSubTreasuryDesGuj(String subTreasuryDesGuj) {
		this.subTreasuryDesGuj = subTreasuryDesGuj;
	}

	/**
	 * Gets the sub treasury code.
	 *
	 * @return the subTreasuryCode
	 */
	public String getSubTreasuryCode() {
		return subTreasuryCode;
	}

	/**
	 * Sets the sub treasury code.
	 *
	 * @param subTreasuryCode the subTreasuryCode to set
	 */
	public void setSubTreasuryCode(String subTreasuryCode) {
		this.subTreasuryCode = subTreasuryCode;
	}

	/**
	 * Gets the sub treasury code guj.
	 *
	 * @return the subTreasuryCodeGuj
	 */
	public String getSubTreasuryCodeGuj() {
		return subTreasuryCodeGuj;
	}

	/**
	 * Sets the sub treasury code guj.
	 *
	 * @param subTreasuryCodeGuj the subTreasuryCodeGuj to set
	 */
	public void setSubTreasuryCodeGuj(String subTreasuryCodeGuj) {
		this.subTreasuryCodeGuj = subTreasuryCodeGuj;
	}

	/**
	 * Gets the sub treasury code name.
	 *
	 * @return the subTreasuryCodeName
	 */
	public String getSubTreasuryCodeName() {
		return subTreasuryCodeName;
	}

	/**
	 * Sets the sub treasury code name.
	 *
	 * @param subTreasuryCodeName the subTreasuryCodeName to set
	 */
	public void setSubTreasuryCodeName(String subTreasuryCodeName) {
		this.subTreasuryCodeName = subTreasuryCodeName;
	}

	/**
	 * Gets the treasury id.
	 *
	 * @return the treasuryId
	 */
	public Long getTreasuryId() {
		return treasuryId;
	}

	/**
	 * Sets the treasury id.
	 *
	 * @param treasuryId the treasuryId to set
	 */
	public void setTreasuryId(Long treasuryId) {
		this.treasuryId = treasuryId;
	}
}
