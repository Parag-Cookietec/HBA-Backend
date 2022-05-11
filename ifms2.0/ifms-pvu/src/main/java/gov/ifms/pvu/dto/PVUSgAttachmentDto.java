package gov.ifms.pvu.dto;

import java.util.Objects;

import gov.ifms.pvu.common.BasePVUAttachmentDto;

/**
 * The Class PVUSgAttachmentDto.
 *
 * @version v 1.0
 * @created 2019/12/19 18:51:39
 *
 */
public class PVUSgAttachmentDto extends BasePVUAttachmentDto {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	private Long workflowId;

	private Long wfRoleId;

	/** The sg emp id. */
	private Long sgEmpId;



	public PVUSgAttachmentDto() {
		super();
	}

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
	 * @return the sgEmpId
	 */
	public Long getSgEmpId() {
		return sgEmpId;
	}

	/**
	 * @param sgEmpId the sgEmpId to set
	 */
	public void setSgEmpId(Long sgEmpId) {
		this.sgEmpId = sgEmpId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sgEmpId, wfRoleId, workflowId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVUSgAttachmentDto)) {
			return false;
		}
		PVUSgAttachmentDto other = (PVUSgAttachmentDto) obj;
		return Objects.equals(sgEmpId, other.sgEmpId) && Objects.equals(wfRoleId, other.wfRoleId)
				&& Objects.equals(workflowId, other.workflowId);
	}

	@Override
	public String toString() {
		return "PVUSgAttachmentDto [workflowId=" + workflowId + ", wfRoleId=" + wfRoleId + ", sgEmpId=" + sgEmpId + "]";
	}

}
