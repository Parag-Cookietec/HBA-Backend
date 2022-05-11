package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class TrnSubmitAssignedToUserImpl extends TrnSubmitAssignedToDto implements Serializable {

    private transient List<TrnIdRemDto> trnDto;
    private WfUserDetails assignTo;

    public TrnSubmitAssignedToUserImpl() {
        super();
    }

    public List<TrnIdRemDto> getTrnDto() {
        return trnDto;
    }

    public void setTrnDto(List<TrnIdRemDto> trnDto) {
        this.trnDto = trnDto;
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
        TrnSubmitAssignedToUserImpl that = (TrnSubmitAssignedToUserImpl) o;
        return Objects.equals(trnDto, that.trnDto) &&
                Objects.equals(assignTo, that.assignTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trnDto, assignTo);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TrnSubmitAssignedToUserImpl.class.getSimpleName() + "[", "]")
                .add("trnDto=" + trnDto)
                .add("assignTo=" + assignTo)
                .toString();
    }
}
