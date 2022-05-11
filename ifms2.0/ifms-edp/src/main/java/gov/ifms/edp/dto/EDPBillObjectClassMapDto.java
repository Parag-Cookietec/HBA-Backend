package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class EDPBillObjectClassMapDto.
 */
public class EDPBillObjectClassMapDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The bill objmap id. */
	private Long billObjmapId;

	/** The bill type id. */
	private Long billTypeId;

	/** The object class id. */
	private List<Long> objectClassId;

	/**
	 * EDPTBillObjectMapDto Constructor.
	 */
	public EDPBillObjectClassMapDto() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(billObjmapId, billTypeId, objectClassId);
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
		if (!(obj instanceof EDPBillObjectClassMapDto)) {
			return false;
		}

		EDPBillObjectClassMapDto other = (EDPBillObjectClassMapDto) obj;

		return Objects.equals(billObjmapId, other.billObjmapId) && Objects.equals(billTypeId, other.billTypeId)
				&& Objects.equals(objectClassId, other.objectClassId);
	}

	/**
	 * getter setter.
	 *
	 * @return the bill objmap id
	 */

	/**
	 * @return the billObjmapId
	 */
	public Long getBillObjmapId() {
		return billObjmapId;
	}

	/**
	 * Sets the bill objmap id.
	 *
	 * @param billObjmapId the billObjmapId to set
	 */
	public void setBillObjmapId(Long billObjmapId) {
		this.billObjmapId = billObjmapId;
	}

	/**
	 * Gets the bill type id.
	 *
	 * @return the billTypeId
	 */
	public Long getBillTypeId() {
		return billTypeId;
	}

	/**
	 * Sets the bill type id.
	 *
	 * @param billTypeId the billTypeId to set
	 */
	public void setBillTypeId(Long billTypeId) {
		this.billTypeId = billTypeId;
	}

	
	/**
	 * Gets the object class id.
	 *
	 * @return the objectClassId
	 */
	public List<Long> getObjectClassId() {
		return objectClassId;
	}

	/**
	 * Sets the object class id.
	 *
	 * @param objectClassId the objectClassId to set
	 */
	public void setObjectClassId(List<Long> objectClassId) {
		this.objectClassId = objectClassId;
	}
	
}
