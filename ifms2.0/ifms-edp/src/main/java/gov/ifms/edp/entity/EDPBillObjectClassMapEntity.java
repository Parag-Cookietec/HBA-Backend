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
 * The Class EDPBillObjectClassMapEntity.
 */
@Entity
@Table(name = "T_EDP_BILL_OBJ_MAP", schema = Constant.EDP_SCHEMA)
public class EDPBillObjectClassMapEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The bill objmap id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EDP_BILL_OBJMAP_ID")
	private Long billObjmapId;

	/** The bill type id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BILL_TYPE_ID",referencedColumnName= "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity billTypeId;

	/** The object class id. */
	@Column(name = "OBJECTCLASS_ID")
	private Long objectClassId;

	/**
	 * EDPTBillObjectMapDto Constructor.
	 */
	public EDPBillObjectClassMapEntity() {
		super();
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
	public EDPLuLookUpInfoEntity getBillTypeId() {
		return billTypeId;
	}

	/**
	 * Sets the bill type id.
	 *
	 * @param billTypeId the billTypeId to set
	 */
	public void setBillTypeId(EDPLuLookUpInfoEntity billTypeId) {
		this.billTypeId = billTypeId;
	}

	/**
	 * Gets the object class id.
	 *
	 * @return the objectClassId
	 */
	public Long getObjectClassId() {
		return objectClassId;
	}

	/**
	 * Sets the object class id.
	 *
	 * @param objectClassId the objectClassId to set
	 */
	public void setObjectClassId(Long objectClassId) {
		this.objectClassId = objectClassId;
	}
	
	
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(billObjmapId, billTypeId, objectClassId);
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
		EDPBillObjectClassMapEntity other = (EDPBillObjectClassMapEntity) obj;
		return Objects.equals(billObjmapId, other.billObjmapId) && Objects.equals(billTypeId, other.billTypeId)
				&& Objects.equals(objectClassId, other.objectClassId);
	}
	
}
