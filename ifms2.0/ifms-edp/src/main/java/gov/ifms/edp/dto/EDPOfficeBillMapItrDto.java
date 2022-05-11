package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPOfficeBillMapItrDto.
 * 
 * @version 1.0
 * @created 2019/12/06 15:16:23
 *
 */
public class EDPOfficeBillMapItrDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The office bill map itr id. */
	private Long officeBillMapItrId;

	/** The office bill map id. */
	private Long officeBillMapId;

	/** The office id. */
	private Long officeId;

	/** The bill submitted to. */
	private Long billSubmittedTo;

	/** The bill type. */
	private Long billType;

	/** The bill list id. */
	private Long billListId;

	/** The status id. */
	private Long statusId;

	/** The workflow id. */
	private Long workflowId;

	/** The wf role id. */
	private Long wfRoleId;

	/**
	 * EDPOfficeBillMapItrDto Constructor.
	 */
	public EDPOfficeBillMapItrDto() {
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
				statusId, workflowId, wfRoleId);
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
		if (!(obj instanceof EDPOfficeBillMapItrDto)) {
			return false;
		}

		EDPOfficeBillMapItrDto other = (EDPOfficeBillMapItrDto) obj;

		return Objects.equals(officeBillMapItrId, other.officeBillMapItrId)
				&& Objects.equals(officeBillMapId, other.officeBillMapId) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(billSubmittedTo, other.billSubmittedTo) && Objects.equals(billType, other.billType)
				&& Objects.equals(billListId, other.billListId) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(workflowId, other.workflowId) && Objects.equals(wfRoleId, other.wfRoleId);
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
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the workflow id.
	 *
	 * @return the workflowId
	 */
	public Long getWorkflowId() {
		return workflowId;
	}

	/**
	 * Sets the workflow id.
	 *
	 * @param workflowId the workflowId to set
	 */
	public void setWorkflowId(Long workflowId) {
		this.workflowId = workflowId;
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
