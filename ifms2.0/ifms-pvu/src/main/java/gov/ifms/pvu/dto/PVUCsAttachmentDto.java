package gov.ifms.pvu.dto;

import java.util.Objects;

import gov.ifms.pvu.common.BasePVUAttachmentDto;

public class PVUCsAttachmentDto extends BasePVUAttachmentDto {
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */

	private Long workflowId;

	private Long wfRoleId;

	private Long changeOfScaleId;

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

	public Long getChangeOfScaleId() {
		return changeOfScaleId;
	}

	public void setChangeOfScaleId(Long changeOfScaleId) {
		this.changeOfScaleId = changeOfScaleId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		if (!(obj instanceof PVUCsAttachmentDto)) {
			return false;
		}
		PVUCsAttachmentDto that = (PVUCsAttachmentDto) obj;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getWorkflowId(), that.getWorkflowId())
				&& Objects.equals(getChangeOfScaleId(), that.getChangeOfScaleId())
				&& Objects.equals(getWfRoleId(), that.getWfRoleId());
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getId(), getWorkflowId(), getWfRoleId(), getChangeOfScaleId());
	}

}
