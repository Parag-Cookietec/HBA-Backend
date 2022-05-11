package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class TrnIdRemAssToUserDto implements Serializable {

    private long trnId;
    private String remarks;
    private WfUserDetails assignTo;

    public long getTrnId() {
        return trnId;
    }

    public void setTrnId(long trnId) {
        this.trnId = trnId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public WfUserDetails getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(WfUserDetails assignTo) {
        this.assignTo = assignTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrnIdRemAssToUserDto that = (TrnIdRemAssToUserDto) o;
        return trnId == that.trnId &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(assignTo, that.assignTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trnId, remarks, assignTo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TrnIdRemAssToUserDto.class.getSimpleName() + "[", "]")
                .add("trnId=" + trnId)
                .add("remarks='" + remarks + "'")
                .add("assignTo=" + assignTo)
                .toString();
    }
}
