package gov.ifms.pvu.dto;

import java.util.Objects;

import gov.ifms.pvu.common.BasePVUAttachmentDto;

/**
 * The Class PVUDeemedDateAttDto.
 * 
 * @version v 1.0
 * @created 2020/03/21 11:30:34
 *
 */
public class PVUDeemedDateAttDto extends BasePVUAttachmentDto {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long entityId;
	private Long workflowId;
	private Long wfRoleId;

	/**
	 * PVUDeemedDateAttDto Constructor
	 */
	public PVUDeemedDateAttDto() {
		super();
	}

	public PVUDeemedDateAttDto(Long id) {
		super();
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

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

	@Override
	public String toString() {
		return "PVUDeemedDateAttDto{" + "id=" + id + ", entityId=" + entityId + ", workflowId=" + workflowId
				+ ", wfRoleId=" + wfRoleId + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PVUDeemedDateAttDto that = (PVUDeemedDateAttDto) o;
		return id.equals(that.id) && entityId.equals(that.entityId) && workflowId.equals(that.workflowId)
				&& wfRoleId.equals(that.wfRoleId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, entityId, workflowId, wfRoleId);
	}
}
