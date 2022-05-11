package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class EDPLuLookUpInfoDto.
 * 
 * @version 1.0
 * @created 2019/08/29 18:24:43
 *
 */
public class EDPLuLookUpInfoDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The look up info id. */
	private long lookUpInfoId;

	/** The look up info name. */
	private String lookUpInfoName;

	/** The look up info name guj. */
	private String lookUpInfoNameGuj;

	/** The look up info description. */
	private String lookUpInfoDescription;

	/** The look up info description guj. */
	private String lookUpInfoDescriptionGuj;

	/** The parent look up info id. */
	private int parentLookUpInfoId;

	/** The order id. */
	private short orderId;

	/** The look up info value. */
	private int lookUpInfoValue;
	
	/** The tresury type. */
	private List<EDPLuLookUpInfoDto> tresuryType; 
	
	
	/**
	 * Gets the look up info value.
	 *
	 * @return the look up info value
	 */
	public int getLookUpInfoValue() {
		return lookUpInfoValue;
	}

	/**
	 * Sets the look up info value.
	 *
	 * @param lookUpInfoValue the new look up info value
	 */
	public void setLookUpInfoValue(int lookUpInfoValue) {
		this.lookUpInfoValue = lookUpInfoValue;
	}

	/**
	 * Gets the look up info id.
	 *
	 * @return the lookUpInfoId
	 */
	public long getLookUpInfoId() {
		return lookUpInfoId;
	}

	/**
	 * Sets the look up info id.
	 *
	 * @param lookUpInfoId the lookUpInfoId to set
	 */
	public void setLookUpInfoId(long lookUpInfoId) {
		this.lookUpInfoId = lookUpInfoId;
	}

	/**
	 * Gets the look up info name.
	 *
	 * @return the lookUpInfoName
	 */
	public String getLookUpInfoName() {
		return lookUpInfoName;
	}

	/**
	 * Sets the look up info name.
	 *
	 * @param lookUpInfoName the lookUpInfoName to set
	 */
	public void setLookUpInfoName(String lookUpInfoName) {
		this.lookUpInfoName = lookUpInfoName;
	}

	/**
	 * Gets the look up info name guj.
	 *
	 * @return the lookUpInfoNameGuj
	 */
	public String getLookUpInfoNameGuj() {
		return lookUpInfoNameGuj;
	}

	/**
	 * Sets the look up info name guj.
	 *
	 * @param lookUpInfoNameGuj the lookUpInfoNameGuj to set
	 */
	public void setLookUpInfoNameGuj(String lookUpInfoNameGuj) {
		this.lookUpInfoNameGuj = lookUpInfoNameGuj;
	}

	/**
	 * Gets the look up info description.
	 *
	 * @return the lookUpInfoDescription
	 */
	public String getLookUpInfoDescription() {
		return lookUpInfoDescription;
	}

	/**
	 * Sets the look up info description.
	 *
	 * @param lookUpInfoDescription the lookUpInfoDescription to set
	 */
	public void setLookUpInfoDescription(String lookUpInfoDescription) {
		this.lookUpInfoDescription = lookUpInfoDescription;
	}

	/**
	 * Gets the look up info description guj.
	 *
	 * @return the lookUpInfoDescriptionGuj
	 */
	public String getLookUpInfoDescriptionGuj() {
		return lookUpInfoDescriptionGuj;
	}

	/**
	 * Sets the look up info description guj.
	 *
	 * @param lookUpInfoDescriptionGuj the lookUpInfoDescriptionGuj to set
	 */
	public void setLookUpInfoDescriptionGuj(String lookUpInfoDescriptionGuj) {
		this.lookUpInfoDescriptionGuj = lookUpInfoDescriptionGuj;
	}

	/**
	 * Gets the parent look up info id.
	 *
	 * @return the parentLookUpInfoId
	 */
	public int getParentLookUpInfoId() {
		return parentLookUpInfoId;
	}

	/**
	 * Sets the parent look up info id.
	 *
	 * @param parentLookUpInfoId the parentLookUpInfoId to set
	 */
	public void setParentLookUpInfoId(int parentLookUpInfoId) {
		this.parentLookUpInfoId = parentLookUpInfoId;
	}

	/**
	 * Gets the order id.
	 *
	 * @return the orderId
	 */
	public short getOrderId() {
		return orderId;
	}

	/**
	 * Sets the order id.
	 *
	 * @param orderId the orderId to set
	 */
	public void setOrderId(short orderId) {
		this.orderId = orderId;
	}

	/**
	 * Gets the tresury type.
	 *
	 * @return the tresuryType
	 */
	public List<EDPLuLookUpInfoDto> getTresuryType() {
		return tresuryType;
	}

	/**
	 * Sets the tresury type.
	 *
	 * @param tresuryType the tresuryType to set
	 */
	public void setTresuryType(List<EDPLuLookUpInfoDto> tresuryType) {
		this.tresuryType = tresuryType;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lookUpInfoDescription, lookUpInfoDescriptionGuj, lookUpInfoId, lookUpInfoName,
				lookUpInfoNameGuj, lookUpInfoValue, orderId, parentLookUpInfoId, tresuryType);
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
		if (!(obj instanceof EDPLuLookUpInfoDto)) {
			return false;
		}
		EDPLuLookUpInfoDto other = (EDPLuLookUpInfoDto) obj;
		return Objects.equals(lookUpInfoDescription, other.lookUpInfoDescription)
				&& Objects.equals(lookUpInfoDescriptionGuj, other.lookUpInfoDescriptionGuj)
				&& lookUpInfoId == other.lookUpInfoId && Objects.equals(lookUpInfoName, other.lookUpInfoName)
				&& Objects.equals(lookUpInfoNameGuj, other.lookUpInfoNameGuj)
				&& lookUpInfoValue == other.lookUpInfoValue && orderId == other.orderId
				&& parentLookUpInfoId == other.parentLookUpInfoId && Objects.equals(tresuryType, other.tresuryType);
	}

	

}
