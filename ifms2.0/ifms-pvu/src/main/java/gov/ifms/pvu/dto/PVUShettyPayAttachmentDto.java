package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.pvu.common.BasePVUAttachmentDto;

/**
 * The Class PVUShettyPayAttachmentDto.
 *
 * @version v 1.0
 * @created 2020/01/15 15:00:11
 *
 */
public class PVUShettyPayAttachmentDto extends BasePVUAttachmentDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long workflowId;

	private Long wfRoleId;

	private Long spId;

	/**
	 * @return the workflowId
	 */
	public Long getWorkflowId() {
		return workflowId;
	}

	/**
	 * @param workflowId the workflowId to set
	 */
	public void setWorkflowId(Long workflowId) {
		this.workflowId = workflowId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(spId, wfRoleId, workflowId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUShettyPayAttachmentDto)) {
			return false;
		}
		PVUShettyPayAttachmentDto other = (PVUShettyPayAttachmentDto) obj;
		return Objects.equals(spId, other.spId) && Objects.equals(wfRoleId, other.wfRoleId)
				&& Objects.equals(workflowId, other.workflowId);
	}

	/**
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * @return the spId
	 */
	public Long getSpId() {
		return spId;
	}

	/**
	 * @param spId the spId to set
	 */
	public void setSpId(Long spId) {
		this.spId = spId;
	}

}
