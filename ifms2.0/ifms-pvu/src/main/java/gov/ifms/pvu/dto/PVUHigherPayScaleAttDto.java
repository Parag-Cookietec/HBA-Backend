package gov.ifms.pvu.dto;

import gov.ifms.pvu.common.BasePVUAttachmentDto;

import java.util.Objects;

public class PVUHigherPayScaleAttDto extends BasePVUAttachmentDto {

    private  Long id;

    private  Long entityId;
    private Long workflowId;
    private Long wfRoleId;

    public PVUHigherPayScaleAttDto(Long id) {
        this.id = id;
    }

    public PVUHigherPayScaleAttDto() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PVUHigherPayScaleAttDto that = (PVUHigherPayScaleAttDto) o;
        return id.equals(that.id) &&
                entityId.equals(that.entityId) &&
                workflowId.equals(that.workflowId) &&
                wfRoleId.equals(that.wfRoleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entityId, workflowId, wfRoleId);
    }

    @Override
    public String toString() {
        return "PVUHigherPayScaleAttDto{" +
                "id=" + id +
                ", entityId=" + entityId +
                ", workflowId=" + workflowId +
                ", wfRoleId=" + wfRoleId +
                '}';
    }
}
