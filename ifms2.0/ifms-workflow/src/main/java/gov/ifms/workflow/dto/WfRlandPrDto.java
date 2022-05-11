package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class WfRlandPrDto implements Serializable {

    private Long wfRoleId;

    private int priority;

    public WfRlandPrDto(Long wfRoleId, int priority) {
        this.wfRoleId = wfRoleId;
        this.priority = priority;
    }

    public Long getWfRoleId() {
        return wfRoleId;
    }

    public void setWfRoleId(Long wfRoleId) {
        this.wfRoleId = wfRoleId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WfRlandPrDto that = (WfRlandPrDto) o;
        return priority == that.priority &&
                Objects.equals(wfRoleId, that.wfRoleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wfRoleId, priority);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WfRlandPrDto.class.getSimpleName() + "[", "]")
                .add("wfRoleId=" + wfRoleId)
                .add("priority=" + priority)
                .toString();
    }
}
