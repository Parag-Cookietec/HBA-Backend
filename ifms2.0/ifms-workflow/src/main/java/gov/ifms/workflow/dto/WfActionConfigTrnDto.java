package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.Objects;


public class WfActionConfigTrnDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

    private Long trnId;

    private Long actionConfigId;

    private WfUserDetails assignedTo;
    
    private WfUserDetails assignedBy;
    
    private String remarks;

	/**
	 * @return the trnId
	 */
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * @param trnId the trnId to set
	 */
	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	/**
	 * @return the actionConfigId
	 */
	public Long getActionConfigId() {
		return actionConfigId;
	}

	/**
	 * @param actionConfigId the actionConfigId to set
	 */
	public void setActionConfigId(Long actionConfigId) {
		this.actionConfigId = actionConfigId;
	}

	/**
	 * @return the assignedTo
	 */
	public WfUserDetails getAssignedTo() {
		return assignedTo;
	}

	/**
	 * @param assignedTo the assignedTo to set
	 */
	public void setAssignedTo(WfUserDetails assignedTo) {
		this.assignedTo = assignedTo;
	}

	/**
	 * @return the assignedBy
	 */
	public WfUserDetails getAssignedBy() {
		return assignedBy;
	}

	/**
	 * @param assignedBy the assignedBy to set
	 */
	public void setAssignedBy(WfUserDetails assignedBy) {
		this.assignedBy = assignedBy;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actionConfigId, assignedBy, assignedTo, remarks, trnId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof WfActionConfigTrnDto)) {
			return false;
		}
		WfActionConfigTrnDto other = (WfActionConfigTrnDto) obj;
		return Objects.equals(actionConfigId, other.actionConfigId) && Objects.equals(assignedBy, other.assignedBy)
				&& Objects.equals(assignedTo, other.assignedTo) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(trnId, other.trnId);
	}

	@Override
	public String toString() {
		return String.format(
				"WfActionConfigTrnDto [trnId=%s, actionConfigId=%s, assignedTo=%s, assignedBy=%s, remarks=%s]", trnId,
				actionConfigId, assignedTo, assignedBy, remarks);
	}
}
