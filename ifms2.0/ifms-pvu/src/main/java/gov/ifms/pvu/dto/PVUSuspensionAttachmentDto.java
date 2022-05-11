package gov.ifms.pvu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import gov.ifms.pvu.common.BasePVUAttachmentDto;

import java.util.Objects;

/**
 * The Class PVUSuspensionAttachmentDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PVUSuspensionAttachmentDto extends BasePVUAttachmentDto {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */

    private Long workflowId;

    private Long wfRoleId;

    private Long suspensionId;

    public Long getSuspensionId() {
        return suspensionId;
    }

    public void setSuspensionId(Long suspensionId) {
        this.suspensionId = suspensionId;
    }

    /**
     * Instantiates a new PVU career advancement entity.
     */
    public PVUSuspensionAttachmentDto() {
        super();
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
        PVUSuspensionAttachmentDto that = (PVUSuspensionAttachmentDto) obj;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getWorkflowId(), that.getWorkflowId()) &&
                Objects.equals(getSuspensionId(), that.getSuspensionId()) &&
                Objects.equals(getWfRoleId(), that.getWfRoleId());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWorkflowId(), getWfRoleId(),getSuspensionId());
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "PVUSuspensionAttachmentEntity{" + "id=" + super.getId() +
                ", workflowId=" + workflowId +
                ", wfRoleId=" + wfRoleId +
                ", suspensionId=" + suspensionId +
                '}';
    }
}
