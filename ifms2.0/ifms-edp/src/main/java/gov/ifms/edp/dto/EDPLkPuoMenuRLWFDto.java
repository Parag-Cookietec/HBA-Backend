package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPLkPuoMenuRLWFDto.
 * 
 * @version 1.0
 * @created 2019/11/28 12:49:10
 *
 */
public class EDPLkPuoMenuRLWFDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lk puo menu rlwf id. */
	private Long lkPuoMenuRlwfId;

	/** The lk puo menu role id. */
	private Long lkPuoMenuRoleId;

	/** The workflow role id. */
	private Long workflowRoleId;

	/**
	 * EDPLkPuoMenuRLWFDto Constructor.
	 */
	public EDPLkPuoMenuRLWFDto() {
		super();
	}

	/**
	 * Gets the lk puo menu rlwf id.
	 *
	 * @return the lkPuoMenuRlwfId
	 */
	public Long getLkPuoMenuRlwfId() {
		return lkPuoMenuRlwfId;
	}

	/**
	 * Sets the lk puo menu rlwf id.
	 *
	 * @param lkPuoMenuRlwfId the lkPuoMenuRlwfId to set
	 */
	public void setLkPuoMenuRlwfId(Long lkPuoMenuRlwfId) {
		this.lkPuoMenuRlwfId = lkPuoMenuRlwfId;
	}

	/**
	 * Gets the lk puo menu role id.
	 *
	 * @return the lkPuoMenuRoleId
	 */
	public Long getLkPuoMenuRoleId() {
		return lkPuoMenuRoleId;
	}

	/**
	 * Sets the lk puo menu role id.
	 *
	 * @param lkPuoMenuRoleId the lkPuoMenuRoleId to set
	 */
	public void setLkPuoMenuRoleId(Long lkPuoMenuRoleId) {
		this.lkPuoMenuRoleId = lkPuoMenuRoleId;
	}

	/**
	 * Gets the workflow role id.
	 *
	 * @return the workflowRoleId
	 */
	public Long getWorkflowRoleId() {
		return workflowRoleId;
	}

	/**
	 * Sets the workflow role id.
	 *
	 * @param workflowRoleId the workflowRoleId to set
	 */
	public void setWorkflowRoleId(Long workflowRoleId) {
		this.workflowRoleId = workflowRoleId;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(lkPuoMenuRlwfId, lkPuoMenuRoleId, workflowRoleId);
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
		if (!(obj instanceof EDPLkPuoMenuRLWFDto)) {
			return false;
		}
		EDPLkPuoMenuRLWFDto other = (EDPLkPuoMenuRLWFDto) obj;
		return Objects.equals(lkPuoMenuRlwfId, other.lkPuoMenuRlwfId)
				&& Objects.equals(lkPuoMenuRoleId, other.lkPuoMenuRoleId)
				&& Objects.equals(workflowRoleId, other.workflowRoleId);
	}

	
}
