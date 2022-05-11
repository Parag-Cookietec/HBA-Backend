package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class EDPOfficeBillMapDto.
 */
public class EDPOfficeBillMapDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The office bill map id. */
	private Long officeBillMapId;

	/** The office id. */
	private Long officeId;

	/** The bill submitted to. */
	private Long billSubmittedTo;

	/** The bill type. */
	private Long billType;

	/** The bill type selected. */
	private Long billTypeSelected;

	/** The status. */
	private Long status;

	/** The workflow id. */
	private Long workflowId;

	/** The wf role id. */
	private Long wfRoleId;
	
	/** The selected bills. */
	private List<Long> selectedBills;

	/**
	 * EDPofficeBillMapDto Constructor.
	 */
	public EDPOfficeBillMapDto() {
		super();
	}

	/**
	 * getter setter.
	 *
	 * @return the office bill map id
	 */

	/**
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
	 * Gets the bill type selected.
	 *
	 * @return the billTypeSelected
	 */
	public Long getBillTypeSelected() {
		return billTypeSelected;
	}

	/**
	 * Sets the bill type selected.
	 *
	 * @param billTypeSelected the billTypeSelected to set
	 */
	public void setBillTypeSelected(Long billTypeSelected) {
		this.billTypeSelected = billTypeSelected;
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

	/**
	 * Gets the selected bills.
	 *
	 * @return the selectedBills
	 */
	public List<Long> getSelectedBills() {
		return selectedBills;
	}

	/**
	 * Sets the selected bills.
	 *
	 * @param selectedBills the selectedBills to set
	 */
	public void setSelectedBills(List<Long> selectedBills) {
		this.selectedBills = selectedBills;
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
		result = prime * result + Objects.hash(billSubmittedTo, billType, billTypeSelected, officeBillMapId, officeId,
				selectedBills, status, wfRoleId, workflowId);
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
		if (!(obj instanceof EDPOfficeBillMapDto)) {
			return false;
		}
		EDPOfficeBillMapDto other = (EDPOfficeBillMapDto) obj;
		return Objects.equals(billSubmittedTo, other.billSubmittedTo) && Objects.equals(billType, other.billType)
				&& Objects.equals(billTypeSelected, other.billTypeSelected)
				&& Objects.equals(officeBillMapId, other.officeBillMapId) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(selectedBills, other.selectedBills) && Objects.equals(status, other.status)
				&& Objects.equals(wfRoleId, other.wfRoleId) && Objects.equals(workflowId, other.workflowId);
	}
	
}
