package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;
import gov.ifms.pvu.common.BasePVUAttachmentDto;

/**
 * The Class PVUCareerAdvanceAttachmentsDto.
 * 
 * @version v 1.0
 * @created 2020/01/17 11:30:23
 *
 */
public class PVUCareerAdvanceAttachmentsDto extends BasePVUAttachmentDto implements Serializable {

	/**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private Long workflowId;

    private Long wfRoleId;

    private Long entityId;

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public PVUCareerAdvanceAttachmentsDto() {
        super();
    }

    public PVUCareerAdvanceAttachmentsDto(Long id) {
        super(id);
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

    /**
     * Equals .
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PVUCareerAdvanceAttachmentsDto that = (PVUCareerAdvanceAttachmentsDto) obj;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getWorkflowId(), that.getWorkflowId()) &&
                Objects.equals(getEntityId(), that.getEntityId()) &&
                Objects.equals(getWfRoleId(), that.getWfRoleId());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWorkflowId(), getWfRoleId(), getEntityId());
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "PVUCareerAdvanceAttachmentsDto{" + "id=" + super.getId() +
                ", workflowId=" + workflowId +
                ", wfRoleId=" + wfRoleId +
                ", entityId=" + entityId +
                '}';
    }

}
