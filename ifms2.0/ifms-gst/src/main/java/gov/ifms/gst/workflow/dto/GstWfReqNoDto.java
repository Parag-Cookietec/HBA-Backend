/*
 * 
 */
package gov.ifms.gst.workflow.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class GstWfReqNoDto.
 */
public class GstWfReqNoDto {

    /** The wf request no. */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String wfRequestNo;

    /** The response list. */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<GstWfActionConfigAsyncSubmitTrnResDto> responseList;

    /**
     * Gets the response list.
     *
     * @return the response list
     */
    public List<GstWfActionConfigAsyncSubmitTrnResDto> getResponseList() {
        return responseList;
    }

    /**
     * Sets the response list.
     *
     * @param responseList the new response list
     */
    public void setResponseList(List<GstWfActionConfigAsyncSubmitTrnResDto> responseList) {
        this.responseList = responseList;
    }

    /**
     * Gets the wf request no.
     *
     * @return the wf request no
     */
    public String getWfRequestNo() {
        return wfRequestNo;
    }

    /**
     * Sets the wf request no.
     *
     * @param wfRequestNo the new wf request no
     */
    public void setWfRequestNo(String wfRequestNo) {
        this.wfRequestNo = wfRequestNo;
    }

    /**
     * Equals.
     *
     * @param o the o
     * @return true, if successful
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GstWfReqNoDto that = (GstWfReqNoDto) o;
        return Objects.equals(wfRequestNo, that.wfRequestNo) && Objects.equals(responseList, that.responseList);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(wfRequestNo, responseList);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GstWfReqNoDto{");
        sb.append("wfRequestNo='").append(wfRequestNo).append('\'');
        sb.append(", responseList=").append(responseList);
        sb.append('}');
        return sb.toString();
    }
}
