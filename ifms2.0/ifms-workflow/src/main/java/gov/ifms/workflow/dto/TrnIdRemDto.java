package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class TrnIdRemDto implements Serializable {

    long trnId;
    String remarks;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrnIdRemDto that = (TrnIdRemDto) o;
        return trnId == that.trnId &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trnId, remarks);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TrnIdRemDto.class.getSimpleName() + "[", "]")
                .add("trnId=" + trnId)
                .add("remarks='" + remarks + "'")
                .toString();
    }
}
