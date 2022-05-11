package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class WfActionConfigs implements Serializable {
    private List<WfActionConfigDto> wfActionConfigList;

    private List<WfActionConfigAsyncSubmitTrnResDto> responseList;

    public WfActionConfigs() {
    }

    public WfActionConfigs(List<WfActionConfigDto> wfActionConfigList) {
        this.wfActionConfigList = wfActionConfigList;
    }

    public List<WfActionConfigAsyncSubmitTrnResDto> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<WfActionConfigAsyncSubmitTrnResDto> responseList) {
        this.responseList = responseList;
    }

    public List<WfActionConfigDto> getWfActionConfigList() {
        return wfActionConfigList;
    }

    public void setWfActionConfigList(List<WfActionConfigDto> wfActionConfigList) {
        this.wfActionConfigList = wfActionConfigList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WfActionConfigs that = (WfActionConfigs) o;
        return Objects.equals(wfActionConfigList, that.wfActionConfigList) &&
                Objects.equals(responseList, that.responseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wfActionConfigList, responseList);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", WfActionConfigs.class.getSimpleName() + "[", "]")
                .add("wfActionConfigList=" + wfActionConfigList)
                .add("responseList=" + responseList)
                .toString();
    }
}
