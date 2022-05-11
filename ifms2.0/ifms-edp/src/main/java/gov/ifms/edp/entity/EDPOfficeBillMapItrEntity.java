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
 * The Class EDPOfficeBillMapItrEntity.
 * 
 * @version 1.0
 * @created 2019/12/06 15:16:23
 *
 */
@Entity
@Table(name = "T_EDP_O_BILL_MAP_ITR", schema = Constant.EDP_SCHEMA)
public class EDPOfficeBillMapItrEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The office bill map itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EDP_OBILLM_ITR_ID")
	private Long officeBillMapItrId;

	/** The office bill map id. */
	@Column(name = "T_EDP_O_BILL_MAP_ID")
	private Long officeBillMapId;

	/** The office id. */
	@Column(name = "OFFICE_ID")
	private Long officeId;

	/** The bill submitted to. */
	@Column(name = "BILL_SUB_TO")
	private Long billSubmittedTo;

	/** The bill type. */
	@Column(name = "BILL_TYPE")
	private Long billType;

	/** The bill list id. */
	@Column(name = "BILL_LIST_ID")
	private Long billListId;

	/** The status. */
	@Column(name = "STATUS_ID")
	private Long status;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/**
	 * EDPOfficeBillMapItrDto Constructor.
	 */
	public EDPOfficeBillMapItrEntity() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(officeBillMapItrId, officeBillMapId, officeId, billSubmittedTo, billType, billListId,
				status, wfRoleId);
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
		if (!(obj instanceof EDPOfficeBillMapItrEntity)) {
			return false;
		}

		EDPOfficeBillMapItrEntity other = (EDPOfficeBillMapItrEntity) obj;

		return Objects.equals(officeBillMapItrId, other.officeBillMapItrId)
				&& Objects.equals(officeBillMapId, other.officeBillMapId) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(billSubmittedTo, other.billSubmittedTo) && Objects.equals(billType, other.billType)
				&& Objects.equals(billListId, other.billListId) && Objects.equals(status, other.status);
	}

	/**
	 * getter setter.
	 *
	 * @return the office bill map itr id
	 */

	/**
	 * @return the officeBillMapItrId
	 */
	public Long getOfficeBillMapItrId() {
		return officeBillMapItrId;
	}

	/**
	 * Sets the office bill map itr id.
	 *
	 * @param officeBillMapItrId the officeBillMapItrId to set
	 */
	public void setOfficeBillMapItrId(Long officeBillMapItrId) {
		this.officeBillMapItrId = officeBillMapItrId;
	}

	/**
	 * Gets the office bill map id.
	 *
	 * @return the officeBillMapId
	 */
	public Long getOfficeBillMapId() {
		return officeBillMapId;
	}

	/**
	 * Sets the office bill map id.
	 *
	 * @param officeBillMapId the officeBillMapId to set
	 */
	public void setOfficeBillMapId(Long officeBillMapId) {
		this.officeBillMapId = officeBillMapId;
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
	 * Gets the bill submitted to.
	 *
	 * @return the billSubmittedTo
	 */
	public Long getBillSubmittedTo() {
		return billSubmittedTo;
	}

	/**
	 * Sets the bill submitted to.
	 *
	 * @param billSubmittedTo the billSubmittedTo to set
	 */
	public void setBillSubmittedTo(Long billSubmittedTo) {
		this.billSubmittedTo = billSubmittedTo;
	}

	/**
	 * Gets the bill type.
	 *
	 * @return the billType
	 */
	public Long getBillType() {
		return billType;
	}

	/**
	 * Sets the bill type.
	 *
	 * @param billType the billType to set
	 */
	public void setBillType(Long billType) {
		this.billType = billType;
	}

	/**
	 * Gets the bill list id.
	 *
	 * @return the billListId
	 */
	public Long getBillListId() {
		return billListId;
	}

	/**
	 * Sets the bill list id.
	 *
	 * @param billListId the billListId to set
	 */
	public void setBillListId(Long billListId) {
		this.billListId = billListId;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Long getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(Long status) {
		this.status = status;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

}
