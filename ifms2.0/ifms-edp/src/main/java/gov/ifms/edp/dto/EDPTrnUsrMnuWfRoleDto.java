package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPTrnUsrMnuWfRoleDto.
 */
public class EDPTrnUsrMnuWfRoleDto extends BaseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trn usr wf role id. */
	private Long trnUsrWfRoleId;

	/** The lk user menu id. */
	private long lkUserMenuId;

	/** The workflow role id. */
	private long workflowRoleId;


	/**
	 * EDPLkPuoMenuRLWFDto Constructor.
	 */
	public EDPTrnUsrMnuWfRoleDto() {
		super();
	}

	/**
	 * Gets the trn usr wf role id.
	 *
	 * @return the trnUsrWfRoleId
	 */
	public Long getTrnUsrWfRoleId() {
		return trnUsrWfRoleId;
	}

	/**
	 * Sets the trn usr wf role id.
	 *
	 * @param trnUsrWfRoleId the trnUsrWfRoleId to set
	 */
	public void setTrnUsrWfRoleId(Long trnUsrWfRoleId) {
		this.trnUsrWfRoleId = trnUsrWfRoleId;
	}

	/**
	 * Gets the lk user menu id.
	 *
	 * @return the lkUserMenuId
	 */
	public long getLkUserMenuId() {
		return lkUserMenuId;
	}

	/**
	 * Sets the lk user menu id.
	 *
	 * @param lkUserMenuId the lkUserMenuId to set
	 */
	public void setLkUserMenuId(long lkUserMenuId) {
		this.lkUserMenuId = lkUserMenuId;
	}

	/**
	 * Gets the workflow role id.
	 *
	 * @return the workflowRoleId
	 */
	public long getWorkflowRoleId() {
		return workflowRoleId;
	}

	/**
	 * Sets the workflow role id.
	 *
	 * @param workflowRoleId the workflowRoleId to set
	 */
	public void setWorkflowRoleId(long workflowRoleId) {
		this.workflowRoleId = workflowRoleId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lkUserMenuId, trnUsrWfRoleId, workflowRoleId);
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
		if (!(obj instanceof EDPTrnUsrMnuWfRoleDto)) {
			return false;
		}
		EDPTrnUsrMnuWfRoleDto other = (EDPTrnUsrMnuWfRoleDto) obj;
		return lkUserMenuId == other.lkUserMenuId 
				&& Objects.equals(trnUsrWfRoleId, other.trnUsrWfRoleId) && workflowRoleId == other.workflowRoleId;
	}

	

}
