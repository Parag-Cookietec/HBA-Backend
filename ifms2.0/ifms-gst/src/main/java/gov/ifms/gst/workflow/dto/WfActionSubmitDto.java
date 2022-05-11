package gov.ifms.gst.workflow.dto;

import java.io.Serializable;
import java.util.List;

public class WfActionSubmitDto implements Serializable {

    /** The wfRequestNo. */
    private String wfRequestNo;
    /** The actionConfigId. */
    private Long actionConfigId;
    /** The assignedBy. */
    private WfUserDetails assignedBy;
    /** The assignedTo. */
    private WfUserDetails assignedTo;
    /** The assignType. */
    private String assignType;
    /** The trnDto. */
    private List<TrnDto> trnDto = null;

    public String getWfRequestNo() {
        return wfRequestNo;
    }

    public void setWfRequestNo(String wfRequestNo) {
        this.wfRequestNo = wfRequestNo;
    }

    public Long getActionConfigId() {
        return actionConfigId;
    }

    public void setActionConfigId(Long actionConfigId) {
        this.actionConfigId = actionConfigId;
    }

    public WfUserDetails getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(WfUserDetails assignedBy) {
        this.assignedBy = assignedBy;
    }

    public WfUserDetails getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(WfUserDetails assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getAssignType() {
        return assignType;
    }

    public void setAssignType(String assignType) {
        this.assignType = assignType;
    }

    public List<TrnDto> getTrnDto() {
        return trnDto;
    }

    public void setTrnDto(List<TrnDto> trnDto) {
        this.trnDto = trnDto;
    }
}
