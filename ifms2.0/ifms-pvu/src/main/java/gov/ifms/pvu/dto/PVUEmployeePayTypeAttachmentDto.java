package gov.ifms.pvu.dto;

import java.util.Objects;

import gov.ifms.pvu.common.BasePVUAttachmentDto;

/**
 * The Class PVUReversionAttachmentDto.
 * 
 * @version v 2.0
 * @created 2021/04/23 15:56:29
 *
 */
public class PVUEmployeePayTypeAttachmentDto extends BasePVUAttachmentDto {

	 /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */

    private Long workflowId;

    private Long wfRoleId;

    private Long reversionId;

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
	 * @return the reversionId
	 */
	public Long getReversionId() {
		return reversionId;
	}

	/**
	 * @param reversionId the reversionId to set
	 */
	public void setReversionId(Long reversionId) {
		this.reversionId = reversionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(reversionId, wfRoleId, workflowId);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof PVUEmployeePayTypeAttachmentDto)) {
			return false;
		}
		PVUEmployeePayTypeAttachmentDto other = (PVUEmployeePayTypeAttachmentDto) obj;
		return Objects.equals(reversionId, other.reversionId) && Objects.equals(wfRoleId, other.wfRoleId)
				&& Objects.equals(workflowId, other.workflowId);
	}

    
}
