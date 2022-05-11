package gov.ifms.workflow.dto;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class TrnSubmitAssignedToUsersImpl extends TrnSubmitAssignedToDto{

    private transient List<TrnIdRemAssToUserDto> trnDto;

    public List<TrnIdRemAssToUserDto> getTrnDto() {
        return trnDto;
    }

    public void setTrnDto(List<TrnIdRemAssToUserDto> trnDto) {
        this.trnDto = trnDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrnSubmitAssignedToUsersImpl that = (TrnSubmitAssignedToUsersImpl) o;
        return Objects.equals(trnDto, that.trnDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trnDto);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TrnSubmitAssignedToUsersImpl.class.getSimpleName() + "[", "]")
                .add("trnDto=" + trnDto)
                .toString();
    }
}
