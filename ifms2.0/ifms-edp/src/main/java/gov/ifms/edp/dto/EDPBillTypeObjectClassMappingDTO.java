package gov.ifms.edp.dto;

import java.util.List;
import java.util.Objects;

/**
 * The Class EDPBillTypeObjectClassMappingDTO.
 */
public class EDPBillTypeObjectClassMappingDTO {

	/** The bill type. */
	private List<ClueDto> billType;

	/** The object class. */
	private List<ClueDto> objectClass;

	/**
	 * Gets the bill type.
	 *
	 * @return the billType
	 */
	public List<ClueDto> getBillType() {
		return billType;
	}

	/**
	 * Sets the bill type.
	 *
	 * @param billType the billType to set
	 */
	public void setBillType(List<ClueDto> billType) {
		this.billType = billType;
	}

	/**
	 * Gets the object class.
	 *
	 * @return the objectClass
	 */
	public List<ClueDto> getObjectClass() {
		return objectClass;
	}

	/**
	 * Sets the object class.
	 *
	 * @param objectClass the objectClass to set
	 */
	public void setObjectClass(List<ClueDto> objectClass) {
		this.objectClass = objectClass;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(billType, objectClass);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPBillTypeObjectClassMappingDTO other = (EDPBillTypeObjectClassMappingDTO) obj;
		return Objects.equals(billType, other.billType) && Objects.equals(objectClass, other.objectClass);
	}

}
