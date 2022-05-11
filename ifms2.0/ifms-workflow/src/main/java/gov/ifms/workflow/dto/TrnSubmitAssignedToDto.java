package gov.ifms.workflow.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import gov.ifms.workflow.util.AssignType;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "assignType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TrnSubmitAssignedToUserImpl.class, name = "SINGLE_USER"),
        @JsonSubTypes.Type(value = TrnSubmitAssignedToUsersImpl.class, name = "MULTIPLE_USER"),
})
public class TrnSubmitAssignedToDto implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    private String wfRequestNo;

    private long actionConfigId;

    private WfUserDetails assignBy;

    private AssignType assignType;

    public String getWfRequestNo() {
        return wfRequestNo;
    }

    public void setWfRequestNo(String wfRequestNo) {
        this.wfRequestNo = wfRequestNo;
    }

    public long getActionConfigId() {
        return actionConfigId;
    }

    public void setActionConfigId(long actionConfigId) {
        this.actionConfigId = actionConfigId;
    }

    public WfUserDetails getAssignBy() {
        return assignBy;
    }

    public void setAssignBy(WfUserDetails assignBy) {
        this.assignBy = assignBy;
    }

    public AssignType getAssignType() {
        return assignType;
    }

    public void setAssignType(AssignType assignType) {
        this.assignType = assignType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrnSubmitAssignedToDto that = (TrnSubmitAssignedToDto) o;
        return actionConfigId == that.actionConfigId &&
                Objects.equals(wfRequestNo, that.wfRequestNo) &&
                Objects.equals(assignBy, that.assignBy) &&
                assignType == that.assignType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wfRequestNo, actionConfigId, assignBy, assignType);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TrnSubmitAssignedToDto.class.getSimpleName() + "[", "]")
                .add("wfRequestNo='" + wfRequestNo + "'")
                .add("actionConfigId=" + actionConfigId)
                .add("assignBy=" + assignBy)
                .add("assignType=" + assignType)
                .toString();
    }
}
