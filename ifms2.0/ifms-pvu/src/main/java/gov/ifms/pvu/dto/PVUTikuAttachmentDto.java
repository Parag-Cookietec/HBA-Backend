package gov.ifms.pvu.dto;

import java.util.Objects;

import gov.ifms.pvu.common.BasePVUAttachmentDto;

public class PVUTikuAttachmentDto extends BasePVUAttachmentDto {

	private static final long serialVersionUID = 1L;


	private Long workflowId;
	private Long wfRoleId;
	private Long tikupayEntityId;


	public Long getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Long workflowId) {
		this.workflowId = workflowId;
	}

	public Long getWfRoleId() {
		return wfRoleId;
	}

	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	public Long getTikupayEntityId() {
		return tikupayEntityId;
	}

	public void setTikupayEntityId(Long tikupayEntityId) {
		this.tikupayEntityId = tikupayEntityId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		if (!(obj instanceof PVUTikuAttachmentDto)) {
			return false;
		}
		PVUTikuAttachmentDto that = (PVUTikuAttachmentDto) obj;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getWorkflowId(), that.getWorkflowId())
				&& Objects.equals(getTikupayEntityId(), that.getTikupayEntityId())
				&& Objects.equals(getWfRoleId(), that.getWfRoleId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getWorkflowId(), getWfRoleId(), getTikupayEntityId());
	}

}
