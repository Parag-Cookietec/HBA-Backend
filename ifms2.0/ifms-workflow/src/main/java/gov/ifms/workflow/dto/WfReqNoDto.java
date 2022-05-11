package gov.ifms.workflow.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class WfReqNoDto {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String wfRequestNo;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<WfActionConfigAsyncSubmitTrnResDto> responseList;

    public List<WfActionConfigAsyncSubmitTrnResDto> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<WfActionConfigAsyncSubmitTrnResDto> responseList) {
        this.responseList = responseList;
    }

    public String getWfRequestNo() {
        return wfRequestNo;
    }

    public void setWfRequestNo(String wfRequestNo) {
        this.wfRequestNo = wfRequestNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WfReqNoDto that = (WfReqNoDto) o;
        return Objects.equals(wfRequestNo, that.wfRequestNo) &&
                Objects.equals(responseList, that.responseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wfRequestNo, responseList);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WfReqNoDto.class.getSimpleName() + "[", "]")
                .add("wfRequestNo='" + wfRequestNo + "'")
                .add("responseList=" + responseList)
                .toString();
    }
}
